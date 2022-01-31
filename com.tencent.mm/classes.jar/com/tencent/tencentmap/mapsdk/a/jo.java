package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class jo
  implements Cloneable
{
  private int a = -1;
  private jo.a b = new jo.a();
  private Rect c = new Rect();
  private int d;
  private double e;
  private double f;
  private double g = 0.0D;
  private double h = 1.0D;
  private double i = 0.0D;
  private double j = 1.0D;
  private double k = 0.0D;
  private double l = 1.0D;
  private GeoPoint m = new GeoPoint();
  private Rect n;
  private jh o;
  private jc p;
  private Integer q = Integer.valueOf(0);
  private DoublePoint r = new DoublePoint();
  private jo.b s;
  
  public jo(jh paramjh)
  {
    this.o = paramjh;
    this.p = paramjh.f();
  }
  
  private boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    do
    {
      return true;
      if ((paramInt1 == 11) && (paramInt2 != 13)) {
        return false;
      }
      if ((paramInt1 == 13) && (paramInt2 != 11)) {
        return false;
      }
      if ((paramInt2 == 11) && (paramInt1 != 13)) {
        return false;
      }
    } while ((paramInt2 != 13) || (paramInt1 == 11));
    return false;
  }
  
  private void c(int paramInt)
  {
    double d1 = (1 << paramInt) * 256;
    this.d = ((int)d1);
    this.e = (d1 / 360.0D);
    this.f = (d1 / 6.283185307179586D);
  }
  
  public float a(float paramFloat)
  {
    if (this.p.z() == paramFloat) {
      return paramFloat;
    }
    float f1 = paramFloat % 360.0F;
    double d1 = Math.toRadians(paramFloat);
    this.g = Math.sin(d1);
    this.h = Math.cos(d1);
    if (this.p != null) {
      this.p.a(f1);
    }
    return f1;
  }
  
  public void a()
  {
    if (this.o == null) {
      return;
    }
    this.m = this.p.s();
    int i1 = this.p.u();
    float f1 = this.p.t();
    if (i1 != i()) {
      this.o.a().a(jo.c.c);
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.a(i1, f1);
      }
      this.a = this.p.A();
      return;
      if (f1 != h()) {
        this.o.a().a(jo.c.b);
      }
    }
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    this.r.set(paramDouble1, paramDouble2);
  }
  
  public void a(Rect paramRect)
  {
    this.c.set(paramRect);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    this.n = paramRect;
    this.c = jd.a(2);
    b(paramInt3);
    a(0);
    a(paramInt1, paramInt2, false);
  }
  
  public void a(jo paramjo)
  {
    this.a = paramjo.a;
    this.b.a(paramjo.b);
    this.c.set(paramjo.c);
    this.d = paramjo.d;
    this.e = paramjo.e;
    this.f = paramjo.f;
    this.g = paramjo.g;
    this.h = paramjo.h;
    this.i = paramjo.i;
    this.j = paramjo.j;
    this.k = paramjo.k;
    this.l = paramjo.l;
    this.m.setGeoPoint(paramjo.m);
    this.r.set(paramjo.r.x, paramjo.r.y);
    this.n = paramjo.n;
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.s == null) {
      this.s = new jo.b(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.o.a(paramFloat1, paramFloat2, paramBoolean);
      return true;
      this.s.a(paramFloat1, paramFloat2);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.p == null) {}
    int i1;
    do
    {
      return false;
      i1 = this.p.A();
    } while (i1 == paramInt);
    if (i1 == 11) {
      this.o.d(false);
    }
    if (paramInt == 11) {
      this.o.d(true);
    }
    this.a = paramInt;
    this.p.b(paramInt, b(i1, paramInt));
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    int i1 = 1 << 20 - i();
    int i2;
    if (131072 > i1)
    {
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i3 = this.c.left - i2;
      i2 = this.c.right + i2;
      int i5 = this.c.top - i1;
      int i4 = i1 + this.c.bottom;
      if (paramInt1 < i5) {
        paramInt1 = i5;
      }
      for (;;)
      {
        i1 = paramInt1;
        if (paramInt1 > i4) {
          i1 = i4;
        }
        if (paramInt2 < i3) {}
        for (paramInt1 = i3;; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > i2) {
            paramInt2 = i2;
          }
          GeoPoint localGeoPoint = new GeoPoint(i1, paramInt2);
          this.p.c(localGeoPoint);
          return true;
        }
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (1 << 20 - i() < 0)
    {
      i1 = 0;
      if (131072 <= i1) {
        break label267;
      }
      i2 = (this.n.width() * 131072 - this.n.width() * i1) / 2;
      i1 = (this.n.height() * 131072 - i1 * this.n.height()) / 2;
    }
    for (;;)
    {
      int i3 = this.c.left - i2;
      i2 += this.c.right;
      int i5 = this.c.top - i1;
      int i4 = i1 + this.c.bottom;
      if (paramInt1 < i5) {
        paramInt1 = i5;
      }
      for (;;)
      {
        i1 = paramInt1;
        if (paramInt1 > i4) {
          i1 = i4;
        }
        if (paramInt2 < i3) {}
        for (paramInt1 = i3;; paramInt1 = paramInt2)
        {
          paramInt2 = paramInt1;
          if (paramInt1 > i2) {
            paramInt2 = i2;
          }
          if ((i1 != this.m.getLatitudeE6()) || (paramInt2 != this.m.getLongitudeE6())) {
            bool = true;
          }
          this.m.setLatitudeE6(i1);
          this.m.setLongitudeE6(paramInt2);
          DoublePoint localDoublePoint = im.a(this, this.m);
          a(localDoublePoint.x, localDoublePoint.y);
          this.p.a(this.m, paramBoolean);
          return bool;
          i1 = 20 - i();
          break;
        }
      }
      label267:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public boolean a(GeoPoint paramGeoPoint)
  {
    return a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
  }
  
  public float b(float paramFloat)
  {
    if (this.p.y() == paramFloat) {
      return paramFloat;
    }
    float f1 = Math.max(0.0F, Math.min(40.0F, paramFloat));
    double d1 = Math.toRadians(paramFloat);
    this.i = Math.sin(d1);
    this.j = Math.cos(d1);
    d1 = 1.570796326794897D - d1;
    this.l = Math.cos(d1);
    this.k = Math.sin(d1);
    if (this.p != null) {
      this.p.b(f1);
    }
    return f1;
  }
  
  public int b()
  {
    if (this.p == null) {
      return this.a;
    }
    return this.p.A();
  }
  
  public boolean b(int paramInt)
  {
    return c(this.b.a(paramInt)) == jo.c.c;
  }
  
  public float c()
  {
    return this.p.z();
  }
  
  public jo.c c(float paramFloat)
  {
    jo.c localc = jo.c.a;
    float f1 = this.b.a();
    int i2 = this.b.b();
    int i1;
    if (this.p != null)
    {
      this.p.a(paramFloat, false);
      paramFloat = this.p.t();
      i1 = this.p.u();
    }
    for (;;)
    {
      this.b.a(i1, paramFloat);
      if (i1 != i2) {
        localc = jo.c.c;
      }
      label162:
      for (;;)
      {
        switch (jo.1.a[localc.ordinal()])
        {
        }
        for (;;)
        {
          DoublePoint localDoublePoint = im.a(this, o());
          this.r.set(localDoublePoint.x, localDoublePoint.y);
          return localc;
          if (paramFloat == f1) {
            break label162;
          }
          localc = jo.c.b;
          break;
          c(this.b.b());
        }
      }
      i1 = i2;
      paramFloat = f1;
    }
  }
  
  public Object clone()
  {
    jo localjo = (jo)super.clone();
    localjo.c = new Rect(this.c);
    localjo.b = ((jo.a)this.b.clone());
    localjo.m = new GeoPoint(this.m);
    localjo.r = new DoublePoint(this.r.x, this.r.y);
    return localjo;
  }
  
  public float d()
  {
    return this.p.y();
  }
  
  public jo.c d(float paramFloat)
  {
    if (this.p != null) {
      this.p.a(paramFloat);
    }
    this.b.a(paramFloat);
    return jo.c.c;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public void e(float paramFloat)
  {
    this.b.b(paramFloat);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof jo)) {}
    do
    {
      return false;
      paramObject = (jo)paramObject;
    } while ((!paramObject.m.equals(this.m)) || (!paramObject.b.equals(this.b)) || (paramObject.a != this.a));
    return true;
  }
  
  public double f()
  {
    return this.e;
  }
  
  public double g()
  {
    return this.f;
  }
  
  public float h()
  {
    return this.b.a();
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public int i()
  {
    return this.b.b();
  }
  
  public float j()
  {
    return this.b.c();
  }
  
  public int k()
  {
    return this.b.d();
  }
  
  public int l()
  {
    return this.b.e();
  }
  
  public int m()
  {
    return this.b.f();
  }
  
  public float n()
  {
    return this.b.g();
  }
  
  public GeoPoint o()
  {
    return this.m;
  }
  
  public jo.b p()
  {
    return this.s;
  }
  
  public byte[] q()
  {
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GeoPoint localGeoPoint = o();
    localStringBuilder.append("mapParam: ");
    localStringBuilder.append("center:" + localGeoPoint.toString() + " ");
    localStringBuilder.append("mode:" + this.a + " ");
    localStringBuilder.append("mapScale:" + this.b.toString() + " ");
    localStringBuilder.append("screenRect:" + this.n.toString() + " ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jo
 * JD-Core Version:    0.7.0.1
 */