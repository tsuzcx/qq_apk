package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.c;
import kotlinx.a.b.a;
import kotlinx.a.b.c.a;
import kotlinx.a.b.e;
import kotlinx.a.b.h;
import kotlinx.a.b.i;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class d<T>
  extends kotlinx.a.d.b<T>
{
  private final e Wki;
  final c<T> ajCv;
  
  public d(c<T> paramc)
  {
    AppMethodBeat.i(188411);
    this.ajCv = paramc;
    paramc = (i)c.a.ajCJ;
    Object localObject = (kotlin.g.a.b)new a(this);
    paramc = h.a("kotlinx.serialization.Polymorphic", paramc, new e[0], (kotlin.g.a.b)localObject);
    localObject = this.ajCv;
    s.u(paramc, "$this$withContext");
    s.u(localObject, "context");
    this.Wki = ((e)new kotlinx.a.b.b(paramc, (c)localObject));
    AppMethodBeat.o(188411);
  }
  
  public final e iou()
  {
    return this.Wki;
  }
  
  public final c<T> kEZ()
  {
    return this.ajCv;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "invoke"}, k=3, mv={1, 4, 0})
  static final class a
    extends u
    implements kotlin.g.a.b<a, ah>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.d
 * JD-Core Version:    0.7.0.1
 */