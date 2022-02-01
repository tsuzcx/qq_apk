package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.ac;
import d.l.b.a.b.f.a;
import d.l.b.a.b.k.a.h;
import d.l.b.a.b.k.a.i;

public final class g
  implements i
{
  private final n Nee;
  private final e Nef;
  
  public g(n paramn, e parame)
  {
    AppMethodBeat.i(58194);
    this.Nee = paramn;
    this.Nef = parame;
    AppMethodBeat.o(58194);
  }
  
  public final h d(a parama)
  {
    AppMethodBeat.i(58193);
    d.g.b.p.h(parama, "classId");
    p localp = o.a(this.Nee, parama);
    if (localp == null)
    {
      AppMethodBeat.o(58193);
      return null;
    }
    boolean bool = d.g.b.p.i(localp.ggt(), parama);
    if ((ac.MKp) && (!bool))
    {
      parama = (Throwable)new AssertionError("Class with incorrect id found: expected " + parama + ", actual " + localp.ggt());
      AppMethodBeat.o(58193);
      throw parama;
    }
    parama = this.Nef.a(localp);
    AppMethodBeat.o(58193);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.g
 * JD-Core Version:    0.7.0.1
 */