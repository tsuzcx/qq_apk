package com.tencent.mm.plugin.repairer.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class RepairerXLogUI$d
  extends u
  implements kotlin.g.a.a<ah>
{
  RepairerXLogUI$d(String paramString, RepairerXLogUI paramRepairerXLogUI)
  {
    super(0);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(277858);
      int i = kotlin.b.a.b((Comparable)Long.valueOf(((RepairerXLogUI.a)paramT2).DZN), (Comparable)Long.valueOf(((RepairerXLogUI.a)paramT1).DZN));
      AppMethodBeat.o(277858);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerXLogUI.d
 * JD-Core Version:    0.7.0.1
 */