package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class hn
  implements hu
{
  private iq a;
  private if b;
  private ik c;
  
  public hn(iq paramiq, hl paramhl)
  {
    AppMethodBeat.i(148110);
    this.a = paramiq;
    this.b = paramhl.f();
    if ((paramhl instanceof ik)) {
      this.c = ((ik)paramhl);
    }
    AppMethodBeat.o(148110);
  }
  
  public static DoublePoint a(iq paramiq, GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148113);
    if ((paramiq == null) || (paramGeoPoint == null))
    {
      AppMethodBeat.o(148113);
      return null;
    }
    double d2 = 0.0D;
    double d1 = 0.0D;
    int i = paramiq.f() >> 1;
    double d4 = paramiq.g();
    double d3 = paramiq.h();
    if (paramGeoPoint != null)
    {
      d1 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
      d2 = i + d4 * (paramGeoPoint.getLongitudeE6() / 1000000.0D);
      d4 = i;
      d1 = Math.log((1.0D + d1) / (1.0D - d1)) * d3 * 0.5D + d4;
    }
    paramiq = new DoublePoint(d2, d1);
    AppMethodBeat.o(148113);
    return paramiq;
  }
  
  public static b a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148116);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148116);
      return null;
    }
    double d = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    paramGeoPoint = new b(paramGeoPoint.getLongitudeE6() / 1000000.0D * 20037508.34D / 180.0D, Math.log(Math.tan((d + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
    AppMethodBeat.o(148116);
    return paramGeoPoint;
  }
  
  public double a(double paramDouble)
  {
    AppMethodBeat.i(148114);
    float f = this.a.j();
    double d = this.a.k();
    d = 40076000.0D / (Math.pow(2.0D, (float)(f + Math.log(d) / Math.log(2.0D))) * 256.0D);
    paramDouble = Math.cos(3.141592653589793D * paramDouble / 180.0D);
    AppMethodBeat.o(148114);
    return d * paramDouble;
  }
  
  public double a(Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(148115);
    GeoPoint localGeoPoint1 = a(new DoublePoint(paramPoint1.x, paramPoint1.y));
    GeoPoint localGeoPoint2 = a(new DoublePoint(paramPoint2.x, paramPoint2.y));
    float[] arrayOfFloat = new float[1];
    Location.distanceBetween(localGeoPoint1.getLatitudeE6() / 1000000.0D, localGeoPoint1.getLongitudeE6() / 1000000.0D, localGeoPoint2.getLatitudeE6() / 1000000.0D, localGeoPoint2.getLongitudeE6() / 1000000.0D, arrayOfFloat);
    int i = (int)Math.sqrt(Math.pow(paramPoint1.x - paramPoint2.x, 2.0D) + Math.pow(paramPoint1.y - paramPoint2.y, 2.0D));
    double d = arrayOfFloat[0] / i;
    AppMethodBeat.o(148115);
    return d;
  }
  
  public GeoPoint a(DoublePoint paramDoublePoint)
  {
    AppMethodBeat.i(148111);
    if (paramDoublePoint == null)
    {
      AppMethodBeat.o(148111);
      return null;
    }
    byte[] arrayOfByte = this.a.r();
    float f4 = (float)paramDoublePoint.x;
    float f3 = (float)paramDoublePoint.y;
    float f2 = f4;
    float f1 = f3;
    if (this.c != null)
    {
      paramDoublePoint = this.c.p();
      f2 = f4;
      f1 = f3;
      if (paramDoublePoint != null)
      {
        f2 = f4 - paramDoublePoint.left;
        f1 = f3 - paramDoublePoint.top;
      }
    }
    paramDoublePoint = this.b.a(arrayOfByte, f2, f1);
    AppMethodBeat.o(148111);
    return paramDoublePoint;
  }
  
  public DoublePoint b(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148112);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148112);
      return null;
    }
    double d1 = paramGeoPoint.getLatitudeE6() / 1000000.0D;
    double d2 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    paramGeoPoint = this.a.r();
    paramGeoPoint = this.b.a(paramGeoPoint, d1, d2);
    float f4 = paramGeoPoint.x;
    float f3 = paramGeoPoint.y;
    float f2 = f4;
    float f1 = f3;
    if (this.c != null)
    {
      paramGeoPoint = this.c.p();
      f2 = f4;
      f1 = f3;
      if (paramGeoPoint != null)
      {
        f2 = f4 + paramGeoPoint.left;
        f1 = f3 + paramGeoPoint.top;
      }
    }
    paramGeoPoint = new DoublePoint(f2, f1);
    AppMethodBeat.o(148112);
    return paramGeoPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.hn
 * JD-Core Version:    0.7.0.1
 */