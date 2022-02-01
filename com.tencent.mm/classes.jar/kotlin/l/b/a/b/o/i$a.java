package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.a.d;
import kotlin.g.b.b;

final class i$a<T>
  implements Iterator<T>, d
{
  private final Iterator<T> TSg;
  
  public i$a(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61394);
    this.TSg = b.af(paramArrayOfT);
    AppMethodBeat.o(61394);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(61391);
    boolean bool = this.TSg.hasNext();
    AppMethodBeat.o(61391);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61392);
    Object localObject = this.TSg.next();
    AppMethodBeat.o(61392);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.b.a.b.o.i.a
 * JD-Core Version:    0.7.0.1
 */