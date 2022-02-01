package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g.b.a.d;

final class f$c<T>
  implements Iterator<T>, d
{
  private final T aqH;
  private boolean aqS;
  
  public f$c(T paramT)
  {
    this.aqH = paramT;
    this.aqS = true;
  }
  
  public final boolean hasNext()
  {
    return this.aqS;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61396);
    if (this.aqS)
    {
      this.aqS = false;
      localObject = this.aqH;
      AppMethodBeat.o(61396);
      return localObject;
    }
    Object localObject = new NoSuchElementException();
    AppMethodBeat.o(61396);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.o.f.c
 * JD-Core Version:    0.7.0.1
 */