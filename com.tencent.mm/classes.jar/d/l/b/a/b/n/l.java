package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.t;
import java.util.List;

public abstract class l
  implements b
{
  private final String description;
  
  private l(String paramString)
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
    extends l
  {
    private final int n;
    
    public a(int paramInt) {}
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61329);
      k.h(paramt, "functionDescriptor");
      if (paramt.fQU().size() >= this.n)
      {
        AppMethodBeat.o(61329);
        return true;
      }
      AppMethodBeat.o(61329);
      return false;
    }
  }
  
  public static final class b
    extends l
  {
    private final int n = 2;
    
    public b()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61331);
      k.h(paramt, "functionDescriptor");
      if (paramt.fQU().size() == this.n)
      {
        AppMethodBeat.o(61331);
        return true;
      }
      AppMethodBeat.o(61331);
      return false;
    }
  }
  
  public static final class c
    extends l
  {
    public static final c LOw;
    
    static
    {
      AppMethodBeat.i(61333);
      LOw = new c();
      AppMethodBeat.o(61333);
    }
    
    private c()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61332);
      k.h(paramt, "functionDescriptor");
      boolean bool = paramt.fQU().isEmpty();
      AppMethodBeat.o(61332);
      return bool;
    }
  }
  
  public static final class d
    extends l
  {
    public static final d LOx;
    
    static
    {
      AppMethodBeat.i(61335);
      LOx = new d();
      AppMethodBeat.o(61335);
    }
    
    private d()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61334);
      k.h(paramt, "functionDescriptor");
      if (paramt.fQU().size() == 1)
      {
        AppMethodBeat.o(61334);
        return true;
      }
      AppMethodBeat.o(61334);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.n.l
 * JD-Core Version:    0.7.0.1
 */