package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class v$a
{
  private static final Iterator<Object> NPa;
  private static final Iterable<Object> NPb;
  
  static
  {
    AppMethodBeat.i(59575);
    NPa = new Iterator()
    {
      public final boolean hasNext()
      {
        return false;
      }
      
      public final Object next()
      {
        AppMethodBeat.i(59572);
        NoSuchElementException localNoSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(59572);
        throw localNoSuchElementException;
      }
      
      public final void remove()
      {
        AppMethodBeat.i(59573);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(59573);
        throw localUnsupportedOperationException;
      }
    };
    NPb = new Iterable()
    {
      public final Iterator<Object> iterator()
      {
        AppMethodBeat.i(59574);
        Iterator localIterator = v.a.gwM();
        AppMethodBeat.o(59574);
        return localIterator;
      }
    };
    AppMethodBeat.o(59575);
  }
  
  static <T> Iterable<T> gwL()
  {
    return NPb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.h.v.a
 * JD-Core Version:    0.7.0.1
 */