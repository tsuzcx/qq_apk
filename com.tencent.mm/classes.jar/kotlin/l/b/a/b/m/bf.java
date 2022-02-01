package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.m.c.k;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.p;
import kotlin.l.b.a.b.m.c.r;

public abstract interface bf
  extends r
{
  public abstract d a(o paramo);
  
  public abstract kotlin.l.b.a.b.m.c.i a(p paramp);
  
  public abstract boolean a(kotlin.l.b.a.b.m.c.i parami, c paramc);
  
  public abstract kotlin.l.b.a.b.a.i b(o paramo);
  
  public abstract kotlin.l.b.a.b.a.i c(o paramo);
  
  public abstract kotlin.l.b.a.b.m.c.i e(kotlin.l.b.a.b.m.c.i parami);
  
  public abstract boolean i(o paramo);
  
  public abstract boolean m(o paramo);
  
  public abstract kotlin.l.b.a.b.m.c.i p(kotlin.l.b.a.b.m.c.i parami);
  
  public static final class a
  {
    public static kotlin.l.b.a.b.m.c.i b(bf parambf, kotlin.l.b.a.b.m.c.i parami)
    {
      AppMethodBeat.i(60872);
      s.u(parambf, "this");
      s.u(parami, "receiver");
      k localk = parambf.c(parami);
      if (localk == null)
      {
        AppMethodBeat.o(60872);
        return parami;
      }
      parambf = (kotlin.l.b.a.b.m.c.i)parambf.a(localk, true);
      AppMethodBeat.o(60872);
      return parambf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bf
 * JD-Core Version:    0.7.0.1
 */