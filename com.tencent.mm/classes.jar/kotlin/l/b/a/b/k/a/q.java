package kotlin.l.b.a.b.k.a;

import java.util.List;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.e.a.k;
import kotlin.l.b.a.b.e.a.l;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.d;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.k.a.b.i;
import kotlin.l.b.a.b.l.j;

public abstract class q
  extends p
{
  private final kotlin.l.b.a.b.e.b.a TKB;
  private final kotlin.l.b.a.b.k.a.b.f TLb;
  private final d TLc;
  final y TLd;
  private a.l TLe;
  private h TLf;
  
  public q(kotlin.l.b.a.b.f.b paramb, j paramj, kotlin.l.b.a.b.b.y paramy, a.l paraml, kotlin.l.b.a.b.e.b.a parama)
  {
    super(paramb, paramj, paramy);
    this.TKB = parama;
    this.TLb = null;
    paramb = paraml.TyP;
    kotlin.g.b.p.g(paramb, "proto.strings");
    paramj = paraml.TyQ;
    kotlin.g.b.p.g(paramj, "proto.qualifiedNames");
    this.TLc = new d(paramb, paramj);
    this.TLd = new y(paraml, (c)this.TLc, this.TKB, (kotlin.g.a.b)new a(this));
    this.TLe = paraml;
  }
  
  public final void b(l paraml)
  {
    kotlin.g.b.p.h(paraml, "components");
    Object localObject = this.TLe;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.TLe = null;
    ab localab = (ab)this;
    localObject = ((a.l)localObject).TyR;
    kotlin.g.b.p.g(localObject, "proto.`package`");
    this.TLf = ((h)new i(localab, (a.k)localObject, (c)this.TLc, this.TKB, this.TLb, paraml, (kotlin.g.a.a)new b(this)));
  }
  
  public final h hAp()
  {
    h localh = this.TLf;
    if (localh == null) {
      kotlin.g.b.p.btv("_memberScope");
    }
    return localh;
  }
  
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<kotlin.l.b.a.b.f.a, an>
  {
    a(q paramq)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.f>>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.q
 * JD-Core Version:    0.7.0.1
 */