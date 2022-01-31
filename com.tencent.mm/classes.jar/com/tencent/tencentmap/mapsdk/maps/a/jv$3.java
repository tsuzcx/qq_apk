package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dd;

class jv$3
  implements kd.b
{
  jv$3(jv paramjv) {}
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(148791);
    this.a.s = paramFloat;
    if (jv.b(this.a) != null)
    {
      jv.b(this.a).a(this.a.s);
      this.a.m.b(this.a.s);
    }
    AppMethodBeat.o(148791);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148793);
    this.a.t = paramFloat1;
    this.a.u = paramFloat2;
    if (jv.b(this.a) != null) {
      jv.b(this.a).b(this.a.t, this.a.u);
    }
    AppMethodBeat.o(148793);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(148790);
    this.a.h = paramFloat1;
    this.a.j = paramFloat2;
    this.a.k = paramFloat3;
    this.a.l = paramFloat4;
    this.a.i = true;
    if (jv.b(this.a) != null) {
      jv.b(this.a).b((int)this.a.h);
    }
    AppMethodBeat.o(148790);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148792);
    if ((jv.c(this.a) != null) && (this.a.p != null))
    {
      Object localObject = new GeoPoint();
      if ((!jv.d(this.a)) || (jv.e(this.a) == null) || (jv.c(this.a).b() == null)) {
        break label257;
      }
      GeoPoint localGeoPoint = jv.c(this.a).b().t().a(new DoublePoint(jv.f(this.a), jv.g(this.a)));
      int i = localGeoPoint.getLatitudeE6();
      int j = jv.e(this.a).getLatitudeE6();
      int k = localGeoPoint.getLongitudeE6();
      int m = jv.e(this.a).getLongitudeE6();
      ((GeoPoint)localObject).setLatitudeE6(i - j + paramInt1);
      ((GeoPoint)localObject).setLongitudeE6(k - m + paramInt2);
      localObject = jv.c(this.a).b().t().b((GeoPoint)localObject);
      this.a.p.setLatitudeE6((int)((DoublePoint)localObject).y);
      this.a.p.setLongitudeE6((int)((DoublePoint)localObject).x);
    }
    for (;;)
    {
      if (jv.b(this.a) != null) {
        jv.b(this.a).a(this.a.p);
      }
      AppMethodBeat.o(148792);
      return;
      label257:
      this.a.p.setLatitudeE6(paramInt1 + 0);
      this.a.p.setLongitudeE6(paramInt2 + 0);
    }
  }
  
  public void b(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jv.3
 * JD-Core Version:    0.7.0.1
 */