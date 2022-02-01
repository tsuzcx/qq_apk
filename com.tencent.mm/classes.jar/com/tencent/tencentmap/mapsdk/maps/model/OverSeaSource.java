package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OverSeaSource
{
  static
  {
    AppMethodBeat.i(195096);
    DEFAULT = new OverSeaSource("DEFAULT", 0);
    SPARE = new OverSeaSource("SPARE", 1);
    $VALUES = new OverSeaSource[] { DEFAULT, SPARE };
    AppMethodBeat.o(195096);
  }
  
  private OverSeaSource() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource
 * JD-Core Version:    0.7.0.1
 */