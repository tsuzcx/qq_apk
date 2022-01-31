package android.arch.a.a;

import java.util.Map.Entry;

final class e<K, V>
  implements Map.Entry<K, V>
{
  final K f;
  final V g;
  e<K, V> h;
  e<K, V> i;
  
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
    } while ((this.f.equals(paramObject.f)) && (this.g.equals(paramObject.g)));
    return false;
  }
  
  public final K getKey()
  {
    return this.f;
  }
  
  public final V getValue()
  {
    return this.g;
  }
  
  public final V setValue(V paramV)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public final String toString()
  {
    return this.f + "=" + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.a.e
 * JD-Core Version:    0.7.0.1
 */