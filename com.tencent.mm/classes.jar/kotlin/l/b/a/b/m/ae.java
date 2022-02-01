package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;

public final class ae
  extends bi
{
  final a<ab> TMV;
  private final f<ab> TOp;
  private final j TcN;
  
  public ae(j paramj, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.TcN = paramj;
    this.TMV = parama;
    this.TOp = this.TcN.al(this.TMV);
    AppMethodBeat.o(60778);
  }
  
  protected final ab hLG()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.TOp.invoke();
    AppMethodBeat.o(60775);
    return localab;
  }
  
  public final boolean hLt()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.TOp.hLt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */