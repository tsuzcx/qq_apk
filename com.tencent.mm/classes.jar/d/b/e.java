package d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Comparator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e Jgs;
  
  static
  {
    AppMethodBeat.i(128998);
    Jgs = new e();
    AppMethodBeat.o(128998);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)f.Jgt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.b.e
 * JD-Core Version:    0.7.0.1
 */