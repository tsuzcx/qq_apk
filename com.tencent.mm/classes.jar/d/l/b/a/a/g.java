package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.b.a;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.av;
import d.l.b.a.b.m.ab;
import d.l.b.a.x;
import d.v;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"})
public final class g<M extends Member>
  implements d<M>
{
  private final a KYF;
  private final d<M> KYG;
  private final boolean isDefault;
  
  public g(d.l.b.a.b.b.b paramb, d<? extends M> paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(56631);
    this.KYG = paramd;
    this.isDefault = paramBoolean;
    Object localObject2 = (g)this;
    paramd = paramb.fQS();
    if (paramd == null) {
      d.g.b.k.fOy();
    }
    d.g.b.k.g(paramd, "descriptor.returnType!!");
    paramd = h.c(paramd);
    if (paramd != null)
    {
      paramd = h.b(paramd, paramb);
      if (!d.l.b.a.b.j.e.f((a)paramb)) {
        break label121;
      }
      paramb = d.k.d.KVi;
    }
    label121:
    Object localObject4;
    for (paramb = new a(d.k.d.fOE(), new Method[0], paramd);; paramb = new a((d.k.d)localObject2, (Method[])localObject4, paramd))
    {
      this.KYF = paramb;
      AppMethodBeat.o(56631);
      return;
      paramd = null;
      break;
      int i;
      label146:
      Object localObject1;
      if ((((g)localObject2).KYG instanceof e.h.c))
      {
        i = -1;
        if (!((g)localObject2).isDefault) {
          break label345;
        }
        j = 2;
        localObject3 = new ArrayList();
        localObject1 = paramb.fQP();
        if (localObject1 == null) {
          break label351;
        }
        localObject1 = ((ak)localObject1).fRV();
        label177:
        if (localObject1 == null) {
          break label357;
        }
        ((ArrayList)localObject3).add(localObject1);
      }
      for (;;)
      {
        localObject1 = paramb.fQU();
        d.g.b.k.g(localObject1, "descriptor.valueParameters");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = ((Iterator)localObject1).next();
          ((Collection)localObject3).add(((av)localObject4).fRV());
        }
        if ((paramb instanceof d.l.b.a.b.b.k))
        {
          if ((((g)localObject2).KYG instanceof c))
          {
            i = -1;
            break;
          }
          i = 0;
          break;
        }
        if ((paramb.fQQ() != null) && (!(((g)localObject2).KYG instanceof c)))
        {
          localObject1 = paramb.fPU();
          d.g.b.k.g(localObject1, "descriptor.containingDeclaration");
          if (!d.l.b.a.b.j.e.D((d.l.b.a.b.b.l)localObject1))
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
        if ((paramb instanceof d.l.b.a.b.b.k))
        {
          localObject1 = ((d.l.b.a.b.b.k)paramb).fRp();
          d.g.b.k.g(localObject1, "descriptor.constructedClass");
          if (((d.l.b.a.b.b.e)localObject1).fQd())
          {
            localObject1 = ((d.l.b.a.b.b.e)localObject1).fPU();
            if (localObject1 == null)
            {
              paramb = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(56631);
              throw paramb;
            }
            ((ArrayList)localObject3).add(((d.l.b.a.b.b.e)localObject1).fRe());
          }
        }
        else
        {
          localObject1 = paramb.fPU();
          d.g.b.k.g(localObject1, "descriptor.containingDeclaration");
          if (((localObject1 instanceof d.l.b.a.b.b.e)) && (((d.l.b.a.b.b.e)localObject1).fQf())) {
            ((ArrayList)localObject3).add(((d.l.b.a.b.b.e)localObject1).fRe());
          }
        }
      }
      Object localObject3 = (List)localObject3;
      int m = j + (((List)localObject3).size() + i);
      if (f.a((d)localObject2) != m)
      {
        paramb = (Throwable)new x("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a((d)localObject2) + " != " + m + '\n' + "Calling: " + paramb + '\n' + "Parameter types: " + ((g)localObject2).fPu() + ")\nDefault: " + ((g)localObject2).isDefault);
        AppMethodBeat.o(56631);
        throw paramb;
      }
      localObject2 = d.k.h.kZ(Math.max(i, 0), ((List)localObject3).size() + i);
      localObject4 = new Method[m];
      int j = k;
      if (j < m)
      {
        if (((d.k.d)localObject2).contains(j))
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
  
  public final Object ae(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56630);
    d.g.b.k.h(paramArrayOfObject, "args");
    Object localObject2 = this.KYF;
    Object localObject1 = ((a)localObject2).KYH;
    Method[] arrayOfMethod = ((a)localObject2).KYI;
    Method localMethod1 = ((a)localObject2).KYJ;
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    d.g.b.k.g(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject == null)
    {
      paramArrayOfObject = new v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(56630);
      throw paramArrayOfObject;
    }
    int i = ((d.k.b)localObject1).KVb;
    int j = ((d.k.b)localObject1).KVc;
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
    localObject1 = this.KYG.ae(arrayOfObject);
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
  
  public final M fPs()
  {
    AppMethodBeat.i(56627);
    Member localMember = this.KYG.fPs();
    AppMethodBeat.o(56627);
    return localMember;
  }
  
  public final Type fPt()
  {
    AppMethodBeat.i(56628);
    Type localType = this.KYG.fPt();
    AppMethodBeat.o(56628);
    return localType;
  }
  
  public final List<Type> fPu()
  {
    AppMethodBeat.i(56629);
    List localList = this.KYG.fPu();
    AppMethodBeat.o(56629);
    return localList;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"})
  static final class a
  {
    final d.k.d KYH;
    final Method[] KYI;
    final Method KYJ;
    
    public a(d.k.d paramd, Method[] paramArrayOfMethod, Method paramMethod)
    {
      AppMethodBeat.i(56626);
      this.KYH = paramd;
      this.KYI = paramArrayOfMethod;
      this.KYJ = paramMethod;
      AppMethodBeat.o(56626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */