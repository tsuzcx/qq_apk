package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.z;
import d.l;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/SealedClassSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", "", "baseClass", "Lkotlin/reflect/KClass;", "subclasses", "", "subclassSerializers", "Lkotlinx/serialization/KSerializer;", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "class2Serializer", "", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "serialName2Serializer", "findPolymorphicSerializer", "decoder", "Lkotlinx/serialization/CompositeDecoder;", "klassName", "encoder", "Lkotlinx/serialization/Encoder;", "value", "(Lkotlinx/serialization/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-runtime"})
public final class m<T>
  extends kotlinx.a.b.b<T>
{
  private final Map<d.l.b<? extends T>, h<? extends T>> OiE;
  private final Map<String, h<? extends T>> OiF;
  private final n Ois;
  private final d.l.b<T> Oit;
  
  public final h<? extends T> a(a parama, String paramString)
  {
    AppMethodBeat.i(200080);
    p.h(parama, "decoder");
    p.h(paramString, "klassName");
    h localh2 = (h)this.OiF.get(paramString);
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = super.a(parama, paramString);
    }
    AppMethodBeat.o(200080);
    return localh1;
  }
  
  public final h<? extends T> b(g paramg, T paramT)
  {
    AppMethodBeat.i(200081);
    p.h(paramg, "encoder");
    p.h(paramT, "value");
    h localh2 = (h)this.OiE.get(z.bp(paramT.getClass()));
    h localh1 = localh2;
    if (localh2 == null) {
      localh1 = super.b(paramg, paramT);
    }
    AppMethodBeat.o(200081);
    return localh1;
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
  
  public final d.l.b<T> gBr()
  {
    return this.Oit;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.m
 * JD-Core Version:    0.7.0.1
 */