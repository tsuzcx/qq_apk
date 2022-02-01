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
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.f;
import kotlin.o;
import kotlin.s;

public final class d
{
  private static final List<r> aaRq;
  private static final List<String> aaRr;
  private static final List<String> aaRs;
  private static final Map<r, b> aaRt;
  private static final Map<String, b> aaRu;
  private static final Set<f> aaRv;
  private static final Set<String> aaRw;
  public static final d aaRx;
  
  static
  {
    AppMethodBeat.i(57565);
    aaRx = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
      p.j(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.O("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    aaRq = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    aaRr = (List)localObject1;
    localObject2 = (Iterable)aaRq;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).aaMN.qu());
    }
    aaRs = (List)localObject1;
    localObject1 = v.aaYI;
    localObject1 = v.bGV("Collection");
    localObject2 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
    p.j(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = s.M(t.O((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.aaRG);
    localObject2 = v.bGV("Collection");
    Object localObject3 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
    p.j(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = s.M(t.O((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.aaRG);
    localObject3 = v.bGV("Map");
    Object localObject4 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
    p.j(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = s.M(t.O((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.aaRG);
    localObject4 = v.bGV("Map");
    Object localObject5 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
    p.j(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = s.M(t.O((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.aaRG);
    localObject5 = v.bGV("Map");
    Object localObject6 = kotlin.l.b.a.b.j.e.d.ably.getDesc();
    p.j(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = s.M(t.O((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.aaRG);
    localObject6 = s.M(t.O(v.bGV("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.aaRH);
    o localo1 = s.M(t.O(v.bGV("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.aaRE);
    o localo2 = s.M(t.O(v.bGV("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.aaRE);
    Object localObject7 = v.bGV("List");
    String str1 = kotlin.l.b.a.b.j.e.d.ablC.getDesc();
    p.j(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = s.M(t.O((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.aaRF);
    str1 = v.bGV("List");
    String str2 = kotlin.l.b.a.b.j.e.d.ablC.getDesc();
    p.j(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, s.M(t.O(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.aaRF) });
    aaRt = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.aDD(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    aaRu = (Map)localObject1;
    localObject1 = ak.b(aaRt.keySet(), (Iterable)aaRq);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).aaMN);
    }
    aaRv = j.r((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    aaRw = j.r((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final kotlin.l.b.a.b.b.t e(kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    p.k(paramt, "functionDescriptor");
    f localf = paramt.iEU();
    p.j(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (kotlin.l.b.a.b.b.t)kotlin.l.b.a.b.j.d.a.b((kotlin.l.b.a.b.b.b)paramt, (kotlin.g.a.b)c.aaRJ);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    p.k(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = aaRv.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final d.a i(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    p.k(paramb, "$this$getSpecialSignatureInfo");
    if (!aaRv.contains(paramb.iEU()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = kotlin.l.b.a.b.j.d.a.b(paramb, (kotlin.g.a.b)d.aaRK);
    if (paramb != null)
    {
      paramb = kotlin.l.b.a.b.d.b.t.c((kotlin.l.b.a.b.b.a)paramb);
      if (paramb != null) {}
    }
    else
    {
      AppMethodBeat.o(57564);
      return null;
    }
    if (aaRr.contains(paramb))
    {
      paramb = d.a.aaRy;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(aaRu, paramb) == b.aaRE)
    {
      paramb = d.a.aaRA;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = d.a.aaRz;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum b
  {
    private final Object bUV;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      aaRE = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      aaRF = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      aaRG = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      aaRH = locala;
      aaRI = new b[] { localb1, localb2, localb3, locala };
      AppMethodBeat.o(57555);
    }
    
    private b(Object paramObject)
    {
      this.bUV = paramObject;
    }
    
    static final class a
      extends d.b
    {
      a()
      {
        super();
      }
    }
  }
  
  static final class c
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final c aaRJ;
    
    static
    {
      AppMethodBeat.i(57559);
      aaRJ = new c();
      AppMethodBeat.o(57559);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    public static final d aaRK;
    
    static
    {
      AppMethodBeat.i(57561);
      aaRK = new d();
      AppMethodBeat.o(57561);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */