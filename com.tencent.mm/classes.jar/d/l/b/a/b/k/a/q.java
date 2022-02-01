package d.l.b.a.b.k.a;

import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.a.l;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.d;
import d.l.b.a.b.j.f.h;
import d.l.b.a.b.k.a.b.i;
import d.l.b.a.b.l.j;
import java.util.List;

public abstract class q
  extends p
{
  private final d.l.b.a.b.k.a.b.f NyY;
  private final d NyZ;
  private final d.l.b.a.b.e.b.a Nyy;
  final y Nza;
  private a.l Nzb;
  private h Nzc;
  
  public q(d.l.b.a.b.f.b paramb, j paramj, d.l.b.a.b.b.y paramy, a.l paraml, d.l.b.a.b.e.b.a parama)
  {
    super(paramb, paramj, paramy);
    this.Nyy = parama;
    this.NyY = null;
    paramb = paraml.Nmh;
    d.g.b.p.g(paramb, "proto.strings");
    paramj = paraml.Nmi;
    d.g.b.p.g(paramj, "proto.qualifiedNames");
    this.NyZ = new d(paramb, paramj);
    this.Nza = new y(paraml, (c)this.NyZ, this.Nyy, (d.g.a.b)new a(this));
    this.Nzb = paraml;
  }
  
  public final void b(l paraml)
  {
    d.g.b.p.h(paraml, "components");
    Object localObject = this.Nzb;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.Nzb = null;
    ab localab = (ab)this;
    localObject = ((a.l)localObject).Nmj;
    d.g.b.p.g(localObject, "proto.`package`");
    this.Nzc = ((h)new i(localab, (a.k)localObject, (c)this.NyZ, this.Nyy, this.NyY, paraml, (d.g.a.a)new b(this)));
  }
  
  public final h gil()
  {
    h localh = this.Nzc;
    if (localh == null) {
      d.g.b.p.bcb("_memberScope");
    }
    return localh;
  }
  
  static final class a
    extends d.g.b.q
    implements d.g.a.b<d.l.b.a.b.f.a, an>
  {
    a(q paramq)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.q
    implements d.g.a.a<List<? extends d.l.b.a.b.f.f>>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.q
 * JD-Core Version:    0.7.0.1
 */