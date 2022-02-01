package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.b.as;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"nullable", "Lkotlinx/serialization/KSerializer;", "T", "", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "MapEntrySerializer", "", "K", "V", "keySerializer", "valueSerializer", "PairSerializer", "Lkotlin/Pair;", "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "kotlinx-serialization-runtime"})
public final class c
{
  public static final <T> h<T> a(h<T> paramh)
  {
    AppMethodBeat.i(199845);
    p.h(paramh, "$this$nullable");
    if (paramh.eOR().gBu())
    {
      AppMethodBeat.o(199845);
      return paramh;
    }
    paramh = (h)new as(paramh);
    AppMethodBeat.o(199845);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.a.c
 * JD-Core Version:    0.7.0.1
 */