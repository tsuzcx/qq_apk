package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class af<T>
  implements Iterable<ae<? extends T>>, kotlin.g.b.a.a
{
  private final kotlin.g.a.a<Iterator<T>> aivB;
  
  public af(kotlin.g.a.a<? extends Iterator<? extends T>> parama)
  {
    AppMethodBeat.i(129116);
    this.aivB = parama;
    AppMethodBeat.o(129116);
  }
  
  public final Iterator<ae<T>> iterator()
  {
    AppMethodBeat.i(129115);
    Iterator localIterator = (Iterator)new ag((Iterator)this.aivB.invoke());
    AppMethodBeat.o(129115);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.af
 * JD-Core Version:    0.7.0.1
 */