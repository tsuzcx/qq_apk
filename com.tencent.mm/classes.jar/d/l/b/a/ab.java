package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l.b.a.b.b.a;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.t;
import d.l.b.a.b.f.f;
import d.l.b.a.b.i.c;
import d.l.b.a.b.m.bh;
import d.l.j.a;
import java.util.List;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"})
public final class ab
{
  private static final c KXU;
  public static final ab KXV;
  
  static
  {
    AppMethodBeat.i(56544);
    KXV = new ab();
    KXU = c.LCg;
    AppMethodBeat.o(56544);
  }
  
  public static String a(as paramas)
  {
    AppMethodBeat.i(56542);
    k.h(paramas, "typeParameter");
    StringBuilder localStringBuilder = new StringBuilder();
    bh localbh = paramas.fRg();
    switch (ac.fTL[localbh.ordinal()])
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramas.fRf());
      paramas = localStringBuilder.toString();
      k.g(paramas, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56542);
      return paramas;
      localStringBuilder.append("in ");
      continue;
      localStringBuilder.append("out ");
    }
  }
  
  public static String a(t paramt)
  {
    AppMethodBeat.i(56539);
    k.h(paramt, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fun ");
    a(localStringBuilder, (a)paramt);
    Object localObject = KXU;
    f localf = paramt.fRf();
    k.g(localf, "descriptor.name");
    localStringBuilder.append(((c)localObject).b(localf, true));
    localObject = paramt.fQU();
    k.g(localObject, "descriptor.valueParameters");
    j.a((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)a.KXW, 48);
    localStringBuilder.append(": ");
    paramt = paramt.fQS();
    if (paramt == null) {
      k.fOy();
    }
    k.g(paramt, "descriptor.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    k.g(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56539);
    return paramt;
  }
  
  private static void a(StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(56537);
    ak localak = af.a(parama);
    parama = parama.fQP();
    a(paramStringBuilder, localak);
    if ((localak != null) && (parama != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramStringBuilder.append("(");
      }
      a(paramStringBuilder, parama);
      if (i != 0) {
        paramStringBuilder.append(")");
      }
      AppMethodBeat.o(56537);
      return;
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, ak paramak)
  {
    AppMethodBeat.i(56536);
    if (paramak != null)
    {
      paramak = paramak.fRV();
      k.g(paramak, "receiver.type");
      paramStringBuilder.append(b(paramak));
      paramStringBuilder.append(".");
    }
    AppMethodBeat.o(56536);
  }
  
  public static String b(ah paramah)
  {
    AppMethodBeat.i(56538);
    k.h(paramah, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramah.fSc()) {}
    for (Object localObject = "var ";; localObject = "val ")
    {
      localStringBuilder.append((String)localObject);
      a(localStringBuilder, (a)paramah);
      localObject = KXU;
      f localf = paramah.fRf();
      k.g(localf, "descriptor.name");
      localStringBuilder.append(((c)localObject).b(localf, true));
      localStringBuilder.append(": ");
      paramah = paramah.fRV();
      k.g(paramah, "descriptor.type");
      localStringBuilder.append(b(paramah));
      paramah = localStringBuilder.toString();
      k.g(paramah, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56538);
      return paramah;
    }
  }
  
  public static String b(t paramt)
  {
    AppMethodBeat.i(56540);
    k.h(paramt, "invoke");
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, (a)paramt);
    List localList = paramt.fQU();
    k.g(localList, "invoke.valueParameters");
    j.a((Iterable)localList, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)b.KXX, 48);
    localStringBuilder.append(" -> ");
    paramt = paramt.fQS();
    if (paramt == null) {
      k.fOy();
    }
    k.g(paramt, "invoke.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    k.g(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56540);
    return paramt;
  }
  
  public static String b(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56543);
    k.h(paramab, "type");
    paramab = KXU.b(paramab);
    AppMethodBeat.o(56543);
    return paramab;
  }
  
  public static String b(o paramo)
  {
    AppMethodBeat.i(56541);
    k.h(paramo, "parameter");
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = paramo.KXj;
    switch (ac.cfA[locala.ordinal()])
    {
    default: 
      localStringBuilder.append(" of ");
      paramo = (a)paramo.KXi.fON();
      if (!(paramo instanceof ah)) {
        break;
      }
    }
    for (paramo = b((ah)paramo);; paramo = a((t)paramo))
    {
      localStringBuilder.append(paramo);
      paramo = localStringBuilder.toString();
      k.g(paramo, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56541);
      return paramo;
      localStringBuilder.append("extension receiver parameter");
      break;
      localStringBuilder.append("instance parameter");
      break;
      localStringBuilder.append("parameter #" + paramo.index + ' ' + paramo.getName());
      break;
      if (!(paramo instanceof t)) {
        break label198;
      }
    }
    label198:
    paramo = (Throwable)new IllegalStateException("Illegal callable: ".concat(String.valueOf(paramo)).toString());
    AppMethodBeat.o(56541);
    throw paramo;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<av, String>
  {
    public static final a KXW;
    
    static
    {
      AppMethodBeat.i(56533);
      KXW = new a();
      AppMethodBeat.o(56533);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<av, String>
  {
    public static final b KXX;
    
    static
    {
      AppMethodBeat.i(56535);
      KXX = new b();
      AppMethodBeat.o(56535);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.ab
 * JD-Core Version:    0.7.0.1
 */