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
  private final kotlin.l.b.a.b.f.f TjT;
  protected final kotlin.l.b.a.b.l.f<aj> TjU;
  private final kotlin.l.b.a.b.l.f<h> TjV;
  private final kotlin.l.b.a.b.l.f<ak> TjW;
  
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
    this.TjT = paramf;
    this.TjU = paramj.al(new kotlin.g.a.a() {});
    this.TjV = paramj.al(new kotlin.g.a.a() {});
    this.TjW = paramj.al(new kotlin.g.a.a() {});
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final h a(ay paramay)
  {
    if (paramay == null) {
      atM(14);
    }
    paramay = a(paramay, kotlin.l.b.a.b.j.d.a.d(c.s(this)));
    if (paramay == null) {
      atM(15);
    }
    return paramay;
  }
  
  public h a(ay paramay, i parami)
  {
    if (paramay == null) {
      atM(9);
    }
    if (parami == null) {
      atM(10);
    }
    if (paramay.isEmpty())
    {
      paramay = a(parami);
      if (paramay == null) {
        atM(11);
      }
      return paramay;
    }
    paramay = ba.d(paramay);
    return new l(a(parami), paramay);
  }
  
  public e g(ba paramba)
  {
    if (paramba == null) {
      atM(17);
    }
    if (paramba.Tlg.isEmpty()) {
      return this;
    }
    return new s(this, paramba);
  }
  
  public final aj hAG()
  {
    aj localaj = (aj)this.TjU.invoke();
    if (localaj == null) {
      atM(19);
    }
    return localaj;
  }
  
  public final kotlin.l.b.a.b.f.f hAH()
  {
    kotlin.l.b.a.b.f.f localf = this.TjT;
    if (localf == null) {
      atM(2);
    }
    return localf;
  }
  
  public h hAM()
  {
    h localh = a(kotlin.l.b.a.b.j.d.a.d(c.s(this)));
    if (localh == null) {
      atM(16);
    }
    return localh;
  }
  
  public h hAN()
  {
    h localh = (h)this.TjV.invoke();
    if (localh == null) {
      atM(4);
    }
    return localh;
  }
  
  public final ak hAO()
  {
    ak localak = (ak)this.TjW.invoke();
    if (localak == null) {
      atM(5);
    }
    return localak;
  }
  
  public final e hAP()
  {
    if (this == null) {
      atM(3);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */