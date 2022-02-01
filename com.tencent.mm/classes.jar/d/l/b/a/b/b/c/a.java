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
  private final d.l.b.a.b.f.f JsQ;
  protected final d.l.b.a.b.l.f<aj> JsR;
  private final d.l.b.a.b.l.f<h> JsS;
  private final d.l.b.a.b.l.f<ak> JsT;
  
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
    this.JsQ = paramf;
    this.JsR = parami.H(new d.g.a.a() {});
    this.JsS = parami.H(new d.g.a.a() {});
    this.JsT = parami.H(new d.g.a.a() {});
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      adP(14);
    }
    paramay = a(paramay, d.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      adP(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, d.l.b.a.b.m.a.i parami)
  {
    if (paramay == null) {
      adP(9);
    }
    if (parami == null) {
      adP(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        adP(11);
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
  
  public final aj fyA()
  {
    aj localaj = (aj)this.JsR.invoke();
    if (localaj == null) {
      adP(19);
    }
    return localaj;
  }
  
  public final d.l.b.a.b.f.f fyB()
  {
    d.l.b.a.b.f.f localf = this.JsQ;
    if (localf == null) {
      adP(2);
    }
    return localf;
  }
  
  public h fyF()
  {
    h localh = a(d.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      adP(16);
    }
    return localh;
  }
  
  public h fyG()
  {
    h localh = (h)this.JsS.invoke();
    if (localh == null) {
      adP(4);
    }
    return localh;
  }
  
  public final ak fyH()
  {
    ak localak = (ak)this.JsT.invoke();
    if (localak == null) {
      adP(5);
    }
    return localak;
  }
  
  public final e fyI()
  {
    if (this == null) {
      adP(3);
    }
    return this;
  }
  
  public e g(ba paramba)
  {
    if (paramba == null) {
      adP(17);
    }
    if (paramba.Jud.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */