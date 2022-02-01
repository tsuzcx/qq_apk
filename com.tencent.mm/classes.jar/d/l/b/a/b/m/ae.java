package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.q;
import d.l.b.a.b.l.f;
import d.l.b.a.b.l.j;
import d.l.b.a.b.m.a.i;

public final class ae
  extends bi
{
  final a<ab> NYc;
  private final f<ab> NZw;
  private final j Nnf;
  
  public ae(j paramj, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.Nnf = paramj;
    this.NYc = parama;
    this.NZw = this.Nnf.S(this.NYc);
    AppMethodBeat.o(60778);
  }
  
  protected final ab gyD()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.NZw.invoke();
    AppMethodBeat.o(60775);
    return localab;
  }
  
  public final boolean gyq()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.NZw.gyq();
    AppMethodBeat.o(60776);
    return bool;
  }
  
  static final class a
    extends q
    implements a<ab>
  {
    a(ae paramae, i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */