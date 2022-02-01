package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i.f;

public final class a
  extends kotlin.l.b.a.b.k.a
{
  public static final a TLQ;
  
  static
  {
    AppMethodBeat.i(60386);
    TLQ = new a();
    AppMethodBeat.o(60386);
  }
  
  private a()
  {
    super(localg, localf1, localf2, localf3, localf4, localf5, localf6, localf7, localf8, localf9, localf10, localf11, localf12);
    AppMethodBeat.o(60385);
  }
  
  public static String r(b paramb)
  {
    AppMethodBeat.i(60384);
    if (paramb.isRoot())
    {
      AppMethodBeat.o(60384);
      return "default-package";
    }
    paramb = paramb.hJg().sG();
    p.g(paramb, "fqName.shortName().asString()");
    AppMethodBeat.o(60384);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */