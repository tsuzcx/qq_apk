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
import kotlin.g.b.aa;
import kotlin.g.b.ac;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/modules/StandardSubtypesOfAny;", "", "()V", "deserializingMap", "", "", "Lkotlinx/serialization/KSerializer;", "map", "Lkotlin/reflect/KClass;", "getDefaultDeserializer", "serializedClassName", "getDefaultDeserializer$kotlinx_serialization_runtime", "getSubclassSerializer", "objectToCheck", "getSubclassSerializer$kotlinx_serialization_runtime", "kotlinx-serialization-runtime"})
public final class i
{
  private static final Map<String, h<?>> UaN;
  public static final i UaO;
  private static final Map<b<?>, h<?>> map;
  
  static
  {
    AppMethodBeat.i(225864);
    UaO = new i();
    Object localObject1 = s.U(aa.bp(List.class), kotlinx.a.a.d.b(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    Object localObject2 = s.U(aa.bp(LinkedHashSet.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    Object localObject3 = s.U(aa.bp(HashSet.class), new y(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    kotlin.o localo1 = s.U(aa.bp(Set.class), kotlinx.a.a.d.c(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    kotlin.o localo2 = s.U(aa.bp(LinkedHashMap.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    kotlin.o localo3 = s.U(aa.bp(HashMap.class), new w(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    kotlin.o localo4 = s.U(aa.bp(Map.class), new kotlinx.a.b.ae(kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class))), kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)))));
    b localb = aa.bp(Map.Entry.class);
    h localh1 = kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)));
    h localh2 = kotlinx.a.a.c.a((h)new kotlinx.a.k(aa.bp(Object.class)));
    p.h(localh1, "keySerializer");
    p.h(localh2, "valueSerializer");
    localObject2 = kotlin.a.ae.e(new kotlin.o[] { localObject1, localObject2, localObject3, localo1, localo2, localo3, localo4, s.U(localb, (h)new am(localh1, localh2)), s.U(aa.bp(String.class), e.a(kotlin.g.b.ae.SYK)), s.U(aa.bp(Character.TYPE), e.a(f.SYo)), s.U(aa.bp(Integer.TYPE), e.a(kotlin.g.b.o.SYy)), s.U(aa.bp(Byte.TYPE), e.a(kotlin.g.b.d.SYj)), s.U(aa.bp(Short.TYPE), e.a(ac.SYJ)), s.U(aa.bp(Long.TYPE), e.a(r.SYz)), s.U(aa.bp(Double.TYPE), e.a(kotlin.g.b.k.SYw)), s.U(aa.bp(Float.TYPE), e.a(kotlin.g.b.l.SYx)), s.U(aa.bp(Boolean.TYPE), e.a(kotlin.g.b.c.SYi)), s.U(aa.bp(x.class), (h)bi.TZa) });
    map = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(kotlin.a.ae.atJ(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((h)((Map.Entry)localObject3).getValue()).fWv().hOz(), ((Map.Entry)localObject3).getValue());
    }
    UaN = (Map)localObject1;
    AppMethodBeat.o(225864);
  }
  
  public static h<?> buU(String paramString)
  {
    AppMethodBeat.i(225863);
    p.h(paramString, "serializedClassName");
    paramString = (h)UaN.get(paramString);
    AppMethodBeat.o(225863);
    return paramString;
  }
  
  public static h<?> gA(Object paramObject)
  {
    AppMethodBeat.i(225862);
    p.h(paramObject, "objectToCheck");
    Iterator localIterator = map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      b localb = (b)((Map.Entry)localObject).getKey();
      localObject = (h)((Map.Entry)localObject).getValue();
      if (u.a(paramObject, localb))
      {
        AppMethodBeat.o(225862);
        return localObject;
      }
    }
    AppMethodBeat.o(225862);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.d.i
 * JD-Core Version:    0.7.0.1
 */