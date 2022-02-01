package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.t;

@Metadata(d1={""}, d2={"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ac
{
  public static final Type a(u paramu)
  {
    AppMethodBeat.i(191280);
    s.u(paramu, "$this$javaType");
    if ((paramu instanceof t))
    {
      Type localType = ((t)paramu).klA();
      if (localType != null)
      {
        AppMethodBeat.o(191280);
        return localType;
      }
    }
    paramu = a(paramu, false);
    AppMethodBeat.o(191280);
    return paramu;
  }
  
  private static final Type a(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(191292);
    Object localObject1 = paramu.klQ();
    if ((localObject1 instanceof v))
    {
      paramu = (Type)new ab((v)localObject1);
      AppMethodBeat.o(191292);
      return paramu;
    }
    if ((localObject1 instanceof c))
    {
      if (paramBoolean) {}
      Object localObject2;
      for (localObject1 = kotlin.g.a.d((c)localObject1);; localObject1 = kotlin.g.a.b((c)localObject1))
      {
        localObject2 = paramu.klR();
        if (!((List)localObject2).isEmpty()) {
          break;
        }
        paramu = (Type)localObject1;
        AppMethodBeat.o(191292);
        return paramu;
      }
      if (((Class)localObject1).isArray())
      {
        Class localClass = ((Class)localObject1).getComponentType();
        s.s(localClass, "jClass.componentType");
        if (localClass.isPrimitive())
        {
          paramu = (Type)localObject1;
          AppMethodBeat.o(191292);
          return paramu;
        }
        localObject2 = (w)kotlin.a.p.oP((List)localObject2);
        if (localObject2 == null)
        {
          paramu = (Throwable)new IllegalArgumentException("kotlin.Array must have exactly one type argument: ".concat(String.valueOf(paramu)));
          AppMethodBeat.o(191292);
          throw paramu;
        }
        paramu = ((w)localObject2).aixJ;
        localObject2 = ((w)localObject2).aixK;
        if (paramu == null)
        {
          paramu = (Type)localObject1;
          AppMethodBeat.o(191292);
          return paramu;
        }
        switch (ad.$EnumSwitchMapping$0[paramu.ordinal()])
        {
        case 1: 
        default: 
          paramu = new kotlin.p();
          AppMethodBeat.o(191292);
          throw paramu;
        }
        s.checkNotNull(localObject2);
        paramu = a((u)localObject2, false);
        if ((paramu instanceof Class))
        {
          paramu = (Type)localObject1;
          AppMethodBeat.o(191292);
          return paramu;
        }
        paramu = (Type)new a(paramu);
        AppMethodBeat.o(191292);
        return paramu;
      }
      paramu = b((Class)localObject1, (List)localObject2);
      AppMethodBeat.o(191292);
      return paramu;
    }
    paramu = (Throwable)new UnsupportedOperationException("Unsupported type classifier: ".concat(String.valueOf(paramu)));
    AppMethodBeat.o(191292);
    throw paramu;
  }
  
  private static final Type a(w paramw)
  {
    AppMethodBeat.i(191305);
    y localy = paramw.aixJ;
    if (localy == null)
    {
      paramw = ae.aixV;
      paramw = (Type)ae.klS();
      AppMethodBeat.o(191305);
      return paramw;
    }
    paramw = paramw.aixK;
    s.checkNotNull(paramw);
    switch (ad.avl[localy.ordinal()])
    {
    default: 
      paramw = new kotlin.p();
      AppMethodBeat.o(191305);
      throw paramw;
    case 1: 
      paramw = a(paramw, true);
      AppMethodBeat.o(191305);
      return paramw;
    case 2: 
      paramw = (Type)new ae(null, a(paramw, true));
      AppMethodBeat.o(191305);
      return paramw;
    }
    paramw = (Type)new ae(a(paramw, true), null);
    AppMethodBeat.o(191305);
    return paramw;
  }
  
  private static final Type b(Class<?> paramClass, List<w> paramList)
  {
    AppMethodBeat.i(191299);
    Object localObject1 = paramClass.getDeclaringClass();
    if (localObject1 == null)
    {
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.add(a((w)((Iterator)localObject1).next()));
      }
      paramClass = (Type)new z(paramClass, null, (List)paramList);
      AppMethodBeat.o(191299);
      return paramClass;
    }
    if (Modifier.isStatic(paramClass.getModifiers()))
    {
      localObject1 = (Type)localObject1;
      localObject2 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.add(a((w)((Iterator)localObject2).next()));
      }
      paramClass = (Type)new z(paramClass, (Type)localObject1, (List)paramList);
      AppMethodBeat.o(191299);
      return paramClass;
    }
    int i = paramClass.getTypeParameters().length;
    localObject1 = b((Class)localObject1, paramList.subList(i, paramList.size()));
    Object localObject2 = (Iterable)paramList.subList(0, i);
    paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramList.add(a((w)((Iterator)localObject2).next()));
    }
    paramClass = (Type)new z(paramClass, (Type)localObject1, (List)paramList);
    AppMethodBeat.o(191299);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.ac
 * JD-Core Version:    0.7.0.1
 */