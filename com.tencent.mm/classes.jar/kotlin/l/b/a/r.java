package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.b.a.b.b.ap;
import kotlin.o;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public class r<T, V>
  extends t<V>
  implements kotlin.l.r<T, V>
{
  private final ac.b<a<T, V>> aizG;
  private final kotlin.j<Field> aizK;
  
  public r(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    super(paramj, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56462);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Getter(this) }");
    this.aizG = paramj;
    this.aizK = k.a(o.aiuG, (a)new c(this));
    AppMethodBeat.o(56462);
  }
  
  public r(j paramj, ap paramap)
  {
    super(paramj, paramap);
    AppMethodBeat.i(56463);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Getter(this) }");
    this.aizG = paramj;
    this.aizK = k.a(o.aiuG, (a)new c(this));
    AppMethodBeat.o(56463);
  }
  
  private a<T, V> kmp()
  {
    AppMethodBeat.i(56457);
    Object localObject = this.aizG.invoke();
    s.s(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56457);
    return localObject;
  }
  
  public final V get(T paramT)
  {
    AppMethodBeat.i(56460);
    paramT = kmp().ap(new Object[] { paramT });
    AppMethodBeat.o(56460);
    return paramT;
  }
  
  public V invoke(T paramT)
  {
    AppMethodBeat.i(56461);
    paramT = get(paramT);
    AppMethodBeat.o(56461);
    return paramT;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "invoke", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a<T, V>
    extends t.c<V>
    implements kotlin.l.r.a<T, V>
  {
    private final r<T, V> aizL;
    
    public a(r<T, ? extends V> paramr)
    {
      AppMethodBeat.i(56454);
      this.aizL = paramr;
      AppMethodBeat.o(56454);
    }
    
    public final V invoke(T paramT)
    {
      AppMethodBeat.i(56453);
      paramT = this.aizL.get(paramT);
      AppMethodBeat.o(56453);
      return paramT;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<r.a<T, ? extends V>>
  {
    b(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "T", "V", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements a<Field>
  {
    c(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.r
 * JD-Core Version:    0.7.0.1
 */