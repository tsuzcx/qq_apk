package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OffsetGuideFilter
  extends BaseFilter
{
  private float xOffset = 0.0F;
  
  public OffsetGuideFilter()
  {
    super(GLSLRender.btg);
  }
  
  private void updatePosition()
  {
    AppMethodBeat.i(82685);
    float f1 = 0.0F - this.xOffset;
    float f2 = 0.5F - this.xOffset / 2.0F;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    setTexCords(new float[] { f2, 1.0F, f2, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    AppMethodBeat.o(82685);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(82686);
    updatePosition();
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
    AppMethodBeat.o(82686);
  }
  
  public void setxOffset(float paramFloat)
  {
    this.xOffset = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.OffsetGuideFilter
 * JD-Core Version:    0.7.0.1
 */