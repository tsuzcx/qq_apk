package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class y
  extends x
{
  public static final <C extends Collection<? super R>, R> C a(Iterable<?> paramIterable, C paramC, Class<R> paramClass)
  {
    AppMethodBeat.i(191027);
    s.u(paramIterable, "$this$filterIsInstanceTo");
    s.u(paramC, "destination");
    s.u(paramClass, "klass");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    AppMethodBeat.o(191027);
    return paramC;
  }
  
  public static final <R> List<R> a(Iterable<?> paramIterable, Class<R> paramClass)
  {
    AppMethodBeat.i(191019);
    s.u(paramIterable, "$this$filterIsInstance");
    s.u(paramClass, "klass");
    paramIterable = (List)p.a(paramIterable, (Collection)new ArrayList(), paramClass);
    AppMethodBeat.o(191019);
    return paramIterable;
  }
  
  public static final <T> void oJ(List<T> paramList)
  {
    AppMethodBeat.i(129225);
    s.u(paramList, "$this$reverse");
    Collections.reverse(paramList);
    AppMethodBeat.o(129225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.y
 * JD-Core Version:    0.7.0.1
 */