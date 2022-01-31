package android.support.v4.b;

import java.util.Iterator;
import java.util.Map.Entry;

final class k
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int ac;
  int js;
  boolean jt = false;
  
  k(g paramg)
  {
    this.js = (paramg.bf() - 1);
    this.ac = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!this.jt) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {}
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
    } while ((!c.b(paramObject.getKey(), this.jr.b(this.ac, 0))) || (!c.b(paramObject.getValue(), this.jr.b(this.ac, 1))));
    return true;
  }
  
  public final K getKey()
  {
    if (!this.jt) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.jr.b(this.ac, 0);
  }
  
  public final V getValue()
  {
    if (!this.jt) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.jr.b(this.ac, 1);
  }
  
  public final boolean hasNext()
  {
    return this.ac < this.js;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.jt) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.jr.b(this.ac, 0);
    Object localObject2 = this.jr.b(this.ac, 1);
    int i;
    if (localObject1 == null)
    {
      i = 0;
      if (localObject2 != null) {
        break label69;
      }
    }
    for (;;)
    {
      return j ^ i;
      i = localObject1.hashCode();
      break;
      label69:
      j = localObject2.hashCode();
    }
  }
  
  public final void remove()
  {
    if (!this.jt) {
      throw new IllegalStateException();
    }
    this.jr.p(this.ac);
    this.ac -= 1;
    this.js -= 1;
    this.jt = false;
  }
  
  public final V setValue(V paramV)
  {
    if (!this.jt) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.jr.a(this.ac, paramV);
  }
  
  public final String toString()
  {
    return getKey() + "=" + getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.k
 * JD-Core Version:    0.7.0.1
 */