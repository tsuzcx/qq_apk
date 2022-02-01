package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.e.b.j;
import kotlin.l.b.a.b.b.e.b.m;
import kotlin.l.b.a.b.b.e.b.p;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.d.a.ac;
import kotlin.l.b.a.b.d.a.v;
import kotlin.l.b.a.b.d.b.t;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class ag
{
  static final kotlin.l.b.a.b.f.b aiAu;
  public static final ag aiAv;
  
  static
  {
    AppMethodBeat.i(56550);
    aiAv = new ag();
    kotlin.l.b.a.b.f.b localb = kotlin.l.b.a.b.f.b.s(new kotlin.l.b.a.b.f.c("java.lang.Void"));
    kotlin.g.b.s.s(localb, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    aiAu = localb;
    AppMethodBeat.o(56550);
  }
  
  private static String b(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(56548);
    String str2 = ac.p(paramb);
    String str1 = str2;
    if (str2 == null)
    {
      if ((paramb instanceof aq))
      {
        paramb = kotlin.l.b.a.b.j.d.a.v(paramb).kok().PF();
        kotlin.g.b.s.s(paramb, "descriptor.propertyIfAccessor.name.asString()");
        paramb = v.bIO(paramb);
        AppMethodBeat.o(56548);
        return paramb;
      }
      if ((paramb instanceof ar))
      {
        paramb = kotlin.l.b.a.b.j.d.a.v(paramb).kok().PF();
        kotlin.g.b.s.s(paramb, "descriptor.propertyIfAccessor.name.asString()");
        paramb = v.bIP(paramb);
        AppMethodBeat.o(56548);
        return paramb;
      }
      str1 = paramb.kok().PF();
      kotlin.g.b.s.s(str1, "descriptor.name.asString()");
    }
    AppMethodBeat.o(56548);
    return str1;
  }
  
  public static d c(x paramx)
  {
    AppMethodBeat.i(56545);
    kotlin.g.b.s.u(paramx, "possiblySubstitutedFunction");
    Object localObject1 = kotlin.l.b.a.b.j.d.t((kotlin.l.b.a.b.b.b)paramx);
    kotlin.g.b.s.s(localObject1, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    x localx = ((x)localObject1).koH();
    kotlin.g.b.s.s(localx, "DescriptorUtils.unwrapFa…titutedFunction).original");
    if ((localx instanceof kotlin.l.b.a.b.k.a.b.c))
    {
      localObject1 = ((kotlin.l.b.a.b.k.a.b.c)localx).kAh();
      Object localObject2;
      if ((localObject1 instanceof a.h))
      {
        localObject2 = g.ajem;
        localObject2 = g.a((a.h)localObject1, ((kotlin.l.b.a.b.k.a.b.c)localx).kAc(), ((kotlin.l.b.a.b.k.a.b.c)localx).kAd());
        if (localObject2 != null)
        {
          paramx = (d)new d.e((kotlin.l.b.a.b.e.c.a.d.b)localObject2);
          AppMethodBeat.o(56545);
          return paramx;
        }
      }
      if ((localObject1 instanceof kotlin.l.b.a.b.e.a.c))
      {
        localObject2 = g.ajem;
        localObject1 = g.a((kotlin.l.b.a.b.e.a.c)localObject1, ((kotlin.l.b.a.b.k.a.b.c)localx).kAc(), ((kotlin.l.b.a.b.k.a.b.c)localx).kAd());
        if (localObject1 != null)
        {
          paramx = paramx.knp();
          kotlin.g.b.s.s(paramx, "possiblySubstitutedFunction.containingDeclaration");
          if (kotlin.l.b.a.b.j.f.D(paramx))
          {
            paramx = (d)new d.e((kotlin.l.b.a.b.e.c.a.d.b)localObject1);
            AppMethodBeat.o(56545);
            return paramx;
          }
          paramx = (d)new d.d((kotlin.l.b.a.b.e.c.a.d.b)localObject1);
          AppMethodBeat.o(56545);
          return paramx;
        }
      }
      paramx = (d)d(localx);
      AppMethodBeat.o(56545);
      return paramx;
    }
    if ((localx instanceof kotlin.l.b.a.b.d.a.b.e))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.b.e)localx).knm();
      paramx = (x)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramx = null;
      }
      paramx = (kotlin.l.b.a.b.d.a.d.a)paramx;
      if (paramx != null) {}
      for (paramx = paramx.kqq();; paramx = null)
      {
        localObject1 = paramx;
        if (!(paramx instanceof kotlin.l.b.a.b.b.e.b.s)) {
          localObject1 = null;
        }
        paramx = (kotlin.l.b.a.b.b.e.b.s)localObject1;
        if (paramx != null)
        {
          paramx = paramx.aiNl;
          if (paramx != null) {
            break;
          }
        }
        paramx = (Throwable)new aa("Incorrect resolution sequence for Java method ".concat(String.valueOf(localx)));
        AppMethodBeat.o(56545);
        throw paramx;
      }
      paramx = (d)new d.c(paramx);
      AppMethodBeat.o(56545);
      return paramx;
    }
    if ((localx instanceof kotlin.l.b.a.b.d.a.b.b))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.b.b)localx).knm();
      paramx = (x)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramx = null;
      }
      paramx = (kotlin.l.b.a.b.d.a.d.a)paramx;
      if (paramx != null) {}
      for (paramx = paramx.kqq(); (paramx instanceof m); paramx = null)
      {
        paramx = (d)new d.b(((m)paramx).aiNi);
        AppMethodBeat.o(56545);
        return paramx;
      }
      if (((paramx instanceof j)) && (((j)paramx).aiMA.isAnnotation()))
      {
        paramx = (d)new d.a(((j)paramx).aiMA);
        AppMethodBeat.o(56545);
        return paramx;
      }
      paramx = (Throwable)new aa("Incorrect resolution sequence for Java constructor " + localx + " (" + paramx + ')');
      AppMethodBeat.o(56545);
      throw paramx;
    }
    if (localx == null) {
      kotlin.l.b.a.b.j.c.aKu(27);
    }
    int i;
    if ((localx.kok().equals(kotlin.l.b.a.b.a.k.aiCg)) && (kotlin.l.b.a.b.j.c.g(localx)))
    {
      i = 1;
      if (i == 0)
      {
        if (localx == null) {
          kotlin.l.b.a.b.j.c.aKu(26);
        }
        if ((!localx.kok().equals(kotlin.l.b.a.b.a.k.aiCf)) || (!kotlin.l.b.a.b.j.c.g(localx))) {
          break label633;
        }
        i = 1;
        label603:
        if (i == 0) {
          break label638;
        }
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label683;
      }
      paramx = (d)d(localx);
      AppMethodBeat.o(56545);
      return paramx;
      i = 0;
      break;
      label633:
      i = 0;
      break label603;
      label638:
      paramx = localx.kok();
      localObject1 = kotlin.l.b.a.b.a.b.a.aiET;
      if ((kotlin.g.b.s.p(paramx, kotlin.l.b.a.b.a.b.a.knD())) && (localx.kod().isEmpty())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label683:
    paramx = (Throwable)new aa("Unknown origin of " + localx + " (" + localx.getClass() + ')');
    AppMethodBeat.o(56545);
    throw paramx;
  }
  
  public static e c(ap paramap)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(56546);
    kotlin.g.b.s.u(paramap, "possiblyOverriddenProperty");
    paramap = kotlin.l.b.a.b.j.d.t((kotlin.l.b.a.b.b.b)paramap);
    kotlin.g.b.s.s(paramap, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    ap localap = ((ap)paramap).kpf();
    kotlin.g.b.s.s(localap, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    Object localObject3;
    if ((localap instanceof kotlin.l.b.a.b.k.a.b.k))
    {
      paramap = ((kotlin.l.b.a.b.k.a.b.k)localap).aiyi;
      localObject2 = (i.c)paramap;
      localObject3 = kotlin.l.b.a.b.e.c.a.ajdo;
      kotlin.g.b.s.s(localObject3, "JvmProtoBuf.propertySignature");
      localObject2 = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.e.a((i.c)localObject2, (i.e)localObject3);
      if (localObject2 != null)
      {
        paramap = (e)new e.c(localap, paramap, (kotlin.l.b.a.b.e.c.a.c)localObject2, ((kotlin.l.b.a.b.k.a.b.k)localap).aiyk, ((kotlin.l.b.a.b.k.a.b.k)localap).aiyl);
        AppMethodBeat.o(56546);
        return paramap;
      }
    }
    else if ((localap instanceof kotlin.l.b.a.b.d.a.b.f))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.b.f)localap).knm();
      paramap = (ap)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramap = null;
      }
      paramap = (kotlin.l.b.a.b.d.a.d.a)paramap;
      if (paramap != null) {}
      for (paramap = paramap.kqq(); (paramap instanceof p); paramap = null)
      {
        paramap = (e)new e.a(((p)paramap).aiNk);
        AppMethodBeat.o(56546);
        return paramap;
      }
      if ((paramap instanceof kotlin.l.b.a.b.b.e.b.s))
      {
        localObject3 = ((kotlin.l.b.a.b.b.e.b.s)paramap).aiNl;
        paramap = localap.kpd();
        if (paramap != null)
        {
          paramap = paramap.knm();
          localObject1 = paramap;
          if (!(paramap instanceof kotlin.l.b.a.b.d.a.d.a)) {
            localObject1 = null;
          }
          paramap = (kotlin.l.b.a.b.d.a.d.a)localObject1;
          if (paramap == null) {
            break label332;
          }
        }
        label332:
        for (paramap = paramap.kqq();; paramap = null)
        {
          localObject1 = paramap;
          if (!(paramap instanceof kotlin.l.b.a.b.b.e.b.s)) {
            localObject1 = null;
          }
          localObject1 = (kotlin.l.b.a.b.b.e.b.s)localObject1;
          paramap = (ap)localObject2;
          if (localObject1 != null) {
            paramap = ((kotlin.l.b.a.b.b.e.b.s)localObject1).aiNl;
          }
          paramap = (e)new e.b((Method)localObject3, paramap);
          AppMethodBeat.o(56546);
          return paramap;
          paramap = null;
          break;
        }
      }
      paramap = (Throwable)new aa("Incorrect resolution sequence for Java field " + localap + " (source = " + paramap + ')');
      AppMethodBeat.o(56546);
      throw paramap;
    }
    paramap = localap.kpc();
    kotlin.g.b.s.checkNotNull(paramap);
    localObject2 = d((x)paramap);
    paramap = localap.kpd();
    if (paramap != null) {}
    for (paramap = d((x)paramap);; paramap = (ap)localObject1)
    {
      paramap = (e)new e.d((d.e)localObject2, paramap);
      AppMethodBeat.o(56546);
      return paramap;
    }
  }
  
  static i cD(Class<?> paramClass)
  {
    AppMethodBeat.i(56549);
    if (paramClass.isPrimitive())
    {
      paramClass = kotlin.l.b.a.b.j.e.e.bJq(paramClass.getSimpleName());
      kotlin.g.b.s.s(paramClass, "JvmPrimitiveType.get(simpleName)");
      paramClass = paramClass.kzs();
      AppMethodBeat.o(56549);
      return paramClass;
    }
    AppMethodBeat.o(56549);
    return null;
  }
  
  private static d.e d(x paramx)
  {
    AppMethodBeat.i(56547);
    paramx = new d.e(new kotlin.l.b.a.b.e.c.a.d.b(b((kotlin.l.b.a.b.b.b)paramx), t.a(paramx, false, false, 1)));
    AppMethodBeat.o(56547);
    return paramx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.ag
 * JD-Core Version:    0.7.0.1
 */