package kotlinx.a.a;

import d.g.b.p;
import d.l;
import d.v;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.d.b;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.t;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/builtins/AbstractDecoder;", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeUnit", "", "decodeUnitElement", "decodeValue", "endStructure", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "kotlinx-serialization-runtime"})
public abstract class a
  implements kotlinx.a.a, c
{
  private final kotlinx.a.z Oji = kotlinx.a.z.Ojg;
  
  private Object gBw()
  {
    throw ((Throwable)new t(d.g.b.z.bp(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  public <T> T a(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.a(this, paramf);
  }
  
  public <T> T a(f<T> paramf, T paramT)
  {
    p.h(paramf, "deserializer");
    return c.a.a(this, paramf, paramT);
  }
  
  public final <T> T a(n paramn, int paramInt, f<T> paramf)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return a(paramf);
  }
  
  public final <T> T a(n paramn, int paramInt, f<T> paramf, T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return a(paramf, paramT);
  }
  
  public final <T> T a(n paramn, f<T> paramf)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return b(paramf);
  }
  
  public final <T> T a(n paramn, f<T> paramf, T paramT)
  {
    p.h(paramn, "descriptor");
    p.h(paramf, "deserializer");
    return b(paramf, paramT);
  }
  
  public kotlinx.a.a a(n paramn, h<?>... paramVarArgs)
  {
    p.h(paramn, "descriptor");
    p.h(paramVarArgs, "typeParams");
    return (kotlinx.a.a)this;
  }
  
  public void a(n paramn)
  {
    p.h(paramn, "descriptor");
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBh();
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBi();
  }
  
  public <T> T b(f<T> paramf)
  {
    p.h(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public <T> T b(f<T> paramf, T paramT)
  {
    p.h(paramf, "deserializer");
    return c.a.b(this, paramf, paramT);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBk();
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBj();
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBl();
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBm();
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBn();
  }
  
  public b gBd()
  {
    return (b)kotlinx.a.d.a.OlL;
  }
  
  public kotlinx.a.z gBe()
  {
    return this.Oji;
  }
  
  public boolean gBf()
  {
    return true;
  }
  
  public Void gBg()
  {
    return null;
  }
  
  public boolean gBh()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public byte gBi()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)localObject).byteValue();
  }
  
  public short gBj()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)localObject).shortValue();
  }
  
  public char gBk()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)localObject).charValue();
  }
  
  public int gBl()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)localObject).intValue();
  }
  
  public long gBm()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)localObject).longValue();
  }
  
  public float gBn()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)localObject).floatValue();
  }
  
  public double gBo()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)localObject).doubleValue();
  }
  
  public String gBp()
  {
    Object localObject = gBw();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.String");
    }
    return (String)localObject;
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBo();
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gBp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.a.a
 * JD-Core Version:    0.7.0.1
 */