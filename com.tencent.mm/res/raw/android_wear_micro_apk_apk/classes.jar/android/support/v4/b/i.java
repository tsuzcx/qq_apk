package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class i
  implements Set<Map.Entry<K, V>>
{
  i(g paramg) {}
  
  public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = this.lo.bw();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      this.lo.b(localEntry.getKey(), localEntry.getValue());
    }
    return i != this.lo.bw();
  }
  
  public final void clear()
  {
    this.lo.by();
  }
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    int i;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      i = this.lo.q(paramObject.getKey());
    } while (i < 0);
    return c.c(this.lo.b(i, 1), paramObject.getValue());
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
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
    int j = this.lo.bw() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject1 = this.lo.b(j, 0);
      Object localObject2 = this.lo.b(j, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label45:
        if (localObject2 != null) {
          break label76;
        }
      }
      label76:
      for (int m = 0;; m = localObject2.hashCode())
      {
        j -= 1;
        i += (m ^ k);
        break;
        k = localObject1.hashCode();
        break label45;
      }
    }
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.lo.bw() == 0;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return new k(this.lo);
  }
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    return this.lo.bw();
  }
  
  public final Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.i
 * JD-Core Version:    0.7.0.1
 */