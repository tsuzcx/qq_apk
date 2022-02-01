package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.d;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i$c<T>
  implements d, Iterator<T>
{
  private boolean JhL;
  private final T Jhw;
  
  public i$c(T paramT)
  {
    this.Jhw = paramT;
    this.JhL = true;
  }
  
  public final boolean hasNext()
  {
    return this.JhL;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61396);
    if (this.JhL)
    {
      this.JhL = false;
      localObject = this.Jhw;
      AppMethodBeat.o(61396);
      return localObject;
    }
    Object localObject = (Throwable)new NoSuchElementException();
    AppMethodBeat.o(61396);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.l.b.a.b.o.i.c
 * JD-Core Version:    0.7.0.1
 */