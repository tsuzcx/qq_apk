package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/Encoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginCollection", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "collectionSize", "", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;I[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", "index", "encodeFloat", "", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "encodeUnit", "kotlinx-serialization-runtime"})
public abstract interface g
{
  public abstract void JK(boolean paramBoolean);
  
  public abstract void Q(char paramChar);
  
  public abstract void Q(double paramDouble);
  
  public abstract void XG(long paramLong);
  
  public abstract <T> void a(v<? super T> paramv, T paramT);
  
  public abstract void aFW(int paramInt);
  
  public abstract b b(n paramn, h<?>... paramVarArgs);
  
  public abstract void bHH(String paramString);
  
  public abstract b c(n paramn, h<?>... paramVarArgs);
  
  public abstract void jdMethod_do(float paramFloat);
  
  public abstract void e(short paramShort);
  
  public abstract void iTD();
  
  public abstract kotlinx.a.d.b iTq();
  
  public abstract void m(byte paramByte);
  
  @l(iBK={1, 1, 16})
  public static final class a
  {
    public static b a(g paramg, n paramn, h<?>... paramVarArgs)
    {
      AppMethodBeat.i(254145);
      p.k(paramn, "descriptor");
      p.k(paramVarArgs, "typeSerializers");
      paramg = paramg.b(paramn, (h[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(254145);
      return paramg;
    }
    
    public static <T> void a(g paramg, v<? super T> paramv, T paramT)
    {
      AppMethodBeat.i(254146);
      p.k(paramv, "serializer");
      if (paramT == null)
      {
        paramg.iTD();
        AppMethodBeat.o(254146);
        return;
      }
      paramg.a(paramv, paramT);
      AppMethodBeat.o(254146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.g
 * JD-Core Version:    0.7.0.1
 */