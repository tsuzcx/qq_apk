package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, iBN=1)
public class b
{
  public static final <T extends Comparable<?>> int a(T paramT1, T paramT2)
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
  public static final class a<T>
    implements Comparator<T>
  {
    public a(kotlin.g.a.b[] paramArrayOfb) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(183771);
      kotlin.g.a.b[] arrayOfb = this.aaAi;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        kotlin.g.a.b localb = arrayOfb[i];
        int k = a.a((Comparable)localb.invoke(paramT1), (Comparable)localb.invoke(paramT2));
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