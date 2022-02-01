package com.tencent.mm.plugin.textstatus.g.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class f$d<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(233114);
    int i = kotlin.b.a.a((Comparable)Integer.valueOf(((a)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((a)paramT1).field_CreateTime));
    AppMethodBeat.o(233114);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.f.d
 * JD-Core Version:    0.7.0.1
 */