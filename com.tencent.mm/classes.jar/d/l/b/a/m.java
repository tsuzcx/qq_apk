package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.i.a;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "Lkotlin/reflect/KMutableProperty2;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "set", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class m<D, E, R>
  extends r<D, E, R>
  implements d.l.i<D, E, R>
{
  final z.b<a<D, E, R>> KWS;
  
  public m(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56410);
    parami = z.M((a)new b(this));
    k.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.KWS = parami;
    AppMethodBeat.o(56410);
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty2$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "invoke", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"})
  public static final class a<D, E, R>
    extends s.d<R>
    implements i.a<D, E, R>
  {
    private final m<D, E, R> KWX;
    
    public a(m<D, E, R> paramm)
    {
      AppMethodBeat.i(56408);
      this.KWX = paramm;
      AppMethodBeat.o(56408);
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "D", "E", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<m.a<D, E, R>>
  {
    b(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.m
 * JD-Core Version:    0.7.0.1
 */