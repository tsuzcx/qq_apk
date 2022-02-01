package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public abstract class i
{
  public abstract Collection<ab> D(e parame);
  
  public abstract h M(l paraml);
  
  public abstract ab aK(ab paramab);
  
  public abstract boolean f(y paramy);
  
  public abstract e h(a parama);
  
  public static final class a
    extends i
  {
    public static final a abrE;
    
    static
    {
      AppMethodBeat.i(61057);
      abrE = new a();
      AppMethodBeat.o(61057);
    }
    
    public final Collection<ab> D(e parame)
    {
      AppMethodBeat.i(61053);
      p.k(parame, "classDescriptor");
      parame = parame.iDL();
      p.j(parame, "classDescriptor.typeConstructor");
      parame = parame.iGk();
      p.j(parame, "classDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(61053);
      return parame;
    }
    
    public final ab aK(ab paramab)
    {
      AppMethodBeat.i(61052);
      p.k(paramab, "type");
      AppMethodBeat.o(61052);
      return paramab;
    }
    
    public final boolean f(y paramy)
    {
      AppMethodBeat.i(61056);
      p.k(paramy, "moduleDescriptor");
      AppMethodBeat.o(61056);
      return false;
    }
    
    public final e h(a parama)
    {
      AppMethodBeat.i(61055);
      p.k(parama, "classId");
      AppMethodBeat.o(61055);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.i
 * JD-Core Version:    0.7.0.1
 */