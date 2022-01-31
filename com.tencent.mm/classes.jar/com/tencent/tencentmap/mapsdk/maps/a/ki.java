package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ki
  extends kd
{
  private GeoPoint e;
  private GeoPoint f;
  private boolean g;
  
  public ki(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148951);
    this.e = null;
    this.f = null;
    this.g = false;
    if (paramGeoPoint != null)
    {
      this.f = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
      this.g = true;
    }
    AppMethodBeat.o(148951);
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148952);
    if ((this.f == null) || (this.e == null))
    {
      AppMethodBeat.o(148952);
      return;
    }
    int m = this.f.getLatitudeE6();
    int n = this.e.getLatitudeE6();
    int j = this.f.getLongitudeE6();
    int k = this.e.getLongitudeE6();
    paramFloat = paramInterpolator.getInterpolation(paramFloat);
    int i = this.e.getLatitudeE6();
    m = (int)((m - n) * paramFloat);
    n = this.e.getLongitudeE6();
    j = (int)((j - k) * paramFloat);
    if (this.d != null) {
      this.d.a(m + i, j + n);
    }
    AppMethodBeat.o(148952);
  }
  
  public boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(148953);
    if (!super.a(null, null))
    {
      AppMethodBeat.o(148953);
      return false;
    }
    if (paramGeoPoint1 != null) {
      this.e = new GeoPoint(paramGeoPoint1.getLatitudeE6(), paramGeoPoint1.getLongitudeE6());
    }
    if ((!this.g) && (paramGeoPoint2 != null)) {
      this.f = new GeoPoint(paramGeoPoint2.getLatitudeE6(), paramGeoPoint2.getLongitudeE6());
    }
    AppMethodBeat.o(148953);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ki
 * JD-Core Version:    0.7.0.1
 */