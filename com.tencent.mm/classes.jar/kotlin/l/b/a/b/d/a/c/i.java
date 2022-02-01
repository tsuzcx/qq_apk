package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.c.a.n;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.l.d;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.o.a;

public final class i
  implements m
{
  final l aaNi;
  final h aaUh;
  final Map<w, Integer> aaUs;
  private final d<w, n> aaUt;
  final int aaUu;
  
  public i(h paramh, l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.aaUh = paramh;
    this.aaNi = paraml;
    this.aaUu = paramInt;
    this.aaUs = a.G((Iterable)paramx.iEG());
    this.aaUt = this.aaUh.aaUp.aaFH.al((kotlin.g.a.b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final as a(w paramw)
  {
    AppMethodBeat.i(57763);
    p.k(paramw, "javaTypeParameter");
    n localn = (n)this.aaUt.invoke(paramw);
    if (localn != null)
    {
      paramw = (as)localn;
      AppMethodBeat.o(57763);
      return paramw;
    }
    paramw = this.aaUh.aaUq.a(paramw);
    AppMethodBeat.o(57763);
    return paramw;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<w, n>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */