package android.support.v4.b;

import java.util.Collection;
import java.util.Iterator;

final class l
  implements Collection<V>
{
  l(g paramg) {}
  
  public final boolean add(V paramV)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection<? extends V> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    this.jr.bh();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.jr.k(paramObject) >= 0;
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
  
  public final boolean isEmpty()
  {
    return this.jr.bf() == 0;
  }
  
  public final Iterator<V> iterator()
  {
    return new h(this.jr, 1);
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = this.jr.k(paramObject);
    if (i >= 0)
    {
      this.jr.p(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    int j = this.jr.bf();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (paramCollection.contains(this.jr.b(i, 1)))
      {
        this.jr.p(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    int j = this.jr.bf();
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      int m = i;
      int k = j;
      if (!paramCollection.contains(this.jr.b(i, 1)))
      {
        this.jr.p(i);
        m = i - 1;
        k = j - 1;
        bool = true;
      }
      i = m + 1;
      j = k;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.jr.bf();
  }
  
  public final Object[] toArray()
  {
    return this.jr.s(1);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.jr.a(paramArrayOfT, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.l
 * JD-Core Version:    0.7.0.1
 */