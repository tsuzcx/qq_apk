package kotlinx.a.d;

import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.a;
import kotlinx.a.c.c.b;
import kotlinx.a.c.d;
import kotlinx.a.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "()V", "baseClass", "Lkotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "decodeSequentially", "compositeDecoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "findPolymorphicSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "klassName", "", "Lkotlinx/serialization/SerializationStrategy;", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serialize", "", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public abstract class b<T>
  implements kotlinx.a.b<T>
{
  public final T a(kotlinx.a.c.e parame)
  {
    s.u(parame, "decoder");
    kotlinx.a.b.e locale = iou();
    kotlinx.a.c.c localc = parame.c(locale);
    Object localObject2;
    label75:
    int i;
    if (localc.kFr())
    {
      parame = a(localc, localc.b(iou(), 0));
      localObject2 = c.b.a(localc, iou(), 1, parame);
      localc.b(iou());
      localc.b(locale);
      return localObject2;
      parame = localc.b(iou(), i);
    }
    for (;;)
    {
      i = localc.g(iou());
      Object localObject1;
      switch (i)
      {
      case 0: 
      default: 
        localObject2 = new StringBuilder("Invalid index in polymorphic deserialization of ");
        localObject1 = parame;
        if (parame == null) {
          localObject1 = "unknown class";
        }
        throw ((Throwable)new kotlinx.a.f((String)localObject1 + "\n Expected 0, 1 or DECODE_DONE(-1), but found " + i));
      case 1: 
        if (parame == null) {
          throw ((Throwable)new IllegalArgumentException("Cannot read polymorphic value before its type token".toString()));
        }
        localObject1 = a(localc, parame);
        localObject1 = c.b.a(localc, iou(), i, (a)localObject1);
        break;
      case -1: 
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label75;
        }
        throw ((Throwable)new IllegalArgumentException("Polymorphic value has not been read for class ".concat(String.valueOf(parame)).toString()));
        localObject1 = null;
        parame = null;
      }
    }
  }
  
  public a<? extends T> a(kotlinx.a.c.c paramc, String paramString)
  {
    s.u(paramc, "decoder");
    s.u(paramString, "klassName");
    paramc = paramc.kFe().a(kEZ(), paramString);
    if (paramc == null)
    {
      c.a(paramString, kEZ());
      throw new kotlin.f();
    }
    return paramc;
  }
  
  public final void a(kotlinx.a.c.f paramf, T paramT)
  {
    s.u(paramf, "encoder");
    s.u(paramT, "value");
    g localg = b(paramf, paramT);
    kotlinx.a.b.e locale1 = iou();
    paramf = paramf.e(locale1);
    paramf.a(iou(), localg.iou().kFa());
    kotlinx.a.b.e locale2 = iou();
    if (localg == null) {
      throw new NullPointerException("null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T>");
    }
    paramf.a(locale2, 1, localg, paramT);
    paramf.b(locale1);
  }
  
  public g<T> b(kotlinx.a.c.f paramf, T paramT)
  {
    s.u(paramf, "encoder");
    s.u(paramT, "value");
    paramf = paramf.kFe().a(kEZ(), paramT);
    if (paramf == null)
    {
      paramf = ai.cz(paramT.getClass());
      paramT = kEZ();
      s.u(paramf, "subClass");
      s.u(paramT, "baseClass");
      c.a(paramf.toString(), paramT);
      throw new kotlin.f();
    }
    return paramf;
  }
  
  public abstract kotlin.l.c<T> kEZ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d.b
 * JD-Core Version:    0.7.0.1
 */