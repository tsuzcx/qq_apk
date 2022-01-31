package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;

public class ee
  implements Projection
{
  private ag a;
  private ah b;
  
  public ee(ah paramah)
  {
    AppMethodBeat.i(150349);
    this.a = paramah.m();
    this.b = paramah;
    AppMethodBeat.o(150349);
  }
  
  public double distanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    AppMethodBeat.i(150353);
    double d = dx.a(paramLatLng1, paramLatLng2);
    AppMethodBeat.o(150353);
    return d;
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    AppMethodBeat.i(150350);
    paramPoint = eh.a(this.a.a(paramPoint));
    AppMethodBeat.o(150350);
    return paramPoint;
  }
  
  public double getLatitudeSpan()
  {
    AppMethodBeat.i(150356);
    dm localdm = this.a.b();
    if (localdm == null)
    {
      AppMethodBeat.o(150356);
      return -1.0D;
    }
    double d1 = localdm.e.a.a;
    double d2 = localdm.e.b.a;
    AppMethodBeat.o(150356);
    return d1 - d2;
  }
  
  public double getLongitudeSpan()
  {
    AppMethodBeat.i(150357);
    dm localdm = this.a.b();
    if (localdm == null)
    {
      AppMethodBeat.o(150357);
      return -1.0D;
    }
    double d1 = localdm.e.a.b;
    double d2 = localdm.e.b.b;
    AppMethodBeat.o(150357);
    return d1 - d2;
  }
  
  public float getScalePerPixel()
  {
    AppMethodBeat.i(150358);
    float f = (float)this.a.a(this.b.d().a.a);
    AppMethodBeat.o(150358);
    return f;
  }
  
  public VisibleRegion getVisibleRegion()
  {
    AppMethodBeat.i(150352);
    VisibleRegion localVisibleRegion = eh.a(this.a.b());
    AppMethodBeat.o(150352);
    return localVisibleRegion;
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    AppMethodBeat.i(150354);
    dw.a("call metersToEquatorPixels");
    paramFloat = metersToPixels(0.0D, paramFloat);
    AppMethodBeat.o(150354);
    return paramFloat;
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(150355);
    dw.a("call metersToPixels");
    float f = (float)(paramDouble2 / this.a.a(paramDouble1));
    AppMethodBeat.o(150355);
    return f;
  }
  
  @Deprecated
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    AppMethodBeat.i(150359);
    paramGeoPoint = GeoPoint.g2l(paramGeoPoint);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(150359);
      return null;
    }
    paramGeoPoint = toScreenLocation(paramGeoPoint);
    AppMethodBeat.o(150359);
    return paramGeoPoint;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    AppMethodBeat.i(150351);
    paramLatLng = this.a.a(eh.a(paramLatLng));
    AppMethodBeat.o(150351);
    return paramLatLng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ee
 * JD-Core Version:    0.7.0.1
 */