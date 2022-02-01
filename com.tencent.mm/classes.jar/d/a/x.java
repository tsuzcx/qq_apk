package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.g.b.f;
import d.g.b.k;
import d.l;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"})
public final class x
  implements a, Serializable, Set
{
  public static final x KTH;
  
  static
  {
    AppMethodBeat.i(129052);
    KTH = new x();
    AppMethodBeat.o(129052);
  }
  
  private final Object readResolve()
  {
    return KTH;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    AppMethodBeat.i(129053);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129053);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129054);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129054);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(129050);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(129050);
      return false;
    }
    k.h((Void)paramObject, "element");
    AppMethodBeat.o(129050);
    return false;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    AppMethodBeat.i(129051);
    k.h(paramCollection, "elements");
    boolean bool = paramCollection.isEmpty();
    AppMethodBeat.o(129051);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129049);
    if (((paramObject instanceof Set)) && (((Set)paramObject).isEmpty()))
    {
      AppMethodBeat.o(129049);
      return true;
    }
    AppMethodBeat.o(129049);
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
  
  public final Iterator iterator()
  {
    return (Iterator)u.KTE;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(129055);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129055);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    AppMethodBeat.i(129056);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129056);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    AppMethodBeat.i(129057);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129057);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(129059);
    Object[] arrayOfObject = f.s(this);
    AppMethodBeat.o(129059);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129060);
    paramArrayOfT = f.a(this, paramArrayOfT);
    AppMethodBeat.o(129060);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    return "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.x
 * JD-Core Version:    0.7.0.1
 */