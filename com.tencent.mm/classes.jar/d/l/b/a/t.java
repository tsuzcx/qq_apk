package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.f;
import d.g.b.p;
import d.g.b.x;
import d.g.b.z;
import d.l;
import d.l.b.a.b.b.ar;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.d.b.b;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.bc;
import d.l.c;
import d.l.k;
import d.l.o;
import d.n;
import java.lang.reflect.Type;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"})
public final class t
  implements o
{
  private final y.a MOC;
  private final y.a MOD;
  private final y.a MOE;
  public final ab MOF;
  
  static
  {
    AppMethodBeat.i(56494);
    cwV = new k[] { (k)z.a(new x(z.bp(t.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), (k)z.a(new x(z.bp(t.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), (k)z.a(new x(z.bp(t.class), "arguments", "getArguments()Ljava/util/List;")) };
    AppMethodBeat.o(56494);
  }
  
  public t(ab paramab, d.g.a.a<? extends Type> parama)
  {
    AppMethodBeat.i(56501);
    this.MOF = paramab;
    this.MOC = y.R(parama);
    this.MOD = y.R((d.g.a.a)new b(this));
    this.MOE = y.R((d.g.a.a)new a(this));
    AppMethodBeat.o(56501);
  }
  
  private final c a(ab paramab)
  {
    AppMethodBeat.i(56497);
    Object localObject = paramab.gsZ().ghO();
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
        paramab = (av)j.jh(paramab.gsW());
        if (paramab != null)
        {
          paramab = paramab.gju();
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
        paramab = (c)new g(b.bD(d.g.a.a(d.l.b.a.a(paramab))));
        AppMethodBeat.o(56497);
        return paramab;
      }
      if (!bc.aF(paramab))
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
    if (((paramObject instanceof t)) && (p.i(this.MOF, ((t)paramObject).MOF)))
    {
      AppMethodBeat.o(56498);
      return true;
    }
    AppMethodBeat.o(56498);
    return false;
  }
  
  public final Type ggO()
  {
    AppMethodBeat.i(56495);
    Type localType = (Type)this.MOC.invoke();
    AppMethodBeat.o(56495);
    return localType;
  }
  
  public final c ggi()
  {
    AppMethodBeat.i(56496);
    c localc = (c)this.MOD.invoke();
    AppMethodBeat.o(56496);
    return localc;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56499);
    int i = this.MOF.hashCode();
    AppMethodBeat.o(56499);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56500);
    Object localObject = aa.MOS;
    localObject = aa.b(this.MOF);
    AppMethodBeat.o(56500);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<List<? extends d.l.q>>
  {
    a(t paramt)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke", "kotlin/reflect/jvm/internal/KTypeImpl$arguments$2$1$type$1"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<Type>
    {
      a(int paramInt, t.a parama, f paramf)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<List<? extends Type>>
    {
      b(t.a parama)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<c>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */