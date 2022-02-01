package kotlinx.a.a;

import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.c;
import kotlinx.a.c.a;
import kotlinx.a.d.b;
import kotlinx.a.f;
import kotlinx.a.h;
import kotlinx.a.n;
import kotlinx.a.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/builtins/AbstractDecoder;", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeUnit", "", "decodeUnitElement", "decodeValue", "endStructure", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "kotlinx-serialization-runtime"})
public abstract class a
  implements kotlinx.a.a, c
{
  private final z abBt = z.abBr;
  
  private Object iTJ()
  {
    throw ((Throwable)new kotlinx.a.t(ab.bO(getClass()) + " can't retrieve untyped values", (byte)0));
  }
  
  public <T> T a(f<T> paramf)
  {
    p.k(paramf, "deserializer");
    return c.a.a(this, paramf);
  }
  
  public <T> T a(f<T> paramf, T paramT)
  {
    p.k(paramf, "deserializer");
    return c.a.a(this, paramf, paramT);
  }
  
  public final <T> T a(n paramn, int paramInt, f<T> paramf)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return a(paramf);
  }
  
  public final <T> T a(n paramn, int paramInt, f<T> paramf, T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return a(paramf, paramT);
  }
  
  public final <T> T a(n paramn, f<T> paramf)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return b(paramf);
  }
  
  public final <T> T a(n paramn, f<T> paramf, T paramT)
  {
    p.k(paramn, "descriptor");
    p.k(paramf, "deserializer");
    return b(paramf, paramT);
  }
  
  public kotlinx.a.a a(n paramn, h<?>... paramVarArgs)
  {
    p.k(paramn, "descriptor");
    p.k(paramVarArgs, "typeParams");
    return (kotlinx.a.a)this;
  }
  
  public void a(n paramn)
  {
    p.k(paramn, "descriptor");
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTu();
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTv();
  }
  
  public <T> T b(f<T> paramf)
  {
    p.k(paramf, "deserializer");
    return c.a.b(this, paramf);
  }
  
  public <T> T b(f<T> paramf, T paramT)
  {
    p.k(paramf, "deserializer");
    return c.a.b(this, paramf, paramT);
  }
  
  public final char c(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTx();
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTw();
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTy();
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTz();
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTA();
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTB();
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.k(paramn, "descriptor");
    return iTC();
  }
  
  public float iTA()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)localObject).floatValue();
  }
  
  public double iTB()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)localObject).doubleValue();
  }
  
  public String iTC()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.String");
    }
    return (String)localObject;
  }
  
  public b iTq()
  {
    return (b)kotlinx.a.d.a.abDW;
  }
  
  public z iTr()
  {
    return this.abBt;
  }
  
  public boolean iTs()
  {
    return true;
  }
  
  public Void iTt()
  {
    return null;
  }
  
  public boolean iTu()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public byte iTv()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)localObject).byteValue();
  }
  
  public short iTw()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)localObject).shortValue();
  }
  
  public char iTx()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)localObject).charValue();
  }
  
  public int iTy()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)localObject).intValue();
  }
  
  public long iTz()
  {
    Object localObject = iTJ();
    if (localObject == null) {
      throw new kotlin.t("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)localObject).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.a.a
 * JD-Core Version:    0.7.0.1
 */