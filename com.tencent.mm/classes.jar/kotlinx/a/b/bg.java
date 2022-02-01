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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedUnit", "(Ljava/lang/Object;)V", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeUnit", "decodeUnitElement", "endStructure", "popTag", "pushTag", "name", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "getTag", "(Lkotlinx/serialization/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class bg<Tag>
  implements kotlinx.a.a, c
{
  private boolean JBn;
  private final kotlinx.a.z Oji = kotlinx.a.z.Ojg;
  private final ArrayList<Tag> Okb = new ArrayList();
  
  private final <E> E c(Tag paramTag, d.g.a.a<? extends E> parama)
  {
    gu(paramTag);
    paramTag = parama.invoke();
    if (!this.JBn) {
      gBD();
    }
    this.JBn = false;
    return paramTag;
  }
  
  private Object gBB()
  {
    throw ((Throwable)new t(d.g.b.z.bp(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  private Tag gBD()
  {
    Object localObject = this.Okb.remove(j.jj((List)this.Okb));
    this.JBn = true;
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
    return gl(l(paramn, paramInt));
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gm(l(paramn, paramInt));
  }
  
  public final <T> T b(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gs(l(paramn, paramInt));
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gn(l(paramn, paramInt));
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return go(l(paramn, paramInt));
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gp(l(paramn, paramInt));
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gq(l(paramn, paramInt));
  }
  
  protected final Tag gBC()
  {
    return j.jo((List)this.Okb);
  }
  
  public b gBd()
  {
    return (b)kotlinx.a.d.a.OlL;
  }
  
  public kotlinx.a.z gBe()
  {
    return this.Oji;
  }
  
  public final boolean gBf()
  {
    return gk(j.jn((List)this.Okb));
  }
  
  public final Void gBg()
  {
    return null;
  }
  
  public final boolean gBh()
  {
    return gl(gBD());
  }
  
  public final byte gBi()
  {
    return gm(gBD());
  }
  
  public final short gBj()
  {
    return gn(gBD());
  }
  
  public final char gBk()
  {
    return gs(gBD());
  }
  
  public final int gBl()
  {
    return go(gBD());
  }
  
  public final long gBm()
  {
    return gp(gBD());
  }
  
  public final float gBn()
  {
    return gq(gBD());
  }
  
  public final double gBo()
  {
    return gr(gBD());
  }
  
  public final String gBp()
  {
    return gt(gBD());
  }
  
  public boolean gk(Tag paramTag)
  {
    return true;
  }
  
  public boolean gl(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)paramTag).booleanValue();
  }
  
  public byte gm(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)paramTag).byteValue();
  }
  
  public short gn(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)paramTag).shortValue();
  }
  
  public int go(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)paramTag).intValue();
  }
  
  public long gp(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramTag).longValue();
  }
  
  public float gq(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)paramTag).floatValue();
  }
  
  public double gr(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)paramTag).doubleValue();
  }
  
  public char gs(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)paramTag).charValue();
  }
  
  public String gt(Tag paramTag)
  {
    paramTag = gBB();
    if (paramTag == null) {
      throw new v("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramTag;
  }
  
  protected final void gu(Tag paramTag)
  {
    this.Okb.add(paramTag);
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gr(l(paramn, paramInt));
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gt(l(paramn, paramInt));
  }
  
  protected abstract Tag l(n paramn, int paramInt);
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(199680);
      Object localObject = this.Okc.b(paramf);
      AppMethodBeat.o(199680);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(199830);
      Object localObject = this.Okc.a(paramf);
      AppMethodBeat.o(199830);
      return localObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(199740);
      Object localObject1 = this.Okc;
      f localf = paramf;
      Object localObject2 = paramT;
      p.h(localf, "deserializer");
      localObject1 = c.a.b((c)localObject1, localf, localObject2);
      AppMethodBeat.o(199740);
      return localObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(199638);
      Object localObject = this.Okc.a(paramf, paramT);
      AppMethodBeat.o(199638);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bg
 * JD-Core Version:    0.7.0.1
 */