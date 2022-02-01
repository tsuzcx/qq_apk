package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "containsValue", "value", "equals", "other", "", "get", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class m
  extends e
  implements Map<String, e>, a
{
  public static final a ajEj;
  private final Map<String, e> ajEi;
  
  static
  {
    AppMethodBeat.i(188481);
    ajEj = new a((byte)0);
    AppMethodBeat.o(188481);
  }
  
  public m(Map<String, ? extends e> paramMap)
  {
    super((byte)0);
    AppMethodBeat.i(188473);
    this.ajEi = paramMap;
    AppMethodBeat.o(188473);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(188616);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188616);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(188571);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(188571);
      return false;
    }
    paramObject = (String)paramObject;
    s.u(paramObject, "key");
    boolean bool = this.ajEi.containsKey(paramObject);
    AppMethodBeat.o(188571);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(188583);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(188583);
      return false;
    }
    paramObject = (e)paramObject;
    s.u(paramObject, "value");
    boolean bool = this.ajEi.containsValue(paramObject);
    AppMethodBeat.o(188583);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188493);
    boolean bool = s.p(this.ajEi, paramObject);
    AppMethodBeat.o(188493);
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(188594);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(188594);
      return null;
    }
    paramObject = (String)paramObject;
    s.u(paramObject, "key");
    paramObject = (e)this.ajEi.get(paramObject);
    AppMethodBeat.o(188594);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(188503);
    int i = this.ajEi.hashCode();
    AppMethodBeat.o(188503);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(188604);
    boolean bool = this.ajEi.isEmpty();
    AppMethodBeat.o(188604);
    return bool;
  }
  
  public final void putAll(Map<? extends String, ? extends e> paramMap)
  {
    AppMethodBeat.i(188630);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188630);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(188642);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188642);
    throw paramObject;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(188651);
    paramObject1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188651);
    throw paramObject1;
  }
  
  public final void replaceAll(BiFunction<? super String, ? super e, ? extends e> paramBiFunction)
  {
    AppMethodBeat.i(188663);
    paramBiFunction = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(188663);
    throw paramBiFunction;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188514);
    String str = p.a((Iterable)this.ajEi.entrySet(), (CharSequence)",", (CharSequence)"{", (CharSequence)"}", 0, null, (b)m.b.ajEk, 24);
    AppMethodBeat.o(188514);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.e.m
 * JD-Core Version:    0.7.0.1
 */