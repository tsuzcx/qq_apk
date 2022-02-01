package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ag;
import kotlin.g.b.s;
import kotlin.g.b.t;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.e.b.b;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.d;
import kotlin.l.o;
import kotlin.l.w;
import kotlin.q;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class v
  implements t
{
  private final ac.a<Type> aiAa;
  private final ac.a aiAb;
  private final ac.a aiAc;
  public final ad aiAd;
  
  static
  {
    AppMethodBeat.i(56494);
    aYe = new o[] { (o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(v.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (o)kotlin.g.b.ai.a(new ag(kotlin.g.b.ai.cz(v.class), "arguments", "getArguments()Ljava/util/List;")) };
    AppMethodBeat.o(56494);
  }
  
  public v(ad paramad, final kotlin.g.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(56501);
    this.aiAd = paramad;
    if (!(parama instanceof ac.a)) {}
    for (paramad = null;; paramad = parama)
    {
      paramad = (ac.a)paramad;
      if (paramad == null) {
        if (parama != null) {
          paramad = ac.cp(parama);
        }
      }
      for (;;)
      {
        this.aiAa = paramad;
        this.aiAb = ac.cp((kotlin.g.a.a)new b(this));
        this.aiAc = ac.cp((kotlin.g.a.a)new a(this, parama));
        AppMethodBeat.o(56501);
        return;
        paramad = localObject;
      }
    }
  }
  
  private final d a(ad paramad)
  {
    AppMethodBeat.i(56497);
    Object localObject = paramad.kzm().knA();
    if ((localObject instanceof e))
    {
      localObject = ai.b((e)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(56497);
        return null;
      }
      if (((Class)localObject).isArray())
      {
        paramad = (kotlin.l.b.a.b.m.az)p.oP(paramad.klR());
        if (paramad != null)
        {
          paramad = paramad.koG();
          if (paramad != null) {}
        }
        else
        {
          paramad = (d)new h((Class)localObject);
          AppMethodBeat.o(56497);
          return paramad;
        }
        s.s(paramad, "type.arguments.singleOrN…return KClassImpl(jClass)");
        paramad = a(paramad);
        if (paramad == null)
        {
          paramad = (Throwable)new aa("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
          AppMethodBeat.o(56497);
          throw paramad;
        }
        paramad = (d)new h(ai.cE(kotlin.g.a.b(kotlin.l.b.a.a(paramad))));
        AppMethodBeat.o(56497);
        return paramad;
      }
      if (!bg.aw(paramad))
      {
        paramad = b.cK((Class)localObject);
        if (paramad != null) {
          break label294;
        }
        paramad = (ad)localObject;
      }
    }
    label294:
    for (;;)
    {
      paramad = (d)new h(paramad);
      AppMethodBeat.o(56497);
      return paramad;
      paramad = (d)new h((Class)localObject);
      AppMethodBeat.o(56497);
      return paramad;
      if ((localObject instanceof ba))
      {
        paramad = (d)new x(null, (ba)localObject);
        AppMethodBeat.o(56497);
        return paramad;
      }
      if ((localObject instanceof kotlin.l.b.a.b.b.az))
      {
        paramad = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
        AppMethodBeat.o(56497);
        throw paramad;
      }
      AppMethodBeat.o(56497);
      return null;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56498);
    if (((paramObject instanceof v)) && (s.p(this.aiAd, ((v)paramObject).aiAd)))
    {
      AppMethodBeat.o(56498);
      return true;
    }
    AppMethodBeat.o(56498);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56499);
    int i = this.aiAd.hashCode();
    AppMethodBeat.o(56499);
    return i;
  }
  
  public final Type klA()
  {
    AppMethodBeat.i(191360);
    Object localObject = this.aiAa;
    if (localObject != null)
    {
      localObject = (Type)((ac.a)localObject).invoke();
      AppMethodBeat.o(191360);
      return localObject;
    }
    AppMethodBeat.o(191360);
    return null;
  }
  
  public final d klQ()
  {
    AppMethodBeat.i(56496);
    d locald = (d)this.aiAb.invoke();
    AppMethodBeat.o(56496);
    return locald;
  }
  
  public final List<w> klR()
  {
    AppMethodBeat.i(191363);
    List localList = (List)this.aiAc.invoke();
    AppMethodBeat.o(191363);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56500);
    Object localObject = ae.aiAr;
    localObject = ae.b(this.aiAd);
    AppMethodBeat.o(56500);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements kotlin.g.a.a<List<? extends w>>
  {
    a(v paramv, kotlin.g.a.a parama)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<no name provided>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements kotlin.g.a.a<Type>
    {
      a(int paramInt, v.a parama, j paramj)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 5, 1})
    static final class b
      extends u
      implements kotlin.g.a.a<List<? extends Type>>
    {
      b(v.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements kotlin.g.a.a<d>
  {
    b(v paramv)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.v
 * JD-Core Version:    0.7.0.1
 */