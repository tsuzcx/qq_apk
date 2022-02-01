package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e aivV;
  
  static
  {
    AppMethodBeat.i(128998);
    aivV = new e();
    AppMethodBeat.o(128998);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)f.aivW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.b.e
 * JD-Core Version:    0.7.0.1
 */