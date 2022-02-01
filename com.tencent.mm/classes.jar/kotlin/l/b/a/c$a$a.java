package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class c$a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(56278);
    paramT1 = (Method)paramT1;
    p.j(paramT1, "it");
    paramT1 = (Comparable)paramT1.getName();
    paramT2 = (Method)paramT2;
    p.j(paramT2, "it");
    int i = a.a(paramT1, (Comparable)paramT2.getName());
    AppMethodBeat.o(56278);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */