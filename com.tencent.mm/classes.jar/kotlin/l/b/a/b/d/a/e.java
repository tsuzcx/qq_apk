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
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.d.a;
import kotlin.o;
import kotlin.s;
import kotlin.z;

public final class e
{
  private static final Map<kotlin.l.b.a.b.f.b, f> aaRL;
  private static final Map<f, List<f>> aaRM;
  private static final Set<kotlin.l.b.a.b.f.b> aaRN;
  private static final Set<f> aaRO;
  public static final e aaRP;
  
  static
  {
    AppMethodBeat.i(57572);
    aaRP = new e();
    Object localObject1 = g.aaFI.aaGd;
    p.j(localObject1, "BUILTIN_NAMES._enum");
    localObject1 = s.M(t.b((c)localObject1, "name"), f.bHb("name"));
    Object localObject2 = g.aaFI.aaGd;
    p.j(localObject2, "BUILTIN_NAMES._enum");
    localObject2 = s.M(t.b((c)localObject2, "ordinal"), f.bHb("ordinal"));
    Object localObject3 = g.aaFI.aaGz;
    p.j(localObject3, "BUILTIN_NAMES.collection");
    localObject3 = s.M(t.a((kotlin.l.b.a.b.f.b)localObject3, "size"), f.bHb("size"));
    Object localObject4 = g.aaFI.aaGD;
    p.j(localObject4, "BUILTIN_NAMES.map");
    localObject4 = s.M(t.a((kotlin.l.b.a.b.f.b)localObject4, "size"), f.bHb("size"));
    Object localObject5 = g.aaFI.aaFR;
    p.j(localObject5, "BUILTIN_NAMES.charSequence");
    localObject5 = s.M(t.b((c)localObject5, "length"), f.bHb("length"));
    Object localObject6 = g.aaFI.aaGD;
    p.j(localObject6, "BUILTIN_NAMES.map");
    localObject6 = s.M(t.a((kotlin.l.b.a.b.f.b)localObject6, "keys"), f.bHb("keySet"));
    Object localObject7 = g.aaFI.aaGD;
    p.j(localObject7, "BUILTIN_NAMES.map");
    localObject7 = s.M(t.a((kotlin.l.b.a.b.f.b)localObject7, "values"), f.bHb("values"));
    kotlin.l.b.a.b.f.b localb = g.aaFI.aaGD;
    p.j(localb, "BUILTIN_NAMES.map");
    localObject1 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, s.M(t.a(localb, "entries"), f.bHb("entrySet")) });
    aaRL = (Map)localObject1;
    localObject2 = (Iterable)((Map)localObject1).entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((kotlin.l.b.a.b.f.b)((Map.Entry)localObject3).getKey()).iNA(), ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).My;
      localObject1 = ((Map)localObject2).get(localObject5);
      if (localObject1 != null) {
        break label594;
      }
      localObject1 = new ArrayList();
      ((Map)localObject2).put(localObject5, localObject1);
    }
    label594:
    for (;;)
    {
      ((List)localObject1).add((f)((o)localObject4).Mx);
      break;
      aaRM = (Map)localObject2;
      localObject1 = aaRL.keySet();
      aaRN = (Set)localObject1;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((kotlin.l.b.a.b.f.b)((Iterator)localObject2).next()).iNA());
      }
      aaRO = j.r((Iterable)localObject1);
      AppMethodBeat.o(57572);
      return;
    }
  }
  
  public static List<f> h(f paramf)
  {
    AppMethodBeat.i(57570);
    p.k(paramf, "name1");
    List localList = (List)aaRM.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)v.aaAd;
    }
    AppMethodBeat.o(57570);
    return paramf;
  }
  
  public static Set<f> iHM()
  {
    return aaRO;
  }
  
  public static boolean k(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57569);
    p.k(paramb, "callableMemberDescriptor");
    if (!aaRO.contains(paramb.iEU()))
    {
      AppMethodBeat.o(57569);
      return false;
    }
    if ((j.a((Iterable)aaRN, a.I((l)paramb))) && (paramb.iEJ().isEmpty()))
    {
      AppMethodBeat.o(57569);
      return true;
    }
    if (g.c((l)paramb))
    {
      paramb = paramb.iEL();
      p.j(paramb, "overriddenDescriptors");
      paramb = (Iterable)paramb;
      if ((!(paramb instanceof Collection)) || (!((Collection)paramb).isEmpty()))
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)paramb.next();
          p.j(localb, "it");
          if (k(localb))
          {
            AppMethodBeat.o(57569);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(57569);
    return false;
  }
  
  public static String l(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57571);
    p.k(paramb, "$this$getBuiltinSpecialPropertyGetterName");
    boolean bool = g.c((l)paramb);
    if ((z.aazO) && (!bool))
    {
      paramb = (Throwable)new AssertionError("This method is defined only for builtin members, but " + paramb + " found");
      AppMethodBeat.o(57571);
      throw paramb;
    }
    paramb = a.b(a.v(paramb), (kotlin.g.a.b)a.aaRQ);
    if (paramb == null)
    {
      AppMethodBeat.o(57571);
      return null;
    }
    paramb = (f)aaRL.get(a.o((l)paramb));
    if (paramb != null)
    {
      paramb = paramb.qu();
      AppMethodBeat.o(57571);
      return paramb;
    }
    AppMethodBeat.o(57571);
    return null;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final a aaRQ;
    
    static
    {
      AppMethodBeat.i(57568);
      aaRQ = new a();
      AppMethodBeat.o(57568);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */