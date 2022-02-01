package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.f;
import kotlin.l.d;
import kotlin.m.i;

public final class s
{
  public static final e a(y paramy, kotlin.l.b.a.b.f.a parama, aa paramaa)
  {
    AppMethodBeat.i(56858);
    p.h(paramy, "$this$findNonGenericClassAcrossDependencies");
    p.h(parama, "classId");
    p.h(paramaa, "notFoundClasses");
    paramy = b(paramy, parama);
    if (paramy != null)
    {
      AppMethodBeat.o(56858);
      return paramy;
    }
    paramy = paramaa.a(parama, i.c(i.d(i.b(parama, (kotlin.g.a.b)a.Thm), (kotlin.g.a.b)s.b.Thn)));
    AppMethodBeat.o(56858);
    return paramy;
  }
  
  public static final h a(y paramy, kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56856);
    p.h(paramy, "$this$findClassifierAcrossModuleDependencies");
    p.h(parama, "classId");
    Object localObject = parama.hIY();
    p.g(localObject, "classId.packageFqName");
    paramy = paramy.e((kotlin.l.b.a.b.f.b)localObject);
    parama = parama.hIZ().TCR.hJl();
    if (parama == null) {
      kotlin.l.b.a.b.f.b.atM(11);
    }
    p.g(parama, "classId.relativeClassName.pathSegments()");
    paramy = paramy.hAp();
    localObject = j.ks(parama);
    p.g(localObject, "segments.first()");
    paramy = paramy.c((f)localObject, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnT);
    if (paramy == null)
    {
      AppMethodBeat.o(56856);
      return null;
    }
    localObject = parama.subList(1, parama.size()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      parama = (f)((Iterator)localObject).next();
      if (!(paramy instanceof e))
      {
        AppMethodBeat.o(56856);
        return null;
      }
      paramy = ((e)paramy).hAN();
      p.g(parama, "name");
      parama = paramy.c(parama, (kotlin.l.b.a.b.c.a.a)kotlin.l.b.a.b.c.a.c.TnT);
      paramy = parama;
      if (!(parama instanceof e)) {
        paramy = null;
      }
      paramy = (e)paramy;
      if (paramy != null)
      {
        paramy = (h)paramy;
      }
      else
      {
        AppMethodBeat.o(56856);
        return null;
      }
    }
    AppMethodBeat.o(56856);
    return paramy;
  }
  
  public static final e b(y paramy, kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56857);
    p.h(paramy, "$this$findClassAcrossModuleDependencies");
    p.h(parama, "classId");
    parama = a(paramy, parama);
    paramy = parama;
    if (!(parama instanceof e)) {
      paramy = null;
    }
    paramy = (e)paramy;
    AppMethodBeat.o(56857);
    return paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.s
 * JD-Core Version:    0.7.0.1
 */