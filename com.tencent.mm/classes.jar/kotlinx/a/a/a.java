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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/builtins/AbstractDecoder;", "Lkotlinx/serialization/Decoder;", "Lkotlinx/serialization/CompositeDecoder;", "()V", "context", "Lkotlinx/serialization/modules/SerialModule;", "getContext", "()Lkotlinx/serialization/modules/SerialModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/CompositeDecoder;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeSerializableElement", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeUnit", "", "decodeUnitElement", "decodeValue", "endStructure", "updateNullableSerializableElement", "old", "(Lkotlinx/serialization/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "updateSerializableElement", "kotlinx-serialization-runtime"})
public abstract class a
  implements kotlinx.a.a, c
{
  private final kotlinx.a.z NMc = kotlinx.a.z.NMa;
  
  private Object gwU()
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
    return gwF();
  }
  
  public final byte b(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwG();
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
    return gwI();
  }
  
  public final short d(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwH();
  }
  
  public final int e(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwJ();
  }
  
  public final long f(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwK();
  }
  
  public final float g(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwL();
  }
  
  public b gwB()
  {
    return (b)kotlinx.a.d.a.NOF;
  }
  
  public kotlinx.a.z gwC()
  {
    return this.NMc;
  }
  
  public boolean gwD()
  {
    return true;
  }
  
  public Void gwE()
  {
    return null;
  }
  
  public boolean gwF()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public byte gwG()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)localObject).byteValue();
  }
  
  public short gwH()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)localObject).shortValue();
  }
  
  public char gwI()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)localObject).charValue();
  }
  
  public int gwJ()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)localObject).intValue();
  }
  
  public long gwK()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)localObject).longValue();
  }
  
  public float gwL()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)localObject).floatValue();
  }
  
  public double gwM()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)localObject).doubleValue();
  }
  
  public String gwN()
  {
    Object localObject = gwU();
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type kotlin.String");
    }
    return (String)localObject;
  }
  
  public final double h(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwM();
  }
  
  public final String i(n paramn, int paramInt)
  {
    p.h(paramn, "descriptor");
    return gwN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.a.a
 * JD-Core Version:    0.7.0.1
 */