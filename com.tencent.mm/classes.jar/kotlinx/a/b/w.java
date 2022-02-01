package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Map;
import kotlinx.a.h;
import kotlinx.a.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/HashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "", "collectionSize", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/HashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-runtime"})
public final class w<K, V>
  extends ao<K, V, Map<K, ? extends V>, HashMap<K, V>>
{
  private final n NLm;
  
  public w(h<K> paramh, h<V> paramh1)
  {
    super(paramh, paramh1, (byte)0);
    AppMethodBeat.i(191138);
    this.NLm = ((n)new v(paramh.eLj(), paramh1.eLj()));
    AppMethodBeat.o(191138);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.w
 * JD-Core Version:    0.7.0.1
 */