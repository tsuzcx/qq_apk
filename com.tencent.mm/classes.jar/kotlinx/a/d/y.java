package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlinx.a.b.a;
import kotlinx.a.b.e;
import kotlinx.a.b.h;
import kotlinx.a.b.i;
import kotlinx.a.b.j.c;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class y<K, V>
  extends q<K, V, Map.Entry<? extends K, ? extends V>>
{
  private final e Wki;
  
  public y(kotlinx.a.b<K> paramb, final kotlinx.a.b<V> paramb1)
  {
    super(paramb, paramb1, (byte)0);
    AppMethodBeat.i(188750);
    i locali = (i)j.c.ajDl;
    paramb = (kotlin.g.a.b)new b(paramb, paramb1);
    this.Wki = h.a("kotlin.collections.Map.Entry", locali, new e[0], paramb);
    AppMethodBeat.o(188750);
  }
  
  public final e iou()
  {
    return this.Wki;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "K", "V", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k=3, mv={1, 4, 0})
  static final class b
    extends u
    implements kotlin.g.a.b<a, ah>
  {
    b(kotlinx.a.b paramb1, kotlinx.a.b paramb2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.y
 * JD-Core Version:    0.7.0.1
 */