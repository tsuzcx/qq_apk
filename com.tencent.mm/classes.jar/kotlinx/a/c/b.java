package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.a.j;
import kotlin.g.b.a.a;
import kotlin.g.b.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "jsonArray", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", "elements", "", "copy", "equals", "other", "", "get", "index", "getArray", "getArrayOrNull", "getAs", "J", "(I)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "Lkotlinx/serialization/json/JsonObject;", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"})
public final class b
  extends f
  implements List<f>, a
{
  public static final a abCE;
  private final b abCC;
  public final List<f> abCD;
  
  static
  {
    AppMethodBeat.i(256805);
    abCE = new a((byte)0);
    AppMethodBeat.o(256805);
  }
  
  public b(List<? extends f> paramList)
  {
    super((byte)0);
    AppMethodBeat.i(256803);
    this.abCD = paramList;
    this.abCC = ((b)this);
    AppMethodBeat.o(256803);
  }
  
  public final f aFZ(int paramInt)
  {
    AppMethodBeat.i(256810);
    Object localObject = this.abCD.get(paramInt);
    p.j(localObject, "get(...)");
    localObject = (f)localObject;
    AppMethodBeat.o(256810);
    return localObject;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(256829);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256829);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(256830);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256830);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(256832);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256832);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(256808);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(256808);
      return false;
    }
    paramObject = (f)paramObject;
    p.k(paramObject, "element");
    boolean bool = this.abCD.contains(paramObject);
    AppMethodBeat.o(256808);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(256809);
    p.k(paramCollection, "elements");
    boolean bool = this.abCD.containsAll(paramCollection);
    AppMethodBeat.o(256809);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256800);
    boolean bool = p.h(this.abCD, paramObject);
    AppMethodBeat.o(256800);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256801);
    int i = this.abCD.hashCode();
    AppMethodBeat.o(256801);
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(256814);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(256814);
      return -1;
    }
    paramObject = (f)paramObject;
    p.k(paramObject, "element");
    int i = this.abCD.indexOf(paramObject);
    AppMethodBeat.o(256814);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(256817);
    boolean bool = this.abCD.isEmpty();
    AppMethodBeat.o(256817);
    return bool;
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(256819);
    Iterator localIterator = this.abCD.iterator();
    AppMethodBeat.o(256819);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(256821);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(256821);
      return -1;
    }
    paramObject = (f)paramObject;
    p.k(paramObject, "element");
    int i = this.abCD.lastIndexOf(paramObject);
    AppMethodBeat.o(256821);
    return i;
  }
  
  public final ListIterator<f> listIterator()
  {
    AppMethodBeat.i(256822);
    ListIterator localListIterator = this.abCD.listIterator();
    AppMethodBeat.o(256822);
    return localListIterator;
  }
  
  public final ListIterator<f> listIterator(int paramInt)
  {
    AppMethodBeat.i(256826);
    ListIterator localListIterator = this.abCD.listIterator(paramInt);
    AppMethodBeat.o(256826);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(256833);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256833);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(256834);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256834);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<f> paramUnaryOperator)
  {
    AppMethodBeat.i(256835);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256835);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(256838);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256838);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super f> paramComparator)
  {
    AppMethodBeat.i(256839);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(256839);
    throw paramComparator;
  }
  
  public final List<f> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256828);
    List localList = this.abCD.subList(paramInt1, paramInt2);
    AppMethodBeat.o(256828);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(256846);
    Object[] arrayOfObject = i.u(this);
    AppMethodBeat.o(256846);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(256847);
    paramArrayOfT = i.b(this, paramArrayOfT);
    AppMethodBeat.o(256847);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256799);
    Object localObject = (Iterable)this.abCD;
    CharSequence localCharSequence1 = (CharSequence)"[";
    CharSequence localCharSequence2 = (CharSequence)"]";
    localObject = j.a((Iterable)localObject, (CharSequence)",", localCharSequence1, localCharSequence2, 0, null, null, 56);
    AppMethodBeat.o(256799);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c.b
 * JD-Core Version:    0.7.0.1
 */