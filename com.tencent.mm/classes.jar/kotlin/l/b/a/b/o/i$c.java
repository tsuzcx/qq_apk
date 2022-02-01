package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.b.a.d;

final class i$c<T>
  implements Iterator<T>, d
{
  private final T SYG;
  private boolean SYY;
  
  public i$c(T paramT)
  {
    this.SYG = paramT;
    this.SYY = true;
  }
  
  public final boolean hasNext()
  {
    return this.SYY;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61396);
    if (this.SYY)
    {
      this.SYY = false;
      localObject = this.SYG;
      AppMethodBeat.o(61396);
      return localObject;
    }
    Object localObject = (Throwable)new NoSuchElementException();
    AppMethodBeat.o(61396);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.o.i.c
 * JD-Core Version:    0.7.0.1
 */