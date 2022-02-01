package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"})
public final class z<T>
  implements d.g.b.a.a, Iterable<y<? extends T>>
{
  private final d.g.a.a<Iterator<T>> Jgo;
  
  public z(d.g.a.a<? extends Iterator<? extends T>> parama)
  {
    AppMethodBeat.i(129116);
    this.Jgo = parama;
    AppMethodBeat.o(129116);
  }
  
  public final Iterator<y<T>> iterator()
  {
    AppMethodBeat.i(129115);
    Iterator localIterator = (Iterator)new aa((Iterator)this.Jgo.invoke());
    AppMethodBeat.o(129115);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.z
 * JD-Core Version:    0.7.0.1
 */