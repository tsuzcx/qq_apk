package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class a$i<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(238653);
    int i = kotlin.b.a.a((Comparable)Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)paramT1).Ghu), (Comparable)Long.valueOf(((com.tencent.mm.plugin.thumbplayer.d.a)paramT2).Ghu));
    AppMethodBeat.o(238653);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a.i
 * JD-Core Version:    0.7.0.1
 */