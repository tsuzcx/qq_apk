package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hj.a;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

class ap$3
  implements hj.a
{
  ap$3(ap paramap, boolean paramBoolean, ah.a parama, long paramLong) {}
  
  public void a(float paramFloat, GeoPoint paramGeoPoint, double paramDouble)
  {
    AppMethodBeat.i(149646);
    if (ap.a(this.d) == null)
    {
      AppMethodBeat.o(149646);
      return;
    }
    ap.a(this.d).I.post(new ap.3.1(this, paramFloat, paramGeoPoint));
    AppMethodBeat.o(149646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.3
 * JD-Core Version:    0.7.0.1
 */