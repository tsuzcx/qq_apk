package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.o;
import kotlin.l.b.a.b.m.c.q;

public abstract interface bb
  extends q
{
  public abstract kotlin.l.b.a.b.m.c.h a(o paramo);
  
  public abstract o a(n paramn);
  
  public abstract boolean a(kotlin.l.b.a.b.m.c.h paramh, b paramb);
  
  public abstract boolean b(n paramn);
  
  public abstract kotlin.l.b.a.b.a.h c(n paramn);
  
  public abstract kotlin.l.b.a.b.a.h d(n paramn);
  
  public abstract boolean e(n paramn);
  
  public abstract c f(n paramn);
  
  public abstract kotlin.l.b.a.b.m.c.h k(kotlin.l.b.a.b.m.c.h paramh);
  
  public abstract boolean l(kotlin.l.b.a.b.m.c.h paramh);
  
  public abstract kotlin.l.b.a.b.m.c.h m(kotlin.l.b.a.b.m.c.h paramh);
  
  public static final class a
  {
    public static boolean b(bb parambb, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60871);
      p.k(paramh, "$this$isMarkedNullable");
      if (((paramh instanceof j)) && (parambb.h((j)paramh)))
      {
        AppMethodBeat.o(60871);
        return true;
      }
      AppMethodBeat.o(60871);
      return false;
    }
    
    public static kotlin.l.b.a.b.m.c.h c(bb parambb, kotlin.l.b.a.b.m.c.h paramh)
    {
      AppMethodBeat.i(60872);
      p.k(paramh, "$this$makeNullable");
      j localj = parambb.o(paramh);
      if (localj != null)
      {
        parambb = parambb.a(localj, true);
        if (parambb != null)
        {
          parambb = (kotlin.l.b.a.b.m.c.h)parambb;
          AppMethodBeat.o(60872);
          return parambb;
        }
      }
      AppMethodBeat.o(60872);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.bb
 * JD-Core Version:    0.7.0.1
 */