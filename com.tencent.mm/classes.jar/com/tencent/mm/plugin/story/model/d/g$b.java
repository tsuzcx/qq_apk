package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class g$b<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(138772);
    int i = a.b.a.a((Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT1).fDT), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.story.model.b.a)paramT2).fDT));
    AppMethodBeat.o(138772);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.g.b
 * JD-Core Version:    0.7.0.1
 */