package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;

public final class m
{
  private static final Set<f> aaIe;
  private static final HashMap<a, a> aaIf;
  private static final HashMap<a, a> aaIg;
  private static final Set<f> aaIh;
  public static final m aaIi;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56704);
    aaIi = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].aaHx);
      i += 1;
    }
    aaIe = j.r((Iterable)localObject);
    aaIf = new HashMap();
    aaIg = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].aaIc.iNu());
      i += 1;
    }
    aaIh = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)aaIf).put(((l)localObject).aaIc, ((l)localObject).aaId);
      ((Map)aaIg).put(((l)localObject).aaId, ((l)localObject).aaIc);
      i += 1;
    }
    AppMethodBeat.o(56704);
  }
  
  public static boolean E(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56703);
    p.k(paramab, "type");
    if (bc.aA(paramab))
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramab = paramab.iOU().iEf();
    if (paramab == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    p.j(paramab, "type.constructor.declara…escriptor ?: return false");
    paramab = (kotlin.l.b.a.b.b.l)paramab;
    p.k(paramab, "descriptor");
    kotlin.l.b.a.b.b.l locall = paramab.iDJ();
    if (((locall instanceof kotlin.l.b.a.b.b.ab)) && (p.h(((kotlin.l.b.a.b.b.ab)locall).iFy(), g.aaFx)) && (aaIe.contains(paramab.iEU())))
    {
      AppMethodBeat.o(56703);
      return true;
    }
    AppMethodBeat.o(56703);
    return false;
  }
  
  public static a a(a parama)
  {
    AppMethodBeat.i(56702);
    p.k(parama, "arrayClassId");
    parama = (a)aaIf.get(parama);
    AppMethodBeat.o(56702);
    return parama;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    p.k(paramf, "name");
    boolean bool = aaIh.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */