package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/LinkedHashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class ae<K, V>
  extends ao<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>>
{
  private final n NLm;
  
  public ae(h<K> paramh, h<V> paramh1)
  {
    super(paramh, paramh1, (byte)0);
    AppMethodBeat.i(191084);
    this.NLm = ((n)new ad(paramh.eLj(), paramh1.eLj()));
    AppMethodBeat.o(191084);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.ae
 * JD-Core Version:    0.7.0.1
 */