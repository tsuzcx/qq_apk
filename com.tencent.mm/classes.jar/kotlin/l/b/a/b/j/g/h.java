package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import kotlin.a.ad;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.f.f;

public abstract interface h
  extends k
{
  public static final h.a ajli = h.a.ajlj;
  
  public abstract Collection<? extends ap> a(f paramf, b paramb);
  
  public abstract Collection<? extends au> b(f paramf, b paramb);
  
  public abstract Set<f> kpL();
  
  public abstract Set<f> kpM();
  
  public abstract Set<f> kpN();
  
  public static final class b
  {
    public static void a(h paramh, f paramf, b paramb)
    {
      AppMethodBeat.i(192228);
      s.u(paramh, "this");
      s.u(paramf, "name");
      s.u(paramb, "location");
      paramh = (k)paramh;
      s.u(paramh, "this");
      s.u(paramf, "name");
      s.u(paramb, "location");
      paramh.b(paramf, paramb);
      AppMethodBeat.o(192228);
    }
  }
  
  public static final class c
    extends i
  {
    public static final c ajlm;
    
    static
    {
      AppMethodBeat.i(60216);
      ajlm = new c();
      AppMethodBeat.o(60216);
    }
    
    public final Set<f> kpL()
    {
      return (Set)ad.aivA;
    }
    
    public final Set<f> kpM()
    {
      return (Set)ad.aivA;
    }
    
    public final Set<f> kpN()
    {
      return (Set)ad.aivA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.h
 * JD-Core Version:    0.7.0.1
 */