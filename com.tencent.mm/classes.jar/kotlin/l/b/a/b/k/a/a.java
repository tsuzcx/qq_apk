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
  private final kotlin.l.b.a.b.l.j aaFH;
  private final y aaIY;
  protected l aaYm;
  private final d<kotlin.l.b.a.b.f.b, ab> abmT;
  private final u abmU;
  
  public a(kotlin.l.b.a.b.l.j paramj, u paramu, y paramy)
  {
    this.aaFH = paramj;
    this.abmU = paramu;
    this.aaIY = paramy;
    this.abmT = this.aaFH.al((kotlin.g.a.b)new a(this));
  }
  
  public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b paramb, kotlin.g.a.b<? super f, Boolean> paramb1)
  {
    kotlin.g.b.p.k(paramb, "fqName");
    kotlin.g.b.p.k(paramb1, "nameFilter");
    return (Collection)x.aaAf;
  }
  
  protected final void a(l paraml)
  {
    kotlin.g.b.p.k(paraml, "<set-?>");
    this.aaYm = paraml;
  }
  
  protected abstract p d(kotlin.l.b.a.b.f.b paramb);
  
  public final List<ab> f(kotlin.l.b.a.b.f.b paramb)
  {
    kotlin.g.b.p.k(paramb, "fqName");
    return kotlin.a.j.eY(this.abmT.invoke(paramb));
  }
  
  protected final kotlin.l.b.a.b.l.j iEV()
  {
    return this.aaFH;
  }
  
  protected final l iIC()
  {
    l locall = this.aaYm;
    if (locall == null) {
      kotlin.g.b.p.bGy("components");
    }
    return locall;
  }
  
  protected final u iPs()
  {
    return this.abmU;
  }
  
  protected final y iPt()
  {
    return this.aaIY;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */