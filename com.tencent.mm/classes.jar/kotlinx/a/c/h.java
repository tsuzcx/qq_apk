package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import d.l;
import kotlinx.a.c;
import kotlinx.a.g;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"verify", "", "decoder", "Lkotlinx/serialization/Decoder;", "encoder", "Lkotlinx/serialization/Encoder;", "asJsonInput", "Lkotlinx/serialization/json/JsonInput;", "asJsonOutput", "Lkotlinx/serialization/json/JsonOutput;", "kotlinx-serialization-runtime"})
public final class h
{
  static final void a(g paramg)
  {
    AppMethodBeat.i(200039);
    p.h(paramg, "$this$asJsonOutput");
    if (!(paramg instanceof u)) {}
    for (g localg = null;; localg = paramg)
    {
      if ((u)localg == null)
      {
        paramg = (Throwable)new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonOutput, got " + z.bp(paramg.getClass()));
        AppMethodBeat.o(200039);
        throw paramg;
      }
      AppMethodBeat.o(200039);
      return;
    }
  }
  
  public static final m b(c paramc)
  {
    AppMethodBeat.i(200040);
    p.h(paramc, "$this$asJsonInput");
    if (!(paramc instanceof m)) {}
    for (Object localObject = null;; localObject = paramc)
    {
      localObject = (m)localObject;
      if (localObject == null)
      {
        paramc = (Throwable)new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonInput, got " + z.bp(paramc.getClass()));
        AppMethodBeat.o(200040);
        throw paramc;
      }
      AppMethodBeat.o(200040);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.h
 * JD-Core Version:    0.7.0.1
 */