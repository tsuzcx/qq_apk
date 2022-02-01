package d.l.b.a.b.b.c;

import d.g.a.b;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.n;
import d.l.b.a.b.j.c;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.j.f.l;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.a.i;
import d.l.b.a.b.m.aj;
import d.l.b.a.b.m.ay;
import d.l.b.a.b.m.ba;

public abstract class a
  extends t
{
  private final d.l.b.a.b.f.f Nul;
  protected final d.l.b.a.b.l.f<aj> Num;
  private final d.l.b.a.b.l.f<h> Nun;
  private final d.l.b.a.b.l.f<ak> Nuo;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(j paramj, d.l.b.a.b.f.f paramf)
  {
    this.Nul = paramf;
    this.Num = paramj.S(new d.g.a.a() {});
    this.Nun = paramj.S(new d.g.a.a() {});
    this.Nuo = paramj.S(new d.g.a.a() {});
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      ajW(14);
    }
    paramay = a(paramay, d.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      ajW(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, i parami)
  {
    if (paramay == null) {
      ajW(9);
    }
    if (parami == null) {
      ajW(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        ajW(11);
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
  
  public e g(ba paramba)
  {
    if (paramba == null) {
      ajW(17);
    }
    if (paramba.Nvy.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
  
  public final aj gne()
  {
    aj localaj = (aj)this.Num.invoke();
    if (localaj == null) {
      ajW(19);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.f.f gnf()
  {
    d.l.b.a.b.f.f localf = this.Nul;
    if (localf == null) {
      ajW(2);
    }
    return localf;
  }
  
  public h gnk()
  {
    h localh = a(d.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      ajW(16);
    }
    return localh;
  }
  
  public h gnl()
  {
    h localh = (h)this.Nun.invoke();
    if (localh == null) {
      ajW(4);
    }
    return localh;
  }
  
  public final ak gnm()
  {
    ak localak = (ak)this.Nuo.invoke();
    if (localak == null) {
      ajW(5);
    }
    return localak;
  }
  
  public final e gnn()
  {
    if (this == null) {
      ajW(3);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */