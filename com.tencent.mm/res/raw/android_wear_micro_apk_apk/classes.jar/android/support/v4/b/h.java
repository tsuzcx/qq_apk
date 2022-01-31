package android.support.v4.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class h<T>
  implements Iterator<T>
{
  int ac;
  int e;
  final int jp;
  boolean jq = false;
  
  h(g paramg, int paramInt)
  {
    this.jp = paramInt;
    this.e = paramg.bf();
  }
  
  public final boolean hasNext()
  {
    return this.ac < this.e;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = this.jr.b(this.ac, this.jp);
    this.ac += 1;
    this.jq = true;
    return localObject;
  }
  
  public final void remove()
  {
    if (!this.jq) {
      throw new IllegalStateException();
    }
    this.ac -= 1;
    this.e -= 1;
    this.jq = false;
    this.jr.p(this.ac);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.h
 * JD-Core Version:    0.7.0.1
 */