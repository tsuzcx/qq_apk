package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.a.b;
import kotlinx.a.b.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/HashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/HashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class m<K, V>
  extends aa<K, V, Map<K, ? extends V>, HashMap<K, V>>
{
  private final e Wki;
  
  public m(b<K> paramb, b<V> paramb1)
  {
    super(paramb, paramb1, (byte)0);
    AppMethodBeat.i(188606);
    this.Wki = ((e)new l(paramb.iou(), paramb1.iou()));
    AppMethodBeat.o(188606);
  }
  
  public final e iou()
  {
    return this.Wki;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.m
 * JD-Core Version:    0.7.0.1
 */