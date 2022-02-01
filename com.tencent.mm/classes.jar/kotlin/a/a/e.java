package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilderEntries;", "K", "V", "Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "add", "", "element", "addAll", "elements", "", "clear", "", "containsAll", "containsEntry", "", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class e<K, V>
  extends a<Map.Entry<K, V>, K, V>
{
  private final d<K, V> aivT;
  
  public e(d<K, V> paramd)
  {
    AppMethodBeat.i(191036);
    this.aivT = paramd;
    AppMethodBeat.o(191036);
  }
  
  public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    AppMethodBeat.i(191091);
    s.u(paramCollection, "elements");
    paramCollection = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(191091);
    throw paramCollection;
  }
  
  public final boolean b(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(191063);
    s.u(paramEntry, "element");
    boolean bool = this.aivT.n(paramEntry);
    AppMethodBeat.o(191063);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191072);
    this.aivT.clear();
    AppMethodBeat.o(191072);
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191114);
    s.u(paramCollection, "elements");
    boolean bool = this.aivT.K(paramCollection);
    AppMethodBeat.o(191114);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(191041);
    int i = this.aivT.size();
    AppMethodBeat.o(191041);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191051);
    boolean bool = this.aivT.isEmpty();
    AppMethodBeat.o(191051);
    return bool;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(191109);
    Iterator localIterator = (Iterator)this.aivT.klg();
    AppMethodBeat.o(191109);
    return localIterator;
  }
  
  public final boolean m(Map.Entry paramEntry)
  {
    AppMethodBeat.i(191101);
    s.u(paramEntry, "element");
    d locald = this.aivT;
    s.u(paramEntry, "entry");
    locald.klc();
    int i = locald.ht(paramEntry.getKey());
    if (i < 0)
    {
      AppMethodBeat.o(191101);
      return false;
    }
    Object[] arrayOfObject = locald.aivN;
    s.checkNotNull(arrayOfObject);
    if ((s.p(arrayOfObject[i], paramEntry.getValue()) ^ true))
    {
      AppMethodBeat.o(191101);
      return false;
    }
    locald.aKn(i);
    AppMethodBeat.o(191101);
    return true;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191119);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.removeAll(paramCollection);
    AppMethodBeat.o(191119);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191124);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.retainAll(paramCollection);
    AppMethodBeat.o(191124);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.e
 * JD-Core Version:    0.7.0.1
 */