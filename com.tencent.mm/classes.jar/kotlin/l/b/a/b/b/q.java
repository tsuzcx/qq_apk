package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;

public final class q
{
  public static final e a(y paramy, b paramb, a parama)
  {
    AppMethodBeat.i(56850);
    p.k(paramy, "$this$resolveClassByFqName");
    p.k(paramb, "fqName");
    p.k(parama, "lookupLocation");
    if (paramb.abfE.abfJ.isEmpty())
    {
      AppMethodBeat.o(56850);
      return null;
    }
    Object localObject1 = paramb.iNz();
    p.j(localObject1, "fqName.parent()");
    localObject1 = paramy.e((b)localObject1).iEC();
    Object localObject2 = paramb.iNA();
    p.j(localObject2, "fqName.shortName()");
    localObject2 = ((h)localObject1).c((f)localObject2, parama);
    localObject1 = localObject2;
    if (!(localObject2 instanceof e)) {
      localObject1 = null;
    }
    localObject1 = (e)localObject1;
    if (localObject1 != null)
    {
      AppMethodBeat.o(56850);
      return localObject1;
    }
    localObject1 = paramb.iNz();
    p.j(localObject1, "fqName.parent()");
    paramy = a(paramy, (b)localObject1, parama);
    if (paramy != null)
    {
      paramy = paramy.iFa();
      if (paramy != null)
      {
        paramb = paramb.iNA();
        p.j(paramb, "fqName.shortName()");
      }
    }
    for (paramy = paramy.c(paramb, parama);; paramy = null)
    {
      paramb = paramy;
      if (!(paramy instanceof e)) {
        paramb = null;
      }
      paramy = (e)paramb;
      AppMethodBeat.o(56850);
      return paramy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.q
 * JD-Core Version:    0.7.0.1
 */