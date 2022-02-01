package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;

final class f
  implements h<K, V>, Iterator<Map.Entry<K, V>>
{
  private e<K, V> r;
  private boolean s = true;
  
  private f(b paramb) {}
  
  public final void c(e<K, V> parame)
  {
    if (parame == this.r)
    {
      this.r = this.r.q;
      if (this.r != null) {
        break label34;
      }
    }
    label34:
    for (boolean bool = true;; bool = false)
    {
      this.s = bool;
      return;
    }
  }
  
  public final boolean hasNext()
  {
    if (this.s) {
      if (b.a(this.t) == null) {}
    }
    while ((this.r != null) && (this.r.p != null))
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.b.f
 * JD-Core Version:    0.7.0.1
 */