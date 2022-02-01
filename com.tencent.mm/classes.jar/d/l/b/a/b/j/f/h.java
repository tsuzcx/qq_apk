package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.c.a.a;
import d.l.b.a.b.f.f;
import java.util.Collection;
import java.util.Set;

public abstract interface h
  extends j
{
  public static final h.a LGV = h.a.LGX;
  
  public abstract Collection<? extends ah> a(f paramf, a parama);
  
  public abstract Collection<? extends am> b(f paramf, a parama);
  
  public abstract Set<f> fSy();
  
  public abstract Set<f> fSz();
  
  public static final class b
    extends i
  {
    public static final b LGZ;
    
    static
    {
      AppMethodBeat.i(60216);
      LGZ = new b();
      AppMethodBeat.o(60216);
    }
    
    public final Set<f> fSy()
    {
      return (Set)x.KTH;
    }
    
    public final Set<f> fSz()
    {
      return (Set)x.KTH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.h
 * JD-Core Version:    0.7.0.1
 */