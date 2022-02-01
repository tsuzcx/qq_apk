package com.tencent.mm.plugin.story.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class a$l<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(119002);
    int i = a.a((Comparable)Integer.valueOf(((c)paramT2).hGU), (Comparable)Integer.valueOf(((c)paramT1).hGU));
    AppMethodBeat.o(119002);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f.a.l
 * JD-Core Version:    0.7.0.1
 */