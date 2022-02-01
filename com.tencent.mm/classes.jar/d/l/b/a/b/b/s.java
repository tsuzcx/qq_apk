package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l.b.a.b.f.f;
import d.m.i;
import java.util.Iterator;
import java.util.List;

public final class s
{
  public static final e a(y paramy, d.l.b.a.b.f.a parama, aa paramaa)
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
    paramy = paramaa.a(parama, i.c(i.d(i.b(parama, (d.g.a.b)s.a.MUz), (d.g.a.b)s.b.MUA)));
    AppMethodBeat.o(56858);
    return paramy;
  }
  
  public static final h a(y paramy, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56856);
    p.h(paramy, "$this$findClassifierAcrossModuleDependencies");
    p.h(parama, "classId");
    Object localObject = parama.gqZ();
    p.g(localObject, "classId.packageFqName");
    paramy = paramy.e((d.l.b.a.b.f.b)localObject);
    parama = parama.gra().Nqg.grm();
    if (parama == null) {
      d.l.b.a.b.f.b.ajm(11);
    }
    p.g(parama, "classId.relativeClassName.pathSegments()");
    paramy = paramy.gil();
    localObject = j.jc(parama);
    p.g(localObject, "segments.first()");
    paramy = paramy.c((f)localObject, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nbg);
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
      paramy = ((e)paramy).giJ();
      p.g(parama, "name");
      parama = paramy.c(parama, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Nbg);
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
  
  public static final e b(y paramy, d.l.b.a.b.f.a parama)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.s
 * JD-Core Version:    0.7.0.1
 */