package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;

public abstract class f
  implements b
{
  private final String description;
  
  private f(String paramString)
  {
    this.description = paramString;
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final String i(t paramt)
  {
    p.h(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends f
  {
    public static final a TQp;
    
    static
    {
      AppMethodBeat.i(61298);
      TQp = new a();
      AppMethodBeat.o(61298);
    }
    
    private a()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61297);
      p.h(paramt, "functionDescriptor");
      if (paramt.hAs() != null)
      {
        AppMethodBeat.o(61297);
        return true;
      }
      AppMethodBeat.o(61297);
      return false;
    }
  }
  
  public static final class b
    extends f
  {
    public static final b TQq;
    
    static
    {
      AppMethodBeat.i(61300);
      TQq = new b();
      AppMethodBeat.o(61300);
    }
    
    private b()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61299);
      p.h(paramt, "functionDescriptor");
      if ((paramt.hAs() != null) || (paramt.hAr() != null))
      {
        AppMethodBeat.o(61299);
        return true;
      }
      AppMethodBeat.o(61299);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.n.f
 * JD-Core Version:    0.7.0.1
 */