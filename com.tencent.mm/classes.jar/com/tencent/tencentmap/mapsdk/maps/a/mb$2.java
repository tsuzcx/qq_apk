package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class mb$2
  implements Comparator<ms>
{
  mb$2(mv parammv) {}
  
  public final int a(ms paramms1, ms paramms2)
  {
    AppMethodBeat.i(149272);
    int i = Float.valueOf(paramms1.b().a().b(this.a).g()).compareTo(Float.valueOf(paramms2.b().a().b(this.a).g()));
    AppMethodBeat.o(149272);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mb.2
 * JD-Core Version:    0.7.0.1
 */