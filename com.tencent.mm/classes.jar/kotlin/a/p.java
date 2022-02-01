package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, hxG=1)
public class p
  extends o
{
  public static final <T> void a(List<T> paramList, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129227);
    kotlin.g.b.p.h(paramList, "$this$sortWith");
    kotlin.g.b.p.h(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
    AppMethodBeat.o(129227);
  }
  
  public static final <T extends Comparable<? super T>> void sort(List<T> paramList)
  {
    AppMethodBeat.i(129226);
    kotlin.g.b.p.h(paramList, "$this$sort");
    if (paramList.size() > 1) {
      Collections.sort(paramList);
    }
    AppMethodBeat.o(129226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.p
 * JD-Core Version:    0.7.0.1
 */