package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/collections/EmptyMap;", "", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "serialVersionUID", "", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "get", "hashCode", "isEmpty", "readResolve", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ac
  implements Serializable, Map, a
{
  public static final ac aivz;
  
  static
  {
    AppMethodBeat.i(129139);
    aivz = new ac();
    AppMethodBeat.o(129139);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(129140);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129140);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    return false;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(129138);
    if (!(paramObject instanceof Void))
    {
      AppMethodBeat.o(129138);
      return false;
    }
    s.u((Void)paramObject, "value");
    AppMethodBeat.o(129138);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129137);
    if (((paramObject instanceof Map)) && (((Map)paramObject).isEmpty()))
    {
      AppMethodBeat.o(129137);
      return true;
    }
    AppMethodBeat.o(129137);
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final boolean isEmpty()
  {
    return true;
  }
  
  public final void putAll(Map paramMap)
  {
    AppMethodBeat.i(129141);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129141);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(129142);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(129142);
    throw paramObject;
  }
  
  public final String toString()
  {
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ac
 * JD-Core Version:    0.7.0.1
 */