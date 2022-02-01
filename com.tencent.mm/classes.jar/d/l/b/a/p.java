package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.l.b.a.b.b.ah;
import d.l.l.a;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class p<R>
  extends s<R>
  implements d.l.l<R>
{
  private final z.b<a<R>> KXl;
  private final f<Object> KXm;
  
  public p(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56451);
    parami = z.M((a)new b(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.KXl = parami;
    this.KXm = g.a(d.k.KTd, (a)new c(this));
    AppMethodBeat.o(56451);
  }
  
  public p(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56452);
    parami = z.M((a)new b(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.KXl = parami;
    this.KXm = g.a(d.k.KTd, (a)new c(this));
    AppMethodBeat.o(56452);
  }
  
  private a<R> fPf()
  {
    AppMethodBeat.i(56446);
    Object localObject = this.KXl.invoke();
    d.g.b.k.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56446);
    return localObject;
  }
  
  public final R get()
  {
    AppMethodBeat.i(56449);
    Object localObject = fPf().ae(new Object[0]);
    AppMethodBeat.o(56449);
    return localObject;
  }
  
  public R invoke()
  {
    AppMethodBeat.i(56450);
    Object localObject = get();
    AppMethodBeat.o(56450);
    return localObject;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<R>
    extends s.c<R>
    implements l.a<R>
  {
    private final p<R> KXn;
    
    public a(p<? extends R> paramp)
    {
      AppMethodBeat.i(56443);
      this.KXn = paramp;
      AppMethodBeat.o(56443);
    }
    
    public final R invoke()
    {
      AppMethodBeat.i(56442);
      Object localObject = this.KXn.get();
      AppMethodBeat.o(56442);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<p.a<? extends R>>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Object>
  {
    c(p paramp)
    {
      super();
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(56445);
      Object localObject = this.KXo.a(this.KXo.fPk(), this.KXo.fOp());
      AppMethodBeat.o(56445);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.p
 * JD-Core Version:    0.7.0.1
 */