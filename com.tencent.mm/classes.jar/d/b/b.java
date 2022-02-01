package d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Comparator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, fOb=1)
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
  
  public static final <T> Comparator<T> a(d.g.a.b<? super T, ? extends Comparable<?>>... paramVarArgs)
  {
    AppMethodBeat.i(183770);
    k.h(paramVarArgs, "selectors");
    paramVarArgs = (Comparator)new a(paramVarArgs);
    AppMethodBeat.o(183770);
    return paramVarArgs;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"})
  static final class a<T>
    implements Comparator<T>
  {
    a(d.g.a.b[] paramArrayOfb) {}
    
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(183771);
      d.g.a.b[] arrayOfb = this.KTL;
      int j = arrayOfb.length;
      int i = 0;
      while (i < j)
      {
        d.g.a.b localb = arrayOfb[i];
        int k = a.a((Comparable)localb.ay(paramT1), (Comparable)localb.ay(paramT2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.b.b
 * JD-Core Version:    0.7.0.1
 */