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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/StreamingJsonOutput;", "Lkotlinx/serialization/json/JsonOutput;", "Lkotlinx/serialization/builtins/AbstractEncoder;", "output", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "modeReuseCache", "", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "composer", "Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "(Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;[Lkotlinx/serialization/json/JsonOutput;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "forceQuoting", "", "getJson", "()Lkotlinx/serialization/json/Json;", "[Lkotlinx/serialization/json/JsonOutput;", "writePolymorphic", "beginStructure", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeElement", "index", "", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeInt", "encodeJson", "element", "Lkotlinx/serialization/json/JsonElement;", "encodeLong", "", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeShort", "", "encodeString", "", "encodeTypeInfo", "endStructure", "shouldEncodeElementDefault", "Composer", "kotlinx-serialization-runtime"})
public final class n
  extends kotlinx.a.a.b
  implements u
{
  private final d NNe;
  private final a NOb;
  private final kotlinx.a.d.b NOo;
  private final r NOp;
  private boolean NOq;
  private boolean NOr;
  private final a NOs;
  private final u[] NOt;
  
  public n(StringBuilder paramStringBuilder, a parama, r paramr, u[] paramArrayOfu)
  {
    this(new a(paramStringBuilder, parama), parama, paramr, paramArrayOfu);
    AppMethodBeat.i(191335);
    AppMethodBeat.o(191335);
  }
  
  private n(a parama, a parama1, r paramr, u[] paramArrayOfu)
  {
    AppMethodBeat.i(191334);
    this.NOs = parama;
    this.NOb = parama1;
    this.NOp = paramr;
    this.NOt = paramArrayOfu;
    this.NOo = this.NOb.NNd;
    this.NNe = this.NOb.NNe;
    int i = this.NOp.ordinal();
    if ((this.NOt[i] != null) || (this.NOt[i] != (n)this)) {
      this.NOt[i] = ((u)this);
    }
    AppMethodBeat.o(191334);
  }
  
  public final void Ay(boolean paramBoolean)
  {
    AppMethodBeat.i(191325);
    if (this.NOq)
    {
      bdl(String.valueOf(paramBoolean));
      AppMethodBeat.o(191325);
      return;
    }
    this.NOs.sb.append(paramBoolean);
    AppMethodBeat.o(191325);
  }
  
  public final void FI(long paramLong)
  {
    AppMethodBeat.i(191329);
    if (this.NOq)
    {
      bdl(String.valueOf(paramLong));
      AppMethodBeat.o(191329);
      return;
    }
    this.NOs.sb.append(paramLong);
    AppMethodBeat.o(191329);
  }
  
  public final void H(char paramChar)
  {
    AppMethodBeat.i(191332);
    bdl(String.valueOf(paramChar));
    AppMethodBeat.o(191332);
  }
  
  public final void N(double paramDouble)
  {
    AppMethodBeat.i(191331);
    if (this.NOq)
    {
      bdl(String.valueOf(paramDouble));
      if (this.NNe.bNj) {
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
      String str = this.NOs.sb.toString();
      d.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "double", str);
      AppMethodBeat.o(191331);
      throw ((Throwable)localObject);
      this.NOs.sb.append(paramDouble);
      break;
    }
    label120:
    AppMethodBeat.o(191331);
  }
  
  public final void a(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(191322);
    d.g.b.p.h(paramn, "descriptor");
    if (this.NOp.NOE != 0)
    {
      paramn = this.NOs;
      paramn.level -= 1;
      this.NOs.gxw();
      this.NOs.J(this.NOp.NOE);
    }
    AppMethodBeat.o(191322);
  }
  
  public final <T> void a(kotlinx.a.v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(191320);
    d.g.b.p.h(paramv, "serializer");
    if ((!(paramv instanceof kotlinx.a.b.b)) || (gxh().NNe.NNv))
    {
      paramv.a((g)this, paramT);
      AppMethodBeat.o(191320);
      return;
    }
    Object localObject1 = (kotlinx.a.b.b)paramv;
    Object localObject2 = (g)this;
    if (paramT == null)
    {
      paramv = new d.v("null cannot be cast to non-null type kotlin.Any");
      AppMethodBeat.o(191320);
      throw paramv;
    }
    localObject1 = ((kotlinx.a.b.b)localObject1).b((g)localObject2, paramT);
    if (localObject1 == null)
    {
      paramv = new d.v("null cannot be cast to non-null type kotlinx.serialization.KSerializer<T>");
      AppMethodBeat.o(191320);
      throw paramv;
    }
    localObject2 = (h)paramv;
    paramv = gxh().NNe.NNw;
    if (((localObject2 instanceof m)) && (bj.e(((h)localObject1).eLj()).contains(paramv)))
    {
      paramT = ((h)localObject2).eLj().gwQ();
      localObject1 = ((h)localObject1).eLj().gwQ();
      paramv = (Throwable)new IllegalStateException(("Sealed class '" + (String)localObject1 + "' cannot be serialized as base class '" + paramT + "' because it has property name that conflicts with JSON class discriminator '" + paramv + "'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism").toString());
      AppMethodBeat.o(191320);
      throw paramv;
    }
    paramv = ((h)localObject1).eLj().gwR();
    d.g.b.p.h(paramv, "kind");
    if ((paramv instanceof x.c))
    {
      paramv = (Throwable)new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(191320);
      throw paramv;
    }
    if ((paramv instanceof kotlinx.a.l))
    {
      paramv = (Throwable)new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonConfiguration.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(191320);
      throw paramv;
    }
    if ((paramv instanceof j))
    {
      paramv = (Throwable)new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
      AppMethodBeat.o(191320);
      throw paramv;
    }
    this.NOr = true;
    ((h)localObject1).a((g)this, paramT);
    AppMethodBeat.o(191320);
  }
  
  public final void alI(int paramInt)
  {
    AppMethodBeat.i(191328);
    if (this.NOq)
    {
      bdl(String.valueOf(paramInt));
      AppMethodBeat.o(191328);
      return;
    }
    this.NOs.sb.append(paramInt);
    AppMethodBeat.o(191328);
  }
  
  public final kotlinx.a.b b(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(191321);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    paramVarArgs = s.a(this.NOb, paramn);
    if (paramVarArgs.NOD != 0)
    {
      this.NOs.J(paramVarArgs.NOD);
      a locala = this.NOs;
      locala.NOu = true;
      locala.level += 1;
    }
    if (this.NOr)
    {
      this.NOr = false;
      this.NOs.gxw();
      bdl(this.NNe.NNw);
      this.NOs.J(':');
      this.NOs.gxx();
      bdl(paramn.gwQ());
    }
    if (this.NOp == paramVarArgs)
    {
      paramn = (kotlinx.a.b)this;
      AppMethodBeat.o(191321);
      return paramn;
    }
    paramn = this.NOt[paramVarArgs.ordinal()];
    if (paramn != null)
    {
      paramn = (kotlinx.a.b)paramn;
      AppMethodBeat.o(191321);
      return paramn;
    }
    paramn = (kotlinx.a.b)new n(this.NOs, this.NOb, paramVarArgs, this.NOt);
    AppMethodBeat.o(191321);
    return paramn;
  }
  
  public final <T> void b(kotlinx.a.v<? super T> paramv, T paramT)
  {
    AppMethodBeat.i(191337);
    d.g.b.p.h(paramv, "serializer");
    d.g.b.p.h(paramv, "serializer");
    g.a.a((g)this, paramv, paramT);
    AppMethodBeat.o(191337);
  }
  
  public final void bdl(String paramString)
  {
    AppMethodBeat.i(191333);
    d.g.b.p.h(paramString, "value");
    if ((this.NNe.NNu) && (!p.bdA(paramString)))
    {
      this.NOs.bdw(paramString);
      AppMethodBeat.o(191333);
      return;
    }
    this.NOs.bdx(paramString);
    AppMethodBeat.o(191333);
  }
  
  public final kotlinx.a.b c(kotlinx.a.n paramn, h<?>... paramVarArgs)
  {
    AppMethodBeat.i(191336);
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    d.g.b.p.h(paramn, "descriptor");
    d.g.b.p.h(paramVarArgs, "typeSerializers");
    paramn = g.a.a((g)this, paramn, paramVarArgs);
    AppMethodBeat.o(191336);
    return paramn;
  }
  
  public final boolean c(kotlinx.a.n paramn)
  {
    AppMethodBeat.i(191319);
    d.g.b.p.h(paramn, "descriptor");
    boolean bool = this.NNe.NNp;
    AppMethodBeat.o(191319);
    return bool;
  }
  
  public final void cs(float paramFloat)
  {
    AppMethodBeat.i(191330);
    if (this.NOq)
    {
      bdl(String.valueOf(paramFloat));
      if (this.NNe.bNj) {
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
      String str = this.NOs.sb.toString();
      d.g.b.p.g(str, "composer.sb.toString()");
      localObject = (Throwable)kotlinx.a.c.l.a((Number)localObject, "float", str);
      AppMethodBeat.o(191330);
      throw ((Throwable)localObject);
      this.NOs.sb.append(paramFloat);
      break;
    }
    label119:
    AppMethodBeat.o(191330);
  }
  
  public final void d(short paramShort)
  {
    AppMethodBeat.i(191327);
    if (this.NOq)
    {
      bdl(String.valueOf(paramShort));
      AppMethodBeat.o(191327);
      return;
    }
    this.NOs.sb.append(Short.valueOf(paramShort));
    AppMethodBeat.o(191327);
  }
  
  public final void e(byte paramByte)
  {
    AppMethodBeat.i(191326);
    if (this.NOq)
    {
      bdl(String.valueOf(paramByte));
      AppMethodBeat.o(191326);
      return;
    }
    this.NOs.sb.append(Byte.valueOf(paramByte));
    AppMethodBeat.o(191326);
  }
  
  public final kotlinx.a.d.b gwB()
  {
    return this.NOo;
  }
  
  public final void gwO()
  {
    AppMethodBeat.i(191324);
    this.NOs.bdw("null");
    AppMethodBeat.o(191324);
  }
  
  public final a gxh()
  {
    return this.NOb;
  }
  
  public final boolean j(kotlinx.a.n paramn, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(191323);
    d.g.b.p.h(paramn, "descriptor");
    r localr = this.NOp;
    switch (o.cpQ[localr.ordinal()])
    {
    default: 
      if (!this.NOs.NOu) {
        this.NOs.J(',');
      }
      this.NOs.gxw();
      bdl(paramn.alJ(paramInt));
      this.NOs.J(':');
      this.NOs.gxx();
    }
    for (;;)
    {
      AppMethodBeat.o(191323);
      return true;
      if (!this.NOs.NOu) {
        this.NOs.J(',');
      }
      this.NOs.gxw();
      continue;
      if (!this.NOs.NOu)
      {
        if (paramInt % 2 == 0)
        {
          this.NOs.J(',');
          this.NOs.gxw();
          bool = true;
        }
        for (;;)
        {
          this.NOq = bool;
          break;
          this.NOs.J(':');
          this.NOs.gxx();
        }
      }
      this.NOq = true;
      this.NOs.gxw();
      continue;
      if (paramInt == 0) {
        this.NOq = true;
      }
      if (paramInt == 1)
      {
        this.NOs.J(',');
        this.NOs.gxx();
        this.NOq = false;
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/internal/StreamingJsonOutput$Composer;", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Ljava/lang/StringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "kotlin.jvm.PlatformType", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-runtime"})
  public static final class a
  {
    private final a NOb;
    boolean NOu;
    int level;
    public final StringBuilder sb;
    
    public a(StringBuilder paramStringBuilder, a parama)
    {
      AppMethodBeat.i(191349);
      this.sb = paramStringBuilder;
      this.NOb = parama;
      this.NOu = true;
      AppMethodBeat.o(191349);
    }
    
    public final StringBuilder J(char paramChar)
    {
      AppMethodBeat.i(191346);
      StringBuilder localStringBuilder = this.sb.append(paramChar);
      AppMethodBeat.o(191346);
      return localStringBuilder;
    }
    
    public final StringBuilder bdw(String paramString)
    {
      AppMethodBeat.i(191347);
      d.g.b.p.h(paramString, "v");
      paramString = this.sb.append(paramString);
      AppMethodBeat.o(191347);
      return paramString;
    }
    
    public final void bdx(String paramString)
    {
      AppMethodBeat.i(191348);
      d.g.b.p.h(paramString, "value");
      p.b(this.sb, paramString);
      AppMethodBeat.o(191348);
    }
    
    public final void gxw()
    {
      int i = 0;
      AppMethodBeat.i(191344);
      this.NOu = false;
      if (this.NOb.NNe.NNt)
      {
        bdw("\n");
        int j = this.level;
        while (i < j)
        {
          bdw(this.NOb.NNe.bQD);
          i += 1;
        }
      }
      AppMethodBeat.o(191344);
    }
    
    public final void gxx()
    {
      AppMethodBeat.i(191345);
      if (this.NOb.NNe.NNt) {
        J(' ');
      }
      AppMethodBeat.o(191345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.a.n
 * JD-Core Version:    0.7.0.1
 */