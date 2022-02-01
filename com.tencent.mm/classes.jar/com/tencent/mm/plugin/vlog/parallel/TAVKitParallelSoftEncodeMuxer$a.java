package com.tencent.mm.plugin.vlog.parallel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
public final class TAVKitParallelSoftEncodeMuxer$a<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(281244);
    int i = a.b((Comparable)Integer.valueOf(((c)paramT1).getIndex()), (Comparable)Integer.valueOf(((c)paramT2).getIndex()));
    AppMethodBeat.o(281244);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.TAVKitParallelSoftEncodeMuxer.a
 * JD-Core Version:    0.7.0.1
 */