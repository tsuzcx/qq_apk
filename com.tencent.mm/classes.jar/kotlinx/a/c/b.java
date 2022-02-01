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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "", "content", "(Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "jsonArray", "getJsonArray", "()Lkotlinx/serialization/json/JsonArray;", "size", "", "getSize", "()I", "component1", "contains", "", "element", "containsAll", "elements", "", "copy", "equals", "other", "", "get", "index", "getArray", "getArrayOrNull", "getAs", "J", "(I)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "Lkotlinx/serialization/json/JsonObject;", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "Companion", "kotlinx-serialization-runtime"})
public final class b
  extends f
  implements a, List<f>
{
  public static final a NNn;
  private final b NNl;
  public final List<f> NNm;
  
  static
  {
    AppMethodBeat.i(191424);
    NNn = new a((byte)0);
    AppMethodBeat.o(191424);
  }
  
  public b(List<? extends f> paramList)
  {
    super((byte)0);
    AppMethodBeat.i(191423);
    this.NNm = paramList;
    this.NNl = ((b)this);
    AppMethodBeat.o(191423);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(191437);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191437);
    throw paramCollection;
  }
  
  public final boolean addAll(Collection<? extends f> paramCollection)
  {
    AppMethodBeat.i(191438);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191438);
    throw paramCollection;
  }
  
  public final f alL(int paramInt)
  {
    AppMethodBeat.i(191428);
    Object localObject = this.NNm.get(paramInt);
    p.g(localObject, "get(...)");
    localObject = (f)localObject;
    AppMethodBeat.o(191428);
    return localObject;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191439);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191439);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(191426);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(191426);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    boolean bool = this.NNm.contains(paramObject);
    AppMethodBeat.o(191426);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191427);
    p.h(paramCollection, "elements");
    boolean bool = this.NNm.containsAll(paramCollection);
    AppMethodBeat.o(191427);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191421);
    boolean bool = p.i(this.NNm, paramObject);
    AppMethodBeat.o(191421);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191422);
    int i = this.NNm.hashCode();
    AppMethodBeat.o(191422);
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(191430);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(191430);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.NNm.indexOf(paramObject);
    AppMethodBeat.o(191430);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191431);
    boolean bool = this.NNm.isEmpty();
    AppMethodBeat.o(191431);
    return bool;
  }
  
  public final Iterator<f> iterator()
  {
    AppMethodBeat.i(191432);
    Iterator localIterator = this.NNm.iterator();
    AppMethodBeat.o(191432);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(191433);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(191433);
      return -1;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "element");
    int i = this.NNm.lastIndexOf(paramObject);
    AppMethodBeat.o(191433);
    return i;
  }
  
  public final ListIterator<f> listIterator()
  {
    AppMethodBeat.i(191434);
    ListIterator localListIterator = this.NNm.listIterator();
    AppMethodBeat.o(191434);
    return localListIterator;
  }
  
  public final ListIterator<f> listIterator(int paramInt)
  {
    AppMethodBeat.i(191435);
    ListIterator localListIterator = this.NNm.listIterator(paramInt);
    AppMethodBeat.o(191435);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(191440);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191440);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191441);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191441);
    throw paramCollection;
  }
  
  public final void replaceAll(UnaryOperator<f> paramUnaryOperator)
  {
    AppMethodBeat.i(191442);
    paramUnaryOperator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191442);
    throw paramUnaryOperator;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(191443);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191443);
    throw paramCollection;
  }
  
  public final void sort(Comparator<? super f> paramComparator)
  {
    AppMethodBeat.i(191444);
    paramComparator = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191444);
    throw paramComparator;
  }
  
  public final List<f> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191436);
    List localList = this.NNm.subList(paramInt1, paramInt2);
    AppMethodBeat.o(191436);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(191449);
    Object[] arrayOfObject = i.t(this);
    AppMethodBeat.o(191449);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191450);
    paramArrayOfT = i.a(this, paramArrayOfT);
    AppMethodBeat.o(191450);
    return paramArrayOfT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191420);
    Object localObject = (Iterable)this.NNm;
    CharSequence localCharSequence1 = (CharSequence)"[";
    CharSequence localCharSequence2 = (CharSequence)"]";
    localObject = j.a((Iterable)localObject, (CharSequence)",", localCharSequence1, localCharSequence2, 0, null, null, 56);
    AppMethodBeat.o(191420);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonArray$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonArray;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.b
 * JD-Core Version:    0.7.0.1
 */