package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.a.a;
import d.g.b.i;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "jsonArray", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", "elements", "", "copy", "equals", "other", "", "get", "index", "getArray", "getArrayOrNull", "getAs", "J", "(I)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "Lkotlinx/serialization/json/JsonObject;", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"})
public final class b
  extends f
  implements a, List<f>
{
  public static final a Okt;
  private final b Okr;
  public final List<f> Oks;
  
  static
  {
    AppMethodBeat.i(200012);
    Okt = new a((byte)0);
    AppMethodBeat.o(200012);
  }
  
  public b(List<? extends f> paramList)
  {
    super((byte)0);
    AppMethodBeat.i(200011);
    this.Oks = paramList;
    this.Okr = ((b)this);
    AppMethodBeat.o(200011);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(200025);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200025);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(200026);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200026);
    throw paramCollection;
  }
  
  public final f amv(int paramInt)
  {
    AppMethodBeat.i(200016);
    Object localObject = this.Oks.get(paramInt);
    p.g(localObject, "get(...)");
    localObject = (f)localObject;
    AppMethodBeat.o(200016);
    return localObject;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200027);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200027);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(200014);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(200014);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    boolean bool = this.Oks.contains(paramObject);
    AppMethodBeat.o(200014);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200015);
    p.h(paramCollection, "elements");
    boolean bool = this.Oks.containsAll(paramCollection);
    AppMethodBeat.o(200015);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200009);
    boolean bool = p.i(this.Oks, paramObject);
    AppMethodBeat.o(200009);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(200010);
    int i = this.Oks.hashCode();
    AppMethodBeat.o(200010);
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(200018);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(200018);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.Oks.indexOf(paramObject);
    AppMethodBeat.o(200018);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(200019);
    boolean bool = this.Oks.isEmpty();
    AppMethodBeat.o(200019);
    return bool;
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(200020);
    Iterator localIterator = this.Oks.iterator();
    AppMethodBeat.o(200020);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(200021);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(200021);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.Oks.lastIndexOf(paramObject);
    AppMethodBeat.o(200021);
    return i;
  }
  
  public final ListIterator<f> listIterator()
  {
    AppMethodBeat.i(200022);
    ListIterator localListIterator = this.Oks.listIterator();
    AppMethodBeat.o(200022);
    return localListIterator;
  }
  
  public final ListIterator<f> listIterator(int paramInt)
  {
    AppMethodBeat.i(200023);
    ListIterator localListIterator = this.Oks.listIterator(paramInt);
    AppMethodBeat.o(200023);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(200028);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200028);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200029);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200029);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<f> paramUnaryOperator)
  {
    AppMethodBeat.i(200030);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200030);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(200031);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200031);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super f> paramComparator)
  {
    AppMethodBeat.i(200032);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200032);
    throw paramComparator;
  }
  
  public final List<f> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200024);
    List localList = this.Oks.subList(paramInt1, paramInt2);
    AppMethodBeat.o(200024);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(200037);
    Object[] arrayOfObject = i.t(this);
    AppMethodBeat.o(200037);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(200038);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(200038);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200008);
    Object localObject = (Iterable)this.Oks;
    CharSequence localCharSequence1 = (CharSequence)"[";
    CharSequence localCharSequence2 = (CharSequence)"]";
    localObject = j.a((Iterable)localObject, (CharSequence)",", localCharSequence1, localCharSequence2, 0, null, null, 56);
    AppMethodBeat.o(200008);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.b
 * JD-Core Version:    0.7.0.1
 */