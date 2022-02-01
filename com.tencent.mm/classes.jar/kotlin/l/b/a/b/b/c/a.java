package kotlin.l.b.a.b.b.c;

import kotlin.g.a.b;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;

public abstract class a
  extends t
{
  private final kotlin.l.b.a.b.l.h<kotlin.l.b.a.b.j.g.h> aiJA;
  private final kotlin.l.b.a.b.l.h<as> aiJB;
  private final f aiJy;
  protected final kotlin.l.b.a.b.l.h<al> aiJz;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(kotlin.l.b.a.b.l.m paramm, f paramf)
  {
    this.aiJy = paramf;
    this.aiJz = paramm.cq(new kotlin.g.a.a() {});
    this.aiJA = paramm.cq(new kotlin.g.a.a() {});
    this.aiJB = paramm.cq(new kotlin.g.a.a() {});
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final kotlin.l.b.a.b.j.g.h a(bc parambc)
  {
    if (parambc == null) {
      aKu(14);
    }
    parambc = a(parambc, kotlin.l.b.a.b.j.d.a.e(d.s(this)));
    if (parambc == null) {
      aKu(15);
    }
    return parambc;
  }
  
  public kotlin.l.b.a.b.j.g.h a(bc parambc, g paramg)
  {
    if (parambc == null) {
      aKu(9);
    }
    if (paramg == null) {
      aKu(10);
    }
    if (parambc.isEmpty())
    {
      parambc = a(paramg);
      if (parambc == null) {
        aKu(11);
      }
      return parambc;
    }
    parambc = be.d(parambc);
    return new kotlin.l.b.a.b.j.g.m(a(paramg), parambc);
  }
  
  public e g(be parambe)
  {
    if (parambe == null) {
      aKu(17);
    }
    if (parambe.aiKL.isEmpty()) {
      return this;
    }
    return new s(this, parambe);
  }
  
  public final al koj()
  {
    al localal = (al)this.aiJz.invoke();
    if (localal == null) {
      aKu(19);
    }
    return localal;
  }
  
  public final f kok()
  {
    f localf = this.aiJy;
    if (localf == null) {
      aKu(2);
    }
    return localf;
  }
  
  public kotlin.l.b.a.b.j.g.h kot()
  {
    kotlin.l.b.a.b.j.g.h localh = a(kotlin.l.b.a.b.j.d.a.e(d.s(this)));
    if (localh == null) {
      aKu(16);
    }
    return localh;
  }
  
  public kotlin.l.b.a.b.j.g.h kou()
  {
    kotlin.l.b.a.b.j.g.h localh = (kotlin.l.b.a.b.j.g.h)this.aiJA.invoke();
    if (localh == null) {
      aKu(4);
    }
    return localh;
  }
  
  public final as kov()
  {
    as localas = (as)this.aiJB.invoke();
    if (localas == null) {
      aKu(5);
    }
    return localas;
  }
  
  public final e kow()
  {
    if (this == null) {
      aKu(3);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */