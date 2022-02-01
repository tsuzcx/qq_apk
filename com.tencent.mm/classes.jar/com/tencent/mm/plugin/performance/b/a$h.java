package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class a$h<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(185182);
    int i = a.a((Comparable)Long.valueOf(((a.a)paramT2).wIM), (Comparable)Long.valueOf(((a.a)paramT1).wIM));
    AppMethodBeat.o(185182);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.h
 * JD-Core Version:    0.7.0.1
 */