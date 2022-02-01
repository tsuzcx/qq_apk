package com.tencent.mm.plugin.recordvideo.background.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public final class f
  extends a
{
  public final float[] wnR;
  private final float[] wnp;
  private final float[] wnq;
  private FloatBuffer wnr;
  private FloatBuffer wns;
  private int wnt;
  private int wnv;
  
  public f()
  {
    AppMethodBeat.i(75012);
    this.wnp = new float[] { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
    this.wnq = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.wnR = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    AppMethodBeat.o(75012);
  }
  
  public static void duJ()
  {
    AppMethodBeat.i(75016);
    GLES20.glDrawArrays(5, 0, 4);
    AppMethodBeat.o(75016);
  }
  
  public final void Mf(int paramInt)
  {
    AppMethodBeat.i(75014);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glUniform1f(this.wnt, 0.0F);
    AppMethodBeat.o(75014);
  }
  
  public final void a(a.a parama, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(75017);
    long l = System.currentTimeMillis();
    float f9 = paramInt1 / paramInt3;
    float f10 = paramInt2 / paramInt4;
    float f8 = -1.0F;
    float f7 = 1.0F;
    float f6 = 1.0F;
    float f5 = -1.0F;
    float f4 = 0.0F;
    float f3 = 1.0F;
    float[] arrayOfFloat1 = Arrays.copyOf(this.wnq, this.wnq.length);
    float[] arrayOfFloat2 = Arrays.copyOf(this.wnp, this.wnp.length);
    float f1;
    switch (1.wnS[parama.ordinal()])
    {
    default: 
      f1 = 1.0F;
      f2 = 0.0F;
      arrayOfFloat1[0] = f4;
      arrayOfFloat1[1] = f1;
      arrayOfFloat1[2] = f3;
      arrayOfFloat1[3] = f1;
      arrayOfFloat1[4] = f4;
      arrayOfFloat1[5] = f2;
      arrayOfFloat1[6] = f3;
      arrayOfFloat1[7] = f2;
      arrayOfFloat2[0] = f8;
      arrayOfFloat2[1] = f5;
      arrayOfFloat2[3] = f7;
      arrayOfFloat2[4] = f5;
      arrayOfFloat2[6] = f8;
      arrayOfFloat2[7] = f6;
      arrayOfFloat2[9] = f7;
      arrayOfFloat2[10] = f6;
      this.wnr = ByteBuffer.allocateDirect(arrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.wnr.put(arrayOfFloat2).position(0);
      GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, this.wnr);
      GLES20.glEnableVertexAttribArray(0);
      this.wns = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
      this.wns.put(arrayOfFloat1).position(0);
      GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, this.wns);
      GLES20.glEnableVertexAttribArray(1);
      new StringBuilder("scale cost:").append(System.currentTimeMillis() - l);
      AppMethodBeat.o(75017);
      return;
    case 1: 
      f3 = 0.0F;
      f1 = 0.0F;
      if (f9 < f10) {
        f2 = paramInt3 - (int)(paramInt1 / f10);
      }
      for (;;)
      {
        f4 = f2 / 2.0F / paramInt3;
        f2 = f1 / 2.0F / paramInt4;
        f1 = 1.0F - f2;
        f3 = 1.0F - f4;
        break;
        f2 = f3;
        if (f9 > f10)
        {
          f1 = paramInt4 - (int)(paramInt2 / f9);
          f2 = f3;
        }
      }
    }
    float f2 = paramInt1;
    f5 = paramInt2;
    if (f9 < f10) {
      f1 = paramInt4 * f9;
    }
    for (;;)
    {
      f7 = f2 / paramInt1;
      f8 = 0.0F - f7;
      f6 = f1 / paramInt2;
      f5 = 0.0F - f6;
      f1 = 1.0F;
      f2 = 0.0F;
      break;
      f1 = f5;
      if (f9 > f10)
      {
        f2 = paramInt3 * f10;
        f1 = f5;
      }
    }
  }
  
  public final void duI()
  {
    AppMethodBeat.i(75013);
    int[] arrayOfInt = new int[1];
    int i = loadShader(35633, "attribute vec4 a_position;    \nattribute vec2 a_texCoords; \nvarying vec2 v_texCoords; \nuniform mat4 uMVPMatrix; \nvoid main()                  \n{                            \n   gl_Position = uMVPMatrix * a_position;  \n    v_texCoords = a_texCoords; \n}                            \n");
    int j = loadShader(35632, "precision mediump float;\t\t\t\t\t  \nuniform sampler2D u_Texture; \nvarying vec2 v_texCoords; \nvoid main()                                  \n{                                            \n  vec4 fcolor = texture2D(u_Texture, v_texCoords) ;\n  gl_FragColor = fcolor ;\n}                                            \n");
    int k = GLES20.glCreateProgram();
    if (k == 0)
    {
      AppMethodBeat.o(75013);
      return;
    }
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glBindAttribLocation(k, 0, "a_position");
    GLES20.glBindAttribLocation(k, 1, "a_texCoords");
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      GLES20.glGetProgramInfoLog(k);
      GLES20.glDeleteProgram(k);
      AppMethodBeat.o(75013);
      return;
    }
    this.wnv = GLES20.glGetUniformLocation(k, "uMVPMatrix");
    this.wnt = GLES20.glGetUniformLocation(k, "u_Texture");
    this.wnk = k;
    AppMethodBeat.o(75013);
  }
  
  public final void o(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(75015);
    GLES20.glUniformMatrix4fv(this.wnv, 1, false, paramArrayOfFloat, 0);
    AppMethodBeat.o(75015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.f
 * JD-Core Version:    0.7.0.1
 */