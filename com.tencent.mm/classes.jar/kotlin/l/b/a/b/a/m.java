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
  private static final Set<f> Tfk;
  private static final HashMap<a, a> Tfl;
  private static final HashMap<a, a> Tfm;
  private static final Set<f> Tfn;
  public static final m Tfo;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56704);
    Tfo = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].TeD);
      i += 1;
    }
    Tfk = j.r((Iterable)localObject);
    Tfl = new HashMap();
    Tfm = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].Tfi.hJa());
      i += 1;
    }
    Tfn = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)Tfl).put(((l)localObject).Tfi, ((l)localObject).Tfj);
      ((Map)Tfm).put(((l)localObject).Tfj, ((l)localObject).Tfi);
      i += 1;
    }
    AppMethodBeat.o(56704);
  }
  
  public static boolean E(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56703);
    p.h(paramab, "type");
    if (bc.aA(paramab))
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramab = paramab.hKE().hzS();
    if (paramab == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    p.g(paramab, "type.constructor.declara…escriptor ?: return false");
    paramab = (kotlin.l.b.a.b.b.l)paramab;
    p.h(paramab, "descriptor");
    kotlin.l.b.a.b.b.l locall = paramab.hzx();
    if (((locall instanceof kotlin.l.b.a.b.b.ab)) && (p.j(((kotlin.l.b.a.b.b.ab)locall).hBk(), g.TcD)) && (Tfk.contains(paramab.hAH())))
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
    parama = (a)Tfl.get(parama);
    AppMethodBeat.o(56702);
    return parama;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    p.h(paramf, "name");
    boolean bool = Tfn.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */