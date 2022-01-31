package android.arch.a.a;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private e<K, V> b;
  private e<K, V> c;
  private WeakHashMap<Object<K, V>, Boolean> d = new WeakHashMap();
  private int e = 0;
  
  public final b<K, V>.f a()
  {
    f localf = new f(this, (byte)0);
    this.d.put(localf, Boolean.valueOf(false));
    return localf;
  }
  
  public final Map.Entry<K, V> b()
  {
    return this.b;
  }
  
  public final Map.Entry<K, V> c()
  {
    return this.c;
  }
  
  public final Iterator<Map.Entry<K, V>> descendingIterator()
  {
    d locald = new d(this.c, this.b);
    this.d.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (this.e != ((b)localObject1).e) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2)))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    c localc = new c(this.b, this.c);
    this.d.put(localc, Boolean.valueOf(false));
    return localc;
  }
  
  public final int size()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.a.b
 * JD-Core Version:    0.7.0.1
 */