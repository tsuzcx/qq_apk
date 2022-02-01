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
  final h NBF;
  final Map<w, Integer> NBQ;
  private final d<w, n> NBR;
  final int NBS;
  final l NuG;
  
  public i(h paramh, l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57764);
    this.NBF = paramh;
    this.NuG = paraml;
    this.NBS = paramInt;
    this.NBQ = a.C((Iterable)paramx.gmR());
    this.NBR = this.NBF.NBN.Nnf.M((d.g.a.b)new a(this));
    AppMethodBeat.o(57764);
  }
  
  public final as a(w paramw)
  {
    AppMethodBeat.i(57763);
    p.h(paramw, "javaTypeParameter");
    n localn = (n)this.NBR.invoke(paramw);
    if (localn != null)
    {
      paramw = (as)localn;
      AppMethodBeat.o(57763);
      return paramw;
    }
    paramw = this.NBF.NBO.a(paramw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.i
 * JD-Core Version:    0.7.0.1
 */