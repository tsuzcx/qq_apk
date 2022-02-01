package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;

public abstract class g
{
  public abstract Collection<ad> F(e parame);
  
  public abstract kotlin.l.b.a.b.b.h M(l paraml);
  
  public abstract <S extends kotlin.l.b.a.b.j.g.h> S a(e parame, a<? extends S> parama);
  
  public abstract ad aD(ad paramad);
  
  public abstract boolean e(ax paramax);
  
  public abstract boolean g(ae paramae);
  
  public abstract e j(b paramb);
  
  public static final class a
    extends g
  {
    public static final a ajra;
    
    static
    {
      AppMethodBeat.i(61057);
      ajra = new a();
      AppMethodBeat.o(61057);
    }
    
    public final Collection<ad> F(e parame)
    {
      AppMethodBeat.i(61053);
      s.u(parame, "classDescriptor");
      parame = parame.kmZ().kpG();
      s.s(parame, "classDescriptor.typeConstructor.supertypes");
      AppMethodBeat.o(61053);
      return parame;
    }
    
    public final <S extends kotlin.l.b.a.b.j.g.h> S a(e parame, a<? extends S> parama)
    {
      AppMethodBeat.i(191706);
      s.u(parame, "classDescriptor");
      s.u(parama, "compute");
      parame = (kotlin.l.b.a.b.j.g.h)parama.invoke();
      AppMethodBeat.o(191706);
      return parame;
    }
    
    public final ad aD(ad paramad)
    {
      AppMethodBeat.i(61052);
      s.u(paramad, "type");
      AppMethodBeat.o(61052);
      return paramad;
    }
    
    public final boolean e(ax paramax)
    {
      AppMethodBeat.i(191701);
      s.u(paramax, "typeConstructor");
      AppMethodBeat.o(191701);
      return false;
    }
    
    public final boolean g(ae paramae)
    {
      AppMethodBeat.i(61056);
      s.u(paramae, "moduleDescriptor");
      AppMethodBeat.o(61056);
      return false;
    }
    
    public final e j(b paramb)
    {
      AppMethodBeat.i(61055);
      s.u(paramb, "classId");
      AppMethodBeat.o(61055);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.a.g
 * JD-Core Version:    0.7.0.1
 */