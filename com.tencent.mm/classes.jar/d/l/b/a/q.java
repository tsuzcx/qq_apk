package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g;
import d.g.a.a;
import d.l.b.a.b.b.ah;
import d.l.m;
import d.l.m.a;
import java.lang.reflect.Field;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class q<T, R>
  extends s<R>
  implements m<T, R>
{
  private final z.b<a<T, R>> KXl;
  private final f<Field> KXp;
  
  public q(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56463);
    parami = z.M((a)new b(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.KXl = parami;
    this.KXp = g.a(d.k.KTd, (a)new c(this));
    AppMethodBeat.o(56463);
  }
  
  public q(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56462);
    parami = z.M((a)new b(this));
    d.g.b.k.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.KXl = parami;
    this.KXp = g.a(d.k.KTd, (a)new c(this));
    AppMethodBeat.o(56462);
  }
  
  private a<T, R> fPh()
  {
    AppMethodBeat.i(56457);
    Object localObject = this.KXl.invoke();
    d.g.b.k.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56457);
    return localObject;
  }
  
  public final R ay(T paramT)
  {
    AppMethodBeat.i(56461);
    paramT = get(paramT);
    AppMethodBeat.o(56461);
    return paramT;
  }
  
  public final R get(T paramT)
  {
    AppMethodBeat.i(56460);
    paramT = fPh().ae(new Object[] { paramT });
    AppMethodBeat.o(56460);
    return paramT;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<T, R>
    extends s.c<R>
    implements m.a<T, R>
  {
    private final q<T, R> KXq;
    
    public a(q<T, ? extends R> paramq)
    {
      AppMethodBeat.i(56454);
      this.KXq = paramq;
      AppMethodBeat.o(56454);
    }
    
    public final R ay(T paramT)
    {
      AppMethodBeat.i(56453);
      paramT = this.KXq.get(paramT);
      AppMethodBeat.o(56453);
      return paramT;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<q.a<T, ? extends R>>
  {
    b(q paramq)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/reflect/Field;", "T", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<Field>
  {
    c(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.q
 * JD-Core Version:    0.7.0.1
 */