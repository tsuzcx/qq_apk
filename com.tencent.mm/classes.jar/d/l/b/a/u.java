package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.f;
import d.g.b.s;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.d.b.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bc;
import d.l.c;
import d.l.o;
import d.l.q;
import d.n;
import java.lang.reflect.Type;
import java.util.List;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"})
public final class u
  implements o
{
  private final z.a Jkl;
  private final z.a Jkm;
  private final z.a Jkn;
  public final d.l.b.a.b.m.ab Jko;
  
  static
  {
    AppMethodBeat.i(56494);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(u.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(u.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(u.class), "arguments", "getArguments()Ljava/util/List;")), (d.l.k)d.g.b.w.a(new s(d.g.b.w.bk(u.class), "parameterizedTypeArguments", "<v#0>")) };
    AppMethodBeat.o(56494);
  }
  
  public u(d.l.b.a.b.m.ab paramab, d.g.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(56501);
    this.Jko = paramab;
    this.Jkl = z.G(parama);
    this.Jkm = z.G((d.g.a.a)new b(this));
    this.Jkn = z.G((d.g.a.a)new a(this));
    AppMethodBeat.o(56501);
  }
  
  private final c a(d.l.b.a.b.m.ab paramab)
  {
    AppMethodBeat.i(56497);
    Object localObject = paramab.fIW().fxM();
    if ((localObject instanceof e))
    {
      localObject = af.a((e)localObject);
      if (localObject == null)
      {
        AppMethodBeat.o(56497);
        return null;
      }
      if (((Class)localObject).isArray())
      {
        paramab = (av)j.iD(paramab.fIT());
        if (paramab != null)
        {
          paramab = paramab.fzr();
          if (paramab != null) {}
        }
        else
        {
          paramab = (c)new g((Class)localObject);
          AppMethodBeat.o(56497);
          return paramab;
        }
        d.g.b.k.g(paramab, "type.arguments.singleOrN…return KClassImpl(jClass)");
        paramab = a(paramab);
        if (paramab == null)
        {
          paramab = (Throwable)new x("Cannot determine classifier for array element type: ".concat(String.valueOf(this)));
          AppMethodBeat.o(56497);
          throw paramab;
        }
        paramab = (c)new g(b.by(d.g.a.a(d.l.b.a.a(paramab))));
        AppMethodBeat.o(56497);
        return paramab;
      }
      if (!bc.aF(paramab))
      {
        paramab = b.bu((Class)localObject);
        if (paramab != null) {
          break label293;
        }
        paramab = (d.l.b.a.b.m.ab)localObject;
      }
    }
    label293:
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
        paramab = (c)new w((as)localObject);
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
    if (((paramObject instanceof u)) && (d.g.b.k.g(this.Jko, ((u)paramObject).Jko)))
    {
      AppMethodBeat.o(56498);
      return true;
    }
    AppMethodBeat.o(56498);
    return false;
  }
  
  public final Type fwM()
  {
    AppMethodBeat.i(56495);
    Type localType = (Type)this.Jkl.invoke();
    AppMethodBeat.o(56495);
    return localType;
  }
  
  public final c fwe()
  {
    AppMethodBeat.i(56496);
    c localc = (c)this.Jkm.invoke();
    AppMethodBeat.o(56496);
    return localc;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56499);
    int i = this.Jko.hashCode();
    AppMethodBeat.o(56499);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56500);
    Object localObject = ab.JkB;
    localObject = ab.b(this.Jko);
    AppMethodBeat.o(56500);
    return localObject;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends q>>
  {
    a(u paramu)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Type>
    {
      a(int paramInt, u.a parama, f paramf, d.l.k paramk)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<List<? extends Type>>
    {
      b(u.a parama)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<c>
  {
    b(u paramu)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.u
 * JD-Core Version:    0.7.0.1
 */