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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-runtime"})
public abstract class ai<Element, Collection, Builder>
  extends a<Element, Collection, Builder>
{
  final h<?>[] NMw;
  private final h<Element> NMx;
  
  private ai(h<Element> paramh)
  {
    super((byte)0);
    this.NMx = paramh;
    this.NMw = new h[] { this.NMx };
  }
  
  public abstract void a(Builder paramBuilder, int paramInt, Element paramElement);
  
  protected void a(kotlinx.a.a parama, int paramInt, Builder paramBuilder)
  {
    p.h(parama, "decoder");
    a(paramBuilder, paramInt, parama.a(eLj(), paramInt, (f)this.NMx));
  }
  
  public void a(g paramg, Collection paramCollection)
  {
    p.h(paramg, "encoder");
    int j = gb(paramCollection);
    n localn = eLj();
    h[] arrayOfh = this.NMw;
    paramg = paramg.c(localn, (h[])Arrays.copyOf(arrayOfh, arrayOfh.length));
    paramCollection = gc(paramCollection);
    int i = 0;
    while (i < j)
    {
      paramg.a(eLj(), i, (v)this.NMx, paramCollection.next());
      i += 1;
    }
    paramg.a(eLj());
  }
  
  public abstract n eLj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ai
 * JD-Core Version:    0.7.0.1
 */