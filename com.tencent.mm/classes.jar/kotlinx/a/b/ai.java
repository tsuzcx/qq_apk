package kotlinx.a.b;

import d.g.b.p;
import d.l;
import java.util.Arrays;
import java.util.Iterator;
import kotlinx.a.b;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-runtime"})
public abstract class ai<Element, Collection, Builder>
  extends a<Element, Collection, Builder>
{
  final h<?>[] OjC;
  private final h<Element> OjD;
  
  private ai(h<Element> paramh)
  {
    super((byte)0);
    this.OjD = paramh;
    this.OjC = new h[] { this.OjD };
  }
  
  public abstract void a(Builder paramBuilder, int paramInt, Element paramElement);
  
  protected void a(kotlinx.a.a parama, int paramInt, Builder paramBuilder)
  {
    p.h(parama, "decoder");
    a(paramBuilder, paramInt, parama.a(eOR(), paramInt, (f)this.OjD));
  }
  
  public void a(g paramg, Collection paramCollection)
  {
    p.h(paramg, "encoder");
    int j = ge(paramCollection);
    n localn = eOR();
    h[] arrayOfh = this.OjC;
    paramg = paramg.c(localn, (h[])Arrays.copyOf(arrayOfh, arrayOfh.length));
    paramCollection = gf(paramCollection);
    int i = 0;
    while (i < j)
    {
      paramg.a(eOR(), i, (v)this.OjD, paramCollection.next());
      i += 1;
    }
    paramg.a(eOR());
  }
  
  public abstract n eOR();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ai
 * JD-Core Version:    0.7.0.1
 */