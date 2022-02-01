package d.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
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
  private static final Set<f> MSA;
  public static final m MSB;
  private static final Set<f> MSx;
  private static final HashMap<a, a> MSy;
  private static final HashMap<a, a> MSz;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56704);
    MSB = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].MRQ);
      i += 1;
    }
    MSx = j.n((Iterable)localObject);
    MSy = new HashMap();
    MSz = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].MSv.grb());
      i += 1;
    }
    MSA = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)MSy).put(((l)localObject).MSv, ((l)localObject).MSw);
      ((Map)MSz).put(((l)localObject).MSw, ((l)localObject).MSv);
      i += 1;
    }
    AppMethodBeat.o(56704);
  }
  
  public static boolean F(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56703);
    p.h(paramab, "type");
    if (bc.aB(paramab))
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramab = paramab.gsZ().ghO();
    if (paramab == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    p.g(paramab, "type.constructor.declara…escriptor ?: return false");
    paramab = (d.l.b.a.b.b.l)paramab;
    p.h(paramab, "descriptor");
    d.l.b.a.b.b.l locall = paramab.ghs();
    if (((locall instanceof d.l.b.a.b.b.ab)) && (p.i(((d.l.b.a.b.b.ab)locall).gjg(), g.MPQ)) && (MSx.contains(paramab.giD())))
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
    p.h(parama, "arrayClassId");
    parama = (a)MSy.get(parama);
    AppMethodBeat.o(56702);
    return parama;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    p.h(paramf, "name");
    boolean bool = MSA.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */