package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/SerialDescriptor;", "kotlinx-serialization-runtime"})
public final class k<T>
  extends kotlinx.a.b.b<T>
{
  private final n NLm;
  final d.l.b<T> NLn;
  
  public k(d.l.b<T> paramb)
  {
    AppMethodBeat.i(191519);
    this.NLn = paramb;
    this.NLm = p.a("kotlinx.serialization.Polymorphic", (s)j.a.NLk, (d.g.a.b)new a(this));
    AppMethodBeat.o(191519);
  }
  
  public final n eLj()
  {
    return this.NLm;
  }
  
  public final d.l.b<T> gwP()
  {
    return this.NLn;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "", "Lkotlinx/serialization/SerialDescriptorBuilder;", "invoke"})
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