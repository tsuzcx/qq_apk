package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"decode", "T", "", "Lkotlinx/serialization/Decoder;", "(Lkotlinx/serialization/Decoder;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/Decoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/CompositeDecoder;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/Decoder;Lkotlinx/serialization/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-runtime"})
public final class e
{
  public static final <T> T c(c paramc, f<T> paramf)
  {
    AppMethodBeat.i(225366);
    p.h(paramc, "$this$decode");
    p.h(paramf, "deserializer");
    paramc = paramc.a(paramf);
    AppMethodBeat.o(225366);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.e
 * JD-Core Version:    0.7.0.1
 */