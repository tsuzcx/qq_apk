package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.m.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"})
public final class aa
{
  private static final c aaEy;
  public static final aa aaEz;
  
  static
  {
    AppMethodBeat.i(56544);
    aaEz = new aa();
    aaEy = c.abhK;
    AppMethodBeat.o(56544);
  }
  
  public static String a(as paramas)
  {
    AppMethodBeat.i(56542);
    p.k(paramas, "typeParameter");
    StringBuilder localStringBuilder = new StringBuilder();
    bh localbh = paramas.iEW();
    switch (ab.jLJ[localbh.ordinal()])
    {
    }
    for (;;)
    {
      localStringBuilder.append(paramas.iEU());
      paramas = localStringBuilder.toString();
      p.j(paramas, "StringBuilder().apply(builderAction).toString()");
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
    p.k(paramt, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fun ");
    a(localStringBuilder, (a)paramt);
    Object localObject = aaEy;
    f localf = paramt.iEU();
    p.j(localf, "descriptor.name");
    localStringBuilder.append(((c)localObject).b(localf, true));
    localObject = paramt.iEJ();
    p.j(localObject, "descriptor.valueParameters");
    j.a((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)a.aaEA, 48);
    localStringBuilder.append(": ");
    paramt = paramt.iEH();
    if (paramt == null) {
      p.iCn();
    }
    p.j(paramt, "descriptor.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    p.j(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56539);
    return paramt;
  }
  
  private static void a(StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(56537);
    ak localak = ae.a(parama);
    parama = parama.iEE();
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
      paramak = paramak.iFN();
      p.j(paramak, "receiver.type");
      paramStringBuilder.append(b(paramak));
      paramStringBuilder.append(".");
    }
    AppMethodBeat.o(56536);
  }
  
  public static String b(ah paramah)
  {
    AppMethodBeat.i(56538);
    p.k(paramah, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramah.iFU()) {}
    for (Object localObject = "var ";; localObject = "val ")
    {
      localStringBuilder.append((String)localObject);
      a(localStringBuilder, (a)paramah);
      localObject = aaEy;
      f localf = paramah.iEU();
      p.j(localf, "descriptor.name");
      localStringBuilder.append(((c)localObject).b(localf, true));
      localStringBuilder.append(": ");
      paramah = paramah.iFN();
      p.j(paramah, "descriptor.type");
      localStringBuilder.append(b(paramah));
      paramah = localStringBuilder.toString();
      p.j(paramah, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56538);
      return paramah;
    }
  }
  
  public static String b(t paramt)
  {
    AppMethodBeat.i(56540);
    p.k(paramt, "invoke");
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, (a)paramt);
    List localList = paramt.iEJ();
    p.j(localList, "invoke.valueParameters");
    j.a((Iterable)localList, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)b.aaEB, 48);
    localStringBuilder.append(" -> ");
    paramt = paramt.iEH();
    if (paramt == null) {
      p.iCn();
    }
    p.j(paramt, "invoke.returnType!!");
    localStringBuilder.append(b(paramt));
    paramt = localStringBuilder.toString();
    p.j(paramt, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56540);
    return paramt;
  }
  
  public static String b(ab paramab)
  {
    AppMethodBeat.i(56543);
    p.k(paramab, "type");
    paramab = aaEy.b(paramab);
    AppMethodBeat.o(56543);
    return paramab;
  }
  
  public static String b(n paramn)
  {
    AppMethodBeat.i(56541);
    p.k(paramn, "parameter");
    StringBuilder localStringBuilder = new StringBuilder();
    m.a locala = paramn.aaDN;
    switch (ab.$EnumSwitchMapping$0[locala.ordinal()])
    {
    default: 
      localStringBuilder.append(" of ");
      paramn = (a)paramn.aaDM.iCD();
      if (!(paramn instanceof ah)) {
        break;
      }
    }
    for (paramn = b((ah)paramn);; paramn = a((t)paramn))
    {
      localStringBuilder.append(paramn);
      paramn = localStringBuilder.toString();
      p.j(paramn, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56541);
      return paramn;
      localStringBuilder.append("extension receiver parameter");
      break;
      localStringBuilder.append("instance parameter");
      break;
      localStringBuilder.append("parameter #" + paramn.index + ' ' + paramn.getName());
      break;
      if (!(paramn instanceof t)) {
        break label198;
      }
    }
    label198:
    paramn = (Throwable)new IllegalStateException("Illegal callable: ".concat(String.valueOf(paramn)).toString());
    AppMethodBeat.o(56541);
    throw paramn;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements b<av, String>
  {
    public static final a aaEA;
    
    static
    {
      AppMethodBeat.i(56533);
      aaEA = new a();
      AppMethodBeat.o(56533);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements b<av, String>
  {
    public static final b aaEB;
    
    static
    {
      AppMethodBeat.i(56535);
      aaEB = new b();
      AppMethodBeat.o(56535);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.aa
 * JD-Core Version:    0.7.0.1
 */