package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.bc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class m
{
  private static final Set<f> LbC;
  private static final HashMap<a, a> LbD;
  private static final HashMap<a, a> LbE;
  private static final Set<f> LbF;
  public static final m LbG;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56704);
    LbG = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].LaV);
      i += 1;
    }
    LbC = j.n((Iterable)localObject);
    LbD = new HashMap();
    LbE = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].LbA.fZC());
      i += 1;
    }
    LbF = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)LbD).put(((l)localObject).LbA, ((l)localObject).LbB);
      ((Map)LbE).put(((l)localObject).LbB, ((l)localObject).LbA);
      i += 1;
    }
    AppMethodBeat.o(56704);
  }
  
  public static boolean F(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56703);
    k.h(paramab, "type");
    if (bc.aB(paramab))
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramab = paramab.gbz().fQq();
    if (paramab == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    k.g(paramab, "type.constructor.declara…escriptor ?: return false");
    paramab = (d.l.b.a.b.b.l)paramab;
    k.h(paramab, "descriptor");
    d.l.b.a.b.b.l locall = paramab.fPU();
    if (((locall instanceof d.l.b.a.b.b.ab)) && (k.g(((d.l.b.a.b.b.ab)locall).fRH(), g.KYV)) && (LbC.contains(paramab.fRf())))
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
    k.h(parama, "arrayClassId");
    parama = (a)LbD.get(parama);
    AppMethodBeat.o(56702);
    return parama;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    k.h(paramf, "name");
    boolean bool = LbF.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */