package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.l.m;

public abstract interface z
{
  public static final z.a aiLC = z.a.aiLD;
  
  public abstract al a(w paramw, c paramc, m paramm);
  
  public static final class b
    implements z
  {
    public static final b aiLF;
    
    static
    {
      AppMethodBeat.i(191873);
      aiLF = new b();
      AppMethodBeat.o(191873);
    }
    
    public final al a(w paramw, c paramc, m paramm)
    {
      AppMethodBeat.i(191877);
      s.u(paramw, "module");
      s.u(paramc, "fqName");
      s.u(paramm, "storageManager");
      paramw = (al)new r(paramw, paramc, paramm);
      AppMethodBeat.o(191877);
      return paramw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.z
 * JD-Core Version:    0.7.0.1
 */