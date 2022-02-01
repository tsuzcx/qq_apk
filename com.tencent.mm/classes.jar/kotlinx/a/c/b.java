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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "jsonArray", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", "elements", "", "copy", "equals", "other", "", "get", "index", "getArray", "getArrayOrNull", "getAs", "J", "(I)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "Lkotlinx/serialization/json/JsonObject;", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"})
public final class b
  extends f
  implements List<f>, a
{
  public static final b.a TZo;
  private final b TZm;
  public final List<f> TZn;
  
  static
  {
    AppMethodBeat.i(225785);
    TZo = new b.a((byte)0);
    AppMethodBeat.o(225785);
  }
  
  public b(List<? extends f> paramList)
  {
    super((byte)0);
    AppMethodBeat.i(225784);
    this.TZn = paramList;
    this.TZm = ((b)this);
    AppMethodBeat.o(225784);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(225798);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225798);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(225799);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225799);
    throw paramCollection;
  }
  
  public final f awe(int paramInt)
  {
    AppMethodBeat.i(225789);
    Object localObject = this.TZn.get(paramInt);
    p.g(localObject, "get(...)");
    localObject = (f)localObject;
    AppMethodBeat.o(225789);
    return localObject;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(225800);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225800);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(225787);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(225787);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    boolean bool = this.TZn.contains(paramObject);
    AppMethodBeat.o(225787);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(225788);
    p.h(paramCollection, "elements");
    boolean bool = this.TZn.containsAll(paramCollection);
    AppMethodBeat.o(225788);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225782);
    boolean bool = p.j(this.TZn, paramObject);
    AppMethodBeat.o(225782);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225783);
    int i = this.TZn.hashCode();
    AppMethodBeat.o(225783);
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(225791);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(225791);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.TZn.indexOf(paramObject);
    AppMethodBeat.o(225791);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(225792);
    boolean bool = this.TZn.isEmpty();
    AppMethodBeat.o(225792);
    return bool;
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(225793);
    Iterator localIterator = this.TZn.iterator();
    AppMethodBeat.o(225793);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(225794);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(225794);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.TZn.lastIndexOf(paramObject);
    AppMethodBeat.o(225794);
    return i;
  }
  
  public final ListIterator<f> listIterator()
  {
    AppMethodBeat.i(225795);
    ListIterator localListIterator = this.TZn.listIterator();
    AppMethodBeat.o(225795);
    return localListIterator;
  }
  
  public final ListIterator<f> listIterator(int paramInt)
  {
    AppMethodBeat.i(225796);
    ListIterator localListIterator = this.TZn.listIterator(paramInt);
    AppMethodBeat.o(225796);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(225801);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225801);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(225802);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225802);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<f> paramUnaryOperator)
  {
    AppMethodBeat.i(225803);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225803);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(225804);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225804);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super f> paramComparator)
  {
    AppMethodBeat.i(225805);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225805);
    throw paramComparator;
  }
  
  public final List<f> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225797);
    List localList = this.TZn.subList(paramInt1, paramInt2);
    AppMethodBeat.o(225797);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(225810);
    Object[] arrayOfObject = i.w(this);
    AppMethodBeat.o(225810);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(225811);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(225811);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225781);
    Object localObject = (Iterable)this.TZn;
    CharSequence localCharSequence1 = (CharSequence)"[";
    CharSequence localCharSequence2 = (CharSequence)"]";
    localObject = j.a((Iterable)localObject, (CharSequence)",", localCharSequence1, localCharSequence2, 0, null, null, 56);
    AppMethodBeat.o(225781);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.b
 * JD-Core Version:    0.7.0.1
 */