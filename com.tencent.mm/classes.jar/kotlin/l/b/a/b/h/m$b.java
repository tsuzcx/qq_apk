package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

final class m$b<K>
  implements Iterator<Map.Entry<K, Object>>
{
  private Iterator<Map.Entry<K, Object>> bZx;
  
  public m$b(Iterator<Map.Entry<K, Object>> paramIterator)
  {
    this.bZx = paramIterator;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(59492);
    boolean bool = this.bZx.hasNext();
    AppMethodBeat.o(59492);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(59493);
    this.bZx.remove();
    AppMethodBeat.o(59493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.m.b
 * JD-Core Version:    0.7.0.1
 */