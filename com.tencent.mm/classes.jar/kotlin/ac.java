package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.a.ax;
import kotlin.a.k;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "size", "", "constructor-impl", "(I)[J", "storage", "", "([J)[J", "getSize-impl", "([J)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([JLjava/lang/Object;)Z", "get", "index", "get-s-VKNKU", "([JI)J", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([J)Z", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "toString", "", "toString-impl", "([J)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ac
  implements Collection<ab>, a
{
  public final long[] aiuT;
  
  public final boolean addAll(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(190813);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190813);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(190820);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190820);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(190771);
    if (!(paramObject instanceof ab))
    {
      AppMethodBeat.o(190771);
      return false;
    }
    long l = ((ab)paramObject).data;
    boolean bool = k.b(this.aiuT, l);
    AppMethodBeat.o(190771);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190776);
    long[] arrayOfLong = this.aiuT;
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (((localObject instanceof ab)) && (k.b(arrayOfLong, ((ab)localObject).data))) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(190776);
          return false;
        }
      }
    }
    AppMethodBeat.o(190776);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190806);
    long[] arrayOfLong = this.aiuT;
    if (((paramObject instanceof ac)) && (s.p(arrayOfLong, ((ac)paramObject).aiuT)))
    {
      AppMethodBeat.o(190806);
      return true;
    }
    AppMethodBeat.o(190806);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190799);
    long[] arrayOfLong = this.aiuT;
    if (arrayOfLong != null)
    {
      int i = Arrays.hashCode(arrayOfLong);
      AppMethodBeat.o(190799);
      return i;
    }
    AppMethodBeat.o(190799);
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return this.aiuT.length == 0;
  }
  
  public final Iterator<ab> iterator()
  {
    AppMethodBeat.i(190761);
    Iterator localIterator = (Iterator)new a(this.aiuT);
    AppMethodBeat.o(190761);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(190830);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190830);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190835);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190835);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190841);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190841);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(190850);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(190850);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(190854);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(190854);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190790);
    Object localObject = this.aiuT;
    localObject = "ULongArray(storage=" + Arrays.toString((long[])localObject) + ")";
    AppMethodBeat.o(190790);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/ULongArray$Iterator;", "Lkotlin/collections/ULongIterator;", "array", "", "([J)V", "index", "", "hasNext", "", "nextULong", "Lkotlin/ULong;", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
    extends ax
  {
    private final long[] dTr;
    private int index;
    
    public a(long[] paramArrayOfLong)
    {
      AppMethodBeat.i(190808);
      this.dTr = paramArrayOfLong;
      AppMethodBeat.o(190808);
    }
    
    public final boolean hasNext()
    {
      return this.index < this.dTr.length;
    }
    
    public final long kkS()
    {
      AppMethodBeat.i(190821);
      if (this.index < this.dTr.length)
      {
        localObject = this.dTr;
        int i = this.index;
        this.index = (i + 1);
        long l = ab.J(localObject[i]);
        AppMethodBeat.o(190821);
        return l;
      }
      Object localObject = (Throwable)new NoSuchElementException(String.valueOf(this.index));
      AppMethodBeat.o(190821);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.ac
 * JD-Core Version:    0.7.0.1
 */