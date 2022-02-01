package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.l.b.a.b.a.h;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.d.b.m;
import d.l.b.a.b.b.d.b.s;
import d.l.b.a.b.d.a.b.g;
import d.l.b.a.b.d.a.o;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.c.a.e.b;
import d.l.b.a.b.e.c.a.i;
import d.l.b.a.b.h.i.c;
import d.l.b.a.b.h.i.f;
import d.l.b.a.b.j.e;
import java.lang.reflect.Method;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"})
public final class ac
{
  static final d.l.b.a.b.f.a Nma;
  public static final ac Nmb;
  
  static
  {
    AppMethodBeat.i(56550);
    Nmb = new ac();
    d.l.b.a.b.f.a locala = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b("java.lang.Void"));
    d.g.b.p.g(locala, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    Nma = locala;
    AppMethodBeat.o(56550);
  }
  
  private static String b(d.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(56548);
    String str = d.l.b.a.b.d.a.t.p(paramb);
    Object localObject = str;
    if (str == null)
    {
      if (!(paramb instanceof ai)) {
        break label54;
      }
      paramb = o.bdT(d.l.b.a.b.j.d.a.v(paramb).gnf().sD());
    }
    for (;;)
    {
      d.g.b.p.g(paramb, "when (descriptor) {\n    …name.asString()\n        }");
      localObject = paramb;
      AppMethodBeat.o(56548);
      return localObject;
      label54:
      if ((paramb instanceof aj)) {
        paramb = o.bdU(d.l.b.a.b.j.d.a.v(paramb).gnf().sD());
      } else {
        paramb = paramb.gnf().sD();
      }
    }
  }
  
  static h bt(Class<?> paramClass)
  {
    AppMethodBeat.i(56549);
    if (paramClass.isPrimitive())
    {
      paramClass = d.l.b.a.b.j.e.d.bev(paramClass.getSimpleName());
      d.g.b.p.g(paramClass, "JvmPrimitiveType.get(simpleName)");
      paramClass = paramClass.gxG();
      AppMethodBeat.o(56549);
      return paramClass;
    }
    AppMethodBeat.o(56549);
    return null;
  }
  
  public static c c(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(56545);
    d.g.b.p.h(paramt, "possiblySubstitutedFunction");
    Object localObject1 = d.l.b.a.b.j.c.t((d.l.b.a.b.b.b)paramt);
    d.g.b.p.g(localObject1, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    d.l.b.a.b.b.t localt = ((d.l.b.a.b.b.t)localObject1).gnr();
    d.g.b.p.g(localt, "DescriptorUtils.unwrapFa…titutedFunction).original");
    if ((localt instanceof d.l.b.a.b.k.a.b.c))
    {
      localObject1 = ((d.l.b.a.b.k.a.b.c)localt).gyf();
      Object localObject2;
      if ((localObject1 instanceof a.h))
      {
        localObject2 = i.NNj;
        localObject2 = i.a((a.h)localObject1, ((d.l.b.a.b.k.a.b.c)localt).gyg(), ((d.l.b.a.b.k.a.b.c)localt).gyh());
        if (localObject2 != null)
        {
          paramt = (c)new c.e((e.b)localObject2);
          AppMethodBeat.o(56545);
          return paramt;
        }
      }
      if ((localObject1 instanceof d.l.b.a.b.e.a.c))
      {
        localObject2 = i.NNj;
        localObject1 = i.a((d.l.b.a.b.e.a.c)localObject1, ((d.l.b.a.b.k.a.b.c)localt).gyg(), ((d.l.b.a.b.k.a.b.c)localt).gyh());
        if (localObject1 != null)
        {
          paramt = paramt.glU();
          d.g.b.p.g(paramt, "possiblySubstitutedFunction.containingDeclaration");
          if (e.D(paramt))
          {
            paramt = (c)new c.e((e.b)localObject1);
            AppMethodBeat.o(56545);
            return paramt;
          }
          paramt = (c)new c.d((e.b)localObject1);
          AppMethodBeat.o(56545);
          return paramt;
        }
      }
      paramt = (c)d(localt);
      AppMethodBeat.o(56545);
      return paramt;
    }
    if ((localt instanceof d.l.b.a.b.d.a.b.f))
    {
      localObject1 = ((d.l.b.a.b.d.a.b.f)localt).gmk();
      paramt = (d.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (d.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.gpa();; paramt = null)
      {
        localObject1 = paramt;
        if (!(paramt instanceof s)) {
          localObject1 = null;
        }
        paramt = (s)localObject1;
        if (paramt != null)
        {
          paramt = paramt.NxK;
          if (paramt != null) {
            break;
          }
        }
        paramt = (Throwable)new w("Incorrect resolution sequence for Java method ".concat(String.valueOf(localt)));
        AppMethodBeat.o(56545);
        throw paramt;
      }
      paramt = (c)new c.c(paramt);
      AppMethodBeat.o(56545);
      return paramt;
    }
    if ((localt instanceof d.l.b.a.b.d.a.b.c))
    {
      localObject1 = ((d.l.b.a.b.d.a.b.c)localt).gmk();
      paramt = (d.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (d.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.gpa(); (paramt instanceof m); paramt = null)
      {
        paramt = (c)new c.b(((m)paramt).NxH);
        AppMethodBeat.o(56545);
        return paramt;
      }
      if (((paramt instanceof d.l.b.a.b.b.d.b.j)) && (((d.l.b.a.b.b.d.b.j)paramt).Nxb.isAnnotation()))
      {
        paramt = (c)new c.a(((d.l.b.a.b.b.d.b.j)paramt).Nxb);
        AppMethodBeat.o(56545);
        return paramt;
      }
      paramt = (Throwable)new w("Incorrect resolution sequence for Java constructor " + localt + " (" + paramt + ')');
      AppMethodBeat.o(56545);
      throw paramt;
    }
    if (localt == null) {
      d.l.b.a.b.j.b.ajW(27);
    }
    int i;
    if ((localt.gnf().equals(d.l.b.a.b.j.c.NSy)) && (d.l.b.a.b.j.b.g(localt)))
    {
      i = 1;
      if (i == 0)
      {
        if (localt == null) {
          d.l.b.a.b.j.b.ajW(26);
        }
        if ((!localt.gnf().equals(d.l.b.a.b.j.c.NSx)) || (!d.l.b.a.b.j.b.g(localt))) {
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
      paramt = (c)d(localt);
      AppMethodBeat.o(56545);
      return paramt;
      i = 0;
      break;
      label633:
      i = 0;
      break label603;
      label638:
      paramt = localt.gnf();
      localObject1 = d.l.b.a.b.a.b.a.Nqc;
      if ((d.g.b.p.i(paramt, d.l.b.a.b.a.b.a.gmw())) && (localt.gmU().isEmpty())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label683:
    paramt = (Throwable)new w("Unknown origin of " + localt + " (" + localt.getClass() + ')');
    AppMethodBeat.o(56545);
    throw paramt;
  }
  
  public static d c(ah paramah)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(56546);
    d.g.b.p.h(paramah, "possiblyOverriddenProperty");
    paramah = d.l.b.a.b.j.c.t((d.l.b.a.b.b.b)paramah);
    d.g.b.p.g(paramah, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    ah localah = ((ah)paramah).gnO();
    d.g.b.p.g(localah, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    Object localObject3;
    if ((localah instanceof d.l.b.a.b.k.a.b.j))
    {
      paramah = ((d.l.b.a.b.k.a.b.j)localah).NjX;
      localObject2 = (i.c)paramah;
      localObject3 = d.l.b.a.b.e.c.a.NMk;
      d.g.b.p.g(localObject3, "JvmProtoBuf.propertySignature");
      localObject2 = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject2, (i.f)localObject3);
      if (localObject2 != null)
      {
        paramah = (d)new d.c(localah, paramah, (d.l.b.a.b.e.c.a.c)localObject2, ((d.l.b.a.b.k.a.b.j)localah).NjZ, ((d.l.b.a.b.k.a.b.j)localah).Nka);
        AppMethodBeat.o(56546);
        return paramah;
      }
    }
    else if ((localah instanceof g))
    {
      localObject1 = ((g)localah).gmk();
      paramah = (ah)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramah = null;
      }
      paramah = (d.l.b.a.b.d.a.d.a)paramah;
      if (paramah != null) {}
      for (paramah = paramah.gpa(); (paramah instanceof d.l.b.a.b.b.d.b.p); paramah = null)
      {
        paramah = (d)new d.a(((d.l.b.a.b.b.d.b.p)paramah).NxJ);
        AppMethodBeat.o(56546);
        return paramah;
      }
      if ((paramah instanceof s))
      {
        localObject3 = ((s)paramah).NxK;
        paramah = localah.gnM();
        if (paramah != null)
        {
          paramah = paramah.gmk();
          localObject1 = paramah;
          if (!(paramah instanceof d.l.b.a.b.d.a.d.a)) {
            localObject1 = null;
          }
          paramah = (d.l.b.a.b.d.a.d.a)localObject1;
          if (paramah == null) {
            break label332;
          }
        }
        label332:
        for (paramah = paramah.gpa();; paramah = null)
        {
          localObject1 = paramah;
          if (!(paramah instanceof s)) {
            localObject1 = null;
          }
          localObject1 = (s)localObject1;
          paramah = (ah)localObject2;
          if (localObject1 != null) {
            paramah = ((s)localObject1).NxK;
          }
          paramah = (d)new d.b((Method)localObject3, paramah);
          AppMethodBeat.o(56546);
          return paramah;
          paramah = null;
          break;
        }
      }
      paramah = (Throwable)new w("Incorrect resolution sequence for Java field " + localah + " (source = " + paramah + ')');
      AppMethodBeat.o(56546);
      throw paramah;
    }
    paramah = localah.gnL();
    if (paramah == null) {
      d.g.b.p.gkB();
    }
    localObject2 = d((d.l.b.a.b.b.t)paramah);
    paramah = localah.gnM();
    if (paramah != null) {}
    for (paramah = d((d.l.b.a.b.b.t)paramah);; paramah = (ah)localObject1)
    {
      paramah = (d)new d.d((c.e)localObject2, paramah);
      AppMethodBeat.o(56546);
      return paramah;
    }
  }
  
  private static c.e d(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(56547);
    paramt = new c.e(new e.b(b((d.l.b.a.b.b.b)paramt), d.l.b.a.b.d.b.t.a(paramt, false, false, 1)));
    AppMethodBeat.o(56547);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.ac
 * JD-Core Version:    0.7.0.1
 */