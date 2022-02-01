package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.c;
import d.l.b.a.b.m.ab;
import d.o;

public final class j
  extends g<o<? extends a, ? extends f>>
{
  private final a Nwv;
  public final f Nww;
  
  public j(a parama, f paramf)
  {
    super(d.u.S(parama, paramf));
    AppMethodBeat.i(60065);
    this.Nwv = parama;
    this.Nww = paramf;
    AppMethodBeat.o(60065);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60063);
    p.h(paramy, "module");
    paramy = s.b(paramy, this.Nwv);
    if (paramy != null)
    {
      if (c.y((l)paramy)) {}
      while (paramy != null)
      {
        paramy = paramy.giC();
        if (paramy == null) {
          break;
        }
        paramy = (ab)paramy;
        AppMethodBeat.o(60063);
        return paramy;
        paramy = null;
      }
    }
    paramy = d.l.b.a.b.m.u.bcU("Containing class for error-class based enum entry " + this.Nwv + '.' + this.Nww);
    p.g(paramy, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60063);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60064);
    String str = this.Nwv.grb() + '.' + this.Nww;
    AppMethodBeat.o(60064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.j
 * JD-Core Version:    0.7.0.1
 */