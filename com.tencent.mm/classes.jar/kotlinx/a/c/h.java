package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"verify", "", "decoder", "Lkotlinx/serialization/Decoder;", "encoder", "Lkotlinx/serialization/Encoder;", "asJsonInput", "Lkotlinx/serialization/json/JsonInput;", "asJsonOutput", "Lkotlinx/serialization/json/JsonOutput;", "kotlinx-serialization-runtime"})
public final class h
{
  static final void a(g paramg)
  {
    AppMethodBeat.i(256883);
    p.k(paramg, "$this$asJsonOutput");
    if (!(paramg instanceof u)) {}
    for (g localg = null;; localg = paramg)
    {
      if ((u)localg == null)
      {
        paramg = (Throwable)new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonOutput, got " + ab.bO(paramg.getClass()));
        AppMethodBeat.o(256883);
        throw paramg;
      }
      AppMethodBeat.o(256883);
      return;
    }
  }
  
  public static final m b(c paramc)
  {
    AppMethodBeat.i(256885);
    p.k(paramc, "$this$asJsonInput");
    if (!(paramc instanceof m)) {}
    for (Object localObject = null;; localObject = paramc)
    {
      localObject = (m)localObject;
      if (localObject == null)
      {
        paramc = (Throwable)new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonInput, got " + ab.bO(paramc.getClass()));
        AppMethodBeat.o(256885);
        throw paramc;
      }
      AppMethodBeat.o(256885);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.h
 * JD-Core Version:    0.7.0.1
 */