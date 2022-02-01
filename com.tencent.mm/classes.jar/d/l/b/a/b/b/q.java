package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.c.a.a;
import d.l.b.a.b.f.b;
import d.l.b.a.b.f.c;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.f.h;

public final class q
{
  public static final e a(y paramy, b paramb, a parama)
  {
    AppMethodBeat.i(56850);
    p.h(paramy, "$this$resolveClassByFqName");
    p.h(paramb, "fqName");
    p.h(parama, "lookupLocation");
    if (paramb.Nqg.Nql.isEmpty())
    {
      AppMethodBeat.o(56850);
      return null;
    }
    Object localObject1 = paramb.grg();
    p.g(localObject1, "fqName.parent()");
    localObject1 = paramy.e((b)localObject1).gil();
    Object localObject2 = paramb.grh();
    p.g(localObject2, "fqName.shortName()");
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
    localObject1 = paramb.grg();
    p.g(localObject1, "fqName.parent()");
    paramy = a(paramy, (b)localObject1, parama);
    if (paramy != null)
    {
      paramy = paramy.giJ();
      if (paramy != null)
      {
        paramb = paramb.grh();
        p.g(paramb, "fqName.shortName()");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.q
 * JD-Core Version:    0.7.0.1
 */