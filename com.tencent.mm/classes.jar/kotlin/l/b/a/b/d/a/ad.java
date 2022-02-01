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
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.e.e;
import kotlin.r;

public class ad
{
  private static final Map<f, List<f>> aiQA;
  public static final a aiQo;
  private static final List<ad.a.a> aiQp;
  private static final List<String> aiQq;
  private static final List<String> aiQr;
  private static final Map<ad.a.a, c> aiQs;
  private static final Map<String, c> aiQt;
  private static final Set<f> aiQu;
  private static final Set<String> aiQv;
  private static final ad.a.a aiQw;
  private static final Map<ad.a.a, f> aiQx;
  private static final Map<String, f> aiQy;
  private static final List<f> aiQz;
  
  static
  {
    AppMethodBeat.i(191999);
    aiQo = new a((byte)0);
    Object localObject2 = (Iterable)ar.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = e.ajkd.getDesc();
      s.s(localObject4, "BOOLEAN.desc");
      ((Collection)localObject1).add(a.Q("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    aiQp = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad.a.a)((Iterator)localObject2).next()).signature);
    }
    aiQq = (List)localObject1;
    localObject2 = (Iterable)aiQp;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad.a.a)((Iterator)localObject2).next()).aiJy.PF());
    }
    aiQr = (List)localObject1;
    localObject1 = kotlin.l.b.a.b.d.b.v.aiXe;
    localObject1 = kotlin.l.b.a.b.d.b.v.bIY("Collection");
    localObject2 = e.ajkd.getDesc();
    s.s(localObject2, "BOOLEAN.desc");
    localObject1 = kotlin.v.Y(a.Q((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), c.aiQJ);
    localObject2 = kotlin.l.b.a.b.d.b.v.bIY("Collection");
    Object localObject3 = e.ajkd.getDesc();
    s.s(localObject3, "BOOLEAN.desc");
    localObject2 = kotlin.v.Y(a.Q((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), c.aiQJ);
    localObject3 = kotlin.l.b.a.b.d.b.v.bIY("Map");
    Object localObject4 = e.ajkd.getDesc();
    s.s(localObject4, "BOOLEAN.desc");
    localObject3 = kotlin.v.Y(a.Q((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), c.aiQJ);
    localObject4 = kotlin.l.b.a.b.d.b.v.bIY("Map");
    Object localObject5 = e.ajkd.getDesc();
    s.s(localObject5, "BOOLEAN.desc");
    localObject4 = kotlin.v.Y(a.Q((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), c.aiQJ);
    localObject5 = kotlin.l.b.a.b.d.b.v.bIY("Map");
    Object localObject6 = e.ajkd.getDesc();
    s.s(localObject6, "BOOLEAN.desc");
    localObject5 = kotlin.v.Y(a.Q((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), c.aiQJ);
    localObject6 = kotlin.v.Y(a.Q(kotlin.l.b.a.b.d.b.v.bIY("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.aiQK);
    Object localObject7 = kotlin.v.Y(a.Q(kotlin.l.b.a.b.d.b.v.bIY("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), c.aiQH);
    Object localObject8 = kotlin.v.Y(a.Q(kotlin.l.b.a.b.d.b.v.bIY("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), c.aiQH);
    Object localObject9 = kotlin.l.b.a.b.d.b.v.bIY("List");
    String str1 = e.ajkh.getDesc();
    s.s(str1, "INT.desc");
    localObject9 = kotlin.v.Y(a.Q((String)localObject9, "indexOf", "Ljava/lang/Object;", str1), c.aiQI);
    str1 = kotlin.l.b.a.b.d.b.v.bIY("List");
    String str2 = e.ajkh.getDesc();
    s.s(str2, "INT.desc");
    localObject2 = ak.e(new r[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, kotlin.v.Y(a.Q(str1, "lastIndexOf", "Ljava/lang/Object;", str2), c.aiQI) });
    aiQs = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ak.aKi(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((ad.a.a)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    aiQt = (Map)localObject1;
    localObject1 = ar.b(aiQs.keySet(), (Iterable)aiQp);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((ad.a.a)((Iterator)localObject3).next()).aiJy);
    }
    aiQu = p.r((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad.a.a)((Iterator)localObject2).next()).signature);
    }
    aiQv = p.r((Iterable)localObject1);
    localObject1 = e.ajkh.getDesc();
    s.s(localObject1, "INT.desc");
    aiQw = a.Q("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = kotlin.l.b.a.b.d.b.v.aiXe;
    localObject1 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject2 = e.ajkf.getDesc();
    s.s(localObject2, "BYTE.desc");
    localObject1 = kotlin.v.Y(a.Q((String)localObject1, "toByte", "", (String)localObject2), f.bJe("byteValue"));
    localObject2 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject3 = e.ajkg.getDesc();
    s.s(localObject3, "SHORT.desc");
    localObject2 = kotlin.v.Y(a.Q((String)localObject2, "toShort", "", (String)localObject3), f.bJe("shortValue"));
    localObject3 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject4 = e.ajkh.getDesc();
    s.s(localObject4, "INT.desc");
    localObject3 = kotlin.v.Y(a.Q((String)localObject3, "toInt", "", (String)localObject4), f.bJe("intValue"));
    localObject4 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject5 = e.ajkj.getDesc();
    s.s(localObject5, "LONG.desc");
    localObject4 = kotlin.v.Y(a.Q((String)localObject4, "toLong", "", (String)localObject5), f.bJe("longValue"));
    localObject5 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject6 = e.ajki.getDesc();
    s.s(localObject6, "FLOAT.desc");
    localObject5 = kotlin.v.Y(a.Q((String)localObject5, "toFloat", "", (String)localObject6), f.bJe("floatValue"));
    localObject6 = kotlin.l.b.a.b.d.b.v.bIX("Number");
    localObject7 = e.ajkk.getDesc();
    s.s(localObject7, "DOUBLE.desc");
    localObject6 = kotlin.v.Y(a.Q((String)localObject6, "toDouble", "", (String)localObject7), f.bJe("doubleValue"));
    localObject7 = kotlin.v.Y(aiQw, f.bJe("remove"));
    localObject8 = kotlin.l.b.a.b.d.b.v.bIX("CharSequence");
    localObject9 = e.ajkh.getDesc();
    s.s(localObject9, "INT.desc");
    str1 = e.ajke.getDesc();
    s.s(str1, "CHAR.desc");
    localObject2 = ak.e(new r[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, kotlin.v.Y(a.Q((String)localObject8, "get", (String)localObject9, str1), f.bJe("charAt")) });
    aiQx = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ak.aKi(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((ad.a.a)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    aiQy = (Map)localObject1;
    localObject2 = (Iterable)aiQx.keySet();
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad.a.a)((Iterator)localObject2).next()).aiJy);
    }
    aiQz = (List)localObject1;
    localObject2 = (Iterable)aiQx.entrySet();
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new r(((ad.a.a)((Map.Entry)localObject3).getKey()).aiJy, ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject3 = (Map)new LinkedHashMap();
    localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((Iterator)localObject4).next();
      localObject6 = (f)((r)localObject5).bsD;
      localObject2 = ((Map)localObject3).get(localObject6);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = (List)new ArrayList();
        ((Map)localObject3).put(localObject6, localObject1);
      }
      ((List)localObject1).add((f)((r)localObject5).bsC);
    }
    aiQA = (Map)localObject3;
    AppMethodBeat.o(191999);
  }
  
  public static final class a
  {
    static ad.a.a Q(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(191972);
      f localf = f.bJe(paramString2);
      s.s(localf, "identifier(name)");
      kotlin.l.b.a.b.d.b.v localv = kotlin.l.b.a.b.d.b.v.aiXe;
      paramString1 = new ad.a.a(localf, kotlin.l.b.a.b.d.b.v.ro(paramString1, paramString2 + '(' + paramString3 + ')' + paramString4));
      AppMethodBeat.o(191972);
      return paramString1;
    }
    
    public static List<f> h(f paramf)
    {
      AppMethodBeat.i(191979);
      s.u(paramf, "name");
      paramf = (List)ad.ksc().get(paramf);
      if (paramf == null)
      {
        paramf = (List)ab.aivy;
        AppMethodBeat.o(191979);
        return paramf;
      }
      AppMethodBeat.o(191979);
      return paramf;
    }
    
    public static boolean i(f paramf)
    {
      AppMethodBeat.i(191985);
      s.u(paramf, "<this>");
      boolean bool = ad.ksb().contains(paramf);
      AppMethodBeat.o(191985);
      return bool;
    }
  }
  
  public static enum c
  {
    private final Object dOI;
    
    static
    {
      AppMethodBeat.i(191991);
      aiQH = new c("NULL", 0, null);
      aiQI = new c("INDEX", 1, Integer.valueOf(-1));
      aiQJ = new c("FALSE", 2, Boolean.FALSE);
      aiQK = new a("MAP_GET_OR_DEFAULT");
      aiQL = new c[] { aiQH, aiQI, aiQJ, aiQK };
      AppMethodBeat.o(191991);
    }
    
    private c(Object paramObject)
    {
      this.dOI = paramObject;
    }
    
    static final class a
      extends ad.c
    {
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.ad
 * JD-Core Version:    0.7.0.1
 */