package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"boolean", "", "Lkotlinx/serialization/json/JsonPrimitive;", "getBoolean", "(Lkotlinx/serialization/json/JsonPrimitive;)Z", "booleanOrNull", "getBooleanOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Boolean;", "contentOrNull", "", "getContentOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/String;", "double", "", "getDouble", "(Lkotlinx/serialization/json/JsonPrimitive;)D", "doubleOrNull", "getDoubleOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Double;", "float", "", "getFloat", "(Lkotlinx/serialization/json/JsonPrimitive;)F", "floatOrNull", "getFloatOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Float;", "int", "", "getInt", "(Lkotlinx/serialization/json/JsonPrimitive;)I", "intOrNull", "getIntOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Integer;", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "Lkotlinx/serialization/json/JsonElement;", "getJsonArray", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonArray;", "jsonNull", "Lkotlinx/serialization/json/JsonNull;", "getJsonNull", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonNull;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "getJsonObject", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonObject;", "jsonPrimitive", "getJsonPrimitive", "(Lkotlinx/serialization/json/JsonElement;)Lkotlinx/serialization/json/JsonPrimitive;", "long", "", "getLong", "(Lkotlinx/serialization/json/JsonPrimitive;)J", "longOrNull", "getLongOrNull", "(Lkotlinx/serialization/json/JsonPrimitive;)Ljava/lang/Long;", "JsonPrimitive", "value", "(Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonPrimitive;", "", "unexpectedJson", "", "key", "expected", "error", "element", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class f
{
  public static final int a(n paramn)
  {
    AppMethodBeat.i(188486);
    s.u(paramn, "$this$int");
    int i = Integer.parseInt(paramn.getContent());
    AppMethodBeat.o(188486);
    return i;
  }
  
  public static final n a(e parame)
  {
    AppMethodBeat.i(188478);
    s.u(parame, "$this$jsonPrimitive");
    if (!(parame instanceof n)) {}
    for (Object localObject = null;; localObject = parame)
    {
      localObject = (n)localObject;
      if (localObject == null)
      {
        parame = (Throwable)new IllegalArgumentException("Element " + ai.cz(parame.getClass()) + " is not a " + "JsonPrimitive");
        AppMethodBeat.o(188478);
        throw parame;
      }
      AppMethodBeat.o(188478);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.e.f
 * JD-Core Version:    0.7.0.1
 */