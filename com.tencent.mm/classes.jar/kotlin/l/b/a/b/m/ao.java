package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;

public final class ao
{
  private static final ac a(ac paramac)
  {
    AppMethodBeat.i(60807);
    int i = 0;
    Object localObject1 = (Iterable)paramac.ajpO;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (ad)localIterator.next();
      localObject1 = localObject2;
      if (bg.aw((ad)localObject2))
      {
        i = 1;
        localObject1 = (ad)b(((ad)localObject2).kAK());
      }
      localCollection.add(localObject1);
    }
    Object localObject2 = (List)localCollection;
    if (i == 0)
    {
      AppMethodBeat.o(60807);
      return null;
    }
    localObject1 = paramac.ajpN;
    if (localObject1 == null) {
      paramac = null;
    }
    for (;;)
    {
      paramac = new ac((Collection)localObject2).ag(paramac);
      AppMethodBeat.o(60807);
      return paramac;
      paramac = (ac)localObject1;
      if (bg.aw((ad)localObject1)) {
        paramac = (ad)b(((ad)localObject1).kAK());
      }
    }
  }
  
  public static final al a(al paramal, boolean paramBoolean)
  {
    AppMethodBeat.i(191570);
    s.u(paramal, "<this>");
    Object localObject = m.ajpo;
    localObject = m.a.a((bk)paramal, paramBoolean);
    if (localObject == null)
    {
      localObject = al((ad)paramal);
      if (localObject == null)
      {
        paramal = paramal.Pq(false);
        AppMethodBeat.o(191570);
        return paramal;
      }
      AppMethodBeat.o(191570);
      return localObject;
    }
    paramal = (al)localObject;
    AppMethodBeat.o(191570);
    return paramal;
  }
  
  public static final al aj(ad paramad)
  {
    AppMethodBeat.i(60802);
    s.u(paramad, "<this>");
    s.u(paramad, "<this>");
    paramad = paramad.kAK();
    if ((paramad instanceof a)) {}
    for (paramad = (a)paramad; paramad == null; paramad = null)
    {
      AppMethodBeat.o(60802);
      return null;
    }
    paramad = paramad.ajoN;
    AppMethodBeat.o(60802);
    return paramad;
  }
  
  public static final boolean ak(ad paramad)
  {
    AppMethodBeat.i(60804);
    s.u(paramad, "<this>");
    boolean bool = paramad.kAK() instanceof m;
    AppMethodBeat.o(60804);
    return bool;
  }
  
  private static final al al(ad paramad)
  {
    AppMethodBeat.i(60806);
    paramad = paramad.kzm();
    if ((paramad instanceof ac)) {}
    for (paramad = (ac)paramad; paramad == null; paramad = null)
    {
      AppMethodBeat.o(60806);
      return null;
    }
    paramad = a(paramad);
    if (paramad == null)
    {
      AppMethodBeat.o(60806);
      return null;
    }
    paramad = paramad.kAJ();
    AppMethodBeat.o(60806);
    return paramad;
  }
  
  public static final al b(al paramal1, al paramal2)
  {
    AppMethodBeat.i(60803);
    s.u(paramal1, "<this>");
    s.u(paramal2, "abbreviatedType");
    if (af.ai((ad)paramal1))
    {
      AppMethodBeat.o(60803);
      return paramal1;
    }
    paramal1 = (al)new a(paramal1, paramal2);
    AppMethodBeat.o(60803);
    return paramal1;
  }
  
  public static final bk b(bk parambk, boolean paramBoolean)
  {
    AppMethodBeat.i(191576);
    s.u(parambk, "<this>");
    Object localObject = m.ajpo;
    localObject = m.a.a(parambk, paramBoolean);
    if (localObject == null)
    {
      localObject = al((ad)parambk);
      if (localObject == null)
      {
        parambk = parambk.Pp(false);
        AppMethodBeat.o(191576);
        return parambk;
      }
      parambk = (bk)localObject;
      AppMethodBeat.o(191576);
      return parambk;
    }
    parambk = (bk)localObject;
    AppMethodBeat.o(191576);
    return parambk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.ao
 * JD-Core Version:    0.7.0.1
 */