package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;

class nv$3$1
  implements Runnable
{
  nv$3$1(nv.3 param3, float paramFloat, GeoPoint paramGeoPoint) {}
  
  public void run()
  {
    double d1 = 0.0D;
    if (nv.a(this.c.d) == null) {
      return;
    }
    double d2;
    if (this.c.a)
    {
      d2 = (int)this.c.d.h() - Math.log(1.0F / this.a) / Math.log(2.0D) - 2.0D;
      if (d2 >= 0.0D) {
        break label204;
      }
    }
    for (;;)
    {
      lx locallx = new lx(10000);
      locallx.c(this.b.getLatitudeE6(), this.b.getLongitudeE6());
      locallx.a((float)d1);
      locallx.a(nv.b(this.c.d));
      locallx.a(this.c.b);
      locallx.a(this.c.c);
      nv.a(this.c.d).getMap().a(locallx);
      return;
      nv.a(this.c.d).getMap().b(this.b);
      nv.a(this.c.d).getMap().c(this.a);
      return;
      label204:
      d1 = d2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv.3.1
 * JD-Core Version:    0.7.0.1
 */