package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.k;
import kotlin.l.k.a;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "V", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class m<T, V>
  extends r<T, V>
  implements k<T, V>
{
  private final ac.b<a<T, V>> aizn;
  
  public m(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    super(paramj, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56405);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Setter(this) }");
    this.aizn = paramj;
    AppMethodBeat.o(56405);
  }
  
  public m(j paramj, ap paramap)
  {
    super(paramj, paramap);
    AppMethodBeat.i(56406);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Setter(this) }");
    this.aizn = paramj;
    AppMethodBeat.o(56406);
  }
  
  private a<T, V> kmk()
  {
    AppMethodBeat.i(56402);
    Object localObject = this.aizn.invoke();
    s.s(localObject, "_setter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56402);
    return localObject;
  }
  
  public final void set(T paramT, V paramV)
  {
    AppMethodBeat.i(56404);
    kmk().ap(new Object[] { paramT, paramV });
    AppMethodBeat.o(56404);
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty1$Setter;", "property", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "invoke", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a<T, V>
    extends t.d<V>
    implements k.a<T, V>
  {
    private final m<T, V> aizq;
    
    public a(m<T, V> paramm)
    {
      AppMethodBeat.i(56400);
      this.aizq = paramm;
      AppMethodBeat.o(56400);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<m.a<T, V>>
  {
    b(m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.m
 * JD-Core Version:    0.7.0.1
 */