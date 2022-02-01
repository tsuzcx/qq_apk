package android.support.v4.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class h<T>
  implements Iterator<T>
{
  int bL;
  final int lm;
  boolean ln = false;
  int m;
  
  h(g paramg, int paramInt)
  {
    this.lm = paramInt;
    this.m = paramg.bw();
  }
  
  public final boolean hasNext()
  {
    return this.bL < this.m;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = this.lo.b(this.bL, this.lm);
    this.bL += 1;
    this.ln = true;
    return localObject;
  }
  
  public final void remove()
  {
    if (!this.ln) {
      throw new IllegalStateException();
    }
    this.bL -= 1;
    this.m -= 1;
    this.ln = false;
    this.lo.z(this.bL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.h
 * JD-Core Version:    0.7.0.1
 */