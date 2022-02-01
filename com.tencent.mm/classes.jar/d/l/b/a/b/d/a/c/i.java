package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.d.a.c.a.n;
import d.l.b.a.b.d.a.e.w;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.l.d;
import d.l.b.a.b.o.a;
import java.util.Map;

public final class i
  implements m
{
  final h JAk;
  final Map<w, Integer> JAv;
  private final d<w, n> JAw;
  final int JAx;
  final d.l.b.a.b.b.l Jtl;
  
  public i(h paramh, d.l.b.a.b.b.l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.JAk = paramh;
    this.Jtl = paraml;
    this.JAx = paramInt;
    this.JAv = a.B((Iterable)paramx.fyn());
    this.JAw = this.JAk.JAs.JlL.B((d.g.a.b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final as a(w paramw)
  {
    AppMethodBeat.i(57763);
    k.h(paramw, "javaTypeParameter");
    n localn = (n)this.JAw.aA(paramw);
    if (localn != null)
    {
      paramw = (as)localn;
      AppMethodBeat.o(57763);
      return paramw;
    }
    paramw = this.JAk.JAt.a(paramw);
    AppMethodBeat.o(57763);
    return paramw;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<w, n>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */