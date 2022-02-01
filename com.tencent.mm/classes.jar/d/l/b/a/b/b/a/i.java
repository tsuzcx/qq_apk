package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

public final class i
{
  public static final g a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(56955);
    p.h(paramg1, "first");
    p.h(paramg2, "second");
    if (paramg1.isEmpty())
    {
      AppMethodBeat.o(56955);
      return paramg2;
    }
    if (paramg2.isEmpty())
    {
      AppMethodBeat.o(56955);
      return paramg1;
    }
    paramg1 = (g)new k(new g[] { paramg1, paramg2 });
    AppMethodBeat.o(56955);
    return paramg1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.a.i
 * JD-Core Version:    0.7.0.1
 */