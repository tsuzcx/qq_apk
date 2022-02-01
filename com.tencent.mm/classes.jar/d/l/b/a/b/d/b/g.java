package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.f.a;
import d.l.b.a.b.k.a.h;
import d.l.b.a.b.k.a.i;

public final class g
  implements i
{
  private final n JzO;
  private final e JzP;
  
  public g(n paramn, e parame)
  {
    AppMethodBeat.i(58194);
    this.JzO = paramn;
    this.JzP = parame;
    AppMethodBeat.o(58194);
  }
  
  public final h d(a parama)
  {
    AppMethodBeat.i(58193);
    k.h(parama, "classId");
    p localp = o.a(this.JzO, parama);
    if (localp == null)
    {
      AppMethodBeat.o(58193);
      return null;
    }
    boolean bool = k.g(localp.fwp(), parama);
    if ((aa.JfW) && (!bool))
    {
      parama = (Throwable)new AssertionError("Class with incorrect id found: expected " + parama + ", actual " + localp.fwp());
      AppMethodBeat.o(58193);
      throw parama;
    }
    parama = this.JzP.a(localp);
    AppMethodBeat.o(58193);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */