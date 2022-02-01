package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.e;

public abstract interface c
{
  public abstract boolean a(e parame, au paramau);
  
  public static final class a
    implements c
  {
    public static final a aiJu;
    
    static
    {
      AppMethodBeat.i(56988);
      aiJu = new a();
      AppMethodBeat.o(56988);
    }
    
    public final boolean a(e parame, au paramau)
    {
      AppMethodBeat.i(56987);
      s.u(parame, "classDescriptor");
      s.u(paramau, "functionDescriptor");
      AppMethodBeat.o(56987);
      return true;
    }
  }
  
  public static final class b
    implements c
  {
    public static final b aiJv;
    
    static
    {
      AppMethodBeat.i(56990);
      aiJv = new b();
      AppMethodBeat.o(56990);
    }
    
    public final boolean a(e parame, au paramau)
    {
      AppMethodBeat.i(56989);
      s.u(parame, "classDescriptor");
      s.u(paramau, "functionDescriptor");
      if (!paramau.knl().i(d.kpC()))
      {
        AppMethodBeat.o(56989);
        return true;
      }
      AppMethodBeat.o(56989);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b.c
 * JD-Core Version:    0.7.0.1
 */