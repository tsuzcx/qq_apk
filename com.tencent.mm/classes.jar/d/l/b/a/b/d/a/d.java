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
  private static final List<r> NbJ;
  private static final List<String> NbK;
  private static final List<String> NbL;
  private static final Map<r, b> NbM;
  private static final Map<String, b> NbN;
  private static final Set<f> NbO;
  private static final Set<String> NbP;
  public static final d NbQ;
  
  static
  {
    AppMethodBeat.i(57565);
    NbQ = new d();
    Object localObject2 = (Iterable)ak.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = d.l.b.a.b.j.e.d.NwT.getDesc();
      p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.B("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    NbJ = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    NbK = (List)localObject1;
    localObject2 = (Iterable)NbJ;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).MXf.sD());
    }
    NbL = (List)localObject1;
    localObject1 = v.Njg;
    localObject1 = v.bcy("Collection");
    localObject2 = d.l.b.a.b.j.e.d.NwT.getDesc();
    p.g(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = u.S(t.B((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), b.NbZ);
    localObject2 = v.bcy("Collection");
    Object localObject3 = d.l.b.a.b.j.e.d.NwT.getDesc();
    p.g(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = u.S(t.B((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), b.NbZ);
    localObject3 = v.bcy("Map");
    Object localObject4 = d.l.b.a.b.j.e.d.NwT.getDesc();
    p.g(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = u.S(t.B((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), b.NbZ);
    localObject4 = v.bcy("Map");
    Object localObject5 = d.l.b.a.b.j.e.d.NwT.getDesc();
    p.g(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = u.S(t.B((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), b.NbZ);
    localObject5 = v.bcy("Map");
    Object localObject6 = d.l.b.a.b.j.e.d.NwT.getDesc();
    p.g(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = u.S(t.B((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), b.NbZ);
    localObject6 = u.S(t.B(v.bcy("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.Nca);
    o localo1 = u.S(t.B(v.bcy("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.NbX);
    o localo2 = u.S(t.B(v.bcy("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.NbX);
    Object localObject7 = v.bcy("List");
    String str1 = d.l.b.a.b.j.e.d.NwX.getDesc();
    p.g(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = u.S(t.B((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), b.NbY);
    str1 = v.bcy("List");
    String str2 = d.l.b.a.b.j.e.d.NwX.getDesc();
    p.g(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, u.S(t.B(str1, "lastIndexOf", "Ljava/lang/Object;", str2), b.NbY) });
    NbM = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.aji(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    NbN = (Map)localObject1;
    localObject1 = ak.b(NbM.keySet(), (Iterable)NbJ);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).MXf);
    }
    NbO = j.n((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    NbP = j.n((Iterable)localObject1);
    AppMethodBeat.o(57565);
  }
  
  public static final d.l.b.a.b.b.t e(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(57562);
    p.h(paramt, "functionDescriptor");
    f localf = paramt.giD();
    p.g(localf, "functionDescriptor.name");
    if (!g(localf))
    {
      AppMethodBeat.o(57562);
      return null;
    }
    paramt = (d.l.b.a.b.b.t)d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramt, (d.g.a.b)c.Ncc);
    AppMethodBeat.o(57562);
    return paramt;
  }
  
  public static boolean g(f paramf)
  {
    AppMethodBeat.i(57563);
    p.h(paramf, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    boolean bool = NbO.contains(paramf);
    AppMethodBeat.o(57563);
    return bool;
  }
  
  public static final d.a i(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(57564);
    p.h(paramb, "$this$getSpecialSignatureInfo");
    if (!NbO.contains(paramb.giD()))
    {
      AppMethodBeat.o(57564);
      return null;
    }
    paramb = d.l.b.a.b.j.d.a.b(paramb, (d.g.a.b)d.Ncd);
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
    if (NbK.contains(paramb))
    {
      paramb = d.a.NbR;
      AppMethodBeat.o(57564);
      return paramb;
    }
    if ((b)ae.e(NbN, paramb) == b.NbX)
    {
      paramb = d.a.NbT;
      AppMethodBeat.o(57564);
      return paramb;
    }
    paramb = d.a.NbS;
    AppMethodBeat.o(57564);
    return paramb;
  }
  
  public static enum b
  {
    private final Object aFh;
    
    static
    {
      AppMethodBeat.i(57555);
      b localb1 = new b("NULL", 0, null);
      NbX = localb1;
      b localb2 = new b("INDEX", 1, Integer.valueOf(-1));
      NbY = localb2;
      b localb3 = new b("FALSE", 2, Boolean.FALSE);
      NbZ = localb3;
      a locala = new a("MAP_GET_OR_DEFAULT");
      Nca = locala;
      Ncb = new b[] { localb1, localb2, localb3, locala };
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
    public static final c Ncc;
    
    static
    {
      AppMethodBeat.i(57559);
      Ncc = new c();
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
    public static final d Ncd;
    
    static
    {
      AppMethodBeat.i(57561);
      Ncd = new d();
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