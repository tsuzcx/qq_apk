package kotlinx.a.d;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b;
import kotlinx.a.b.e;
import kotlinx.a.c.c;
import kotlinx.a.c.c.b;
import kotlinx.a.c.d;
import kotlinx.a.c.f;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class w<Element, Collection, Builder>
  extends a<Element, Collection, Builder>
{
  private final b<Element> ajDz;
  
  private w(b<Element> paramb)
  {
    super((byte)0);
    this.ajDz = paramb;
  }
  
  protected final void a(c paramc, int paramInt, Builder paramBuilder, boolean paramBoolean)
  {
    s.u(paramc, "decoder");
    b(paramBuilder, paramInt, c.b.a(paramc, iou(), paramInt, (kotlinx.a.a)this.ajDz));
  }
  
  protected final void a(c paramc, Builder paramBuilder, int paramInt1, int paramInt2)
  {
    s.u(paramc, "decoder");
    if (paramInt2 >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString()));
    }
    i = 0;
    while (i < paramInt2)
    {
      a(paramc, paramInt1 + i, paramBuilder, false);
      i += 1;
    }
  }
  
  public final void a(f paramf, Collection paramCollection)
  {
    s.u(paramf, "encoder");
    int j = jr(paramCollection);
    paramf = paramf.d(iou(), j);
    paramCollection = js(paramCollection);
    int i = 0;
    while (i < j)
    {
      paramf.a(iou(), i, (g)this.ajDz, paramCollection.next());
      i += 1;
    }
    paramf.b(iou());
  }
  
  protected abstract void b(Builder paramBuilder, int paramInt, Element paramElement);
  
  public abstract e iou();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.w
 * JD-Core Version:    0.7.0.1
 */