package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", "tag", "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "enumDescription", "(Ljava/lang/Object;Lkotlinx/serialization/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedUnit", "(Ljava/lang/Object;)V", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "decodeUnit", "decodeUnitElement", "endStructure", "popTag", "pushTag", "name", "tagBlock", "E", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "getTag", "(Lkotlinx/serialization/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class bg<Tag>
  implements kotlinx.a.a, c
{
  private final ArrayList<Tag> TYW = new ArrayList();
  private final z TYe = z.TYc;
  private boolean hga;
  
  private final <E> E c(Tag paramTag, kotlin.g.a.a<? extends E> parama)
  {
    gz(paramTag);
    paramTag = parama.invoke();
    if (!this.hga) {
      hOK();
    }
    this.hga = false;
    return paramTag;
  }
  
  private Object hOI()
  {
    throw ((Throwable)new kotlinx.a.t(aa.bp(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  private Tag hOK()
  {
    Object localObject = this.TYW.remove(j.kq((List)this.TYW));
    this.hga = true;
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
    return c(l(paramn, paramInt), (kotlin.g.a.a)new b(this, paramf));
  }
  
  public final <T> T a(n paramn, int paramInt, final f<T> paramf, final T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, paramInt), (kotlin.g.a.a)new d(this, paramf, paramT));
  }
  
  public final <T> T a(n paramn, final f<T> paramf)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, 5), (kotlin.g.a.a)new a(this, paramf));
  }
  
  public final <T> T a(n paramn, final f<T> paramf, final T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return c(l(paramn, 5), (kotlin.g.a.a)new c(this, paramf, paramT));
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
    return gq(l(paramn, paramInt));
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gr(l(paramn, paramInt));
  }
  
  public final <T> T b(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gx(l(paramn, paramInt));
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gs(l(paramn, paramInt));
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gt(l(paramn, paramInt));
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gu(l(paramn, paramInt));
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gv(l(paramn, paramInt));
  }
  
  public boolean gp(Tag paramTag)
  {
    return true;
  }
  
  public boolean gq(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)paramTag).booleanValue();
  }
  
  public byte gr(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)paramTag).byteValue();
  }
  
  public short gs(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)paramTag).shortValue();
  }
  
  public int gt(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)paramTag).intValue();
  }
  
  public long gu(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)paramTag).longValue();
  }
  
  public float gv(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)paramTag).floatValue();
  }
  
  public double gw(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)paramTag).doubleValue();
  }
  
  public char gx(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)paramTag).charValue();
  }
  
  public String gy(Tag paramTag)
  {
    paramTag = hOI();
    if (paramTag == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.String");
    }
    return (String)paramTag;
  }
  
  protected final void gz(Tag paramTag)
  {
    this.TYW.add(paramTag);
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gw(l(paramn, paramInt));
  }
  
  protected final Tag hOJ()
  {
    return j.kv((List)this.TYW);
  }
  
  public b hOk()
  {
    return (b)kotlinx.a.d.a.UaI;
  }
  
  public z hOl()
  {
    return this.TYe;
  }
  
  public final boolean hOm()
  {
    return gp(j.ku((List)this.TYW));
  }
  
  public final Void hOn()
  {
    return null;
  }
  
  public final boolean hOo()
  {
    return gq(hOK());
  }
  
  public final byte hOp()
  {
    return gr(hOK());
  }
  
  public final short hOq()
  {
    return gs(hOK());
  }
  
  public final char hOr()
  {
    return gx(hOK());
  }
  
  public final int hOs()
  {
    return gt(hOK());
  }
  
  public final long hOt()
  {
    return gu(hOK());
  }
  
  public final float hOu()
  {
    return gv(hOK());
  }
  
  public final double hOv()
  {
    return gw(hOK());
  }
  
  public final String hOw()
  {
    return gy(hOK());
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gy(l(paramn, paramInt));
  }
  
  protected abstract Tag l(n paramn, int paramInt);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(225452);
      Object localObject = this.TYX.b(paramf);
      AppMethodBeat.o(225452);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(225602);
      Object localObject = this.TYX.a(paramf);
      AppMethodBeat.o(225602);
      return localObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(225512);
      Object localObject1 = this.TYX;
      f localf = paramf;
      Object localObject2 = paramT;
      p.h(localf, "deserializer");
      localObject1 = c.a.b((c)localObject1, localf, localObject2);
      AppMethodBeat.o(225512);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "Tag", "invoke", "()Ljava/lang/Object;"})
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
      AppMethodBeat.i(225410);
      Object localObject = this.TYX.a(paramf, paramT);
      AppMethodBeat.o(225410);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.bg
 * JD-Core Version:    0.7.0.1
 */