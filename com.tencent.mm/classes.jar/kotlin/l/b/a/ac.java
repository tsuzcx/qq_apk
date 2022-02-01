package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.l;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.b.d.b.m;
import kotlin.l.b.a.b.b.d.b.s;
import kotlin.l.b.a.b.d.a.b.g;
import kotlin.l.b.a.b.d.a.o;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.c.a.e.b;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.h.i.c;
import kotlin.l.b.a.b.h.i.e;
import kotlin.l.b.a.b.j.e;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"})
public final class ac
{
  static final kotlin.l.b.a.b.f.a aaEC;
  public static final ac aaED;
  
  static
  {
    AppMethodBeat.i(56550);
    aaED = new ac();
    kotlin.l.b.a.b.f.a locala = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("java.lang.Void"));
    kotlin.g.b.p.j(locala, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
    aaEC = locala;
    AppMethodBeat.o(56550);
  }
  
  private static String b(kotlin.l.b.a.b.b.b paramb)
  {
    AppMethodBeat.i(56548);
    String str = kotlin.l.b.a.b.d.a.t.p(paramb);
    Object localObject = str;
    if (str == null)
    {
      if (!(paramb instanceof ai)) {
        break label54;
      }
      paramb = o.bGM(kotlin.l.b.a.b.j.d.a.v(paramb).iEU().qu());
    }
    for (;;)
    {
      kotlin.g.b.p.j(paramb, "when (descriptor) {\n    …name.asString()\n        }");
      localObject = paramb;
      AppMethodBeat.o(56548);
      return localObject;
      label54:
      if ((paramb instanceof aj)) {
        paramb = o.bGN(kotlin.l.b.a.b.j.d.a.v(paramb).iEU().qu());
      } else {
        paramb = paramb.iEU().qu();
      }
    }
  }
  
  static h bS(Class<?> paramClass)
  {
    AppMethodBeat.i(56549);
    if (paramClass.isPrimitive())
    {
      paramClass = kotlin.l.b.a.b.j.e.d.bHm(paramClass.getSimpleName());
      kotlin.g.b.p.j(paramClass, "JvmPrimitiveType.get(simpleName)");
      paramClass = paramClass.iOZ();
      AppMethodBeat.o(56549);
      return paramClass;
    }
    AppMethodBeat.o(56549);
    return null;
  }
  
  public static c c(kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(56545);
    kotlin.g.b.p.k(paramt, "possiblySubstitutedFunction");
    Object localObject1 = kotlin.l.b.a.b.j.c.t((kotlin.l.b.a.b.b.b)paramt);
    kotlin.g.b.p.j(localObject1, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
    kotlin.l.b.a.b.b.t localt = ((kotlin.l.b.a.b.b.t)localObject1).iFh();
    kotlin.g.b.p.j(localt, "DescriptorUtils.unwrapFa…titutedFunction).original");
    if ((localt instanceof kotlin.l.b.a.b.k.a.b.c))
    {
      localObject1 = ((kotlin.l.b.a.b.k.a.b.c)localt).iPA();
      Object localObject2;
      if ((localObject1 instanceof a.h))
      {
        localObject2 = i.abfB;
        localObject2 = i.a((a.h)localObject1, ((kotlin.l.b.a.b.k.a.b.c)localt).iPB(), ((kotlin.l.b.a.b.k.a.b.c)localt).iPC());
        if (localObject2 != null)
        {
          paramt = (c)new c.e((e.b)localObject2);
          AppMethodBeat.o(56545);
          return paramt;
        }
      }
      if ((localObject1 instanceof kotlin.l.b.a.b.e.a.c))
      {
        localObject2 = i.abfB;
        localObject1 = i.a((kotlin.l.b.a.b.e.a.c)localObject1, ((kotlin.l.b.a.b.k.a.b.c)localt).iPB(), ((kotlin.l.b.a.b.k.a.b.c)localt).iPC());
        if (localObject1 != null)
        {
          paramt = paramt.iDJ();
          kotlin.g.b.p.j(paramt, "possiblySubstitutedFunction.containingDeclaration");
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
    if ((localt instanceof kotlin.l.b.a.b.d.a.b.f))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.b.f)localt).iDZ();
      paramt = (kotlin.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (kotlin.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.iGT();; paramt = null)
      {
        localObject1 = paramt;
        if (!(paramt instanceof s)) {
          localObject1 = null;
        }
        paramt = (s)localObject1;
        if (paramt != null)
        {
          paramt = paramt.aaQm;
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
    if ((localt instanceof kotlin.l.b.a.b.d.a.b.c))
    {
      localObject1 = ((kotlin.l.b.a.b.d.a.b.c)localt).iDZ();
      paramt = (kotlin.l.b.a.b.b.t)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramt = null;
      }
      paramt = (kotlin.l.b.a.b.d.a.d.a)paramt;
      if (paramt != null) {}
      for (paramt = paramt.iGT(); (paramt instanceof m); paramt = null)
      {
        paramt = (c)new c.b(((m)paramt).aaQj);
        AppMethodBeat.o(56545);
        return paramt;
      }
      if (((paramt instanceof kotlin.l.b.a.b.b.d.b.j)) && (((kotlin.l.b.a.b.b.d.b.j)paramt).aaPD.isAnnotation()))
      {
        paramt = (c)new c.a(((kotlin.l.b.a.b.b.d.b.j)paramt).aaPD);
        AppMethodBeat.o(56545);
        return paramt;
      }
      paramt = (Throwable)new w("Incorrect resolution sequence for Java constructor " + localt + " (" + paramt + ')');
      AppMethodBeat.o(56545);
      throw paramt;
    }
    if (localt == null) {
      kotlin.l.b.a.b.j.b.aDG(27);
    }
    int i;
    if ((localt.iEU().equals(kotlin.l.b.a.b.j.c.abjY)) && (kotlin.l.b.a.b.j.b.g(localt)))
    {
      i = 1;
      if (i == 0)
      {
        if (localt == null) {
          kotlin.l.b.a.b.j.b.aDG(26);
        }
        if ((!localt.iEU().equals(kotlin.l.b.a.b.j.c.abjX)) || (!kotlin.l.b.a.b.j.b.g(localt))) {
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
      paramt = localt.iEU();
      localObject1 = kotlin.l.b.a.b.a.b.a.aaIE;
      if ((kotlin.g.b.p.h(paramt, kotlin.l.b.a.b.a.b.a.iEl())) && (localt.iEJ().isEmpty())) {
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
    kotlin.g.b.p.k(paramah, "possiblyOverriddenProperty");
    paramah = kotlin.l.b.a.b.j.c.t((kotlin.l.b.a.b.b.b)paramah);
    kotlin.g.b.p.j(paramah, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
    ah localah = ((ah)paramah).iFF();
    kotlin.g.b.p.j(localah, "DescriptorUtils.unwrapFa…rriddenProperty).original");
    Object localObject3;
    if ((localah instanceof kotlin.l.b.a.b.k.a.b.j))
    {
      paramah = ((kotlin.l.b.a.b.k.a.b.j)localah).aaCz;
      localObject2 = (i.c)paramah;
      localObject3 = kotlin.l.b.a.b.e.c.a.abeC;
      kotlin.g.b.p.j(localObject3, "JvmProtoBuf.propertySignature");
      localObject2 = (kotlin.l.b.a.b.e.c.a.c)kotlin.l.b.a.b.e.b.f.a((i.c)localObject2, (i.e)localObject3);
      if (localObject2 != null)
      {
        paramah = (d)new d.c(localah, paramah, (kotlin.l.b.a.b.e.c.a.c)localObject2, ((kotlin.l.b.a.b.k.a.b.j)localah).aaCB, ((kotlin.l.b.a.b.k.a.b.j)localah).aaCC);
        AppMethodBeat.o(56546);
        return paramah;
      }
    }
    else if ((localah instanceof g))
    {
      localObject1 = ((g)localah).iDZ();
      paramah = (ah)localObject1;
      if (!(localObject1 instanceof kotlin.l.b.a.b.d.a.d.a)) {
        paramah = null;
      }
      paramah = (kotlin.l.b.a.b.d.a.d.a)paramah;
      if (paramah != null) {}
      for (paramah = paramah.iGT(); (paramah instanceof kotlin.l.b.a.b.b.d.b.p); paramah = null)
      {
        paramah = (d)new d.a(((kotlin.l.b.a.b.b.d.b.p)paramah).aaQl);
        AppMethodBeat.o(56546);
        return paramah;
      }
      if ((paramah instanceof s))
      {
        localObject3 = ((s)paramah).aaQm;
        paramah = localah.iFD();
        if (paramah != null)
        {
          paramah = paramah.iDZ();
          localObject1 = paramah;
          if (!(paramah instanceof kotlin.l.b.a.b.d.a.d.a)) {
            localObject1 = null;
          }
          paramah = (kotlin.l.b.a.b.d.a.d.a)localObject1;
          if (paramah == null) {
            break label332;
          }
        }
        label332:
        for (paramah = paramah.iGT();; paramah = null)
        {
          localObject1 = paramah;
          if (!(paramah instanceof s)) {
            localObject1 = null;
          }
          localObject1 = (s)localObject1;
          paramah = (ah)localObject2;
          if (localObject1 != null) {
            paramah = ((s)localObject1).aaQm;
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
    paramah = localah.iFC();
    if (paramah == null) {
      kotlin.g.b.p.iCn();
    }
    localObject2 = d((kotlin.l.b.a.b.b.t)paramah);
    paramah = localah.iFD();
    if (paramah != null) {}
    for (paramah = d((kotlin.l.b.a.b.b.t)paramah);; paramah = (ah)localObject1)
    {
      paramah = (d)new d.d((c.e)localObject2, paramah);
      AppMethodBeat.o(56546);
      return paramah;
    }
  }
  
  private static c.e d(kotlin.l.b.a.b.b.t paramt)
  {
    AppMethodBeat.i(56547);
    paramt = new c.e(new e.b(b((kotlin.l.b.a.b.b.b)paramt), kotlin.l.b.a.b.d.b.t.a(paramt, false, false, 1)));
    AppMethodBeat.o(56547);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.ac
 * JD-Core Version:    0.7.0.1
 */