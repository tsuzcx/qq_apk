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
  private final d.l.b.a.b.k.a.b.f JUH;
  private final d JUI;
  final y JUJ;
  private a.l JUK;
  private h JUL;
  private final d.l.b.a.b.e.b.a JUh;
  
  public q(d.l.b.a.b.f.b paramb, d.l.b.a.b.l.i parami, d.l.b.a.b.b.y paramy, a.l paraml, d.l.b.a.b.e.b.a parama)
  {
    super(paramb, parami, paramy);
    this.JUh = parama;
    this.JUH = null;
    paramb = paraml.JHR;
    k.g(paramb, "proto.strings");
    parami = paraml.JHS;
    k.g(parami, "proto.qualifiedNames");
    this.JUI = new d(paramb, parami);
    this.JUJ = new y(paraml, (c)this.JUI, this.JUh, (d.g.a.b)new a(this));
    this.JUK = paraml;
  }
  
  public final void b(l paraml)
  {
    k.h(paraml, "components");
    Object localObject = this.JUK;
    if (localObject == null) {
      throw ((Throwable)new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString()));
    }
    this.JUK = null;
    ab localab = (ab)this;
    localObject = ((a.l)localObject).JHT;
    k.g(localObject, "proto.`package`");
    this.JUL = ((h)new d.l.b.a.b.k.a.b.i(localab, (a.k)localObject, (c)this.JUI, this.JUh, this.JUH, paraml, (d.g.a.a)new b(this)));
  }
  
  public final h fyj()
  {
    h localh = this.JUL;
    if (localh == null) {
      k.aPZ("_memberScope");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.k.a.q
 * JD-Core Version:    0.7.0.1
 */