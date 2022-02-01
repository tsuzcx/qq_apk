package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlinx.a.h;
import kotlinx.a.u;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerialModule;", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "polyBase2NamedSerializers", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerialModuleCollector;", "getContextual", "T", "", "kclass", "getPolymorphic", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "serializedClassName", "kotlinx-serialization-runtime"})
public final class f
  implements b
{
  private final Map<d.l.b<?>, h<?>> OiE;
  private final Map<d.l.b<?>, Map<d.l.b<?>, h<?>>> OlO;
  private final Map<d.l.b<?>, Map<String, h<?>>> OlP;
  
  public f(Map<d.l.b<?>, ? extends h<?>> paramMap, Map<d.l.b<?>, ? extends Map<d.l.b<?>, ? extends h<?>>> paramMap1, Map<d.l.b<?>, ? extends Map<String, ? extends h<?>>> paramMap2)
  {
    AppMethodBeat.i(200094);
    this.OiE = paramMap;
    this.OlO = paramMap1;
    this.OlP = paramMap2;
    AppMethodBeat.o(200094);
  }
  
  public final <T> h<? extends T> a(d.l.b<T> paramb, T paramT)
  {
    Object localObject3 = null;
    AppMethodBeat.i(200091);
    p.h(paramb, "baseClass");
    p.h(paramT, "value");
    if (!u.a(paramT, paramb))
    {
      AppMethodBeat.o(200091);
      return null;
    }
    Object localObject1 = (Map)this.OlO.get(paramb);
    if (localObject1 != null) {}
    for (localObject1 = (h)((Map)localObject1).get(z.bp(paramT.getClass()));; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof h)) {
        localObject2 = null;
      }
      if (localObject2 == null) {
        break;
      }
      AppMethodBeat.o(200091);
      return localObject2;
    }
    if (p.i(paramb, z.bp(Object.class)))
    {
      paramb = i.OlR;
      paramb = i.gv(paramT);
      if ((paramb instanceof h)) {
        break label146;
      }
      paramb = localObject3;
    }
    label146:
    for (;;)
    {
      AppMethodBeat.o(200091);
      return paramb;
      AppMethodBeat.o(200091);
      return null;
    }
  }
  
  public final <T> h<? extends T> a(d.l.b<T> paramb, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200092);
    p.h(paramb, "baseClass");
    p.h(paramString, "serializedClassName");
    if (p.i(paramb, z.bp(Object.class))) {
      localObject1 = i.OlR;
    }
    for (Object localObject1 = i.bff(paramString); localObject1 != null; localObject1 = null)
    {
      AppMethodBeat.o(200092);
      return localObject1;
    }
    paramb = (Map)this.OlP.get(paramb);
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
      AppMethodBeat.o(200092);
      return paramb;
      paramb = null;
      break;
    }
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(200093);
    p.h(paramd, "collector");
    Iterator localIterator = this.OiE.entrySet().iterator();
    Object localObject1;
    d.l.b localb1;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localb1 = (d.l.b)((Map.Entry)localObject1).getKey();
      localObject1 = (h)((Map.Entry)localObject1).getValue();
      if (localb1 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        AppMethodBeat.o(200093);
        throw paramd;
      }
      if (localObject1 == null)
      {
        paramd = new v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
        AppMethodBeat.o(200093);
        throw paramd;
      }
      paramd.a(localb1, (h)localObject1);
    }
    localIterator = this.OlO.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localb1 = (d.l.b)((Map.Entry)localObject1).getKey();
      localObject1 = ((Map)((Map.Entry)localObject1).getValue()).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        d.l.b localb2 = (d.l.b)((Map.Entry)localObject2).getKey();
        localObject2 = (h)((Map.Entry)localObject2).getValue();
        if (localb1 == null)
        {
          paramd = new v("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
          AppMethodBeat.o(200093);
          throw paramd;
        }
        if (localb2 == null)
        {
          paramd = new v("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
          AppMethodBeat.o(200093);
          throw paramd;
        }
        if (localObject2 == null)
        {
          paramd = new v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
          AppMethodBeat.o(200093);
          throw paramd;
        }
        paramd.a(localb1, localb2, (h)localObject2);
      }
    }
    AppMethodBeat.o(200093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.f
 * JD-Core Version:    0.7.0.1
 */