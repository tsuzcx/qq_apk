package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "serialName2Serializer", "findPolymorphicSerializer", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "klassName", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-runtime"})
public final class m<T>
  extends kotlinx.a.b.b<T>
{
  private final Map<kotlin.l.b<? extends T>, h<? extends T>> TXA;
  private final Map<String, h<? extends T>> TXB;
  private final n TXo;
  private final kotlin.l.b<T> TXp;
  
  public final h<? extends T> a(a parama, String paramString)
  {
    AppMethodBeat.i(225854);
    p.h(parama, "decoder");
    p.h(paramString, "klassName");
    h localh2 = (h)this.TXB.get(paramString);
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = super.a(parama, paramString);
    }
    AppMethodBeat.o(225854);
    return localh1;
  }
  
  public final h<? extends T> b(g paramg, T paramT)
  {
    AppMethodBeat.i(225855);
    p.h(paramg, "encoder");
    p.h(paramT, "value");
    h localh2 = (h)this.TXA.get(aa.bp(paramT.getClass()));
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = super.b(paramg, paramT);
    }
    AppMethodBeat.o(225855);
    return localh1;
  }
  
  public final n fWv()
  {
    return this.TXo;
  }
  
  public final kotlin.l.b<T> hOy()
  {
    return this.TXp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.m
 * JD-Core Version:    0.7.0.1
 */