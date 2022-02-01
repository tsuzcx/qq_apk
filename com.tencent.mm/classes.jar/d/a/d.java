package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.a;
import d.g.b.b;
import d.g.b.f;
import d.g.b.k;
import d.l;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"})
final class d<T>
  implements a, Collection<T>
{
  private final boolean KTx;
  private final T[] anD;
  
  public d(T[] paramArrayOfT, boolean paramBoolean)
  {
    AppMethodBeat.i(129067);
    this.anD = paramArrayOfT;
    this.KTx = paramBoolean;
    AppMethodBeat.o(129067);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(129068);
    paramT = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129068);
    throw paramT;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(129069);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129069);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129070);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129070);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(129063);
    boolean bool = e.contains(this.anD, paramObject);
    AppMethodBeat.o(129063);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(129064);
    k.h(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(129064);
          return false;
        }
      }
    }
    AppMethodBeat.o(129064);
    return true;
  }
  
  public final boolean isEmpty()
  {
    return this.anD.length == 0;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(129065);
    Iterator localIterator = b.ad(this.anD);
    AppMethodBeat.o(129065);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(129071);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129071);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(129072);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129072);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(129073);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129073);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(129066);
    Object[] arrayOfObject = this.anD;
    boolean bool = this.KTx;
    k.h(arrayOfObject, "$this$copyToArrayOfAny");
    if ((bool) && (k.g(arrayOfObject.getClass(), [Ljava.lang.Object.class)))
    {
      AppMethodBeat.o(129066);
      return arrayOfObject;
    }
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Ljava.lang.Object.class);
    k.g(arrayOfObject, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
    AppMethodBeat.o(129066);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129074);
    paramArrayOfT = f.a(this, paramArrayOfT);
    AppMethodBeat.o(129074);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.d
 * JD-Core Version:    0.7.0.1
 */