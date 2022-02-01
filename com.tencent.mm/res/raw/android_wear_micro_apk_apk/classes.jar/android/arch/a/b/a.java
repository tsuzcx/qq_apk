package android.arch.a.b;

import java.util.HashMap;
import java.util.Map.Entry;

public final class a<K, V>
  extends b<K, V>
{
  private HashMap<K, e<K, V>> i = new HashMap();
  
  protected final e<K, V> a(K paramK)
  {
    return (e)this.i.get(paramK);
  }
  
  public final Map.Entry<K, V> b(K paramK)
  {
    if (contains(paramK)) {
      return ((e)this.i.get(paramK)).q;
    }
    return null;
  }
  
  public final boolean contains(K paramK)
  {
    return this.i.containsKey(paramK);
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    e locale = a(paramK);
    if (locale != null) {
      return locale.o;
    }
    this.i.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public final V remove(K paramK)
  {
    Object localObject = super.remove(paramK);
    this.i.remove(paramK);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.b.a
 * JD-Core Version:    0.7.0.1
 */