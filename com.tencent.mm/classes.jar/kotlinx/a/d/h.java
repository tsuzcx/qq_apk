package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "()V", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2NamedSerializers", "", "polyBase2Serializers", "build", "Lkotlinx/serialization/modules/SerialModule;", "build$kotlinx_serialization_runtime", "contextual", "", "T", "", "kClass", "serializer", "include", "other", "polymorphic", "baseClass", "baseClasses", "", "buildAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Base", "Sub", "actualClass", "actualSerializer", "baseSerializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "allowOverwrite", "", "registerSerializer", "forClass", "kotlinx-serialization-runtime"})
public final class h
  implements d
{
  private final Map<kotlin.l.b<?>, kotlinx.a.h<?>> TXA;
  private final Map<kotlin.l.b<?>, Map<kotlin.l.b<?>, kotlinx.a.h<?>>> UaL;
  private final Map<kotlin.l.b<?>, Map<String, kotlinx.a.h<?>>> UaM;
  
  public h()
  {
    AppMethodBeat.i(225878);
    this.TXA = ((Map)new HashMap());
    this.UaL = ((Map)new HashMap());
    this.UaM = ((Map)new HashMap());
    AppMethodBeat.o(225878);
  }
  
  private <T> void b(kotlin.l.b<T> paramb, kotlinx.a.h<T> paramh)
  {
    AppMethodBeat.i(225876);
    p.h(paramb, "forClass");
    p.h(paramh, "serializer");
    kotlinx.a.h localh = (kotlinx.a.h)this.TXA.get(paramb);
    if ((localh != null) && ((p.j(localh, paramh) ^ true)))
    {
      String str1 = paramh.fWv().hOz();
      String str2 = localh.fWv().hOz();
      paramb = (Throwable)new g("Serializer for " + paramb + " already registered in this module: " + localh + " (" + str2 + "), attempted to register " + paramh + " (" + str1 + ')');
      AppMethodBeat.o(225876);
      throw paramb;
    }
    this.TXA.put(paramb, paramh);
    AppMethodBeat.o(225876);
  }
  
  public final <Base, Sub extends Base> void a(kotlin.l.b<Base> paramb, kotlin.l.b<Sub> paramb1, kotlinx.a.h<Sub> paramh)
  {
    AppMethodBeat.i(225874);
    p.h(paramb, "baseClass");
    p.h(paramb1, "actualClass");
    p.h(paramh, "actualSerializer");
    p.h(paramb, "baseClass");
    p.h(paramb1, "concreteClass");
    p.h(paramh, "concreteSerializer");
    String str = paramh.fWv().hOz();
    Map localMap1 = this.UaL;
    Object localObject2 = localMap1.get(paramb);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      localMap1.put(paramb, localObject1);
    }
    localMap1 = (Map)localObject1;
    kotlinx.a.h localh = (kotlinx.a.h)localMap1.get(paramb1);
    Map localMap2 = this.UaM;
    localObject2 = localMap2.get(paramb);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      localMap2.put(paramb, localObject1);
    }
    localObject2 = (Map)localObject1;
    if (localh != null)
    {
      if ((p.j(localh, paramh) ^ true))
      {
        paramb = (Throwable)new g(paramb, paramb1);
        AppMethodBeat.o(225874);
        throw paramb;
      }
      ((Map)localObject2).remove(localh.fWv().hOz());
    }
    localObject1 = (kotlinx.a.h)((Map)localObject2).get(str);
    if (localObject1 != null)
    {
      paramh = this.UaL.get(paramb);
      if (paramh == null) {
        p.hyc();
      }
      localObject2 = ae.cw((Map)paramh).iterator();
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        paramh = ((Iterator)localObject2).next();
        if ((kotlinx.a.h)((Map.Entry)paramh).getValue() == localObject1)
        {
          i = 1;
          label316:
          if (i == 0) {
            break label397;
          }
        }
      }
      for (;;)
      {
        paramh = (Map.Entry)paramh;
        paramb = (Throwable)new IllegalArgumentException("Multiple polymorphic serializers for base class '" + paramb + "' have the same serial name '" + str + "': '" + paramb1 + "' and '" + paramh + '\'');
        AppMethodBeat.o(225874);
        throw paramb;
        i = 0;
        break label316;
        label397:
        break;
        paramh = null;
      }
    }
    localMap1.put(paramb1, paramh);
    ((Map)localObject2).put(str, paramh);
    AppMethodBeat.o(225874);
  }
  
  public final <T> void a(kotlin.l.b<T> paramb, kotlinx.a.h<T> paramh)
  {
    AppMethodBeat.i(225873);
    p.h(paramb, "kClass");
    p.h(paramh, "serializer");
    b(paramb, paramh);
    AppMethodBeat.o(225873);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(225875);
    p.h(paramb, "other");
    paramb.a((d)this);
    AppMethodBeat.o(225875);
  }
  
  public final b hPh()
  {
    AppMethodBeat.i(225877);
    b localb = (b)new f(this.TXA, this.UaL, this.UaM);
    AppMethodBeat.o(225877);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlinx.a.d.h
 * JD-Core Version:    0.7.0.1
 */