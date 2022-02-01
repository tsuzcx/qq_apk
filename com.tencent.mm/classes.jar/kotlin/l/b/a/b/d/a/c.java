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
  private static final r Top;
  private static final Map<r, f> Toq;
  private static final Map<String, f> Tor;
  private static final List<f> Tos;
  private static final Map<f, List<f>> Tot;
  public static final c Tou;
  
  static
  {
    AppMethodBeat.i(57551);
    Tou = new c();
    Object localObject1 = d.TJa.getDesc();
    p.g(localObject1, "JvmPrimitiveType.INT.desc");
    Top = t.H("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = kotlin.l.b.a.b.d.b.v.TvS;
    localObject1 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject2 = d.TIY.getDesc();
    p.g(localObject2, "JvmPrimitiveType.BYTE.desc");
    localObject1 = s.U(t.H((String)localObject1, "toByte", "", (String)localObject2), f.btY("byteValue"));
    localObject2 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject3 = d.TIZ.getDesc();
    p.g(localObject3, "JvmPrimitiveType.SHORT.desc");
    localObject2 = s.U(t.H((String)localObject2, "toShort", "", (String)localObject3), f.btY("shortValue"));
    localObject3 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject4 = d.TJa.getDesc();
    p.g(localObject4, "JvmPrimitiveType.INT.desc");
    localObject3 = s.U(t.H((String)localObject3, "toInt", "", (String)localObject4), f.btY("intValue"));
    localObject4 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject5 = d.TJc.getDesc();
    p.g(localObject5, "JvmPrimitiveType.LONG.desc");
    localObject4 = s.U(t.H((String)localObject4, "toLong", "", (String)localObject5), f.btY("longValue"));
    localObject5 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject6 = d.TJb.getDesc();
    p.g(localObject6, "JvmPrimitiveType.FLOAT.desc");
    localObject5 = s.U(t.H((String)localObject5, "toFloat", "", (String)localObject6), f.btY("floatValue"));
    localObject6 = kotlin.l.b.a.b.d.b.v.btR("Number");
    Object localObject7 = d.TJd.getDesc();
    p.g(localObject7, "JvmPrimitiveType.DOUBLE.desc");
    localObject6 = s.U(t.H((String)localObject6, "toDouble", "", (String)localObject7), f.btY("doubleValue"));
    localObject7 = s.U(Top, f.btY("remove"));
    String str1 = kotlin.l.b.a.b.d.b.v.btR("CharSequence");
    String str2 = d.TJa.getDesc();
    p.g(str2, "JvmPrimitiveType.INT.desc");
    String str3 = d.TIX.getDesc();
    p.g(str3, "JvmPrimitiveType.CHAR.desc");
    localObject2 = ae.e(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, s.U(t.H(str1, "get", str2, str3), f.btY("charAt")) });
    Toq = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ae.atJ(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    Tor = (Map)localObject1;
    localObject2 = (Iterable)Toq.keySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).TjT);
    }
    Tos = (List)localObject1;
    localObject2 = (Iterable)Toq.entrySet();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((r)((Map.Entry)localObject3).getKey()).TjT, ((Map.Entry)localObject3).getValue()));
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
    Tot = (Map)localObject2;
    AppMethodBeat.o(57551);
  }
  
  public static f a(am paramam)
  {
    AppMethodBeat.i(57547);
    p.h(paramam, "functionDescriptor");
    Map localMap = Tor;
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
    p.h(paramam, "functionDescriptor");
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
    p.h(paramam, "$this$isRemoveAtByIndex");
    if ((p.j(paramam.hAH().sG(), "removeAt")) && (p.j(kotlin.l.b.a.b.d.b.t.c((kotlin.l.b.a.b.b.a)paramam), Top.signature)))
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
    boolean bool = Tos.contains(paramf);
    AppMethodBeat.o(57546);
    return bool;
  }
  
  public static List<f> f(f paramf)
  {
    AppMethodBeat.i(57549);
    p.h(paramf, "name");
    List localList = (List)Tot.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)kotlin.a.v.SXr;
    }
    AppMethodBeat.o(57549);
    return paramf;
  }
  
  public static List<f> hDr()
  {
    return Tos;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c
 * JD-Core Version:    0.7.0.1
 */