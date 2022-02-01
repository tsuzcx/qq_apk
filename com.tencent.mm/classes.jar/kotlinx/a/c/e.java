package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.a;
import kotlinx.a.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/encoding/Decoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode$annotations", "()V", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeBoolean", "", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeEnum", "", "enumDescriptor", "decodeFloat", "", "decodeInt", "decodeLong", "", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableValue", "decodeShort", "", "decodeString", "", "updateNullableSerializableValue", "old", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableValue", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract interface e
{
  public abstract c a(kotlinx.a.b.e parame, b<?>... paramVarArgs);
  
  public abstract <T> T b(a<T> parama);
  
  public abstract c c(kotlinx.a.b.e parame);
  
  public abstract boolean kFg();
  
  public abstract Void kFh();
  
  public abstract boolean kFi();
  
  public abstract byte kFj();
  
  public abstract short kFk();
  
  public abstract int kFl();
  
  public abstract long kFm();
  
  public abstract float kFn();
  
  public abstract double kFo();
  
  public abstract char kFp();
  
  public abstract String kFq();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 4, 0})
  public static final class a
  {
    public static <T> T a(e parame, a<T> parama)
    {
      AppMethodBeat.i(188414);
      s.u(parama, "deserializer");
      parame = parama.a(parame);
      AppMethodBeat.o(188414);
      return parame;
    }
    
    public static c a(e parame, kotlinx.a.b.e parame1)
    {
      AppMethodBeat.i(188410);
      s.u(parame1, "descriptor");
      parame = parame.a(parame1, new b[0]);
      AppMethodBeat.o(188410);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.c.e
 * JD-Core Version:    0.7.0.1
 */