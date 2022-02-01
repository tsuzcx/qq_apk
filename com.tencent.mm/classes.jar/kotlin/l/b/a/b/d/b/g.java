package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.k.a.h;
import kotlin.l.b.a.b.k.a.i;
import kotlin.z;

public final class g
  implements i
{
  private final n aaTL;
  private final e aaTM;
  
  public g(n paramn, e parame)
  {
    AppMethodBeat.i(58194);
    this.aaTL = paramn;
    this.aaTM = parame;
    AppMethodBeat.o(58194);
  }
  
  public final h d(a parama)
  {
    AppMethodBeat.i(58193);
    kotlin.g.b.p.k(parama, "classId");
    p localp = o.a(this.aaTL, parama);
    if (localp == null)
    {
      AppMethodBeat.o(58193);
      return null;
    }
    boolean bool = kotlin.g.b.p.h(localp.iCJ(), parama);
    if ((z.aazO) && (!bool))
    {
      parama = (Throwable)new AssertionError("Class with incorrect id found: expected " + parama + ", actual " + localp.iCJ());
      AppMethodBeat.o(58193);
      throw parama;
    }
    parama = this.aaTM.a(localp);
    AppMethodBeat.o(58193);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */