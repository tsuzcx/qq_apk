package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
    k.h(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
  
  public static final class a
    extends f
  {
    public static final a Kaa;
    
    static
    {
      AppMethodBeat.i(61298);
      Kaa = new a();
      AppMethodBeat.o(61298);
    }
    
    private a()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61297);
      k.h(paramt, "functionDescriptor");
      if (paramt.fym() != null)
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
    public static final b Kab;
    
    static
    {
      AppMethodBeat.i(61300);
      Kab = new b();
      AppMethodBeat.o(61300);
    }
    
    private b()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61299);
      k.h(paramt, "functionDescriptor");
      if ((paramt.fym() != null) || (paramt.fyl() != null))
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