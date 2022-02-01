package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.a.c.e.a;
import kotlinx.a.f;
import kotlinx.a.i;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode$annotations", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeDecoder;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "endStructure", "popTag", "pushTag", "name", "(Ljava/lang/Object;)V", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class am<Tag>
  implements kotlinx.a.c.c, kotlinx.a.c.e
{
  private final ArrayList<Tag> ajDV = new ArrayList();
  private final i ajDn = i.ajCy;
  private boolean mrc;
  
  private final <E> E f(Tag paramTag, kotlin.g.a.a<? extends E> parama)
  {
    jG(paramTag);
    paramTag = parama.invoke();
    if (!this.mrc) {
      kFz();
    }
    this.mrc = false;
    return paramTag;
  }
  
  private void jG(Tag paramTag)
  {
    this.ajDV.add(paramTag);
  }
  
  private Object kFx()
  {
    throw ((Throwable)new f(ai.cz(getClass()) + " can't retrieve untyped values"));
  }
  
  private Tag kFz()
  {
    Object localObject = this.ajDV.remove(p.oE((List)this.ajDV));
    this.mrc = true;
    return localObject;
  }
  
  public final int a(kotlinx.a.b.e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return jA(f(parame, paramInt));
  }
  
  protected final <T> T a(kotlinx.a.a<T> parama)
  {
    s.u(parama, "deserializer");
    return b(parama);
  }
  
  public final <T> T a(kotlinx.a.b.e parame, int paramInt, final kotlinx.a.a<T> parama, final T paramT)
  {
    s.u(parame, "descriptor");
    s.u(parama, "deserializer");
    return f(f(parame, paramInt), (kotlin.g.a.a)new b(this, parama, paramT));
  }
  
  public final <T> T a(kotlinx.a.b.e parame, final kotlinx.a.a<T> parama, final T paramT)
  {
    s.u(parame, "descriptor");
    s.u(parama, "deserializer");
    return f(f(parame, 5), (kotlin.g.a.a)new a(this, parama, paramT));
  }
  
  public final kotlinx.a.c.c a(kotlinx.a.b.e parame, kotlinx.a.b<?>... paramVarArgs)
  {
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeParams");
    return (kotlinx.a.c.c)this;
  }
  
  public <T> T b(kotlinx.a.a<T> parama)
  {
    s.u(parama, "deserializer");
    return e.a.a(this, parama);
  }
  
  public final String b(kotlinx.a.b.e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return jF(f(parame, paramInt));
  }
  
  public void b(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
  }
  
  public kotlinx.a.c.c c(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
    return e.a.a(this, parame);
  }
  
  public final int d(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    return -1;
  }
  
  protected abstract Tag f(kotlinx.a.b.e parame, int paramInt);
  
  protected int jA(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)paramTag).intValue();
  }
  
  protected long jB(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramTag).longValue();
  }
  
  protected float jC(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)paramTag).floatValue();
  }
  
  protected double jD(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)paramTag).doubleValue();
  }
  
  protected char jE(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)paramTag).charValue();
  }
  
  protected String jF(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramTag;
  }
  
  protected boolean jw(Tag paramTag)
  {
    return true;
  }
  
  protected boolean jx(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)paramTag).booleanValue();
  }
  
  protected byte jy(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)paramTag).byteValue();
  }
  
  protected short jz(Tag paramTag)
  {
    paramTag = kFx();
    if (paramTag == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)paramTag).shortValue();
  }
  
  public kotlinx.a.f.b kFe()
  {
    return kotlinx.a.f.c.kFP();
  }
  
  public final boolean kFg()
  {
    return jw(p.oM((List)this.ajDV));
  }
  
  public final Void kFh()
  {
    return null;
  }
  
  public final boolean kFi()
  {
    return jx(kFz());
  }
  
  public final byte kFj()
  {
    return jy(kFz());
  }
  
  public final short kFk()
  {
    return jz(kFz());
  }
  
  public final int kFl()
  {
    return jA(kFz());
  }
  
  public final long kFm()
  {
    return jB(kFz());
  }
  
  public final float kFn()
  {
    return jC(kFz());
  }
  
  public final double kFo()
  {
    return jD(kFz());
  }
  
  public final char kFp()
  {
    return jE(kFz());
  }
  
  public final String kFq()
  {
    return jF(kFz());
  }
  
  public final boolean kFr()
  {
    return false;
  }
  
  protected final Tag kFy()
  {
    return p.oN((List)this.ajDV);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 4, 0})
  static final class a
    extends u
    implements kotlin.g.a.a<T>
  {
    a(am paramam, kotlinx.a.a parama, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(188735);
      if (this.ajDW.kFg())
      {
        Object localObject = this.ajDW.a(parama);
        AppMethodBeat.o(188735);
        return localObject;
      }
      AppMethodBeat.o(188735);
      return null;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 4, 0})
  static final class b
    extends u
    implements kotlin.g.a.a<T>
  {
    b(am paramam, kotlinx.a.a parama, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(188728);
      Object localObject = this.ajDW.a(parama);
      AppMethodBeat.o(188728);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.am
 * JD-Core Version:    0.7.0.1
 */