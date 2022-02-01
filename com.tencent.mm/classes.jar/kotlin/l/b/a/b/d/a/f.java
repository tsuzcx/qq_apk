package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.f.c;
import kotlin.r;
import kotlin.v;

public final class f
{
  private static final Map<c, kotlin.l.b.a.b.f.f> aiOA;
  private static final Map<kotlin.l.b.a.b.f.f, List<kotlin.l.b.a.b.f.f>> aiOB;
  private static final Set<c> aiOC;
  private static final Set<kotlin.l.b.a.b.f.f> aiOD;
  public static final f aiOz;
  
  static
  {
    AppMethodBeat.i(57572);
    aiOz = new f();
    Object localObject1 = ak.e(new r[] { v.Y(g.b(k.a.aiCP, "name"), kotlin.l.b.a.b.f.f.bJe("name")), v.Y(g.b(k.a.aiCP, "ordinal"), kotlin.l.b.a.b.f.f.bJe("ordinal")), v.Y(g.b(k.a.aiDm, "size"), kotlin.l.b.a.b.f.f.bJe("size")), v.Y(g.b(k.a.aiDq, "size"), kotlin.l.b.a.b.f.f.bJe("size")), v.Y(g.b(k.a.aiCD, "length"), kotlin.l.b.a.b.f.f.bJe("length")), v.Y(g.b(k.a.aiDq, "keys"), kotlin.l.b.a.b.f.f.bJe("keySet")), v.Y(g.b(k.a.aiDq, "values"), kotlin.l.b.a.b.f.f.bJe("values")), v.Y(g.b(k.a.aiDq, "entries"), kotlin.l.b.a.b.f.f.bJe("entrySet")) });
    aiOA = (Map)localObject1;
    Object localObject2 = (Iterable)((Map)localObject1).entrySet();
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new r(((c)((Map.Entry)localObject3).getKey()).kxT(), ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    Object localObject3 = ((Iterable)localObject1).iterator();
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      kotlin.l.b.a.b.f.f localf = (kotlin.l.b.a.b.f.f)((r)localObject4).bsD;
      localObject1 = ((Map)localObject2).get(localf);
      if (localObject1 != null) {
        break label562;
      }
      localObject1 = (List)new ArrayList();
      ((Map)localObject2).put(localf, localObject1);
    }
    label562:
    for (;;)
    {
      ((List)localObject1).add((kotlin.l.b.a.b.f.f)((r)localObject4).bsC);
      break;
      localObject1 = (Map)new LinkedHashMap(ak.aKi(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), p.t((Iterable)((Map.Entry)localObject3).getValue()));
      }
      aiOB = (Map)localObject1;
      localObject1 = aiOA.keySet();
      aiOC = (Set)localObject1;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((c)((Iterator)localObject2).next()).kxT());
      }
      aiOD = p.r((Iterable)localObject1);
      AppMethodBeat.o(57572);
      return;
    }
  }
  
  public static List<kotlin.l.b.a.b.f.f> f(kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(57570);
    s.u(paramf, "name1");
    paramf = (List)aiOB.get(paramf);
    if (paramf == null)
    {
      paramf = (List)ab.aivy;
      AppMethodBeat.o(57570);
      return paramf;
    }
    AppMethodBeat.o(57570);
    return paramf;
  }
  
  public static Set<kotlin.l.b.a.b.f.f> krA()
  {
    return aiOD;
  }
  
  public static Map<c, kotlin.l.b.a.b.f.f> kry()
  {
    return aiOA;
  }
  
  public static Set<c> krz()
  {
    return aiOC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f
 * JD-Core Version:    0.7.0.1
 */