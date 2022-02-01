package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.b.a.b.b.ap;
import kotlin.o;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "V", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public class s<D, E, V>
  extends t<V>
  implements kotlin.l.s<D, E, V>
{
  private final ac.b<a<D, E, V>> aizG;
  private final kotlin.j<Field> aizK;
  
  public s(j paramj, ap paramap)
  {
    super(paramj, paramap);
    AppMethodBeat.i(56472);
    paramj = ac.co((a)new b(this));
    kotlin.g.b.s.s(paramj, "ReflectProperties.lazy { Getter(this) }");
    this.aizG = paramj;
    this.aizK = k.a(o.aiuG, (a)new c(this));
    AppMethodBeat.o(56472);
  }
  
  private a<D, E, V> kmq()
  {
    AppMethodBeat.i(56468);
    Object localObject = this.aizG.invoke();
    kotlin.g.b.s.s(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56468);
    return localObject;
  }
  
  public final V J(D paramD, E paramE)
  {
    AppMethodBeat.i(56470);
    paramD = kmq().ap(new Object[] { paramD, paramE });
    AppMethodBeat.o(56470);
    return paramD;
  }
  
  public V invoke(D paramD, E paramE)
  {
    AppMethodBeat.i(56471);
    paramD = J(paramD, paramE);
    AppMethodBeat.o(56471);
    return paramD;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "V", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty2$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "(Lkotlin/reflect/jvm/internal/KProperty2Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty2Impl;", "invoke", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a<D, E, V>
    extends t.c<V>
    implements kotlin.l.t<D, E, V>
  {
    private final s<D, E, V> aizN;
    
    public a(s<D, E, ? extends V> params)
    {
      AppMethodBeat.i(56465);
      this.aizN = params;
      AppMethodBeat.o(56465);
    }
    
    public final V invoke(D paramD, E paramE)
    {
      AppMethodBeat.i(56464);
      paramD = this.aizN.J(paramD, paramE);
      AppMethodBeat.o(56464);
      return paramD;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "D", "E", "V", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<s.a<D, E, ? extends V>>
  {
    b(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "D", "E", "V", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements a<Field>
  {
    c(s params)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.s
 * JD-Core Version:    0.7.0.1
 */