package kotlinx.a.b;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.b;
import kotlinx.a.f;
import kotlinx.a.g;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ListLikeSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "elementSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "[Lkotlinx/serialization/KSerializer;", "readAll", "", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "insert", "element", "(Ljava/lang/Object;ILjava/lang/Object;)V", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlinx/serialization/internal/ReferenceArraySerializer;", "Lkotlinx/serialization/internal/ArrayListSerializer;", "Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "Lkotlinx/serialization/internal/HashSetSerializer;", "kotlinx-serialization-runtime"})
public abstract class ai<Element, Collection, Builder>
  extends a<Element, Collection, Builder>
{
  private final h<?>[] abBM;
  private final h<Element> abBN;
  
  private ai(h<Element> paramh)
  {
    super((byte)0);
    this.abBN = paramh;
    this.abBM = new h[] { this.abBN };
  }
  
  public abstract void a(Builder paramBuilder, int paramInt, Element paramElement);
  
  protected void a(kotlinx.a.a parama, int paramInt, Builder paramBuilder, boolean paramBoolean)
  {
    p.k(parama, "decoder");
    a(paramBuilder, paramInt, parama.a(gPe(), paramInt, (f)this.abBN));
  }
  
  public void a(g paramg, Collection paramCollection)
  {
    p.k(paramg, "encoder");
    int j = gB(paramCollection);
    n localn = gPe();
    h[] arrayOfh = this.abBM;
    paramg = paramg.c(localn, (h[])Arrays.copyOf(arrayOfh, arrayOfh.length));
    paramCollection = gC(paramCollection);
    int i = 0;
    while (i < j)
    {
      paramg.a(gPe(), i, (v)this.abBN, paramCollection.next());
      i += 1;
    }
    paramg.a(gPe());
  }
  
  public abstract n gPe();
  
  public final h<?>[] iTM()
  {
    return this.abBM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.ai
 * JD-Core Version:    0.7.0.1
 */