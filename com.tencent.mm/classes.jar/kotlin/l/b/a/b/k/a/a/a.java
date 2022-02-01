package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i.e;

public final class a
  extends kotlin.l.b.a.b.k.a
{
  public static final a abos;
  
  static
  {
    AppMethodBeat.i(60386);
    abos = new a();
    AppMethodBeat.o(60386);
  }
  
  private a()
  {
    super(localg, locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11, locale12);
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
    paramb = paramb.iNA().qu();
    p.j(paramb, "fqName.shortName().asString()");
    AppMethodBeat.o(60384);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */