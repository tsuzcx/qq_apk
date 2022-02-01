package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.h;

public final class r
{
  public static final e a(ae paramae, c paramc, b paramb)
  {
    AppMethodBeat.i(56850);
    s.u(paramae, "<this>");
    s.u(paramc, "fqName");
    s.u(paramb, "lookupLocation");
    if (paramc.ajex.ajeC.isEmpty())
    {
      AppMethodBeat.o(56850);
      return null;
    }
    Object localObject = paramc.kxS();
    s.s(localObject, "fqName.parent()");
    localObject = paramae.e((c)localObject).knP();
    f localf = paramc.kxT();
    s.s(localf, "fqName.shortName()");
    localObject = ((h)localObject).c(localf, paramb);
    if ((localObject instanceof e)) {}
    for (localObject = (e)localObject; localObject != null; localObject = null)
    {
      AppMethodBeat.o(56850);
      return localObject;
    }
    localObject = paramc.kxS();
    s.s(localObject, "fqName.parent()");
    paramae = a(paramae, (c)localObject, paramb);
    if (paramae == null) {
      paramae = null;
    }
    while ((paramae instanceof e))
    {
      paramae = (e)paramae;
      AppMethodBeat.o(56850);
      return paramae;
      paramae = paramae.kou();
      if (paramae == null)
      {
        paramae = null;
      }
      else
      {
        paramc = paramc.kxT();
        s.s(paramc, "fqName.shortName()");
        paramae = paramae.c(paramc, paramb);
      }
    }
    AppMethodBeat.o(56850);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.r
 * JD-Core Version:    0.7.0.1
 */