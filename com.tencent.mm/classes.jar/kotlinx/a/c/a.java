package kotlinx.a.c;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.f;
import kotlinx.a.i;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/encoding/AbstractDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "updateMode", "Lkotlinx/serialization/UpdateMode;", "getUpdateMode$annotations", "getUpdateMode", "()Lkotlinx/serialization/UpdateMode;", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParams", "", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeBoolean", "", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", "T", "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeValue", "endStructure", "", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class a
  implements c, e
{
  private final i ajDn = i.ajCy;
  
  private <T> T a(kotlinx.a.a<T> parama)
  {
    s.u(parama, "deserializer");
    return b(parama);
  }
  
  private Object kFf()
  {
    throw ((Throwable)new f(ai.cz(getClass()) + " can't retrieve untyped values"));
  }
  
  public final int a(kotlinx.a.b.e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return kFl();
  }
  
  public final <T> T a(kotlinx.a.b.e parame, int paramInt, kotlinx.a.a<T> parama, T paramT)
  {
    s.u(parame, "descriptor");
    s.u(parama, "deserializer");
    return a(parama);
  }
  
  public final <T> T a(kotlinx.a.b.e parame, kotlinx.a.a<T> parama, T paramT)
  {
    s.u(parame, "descriptor");
    s.u(parama, "deserializer");
    if (kFg()) {
      return a(parama);
    }
    return kFh();
  }
  
  public final c a(kotlinx.a.b.e parame, kotlinx.a.b<?>... paramVarArgs)
  {
    s.u(parame, "descriptor");
    s.u(paramVarArgs, "typeParams");
    return (c)this;
  }
  
  public <T> T b(kotlinx.a.a<T> parama)
  {
    s.u(parama, "deserializer");
    return e.a.a(this, parama);
  }
  
  public final String b(kotlinx.a.b.e parame, int paramInt)
  {
    s.u(parame, "descriptor");
    return kFq();
  }
  
  public void b(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
  }
  
  public c c(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
    return e.a.a(this, parame);
  }
  
  public int d(kotlinx.a.b.e parame)
  {
    s.u(parame, "descriptor");
    s.u(parame, "descriptor");
    return -1;
  }
  
  public kotlinx.a.f.b kFe()
  {
    return kotlinx.a.f.c.kFP();
  }
  
  public boolean kFg()
  {
    return true;
  }
  
  public Void kFh()
  {
    return null;
  }
  
  public boolean kFi()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public byte kFj()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Byte");
    }
    return ((Byte)localObject).byteValue();
  }
  
  public short kFk()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Short");
    }
    return ((Short)localObject).shortValue();
  }
  
  public int kFl()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
    return ((Integer)localObject).intValue();
  }
  
  public long kFm()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    }
    return ((Long)localObject).longValue();
  }
  
  public float kFn()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
    return ((Float)localObject).floatValue();
  }
  
  public double kFo()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    }
    return ((Double)localObject).doubleValue();
  }
  
  public char kFp()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.Char");
    }
    return ((Character)localObject).charValue();
  }
  
  public String kFq()
  {
    Object localObject = kFf();
    if (localObject == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
    return (String)localObject;
  }
  
  public boolean kFr()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.c.a
 * JD-Core Version:    0.7.0.1
 */