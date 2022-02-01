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
  private final kotlin.f TiG;
  final kotlin.l.b.a.b.a.g TiH;
  final b TiI;
  private final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> TiJ;
  
  public j(kotlin.l.b.a.b.a.g paramg, b paramb, Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>> paramMap)
  {
    AppMethodBeat.i(56960);
    this.TiH = paramg;
    this.TiI = paramb;
    this.TiJ = paramMap;
    this.TiG = kotlin.g.a(k.SWQ, (a)new a(this));
    AppMethodBeat.o(56960);
  }
  
  public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> hBO()
  {
    return this.TiJ;
  }
  
  public final b hBk()
  {
    return this.TiI;
  }
  
  public final ab hBy()
  {
    AppMethodBeat.i(56958);
    ab localab = (ab)this.TiG.getValue();
    AppMethodBeat.o(56958);
    return localab;
  }
  
  public final an hzM()
  {
    AppMethodBeat.i(56959);
    an localan = an.ThK;
    p.g(localan, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(56959);
    return localan;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.j
 * JD-Core Version:    0.7.0.1
 */