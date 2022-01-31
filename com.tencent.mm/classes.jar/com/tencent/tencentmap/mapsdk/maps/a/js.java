package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.element.j;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cp;
import com.tencent.tencentmap.mapsdk.a.cz;
import javax.microedition.khronos.opengles.GL10;

public class js
  extends jx
  implements j
{
  private GeoPoint a;
  private double b;
  private float c;
  private kx d;
  private cp e;
  private int f;
  private CircleInfo g;
  
  public js(kx paramkx)
  {
    AppMethodBeat.i(148735);
    this.a = new GeoPoint(39909230, 116397428);
    this.b = 0.0D;
    this.c = 1000.0F;
    this.d = null;
    this.f = -1;
    this.g = new CircleInfo();
    this.d = paramkx;
    AppMethodBeat.o(148735);
  }
  
  private double a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148744);
    paramDouble1 /= Math.cos(3.141592653589793D * paramDouble2 / 180.0D);
    AppMethodBeat.o(148744);
    return paramDouble1;
  }
  
  private b a(cz paramcz)
  {
    AppMethodBeat.i(148745);
    if (paramcz == null)
    {
      AppMethodBeat.o(148745);
      return null;
    }
    double d1 = paramcz.a;
    paramcz = new b(paramcz.b * 20037508.34D / 180.0D, Math.log(Math.tan((d1 + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
    AppMethodBeat.o(148745);
    return paramcz;
  }
  
  private cz a(b paramb)
  {
    AppMethodBeat.i(148746);
    float f1 = (float)(paramb.b() * 180.0D / 20037508.34D);
    paramb = new cz((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramb.a() * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f1);
    AppMethodBeat.o(148746);
    return paramb;
  }
  
  public Rect a(hu paramhu)
  {
    AppMethodBeat.i(148743);
    double d1 = a(this.b, this.a.getLatitudeE6() / 1000000.0D);
    Object localObject = a(new cz(this.a.getLatitudeE6() / 1000000.0D, this.a.getLongitudeE6() / 1000000.0D));
    paramhu = new b(((b)localObject).b() - d1, ((b)localObject).a() + d1);
    localObject = new b(((b)localObject).b() + d1, ((b)localObject).a() - d1);
    paramhu = a(paramhu);
    localObject = a((b)localObject);
    Rect localRect = new Rect();
    localRect.left = ((int)(paramhu.b * 1000000.0D));
    localRect.top = ((int)(paramhu.a * 1000000.0D));
    localRect.right = ((int)(((cz)localObject).b * 1000000.0D));
    localRect.bottom = ((int)(((cz)localObject).a * 1000000.0D));
    AppMethodBeat.o(148743);
    return localRect;
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(148738);
    if (paramDouble < 0.0D)
    {
      AppMethodBeat.o(148738);
      return;
    }
    double d1 = paramDouble;
    if (paramDouble == 0.0D) {
      d1 = 1.0E-010D;
    }
    if ((this.e == null) || (this.e.a() == null))
    {
      AppMethodBeat.o(148738);
      return;
    }
    this.b = d1;
    this.c = ((float)ka.a(d1, this.e.a().a));
    this.P = true;
    AppMethodBeat.o(148738);
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148737);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148737);
      return;
    }
    if (this.a == null) {
      this.a = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      this.P = true;
      AppMethodBeat.o(148737);
      return;
      this.a.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.a.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void a(cp paramcp)
  {
    AppMethodBeat.i(148736);
    if (paramcp == null)
    {
      AppMethodBeat.o(148736);
      return;
    }
    this.e = paramcp;
    cz localcz = paramcp.a();
    if (localcz != null) {
      a(ka.a(localcz));
    }
    a(paramcp.b());
    d(paramcp.c());
    c(paramcp.d());
    d(paramcp.e());
    c(paramcp.f());
    a(paramcp.g());
    a_(paramcp.h());
    this.e = paramcp;
    this.P = true;
    AppMethodBeat.o(148736);
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148739);
    if ((this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(148739);
      return;
    }
    c();
    AppMethodBeat.o(148739);
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
    this.P = true;
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148740);
    if ((this.a == null) || (this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(148740);
      return false;
    }
    GeoPoint localGeoPoint = this.d.b().t().a(new DoublePoint(paramFloat1, paramFloat2));
    if (Math.hypot(localGeoPoint.getLatitudeE6() - this.a.getLatitudeE6(), localGeoPoint.getLongitudeE6() - this.a.getLongitudeE6()) <= this.c)
    {
      AppMethodBeat.o(148740);
      return true;
    }
    AppMethodBeat.o(148740);
    return false;
  }
  
  public boolean a(hu paramhu, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(ih paramih, hu paramhu) {}
  
  public void c()
  {
    AppMethodBeat.i(148741);
    if (((this.f > 0) && (!this.P)) || (this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(148741);
      return;
    }
    this.g.zIndex = ((int)this.N);
    this.g.borderColor = this.M;
    this.g.borderWidth = ((int)this.K);
    this.g.fillColor = this.L;
    this.g.radius = ((float)this.b);
    this.g.centerX = this.a.getLongitudeE6();
    this.g.centerY = this.a.getLatitudeE6();
    this.g.isVisible = this.O;
    this.g.level = this.Q;
    if (this.f == -1) {
      this.f = this.d.b().a(this.g);
    }
    for (;;)
    {
      this.P = false;
      AppMethodBeat.o(148741);
      return;
      if (this.P) {
        this.d.b().a(this.f, this.g);
      }
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(148742);
    if ((this.f != -1) && (this.d != null) && (this.d.b() != null))
    {
      this.d.b().d(this.f);
      this.f = -1;
    }
    AppMethodBeat.o(148742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.js
 * JD-Core Version:    0.7.0.1
 */