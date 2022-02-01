package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.u;
import kotlin.o;

public final class j
  extends g<o<? extends a, ? extends f>>
{
  private final a TIx;
  public final f TIy;
  
  public j(a parama, f paramf)
  {
    super(kotlin.s.U(parama, paramf));
    AppMethodBeat.i(60065);
    this.TIx = parama;
    this.TIy = paramf;
    AppMethodBeat.o(60065);
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60063);
    p.h(paramy, "module");
    paramy = kotlin.l.b.a.b.b.s.b(paramy, this.TIx);
    if (paramy != null)
    {
      if (c.y((l)paramy)) {}
      while (paramy != null)
      {
        paramy = paramy.hAG();
        if (paramy == null) {
          break;
        }
        paramy = (ab)paramy;
        AppMethodBeat.o(60063);
        return paramy;
        paramy = null;
      }
    }
    paramy = u.bun("Containing class for error-class based enum entry " + this.TIx + '.' + this.TIy);
    p.g(paramy, "ErrorUtils.createErrorTy…mClassId.$enumEntryName\")");
    paramy = (ab)paramy;
    AppMethodBeat.o(60063);
    return paramy;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60064);
    String str = this.TIx.hJa() + '.' + this.TIy;
    AppMethodBeat.o(60064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.j
 * JD-Core Version:    0.7.0.1
 */