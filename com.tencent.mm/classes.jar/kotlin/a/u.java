package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class u
  implements ListIterator, a
{
  public static final u SXq;
  
  static
  {
    AppMethodBeat.i(129012);
    SXq = new u();
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
 * Qualified Name:     kotlin.a.u
 * JD-Core Version:    0.7.0.1
 */