package com.tencent.mm.plugin.story.model.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.f;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class a$j<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(119001);
    paramT2 = (f)paramT2;
    if (paramT2.field_updateTime == 0L)
    {
      l = paramT2.field_storyPostTime * 1000L;
      paramT2 = (Comparable)Long.valueOf(l);
      paramT1 = (f)paramT1;
      if (paramT1.field_updateTime != 0L) {
        break label93;
      }
    }
    label93:
    for (long l = paramT1.field_storyPostTime * 1000L;; l = paramT1.field_updateTime)
    {
      int i = a.b(paramT2, (Comparable)Long.valueOf(l));
      AppMethodBeat.o(119001);
      return i;
      l = paramT2.field_updateTime;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.sync.a.j
 * JD-Core Version:    0.7.0.1
 */