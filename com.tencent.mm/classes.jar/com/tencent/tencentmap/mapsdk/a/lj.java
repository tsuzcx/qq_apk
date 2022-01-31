package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.Polygon2D;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class lj
  extends ln
  implements kj
{
  Polygon2D a;
  private GeoPoint b = new GeoPoint(39909230, 116397428);
  private double c = 0.0D;
  private double d = 1000.0D;
  private double e = -1.0D;
  private float f = 1.0F;
  private ma g = null;
  private List<GeoPoint> h = new ArrayList();
  private pw i;
  private pv j;
  
  public lj(ma paramma)
  {
    this.g = paramma;
    this.a = new Polygon2D();
    this.a.polygonId = -1;
  }
  
  private double a(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 / Math.cos(3.141592653589793D * paramDouble2 / 180.0D);
  }
  
  private b a(qc paramqc)
  {
    if (paramqc == null) {
      return null;
    }
    double d1 = paramqc.a;
    return new b(paramqc.b * 20037508.34D / 180.0D, Math.log(Math.tan((d1 + 90.0D) * 3.141592653589793D / 360.0D)) / 0.0174532925199433D * 20037508.34D / 180.0D);
  }
  
  private qc a(b paramb)
  {
    float f1 = (float)(paramb.b() * 180.0D / 20037508.34D);
    return new qc((float)(57.295779513082323D * (2.0D * Math.atan(Math.exp((float)(paramb.a() * 180.0D / 20037508.34D) * 3.141592653589793D / 180.0D)) - 1.570796326794897D)), f1);
  }
  
  private int[] a(int paramInt)
  {
    return new int[] { Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt), Color.alpha(paramInt) };
  }
  
  public Rect a(iu paramiu)
  {
    double d1 = a(this.c, this.b.getLatitudeE6() / 1000000.0D);
    Object localObject = a(new qc(this.b.getLatitudeE6() / 1000000.0D, this.b.getLongitudeE6() / 1000000.0D));
    paramiu = new b(((b)localObject).b() - d1, ((b)localObject).a() + d1);
    localObject = new b(((b)localObject).b() + d1, ((b)localObject).a() - d1);
    paramiu = a(paramiu);
    localObject = a((b)localObject);
    Rect localRect = new Rect();
    localRect.left = ((int)(paramiu.b * 1000000.0D));
    localRect.top = ((int)(paramiu.a * 1000000.0D));
    localRect.right = ((int)(((qc)localObject).b * 1000000.0D));
    localRect.bottom = ((int)(((qc)localObject).a * 1000000.0D));
    return localRect;
  }
  
  public void a(double paramDouble)
  {
    if (paramDouble < 0.0D) {}
    double d1;
    do
    {
      return;
      d1 = paramDouble;
      if (paramDouble == 0.0D) {
        d1 = 1.0E-010D;
      }
    } while ((this.i == null) || (this.i.a() == null));
    this.c = d1;
    float f1 = (float)lq.a(d1, this.i.a().a);
    if (this.e == -1.0D) {
      this.e = f1;
    }
    for (this.f = 1.0F;; this.f = ((float)(f1 / this.e)))
    {
      this.d = f1;
      this.P = true;
      return;
      if (this.e == 0.0D) {
        this.e = 1.0E-010D;
      }
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    if (this.b == null) {
      this.b = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      this.P = true;
      return;
      this.b.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.b.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void a(pv parampv)
  {
    this.j = parampv;
  }
  
  public void a(pw parampw)
  {
    if (parampw == null) {
      return;
    }
    this.i = parampw;
    qc localqc = parampw.a();
    if (localqc != null) {
      a(lq.a(localqc));
    }
    a(parampw.b());
    d(parampw.c());
    b(parampw.d());
    c(parampw.e());
    c(parampw.f());
    a_(parampw.g());
    this.i = parampw;
    this.P = true;
  }
  
  public void a(GL10 paramGL10)
  {
    if ((this.g == null) || (this.g.getMap() == null)) {
      return;
    }
    if (!a())
    {
      this.g.getMap().c(this.a.polygonId);
      this.a.polygonId = -1;
      return;
    }
    c();
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((this.g == null) || (this.g.getMap() == null) || (this.b == null)) {}
    GeoPoint localGeoPoint;
    do
    {
      return false;
      localGeoPoint = this.g.getMap().t().a(new DoublePoint(paramFloat1, paramFloat2));
    } while (Math.hypot(localGeoPoint.getLatitudeE6() - this.b.getLatitudeE6(), localGeoPoint.getLongitudeE6() - this.b.getLongitudeE6()) > this.d);
    return true;
  }
  
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void a_(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public void b() {}
  
  public void b(je paramje, iu paramiu) {}
  
  public void c()
  {
    if ((this.g == null) || (this.g.getMap() == null) || ((this.a.polygonId >= 0) && (!this.P))) {
      return;
    }
    this.a.color = a(this.L);
    this.a.borderColor = a(this.M);
    this.a.borderWidth = this.K;
    this.a.pointsCount = 128;
    this.a.polygonMode = 1;
    this.a.originalRadius = ((float)this.e);
    this.a.scale = this.f;
    this.a.zIndex = this.N;
    if (this.b != null)
    {
      this.a.centerX = this.b.getLatitudeE6();
      this.a.centerY = this.b.getLongitudeE6();
    }
    this.a.points = new Point[0];
    if (-1 == this.a.polygonId) {
      this.a.polygonId = this.g.getMap().a(this.a);
    }
    for (;;)
    {
      this.P = false;
      return;
      if (this.P) {
        this.g.getMap().b(this.a);
      }
    }
  }
  
  public void d()
  {
    if ((this.g == null) || (this.g.getMap() == null)) {
      return;
    }
    if (this.a != null) {
      this.g.getMap().c(this.a.polygonId);
    }
    this.e = -1.0D;
    this.b = null;
    this.j = null;
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lj
 * JD-Core Version:    0.7.0.1
 */