package kotlin.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;

public abstract interface c
{
  public abstract boolean a(e parame, am paramam);
  
  public static final class a
    implements c
  {
    public static final a aaMK;
    
    static
    {
      AppMethodBeat.i(56988);
      aaMK = new a();
      AppMethodBeat.o(56988);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56987);
      p.k(parame, "classDescriptor");
      p.k(paramam, "functionDescriptor");
      AppMethodBeat.o(56987);
      return true;
    }
  }
  
  public static final class b
    implements c
  {
    public static final b aaML;
    
    static
    {
      AppMethodBeat.i(56990);
      aaML = new b();
      AppMethodBeat.o(56990);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56989);
      p.k(parame, "classDescriptor");
      p.k(paramam, "functionDescriptor");
      if (!paramam.iDY().h(d.iGf()))
      {
        AppMethodBeat.o(56989);
        return true;
      }
      AppMethodBeat.o(56989);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.b.c
 * JD-Core Version:    0.7.0.1
 */