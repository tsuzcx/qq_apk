package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
public final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f SXy;
  
  static
  {
    AppMethodBeat.i(129001);
    SXy = new f();
    AppMethodBeat.o(129001);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)e.SXx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.b.f
 * JD-Core Version:    0.7.0.1
 */