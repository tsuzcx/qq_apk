package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class k<T>
  extends kotlinx.a.b.b<T>
{
  private final n Ois;
  final d.l.b<T> Oit;
  
  public k(d.l.b<T> paramb)
  {
    AppMethodBeat.i(200107);
    this.Oit = paramb;
    this.Ois = p.a("kotlinx.serialization.Polymorphic", (s)j.a.Oiq, (d.g.a.b)new a(this));
    AppMethodBeat.o(200107);
  }
  
  public final n eOR()
  {
    return this.Ois;
  }
  
  public final d.l.b<T> gBr()
  {
    return this.Oit;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<o, z>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.k
 * JD-Core Version:    0.7.0.1
 */