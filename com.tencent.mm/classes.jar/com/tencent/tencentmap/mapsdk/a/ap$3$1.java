package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.kk;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

class ap$3$1
  implements Runnable
{
  ap$3$1(ap.3 param3, float paramFloat, GeoPoint paramGeoPoint) {}
  
  public void run()
  {
    double d1 = 0.0D;
    AppMethodBeat.i(149645);
    if (ap.a(this.c.d) == null)
    {
      AppMethodBeat.o(149645);
      return;
    }
    double d2;
    if (this.c.a)
    {
      d2 = (int)this.c.d.g() - Math.log(1.0F / this.a) / Math.log(2.0D) - 2.0D;
      if (d2 >= 0.0D) {
        break label224;
      }
    }
    for (;;)
    {
      kk localkk = new kk(10000);
      localkk.c(this.b.getLatitudeE6(), this.b.getLongitudeE6());
      localkk.a((float)d1);
      localkk.a(ap.b(this.c.d));
      localkk.a(this.c.b);
      localkk.a(this.c.c);
      ap.a(this.c.d).b().a(localkk);
      AppMethodBeat.o(149645);
      return;
      ap.a(this.c.d).b().b(this.b);
      ap.a(this.c.d).b().c(this.a);
      AppMethodBeat.o(149645);
      return;
      label224:
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.3.1
 * JD-Core Version:    0.7.0.1
 */