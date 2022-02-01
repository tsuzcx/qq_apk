package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.x;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class k
  extends f<Object>
  implements kotlin.g.b.o<Object>, c, kotlin.l.f<Object>
{
  final j aixX;
  private final ac.a aiyz;
  private final ac.b aizj;
  private final ac.b aizk;
  private final Object aizl;
  private final String signature;
  
  static
  {
    AppMethodBeat.i(56371);
    aYe = new kotlin.l.o[] { (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(k.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(k.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), (kotlin.l.o)kotlin.g.b.ai.a(new kotlin.g.b.ag(kotlin.g.b.ai.cz(k.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")) };
    AppMethodBeat.o(56371);
  }
  
  public k(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    this(paramj, paramString1, paramString2, null, paramObject);
    AppMethodBeat.i(56384);
    AppMethodBeat.o(56384);
  }
  
  private k(j paramj, final String paramString1, String paramString2, x paramx, Object paramObject)
  {
    AppMethodBeat.i(56382);
    this.aixX = paramj;
    this.signature = paramString2;
    this.aizl = paramObject;
    this.aiyz = ac.d(paramx, (a)new c(this, paramString1));
    this.aizj = ac.co((a)new a(this));
    this.aizk = ac.co((a)new b(this));
    AppMethodBeat.o(56382);
  }
  
  public k(j paramj, x paramx)
  {
    this(paramj, str, ag.c(paramx).PF(), paramx);
    AppMethodBeat.i(56385);
    AppMethodBeat.o(56385);
  }
  
  private final Object kln()
  {
    AppMethodBeat.i(56377);
    Object localObject = h.a(this.aizl, (b)kmi());
    AppMethodBeat.o(56377);
    return localObject;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(56390);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(56390);
    return paramObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(168742);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(168742);
    return paramObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    AppMethodBeat.i(191388);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
    AppMethodBeat.o(191388);
    return paramObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56379);
    paramObject = ai.hO(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(56379);
      return false;
    }
    if ((s.p(this.aixX, paramObject.aixX)) && (s.p(getName(), paramObject.getName())) && (s.p(this.signature, paramObject.signature)) && (s.p(this.aizl, paramObject.aizl)))
    {
      AppMethodBeat.o(56379);
      return true;
    }
    AppMethodBeat.o(56379);
    return false;
  }
  
  public final int getArity()
  {
    AppMethodBeat.i(56378);
    int i = kotlin.l.b.a.a.f.a(klW());
    AppMethodBeat.o(56378);
    return i;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56375);
    String str = kmi().kok().PF();
    s.s(str, "descriptor.name.asString()");
    AppMethodBeat.o(56375);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56380);
    int i = this.aixX.hashCode();
    int j = getName().hashCode();
    int k = this.signature.hashCode();
    AppMethodBeat.o(56380);
    return (i * 31 + j) * 31 + k;
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(56386);
    Object localObject = ap(new Object[0]);
    AppMethodBeat.o(56386);
    return localObject;
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(56387);
    paramObject = ap(new Object[] { paramObject });
    AppMethodBeat.o(56387);
    return paramObject;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(56388);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(56388);
    return paramObject1;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(56389);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(56389);
    return paramObject1;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(191390);
    paramObject1 = ap(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(191390);
    return paramObject1;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(56372);
    boolean bool = s.p(this.aizl, kotlin.g.b.f.aiwK);
    AppMethodBeat.o(56372);
    return bool ^ true;
  }
  
  public final kotlin.l.b.a.a.d<?> klW()
  {
    AppMethodBeat.i(56376);
    kotlin.l.b.a.a.d locald = (kotlin.l.b.a.a.d)this.aizj.invoke();
    AppMethodBeat.o(56376);
    return locald;
  }
  
  public final kotlin.l.b.a.a.d<?> klX()
  {
    AppMethodBeat.i(191381);
    kotlin.l.b.a.a.d locald = (kotlin.l.b.a.a.d)this.aizk.invoke();
    AppMethodBeat.o(191381);
    return locald;
  }
  
  public final j klY()
  {
    return this.aixX;
  }
  
  public final x kmi()
  {
    AppMethodBeat.i(56373);
    x localx = (x)this.aiyz.invoke();
    AppMethodBeat.o(56373);
    return localx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56381);
    Object localObject = ae.aiAr;
    localObject = ae.a(kmi());
    AppMethodBeat.o(56381);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements a<kotlin.l.b.a.a.d<? extends Member>>
  {
    a(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<kotlin.l.b.a.a.d<? extends Member>>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements a<x>
  {
    c(k paramk, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.k
 * JD-Core Version:    0.7.0.1
 */