package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.d;
import kotlin.o;
import kotlin.s;

public final class c
{
  private static final r aaRj;
  private static final Map<r, f> aaRk;
  private static final Map<String, f> aaRl;
  private static final List<f> aaRm;
  private static final Map<f, List<f>> aaRn;
  public static final c aaRo;
  
  static
  {
    AppMethodBeat.i(57551);
    aaRo = new c();
    Object localObject1 = d.ablC.getDesc();
    p.j(localObject1, "JvmPrimitiveType.INT.desc");
    aaRj = t.O("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = kotlin.l.b.a.b.d.b.v.aaYI;
    localObject1 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject2 = d.ablA.getDesc();
    p.j(localObject2, "JvmPrimitiveType.BYTE.desc");
    localObject1 = s.M(t.O((String)localObject1, "toByte", "", (String)localObject2), f.bHb("byteValue"));
    localObject2 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject3 = d.ablB.getDesc();
    p.j(localObject3, "JvmPrimitiveType.SHORT.desc");
    localObject2 = s.M(t.O((String)localObject2, "toShort", "", (String)localObject3), f.bHb("shortValue"));
    localObject3 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject4 = d.ablC.getDesc();
    p.j(localObject4, "JvmPrimitiveType.INT.desc");
    localObject3 = s.M(t.O((String)localObject3, "toInt", "", (String)localObject4), f.bHb("intValue"));
    localObject4 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject5 = d.ablE.getDesc();
    p.j(localObject5, "JvmPrimitiveType.LONG.desc");
    localObject4 = s.M(t.O((String)localObject4, "toLong", "", (String)localObject5), f.bHb("longValue"));
    localObject5 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject6 = d.ablD.getDesc();
    p.j(localObject6, "JvmPrimitiveType.FLOAT.desc");
    localObject5 = s.M(t.O((String)localObject5, "toFloat", "", (String)localObject6), f.bHb("floatValue"));
    localObject6 = kotlin.l.b.a.b.d.b.v.bGU("Number");
    Object localObject7 = d.ablF.getDesc();
    p.j(localObject7, "JvmPrimitiveType.DOUBLE.desc");
    localObject6 = s.M(t.O((String)localObject6, "toDouble", "", (String)localObject7), f.bHb("doubleValue"));
    localObject7 = s.M(aaRj, f.bHb("remove"));
    String str1 = kotlin.l.b.a.b.d.b.v.bGU("CharSequence");
    String str2 = d.ablC.getDesc();
    p.j(str2, "JvmPrimitiveType.INT.desc");
    String str3 = d.ablz.getDesc();
    p.j(str3, "JvmPrimitiveType.CHAR.desc");
    localObject2 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, s.M(t.O(str1, "get", str2, str3), f.bHb("charAt")) });
    aaRk = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.aDD(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    aaRl = (Map)localObject1;
    localObject2 = (Iterable)aaRk.keySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).aaMN);
    }
    aaRm = (List)localObject1;
    localObject2 = (Iterable)aaRk.entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((r)((Map.Entry)localObject3).getKey()).aaMN, ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).My;
      localObject1 = ((Map)localObject2).get(localObject5);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        ((Map)localObject2).put(localObject5, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add((f)((o)localObject4).Mx);
        break;
      }
    }
    aaRn = (Map)localObject2;
    AppMethodBeat.o(57551);
  }
  
  public static f a(am paramam)
  {
    AppMethodBeat.i(57547);
    p.k(paramam, "functionDescriptor");
    Map localMap = aaRl;
    paramam = kotlin.l.b.a.b.d.b.t.c((kotlin.l.b.a.b.b.a)paramam);
    if (paramam == null)
    {
      AppMethodBeat.o(57547);
      return null;
    }
    paramam = (f)localMap.get(paramam);
    AppMethodBeat.o(57547);
    return paramam;
  }
  
  public static boolean b(am paramam)
  {
    AppMethodBeat.i(57548);
    p.k(paramam, "functionDescriptor");
    if ((g.c((l)paramam)) && (kotlin.l.b.a.b.j.d.a.b((kotlin.l.b.a.b.b.b)paramam, (kotlin.g.a.b)new a(paramam)) != null))
    {
      AppMethodBeat.o(57548);
      return true;
    }
    AppMethodBeat.o(57548);
    return false;
  }
  
  public static boolean c(am paramam)
  {
    AppMethodBeat.i(57550);
    p.k(paramam, "$this$isRemoveAtByIndex");
    if ((p.h(paramam.iEU().qu(), "removeAt")) && (p.h(kotlin.l.b.a.b.d.b.t.c((kotlin.l.b.a.b.b.a)paramam), aaRj.signature)))
    {
      AppMethodBeat.o(57550);
      return true;
    }
    AppMethodBeat.o(57550);
    return false;
  }
  
  public static boolean e(f paramf)
  {
    AppMethodBeat.i(57546);
    p.k(paramf, "$this$sameAsRenamedInJvmBuiltin");
    boolean bool = aaRm.contains(paramf);
    AppMethodBeat.o(57546);
    return bool;
  }
  
  public static List<f> f(f paramf)
  {
    AppMethodBeat.i(57549);
    p.k(paramf, "name");
    List localList = (List)aaRn.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)kotlin.a.v.aaAd;
    }
    AppMethodBeat.o(57549);
    return paramf;
  }
  
  public static List<f> iHK()
  {
    return aaRm;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean>
  {
    a(am paramam)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */