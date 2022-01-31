package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$DETECTOR_BIT
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(84065);
    REFINE = new DETECTOR_BIT("REFINE", 0, 1);
    $VALUES = new DETECTOR_BIT[] { REFINE };
    AppMethodBeat.o(84065);
  }
  
  private VideoMaterialUtil$DETECTOR_BIT(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.DETECTOR_BIT
 * JD-Core Version:    0.7.0.1
 */