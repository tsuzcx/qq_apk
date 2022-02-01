package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;

final class m$a<K>
  implements Map.Entry<K, Object>
{
  private Map.Entry<K, m> bZw;
  
  private m$a(Map.Entry<K, m> paramEntry)
  {
    this.bZw = paramEntry;
  }
  
  public final K getKey()
  {
    AppMethodBeat.i(59489);
    Object localObject = this.bZw.getKey();
    AppMethodBeat.o(59489);
    return localObject;
  }
  
  public final Object getValue()
  {
    AppMethodBeat.i(59490);
    if ((m)this.bZw.getValue() == null)
    {
      AppMethodBeat.o(59490);
      return null;
    }
    AppMethodBeat.o(59490);
    throw null;
  }
  
  public final Object setValue(Object paramObject)
  {
    AppMethodBeat.i(59491);
    if (!(paramObject instanceof r))
    {
      paramObject = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      AppMethodBeat.o(59491);
      throw paramObject;
    }
    this.bZw.getValue();
    AppMethodBeat.o(59491);
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.h.m.a
 * JD-Core Version:    0.7.0.1
 */