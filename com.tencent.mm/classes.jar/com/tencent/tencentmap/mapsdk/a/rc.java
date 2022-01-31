package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class rc
  implements Projection
{
  private va a;
  
  public rc(va paramva)
  {
    this.a = paramva;
  }
  
  public double distanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (this.a != null) {
      return this.a.a(re.a(paramLatLng1), re.a(paramLatLng2));
    }
    return -1.0D;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    if (this.a != null) {
      return re.a(this.a.a(paramPoint));
    }
    return null;
  }
  
  public double getLatitudeSpan()
  {
    if (this.a != null) {
      return this.a.b() / 1000000.0D;
    }
    return -1.0D;
  }
  
  public double getLongitudeSpan()
  {
    if (this.a != null) {
      return this.a.c() / 1000000.0D;
    }
    return -1.0D;
  }
  
  public float getScalePerPixel()
  {
    if (this.a != null) {
      return this.a.d();
    }
    return -1.0F;
  }
  
  public VisibleRegion getVisibleRegion()
  {
    if (this.a != null) {
      return re.a(this.a.a());
    }
    return null;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    if (this.a != null) {
      return this.a.a(paramFloat);
    }
    return -1.0F;
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    if (this.a != null) {
      return this.a.a(paramDouble1, paramDouble2);
    }
    return -1.0F;
  }
  
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    paramGeoPoint = GeoPoint.g2l(paramGeoPoint);
    if (paramGeoPoint == null) {
      return null;
    }
    return toScreenLocation(paramGeoPoint);
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    if (this.a != null) {
      return this.a.a(re.a(paramLatLng));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rc
 * JD-Core Version:    0.7.0.1
 */