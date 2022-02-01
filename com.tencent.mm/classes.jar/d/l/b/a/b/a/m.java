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
  private static final Set<f> Joi;
  private static final HashMap<a, a> Joj;
  private static final HashMap<a, a> Jok;
  private static final Set<f> Jol;
  public static final m Jom;
  
  static
  {
    int j = 0;
    AppMethodBeat.i(56704);
    Jom = new m();
    l[] arrayOfl = l.values();
    Object localObject = (Collection)new ArrayList(arrayOfl.length);
    int k = arrayOfl.length;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].JnB);
      i += 1;
    }
    Joi = j.o((Iterable)localObject);
    Joj = new HashMap();
    Jok = new HashMap();
    arrayOfl = l.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfl.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfl[i].Jog.fGY());
      i += 1;
    }
    Jol = (Set)localObject;
    arrayOfl = l.values();
    k = arrayOfl.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfl[i];
      ((Map)Joj).put(((l)localObject).Jog, ((l)localObject).Joh);
      ((Map)Jok).put(((l)localObject).Joh, ((l)localObject).Jog);
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
    paramab = paramab.fIW().fxM();
    if (paramab == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    k.g(paramab, "type.constructor.declara…escriptor ?: return false");
    paramab = (d.l.b.a.b.b.l)paramab;
    k.h(paramab, "descriptor");
    d.l.b.a.b.b.l locall = paramab.fxq();
    if (((locall instanceof d.l.b.a.b.b.ab)) && (k.g(((d.l.b.a.b.b.ab)locall).fzd(), g.JlB)) && (Joi.contains(paramab.fyB())))
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
    parama = (a)Joj.get(parama);
    AppMethodBeat.o(56702);
    return parama;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    k.h(paramf, "name");
    boolean bool = Jol.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.a.m
 * JD-Core Version:    0.7.0.1
 */