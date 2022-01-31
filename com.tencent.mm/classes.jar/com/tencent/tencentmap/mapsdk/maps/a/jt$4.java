package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

class jt$4
  implements kd.b
{
  jt$4(jt paramjt) {}
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(148751);
    this.a.q = paramFloat;
    if (this.a.a != null) {
      this.a.a.a(this.a.q);
    }
    AppMethodBeat.o(148751);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148753);
    this.a.r = paramFloat1;
    this.a.s = paramFloat2;
    if (this.a.a != null) {
      this.a.a.b(this.a.r, this.a.s);
    }
    AppMethodBeat.o(148753);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a.e = paramFloat1;
    this.a.e %= 360.0F;
    this.a.e += 360.0F;
    this.a.e %= 360.0F;
    this.a.g = paramFloat2;
    this.a.h = paramFloat3;
    this.a.i = paramFloat4;
    this.a.f = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148752);
    if (this.a.n != null)
    {
      this.a.n.setLatitudeE6(paramInt1);
      this.a.n.setLongitudeE6(paramInt2);
      if (this.a.a != null) {
        this.a.a.a(this.a.n);
      }
    }
    AppMethodBeat.o(148752);
  }
  
  public void b(float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jt.4
 * JD-Core Version:    0.7.0.1
 */