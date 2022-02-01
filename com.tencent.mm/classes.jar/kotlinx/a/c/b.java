package kotlinx.a.c;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.b.e;
import kotlinx.a.f.c;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/encoding/AbstractEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeValue", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class b
  implements d, f
{
  private void jq(Object paramObject)
  {
    s.u(paramObject, "value");
    throw ((Throwable)new kotlinx.a.f("Non-serializable " + ai.cz(paramObject.getClass()) + " is not supported by " + ai.cz(getClass()) + " encoder"));
  }
  
  public void BS(long paramLong)
  {
    jq(Long.valueOf(paramLong));
  }
  
  public void K(char paramChar)
  {
    jq(Character.valueOf(paramChar));
  }
  
  public void PO(boolean paramBoolean)
  {
    jq(Boolean.valueOf(paramBoolean));
  }
  
  public final void a(e parame, int paramInt1, int paramInt2)
  {
    s.u(parame, "descriptor");
    if (c(parame, paramInt1)) {
      aML(paramInt2);
    }
  }
  
  public final <T> void a(e parame, int paramInt, g<? super T> paramg, T paramT)
  {
    s.u(parame, "descriptor");
    s.u(paramg, "serializer");
    if (c(parame, paramInt)) {
      a(paramg, paramT);
    }
  }
  
  public final void a(e parame, String paramString)
  {
    s.u(parame, "descriptor");
    s.u(paramString, "value");
    if (c(parame, 0)) {
      bJO(paramString);
    }
  }
  
  public final <T> void a(e parame, g<? super T> paramg, T paramT)
  {
    s.u(parame, "descriptor");
    s.u(paramg, "serializer");
    if (c(parame, 5)) {
      b(paramg, paramT);
    }
  }
  
  public <T> void a(g<? super T> paramg, T paramT)
  {
    s.u(paramg, "serializer");
    s.u(paramg, "serializer");
    paramg.a(this, paramT);
  }
  
  public void aML(int paramInt)
  {
    jq(Integer.valueOf(paramInt));
  }
  
  public void al(double paramDouble)
  {
    jq(Double.valueOf(paramDouble));
  }
  
  public final d b(e parame, kotlinx.a.b<?>... paramVarArgs)
  {
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeSerializers");
    return (d)this;
  }
  
  public <T> void b(g<? super T> paramg, T paramT)
  {
    s.u(paramg, "serializer");
    f.a.a(this, paramg, paramT);
  }
  
  public void bJO(String paramString)
  {
    s.u(paramString, "value");
    jq(paramString);
  }
  
  public d c(e parame, kotlinx.a.b<?>... paramVarArgs)
  {
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeSerializers");
    return f.a.a(this, parame, paramVarArgs);
  }
  
  public boolean c(e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return true;
  }
  
  public d d(e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return f.a.a(this, parame, paramInt);
  }
  
  public d e(e parame)
  {
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    return b(parame, new kotlinx.a.b[0]);
  }
  
  public void eJ(float paramFloat)
  {
    jq(Float.valueOf(paramFloat));
  }
  
  public boolean f(e parame)
  {
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    return true;
  }
  
  public void i(short paramShort)
  {
    jq(Short.valueOf(paramShort));
  }
  
  public kotlinx.a.f.b kFe()
  {
    return c.kFP();
  }
  
  public void kFs()
  {
    throw ((Throwable)new kotlinx.a.f("'null' is not supported by default"));
  }
  
  public void q(byte paramByte)
  {
    jq(Byte.valueOf(paramByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.c.b
 * JD-Core Version:    0.7.0.1
 */