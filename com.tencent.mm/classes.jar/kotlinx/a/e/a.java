package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.e.a.c;
import kotlinx.a.e.a.e;
import kotlinx.a.e.a.k;
import kotlinx.a.e.a.q;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/Json;", "Lkotlinx/serialization/StringFormat;", "configuration", "Lkotlinx/serialization/json/internal/JsonConf;", "(Lkotlinx/serialization/json/internal/JsonConf;)V", "getConfiguration$kotlinx_serialization_runtime", "()Lkotlinx/serialization/json/internal/JsonConf;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "decodeFromJsonElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "element", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/DeserializationStrategy;Lkotlinx/serialization/json/JsonElement;)Ljava/lang/Object;", "decodeFromString", "string", "", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "encodeToJsonElement", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lkotlinx/serialization/json/JsonElement;", "encodeToString", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "parseToJsonElement", "Default", "Lkotlinx/serialization/json/JsonImpl;", "Lkotlinx/serialization/json/Json$Default;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class a
{
  public static final a ajEc = new a((byte)0);
  public final c ajEb;
  
  private a(c paramc)
  {
    this.ajEb = paramc;
  }
  
  public final <T> T a(kotlinx.a.a<T> parama, String paramString)
  {
    s.u(parama, "deserializer");
    s.u(paramString, "string");
    paramString = new e(paramString);
    parama = new k(this, q.ajER, paramString).b(parama);
    if (!paramString.isDone()) {
      throw ((Throwable)new IllegalStateException("Reader has not consumed the whole input: ".concat(String.valueOf(paramString)).toString()));
    }
    return parama;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/Json$Default;", "Lkotlinx/serialization/json/Json;", "()V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
  public static final class a
    extends a
  {
    private a()
    {
      super((byte)0);
      AppMethodBeat.i(188456);
      AppMethodBeat.o(188456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a
 * JD-Core Version:    0.7.0.1
 */