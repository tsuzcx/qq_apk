package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PTFilter$PTYUV2RGBAFilter
  extends PTFilter
{
  public PTFilter$PTYUV2RGBAFilter()
  {
    AppMethodBeat.i(80692);
    this.mFilter = new o();
    AppMethodBeat.o(80692);
  }
  
  public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(80693);
    BaseFilter localBaseFilter = this.mFilter;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label48;
      }
    }
    for (;;)
    {
      localBaseFilter.nativeSetRotationAndFlip(paramInt, i, j);
      AppMethodBeat.o(80693);
      return;
      i = 0;
      break;
      label48:
      j = 0;
    }
  }
  
  public void setTextureCoordsMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(80694);
    this.mFilter.nativeUpdateMatrix(paramArrayOfFloat);
    AppMethodBeat.o(80694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTYUV2RGBAFilter
 * JD-Core Version:    0.7.0.1
 */