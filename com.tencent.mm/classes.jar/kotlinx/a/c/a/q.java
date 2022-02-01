package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.m;
import kotlinx.a.c;
import kotlinx.a.c.b;
import kotlinx.a.c.o;
import kotlinx.a.c.s;
import kotlinx.a.c.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"readJson", "T", "Lkotlinx/serialization/json/Json;", "element", "Lkotlinx/serialization/json/JsonElement;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class q
{
  public static final <T> T a(kotlinx.a.c.a parama, kotlinx.a.c.f paramf, kotlinx.a.f<T> paramf1)
  {
    AppMethodBeat.i(191343);
    p.h(parama, "$this$readJson");
    p.h(paramf, "element");
    p.h(paramf1, "deserializer");
    if ((paramf instanceof s)) {
      parama = (a)new h(parama, (s)paramf);
    }
    for (;;)
    {
      parama = kotlinx.a.e.c((c)parama, paramf1);
      AppMethodBeat.o(191343);
      return parama;
      if ((paramf instanceof b))
      {
        parama = (a)new i(parama, (b)paramf);
      }
      else
      {
        if ((!(paramf instanceof o)) && (!p.i(paramf, kotlinx.a.c.q.NNR))) {
          break;
        }
        parama = (a)new e(parama, (v)paramf);
      }
    }
    parama = new m();
    AppMethodBeat.o(191343);
    throw parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.q
 * JD-Core Version:    0.7.0.1
 */