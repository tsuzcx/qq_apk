package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import java.util.List;

public final class f
{
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.f<M, T> paramf)
  {
    AppMethodBeat.i(59069);
    k.h(paramc, "$this$getExtensionOrNull");
    k.h(paramf, "extension");
    if (paramc.c(paramf))
    {
      paramc = paramc.e(paramf);
      AppMethodBeat.o(59069);
      return paramc;
    }
    AppMethodBeat.o(59069);
    return null;
  }
  
  public static final <M extends i.c<M>, T> T a(i.c<M> paramc, i.f<M, List<T>> paramf, int paramInt)
  {
    AppMethodBeat.i(59070);
    k.h(paramc, "$this$getExtensionOrNull");
    k.h(paramf, "extension");
    if (paramInt < paramc.d(paramf))
    {
      paramc = paramc.a(paramf, paramInt);
      AppMethodBeat.o(59070);
      return paramc;
    }
    AppMethodBeat.o(59070);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.e.b.f
 * JD-Core Version:    0.7.0.1
 */