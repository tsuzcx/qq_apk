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
  final d.l.b.a.b.a.g MVT;
  final b MVU;
  private final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> MVV;
  private final d.f okp;
  
  public j(d.l.b.a.b.a.g paramg, b paramb, Map<d.l.b.a.b.f.f, ? extends d.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.MVT = paramg;
    this.MVU = paramb;
    this.MVV = paramMap;
    this.okp = d.g.a(k.MKb, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final an ghI()
  {
    AppMethodBeat.i(56959);
    an localan = an.MUX;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
  }
  
  public final Map<d.l.b.a.b.f.f, d.l.b.a.b.j.b.g<?>> gjK()
  {
    return this.MVV;
  }
  
  public final b gjg()
  {
    return this.MVU;
  }
  
  public final ab gju()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.okp.getValue();
    AppMethodBeat.o(56958);
    return localab;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */