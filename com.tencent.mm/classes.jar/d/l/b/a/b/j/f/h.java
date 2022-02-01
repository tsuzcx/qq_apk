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
  public static final h.a JTC = h.a.JTE;
  
  public abstract Collection<? extends ah> a(f paramf, a parama);
  
  public abstract Collection<? extends am> b(f paramf, a parama);
  
  public abstract Set<f> fzU();
  
  public abstract Set<f> fzV();
  
  public static final class b
    extends i
  {
    public static final b JTG;
    
    static
    {
      AppMethodBeat.i(60216);
      JTG = new b();
      AppMethodBeat.o(60216);
    }
    
    public final Set<f> fzU()
    {
      return (Set)x.Jgn;
    }
    
    public final Set<f> fzV()
    {
      return (Set)x.Jgn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.h
 * JD-Core Version:    0.7.0.1
 */