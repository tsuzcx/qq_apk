package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class aa
  implements ListIterator, a
{
  public static final aa aivx;
  
  static
  {
    AppMethodBeat.i(129012);
    aivx = new aa();
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
 * Qualified Name:     kotlin.a.aa
 * JD-Core Version:    0.7.0.1
 */