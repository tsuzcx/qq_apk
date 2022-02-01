package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "K", "V", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/serialization/internal/MapEntrySerializer$MapEntry;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-runtime"})
final class am$a<K, V>
  implements Map.Entry<K, V>, a
{
  private final K key;
  private final V value;
  
  public am$a(K paramK, V paramV)
  {
    this.key = paramK;
    this.value = paramV;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225578);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(getKey(), paramObject.getKey())) || (!p.j(getValue(), paramObject.getValue()))) {}
      }
    }
    else
    {
      AppMethodBeat.o(225578);
      return true;
    }
    AppMethodBeat.o(225578);
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
    AppMethodBeat.i(225577);
    Object localObject = getKey();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = getValue();
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(225577);
      return i * 31 + j;
    }
  }
  
  public final V setValue(V paramV)
  {
    AppMethodBeat.i(225579);
    paramV = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225579);
    throw paramV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225576);
    String str = "MapEntry(key=" + getKey() + ", value=" + getValue() + ")";
    AppMethodBeat.o(225576);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.am.a
 * JD-Core Version:    0.7.0.1
 */