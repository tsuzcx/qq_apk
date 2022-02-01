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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/StreamingJsonOutput;", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/builtins/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "composer", "Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonOutput;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJson", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"})
public final class n
  extends kotlinx.a.a.b
  implements u
{
  private final d abCv;
  private final kotlinx.a.d.b abDF;
  private final r abDG;
  private boolean abDH;
  private boolean abDI;
  private final a abDJ;
  private final u[] abDK;
  private final a abDs;
  
  public n(StringBuilder paramStringBuilder, a parama, r paramr, u[] paramArrayOfu)
  {
    this(new a(paramStringBuilder, parama), parama, paramr, paramArrayOfu);
    AppMethodBeat.i(255992);
    AppMethodBeat.o(255992);
  }
  
  private n(a parama, a parama1, r paramr, u[] paramArrayOfu)
  {
    AppMethodBeat.i(255991);
    this.abDJ = parama;
    this.abDs = parama1;
    this.abDG = paramr;
    this.abDK = paramArrayOfu;
    this.abDF = this.abDs.abCu;
    this.abCv = this.abDs.abCv;
    int i = this.abDG.ordinal();
    if ((this.abDK[i] != null) || (this.abDK[i] != (n)this)) {
      this.abDK[i] = ((u)this);
    }
    AppMethodBeat.o(255991);
  }
  
  public final void JK(boolean paramBoolean)
  {
    AppMethodBeat.i(255975);
    if (this.abDH)
    {
      bHH(String.valueOf(paramBoolean));
      AppMethodBeat.o(255975);
      return;
    }
    this.abDJ.sb.append(paramBoolean);
    AppMethodBeat.o(255975);
  }
  
  public final void Q(char paramChar)
  {
    AppMethodBeat.i(255987);
    bHH(String.valueOf(paramChar));
    AppMethodBeat.o(255987);
  }
  
  public final void Q(double paramDouble)
  {
    AppMethodBeat.i(255985);
    if (this.abDH)
    {
      bHH(String.valueOf(paramDouble));
      if (this.abCv.bLc) {
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
      String str = this.abDJ.sb.toString();
      kotlin.g.b.p.j(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "double", str);
      AppMethodBeat.o(255985);
      throw ((Throwable)localObject);
      this.abDJ.sb.append(paramDouble);
      break;
    }
    label120:
    AppMethodBeat.o(255985);
  }
  
  public final void XG(long paramLong)
  {
    AppMethodBeat.i(255980);
    if (this.abDH)
    {
      bHH(String.valueOf(paramLong));
      AppMethodBeat.o(255980);
      return;
    }
    this.abDJ.sb.append(paramLong);
    AppMethodBeat.o(255980);
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(255968);
    kotlin.g.b.p.k(paramn, "descriptor");
    if (this.abDG.abDV != 0)
    {
      paramn = this.abDJ;
      paramn.level -= 1;
      this.abDJ.iUm();
      this.abDJ.S(this.abDG.abDV);
    }
    AppMethodBeat.o(255968);
  }
  
  public final <T> void a(v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(255963);
    kotlin.g.b.p.k(paramv, "serializer");
    if ((!(paramv instanceof kotlinx.a.b.b)) || (iTX().abCv.abCM))
    {
      paramv.a((g)this, paramT);
      AppMethodBeat.o(255963);
      return;
    }
    Object localObject1 = (kotlinx.a.b.b)paramv;
    Object localObject2 = (g)this;
    if (paramT == null)
    {
      paramv = new t("null cannot be cast to non-null type kotlin.Any");
      AppMethodBeat.o(255963);
      throw paramv;
    }
    localObject1 = ((kotlinx.a.b.b)localObject1).b((g)localObject2, paramT);
    if (localObject1 == null)
    {
      paramv = new t("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(255963);
      throw paramv;
    }
    localObject2 = (h)paramv;
    paramv = iTX().abCv.abCN;
    if (((localObject2 instanceof m)) && (bj.e(((h)localObject1).gPe()).contains(paramv)))
    {
      paramT = ((h)localObject2).gPe().iTF();
      localObject1 = ((h)localObject1).gPe().iTF();
      paramv = (Throwable)new IllegalStateException(("Sealed class '" + (String)localObject1 + "' cannot be serialized as base class '" + paramT + "' because it has property name that conflicts with JSON class discriminator '" + paramv + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
      AppMethodBeat.o(255963);
      throw paramv;
    }
    paramv = ((h)localObject1).gPe().iTG();
    kotlin.g.b.p.k(paramv, "kind");
    if ((paramv instanceof x.c))
    {
      paramv = (Throwable)new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(255963);
      throw paramv;
    }
    if ((paramv instanceof kotlinx.a.l))
    {
      paramv = (Throwable)new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(255963);
      throw paramv;
    }
    if ((paramv instanceof j))
    {
      paramv = (Throwable)new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
      AppMethodBeat.o(255963);
      throw paramv;
    }
    this.abDI = true;
    ((h)localObject1).a((g)this, paramT);
    AppMethodBeat.o(255963);
  }
  
  public final void aFW(int paramInt)
  {
    AppMethodBeat.i(255979);
    if (this.abDH)
    {
      bHH(String.valueOf(paramInt));
      AppMethodBeat.o(255979);
      return;
    }
    this.abDJ.sb.append(paramInt);
    AppMethodBeat.o(255979);
  }
  
  public final kotlinx.a.b b(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(255966);
    kotlin.g.b.p.k(paramn, "descriptor");
    kotlin.g.b.p.k(paramVarArgs, "typeSerializers");
    paramVarArgs = s.a(this.abDs, paramn);
    if (paramVarArgs.abDU != 0)
    {
      this.abDJ.S(paramVarArgs.abDU);
      a locala = this.abDJ;
      locala.abDL = true;
      locala.level += 1;
    }
    if (this.abDI)
    {
      this.abDI = false;
      this.abDJ.iUm();
      bHH(this.abCv.abCN);
      this.abDJ.S(':');
      this.abDJ.iUn();
      bHH(paramn.iTF());
    }
    if (this.abDG == paramVarArgs)
    {
      paramn = (kotlinx.a.b)this;
      AppMethodBeat.o(255966);
      return paramn;
    }
    paramn = this.abDK[paramVarArgs.ordinal()];
    if (paramn != null)
    {
      paramn = (kotlinx.a.b)paramn;
      AppMethodBeat.o(255966);
      return paramn;
    }
    paramn = (kotlinx.a.b)new n(this.abDJ, this.abDs, paramVarArgs, this.abDK);
    AppMethodBeat.o(255966);
    return paramn;
  }
  
  public final <T> void b(v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(255994);
    kotlin.g.b.p.k(paramv, "serializer");
    kotlin.g.b.p.k(paramv, "serializer");
    g.a.a((g)this, paramv, paramT);
    AppMethodBeat.o(255994);
  }
  
  public final void bHH(String paramString)
  {
    AppMethodBeat.i(255989);
    kotlin.g.b.p.k(paramString, "value");
    if ((this.abCv.abCL) && (!p.bHW(paramString)))
    {
      this.abDJ.bHS(paramString);
      AppMethodBeat.o(255989);
      return;
    }
    this.abDJ.bHT(paramString);
    AppMethodBeat.o(255989);
  }
  
  public final kotlinx.a.b c(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(255993);
    kotlin.g.b.p.k(paramn, "descriptor");
    kotlin.g.b.p.k(paramVarArgs, "typeSerializers");
    kotlin.g.b.p.k(paramn, "descriptor");
    kotlin.g.b.p.k(paramVarArgs, "typeSerializers");
    paramn = g.a.a((g)this, paramn, paramVarArgs);
    AppMethodBeat.o(255993);
    return paramn;
  }
  
  public final boolean c(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(255962);
    kotlin.g.b.p.k(paramn, "descriptor");
    boolean bool = this.abCv.abCG;
    AppMethodBeat.o(255962);
    return bool;
  }
  
  public final void jdMethod_do(float paramFloat)
  {
    AppMethodBeat.i(255983);
    if (this.abDH)
    {
      bHH(String.valueOf(paramFloat));
      if (this.abCv.bLc) {
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
      String str = this.abDJ.sb.toString();
      kotlin.g.b.p.j(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "float", str);
      AppMethodBeat.o(255983);
      throw ((Throwable)localObject);
      this.abDJ.sb.append(paramFloat);
      break;
    }
    label119:
    AppMethodBeat.o(255983);
  }
  
  public final void e(short paramShort)
  {
    AppMethodBeat.i(255977);
    if (this.abDH)
    {
      bHH(String.valueOf(paramShort));
      AppMethodBeat.o(255977);
      return;
    }
    this.abDJ.sb.append(Short.valueOf(paramShort));
    AppMethodBeat.o(255977);
  }
  
  public final void iTD()
  {
    AppMethodBeat.i(255974);
    this.abDJ.bHS("null");
    AppMethodBeat.o(255974);
  }
  
  public final a iTX()
  {
    return this.abDs;
  }
  
  public final kotlinx.a.d.b iTq()
  {
    return this.abDF;
  }
  
  public final boolean j(kotlinx.a.n paramn, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(255972);
    kotlin.g.b.p.k(paramn, "descriptor");
    r localr = this.abDG;
    switch (o.$EnumSwitchMapping$0[localr.ordinal()])
    {
    default: 
      if (!this.abDJ.abDL) {
        this.abDJ.S(',');
      }
      this.abDJ.iUm();
      bHH(paramn.aFX(paramInt));
      this.abDJ.S(':');
      this.abDJ.iUn();
    }
    for (;;)
    {
      AppMethodBeat.o(255972);
      return true;
      if (!this.abDJ.abDL) {
        this.abDJ.S(',');
      }
      this.abDJ.iUm();
      continue;
      if (!this.abDJ.abDL)
      {
        if (paramInt % 2 == 0)
        {
          this.abDJ.S(',');
          this.abDJ.iUm();
          bool = true;
        }
        for (;;)
        {
          this.abDH = bool;
          break;
          this.abDJ.S(':');
          this.abDJ.iUn();
        }
      }
      this.abDH = true;
      this.abDJ.iUm();
      continue;
      if (paramInt == 0) {
        this.abDH = true;
      }
      if (paramInt == 1)
      {
        this.abDJ.S(',');
        this.abDJ.iUn();
        this.abDH = false;
      }
    }
  }
  
  public final void m(byte paramByte)
  {
    AppMethodBeat.i(255976);
    if (this.abDH)
    {
      bHH(String.valueOf(paramByte));
      AppMethodBeat.o(255976);
      return;
    }
    this.abDJ.sb.append(Byte.valueOf(paramByte));
    AppMethodBeat.o(255976);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"})
  public static final class a
  {
    boolean abDL;
    private final a abDs;
    int level;
    public final StringBuilder sb;
    
    public a(StringBuilder paramStringBuilder, a parama)
    {
      AppMethodBeat.i(256097);
      this.sb = paramStringBuilder;
      this.abDs = parama;
      this.abDL = true;
      AppMethodBeat.o(256097);
    }
    
    public final StringBuilder S(char paramChar)
    {
      AppMethodBeat.i(256092);
      StringBuilder localStringBuilder = this.sb.append(paramChar);
      AppMethodBeat.o(256092);
      return localStringBuilder;
    }
    
    public final StringBuilder bHS(String paramString)
    {
      AppMethodBeat.i(256094);
      kotlin.g.b.p.k(paramString, "v");
      paramString = this.sb.append(paramString);
      AppMethodBeat.o(256094);
      return paramString;
    }
    
    public final void bHT(String paramString)
    {
      AppMethodBeat.i(256096);
      kotlin.g.b.p.k(paramString, "value");
      p.b(this.sb, paramString);
      AppMethodBeat.o(256096);
    }
    
    public final void iUm()
    {
      int i = 0;
      AppMethodBeat.i(256089);
      this.abDL = false;
      if (this.abDs.abCv.abCK)
      {
        bHS("\n");
        int j = this.level;
        while (i < j)
        {
          bHS(this.abDs.abCv.bOW);
          i += 1;
        }
      }
      AppMethodBeat.o(256089);
    }
    
    public final void iUn()
    {
      AppMethodBeat.i(256091);
      if (this.abDs.abCv.abCK) {
        S(' ');
      }
      AppMethodBeat.o(256091);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */