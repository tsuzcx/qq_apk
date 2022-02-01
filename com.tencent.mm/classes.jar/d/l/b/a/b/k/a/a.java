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
  protected final i KZf;
  private final d<d.l.b.a.b.f.b, ab> LHp;
  protected final u LHq;
  protected final y Lcw;
  protected l LrK;
  
  public a(i parami, u paramu, y paramy)
  {
    this.KZf = parami;
    this.LHq = paramu;
    this.Lcw = paramy;
    this.LHp = this.KZf.J((d.g.a.b)new a(this));
  }
  
  public final Collection<d.l.b.a.b.f.b> a(d.l.b.a.b.f.b paramb, d.g.a.b<? super f, Boolean> paramb1)
  {
    k.h(paramb, "fqName");
    k.h(paramb1, "nameFilter");
    return (Collection)x.KTH;
  }
  
  protected final void a(l paraml)
  {
    k.h(paraml, "<set-?>");
    this.LrK = paraml;
  }
  
  protected abstract p d(d.l.b.a.b.f.b paramb);
  
  public final List<ab> f(d.l.b.a.b.f.b paramb)
  {
    k.h(paramb, "fqName");
    return j.eJ(this.LHp.ay(paramb));
  }
  
  protected final l fUE()
  {
    l locall = this.LrK;
    if (locall == null) {
      k.aVY("components");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */