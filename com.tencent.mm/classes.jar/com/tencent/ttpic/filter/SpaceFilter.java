package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SpaceFilter
  extends BaseFilter
{
  private float mRatio = 0.0F;
  
  public SpaceFilter()
  {
    super(GLSLRender.btg);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82951);
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16384);
    GLES20.glFinish();
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(82951);
    return bool;
  }
  
  public void setSpaceRatio(float paramFloat)
  {
    AppMethodBeat.i(82950);
    if (Float.compare(this.mRatio, paramFloat) == 0)
    {
      AppMethodBeat.o(82950);
      return;
    }
    this.mRatio = paramFloat;
    paramFloat = 1.0F - this.mRatio;
    setPositions(new float[] { -paramFloat, -paramFloat, -paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, -paramFloat });
    AppMethodBeat.o(82950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.SpaceFilter
 * JD-Core Version:    0.7.0.1
 */