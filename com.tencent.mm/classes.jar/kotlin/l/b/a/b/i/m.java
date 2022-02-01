package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.n.n;

public enum m
{
  private m() {}
  
  public abstract String EQ(String paramString);
  
  static final class a
    extends m
  {
    a()
    {
      super(1, (byte)0);
    }
    
    public final String EQ(String paramString)
    {
      AppMethodBeat.i(59867);
      s.u(paramString, "string");
      paramString = n.m(n.m(paramString, "<", "&lt;", false), ">", "&gt;", false);
      AppMethodBeat.o(59867);
      return paramString;
    }
  }
  
  static final class b
    extends m
  {
    b()
    {
      super(0, (byte)0);
    }
    
    public final String EQ(String paramString)
    {
      AppMethodBeat.i(59868);
      s.u(paramString, "string");
      AppMethodBeat.o(59868);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.i.m
 * JD-Core Version:    0.7.0.1
 */