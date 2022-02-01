package kotlin.l.b.a.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.j;
import kotlin.g.b.s;

public final class b
  implements Collection<a>, kotlin.g.b.a.a
{
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
    s.u((a)paramObject, "element");
    AppMethodBeat.o(59345);
    throw null;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(59346);
    s.u(paramCollection, "elements");
    AppMethodBeat.o(59346);
    throw null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59342);
    if (this == paramObject)
    {
      AppMethodBeat.o(59342);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(59342);
      return false;
    }
    AppMethodBeat.o(59342);
    throw null;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59343);
    AppMethodBeat.o(59343);
    throw null;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(59347);
    AppMethodBeat.o(59347);
    throw null;
  }
  
  public final Iterator<a> iterator()
  {
    AppMethodBeat.i(59348);
    AppMethodBeat.o(59348);
    throw null;
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
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(59355);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(59356);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(59356);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59341);
    s.u(this, "<this>");
    AppMethodBeat.o(59341);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.g.b
 * JD-Core Version:    0.7.0.1
 */