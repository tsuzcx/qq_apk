package com.tencent.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PTFilter$PTCopyFilter
  extends PTFilter
{
  public void setRotationAndFlip(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(80652);
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
      AppMethodBeat.o(80652);
      return;
      i = 0;
      break;
      label48:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.PTFilter.PTCopyFilter
 * JD-Core Version:    0.7.0.1
 */