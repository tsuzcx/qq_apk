package d.l.b.a.b.b.c;

import d.g.b.p;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.an;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.n;
import d.l.b.a.b.f.b;
import d.v;

public abstract class y
  extends k
  implements ab
{
  public final b MVU;
  
  public y(d.l.b.a.b.b.y paramy, b paramb)
  {
    super(paramy, g.a.gjL(), paramb.gri(), an.MUX);
    this.MVU = paramb;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    p.h(paramn, "visitor");
    return paramn.a((ab)this, paramD);
  }
  
  public an ghI()
  {
    an localan = an.MUX;
    p.g(localan, "SourceElement.NO_SOURCE");
    return localan;
  }
  
  public final d.l.b.a.b.b.y gjf()
  {
    l locall = super.ghs();
    if (locall == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }
    return (d.l.b.a.b.b.y)locall;
  }
  
  public final b gjg()
  {
    return this.MVU;
  }
  
  public String toString()
  {
    return "package " + this.MVU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.c.y
 * JD-Core Version:    0.7.0.1
 */