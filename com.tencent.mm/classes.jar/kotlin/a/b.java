package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class b<E>
  extends a<E>
  implements List<E>
{
  public static final a aivb = new a((byte)0);
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == (b)this) {
      return true;
    }
    if (!(paramObject instanceof List)) {
      return false;
    }
    Object localObject = (Collection)this;
    paramObject = (Collection)paramObject;
    s.u(localObject, "c");
    s.u(paramObject, "other");
    if (((Collection)localObject).size() != paramObject.size()) {
      return false;
    }
    paramObject = paramObject.iterator();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((s.p(((Iterator)localObject).next(), paramObject.next()) ^ true)) {
        return false;
      }
    }
    return true;
  }
  
  public abstract E get(int paramInt);
  
  public int hashCode()
  {
    Object localObject1 = (Collection)this;
    s.u(localObject1, "c");
    int i = 1;
    localObject1 = ((Collection)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 != null) {}
      for (int j = localObject2.hashCode();; j = 0)
      {
        i = j + i * 31;
        break;
      }
    }
    return i;
  }
  
  public int indexOf(Object paramObject)
  {
    int i = 0;
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      if (s.p(localIterator.next(), paramObject)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public Iterator<E> iterator()
  {
    return (Iterator)new b();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    ListIterator localListIterator = listIterator(size());
    while (localListIterator.hasPrevious()) {
      if (s.p(localListIterator.previous(), paramObject)) {
        return localListIterator.nextIndex();
      }
    }
    return -1;
  }
  
  public ListIterator<E> listIterator()
  {
    return (ListIterator)new c(0);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return (ListIterator)new c(paramInt);
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return (List)new d(this, paramInt1, paramInt2);
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
  {
    public static void bM(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(191210);
      Throwable localThrowable;
      if ((paramInt1 < 0) || (paramInt2 > paramInt3))
      {
        localThrowable = (Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2 + ", size: " + paramInt3);
        AppMethodBeat.o(191210);
        throw localThrowable;
      }
      if (paramInt1 > paramInt2)
      {
        localThrowable = (Throwable)new IllegalArgumentException("fromIndex: " + paramInt1 + " > toIndex: " + paramInt2);
        AppMethodBeat.o(191210);
        throw localThrowable;
      }
      AppMethodBeat.o(191210);
    }
    
    public static void qj(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191193);
      if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
      {
        Throwable localThrowable = (Throwable)new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2);
        AppMethodBeat.o(191193);
        throw localThrowable;
      }
      AppMethodBeat.o(191193);
    }
    
    public static void qk(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(191201);
      if ((paramInt1 < 0) || (paramInt1 > paramInt2))
      {
        Throwable localThrowable = (Throwable)new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2);
        AppMethodBeat.o(191201);
        throw localThrowable;
      }
      AppMethodBeat.o(191201);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  class b
    implements Iterator<E>, kotlin.g.b.a.a
  {
    private int index;
    
    protected final int getIndex()
    {
      return this.index;
    }
    
    public boolean hasNext()
    {
      AppMethodBeat.i(129035);
      if (this.index < this.aivc.size())
      {
        AppMethodBeat.o(129035);
        return true;
      }
      AppMethodBeat.o(129035);
      return false;
    }
    
    public E next()
    {
      AppMethodBeat.i(129036);
      if (!hasNext())
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129036);
        throw ((Throwable)localObject);
      }
      Object localObject = this.aivc;
      int i = this.index;
      this.index = (i + 1);
      localObject = ((b)localObject).get(i);
      AppMethodBeat.o(129036);
      return localObject;
    }
    
    public void remove()
    {
      AppMethodBeat.i(129037);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129037);
      throw localUnsupportedOperationException;
    }
    
    protected final void setIndex(int paramInt)
    {
      this.index = paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  final class c
    extends b<E>.b
    implements ListIterator<E>
  {
    public c()
    {
      super();
      AppMethodBeat.i(129032);
      b.a locala = b.aivb;
      int i;
      b.a.qk(i, b.this.size());
      setIndex(i);
      AppMethodBeat.o(129032);
    }
    
    public final void add(E paramE)
    {
      AppMethodBeat.i(129033);
      paramE = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129033);
      throw paramE;
    }
    
    public final boolean hasPrevious()
    {
      AppMethodBeat.i(191200);
      if (getIndex() > 0)
      {
        AppMethodBeat.o(191200);
        return true;
      }
      AppMethodBeat.o(191200);
      return false;
    }
    
    public final int nextIndex()
    {
      AppMethodBeat.i(191206);
      int i = getIndex();
      AppMethodBeat.o(191206);
      return i;
    }
    
    public final E previous()
    {
      AppMethodBeat.i(129031);
      if (!hasPrevious())
      {
        localObject = (Throwable)new NoSuchElementException();
        AppMethodBeat.o(129031);
        throw ((Throwable)localObject);
      }
      Object localObject = b.this;
      setIndex(getIndex() - 1);
      localObject = ((b)localObject).get(getIndex());
      AppMethodBeat.o(129031);
      return localObject;
    }
    
    public final int previousIndex()
    {
      AppMethodBeat.i(191220);
      int i = getIndex();
      AppMethodBeat.o(191220);
      return i - 1;
    }
    
    public final void set(E paramE)
    {
      AppMethodBeat.i(129034);
      paramE = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129034);
      throw paramE;
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  static final class d<E>
    extends b<E>
    implements RandomAccess
  {
    private int _size;
    private final b<E> aivd;
    private final int aqt;
    
    public d(b<? extends E> paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129224);
      this.aivd = paramb;
      this.aqt = paramInt1;
      b.a.bM(this.aqt, paramInt2, this.aivd.size());
      this._size = (paramInt2 - this.aqt);
      AppMethodBeat.o(129224);
    }
    
    public final E get(int paramInt)
    {
      AppMethodBeat.i(129223);
      b.a.qj(paramInt, this._size);
      Object localObject = this.aivd.get(this.aqt + paramInt);
      AppMethodBeat.o(129223);
      return localObject;
    }
    
    public final int getSize()
    {
      return this._size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.a.b
 * JD-Core Version:    0.7.0.1
 */