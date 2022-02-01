package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/EmptyList;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "readResolve", "subList", "fromIndex", "toIndex", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ab
  implements Serializable, List, RandomAccess, a
{
  public static final ab aivy;
  
  static
  {
    AppMethodBeat.i(129160);
    aivy = new ab();
    AppMethodBeat.o(129160);
  }
  
  public final boolean addAll(int paramInt, Collection paramCollection)
  {
    AppMethodBeat.i(129161);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129161);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    AppMethodBeat.i(129162);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129162);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129163);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129163);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(129153);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(129153);
      return false;
    }
    s.u((Void)paramObject, "element");
    AppMethodBeat.o(129153);
    return false;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    AppMethodBeat.i(129154);
    s.u(paramCollection, "elements");
    boolean bool = paramCollection.isEmpty();
    AppMethodBeat.o(129154);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129152);
    if (((paramObject instanceof List)) && (((List)paramObject).isEmpty()))
    {
      AppMethodBeat.o(129152);
      return true;
    }
    AppMethodBeat.o(129152);
    return false;
  }
  
  public final int hashCode()
  {
    return 1;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(129156);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(129156);
      return -1;
    }
    s.u((Void)paramObject, "element");
    AppMethodBeat.o(129156);
    return -1;
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
  
  public final Iterator iterator()
  {
    return (Iterator)aa.aivx;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(129157);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(129157);
      return -1;
    }
    s.u((Void)paramObject, "element");
    AppMethodBeat.o(129157);
    return -1;
  }
  
  public final ListIterator listIterator()
  {
    return (ListIterator)aa.aivx;
  }
  
  public final ListIterator listIterator(int paramInt)
  {
    AppMethodBeat.i(129158);
    if (paramInt != 0)
    {
      localObject = (Throwable)new IndexOutOfBoundsException("Index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(129158);
      throw ((Throwable)localObject);
    }
    Object localObject = (ListIterator)aa.aivx;
    AppMethodBeat.o(129158);
    return localObject;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(129164);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129164);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    AppMethodBeat.i(129165);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129165);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    AppMethodBeat.i(129166);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129166);
    throw paramCollection;
  }
  
  public final List subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129159);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject = (List)this;
      AppMethodBeat.o(129159);
      return localObject;
    }
    Object localObject = (Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2);
    AppMethodBeat.o(129159);
    throw ((Throwable)localObject);
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(129171);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(129171);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129172);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(129172);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    return "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ab
 * JD-Core Version:    0.7.0.1
 */