package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.l;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class u
  implements a, ListIterator
{
  public static final u MKD;
  
  static
  {
    AppMethodBeat.i(129012);
    MKD = new u();
    AppMethodBeat.o(129012);
  }
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final boolean hasPrevious()
  {
    return false;
  }
  
  public final int nextIndex()
  {
    return 0;
  }
  
  public final int previousIndex()
  {
    return -1;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(129013);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129013);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.u
 * JD-Core Version:    0.7.0.1
 */