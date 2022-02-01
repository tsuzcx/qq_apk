package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class a$h<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(185182);
    int i = a.b((Comparable)Long.valueOf(((a.a)paramT2).MMg), (Comparable)Long.valueOf(((a.a)paramT1).MMg));
    AppMethodBeat.o(185182);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.h
 * JD-Core Version:    0.7.0.1
 */