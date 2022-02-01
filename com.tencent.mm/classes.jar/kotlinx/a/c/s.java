package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.g.b.a.a;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.function.BiFunction;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "jsonObject", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", "key", "containsValue", "value", "copy", "equals", "other", "", "get", "getArray", "Lkotlinx/serialization/json/JsonArray;", "getArrayOrNull", "getAs", "J", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class s
  extends f
  implements a, Map<String, f>
{
  public static final a NNV;
  private final s NNT;
  public final Map<String, f> NNU;
  
  static
  {
    AppMethodBeat.i(191461);
    NNV = new a((byte)0);
    AppMethodBeat.o(191461);
  }
  
  public s(Map<String, ? extends f> paramMap)
  {
    super((byte)0);
    AppMethodBeat.i(191460);
    this.NNU = paramMap;
    this.NNT = ((s)this);
    AppMethodBeat.o(191460);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(191470);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191470);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(191466);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(191466);
      return false;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    boolean bool = this.NNU.containsKey(paramObject);
    AppMethodBeat.o(191466);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(191467);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(191467);
      return false;
    }
    paramObject = (f)paramObject;
    p.h(paramObject, "value");
    boolean bool = this.NNU.containsValue(paramObject);
    AppMethodBeat.o(191467);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191458);
    boolean bool = p.i(this.NNU, paramObject);
    AppMethodBeat.o(191458);
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(191468);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(191468);
      return null;
    }
    paramObject = (String)paramObject;
    p.h(paramObject, "key");
    paramObject = (f)this.NNU.get(paramObject);
    AppMethodBeat.o(191468);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191459);
    int i = this.NNU.hashCode();
    AppMethodBeat.o(191459);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(191469);
    boolean bool = this.NNU.isEmpty();
    AppMethodBeat.o(191469);
    return bool;
  }
  
  public final void putAll(Map<? extends String, ? extends f> paramMap)
  {
    AppMethodBeat.i(191471);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191471);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(191472);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191472);
    throw paramObject;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191473);
    paramObject1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191473);
    throw paramObject1;
  }
  
  public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> paramBiFunction)
  {
    AppMethodBeat.i(191474);
    paramBiFunction = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(191474);
    throw paramBiFunction;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191457);
    String str = j.a((Iterable)this.NNU.entrySet(), (CharSequence)",", (CharSequence)"{", (CharSequence)"}", 0, null, (b)s.b.NNW, 24);
    AppMethodBeat.o(191457);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.s
 * JD-Core Version:    0.7.0.1
 */