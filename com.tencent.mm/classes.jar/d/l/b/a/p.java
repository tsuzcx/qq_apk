package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.q;
import d.k;
import d.l;
import d.l.b.a.b.b.ah;
import d.l.m;
import d.l.m.a;
import java.lang.reflect.Field;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class p<T, R>
  extends r<R>
  implements m<T, R>
{
  private final y.b<a<T, R>> Nln;
  private final f<Field> Nlr;
  
  public p(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56463);
    parami = y.Q((a)new b(this));
    d.g.b.p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.Nln = parami;
    this.Nlr = g.a(k.Nhe, (a)new c(this));
    AppMethodBeat.o(56463);
  }
  
  public p(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56462);
    parami = y.Q((a)new b(this));
    d.g.b.p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.Nln = parami;
    this.Nlr = g.a(k.Nhe, (a)new c(this));
    AppMethodBeat.o(56462);
  }
  
  private a<T, R> glh()
  {
    AppMethodBeat.i(56457);
    Object localObject = this.Nln.invoke();
    d.g.b.p.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56457);
    return localObject;
  }
  
  public final R get(T paramT)
  {
    AppMethodBeat.i(56460);
    paramT = glh().ae(new Object[] { paramT });
    AppMethodBeat.o(56460);
    return paramT;
  }
  
  public R invoke(T paramT)
  {
    AppMethodBeat.i(56461);
    paramT = get(paramT);
    AppMethodBeat.o(56461);
    return paramT;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<T, R>
    extends r.c<R>
    implements m.a<T, R>
  {
    private final p<T, R> Nls;
    
    public a(p<T, ? extends R> paramp)
    {
      AppMethodBeat.i(56454);
      this.Nls = paramp;
      AppMethodBeat.o(56454);
    }
    
    public final R invoke(T paramT)
    {
      AppMethodBeat.i(56453);
      paramT = this.Nls.get(paramT);
      AppMethodBeat.o(56453);
      return paramT;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "invoke"})
  static final class b
    extends q
    implements a<p.a<T, ? extends R>>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/lang/reflect/Field;", "T", "R", "invoke"})
  static final class c
    extends q
    implements a<Field>
  {
    c(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.p
 * JD-Core Version:    0.7.0.1
 */