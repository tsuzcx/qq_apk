package kotlin.l.b.a.b.b.c;

import kotlin.g.a.b;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.l;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ba;

public abstract class a
  extends t
{
  private final kotlin.l.b.a.b.f.f aaMN;
  protected final kotlin.l.b.a.b.l.f<aj> aaMO;
  private final kotlin.l.b.a.b.l.f<h> aaMP;
  private final kotlin.l.b.a.b.l.f<ak> aaMQ;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(j paramj, kotlin.l.b.a.b.f.f paramf)
  {
    this.aaMN = paramf;
    this.aaMO = paramj.av(new kotlin.g.a.a() {});
    this.aaMP = paramj.av(new kotlin.g.a.a() {});
    this.aaMQ = paramj.av(new kotlin.g.a.a() {});
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      aDG(14);
    }
    paramay = a(paramay, kotlin.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      aDG(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, i parami)
  {
    if (paramay == null) {
      aDG(9);
    }
    if (parami == null) {
      aDG(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        aDG(11);
      }
      return paramay;
    }
    paramay = ba.d(paramay);
    return new l(a(parami), paramay);
  }
  
  public e g(ba paramba)
  {
    if (paramba == null) {
      aDG(17);
    }
    if (paramba.aaOa.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
  
  public final aj iET()
  {
    aj localaj = (aj)this.aaMO.invoke();
    if (localaj == null) {
      aDG(19);
    }
    return localaj;
  }
  
  public final kotlin.l.b.a.b.f.f iEU()
  {
    kotlin.l.b.a.b.f.f localf = this.aaMN;
    if (localf == null) {
      aDG(2);
    }
    return localf;
  }
  
  public h iEZ()
  {
    h localh = a(kotlin.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      aDG(16);
    }
    return localh;
  }
  
  public h iFa()
  {
    h localh = (h)this.aaMP.invoke();
    if (localh == null) {
      aDG(4);
    }
    return localh;
  }
  
  public final ak iFb()
  {
    ak localak = (ak)this.aaMQ.invoke();
    if (localak == null) {
      aDG(5);
    }
    return localak;
  }
  
  public final e iFc()
  {
    if (this == null) {
      aDG(3);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */