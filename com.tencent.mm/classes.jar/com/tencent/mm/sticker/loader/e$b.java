package com.tencent.mm.sticker.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class e$b<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(105926);
    int i = a.a((Comparable)Long.valueOf(((FileSystem.a)paramT2).LjK), (Comparable)Long.valueOf(((FileSystem.a)paramT1).LjK));
    AppMethodBeat.o(105926);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sticker.loader.e.b
 * JD-Core Version:    0.7.0.1
 */