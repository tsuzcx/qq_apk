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
import kotlin.aa;
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

public final class e
{
  private static final Map<kotlin.l.b.a.b.f.b, f> ToR;
  private static final Map<f, List<f>> ToS;
  private static final Set<kotlin.l.b.a.b.f.b> ToT;
  private static final Set<f> ToU;
  public static final e ToV;
  
  static
  {
    AppMethodBeat.i(57572);
    ToV = new e();
    Object localObject1 = g.TcO.Tdj;
    p.g(localObject1, "BUILTIN_NAMES._enum");
    localObject1 = s.U(t.b((c)localObject1, "name"), f.btY("name"));
    Object localObject2 = g.TcO.Tdj;
    p.g(localObject2, "BUILTIN_NAMES._enum");
    localObject2 = s.U(t.b((c)localObject2, "ordinal"), f.btY("ordinal"));
    Object localObject3 = g.TcO.TdF;
    p.g(localObject3, "BUILTIN_NAMES.collection");
    localObject3 = s.U(t.a((kotlin.l.b.a.b.f.b)localObject3, "size"), f.btY("size"));
    Object localObject4 = g.TcO.TdJ;
    p.g(localObject4, "BUILTIN_NAMES.map");
    localObject4 = s.U(t.a((kotlin.l.b.a.b.f.b)localObject4, "size"), f.btY("size"));
    Object localObject5 = g.TcO.TcX;
    p.g(localObject5, "BUILTIN_NAMES.charSequence");
    localObject5 = s.U(t.b((c)localObject5, "length"), f.btY("length"));
    Object localObject6 = g.TcO.TdJ;
    p.g(localObject6, "BUILTIN_NAMES.map");
    localObject6 = s.U(t.a((kotlin.l.b.a.b.f.b)localObject6, "keys"), f.btY("keySet"));
    Object localObject7 = g.TcO.TdJ;
    p.g(localObject7, "BUILTIN_NAMES.map");
    localObject7 = s.U(t.a((kotlin.l.b.a.b.f.b)localObject7, "values"), f.btY("values"));
    kotlin.l.b.a.b.f.b localb = g.TcO.TdJ;
    p.g(localb, "BUILTIN_NAMES.map");
    localObject1 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, s.U(t.a(localb, "entries"), f.btY("entrySet")) });
    ToR = (Map)localObject1;
    localObject2 = (Iterable)((Map)localObject1).entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((kotlin.l.b.a.b.f.b)((Map.Entry)localObject3).getKey()).hJg(), ((Map.Entry)localObject3).getValue()));
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
      ToS = (Map)localObject2;
      localObject1 = ToR.keySet();
      ToT = (Set)localObject1;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((kotlin.l.b.a.b.f.b)((Iterator)localObject2).next()).hJg());
      }
      ToU = j.r((Iterable)localObject1);
      AppMethodBeat.o(57572);
      return;
    }
  }
  
  public static List<f> h(f paramf)
  {
    AppMethodBeat.i(57570);
    p.h(paramf, "name1");
    List localList = (List)ToS.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)v.SXr;
    }
    AppMethodBeat.o(57570);
    return paramf;
  }
  
  public static Set<f> hDt()
  {
    return ToU;
  }
  
  public static boolean k(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57569);
    p.h(paramb, "callableMemberDescriptor");
    if (!ToU.contains(paramb.hAH()))
    {
      AppMethodBeat.o(57569);
      return false;
    }
    if ((j.a((Iterable)ToT, a.I((l)paramb))) && (paramb.hAw().isEmpty()))
    {
      AppMethodBeat.o(57569);
      return true;
    }
    if (g.c((l)paramb))
    {
      paramb = paramb.hAy();
      p.g(paramb, "overriddenDescriptors");
      paramb = (Iterable)paramb;
      if ((!(paramb instanceof Collection)) || (!((Collection)paramb).isEmpty()))
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          kotlin.l.b.a.b.b.b localb = (kotlin.l.b.a.b.b.b)paramb.next();
          p.g(localb, "it");
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
    p.h(paramb, "$this$getBuiltinSpecialPropertyGetterName");
    boolean bool = g.c((l)paramb);
    if ((aa.SXc) && (!bool))
    {
      paramb = (Throwable)new AssertionError("This method is defined only for builtin members, but " + paramb + " found");
      AppMethodBeat.o(57571);
      throw paramb;
    }
    paramb = a.b(a.v(paramb), (kotlin.g.a.b)a.ToW);
    if (paramb == null)
    {
      AppMethodBeat.o(57571);
      return null;
    }
    paramb = (f)ToR.get(a.o((l)paramb));
    if (paramb != null)
    {
      paramb = paramb.sG();
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
    public static final a ToW;
    
    static
    {
      AppMethodBeat.i(57568);
      ToW = new a();
      AppMethodBeat.o(57568);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.e
 * JD-Core Version:    0.7.0.1
 */