package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.f;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/StringFormat;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "indented", "Lkotlinx/serialization/json/Json;", "indented$annotations", "getIndented", "()Lkotlinx/serialization/json/Json;", "jsonInstance", "message", "", "nonstrict", "nonstrict$annotations", "getNonstrict", "plain", "plain$annotations", "getPlain", "unquoted", "unquoted$annotations", "getUnquoted", "fromJson", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "json", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "", "tree", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "parse", "string", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "parseJson", "stringify", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "toJson", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-runtime"})
public final class a$a
{
  public static <T> T a(f<T> paramf, String paramString)
  {
    AppMethodBeat.i(225814);
    p.h(paramf, "deserializer");
    p.h(paramString, "string");
    paramf = a.hON().a(paramf, paramString);
    AppMethodBeat.o(225814);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */