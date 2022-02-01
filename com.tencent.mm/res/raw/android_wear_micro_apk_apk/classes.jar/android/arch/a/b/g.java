package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

abstract class g<K, V>
  implements h<K, V>, Iterator<Map.Entry<K, V>>
{
  e<K, V> p;
  e<K, V> u;
  
  g(e<K, V> parame1, e<K, V> parame2)
  {
    this.u = parame2;
    this.p = parame1;
  }
  
  private e<K, V> f()
  {
    if ((this.p == this.u) || (this.u == null)) {
      return null;
    }
    return a(this.p);
  }
  
  abstract e<K, V> a(e<K, V> parame);
  
  abstract e<K, V> b(e<K, V> parame);
  
  public final void c(e<K, V> parame)
  {
    if ((this.u == parame) && (parame == this.p))
    {
      this.p = null;
      this.u = null;
    }
    if (this.u == parame) {
      this.u = b(this.u);
    }
    if (this.p == parame) {
      this.p = f();
    }
  }
  
  public boolean hasNext()
  {
    return this.p != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.b.g
 * JD-Core Version:    0.7.0.1
 */