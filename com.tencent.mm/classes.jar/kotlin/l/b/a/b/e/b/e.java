package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;

public final class e
{
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.e<M, T> parame)
  {
    AppMethodBeat.i(59069);
    s.u(paramc, "<this>");
    s.u(parame, "extension");
    if (paramc.c(parame))
    {
      paramc = paramc.e(parame);
      AppMethodBeat.o(59069);
      return paramc;
    }
    AppMethodBeat.o(59069);
    return null;
  }
  
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.e<M, List<T>> parame, int paramInt)
  {
    AppMethodBeat.i(59070);
    s.u(paramc, "<this>");
    s.u(parame, "extension");
    if (paramInt < paramc.d(parame))
    {
      paramc = paramc.a(parame, paramInt);
      AppMethodBeat.o(59070);
      return paramc;
    }
    AppMethodBeat.o(59070);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.e
 * JD-Core Version:    0.7.0.1
 */