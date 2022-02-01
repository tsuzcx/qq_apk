package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.j;
import kotlin.l.j.a;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "R", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class l<T, R>
  extends p<T, R>
  implements j<T, R>
{
  private final y.b<a<T, R>> aaDF;
  
  public l(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56405);
    parami = y.at((a)new b(this));
    kotlin.g.b.p.j(parami, "ReflectProperties.lazy { Setter(this) }");
    this.aaDF = parami;
    AppMethodBeat.o(56405);
  }
  
  public l(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56406);
    parami = y.at((a)new b(this));
    kotlin.g.b.p.j(parami, "ReflectProperties.lazy { Setter(this) }");
    this.aaDF = parami;
    AppMethodBeat.o(56406);
  }
  
  private a<T, R> iCR()
  {
    AppMethodBeat.i(56402);
    Object localObject = this.aaDF.invoke();
    kotlin.g.b.p.j(localObject, "_setter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56402);
    return localObject;
  }
  
  public final void set(T paramT, R paramR)
  {
    AppMethodBeat.i(56404);
    iCR().ak(new Object[] { paramT, paramR });
    AppMethodBeat.o(56404);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"})
  public static final class a<T, R>
    extends r.d<R>
    implements j.a<T, R>
  {
    private final l<T, R> aaDI;
    
    public a(l<T, R> paraml)
    {
      AppMethodBeat.i(56400);
      this.aaDI = paraml;
      AppMethodBeat.o(56400);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "invoke"})
  static final class b
    extends q
    implements a<l.a<T, R>>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.l
 * JD-Core Version:    0.7.0.1
 */