package kotlinx.a.b;

import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.h;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "()V", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "builder", "()Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "readAll", "", "Lkotlinx/serialization/CompositeDecoder;", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;)I", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "builderSize", "(Ljava/lang/Object;)I", "checkCapacity", "(Ljava/lang/Object;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "toBuilder", "(Ljava/lang/Object;)Ljava/lang/Object;", "toResult", "Lkotlinx/serialization/internal/ListLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-runtime"})
public abstract class a<Element, Collection, Builder>
  implements h<Collection>
{
  public Collection a(c paramc)
  {
    p.k(paramc, "decoder");
    return a(paramc, gE(iTK()));
  }
  
  public final Collection a(c paramc, Collection paramCollection)
  {
    p.k(paramc, "decoder");
    paramCollection = gF(paramCollection);
    int i = gD(paramCollection);
    paramc = paramc.a(gPe(), new h[0]);
    for (;;)
    {
      int j = paramc.b(gPe());
      if (j == -1) {
        break;
      }
      a(paramc, j + i, paramCollection, true);
    }
    paramc.a(gPe());
    return gE(paramCollection);
  }
  
  protected abstract void a(kotlinx.a.a parama, int paramInt, Builder paramBuilder, boolean paramBoolean);
  
  protected abstract int gB(Collection paramCollection);
  
  protected abstract Iterator<Element> gC(Collection paramCollection);
  
  protected abstract int gD(Builder paramBuilder);
  
  protected abstract Collection gE(Builder paramBuilder);
  
  protected abstract Builder gF(Collection paramCollection);
  
  protected abstract Builder iTK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.a
 * JD-Core Version:    0.7.0.1
 */