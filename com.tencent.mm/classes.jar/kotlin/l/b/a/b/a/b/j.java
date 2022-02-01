package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.ay.a;
import kotlin.l.b.a.b.m.d.a;

public final class j
{
  public static final ay a(e parame1, e parame2)
  {
    AppMethodBeat.i(56826);
    s.u(parame1, "from");
    s.u(parame2, "to");
    if (parame1.kno().size() == parame2.kno().size()) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      parame1 = (Throwable)new AssertionError(parame1 + " and " + parame2 + " should have same number of type parameters, but " + parame1.kno().size() + " / " + parame2.kno().size() + " found");
      AppMethodBeat.o(56826);
      throw parame1;
    }
    Object localObject = ay.ajqs;
    parame1 = parame1.kno();
    s.s(parame1, "from.declaredTypeParameters");
    localObject = (Iterable)parame1;
    parame1 = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      parame1.add(((ba)((Iterator)localObject).next()).kmZ());
    }
    parame1 = (Iterable)parame1;
    parame2 = parame2.kno();
    s.s(parame2, "to.declaredTypeParameters");
    localObject = (Iterable)parame2;
    parame2 = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      al localal = ((ba)((Iterator)localObject).next()).koj();
      s.s(localal, "it.defaultType");
      parame2.add(a.aF((ad)localal));
    }
    parame1 = ay.a.dF(kotlin.a.ak.F((Iterable)p.d(parame1, (Iterable)parame2)));
    AppMethodBeat.o(56826);
    return parame1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.j
 * JD-Core Version:    0.7.0.1
 */