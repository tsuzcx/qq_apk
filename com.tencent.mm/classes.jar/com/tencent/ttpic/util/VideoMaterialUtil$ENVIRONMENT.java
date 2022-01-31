package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$ENVIRONMENT
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(84071);
    BYPASS = new ENVIRONMENT("BYPASS", 0, -1);
    ECHO = new ENVIRONMENT("ECHO", 1, 1);
    VIBRATE = new ENVIRONMENT("VIBRATE", 2, 2);
    THREE = new ENVIRONMENT("THREE", 3, 3);
    FOUR = new ENVIRONMENT("FOUR", 4, 4);
    FIVE = new ENVIRONMENT("FIVE", 5, 5);
    NINE = new ENVIRONMENT("NINE", 6, 9);
    TWENTY = new ENVIRONMENT("TWENTY", 7, 20);
    FIFTY = new ENVIRONMENT("FIFTY", 8, 50);
    FIFTYONE = new ENVIRONMENT("FIFTYONE", 9, 51);
    $VALUES = new ENVIRONMENT[] { BYPASS, ECHO, VIBRATE, THREE, FOUR, FIVE, NINE, TWENTY, FIFTY, FIFTYONE };
    AppMethodBeat.o(84071);
  }
  
  private VideoMaterialUtil$ENVIRONMENT(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.ENVIRONMENT
 * JD-Core Version:    0.7.0.1
 */