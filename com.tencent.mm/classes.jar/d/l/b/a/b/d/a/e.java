package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.a.v;
import d.aa;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.f.c;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.d.a;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static final Map<d.l.b.a.b.f.b, f> Llh;
  private static final Map<f, List<f>> Lli;
  private static final Set<d.l.b.a.b.f.b> Llj;
  private static final Set<f> Llk;
  public static final e Lll;
  
  static
  {
    AppMethodBeat.i(57572);
    Lll = new e();
    Object localObject1 = g.KZg.KZB;
    k.g(localObject1, "BUILTIN_NAMES._enum");
    localObject1 = u.Q(t.b((c)localObject1, "name"), f.aWB("name"));
    Object localObject2 = g.KZg.KZB;
    k.g(localObject2, "BUILTIN_NAMES._enum");
    localObject2 = u.Q(t.b((c)localObject2, "ordinal"), f.aWB("ordinal"));
    Object localObject3 = g.KZg.KZX;
    k.g(localObject3, "BUILTIN_NAMES.collection");
    localObject3 = u.Q(t.a((d.l.b.a.b.f.b)localObject3, "size"), f.aWB("size"));
    Object localObject4 = g.KZg.Lab;
    k.g(localObject4, "BUILTIN_NAMES.map");
    localObject4 = u.Q(t.a((d.l.b.a.b.f.b)localObject4, "size"), f.aWB("size"));
    Object localObject5 = g.KZg.KZp;
    k.g(localObject5, "BUILTIN_NAMES.charSequence");
    localObject5 = u.Q(t.b((c)localObject5, "length"), f.aWB("length"));
    Object localObject6 = g.KZg.Lab;
    k.g(localObject6, "BUILTIN_NAMES.map");
    localObject6 = u.Q(t.a((d.l.b.a.b.f.b)localObject6, "keys"), f.aWB("keySet"));
    Object localObject7 = g.KZg.Lab;
    k.g(localObject7, "BUILTIN_NAMES.map");
    localObject7 = u.Q(t.a((d.l.b.a.b.f.b)localObject7, "values"), f.aWB("values"));
    d.l.b.a.b.f.b localb = g.KZg.Lab;
    k.g(localb, "BUILTIN_NAMES.map");
    localObject1 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, u.Q(t.a(localb, "entries"), f.aWB("entrySet")) });
    Llh = (Map)localObject1;
    localObject2 = (Iterable)((Map)localObject1).entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((d.l.b.a.b.f.b)((Map.Entry)localObject3).getKey()).fZI(), ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).second;
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
      ((List)localObject1).add((f)((o)localObject4).first);
      break;
      Lli = (Map)localObject2;
      localObject1 = Llh.keySet();
      Llj = (Set)localObject1;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((d.l.b.a.b.f.b)((Iterator)localObject2).next()).fZI());
      }
      Llk = j.n((Iterable)localObject1);
      AppMethodBeat.o(57572);
      return;
    }
  }
  
  public static Set<f> fTQ()
  {
    return Llk;
  }
  
  public static List<f> h(f paramf)
  {
    AppMethodBeat.i(57570);
    k.h(paramf, "name1");
    List localList = (List)Lli.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)v.KTF;
    }
    AppMethodBeat.o(57570);
    return paramf;
  }
  
  public static boolean k(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57569);
    k.h(paramb, "callableMemberDescriptor");
    if (!Llk.contains(paramb.fRf()))
    {
      AppMethodBeat.o(57569);
      return false;
    }
    if ((j.a((Iterable)Llj, a.I((d.l.b.a.b.b.l)paramb))) && (paramb.fQU().isEmpty()))
    {
      AppMethodBeat.o(57569);
      return true;
    }
    if (g.c((d.l.b.a.b.b.l)paramb))
    {
      paramb = paramb.fQW();
      k.g(paramb, "overriddenDescriptors");
      paramb = (Iterable)paramb;
      if ((!(paramb instanceof Collection)) || (!((Collection)paramb).isEmpty()))
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          d.l.b.a.b.b.b localb = (d.l.b.a.b.b.b)paramb.next();
          k.g(localb, "it");
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
  
  public static String l(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57571);
    k.h(paramb, "$this$getBuiltinSpecialPropertyGetterName");
    boolean bool = g.c((d.l.b.a.b.b.l)paramb);
    if ((aa.KTq) && (!bool))
    {
      paramb = (Throwable)new AssertionError("This method is defined only for builtin members, but " + paramb + " found");
      AppMethodBeat.o(57571);
      throw paramb;
    }
    paramb = a.b(a.v(paramb), (d.g.a.b)a.Llm);
    if (paramb == null)
    {
      AppMethodBeat.o(57571);
      return null;
    }
    paramb = (f)Llh.get(a.o((d.l.b.a.b.b.l)paramb));
    if (paramb != null)
    {
      paramb = paramb.rf();
      AppMethodBeat.o(57571);
      return paramb;
    }
    AppMethodBeat.o(57571);
    return null;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final a Llm;
    
    static
    {
      AppMethodBeat.i(57568);
      Llm = new a();
      AppMethodBeat.o(57568);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */