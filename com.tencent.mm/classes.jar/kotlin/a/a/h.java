package kotlin.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/builders/SetBuilder;", "E", "", "Lkotlin/collections/AbstractMutableSet;", "()V", "initialCapacity", "", "(I)V", "backing", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "build", "", "clear", "", "contains", "isEmpty", "iterator", "", "remove", "removeAll", "retainAll", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class h<E>
  extends g<E>
  implements Set<E>
{
  public final d<E, ?> aivT;
  
  public h()
  {
    this(new d());
    AppMethodBeat.i(191035);
    AppMethodBeat.o(191035);
  }
  
  private h(d<E, ?> paramd)
  {
    AppMethodBeat.i(191028);
    this.aivT = paramd;
    AppMethodBeat.o(191028);
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(191086);
    if (this.aivT.hv(paramE) >= 0)
    {
      AppMethodBeat.o(191086);
      return true;
    }
    AppMethodBeat.o(191086);
    return false;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    AppMethodBeat.i(191112);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.addAll(paramCollection);
    AppMethodBeat.o(191112);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191075);
    this.aivT.clear();
    AppMethodBeat.o(191075);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191065);
    boolean bool = this.aivT.containsKey(paramObject);
    AppMethodBeat.o(191065);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(191043);
    int i = this.aivT.size();
    AppMethodBeat.o(191043);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191054);
    boolean bool = this.aivT.isEmpty();
    AppMethodBeat.o(191054);
    return bool;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(191105);
    Iterator localIterator = (Iterator)this.aivT.klf();
    AppMethodBeat.o(191105);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191097);
    if (this.aivT.hw(paramObject) >= 0)
    {
      AppMethodBeat.o(191097);
      return true;
    }
    AppMethodBeat.o(191097);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191118);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.removeAll(paramCollection);
    AppMethodBeat.o(191118);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191125);
    s.u(paramCollection, "elements");
    this.aivT.klc();
    boolean bool = super.retainAll(paramCollection);
    AppMethodBeat.o(191125);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.a.a.h
 * JD-Core Version:    0.7.0.1
 */