package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlinx.a.b.bj;
import kotlinx.a.c.a;
import kotlinx.a.c.d;
import kotlinx.a.c.u;
import kotlinx.a.g;
import kotlinx.a.g.a;
import kotlinx.a.h;
import kotlinx.a.j;
import kotlinx.a.m;
import kotlinx.a.x.c;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/StreamingJsonOutput;", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/builtins/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "composer", "Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonOutput;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJson", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"})
public final class n
  extends kotlinx.a.a.b
  implements u
{
  private final d Okk;
  private final a Olh;
  private final kotlinx.a.d.b Olu;
  private final r Olv;
  private boolean Olw;
  private boolean Olx;
  private final a Oly;
  private final u[] Olz;
  
  public n(StringBuilder paramStringBuilder, a parama, r paramr, u[] paramArrayOfu)
  {
    this(new a(paramStringBuilder, parama), parama, paramr, paramArrayOfu);
    AppMethodBeat.i(199923);
    AppMethodBeat.o(199923);
  }
  
  private n(a parama, a parama1, r paramr, u[] paramArrayOfu)
  {
    AppMethodBeat.i(199922);
    this.Oly = parama;
    this.Olh = parama1;
    this.Olv = paramr;
    this.Olz = paramArrayOfu;
    this.Olu = this.Olh.Okj;
    this.Okk = this.Olh.Okk;
    int i = this.Olv.ordinal();
    if ((this.Olz[i] != null) || (this.Olz[i] != (n)this)) {
      this.Olz[i] = ((u)this);
    }
    AppMethodBeat.o(199922);
  }
  
  public final void AL(boolean paramBoolean)
  {
    AppMethodBeat.i(199913);
    if (this.Olw)
    {
      beP(String.valueOf(paramBoolean));
      AppMethodBeat.o(199913);
      return;
    }
    this.Oly.sb.append(paramBoolean);
    AppMethodBeat.o(199913);
  }
  
  public final void Gk(long paramLong)
  {
    AppMethodBeat.i(199917);
    if (this.Olw)
    {
      beP(String.valueOf(paramLong));
      AppMethodBeat.o(199917);
      return;
    }
    this.Oly.sb.append(paramLong);
    AppMethodBeat.o(199917);
  }
  
  public final void H(char paramChar)
  {
    AppMethodBeat.i(199920);
    beP(String.valueOf(paramChar));
    AppMethodBeat.o(199920);
  }
  
  public final void O(double paramDouble)
  {
    AppMethodBeat.i(199919);
    if (this.Olw)
    {
      beP(String.valueOf(paramDouble));
      if (this.Okk.bNj) {
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
      String str = this.Oly.sb.toString();
      d.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "double", str);
      AppMethodBeat.o(199919);
      throw ((Throwable)localObject);
      this.Oly.sb.append(paramDouble);
      break;
    }
    label120:
    AppMethodBeat.o(199919);
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(199910);
    d.g.b.p.h(paramn, "descriptor");
    if (this.Olv.OlK != 0)
    {
      paramn = this.Oly;
      paramn.level -= 1;
      this.Oly.gBY();
      this.Oly.J(this.Olv.OlK);
    }
    AppMethodBeat.o(199910);
  }
  
  public final <T> void a(kotlinx.a.v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(199908);
    d.g.b.p.h(paramv, "serializer");
    if ((!(paramv instanceof kotlinx.a.b.b)) || (gBJ().Okk.OkB))
    {
      paramv.a((g)this, paramT);
      AppMethodBeat.o(199908);
      return;
    }
    Object localObject1 = (kotlinx.a.b.b)paramv;
    Object localObject2 = (g)this;
    if (paramT == null)
    {
      paramv = new d.v("null cannot be cast to non-null type kotlin.Any");
      AppMethodBeat.o(199908);
      throw paramv;
    }
    localObject1 = ((kotlinx.a.b.b)localObject1).b((g)localObject2, paramT);
    if (localObject1 == null)
    {
      paramv = new d.v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(199908);
      throw paramv;
    }
    localObject2 = (h)paramv;
    paramv = gBJ().Okk.OkC;
    if (((localObject2 instanceof m)) && (bj.e(((h)localObject1).eOR()).contains(paramv)))
    {
      paramT = ((h)localObject2).eOR().gBs();
      localObject1 = ((h)localObject1).eOR().gBs();
      paramv = (Throwable)new IllegalStateException(("Sealed class '" + (String)localObject1 + "' cannot be serialized as base class '" + paramT + "' because it has property name that conflicts with JSON class discriminator '" + paramv + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
      AppMethodBeat.o(199908);
      throw paramv;
    }
    paramv = ((h)localObject1).eOR().gBt();
    d.g.b.p.h(paramv, "kind");
    if ((paramv instanceof x.c))
    {
      paramv = (Throwable)new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(199908);
      throw paramv;
    }
    if ((paramv instanceof kotlinx.a.l))
    {
      paramv = (Throwable)new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(199908);
      throw paramv;
    }
    if ((paramv instanceof j))
    {
      paramv = (Throwable)new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
      AppMethodBeat.o(199908);
      throw paramv;
    }
    this.Olx = true;
    ((h)localObject1).a((g)this, paramT);
    AppMethodBeat.o(199908);
  }
  
  public final void ams(int paramInt)
  {
    AppMethodBeat.i(199916);
    if (this.Olw)
    {
      beP(String.valueOf(paramInt));
      AppMethodBeat.o(199916);
      return;
    }
    this.Oly.sb.append(paramInt);
    AppMethodBeat.o(199916);
  }
  
  public final kotlinx.a.b b(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(199909);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    paramVarArgs = s.a(this.Olh, paramn);
    if (paramVarArgs.OlJ != 0)
    {
      this.Oly.J(paramVarArgs.OlJ);
      a locala = this.Oly;
      locala.OlA = true;
      locala.level += 1;
    }
    if (this.Olx)
    {
      this.Olx = false;
      this.Oly.gBY();
      beP(this.Okk.OkC);
      this.Oly.J(':');
      this.Oly.gBZ();
      beP(paramn.gBs());
    }
    if (this.Olv == paramVarArgs)
    {
      paramn = (kotlinx.a.b)this;
      AppMethodBeat.o(199909);
      return paramn;
    }
    paramn = this.Olz[paramVarArgs.ordinal()];
    if (paramn != null)
    {
      paramn = (kotlinx.a.b)paramn;
      AppMethodBeat.o(199909);
      return paramn;
    }
    paramn = (kotlinx.a.b)new n(this.Oly, this.Olh, paramVarArgs, this.Olz);
    AppMethodBeat.o(199909);
    return paramn;
  }
  
  public final <T> void b(kotlinx.a.v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(199925);
    d.g.b.p.h(paramv, "serializer");
    d.g.b.p.h(paramv, "serializer");
    g.a.a((g)this, paramv, paramT);
    AppMethodBeat.o(199925);
  }
  
  public final void beP(String paramString)
  {
    AppMethodBeat.i(199921);
    d.g.b.p.h(paramString, "value");
    if ((this.Okk.OkA) && (!p.bfe(paramString)))
    {
      this.Oly.bfa(paramString);
      AppMethodBeat.o(199921);
      return;
    }
    this.Oly.bfb(paramString);
    AppMethodBeat.o(199921);
  }
  
  public final kotlinx.a.b c(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(199924);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    paramn = g.a.a((g)this, paramn, paramVarArgs);
    AppMethodBeat.o(199924);
    return paramn;
  }
  
  public final boolean c(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(199907);
    d.g.b.p.h(paramn, "descriptor");
    boolean bool = this.Okk.Okv;
    AppMethodBeat.o(199907);
    return bool;
  }
  
  public final void cq(float paramFloat)
  {
    AppMethodBeat.i(199918);
    if (this.Olw)
    {
      beP(String.valueOf(paramFloat));
      if (this.Okk.bNj) {
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
      String str = this.Oly.sb.toString();
      d.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "float", str);
      AppMethodBeat.o(199918);
      throw ((Throwable)localObject);
      this.Oly.sb.append(paramFloat);
      break;
    }
    label119:
    AppMethodBeat.o(199918);
  }
  
  public final void d(short paramShort)
  {
    AppMethodBeat.i(199915);
    if (this.Olw)
    {
      beP(String.valueOf(paramShort));
      AppMethodBeat.o(199915);
      return;
    }
    this.Oly.sb.append(Short.valueOf(paramShort));
    AppMethodBeat.o(199915);
  }
  
  public final void e(byte paramByte)
  {
    AppMethodBeat.i(199914);
    if (this.Olw)
    {
      beP(String.valueOf(paramByte));
      AppMethodBeat.o(199914);
      return;
    }
    this.Oly.sb.append(Byte.valueOf(paramByte));
    AppMethodBeat.o(199914);
  }
  
  public final a gBJ()
  {
    return this.Olh;
  }
  
  public final kotlinx.a.d.b gBd()
  {
    return this.Olu;
  }
  
  public final void gBq()
  {
    AppMethodBeat.i(199912);
    this.Oly.bfa("null");
    AppMethodBeat.o(199912);
  }
  
  public final boolean j(kotlinx.a.n paramn, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(199911);
    d.g.b.p.h(paramn, "descriptor");
    r localr = this.Olv;
    switch (o.cqt[localr.ordinal()])
    {
    default: 
      if (!this.Oly.OlA) {
        this.Oly.J(',');
      }
      this.Oly.gBY();
      beP(paramn.amt(paramInt));
      this.Oly.J(':');
      this.Oly.gBZ();
    }
    for (;;)
    {
      AppMethodBeat.o(199911);
      return true;
      if (!this.Oly.OlA) {
        this.Oly.J(',');
      }
      this.Oly.gBY();
      continue;
      if (!this.Oly.OlA)
      {
        if (paramInt % 2 == 0)
        {
          this.Oly.J(',');
          this.Oly.gBY();
          bool = true;
        }
        for (;;)
        {
          this.Olw = bool;
          break;
          this.Oly.J(':');
          this.Oly.gBZ();
        }
      }
      this.Olw = true;
      this.Oly.gBY();
      continue;
      if (paramInt == 0) {
        this.Olw = true;
      }
      if (paramInt == 1)
      {
        this.Oly.J(',');
        this.Oly.gBZ();
        this.Olw = false;
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"})
  public static final class a
  {
    boolean OlA;
    private final a Olh;
    int level;
    public final StringBuilder sb;
    
    public a(StringBuilder paramStringBuilder, a parama)
    {
      AppMethodBeat.i(199937);
      this.sb = paramStringBuilder;
      this.Olh = parama;
      this.OlA = true;
      AppMethodBeat.o(199937);
    }
    
    public final StringBuilder J(char paramChar)
    {
      AppMethodBeat.i(199934);
      StringBuilder localStringBuilder = this.sb.append(paramChar);
      AppMethodBeat.o(199934);
      return localStringBuilder;
    }
    
    public final StringBuilder bfa(String paramString)
    {
      AppMethodBeat.i(199935);
      d.g.b.p.h(paramString, "v");
      paramString = this.sb.append(paramString);
      AppMethodBeat.o(199935);
      return paramString;
    }
    
    public final void bfb(String paramString)
    {
      AppMethodBeat.i(199936);
      d.g.b.p.h(paramString, "value");
      p.b(this.sb, paramString);
      AppMethodBeat.o(199936);
    }
    
    public final void gBY()
    {
      int i = 0;
      AppMethodBeat.i(199932);
      this.OlA = false;
      if (this.Olh.Okk.Okz)
      {
        bfa("\n");
        int j = this.level;
        while (i < j)
        {
          bfa(this.Olh.Okk.bQD);
          i += 1;
        }
      }
      AppMethodBeat.o(199932);
    }
    
    public final void gBZ()
    {
      AppMethodBeat.i(199933);
      if (this.Olh.Okk.Okz) {
        J(' ');
      }
      AppMethodBeat.o(199933);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */