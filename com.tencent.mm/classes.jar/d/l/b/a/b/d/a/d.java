package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.ak;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
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
  private static final List<r> NyO;
  private static final List<String> NyP;
  private static final List<String> NyQ;
  private static final Map<r, b> NyR;
  private static final Map<String, b> NyS;
  private static final Set<f> NyT;
  private static final Set<String> NyU;
  public static final d NyV;
  
  static
  {
    AppMethodBeat.i(57565);
    NyV = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = d.l.b.a.b.j.e.d.NTZ.getDesc();
      p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.B("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    NyO = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    NyP = (List)localObject1;
    localObject2 = (Iterable)NyO;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).Nul.sD());
    }
    NyQ = (List)localObject1;
    localObject1 = v.NGm;
    localObject1 = v.bec("Collection");
    localObject2 = d.l.b.a.b.j.e.d.NTZ.getDesc();
    p.g(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = u.R(t.B((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.Nze);
    localObject2 = v.bec("Collection");
    Object localObject3 = d.l.b.a.b.j.e.d.NTZ.getDesc();
    p.g(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = u.R(t.B((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.Nze);
    localObject3 = v.bec("Map");
    Object localObject4 = d.l.b.a.b.j.e.d.NTZ.getDesc();
    p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = u.R(t.B((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.Nze);
    localObject4 = v.bec("Map");
    Object localObject5 = d.l.b.a.b.j.e.d.NTZ.getDesc();
    p.g(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = u.R(t.B((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.Nze);
    localObject5 = v.bec("Map");
    Object localObject6 = d.l.b.a.b.j.e.d.NTZ.getDesc();
    p.g(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = u.R(t.B((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.Nze);
    localObject6 = u.R(t.B(v.bec("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.Nzf);
    o localo1 = u.R(t.B(v.bec("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.Nzc);
    o localo2 = u.R(t.B(v.bec("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.Nzc);
    Object localObject7 = v.bec("List");
    String str1 = d.l.b.a.b.j.e.d.NUd.getDesc();
    p.g(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = u.R(t.B((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.Nzd);
    str1 = v.bec("List");
    String str2 = d.l.b.a.b.j.e.d.NUd.getDesc();
    p.g(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, u.R(t.B(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.Nzd) });
    NyR = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.ajS(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    NyS = (Map)localObject1;
    localObject1 = ak.b(NyR.keySet(), (Iterable)NyO);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).Nul);
    }
    NyT = j.n((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    NyU = j.n((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final d.l.b.a.b.b.t e(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    p.h(paramt, "functionDescriptor");
    f localf = paramt.gnf();
    p.g(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (d.l.b.a.b.b.t)d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramt, (d.g.a.b)c.Nzh);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    p.h(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = NyT.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final a i(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    p.h(paramb, "$this$getSpecialSignatureInfo");
    if (!NyT.contains(paramb.gnf()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = d.l.b.a.b.j.d.a.b(paramb, (d.g.a.b)d.Nzi);
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
    if (NyP.contains(paramb))
    {
      paramb = a.NyW;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(NyS, paramb) == b.Nzc)
    {
      paramb = a.NyY;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = a.NyX;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum a
  {
    private final String Nza;
    private final boolean Nzb;
    
    static
    {
      AppMethodBeat.i(57552);
      a locala1 = new a("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
      NyW = locala1;
      a locala2 = new a("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
      NyX = locala2;
      a locala3 = new a("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);
      NyY = locala3;
      NyZ = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(57552);
    }
    
    private a(String paramString, boolean paramBoolean)
    {
      this.Nza = paramString;
      this.Nzb = paramBoolean;
    }
  }
  
  public static enum b
  {
    private final Object aFh;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      Nzc = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      Nzd = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      Nze = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      Nzf = locala;
      Nzg = new b[] { localb1, localb2, localb3, locala };
      AppMethodBeat.o(57555);
    }
    
    private b(Object paramObject)
    {
      this.aFh = paramObject;
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
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final c Nzh;
    
    static
    {
      AppMethodBeat.i(57559);
      Nzh = new c();
      AppMethodBeat.o(57559);
    }
    
    c()
    {
      super();
    }
  }
  
  static final class d
    extends q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    public static final d Nzi;
    
    static
    {
      AppMethodBeat.i(57561);
      Nzi = new d();
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