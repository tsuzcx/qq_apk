package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.b.e;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/encoding/Encoder;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginCollection", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", "index", "encodeFloat", "", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract interface f
{
  public abstract void BS(long paramLong);
  
  public abstract void K(char paramChar);
  
  public abstract void PO(boolean paramBoolean);
  
  public abstract <T> void a(g<? super T> paramg, T paramT);
  
  public abstract void aML(int paramInt);
  
  public abstract void al(double paramDouble);
  
  public abstract d b(e parame, kotlinx.a.b<?>... paramVarArgs);
  
  public abstract void bJO(String paramString);
  
  public abstract d c(e parame, kotlinx.a.b<?>... paramVarArgs);
  
  public abstract d d(e parame, int paramInt);
  
  public abstract d e(e parame);
  
  public abstract void eJ(float paramFloat);
  
  public abstract void i(short paramShort);
  
  public abstract kotlinx.a.f.b kFe();
  
  public abstract void kFs();
  
  public abstract void q(byte paramByte);
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 4, 0})
  public static final class a
  {
    public static d a(f paramf, e parame, int paramInt)
    {
      AppMethodBeat.i(188418);
      s.u(parame, "descriptor");
      paramf = paramf.c(parame, new kotlinx.a.b[0]);
      AppMethodBeat.o(188418);
      return paramf;
    }
    
    public static d a(f paramf, e parame, kotlinx.a.b<?>... paramVarArgs)
    {
      AppMethodBeat.i(188423);
      s.u(parame, "descriptor");
      s.u(paramVarArgs, "typeSerializers");
      paramf = paramf.e(parame);
      AppMethodBeat.o(188423);
      return paramf;
    }
    
    public static <T> void a(f paramf, g<? super T> paramg, T paramT)
    {
      AppMethodBeat.i(188426);
      s.u(paramg, "serializer");
      if (paramT == null)
      {
        paramf.kFs();
        AppMethodBeat.o(188426);
        return;
      }
      paramf.a(paramg, paramT);
      AppMethodBeat.o(188426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.c.f
 * JD-Core Version:    0.7.0.1
 */