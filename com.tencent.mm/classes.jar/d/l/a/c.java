package d.l.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.b.k;
import d.l;
import d.l.b;
import d.l.e;
import d.l.j;
import java.util.Collection;
import java.util.Iterator;

@l(fvt={1, 1, 15}, fvu={""}, fvv={"allSuperclasses", "", "Lkotlin/reflect/KClass;", "allSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "allSupertypes$annotations", "getAllSupertypes", "companionObject", "companionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "companionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "declaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "declaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", "T", "declaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "declaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "declaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "declaredMembers$annotations", "getDeclaredMembers", "defaultType", "defaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "functions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "memberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "memberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "memberFunctions$annotations", "getMemberFunctions", "memberProperties", "memberProperties$annotations", "getMemberProperties", "primaryConstructor", "primaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "staticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "staticProperties$annotations", "getStaticProperties", "superclasses", "", "superclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"})
public final class c
{
  public static final <T> T d(b<T> paramb)
  {
    AppMethodBeat.i(186688);
    k.h(paramb, "$this$createInstance");
    Iterator localIterator = ((Iterable)paramb.fvR()).iterator();
    int i = 0;
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = (Iterable)((e)localObject2).getParameters();
      int j;
      if ((!(localObject3 instanceof Collection)) || (!((Collection)localObject3).isEmpty()))
      {
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          if (!((j)((Iterator)localObject3).next()).bfV()) {
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
            localObject1 = (e)localObject1;
            if (localObject1 == null)
            {
              paramb = (Throwable)new IllegalArgumentException("Class should have a single no-arg constructor: ".concat(String.valueOf(paramb)));
              AppMethodBeat.o(186688);
              throw paramb;
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
      paramb = ((e)localObject1).bT(ae.emptyMap());
      AppMethodBeat.o(186688);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.l.a.c
 * JD-Core Version:    0.7.0.1
 */