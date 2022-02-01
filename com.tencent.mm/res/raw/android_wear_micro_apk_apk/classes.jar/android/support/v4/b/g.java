package android.support.v4.b;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class g<K, V>
{
  g<K, V>.i lj;
  g<K, V>.j lk;
  g<K, V>.l ll;
  
  public static <K, V> boolean a(Map<K, V> paramMap, Collection<?> paramCollection)
  {
    int i = paramMap.size();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!paramCollection.contains(localIterator.next())) {
        localIterator.remove();
      }
    }
    return i != paramMap.size();
  }
  
  public static <T> boolean a(Set<T> paramSet, Object paramObject)
  {
    if (paramSet == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        try
        {
          if (paramSet.size() == paramObject.size())
          {
            boolean bool = paramSet.containsAll(paramObject);
            if (bool) {}
          }
          else
          {
            return false;
          }
        }
        catch (NullPointerException paramSet)
        {
          return false;
        }
        catch (ClassCastException paramSet)
        {
          return false;
        }
      }
    }
    return false;
  }
  
  public final Object[] C(int paramInt)
  {
    int j = bw();
    Object[] arrayOfObject = new Object[j];
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = b(i, paramInt);
      i += 1;
    }
    return arrayOfObject;
  }
  
  protected abstract V a(int paramInt, V paramV);
  
  public final <T> T[] a(T[] paramArrayOfT, int paramInt)
  {
    int j = bw();
    if (paramArrayOfT.length < j) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        paramArrayOfT[i] = b(i, paramInt);
        i += 1;
      }
      if (paramArrayOfT.length > j) {
        paramArrayOfT[j] = null;
      }
      return paramArrayOfT;
    }
  }
  
  protected abstract Object b(int paramInt1, int paramInt2);
  
  protected abstract void b(K paramK, V paramV);
  
  public final Set<K> bB()
  {
    if (this.lk == null) {
      this.lk = new j(this);
    }
    return this.lk;
  }
  
  protected abstract int bw();
  
  protected abstract Map<K, V> bx();
  
  protected abstract void by();
  
  protected abstract int q(Object paramObject);
  
  protected abstract int r(Object paramObject);
  
  protected abstract void z(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.g
 * JD-Core Version:    0.7.0.1
 */