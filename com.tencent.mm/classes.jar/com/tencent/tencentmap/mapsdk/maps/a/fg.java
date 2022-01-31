package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum fg
{
  static
  {
    AppMethodBeat.i(98898);
    a = new fg("BEGIN_ARRAY", 0);
    b = new fg("END_ARRAY", 1);
    c = new fg("BEGIN_OBJECT", 2);
    d = new fg("END_OBJECT", 3);
    e = new fg("NAME", 4);
    f = new fg("STRING", 5);
    g = new fg("NUMBER", 6);
    h = new fg("BOOLEAN", 7);
    i = new fg("NULL", 8);
    j = new fg("END_DOCUMENT", 9);
    k = new fg[] { a, b, c, d, e, f, g, h, i, j };
    AppMethodBeat.o(98898);
  }
  
  private fg() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fg
 * JD-Core Version:    0.7.0.1
 */