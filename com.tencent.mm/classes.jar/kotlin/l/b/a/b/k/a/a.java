package kotlin.l.b.a.b.k.a;

import java.util.Collection;
import java.util.List;
import kotlin.a.x;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.d;

public abstract class a
  implements ac
{
  private final d<kotlin.l.b.a.b.f.b, ab> TKq;
  protected final u TKr;
  protected final kotlin.l.b.a.b.l.j TcN;
  protected final y Tge;
  protected l Tvt;
  
  public a(kotlin.l.b.a.b.l.j paramj, u paramu, y paramy)
  {
    this.TcN = paramj;
    this.TKr = paramu;
    this.Tge = paramy;
    this.TKq = this.TcN.V((kotlin.g.a.b)new a(this));
  }
  
  public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramb, kotlin.g.a.b<? super f, Boolean> paramb1)
  {
    kotlin.g.b.p.h(paramb, "fqName");
    kotlin.g.b.p.h(paramb1, "nameFilter");
    return (Collection)x.SXt;
  }
  
  protected final void a(l paraml)
  {
    kotlin.g.b.p.h(paraml, "<set-?>");
    this.Tvt = paraml;
  }
  
  protected abstract p d(kotlin.l.b.a.b.f.b paramb);
  
  public final List<ab> f(kotlin.l.b.a.b.f.b paramb)
  {
    kotlin.g.b.p.h(paramb, "fqName");
    return kotlin.a.j.eR(this.TKq.invoke(paramb));
  }
  
  protected final l hEh()
  {
    l locall = this.Tvt;
    if (locall == null) {
      kotlin.g.b.p.btv("components");
    }
    return locall;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, p>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */