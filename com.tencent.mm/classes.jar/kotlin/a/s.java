package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, hxG=1)
public class s
  extends r
{
  public static final <C extends Collection<? super R>, R> C a(Iterable<?> paramIterable, C paramC, Class<R> paramClass)
  {
    AppMethodBeat.i(206262);
    p.h(paramIterable, "$this$filterIsInstanceTo");
    p.h(paramC, "destination");
    p.h(paramClass, "klass");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
    }
    AppMethodBeat.o(206262);
    return paramC;
  }
  
  public static final <T> void reverse(List<T> paramList)
  {
    AppMethodBeat.i(129225);
    p.h(paramList, "$this$reverse");
    Collections.reverse(paramList);
    AppMethodBeat.o(129225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.s
 * JD-Core Version:    0.7.0.1
 */