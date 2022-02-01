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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.b.a.aa;
import kotlin.l.b.a.ai;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.m.ad;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class g<M extends Member>
  implements d<M>
{
  private final a aiAY;
  private final d<M> aiAZ;
  private final boolean oBZ;
  
  public g(b paramb, d<? extends M> paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(56631);
    this.aiAZ = paramd;
    this.oBZ = paramBoolean;
    Object localObject2 = (g)this;
    paramd = paramb.kob();
    s.checkNotNull(paramd);
    s.s(paramd, "descriptor.returnType!!");
    paramd = h.c(paramd);
    if (paramd != null)
    {
      paramd = h.b(paramd, paramb);
      if (!kotlin.l.b.a.b.j.f.f((a)paramb)) {
        break label121;
      }
      paramb = kotlin.k.g.aixx;
    }
    label121:
    Object localObject4;
    for (paramb = new a(kotlin.k.g.klL(), new Method[0], paramd);; paramb = new a((kotlin.k.g)localObject2, (Method[])localObject4, paramd))
    {
      this.aiAY = paramb;
      AppMethodBeat.o(56631);
      return;
      paramd = null;
      break;
      int i;
      label146:
      label165:
      Object localObject1;
      if ((((g)localObject2).aiAZ instanceof e.h.c))
      {
        i = -1;
        if (!((g)localObject2).oBZ) {
          break label364;
        }
        j = 2;
        if ((!(paramb instanceof x)) || (!((x)paramb).koN())) {
          break label370;
        }
        localObject3 = new ArrayList();
        localObject1 = paramb.knY();
        if (localObject1 == null) {
          break label376;
        }
        localObject1 = ((as)localObject1).koG();
        label196:
        if (localObject1 == null) {
          break label382;
        }
        ((ArrayList)localObject3).add(localObject1);
      }
      for (;;)
      {
        localObject1 = paramb.kod();
        s.s(localObject1, "descriptor.valueParameters");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = ((Iterator)localObject1).next();
          ((Collection)localObject3).add(((bd)localObject4).koG());
        }
        if ((paramb instanceof kotlin.l.b.a.b.b.k))
        {
          if ((((g)localObject2).aiAZ instanceof c))
          {
            i = -1;
            break;
          }
          i = 0;
          break;
        }
        if ((paramb.knZ() != null) && (!(((g)localObject2).aiAZ instanceof c)))
        {
          localObject1 = paramb.knp();
          s.s(localObject1, "descriptor.containingDeclaration");
          if (!kotlin.l.b.a.b.j.f.D((l)localObject1))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        label364:
        j = 0;
        break label146;
        label370:
        k = 0;
        break label165;
        label376:
        localObject1 = null;
        break label196;
        label382:
        if ((paramb instanceof kotlin.l.b.a.b.b.k))
        {
          localObject1 = ((kotlin.l.b.a.b.b.k)paramb).koz();
          s.s(localObject1, "descriptor.constructedClass");
          if (((kotlin.l.b.a.b.b.e)localObject1).kne())
          {
            localObject1 = ((kotlin.l.b.a.b.b.e)localObject1).knp();
            if (localObject1 == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              AppMethodBeat.o(56631);
              throw paramb;
            }
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).koj());
          }
        }
        else
        {
          localObject1 = paramb.knp();
          s.s(localObject1, "descriptor.containingDeclaration");
          if (((localObject1 instanceof kotlin.l.b.a.b.b.e)) && (kotlin.l.b.a.b.j.f.D((l)localObject1))) {
            ((ArrayList)localObject3).add(((kotlin.l.b.a.b.b.e)localObject1).koj());
          }
        }
      }
      Object localObject3 = (List)localObject3;
      k = ((List)localObject3).size() + i + (j + k);
      if (f.a((d)localObject2) != k)
      {
        paramb = (Throwable)new aa("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a((d)localObject2) + " != " + k + '\n' + "Calling: " + paramb + '\n' + "Parameter types: " + ((g)localObject2).kmA() + ")\nDefault: " + ((g)localObject2).oBZ);
        AppMethodBeat.o(56631);
        throw paramb;
      }
      localObject2 = kotlin.k.k.qt(Math.max(i, 0), ((List)localObject3).size() + i);
      localObject4 = new Method[k];
      int j = m;
      if (j < k)
      {
        if (((kotlin.k.g)localObject2).aKs(j))
        {
          localObject1 = h.c((ad)((List)localObject3).get(j - i));
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
  
  public final Object ap(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56630);
    s.u(paramArrayOfObject, "args");
    Object localObject2 = this.aiAY;
    Object localObject1 = ((a)localObject2).aiBa;
    Method[] arrayOfMethod = ((a)localObject2).aiBb;
    Method localMethod1 = ((a)localObject2).aiBc;
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    s.s(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject == null)
    {
      paramArrayOfObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
      AppMethodBeat.o(56630);
      throw paramArrayOfObject;
    }
    int i = ((kotlin.k.e)localObject1).fIj;
    int j = ((kotlin.k.e)localObject1).aixs;
    if (i <= j)
    {
      Method localMethod2 = arrayOfMethod[i];
      localObject2 = paramArrayOfObject[i];
      localObject1 = localObject2;
      if (localMethod2 != null) {
        if (localObject2 == null) {
          break label153;
        }
      }
      for (localObject1 = localMethod2.invoke(localObject2, new Object[0]);; localObject1 = ai.j((Type)localObject1))
      {
        arrayOfObject[i] = localObject1;
        if (i == j) {
          break label181;
        }
        i += 1;
        break;
        label153:
        localObject1 = localMethod2.getReturnType();
        s.s(localObject1, "method.returnType");
      }
    }
    label181:
    localObject1 = this.aiAZ.ap(arrayOfObject);
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
  
  public final List<Type> kmA()
  {
    AppMethodBeat.i(56629);
    List localList = this.aiAZ.kmA();
    AppMethodBeat.o(56629);
    return localList;
  }
  
  public final M kmy()
  {
    AppMethodBeat.i(56627);
    Member localMember = this.aiAZ.kmy();
    AppMethodBeat.o(56627);
    return localMember;
  }
  
  public final Type kmz()
  {
    AppMethodBeat.i(56628);
    Type localType = this.aiAZ.kmz();
    AppMethodBeat.o(56628);
    return localType;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  static final class a
  {
    final kotlin.k.g aiBa;
    final Method[] aiBb;
    final Method aiBc;
    
    public a(kotlin.k.g paramg, Method[] paramArrayOfMethod, Method paramMethod)
    {
      AppMethodBeat.i(56626);
      this.aiBa = paramg;
      this.aiBb = paramArrayOfMethod;
      this.aiBc = paramMethod;
      AppMethodBeat.o(56626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */