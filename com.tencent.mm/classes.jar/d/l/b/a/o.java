package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.k;
import d.l.b.a.b.b.ah;
import d.l.l.a;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class o<R>
  extends r<R>
  implements d.l.l<R>
{
  private final y.b<a<R>> MOi;
  private final f<Object> MOj;
  
  public o(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56451);
    parami = y.Q((a)new b(this));
    p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.MOi = parami;
    this.MOj = g.a(k.MKb, (a)new c(this));
    AppMethodBeat.o(56451);
  }
  
  private a<R> ggD()
  {
    AppMethodBeat.i(56446);
    Object localObject = this.MOi.invoke();
    p.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56446);
    return localObject;
  }
  
  public final R get()
  {
    AppMethodBeat.i(56449);
    Object localObject = ggD().af(new Object[0]);
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<R>
    extends r.c<R>
    implements l.a<R>
  {
    private final o<R> MOk;
    
    public a(o<? extends R> paramo)
    {
      AppMethodBeat.i(56443);
      this.MOk = paramo;
      AppMethodBeat.o(56443);
    }
    
    public final R invoke()
    {
      AppMethodBeat.i(56442);
      Object localObject = this.MOk.get();
      AppMethodBeat.o(56442);
      return localObject;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "invoke"})
  static final class b
    extends q
    implements a<o.a<? extends R>>
  {
    b(o paramo)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "R", "invoke"})
  static final class c
    extends q
    implements a<Object>
  {
    c(o paramo)
    {
      super();
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(56445);
      Object localObject = this.MOl.a(this.MOl.ggI(), this.MOl.gfP());
      AppMethodBeat.o(56445);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.o
 * JD-Core Version:    0.7.0.1
 */