package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MouthRangeDetector$RANGE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(81896);
    CLOSE_MOUTH = new RANGE("CLOSE_MOUTH", 0, 0);
    OPEN_MOUTH_20 = new RANGE("OPEN_MOUTH_20", 1, 1);
    OPEN_MOUTH_40 = new RANGE("OPEN_MOUTH_40", 2, 2);
    OPEN_MOUTH_60 = new RANGE("OPEN_MOUTH_60", 3, 3);
    OPEN_MOUTH_80 = new RANGE("OPEN_MOUTH_80", 4, 4);
    OPEN_MOUTH_100 = new RANGE("OPEN_MOUTH_100", 5, 5);
    $VALUES = new RANGE[] { CLOSE_MOUTH, OPEN_MOUTH_20, OPEN_MOUTH_40, OPEN_MOUTH_60, OPEN_MOUTH_80, OPEN_MOUTH_100 };
    AppMethodBeat.o(81896);
  }
  
  private MouthRangeDetector$RANGE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.face.MouthRangeDetector.RANGE
 * JD-Core Version:    0.7.0.1
 */