package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import d.l.b.a.b.j.e.d;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c
{
  private static final r NyH;
  private static final Map<r, f> NyI;
  private static final Map<String, f> NyJ;
  private static final List<f> NyK;
  private static final Map<f, List<f>> NyL;
  public static final c NyM;
  
  static
  {
    AppMethodBeat.i(57551);
    NyM = new c();
    Object localObject1 = d.NUd.getDesc();
    p.g(localObject1, "JvmPrimitiveType.INT.desc");
    NyH = t.B("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = d.l.b.a.b.d.b.v.NGm;
    localObject1 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject2 = d.NUb.getDesc();
    p.g(localObject2, "JvmPrimitiveType.BYTE.desc");
    localObject1 = u.R(t.B((String)localObject1, "toByte", "", (String)localObject2), f.bei("byteValue"));
    localObject2 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject3 = d.NUc.getDesc();
    p.g(localObject3, "JvmPrimitiveType.SHORT.desc");
    localObject2 = u.R(t.B((String)localObject2, "toShort", "", (String)localObject3), f.bei("shortValue"));
    localObject3 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject4 = d.NUd.getDesc();
    p.g(localObject4, "JvmPrimitiveType.INT.desc");
    localObject3 = u.R(t.B((String)localObject3, "toInt", "", (String)localObject4), f.bei("intValue"));
    localObject4 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject5 = d.NUf.getDesc();
    p.g(localObject5, "JvmPrimitiveType.LONG.desc");
    localObject4 = u.R(t.B((String)localObject4, "toLong", "", (String)localObject5), f.bei("longValue"));
    localObject5 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject6 = d.NUe.getDesc();
    p.g(localObject6, "JvmPrimitiveType.FLOAT.desc");
    localObject5 = u.R(t.B((String)localObject5, "toFloat", "", (String)localObject6), f.bei("floatValue"));
    localObject6 = d.l.b.a.b.d.b.v.beb("Number");
    Object localObject7 = d.NUg.getDesc();
    p.g(localObject7, "JvmPrimitiveType.DOUBLE.desc");
    localObject6 = u.R(t.B((String)localObject6, "toDouble", "", (String)localObject7), f.bei("doubleValue"));
    localObject7 = u.R(NyH, f.bei("remove"));
    String str1 = d.l.b.a.b.d.b.v.beb("CharSequence");
    String str2 = d.NUd.getDesc();
    p.g(str2, "JvmPrimitiveType.INT.desc");
    String str3 = d.NUa.getDesc();
    p.g(str3, "JvmPrimitiveType.CHAR.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, u.R(t.B(str1, "get", str2, str3), f.bei("charAt")) });
    NyI = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.ajS(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    NyJ = (Map)localObject1;
    localObject2 = (Iterable)NyI.keySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).Nul);
    }
    NyK = (List)localObject1;
    localObject2 = (Iterable)NyI.entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((r)((Map.Entry)localObject3).getKey()).Nul, ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).second;
      localObject1 = ((Map)localObject2).get(localObject5);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        ((Map)localObject2).put(localObject5, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add((f)((o)localObject4).first);
        break;
      }
    }
    NyL = (Map)localObject2;
    AppMethodBeat.o(57551);
  }
  
  public static f a(am paramam)
  {
    AppMethodBeat.i(57547);
    p.h(paramam, "functionDescriptor");
    Map localMap = NyJ;
    paramam = d.l.b.a.b.d.b.t.c((d.l.b.a.b.b.a)paramam);
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
    p.h(paramam, "functionDescriptor");
    if ((g.c((l)paramam)) && (d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramam, (d.g.a.b)new a(paramam)) != null))
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
    p.h(paramam, "$this$isRemoveAtByIndex");
    if ((p.i(paramam.gnf().sD(), "removeAt")) && (p.i(d.l.b.a.b.d.b.t.c((d.l.b.a.b.b.a)paramam), NyH.signature)))
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
    p.h(paramf, "$this$sameAsRenamedInJvmBuiltin");
    boolean bool = NyK.contains(paramf);
    AppMethodBeat.o(57546);
    return bool;
  }
  
  public static List<f> f(f paramf)
  {
    AppMethodBeat.i(57549);
    p.h(paramf, "name");
    List localList = (List)NyL.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)d.a.v.NhH;
    }
    AppMethodBeat.o(57549);
    return paramf;
  }
  
  public static List<f> gpP()
  {
    return NyK;
  }
  
  static final class a
    extends q
    implements d.g.a.b<d.l.b.a.b.b.b, Boolean>
  {
    a(am paramam)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */