package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.d.b;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedUnit", "(Ljava/lang/Object;)V", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeUnit", "decodeUnitElement", "endStructure", "popTag", "pushTag", "name", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "getTag", "(Lkotlinx/serialization/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class bg<Tag>
  implements kotlinx.a.a, c
{
  private final z abBt = z.abBr;
  private final ArrayList<Tag> abCl = new ArrayList();
  private boolean jRS;
  
  private final <E> E c(Tag paramTag, kotlin.g.a.a<? extends E> parama)
  {
    gR(paramTag);
    paramTag = parama.invoke();
    if (!this.jRS) {
      iTR();
    }
    this.jRS = false;
    return paramTag;
  }
  
  private Object iTP()
  {
    throw ((Throwable)new kotlinx.a.t(ab.bO(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  private Tag iTR()
  {
    Object localObject = this.abCl.remove(j.lk((List)this.abCl));
    this.jRS = true;
    return localObject;
  }
  
  public <T> T a(f<T> paramf)
  {
    p.k(paramf, "deserializer");
    return c.a.a(this, paramf);
  }
  
  public final <T> T a(f<T> paramf, T paramT)
  {
    p.k(paramf, "deserializer");
    return c.a.a(this, paramf, paramT);
  }
  
  public final <T> T a(n paramn, int paramInt, final f<T> paramf)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return c(l(paramn, paramInt), (kotlin.g.a.a)new b(this, paramf));
  }
  
  public final <T> T a(n paramn, int paramInt, final f<T> paramf, final T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return c(l(paramn, paramInt), (kotlin.g.a.a)new d(this, paramf, paramT));
  }
  
  public final <T> T a(n paramn, final f<T> paramf)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return c(l(paramn, 5), (kotlin.g.a.a)new a(this, paramf));
  }
  
  public final <T> T a(n paramn, final f<T> paramf, final T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return c(l(paramn, 5), (kotlin.g.a.a)new c(this, paramf, paramT));
  }
  
  public kotlinx.a.a a(n paramn, h<?>... paramVarArgs)
  {
    p.k(paramn, "descriptor");
    p.k(paramVarArgs, "typeParams");
    return (kotlinx.a.a)this;
  }
  
  public void a(n paramn)
  {
    p.k(paramn, "descriptor");
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gI(l(paramn, paramInt));
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gJ(l(paramn, paramInt));
  }
  
  public final <T> T b(f<T> paramf)
  {
    p.k(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gP(l(paramn, paramInt));
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gK(l(paramn, paramInt));
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gL(l(paramn, paramInt));
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gM(l(paramn, paramInt));
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gN(l(paramn, paramInt));
  }
  
  public boolean gH(Tag paramTag)
  {
    return true;
  }
  
  public boolean gI(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)paramTag).booleanValue();
  }
  
  public byte gJ(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)paramTag).byteValue();
  }
  
  public short gK(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)paramTag).shortValue();
  }
  
  public int gL(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)paramTag).intValue();
  }
  
  public long gM(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramTag).longValue();
  }
  
  public float gN(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)paramTag).floatValue();
  }
  
  public double gO(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)paramTag).doubleValue();
  }
  
  public char gP(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)paramTag).charValue();
  }
  
  public String gQ(Tag paramTag)
  {
    paramTag = iTP();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramTag;
  }
  
  protected final void gR(Tag paramTag)
  {
    this.abCl.add(paramTag);
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gO(l(paramn, paramInt));
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return gQ(l(paramn, paramInt));
  }
  
  public final float iTA()
  {
    return gN(iTR());
  }
  
  public final double iTB()
  {
    return gO(iTR());
  }
  
  public final String iTC()
  {
    return gQ(iTR());
  }
  
  protected final Tag iTQ()
  {
    return j.lr((List)this.abCl);
  }
  
  public b iTq()
  {
    return (b)kotlinx.a.d.a.abDW;
  }
  
  public z iTr()
  {
    return this.abBt;
  }
  
  public final boolean iTs()
  {
    return gH(j.lq((List)this.abCl));
  }
  
  public final Void iTt()
  {
    return null;
  }
  
  public final boolean iTu()
  {
    return gI(iTR());
  }
  
  public final byte iTv()
  {
    return gJ(iTR());
  }
  
  public final short iTw()
  {
    return gK(iTR());
  }
  
  public final char iTx()
  {
    return gP(iTR());
  }
  
  public final int iTy()
  {
    return gL(iTR());
  }
  
  public final long iTz()
  {
    return gM(iTR());
  }
  
  protected abstract Tag l(n paramn, int paramInt);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    a(bg parambg, f paramf)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(254385);
      Object localObject = this.abCm.b(paramf);
      AppMethodBeat.o(254385);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class b
    extends q
    implements kotlin.g.a.a<T>
  {
    b(bg parambg, f paramf)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(254888);
      Object localObject = this.abCm.a(paramf);
      AppMethodBeat.o(254888);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class c
    extends q
    implements kotlin.g.a.a<T>
  {
    c(bg parambg, f paramf, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(254530);
      Object localObject1 = this.abCm;
      f localf = paramf;
      Object localObject2 = paramT;
      p.k(localf, "deserializer");
      localObject1 = c.a.b((c)localObject1, localf, localObject2);
      AppMethodBeat.o(254530);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class d
    extends q
    implements kotlin.g.a.a<T>
  {
    d(bg parambg, f paramf, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(254272);
      Object localObject = this.abCm.a(paramf, paramT);
      AppMethodBeat.o(254272);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.bg
 * JD-Core Version:    0.7.0.1
 */