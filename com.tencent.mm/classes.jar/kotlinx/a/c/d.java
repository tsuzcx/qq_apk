package kotlinx.a.c;

import kotlin.Metadata;
import kotlinx.a.b.e;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/encoding/CompositeEncoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeBooleanElement", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "value", "", "encodeByteElement", "", "encodeCharElement", "", "encodeDoubleElement", "", "encodeFloatElement", "", "encodeIntElement", "encodeLongElement", "", "encodeNonSerializableElement", "encodeNullableSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShortElement", "", "encodeStringElement", "", "endStructure", "shouldEncodeElementDefault", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract interface d
{
  public abstract void a(e parame, int paramInt1, int paramInt2);
  
  public abstract <T> void a(e parame, int paramInt, g<? super T> paramg, T paramT);
  
  public abstract void a(e parame, String paramString);
  
  public abstract <T> void a(e parame, g<? super T> paramg, T paramT);
  
  public abstract void b(e parame);
  
  public abstract boolean f(e parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c.d
 * JD-Core Version:    0.7.0.1
 */