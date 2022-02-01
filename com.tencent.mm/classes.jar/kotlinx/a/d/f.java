package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlinx.a.h;
import kotlinx.a.u;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerialModule;", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "polyBase2NamedSerializers", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "T", "", "kclass", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "kotlinx-serialization-runtime"})
public final class f
  implements b
{
  private final Map<kotlin.l.b<?>, h<?>> TXA;
  private final Map<kotlin.l.b<?>, Map<kotlin.l.b<?>, h<?>>> UaL;
  private final Map<kotlin.l.b<?>, Map<String, h<?>>> UaM;
  
  public f(Map<kotlin.l.b<?>, ? extends h<?>> paramMap, Map<kotlin.l.b<?>, ? extends Map<kotlin.l.b<?>, ? extends h<?>>> paramMap1, Map<kotlin.l.b<?>, ? extends Map<String, ? extends h<?>>> paramMap2)
  {
    AppMethodBeat.i(225868);
    this.TXA = paramMap;
    this.UaL = paramMap1;
    this.UaM = paramMap2;
    AppMethodBeat.o(225868);
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, T paramT)
  {
    Object localObject3 = null;
    AppMethodBeat.i(225865);
    p.h(paramb, "baseClass");
    p.h(paramT, "value");
    if (!u.a(paramT, paramb))
    {
      AppMethodBeat.o(225865);
      return null;
    }
    Object localObject1 = (Map)this.UaL.get(paramb);
    if (localObject1 != null) {}
    for (localObject1 = (h)((Map)localObject1).get(aa.bp(paramT.getClass()));; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof h)) {
        localObject2 = null;
      }
      if (localObject2 == null) {
        break;
      }
      AppMethodBeat.o(225865);
      return localObject2;
    }
    if (p.j(paramb, aa.bp(Object.class)))
    {
      paramb = i.UaO;
      paramb = i.gA(paramT);
      if ((paramb instanceof h)) {
        break label146;
      }
      paramb = localObject3;
    }
    label146:
    for (;;)
    {
      AppMethodBeat.o(225865);
      return paramb;
      AppMethodBeat.o(225865);
      return null;
    }
  }
  
  public final <T> h<? extends T> a(kotlin.l.b<T> paramb, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(225866);
    p.h(paramb, "baseClass");
    p.h(paramString, "serializedClassName");
    if (p.j(paramb, aa.bp(Object.class))) {
      localObject1 = i.UaO;
    }
    for (Object localObject1 = i.buU(paramString); localObject1 != null; localObject1 = null)
    {
      AppMethodBeat.o(225866);
      return localObject1;
    }
    paramb = (Map)this.UaM.get(paramb);
    if (paramb != null)
    {
      paramb = (h)paramb.get(paramString);
      if ((paramb instanceof h)) {
        break label108;
      }
      paramb = localObject2;
    }
    label108:
    for (;;)
    {
      AppMethodBeat.o(225866);
      return paramb;
      paramb = null;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(225867);
    p.h(paramd, "collector");
    Iterator localIterator = this.TXA.entrySet().iterator();
    Object localObject1;
    kotlin.l.b localb1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localb1 = (kotlin.l.b)((Map.Entry)localObject1).getKey();
      localObject1 = (h)((Map.Entry)localObject1).getValue();
      if (localb1 == null)
      {
        paramd = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        AppMethodBeat.o(225867);
        throw paramd;
      }
      if (localObject1 == null)
      {
        paramd = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
        AppMethodBeat.o(225867);
        throw paramd;
      }
      paramd.a(localb1, (h)localObject1);
    }
    localIterator = this.UaL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localb1 = (kotlin.l.b)((Map.Entry)localObject1).getKey();
      localObject1 = ((Map)((Map.Entry)localObject1).getValue()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        kotlin.l.b localb2 = (kotlin.l.b)((Map.Entry)localObject2).getKey();
        localObject2 = (h)((Map.Entry)localObject2).getValue();
        if (localb1 == null)
        {
          paramd = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
          AppMethodBeat.o(225867);
          throw paramd;
        }
        if (localb2 == null)
        {
          paramd = new t("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
          AppMethodBeat.o(225867);
          throw paramd;
        }
        if (localObject2 == null)
        {
          paramd = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
          AppMethodBeat.o(225867);
          throw paramd;
        }
        paramd.a(localb1, localb2, (h)localObject2);
      }
    }
    AppMethodBeat.o(225867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.d.f
 * JD-Core Version:    0.7.0.1
 */