package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class i
{
  public static final g a(g paramg1, g paramg2)
  {
    AppMethodBeat.i(56955);
    s.u(paramg1, "first");
    s.u(paramg2, "second");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.i
 * JD-Core Version:    0.7.0.1
 */