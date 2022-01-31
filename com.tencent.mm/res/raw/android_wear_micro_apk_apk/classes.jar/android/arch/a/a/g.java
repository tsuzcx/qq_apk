package android.arch.a.a;

import java.util.Iterator;
import java.util.Map.Entry;

abstract class g<K, V>
  implements Iterator<Map.Entry<K, V>>
{
  e<K, V> h;
  e<K, V> m;
  
  g(e<K, V> parame1, e<K, V> parame2)
  {
    this.m = parame2;
    this.h = parame1;
  }
  
  abstract e<K, V> a(e<K, V> parame);
  
  public boolean hasNext()
  {
    return this.h != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.a.g
 * JD-Core Version:    0.7.0.1
 */