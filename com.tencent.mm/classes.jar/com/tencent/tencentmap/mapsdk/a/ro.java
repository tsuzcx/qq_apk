package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class ro
  implements Projection
{
  private ag a;
  private ah b;
  
  public ro(ah paramah)
  {
    this.a = paramah.m();
    this.b = paramah;
  }
  
  public double distanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return ri.a(paramLatLng1, paramLatLng2);
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    return rq.a(this.a.a(paramPoint));
  }
  
  public double getLatitudeSpan()
  {
    qo localqo = this.a.b();
    if (localqo == null) {
      return -1.0D;
    }
    return localqo.e.a.a - localqo.e.b.a;
  }
  
  public double getLongitudeSpan()
  {
    qo localqo = this.a.b();
    if (localqo == null) {
      return -1.0D;
    }
    return localqo.e.a.b - localqo.e.b.b;
  }
  
  public float getScalePerPixel()
  {
    return (float)this.a.a(this.b.d().a.a);
  }
  
  public VisibleRegion getVisibleRegion()
  {
    return rq.a(this.a.b());
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    rh.a("call metersToEquatorPixels");
    return metersToPixels(0.0D, paramFloat);
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    rh.a("call metersToPixels");
    return (float)(paramDouble2 / this.a.a(paramDouble1));
  }
  
  @Deprecated
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
    return this.a.a(rq.a(paramLatLng));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ro
 * JD-Core Version:    0.7.0.1
 */