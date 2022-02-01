package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class w$a
{
  private static final Iterator<Object> dVn;
  private static final Iterable<Object> dVo;
  
  static
  {
    AppMethodBeat.i(59575);
    dVn = new w.a.1();
    dVo = new Iterable()
    {
      public final Iterator<Object> iterator()
      {
        AppMethodBeat.i(59574);
        Iterator localIterator = w.a.kyz();
        AppMethodBeat.o(59574);
        return localIterator;
      }
    };
    AppMethodBeat.o(59575);
  }
  
  static <T> Iterable<T> ajx()
  {
    return dVo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.w.a
 * JD-Core Version:    0.7.0.1
 */