package d.l.b.a.b.b.c;

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
  public final b LeZ;
  
  public y(d.l.b.a.b.b.y paramy, b paramb)
  {
    super(paramy, g.a.fSm(), paramb.fZJ(), an.Lec);
    this.LeZ = paramb;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    d.g.b.k.h(paramn, "visitor");
    return paramn.a((ab)this, paramD);
  }
  
  public an fQk()
  {
    an localan = an.Lec;
    d.g.b.k.g(localan, "SourceElement.NO_SOURCE");
    return localan;
  }
  
  public final d.l.b.a.b.b.y fRG()
  {
    l locall = super.fPU();
    if (locall == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }
    return (d.l.b.a.b.b.y)locall;
  }
  
  public final b fRH()
  {
    return this.LeZ;
  }
  
  public String toString()
  {
    return "package " + this.LeZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.c.y
 * JD-Core Version:    0.7.0.1
 */