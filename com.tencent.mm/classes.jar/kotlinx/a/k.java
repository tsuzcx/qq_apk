package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class k<T>
  extends kotlinx.a.b.b<T>
{
  private final n abAF;
  final kotlin.l.b<T> abAG;
  
  public k(kotlin.l.b<T> paramb)
  {
    AppMethodBeat.i(257497);
    this.abAG = paramb;
    this.abAF = p.a("kotlinx.serialization.Polymorphic", (s)j.a.abAD, (kotlin.g.a.b)new a(this));
    AppMethodBeat.o(257497);
  }
  
  public final n gPe()
  {
    return this.abAF;
  }
  
  public final kotlin.l.b<T> iTE()
  {
    return this.abAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.k
 * JD-Core Version:    0.7.0.1
 */