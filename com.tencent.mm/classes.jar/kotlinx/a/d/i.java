package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.ab;
import d.g.b.ad;
import d.g.b.f;
import d.g.b.p;
import d.g.b.r;
import d.l.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlinx.a.a.e;
import kotlinx.a.b.am;
import kotlinx.a.b.bi;
import kotlinx.a.b.w;
import kotlinx.a.b.y;
import kotlinx.a.h;
import kotlinx.a.n;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/modules/StandardSubtypesOfAny;", "", "()V", "deserializingMap", "", "", "Lkotlinx/serialization/KSerializer;", "map", "Lkotlin/reflect/KClass;", "getDefaultDeserializer", "serializedClassName", "getDefaultDeserializer$kotlinx_serialization_runtime", "getSubclassSerializer", "objectToCheck", "getSubclassSerializer$kotlinx_serialization_runtime", "kotlinx-serialization-runtime"})
public final class i
{
  private static final Map<String, h<?>> OlQ;
  public static final i OlR;
  private static final Map<b<?>, h<?>> map;
  
  static
  {
    AppMethodBeat.i(200090);
    OlR = new i();
    Object localObject1 = d.u.R(d.g.b.z.bp(List.class), kotlinx.a.a.d.b(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    Object localObject2 = d.u.R(d.g.b.z.bp(LinkedHashSet.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    Object localObject3 = d.u.R(d.g.b.z.bp(HashSet.class), new y(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    d.o localo1 = d.u.R(d.g.b.z.bp(Set.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    d.o localo2 = d.u.R(d.g.b.z.bp(LinkedHashMap.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    d.o localo3 = d.u.R(d.g.b.z.bp(HashMap.class), new w(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    d.o localo4 = d.u.R(d.g.b.z.bp(Map.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)))));
    b localb = d.g.b.z.bp(Map.Entry.class);
    h localh1 = kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)));
    h localh2 = kotlinx.a.a.c.a((h)new kotlinx.a.k(d.g.b.z.bp(Object.class)));
    p.h(localh1, "keySerializer");
    p.h(localh2, "valueSerializer");
    localObject2 = d.a.ae.a(new d.o[] { localObject1, localObject2, localObject3, localo1, localo2, localo3, localo4, d.u.R(localb, (h)new am(localh1, localh2)), d.u.R(d.g.b.z.bp(String.class), e.a(ad.Njc)), d.u.R(d.g.b.z.bp(Character.TYPE), e.a(f.NiG)), d.u.R(d.g.b.z.bp(Integer.TYPE), e.a(d.g.b.o.NiQ)), d.u.R(d.g.b.z.bp(Byte.TYPE), e.a(d.g.b.d.NiB)), d.u.R(d.g.b.z.bp(Short.TYPE), e.a(ab.Njb)), d.u.R(d.g.b.z.bp(Long.TYPE), e.a(r.NiR)), d.u.R(d.g.b.z.bp(Double.TYPE), e.a(d.g.b.k.NiO)), d.u.R(d.g.b.z.bp(Float.TYPE), e.a(d.g.b.l.NiP)), d.u.R(d.g.b.z.bp(Boolean.TYPE), e.a(d.g.b.c.NiA)), d.u.R(d.g.b.z.bp(d.z.class), (h)bi.Okf) });
    map = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(d.a.ae.ajS(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((h)((Map.Entry)localObject3).getValue()).eOR().gBs(), ((Map.Entry)localObject3).getValue());
    }
    OlQ = (Map)localObject1;
    AppMethodBeat.o(200090);
  }
  
  public static h<?> bff(String paramString)
  {
    AppMethodBeat.i(200089);
    p.h(paramString, "serializedClassName");
    paramString = (h)OlQ.get(paramString);
    AppMethodBeat.o(200089);
    return paramString;
  }
  
  public static h<?> gv(Object paramObject)
  {
    AppMethodBeat.i(200088);
    p.h(paramObject, "objectToCheck");
    Iterator localIterator = map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      b localb = (b)((Map.Entry)localObject).getKey();
      localObject = (h)((Map.Entry)localObject).getValue();
      if (kotlinx.a.u.a(paramObject, localb))
      {
        AppMethodBeat.o(200088);
        return localObject;
      }
    }
    AppMethodBeat.o(200088);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.i
 * JD-Core Version:    0.7.0.1
 */