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
  private final a LFx;
  public final f LFy;
  
  public j(a parama, f paramf)
  {
    super(d.u.Q(parama, paramf));
    AppMethodBeat.i(60065);
    this.LFx = parama;
    this.LFy = paramf;
    AppMethodBeat.o(60065);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60063);
    k.h(paramy, "module");
    paramy = s.b(paramy, this.LFx);
    if (paramy != null)
    {
      if (c.y((l)paramy)) {}
      while (paramy != null)
      {
        paramy = paramy.fRe();
        if (paramy == null) {
          break;
        }
        paramy = (ab)paramy;
        AppMethodBeat.o(60063);
        return paramy;
        paramy = null;
      }
    }
    paramy = d.l.b.a.b.m.u.aWR("Containing class for error-class based enum entry " + this.LFx + '.' + this.LFy);
    k.g(paramy, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60063);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60064);
    String str = this.LFx.fZC() + '.' + this.LFy;
    AppMethodBeat.o(60064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.j
 * JD-Core Version:    0.7.0.1
 */