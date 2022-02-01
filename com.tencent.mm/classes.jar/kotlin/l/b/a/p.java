package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.n;
import kotlin.l.n.a;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class p
  implements n
{
  private final ac.a aiyA;
  private final ac.a aiyz;
  final f<?> aizD;
  final n.a aizE;
  final int index;
  
  static
  {
    AppMethodBeat.i(56434);
    aYe = new o[] { (o)ai.a(new ag(ai.cz(p.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (o)ai.a(new ag(ai.cz(p.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(56434);
  }
  
  public p(f<?> paramf, int paramInt, n.a parama, kotlin.g.a.a<? extends am> parama1)
  {
    AppMethodBeat.i(56440);
    this.aizD = paramf;
    this.index = paramInt;
    this.aizE = parama;
    this.aiyz = ac.cp(parama1);
    this.aiyA = ac.cp((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(56440);
  }
  
  private final am kmm()
  {
    AppMethodBeat.i(56435);
    am localam = (am)this.aiyz.invoke();
    AppMethodBeat.o(56435);
    return localam;
  }
  
  public final boolean ahk()
  {
    AppMethodBeat.i(191369);
    am localam = kmm();
    Object localObject = localam;
    if (!(localam instanceof bd)) {
      localObject = null;
    }
    localObject = (bd)localObject;
    if (localObject != null)
    {
      boolean bool = kotlin.l.b.a.b.j.d.a.b((bd)localObject);
      AppMethodBeat.o(191369);
      return bool;
    }
    AppMethodBeat.o(191369);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56437);
    if (((paramObject instanceof p)) && (s.p(this.aizD, ((p)paramObject).aizD)) && (this.index == ((p)paramObject).index))
    {
      AppMethodBeat.o(56437);
      return true;
    }
    AppMethodBeat.o(56437);
    return false;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56436);
    am localam = kmm();
    Object localObject = localam;
    if (!(localam instanceof bd)) {
      localObject = null;
    }
    localObject = (bd)localObject;
    if (localObject == null)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    if (((bd)localObject).kpo().koe())
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((bd)localObject).kok();
    s.s(localObject, "valueParameter.name");
    if (((kotlin.l.b.a.b.f.f)localObject).ajeG)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((kotlin.l.b.a.b.f.f)localObject).PF();
    AppMethodBeat.o(56436);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56438);
    int i = this.aizD.hashCode();
    int j = Integer.valueOf(this.index).hashCode();
    AppMethodBeat.o(56438);
    return i * 31 + j;
  }
  
  public final kotlin.l.u klN()
  {
    AppMethodBeat.i(191367);
    Object localObject = kmm().koG();
    s.s(localObject, "descriptor.type");
    localObject = (kotlin.l.u)new v((ad)localObject, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(191367);
    return localObject;
  }
  
  public final n.a klO()
  {
    return this.aizE;
  }
  
  public final boolean klP()
  {
    AppMethodBeat.i(191370);
    am localam = kmm();
    if (((localam instanceof bd)) && (((bd)localam).kpq() != null))
    {
      AppMethodBeat.o(191370);
      return true;
    }
    AppMethodBeat.o(191370);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56439);
    Object localObject = ae.aiAr;
    localObject = ae.b(this);
    AppMethodBeat.o(56439);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Type>
  {
    b(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.p
 * JD-Core Version:    0.7.0.1
 */