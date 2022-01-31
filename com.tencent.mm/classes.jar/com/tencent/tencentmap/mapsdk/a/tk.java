package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;

public final class tk
{
  private static final sv a = new sv(new sw(-20037508.34D, -20037508.34D), new sw(20037508.34D, 20037508.34D));
  private tn b;
  private tj c;
  private su d;
  private su e;
  private boolean f = false;
  private sv g;
  private double h = 0.0D;
  private double i = 0.0D;
  
  public tk(tn paramtn)
  {
    this.b = paramtn;
  }
  
  private double a(double paramDouble)
  {
    return this.c.d().d() * Math.cos(0.0174532925199433D * paramDouble);
  }
  
  private double a(boolean paramBoolean)
  {
    rz localrz = c();
    if (paramBoolean) {
      return Math.abs(localrz.c().c() - localrz.b().c());
    }
    return Math.abs(localrz.c().b() - localrz.b().b());
  }
  
  private sw[] k()
  {
    int j = this.c.getWidth();
    return new sw[] { sx.a(new PointF(0.0F, this.c.getHeight()), this.c.b(), this.c.a(), this.c.d()), sx.a(new PointF(j, 0.0F), this.c.b(), this.c.a(), this.c.d()) };
  }
  
  public final float a(double paramDouble1, double paramDouble2)
  {
    return (float)(paramDouble2 / a(paramDouble1));
  }
  
  public final float a(float paramFloat)
  {
    return (float)(paramFloat / a(0.0D));
  }
  
  public final PointF a(ry paramry)
  {
    sw localsw = this.c.b();
    PointF localPointF = this.c.a();
    su localsu = this.c.d();
    paramry = sx.a(paramry);
    double d3 = paramry.b();
    double d4 = localsw.b();
    double d1 = paramry.a();
    double d2 = localsw.a();
    d3 = (d3 - d4) / localsu.d();
    d1 = (d1 - d2) / localsu.d();
    paramry = new PointF();
    paramry.x = ((float)(d3 + localPointF.x));
    paramry.y = ((float)(localPointF.y - d1));
    return paramry;
  }
  
  public final ry a(int paramInt1, int paramInt2)
  {
    return sx.a(sx.a(new PointF(paramInt1, paramInt2), this.c.b(), this.c.a(), this.c.d()));
  }
  
  public final su a(su paramsu)
  {
    int j;
    double d2;
    double d3;
    double d1;
    label67:
    su localsu2;
    if ((this.b.f().a() >= 3) && (this.b.f().b() > 1.0F))
    {
      j = 1;
      d2 = paramsu.c();
      d3 = this.e.a();
      if (j == 0) {
        break label200;
      }
      d1 = Math.log(1.3D) / Math.log(2.0D);
      if (d2 >= d1 + d3) {
        break label210;
      }
      localsu2 = new su(this.e.c());
      localsu1 = localsu2;
      if (j != 0) {
        localsu2.a(1.3D);
      }
    }
    label200:
    label210:
    for (su localsu1 = localsu2;; localsu1 = paramsu)
    {
      d2 = paramsu.c();
      d3 = this.d.c();
      if (j != 0) {}
      for (d1 = Math.log(1.3D) / Math.log(2.0D);; d1 = 0.0D)
      {
        if (d2 > d1 + d3)
        {
          paramsu = new su(this.d.c());
          localsu1 = paramsu;
          if (j != 0)
          {
            paramsu.a(1.3D);
            localsu1 = paramsu;
          }
        }
        return localsu1;
        j = 0;
        break;
        d1 = 0.0D;
        break label67;
      }
    }
  }
  
  public final void a()
  {
    this.g = a;
    this.d = new su(19.0D);
    this.e = new su(su.a);
    this.c = this.b.c();
  }
  
  protected final void a(int paramInt)
  {
    this.h = 0.0D;
  }
  
  public final void a(sw paramsw)
  {
    double d2 = 0.0D;
    if (this.g == null) {
      return;
    }
    sw[] arrayOfsw = k();
    sw localsw1 = this.g.a();
    sw localsw2 = this.g.b();
    if (localsw1.a() > arrayOfsw[0].a()) {}
    for (double d1 = localsw1.a() - arrayOfsw[0].a();; d1 = 0.0D)
    {
      if (localsw1.b() > arrayOfsw[0].b()) {
        d2 = localsw1.b() - arrayOfsw[0].b();
      }
      if (localsw2.a() < arrayOfsw[1].a()) {
        d1 = localsw2.a() - arrayOfsw[1].a();
      }
      if (localsw2.b() < arrayOfsw[1].b()) {
        d2 = localsw2.b() - arrayOfsw[1].b();
      }
      paramsw.a(d1 + paramsw.a());
      paramsw.b(paramsw.b() + d2);
      return;
    }
  }
  
  protected final void b(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      return;
    }
    double d1 = a(true);
    double d2 = a(false);
    if ((d1 == 0.0D) && (d2 == 0.0D))
    {
      this.h = paramDouble1;
      this.i = paramDouble2;
      return;
    }
    paramDouble1 = Math.max(paramDouble1 / d2, paramDouble2 / d1);
    su localsu = this.c.d();
    localsu.a(paramDouble1 * localsu.b());
    a(localsu);
    this.b.a(false, false);
  }
  
  protected final void b(int paramInt)
  {
    this.i = 0.0D;
  }
  
  public final sw[] b()
  {
    int j = 0;
    sw[] arrayOfsw = new sw[8];
    float f1 = this.c.getWidth();
    float f2 = this.c.getHeight();
    PointF localPointF1 = new PointF(0.0F, 0.0F);
    PointF localPointF2 = new PointF(f1 / 2.0F, 0.0F);
    PointF localPointF3 = new PointF(f1, 0.0F);
    PointF localPointF4 = new PointF(f1, f2 / 2.0F);
    PointF localPointF5 = new PointF(f1, f2);
    PointF localPointF6 = new PointF(f1 / 2.0F, f2);
    PointF localPointF7 = new PointF(0.0F, f2);
    PointF localPointF8 = new PointF(0.0F, f2 / 2.0F);
    while (j < 8)
    {
      arrayOfsw[j] = sx.a(new PointF[] { localPointF1, localPointF2, localPointF3, localPointF4, localPointF5, localPointF6, localPointF7, localPointF8 }[j], this.c.b(), this.c.a(), this.c.d());
      j += 1;
    }
    return arrayOfsw;
  }
  
  public final rz c()
  {
    sw[] arrayOfsw = k();
    return new rz(sx.a(arrayOfsw[0]), sx.a(arrayOfsw[1]));
  }
  
  public final void c(int paramInt)
  {
    int j = paramInt;
    if (this.f)
    {
      j = paramInt;
      if (paramInt <= this.e.c()) {
        j = this.e.a();
      }
    }
    paramInt = j;
    if (j <= su.a) {
      paramInt = su.a;
    }
    j = paramInt;
    if (paramInt >= this.d.c()) {
      j = this.d.a();
    }
    this.e.b(j);
    if (this.c.d().c() <= this.e.c()) {
      this.c.b(this.e.c(), true, null);
    }
  }
  
  public final ru d()
  {
    ry localry = sx.a(this.c.b());
    float f1 = this.c.d().a();
    return ru.a().a(localry).a(f1).a();
  }
  
  public final double e()
  {
    double d1 = 1.0D;
    if (this.c.d().a() < 7) {}
    for (;;)
    {
      return d1 * this.c.d().d();
      double d2 = 1.0D - Math.abs(this.c.b().a() / 20037508.34D);
      d1 = d2;
      if (d2 < 0.1D) {
        d1 = 0.1D;
      }
    }
  }
  
  public final float f()
  {
    int j = this.c.getWidth();
    return (float)(sx.a(a(0, 0), a(j, 0)) / j);
  }
  
  protected final double g()
  {
    return this.h;
  }
  
  protected final double h()
  {
    return this.i;
  }
  
  public final su i()
  {
    return this.d;
  }
  
  public final su j()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tk
 * JD-Core Version:    0.7.0.1
 */