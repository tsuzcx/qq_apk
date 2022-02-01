package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e SXx;
  
  static
  {
    AppMethodBeat.i(128998);
    SXx = new e();
    AppMethodBeat.o(128998);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)f.SXy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlin.b.e
 * JD-Core Version:    0.7.0.1
 */