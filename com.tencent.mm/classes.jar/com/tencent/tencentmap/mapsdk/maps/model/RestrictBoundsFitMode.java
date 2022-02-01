package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum RestrictBoundsFitMode
{
  static
  {
    AppMethodBeat.i(173369);
    FIT_WIDTH = new RestrictBoundsFitMode("FIT_WIDTH", 0);
    FIT_HEIGHT = new RestrictBoundsFitMode("FIT_HEIGHT", 1);
    $VALUES = new RestrictBoundsFitMode[] { FIT_WIDTH, FIT_HEIGHT };
    AppMethodBeat.o(173369);
  }
  
  private RestrictBoundsFitMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode
 * JD-Core Version:    0.7.0.1
 */