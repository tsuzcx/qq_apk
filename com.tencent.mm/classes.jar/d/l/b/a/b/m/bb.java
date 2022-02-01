package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import d.l.b.a.b.m.c.j;
import d.l.b.a.b.m.c.n;
import d.l.b.a.b.m.c.o;
import d.l.b.a.b.m.c.q;

public abstract interface bb
  extends q
{
  public abstract d.l.b.a.b.m.c.h a(o paramo);
  
  public abstract o a(n paramn);
  
  public abstract boolean a(d.l.b.a.b.m.c.h paramh, b paramb);
  
  public abstract boolean b(n paramn);
  
  public abstract d.l.b.a.b.a.h c(n paramn);
  
  public abstract d.l.b.a.b.a.h d(n paramn);
  
  public abstract boolean e(n paramn);
  
  public abstract c f(n paramn);
  
  public abstract d.l.b.a.b.m.c.h k(d.l.b.a.b.m.c.h paramh);
  
  public abstract boolean l(d.l.b.a.b.m.c.h paramh);
  
  public abstract d.l.b.a.b.m.c.h m(d.l.b.a.b.m.c.h paramh);
  
  public static final class a
  {
    public static boolean b(bb parambb, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60871);
      p.h(paramh, "$this$isMarkedNullable");
      if (((paramh instanceof j)) && (parambb.h((j)paramh)))
      {
        AppMethodBeat.o(60871);
        return true;
      }
      AppMethodBeat.o(60871);
      return false;
    }
    
    public static d.l.b.a.b.m.c.h c(bb parambb, d.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60872);
      p.h(paramh, "$this$makeNullable");
      j localj = parambb.o(paramh);
      if (localj != null)
      {
        parambb = parambb.a(localj, true);
        if (parambb != null)
        {
          parambb = (d.l.b.a.b.m.c.h)parambb;
          AppMethodBeat.o(60872);
          return parambb;
        }
      }
      AppMethodBeat.o(60872);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bb
 * JD-Core Version:    0.7.0.1
 */