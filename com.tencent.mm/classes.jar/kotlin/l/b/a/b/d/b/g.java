package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.k.a.h;
import kotlin.l.b.a.b.k.a.i;

public final class g
  implements i
{
  private final n TqR;
  private final e TqS;
  
  public g(n paramn, e parame)
  {
    AppMethodBeat.i(58194);
    this.TqR = paramn;
    this.TqS = parame;
    AppMethodBeat.o(58194);
  }
  
  public final h d(a parama)
  {
    AppMethodBeat.i(58193);
    kotlin.g.b.p.h(parama, "classId");
    p localp = o.a(this.TqR, parama);
    if (localp == null)
    {
      AppMethodBeat.o(58193);
      return null;
    }
    boolean bool = kotlin.g.b.p.j(localp.hyy(), parama);
    if ((aa.SXc) && (!bool))
    {
      parama = (Throwable)new AssertionError("Class with incorrect id found: expected " + parama + ", actual " + localp.hyy());
      AppMethodBeat.o(58193);
      throw parama;
    }
    parama = this.TqS.a(localp);
    AppMethodBeat.o(58193);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */