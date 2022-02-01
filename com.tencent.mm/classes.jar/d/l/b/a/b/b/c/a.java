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
  private final d.l.b.a.b.f.f MXf;
  protected final d.l.b.a.b.l.f<aj> MXg;
  private final d.l.b.a.b.l.f<h> MXh;
  private final d.l.b.a.b.l.f<ak> MXi;
  
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
    this.MXf = paramf;
    this.MXg = paramj.S(new d.g.a.a() {});
    this.MXh = paramj.S(new d.g.a.a() {});
    this.MXi = paramj.S(new d.g.a.a() {});
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      ajm(14);
    }
    paramay = a(paramay, d.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      ajm(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, i parami)
  {
    if (paramay == null) {
      ajm(9);
    }
    if (parami == null) {
      ajm(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        ajm(11);
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
      ajm(17);
    }
    if (paramba.MYs.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
  
  public final aj giC()
  {
    aj localaj = (aj)this.MXg.invoke();
    if (localaj == null) {
      ajm(19);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.f.f giD()
  {
    d.l.b.a.b.f.f localf = this.MXf;
    if (localf == null) {
      ajm(2);
    }
    return localf;
  }
  
  public h giI()
  {
    h localh = a(d.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      ajm(16);
    }
    return localh;
  }
  
  public h giJ()
  {
    h localh = (h)this.MXh.invoke();
    if (localh == null) {
      ajm(4);
    }
    return localh;
  }
  
  public final ak giK()
  {
    ak localak = (ak)this.MXi.invoke();
    if (localak == null) {
      ajm(5);
    }
    return localak;
  }
  
  public final e giL()
  {
    if (this == null) {
      ajm(3);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */