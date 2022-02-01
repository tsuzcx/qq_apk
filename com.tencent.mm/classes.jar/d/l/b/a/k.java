package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.b.a.b.b.ah;
import d.l.g;
import d.l.g.a;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "R", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class k<R>
  extends o<R>
  implements g<R>
{
  final y.b<a<R>> MNY;
  
  public k(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56398);
    parami = y.Q((a)new b(this));
    p.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.MNY = parami;
    AppMethodBeat.o(56398);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", "", "value", "(Ljava/lang/Object;)V", "kotlin-reflection"})
  public static final class a<R>
    extends r.d<R>
    implements g.a<R>
  {
    private final k<R> MNZ;
    
    public a(k<R> paramk)
    {
      AppMethodBeat.i(56396);
      this.MNZ = paramk;
      AppMethodBeat.o(56396);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "invoke"})
  static final class b
    extends q
    implements a<k.a<R>>
  {
    b(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.k
 * JD-Core Version:    0.7.0.1
 */