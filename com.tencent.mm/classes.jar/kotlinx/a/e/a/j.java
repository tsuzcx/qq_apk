package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlinx.a.b.i;
import kotlinx.a.b.i.b;
import kotlinx.a.d.b;
import kotlinx.a.e.f;
import kotlinx.a.e.m;
import kotlinx.a.e.n;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkKind", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "validateIfSealed", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "actualSerializer", "", "classDiscriminator", "", "decodeSerializableValuePolymorphic", "T", "Lkotlinx/serialization/json/JsonDecoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonEncoder;", "value", "ifPolymorphic", "Lkotlin/Function0;", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "kotlinx-serialization-runtime"}, k=2, mv={1, 4, 0})
public final class j
{
  public static final <T> T a(kotlinx.a.e.c paramc, kotlinx.a.a<T> parama)
  {
    AppMethodBeat.i(188544);
    s.u(paramc, "$this$decodeSerializableValuePolymorphic");
    s.u(parama, "deserializer");
    if ((!(parama instanceof b)) || (paramc.kFA().ajEb.ajEx))
    {
      paramc = parama.a((kotlinx.a.c.e)paramc);
      AppMethodBeat.o(188544);
      return paramc;
    }
    Object localObject1 = paramc.kFB();
    Object localObject2 = parama.iou();
    if (!(localObject1 instanceof m))
    {
      paramc = (Throwable)new kotlinx.a.e.d(-1, "Expected " + ai.cz(m.class) + " as the serialized body of " + ((kotlinx.a.b.e)localObject2).kFa() + ", but had " + ai.cz(localObject1.getClass()));
      AppMethodBeat.o(188544);
      throw paramc;
    }
    localObject1 = (m)localObject1;
    localObject2 = paramc.kFA().ajEb.ajEy;
    Object localObject3 = (kotlinx.a.e.e)((m)localObject1).get(localObject2);
    if (localObject3 != null)
    {
      localObject3 = f.a((kotlinx.a.e.e)localObject3);
      if (localObject3 != null)
      {
        localObject3 = ((n)localObject3).getContent();
        if (localObject3 != null) {
          break label231;
        }
      }
    }
    paramc = (Throwable)kotlinx.a.e.j.am(-1, "Missing polymorphic discriminator ".concat(String.valueOf(localObject2)), ((m)localObject1).toString());
    AppMethodBeat.o(188544);
    throw paramc;
    label231:
    parama = ((b)parama).a((kotlinx.a.c.c)paramc, (String)localObject3);
    if (parama == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T>");
      AppMethodBeat.o(188544);
      throw paramc;
    }
    paramc = p.a(paramc.kFA(), (String)localObject2, (m)localObject1, parama);
    AppMethodBeat.o(188544);
    return paramc;
  }
  
  public static final void a(i parami)
  {
    AppMethodBeat.i(188532);
    s.u(parami, "kind");
    if ((parami instanceof i.b))
    {
      parami = (Throwable)new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(188532);
      throw parami;
    }
    if ((parami instanceof kotlinx.a.b.d))
    {
      parami = (Throwable)new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
      AppMethodBeat.o(188532);
      throw parami;
    }
    if ((parami instanceof kotlinx.a.b.c))
    {
      parami = (Throwable)new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
      AppMethodBeat.o(188532);
      throw parami;
    }
    AppMethodBeat.o(188532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.j
 * JD-Core Version:    0.7.0.1
 */