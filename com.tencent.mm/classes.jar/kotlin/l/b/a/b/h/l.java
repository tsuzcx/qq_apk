package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class l
  extends m
{
  private final q TDL;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59497);
    boolean bool = hJL().equals(paramObject);
    AppMethodBeat.o(59497);
    return bool;
  }
  
  public final q hJL()
  {
    AppMethodBeat.i(59495);
    q localq = d(this.TDL);
    AppMethodBeat.o(59495);
    return localq;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59496);
    int i = hJL().hashCode();
    AppMethodBeat.o(59496);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59498);
    String str = hJL().toString();
    AppMethodBeat.o(59498);
    return str;
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, l> bXF;
    
    private a(Map.Entry<K, l> paramEntry)
    {
      this.bXF = paramEntry;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(59489);
      Object localObject = this.bXF.getKey();
      AppMethodBeat.o(59489);
      return localObject;
    }
    
    public final Object getValue()
    {
      AppMethodBeat.i(59490);
      Object localObject = (l)this.bXF.getValue();
      if (localObject == null)
      {
        AppMethodBeat.o(59490);
        return null;
      }
      localObject = ((l)localObject).hJL();
      AppMethodBeat.o(59490);
      return localObject;
    }
    
    public final Object setValue(Object paramObject)
    {
      AppMethodBeat.i(59491);
      if (!(paramObject instanceof q))
      {
        paramObject = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        AppMethodBeat.o(59491);
        throw paramObject;
      }
      paramObject = ((l)this.bXF.getValue()).e((q)paramObject);
      AppMethodBeat.o(59491);
      return paramObject;
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> bXG;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.bXG = paramIterator;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(59492);
      boolean bool = this.bXG.hasNext();
      AppMethodBeat.o(59492);
      return bool;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59493);
      this.bXG.remove();
      AppMethodBeat.o(59493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.l
 * JD-Core Version:    0.7.0.1
 */