package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"setOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, fvw=1)
public class al
{
  public static final <T> Set<T> setOf(T paramT)
  {
    AppMethodBeat.i(129026);
    paramT = Collections.singleton(paramT);
    k.g(paramT, "java.util.Collections.singleton(element)");
    AppMethodBeat.o(129026);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.al
 * JD-Core Version:    0.7.0.1
 */