package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.a.a;

@Metadata(d1={""}, d2={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ag<T>
  implements Iterator<ae<? extends T>>, a
{
  private final Iterator<T> atq;
  private int index;
  
  public ag(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(129029);
    this.atq = paramIterator;
    AppMethodBeat.o(129029);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129027);
    boolean bool = this.atq.hasNext();
    AppMethodBeat.o(129027);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(129030);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129030);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ag
 * JD-Core Version:    0.7.0.1
 */