package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.b.a;
import d.g.b.p;
import d.l;
import java.lang.reflect.Method;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class c$a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(56278);
    paramT1 = (Method)paramT1;
    p.g(paramT1, "it");
    paramT1 = (Comparable)paramT1.getName();
    paramT2 = (Method)paramT2;
    p.g(paramT2, "it");
    int i = a.a(paramT1, (Comparable)paramT2.getName());
    AppMethodBeat.o(56278);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.l.b.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */