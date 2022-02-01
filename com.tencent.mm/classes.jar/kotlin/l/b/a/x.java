package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ag;
import kotlin.g.b.ao;
import kotlin.g.b.ao.a;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.d.b.i;
import kotlin.l.o;
import kotlin.l.y;
import kotlin.p;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "container", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class x
  implements kotlin.l.v
{
  private final ac.a aiAj;
  private final z aiAk;
  final ba aiAl;
  
  static
  {
    AppMethodBeat.i(56505);
    aYe = new o[] { (o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(x.class), "upperBounds", "getUpperBounds()Ljava/util/List;")) };
    AppMethodBeat.o(56505);
  }
  
  public x(z paramz, ba paramba)
  {
    AppMethodBeat.i(191357);
    this.aiAl = paramba;
    this.aiAj = ac.cp((kotlin.g.a.a)new a(this));
    l locall;
    if (paramz == null)
    {
      locall = ((x)this).aiAl.knp();
      s.s(locall, "descriptor.containingDeclaration");
      if ((locall instanceof e))
      {
        paramz = a((e)locall);
        s.s(paramz, "when (val declaration = … $declaration\")\n        }");
        paramz = (z)paramz;
      }
    }
    for (;;)
    {
      this.aiAk = paramz;
      AppMethodBeat.o(191357);
      return;
      if ((locall instanceof b))
      {
        paramz = ((b)locall).knp();
        s.s(paramz, "declaration.containingDeclaration");
        if ((paramz instanceof e))
        {
          paramz = a((e)paramz);
          paramz = locall.a((n)new a((j)paramz), ah.aiuX);
          break;
        }
        if ((locall instanceof kotlin.l.b.a.b.k.a.b.h)) {
          break label366;
        }
      }
      label366:
      for (paramz = null;; paramz = locall)
      {
        kotlin.l.b.a.b.k.a.b.h localh = (kotlin.l.b.a.b.k.a.b.h)paramz;
        if (localh == null)
        {
          paramz = (Throwable)new aa("Non-class callable descriptor must be deserialized: ".concat(String.valueOf(locall)));
          AppMethodBeat.o(191357);
          throw paramz;
        }
        paramba = localh.kAf();
        paramz = paramba;
        if (!(paramba instanceof i)) {
          paramz = null;
        }
        paramz = (i)paramz;
        if (paramz != null) {}
        for (paramz = paramz.aiWL;; paramz = null)
        {
          paramba = paramz;
          if (!(paramz instanceof kotlin.l.b.a.b.b.e.a.f)) {
            paramba = null;
          }
          paramz = (kotlin.l.b.a.b.b.e.a.f)paramba;
          if (paramz != null)
          {
            paramz = paramz.aiMA;
            if (paramz != null) {
              break;
            }
          }
          paramz = (Throwable)new aa("Container of deserialized member is not resolved: ".concat(String.valueOf(localh)));
          AppMethodBeat.o(191357);
          throw paramz;
        }
        paramz = kotlin.g.a.cx(paramz);
        if (paramz == null)
        {
          paramz = new NullPointerException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
          AppMethodBeat.o(191357);
          throw paramz;
        }
        paramz = (h)paramz;
        break;
        paramz = (Throwable)new aa("Unknown type parameter container: ".concat(String.valueOf(locall)));
        AppMethodBeat.o(191357);
        throw paramz;
      }
    }
  }
  
  private static h<?> a(e parame)
  {
    AppMethodBeat.i(191356);
    Object localObject = ai.b(parame);
    if (localObject != null) {}
    for (localObject = kotlin.g.a.cx((Class)localObject);; localObject = null)
    {
      localObject = (h)localObject;
      if (localObject != null) {
        break;
      }
      parame = (Throwable)new aa("Type parameter container is not resolved: " + parame.knp());
      AppMethodBeat.o(191356);
      throw parame;
    }
    AppMethodBeat.o(191356);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56507);
    if (((paramObject instanceof x)) && (s.p(this.aiAk, ((x)paramObject).aiAk)) && (s.p(getName(), ((x)paramObject).getName())))
    {
      AppMethodBeat.o(56507);
      return true;
    }
    AppMethodBeat.o(56507);
    return false;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(191358);
    String str = this.aiAl.kok().PF();
    s.s(str, "descriptor.name.asString()");
    AppMethodBeat.o(191358);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56508);
    int i = this.aiAk.hashCode();
    int j = getName().hashCode();
    AppMethodBeat.o(56508);
    return i * 31 + j;
  }
  
  public final List<kotlin.l.u> klF()
  {
    AppMethodBeat.i(56506);
    List localList = (List)this.aiAj.invoke();
    AppMethodBeat.o(56506);
    return localList;
  }
  
  public final y klG()
  {
    AppMethodBeat.i(191362);
    Object localObject = this.aiAl.kom();
    switch (y.$EnumSwitchMapping$0[localObject.ordinal()])
    {
    default: 
      localObject = new p();
      AppMethodBeat.o(191362);
      throw ((Throwable)localObject);
    case 1: 
      localObject = y.aixN;
      AppMethodBeat.o(191362);
      return localObject;
    case 2: 
      localObject = y.aixO;
      AppMethodBeat.o(191362);
      return localObject;
    }
    localObject = y.aixP;
    AppMethodBeat.o(191362);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56509);
    Object localObject = ao.aixh;
    localObject = ao.a.a((kotlin.l.v)this);
    AppMethodBeat.o(56509);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends v>>
  {
    a(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.x
 * JD-Core Version:    0.7.0.1
 */