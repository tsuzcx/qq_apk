package kotlinx.a.f;

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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.am;
import kotlin.g.b.l;
import kotlin.l.c;
import kotlinx.a.a.a;
import kotlinx.a.b;
import kotlinx.a.d.ae;
import kotlinx.a.d.ao;
import kotlinx.a.d.f;
import kotlinx.a.d.h;
import kotlinx.a.d.i;
import kotlinx.a.d.j;
import kotlinx.a.d.o;
import kotlinx.a.d.p;
import kotlinx.a.d.x;
import kotlinx.a.d.y;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/modules/StandardSubtypesOfAny;", "", "()V", "deserializingMap", "", "", "Lkotlinx/serialization/KSerializer;", "map", "Lkotlin/reflect/KClass;", "getDefaultDeserializer", "serializedClassName", "getDefaultDeserializer$kotlinx_serialization_runtime", "getSubclassSerializer", "objectToCheck", "getSubclassSerializer$kotlinx_serialization_runtime", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class d
{
  private static final Map<String, b<?>> ajFf;
  public static final d ajFg;
  private static final Map<c<?>, b<?>> map;
  
  static
  {
    AppMethodBeat.i(188416);
    ajFg = new d();
    Object localObject1 = ai.cz(List.class);
    Object localObject2 = a.a((b)new kotlinx.a.d(ai.cz(Object.class)));
    kotlin.g.b.s.u(localObject2, "elementSerializer");
    localObject1 = kotlin.v.Y(localObject1, (b)new kotlinx.a.d.e((b)localObject2));
    localObject2 = kotlin.v.Y(ai.cz(LinkedHashSet.class), a.b(a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    Object localObject3 = kotlin.v.Y(ai.cz(HashSet.class), new o(a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    kotlin.r localr1 = kotlin.v.Y(ai.cz(Set.class), a.b(a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    kotlin.r localr2 = kotlin.v.Y(ai.cz(LinkedHashMap.class), new kotlinx.a.d.s(a.a((b)new kotlinx.a.d(ai.cz(Object.class))), a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    kotlin.r localr3 = kotlin.v.Y(ai.cz(HashMap.class), new kotlinx.a.d.m(a.a((b)new kotlinx.a.d(ai.cz(Object.class))), a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    kotlin.r localr4 = kotlin.v.Y(ai.cz(Map.class), new kotlinx.a.d.s(a.a((b)new kotlinx.a.d(ai.cz(Object.class))), a.a((b)new kotlinx.a.d(ai.cz(Object.class)))));
    Object localObject4 = ai.cz(Map.Entry.class);
    Object localObject5 = a.a((b)new kotlinx.a.d(ai.cz(Object.class)));
    Object localObject6 = a.a((b)new kotlinx.a.d(ai.cz(Object.class)));
    kotlin.g.b.s.u(localObject5, "keySerializer");
    kotlin.g.b.s.u(localObject6, "valueSerializer");
    localObject4 = kotlin.v.Y(localObject4, (b)new y((b)localObject5, (b)localObject6));
    localObject5 = kotlin.v.Y(ai.cz(String.class), a.a(am.aixg));
    localObject6 = ai.cz(Character.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.g.aiwM, "$this$serializer");
    localObject6 = kotlin.v.Y(localObject6, (b)h.ajDs);
    Object localObject7 = ai.cz(Integer.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.r.aiwW, "$this$serializer");
    localObject7 = kotlin.v.Y(localObject7, (b)p.ajDv);
    Object localObject8 = ai.cz(Byte.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.e.aiwI, "$this$serializer");
    localObject8 = kotlin.v.Y(localObject8, (b)kotlinx.a.d.g.ajDr);
    Object localObject9 = ai.cz(Short.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.ak.aixf, "$this$serializer");
    localObject9 = kotlin.v.Y(localObject9, (b)kotlinx.a.d.ak.ajDT);
    Object localObject10 = ai.cz(Long.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.v.aiwX, "$this$serializer");
    localObject10 = kotlin.v.Y(localObject10, (b)x.ajDA);
    Object localObject11 = ai.cz(Double.TYPE);
    kotlin.g.b.s.u(l.aiwU, "$this$serializer");
    localObject11 = kotlin.v.Y(localObject11, (b)i.ajDt);
    Object localObject12 = ai.cz(Float.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.m.aiwV, "$this$serializer");
    localObject12 = kotlin.v.Y(localObject12, (b)j.ajDu);
    Object localObject13 = ai.cz(Boolean.TYPE);
    kotlin.g.b.s.u(kotlin.g.b.d.aiwH, "$this$serializer");
    localObject13 = kotlin.v.Y(localObject13, (b)f.ajDq);
    c localc = ai.cz(ah.class);
    kotlin.g.b.s.u(ah.aiuX, "$this$serializer");
    localObject2 = kotlin.a.ak.e(new kotlin.r[] { localObject1, localObject2, localObject3, localr1, localr2, localr3, localr4, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, kotlin.v.Y(localc, (b)ao.ajDZ) });
    map = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(kotlin.a.ak.aKi(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((b)((Map.Entry)localObject3).getValue()).iou().kFa(), ((Map.Entry)localObject3).getValue());
    }
    ajFf = (Map)localObject1;
    AppMethodBeat.o(188416);
  }
  
  public static b<?> bKb(String paramString)
  {
    AppMethodBeat.i(188403);
    kotlin.g.b.s.u(paramString, "serializedClassName");
    paramString = (b)ajFf.get(paramString);
    AppMethodBeat.o(188403);
    return paramString;
  }
  
  public static b<?> jH(Object paramObject)
  {
    AppMethodBeat.i(188401);
    kotlin.g.b.s.u(paramObject, "objectToCheck");
    Iterator localIterator = map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      c localc = (c)((Map.Entry)localObject).getKey();
      localObject = (b)((Map.Entry)localObject).getValue();
      if (ae.a(paramObject, localc))
      {
        AppMethodBeat.o(188401);
        return localObject;
      }
    }
    AppMethodBeat.o(188401);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.f.d
 * JD-Core Version:    0.7.0.1
 */