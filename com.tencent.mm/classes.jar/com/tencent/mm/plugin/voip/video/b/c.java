package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class c
{
  public int eXo;
  public int eXp;
  int eYw;
  int eYx;
  int fbH;
  int fbI;
  private int mProgram;
  private FloatBuffer mVertexBuffer;
  public a tIA;
  boolean tIB;
  public float[] tIC;
  public float[] tID;
  float[] tIE;
  float[] tIF;
  IntBuffer tIx;
  private int[] tIy;
  private FloatBuffer tIz;
  
  public c()
  {
    AppMethodBeat.i(140226);
    this.mProgram = 0;
    this.tIx = IntBuffer.wrap(new int[3]);
    this.tIy = new int[3];
    this.eYw = -1;
    this.eYx = -1;
    this.tIB = false;
    this.fbH = 0;
    this.fbI = 0;
    this.eXo = 0;
    this.eXp = 0;
    this.tIC = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.tID = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.tIE = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    this.tIF = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    cPT();
    this.mProgram = e.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
    GLES20.glGenTextures(3, this.tIx);
    ab.i("MicroMsg.VoipGLSProgram", "gen texture is 1 is %s", new Object[] { Integer.valueOf(this.tIx.get(0)) });
    this.tIA = new a();
    a locala = this.tIA;
    locala.cPT();
    locala.tIb = e.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "varying highp vec2 tc;\nuniform sampler2D inputImageTexture;\nuniform mediump float smoothDegree;\nuniform mediump int showCounter;\nuniform mediump int showMode;\n\nuniform mediump float brightness;\nuniform mediump float texelWidth;\nuniform mediump float texelHeight;\n\nprecision highp float;\nconst mat3 RGBtoYUV = mat3(0.299,  0.587, 0.114, 0.5, -0.4187, -0.0813, -0.169, -0.3313,  0.5 );    //full range\nconst mat3 YUVtoRGB = mat3(1.1643, 1.5958, 0.0, 1.1643, -0.8129, -0.3917, 1.1643, 0.0, 2.017 );\n\nconst highp mat3 saturateMatrix = mat3(\n1.1102, -0.0598, -0.061,\n-0.0774, 1.0826, -0.1186,\n-0.0228, -0.0228, 1.1772);\n\n\nvec3 rgb2hsv(vec3 c)\n{\n    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n    vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n    vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n\n    float d = q.x - min(q.w, q.y);\n    float e = 1.0e-10;\n    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n}\n\nvec3 hsv2rgb(vec3 c)\n{\n    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);\n    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);\n    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);\n}\n\nvec3 yuv2rgb(vec3 c)\n{\n    vec3 rgb = YUVtoRGB*c;\n    return rgb;\n}\nvec3 rgb2yuv(vec3 c)\n{\n    vec3 yuv = c*RGBtoYUV;\n    return yuv;\n}\nmediump float hardLight(mediump float color){\n    if (color <= 0.5)\n    color = color * color * 2.0;\n    else\n    color = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n    return color;\n}\n\nfloat lum(vec3 v)\n{\n    return dot(v, vec3(0.299, 0.587, 0.114));\n}\n\nvec4 getValue(vec4 newValue, vec4 originValue)\n{\n    return mix(newValue, originValue, step(lum(newValue.rgb), lum(originValue.rgb)));\n}\n\nvec4 Sobel2()\n{\n    vec2 samplerSteps = vec2(1.0/texelWidth, 1.0/texelHeight);\n    vec2 coords[8];\n    coords[0] = tc - samplerSteps * 2.0;\n    coords[1] = tc + vec2(0.0, -samplerSteps.y) * 2.0;\n    coords[2] = tc + vec2(samplerSteps.x, -samplerSteps.y) * 2.0;\n\n    coords[3] = tc - vec2(samplerSteps.x, 0.0) * 2.0;\n    coords[4] = tc + vec2(samplerSteps.x, 0.0) * 2.0;\n\n    coords[5] = tc + vec2(-samplerSteps.x, samplerSteps.y) * 2.0;\n    coords[6] = tc + vec2(0.0, samplerSteps.y) * 2.0;\n    coords[7] = tc + vec2(samplerSteps.x, samplerSteps.y) * 2.0;\n\n    vec3 colors[8];\n    for(int i = 0; i < 8; ++i)\n    {\n        colors[i] = texture2D(inputImageTexture, coords[i]).rgb;\n    }\n\n    vec4 src = texture2D(inputImageTexture, tc);\n    vec3 h = -colors[0] - 2.0 * colors[1] - colors[2] + colors[5] + 2.0 * colors[6] + colors[7];\n    vec3 v = -colors[0] + colors[2] - 2.0 * colors[3] + 2.0 * colors[4] - colors[5] + colors[7];\n    return vec4(mix(src.rgb, sqrt(h * h + v * v), 1.0), src.a);\n}\n\nvec4 maxFilter()\n{\n    vec2 samplerSteps = vec2(1.0/texelWidth, 1.0/texelHeight);\n    vec2 texCoord[13];\n    vec4 vMin;\n    vec2 thisCoord = tc;\n\n    texCoord[0] = thisCoord + vec2(0, -samplerSteps.y * 2.0);\n    texCoord[1] = thisCoord - samplerSteps;\n    texCoord[2] = thisCoord + vec2(0, -samplerSteps.y);\n    texCoord[3] = thisCoord + vec2(samplerSteps.x, -samplerSteps.y);\n    texCoord[4] = thisCoord + vec2(-samplerSteps.x * 2.0, 0.0);\n    texCoord[5] = thisCoord + vec2(-samplerSteps.x, 0.0);\n    texCoord[6] = thisCoord;\n    texCoord[7] = thisCoord + vec2(samplerSteps.x, 0.0);\n    texCoord[8] = thisCoord + vec2(samplerSteps.x * 2.0, 0.0);\n    texCoord[9] = thisCoord + vec2(-samplerSteps.x, samplerSteps.y);\n    texCoord[10] = thisCoord + vec2(0.0, samplerSteps.y);\n    texCoord[11] = thisCoord + samplerSteps;\n    texCoord[12] = thisCoord + vec2(0.0, 2.0* samplerSteps.y);\n\n\n\n    {\n        vec4 vTemp;\n\n        vMin = texture2D(inputImageTexture, texCoord[0]);\n\n        vTemp = texture2D(inputImageTexture, texCoord[1]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[2]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[3]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[4]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[5]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[6]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[7]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[8]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[9]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[10]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[11]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[12]);\n        vMin = getValue(vTemp, vMin);\n    }\n    return vMin;\n}\n\nvoid main()\n{\n    //highp vec4 smoothNew;\n    highp vec3 yuv;\n    highp vec3 rgb;\n\n    vec3 centralColor = texture2D(inputImageTexture,  tc ).rgb;\n    //vec3 maxFilt = texture2D(inputImageTexture3, tc).rgb;  //canny\n    //vec3 lunkuo  = texture2D(inputImageTexture3, tc).rgb;\n\n    vec2 blurCoordinates[20];\n    vec2 imageStep = vec2(1.5/texelWidth, 1.5/texelHeight);\n\n    //重新调整了滤波的范围和权重，减少水波纹\n    blurCoordinates[0] = tc + vec2(0.0, -4.0) * imageStep;\n    blurCoordinates[1] = tc + vec2(2.0, -3.0) * imageStep;\n    blurCoordinates[2] = tc + vec2(3.0, -2.0) * imageStep;\n    blurCoordinates[3] = tc + vec2(4.0, 0.0) * imageStep;\n    blurCoordinates[4] = tc + vec2(3.0, 2.0) * imageStep;\n    blurCoordinates[5] = tc + vec2(2.0, 3.0) * imageStep;\n    blurCoordinates[6] = tc + vec2(0.0, 4.0) * imageStep;\n    blurCoordinates[7] = tc + vec2(-2.0, 3.0) * imageStep;\n    blurCoordinates[8] = tc + vec2(-3.0, 2.0) * imageStep;\n    blurCoordinates[9] = tc + vec2(-4.0, 0.0) * imageStep;\n    blurCoordinates[10] = tc + vec2(-3.0, -2.0) * imageStep;\n    blurCoordinates[11] = tc + vec2(-2.0, -3.0) * imageStep;\n\n    blurCoordinates[12] = tc + vec2(0.0, -2.0) * imageStep;\n    blurCoordinates[13] = tc + vec2(-1.0, -1.0) * imageStep;\n    blurCoordinates[14] = tc + vec2(-2.0, 0.0) * imageStep;\n    blurCoordinates[15] = tc + vec2(-1.0, 1.0) * imageStep;\n    blurCoordinates[16] = tc + vec2(0.0, 2.0) * imageStep;\n    blurCoordinates[17] = tc + vec2(1.0, 1.0) * imageStep;\n    blurCoordinates[18] = tc + vec2(2.0, 0.0) * imageStep;\n    blurCoordinates[19] = tc + vec2(1.0, -1.0) * imageStep;\n\n    //vec3 centralColor = texture2D(inputImageTexture, tc).rgb;\n    //float sampleColor = centralColor.g * 24.0;\n    vec3 sampleColor = centralColor * 24.0;\n\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[0]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[1]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[2]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[3]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[4]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[5]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[6]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[7]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[8]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[9]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[10]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[11]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[12]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[13]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[14]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[15]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[16]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[17]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[18]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[19]).rgb;\n\n    sampleColor = sampleColor/44.0;\n\n    float dis = centralColor.g - sampleColor.g + 0.5;   //high\n\n    for (int i = 0; i < 5; i++) {\n        dis = hardLight(dis);\n    }\n\n    // 0.065 -> 1.125, 加大滤波强度\n    vec3 result = centralColor * 1.125 - dis * 0.125; //central+(central-dis)*0.065\n\n    float hue = dot(result, vec3(0.299,0.587,0.114)) - 0.3;   //luminance\n    hue = pow(clamp(hue, 0.0, 1.0), 0.3);\n\n    yuv= rgb2yuv(sampleColor);\n    float cr=yuv.y-0.094;\n    float cb=yuv.z+0.0745;\n\n    float tx = ((25.59*cr-19.19*cb)*255.0 + 51.0)*0.04;\n    float ty = ((25.59*cr+19.19*cb)*255.0 + 77.0)*0.07;\n    float val0 = tx*tx + ty*ty;\n\n    float chroma_sum=yuv.y+yuv.z+1.0;\n    float chroma_diff=yuv.y-yuv.z;\n    float chroma_diff_th = 0.1-(yuv.x/10.0);\n\n    float face = 1.0;\n    if(yuv.z>-0.1667 && yuv.z<0.0294 && chroma_sum>0.7804 && chroma_sum<1.098 && chroma_diff>chroma_diff_th){\n        if(yuv.x<0.3922) {\n            if(val0<1700.0) {\n                face = 0.0;\n            } else {\n                hue = 0.0;\n            }\n        } else {\n            if(val0<3150.0) {\n                face = 0.0;\n            } else {\n                hue = 0.0;\n            }\n        }\n    } else {\n        hue = 0.0;\n    }\n\n    result = centralColor * (1.0 - hue) + result * hue;\n    result = result+vec3(brightness*0.1);\n\n    // 这里可以进一步简化计算\n    if(showMode == 1 /*|| showMode == 2*/)\n    {\n         result = vec3(hue);\n    }\n    else if(showMode == 0)\n    {\n        result = centralColor;\n    }\n\n    vec3 smoothNew = mix(centralColor, result, smoothDegree);\n\n\n//showCounter用于显示mask\nif(showCounter == 1)\n{\n    smoothNew =vec3(face);\n}\n\n//mode3:显示边缘\nif(showMode == 3)\n{\n    vec3 maxValue = maxFilter().rgb;\n    float lumOrigin = lum(centralColor);\n    float lumMax = lum(maxValue) + 0.001;\n    float blendColor = min(lumOrigin / lumMax, 1.0);\n\n    float smoothDegree2 =  0.8 + (smoothDegree/5.0); //约束范围：0.8~1.0\n    smoothNew =mix(centralColor, vec3(blendColor), smoothDegree2);\n}\n\n//mode4:显示轮廓\nif(showMode == 4)\n{\n    vec4 src  = Sobel2();\n    // saturation合并到level中\n    max(src.r, src.g);\n    float lum = (max(max(src.r, src.g),src.b) + min(min(src.r, src.g), src.b)) / 2.0;\n    src = vec4(mix(vec3(lum), src.rgb, 0.0), src.a);  //intensity = 0.0\n\n    // level filter: colorLevel.x = dark = 0.33, colorLevel.y = light = 0.60\n    float colorLevelx = 0.3;\n    float colorLevely = 0.60;\n    //float gamma = 0.99;\n    float gamma = smoothDegree;\n    src.rgb = clamp((src.rgb - colorLevelx) / (colorLevely - colorLevelx), 0.0, 1.0);\n    src.rgb = clamp(pow(src.rgb, vec3(gamma)), 0.0, 1.0);\n    smoothNew = src.rgb;\n}\n\ngl_FragColor = vec4(smoothNew, 1.0);\n}");
    locala.tIc = e.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision mediump float;\nvarying vec2 tc;\nuniform sampler2D inputImageTexture;\nvoid main() {\n    vec4 color = texture2D(inputImageTexture, tc);\n    gl_FragColor = color;\n}");
    this.eYw = e.Vm();
    this.eYx = e.Vn();
    ab.i("MicroMsg.VoipGLSProgram", "initRenderOutputFbo, texture:%s, fbo:%s", new Object[] { Integer.valueOf(this.eYw), Integer.valueOf(this.eYx) });
    locala = this.tIA;
    int i = this.eYw;
    ab.i("MicroMsg.VoipGLSProgram", "initData, texture:%s", new Object[] { Integer.valueOf(i) });
    locala.tId = i;
    a.k(locala.tIp);
    float[] arrayOfFloat1 = locala.tIo;
    float[] arrayOfFloat2 = locala.tIp;
    locala.tIg = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    locala.tIg.put(arrayOfFloat1);
    locala.tIg.position(0);
    locala.tIr = ByteBuffer.allocateDirect(arrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    locala.tIr.put(arrayOfFloat2);
    locala.tIr.position(0);
    AppMethodBeat.o(140226);
  }
  
  static void Vo()
  {
    AppMethodBeat.i(140228);
    GLES20.glFinish();
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glUseProgram(0);
    AppMethodBeat.o(140228);
  }
  
  final void HX(int paramInt)
  {
    int j = 2;
    AppMethodBeat.i(140227);
    GLES20.glUseProgram(this.mProgram);
    int k = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    int i = k;
    if (k < 0)
    {
      ab.e("MicroMsg.VoipGLSProgram", "int mPositionHandle error: %s, reinit program", new Object[] { Integer.valueOf(k) });
      GLES20.glDeleteProgram(this.mProgram);
      this.mProgram = e.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
      i = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
    }
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.mVertexBuffer);
    i = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, this.tIz);
    if ((paramInt == 0) || (paramInt == 1))
    {
      this.tIy[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
      this.tIy[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerU");
      this.tIy[2] = GLES20.glGetUniformLocation(this.mProgram, "samplerV");
      i = 3;
    }
    for (;;)
    {
      j = 0;
      for (;;)
      {
        if (j < i)
        {
          GLES20.glActiveTexture(33984 + j);
          GLES20.glBindTexture(3553, this.tIx.get(j));
          GLES20.glUniform1i(this.tIy[j], j);
          j += 1;
          continue;
          if (paramInt != 3) {
            break label301;
          }
          this.tIy[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
          this.tIy[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerUV");
          i = j;
          break;
        }
      }
      i = GLES20.glGetUniformLocation(this.mProgram, "yuvType");
      if (i >= 0) {
        GLES20.glUniform1i(i, paramInt);
      }
      GLES20.glDrawArrays(5, 0, 4);
      AppMethodBeat.o(140227);
      return;
      label301:
      i = 0;
    }
  }
  
  final void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140229);
    GLES20.glBindTexture(3553, this.tIx.get(paramInt3));
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, paramByteBuffer);
    AppMethodBeat.o(140229);
  }
  
  public final void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(140230);
    if ((this.mVertexBuffer == null) || (this.mVertexBuffer.capacity() != paramArrayOfFloat1.length)) {
      this.mVertexBuffer = ByteBuffer.allocateDirect(paramArrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.mVertexBuffer.put(paramArrayOfFloat1);
    this.mVertexBuffer.position(0);
    if ((this.tIz == null) || (this.tIz.capacity() != paramArrayOfFloat2.length)) {
      this.tIz = ByteBuffer.allocateDirect(paramArrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    this.tIz.put(paramArrayOfFloat2);
    this.tIz.position(0);
    AppMethodBeat.o(140230);
  }
  
  public final void cPT()
  {
    int i = 1;
    try
    {
      AppMethodBeat.i(140231);
      ab.i("MicroMsg.VoipGLSProgram", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
      int[] arrayOfInt = new int[this.tIx.capacity() + 1];
      arrayOfInt[0] = this.eYw;
      while (i < this.tIx.capacity())
      {
        arrayOfInt[i] = this.tIx.get(i - 1);
        i += 1;
      }
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glDeleteFramebuffers(1, new int[] { this.eYx }, 0);
      GLES20.glDeleteProgram(this.mProgram);
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFinish();
      if (this.tIz != null) {
        this.tIz.clear();
      }
      if (this.mVertexBuffer != null) {
        this.mVertexBuffer.clear();
      }
      this.eYw = 0;
      this.eYx = 0;
      this.mVertexBuffer = null;
      this.tIz = null;
      this.mProgram = 0;
      if (this.tIA != null) {
        this.tIA.cPT();
      }
      AppMethodBeat.o(140231);
      return;
    }
    finally {}
  }
  
  public final a.a cPW()
  {
    AppMethodBeat.i(140232);
    if (this.tIA != null)
    {
      Object localObject = this.tIA;
      if ((((a)localObject).tIs != null) && (((a)localObject).eXp != 0) && (((a)localObject).eXo != 0))
      {
        localObject = new a.a((a)localObject, ((a)localObject).eXo, ((a)localObject).eXp, ((a)localObject).tIs);
        AppMethodBeat.o(140232);
        return localObject;
      }
      AppMethodBeat.o(140232);
      return null;
    }
    AppMethodBeat.o(140232);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.b.c
 * JD-Core Version:    0.7.0.1
 */