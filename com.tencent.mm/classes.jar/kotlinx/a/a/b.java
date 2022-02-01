package kotlinx.a.a;

import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.a;
import kotlinx.a.g;
import kotlinx.a.g.a;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.v;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/builtins/AbstractEncoder;", "Lkotlinx/serialization/Encoder;", "Lkotlinx/serialization/CompositeEncoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeUnit", "encodeUnitElement", "encodeValue", "kotlinx-serialization-runtime"})
public abstract class b
  implements kotlinx.a.b, g
{
  private void gi(Object paramObject)
  {
    p.h(paramObject, "value");
    throw ((Throwable)new t("Non-serializable " + aa.bp(paramObject.getClass()) + " is not supported by " + aa.bp(getClass()) + " encoder", (byte)0));
  }
  
  public void F(char paramChar)
  {
    gi(Character.valueOf(paramChar));
  }
  
  public void Fb(boolean paramBoolean)
  {
    gi(Boolean.valueOf(paramBoolean));
  }
  
  public void O(double paramDouble)
  {
    gi(Double.valueOf(paramDouble));
  }
  
  public void Pq(long paramLong)
  {
    gi(Long.valueOf(paramLong));
  }
  
  public final void a(n paramn, int paramInt, byte paramByte)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    m(paramByte);
  }
  
  public final void a(n paramn, int paramInt, char paramChar)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    F(paramChar);
  }
  
  public final void a(n paramn, int paramInt, double paramDouble)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    O(paramDouble);
  }
  
  public final void a(n paramn, int paramInt, float paramFloat)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    cU(paramFloat);
  }
  
  public final void a(n paramn, int paramInt1, int paramInt2)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt1);
    awb(paramInt2);
  }
  
  public final void a(n paramn, int paramInt, long paramLong)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    Pq(paramLong);
  }
  
  public final <T> void a(n paramn, int paramInt, v<? super T> paramv, T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramv, "serializer");
    j(paramn, paramInt);
    a(paramv, paramT);
  }
  
  public final void a(n paramn, int paramInt, short paramShort)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    d(paramShort);
  }
  
  public final void a(n paramn, int paramInt, boolean paramBoolean)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    Fb(paramBoolean);
  }
  
  public final void a(n paramn, String paramString)
  {
    p.h(paramn, "descriptor");
    p.h(paramString, "value");
    j(paramn, 0);
    buE(paramString);
  }
  
  public final <T> void a(n paramn, v<? super T> paramv, T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramv, "serializer");
    j(paramn, 5);
    b(paramv, paramT);
  }
  
  public <T> void a(v<? super T> paramv, T paramT)
  {
    p.h(paramv, "serializer");
    p.h(paramv, "serializer");
    paramv.a(this, paramT);
  }
  
  public void awb(int paramInt)
  {
    gi(Integer.valueOf(paramInt));
  }
  
  public kotlinx.a.b b(n paramn, h<?>... paramVarArgs)
  {
    p.h(paramn, "descriptor");
    p.h(paramVarArgs, "typeSerializers");
    return (kotlinx.a.b)this;
  }
  
  public <T> void b(v<? super T> paramv, T paramT)
  {
    p.h(paramv, "serializer");
    g.a.a(this, paramv, paramT);
  }
  
  public void buE(String paramString)
  {
    p.h(paramString, "value");
    gi(paramString);
  }
  
  public kotlinx.a.b c(n paramn, h<?>... paramVarArgs)
  {
    p.h(paramn, "descriptor");
    p.h(paramVarArgs, "typeSerializers");
    return g.a.a(this, paramn, paramVarArgs);
  }
  
  public boolean c(n paramn)
  {
    p.h(paramn, "descriptor");
    p.h(paramn, "descriptor");
    return true;
  }
  
  public void cU(float paramFloat)
  {
    gi(Float.valueOf(paramFloat));
  }
  
  public void d(short paramShort)
  {
    gi(Short.valueOf(paramShort));
  }
  
  public kotlinx.a.d.b hOk()
  {
    return (kotlinx.a.d.b)a.UaI;
  }
  
  public void hOx()
  {
    throw ((Throwable)new t("'null' is not supported by default", (byte)0));
  }
  
  public boolean j(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return true;
  }
  
  public void m(byte paramByte)
  {
    gi(Byte.valueOf(paramByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.a.b
 * JD-Core Version:    0.7.0.1
 */