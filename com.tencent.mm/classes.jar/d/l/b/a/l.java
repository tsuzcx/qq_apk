package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.h;
import d.l.h.a;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "R", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"})
public final class l<T, R>
  extends q<T, R>
  implements h<T, R>
{
  private final z.b<a<T, R>> Jjy;
  
  public l(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56406);
    parami = z.F((a)new b(this));
    k.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.Jjy = parami;
    AppMethodBeat.o(56406);
  }
  
  public l(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56405);
    parami = z.F((a)new b(this));
    k.g(parami, "ReflectProperties.lazy { Setter(this) }");
    this.Jjy = parami;
    AppMethodBeat.o(56405);
  }
  
  private a<T, R> fwy()
  {
    AppMethodBeat.i(56402);
    Object localObject = this.Jjy.invoke();
    k.g(localObject, "_setter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56402);
    return localObject;
  }
  
  public final void set(T paramT, R paramR)
  {
    AppMethodBeat.i(56404);
    fwy().ac(new Object[] { paramT, paramR });
    AppMethodBeat.o(56404);
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"})
  public static final class a<T, R>
    extends s.d<R>
    implements h.a<T, R>
  {
    private final l<T, R> JjB;
    
    public a(l<T, R> paraml)
    {
      AppMethodBeat.i(56400);
      this.JjB = paraml;
      AppMethodBeat.o(56400);
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<l.a<T, R>>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.l
 * JD-Core Version:    0.7.0.1
 */