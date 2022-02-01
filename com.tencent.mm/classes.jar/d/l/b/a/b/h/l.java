package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;

public final class l
  extends m
{
  private final q LAu;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59497);
    boolean bool = gay().equals(paramObject);
    AppMethodBeat.o(59497);
    return bool;
  }
  
  public final q gay()
  {
    AppMethodBeat.i(59495);
    q localq = d(this.LAu);
    AppMethodBeat.o(59495);
    return localq;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59496);
    int i = gay().hashCode();
    AppMethodBeat.o(59496);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59498);
    String str = gay().toString();
    AppMethodBeat.o(59498);
    return str;
  }
  
  static final class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, l> bTg;
    
    private a(Map.Entry<K, l> paramEntry)
    {
      this.bTg = paramEntry;
    }
    
    public final K getKey()
    {
      AppMethodBeat.i(59489);
      Object localObject = this.bTg.getKey();
      AppMethodBeat.o(59489);
      return localObject;
    }
    
    public final Object getValue()
    {
      AppMethodBeat.i(59490);
      Object localObject = (l)this.bTg.getValue();
      if (localObject == null)
      {
        AppMethodBeat.o(59490);
        return null;
      }
      localObject = ((l)localObject).gay();
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
      paramObject = ((l)this.bTg.getValue()).e((q)paramObject);
      AppMethodBeat.o(59491);
      return paramObject;
    }
  }
  
  static final class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> KTJ;
    
    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.KTJ = paramIterator;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(59492);
      boolean bool = this.KTJ.hasNext();
      AppMethodBeat.o(59492);
      return bool;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(59493);
      this.KTJ.remove();
      AppMethodBeat.o(59493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.h.l
 * JD-Core Version:    0.7.0.1
 */