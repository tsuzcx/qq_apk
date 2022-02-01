package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilderKeys;", "E", "", "Lkotlin/collections/AbstractMutableSet;", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class f<E>
  extends g<E>
  implements Set<E>
{
  private final d<E, ?> aivT;
  
  public f(d<E, ?> paramd)
  {
    AppMethodBeat.i(191024);
    this.aivT = paramd;
    AppMethodBeat.o(191024);
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(191070);
    paramE = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(191070);
    throw paramE;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191081);
    s.u(paramCollection, "elements");
    paramCollection = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(191081);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191058);
    this.aivT.clear();
    AppMethodBeat.o(191058);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191045);
    boolean bool = this.aivT.containsKey(paramObject);
    AppMethodBeat.o(191045);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(191032);
    int i = this.aivT.size();
    AppMethodBeat.o(191032);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191037);
    boolean bool = this.aivT.isEmpty();
    AppMethodBeat.o(191037);
    return bool;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(191098);
    Iterator localIterator = (Iterator)this.aivT.klf();
    AppMethodBeat.o(191098);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191089);
    if (this.aivT.hw(paramObject) >= 0)
    {
      AppMethodBeat.o(191089);
      return true;
    }
    AppMethodBeat.o(191089);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191108);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.removeAll(paramCollection);
    AppMethodBeat.o(191108);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191116);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.retainAll(paramCollection);
    AppMethodBeat.o(191116);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.f
 * JD-Core Version:    0.7.0.1
 */