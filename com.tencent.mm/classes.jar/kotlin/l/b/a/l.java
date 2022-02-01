package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.i;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "V", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class l<V>
  extends q<V>
  implements i<V>
{
  final ac.b<a<V>> aizn;
  
  public l(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    super(paramj, paramString1, paramString2, paramObject);
    AppMethodBeat.i(191359);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Setter(this) }");
    this.aizn = paramj;
    AppMethodBeat.o(191359);
  }
  
  public l(j paramj, ap paramap)
  {
    super(paramj, paramap);
    AppMethodBeat.i(56398);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Setter(this) }");
    this.aizn = paramj;
    AppMethodBeat.o(56398);
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "invoke", "", "value", "(Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a<R>
    extends t.d<R>
    implements kotlin.l.j<R>
  {
    private final l<R> aizo;
    
    public a(l<R> paraml)
    {
      AppMethodBeat.i(56396);
      this.aizo = paraml;
      AppMethodBeat.o(56396);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "V", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<l.a<V>>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.l
 * JD-Core Version:    0.7.0.1
 */