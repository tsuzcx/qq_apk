package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.a.av;
import kotlin.a.k;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "size", "", "constructor-impl", "(I)[B", "storage", "", "([B)[B", "getSize-impl", "([B)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([BLjava/lang/Object;)Z", "get", "index", "get-w2LRezQ", "([BI)B", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([B)Z", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "set", "", "value", "set-VurrAj0", "([BIB)V", "toString", "", "toString-impl", "([B)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class y
  implements Collection<x>, a
{
  public final byte[] aiuP;
  
  public final boolean addAll(Collection<? extends x> paramCollection)
  {
    AppMethodBeat.i(191294);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191294);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191301);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191301);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191258);
    byte[] arrayOfByte = this.aiuP;
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (((localObject instanceof x)) && (k.contains(arrayOfByte, ((x)localObject).data))) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(191258);
          return false;
        }
      }
    }
    AppMethodBeat.o(191258);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191289);
    byte[] arrayOfByte = this.aiuP;
    if (((paramObject instanceof y)) && (s.p(arrayOfByte, ((y)paramObject).aiuP)))
    {
      AppMethodBeat.o(191289);
      return true;
    }
    AppMethodBeat.o(191289);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191279);
    byte[] arrayOfByte = this.aiuP;
    if (arrayOfByte != null)
    {
      int i = Arrays.hashCode(arrayOfByte);
      AppMethodBeat.o(191279);
      return i;
    }
    AppMethodBeat.o(191279);
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return this.aiuP.length == 0;
  }
  
  public final Iterator<x> iterator()
  {
    AppMethodBeat.i(191245);
    Iterator localIterator = (Iterator)new a(this.aiuP);
    AppMethodBeat.o(191245);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191308);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191308);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191315);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191315);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191323);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191323);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(191336);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(191336);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191338);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(191338);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191273);
    Object localObject = this.aiuP;
    localObject = "UByteArray(storage=" + Arrays.toString((byte[])localObject) + ")";
    AppMethodBeat.o(191273);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/UByteArray$Iterator;", "Lkotlin/collections/UByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextUByte", "Lkotlin/UByte;", "nextUByte-w2LRezQ", "()B", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
    extends av
  {
    private final byte[] array;
    private int index;
    
    public a(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(190773);
      this.array = paramArrayOfByte;
      AppMethodBeat.o(190773);
    }
    
    public final boolean hasNext()
    {
      return this.index < this.array.length;
    }
    
    public final byte kkQ()
    {
      AppMethodBeat.i(190785);
      if (this.index < this.array.length)
      {
        localObject = this.array;
        int i = this.index;
        this.index = (i + 1);
        byte b = x.n(localObject[i]);
        AppMethodBeat.o(190785);
        return b;
      }
      Object localObject = (Throwable)new NoSuchElementException(String.valueOf(this.index));
      AppMethodBeat.o(190785);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.y
 * JD-Core Version:    0.7.0.1
 */