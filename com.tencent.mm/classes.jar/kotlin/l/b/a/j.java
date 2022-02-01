package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import kotlin.g.a.a;
import kotlin.g.b.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.b.b.t;
import kotlin.l.k;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"})
public final class j
  extends e<Object>
  implements m<Object>, b, kotlin.l.e<Object>
{
  private final y.a SZW;
  private final y.b TaG;
  private final y.b TaH;
  final i TaI;
  private final Object TaJ;
  private final String signature;
  
  static
  {
    AppMethodBeat.i(56371);
    cLI = new k[] { (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")) };
    AppMethodBeat.o(56371);
  }
  
  public j(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
    AppMethodBeat.i(56384);
    AppMethodBeat.o(56384);
  }
  
  private j(i parami, final String paramString1, String paramString2, t paramt, Object paramObject)
  {
    AppMethodBeat.i(56382);
    this.TaI = parami;
    this.signature = paramString2;
    this.TaJ = paramObject;
    this.SZW = y.a(paramt, (a)new c(this, paramString1));
    this.TaG = y.aj((a)new a(this));
    this.TaH = y.aj((a)new b(this));
    AppMethodBeat.o(56382);
  }
  
  public j(i parami, t paramt)
  {
    this(parami, str, ac.c(paramt).sG(), paramt);
    AppMethodBeat.i(56385);
    AppMethodBeat.o(56385);
  }
  
  private final Object hxQ()
  {
    AppMethodBeat.i(56377);
    Object localObject = h.a(this.TaJ, (kotlin.l.b.a.b.b.b)hyE());
    AppMethodBeat.o(56377);
    return localObject;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(168742);
    paramObject1 = ag(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(168742);
    return paramObject1;
  }
  
  public final Object d(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(56389);
    paramObject1 = ag(new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(56389);
    return paramObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56379);
    paramObject = ae.fh(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(56379);
      return false;
    }
    if ((p.j(this.TaI, paramObject.TaI)) && (p.j(getName(), paramObject.getName())) && (p.j(this.signature, paramObject.signature)) && (p.j(this.TaJ, paramObject.TaJ)))
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
    int i = kotlin.l.b.a.a.f.a(hyt());
    AppMethodBeat.o(56378);
    return i;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56375);
    String str = hyE().hAH().sG();
    p.g(str, "descriptor.name.asString()");
    AppMethodBeat.o(56375);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56380);
    int i = this.TaI.hashCode();
    int j = getName().hashCode();
    int k = this.signature.hashCode();
    AppMethodBeat.o(56380);
    return (i * 31 + j) * 31 + k;
  }
  
  public final t hyE()
  {
    AppMethodBeat.i(56373);
    t localt = (t)this.SZW.invoke();
    AppMethodBeat.o(56373);
    return localt;
  }
  
  public final d<?> hyt()
  {
    AppMethodBeat.i(56376);
    d locald = (d)this.TaG.invoke();
    AppMethodBeat.o(56376);
    return locald;
  }
  
  public final d<?> hyu()
  {
    AppMethodBeat.i(186231);
    d locald = (d)this.TaH.invoke();
    AppMethodBeat.o(186231);
    return locald;
  }
  
  public final i hyv()
  {
    return this.TaI;
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(56386);
    Object localObject = ag(new Object[0]);
    AppMethodBeat.o(56386);
    return localObject;
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(56387);
    paramObject = ag(new Object[] { paramObject });
    AppMethodBeat.o(56387);
    return paramObject;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(56388);
    paramObject1 = ag(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(56388);
    return paramObject1;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(56390);
    paramObject1 = ag(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(56390);
    return paramObject1;
  }
  
  public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    AppMethodBeat.i(186232);
    paramObject1 = ag(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
    AppMethodBeat.o(186232);
    return paramObject1;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(56372);
    boolean bool = p.j(this.TaJ, kotlin.g.b.e.SYm);
    AppMethodBeat.o(56372);
    return bool ^ true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56381);
    Object localObject = aa.TbF;
    localObject = aa.a(hyE());
    AppMethodBeat.o(56381);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class a
    extends q
    implements a<d<? extends Member>>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class b
    extends q
    implements a<d<? extends Member>>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
  static final class c
    extends q
    implements a<t>
  {
    c(j paramj, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.j
 * JD-Core Version:    0.7.0.1
 */