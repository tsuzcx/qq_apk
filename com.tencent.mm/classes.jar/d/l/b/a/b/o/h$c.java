package d.l.b.a.b.o;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class h$c<T>
  implements Iterator<T>
{
  private boolean NGe;
  
  protected abstract T gus();
  
  protected abstract void gut();
  
  public final boolean hasNext()
  {
    return !this.NGe;
  }
  
  public final T next()
  {
    if (this.NGe) {
      throw new NoSuchElementException();
    }
    this.NGe = true;
    gut();
    return gus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.h.c
 * JD-Core Version:    0.7.0.1
 */