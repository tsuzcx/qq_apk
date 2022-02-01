package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class k<T>
  extends kotlinx.a.b.b<T>
{
  private final n TXo;
  final kotlin.l.b<T> TXp;
  
  public k(kotlin.l.b<T> paramb)
  {
    AppMethodBeat.i(225881);
    this.TXp = paramb;
    this.TXo = p.a("kotlinx.serialization.Polymorphic", (s)j.a.TXm, (kotlin.g.a.b)new a(this));
    AppMethodBeat.o(225881);
  }
  
  public final n fWv()
  {
    return this.TXo;
  }
  
  public final kotlin.l.b<T> hOy()
  {
    return this.TXp;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<o, x>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.k
 * JD-Core Version:    0.7.0.1
 */