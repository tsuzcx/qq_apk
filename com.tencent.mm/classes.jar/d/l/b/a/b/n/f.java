package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.t;

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
    public static final a NEo;
    
    static
    {
      AppMethodBeat.i(61298);
      NEo = new a();
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
      if (paramt.gio() != null)
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
    public static final b NEp;
    
    static
    {
      AppMethodBeat.i(61300);
      NEp = new b();
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
      if ((paramt.gio() != null) || (paramt.gin() != null))
      {
        AppMethodBeat.o(61299);
        return true;
      }
      AppMethodBeat.o(61299);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.n.f
 * JD-Core Version:    0.7.0.1
 */