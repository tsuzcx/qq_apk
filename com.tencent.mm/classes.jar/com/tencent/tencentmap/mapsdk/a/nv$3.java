package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;

class nv$3
  implements ii.a
{
  nv$3(nv paramnv, boolean paramBoolean, ah.a parama, long paramLong) {}
  
  public void a(float paramFloat, GeoPoint paramGeoPoint, double paramDouble)
  {
    if (nv.a(this.d) == null) {
      return;
    }
    nv.a(this.d).v.post(new nv.3.1(this, paramFloat, paramGeoPoint));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nv.3
 * JD-Core Version:    0.7.0.1
 */