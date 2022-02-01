package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import kotlin.a.x;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.f.f;

public abstract interface h
  extends j
{
  public static final h.a TJW = h.a.TJY;
  
  public abstract Collection<? extends ah> a(f paramf, a parama);
  
  public abstract Collection<? extends am> b(f paramf, a parama);
  
  public abstract Set<f> hCa();
  
  public abstract Set<f> hCb();
  
  public static final class b
    extends i
  {
    public static final b TKa;
    
    static
    {
      AppMethodBeat.i(60216);
      TKa = new b();
      AppMethodBeat.o(60216);
    }
    
    public final Set<f> hCa()
    {
      return (Set)x.SXt;
    }
    
    public final Set<f> hCb()
    {
      return (Set)x.SXt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.h
 * JD-Core Version:    0.7.0.1
 */