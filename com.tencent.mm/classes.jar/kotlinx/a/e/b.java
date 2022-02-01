package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class b
  extends e
  implements List<e>, a
{
  public static final a ajEe;
  private final List<e> ajEd;
  
  static
  {
    AppMethodBeat.i(188482);
    ajEe = new a((byte)0);
    AppMethodBeat.o(188482);
  }
  
  public b(List<? extends e> paramList)
  {
    super((byte)0);
    AppMethodBeat.i(188471);
    this.ajEd = paramList;
    AppMethodBeat.o(188471);
  }
  
  public final e aMM(int paramInt)
  {
    AppMethodBeat.i(188547);
    Object localObject = this.ajEd.get(paramInt);
    s.s(localObject, "get(...)");
    localObject = (e)localObject;
    AppMethodBeat.o(188547);
    return localObject;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends e> paramCollection)
  {
    AppMethodBeat.i(188648);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188648);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends e> paramCollection)
  {
    AppMethodBeat.i(188659);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188659);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(188673);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188673);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(188527);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(188527);
      return false;
    }
    paramObject = (e)paramObject;
    s.u(paramObject, "element");
    boolean bool = this.ajEd.contains(paramObject);
    AppMethodBeat.o(188527);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(188537);
    s.u(paramCollection, "elements");
    boolean bool = this.ajEd.containsAll(paramCollection);
    AppMethodBeat.o(188537);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188494);
    boolean bool = s.p(this.ajEd, paramObject);
    AppMethodBeat.o(188494);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188501);
    int i = this.ajEd.hashCode();
    AppMethodBeat.o(188501);
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(188570);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(188570);
      return -1;
    }
    paramObject = (e)paramObject;
    s.u(paramObject, "element");
    int i = this.ajEd.indexOf(paramObject);
    AppMethodBeat.o(188570);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(188581);
    boolean bool = this.ajEd.isEmpty();
    AppMethodBeat.o(188581);
    return bool;
  }
  
  public final Iterator<e> iterator()
  {
    AppMethodBeat.i(188592);
    Iterator localIterator = this.ajEd.iterator();
    AppMethodBeat.o(188592);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(188602);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(188602);
      return -1;
    }
    paramObject = (e)paramObject;
    s.u(paramObject, "element");
    int i = this.ajEd.lastIndexOf(paramObject);
    AppMethodBeat.o(188602);
    return i;
  }
  
  public final ListIterator<e> listIterator()
  {
    AppMethodBeat.i(188612);
    ListIterator localListIterator = this.ajEd.listIterator();
    AppMethodBeat.o(188612);
    return localListIterator;
  }
  
  public final ListIterator<e> listIterator(int paramInt)
  {
    AppMethodBeat.i(188621);
    ListIterator localListIterator = this.ajEd.listIterator(paramInt);
    AppMethodBeat.o(188621);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(188682);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188682);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(188694);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188694);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<e> paramUnaryOperator)
  {
    AppMethodBeat.i(188707);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188707);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(188716);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188716);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super e> paramComparator)
  {
    AppMethodBeat.i(188724);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188724);
    throw paramComparator;
  }
  
  public final List<e> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188635);
    List localList = this.ajEd.subList(paramInt1, paramInt2);
    AppMethodBeat.o(188635);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(188764);
    Object[] arrayOfObject = j.L(this);
    AppMethodBeat.o(188764);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(188769);
    paramArrayOfT = j.b(this, paramArrayOfT);
    AppMethodBeat.o(188769);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188510);
    Object localObject = (Iterable)this.ajEd;
    CharSequence localCharSequence1 = (CharSequence)"[";
    CharSequence localCharSequence2 = (CharSequence)"]";
    localObject = p.a((Iterable)localObject, (CharSequence)",", localCharSequence1, localCharSequence2, 0, null, null, 56);
    AppMethodBeat.o(188510);
    return localObject;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.e.b
 * JD-Core Version:    0.7.0.1
 */