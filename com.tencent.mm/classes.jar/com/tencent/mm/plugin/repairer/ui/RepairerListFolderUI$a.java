package com.tencent.mm.plugin.repairer.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.j;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class RepairerListFolderUI$a<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(277869);
    int i = a.b((Comparable)Long.valueOf(((j)paramT2).agxg), (Comparable)Long.valueOf(((j)paramT1).agxg));
    AppMethodBeat.o(277869);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerListFolderUI.a
 * JD-Core Version:    0.7.0.1
 */