package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class mb$3
  implements Comparator<R>
{
  mb$3(oe paramoe) {}
  
  public final int compare(R paramR1, R paramR2)
  {
    AppMethodBeat.i(149274);
    int i = ((Comparable)this.a.a(paramR1)).compareTo(this.a.a(paramR2));
    AppMethodBeat.o(149274);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.mb.3
 * JD-Core Version:    0.7.0.1
 */