package kotlin.l.b.a.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public abstract interface c
{
  public abstract void a(String paramString1, e parame, String paramString2, f paramf, String paramString3);
  
  public abstract boolean krp();
  
  public static final class a
    implements c
  {
    public static final a aiNu;
    
    static
    {
      AppMethodBeat.i(57523);
      aiNu = new a();
      AppMethodBeat.o(57523);
    }
    
    public final void a(String paramString1, e parame, String paramString2, f paramf, String paramString3)
    {
      AppMethodBeat.i(191379);
      s.u(paramString1, "filePath");
      s.u(parame, "position");
      s.u(paramString2, "scopeFqName");
      s.u(paramf, "scopeKind");
      s.u(paramString3, "name");
      AppMethodBeat.o(191379);
    }
    
    public final boolean krp()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.c.a.c
 * JD-Core Version:    0.7.0.1
 */