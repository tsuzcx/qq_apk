package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SplitFilter
  extends BaseFilter
{
  private float xPos = 0.0F;
  
  public SplitFilter()
  {
    super(GLSLRender.btg);
  }
  
  private void updatePosition()
  {
    AppMethodBeat.i(82952);
    float f1 = this.xPos * 2.0F - 1.0F;
    float f2 = this.xPos;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    setTexCords(new float[] { f2, 0.0F, f2, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
    AppMethodBeat.o(82952);
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, h paramh)
  {
    AppMethodBeat.i(82953);
    updatePosition();
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramh);
    AppMethodBeat.o(82953);
  }
  
  public void setxPos(float paramFloat)
  {
    this.xPos = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.SplitFilter
 * JD-Core Version:    0.7.0.1
 */