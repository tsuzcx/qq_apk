package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  private e<K, V> j;
  private e<K, V> k;
  private WeakHashMap<h<K, V>, Boolean> l = new WeakHashMap();
  private int m = 0;
  
  protected e<K, V> a(K paramK)
  {
    for (e locale = this.j; (locale != null) && (!locale.n.equals(paramK)); locale = locale.p) {}
    return locale;
  }
  
  protected final e<K, V> a(K paramK, V paramV)
  {
    paramK = new e(paramK, paramV);
    this.m += 1;
    if (this.k == null)
    {
      this.j = paramK;
      this.k = this.j;
      return paramK;
    }
    this.k.p = paramK;
    paramK.q = this.k;
    this.k = paramK;
    return paramK;
  }
  
  public final b<K, V>.f c()
  {
    f localf = new f(this, (byte)0);
    this.l.put(localf, Boolean.FALSE);
    return localf;
  }
  
  public final Map.Entry<K, V> d()
  {
    return this.j;
  }
  
  public final Iterator<Map.Entry<K, V>> descendingIterator()
  {
    d locald = new d(this.k, this.j);
    this.l.put(locald, Boolean.FALSE);
    return locald;
  }
  
  public final Map.Entry<K, V> e()
  {
    return this.k;
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
    if (this.m != ((b)localObject1).m) {
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
    c localc = new c(this.j, this.k);
    this.l.put(localc, Boolean.FALSE);
    return localc;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    e locale = a(paramK);
    if (locale != null) {
      return locale.o;
    }
    a(paramK, paramV);
    return null;
  }
  
  public V remove(K paramK)
  {
    paramK = a(paramK);
    if (paramK == null) {
      return null;
    }
    this.m -= 1;
    if (!this.l.isEmpty())
    {
      Iterator localIterator = this.l.keySet().iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).c(paramK);
      }
    }
    if (paramK.q != null)
    {
      paramK.q.p = paramK.p;
      if (paramK.p == null) {
        break label134;
      }
      paramK.p.q = paramK.q;
    }
    for (;;)
    {
      paramK.p = null;
      paramK.q = null;
      return paramK.o;
      this.j = paramK.p;
      break;
      label134:
      this.k = paramK.q;
    }
  }
  
  public final int size()
  {
    return this.m;
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
 * Qualified Name:     android.arch.a.b.b
 * JD-Core Version:    0.7.0.1
 */