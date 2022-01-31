package com.tencent.mm.plugin.story.model;

import a.b.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class i$a$a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(109034);
    int i = a.a((Comparable)Long.valueOf(((b)paramT2).lastModified()), (Comparable)Long.valueOf(((b)paramT1).lastModified()));
    AppMethodBeat.o(109034);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.i.a.a.a
 * JD-Core Version:    0.7.0.1
 */