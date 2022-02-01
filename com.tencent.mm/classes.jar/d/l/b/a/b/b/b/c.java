package d.l.b.a.b.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.e;

public abstract interface c
{
  public abstract boolean a(e parame, am paramam);
  
  public static final class a
    implements c
  {
    public static final a Lgg;
    
    static
    {
      AppMethodBeat.i(56988);
      Lgg = new a();
      AppMethodBeat.o(56988);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56987);
      k.h(parame, "classDescriptor");
      k.h(paramam, "functionDescriptor");
      AppMethodBeat.o(56987);
      return true;
    }
  }
  
  public static final class b
    implements c
  {
    public static final b Lgh;
    
    static
    {
      AppMethodBeat.i(56990);
      Lgh = new b();
      AppMethodBeat.o(56990);
    }
    
    public final boolean a(e parame, am paramam)
    {
      AppMethodBeat.i(56989);
      k.h(parame, "classDescriptor");
      k.h(paramam, "functionDescriptor");
      if (!paramam.fQj().h(d.fSn()))
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