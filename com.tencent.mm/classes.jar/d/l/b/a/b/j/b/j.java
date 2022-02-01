package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
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
  private final a JSe;
  public final f JSf;
  
  public j(a parama, f paramf)
  {
    super(d.u.P(parama, paramf));
    AppMethodBeat.i(60065);
    this.JSe = parama;
    this.JSf = paramf;
    AppMethodBeat.o(60065);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60063);
    k.h(paramy, "module");
    paramy = s.b(paramy, this.JSe);
    if (paramy != null)
    {
      if (c.y((l)paramy)) {}
      while (paramy != null)
      {
        paramy = paramy.fyA();
        if (paramy == null) {
          break;
        }
        paramy = (ab)paramy;
        AppMethodBeat.o(60063);
        return paramy;
        paramy = null;
      }
    }
    paramy = d.l.b.a.b.m.u.aQS("Containing class for error-class based enum entry " + this.JSe + '.' + this.JSf);
    k.g(paramy, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60063);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60064);
    String str = this.JSe.fGY() + '.' + this.JSf;
    AppMethodBeat.o(60064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.j
 * JD-Core Version:    0.7.0.1
 */