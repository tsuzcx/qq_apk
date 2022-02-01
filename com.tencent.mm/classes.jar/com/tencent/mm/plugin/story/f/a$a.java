package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(118628);
    int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).LjK), (Comparable)Long.valueOf(((FileSystem.a)paramT2).LjK));
    AppMethodBeat.o(118628);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a.a
 * JD-Core Version:    0.7.0.1
 */