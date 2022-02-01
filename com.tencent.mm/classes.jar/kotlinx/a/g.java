package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/Encoder;", "", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginCollection", "Lkotlinx/serialization/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "collectionSize", "", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;I[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "beginStructure", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeByte", "", "encodeChar", "", "encodeDouble", "", "encodeEnum", "enumDescriptor", "index", "encodeFloat", "", "encodeInt", "encodeLong", "", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableValue", "encodeShort", "", "encodeString", "", "encodeUnit", "kotlinx-serialization-runtime"})
public abstract interface g
{
  public abstract void AL(boolean paramBoolean);
  
  public abstract void Gk(long paramLong);
  
  public abstract void H(char paramChar);
  
  public abstract void O(double paramDouble);
  
  public abstract <T> void a(v<? super T> paramv, T paramT);
  
  public abstract void ams(int paramInt);
  
  public abstract b b(n paramn, h<?>... paramVarArgs);
  
  public abstract void beP(String paramString);
  
  public abstract b c(n paramn, h<?>... paramVarArgs);
  
  public abstract void cq(float paramFloat);
  
  public abstract void d(short paramShort);
  
  public abstract void e(byte paramByte);
  
  public abstract kotlinx.a.d.b gBd();
  
  public abstract void gBq();
  
  @l(gjZ={1, 1, 16})
  public static final class a
  {
    public static b a(g paramg, n paramn, h<?>... paramVarArgs)
    {
      AppMethodBeat.i(199585);
      p.h(paramn, "descriptor");
      p.h(paramVarArgs, "typeSerializers");
      paramg = paramg.b(paramn, (h[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
      AppMethodBeat.o(199585);
      return paramg;
    }
    
    public static <T> void a(g paramg, v<? super T> paramv, T paramT)
    {
      AppMethodBeat.i(199586);
      p.h(paramv, "serializer");
      if (paramT == null)
      {
        paramg.gBq();
        AppMethodBeat.o(199586);
        return;
      }
      paramg.a(paramv, paramT);
      AppMethodBeat.o(199586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.g
 * JD-Core Version:    0.7.0.1
 */