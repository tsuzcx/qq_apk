package android.arch.a.b;

import java.util.Map.Entry;

final class e<K, V>
  implements Map.Entry<K, V>
{
  final K n;
  final V o;
  e<K, V> p;
  e<K, V> q;
  
  e(K paramK, V paramV)
  {
    this.n = paramK;
    this.o = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
    } while ((this.n.equals(paramObject.n)) && (this.o.equals(paramObject.o)));
    return false;
  }
  
  public final K getKey()
  {
    return this.n;
  }
  
  public final V getValue()
  {
    return this.o;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public final String toString()
  {
    return this.n + "=" + this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.b.e
 * JD-Core Version:    0.7.0.1
 */