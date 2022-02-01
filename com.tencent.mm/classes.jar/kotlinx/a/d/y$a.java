package kotlinx.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
final class y$a<K, V>
  implements Map.Entry<K, V>, a
{
  private final K key;
  private final V value;
  
  public y$a(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188761);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!s.p(getKey(), paramObject.getKey())) || (!s.p(getValue(), paramObject.getValue()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(188761);
      return true;
    }
    AppMethodBeat.o(188761);
    return false;
  }
  
  public final K getKey()
  {
    return this.key;
  }
  
  public final V getValue()
  {
    return this.value;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(188752);
    Object localObject = getKey();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = getValue();
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(188752);
      return i * 31 + j;
    }
  }
  
  public final V setValue(V paramV)
  {
    AppMethodBeat.i(188767);
    paramV = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188767);
    throw paramV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188742);
    String str = "MapEntry(key=" + getKey() + ", value=" + getValue() + ")";
    AppMethodBeat.o(188742);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.d.y.a
 * JD-Core Version:    0.7.0.1
 */