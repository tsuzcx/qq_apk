package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonObject;", "Lkotlinx/serialization/json/JsonElement;", "", "", "content", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "jsonObject", "getJsonObject", "()Lkotlinx/serialization/json/JsonObject;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "component1", "containsKey", "", "key", "containsValue", "value", "copy", "equals", "other", "", "get", "getArray", "Lkotlinx/serialization/json/JsonArray;", "getArrayOrNull", "getAs", "J", "(Ljava/lang/String;)Lkotlinx/serialization/json/JsonElement;", "getAsOrNull", "getObject", "getObjectOrNull", "getPrimitive", "Lkotlinx/serialization/json/JsonPrimitive;", "getPrimitiveOrNull", "hashCode", "isEmpty", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class s
  extends f
  implements Map<String, f>, a
{
  public static final a abDm;
  private final s abDk;
  public final Map<String, f> abDl;
  
  static
  {
    AppMethodBeat.i(256998);
    abDm = new a((byte)0);
    AppMethodBeat.o(256998);
  }
  
  public s(Map<String, ? extends f> paramMap)
  {
    super((byte)0);
    AppMethodBeat.i(256997);
    this.abDl = paramMap;
    this.abDk = ((s)this);
    AppMethodBeat.o(256997);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(257010);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(257010);
    throw localUnsupportedOperationException;
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(257003);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(257003);
      return false;
    }
    paramObject = (String)paramObject;
    p.k(paramObject, "key");
    boolean bool = this.abDl.containsKey(paramObject);
    AppMethodBeat.o(257003);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(257006);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(257006);
      return false;
    }
    paramObject = (f)paramObject;
    p.k(paramObject, "value");
    boolean bool = this.abDl.containsValue(paramObject);
    AppMethodBeat.o(257006);
    return bool;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256994);
    boolean bool = p.h(this.abDl, paramObject);
    AppMethodBeat.o(256994);
    return bool;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(257007);
    if (!(paramObject instanceof String))
    {
      AppMethodBeat.o(257007);
      return null;
    }
    paramObject = (String)paramObject;
    p.k(paramObject, "key");
    paramObject = (f)this.abDl.get(paramObject);
    AppMethodBeat.o(257007);
    return paramObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256996);
    int i = this.abDl.hashCode();
    AppMethodBeat.o(256996);
    return i;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(257009);
    boolean bool = this.abDl.isEmpty();
    AppMethodBeat.o(257009);
    return bool;
  }
  
  public final void putAll(Map<? extends String, ? extends f> paramMap)
  {
    AppMethodBeat.i(257013);
    paramMap = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(257013);
    throw paramMap;
  }
  
  public final Object remove(Object paramObject)
  {
    AppMethodBeat.i(257014);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(257014);
    throw paramObject;
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(257015);
    paramObject1 = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(257015);
    throw paramObject1;
  }
  
  public final void replaceAll(BiFunction<? super String, ? super f, ? extends f> paramBiFunction)
  {
    AppMethodBeat.i(257016);
    paramBiFunction = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(257016);
    throw paramBiFunction;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256993);
    String str = j.a((Iterable)this.abDl.entrySet(), (CharSequence)",", (CharSequence)"{", (CharSequence)"}", 0, null, (b)b.abDn, 24);
    AppMethodBeat.o(256993);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonObject$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonObject;", "kotlinx-serialization-runtime"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<name for destructuring parameter 0>", "", "Lkotlinx/serialization/json/JsonElement;", "invoke"})
  static final class b
    extends q
    implements b<Map.Entry<? extends String, ? extends f>, String>
  {
    public static final b abDn;
    
    static
    {
      AppMethodBeat.i(256487);
      abDn = new b();
      AppMethodBeat.o(256487);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c.s
 * JD-Core Version:    0.7.0.1
 */