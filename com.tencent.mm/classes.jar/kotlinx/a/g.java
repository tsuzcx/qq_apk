package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/Encoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginCollection", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "collectionSize", "", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;I[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", "index", "encodeFloat", "", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "encodeUnit", "kotlinx-serialization-runtime"})
public abstract interface g
{
  public abstract void F(char paramChar);
  
  public abstract void Fb(boolean paramBoolean);
  
  public abstract void O(double paramDouble);
  
  public abstract void Pq(long paramLong);
  
  public abstract <T> void a(v<? super T> paramv, T paramT);
  
  public abstract void awb(int paramInt);
  
  public abstract b b(n paramn, h<?>... paramVarArgs);
  
  public abstract void buE(String paramString);
  
  public abstract b c(n paramn, h<?>... paramVarArgs);
  
  public abstract void cU(float paramFloat);
  
  public abstract void d(short paramShort);
  
  public abstract kotlinx.a.d.b hOk();
  
  public abstract void hOx();
  
  public abstract void m(byte paramByte);
  
  @l(hxD={1, 1, 16})
  public static final class a
  {
    public static b a(g paramg, n paramn, h<?>... paramVarArgs)
    {
      AppMethodBeat.i(225357);
      p.h(paramn, "descriptor");
      p.h(paramVarArgs, "typeSerializers");
      paramg = paramg.b(paramn, (h[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(225357);
      return paramg;
    }
    
    public static <T> void a(g paramg, v<? super T> paramv, T paramT)
    {
      AppMethodBeat.i(225358);
      p.h(paramv, "serializer");
      if (paramT == null)
      {
        paramg.hOx();
        AppMethodBeat.o(225358);
        return;
      }
      paramg.a(paramv, paramT);
      AppMethodBeat.o(225358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.g
 * JD-Core Version:    0.7.0.1
 */