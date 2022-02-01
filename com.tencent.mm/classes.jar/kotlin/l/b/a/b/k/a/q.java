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
  private final kotlin.l.b.a.b.k.a.b.f abnE;
  private final d abnF;
  final y abnG;
  private a.l abnH;
  private h abnI;
  private final kotlin.l.b.a.b.e.b.a abne;
  
  public q(kotlin.l.b.a.b.f.b paramb, j paramj, kotlin.l.b.a.b.b.y paramy, a.l paraml, kotlin.l.b.a.b.e.b.a parama)
  {
    super(paramb, paramj, paramy);
    this.abne = parama;
    this.abnE = null;
    paramb = paraml.abbG;
    kotlin.g.b.p.j(paramb, "proto.strings");
    paramj = paraml.abbH;
    kotlin.g.b.p.j(paramj, "proto.qualifiedNames");
    this.abnF = new d(paramb, paramj);
    this.abnG = new y(paraml, (c)this.abnF, this.abne, (kotlin.g.a.b)new a(this));
    this.abnH = paraml;
  }
  
  public final void b(l paraml)
  {
    kotlin.g.b.p.k(paraml, "components");
    Object localObject = this.abnH;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.abnH = null;
    ab localab = (ab)this;
    localObject = ((a.l)localObject).abbI;
    kotlin.g.b.p.j(localObject, "proto.`package`");
    this.abnI = ((h)new i(localab, (a.k)localObject, (c)this.abnF, this.abne, this.abnE, paraml, (kotlin.g.a.a)new b(this)));
  }
  
  public final h iEC()
  {
    h localh = this.abnI;
    if (localh == null) {
      kotlin.g.b.p.bGy("_memberScope");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.q
 * JD-Core Version:    0.7.0.1
 */