package kotlinx.a.b;

import d.g.b.p;
import d.l;
import java.util.Iterator;
import kotlinx.a.c;
import kotlinx.a.h;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "()V", "typeParams", "", "getTypeParams", "()[Lkotlinx/serialization/KSerializer;", "builder", "()Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "patch", "old", "(Lkotlinx/serialization/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "readAll", "", "Lkotlinx/serialization/CompositeDecoder;", "startIndex", "", "size", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/CompositeDecoder;Ljava/lang/Object;)I", "serialize", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)V", "builderSize", "(Ljava/lang/Object;)I", "checkCapacity", "(Ljava/lang/Object;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "toBuilder", "(Ljava/lang/Object;)Ljava/lang/Object;", "toResult", "Lkotlinx/serialization/internal/ListLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-runtime"})
public abstract class a<Element, Collection, Builder>
  implements h<Collection>
{
  public Collection a(c paramc)
  {
    p.h(paramc, "decoder");
    return a(paramc, ge(gwV()));
  }
  
  public final Collection a(c paramc, Collection paramCollection)
  {
    p.h(paramc, "decoder");
    paramCollection = gf(paramCollection);
    int i = gd(paramCollection);
    paramc = paramc.a(eLj(), new h[0]);
    for (;;)
    {
      int j = paramc.b(eLj());
      if (j == -1) {
        break;
      }
      a(paramc, j + i, paramCollection);
    }
    paramc.a(eLj());
    return ge(paramCollection);
  }
  
  protected abstract void a(kotlinx.a.a parama, int paramInt, Builder paramBuilder);
  
  protected abstract int gb(Collection paramCollection);
  
  protected abstract Iterator<Element> gc(Collection paramCollection);
  
  protected abstract int gd(Builder paramBuilder);
  
  protected abstract Collection ge(Builder paramBuilder);
  
  protected abstract Builder gf(Collection paramCollection);
  
  protected abstract Builder gwV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.a
 * JD-Core Version:    0.7.0.1
 */