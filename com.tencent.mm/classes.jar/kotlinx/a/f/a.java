package kotlinx.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.l.c;
import kotlinx.a.d.ae;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2Serializers", "polyBase2NamedSerializers", "", "polyBase2DefaultProvider", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicProvider;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", "T", "", "kclass", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class a
  extends b
{
  private final Map<c<?>, kotlinx.a.b<?>> ajFa;
  public final Map<c<?>, Map<c<?>, kotlinx.a.b<?>>> ajFb;
  private final Map<c<?>, Map<String, kotlinx.a.b<?>>> ajFc;
  private final Map<c<?>, kotlin.g.a.b<String, kotlinx.a.a<?>>> ajFd;
  
  public a(Map<c<?>, ? extends kotlinx.a.b<?>> paramMap, Map<c<?>, ? extends Map<c<?>, ? extends kotlinx.a.b<?>>> paramMap1, Map<c<?>, ? extends Map<String, ? extends kotlinx.a.b<?>>> paramMap2, Map<c<?>, ? extends kotlin.g.a.b<? super String, ? extends kotlinx.a.a<?>>> paramMap3)
  {
    super((byte)0);
    AppMethodBeat.i(188404);
    this.ajFa = paramMap;
    this.ajFb = paramMap1;
    this.ajFc = paramMap2;
    this.ajFd = paramMap3;
    AppMethodBeat.o(188404);
  }
  
  public final <T> kotlinx.a.a<? extends T> a(c<? super T> paramc, String paramString)
  {
    AppMethodBeat.i(188422);
    s.u(paramc, "baseClass");
    s.u(paramString, "serializedClassName");
    Object localObject1 = (Map)this.ajFc.get(paramc);
    if (localObject1 != null) {}
    for (localObject1 = (kotlinx.a.b)((Map)localObject1).get(paramString);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof kotlinx.a.b)) {
        localObject2 = null;
      }
      if (localObject2 == null) {
        break;
      }
      paramc = (kotlinx.a.a)localObject2;
      AppMethodBeat.o(188422);
      return paramc;
    }
    Object localObject2 = this.ajFd.get(paramc);
    localObject1 = localObject2;
    if (!an.x(localObject2, 1)) {
      localObject1 = null;
    }
    localObject1 = (kotlin.g.a.b)localObject1;
    if (localObject1 != null) {}
    for (localObject1 = (kotlinx.a.a)((kotlin.g.a.b)localObject1).invoke(paramString); localObject1 != null; localObject1 = null)
    {
      AppMethodBeat.o(188422);
      return localObject1;
    }
    if (s.p(paramc, ai.cz(Object.class)))
    {
      paramc = d.ajFg;
      paramString = d.bKb(paramString);
      if (paramString != null)
      {
        paramc = paramString;
        if (paramString == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
          AppMethodBeat.o(188422);
          throw paramc;
        }
      }
      else
      {
        paramc = null;
      }
      paramc = (kotlinx.a.a)paramc;
      AppMethodBeat.o(188422);
      return paramc;
    }
    AppMethodBeat.o(188422);
    return null;
  }
  
  public final <T> g<T> a(c<? super T> paramc, T paramT)
  {
    AppMethodBeat.i(188419);
    s.u(paramc, "baseClass");
    s.u(paramT, "value");
    if (!ae.a(paramT, paramc))
    {
      AppMethodBeat.o(188419);
      return null;
    }
    Object localObject1 = (Map)this.ajFb.get(paramc);
    if (localObject1 != null) {}
    for (localObject1 = (kotlinx.a.b)((Map)localObject1).get(ai.cz(paramT.getClass()));; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof g)) {
        localObject2 = null;
      }
      localObject1 = (g)localObject2;
      if (localObject1 == null) {
        break;
      }
      AppMethodBeat.o(188419);
      return localObject1;
    }
    if (s.p(paramc, ai.cz(Object.class)))
    {
      paramc = d.ajFg;
      paramT = d.jH(paramT);
      paramc = paramT;
      if (!(paramT instanceof g)) {
        paramc = null;
      }
      paramc = (g)paramc;
      AppMethodBeat.o(188419);
      return paramc;
    }
    AppMethodBeat.o(188419);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.f.a
 * JD-Core Version:    0.7.0.1
 */