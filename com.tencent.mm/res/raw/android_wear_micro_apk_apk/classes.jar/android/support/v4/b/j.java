package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class j
  implements Set<K>
{
  j(g paramg) {}
  
  public final boolean add(K paramK)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection<? extends K> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    this.lo.by();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.lo.q(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    Map localMap = this.lo.bx();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!localMap.containsKey(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    return g.a(this, paramObject);
  }
  
  public final int hashCode()
  {
    int i = this.lo.bw() - 1;
    int j = 0;
    if (i >= 0)
    {
      Object localObject = this.lo.b(i, 0);
      if (localObject == null) {}
      for (int k = 0;; k = localObject.hashCode())
      {
        j += k;
        i -= 1;
        break;
      }
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this.lo.bw() == 0;
  }
  
  public final Iterator<K> iterator()
  {
    return new h(this.lo, 0);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = this.lo.q(paramObject);
    if (i >= 0)
    {
      this.lo.z(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    Map localMap = this.lo.bx();
    int i = localMap.size();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localMap.remove(paramCollection.next());
    }
    return i != localMap.size();
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    return g.a(this.lo.bx(), paramCollection);
  }
  
  public final int size()
  {
    return this.lo.bw();
  }
  
  public final Object[] toArray()
  {
    return this.lo.C(0);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.lo.a(paramArrayOfT, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.j
 * JD-Core Version:    0.7.0.1
 */