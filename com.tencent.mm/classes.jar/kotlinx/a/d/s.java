package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.a.b;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/LinkedHashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class s<K, V>
  extends aa<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>>
{
  private final e Wki;
  
  public s(b<K> paramb, b<V> paramb1)
  {
    super(paramb, paramb1, (byte)0);
    AppMethodBeat.i(188573);
    this.Wki = ((e)new r(paramb.iou(), paramb1.iou()));
    AppMethodBeat.o(188573);
  }
  
  public final e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.s
 * JD-Core Version:    0.7.0.1
 */