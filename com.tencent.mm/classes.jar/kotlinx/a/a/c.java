package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b.as;
import kotlinx.a.h;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"nullable", "Lkotlinx/serialization/KSerializer;", "T", "", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "MapEntrySerializer", "", "K", "V", "keySerializer", "valueSerializer", "PairSerializer", "Lkotlin/Pair;", "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "kotlinx-serialization-runtime"})
public final class c
{
  public static final <T> h<T> a(h<T> paramh)
  {
    AppMethodBeat.i(225617);
    p.h(paramh, "$this$nullable");
    if (paramh.fWv().hOB())
    {
      AppMethodBeat.o(225617);
      return paramh;
    }
    paramh = (h)new as(paramh);
    AppMethodBeat.o(225617);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.a.c
 * JD-Core Version:    0.7.0.1
 */