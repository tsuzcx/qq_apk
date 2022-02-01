package kotlin.l.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.l.f;
import kotlin.l.n;

@Metadata(d1={""}, d2={"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class c
{
  public static final <T> T e(kotlin.l.c<T> paramc)
  {
    AppMethodBeat.i(191267);
    s.u(paramc, "$this$createInstance");
    Iterator localIterator = ((Iterable)paramc.klv()).iterator();
    int i = 0;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = (Iterable)((f)localObject2).klq();
      int j;
      if ((!(localObject3 instanceof Collection)) || (!((Collection)localObject3).isEmpty()))
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          if (!((n)((Iterator)localObject3).next()).ahk()) {
            j = 0;
          }
        }
      }
      for (;;)
      {
        if (j != 0) {
          if (i != 0)
          {
            localObject1 = null;
            label135:
            localObject1 = (f)localObject1;
            if (localObject1 == null)
            {
              paramc = (Throwable)new IllegalArgumentException("Class should have a single no-arg constructor: ".concat(String.valueOf(paramc)));
              AppMethodBeat.o(191267);
              throw paramc;
              j = 1;
            }
          }
          else
          {
            i = 1;
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (i == 0)
      {
        localObject1 = null;
        break label135;
      }
      break label135;
      paramc = ((f)localObject1).dA(ak.kkZ());
      AppMethodBeat.o(191267);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.l.a.c
 * JD-Core Version:    0.7.0.1
 */