package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.m;
import kotlin.l.m.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"})
public class p<T, R>
  extends r<R>
  implements m<T, R>
{
  private final y.b<a<T, R>> TaV;
  private final f<Field> TaZ;
  
  public p(i parami, String paramString1, String paramString2, Object paramObject)
  {
    super(parami, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56462);
    parami = y.aj((a)new b(this));
    kotlin.g.b.p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.TaV = parami;
    this.TaZ = g.a(k.SWQ, (a)new c(this));
    AppMethodBeat.o(56462);
  }
  
  public p(i parami, ah paramah)
  {
    super(parami, paramah);
    AppMethodBeat.i(56463);
    parami = y.aj((a)new b(this));
    kotlin.g.b.p.g(parami, "ReflectProperties.lazy { Getter(this) }");
    this.TaV = parami;
    this.TaZ = g.a(k.SWQ, (a)new c(this));
    AppMethodBeat.o(56463);
  }
  
  private a<T, R> hyK()
  {
    AppMethodBeat.i(56457);
    Object localObject = this.TaV.invoke();
    kotlin.g.b.p.g(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56457);
    return localObject;
  }
  
  public final R get(T paramT)
  {
    AppMethodBeat.i(56460);
    paramT = hyK().ag(new Object[] { paramT });
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
  public static final class a<T, R>
    extends r.c<R>
    implements m.a<T, R>
  {
    private final p<T, R> Tba;
    
    public a(p<T, ? extends R> paramp)
    {
      AppMethodBeat.i(56454);
      this.Tba = paramp;
      AppMethodBeat.o(56454);
    }
    
    public final R invoke(T paramT)
    {
      AppMethodBeat.i(56453);
      paramT = this.Tba.get(paramT);
      AppMethodBeat.o(56453);
      return paramT;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "R", "invoke"})
  static final class b
    extends q
    implements a<p.a<T, ? extends R>>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/reflect/Field;", "T", "R", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.p
 * JD-Core Version:    0.7.0.1
 */