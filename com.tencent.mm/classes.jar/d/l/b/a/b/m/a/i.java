package d.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.a;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import java.util.Collection;

public abstract class i
{
  public abstract Collection<ab> D(e parame);
  
  public abstract h M(l paraml);
  
  public abstract ab aL(ab paramab);
  
  public abstract boolean f(y paramy);
  
  public abstract e h(a parama);
  
  public static final class a
    extends i
  {
    public static final a LMj;
    
    static
    {
      AppMethodBeat.i(61057);
      LMj = new a();
      AppMethodBeat.o(61057);
    }
    
    public final Collection<ab> D(e parame)
    {
      AppMethodBeat.i(61053);
      k.h(parame, "classDescriptor");
      parame = parame.fPW();
      k.g(parame, "classDescriptor.typeConstructor");
      parame = parame.fSt();
      k.g(parame, "classDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(61053);
      return parame;
    }
    
    public final ab aL(ab paramab)
    {
      AppMethodBeat.i(61052);
      k.h(paramab, "type");
      AppMethodBeat.o(61052);
      return paramab;
    }
    
    public final boolean f(y paramy)
    {
      AppMethodBeat.i(61056);
      k.h(paramy, "moduleDescriptor");
      AppMethodBeat.o(61056);
      return false;
    }
    
    public final e h(a parama)
    {
      AppMethodBeat.i(61055);
      k.h(parama, "classId");
      AppMethodBeat.o(61055);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.a.i
 * JD-Core Version:    0.7.0.1
 */