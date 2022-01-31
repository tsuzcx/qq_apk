package com.tencent.mm.plugin.story.image2video;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class b
  extends a
{
  private final float[] ssI;
  private final float[] ssJ;
  private FloatBuffer ssK;
  private FloatBuffer ssL;
  private int ssM;
  private int ssN;
  private int ssO;
  private int ssP;
  private int ssQ;
  
  public b()
  {
    AppMethodBeat.i(150921);
    this.ssI = new float[] { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
    this.ssJ = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    AppMethodBeat.o(150921);
  }
  
  public static void czS()
  {
    AppMethodBeat.i(150926);
    GLES20.glDrawArrays(5, 0, 4);
    AppMethodBeat.o(150926);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    AppMethodBeat.i(150928);
    long l = System.currentTimeMillis();
    this.ssK = ByteBuffer.allocateDirect(this.ssI.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.ssK.put(this.ssI).position(0);
    GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, this.ssK);
    GLES20.glEnableVertexAttribArray(0);
    float f7 = paramInt1 / paramInt3;
    float f8 = paramInt2 / paramInt4;
    float[] arrayOfFloat = Arrays.copyOf(this.ssJ, this.ssJ.length);
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
      this.ssL = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.ssL.put(arrayOfFloat).position(0);
      GLES20.glVertexAttribPointer(2, 2, 5126, false, 0, this.ssL);
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
      this.ssL = ByteBuffer.allocateDirect(arrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.ssL.put(arrayOfFloat).position(0);
      GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, this.ssL);
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
      GLES20.glUniform4fv(this.ssQ, 1, localFloatBuffer);
      ab.i("MicroMsg.Story.FadeImageShader", "scale cost:" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(150928);
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
  
  public final void bg(float paramFloat)
  {
    AppMethodBeat.i(150927);
    GLES20.glUniform1f(this.ssP, paramFloat);
    AppMethodBeat.o(150927);
  }
  
  public final void czR()
  {
    AppMethodBeat.i(150922);
    ab.i("MicroMsg.Story.FadeImageShader", "comipleAndLinkProgram");
    int[] arrayOfInt = new int[1];
    int i = loadShader(35633, "attribute vec4 a_position;\nattribute vec2 a_texCoords;\nattribute vec2 a_texBgCoords;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform mat4 uMVPMatrix; \nvoid main()\n{\n  gl_Position = uMVPMatrix * a_position;\n  v_texCoords = a_texCoords;\n  v_texBgCoords = a_texBgCoords;\n}");
    int j = loadShader(35632, "precision mediump float;\nuniform sampler2D u_Texture;\nuniform sampler2D u_TextureBg;\nvarying vec2 v_texCoords;\nvarying vec2 v_texBgCoords;\nuniform float u_texAlphaRatio;\nuniform vec4 centerPic; // 按top bottom left right来传\nvoid main()\n{\n    vec4 fcolor = vec4(0.0);\n    if (gl_FragCoord.y > centerPic[0] || gl_FragCoord.y < centerPic[1] || \n        gl_FragCoord.x > centerPic[3] || gl_FragCoord.x < centerPic[2]) {\n        // >top <bottom >right <left, 不是中间的图片区域，取背景色\n        fcolor = texture2D(u_TextureBg, v_texBgCoords);\n    } else {\n        fcolor = texture2D(u_Texture, v_texCoords);\n    } \n    fcolor.a *= u_texAlphaRatio;\n    gl_FragColor = fcolor;\n}");
    int k = GLES20.glCreateProgram();
    if (k == 0)
    {
      AppMethodBeat.o(150922);
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
      ab.e("MicroMsg.Story.FadeImageShader", "Error linking program:");
      ab.e("MicroMsg.Story.FadeImageShader", GLES20.glGetProgramInfoLog(k));
      GLES20.glDeleteProgram(k);
      AppMethodBeat.o(150922);
      return;
    }
    this.ssO = GLES20.glGetUniformLocation(k, "uMVPMatrix");
    this.ssP = GLES20.glGetUniformLocation(k, "u_texAlphaRatio");
    this.ssQ = GLES20.glGetUniformLocation(k, "centerPic");
    this.ssM = GLES20.glGetUniformLocation(k, "u_Texture");
    this.ssN = GLES20.glGetUniformLocation(k, "u_TextureBg");
    this.ssD = k;
    AppMethodBeat.o(150922);
  }
  
  public final void fV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150923);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glUniform1i(this.ssM, paramInt2);
    AppMethodBeat.o(150923);
  }
  
  public final void fW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150924);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glUniform1i(this.ssN, paramInt2);
    AppMethodBeat.o(150924);
  }
  
  public final void j(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(150925);
    GLES20.glUniformMatrix4fv(this.ssO, 1, false, paramArrayOfFloat, 0);
    AppMethodBeat.o(150925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.b
 * JD-Core Version:    0.7.0.1
 */