package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.ab;
import kotlin.g.b.ad;
import kotlin.g.b.af;
import kotlin.g.b.f;
import kotlin.g.b.p;
import kotlin.g.b.r;
import kotlin.l.b;
import kotlin.s;
import kotlin.x;
import kotlinx.a.a.e;
import kotlinx.a.b.am;
import kotlinx.a.b.bi;
import kotlinx.a.b.w;
import kotlinx.a.b.y;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.u;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/modules/StandardSubtypesOfAny;", "", "()V", "deserializingMap", "", "", "Lkotlinx/serialization/KSerializer;", "map", "Lkotlin/reflect/KClass;", "getDefaultDeserializer", "serializedClassName", "getDefaultDeserializer$kotlinx_serialization_runtime", "getSubclassSerializer", "objectToCheck", "getSubclassSerializer$kotlinx_serialization_runtime", "kotlinx-serialization-runtime"})
public final class i
{
  private static final Map<String, h<?>> abEc;
  public static final i abEd;
  private static final Map<b<?>, h<?>> map;
  
  static
  {
    AppMethodBeat.i(257205);
    abEd = new i();
    Object localObject1 = s.M(ab.bO(List.class), kotlinx.a.a.d.b(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    Object localObject2 = s.M(ab.bO(LinkedHashSet.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    Object localObject3 = s.M(ab.bO(HashSet.class), new y(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    kotlin.o localo1 = s.M(ab.bO(Set.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    kotlin.o localo2 = s.M(ab.bO(LinkedHashMap.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    kotlin.o localo3 = s.M(ab.bO(HashMap.class), new w(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    kotlin.o localo4 = s.M(ab.bO(Map.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)))));
    b localb = ab.bO(Map.Entry.class);
    h localh1 = kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)));
    h localh2 = kotlinx.a.a.c.a((h)new kotlinx.a.k(ab.bO(Object.class)));
    p.k(localh1, "keySerializer");
    p.k(localh2, "valueSerializer");
    localObject2 = kotlin.a.ae.e(new kotlin.o[] { localObject1, localObject2, localObject3, localo1, localo2, localo3, localo4, s.M(localb, (h)new am(localh1, localh2)), s.M(ab.bO(String.class), e.a(af.aaBG)), s.M(ab.bO(Character.TYPE), e.a(f.aaBa)), s.M(ab.bO(Integer.TYPE), e.a(kotlin.g.b.o.aaBu)), s.M(ab.bO(Byte.TYPE), e.a(kotlin.g.b.d.aaAV)), s.M(ab.bO(Short.TYPE), e.a(ad.aaBF)), s.M(ab.bO(Long.TYPE), e.a(r.aaBv)), s.M(ab.bO(Double.TYPE), e.a(kotlin.g.b.k.aaBn)), s.M(ab.bO(Float.TYPE), e.a(kotlin.g.b.l.aaBt)), s.M(ab.bO(Boolean.TYPE), e.a(kotlin.g.b.c.aaAU)), s.M(ab.bO(x.class), (h)bi.abCq) });
    map = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(kotlin.a.ae.aDD(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((h)((Map.Entry)localObject3).getValue()).gPe().iTF(), ((Map.Entry)localObject3).getValue());
    }
    abEc = (Map)localObject1;
    AppMethodBeat.o(257205);
  }
  
  public static h<?> bHX(String paramString)
  {
    AppMethodBeat.i(257204);
    p.k(paramString, "serializedClassName");
    paramString = (h)abEc.get(paramString);
    AppMethodBeat.o(257204);
    return paramString;
  }
  
  public static h<?> gS(Object paramObject)
  {
    AppMethodBeat.i(257203);
    p.k(paramObject, "objectToCheck");
    Iterator localIterator = map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      b localb = (b)((Map.Entry)localObject).getKey();
      localObject = (h)((Map.Entry)localObject).getValue();
      if (u.a(paramObject, localb))
      {
        AppMethodBeat.o(257203);
        return localObject;
      }
    }
    AppMethodBeat.o(257203);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.d.i
 * JD-Core Version:    0.7.0.1
 */