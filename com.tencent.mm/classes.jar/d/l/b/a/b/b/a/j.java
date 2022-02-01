package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l.b.a.b.b.an;
import d.l.b.a.b.f.b;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.aj;
import java.util.Map;

public final class j
  implements c
{
  private final d.f NsY;
  final d.l.b.a.b.a.g NsZ;
  final b Nta;
  private final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> Ntb;
  
  public j(d.l.b.a.b.a.g paramg, b paramb, Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.NsZ = paramg;
    this.Nta = paramb;
    this.Ntb = paramMap;
    this.NsY = d.g.a(k.Nhe, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final an gmk()
  {
    AppMethodBeat.i(56959);
    an localan = an.Nsc;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
  }
  
  public final b gnI()
  {
    return this.Nta;
  }
  
  public final ab gnW()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.NsY.getValue();
    AppMethodBeat.o(56958);
    return localab;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> gom()
  {
    return this.Ntb;
  }
  
  static final class a
    extends q
    implements a<aj>
  {
    a(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */