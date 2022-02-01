package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.t;
import kotlinx.a.b.bj;
import kotlinx.a.c.a;
import kotlinx.a.c.d;
import kotlinx.a.c.u;
import kotlinx.a.g;
import kotlinx.a.g.a;
import kotlinx.a.h;
import kotlinx.a.j;
import kotlinx.a.m;
import kotlinx.a.v;
import kotlinx.a.x.c;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/StreamingJsonOutput;", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/builtins/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "composer", "Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonOutput;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJson", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"})
public final class n
  extends kotlinx.a.a.b
  implements u
{
  private final d TZf;
  private final a Uae;
  private final kotlinx.a.d.b Uar;
  private final r Uas;
  private boolean Uat;
  private boolean Uau;
  private final a Uav;
  private final u[] Uaw;
  
  public n(StringBuilder paramStringBuilder, a parama, r paramr, u[] paramArrayOfu)
  {
    this(new a(paramStringBuilder, parama), parama, paramr, paramArrayOfu);
    AppMethodBeat.i(225695);
    AppMethodBeat.o(225695);
  }
  
  private n(a parama, a parama1, r paramr, u[] paramArrayOfu)
  {
    AppMethodBeat.i(225694);
    this.Uav = parama;
    this.Uae = parama1;
    this.Uas = paramr;
    this.Uaw = paramArrayOfu;
    this.Uar = this.Uae.TZe;
    this.TZf = this.Uae.TZf;
    int i = this.Uas.ordinal();
    if ((this.Uaw[i] != null) || (this.Uaw[i] != (n)this)) {
      this.Uaw[i] = ((u)this);
    }
    AppMethodBeat.o(225694);
  }
  
  public final void F(char paramChar)
  {
    AppMethodBeat.i(225692);
    buE(String.valueOf(paramChar));
    AppMethodBeat.o(225692);
  }
  
  public final void Fb(boolean paramBoolean)
  {
    AppMethodBeat.i(225685);
    if (this.Uat)
    {
      buE(String.valueOf(paramBoolean));
      AppMethodBeat.o(225685);
      return;
    }
    this.Uav.sb.append(paramBoolean);
    AppMethodBeat.o(225685);
  }
  
  public final void O(double paramDouble)
  {
    AppMethodBeat.i(225691);
    if (this.Uat)
    {
      buE(String.valueOf(paramDouble));
      if (this.TZf.TZt) {
        break label120;
      }
      if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
        break label115;
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label120;
      }
      Object localObject = (Number)Double.valueOf(paramDouble);
      String str = this.Uav.sb.toString();
      kotlin.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "double", str);
      AppMethodBeat.o(225691);
      throw ((Throwable)localObject);
      this.Uav.sb.append(paramDouble);
      break;
    }
    label120:
    AppMethodBeat.o(225691);
  }
  
  public final void Pq(long paramLong)
  {
    AppMethodBeat.i(225689);
    if (this.Uat)
    {
      buE(String.valueOf(paramLong));
      AppMethodBeat.o(225689);
      return;
    }
    this.Uav.sb.append(paramLong);
    AppMethodBeat.o(225689);
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(225682);
    kotlin.g.b.p.h(paramn, "descriptor");
    if (this.Uas.UaH != 0)
    {
      paramn = this.Uav;
      paramn.level -= 1;
      this.Uav.hPf();
      this.Uav.H(this.Uas.UaH);
    }
    AppMethodBeat.o(225682);
  }
  
  public final <T> void a(v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(225680);
    kotlin.g.b.p.h(paramv, "serializer");
    if ((!(paramv instanceof kotlinx.a.b.b)) || (hOQ().TZf.TZy))
    {
      paramv.a((g)this, paramT);
      AppMethodBeat.o(225680);
      return;
    }
    Object localObject1 = (kotlinx.a.b.b)paramv;
    Object localObject2 = (g)this;
    if (paramT == null)
    {
      paramv = new t("null cannot be cast to non-null type kotlin.Any");
      AppMethodBeat.o(225680);
      throw paramv;
    }
    localObject1 = ((kotlinx.a.b.b)localObject1).b((g)localObject2, paramT);
    if (localObject1 == null)
    {
      paramv = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(225680);
      throw paramv;
    }
    localObject2 = (h)paramv;
    paramv = hOQ().TZf.TZz;
    if (((localObject2 instanceof m)) && (bj.e(((h)localObject1).fWv()).contains(paramv)))
    {
      paramT = ((h)localObject2).fWv().hOz();
      localObject1 = ((h)localObject1).fWv().hOz();
      paramv = (Throwable)new IllegalStateException(("Sealed class '" + (String)localObject1 + "' cannot be serialized as base class '" + paramT + "' because it has property name that conflicts with JSON class discriminator '" + paramv + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
      AppMethodBeat.o(225680);
      throw paramv;
    }
    paramv = ((h)localObject1).fWv().hOA();
    kotlin.g.b.p.h(paramv, "kind");
    if ((paramv instanceof x.c))
    {
      paramv = (Throwable)new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(225680);
      throw paramv;
    }
    if ((paramv instanceof kotlinx.a.l))
    {
      paramv = (Throwable)new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(225680);
      throw paramv;
    }
    if ((paramv instanceof j))
    {
      paramv = (Throwable)new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
      AppMethodBeat.o(225680);
      throw paramv;
    }
    this.Uau = true;
    ((h)localObject1).a((g)this, paramT);
    AppMethodBeat.o(225680);
  }
  
  public final void awb(int paramInt)
  {
    AppMethodBeat.i(225688);
    if (this.Uat)
    {
      buE(String.valueOf(paramInt));
      AppMethodBeat.o(225688);
      return;
    }
    this.Uav.sb.append(paramInt);
    AppMethodBeat.o(225688);
  }
  
  public final kotlinx.a.b b(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(225681);
    kotlin.g.b.p.h(paramn, "descriptor");
    kotlin.g.b.p.h(paramVarArgs, "typeSerializers");
    paramVarArgs = s.a(this.Uae, paramn);
    if (paramVarArgs.UaG != 0)
    {
      this.Uav.H(paramVarArgs.UaG);
      a locala = this.Uav;
      locala.Uax = true;
      locala.level += 1;
    }
    if (this.Uau)
    {
      this.Uau = false;
      this.Uav.hPf();
      buE(this.TZf.TZz);
      this.Uav.H(':');
      this.Uav.hPg();
      buE(paramn.hOz());
    }
    if (this.Uas == paramVarArgs)
    {
      paramn = (kotlinx.a.b)this;
      AppMethodBeat.o(225681);
      return paramn;
    }
    paramn = this.Uaw[paramVarArgs.ordinal()];
    if (paramn != null)
    {
      paramn = (kotlinx.a.b)paramn;
      AppMethodBeat.o(225681);
      return paramn;
    }
    paramn = (kotlinx.a.b)new n(this.Uav, this.Uae, paramVarArgs, this.Uaw);
    AppMethodBeat.o(225681);
    return paramn;
  }
  
  public final <T> void b(v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(225697);
    kotlin.g.b.p.h(paramv, "serializer");
    kotlin.g.b.p.h(paramv, "serializer");
    g.a.a((g)this, paramv, paramT);
    AppMethodBeat.o(225697);
  }
  
  public final void buE(String paramString)
  {
    AppMethodBeat.i(225693);
    kotlin.g.b.p.h(paramString, "value");
    if ((this.TZf.TZw) && (!p.buT(paramString)))
    {
      this.Uav.buP(paramString);
      AppMethodBeat.o(225693);
      return;
    }
    this.Uav.buQ(paramString);
    AppMethodBeat.o(225693);
  }
  
  public final kotlinx.a.b c(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(225696);
    kotlin.g.b.p.h(paramn, "descriptor");
    kotlin.g.b.p.h(paramVarArgs, "typeSerializers");
    kotlin.g.b.p.h(paramn, "descriptor");
    kotlin.g.b.p.h(paramVarArgs, "typeSerializers");
    paramn = g.a.a((g)this, paramn, paramVarArgs);
    AppMethodBeat.o(225696);
    return paramn;
  }
  
  public final boolean c(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(225679);
    kotlin.g.b.p.h(paramn, "descriptor");
    boolean bool = this.TZf.TZq;
    AppMethodBeat.o(225679);
    return bool;
  }
  
  public final void cU(float paramFloat)
  {
    AppMethodBeat.i(225690);
    if (this.Uat)
    {
      buE(String.valueOf(paramFloat));
      if (this.TZf.TZt) {
        break label119;
      }
      if ((Float.isInfinite(paramFloat)) || (Float.isNaN(paramFloat))) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label119;
      }
      Object localObject = (Number)Float.valueOf(paramFloat);
      String str = this.Uav.sb.toString();
      kotlin.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "float", str);
      AppMethodBeat.o(225690);
      throw ((Throwable)localObject);
      this.Uav.sb.append(paramFloat);
      break;
    }
    label119:
    AppMethodBeat.o(225690);
  }
  
  public final void d(short paramShort)
  {
    AppMethodBeat.i(225687);
    if (this.Uat)
    {
      buE(String.valueOf(paramShort));
      AppMethodBeat.o(225687);
      return;
    }
    this.Uav.sb.append(Short.valueOf(paramShort));
    AppMethodBeat.o(225687);
  }
  
  public final a hOQ()
  {
    return this.Uae;
  }
  
  public final kotlinx.a.d.b hOk()
  {
    return this.Uar;
  }
  
  public final void hOx()
  {
    AppMethodBeat.i(225684);
    this.Uav.buP("null");
    AppMethodBeat.o(225684);
  }
  
  public final boolean j(kotlinx.a.n paramn, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(225683);
    kotlin.g.b.p.h(paramn, "descriptor");
    r localr = this.Uas;
    switch (o.$EnumSwitchMapping$0[localr.ordinal()])
    {
    default: 
      if (!this.Uav.Uax) {
        this.Uav.H(',');
      }
      this.Uav.hPf();
      buE(paramn.awc(paramInt));
      this.Uav.H(':');
      this.Uav.hPg();
    }
    for (;;)
    {
      AppMethodBeat.o(225683);
      return true;
      if (!this.Uav.Uax) {
        this.Uav.H(',');
      }
      this.Uav.hPf();
      continue;
      if (!this.Uav.Uax)
      {
        if (paramInt % 2 == 0)
        {
          this.Uav.H(',');
          this.Uav.hPf();
          bool = true;
        }
        for (;;)
        {
          this.Uat = bool;
          break;
          this.Uav.H(':');
          this.Uav.hPg();
        }
      }
      this.Uat = true;
      this.Uav.hPf();
      continue;
      if (paramInt == 0) {
        this.Uat = true;
      }
      if (paramInt == 1)
      {
        this.Uav.H(',');
        this.Uav.hPg();
        this.Uat = false;
      }
    }
  }
  
  public final void m(byte paramByte)
  {
    AppMethodBeat.i(225686);
    if (this.Uat)
    {
      buE(String.valueOf(paramByte));
      AppMethodBeat.o(225686);
      return;
    }
    this.Uav.sb.append(Byte.valueOf(paramByte));
    AppMethodBeat.o(225686);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"})
  public static final class a
  {
    private final a Uae;
    boolean Uax;
    int level;
    public final StringBuilder sb;
    
    public a(StringBuilder paramStringBuilder, a parama)
    {
      AppMethodBeat.i(225709);
      this.sb = paramStringBuilder;
      this.Uae = parama;
      this.Uax = true;
      AppMethodBeat.o(225709);
    }
    
    public final StringBuilder H(char paramChar)
    {
      AppMethodBeat.i(225706);
      StringBuilder localStringBuilder = this.sb.append(paramChar);
      AppMethodBeat.o(225706);
      return localStringBuilder;
    }
    
    public final StringBuilder buP(String paramString)
    {
      AppMethodBeat.i(225707);
      kotlin.g.b.p.h(paramString, "v");
      paramString = this.sb.append(paramString);
      AppMethodBeat.o(225707);
      return paramString;
    }
    
    public final void buQ(String paramString)
    {
      AppMethodBeat.i(225708);
      kotlin.g.b.p.h(paramString, "value");
      p.b(this.sb, paramString);
      AppMethodBeat.o(225708);
    }
    
    public final void hPf()
    {
      int i = 0;
      AppMethodBeat.i(225704);
      this.Uax = false;
      if (this.Uae.TZf.TZv)
      {
        buP("\n");
        int j = this.level;
        while (i < j)
        {
          buP(this.Uae.TZf.TZx);
          i += 1;
        }
      }
      AppMethodBeat.o(225704);
    }
    
    public final void hPg()
    {
      AppMethodBeat.i(225705);
      if (this.Uae.TZf.TZv) {
        H(' ');
      }
      AppMethodBeat.o(225705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */