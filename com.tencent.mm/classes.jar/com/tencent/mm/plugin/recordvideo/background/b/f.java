package com.tencent.mm.plugin.recordvideo.background.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public final class f
  extends a
{
  final float[] NEL;
  final float[] NEM;
  FloatBuffer NEN;
  FloatBuffer NEO;
  int NEP;
  public final float[] NFn;
  int mPl;
  
  public f()
  {
    AppMethodBeat.i(75012);
    this.NEL = new float[] { -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
    this.NEM = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.NFn = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    AppMethodBeat.o(75012);
  }
  
  public final void gHc()
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
    this.mPl = GLES20.glGetUniformLocation(k, "uMVPMatrix");
    this.NEP = GLES20.glGetUniformLocation(k, "u_Texture");
    this.NEG = k;
    AppMethodBeat.o(75013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.f
 * JD-Core Version:    0.7.0.1
 */