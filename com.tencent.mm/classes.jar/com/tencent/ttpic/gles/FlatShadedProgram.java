package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class FlatShadedProgram
{
  private static final String FRAGMENT_SHADER = "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}";
  private static final String TAG = GlUtil.TAG;
  private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}";
  private int mProgramHandle = -1;
  private int maPositionLoc = -1;
  private int muColorLoc = -1;
  private int muMVPMatrixLoc = -1;
  
  public FlatShadedProgram()
  {
    if (this.mProgramHandle == 0) {
      throw new RuntimeException("Unable to create program");
    }
    new StringBuilder("Created program ").append(this.mProgramHandle);
    this.maPositionLoc = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
    GlUtil.checkLocation(this.maPositionLoc, "aPosition");
    this.muMVPMatrixLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
    GlUtil.checkLocation(this.muMVPMatrixLoc, "uMVPMatrix");
    this.muColorLoc = GLES20.glGetUniformLocation(this.mProgramHandle, "uColor");
    GlUtil.checkLocation(this.muColorLoc, "uColor");
  }
  
  public void draw(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, FloatBuffer paramFloatBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GlUtil.checkGlError("draw start");
    GLES20.glUseProgram(this.mProgramHandle);
    GlUtil.checkGlError("glUseProgram");
    GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, paramArrayOfFloat1, 0);
    GlUtil.checkGlError("glUniformMatrix4fv");
    GLES20.glUniform4fv(this.muColorLoc, 1, paramArrayOfFloat2, 0);
    GlUtil.checkGlError("glUniform4fv ");
    GLES20.glEnableVertexAttribArray(this.maPositionLoc);
    GlUtil.checkGlError("glEnableVertexAttribArray");
    GLES20.glVertexAttribPointer(this.maPositionLoc, paramInt3, 5126, false, paramInt4, paramFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer");
    GLES20.glDrawArrays(5, paramInt1, paramInt2);
    GlUtil.checkGlError("glDrawArrays");
    GLES20.glDisableVertexAttribArray(this.maPositionLoc);
    GLES20.glUseProgram(0);
  }
  
  public void release()
  {
    GLES20.glDeleteProgram(this.mProgramHandle);
    this.mProgramHandle = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.FlatShadedProgram
 * JD-Core Version:    0.7.0.1
 */