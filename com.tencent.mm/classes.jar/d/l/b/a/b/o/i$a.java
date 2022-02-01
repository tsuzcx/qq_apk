package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.a.d;
import d.g.b.b;
import java.util.Iterator;

final class i$a<T>
  implements d, Iterator<T>
{
  private final Iterator<T> NGg;
  
  public i$a(T[] paramArrayOfT)
  {
    AppMethodBeat.i(61394);
    this.NGg = b.ae(paramArrayOfT);
    AppMethodBeat.o(61394);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(61391);
    boolean bool = this.NGg.hasNext();
    AppMethodBeat.o(61391);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(61392);
    Object localObject = this.NGg.next();
    AppMethodBeat.o(61392);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.b.a.b.o.i.a
 * JD-Core Version:    0.7.0.1
 */