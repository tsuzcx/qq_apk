package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

class ii$3
  implements Runnable
{
  ii$3(ii paramii, iq.c paramc) {}
  
  public void run()
  {
    AppMethodBeat.i(148342);
    Iterator localIterator = ii.b(this.b).iterator();
    while (localIterator.hasNext())
    {
      hr localhr = (hr)localIterator.next();
      if (localhr != null) {
        localhr.a(this.a);
      }
    }
    ii.c(this.b);
    AppMethodBeat.o(148342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ii.3
 * JD-Core Version:    0.7.0.1
 */