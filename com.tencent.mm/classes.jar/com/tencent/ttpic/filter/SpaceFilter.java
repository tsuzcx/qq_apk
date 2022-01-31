package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;

public class SpaceFilter
  extends BaseFilter
{
  private float mRatio = 0.0F;
  
  public SpaceFilter()
  {
    super(GLSLRender.bcE);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glFinish();
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setSpaceRatio(float paramFloat)
  {
    if (Float.compare(this.mRatio, paramFloat) == 0) {
      return;
    }
    this.mRatio = paramFloat;
    paramFloat = 1.0F - this.mRatio;
    setPositions(new float[] { -paramFloat, -paramFloat, -paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, -paramFloat });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.SpaceFilter
 * JD-Core Version:    0.7.0.1
 */