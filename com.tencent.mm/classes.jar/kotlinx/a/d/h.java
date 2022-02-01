package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerialModuleCollector;", "()V", "class2Serializer", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/KSerializer;", "polyBase2NamedSerializers", "", "polyBase2Serializers", "build", "Lkotlinx/serialization/modules/SerialModule;", "build$kotlinx_serialization_runtime", "contextual", "", "T", "", "kClass", "serializer", "include", "other", "polymorphic", "baseClass", "baseClasses", "", "buildAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Base", "Sub", "actualClass", "actualSerializer", "baseSerializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "allowOverwrite", "", "registerSerializer", "forClass", "kotlinx-serialization-runtime"})
public final class h
  implements d
{
  private final Map<d.l.b<?>, kotlinx.a.h<?>> NLy;
  private final Map<d.l.b<?>, Map<d.l.b<?>, kotlinx.a.h<?>>> NOI;
  private final Map<d.l.b<?>, Map<String, kotlinx.a.h<?>>> NOJ;
  
  public h()
  {
    AppMethodBeat.i(191516);
    this.NLy = ((Map)new HashMap());
    this.NOI = ((Map)new HashMap());
    this.NOJ = ((Map)new HashMap());
    AppMethodBeat.o(191516);
  }
  
  private <T> void b(d.l.b<T> paramb, kotlinx.a.h<T> paramh)
  {
    AppMethodBeat.i(191514);
    p.h(paramb, "forClass");
    p.h(paramh, "serializer");
    kotlinx.a.h localh = (kotlinx.a.h)this.NLy.get(paramb);
    if ((localh != null) && ((p.i(localh, paramh) ^ true)))
    {
      String str1 = paramh.eLj().gwQ();
      String str2 = localh.eLj().gwQ();
      paramb = (Throwable)new g("Serializer for " + paramb + " already registered in this module: " + localh + " (" + str2 + "), attempted to register " + paramh + " (" + str1 + ')');
      AppMethodBeat.o(191514);
      throw paramb;
    }
    this.NLy.put(paramb, paramh);
    AppMethodBeat.o(191514);
  }
  
  public final <Base, Sub extends Base> void a(d.l.b<Base> paramb, d.l.b<Sub> paramb1, kotlinx.a.h<Sub> paramh)
  {
    AppMethodBeat.i(191512);
    p.h(paramb, "baseClass");
    p.h(paramb1, "actualClass");
    p.h(paramh, "actualSerializer");
    p.h(paramb, "baseClass");
    p.h(paramb1, "concreteClass");
    p.h(paramh, "concreteSerializer");
    String str = paramh.eLj().gwQ();
    Map localMap1 = this.NOI;
    Object localObject2 = localMap1.get(paramb);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      localMap1.put(paramb, localObject1);
    }
    localMap1 = (Map)localObject1;
    kotlinx.a.h localh = (kotlinx.a.h)localMap1.get(paramb1);
    Map localMap2 = this.NOJ;
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
      if ((p.i(localh, paramh) ^ true))
      {
        paramb = (Throwable)new g(paramb, paramb1);
        AppMethodBeat.o(191512);
        throw paramb;
      }
      ((Map)localObject2).remove(localh.eLj().gwQ());
    }
    localObject1 = (kotlinx.a.h)((Map)localObject2).get(str);
    if (localObject1 != null)
    {
      paramh = this.NOI.get(paramb);
      if (paramh == null) {
        p.gfZ();
      }
      paramh = (Map)paramh;
      p.h(paramh, "$this$asSequence");
      localObject2 = j.v((Iterable)paramh.entrySet()).iterator();
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        paramh = ((Iterator)localObject2).next();
        if ((kotlinx.a.h)((Map.Entry)paramh).getValue() == localObject1)
        {
          i = 1;
          label332:
          if (i == 0) {
            break label413;
          }
        }
      }
      for (;;)
      {
        paramh = (Map.Entry)paramh;
        paramb = (Throwable)new IllegalArgumentException("Multiple polymorphic serializers for base class '" + paramb + "' have the same serial name '" + str + "': '" + paramb1 + "' and '" + paramh + '\'');
        AppMethodBeat.o(191512);
        throw paramb;
        i = 0;
        break label332;
        label413:
        break;
        paramh = null;
      }
    }
    localMap1.put(paramb1, paramh);
    ((Map)localObject2).put(str, paramh);
    AppMethodBeat.o(191512);
  }
  
  public final <T> void a(d.l.b<T> paramb, kotlinx.a.h<T> paramh)
  {
    AppMethodBeat.i(191511);
    p.h(paramb, "kClass");
    p.h(paramh, "serializer");
    b(paramb, paramh);
    AppMethodBeat.o(191511);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(191513);
    p.h(paramb, "other");
    paramb.a((d)this);
    AppMethodBeat.o(191513);
  }
  
  public final b gxy()
  {
    AppMethodBeat.i(191515);
    b localb = (b)new f(this.NLy, this.NOI, this.NOJ);
    AppMethodBeat.o(191515);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.d.h
 * JD-Core Version:    0.7.0.1
 */