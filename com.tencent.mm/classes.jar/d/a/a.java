package d.a;

import d.g.a.b;
import d.g.b.i;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"})
public abstract class a<E>
  implements d.g.b.a.a, Collection<E>
{
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(Object paramObject)
  {
    if (!((Collection)this).isEmpty())
    {
      Iterator localIterator = iterator();
      while (localIterator.hasNext()) {
        if (p.i(localIterator.next(), paramObject)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    p.h(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public abstract int getSize();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public Object[] toArray()
  {
    return i.t((Collection)this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    p.h(paramArrayOfT, "array");
    paramArrayOfT = i.a((Collection)this, paramArrayOfT);
    if (paramArrayOfT == null) {
      throw new v("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return paramArrayOfT;
  }
  
  public String toString()
  {
    return j.a(this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, null, (b)new a(this), 24);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"})
  static final class a
    extends q
    implements b<E, CharSequence>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a
 * JD-Core Version:    0.7.0.1
 */