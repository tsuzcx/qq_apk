package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.a.ar;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.l.m;

public final class h
{
  public static final h.b ajlP;
  private static final Set<kotlin.l.b.a.b.f.b> ajlR;
  private final j aiWx;
  private final kotlin.g.a.b<h.a, e> ajlQ;
  
  static
  {
    AppMethodBeat.i(60299);
    ajlP = new h.b((byte)0);
    ajlR = ar.setOf(kotlin.l.b.a.b.f.b.s(k.a.aiCA.kxX()));
    AppMethodBeat.o(60299);
  }
  
  public h(j paramj)
  {
    AppMethodBeat.i(60298);
    this.aiWx = paramj;
    this.ajlQ = ((kotlin.g.a.b)this.aiWx.aiBu.be((kotlin.g.a.b)new c(this)));
    AppMethodBeat.o(60298);
  }
  
  public final e a(kotlin.l.b.a.b.f.b paramb, f paramf)
  {
    AppMethodBeat.i(60296);
    s.u(paramb, "classId");
    paramb = (e)this.ajlQ.invoke(new h.a(paramb, paramf));
    AppMethodBeat.o(60296);
    return paramb;
  }
  
  static final class c
    extends u
    implements kotlin.g.a.b<h.a, e>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.h
 * JD-Core Version:    0.7.0.1
 */