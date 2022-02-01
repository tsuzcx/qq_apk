package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ah;
import kotlin.g.b.s;

public abstract class k
  extends g<ah>
{
  public static final a ajjJ = new a((byte)0);
  
  public k()
  {
    super(ah.aiuX);
  }
  
  public static final class a
  {
    public static k bJo(String paramString)
    {
      AppMethodBeat.i(60066);
      s.u(paramString, "message");
      paramString = (k)new k.b(paramString);
      AppMethodBeat.o(60066);
      return paramString;
    }
  }
  
  public static final class b
    extends k
  {
    private final String message;
    
    public b(String paramString)
    {
      AppMethodBeat.i(60068);
      this.message = paramString;
      AppMethodBeat.o(60068);
    }
    
    public final String toString()
    {
      return this.message;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.k
 * JD-Core Version:    0.7.0.1
 */