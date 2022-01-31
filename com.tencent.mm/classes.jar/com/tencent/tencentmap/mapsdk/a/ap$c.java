package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hv;
import com.tencent.tencentmap.mapsdk.maps.a.kk;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

class ap$c
  implements ap.b
{
  private boolean b = false;
  
  public ap$c(ap paramap, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a()
  {
    AppMethodBeat.i(149651);
    if ((ap.a(this.a).T == 0) || (ap.a(this.a).U == 0))
    {
      AppMethodBeat.o(149651);
      return;
    }
    ap.a(this.a).a(null);
    if ((ap.a(this.a).M == null) || (ap.a(this.a).N == null))
    {
      AppMethodBeat.o(149651);
      return;
    }
    Object localObject = new GeoPoint();
    float f;
    int i;
    int j;
    if ((ap.a(this.a).P == 0) && (ap.a(this.a).Q == 0) && (ap.a(this.a).R == 0) && (ap.a(this.a).S == 0))
    {
      f = this.a.a(0, 0, 0, 0, ap.a(this.a).M, ap.a(this.a).N, (GeoPoint)localObject);
      ah.a locala = ap.a(this.a).w;
      i = ((GeoPoint)localObject).getLatitudeE6();
      j = ((GeoPoint)localObject).getLongitudeE6();
      if (!this.b) {
        break label433;
      }
      localObject = new kk(10000);
      ((kk)localObject).c(0.0F);
      ((kk)localObject).d(0.0F);
      ((kk)localObject).c(i, j);
      ((kk)localObject).a(f);
      ((kk)localObject).a(ap.b(this.a));
      ((kk)localObject).a(locala);
      ap.a(this.a).b().a((hv)localObject);
    }
    for (;;)
    {
      ap.a(this.a).M = null;
      ap.a(this.a).N = null;
      ap.a(this.a).P = 0;
      ap.a(this.a).Q = 0;
      ap.a(this.a).R = 0;
      ap.a(this.a).S = 0;
      ap.a(this.a).w = null;
      AppMethodBeat.o(149651);
      return;
      f = this.a.a(ap.a(this.a).P, ap.a(this.a).Q, ap.a(this.a).R, ap.a(this.a).S, ap.a(this.a).M, ap.a(this.a).N, (GeoPoint)localObject);
      break;
      label433:
      ap.a(this.a).b().b(0.0F);
      ap.a(this.a).b().a(0.0F);
      ap.a(this.a).b().a(i, j);
      ap.a(this.a, f, false, 0L, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.c
 * JD-Core Version:    0.7.0.1
 */