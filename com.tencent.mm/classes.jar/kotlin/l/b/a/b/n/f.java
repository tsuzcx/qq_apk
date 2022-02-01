package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.x;

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
  
  public final String i(x paramx)
  {
    return b.a.a(this, paramx);
  }
  
  public static final class a
    extends f
  {
    public static final a ajse;
    
    static
    {
      AppMethodBeat.i(61298);
      ajse = new a();
      AppMethodBeat.o(61298);
    }
    
    private a()
    {
      super((byte)0);
    }
    
    public final boolean h(x paramx)
    {
      AppMethodBeat.i(61297);
      s.u(paramx, "functionDescriptor");
      if (paramx.knZ() != null)
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
    public static final b ajsf;
    
    static
    {
      AppMethodBeat.i(61300);
      ajsf = new b();
      AppMethodBeat.o(61300);
    }
    
    private b()
    {
      super((byte)0);
    }
    
    public final boolean h(x paramx)
    {
      AppMethodBeat.i(61299);
      s.u(paramx, "functionDescriptor");
      if ((paramx.knZ() != null) || (paramx.knY() != null))
      {
        AppMethodBeat.o(61299);
        return true;
      }
      AppMethodBeat.o(61299);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.f
 * JD-Core Version:    0.7.0.1
 */