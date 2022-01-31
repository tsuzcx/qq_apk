package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.Rect;

public class vb
{
  private static vb.b d;
  private tn a;
  private th b;
  private tk c;
  
  public vb(tn paramtn)
  {
    this.a = paramtn;
    this.b = paramtn.e();
    this.c = paramtn.b();
  }
  
  public static void a(vb.b paramb)
  {
    d = paramb;
  }
  
  private void b(ut paramut, long paramLong, uv paramuv)
  {
    if ((!this.a.f().k()) || (paramLong < 0L)) {
      paramut.a().a(false);
    }
    paramut.a().a(paramuv);
    paramut.a().a(paramLong);
    this.a.c().a(paramut.a());
  }
  
  public static vb.b n()
  {
    return d;
  }
  
  public rv a(rw paramrw)
  {
    return new rv(this.b.a(paramrw));
  }
  
  public sa a(sb paramsb)
  {
    return new sa(this.b.a(paramsb));
  }
  
  public sc a(sd paramsd)
  {
    return new sc(this.b.a(paramsd));
  }
  
  public se a(sf paramsf)
  {
    return new se(this.b.a(paramsf));
  }
  
  public final void a()
  {
    this.b.a();
    this.a.a(false, false);
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    a(new ry(c().b() - paramDouble1 / 2.0D, c().c() + paramDouble2 / 2.0D), new ry(c().b() + paramDouble1 / 2.0D, c().c() - paramDouble2 / 2.0D));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    b(uu.a(paramFloat1, paramFloat2), 1000L, null);
  }
  
  public void a(float paramFloat1, float paramFloat2, long paramLong, uv paramuv)
  {
    b(uu.a(paramFloat1, paramFloat2), paramLong, paramuv);
  }
  
  public void a(int paramInt)
  {
    b(uu.a(paramInt), 0L, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(uu.a(1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void a(ry paramry)
  {
    b(uu.a(paramry), 1000L, null);
  }
  
  public void a(ry paramry, long paramLong, uv paramuv)
  {
    b(uu.a(paramry), paramLong, paramuv);
  }
  
  public void a(ry paramry1, ry paramry2)
  {
    paramry1 = new rz.a().a(paramry1).a(paramry2).a();
    this.a.c().a(uu.a(paramry1, 10).a());
  }
  
  public void a(ry paramry, Runnable paramRunnable)
  {
    b(uu.a(paramry), 1000L, new vb.1(this, paramRunnable));
  }
  
  public void a(sg paramsg)
  {
    tn.a(sg.a(paramsg));
    this.a.a(true, true);
  }
  
  public void a(ut paramut)
  {
    if (paramut != null)
    {
      paramut = paramut.a();
      if (paramut != null)
      {
        paramut.a(false);
        this.a.c().a(paramut);
      }
    }
  }
  
  public void a(ut paramut, long paramLong, uv paramuv)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    b(paramut, l, paramuv);
  }
  
  public void a(vb.a parama)
  {
    this.a.h().a(parama);
  }
  
  public void a(vb.c paramc)
  {
    this.a.h().a(paramc);
  }
  
  public void a(vb.d paramd)
  {
    this.a.h().a(paramd);
  }
  
  public void a(vb.e parame)
  {
    this.a.h().a(parame);
  }
  
  public void a(vb.f paramf)
  {
    this.a.c().a(paramf);
  }
  
  public void a(vb.g paramg)
  {
    this.a.h().a(paramg);
  }
  
  public void a(vb.h paramh)
  {
    this.a.h().a(paramh);
  }
  
  public void a(vb.i parami)
  {
    this.a.h().a(parami);
  }
  
  public void a(vb.j paramj)
  {
    this.a.a(paramj);
  }
  
  public void a(vb.j paramj, Rect paramRect)
  {
    this.a.a(paramj, paramRect);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a(2);
      return;
    }
    this.a.a(1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    b(uu.a(-1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void b(ry paramry)
  {
    b(uu.a(paramry, d()), 0L, null);
  }
  
  public void b(ut paramut)
  {
    b(paramut, 1000L, null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.i().a(paramBoolean);
  }
  
  public boolean b()
  {
    return (ug.a().a(ue.a.b)) && (ug.a().a(ue.a.a)) && (ug.a().a(ue.a.c));
  }
  
  public ry c()
  {
    return this.c.d().b();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.g(paramBoolean);
    }
  }
  
  public int d()
  {
    return (int)this.c.d().c();
  }
  
  public int e()
  {
    return this.c.i().a();
  }
  
  public int f()
  {
    return this.c.j().a();
  }
  
  public final String g()
  {
    return "1.3.2.cb07f1c";
  }
  
  public final boolean h()
  {
    return tn.p();
  }
  
  public final boolean i()
  {
    return this.a.l() == 2;
  }
  
  public void j()
  {
    b(uu.a(), 1000L, null);
  }
  
  public void k()
  {
    b(uu.b(), 1000L, null);
  }
  
  public void l()
  {
    this.a.d().g();
  }
  
  public boolean m()
  {
    return this.a.i().a();
  }
  
  public boolean o()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.vb
 * JD-Core Version:    0.7.0.1
 */