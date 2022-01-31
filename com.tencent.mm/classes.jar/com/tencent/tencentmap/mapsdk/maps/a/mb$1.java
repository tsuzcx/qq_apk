package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class mb$1
  implements Comparator<mt<?>>
{
  public final int a(mt<?> parammt1, mt<?> parammt2)
  {
    AppMethodBeat.i(149270);
    int i = Float.valueOf(parammt1.c()).compareTo(Float.valueOf(parammt2.c()));
    AppMethodBeat.o(149270);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mb.1
 * JD-Core Version:    0.7.0.1
 */