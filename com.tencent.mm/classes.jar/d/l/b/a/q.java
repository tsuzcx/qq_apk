package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.k;
import d.l;
import d.l.b.a.b.b.ah;
import d.l.n;
import d.l.n.a;
import java.lang.reflect.Field;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"})
public class q<D, E, R>
  extends r<R>
  implements n<D, E, R>
{
  private final y.b<a<D, E, R>> MOi;
  private final f<Field> MOm;
  
  public q(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56472);
    parami = y.Q((a)new b(this));
    p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.MOi = parami;
    this.MOm = g.a(k.MKb, (a)new c(this));
    AppMethodBeat.o(56472);
  }
  
  private a<D, E, R> ggG()
  {
    AppMethodBeat.i(56468);
    Object localObject = this.MOi.invoke();
    p.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56468);
    return localObject;
  }
  
  public final R p(D paramD, E paramE)
  {
    AppMethodBeat.i(56471);
    paramD = y(paramD, paramE);
    AppMethodBeat.o(56471);
    return paramD;
  }
  
  public final R y(D paramD, E paramE)
  {
    AppMethodBeat.i(56470);
    paramD = ggG().af(new Object[] { paramD, paramE });
    AppMethodBeat.o(56470);
    return paramD;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<D, E, R>
    extends r.c<R>
    implements n.a<D, E, R>
  {
    private final q<D, E, R> MOp;
    
    public a(q<D, E, ? extends R> paramq)
    {
      AppMethodBeat.i(56465);
      this.MOp = paramq;
      AppMethodBeat.o(56465);
    }
    
    public final R p(D paramD, E paramE)
    {
      AppMethodBeat.i(56464);
      paramD = this.MOp.y(paramD, paramE);
      AppMethodBeat.o(56464);
      return paramD;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "R", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<q.a<D, E, ? extends R>>
  {
    b(q paramq)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/reflect/Field;", "D", "E", "R", "invoke"})
  static final class c
    extends d.g.b.q
    implements a<Field>
  {
    c(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.q
 * JD-Core Version:    0.7.0.1
 */