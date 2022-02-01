package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.a.aw;
import kotlin.a.k;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "size", "", "constructor-impl", "(I)[I", "storage", "", "([I)[I", "getSize-impl", "([I)I", "getStorage$annotations", "()V", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "equals", "other", "", "equals-impl", "([ILjava/lang/Object;)Z", "get", "index", "get-pVg5ArA", "([II)I", "hashCode", "hashCode-impl", "isEmpty", "isEmpty-impl", "([I)Z", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "set", "", "value", "set-VXSXFK8", "([III)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "Iterator", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class aa
  implements Collection<z>, a
{
  public final int[] aiuR;
  
  public final boolean addAll(Collection<? extends z> paramCollection)
  {
    AppMethodBeat.i(190818);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190818);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(190826);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190826);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190781);
    int[] arrayOfInt = this.aiuR;
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (((localObject instanceof z)) && (k.contains(arrayOfInt, ((z)localObject).data))) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(190781);
          return false;
        }
      }
    }
    AppMethodBeat.o(190781);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190811);
    int[] arrayOfInt = this.aiuR;
    if (((paramObject instanceof aa)) && (s.p(arrayOfInt, ((aa)paramObject).aiuR)))
    {
      AppMethodBeat.o(190811);
      return true;
    }
    AppMethodBeat.o(190811);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190802);
    int[] arrayOfInt = this.aiuR;
    if (arrayOfInt != null)
    {
      int i = Arrays.hashCode(arrayOfInt);
      AppMethodBeat.o(190802);
      return i;
    }
    AppMethodBeat.o(190802);
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return this.aiuR.length == 0;
  }
  
  public final Iterator<z> iterator()
  {
    AppMethodBeat.i(190769);
    Iterator localIterator = (Iterator)new a(this.aiuR);
    AppMethodBeat.o(190769);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(190833);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190833);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190836);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190836);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(190844);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(190844);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(190852);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(190852);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(190857);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(190857);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190796);
    Object localObject = this.aiuR;
    localObject = "UIntArray(storage=" + Arrays.toString((int[])localObject) + ")";
    AppMethodBeat.o(190796);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/UIntArray$Iterator;", "Lkotlin/collections/UIntIterator;", "array", "", "([I)V", "index", "", "hasNext", "", "nextUInt", "Lkotlin/UInt;", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class a
    extends aw
  {
    private final int[] dSQ;
    private int index;
    
    public a(int[] paramArrayOfInt)
    {
      AppMethodBeat.i(191207);
      this.dSQ = paramArrayOfInt;
      AppMethodBeat.o(191207);
    }
    
    public final boolean hasNext()
    {
      return this.index < this.dSQ.length;
    }
    
    public final int kkR()
    {
      AppMethodBeat.i(191217);
      if (this.index < this.dSQ.length)
      {
        localObject = this.dSQ;
        int i = this.index;
        this.index = (i + 1);
        i = z.aKc(localObject[i]);
        AppMethodBeat.o(191217);
        return i;
      }
      Object localObject = (Throwable)new NoSuchElementException(String.valueOf(this.index));
      AppMethodBeat.o(191217);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.aa
 * JD-Core Version:    0.7.0.1
 */