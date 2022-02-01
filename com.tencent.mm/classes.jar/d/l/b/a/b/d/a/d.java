package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.ak;
import d.a.j;
import d.g.b.k;
import d.g.b.l;
import d.l.b.a.b.d.b.v;
import d.l.b.a.b.f.f;
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

public final class d
{
  private static final List<r> LkM;
  private static final List<String> LkN;
  private static final List<String> LkO;
  private static final Map<r, b> LkP;
  private static final Map<String, b> LkQ;
  private static final Set<f> LkR;
  private static final Set<String> LkS;
  public static final d LkT;
  
  static
  {
    AppMethodBeat.i(57565);
    LkT = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = d.l.b.a.b.j.e.d.LFV.getDesc();
      k.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.A("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    LkM = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    LkN = (List)localObject1;
    localObject2 = (Iterable)LkM;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).Lgj.rf());
    }
    LkO = (List)localObject1;
    localObject1 = v.Lsj;
    localObject1 = v.aWv("Collection");
    localObject2 = d.l.b.a.b.j.e.d.LFV.getDesc();
    k.g(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = u.Q(t.A((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.Llc);
    localObject2 = v.aWv("Collection");
    Object localObject3 = d.l.b.a.b.j.e.d.LFV.getDesc();
    k.g(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = u.Q(t.A((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.Llc);
    localObject3 = v.aWv("Map");
    Object localObject4 = d.l.b.a.b.j.e.d.LFV.getDesc();
    k.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = u.Q(t.A((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.Llc);
    localObject4 = v.aWv("Map");
    Object localObject5 = d.l.b.a.b.j.e.d.LFV.getDesc();
    k.g(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = u.Q(t.A((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.Llc);
    localObject5 = v.aWv("Map");
    Object localObject6 = d.l.b.a.b.j.e.d.LFV.getDesc();
    k.g(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = u.Q(t.A((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.Llc);
    localObject6 = u.Q(t.A(v.aWv("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.Lld);
    o localo1 = u.Q(t.A(v.aWv("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.Lla);
    o localo2 = u.Q(t.A(v.aWv("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.Lla);
    Object localObject7 = v.aWv("List");
    String str1 = d.l.b.a.b.j.e.d.LFZ.getDesc();
    k.g(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = u.Q(t.A((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.Llb);
    str1 = v.aWv("List");
    String str2 = d.l.b.a.b.j.e.d.LFZ.getDesc();
    k.g(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, u.Q(t.A(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.Llb) });
    LkP = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.agH(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    LkQ = (Map)localObject1;
    localObject1 = ak.a(LkP.keySet(), (Iterable)LkM);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).Lgj);
    }
    LkR = j.n((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    LkS = j.n((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final d.l.b.a.b.b.t e(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    k.h(paramt, "functionDescriptor");
    f localf = paramt.fRf();
    k.g(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (d.l.b.a.b.b.t)d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramt, (d.g.a.b)c.Llf);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    k.h(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = LkR.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final a i(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    k.h(paramb, "$this$getSpecialSignatureInfo");
    if (!LkR.contains(paramb.fRf()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = d.l.b.a.b.j.d.a.b(paramb, (d.g.a.b)d.Llg);
    if (paramb != null)
    {
      paramb = d.l.b.a.b.d.b.t.c((d.l.b.a.b.b.a)paramb);
      if (paramb != null) {}
    }
    else
    {
      AppMethodBeat.o(57564);
      return null;
    }
    if (LkN.contains(paramb))
    {
      paramb = a.LkU;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(LkQ, paramb) == b.Lla)
    {
      paramb = a.LkW;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = a.LkV;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum a
  {
    private final String LkY;
    private final boolean LkZ;
    
    static
    {
      AppMethodBeat.i(57552);
      a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
      LkU = locala1;
      a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
      LkV = locala2;
      a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
      LkW = locala3;
      LkX = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(57552);
    }
    
    private a(String paramString, boolean paramBoolean)
    {
      this.LkY = paramString;
      this.LkZ = paramBoolean;
    }
  }
  
  public static enum b
  {
    private final Object aDq;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      Lla = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      Llb = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      Llc = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      Lld = locala;
      Lle = new b[] { localb1, localb2, localb3, locala };
      AppMethodBeat.o(57555);
    }
    
    private b(Object paramObject)
    {
      this.aDq = paramObject;
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
    extends l
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final c Llf;
    
    static
    {
      AppMethodBeat.i(57559);
      Llf = new c();
      AppMethodBeat.o(57559);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends l
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final d Llg;
    
    static
    {
      AppMethodBeat.i(57561);
      Llg = new d();
      AppMethodBeat.o(57561);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */