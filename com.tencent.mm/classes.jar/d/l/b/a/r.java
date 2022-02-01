package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.l.b.a.b.b.ah;
import d.l.n;
import d.l.n.a;
import java.lang.reflect.Field;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"})
public class r<D, E, R>
  extends s<R>
  implements n<D, E, R>
{
  private final z.b<a<D, E, R>> JjR;
  private final f<Field> JjV;
  
  public r(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56472);
    parami = z.F((a)new b(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.JjR = parami;
    this.JjV = g.a(d.k.JfJ, (a)new c(this));
    AppMethodBeat.o(56472);
  }
  
  private a<D, E, R> fwE()
  {
    AppMethodBeat.i(56468);
    Object localObject = this.JjR.invoke();
    d.g.b.k.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56468);
    return localObject;
  }
  
  public final R n(D paramD, E paramE)
  {
    AppMethodBeat.i(56471);
    paramD = w(paramD, paramE);
    AppMethodBeat.o(56471);
    return paramD;
  }
  
  public final R w(D paramD, E paramE)
  {
    AppMethodBeat.i(56470);
    paramD = fwE().ac(new Object[] { paramD, paramE });
    AppMethodBeat.o(56470);
    return paramD;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<D, E, R>
    extends s.c<R>
    implements n.a<D, E, R>
  {
    private final r<D, E, R> JjY;
    
    public a(r<D, E, ? extends R> paramr)
    {
      AppMethodBeat.i(56465);
      this.JjY = paramr;
      AppMethodBeat.o(56465);
    }
    
    public final R n(D paramD, E paramE)
    {
      AppMethodBeat.i(56464);
      paramD = this.JjY.w(paramD, paramE);
      AppMethodBeat.o(56464);
      return paramD;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<r.a<D, E, ? extends R>>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/reflect/Field;", "D", "E", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Field>
  {
    c(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.r
 * JD-Core Version:    0.7.0.1
 */