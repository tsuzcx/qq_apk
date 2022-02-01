package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/comparisons/ComparisonsKt")
public class b
{
  public static final <T extends Comparable<?>> int b(T paramT1, T paramT2)
  {
    AppMethodBeat.i(128999);
    if (paramT1 == paramT2)
    {
      AppMethodBeat.o(128999);
      return 0;
    }
    if (paramT1 == null)
    {
      AppMethodBeat.o(128999);
      return -1;
    }
    if (paramT2 == null)
    {
      AppMethodBeat.o(128999);
      return 1;
    }
    int i = paramT1.compareTo(paramT2);
    AppMethodBeat.o(128999);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public a(kotlin.g.a.b[] paramArrayOfb) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(183771);
      kotlin.g.a.b[] arrayOfb = this.aivU;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        kotlin.g.a.b localb = arrayOfb[i];
        int k = a.b((Comparable)localb.invoke(paramT1), (Comparable)localb.invoke(paramT2));
        if (k != 0)
        {
          AppMethodBeat.o(183771);
          return k;
        }
        i += 1;
      }
      AppMethodBeat.o(183771);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.b.b
 * JD-Core Version:    0.7.0.1
 */