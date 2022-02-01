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
  public static final d JxA;
  private static final List<r> Jxt;
  private static final List<String> Jxu;
  private static final List<String> Jxv;
  private static final Map<r, b> Jxw;
  private static final Map<String, b> Jxx;
  private static final Set<f> Jxy;
  private static final Set<String> Jxz;
  
  static
  {
    AppMethodBeat.i(57565);
    JxA = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = d.l.b.a.b.j.e.d.JSC.getDesc();
      k.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.y("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    Jxt = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    Jxu = (List)localObject1;
    localObject2 = (Iterable)Jxt;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).JsQ.qV());
    }
    Jxv = (List)localObject1;
    localObject1 = v.JEQ;
    localObject1 = v.aQw("Collection");
    localObject2 = d.l.b.a.b.j.e.d.JSC.getDesc();
    k.g(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = u.P(t.y((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.JxJ);
    localObject2 = v.aQw("Collection");
    Object localObject3 = d.l.b.a.b.j.e.d.JSC.getDesc();
    k.g(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = u.P(t.y((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.JxJ);
    localObject3 = v.aQw("Map");
    Object localObject4 = d.l.b.a.b.j.e.d.JSC.getDesc();
    k.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = u.P(t.y((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.JxJ);
    localObject4 = v.aQw("Map");
    Object localObject5 = d.l.b.a.b.j.e.d.JSC.getDesc();
    k.g(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = u.P(t.y((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.JxJ);
    localObject5 = v.aQw("Map");
    Object localObject6 = d.l.b.a.b.j.e.d.JSC.getDesc();
    k.g(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = u.P(t.y((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.JxJ);
    localObject6 = u.P(t.y(v.aQw("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.JxK);
    o localo1 = u.P(t.y(v.aQw("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.JxH);
    o localo2 = u.P(t.y(v.aQw("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.JxH);
    Object localObject7 = v.aQw("List");
    String str1 = d.l.b.a.b.j.e.d.JSG.getDesc();
    k.g(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = u.P(t.y((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.JxI);
    str1 = v.aQw("List");
    String str2 = d.l.b.a.b.j.e.d.JSG.getDesc();
    k.g(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, u.P(t.y(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.JxI) });
    Jxw = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.adL(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    Jxx = (Map)localObject1;
    localObject1 = ak.a(Jxw.keySet(), (Iterable)Jxt);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).JsQ);
    }
    Jxy = j.o((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    Jxz = j.o((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final d.l.b.a.b.b.t e(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    k.h(paramt, "functionDescriptor");
    f localf = paramt.fyB();
    k.g(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (d.l.b.a.b.b.t)d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramt, (d.g.a.b)c.JxM);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    k.h(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = Jxy.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final d.a i(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    k.h(paramb, "$this$getSpecialSignatureInfo");
    if (!Jxy.contains(paramb.fyB()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = d.l.b.a.b.j.d.a.b(paramb, (d.g.a.b)d.JxN);
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
    if (Jxu.contains(paramb))
    {
      paramb = d.a.JxB;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(Jxx, paramb) == b.JxH)
    {
      paramb = d.a.JxD;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = d.a.JxC;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum b
  {
    private final Object aCy;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      JxH = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      JxI = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      JxJ = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      JxK = locala;
      JxL = new b[] { localb1, localb2, localb3, locala };
      AppMethodBeat.o(57555);
    }
    
    private b(Object paramObject)
    {
      this.aCy = paramObject;
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
    public static final c JxM;
    
    static
    {
      AppMethodBeat.i(57559);
      JxM = new c();
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
    public static final d JxN;
    
    static
    {
      AppMethodBeat.i(57561);
      JxN = new d();
      AppMethodBeat.o(57561);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */