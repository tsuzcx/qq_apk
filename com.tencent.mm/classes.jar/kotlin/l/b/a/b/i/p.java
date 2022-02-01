package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.n.n;

public enum p
{
  static
  {
    b localb = new b("PLAIN");
    abjN = localb;
    a locala = new a("HTML");
    abjO = locala;
    abjP = new p[] { localb, locala };
  }
  
  private p() {}
  
  public abstract String Mi(String paramString);
  
  static final class a
    extends p
  {
    a()
    {
      super(1, (byte)0);
    }
    
    public final String Mi(String paramString)
    {
      AppMethodBeat.i(59867);
      kotlin.g.b.p.k(paramString, "string");
      paramString = n.l(n.l(paramString, "<", "&lt;", false), ">", "&gt;", false);
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
    
    public final String Mi(String paramString)
    {
      AppMethodBeat.i(59868);
      kotlin.g.b.p.k(paramString, "string");
      AppMethodBeat.o(59868);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.i.p
 * JD-Core Version:    0.7.0.1
 */