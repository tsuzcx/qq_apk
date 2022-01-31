package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum GlUtil$DRAW_MODE
{
  static
  {
    AppMethodBeat.i(50000);
    TRIANGLE_STRIP = new DRAW_MODE("TRIANGLE_STRIP", 0);
    TRIANGLES = new DRAW_MODE("TRIANGLES", 1);
    TRIANGLE_FAN = new DRAW_MODE("TRIANGLE_FAN", 2);
    LINES = new DRAW_MODE("LINES", 3);
    POINTS = new DRAW_MODE("POINTS", 4);
    $VALUES = new DRAW_MODE[] { TRIANGLE_STRIP, TRIANGLES, TRIANGLE_FAN, LINES, POINTS };
    AppMethodBeat.o(50000);
  }
  
  private GlUtil$DRAW_MODE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.gles.GlUtil.DRAW_MODE
 * JD-Core Version:    0.7.0.1
 */