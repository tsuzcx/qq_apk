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
  public final b TiI;
  
  public y(kotlin.l.b.a.b.b.y paramy, b paramb)
  {
    super(paramy, g.a.hBP(), paramb.hJh(), an.ThK);
    this.TiI = paramb;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    p.h(paramn, "visitor");
    return paramn.a((ab)this, paramD);
  }
  
  public final kotlin.l.b.a.b.b.y hBj()
  {
    l locall = super.hzx();
    if (locall == null) {
      throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }
    return (kotlin.l.b.a.b.b.y)locall;
  }
  
  public final b hBk()
  {
    return this.TiI;
  }
  
  public an hzM()
  {
    an localan = an.ThK;
    p.g(localan, "SourceElement.NO_SOURCE");
    return localan;
  }
  
  public String toString()
  {
    return "package " + this.TiI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.y
 * JD-Core Version:    0.7.0.1
 */