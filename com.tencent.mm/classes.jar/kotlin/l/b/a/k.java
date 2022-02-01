package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.g;
import kotlin.l.g.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "R", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class k<R>
  extends o<R>
  implements g<R>
{
  final y.b<a<R>> TaL;
  
  public k(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(186233);
    parami = y.aj((a)new b(this));
    p.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.TaL = parami;
    AppMethodBeat.o(186233);
  }
  
  public k(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56398);
    parami = y.aj((a)new b(this));
    p.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.TaL = parami;
    AppMethodBeat.o(56398);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", "", "value", "(Ljava/lang/Object;)V", "kotlin-reflection"})
  public static final class a<R>
    extends r.d<R>
    implements g.a<R>
  {
    private final k<R> TaM;
    
    public a(k<R> paramk)
    {
      AppMethodBeat.i(56396);
      this.TaM = paramk;
      AppMethodBeat.o(56396);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.k
 * JD-Core Version:    0.7.0.1
 */