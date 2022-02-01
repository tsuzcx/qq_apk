package android.support.v4.b;

import java.util.Iterator;
import java.util.Map.Entry;

final class k
  implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V>
{
  int bL;
  int lp;
  boolean lq = false;
  
  k(g paramg)
  {
    this.lp = (paramg.bw() - 1);
    this.bL = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!this.lq) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    if (!(paramObject instanceof Map.Entry)) {}
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
    } while ((!c.c(paramObject.getKey(), this.lo.b(this.bL, 0))) || (!c.c(paramObject.getValue(), this.lo.b(this.bL, 1))));
    return true;
  }
  
  public final K getKey()
  {
    if (!this.lq) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.lo.b(this.bL, 0);
  }
  
  public final V getValue()
  {
    if (!this.lq) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.lo.b(this.bL, 1);
  }
  
  public final boolean hasNext()
  {
    return this.bL < this.lp;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (!this.lq) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    Object localObject1 = this.lo.b(this.bL, 0);
    Object localObject2 = this.lo.b(this.bL, 1);
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
    if (!this.lq) {
      throw new IllegalStateException();
    }
    this.lo.z(this.bL);
    this.bL -= 1;
    this.lp -= 1;
    this.lq = false;
  }
  
  public final V setValue(V paramV)
  {
    if (!this.lq) {
      throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }
    return this.lo.a(this.bL, paramV);
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