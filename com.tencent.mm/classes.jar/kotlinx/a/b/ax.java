package kotlinx.a.b;

import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.Iterator;
import kotlinx.a.b;
import kotlinx.a.c;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Element", "Array", "Builder", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlinx/serialization/internal/ListLikeSerializer;", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "()Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "empty", "()Ljava/lang/Object;", "readElement", "", "Lkotlinx/serialization/CompositeDecoder;", "index", "", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILkotlinx/serialization/internal/PrimitiveArrayBuilder;Z)V", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "writeContent", "Lkotlinx/serialization/CompositeEncoder;", "content", "size", "(Lkotlinx/serialization/CompositeEncoder;Ljava/lang/Object;I)V", "builderSize", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)I", "checkCapacity", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "insert", "element", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;ILjava/lang/Object;)V", "toResult", "(Lkotlinx/serialization/internal/PrimitiveArrayBuilder;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public abstract class ax<Element, Array, Builder extends av<Array>>
  extends ai<Element, Array, Builder>
{
  final n Ois;
  
  public ax(h<Element> paramh)
  {
    super(paramh, (byte)0);
    this.Ois = ((n)new aw(paramh.eOR()));
  }
  
  public final Array a(c paramc)
  {
    p.h(paramc, "decoder");
    return a(paramc, gBy());
  }
  
  protected abstract void a(b paramb, Array paramArray, int paramInt);
  
  public final void a(g paramg, Array paramArray)
  {
    p.h(paramg, "encoder");
    int i = ge(paramArray);
    n localn = this.Ois;
    h[] arrayOfh = this.OjC;
    paramg = paramg.c(localn, (h[])Arrays.copyOf(arrayOfh, arrayOfh.length));
    a(paramg, paramArray, i);
    paramg.a(this.Ois);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
  
  protected abstract Array gBy();
  
  protected final Iterator<Element> gf(Array paramArray)
  {
    throw ((Throwable)new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ax
 * JD-Core Version:    0.7.0.1
 */