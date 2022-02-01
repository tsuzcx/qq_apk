package kotlin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f aivW;
  
  static
  {
    AppMethodBeat.i(129001);
    aivW = new f();
    AppMethodBeat.o(129001);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)e.aivV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.b.f
 * JD-Core Version:    0.7.0.1
 */