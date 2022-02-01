package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.am;
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
  private static final r LkF;
  private static final Map<r, f> LkG;
  private static final Map<String, f> LkH;
  private static final List<f> LkI;
  private static final Map<f, List<f>> LkJ;
  public static final c LkK;
  
  static
  {
    AppMethodBeat.i(57551);
    LkK = new c();
    Object localObject1 = d.LFZ.getDesc();
    k.g(localObject1, "JvmPrimitiveType.INT.desc");
    LkF = t.A("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = d.l.b.a.b.d.b.v.Lsj;
    localObject1 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject2 = d.LFX.getDesc();
    k.g(localObject2, "JvmPrimitiveType.BYTE.desc");
    localObject1 = u.Q(t.A((String)localObject1, "toByte", "", (String)localObject2), f.aWB("byteValue"));
    localObject2 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject3 = d.LFY.getDesc();
    k.g(localObject3, "JvmPrimitiveType.SHORT.desc");
    localObject2 = u.Q(t.A((String)localObject2, "toShort", "", (String)localObject3), f.aWB("shortValue"));
    localObject3 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject4 = d.LFZ.getDesc();
    k.g(localObject4, "JvmPrimitiveType.INT.desc");
    localObject3 = u.Q(t.A((String)localObject3, "toInt", "", (String)localObject4), f.aWB("intValue"));
    localObject4 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject5 = d.LGb.getDesc();
    k.g(localObject5, "JvmPrimitiveType.LONG.desc");
    localObject4 = u.Q(t.A((String)localObject4, "toLong", "", (String)localObject5), f.aWB("longValue"));
    localObject5 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject6 = d.LGa.getDesc();
    k.g(localObject6, "JvmPrimitiveType.FLOAT.desc");
    localObject5 = u.Q(t.A((String)localObject5, "toFloat", "", (String)localObject6), f.aWB("floatValue"));
    localObject6 = d.l.b.a.b.d.b.v.aWu("Number");
    Object localObject7 = d.LGc.getDesc();
    k.g(localObject7, "JvmPrimitiveType.DOUBLE.desc");
    localObject6 = u.Q(t.A((String)localObject6, "toDouble", "", (String)localObject7), f.aWB("doubleValue"));
    localObject7 = u.Q(LkF, f.aWB("remove"));
    String str1 = d.l.b.a.b.d.b.v.aWu("CharSequence");
    String str2 = d.LFZ.getDesc();
    k.g(str2, "JvmPrimitiveType.INT.desc");
    String str3 = d.LFW.getDesc();
    k.g(str3, "JvmPrimitiveType.CHAR.desc");
    localObject2 = ae.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, u.Q(t.A(str1, "get", str2, str3), f.aWB("charAt")) });
    LkG = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.agH(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    LkH = (Map)localObject1;
    localObject2 = (Iterable)LkG.keySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).Lgj);
    }
    LkI = (List)localObject1;
    localObject2 = (Iterable)LkG.entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((r)((Map.Entry)localObject3).getKey()).Lgj, ((Map.Entry)localObject3).getValue()));
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
    LkJ = (Map)localObject2;
    AppMethodBeat.o(57551);
  }
  
  public static f a(am paramam)
  {
    AppMethodBeat.i(57547);
    k.h(paramam, "functionDescriptor");
    Map localMap = LkH;
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
    k.h(paramam, "functionDescriptor");
    if ((g.c((d.l.b.a.b.b.l)paramam)) && (d.l.b.a.b.j.d.a.b((d.l.b.a.b.b.b)paramam, (d.g.a.b)new a(paramam)) != null))
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
    k.h(paramam, "$this$isRemoveAtByIndex");
    if ((k.g(paramam.fRf().rf(), "removeAt")) && (k.g(d.l.b.a.b.d.b.t.c((d.l.b.a.b.b.a)paramam), LkF.signature)))
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
    k.h(paramf, "$this$sameAsRenamedInJvmBuiltin");
    boolean bool = LkI.contains(paramf);
    AppMethodBeat.o(57546);
    return bool;
  }
  
  public static List<f> f(f paramf)
  {
    AppMethodBeat.i(57549);
    k.h(paramf, "name");
    List localList = (List)LkJ.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)d.a.v.KTF;
    }
    AppMethodBeat.o(57549);
    return paramf;
  }
  
  public static List<f> fTO()
  {
    return LkI;
  }
  
  static final class a
    extends d.g.b.l
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