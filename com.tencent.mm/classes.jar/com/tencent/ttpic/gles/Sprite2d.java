package com.tencent.ttpic.gles;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Sprite2d
{
  private static final String TAG = GlUtil.TAG;
  private float mAngle;
  private float[] mColor;
  private Drawable2d mDrawable;
  private boolean mMatrixReady;
  private float[] mModelViewMatrix;
  private float mPosX;
  private float mPosY;
  private float mScaleX;
  private float mScaleY;
  private float[] mScratchMatrix;
  private int mTextureId;
  
  public Sprite2d(Drawable2d paramDrawable2d)
  {
    AppMethodBeat.i(50029);
    this.mScratchMatrix = new float[16];
    this.mDrawable = paramDrawable2d;
    this.mColor = new float[4];
    this.mColor[3] = 1.0F;
    this.mTextureId = -1;
    this.mModelViewMatrix = new float[16];
    this.mMatrixReady = false;
    AppMethodBeat.o(50029);
  }
  
  private void recomputeMatrix()
  {
    AppMethodBeat.i(50030);
    float[] arrayOfFloat = this.mModelViewMatrix;
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.translateM(arrayOfFloat, 0, this.mPosX, this.mPosY, 0.0F);
    if (this.mAngle != 0.0F) {
      Matrix.rotateM(arrayOfFloat, 0, this.mAngle, 0.0F, 0.0F, 1.0F);
    }
    Matrix.scaleM(arrayOfFloat, 0, this.mScaleX, this.mScaleY, 1.0F);
    this.mMatrixReady = true;
    AppMethodBeat.o(50030);
  }
  
  public void draw(FlatShadedProgram paramFlatShadedProgram, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(50032);
    Matrix.multiplyMM(this.mScratchMatrix, 0, paramArrayOfFloat, 0, getModelViewMatrix(), 0);
    paramFlatShadedProgram.draw(this.mScratchMatrix, this.mColor, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride());
    AppMethodBeat.o(50032);
  }
  
  public void draw(Texture2dProgram paramTexture2dProgram, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(50033);
    Matrix.multiplyMM(this.mScratchMatrix, 0, paramArrayOfFloat, 0, getModelViewMatrix(), 0);
    paramTexture2dProgram.draw(this.mScratchMatrix, this.mDrawable.getVertexArray(), 0, this.mDrawable.getVertexCount(), this.mDrawable.getCoordsPerVertex(), this.mDrawable.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.mDrawable.getTexCoordArray(), this.mTextureId, this.mDrawable.getTexCoordStride());
    AppMethodBeat.o(50033);
  }
  
  public float[] getColor()
  {
    return this.mColor;
  }
  
  public float[] getModelViewMatrix()
  {
    AppMethodBeat.i(50031);
    if (!this.mMatrixReady) {
      recomputeMatrix();
    }
    float[] arrayOfFloat = this.mModelViewMatrix;
    AppMethodBeat.o(50031);
    return arrayOfFloat;
  }
  
  public float getPositionX()
  {
    return this.mPosX;
  }
  
  public float getPositionY()
  {
    return this.mPosY;
  }
  
  public float getRotation()
  {
    return this.mAngle;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public void setColor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mColor[0] = paramFloat1;
    this.mColor[1] = paramFloat2;
    this.mColor[2] = paramFloat3;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.mPosX = paramFloat1;
    this.mPosY = paramFloat2;
    this.mMatrixReady = false;
  }
  
  public void setRotation(float paramFloat)
  {
    float f;
    for (;;)
    {
      f = paramFloat;
      if (paramFloat < 360.0F) {
        break;
      }
      paramFloat -= 360.0F;
    }
    while (f <= -360.0F) {
      f += 360.0F;
    }
    this.mAngle = f;
    this.mMatrixReady = false;
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.mScaleX = paramFloat1;
    this.mScaleY = paramFloat2;
    this.mMatrixReady = false;
  }
  
  public void setTexture(int paramInt)
  {
    this.mTextureId = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(50034);
    String str = "[Sprite2d pos=" + this.mPosX + "," + this.mPosY + " scale=" + this.mScaleX + "," + this.mScaleY + " angle=" + this.mAngle + " color={" + this.mColor[0] + "," + this.mColor[1] + "," + this.mColor[2] + "} drawable=" + this.mDrawable + "]";
    AppMethodBeat.o(50034);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.gles.Sprite2d
 * JD-Core Version:    0.7.0.1
 */