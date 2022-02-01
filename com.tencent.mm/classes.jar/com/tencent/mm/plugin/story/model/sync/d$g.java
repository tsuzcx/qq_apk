package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;
import kotlin.r;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class d$g<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(119055);
    int i = a.b((Comparable)Long.valueOf(((f)((r)paramT2).bsD).field_readTime), (Comparable)Long.valueOf(((f)((r)paramT1).bsD).field_readTime));
    AppMethodBeat.o(119055);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.d.g
 * JD-Core Version:    0.7.0.1
 */