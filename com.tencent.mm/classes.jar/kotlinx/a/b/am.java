package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.o;
import kotlinx.a.p;
import kotlinx.a.s;
import kotlinx.a.w.c;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/MapEntrySerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "key", "getKey", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "MapEntry", "kotlinx-serialization-runtime"})
public final class am<K, V>
  extends ac<K, V, Map.Entry<? extends K, ? extends V>>
{
  private final n abAF;
  
  public am(h<K> paramh, final h<V> paramh1)
  {
    super(paramh, paramh1, (byte)0);
    AppMethodBeat.i(254247);
    this.abAF = p.a("kotlin.collections.Map.Entry", (s)w.c.abBj, (b)new b(paramh, paramh1));
    AppMethodBeat.o(254247);
  }
  
  public final n gPe()
  {
    return this.abAF;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "K", "V", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class b
    extends q
    implements b<o, x>
  {
    b(h paramh1, h paramh2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.am
 * JD-Core Version:    0.7.0.1
 */