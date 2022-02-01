package d.l.b.a.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.i;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements d.g.b.a.a, Collection<a>
{
  final Set<a> NqC;
  
  public final boolean addAll(Collection<? extends a> paramCollection)
  {
    AppMethodBeat.i(59349);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(59349);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(59350);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(59350);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(59345);
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(59345);
      return false;
    }
    paramObject = (a)paramObject;
    p.h(paramObject, "element");
    boolean bool = this.NqC.contains(paramObject);
    AppMethodBeat.o(59345);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(59346);
    p.h(paramCollection, "elements");
    boolean bool = this.NqC.containsAll(paramCollection);
    AppMethodBeat.o(59346);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59342);
    if ((b)this == paramObject)
    {
      AppMethodBeat.o(59342);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(59342);
      return false;
    }
    if ((p.i(this.NqC, ((b)paramObject).NqC) ^ true))
    {
      AppMethodBeat.o(59342);
      return false;
    }
    AppMethodBeat.o(59342);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59343);
    int i = this.NqC.hashCode();
    AppMethodBeat.o(59343);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(59347);
    boolean bool = this.NqC.isEmpty();
    AppMethodBeat.o(59347);
    return bool;
  }
  
  public final Iterator<a> iterator()
  {
    AppMethodBeat.i(59348);
    Iterator localIterator = this.NqC.iterator();
    AppMethodBeat.o(59348);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(59351);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(59351);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(59352);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(59352);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(59353);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(59353);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(59355);
    Object[] arrayOfObject = i.t(this);
    AppMethodBeat.o(59355);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(59356);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(59356);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59341);
    p.h(this, "$this$presentableDescription");
    String str = j.a((Iterable)this.NqC, (CharSequence)"/", null, null, 0, null, null, 62);
    AppMethodBeat.o(59341);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.g.b
 * JD-Core Version:    0.7.0.1
 */