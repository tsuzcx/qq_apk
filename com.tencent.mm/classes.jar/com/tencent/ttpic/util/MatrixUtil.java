package com.tencent.ttpic.util;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MatrixUtil
{
  private static float[] mIdentityMatrix = new float[16];
  private static float[] mMVPMatrix;
  private static float[] mProjectionMatrix = new float[16];
  private static float[] mViewMatrix = new float[16];
  
  static
  {
    mMVPMatrix = new float[16];
  }
  
  public static float[] getDefaultMVPMatrix()
  {
    AppMethodBeat.i(83932);
    initProjectionMatrix(1.0F, 3.0F);
    initViewMatrix(2.0F);
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    float[] arrayOfFloat = mMVPMatrix;
    AppMethodBeat.o(83932);
    return arrayOfFloat;
  }
  
  public static float[] getIdentityMatrix()
  {
    AppMethodBeat.i(83931);
    Matrix.setIdentityM(mIdentityMatrix, 0);
    float[] arrayOfFloat = mIdentityMatrix;
    AppMethodBeat.o(83931);
    return arrayOfFloat;
  }
  
  public static float[] getMVPMatrix(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(83933);
    initProjectionMatrix(paramFloat2, paramFloat3);
    initViewMatrix(paramFloat1);
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
    float[] arrayOfFloat = mMVPMatrix;
    AppMethodBeat.o(83933);
    return arrayOfFloat;
  }
  
  public static float[] initProjectionMatrix(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(83934);
    Matrix.frustumM(mProjectionMatrix, 0, -1.0F, 1.0F, -1.0F, 1.0F, paramFloat1, paramFloat2);
    float[] arrayOfFloat = mProjectionMatrix;
    AppMethodBeat.o(83934);
    return arrayOfFloat;
  }
  
  public static float[] initViewMatrix(float paramFloat)
  {
    AppMethodBeat.i(83935);
    Matrix.setLookAtM(mViewMatrix, 0, 0.0F, 0.0F, paramFloat, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F);
    float[] arrayOfFloat = mViewMatrix;
    AppMethodBeat.o(83935);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.MatrixUtil
 * JD-Core Version:    0.7.0.1
 */