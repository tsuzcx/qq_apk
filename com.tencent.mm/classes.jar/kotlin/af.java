package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.a.ay;
import kotlin.a.k;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "size", "", "constructor-impl", "(I)[S", "storage", "", "([S)[S", "getSize-impl", "([S)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([SLjava/lang/Object;)Z", "get", "index", "get-Mh2AYeg", "([SI)S", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([S)Z", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "set", "", "value", "set-01HTLdE", "([SIS)V", "toString", "", "toString-impl", "([S)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class af
  implements Collection<ae>, a
{
  public final short[] aiuW;
  
  public final boolean addAll(Collection<? extends ae> paramCollection)
  {
    AppMethodBeat.i(190795);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190795);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(190801);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190801);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190766);
    short[] arrayOfShort = this.aiuW;
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (((localObject instanceof ae)) && (k.contains(arrayOfShort, ((ae)localObject).data))) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(190766);
          return false;
        }
      }
    }
    AppMethodBeat.o(190766);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190789);
    short[] arrayOfShort = this.aiuW;
    if (((paramObject instanceof af)) && (s.p(arrayOfShort, ((af)paramObject).aiuW)))
    {
      AppMethodBeat.o(190789);
      return true;
    }
    AppMethodBeat.o(190789);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190783);
    short[] arrayOfShort = this.aiuW;
    if (arrayOfShort != null)
    {
      int i = Arrays.hashCode(arrayOfShort);
      AppMethodBeat.o(190783);
      return i;
    }
    AppMethodBeat.o(190783);
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return this.aiuW.length == 0;
  }
  
  public final Iterator<ae> iterator()
  {
    AppMethodBeat.i(190753);
    Iterator localIterator = (Iterator)new a(this.aiuW);
    AppMethodBeat.o(190753);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(190807);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190807);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190814);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190814);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190822);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190822);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(190834);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(190834);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(190837);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(190837);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190779);
    Object localObject = this.aiuW;
    localObject = "UShortArray(storage=" + Arrays.toString((short[])localObject) + ")";
    AppMethodBeat.o(190779);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/UShortArray$Iterator;", "Lkotlin/collections/UShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextUShort", "Lkotlin/UShort;", "nextUShort-Mh2AYeg", "()S", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
    extends ay
  {
    private final short[] ahPf;
    private int index;
    
    public a(short[] paramArrayOfShort)
    {
      AppMethodBeat.i(190746);
      this.ahPf = paramArrayOfShort;
      AppMethodBeat.o(190746);
    }
    
    public final boolean hasNext()
    {
      return this.index < this.ahPf.length;
    }
    
    public final short kkT()
    {
      AppMethodBeat.i(190759);
      if (this.index < this.ahPf.length)
      {
        localObject = this.ahPf;
        int i = this.index;
        this.index = (i + 1);
        short s = ae.d(localObject[i]);
        AppMethodBeat.o(190759);
        return s;
      }
      Object localObject = (Throwable)new NoSuchElementException(String.valueOf(this.index));
      AppMethodBeat.o(190759);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.af
 * JD-Core Version:    0.7.0.1
 */