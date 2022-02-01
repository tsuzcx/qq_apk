package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aa<T>
  implements a, Iterator<y<? extends T>>
{
  private final Iterator<T> KTJ;
  private int index;
  
  public aa(Iterator<? extends T> paramIterator)
  {
    AppMethodBeat.i(129029);
    this.KTJ = paramIterator;
    AppMethodBeat.o(129029);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(129027);
    boolean bool = this.KTJ.hasNext();
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
 * Qualified Name:     d.a.aa
 * JD-Core Version:    0.7.0.1
 */