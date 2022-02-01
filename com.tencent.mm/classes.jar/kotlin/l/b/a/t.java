package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.d.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.c;
import kotlin.l.k;
import kotlin.l.o;
import kotlin.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"})
public final class t
  implements o
{
  private final y.a Tbp;
  private final y.a Tbq;
  private final y.a Tbr;
  public final ab Tbs;
  
  static
  {
    AppMethodBeat.i(56494);
    cLI = new k[] { (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(t.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(t.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(t.class), "arguments", "getArguments()Ljava/util/List;")) };
    AppMethodBeat.o(56494);
  }
  
  public t(ab paramab, kotlin.g.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(56501);
    this.Tbs = paramab;
    this.Tbp = y.ak(parama);
    this.Tbq = y.ak((kotlin.g.a.a)new b(this));
    this.Tbr = y.ak((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(56501);
  }
  
  private final c a(ab paramab)
  {
    AppMethodBeat.i(56497);
    Object localObject = paramab.hKE().hzS();
    if ((localObject instanceof e))
    {
      localObject = ae.a((e)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(56497);
        return null;
      }
      if (((Class)localObject).isArray())
      {
        paramab = (av)j.kx(paramab.hKB());
        if (paramab != null)
        {
          paramab = paramab.hBy();
          if (paramab != null) {}
        }
        else
        {
          paramab = (c)new g((Class)localObject);
          AppMethodBeat.o(56497);
          return paramab;
        }
        p.g(paramab, "type.arguments.singleOrN…return KClassImpl(jClass)");
        paramab = a(paramab);
        if (paramab == null)
        {
          paramab = (Throwable)new w("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
          AppMethodBeat.o(56497);
          throw paramab;
        }
        paramab = (c)new g(b.bD(kotlin.g.a.a(kotlin.l.b.a.a(paramab))));
        AppMethodBeat.o(56497);
        return paramab;
      }
      if (!bc.aE(paramab))
      {
        paramab = b.bz((Class)localObject);
        if (paramab != null) {
          break label291;
        }
        paramab = (ab)localObject;
      }
    }
    label291:
    for (;;)
    {
      paramab = (c)new g(paramab);
      AppMethodBeat.o(56497);
      return paramab;
      paramab = (c)new g((Class)localObject);
      AppMethodBeat.o(56497);
      return paramab;
      if ((localObject instanceof as))
      {
        paramab = (c)new v((as)localObject);
        AppMethodBeat.o(56497);
        return paramab;
      }
      if ((localObject instanceof ar))
      {
        paramab = (Throwable)new n("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
        AppMethodBeat.o(56497);
        throw paramab;
      }
      AppMethodBeat.o(56497);
      return null;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56498);
    if (((paramObject instanceof t)) && (p.j(this.Tbs, ((t)paramObject).Tbs)))
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
    int i = this.Tbs.hashCode();
    AppMethodBeat.o(56499);
    return i;
  }
  
  public final Type hyT()
  {
    AppMethodBeat.i(56495);
    Type localType = (Type)this.Tbp.invoke();
    AppMethodBeat.o(56495);
    return localType;
  }
  
  public final c hyn()
  {
    AppMethodBeat.i(56496);
    c localc = (c)this.Tbq.invoke();
    AppMethodBeat.o(56496);
    return localc;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56500);
    Object localObject = aa.TbF;
    localObject = aa.b(this.Tbs);
    AppMethodBeat.o(56500);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<List<? extends kotlin.l.q>>
  {
    a(t paramt)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Type>
    {
      a(int paramInt, t.a parama, f paramf)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<List<? extends Type>>
    {
      b(t.a parama)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<c>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */