package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.l.b.a.b.b.ap;
import kotlin.o;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "V", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public class q<V>
  extends t<V>
  implements kotlin.l.q<V>
{
  private final ac.b<a<V>> aizG;
  private final kotlin.j<Object> aizH;
  
  public q(j paramj, String paramString1, String paramString2, Object paramObject)
  {
    super(paramj, paramString1, paramString2, paramObject);
    AppMethodBeat.i(56452);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Getter(this) }");
    this.aizG = paramj;
    this.aizH = k.a(o.aiuG, (a)new c(this));
    AppMethodBeat.o(56452);
  }
  
  public q(j paramj, ap paramap)
  {
    super(paramj, paramap);
    AppMethodBeat.i(56451);
    paramj = ac.co((a)new b(this));
    s.s(paramj, "ReflectProperties.lazy { Getter(this) }");
    this.aizG = paramj;
    this.aizH = k.a(o.aiuG, (a)new c(this));
    AppMethodBeat.o(56451);
  }
  
  private a<V> kmn()
  {
    AppMethodBeat.i(56446);
    Object localObject = this.aizG.invoke();
    s.s(localObject, "_getter()");
    localObject = (a)localObject;
    AppMethodBeat.o(56446);
    return localObject;
  }
  
  public final V get()
  {
    AppMethodBeat.i(56449);
    Object localObject = kmn().ap(new Object[0]);
    AppMethodBeat.o(56449);
    return localObject;
  }
  
  public V invoke()
  {
    AppMethodBeat.i(56450);
    Object localObject = get();
    AppMethodBeat.o(56450);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty0$Getter;", "property", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "(Lkotlin/reflect/jvm/internal/KProperty0Impl;)V", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty0Impl;", "invoke", "()Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
  public static final class a<R>
    extends t.c<R>
    implements kotlin.l.q.a<R>
  {
    private final q<R> aizI;
    
    public a(q<? extends R> paramq)
    {
      AppMethodBeat.i(56443);
      this.aizI = paramq;
      AppMethodBeat.o(56443);
    }
    
    public final R invoke()
    {
      AppMethodBeat.i(56442);
      Object localObject = this.aizI.get();
      AppMethodBeat.o(56442);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "V", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements a<q.a<? extends V>>
  {
    b(q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "V", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements a<Object>
  {
    c(q paramq)
    {
      super();
    }
    
    public final Object invoke()
    {
      AppMethodBeat.i(56445);
      Object localObject = this.aizJ.a(this.aizJ.kms(), this.aizJ.kln());
      AppMethodBeat.o(56445);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.q
 * JD-Core Version:    0.7.0.1
 */