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
import kotlin.k.i;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.w;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"})
public final class g<M extends Member>
  implements d<M>
{
  private final a aaFh;
  private final d<M> aaFi;
  private final boolean lJx;
  
  public g(b paramb, d<? extends M> paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(56631);
    this.aaFi = paramd;
    this.lJx = paramBoolean;
    Object localObject2 = (g)this;
    paramd = paramb.iEH();
    if (paramd == null) {
      p.iCn();
    }
    p.j(paramd, "descriptor.returnType!!");
    paramd = h.c(paramd);
    if (paramd != null)
    {
      paramd = h.b(paramd, paramb);
      if (!kotlin.l.b.a.b.j.e.f((a)paramb)) {
        break label121;
      }
      paramb = kotlin.k.e.aaBV;
    }
    label121:
    Object localObject4;
    for (paramb = new a(kotlin.k.e.iCu(), new Method[0], paramd);; paramb = new a((kotlin.k.e)localObject2, (Method[])localObject4, paramd))
    {
      this.aaFh = paramb;
      AppMethodBeat.o(56631);
      return;
      paramd = null;
      break;
      int i;
      label146:
      Object localObject1;
      if ((((g)localObject2).aaFi instanceof e.h.c))
      {
        i = -1;
        if (!((g)localObject2).lJx) {
          break label345;
        }
        j = 2;
        localObject3 = new ArrayList();
        localObject1 = paramb.iEE();
        if (localObject1 == null) {
          break label351;
        }
        localObject1 = ((ak)localObject1).iFN();
        label177:
        if (localObject1 == null) {
          break label357;
        }
        ((ArrayList)localObject3).add(localObject1);
      }
      for (;;)
      {
        localObject1 = paramb.iEJ();
        p.j(localObject1, "descriptor.valueParameters");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = ((Iterator)localObject1).next();
          ((Collection)localObject3).add(((av)localObject4).iFN());
        }
        if ((paramb instanceof k))
        {
          if ((((g)localObject2).aaFi instanceof c))
          {
            i = -1;
            break;
          }
          i = 0;
          break;
        }
        if ((paramb.iEF() != null) && (!(((g)localObject2).aaFi instanceof c)))
        {
          localObject1 = paramb.iDJ();
          p.j(localObject1, "descriptor.containingDeclaration");
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
          localObject1 = ((k)paramb).iFf();
          p.j(localObject1, "descriptor.constructedClass");
          if (((kotlin.l.b.a.b.b.e)localObject1).iDS())
          {
            localObject1 = ((kotlin.l.b.a.b.b.e)localObject1).iDJ();
            if (localObject1 == null)
            {
              paramb = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(56631);
              throw paramb;
            }
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).iET());
          }
        }
        else
        {
          localObject1 = paramb.iDJ();
          p.j(localObject1, "descriptor.containingDeclaration");
          if (((localObject1 instanceof kotlin.l.b.a.b.b.e)) && (((kotlin.l.b.a.b.b.e)localObject1).iDU())) {
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).iET());
          }
        }
      }
      Object localObject3 = (List)localObject3;
      int m = j + (((List)localObject3).size() + i);
      if (f.a((d)localObject2) != m)
      {
        paramb = (Throwable)new w("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a((d)localObject2) + " != " + m + '\n' + "Calling: " + paramb + '\n' + "Parameter types: " + ((g)localObject2).iDi() + ")\nDefault: " + ((g)localObject2).lJx);
        AppMethodBeat.o(56631);
        throw paramb;
      }
      localObject2 = i.ou(Math.max(i, 0), ((List)localObject3).size() + i);
      localObject4 = new Method[m];
      int j = k;
      if (j < m)
      {
        if (((kotlin.k.e)localObject2).contains(j))
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
  
  public final Object ak(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56630);
    p.k(paramArrayOfObject, "args");
    Object localObject2 = this.aaFh;
    Object localObject1 = ((a)localObject2).aaFj;
    Method[] arrayOfMethod = ((a)localObject2).aaFk;
    Method localMethod1 = ((a)localObject2).aaFl;
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    p.j(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject == null)
    {
      paramArrayOfObject = new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(56630);
      throw paramArrayOfObject;
    }
    int i = ((kotlin.k.c)localObject1).dHa;
    int j = ((kotlin.k.c)localObject1).aaBQ;
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
    localObject1 = this.aaFi.ak(arrayOfObject);
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
  
  public final M iDg()
  {
    AppMethodBeat.i(56627);
    Member localMember = this.aaFi.iDg();
    AppMethodBeat.o(56627);
    return localMember;
  }
  
  public final Type iDh()
  {
    AppMethodBeat.i(56628);
    Type localType = this.aaFi.iDh();
    AppMethodBeat.o(56628);
    return localType;
  }
  
  public final List<Type> iDi()
  {
    AppMethodBeat.i(56629);
    List localList = this.aaFi.iDi();
    AppMethodBeat.o(56629);
    return localList;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"})
  static final class a
  {
    final kotlin.k.e aaFj;
    final Method[] aaFk;
    final Method aaFl;
    
    public a(kotlin.k.e parame, Method[] paramArrayOfMethod, Method paramMethod)
    {
      AppMethodBeat.i(56626);
      this.aaFj = parame;
      this.aaFk = paramArrayOfMethod;
      this.aaFl = paramMethod;
      AppMethodBeat.o(56626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */