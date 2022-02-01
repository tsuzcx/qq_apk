package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l.b.a.a.d;
import d.l.b.a.a.h;
import d.l.b.a.b.b.t;
import java.lang.reflect.Member;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"})
public final class j
  extends e<Object>
  implements d.g.b.i<Object>, b, d.l.e<Object>
{
  private final z.b KWN;
  private final z.b KWO;
  final i KWP;
  private final Object KWQ;
  private final z.a KWd;
  private final String signature;
  
  static
  {
    AppMethodBeat.i(56371);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (d.l.k)w.a(new u(w.bn(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), (d.l.k)w.a(new u(w.bn(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")) };
    AppMethodBeat.o(56371);
  }
  
  public j(i parami, t paramt)
  {
    this(parami, str, ad.c(paramt).rf(), paramt);
    AppMethodBeat.i(56385);
    AppMethodBeat.o(56385);
  }
  
  private j(i parami, final String paramString1, String paramString2, t paramt, Object paramObject)
  {
    AppMethodBeat.i(56382);
    this.KWP = parami;
    this.signature = paramString2;
    this.KWQ = paramObject;
    this.KWd = z.a(paramt, (a)new c(this, paramString1));
    this.KWN = z.M((a)new a(this));
    this.KWO = z.M((a)new b(this));
    AppMethodBeat.o(56382);
  }
  
  public j(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
    AppMethodBeat.i(56384);
    AppMethodBeat.o(56384);
  }
  
  private final Object fOp()
  {
    AppMethodBeat.i(56377);
    Object localObject = h.a(this.KWQ, (d.l.b.a.b.b.b)fPa());
    AppMethodBeat.o(56377);
    return localObject;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(56390);
    paramObject1 = ae(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(56390);
    return paramObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(168742);
    paramObject1 = ae(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(168742);
    return paramObject1;
  }
  
  public final Object ay(Object paramObject)
  {
    AppMethodBeat.i(56387);
    paramObject = ae(new Object[] { paramObject });
    AppMethodBeat.o(56387);
    return paramObject;
  }
  
  public final Object d(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(56389);
    paramObject1 = ae(new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(56389);
    return paramObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56379);
    paramObject = af.eX(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(56379);
      return false;
    }
    if ((d.g.b.k.g(this.KWP, paramObject.KWP)) && (d.g.b.k.g(getName(), paramObject.getName())) && (d.g.b.k.g(this.signature, paramObject.signature)) && (d.g.b.k.g(this.KWQ, paramObject.KWQ)))
    {
      AppMethodBeat.o(56379);
      return true;
    }
    AppMethodBeat.o(56379);
    return false;
  }
  
  public final d<?> fOO()
  {
    AppMethodBeat.i(56376);
    d locald = (d)this.KWN.invoke();
    AppMethodBeat.o(56376);
    return locald;
  }
  
  public final d<?> fOP()
  {
    AppMethodBeat.i(207354);
    d locald = (d)this.KWO.invoke();
    AppMethodBeat.o(207354);
    return locald;
  }
  
  public final i fOQ()
  {
    return this.KWP;
  }
  
  public final t fPa()
  {
    AppMethodBeat.i(56373);
    t localt = (t)this.KWd.invoke();
    AppMethodBeat.o(56373);
    return localt;
  }
  
  public final int getArity()
  {
    AppMethodBeat.i(56378);
    int i = d.l.b.a.a.f.a(fOO());
    AppMethodBeat.o(56378);
    return i;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56375);
    String str = fPa().fRf().rf();
    d.g.b.k.g(str, "descriptor.name.asString()");
    AppMethodBeat.o(56375);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56380);
    int i = this.KWP.hashCode();
    int j = getName().hashCode();
    int k = this.signature.hashCode();
    AppMethodBeat.o(56380);
    return (i * 31 + j) * 31 + k;
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(56386);
    Object localObject = ae(new Object[0]);
    AppMethodBeat.o(56386);
    return localObject;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(56372);
    boolean bool = d.g.b.k.g(this.KWQ, d.g.b.c.KUA);
    AppMethodBeat.o(56372);
    return bool ^ true;
  }
  
  public final Object n(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(56388);
    paramObject1 = ae(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(56388);
    return paramObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56381);
    Object localObject = ab.KXV;
    localObject = ab.a(fPa());
    AppMethodBeat.o(56381);
    return localObject;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<d<? extends Member>>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<d<? extends Member>>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<t>
  {
    c(j paramj, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.j
 * JD-Core Version:    0.7.0.1
 */