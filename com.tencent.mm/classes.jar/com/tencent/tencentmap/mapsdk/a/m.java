package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

public class m
  implements com.tencent.tencentmap.mapsdk.map.Projection
{
  private com.tencent.tencentmap.mapsdk.maps.Projection a;
  private TencentMap b;
  
  public m(TencentMap paramTencentMap)
  {
    AppMethodBeat.i(186354);
    this.a = paramTencentMap.getProjection();
    this.b = paramTencentMap;
    AppMethodBeat.o(186354);
  }
  
  public double distanceBetween(com.tencent.mapsdk.raster.model.LatLng paramLatLng1, com.tencent.mapsdk.raster.model.LatLng paramLatLng2)
  {
    AppMethodBeat.i(186358);
    double d = e.a(paramLatLng1, paramLatLng2);
    AppMethodBeat.o(186358);
    return d;
  }
  
  public com.tencent.mapsdk.raster.model.LatLng fromScreenLocation(Point paramPoint)
  {
    AppMethodBeat.i(186355);
    paramPoint = q.a(this.a.fromScreenLocation(paramPoint));
    AppMethodBeat.o(186355);
    return paramPoint;
  }
  
  public double getLatitudeSpan()
  {
    AppMethodBeat.i(186361);
    com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion localVisibleRegion = this.a.getVisibleRegion();
    if (localVisibleRegion == null)
    {
      AppMethodBeat.o(186361);
      return -1.0D;
    }
    double d1 = localVisibleRegion.latLngBounds.southwest.latitude;
    double d2 = localVisibleRegion.latLngBounds.northeast.latitude;
    AppMethodBeat.o(186361);
    return d1 - d2;
  }
  
  public double getLongitudeSpan()
  {
    AppMethodBeat.i(186362);
    com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion localVisibleRegion = this.a.getVisibleRegion();
    if (localVisibleRegion == null)
    {
      AppMethodBeat.o(186362);
      return -1.0D;
    }
    double d1 = localVisibleRegion.latLngBounds.southwest.longitude;
    double d2 = localVisibleRegion.latLngBounds.northeast.longitude;
    AppMethodBeat.o(186362);
    return d1 - d2;
  }
  
  public float getScalePerPixel()
  {
    AppMethodBeat.i(186363);
    float f = (float)this.a.metersPerPixel(this.b.getCameraPosition().target.latitude);
    AppMethodBeat.o(186363);
    return f;
  }
  
  public com.tencent.mapsdk.raster.model.VisibleRegion getVisibleRegion()
  {
    AppMethodBeat.i(186357);
    com.tencent.mapsdk.raster.model.VisibleRegion localVisibleRegion = q.a(this.a.getVisibleRegion());
    AppMethodBeat.o(186357);
    return localVisibleRegion;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    AppMethodBeat.i(186359);
    paramFloat = metersToPixels(0.0D, paramFloat);
    AppMethodBeat.o(186359);
    return paramFloat;
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(186360);
    float f = (float)(paramDouble2 / this.a.metersPerPixel(paramDouble1));
    AppMethodBeat.o(186360);
    return f;
  }
  
  @Deprecated
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    AppMethodBeat.i(186364);
    paramGeoPoint = GeoPoint.g2l(paramGeoPoint);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(186364);
      return null;
    }
    paramGeoPoint = toScreenLocation(paramGeoPoint);
    AppMethodBeat.o(186364);
    return paramGeoPoint;
  }
  
  public Point toScreenLocation(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186356);
    paramLatLng = this.a.toScreenLocation(q.a(paramLatLng));
    AppMethodBeat.o(186356);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.m
 * JD-Core Version:    0.7.0.1
 */