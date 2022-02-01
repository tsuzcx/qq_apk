package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

public final class am
{
  private static final aa a(aa paramaa)
  {
    AppMethodBeat.i(60807);
    int i = 0;
    paramaa = (Iterable)paramaa.abqE;
    Collection localCollection = (Collection)new ArrayList(j.a(paramaa, 10));
    Iterator localIterator = paramaa.iterator();
    while (localIterator.hasNext())
    {
      ab localab = (ab)localIterator.next();
      paramaa = localab;
      if (bc.aE(localab))
      {
        i = 1;
        paramaa = (ab)b(localab.iPX());
      }
      localCollection.add(paramaa);
    }
    paramaa = (List)localCollection;
    if (i == 0)
    {
      AppMethodBeat.o(60807);
      return null;
    }
    paramaa = new aa((Collection)paramaa);
    AppMethodBeat.o(60807);
    return paramaa;
  }
  
  public static final aj aq(ab paramab)
  {
    AppMethodBeat.i(60802);
    p.k(paramab, "$this$getAbbreviation");
    p.k(paramab, "$this$getAbbreviatedType");
    bg localbg = paramab.iPX();
    paramab = localbg;
    if (!(localbg instanceof a)) {
      paramab = null;
    }
    paramab = (a)paramab;
    if (paramab != null)
    {
      paramab = paramab.abpJ;
      AppMethodBeat.o(60802);
      return paramab;
    }
    AppMethodBeat.o(60802);
    return null;
  }
  
  public static final boolean ar(ab paramab)
  {
    AppMethodBeat.i(60804);
    p.k(paramab, "$this$isDefinitelyNotNullType");
    boolean bool = paramab.iPX() instanceof l;
    AppMethodBeat.o(60804);
    return bool;
  }
  
  public static final aj as(ab paramab)
  {
    AppMethodBeat.i(60806);
    at localat = paramab.iOU();
    paramab = localat;
    if (!(localat instanceof aa)) {
      paramab = null;
    }
    paramab = (aa)paramab;
    if (paramab == null)
    {
      AppMethodBeat.o(60806);
      return null;
    }
    paramab = a(paramab);
    if (paramab == null)
    {
      AppMethodBeat.o(60806);
      return null;
    }
    paramab = paramab.iPW();
    AppMethodBeat.o(60806);
    return paramab;
  }
  
  public static final aj b(aj paramaj1, aj paramaj2)
  {
    AppMethodBeat.i(60803);
    p.k(paramaj1, "$this$withAbbreviation");
    p.k(paramaj2, "abbreviatedType");
    if (ad.ap((ab)paramaj1))
    {
      AppMethodBeat.o(60803);
      return paramaj1;
    }
    paramaj1 = (aj)new a(paramaj1, paramaj2);
    AppMethodBeat.o(60803);
    return paramaj1;
  }
  
  public static final bg b(bg parambg)
  {
    AppMethodBeat.i(60805);
    p.k(parambg, "$this$makeDefinitelyNotNullOrNotNull");
    Object localObject1 = l.abqh;
    localObject1 = l.a.a(parambg);
    if (localObject1 != null) {}
    for (localObject1 = (bg)localObject1;; localObject1 = (bg)as((ab)parambg))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = parambg.Jm(false);
      }
      AppMethodBeat.o(60805);
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.am
 * JD-Core Version:    0.7.0.1
 */