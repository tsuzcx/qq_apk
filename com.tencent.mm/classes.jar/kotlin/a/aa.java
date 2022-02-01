package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aa<T>
  implements Iterator<y<? extends T>>, a
{
  private final Iterator<T> bXG;
  private int index;
  
  public aa(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(129029);
    this.bXG = paramIterator;
    AppMethodBeat.o(129029);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129027);
    boolean bool = this.bXG.hasNext();
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
 * Qualified Name:     kotlin.a.aa
 * JD-Core Version:    0.7.0.1
 */