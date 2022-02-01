package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class v
  extends u
{
  public static final <T extends Comparable<? super T>> void N(List<T> paramList)
  {
    AppMethodBeat.i(129226);
    s.u(paramList, "$this$sort");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
    AppMethodBeat.o(129226);
  }
  
  public static final <T> void a(List<T> paramList, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129227);
    s.u(paramList, "$this$sortWith");
    s.u(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
    AppMethodBeat.o(129227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.v
 * JD-Core Version:    0.7.0.1
 */