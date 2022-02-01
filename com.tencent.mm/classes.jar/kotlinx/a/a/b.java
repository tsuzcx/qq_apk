package kotlinx.a.a;

import d.g.b.p;
import d.g.b.z;
import d.l;
import kotlinx.a.d.a;
import kotlinx.a.g;
import kotlinx.a.g.a;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;
import kotlinx.a.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/builtins/AbstractEncoder;", "Lkotlinx/serialization/Encoder;", "Lkotlinx/serialization/CompositeEncoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeSerializers", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeEncoder;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeUnit", "encodeUnitElement", "encodeValue", "kotlinx-serialization-runtime"})
public abstract class b
  implements kotlinx.a.b, g
{
  private void ga(Object paramObject)
  {
    p.h(paramObject, "value");
    throw ((Throwable)new t("Non-serializable " + z.bp(paramObject.getClass()) + " is not supported by " + z.bp(getClass()) + " encoder", (byte)0));
  }
  
  public void Ay(boolean paramBoolean)
  {
    ga(Boolean.valueOf(paramBoolean));
  }
  
  public void FI(long paramLong)
  {
    ga(Long.valueOf(paramLong));
  }
  
  public void H(char paramChar)
  {
    ga(Character.valueOf(paramChar));
  }
  
  public void N(double paramDouble)
  {
    ga(Double.valueOf(paramDouble));
  }
  
  public final void a(n paramn, int paramInt, byte paramByte)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    e(paramByte);
  }
  
  public final void a(n paramn, int paramInt, char paramChar)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    H(paramChar);
  }
  
  public final void a(n paramn, int paramInt, double paramDouble)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    N(paramDouble);
  }
  
  public final void a(n paramn, int paramInt, float paramFloat)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    cs(paramFloat);
  }
  
  public final void a(n paramn, int paramInt1, int paramInt2)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt1);
    alI(paramInt2);
  }
  
  public final void a(n paramn, int paramInt, long paramLong)
  {
    p.h(paramn, "descriptor");
    j(paramn, paramInt);
    FI(paramLong);
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
    Ay(paramBoolean);
  }
  
  public final void a(n paramn, String paramString)
  {
    p.h(paramn, "descriptor");
    p.h(paramString, "value");
    j(paramn, 0);
    bdl(paramString);
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
  
  public void alI(int paramInt)
  {
    ga(Integer.valueOf(paramInt));
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
  
  public void bdl(String paramString)
  {
    p.h(paramString, "value");
    ga(paramString);
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
  
  public void cs(float paramFloat)
  {
    ga(Float.valueOf(paramFloat));
  }
  
  public void d(short paramShort)
  {
    ga(Short.valueOf(paramShort));
  }
  
  public void e(byte paramByte)
  {
    ga(Byte.valueOf(paramByte));
  }
  
  public kotlinx.a.d.b gwB()
  {
    return (kotlinx.a.d.b)a.NOF;
  }
  
  public void gwO()
  {
    throw ((Throwable)new t("'null' is not supported by default", (byte)0));
  }
  
  public boolean j(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.a.b
 * JD-Core Version:    0.7.0.1
 */