package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.d.a;

final class h
  implements b
{
  public static final h absR;
  private static final String description = "should not have varargs or parameters with default values";
  
  static
  {
    AppMethodBeat.i(61304);
    absR = new h();
    description = "should not have varargs or parameters with default values";
    AppMethodBeat.o(61304);
  }
  
  public final String getDescription()
  {
    return description;
  }
  
  public final boolean h(t paramt)
  {
    AppMethodBeat.i(61303);
    p.k(paramt, "functionDescriptor");
    paramt = paramt.iEJ();
    p.j(paramt, "functionDescriptor.valueParameters");
    paramt = (Iterable)paramt;
    if ((!(paramt instanceof Collection)) || (!((Collection)paramt).isEmpty()))
    {
      paramt = paramt.iterator();
      while (paramt.hasNext())
      {
        av localav = (av)paramt.next();
        p.j(localav, "it");
        if ((!a.b(localav)) && (localav.iFQ() == null)) {}
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
  
  public final String i(t paramt)
  {
    AppMethodBeat.i(61305);
    p.k(paramt, "functionDescriptor");
    paramt = b.a.a(this, paramt);
    AppMethodBeat.o(61305);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.n.h
 * JD-Core Version:    0.7.0.1
 */