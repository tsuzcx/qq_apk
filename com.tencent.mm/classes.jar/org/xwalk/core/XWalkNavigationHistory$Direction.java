package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum XWalkNavigationHistory$Direction
{
  static
  {
    AppMethodBeat.i(154811);
    BACKWARD = new Direction("BACKWARD", 0);
    FORWARD = new Direction("FORWARD", 1);
    $VALUES = new Direction[] { BACKWARD, FORWARD };
    AppMethodBeat.o(154811);
  }
  
  private XWalkNavigationHistory$Direction() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkNavigationHistory.Direction
 * JD-Core Version:    0.7.0.1
 */