package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.l;
import d.l.b.a.b.d.a.c.a.n;
import d.l.b.a.b.d.a.e.w;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.l.d;
import d.l.b.a.b.l.j;
import d.l.b.a.b.o.a;
import java.util.Map;

public final class i
  implements m
{
  final l MXA;
  final h NeA;
  final Map<w, Integer> NeL;
  private final d<w, n> NeM;
  final int NeN;
  
  public i(h paramh, l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.NeA = paramh;
    this.MXA = paraml;
    this.NeN = paramInt;
    this.NeL = a.C((Iterable)paramx.gip());
    this.NeM = this.NeA.NeI.MQa.J((d.g.a.b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final as a(w paramw)
  {
    AppMethodBeat.i(57763);
    p.h(paramw, "javaTypeParameter");
    n localn = (n)this.NeM.invoke(paramw);
    if (localn != null)
    {
      paramw = (as)localn;
      AppMethodBeat.o(57763);
      return paramw;
    }
    paramw = this.NeA.NeJ.a(paramw);
    AppMethodBeat.o(57763);
    return paramw;
  }
  
  static final class a
    extends q
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