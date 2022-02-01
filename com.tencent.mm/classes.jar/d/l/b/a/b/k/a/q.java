package d.l.b.a.b.k.a;

import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.an;
import d.l.b.a.b.e.a.k;
import d.l.b.a.b.e.a.l;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.b.d;
import d.l.b.a.b.j.f.h;
import java.util.List;

public abstract class q
  extends p
{
  private final d.l.b.a.b.e.b.a LHA;
  private final d.l.b.a.b.k.a.b.f LIa;
  private final d LIb;
  final y LIc;
  private a.l LId;
  private h LIe;
  
  public q(d.l.b.a.b.f.b paramb, d.l.b.a.b.l.i parami, d.l.b.a.b.b.y paramy, a.l paraml, d.l.b.a.b.e.b.a parama)
  {
    super(paramb, parami, paramy);
    this.LHA = parama;
    this.LIa = null;
    paramb = paraml.Lvk;
    k.g(paramb, "proto.strings");
    parami = paraml.Lvl;
    k.g(parami, "proto.qualifiedNames");
    this.LIb = new d(paramb, parami);
    this.LIc = new y(paraml, (c)this.LIb, this.LHA, (d.g.a.b)new a(this));
    this.LId = paraml;
  }
  
  public final void b(l paraml)
  {
    k.h(paraml, "components");
    Object localObject = this.LId;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.LId = null;
    ab localab = (ab)this;
    localObject = ((a.l)localObject).Lvm;
    k.g(localObject, "proto.`package`");
    this.LIe = ((h)new d.l.b.a.b.k.a.b.i(localab, (a.k)localObject, (c)this.LIb, this.LHA, this.LIa, paraml, (d.g.a.a)new b(this)));
  }
  
  public final h fQN()
  {
    h localh = this.LIe;
    if (localh == null) {
      k.aVY("_memberScope");
    }
    return localh;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.f.a, an>
  {
    a(q paramq)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<List<? extends d.l.b.a.b.f.f>>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.k.a.q
 * JD-Core Version:    0.7.0.1
 */