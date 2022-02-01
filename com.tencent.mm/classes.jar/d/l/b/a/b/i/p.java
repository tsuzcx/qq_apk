package d.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.n.n;

public enum p
{
  static
  {
    b localb = new b("PLAIN");
    JQP = localb;
    a locala = new a("HTML");
    JQQ = locala;
    JQR = new p[] { localb, locala };
  }
  
  private p() {}
  
  public abstract String qj(String paramString);
  
  static final class a
    extends p
  {
    a()
    {
      super(1, (byte)0);
    }
    
    public final String qj(String paramString)
    {
      AppMethodBeat.i(59867);
      k.h(paramString, "string");
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
    
    public final String qj(String paramString)
    {
      AppMethodBeat.i(59868);
      k.h(paramString, "string");
      AppMethodBeat.o(59868);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.i.p
 * JD-Core Version:    0.7.0.1
 */