package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.h;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import d.l.b.a.b.m.c.g;
import d.l.b.a.b.m.c.i;
import d.l.b.a.b.m.c.m;
import d.l.b.a.b.m.c.n;
import d.l.b.a.b.m.c.p;

public abstract interface bb
  extends p
{
  public abstract g a(n paramn);
  
  public abstract n a(m paramm);
  
  public abstract boolean a(g paramg, b paramb);
  
  public abstract boolean b(m paramm);
  
  public abstract h c(m paramm);
  
  public abstract h d(m paramm);
  
  public abstract boolean e(m paramm);
  
  public abstract c f(m paramm);
  
  public abstract g k(g paramg);
  
  public abstract boolean l(g paramg);
  
  public abstract g m(g paramg);
  
  public static final class a
  {
    public static boolean b(bb parambb, g paramg)
    {
      AppMethodBeat.i(60871);
      k.h(paramg, "$this$isMarkedNullable");
      if (((paramg instanceof i)) && (parambb.h((i)paramg)))
      {
        AppMethodBeat.o(60871);
        return true;
      }
      AppMethodBeat.o(60871);
      return false;
    }
    
    public static g c(bb parambb, g paramg)
    {
      AppMethodBeat.i(60872);
      k.h(paramg, "$this$makeNullable");
      i locali = parambb.o(paramg);
      if (locali != null)
      {
        parambb = parambb.a(locali, true);
        if (parambb != null)
        {
          parambb = (g)parambb;
          AppMethodBeat.o(60872);
          return parambb;
        }
      }
      AppMethodBeat.o(60872);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.bb
 * JD-Core Version:    0.7.0.1
 */