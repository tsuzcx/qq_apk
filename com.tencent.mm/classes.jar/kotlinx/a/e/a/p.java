package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.e.m;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"readJson", "T", "Lkotlinx/serialization/json/Json;", "element", "Lkotlinx/serialization/json/JsonElement;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "readPolymorphicJson", "discriminator", "", "Lkotlinx/serialization/json/JsonObject;", "(Lkotlinx/serialization/json/Json;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class p
{
  public static final <T> T a(kotlinx.a.e.a parama, String paramString, m paramm, kotlinx.a.a<T> parama1)
  {
    AppMethodBeat.i(188539);
    s.u(parama, "$this$readPolymorphicJson");
    s.u(paramString, "discriminator");
    s.u(paramm, "element");
    s.u(parama1, "deserializer");
    parama = new g(parama, paramm, paramString, parama1.iou()).b(parama1);
    AppMethodBeat.o(188539);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.p
 * JD-Core Version:    0.7.0.1
 */