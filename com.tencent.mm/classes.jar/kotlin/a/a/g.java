package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/MapBuilderValues;", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "getBacking", "()Lkotlin/collections/builders/MapBuilder;", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class g<V>
  extends kotlin.a.d<V>
  implements Collection<V>
{
  private final d<?, V> aivT;
  
  public g(d<?, V> paramd)
  {
    AppMethodBeat.i(191020);
    this.aivT = paramd;
    AppMethodBeat.o(191020);
  }
  
  public final boolean add(V paramV)
  {
    AppMethodBeat.i(191044);
    paramV = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(191044);
    throw paramV;
  }
  
  public final boolean addAll(Collection<? extends V> paramCollection)
  {
    AppMethodBeat.i(191055);
    s.u(paramCollection, "elements");
    paramCollection = (Throwable)new UnsupportedOperationException();
    AppMethodBeat.o(191055);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191066);
    this.aivT.clear();
    AppMethodBeat.o(191066);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191038);
    boolean bool = this.aivT.containsValue(paramObject);
    AppMethodBeat.o(191038);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(191026);
    int i = this.aivT.size();
    AppMethodBeat.o(191026);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191033);
    boolean bool = this.aivT.isEmpty();
    AppMethodBeat.o(191033);
    return bool;
  }
  
  public final Iterator<V> iterator()
  {
    AppMethodBeat.i(191076);
    Iterator localIterator = (Iterator)new d.f(this.aivT);
    AppMethodBeat.o(191076);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191084);
    d locald = this.aivT;
    locald.klc();
    int i = locald.hu(paramObject);
    if (i < 0)
    {
      AppMethodBeat.o(191084);
      return false;
    }
    locald.aKn(i);
    AppMethodBeat.o(191084);
    return true;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191093);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.removeAll(paramCollection);
    AppMethodBeat.o(191093);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191103);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.retainAll(paramCollection);
    AppMethodBeat.o(191103);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.g
 * JD-Core Version:    0.7.0.1
 */