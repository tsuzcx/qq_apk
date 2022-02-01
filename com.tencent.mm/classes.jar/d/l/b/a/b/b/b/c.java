package d.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;

public abstract interface c
{
  public abstract boolean a(e parame, am paramam);
  
  public static final class a
    implements c
  {
    public static final a Nui;
    
    static
    {
      AppMethodBeat.i(56988);
      Nui = new a();
      AppMethodBeat.o(56988);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56987);
      p.h(parame, "classDescriptor");
      p.h(paramam, "functionDescriptor");
      AppMethodBeat.o(56987);
      return true;
    }
  }
  
  public static final class b
    implements c
  {
    public static final b Nuj;
    
    static
    {
      AppMethodBeat.i(56990);
      Nuj = new b();
      AppMethodBeat.o(56990);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56989);
      p.h(parame, "classDescriptor");
      p.h(paramam, "functionDescriptor");
      if (!paramam.gmj().h(d.goo()))
      {
        AppMethodBeat.o(56989);
        return true;
      }
      AppMethodBeat.o(56989);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.b.c
 * JD-Core Version:    0.7.0.1
 */