package d.l.b.a.b.b.c;

import d.g.a.b;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.n;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.j.f.l;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.ba;

public abstract class a
  extends t
{
  private final d.l.b.a.b.f.f Lgj;
  protected final d.l.b.a.b.l.f<aj> Lgk;
  private final d.l.b.a.b.l.f<h> Lgl;
  private final d.l.b.a.b.l.f<ak> Lgm;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(d.l.b.a.b.l.i parami, d.l.b.a.b.f.f paramf)
  {
    this.Lgj = paramf;
    this.Lgk = parami.O(new d.g.a.a() {});
    this.Lgl = parami.O(new d.g.a.a() {});
    this.Lgm = parami.O(new d.g.a.a() {});
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      agL(14);
    }
    paramay = a(paramay, d.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      agL(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, d.l.b.a.b.m.a.i parami)
  {
    if (paramay == null) {
      agL(9);
    }
    if (parami == null) {
      agL(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        agL(11);
      }
      return paramay;
    }
    paramay = ba.d(paramay);
    return new l(a(parami), paramay);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final aj fRe()
  {
    aj localaj = (aj)this.Lgk.invoke();
    if (localaj == null) {
      agL(19);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.f.f fRf()
  {
    d.l.b.a.b.f.f localf = this.Lgj;
    if (localf == null) {
      agL(2);
    }
    return localf;
  }
  
  public h fRj()
  {
    h localh = a(d.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      agL(16);
    }
    return localh;
  }
  
  public h fRk()
  {
    h localh = (h)this.Lgl.invoke();
    if (localh == null) {
      agL(4);
    }
    return localh;
  }
  
  public final ak fRl()
  {
    ak localak = (ak)this.Lgm.invoke();
    if (localak == null) {
      agL(5);
    }
    return localak;
  }
  
  public final e fRm()
  {
    if (this == null) {
      agL(3);
    }
    return this;
  }
  
  public e g(ba paramba)
  {
    if (paramba == null) {
      agL(17);
    }
    if (paramba.Lhw.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */