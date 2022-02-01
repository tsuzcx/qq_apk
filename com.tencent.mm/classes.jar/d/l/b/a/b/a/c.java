package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class c
{
  private static final LinkedHashSet<d.l.b.a.b.f.a> KYQ;
  public static final c KYR;
  
  static
  {
    AppMethodBeat.i(56653);
    KYR = new c();
    Object localObject1 = h.LaU;
    k.g(localObject1, "PrimitiveType.NUMBER_TYPES");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(g.c((h)((Iterator)localObject2).next()));
    }
    localObject2 = (Iterable)j.b((Collection)j.b((Collection)j.b((Collection)localObject1, g.KZg.KZq.fZL()), g.KZg.KZs.fZL()), g.KZg.KZB.fZL());
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(d.l.b.a.b.f.a.p((b)((Iterator)localObject2).next()));
    }
    KYQ = (LinkedHashSet)localObject1;
    AppMethodBeat.o(56653);
  }
  
  public static boolean b(e parame)
  {
    AppMethodBeat.i(56652);
    k.h(parame, "classDescriptor");
    if (d.l.b.a.b.j.c.u((l)parame))
    {
      Iterable localIterable = (Iterable)KYQ;
      parame = d.l.b.a.b.j.d.a.c((d.l.b.a.b.b.h)parame);
      if (parame != null) {}
      for (parame = parame.fZD(); j.a(localIterable, parame); parame = null)
      {
        AppMethodBeat.o(56652);
        return true;
      }
    }
    AppMethodBeat.o(56652);
    return false;
  }
  
  public static Set<d.l.b.a.b.f.a> fPx()
  {
    AppMethodBeat.i(56651);
    Set localSet = Collections.unmodifiableSet((Set)KYQ);
    k.g(localSet, "Collections.unmodifiableSet(classIds)");
    AppMethodBeat.o(56651);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */