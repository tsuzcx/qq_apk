package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.j.d.a;

final class h
  implements b
{
  public static final h ajsh;
  private static final String description;
  
  static
  {
    AppMethodBeat.i(61304);
    ajsh = new h();
    description = "should not have varargs or parameters with default values";
    AppMethodBeat.o(61304);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(x paramx)
  {
    AppMethodBeat.i(61303);
    s.u(paramx, "functionDescriptor");
    paramx = paramx.kod();
    s.s(paramx, "functionDescriptor.valueParameters");
    paramx = (Iterable)paramx;
    if ((!(paramx instanceof Collection)) || (!((Collection)paramx).isEmpty()))
    {
      paramx = paramx.iterator();
      while (paramx.hasNext())
      {
        bd localbd = (bd)paramx.next();
        s.s(localbd, "it");
        if ((!a.b(localbd)) && (localbd.kpq() == null)) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(61303);
          return false;
        }
      }
    }
    AppMethodBeat.o(61303);
    return true;
  }
  
  public final String i(x paramx)
  {
    AppMethodBeat.i(61305);
    paramx = b.a.a(this, paramx);
    AppMethodBeat.o(61305);
    return paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.n.h
 * JD-Core Version:    0.7.0.1
 */