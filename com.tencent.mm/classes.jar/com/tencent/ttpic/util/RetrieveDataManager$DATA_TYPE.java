package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum RetrieveDataManager$DATA_TYPE
{
  public int value;
  
  static
  {
    AppMethodBeat.i(83968);
    RGBA = new DATA_TYPE("RGBA", 0, 0);
    YUV = new DATA_TYPE("YUV", 1, 1);
    $VALUES = new DATA_TYPE[] { RGBA, YUV };
    AppMethodBeat.o(83968);
  }
  
  private RetrieveDataManager$DATA_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE
 * JD-Core Version:    0.7.0.1
 */