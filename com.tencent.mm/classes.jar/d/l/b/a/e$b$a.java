package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.b.a;
import d.l;
import d.l.j;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class e$b$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(56298);
    int i = a.a((Comparable)((j)paramT1).getName(), (Comparable)((j)paramT2).getName());
    AppMethodBeat.o(56298);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.l.b.a.e.b.a
 * JD-Core Version:    0.7.0.1
 */