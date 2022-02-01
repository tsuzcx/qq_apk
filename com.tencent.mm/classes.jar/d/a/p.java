package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, gkc=1)
public class p
  extends o
{
  public static final <T> void a(List<T> paramList, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129227);
    d.g.b.p.h(paramList, "$this$sortWith");
    d.g.b.p.h(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
    AppMethodBeat.o(129227);
  }
  
  public static final <T extends Comparable<? super T>> void sort(List<T> paramList)
  {
    AppMethodBeat.i(129226);
    d.g.b.p.h(paramList, "$this$sort");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
    AppMethodBeat.o(129226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.p
 * JD-Core Version:    0.7.0.1
 */