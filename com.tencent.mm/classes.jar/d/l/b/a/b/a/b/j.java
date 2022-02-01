package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.ac;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.au;
import d.l.b.a.b.m.au.a;
import d.l.b.a.b.m.d.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static final au a(e parame1, e parame2)
  {
    AppMethodBeat.i(56826);
    p.h(parame1, "from");
    p.h(parame2, "to");
    if (parame1.gmm().size() == parame2.gmm().size()) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      parame1 = (Throwable)new AssertionError(parame1 + " and " + parame2 + " should have same number of type parameters, but " + parame1.gmm().size() + " / " + parame2.gmm().size() + " found");
      AppMethodBeat.o(56826);
      throw parame1;
    }
    Object localObject1 = au.NZG;
    parame1 = parame1.gmm();
    p.g(parame1, "from.declaredTypeParameters");
    localObject1 = (Iterable)parame1;
    parame1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      parame1.add(((as)((Iterator)localObject1).next()).glW());
    }
    parame1 = (Iterable)parame1;
    parame2 = parame2.gmm();
    p.g(parame2, "to.declaredTypeParameters");
    localObject1 = (Iterable)parame2;
    parame2 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (as)((Iterator)localObject1).next();
      p.g(localObject2, "it");
      localObject2 = ((as)localObject2).gne();
      p.g(localObject2, "it.defaultType");
      parame2.add(a.aO((ab)localObject2));
    }
    parame1 = au.a.cp(ae.A((Iterable)d.a.j.c(parame1, (Iterable)parame2)));
    AppMethodBeat.o(56826);
    return parame1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.b.j
 * JD-Core Version:    0.7.0.1
 */