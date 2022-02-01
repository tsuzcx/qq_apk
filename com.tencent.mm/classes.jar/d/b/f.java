package d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Comparator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
public final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f NhP;
  
  static
  {
    AppMethodBeat.i(129001);
    NhP = new f();
    AppMethodBeat.o(129001);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)e.NhO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.b.f
 * JD-Core Version:    0.7.0.1
 */