package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.d.b;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedUnit", "(Ljava/lang/Object;)V", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeUnit", "decodeUnitElement", "endStructure", "popTag", "pushTag", "name", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "getTag", "(Lkotlinx/serialization/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class bg<Tag>
  implements kotlinx.a.a, c
{
  private boolean JgC;
  private final ArrayList<Tag> NMV = new ArrayList();
  private final kotlinx.a.z NMc = kotlinx.a.z.NMa;
  
  private final <E> E c(Tag paramTag, d.g.a.a<? extends E> parama)
  {
    gr(paramTag);
    paramTag = parama.invoke();
    if (!this.JgC) {
      gxb();
    }
    this.JgC = false;
    return paramTag;
  }
  
  private Object gwZ()
  {
    throw ((Throwable)new t(d.g.b.z.bp(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  private Tag gxb()
  {
    Object localObject = this.NMV.remove(j.ja((List)this.NMV));
    this.JgC = true;
    return localObject;
  }
  
  public <T> T a(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.a(this, paramf);
  }
  
  public final <T> T a(f<T> paramf, T paramT)
  {
    p.h(paramf, "deserializer");
    return c.a.a(this, paramf, paramT);
  }
  
  public final <T> T a(n paramn, int paramInt, final f<T> paramf)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, paramInt), (d.g.a.a)new b(this, paramf));
  }
  
  public final <T> T a(n paramn, int paramInt, final f<T> paramf, final T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, paramInt), (d.g.a.a)new d(this, paramf, paramT));
  }
  
  public final <T> T a(n paramn, final f<T> paramf)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, 5), (d.g.a.a)new a(this, paramf));
  }
  
  public final <T> T a(n paramn, final f<T> paramf, final T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, 5), (d.g.a.a)new c(this, paramf, paramT));
  }
  
  public kotlinx.a.a a(n paramn, h<?>... paramVarArgs)
  {
    p.h(paramn, "descriptor");
    p.h(paramVarArgs, "typeParams");
    return (kotlinx.a.a)this;
  }
  
  public void a(n paramn)
  {
    p.h(paramn, "descriptor");
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gi(l(paramn, paramInt));
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gj(l(paramn, paramInt));
  }
  
  public final <T> T b(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gp(l(paramn, paramInt));
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gk(l(paramn, paramInt));
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gl(l(paramn, paramInt));
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gm(l(paramn, paramInt));
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gn(l(paramn, paramInt));
  }
  
  public boolean gh(Tag paramTag)
  {
    return true;
  }
  
  public boolean gi(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)paramTag).booleanValue();
  }
  
  public byte gj(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)paramTag).byteValue();
  }
  
  public short gk(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)paramTag).shortValue();
  }
  
  public int gl(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)paramTag).intValue();
  }
  
  public long gm(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramTag).longValue();
  }
  
  public float gn(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)paramTag).floatValue();
  }
  
  public double go(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)paramTag).doubleValue();
  }
  
  public char gp(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)paramTag).charValue();
  }
  
  public String gq(Tag paramTag)
  {
    paramTag = gwZ();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramTag;
  }
  
  protected final void gr(Tag paramTag)
  {
    this.NMV.add(paramTag);
  }
  
  public b gwB()
  {
    return (b)kotlinx.a.d.a.NOF;
  }
  
  public kotlinx.a.z gwC()
  {
    return this.NMc;
  }
  
  public final boolean gwD()
  {
    return gh(j.je((List)this.NMV));
  }
  
  public final Void gwE()
  {
    return null;
  }
  
  public final boolean gwF()
  {
    return gi(gxb());
  }
  
  public final byte gwG()
  {
    return gj(gxb());
  }
  
  public final short gwH()
  {
    return gk(gxb());
  }
  
  public final char gwI()
  {
    return gp(gxb());
  }
  
  public final int gwJ()
  {
    return gl(gxb());
  }
  
  public final long gwK()
  {
    return gm(gxb());
  }
  
  public final float gwL()
  {
    return gn(gxb());
  }
  
  public final double gwM()
  {
    return go(gxb());
  }
  
  public final String gwN()
  {
    return gq(gxb());
  }
  
  protected final Tag gxa()
  {
    return j.jf((List)this.NMV);
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return go(l(paramn, paramInt));
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gq(l(paramn, paramInt));
  }
  
  protected abstract Tag l(n paramn, int paramInt);
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class a
    extends q
    implements d.g.a.a<T>
  {
    a(bg parambg, f paramf)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(191092);
      Object localObject = this.NMW.b(paramf);
      AppMethodBeat.o(191092);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class b
    extends q
    implements d.g.a.a<T>
  {
    b(bg parambg, f paramf)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(191242);
      Object localObject = this.NMW.a(paramf);
      AppMethodBeat.o(191242);
      return localObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class c
    extends q
    implements d.g.a.a<T>
  {
    c(bg parambg, f paramf, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(191152);
      Object localObject1 = this.NMW;
      f localf = paramf;
      Object localObject2 = paramT;
      p.h(localf, "deserializer");
      localObject1 = c.a.b((c)localObject1, localf, localObject2);
      AppMethodBeat.o(191152);
      return localObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
  static final class d
    extends q
    implements d.g.a.a<T>
  {
    d(bg parambg, f paramf, Object paramObject)
    {
      super();
    }
    
    public final T invoke()
    {
      AppMethodBeat.i(191050);
      Object localObject = this.NMW.a(paramf, paramT);
      AppMethodBeat.o(191050);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bg
 * JD-Core Version:    0.7.0.1
 */