package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.f;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/StringFormat;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "indented", "Lkotlinx/serialization/json/Json;", "indented$annotations", "getIndented", "()Lkotlinx/serialization/json/Json;", "jsonInstance", "message", "", "nonstrict", "nonstrict$annotations", "getNonstrict", "plain", "plain$annotations", "getPlain", "unquoted", "unquoted$annotations", "getUnquoted", "fromJson", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "json", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "", "tree", "(Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "parse", "string", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "parseJson", "stringify", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "toJson", "(Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-runtime"})
public final class a$a
{
  public static <T> T a(f<T> paramf, String paramString)
  {
    AppMethodBeat.i(256929);
    p.k(paramf, "deserializer");
    p.k(paramString, "string");
    paramf = a.iTU().a(paramf, paramString);
    AppMethodBeat.o(256929);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */