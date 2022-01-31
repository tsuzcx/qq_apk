package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;

public class PTFilter$PTCopyFilter
  extends PTFilter
{
  public PTFilter$PTCopyFilter()
  {
    this.mFilter = new BaseFilter(GLSLRender.bcE);
    this.mFilterFrame = new h();
  }
  
  public BaseFilter getFilter()
  {
    return this.mFilter;
  }
  
  public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (this.mFilter == null) {
      return;
    }
    BaseFilter localBaseFilter = this.mFilter;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label46;
      }
    }
    for (;;)
    {
      localBaseFilter.nativeSetRotationAndFlip(paramInt, i, j);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTCopyFilter
 * JD-Core Version:    0.7.0.1
 */