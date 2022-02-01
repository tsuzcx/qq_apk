package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class j$e<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(189388);
    int i = a.b((Comparable)Integer.valueOf(((Constructor)paramT2).getParameterTypes().length), (Comparable)Integer.valueOf(((Constructor)paramT1).getParameterTypes().length));
    AppMethodBeat.o(189388);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.j.e
 * JD-Core Version:    0.7.0.1
 */