package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d;
import kotlin.l.b.a.b.m.ad;
import kotlin.r;

public final class j
  extends g<r<? extends b, ? extends f>>
{
  private final b ajjH;
  public final f ajjI;
  
  public j(b paramb, f paramf)
  {
    super(kotlin.v.Y(paramb, paramf));
    AppMethodBeat.i(60065);
    this.ajjH = paramb;
    this.ajjI = paramf;
    AppMethodBeat.o(60065);
  }
  
  public final ad c(ae paramae)
  {
    AppMethodBeat.i(60063);
    s.u(paramae, "module");
    paramae = w.b(paramae, this.ajjH);
    if (paramae == null) {
      paramae = null;
    }
    while (paramae == null)
    {
      paramae = kotlin.l.b.a.b.m.v.bJt("Containing class for error-class based enum entry " + this.ajjH + '.' + this.ajjI);
      s.s(paramae, "createErrorType(\"Contain…mClassId.$enumEntryName\")");
      paramae = (ad)paramae;
      AppMethodBeat.o(60063);
      return paramae;
      if (d.y((l)paramae)) {}
      for (;;)
      {
        if (paramae != null) {
          break label107;
        }
        paramae = null;
        break;
        paramae = null;
      }
      label107:
      paramae = paramae.koj();
    }
    paramae = (ad)paramae;
    AppMethodBeat.o(60063);
    return paramae;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60064);
    String str = this.ajjH.kxN() + '.' + this.ajjI;
    AppMethodBeat.o(60064);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.j
 * JD-Core Version:    0.7.0.1
 */