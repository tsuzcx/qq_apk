package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class h$a<T>
  implements Iterator<T>
{
  private static final a abuA;
  
  static
  {
    AppMethodBeat.i(61378);
    abuA = new a();
    AppMethodBeat.o(61378);
  }
  
  public static <T> a<T> iQn()
  {
    return abuA;
  }
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61376);
    NoSuchElementException localNoSuchElementException = new NoSuchElementException();
    AppMethodBeat.o(61376);
    throw localNoSuchElementException;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(61377);
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(61377);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.o.h.a
 * JD-Core Version:    0.7.0.1
 */