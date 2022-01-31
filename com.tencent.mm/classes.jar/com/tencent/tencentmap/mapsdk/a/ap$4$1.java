package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import com.tencent.tencentmap.mapsdk.maps.a.ne;

class ap$4$1
  implements Runnable
{
  ap$4$1(ap.4 param4) {}
  
  public void run()
  {
    AppMethodBeat.i(149647);
    if (ap.a(this.a.c) == null)
    {
      AppMethodBeat.o(149647);
      return;
    }
    ap.a(this.a.c).a(ap.a(this.a.c).b().j());
    ap.a(this.a.c).N().h();
    if (ap.a(this.a.c).q != null)
    {
      ap.a(this.a.c).q.a();
      ap.a(this.a.c).q = null;
    }
    AppMethodBeat.o(149647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.4.1
 * JD-Core Version:    0.7.0.1
 */