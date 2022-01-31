package com.tencent.mm.plugin.story.model.f;

import a.b.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class a$c<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(109349);
    int i = a.a((Comparable)Long.valueOf(((f)paramT2).field_readTime), (Comparable)Long.valueOf(((f)paramT1).field_readTime));
    AppMethodBeat.o(109349);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.a.c
 * JD-Core Version:    0.7.0.1
 */