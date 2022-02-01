package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.d.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.c;
import kotlin.l.u;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"})
public final class t
  implements u
{
  private final y.a aaEj;
  private final y.a aaEk;
  private final y.a aaEl;
  public final kotlin.l.b.a.b.m.ab aaEm;
  
  static
  {
    AppMethodBeat.i(56494);
    cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(t.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(t.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(t.class), "arguments", "getArguments()Ljava/util/List;")) };
    AppMethodBeat.o(56494);
  }
  
  public t(kotlin.l.b.a.b.m.ab paramab, kotlin.g.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(56501);
    this.aaEm = paramab;
    this.aaEj = y.au(parama);
    this.aaEk = y.au((kotlin.g.a.a)new b(this));
    this.aaEl = y.au((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(56501);
  }
  
  private final c a(kotlin.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56497);
    Object localObject = paramab.iOU().iEf();
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
        paramab = (av)j.lt(paramab.iOR());
        if (paramab != null)
        {
          paramab = paramab.iFN();
          if (paramab != null) {}
        }
        else
        {
          paramab = (c)new g((Class)localObject);
          AppMethodBeat.o(56497);
          return paramab;
        }
        p.j(paramab, "type.arguments.singleOrN…return KClassImpl(jClass)");
        paramab = a(paramab);
        if (paramab == null)
        {
          paramab = (Throwable)new w("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
          AppMethodBeat.o(56497);
          throw paramab;
        }
        paramab = (c)new g(b.cc(kotlin.g.a.a(kotlin.l.b.a.a(paramab))));
        AppMethodBeat.o(56497);
        return paramab;
      }
      if (!bc.aE(paramab))
      {
        paramab = b.bY((Class)localObject);
        if (paramab != null) {
          break label291;
        }
        paramab = (kotlin.l.b.a.b.m.ab)localObject;
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
        paramab = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Type alias classifiers are not yet supported")));
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
    if (((paramObject instanceof t)) && (p.h(this.aaEm, ((t)paramObject).aaEm)))
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
    int i = this.aaEm.hashCode();
    AppMethodBeat.o(56499);
    return i;
  }
  
  public final c iCy()
  {
    AppMethodBeat.i(56496);
    c localc = (c)this.aaEk.invoke();
    AppMethodBeat.o(56496);
    return localc;
  }
  
  public final Type iDe()
  {
    AppMethodBeat.i(56495);
    Type localType = (Type)this.aaEj.invoke();
    AppMethodBeat.o(56495);
    return localType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56500);
    Object localObject = aa.aaEz;
    localObject = aa.b(this.aaEm);
    AppMethodBeat.o(56500);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends kotlin.l.w>>
  {
    a(t paramt)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<Type>
    {
      a(int paramInt, t.a parama, f paramf)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<List<? extends Type>>
    {
      b(t.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<c>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */