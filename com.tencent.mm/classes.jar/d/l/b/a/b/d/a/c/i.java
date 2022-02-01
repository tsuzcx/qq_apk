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
  final d.l.b.a.b.b.l LgE;
  final h LnD;
  final Map<w, Integer> LnO;
  private final d<w, n> LnP;
  final int LnQ;
  
  public i(h paramh, d.l.b.a.b.b.l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.LnD = paramh;
    this.LgE = paraml;
    this.LnQ = paramInt;
    this.LnO = a.A((Iterable)paramx.fQR());
    this.LnP = this.LnD.LnL.KZf.J((d.g.a.b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final as a(w paramw)
  {
    AppMethodBeat.i(57763);
    k.h(paramw, "javaTypeParameter");
    n localn = (n)this.LnP.ay(paramw);
    if (localn != null)
    {
      paramw = (as)localn;
      AppMethodBeat.o(57763);
      return paramw;
    }
    paramw = this.LnD.LnM.a(paramw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */