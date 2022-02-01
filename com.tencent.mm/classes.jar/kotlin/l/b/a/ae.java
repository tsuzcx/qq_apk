package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.n.a;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "renderFunction", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "renderType", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class ae
{
  private static final c aiAq;
  public static final ae aiAr;
  
  static
  {
    AppMethodBeat.i(56544);
    aiAr = new ae();
    aiAq = c.ajgy;
    AppMethodBeat.o(56544);
  }
  
  public static String a(x paramx)
  {
    AppMethodBeat.i(56539);
    s.u(paramx, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fun ");
    a(localStringBuilder, (a)paramx);
    Object localObject = aiAq;
    kotlin.l.b.a.b.f.f localf = paramx.kok();
    s.s(localf, "descriptor.name");
    localStringBuilder.append(((c)localObject).b(localf, true));
    localObject = paramx.kod();
    s.s(localObject, "descriptor.valueParameters");
    kotlin.a.p.a((Iterable)localObject, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)a.aiAs, 48);
    localStringBuilder.append(": ");
    paramx = paramx.kob();
    s.checkNotNull(paramx);
    s.s(paramx, "descriptor.returnType!!");
    localStringBuilder.append(b(paramx));
    paramx = localStringBuilder.toString();
    s.s(paramx, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56539);
    return paramx;
  }
  
  private static void a(StringBuilder paramStringBuilder, a parama)
  {
    AppMethodBeat.i(56537);
    as localas = ai.a(parama);
    parama = parama.knY();
    a(paramStringBuilder, localas);
    if ((localas != null) && (parama != null)) {}
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
  
  private static void a(StringBuilder paramStringBuilder, as paramas)
  {
    AppMethodBeat.i(56536);
    if (paramas != null)
    {
      paramas = paramas.koG();
      s.s(paramas, "receiver.type");
      paramStringBuilder.append(b(paramas));
      paramStringBuilder.append(".");
    }
    AppMethodBeat.o(56536);
  }
  
  public static String b(ap paramap)
  {
    AppMethodBeat.i(56538);
    s.u(paramap, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramap.kpu()) {}
    for (Object localObject = "var ";; localObject = "val ")
    {
      localStringBuilder.append((String)localObject);
      a(localStringBuilder, (a)paramap);
      localObject = aiAq;
      kotlin.l.b.a.b.f.f localf = paramap.kok();
      s.s(localf, "descriptor.name");
      localStringBuilder.append(((c)localObject).b(localf, true));
      localStringBuilder.append(": ");
      paramap = paramap.koG();
      s.s(paramap, "descriptor.type");
      localStringBuilder.append(b(paramap));
      paramap = localStringBuilder.toString();
      s.s(paramap, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56538);
      return paramap;
    }
  }
  
  public static String b(x paramx)
  {
    AppMethodBeat.i(56540);
    s.u(paramx, "invoke");
    StringBuilder localStringBuilder = new StringBuilder();
    a(localStringBuilder, (a)paramx);
    List localList = paramx.kod();
    s.s(localList, "invoke.valueParameters");
    kotlin.a.p.a((Iterable)localList, (Appendable)localStringBuilder, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (b)b.aiAt, 48);
    localStringBuilder.append(" -> ");
    paramx = paramx.kob();
    s.checkNotNull(paramx);
    s.s(paramx, "invoke.returnType!!");
    localStringBuilder.append(b(paramx));
    paramx = localStringBuilder.toString();
    s.s(paramx, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(56540);
    return paramx;
  }
  
  public static String b(ad paramad)
  {
    AppMethodBeat.i(56543);
    s.u(paramad, "type");
    paramad = aiAq.b(paramad);
    AppMethodBeat.o(56543);
    return paramad;
  }
  
  public static String b(p paramp)
  {
    AppMethodBeat.i(56541);
    s.u(paramp, "parameter");
    StringBuilder localStringBuilder = new StringBuilder();
    n.a locala = paramp.aizE;
    switch (af.$EnumSwitchMapping$0[locala.ordinal()])
    {
    default: 
      localStringBuilder.append(" of ");
      paramp = (a)paramp.aizD.klV();
      if (!(paramp instanceof ap)) {
        break;
      }
    }
    for (paramp = b((ap)paramp);; paramp = a((x)paramp))
    {
      localStringBuilder.append(paramp);
      paramp = localStringBuilder.toString();
      s.s(paramp, "StringBuilder().apply(builderAction).toString()");
      AppMethodBeat.o(56541);
      return paramp;
      localStringBuilder.append("extension receiver parameter");
      break;
      localStringBuilder.append("instance parameter");
      break;
      localStringBuilder.append("parameter #" + paramp.index + ' ' + paramp.getName());
      break;
      if (!(paramp instanceof x)) {
        break label195;
      }
    }
    label195:
    paramp = (Throwable)new IllegalStateException("Illegal callable: ".concat(String.valueOf(paramp)).toString());
    AppMethodBeat.o(56541);
    throw paramp;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements b<bd, CharSequence>
  {
    public static final a aiAs;
    
    static
    {
      AppMethodBeat.i(56533);
      aiAs = new a();
      AppMethodBeat.o(56533);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements b<bd, CharSequence>
  {
    public static final b aiAt;
    
    static
    {
      AppMethodBeat.i(56535);
      aiAt = new b();
      AppMethodBeat.o(56535);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.ae
 * JD-Core Version:    0.7.0.1
 */