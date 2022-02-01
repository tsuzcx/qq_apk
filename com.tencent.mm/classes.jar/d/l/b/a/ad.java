package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.l.b.a.b.a.h;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ai;
import d.l.b.a.b.b.aj;
import d.l.b.a.b.b.d.b.m;
import d.l.b.a.b.b.d.b.p;
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

@l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"})
public final class ad
{
  static final d.l.b.a.b.f.a JkE;
  public static final ad JkF;
  
  static
  {
    AppMethodBeat.i(56550);
    JkF = new ad();
    d.l.b.a.b.f.a locala = d.l.b.a.b.f.a.p(new d.l.b.a.b.f.b("java.lang.Void"));
    k.g(locala, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    JkE = locala;
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
      paramb = o.aQn(d.l.b.a.b.j.d.a.v(paramb).fyB().qV());
    }
    for (;;)
    {
      k.g(paramb, "when (descriptor) {\n    …name.asString()\n        }");
      localObject = paramb;
      AppMethodBeat.o(56548);
      return localObject;
      label54:
      if ((paramb instanceof aj)) {
        paramb = o.aQo(d.l.b.a.b.j.d.a.v(paramb).fyB().qV());
      } else {
        paramb = paramb.fyB().qV();
      }
    }
  }
  
  static h bo(Class<?> paramClass)
  {
    AppMethodBeat.i(56549);
    if (paramClass.isPrimitive())
    {
      paramClass = d.l.b.a.b.j.e.d.aQP(paramClass.getSimpleName());
      k.g(paramClass, "JvmPrimitiveType.get(simpleName)");
      paramClass = paramClass.fJc();
      AppMethodBeat.o(56549);
      return paramClass;
    }
    AppMethodBeat.o(56549);
    return null;
  }
  
  public static c c(d.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(56545);
    k.h(paramt, "possiblySubstitutedFunction");
    Object localObject1 = d.l.b.a.b.j.c.t((d.l.b.a.b.b.b)paramt);
    k.g(localObject1, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    d.l.b.a.b.b.t localt = ((d.l.b.a.b.b.t)localObject1).fyM();
    k.g(localt, "DescriptorUtils.unwrapFa…titutedFunction).original");
    if ((localt instanceof d.l.b.a.b.k.a.b.c))
    {
      localObject1 = ((d.l.b.a.b.k.a.b.c)localt).fJB();
      Object localObject2;
      if ((localObject1 instanceof a.h))
      {
        localObject2 = i.JLN;
        localObject2 = i.a((a.h)localObject1, ((d.l.b.a.b.k.a.b.c)localt).fJC(), ((d.l.b.a.b.k.a.b.c)localt).fJD());
        if (localObject2 != null)
        {
          paramt = (c)new c.e((e.b)localObject2);
          AppMethodBeat.o(56545);
          return paramt;
        }
      }
      if ((localObject1 instanceof d.l.b.a.b.e.a.c))
      {
        localObject2 = i.JLN;
        localObject1 = i.a((d.l.b.a.b.e.a.c)localObject1, ((d.l.b.a.b.k.a.b.c)localt).fJC(), ((d.l.b.a.b.k.a.b.c)localt).fJD());
        if (localObject1 != null)
        {
          paramt = paramt.fxq();
          k.g(paramt, "possiblySubstitutedFunction.containingDeclaration");
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
      localObject1 = ((d.l.b.a.b.d.a.b.f)localt).fxG();
      paramt = (d.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (d.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.fAv();; paramt = null)
      {
        localObject1 = paramt;
        if (!(paramt instanceof s)) {
          localObject1 = null;
        }
        paramt = (s)localObject1;
        if (paramt != null)
        {
          paramt = paramt.Jwp;
          if (paramt != null) {
            break;
          }
        }
        paramt = (Throwable)new x("Incorrect resolution sequence for Java method ".concat(String.valueOf(localt)));
        AppMethodBeat.o(56545);
        throw paramt;
      }
      paramt = (c)new c.c(paramt);
      AppMethodBeat.o(56545);
      return paramt;
    }
    if ((localt instanceof d.l.b.a.b.d.a.b.c))
    {
      localObject1 = ((d.l.b.a.b.d.a.b.c)localt).fxG();
      paramt = (d.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (d.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.fAv(); (paramt instanceof m); paramt = null)
      {
        paramt = (c)new c.b(((m)paramt).Jwm);
        AppMethodBeat.o(56545);
        return paramt;
      }
      if (((paramt instanceof d.l.b.a.b.b.d.b.j)) && (((d.l.b.a.b.b.d.b.j)paramt).JvG.isAnnotation()))
      {
        paramt = (c)new c.a(((d.l.b.a.b.b.d.b.j)paramt).JvG);
        AppMethodBeat.o(56545);
        return paramt;
      }
      paramt = (Throwable)new x("Incorrect resolution sequence for Java constructor " + localt + " (" + paramt + ')');
      AppMethodBeat.o(56545);
      throw paramt;
    }
    if (localt == null) {
      d.l.b.a.b.j.b.adP(27);
    }
    int i;
    if ((localt.fyB().equals(d.l.b.a.b.j.c.JRa)) && (d.l.b.a.b.j.b.g(localt)))
    {
      i = 1;
      if (i == 0)
      {
        if (localt == null) {
          d.l.b.a.b.j.b.adP(26);
        }
        if ((!localt.fyB().equals(d.l.b.a.b.j.c.JQZ)) || (!d.l.b.a.b.j.b.g(localt))) {
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
      paramt = localt.fyB();
      localObject1 = d.l.b.a.b.a.b.a.JoJ;
      if ((k.g(paramt, d.l.b.a.b.a.b.a.fxS())) && (localt.fyq().isEmpty())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label683:
    paramt = (Throwable)new x("Unknown origin of " + localt + " (" + localt.getClass() + ')');
    AppMethodBeat.o(56545);
    throw paramt;
  }
  
  public static d c(ah paramah)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(56546);
    k.h(paramah, "possiblyOverriddenProperty");
    paramah = d.l.b.a.b.j.c.t((d.l.b.a.b.b.b)paramah);
    k.g(paramah, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    ah localah = ((ah)paramah).fzj();
    k.g(localah, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    Object localObject3;
    if ((localah instanceof d.l.b.a.b.k.a.b.j))
    {
      paramah = ((d.l.b.a.b.k.a.b.j)localah).Jis;
      localObject2 = (i.c)paramah;
      localObject3 = d.l.b.a.b.e.c.a.JKO;
      k.g(localObject3, "JvmProtoBuf.propertySignature");
      localObject2 = (d.l.b.a.b.e.c.a.c)d.l.b.a.b.e.b.f.a((i.c)localObject2, (i.f)localObject3);
      if (localObject2 != null)
      {
        paramah = (d)new d.c(localah, paramah, (d.l.b.a.b.e.c.a.c)localObject2, ((d.l.b.a.b.k.a.b.j)localah).Jiu, ((d.l.b.a.b.k.a.b.j)localah).Jiv);
        AppMethodBeat.o(56546);
        return paramah;
      }
    }
    else if ((localah instanceof g))
    {
      localObject1 = ((g)localah).fxG();
      paramah = (ah)localObject1;
      if (!(localObject1 instanceof d.l.b.a.b.d.a.d.a)) {
        paramah = null;
      }
      paramah = (d.l.b.a.b.d.a.d.a)paramah;
      if (paramah != null) {}
      for (paramah = paramah.fAv(); (paramah instanceof p); paramah = null)
      {
        paramah = (d)new d.a(((p)paramah).Jwo);
        AppMethodBeat.o(56546);
        return paramah;
      }
      if ((paramah instanceof s))
      {
        localObject3 = ((s)paramah).Jwp;
        paramah = localah.fzh();
        if (paramah != null)
        {
          paramah = paramah.fxG();
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
        for (paramah = paramah.fAv();; paramah = null)
        {
          localObject1 = paramah;
          if (!(paramah instanceof s)) {
            localObject1 = null;
          }
          localObject1 = (s)localObject1;
          paramah = (ah)localObject2;
          if (localObject1 != null) {
            paramah = ((s)localObject1).Jwp;
          }
          paramah = (d)new d.b((Method)localObject3, paramah);
          AppMethodBeat.o(56546);
          return paramah;
          paramah = null;
          break;
        }
      }
      paramah = (Throwable)new x("Incorrect resolution sequence for Java field " + localah + " (source = " + paramah + ')');
      AppMethodBeat.o(56546);
      throw paramah;
    }
    paramah = localah.fzg();
    if (paramah == null) {
      k.fvU();
    }
    localObject2 = d((d.l.b.a.b.b.t)paramah);
    paramah = localah.fzh();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.ad
 * JD-Core Version:    0.7.0.1
 */