package kotlin.l.b.a.b.b.c;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.f.b;
import kotlin.t;

public abstract class y
  extends k
  implements ab
{
  public final b aaLC;
  
  public y(kotlin.l.b.a.b.b.y paramy, b paramb)
  {
    super(paramy, g.a.iGe(), paramb.iNB(), an.aaKE);
    this.aaLC = paramb;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    p.k(paramn, "visitor");
    return paramn.a((ab)this, paramD);
  }
  
  public an iDZ()
  {
    an localan = an.aaKE;
    p.j(localan, "SourceElement.NO_SOURCE");
    return localan;
  }
  
  public final kotlin.l.b.a.b.b.y iFx()
  {
    l locall = super.iDJ();
    if (locall == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }
    return (kotlin.l.b.a.b.b.y)locall;
  }
  
  public final b iFy()
  {
    return this.aaLC;
  }
  
  public String toString()
  {
    return "package " + this.aaLC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.y
 * JD-Core Version:    0.7.0.1
 */