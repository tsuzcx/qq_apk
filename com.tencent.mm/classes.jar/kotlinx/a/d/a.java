package kotlinx.a.d;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b;
import kotlinx.a.c.c;
import kotlinx.a.c.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "()V", "builder", "()Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "merge", "previous", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "readAll", "", "Lkotlinx/serialization/encoding/CompositeDecoder;", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "builderSize", "(Ljava/lang/Object;)I", "checkCapacity", "(Ljava/lang/Object;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "toBuilder", "(Ljava/lang/Object;)Ljava/lang/Object;", "toResult", "Lkotlinx/serialization/internal/ListLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class a<Element, Collection, Builder>
  implements b<Collection>
{
  public final Collection a(e parame)
  {
    s.u(parame, "decoder");
    s.u(parame, "decoder");
    Object localObject = kFt();
    int i = jt(localObject);
    parame = parame.c(iou());
    int j;
    if (parame.kFr())
    {
      j = parame.d(iou());
      z(localObject, j);
      a(parame, localObject, i, j);
      parame.b(iou());
      return ju(localObject);
    }
    for (;;)
    {
      j = parame.g(iou());
      if (j == -1) {
        break;
      }
      a(parame, j + i, localObject, true);
    }
  }
  
  protected abstract void a(c paramc, int paramInt, Builder paramBuilder, boolean paramBoolean);
  
  protected abstract void a(c paramc, Builder paramBuilder, int paramInt1, int paramInt2);
  
  protected abstract int jr(Collection paramCollection);
  
  protected abstract Iterator<Element> js(Collection paramCollection);
  
  protected abstract int jt(Builder paramBuilder);
  
  protected abstract Collection ju(Builder paramBuilder);
  
  protected abstract Builder kFt();
  
  protected abstract void z(Builder paramBuilder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.a
 * JD-Core Version:    0.7.0.1
 */