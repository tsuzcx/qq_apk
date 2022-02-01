package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class m
  extends n
{
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59497);
    AppMethodBeat.o(59497);
    throw null;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59496);
    AppMethodBeat.o(59496);
    throw null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59498);
    AppMethodBeat.o(59498);
    throw null;
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, m> dTg;
    
    private a(Map.Entry<K, m> paramEntry)
    {
      this.dTg = paramEntry;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(59489);
      Object localObject = this.dTg.getKey();
      AppMethodBeat.o(59489);
      return localObject;
    }
    
    public final Object getValue()
    {
      AppMethodBeat.i(59490);
      if ((m)this.dTg.getValue() == null)
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
      this.dTg.getValue();
      AppMethodBeat.o(59491);
      throw null;
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> atq;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.atq = paramIterator;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(59492);
      boolean bool = this.atq.hasNext();
      AppMethodBeat.o(59492);
      return bool;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59493);
      this.atq.remove();
      AppMethodBeat.o(59493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.b.a.b.h.m
 * JD-Core Version:    0.7.0.1
 */