package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.n.n;

public enum p
{
  static
  {
    b localb = new b("PLAIN");
    Nvh = localb;
    a locala = new a("HTML");
    Nvi = locala;
    Nvj = new p[] { localb, locala };
  }
  
  private p() {}
  
  public abstract String wo(String paramString);
  
  static final class a
    extends p
  {
    a()
    {
      super(1, (byte)0);
    }
    
    public final String wo(String paramString)
    {
      AppMethodBeat.i(59867);
      d.g.b.p.h(paramString, "string");
      paramString = n.h(n.h(paramString, "<", "&lt;", false), ">", "&gt;", false);
      AppMethodBeat.o(59867);
      return paramString;
    }
  }
  
  static final class b
    extends p
  {
    b()
    {
      super(0, (byte)0);
    }
    
    public final String wo(String paramString)
    {
      AppMethodBeat.i(59868);
      d.g.b.p.h(paramString, "string");
      AppMethodBeat.o(59868);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.p
 * JD-Core Version:    0.7.0.1
 */