package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class j
  implements c
{
  private final kotlin.f aaLA;
  final kotlin.l.b.a.b.a.g aaLB;
  final b aaLC;
  private final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> aaLD;
  
  public j(kotlin.l.b.a.b.a.g paramg, b paramb, Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.aaLB = paramg;
    this.aaLC = paramb;
    this.aaLD = paramMap;
    this.aaLA = kotlin.g.a(k.aazC, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final an iDZ()
  {
    AppMethodBeat.i(56959);
    an localan = an.aaKE;
    p.j(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
  }
  
  public final ab iFN()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.aaLA.getValue();
    AppMethodBeat.o(56958);
    return localab;
  }
  
  public final b iFy()
  {
    return this.aaLC;
  }
  
  public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> iGd()
  {
    return this.aaLD;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */