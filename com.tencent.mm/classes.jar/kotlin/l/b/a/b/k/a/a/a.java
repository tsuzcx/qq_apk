package kotlin.l.b.a.b.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i.e;

public final class a
  extends kotlin.l.b.a.b.k.a
{
  public static final a ajnb;
  
  static
  {
    AppMethodBeat.i(60386);
    ajnb = new a();
    AppMethodBeat.o(60386);
  }
  
  private a()
  {
    super(localg, (i.e)localObject, locale1, locale2, locale3, locale4, locale5, locale6, locale7, locale8, locale9, locale10, locale11);
    AppMethodBeat.o(60385);
  }
  
  public static String u(c paramc)
  {
    AppMethodBeat.i(60384);
    if (paramc.isRoot())
    {
      AppMethodBeat.o(60384);
      return "default-package";
    }
    paramc = paramc.kxT().PF();
    s.s(paramc, "fqName.shortName().asString()");
    AppMethodBeat.o(60384);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */