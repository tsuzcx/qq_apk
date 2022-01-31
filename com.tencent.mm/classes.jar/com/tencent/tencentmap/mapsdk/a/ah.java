package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.location.Location;

public final class ah
{
  private static int I = 1;
  public static final int a = q.a + 0;
  public static final int b = q.a + 9;
  public static final int c = q.a + 10;
  @Deprecated
  public static final int d = q.a + 11;
  public static final int e = q.a + 13;
  public static final int f = q.a + 12;
  @Deprecated
  public static final int g = b;
  @Deprecated
  public static final int h = e;
  private pn A = null;
  private on B = null;
  private or C;
  private ob D;
  private boolean E = false;
  private nt F = null;
  private aj G;
  private af H = null;
  private final oo.a J = new ah.1(this);
  private nv i = null;
  private ox j = null;
  private ov k = null;
  private oh l = null;
  private of m = null;
  private oa n = null;
  private nz o = null;
  private po p = null;
  private os q;
  private oc r;
  private op s = null;
  private ag t = null;
  private ow u = null;
  private ou v = null;
  private og w = null;
  private oe x = null;
  private nx y = null;
  private ny z = null;
  
  protected ah()
  {
    this.i = new nv(null, null, null);
    this.F = new nt(this.i, b());
  }
  
  protected ah(af paramaf, Context paramContext, ai paramai)
  {
    lq.b(paramContext);
    lq.a(paramContext);
    my.a().a(paramContext);
    nb.a(paramContext);
    this.H = paramaf;
    this.i = new nv(this.H, paramContext, paramai);
    this.F = new nt(this.i, b());
    b().b();
    if (this.B == null)
    {
      this.i.a(this.J);
      this.B = new on(this.i.a());
    }
    nd.a(0, w.a(paramContext));
  }
  
  private void A()
  {
    if (this.B != null)
    {
      this.B.a();
      this.B = null;
    }
    if (this.A != null)
    {
      this.A.a();
      this.A = null;
    }
    if (this.y != null)
    {
      this.y.a();
      this.y = null;
    }
    if (this.x != null)
    {
      this.x.a();
      this.x = null;
    }
    if (this.w != null)
    {
      this.w.a();
      this.w = null;
    }
    if (this.v != null)
    {
      this.v.a();
      this.v = null;
    }
    if (this.C != null)
    {
      this.C.a();
      this.C = null;
    }
    if (this.z != null)
    {
      this.z.a();
      this.z = null;
    }
    if (this.D != null)
    {
      this.D.a();
      this.D = null;
    }
    if (this.u != null)
    {
      this.u.a();
      this.u = null;
    }
    if (this.t != null)
    {
      this.t.a();
      this.t = null;
    }
    if (this.s != null)
    {
      this.s.a();
      this.s = null;
    }
  }
  
  public static int a()
  {
    return I;
  }
  
  private void y()
  {
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    if (this.y == null)
    {
      if (this.n == null) {
        this.n = new oa(this.H, this.s.b());
      }
      this.y = new nx(this.n);
    }
    if (this.k == null) {
      this.k = new ov(this.s.b());
    }
    if (this.v == null) {
      this.v = new ou(this.k);
    }
    if (this.p == null) {
      this.p = new po(this.y, this.v, this.u);
    }
    if (this.A == null) {
      this.A = new pn(this.p);
    }
  }
  
  private void z()
  {
    if (this.p != null)
    {
      this.p.e();
      this.p = null;
    }
    if (this.n != null)
    {
      this.n.a();
      this.n = null;
    }
    if (this.m != null)
    {
      this.m.a();
      this.m = null;
    }
    if (this.l != null)
    {
      this.l.a();
      this.l = null;
    }
    if (this.k != null)
    {
      this.k.a();
      this.k = null;
    }
    if (this.i != null)
    {
      this.i.d();
      this.i = null;
    }
    if (this.q != null)
    {
      this.q.a();
      this.q = null;
    }
    if (this.o != null)
    {
      this.o.a();
      this.o = null;
    }
    if (this.r != null) {
      this.r.a();
    }
  }
  
  public final pv a(pw parampw)
  {
    if ((this.E) || (parampw == null)) {
      return null;
    }
    if (this.k == null) {
      this.k = new ov(this.s.b());
    }
    if (this.v == null) {
      this.v = new ou(this.k);
    }
    return this.v.a(parampw);
  }
  
  public final qf a(qg paramqg)
  {
    if ((this.E) || (paramqg == null)) {}
    do
    {
      return null;
      if (this.n != null) {
        break;
      }
    } while ((this.H == null) || (this.s == null));
    this.n = new oa(this.H, this.s.b());
    if (this.y == null) {
      this.y = new nx(this.n);
    }
    return this.y.a(paramqg, this.y);
  }
  
  public final qi a(qj paramqj)
  {
    if ((this.E) || (paramqj == null)) {
      return null;
    }
    if (this.m == null) {
      this.m = new of(this.s.b());
    }
    if (this.x == null) {
      this.x = new oe(this.m);
    }
    return this.x.a(paramqj);
  }
  
  public final qk a(ql paramql)
  {
    if (this.E) {}
    do
    {
      return null;
      if (this.l != null) {
        break;
      }
    } while (this.s == null);
    this.l = new oh(this.s.b());
    if (this.w == null) {
      this.w = new og(this.l);
    }
    return this.w.a(paramql);
  }
  
  public final String a(qc paramqc)
  {
    if (this.E) {
      return null;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.a(paramqc);
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  @Deprecated
  public final void a(int paramInt)
  {
    b(paramInt);
  }
  
  public final void a(ac paramac)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramac);
  }
  
  public final void a(ac paramac, long paramLong, a parama)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramac, paramLong, parama);
  }
  
  public final void a(ac paramac, a parama)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramac, 500L, parama);
  }
  
  public final void a(ah.b paramb)
  {
    if (this.E) {
      return;
    }
    if (this.n == null) {
      this.n = new oa(this.H, this.s.b());
    }
    if (this.y == null) {
      this.y = new nx(this.n);
    }
    this.y.a(paramb);
  }
  
  public final void a(ah.c paramc)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramc);
  }
  
  public final void a(ah.f paramf)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramf);
  }
  
  public final void a(ah.g paramg)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramg);
  }
  
  public final void a(ah.h paramh)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramh);
  }
  
  public final void a(ah.i parami)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(parami);
  }
  
  public final void a(ah.j paramj)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramj);
  }
  
  public final void a(ah.k paramk)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramk);
  }
  
  public final void a(ah.l paraml)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paraml);
  }
  
  public final void a(ah.m paramm)
  {
    if (this.E) {
      return;
    }
    if (this.n == null) {
      this.n = new oa(this.H, this.s.b());
    }
    if (this.y == null) {
      this.y = new nx(this.n);
    }
    this.y.a(paramm);
  }
  
  public final void a(ah.p paramp)
  {
    a(paramp, Bitmap.Config.ARGB_8888);
  }
  
  public final void a(ah.p paramp, Bitmap.Config paramConfig)
  {
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramp, paramConfig);
  }
  
  public final void a(qb paramqb)
  {
    ((ma)b().b()).getWorldMapOverlayManager().a(paramqb);
  }
  
  @Deprecated
  public final void a(qn paramqn)
  {
    b(paramqn);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramBoolean);
  }
  
  final op b()
  {
    if (this.s == null) {
      this.s = new op(this.i);
    }
    return this.s;
  }
  
  public final void b(int paramInt)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramInt);
  }
  
  public final void b(ac paramac)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramac, 500L, null);
  }
  
  public final void b(qn paramqn)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.a(paramqn);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.b(paramBoolean);
  }
  
  public final nv c()
  {
    return this.i;
  }
  
  public final void c(int paramInt)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.b(paramInt);
  }
  
  public final void c(qn paramqn)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.b(paramqn);
  }
  
  public final void c(boolean paramBoolean)
  {
    if (this.E) {}
    do
    {
      return;
      y();
      if (!paramBoolean)
      {
        this.A.d();
        return;
      }
    } while (j() == true);
    this.A.c();
  }
  
  public final pu d()
  {
    if (this.E) {
      return null;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.b();
  }
  
  protected final void d(boolean paramBoolean)
  {
    if ((this.E) || (this.i == null)) {
      return;
    }
    this.i.c(paramBoolean);
  }
  
  public final float e()
  {
    if (this.E) {
      return 0.0F;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.c();
  }
  
  public final void e(boolean paramBoolean)
  {
    if ((this.E) || (this.i == null)) {
      return;
    }
    this.i.a(paramBoolean, false);
  }
  
  public final float f()
  {
    if (this.E) {
      return 0.0F;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.d();
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.c(paramBoolean);
  }
  
  public final void g()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.e();
  }
  
  public final void g(boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.d(paramBoolean);
  }
  
  public final void h()
  {
    if (this.w != null) {
      this.w.b();
    }
    if (this.x != null) {
      this.x.b();
    }
    if (this.v != null) {
      this.v.b();
    }
    if (this.y != null) {
      this.y.b();
    }
    if (this.C != null) {
      this.C.b();
    }
  }
  
  public final void h(boolean paramBoolean)
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.e(paramBoolean);
  }
  
  public final boolean i()
  {
    if (this.E) {
      return false;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.f();
  }
  
  public final boolean j()
  {
    if (this.E) {
      return false;
    }
    y();
    return this.A.e();
  }
  
  public final Location k()
  {
    if (this.E) {
      return null;
    }
    y();
    return this.A.b();
  }
  
  public final aj l()
  {
    if (this.E) {
      return null;
    }
    if (this.G == null)
    {
      if (this.B == null) {
        this.B = new on(this.i.a());
      }
      this.G = new aj(this.B);
    }
    return this.G;
  }
  
  public final ag m()
  {
    if (this.E) {
      return null;
    }
    if (this.t == null) {
      this.t = new ag(this.i);
    }
    return this.t;
  }
  
  final void n()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.g();
  }
  
  final void o()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.h();
  }
  
  final void p()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.i();
  }
  
  final void q()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.j();
  }
  
  final void r()
  {
    if (this.E) {
      return;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    this.u.k();
  }
  
  final void s()
  {
    if (this.E) {
      return;
    }
    if (this.u != null) {
      this.u.l();
    }
    A();
    z();
    this.E = true;
  }
  
  public final af t()
  {
    return this.H;
  }
  
  public final String u()
  {
    if (this.E) {
      return "";
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.m();
  }
  
  public final int v()
  {
    if (this.E) {
      return -1;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.n();
  }
  
  public final String[] w()
  {
    if (this.E) {
      return null;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.o();
  }
  
  public final boolean x()
  {
    if (this.E) {
      return false;
    }
    if (this.u == null) {
      this.u = new ow(this.i);
    }
    return this.u.p();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ah
 * JD-Core Version:    0.7.0.1
 */