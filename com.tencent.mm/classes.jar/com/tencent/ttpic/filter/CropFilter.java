package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CropFilter
  extends BaseFilter
{
  private float bottom = 0.0F;
  private float left = 0.0F;
  
  public CropFilter()
  {
    super(GLSLRender.btg);
  }
  
  private void updatePosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82132);
    float f3 = (paramInt3 - paramInt1) / paramInt3;
    float f2 = (paramInt4 - paramInt2) / paramInt4;
    float f1 = -1.0F + f3;
    f3 = 1.0F - f3;
    float f4 = -1.0F + f2;
    f2 = 1.0F - f2;
    setPositions(new float[] { f1, f4, f1, f2, f3, f2, f3, f4 });
    AppMethodBeat.o(82132);
  }
  
  private void updateTexCords(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82133);
    float f1 = (paramInt3 - paramInt1) / 2.0F / paramInt3;
    float f2 = 1.0F - f1;
    float f3 = (paramInt4 - paramInt2) / 2.0F / paramInt4;
    float f4 = 1.0F - f3;
    if ((Float.compare(f1, this.left) == 0) && (Float.compare(f3, this.bottom) == 0))
    {
      AppMethodBeat.o(82133);
      return;
    }
    this.left = f1;
    this.bottom = f3;
    setTexCords(new float[] { f1, f3, f1, f4, f2, f4, f2, f3 });
    AppMethodBeat.o(82133);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82134);
    this.left = 0.0F;
    this.bottom = 0.0F;
    super.clearGLSLSelf();
    AppMethodBeat.o(82134);
  }
  
  public void updateCorpRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82131);
    updateTexCords(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(82131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.CropFilter
 * JD-Core Version:    0.7.0.1
 */