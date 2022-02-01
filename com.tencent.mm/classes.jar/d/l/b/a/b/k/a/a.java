package d.l.b.a.b.k.a;

import d.a.x;
import d.g.b.q;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ac;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.d;
import java.util.Collection;
import java.util.List;

public abstract class a
  implements ac
{
  protected l NFN;
  private final d<d.l.b.a.b.f.b, ab> NVu;
  protected final u NVv;
  protected final d.l.b.a.b.l.j Nnf;
  protected final y Nqw;
  
  public a(d.l.b.a.b.l.j paramj, u paramu, y paramy)
  {
    this.Nnf = paramj;
    this.NVv = paramu;
    this.Nqw = paramy;
    this.NVu = this.Nnf.M((d.g.a.b)new a(this));
  }
  
  public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramb, d.g.a.b<? super f, Boolean> paramb1)
  {
    d.g.b.p.h(paramb, "fqName");
    d.g.b.p.h(paramb1, "nameFilter");
    return (Collection)x.NhJ;
  }
  
  protected final void a(l paraml)
  {
    d.g.b.p.h(paraml, "<set-?>");
    this.NFN = paraml;
  }
  
  protected abstract p d(d.l.b.a.b.f.b paramb);
  
  public final List<ab> f(d.l.b.a.b.f.b paramb)
  {
    d.g.b.p.h(paramb, "fqName");
    return d.a.j.eP(this.NVu.invoke(paramb));
  }
  
  protected final l gqF()
  {
    l locall = this.NFN;
    if (locall == null) {
      d.g.b.p.bdF("components");
    }
    return locall;
  }
  
  static final class a
    extends q
    implements d.g.a.b<d.l.b.a.b.f.b, p>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */