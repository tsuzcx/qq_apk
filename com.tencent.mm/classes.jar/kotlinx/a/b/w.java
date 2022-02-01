package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Map;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/HashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/HashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class w<K, V>
  extends ao<K, V, Map<K, ? extends V>, HashMap<K, V>>
{
  private final n Ois;
  
  public w(h<K> paramh, h<V> paramh1)
  {
    super(paramh, paramh1, (byte)0);
    AppMethodBeat.i(199726);
    this.Ois = ((n)new v(paramh.eOR(), paramh1.eOR()));
    AppMethodBeat.o(199726);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.w
 * JD-Core Version:    0.7.0.1
 */