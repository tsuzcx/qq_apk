package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.filter.o;

public class PTFilter$PTYUV2RGBAFilter
  extends PTFilter
{
  public PTFilter$PTYUV2RGBAFilter()
  {
    this.mFilter = new o();
    this.mFilterFrame = new h();
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
  
  public void setTextureCoordsMatrix(float[] paramArrayOfFloat)
  {
    if (this.mFilter == null) {
      return;
    }
    this.mFilter.nativeUpdateMatrix(paramArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTYUV2RGBAFilter
 * JD-Core Version:    0.7.0.1
 */