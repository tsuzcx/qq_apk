package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class iq
  implements Cloneable
{
  private int a;
  private iq.a b;
  private Rect c;
  private int d;
  private double e;
  private double f;
  private double g;
  private double h;
  private double i;
  private double j;
  private double k;
  private double l;
  private GeoPoint m;
  private Rect n;
  private ik o;
  private if p;
  private Integer q;
  private DoublePoint r;
  private iq.b s;
  
  public iq(ik paramik)
  {
    AppMethodBeat.i(148614);
    this.g = 0.0D;
    this.h = 1.0D;
    this.i = 0.0D;
    this.j = 1.0D;
    this.k = 0.0D;
    this.l = 1.0D;
    this.q = Integer.valueOf(0);
    this.a = -1;
    this.b = new iq.a();
    this.c = new Rect();
    this.m = new GeoPoint();
    this.r = new DoublePoint();
    this.o = paramik;
    this.p = paramik.f();
    AppMethodBeat.o(148614);
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
  
  private void d(int paramInt)
  {
    double d1 = (1 << paramInt) * 256;
    this.d = ((int)d1);
    this.e = (d1 / 360.0D);
    this.f = (d1 / 6.283185307179586D);
  }
  
  public float a(float paramFloat)
  {
    AppMethodBeat.i(148620);
    if (this.p.w() == paramFloat)
    {
      AppMethodBeat.o(148620);
      return paramFloat;
    }
    float f1 = paramFloat % 360.0F;
    double d1 = Math.toRadians(paramFloat);
    this.g = Math.sin(d1);
    this.h = Math.cos(d1);
    if (this.p != null) {
      this.p.a(f1);
    }
    AppMethodBeat.o(148620);
    return f1;
  }
  
  public void a()
  {
    AppMethodBeat.i(148617);
    if (this.o == null)
    {
      AppMethodBeat.o(148617);
      return;
    }
    this.m = this.p.o();
    int i1 = this.p.r();
    float f1 = this.p.p();
    if (i1 != j()) {
      this.o.a().a(iq.c.c);
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.a(i1, f1);
      }
      this.a = this.p.x();
      AppMethodBeat.o(148617);
      return;
      if (f1 != i()) {
        this.o.a().a(iq.c.b);
      }
    }
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(148641);
    this.r.set(paramDouble1, paramDouble2);
    AppMethodBeat.o(148641);
  }
  
  public void a(Rect paramRect)
  {
    AppMethodBeat.i(148637);
    this.c.set(paramRect);
    AppMethodBeat.o(148637);
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148616);
    this.n = paramRect;
    this.c = ig.a(2);
    b(paramInt3);
    a(0);
    a(paramInt1, paramInt2, false);
    AppMethodBeat.o(148616);
  }
  
  public void a(iq paramiq)
  {
    AppMethodBeat.i(148615);
    this.a = paramiq.a;
    this.b.a(paramiq.b);
    this.c.set(paramiq.c);
    this.d = paramiq.d;
    this.e = paramiq.e;
    this.f = paramiq.f;
    this.g = paramiq.g;
    this.h = paramiq.h;
    this.i = paramiq.i;
    this.j = paramiq.j;
    this.k = paramiq.k;
    this.l = paramiq.l;
    this.m.setGeoPoint(paramiq.m);
    this.r.set(paramiq.r.x, paramiq.r.y);
    this.n = paramiq.n;
    AppMethodBeat.o(148615);
  }
  
  public boolean a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(148642);
    if (this.s == null) {
      this.s = new iq.b(paramFloat1, paramFloat2);
    }
    for (;;)
    {
      this.o.a(paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(148642);
      return true;
      this.s.a(paramFloat1, paramFloat2);
    }
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(148618);
    if (this.p == null)
    {
      AppMethodBeat.o(148618);
      return false;
    }
    int i1 = this.p.x();
    if (i1 == paramInt)
    {
      AppMethodBeat.o(148618);
      return false;
    }
    if (i1 == 11) {
      this.o.c(false);
    }
    if (paramInt == 11) {
      this.o.c(true);
    }
    this.a = paramInt;
    this.p.c(paramInt, b(i1, paramInt));
    AppMethodBeat.o(148618);
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148640);
    int i1 = 1 << 20 - j();
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
          AppMethodBeat.o(148640);
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
    AppMethodBeat.i(148639);
    int i1;
    int i2;
    if (1 << 20 - j() < 0)
    {
      i1 = 0;
      if (131072 <= i1) {
        break label279;
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
          DoublePoint localDoublePoint = hn.a(this, this.m);
          a(localDoublePoint.x, localDoublePoint.y);
          this.p.a(this.m, paramBoolean);
          AppMethodBeat.o(148639);
          return bool;
          i1 = 20 - j();
          break;
        }
      }
      label279:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public boolean a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148638);
    boolean bool = a(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    AppMethodBeat.o(148638);
    return bool;
  }
  
  public float b(float paramFloat)
  {
    AppMethodBeat.i(148622);
    if (this.p.v() == paramFloat)
    {
      AppMethodBeat.o(148622);
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
    AppMethodBeat.o(148622);
    return f1;
  }
  
  public int b()
  {
    AppMethodBeat.i(148619);
    if (this.p == null)
    {
      i1 = this.a;
      AppMethodBeat.o(148619);
      return i1;
    }
    int i1 = this.p.x();
    AppMethodBeat.o(148619);
    return i1;
  }
  
  public boolean b(int paramInt)
  {
    AppMethodBeat.i(148627);
    if (c(this.b.a(paramInt)) == iq.c.c)
    {
      AppMethodBeat.o(148627);
      return true;
    }
    AppMethodBeat.o(148627);
    return false;
  }
  
  public float c()
  {
    AppMethodBeat.i(148621);
    float f1 = this.p.w();
    AppMethodBeat.o(148621);
    return f1;
  }
  
  public iq.c c(float paramFloat)
  {
    AppMethodBeat.i(148624);
    iq.c localc = iq.c.a;
    float f1 = this.b.a();
    int i2 = this.b.b();
    int i1;
    if (this.p != null)
    {
      this.p.a(paramFloat, false);
      paramFloat = this.p.p();
      i1 = this.p.r();
    }
    for (;;)
    {
      this.b.a(i1, paramFloat);
      if (i1 != i2) {
        localc = iq.c.c;
      }
      label172:
      for (;;)
      {
        switch (iq.1.a[localc.ordinal()])
        {
        }
        for (;;)
        {
          DoublePoint localDoublePoint = hn.a(this, p());
          this.r.set(localDoublePoint.x, localDoublePoint.y);
          AppMethodBeat.o(148624);
          return localc;
          if (paramFloat == f1) {
            break label172;
          }
          localc = iq.c.b;
          break;
          d(this.b.b());
        }
      }
      i1 = i2;
      paramFloat = f1;
    }
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(148634);
    this.b.b(paramInt);
    AppMethodBeat.o(148634);
  }
  
  public Object clone()
  {
    AppMethodBeat.i(148646);
    iq localiq = (iq)super.clone();
    localiq.c = new Rect(this.c);
    localiq.b = ((iq.a)this.b.clone());
    localiq.m = new GeoPoint(this.m);
    localiq.r = new DoublePoint(this.r.x, this.r.y);
    AppMethodBeat.o(148646);
    return localiq;
  }
  
  public float d()
  {
    AppMethodBeat.i(148623);
    float f1 = this.p.v();
    AppMethodBeat.o(148623);
    return f1;
  }
  
  public iq.c d(float paramFloat)
  {
    AppMethodBeat.i(148626);
    if (this.p != null) {
      this.p.a(paramFloat);
    }
    this.b.a(paramFloat);
    iq.c localc = iq.c.c;
    AppMethodBeat.o(148626);
    return localc;
  }
  
  public void e()
  {
    AppMethodBeat.i(148625);
    d(this.b.b());
    DoublePoint localDoublePoint = hn.a(this, p());
    this.r.set(localDoublePoint.x, localDoublePoint.y);
    AppMethodBeat.o(148625);
  }
  
  public void e(float paramFloat)
  {
    AppMethodBeat.i(148636);
    this.b.b(paramFloat);
    AppMethodBeat.o(148636);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(148644);
    if (!(paramObject instanceof iq))
    {
      AppMethodBeat.o(148644);
      return false;
    }
    paramObject = (iq)paramObject;
    if (!paramObject.m.equals(this.m))
    {
      AppMethodBeat.o(148644);
      return false;
    }
    if (!paramObject.b.equals(this.b))
    {
      AppMethodBeat.o(148644);
      return false;
    }
    if (paramObject.a != this.a)
    {
      AppMethodBeat.o(148644);
      return false;
    }
    AppMethodBeat.o(148644);
    return true;
  }
  
  public int f()
  {
    return this.d;
  }
  
  public double g()
  {
    return this.e;
  }
  
  public double h()
  {
    return this.f;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(148643);
    int i1 = toString().hashCode();
    AppMethodBeat.o(148643);
    return i1;
  }
  
  public float i()
  {
    AppMethodBeat.i(148628);
    float f1 = this.b.a();
    AppMethodBeat.o(148628);
    return f1;
  }
  
  public int j()
  {
    AppMethodBeat.i(148629);
    int i1 = this.b.b();
    AppMethodBeat.o(148629);
    return i1;
  }
  
  public float k()
  {
    AppMethodBeat.i(148630);
    float f1 = this.b.c();
    AppMethodBeat.o(148630);
    return f1;
  }
  
  public int l()
  {
    AppMethodBeat.i(148631);
    int i1 = this.b.d();
    AppMethodBeat.o(148631);
    return i1;
  }
  
  public int m()
  {
    AppMethodBeat.i(148632);
    int i1 = this.b.e();
    AppMethodBeat.o(148632);
    return i1;
  }
  
  public int n()
  {
    AppMethodBeat.i(148633);
    int i1 = this.b.f();
    AppMethodBeat.o(148633);
    return i1;
  }
  
  public float o()
  {
    AppMethodBeat.i(148635);
    float f1 = this.b.g();
    AppMethodBeat.o(148635);
    return f1;
  }
  
  public GeoPoint p()
  {
    return this.m;
  }
  
  public iq.b q()
  {
    return this.s;
  }
  
  public byte[] r()
  {
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(148645);
    Object localObject = new StringBuilder();
    GeoPoint localGeoPoint = p();
    ((StringBuilder)localObject).append("mapParam: ");
    ((StringBuilder)localObject).append("center:" + localGeoPoint.toString() + " ");
    ((StringBuilder)localObject).append("mode:" + this.a + " ");
    ((StringBuilder)localObject).append("mapScale:" + this.b.toString() + " ");
    ((StringBuilder)localObject).append("screenRect:" + this.n.toString() + " ");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(148645);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.iq
 * JD-Core Version:    0.7.0.1
 */