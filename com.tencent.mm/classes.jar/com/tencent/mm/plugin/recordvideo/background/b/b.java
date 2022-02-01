package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class b
  extends a
{
  private final float[] NEL;
  private final float[] NEM;
  private FloatBuffer NEN;
  private FloatBuffer NEO;
  private int NEP;
  private int NEQ;
  private int NER;
  private int NES;
  private int mPl;
  
  public b()
  {
    AppMethodBeat.i(74995);
    this.NEL = new float[] { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
    this.NEM = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    AppMethodBeat.o(74995);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(75002);
    long l = System.currentTimeMillis();
    this.NEN = ByteBuffer.allocateDirect(this.NEL.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.NEN.put(this.NEL).position(0);
    GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, this.NEN);
    GLES20.glEnableVertexAttribArray(0);
    float f7 = paramInt1 / paramInt3;
    float f8 = paramInt2 / paramInt4;
    float[] arrayOfFloat = Arrays.copyOf(this.NEM, this.NEM.length);
    float f3 = 0.0F;
    float f1 = 0.0F;
    float f2;
    float f4;
    float f5;
    float f6;
    if (f7 < f8)
    {
      f2 = paramInt3 - (int)(paramInt1 / f8);
      f2 = f2 / 2.0F / paramInt3;
      f3 = 1.0F - f2;
      f1 = f1 / 2.0F / paramInt4;
      f4 = 1.0F - f1;
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f4;
      arrayOfFloat[2] = f3;
      arrayOfFloat[3] = f4;
      arrayOfFloat[4] = f2;
      arrayOfFloat[5] = f1;
      arrayOfFloat[6] = f3;
      arrayOfFloat[7] = f1;
      this.NEO = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.NEO.put(arrayOfFloat).position(0);
      GLES20.glVertexAttribPointer(2, 2, 5126, false, 0, this.NEO);
      GLES20.glEnableVertexAttribArray(2);
      f4 = 0.0F;
      f3 = 1.0F;
      f5 = 0.0F;
      f6 = 1.0F;
      if (f7 >= f8) {
        break label575;
      }
      f2 = f8 / f7 - 1.0F;
      f1 = f2 / 2.0F + 1.0F;
      f2 = 0.0F - f2 / 2.0F;
      label300:
      arrayOfFloat[0] = f4;
      arrayOfFloat[1] = f1;
      arrayOfFloat[2] = f3;
      arrayOfFloat[3] = f1;
      arrayOfFloat[4] = f4;
      arrayOfFloat[5] = f2;
      arrayOfFloat[6] = f3;
      arrayOfFloat[7] = f2;
      this.NEO = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.NEO.put(arrayOfFloat).position(0);
      GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, this.NEO);
      GLES20.glEnableVertexAttribArray(1);
      arrayOfFloat = new float[4];
      arrayOfFloat[0] = paramInt2;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = 0.0F;
      arrayOfFloat[3] = paramInt1;
      if (f7 >= f8) {
        break label627;
      }
      f1 = paramInt4 * f7;
      arrayOfFloat[0] = ((paramInt2 + f1 * paramFloat) / 2.0F);
      arrayOfFloat[1] = ((paramInt2 - f1 * paramFloat) / 2.0F);
    }
    for (;;)
    {
      FloatBuffer localFloatBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
      localFloatBuffer.put(arrayOfFloat).position(0);
      GLES20.glUniform4fv(this.NES, 1, localFloatBuffer);
      Log.i("MicroMsg.Story.FadeImageShader", "scale cost:" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(75002);
      return;
      f2 = f3;
      if (f7 <= f8) {
        break;
      }
      f1 = paramInt4 - (int)(paramInt2 / f7);
      f2 = f3;
      break;
      label575:
      f1 = f6;
      f2 = f5;
      if (f7 <= f8) {
        break label300;
      }
      f1 = f7 / f8 - 1.0F;
      f3 = f1 / 2.0F + 1.0F;
      f4 = 0.0F - f1 / 2.0F;
      f1 = f6;
      f2 = f5;
      break label300;
      label627:
      if (f7 > f8)
      {
        f1 = paramInt3 * f8;
        arrayOfFloat[2] = ((paramInt1 - f1 * paramFloat) / 2.0F);
        arrayOfFloat[3] = ((f1 * paramFloat + paramInt1) / 2.0F);
      }
    }
  }
  
  public final void cU(float paramFloat)
  {
    AppMethodBeat.i(75001);
    GLES20.glUniform1f(this.NER, paramFloat);
    AppMethodBeat.o(75001);
  }
  
  public final void gHc()
  {
    AppMethodBeat.i(74996);
    Log.i("MicroMsg.Story.FadeImageShader", "comipleAndLinkProgram");
    int[] arrayOfInt = new int[1];
    int i = loadShader(35633, "attribute vec4 a_position;\nattribute vec2 a_texCoords;\nattribute vec2 a_texBgCoords;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform mat4 uMVPMatrix; \nvoid main()\n{\n  gl_Position = uMVPMatrix * a_position;\n  v_texCoords = a_texCoords;\n  v_texBgCoords = a_texBgCoords;\n}");
    int j = loadShader(35632, "precision mediump float;\nuniform sampler2D u_Texture;\nuniform sampler2D u_TextureBg;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform float u_texAlphaRatio;\nuniform vec4 centerPic; // 按top bottom left right来传\nvoid main()\n{\n    vec4 fcolor = vec4(0.0);\n    if (gl_FragCoord.y > centerPic[0] || gl_FragCoord.y < centerPic[1] || \n        gl_FragCoord.x > centerPic[3] || gl_FragCoord.x < centerPic[2]) {\n        // >top <bottom >right <left, 不是中间的图片区域，取背景色\n        fcolor = texture2D(u_TextureBg, v_texBgCoords);\n    } else {\n        fcolor = texture2D(u_Texture, v_texCoords);\n    } \n    fcolor.a *= u_texAlphaRatio;\n    gl_FragColor = fcolor;\n}");
    int k = GLES20.glCreateProgram();
    if (k == 0)
    {
      AppMethodBeat.o(74996);
      return;
    }
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glBindAttribLocation(k, 0, "a_position");
    GLES20.glBindAttribLocation(k, 1, "a_texCoords");
    GLES20.glBindAttribLocation(k, 2, "a_texBgCoords");
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      Log.e("MicroMsg.Story.FadeImageShader", "Error linking program:");
      Log.e("MicroMsg.Story.FadeImageShader", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      AppMethodBeat.o(74996);
      return;
    }
    this.mPl = GLES20.glGetUniformLocation(k, "uMVPMatrix");
    this.NER = GLES20.glGetUniformLocation(k, "u_texAlphaRatio");
    this.NES = GLES20.glGetUniformLocation(k, "centerPic");
    this.NEP = GLES20.glGetUniformLocation(k, "u_Texture");
    this.NEQ = GLES20.glGetUniformLocation(k, "u_TextureBg");
    this.NEG = k;
    AppMethodBeat.o(74996);
  }
  
  public final void kE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74997);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glUniform1i(this.NEP, paramInt2);
    AppMethodBeat.o(74997);
  }
  
  public final void kF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(74998);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glUniform1i(this.NEQ, paramInt2);
    AppMethodBeat.o(74998);
  }
  
  public final void v(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(74999);
    GLES20.glUniformMatrix4fv(this.mPl, 1, false, paramArrayOfFloat, 0);
    AppMethodBeat.o(74999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.b
 * JD-Core Version:    0.7.0.1
 */