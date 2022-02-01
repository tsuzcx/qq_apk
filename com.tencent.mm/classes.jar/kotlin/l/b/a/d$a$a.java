package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
public final class d$a$a<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(56278);
    paramT1 = (Method)paramT1;
    s.s(paramT1, "it");
    paramT1 = (Comparable)paramT1.getName();
    paramT2 = (Method)paramT2;
    s.s(paramT2, "it");
    int i = a.b(paramT1, (Comparable)paramT2.getName());
    AppMethodBeat.o(56278);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.d.a.a
 * JD-Core Version:    0.7.0.1
 */