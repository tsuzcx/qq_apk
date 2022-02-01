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
  private static final Map<String, b> ToA;
  private static final Set<f> ToB;
  private static final Set<String> ToC;
  public static final d ToD;
  private static final List<r> Tow;
  private static final List<String> Tox;
  private static final List<String> Toy;
  private static final Map<r, b> Toz;
  
  static
  {
    AppMethodBeat.i(57565);
    ToD = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
      p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.H("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    Tow = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    Tox = (List)localObject1;
    localObject2 = (Iterable)Tow;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).TjT.sG());
    }
    Toy = (List)localObject1;
    localObject1 = v.TvS;
    localObject1 = v.btS("Collection");
    localObject2 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
    p.g(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = s.U(t.H((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.ToM);
    localObject2 = v.btS("Collection");
    Object localObject3 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
    p.g(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = s.U(t.H((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.ToM);
    localObject3 = v.btS("Map");
    Object localObject4 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
    p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = s.U(t.H((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.ToM);
    localObject4 = v.btS("Map");
    Object localObject5 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
    p.g(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = s.U(t.H((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.ToM);
    localObject5 = v.btS("Map");
    Object localObject6 = kotlin.l.b.a.b.j.e.d.TIW.getDesc();
    p.g(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = s.U(t.H((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.ToM);
    localObject6 = s.U(t.H(v.btS("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToN);
    o localo1 = s.U(t.H(v.btS("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToK);
    o localo2 = s.U(t.H(v.btS("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToK);
    Object localObject7 = v.btS("List");
    String str1 = kotlin.l.b.a.b.j.e.d.TJa.getDesc();
    p.g(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = s.U(t.H((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.ToL);
    str1 = v.btS("List");
    String str2 = kotlin.l.b.a.b.j.e.d.TJa.getDesc();
    p.g(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, s.U(t.H(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.ToL) });
    Toz = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.atJ(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    ToA = (Map)localObject1;
    localObject1 = ak.b(Toz.keySet(), (Iterable)Tow);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).TjT);
    }
    ToB = j.r((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    ToC = j.r((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final kotlin.l.b.a.b.b.t e(kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    p.h(paramt, "functionDescriptor");
    f localf = paramt.hAH();
    p.g(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (kotlin.l.b.a.b.b.t)kotlin.l.b.a.b.j.d.a.b((kotlin.l.b.a.b.b.b)paramt, (kotlin.g.a.b)c.ToP);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    p.h(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = ToB.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final d.a i(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    p.h(paramb, "$this$getSpecialSignatureInfo");
    if (!ToB.contains(paramb.hAH()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = kotlin.l.b.a.b.j.d.a.b(paramb, (kotlin.g.a.b)d.ToQ);
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
    if (Tox.contains(paramb))
    {
      paramb = d.a.ToE;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(ToA, paramb) == b.ToK)
    {
      paramb = d.a.ToG;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = d.a.ToF;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum b
  {
    private final Object aEX;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      ToK = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      ToL = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      ToM = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      ToN = locala;
      ToO = new b[] { localb1, localb2, localb3, locala };
      AppMethodBeat.o(57555);
    }
    
    private b(Object paramObject)
    {
      this.aEX = paramObject;
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
    public static final c ToP;
    
    static
    {
      AppMethodBeat.i(57559);
      ToP = new c();
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
    public static final d ToQ;
    
    static
    {
      AppMethodBeat.i(57561);
      ToQ = new d();
      AppMethodBeat.o(57561);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */