package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.w;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"})
public final class g<M extends Member>
  implements d<M>
{
  private final a Tcn;
  private final d<M> Tco;
  private final boolean isDefault;
  
  public g(b paramb, d<? extends M> paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(56631);
    this.Tco = paramd;
    this.isDefault = paramBoolean;
    Object localObject2 = (g)this;
    paramd = paramb.hAu();
    if (paramd == null) {
      p.hyc();
    }
    p.g(paramd, "descriptor.returnType!!");
    paramd = h.c(paramd);
    if (paramd != null)
    {
      paramd = h.b(paramd, paramb);
      if (!kotlin.l.b.a.b.j.e.f((a)paramb)) {
        break label121;
      }
      paramb = kotlin.k.f.SZb;
    }
    label121:
    Object localObject4;
    for (paramb = new a(kotlin.k.f.hyj(), new Method[0], paramd);; paramb = new a((kotlin.k.f)localObject2, (Method[])localObject4, paramd))
    {
      this.Tcn = paramb;
      AppMethodBeat.o(56631);
      return;
      paramd = null;
      break;
      int i;
      label146:
      Object localObject1;
      if ((((g)localObject2).Tco instanceof e.h.c))
      {
        i = -1;
        if (!((g)localObject2).isDefault) {
          break label345;
        }
        j = 2;
        localObject3 = new ArrayList();
        localObject1 = paramb.hAr();
        if (localObject1 == null) {
          break label351;
        }
        localObject1 = ((ak)localObject1).hBy();
        label177:
        if (localObject1 == null) {
          break label357;
        }
        ((ArrayList)localObject3).add(localObject1);
      }
      for (;;)
      {
        localObject1 = paramb.hAw();
        p.g(localObject1, "descriptor.valueParameters");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = ((Iterator)localObject1).next();
          ((Collection)localObject3).add(((av)localObject4).hBy());
        }
        if ((paramb instanceof k))
        {
          if ((((g)localObject2).Tco instanceof c))
          {
            i = -1;
            break;
          }
          i = 0;
          break;
        }
        if ((paramb.hAs() != null) && (!(((g)localObject2).Tco instanceof c)))
        {
          localObject1 = paramb.hzx();
          p.g(localObject1, "descriptor.containingDeclaration");
          if (!kotlin.l.b.a.b.j.e.D((kotlin.l.b.a.b.b.l)localObject1))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        label345:
        j = 0;
        break label146;
        label351:
        localObject1 = null;
        break label177;
        label357:
        if ((paramb instanceof k))
        {
          localObject1 = ((k)paramb).hAS();
          p.g(localObject1, "descriptor.constructedClass");
          if (((kotlin.l.b.a.b.b.e)localObject1).hzG())
          {
            localObject1 = ((kotlin.l.b.a.b.b.e)localObject1).hzx();
            if (localObject1 == null)
            {
              paramb = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(56631);
              throw paramb;
            }
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).hAG());
          }
        }
        else
        {
          localObject1 = paramb.hzx();
          p.g(localObject1, "descriptor.containingDeclaration");
          if (((localObject1 instanceof kotlin.l.b.a.b.b.e)) && (((kotlin.l.b.a.b.b.e)localObject1).hzI())) {
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).hAG());
          }
        }
      }
      Object localObject3 = (List)localObject3;
      int m = j + (((List)localObject3).size() + i);
      if (f.a((d)localObject2) != m)
      {
        paramb = (Throwable)new w("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a((d)localObject2) + " != " + m + '\n' + "Calling: " + paramb + '\n' + "Parameter types: " + ((g)localObject2).hyX() + ")\nDefault: " + ((g)localObject2).isDefault);
        AppMethodBeat.o(56631);
        throw paramb;
      }
      localObject2 = j.mY(Math.max(i, 0), ((List)localObject3).size() + i);
      localObject4 = new Method[m];
      int j = k;
      if (j < m)
      {
        if (((kotlin.k.f)localObject2).contains(j))
        {
          localObject1 = h.c((ab)((List)localObject3).get(j - i));
          if (localObject1 == null) {}
        }
        for (localObject1 = h.a((Class)localObject1, paramb);; localObject1 = null)
        {
          localObject4[j] = localObject1;
          j += 1;
          break;
        }
      }
    }
  }
  
  public final Object ag(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56630);
    p.h(paramArrayOfObject, "args");
    Object localObject2 = this.Tcn;
    Object localObject1 = ((a)localObject2).Tcp;
    Method[] arrayOfMethod = ((a)localObject2).Tcq;
    Method localMethod1 = ((a)localObject2).Tcr;
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    p.g(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject == null)
    {
      paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(56630);
      throw paramArrayOfObject;
    }
    int i = ((kotlin.k.d)localObject1).SYU;
    int j = ((kotlin.k.d)localObject1).SYV;
    if (i <= j) {
      for (;;)
      {
        Method localMethod2 = arrayOfMethod[i];
        localObject2 = paramArrayOfObject[i];
        localObject1 = localObject2;
        if (localMethod2 != null)
        {
          localObject1 = localObject2;
          if (localObject2 != null) {
            localObject1 = localMethod2.invoke(localObject2, new Object[0]);
          }
        }
        arrayOfObject[i] = localObject1;
        if (i == j) {
          break;
        }
        i += 1;
      }
    }
    localObject1 = this.Tco.ag(arrayOfObject);
    if (localMethod1 != null)
    {
      localObject2 = localMethod1.invoke(null, new Object[] { localObject1 });
      paramArrayOfObject = (Object[])localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      paramArrayOfObject = (Object[])localObject1;
    }
    AppMethodBeat.o(56630);
    return paramArrayOfObject;
  }
  
  public final M hyV()
  {
    AppMethodBeat.i(56627);
    Member localMember = this.Tco.hyV();
    AppMethodBeat.o(56627);
    return localMember;
  }
  
  public final Type hyW()
  {
    AppMethodBeat.i(56628);
    Type localType = this.Tco.hyW();
    AppMethodBeat.o(56628);
    return localType;
  }
  
  public final List<Type> hyX()
  {
    AppMethodBeat.i(56629);
    List localList = this.Tco.hyX();
    AppMethodBeat.o(56629);
    return localList;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"})
  static final class a
  {
    final kotlin.k.f Tcp;
    final Method[] Tcq;
    final Method Tcr;
    
    public a(kotlin.k.f paramf, Method[] paramArrayOfMethod, Method paramMethod)
    {
      AppMethodBeat.i(56626);
      this.Tcp = paramf;
      this.Tcq = paramArrayOfMethod;
      this.Tcr = paramMethod;
      AppMethodBeat.o(56626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */