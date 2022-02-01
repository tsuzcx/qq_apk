package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l;
import d.l.b.a.a.d;
import d.l.b.a.a.h;
import d.l.b.a.b.b.t;
import d.l.k;
import java.lang.reflect.Member;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"})
public final class j
  extends e<Object>
  implements m<Object>, b, d.l.e<Object>
{
  private final y.b MNT;
  private final y.b MNU;
  final i MNV;
  private final Object MNW;
  private final y.a MNj;
  private final String signature;
  
  static
  {
    AppMethodBeat.i(56371);
    cwV = new k[] { (k)z.a(new x(z.bp(j.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), (k)z.a(new x(z.bp(j.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), (k)z.a(new x(z.bp(j.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")) };
    AppMethodBeat.o(56371);
  }
  
  public j(i parami, t paramt)
  {
    this(parami, str, ac.c(paramt).sD(), paramt);
    AppMethodBeat.i(56385);
    AppMethodBeat.o(56385);
  }
  
  private j(i parami, final String paramString1, String paramString2, t paramt, Object paramObject)
  {
    AppMethodBeat.i(56382);
    this.MNV = parami;
    this.signature = paramString2;
    this.MNW = paramObject;
    this.MNj = y.a(paramt, (a)new c(this, paramString1));
    this.MNT = y.Q((a)new a(this));
    this.MNU = y.Q((a)new b(this));
    AppMethodBeat.o(56382);
  }
  
  public j(i parami, String paramString1, String paramString2, Object paramObject)
  {
    this(parami, paramString1, paramString2, null, paramObject);
    AppMethodBeat.i(56384);
    AppMethodBeat.o(56384);
  }
  
  private final Object gfP()
  {
    AppMethodBeat.i(56377);
    Object localObject = h.a(this.MNW, (d.l.b.a.b.b.b)ggz());
    AppMethodBeat.o(56377);
    return localObject;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    AppMethodBeat.i(56390);
    paramObject1 = af(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
    AppMethodBeat.o(56390);
    return paramObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    AppMethodBeat.i(168742);
    paramObject1 = af(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
    AppMethodBeat.o(168742);
    return paramObject1;
  }
  
  public final Object a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    AppMethodBeat.i(187761);
    paramObject1 = af(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10 });
    AppMethodBeat.o(187761);
    return paramObject1;
  }
  
  public final Object d(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(56389);
    paramObject1 = af(new Object[] { paramObject1, paramObject2, paramObject3 });
    AppMethodBeat.o(56389);
    return paramObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56379);
    paramObject = ae.eZ(paramObject);
    if (paramObject == null)
    {
      AppMethodBeat.o(56379);
      return false;
    }
    if ((p.i(this.MNV, paramObject.MNV)) && (p.i(getName(), paramObject.getName())) && (p.i(this.signature, paramObject.signature)) && (p.i(this.MNW, paramObject.MNW)))
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
    int i = d.l.b.a.a.f.a(ggo());
    AppMethodBeat.o(56378);
    return i;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56375);
    String str = ggz().giD().sD();
    p.g(str, "descriptor.name.asString()");
    AppMethodBeat.o(56375);
    return str;
  }
  
  public final d<?> ggo()
  {
    AppMethodBeat.i(56376);
    d locald = (d)this.MNT.invoke();
    AppMethodBeat.o(56376);
    return locald;
  }
  
  public final d<?> ggp()
  {
    AppMethodBeat.i(187760);
    d locald = (d)this.MNU.invoke();
    AppMethodBeat.o(187760);
    return locald;
  }
  
  public final i ggq()
  {
    return this.MNV;
  }
  
  public final t ggz()
  {
    AppMethodBeat.i(56373);
    t localt = (t)this.MNj.invoke();
    AppMethodBeat.o(56373);
    return localt;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56380);
    int i = this.MNV.hashCode();
    int j = getName().hashCode();
    int k = this.signature.hashCode();
    AppMethodBeat.o(56380);
    return (i * 31 + j) * 31 + k;
  }
  
  public final Object invoke()
  {
    AppMethodBeat.i(56386);
    Object localObject = af(new Object[0]);
    AppMethodBeat.o(56386);
    return localObject;
  }
  
  public final Object invoke(Object paramObject)
  {
    AppMethodBeat.i(56387);
    paramObject = af(new Object[] { paramObject });
    AppMethodBeat.o(56387);
    return paramObject;
  }
  
  public final boolean isBound()
  {
    AppMethodBeat.i(56372);
    boolean bool = p.i(this.MNW, d.g.b.e.MLB);
    AppMethodBeat.o(56372);
    return bool ^ true;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(56388);
    paramObject1 = af(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(56388);
    return paramObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56381);
    Object localObject = aa.MOS;
    localObject = aa.a(ggz());
    AppMethodBeat.o(56381);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class a
    extends q
    implements a<d<? extends Member>>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"})
  static final class b
    extends q
    implements a<d<? extends Member>>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.j
 * JD-Core Version:    0.7.0.1
 */