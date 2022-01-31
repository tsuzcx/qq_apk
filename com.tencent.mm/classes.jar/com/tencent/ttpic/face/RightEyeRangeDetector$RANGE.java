package com.tencent.ttpic.face;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum RightEyeRangeDetector$RANGE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(81902);
    CLOSE_EYE = new RANGE("CLOSE_EYE", 0, 0);
    OPEN_EYE_20 = new RANGE("OPEN_EYE_20", 1, 1);
    OPEN_EYE_40 = new RANGE("OPEN_EYE_40", 2, 2);
    OPEN_EYE_60 = new RANGE("OPEN_EYE_60", 3, 3);
    OPEN_EYE_80 = new RANGE("OPEN_EYE_80", 4, 4);
    OPEN_EYE_100 = new RANGE("OPEN_EYE_100", 5, 5);
    $VALUES = new RANGE[] { CLOSE_EYE, OPEN_EYE_20, OPEN_EYE_40, OPEN_EYE_60, OPEN_EYE_80, OPEN_EYE_100 };
    AppMethodBeat.o(81902);
  }
  
  private RightEyeRangeDetector$RANGE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.face.RightEyeRangeDetector.RANGE
 * JD-Core Version:    0.7.0.1
 */