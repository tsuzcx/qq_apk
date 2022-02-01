package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.au.a;
import kotlin.l.b.a.b.m.d.a;
import kotlin.z;

public final class j
{
  public static final au a(e parame1, e parame2)
  {
    AppMethodBeat.i(56826);
    p.k(parame1, "from");
    p.k(parame2, "to");
    if (parame1.iEb().size() == parame2.iEb().size()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      parame1 = (Throwable)new AssertionError(parame1 + " and " + parame2 + " should have same number of type parameters, but " + parame1.iEb().size() + " / " + parame2.iEb().size() + " found");
      AppMethodBeat.o(56826);
      throw parame1;
    }
    Object localObject1 = au.abqZ;
    parame1 = parame1.iEb();
    p.j(parame1, "from.declaredTypeParameters");
    localObject1 = (Iterable)parame1;
    parame1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      parame1.add(((as)((Iterator)localObject1).next()).iDL());
    }
    parame1 = (Iterable)parame1;
    parame2 = parame2.iEb();
    p.j(parame2, "to.declaredTypeParameters");
    localObject1 = (Iterable)parame2;
    parame2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (as)((Iterator)localObject1).next();
      p.j(localObject2, "it");
      localObject2 = ((as)localObject2).iET();
      p.j(localObject2, "it.defaultType");
      parame2.add(a.aN((ab)localObject2));
    }
    parame1 = au.a.cJ(ae.E((Iterable)kotlin.a.j.c(parame1, (Iterable)parame2)));
    AppMethodBeat.o(56826);
    return parame1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.j
 * JD-Core Version:    0.7.0.1
 */