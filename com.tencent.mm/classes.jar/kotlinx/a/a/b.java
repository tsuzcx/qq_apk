package kotlinx.a.a;

import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.d.a;
import kotlinx.a.g;
import kotlinx.a.g.a;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.v;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/builtins/AbstractEncoder;", "Lkotlinx/serialization/Encoder;", "Lkotlinx/serialization/CompositeEncoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeUnit", "encodeUnitElement", "encodeValue", "kotlinx-serialization-runtime"})
public abstract class b
  implements kotlinx.a.b, g
{
  private void gA(Object paramObject)
  {
    p.k(paramObject, "value");
    throw ((Throwable)new t("Non-serializable " + ab.bO(paramObject.getClass()) + " is not supported by " + ab.bO(getClass()) + " encoder", (byte)0));
  }
  
  public void JK(boolean paramBoolean)
  {
    gA(Boolean.valueOf(paramBoolean));
  }
  
  public void Q(char paramChar)
  {
    gA(Character.valueOf(paramChar));
  }
  
  public void Q(double paramDouble)
  {
    gA(Double.valueOf(paramDouble));
  }
  
  public void XG(long paramLong)
  {
    gA(Long.valueOf(paramLong));
  }
  
  public final void a(n paramn, int paramInt, byte paramByte)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    m(paramByte);
  }
  
  public final void a(n paramn, int paramInt, char paramChar)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    Q(paramChar);
  }
  
  public final void a(n paramn, int paramInt, double paramDouble)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    Q(paramDouble);
  }
  
  public final void a(n paramn, int paramInt, float paramFloat)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    jdMethod_do(paramFloat);
  }
  
  public final void a(n paramn, int paramInt1, int paramInt2)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt1);
    aFW(paramInt2);
  }
  
  public final void a(n paramn, int paramInt, long paramLong)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    XG(paramLong);
  }
  
  public final <T> void a(n paramn, int paramInt, v<? super T> paramv, T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramv, "serializer");
    j(paramn, paramInt);
    a(paramv, paramT);
  }
  
  public final void a(n paramn, int paramInt, short paramShort)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    e(paramShort);
  }
  
  public final void a(n paramn, int paramInt, boolean paramBoolean)
  {
    p.k(paramn, "descriptor");
    j(paramn, paramInt);
    JK(paramBoolean);
  }
  
  public final void a(n paramn, String paramString)
  {
    p.k(paramn, "descriptor");
    p.k(paramString, "value");
    j(paramn, 0);
    bHH(paramString);
  }
  
  public final <T> void a(n paramn, v<? super T> paramv, T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramv, "serializer");
    j(paramn, 5);
    b(paramv, paramT);
  }
  
  public <T> void a(v<? super T> paramv, T paramT)
  {
    p.k(paramv, "serializer");
    p.k(paramv, "serializer");
    paramv.a(this, paramT);
  }
  
  public void aFW(int paramInt)
  {
    gA(Integer.valueOf(paramInt));
  }
  
  public kotlinx.a.b b(n paramn, h<?>... paramVarArgs)
  {
    p.k(paramn, "descriptor");
    p.k(paramVarArgs, "typeSerializers");
    return (kotlinx.a.b)this;
  }
  
  public <T> void b(v<? super T> paramv, T paramT)
  {
    p.k(paramv, "serializer");
    g.a.a(this, paramv, paramT);
  }
  
  public void bHH(String paramString)
  {
    p.k(paramString, "value");
    gA(paramString);
  }
  
  public kotlinx.a.b c(n paramn, h<?>... paramVarArgs)
  {
    p.k(paramn, "descriptor");
    p.k(paramVarArgs, "typeSerializers");
    return g.a.a(this, paramn, paramVarArgs);
  }
  
  public boolean c(n paramn)
  {
    p.k(paramn, "descriptor");
    p.k(paramn, "descriptor");
    return true;
  }
  
  public void jdMethod_do(float paramFloat)
  {
    gA(Float.valueOf(paramFloat));
  }
  
  public void e(short paramShort)
  {
    gA(Short.valueOf(paramShort));
  }
  
  public void iTD()
  {
    throw ((Throwable)new t("'null' is not supported by default", (byte)0));
  }
  
  public kotlinx.a.d.b iTq()
  {
    return (kotlinx.a.d.b)a.abDW;
  }
  
  public boolean j(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return true;
  }
  
  public void m(byte paramByte)
  {
    gA(Byte.valueOf(paramByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.a.b
 * JD-Core Version:    0.7.0.1
 */