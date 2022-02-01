package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, iBN=1)
public class s
  extends r
{
  public static final <C extends Collection<? super R>, R> C a(Iterable<?> paramIterable, C paramC, Class<R> paramClass)
  {
    AppMethodBeat.i(218709);
    p.k(paramIterable, "$this$filterIsInstanceTo");
    p.k(paramC, "destination");
    p.k(paramClass, "klass");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    AppMethodBeat.o(218709);
    return paramC;
  }
  
  public static final <R> List<R> a(Iterable<?> paramIterable, Class<R> paramClass)
  {
    AppMethodBeat.i(218706);
    p.k(paramIterable, "$this$filterIsInstance");
    p.k(paramClass, "klass");
    paramIterable = (List)j.a(paramIterable, (Collection)new ArrayList(), paramClass);
    AppMethodBeat.o(218706);
    return paramIterable;
  }
  
  public static final <T> void ln(List<T> paramList)
  {
    AppMethodBeat.i(129225);
    p.k(paramList, "$this$reverse");
    Collections.reverse(paramList);
    AppMethodBeat.o(129225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.s
 * JD-Core Version:    0.7.0.1
 */