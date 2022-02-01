package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractList;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "size", "", "getSize", "()I", "equals", "", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "element", "(Ljava/lang/Object;)I", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "IteratorImpl", "ListIteratorImpl", "SubList", "kotlin-stdlib"})
public abstract class b<E>
  extends a<E>
  implements d.g.b.a.a, List<E>
{
  public static final a MKs = new a((byte)0);
  
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
    p.h(localObject, "c");
    p.h(paramObject, "other");
    if (((Collection)localObject).size() != paramObject.size()) {
      return false;
    }
    paramObject = paramObject.iterator();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if ((p.i(((Iterator)localObject).next(), paramObject.next()) ^ true)) {
        return false;
      }
    }
    return true;
  }
  
  public abstract E get(int paramInt);
  
  public int hashCode()
  {
    Object localObject1 = (Collection)this;
    p.h(localObject1, "c");
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
      if (p.i(localIterator.next(), paramObject)) {
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
      if (p.i(localListIterator.previous(), paramObject)) {
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractList$Companion;", "", "()V", "checkBoundsIndexes", "", "startIndex", "", "endIndex", "size", "checkBoundsIndexes$kotlin_stdlib", "checkElementIndex", "index", "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "orderedEquals", "", "c", "", "other", "orderedEquals$kotlin_stdlib", "orderedHashCode", "orderedHashCode$kotlin_stdlib", "kotlin-stdlib"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
  class b
    implements d.g.b.a.a, Iterator<E>
  {
    int index;
    
    public boolean hasNext()
    {
      AppMethodBeat.i(129035);
      if (this.index < this.MKt.size())
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
      Object localObject = this.MKt;
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
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"})
  final class c
    extends b<E>.b
    implements d.g.b.a.a, ListIterator<E>
  {
    public c()
    {
      super();
      AppMethodBeat.i(129032);
      b.a locala = b.MKs;
      int j = b.this.size();
      int i;
      if ((i < 0) || (i > j))
      {
        this$1 = (Throwable)new IndexOutOfBoundsException("index: " + i + ", size: " + j);
        AppMethodBeat.o(129032);
        throw b.this;
      }
      this.index = i;
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
      return this.index > 0;
    }
    
    public final int nextIndex()
    {
      return this.index;
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
      this.index -= 1;
      localObject = ((b)localObject).get(this.index);
      AppMethodBeat.o(129031);
      return localObject;
    }
    
    public final int previousIndex()
    {
      return this.index - 1;
    }
    
    public final void set(E paramE)
    {
      AppMethodBeat.i(129034);
      paramE = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(129034);
      throw paramE;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"})
  static final class d<E>
    extends b<E>
    implements RandomAccess
  {
    private final b<E> MKu;
    private final int MKv;
    private int _size;
    
    public d(b<? extends E> paramb, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(129224);
      this.MKu = paramb;
      this.MKv = paramInt1;
      paramInt1 = this.MKv;
      int i = this.MKu.size();
      if ((paramInt1 < 0) || (paramInt2 > i))
      {
        paramb = (Throwable)new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2 + ", size: " + i);
        AppMethodBeat.o(129224);
        throw paramb;
      }
      if (paramInt1 > paramInt2)
      {
        paramb = (Throwable)new IllegalArgumentException("fromIndex: " + paramInt1 + " > toIndex: " + paramInt2);
        AppMethodBeat.o(129224);
        throw paramb;
      }
      this._size = (paramInt2 - this.MKv);
      AppMethodBeat.o(129224);
    }
    
    public final E get(int paramInt)
    {
      AppMethodBeat.i(129223);
      int i = this._size;
      if ((paramInt < 0) || (paramInt >= i))
      {
        localObject = (Throwable)new IndexOutOfBoundsException("index: " + paramInt + ", size: " + i);
        AppMethodBeat.o(129223);
        throw ((Throwable)localObject);
      }
      Object localObject = this.MKu.get(this.MKv + paramInt);
      AppMethodBeat.o(129223);
      return localObject;
    }
    
    public final int getSize()
    {
      return this._size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.b
 * JD-Core Version:    0.7.0.1
 */