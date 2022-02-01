package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.t;

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
    p.k(paramt, "functionDescriptor");
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
      p.k(paramt, "functionDescriptor");
      if (paramt.iEJ().size() >= this.n)
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
    private final int n;
    
    public b()
    {
      super((byte)0);
      AppMethodBeat.i(270680);
      this.n = 2;
      AppMethodBeat.o(270680);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61331);
      p.k(paramt, "functionDescriptor");
      if (paramt.iEJ().size() == this.n)
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
    public static final c abtS;
    
    static
    {
      AppMethodBeat.i(61333);
      abtS = new c();
      AppMethodBeat.o(61333);
    }
    
    private c()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61332);
      p.k(paramt, "functionDescriptor");
      boolean bool = paramt.iEJ().isEmpty();
      AppMethodBeat.o(61332);
      return bool;
    }
  }
  
  public static final class d
    extends l
  {
    public static final d abtT;
    
    static
    {
      AppMethodBeat.i(61335);
      abtT = new d();
      AppMethodBeat.o(61335);
    }
    
    private d()
    {
      super((byte)0);
    }
    
    public final boolean h(t paramt)
    {
      AppMethodBeat.i(61334);
      p.k(paramt, "functionDescriptor");
      if (paramt.iEJ().size() == 1)
      {
        AppMethodBeat.o(61334);
        return true;
      }
      AppMethodBeat.o(61334);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.n.l
 * JD-Core Version:    0.7.0.1
 */