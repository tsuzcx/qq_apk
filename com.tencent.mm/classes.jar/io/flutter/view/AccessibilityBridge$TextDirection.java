package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum AccessibilityBridge$TextDirection
{
  static
  {
    AppMethodBeat.i(9687);
    UNKNOWN = new TextDirection("UNKNOWN", 0);
    LTR = new TextDirection("LTR", 1);
    RTL = new TextDirection("RTL", 2);
    $VALUES = new TextDirection[] { UNKNOWN, LTR, RTL };
    AppMethodBeat.o(9687);
  }
  
  private AccessibilityBridge$TextDirection() {}
  
  public static TextDirection fromInt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return UNKNOWN;
    case 1: 
      return RTL;
    }
    return LTR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.TextDirection
 * JD-Core Version:    0.7.0.1
 */