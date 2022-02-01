package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Collections;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, fvw=1)
class s
  extends r
{
  public static final <T> void reverse(List<T> paramList)
  {
    AppMethodBeat.i(129225);
    k.h(paramList, "$this$reverse");
    Collections.reverse(paramList);
    AppMethodBeat.o(129225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.s
 * JD-Core Version:    0.7.0.1
 */