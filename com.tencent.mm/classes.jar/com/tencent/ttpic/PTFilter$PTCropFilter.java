package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;

public class PTFilter$PTCropFilter
  extends PTFilter
{
  private float bottom = 0.0F;
  private float left = 0.0F;
  
  public PTFilter$PTCropFilter()
  {
    this.mFilter = new BaseFilter(GLSLRender.bcE);
    this.mFilterFrame = new h();
  }
  
  public void updateCorpRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = (paramInt3 - paramInt1) / 2.0F / paramInt3;
    float f2 = 1.0F - f1;
    float f3 = (paramInt4 - paramInt2) / 2.0F / paramInt4;
    float f4 = 1.0F - f3;
    if ((Float.compare(f1, this.left) == 0) && (Float.compare(f3, this.bottom) == 0)) {
      return;
    }
    this.left = f1;
    this.bottom = f3;
    this.mFilter.setTexCords(new float[] { f1, f3, f1, f4, f2, f4, f2, f3 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTCropFilter
 * JD-Core Version:    0.7.0.1
 */