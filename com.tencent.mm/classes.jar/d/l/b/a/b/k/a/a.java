package d.l.b.a.b.k.a;

import d.a.j;
import d.a.x;
import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.d;
import d.l.b.a.b.l.i;
import java.util.Collection;
import java.util.List;

public abstract class a
  implements ac
{
  protected l JEr;
  private final d<d.l.b.a.b.f.b, ab> JTW;
  protected final u JTX;
  protected final i JlL;
  protected final y Jpd;
  
  public a(i parami, u paramu, y paramy)
  {
    this.JlL = parami;
    this.JTX = paramu;
    this.Jpd = paramy;
    this.JTW = this.JlL.B((d.g.a.b)new a(this));
  }
  
  public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramb, d.g.a.b<? super f, Boolean> paramb1)
  {
    k.h(paramb, "fqName");
    k.h(paramb1, "nameFilter");
    return (Collection)x.Jgn;
  }
  
  protected final void a(l paraml)
  {
    k.h(paraml, "<set-?>");
    this.JEr = paraml;
  }
  
  protected abstract p d(d.l.b.a.b.f.b paramb);
  
  public final List<ab> f(d.l.b.a.b.f.b paramb)
  {
    k.h(paramb, "fqName");
    return j.eG(this.JTW.aA(paramb));
  }
  
  protected final l fCa()
  {
    l locall = this.JEr;
    if (locall == null) {
      k.aPZ("components");
    }
    return locall;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.b, p>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */