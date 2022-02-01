package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.function.BiFunction;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "jsonObject", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", "key", "containsValue", "value", "copy", "equals", "other", "", "get", "getArray", "Lkotlinx/serialization/json/JsonArray;", "getArrayOrNull", "getAs", "J", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class s
  extends f
  implements Map<String, f>, a
{
  public static final s.a TZY;
  private final s TZW;
  public final Map<String, f> TZX;
  
  static
  {
    AppMethodBeat.i(225823);
    TZY = new s.a((byte)0);
    AppMethodBeat.o(225823);
  }
  
  public s(Map<String, ? extends f> paramMap)
  {
    super((byte)0);
    AppMethodBeat.i(225822);
    this.TZX = paramMap;
    this.TZW = ((s)this);
    AppMethodBeat.o(225822);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(225832);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225832);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(225828);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(225828);
      return false;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    boolean bool = this.TZX.containsKey(paramObject);
    AppMethodBeat.o(225828);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(225829);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(225829);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "value");
    boolean bool = this.TZX.containsValue(paramObject);
    AppMethodBeat.o(225829);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225820);
    boolean bool = p.j(this.TZX, paramObject);
    AppMethodBeat.o(225820);
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(225830);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(225830);
      return null;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    paramObject = (f)this.TZX.get(paramObject);
    AppMethodBeat.o(225830);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225821);
    int i = this.TZX.hashCode();
    AppMethodBeat.o(225821);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(225831);
    boolean bool = this.TZX.isEmpty();
    AppMethodBeat.o(225831);
    return bool;
  }
  
  public final void putAll(Map<? extends String, ? extends f> paramMap)
  {
    AppMethodBeat.i(225833);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225833);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(225834);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225834);
    throw paramObject;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(225835);
    paramObject1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225835);
    throw paramObject1;
  }
  
  public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> paramBiFunction)
  {
    AppMethodBeat.i(225836);
    paramBiFunction = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(225836);
    throw paramBiFunction;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225819);
    String str = j.a((Iterable)this.TZX.entrySet(), (CharSequence)",", (CharSequence)"{", (CharSequence)"}", 0, null, (b)s.b.TZZ, 24);
    AppMethodBeat.o(225819);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.s
 * JD-Core Version:    0.7.0.1
 */