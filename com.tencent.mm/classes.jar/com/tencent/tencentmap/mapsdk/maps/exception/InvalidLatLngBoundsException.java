package com.tencent.tencentmap.mapsdk.maps.exception;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class InvalidLatLngBoundsException
  extends RuntimeException
{
  public InvalidLatLngBoundsException(int paramInt)
  {
    super("Cannot create a LatLngBounds from " + paramInt + " items");
    AppMethodBeat.i(181048);
    AppMethodBeat.o(181048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.exception.InvalidLatLngBoundsException
 * JD-Core Version:    0.7.0.1
 */