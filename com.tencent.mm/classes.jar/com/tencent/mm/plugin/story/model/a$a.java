package com.tencent.mm.plugin.story.model;

import a.b.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(108998);
    int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).APt), (Comparable)Long.valueOf(((FileSystem.a)paramT2).APt));
    AppMethodBeat.o(108998);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.a.a
 * JD-Core Version:    0.7.0.1
 */