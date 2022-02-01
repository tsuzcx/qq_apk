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
  private final j aaFH;
  final a<ab> abpx;
  private final f<ab> abqP;
  
  public ae(j paramj, a<? extends ab> parama)
  {
    AppMethodBeat.i(60778);
    this.aaFH = paramj;
    this.abpx = parama;
    this.abqP = this.aaFH.av(this.abpx);
    AppMethodBeat.o(60778);
  }
  
  public final boolean iPL()
  {
    AppMethodBeat.i(60776);
    boolean bool = this.abqP.iPL();
    AppMethodBeat.o(60776);
    return bool;
  }
  
  protected final ab iPY()
  {
    AppMethodBeat.i(60775);
    ab localab = (ab)this.abqP.invoke();
    AppMethodBeat.o(60775);
    return localab;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ae
 * JD-Core Version:    0.7.0.1
 */