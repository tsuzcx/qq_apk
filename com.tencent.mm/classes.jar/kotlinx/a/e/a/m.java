package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.e;
import kotlinx.a.c.d;
import kotlinx.a.c.f;
import kotlinx.a.c.f.a;
import kotlinx.a.e.a;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/StreamingJsonEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "composer", "Lkotlinx/serialization/json/internal/StreamingJsonEncoder$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonEncoder$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonEncoder;)V", "configuration", "Lkotlinx/serialization/json/internal/JsonConf;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonEncoder;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJsonElement", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class m
  extends kotlinx.a.c.b
  implements kotlinx.a.e.g
{
  private final kotlinx.a.f.b ajEA;
  private final q ajEK;
  private boolean ajEL;
  private boolean ajEM;
  private final a ajEN;
  private final kotlinx.a.e.g[] ajEO;
  private final c ajEb;
  private final a ajEm;
  
  public m(StringBuilder paramStringBuilder, a parama, q paramq, kotlinx.a.e.g[] paramArrayOfg)
  {
    this(new a(paramStringBuilder, parama), parama, paramq, paramArrayOfg);
    AppMethodBeat.i(188521);
    AppMethodBeat.o(188521);
  }
  
  private m(a parama, a parama1, q paramq, kotlinx.a.e.g[] paramArrayOfg)
  {
    AppMethodBeat.i(188511);
    this.ajEN = parama;
    this.ajEm = parama1;
    this.ajEK = paramq;
    this.ajEO = paramArrayOfg;
    this.ajEA = this.ajEm.ajEb.ajEA;
    this.ajEb = this.ajEm.ajEb;
    int i = this.ajEK.ordinal();
    if ((this.ajEO[i] != null) || (this.ajEO[i] != (m)this)) {
      this.ajEO[i] = ((kotlinx.a.e.g)this);
    }
    AppMethodBeat.o(188511);
  }
  
  public final void BS(long paramLong)
  {
    AppMethodBeat.i(188677);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramLong));
      AppMethodBeat.o(188677);
      return;
    }
    this.ajEN.sb.append(paramLong);
    AppMethodBeat.o(188677);
  }
  
  public final void K(char paramChar)
  {
    AppMethodBeat.i(188717);
    bJO(String.valueOf(paramChar));
    AppMethodBeat.o(188717);
  }
  
  public final void PO(boolean paramBoolean)
  {
    AppMethodBeat.i(188624);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramBoolean));
      AppMethodBeat.o(188624);
      return;
    }
    this.ajEN.sb.append(paramBoolean);
    AppMethodBeat.o(188624);
  }
  
  public final <T> void a(kotlinx.a.g<? super T> paramg, T paramT)
  {
    AppMethodBeat.i(188559);
    s.u(paramg, "serializer");
    if ((!(paramg instanceof kotlinx.a.d.b)) || (kFA().ajEb.ajEx))
    {
      paramg.a((f)this, paramT);
      AppMethodBeat.o(188559);
      return;
    }
    Object localObject = (kotlinx.a.d.b)paramg;
    f localf = (f)this;
    if (paramT == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlin.Any");
      AppMethodBeat.o(188559);
      throw paramg;
    }
    localObject = ((kotlinx.a.d.b)localObject).b(localf, paramT);
    if (localObject == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T>");
      AppMethodBeat.o(188559);
      throw paramg;
    }
    j.a(paramg, (kotlinx.a.g)localObject, kFA().ajEb.ajEy);
    j.a(((kotlinx.a.g)localObject).iou().kFd());
    this.ajEM = true;
    ((kotlinx.a.g)localObject).a((f)this, paramT);
    AppMethodBeat.o(188559);
  }
  
  public final void aML(int paramInt)
  {
    AppMethodBeat.i(188665);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramInt));
      AppMethodBeat.o(188665);
      return;
    }
    this.ajEN.sb.append(paramInt);
    AppMethodBeat.o(188665);
  }
  
  public final void al(double paramDouble)
  {
    AppMethodBeat.i(188704);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramDouble));
      if (this.ajEb.ajEz) {
        break label124;
      }
      if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
        break label119;
      }
    }
    label119:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label124;
      }
      Object localObject = (Number)Double.valueOf(paramDouble);
      String str = this.ajEN.sb.toString();
      s.s(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.e.j.a((Number)localObject, "double", str);
      AppMethodBeat.o(188704);
      throw ((Throwable)localObject);
      this.ajEN.sb.append(paramDouble);
      break;
    }
    label124:
    AppMethodBeat.o(188704);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(188586);
    s.u(parame, "descriptor");
    if (this.ajEK.ajEZ != 0)
    {
      parame = this.ajEN;
      parame.level -= 1;
      this.ajEN.kFN();
      this.ajEN.M(this.ajEK.ajEZ);
    }
    AppMethodBeat.o(188586);
  }
  
  public final <T> void b(kotlinx.a.g<? super T> paramg, T paramT)
  {
    AppMethodBeat.i(188763);
    s.u(paramg, "serializer");
    s.u(paramg, "serializer");
    f.a.a((f)this, paramg, paramT);
    AppMethodBeat.o(188763);
  }
  
  public final void bJO(String paramString)
  {
    AppMethodBeat.i(188726);
    s.u(paramString, "value");
    this.ajEN.bJZ(paramString);
    AppMethodBeat.o(188726);
  }
  
  public final d c(e parame, kotlinx.a.b<?>... paramVarArgs)
  {
    AppMethodBeat.i(188756);
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeSerializers");
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeSerializers");
    parame = f.a.a((f)this, parame, paramVarArgs);
    AppMethodBeat.o(188756);
    return parame;
  }
  
  public final boolean c(e parame, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(188598);
    s.u(parame, "descriptor");
    q localq = this.ajEK;
    switch (n.$EnumSwitchMapping$0[localq.ordinal()])
    {
    default: 
      if (!this.ajEN.ajEP) {
        this.ajEN.M(',');
      }
      this.ajEN.kFN();
      bJO(parame.aMK(paramInt));
      this.ajEN.M(':');
      this.ajEN.kFO();
    }
    for (;;)
    {
      AppMethodBeat.o(188598);
      return true;
      if (!this.ajEN.ajEP) {
        this.ajEN.M(',');
      }
      this.ajEN.kFN();
      continue;
      if (!this.ajEN.ajEP)
      {
        if (paramInt % 2 == 0)
        {
          this.ajEN.M(',');
          this.ajEN.kFN();
          bool = true;
        }
        for (;;)
        {
          this.ajEL = bool;
          break;
          this.ajEN.M(':');
          this.ajEN.kFO();
        }
      }
      this.ajEL = true;
      this.ajEN.kFN();
      continue;
      if (paramInt == 0) {
        this.ajEL = true;
      }
      if (paramInt == 1)
      {
        this.ajEN.M(',');
        this.ajEN.kFO();
        this.ajEL = false;
      }
    }
  }
  
  public final d d(e parame, int paramInt)
  {
    AppMethodBeat.i(188746);
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    parame = f.a.a((f)this, parame, paramInt);
    AppMethodBeat.o(188746);
    return parame;
  }
  
  public final d e(e parame)
  {
    AppMethodBeat.i(188574);
    s.u(parame, "descriptor");
    q localq = r.a(this.ajEm, parame);
    if (localq.ajEY != 0)
    {
      this.ajEN.M(localq.ajEY);
      a locala = this.ajEN;
      locala.ajEP = true;
      locala.level += 1;
    }
    if (this.ajEM)
    {
      this.ajEM = false;
      this.ajEN.kFN();
      bJO(this.ajEb.ajEy);
      this.ajEN.M(':');
      this.ajEN.kFO();
      bJO(parame.kFa());
    }
    if (this.ajEK == localq)
    {
      parame = (d)this;
      AppMethodBeat.o(188574);
      return parame;
    }
    parame = this.ajEO[localq.ordinal()];
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(188574);
      return parame;
    }
    parame = (d)new m(this.ajEN, this.ajEm, localq, this.ajEO);
    AppMethodBeat.o(188574);
    return parame;
  }
  
  public final void eJ(float paramFloat)
  {
    AppMethodBeat.i(188691);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramFloat));
      if (this.ajEb.ajEz) {
        break label120;
      }
      if ((Float.isInfinite(paramFloat)) || (Float.isNaN(paramFloat))) {
        break label115;
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label120;
      }
      Object localObject = (Number)Float.valueOf(paramFloat);
      String str = this.ajEN.sb.toString();
      s.s(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.e.j.a((Number)localObject, "float", str);
      AppMethodBeat.o(188691);
      throw ((Throwable)localObject);
      this.ajEN.sb.append(paramFloat);
      break;
    }
    label120:
    AppMethodBeat.o(188691);
  }
  
  public final boolean f(e parame)
  {
    AppMethodBeat.i(188543);
    s.u(parame, "descriptor");
    boolean bool = this.ajEb.ajEq;
    AppMethodBeat.o(188543);
    return bool;
  }
  
  public final void i(short paramShort)
  {
    AppMethodBeat.i(188654);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramShort));
      AppMethodBeat.o(188654);
      return;
    }
    this.ajEN.sb.append(Short.valueOf(paramShort));
    AppMethodBeat.o(188654);
  }
  
  public final a kFA()
  {
    return this.ajEm;
  }
  
  public final kotlinx.a.f.b kFe()
  {
    return this.ajEA;
  }
  
  public final void kFs()
  {
    AppMethodBeat.i(188610);
    this.ajEN.bJY("null");
    AppMethodBeat.o(188610);
  }
  
  public final void q(byte paramByte)
  {
    AppMethodBeat.i(188639);
    if (this.ajEL)
    {
      bJO(String.valueOf(paramByte));
      AppMethodBeat.o(188639);
      return;
    }
    this.ajEN.sb.append(Byte.valueOf(paramByte));
    AppMethodBeat.o(188639);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/StreamingJsonEncoder$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a
  {
    boolean ajEP;
    private final a ajEm;
    int level;
    public final StringBuilder sb;
    
    public a(StringBuilder paramStringBuilder, a parama)
    {
      AppMethodBeat.i(188479);
      this.sb = paramStringBuilder;
      this.ajEm = parama;
      this.ajEP = true;
      AppMethodBeat.o(188479);
    }
    
    public final StringBuilder M(char paramChar)
    {
      AppMethodBeat.i(188505);
      StringBuilder localStringBuilder = this.sb.append(paramChar);
      AppMethodBeat.o(188505);
      return localStringBuilder;
    }
    
    public final StringBuilder bJY(String paramString)
    {
      AppMethodBeat.i(188515);
      s.u(paramString, "v");
      paramString = this.sb.append(paramString);
      AppMethodBeat.o(188515);
      return paramString;
    }
    
    public final void bJZ(String paramString)
    {
      AppMethodBeat.i(188524);
      s.u(paramString, "value");
      o.b(this.sb, paramString);
      AppMethodBeat.o(188524);
    }
    
    public final void kFN()
    {
      int i = 0;
      AppMethodBeat.i(188490);
      this.ajEP = false;
      if (this.ajEm.ajEb.ajEu)
      {
        bJY("\n");
        int j = this.level;
        while (i < j)
        {
          bJY(this.ajEm.ajEb.ajEv);
          i += 1;
        }
      }
      AppMethodBeat.o(188490);
    }
    
    public final void kFO()
    {
      AppMethodBeat.i(188498);
      if (this.ajEm.ajEb.ajEu) {
        M(' ');
      }
      AppMethodBeat.o(188498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.m
 * JD-Core Version:    0.7.0.1
 */