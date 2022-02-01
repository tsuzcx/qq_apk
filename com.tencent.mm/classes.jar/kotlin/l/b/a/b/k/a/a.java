package kotlin.l.b.a.b.k.a;

import java.util.Collection;
import java.util.List;
import kotlin.a.ad;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.g;
import kotlin.l.b.a.b.l.m;

public abstract class a
  implements ak
{
  private final m aiBu;
  private final ae aiFr;
  protected j aiWx;
  private final t ajlC;
  private final g<c, ah> ajlD;
  
  public a(m paramm, t paramt, ae paramae)
  {
    this.aiBu = paramm;
    this.ajlC = paramt;
    this.aiFr = paramae;
    this.ajlD = this.aiBu.be((b)new a(this));
  }
  
  public final Collection<c> a(c paramc, b<? super f, Boolean> paramb)
  {
    s.u(paramc, "fqName");
    s.u(paramb, "nameFilter");
    return (Collection)ad.aivA;
  }
  
  public final void a(c paramc, Collection<ah> paramCollection)
  {
    s.u(paramc, "fqName");
    s.u(paramCollection, "packageFragments");
    kotlin.l.b.a.b.o.a.c(paramCollection, this.ajlD.invoke(paramc));
  }
  
  protected final void a(j paramj)
  {
    s.u(paramj, "<set-?>");
    this.aiWx = paramj;
  }
  
  protected abstract o d(c paramc);
  
  public final List<ah> f(c paramc)
  {
    s.u(paramc, "fqName");
    return p.hs(this.ajlD.invoke(paramc));
  }
  
  public final boolean g(c paramc)
  {
    s.u(paramc, "fqName");
    if (this.ajlD.ik(paramc)) {}
    for (paramc = (ah)this.ajlD.invoke(paramc); paramc == null; paramc = (ah)d(paramc)) {
      return true;
    }
    return false;
  }
  
  protected final m kol()
  {
    return this.aiBu;
  }
  
  protected final j ksJ()
  {
    j localj = this.aiWx;
    if (localj != null) {
      return localj;
    }
    s.bIx("components");
    return null;
  }
  
  protected final t kzN()
  {
    return this.ajlC;
  }
  
  protected final ae kzO()
  {
    return this.aiFr;
  }
  
  static final class a
    extends u
    implements b<c, ah>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a
 * JD-Core Version:    0.7.0.1
 */