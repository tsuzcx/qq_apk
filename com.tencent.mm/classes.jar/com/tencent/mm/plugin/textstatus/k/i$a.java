package com.tencent.mm.plugin.textstatus.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.ac;
import com.tencent.mm.plugin.textstatus.proto.ad;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class i$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    int j = 0;
    AppMethodBeat.i(238013);
    paramT1 = (ac)paramT1;
    p.j(paramT1, "it");
    paramT1 = j.a(paramT1, true);
    if (paramT1 != null) {}
    for (int i = paramT1.order;; i = 0)
    {
      paramT1 = (Comparable)Integer.valueOf(i);
      paramT2 = (ac)paramT2;
      p.j(paramT2, "it");
      paramT2 = j.a(paramT2, true);
      i = j;
      if (paramT2 != null) {
        i = paramT2.order;
      }
      i = a.a(paramT1, (Comparable)Integer.valueOf(i));
      AppMethodBeat.o(238013);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.i.a
 * JD-Core Version:    0.7.0.1
 */