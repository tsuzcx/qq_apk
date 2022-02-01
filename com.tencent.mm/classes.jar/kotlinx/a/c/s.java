package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.g.b.a.a;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.function.BiFunction;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "jsonObject", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", "key", "containsValue", "value", "copy", "equals", "other", "", "get", "getArray", "Lkotlinx/serialization/json/JsonArray;", "getArrayOrNull", "getAs", "J", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class s
  extends f
  implements a, Map<String, f>
{
  public static final a Olb;
  private final s OkZ;
  public final Map<String, f> Ola;
  
  static
  {
    AppMethodBeat.i(200049);
    Olb = new a((byte)0);
    AppMethodBeat.o(200049);
  }
  
  public s(Map<String, ? extends f> paramMap)
  {
    super((byte)0);
    AppMethodBeat.i(200048);
    this.Ola = paramMap;
    this.OkZ = ((s)this);
    AppMethodBeat.o(200048);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200058);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200058);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(200054);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(200054);
      return false;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    boolean bool = this.Ola.containsKey(paramObject);
    AppMethodBeat.o(200054);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(200055);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(200055);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "value");
    boolean bool = this.Ola.containsValue(paramObject);
    AppMethodBeat.o(200055);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200046);
    boolean bool = p.i(this.Ola, paramObject);
    AppMethodBeat.o(200046);
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(200056);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(200056);
      return null;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    paramObject = (f)this.Ola.get(paramObject);
    AppMethodBeat.o(200056);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(200047);
    int i = this.Ola.hashCode();
    AppMethodBeat.o(200047);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(200057);
    boolean bool = this.Ola.isEmpty();
    AppMethodBeat.o(200057);
    return bool;
  }
  
  public final void putAll(Map<? extends String, ? extends f> paramMap)
  {
    AppMethodBeat.i(200059);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200059);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(200060);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200060);
    throw paramObject;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(200061);
    paramObject1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200061);
    throw paramObject1;
  }
  
  public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> paramBiFunction)
  {
    AppMethodBeat.i(200062);
    paramBiFunction = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(200062);
    throw paramBiFunction;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200045);
    String str = j.a((Iterable)this.Ola.entrySet(), (CharSequence)",", (CharSequence)"{", (CharSequence)"}", 0, null, (b)s.b.Olc, 24);
    AppMethodBeat.o(200045);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.s
 * JD-Core Version:    0.7.0.1
 */