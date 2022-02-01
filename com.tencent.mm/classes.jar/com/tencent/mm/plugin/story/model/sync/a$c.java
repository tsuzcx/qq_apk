package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class a$c<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(118978);
    int i = a.b((Comparable)Long.valueOf(((f)paramT2).field_readTime), (Comparable)Long.valueOf(((f)paramT1).field_readTime));
    AppMethodBeat.o(118978);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.a.c
 * JD-Core Version:    0.7.0.1
 */