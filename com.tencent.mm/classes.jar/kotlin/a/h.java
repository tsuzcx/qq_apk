package kotlin.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/AbstractSet;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", "other", "", "hashCode", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class h<E>
  extends a<E>
  implements Set<E>
{
  public static final a aivj = new a((byte)0);
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == (h)this) {
      return true;
    }
    if (!(paramObject instanceof Set)) {
      return false;
    }
    Set localSet = (Set)this;
    paramObject = (Set)paramObject;
    s.u(localSet, "c");
    s.u(paramObject, "other");
    if (localSet.size() != paramObject.size()) {
      return false;
    }
    return ((Collection)localSet).containsAll((Collection)paramObject);
  }
  
  public int hashCode()
  {
    Object localObject1 = (Collection)this;
    s.u(localObject1, "c");
    localObject1 = ((Collection)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 != null) {}
      for (int j = localObject2.hashCode();; j = 0)
      {
        i = j + i;
        break;
      }
    }
    return i;
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/collections/AbstractSet$Companion;", "", "()V", "setEquals", "", "c", "", "other", "setEquals$kotlin_stdlib", "unorderedHashCode", "", "", "unorderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.a.h
 * JD-Core Version:    0.7.0.1
 */