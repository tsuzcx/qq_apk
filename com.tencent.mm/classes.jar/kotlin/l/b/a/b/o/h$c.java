package kotlin.l.b.a.b.o;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class h$c<T>
  implements Iterator<T>
{
  private boolean abuD;
  
  public final boolean hasNext()
  {
    return !this.abuD;
  }
  
  protected abstract T iQo();
  
  protected abstract void iQp();
  
  public final T next()
  {
    if (this.abuD) {
      throw new NoSuchElementException();
    }
    this.abuD = true;
    iQp();
    return iQo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.o.h.c
 * JD-Core Version:    0.7.0.1
 */