package d.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.f.f;
import d.l.d;
import d.m.i;
import java.util.Iterator;
import java.util.List;

public final class s
{
  public static final e a(y paramy, d.l.b.a.b.f.a parama, aa paramaa)
  {
    AppMethodBeat.i(56858);
    k.h(paramy, "$this$findNonGenericClassAcrossDependencies");
    k.h(parama, "classId");
    k.h(paramaa, "notFoundClasses");
    paramy = b(paramy, parama);
    if (paramy != null)
    {
      AppMethodBeat.o(56858);
      return paramy;
    }
    paramy = paramaa.a(parama, i.c(i.d(i.b(parama, (d.g.a.b)a.LdE), (d.g.a.b)b.LdF)));
    AppMethodBeat.o(56858);
    return paramy;
  }
  
  public static final h a(y paramy, d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56856);
    k.h(paramy, "$this$findClassifierAcrossModuleDependencies");
    k.h(parama, "classId");
    Object localObject = parama.fZA();
    k.g(localObject, "classId.packageFqName");
    paramy = paramy.e((d.l.b.a.b.f.b)localObject);
    parama = parama.fZB().Lzj.fZN();
    if (parama == null) {
      d.l.b.a.b.f.b.agL(11);
    }
    k.g(parama, "classId.relativeClassName.pathSegments()");
    paramy = paramy.fQN();
    localObject = d.a.j.iO(parama);
    k.g(localObject, "segments.first()");
    paramy = paramy.c((f)localObject, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkj);
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
      paramy = ((e)paramy).fRk();
      k.g(parama, "name");
      parama = paramy.c(parama, (d.l.b.a.b.c.a.a)d.l.b.a.b.c.a.c.Lkj);
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
    k.h(paramy, "$this$findClassAcrossModuleDependencies");
    k.h(parama, "classId");
    parama = a(paramy, parama);
    paramy = parama;
    if (!(parama instanceof e)) {
      paramy = null;
    }
    paramy = (e)paramy;
    AppMethodBeat.o(56857);
    return paramy;
  }
  
  static final class b
    extends l
    implements d.g.a.b<d.l.b.a.b.f.a, Integer>
  {
    public static final b LdF;
    
    static
    {
      AppMethodBeat.i(56855);
      LdF = new b();
      AppMethodBeat.o(56855);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.s
 * JD-Core Version:    0.7.0.1
 */