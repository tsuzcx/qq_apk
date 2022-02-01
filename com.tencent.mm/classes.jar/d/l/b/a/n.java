package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l;
import d.l.b.a.b.b.ae;
import d.l.b.a.b.b.av;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.l.j;
import d.l.j.a;
import d.l.k;
import d.l.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"})
public final class n
  implements j
{
  private final y.a MNj;
  private final y.a MNk;
  final e<?> MOf;
  final j.a MOg;
  final int index;
  
  static
  {
    AppMethodBeat.i(56434);
    cwV = new k[] { (k)z.a(new x(z.bp(n.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (k)z.a(new x(z.bp(n.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(56434);
  }
  
  public n(e<?> parame, int paramInt, j.a parama, d.g.a.a<? extends ae> parama1)
  {
    AppMethodBeat.i(56440);
    this.MOf = parame;
    this.index = paramInt;
    this.MOg = parama;
    this.MNj = y.R(parama1);
    this.MNk = y.R((d.g.a.a)new a(this));
    AppMethodBeat.o(56440);
  }
  
  private final ae ggC()
  {
    AppMethodBeat.i(56435);
    ae localae = (ae)this.MNj.invoke();
    AppMethodBeat.o(56435);
    return localae;
  }
  
  public final boolean bqA()
  {
    AppMethodBeat.i(187764);
    ae localae = ggC();
    Object localObject = localae;
    if (!(localae instanceof av)) {
      localObject = null;
    }
    localObject = (av)localObject;
    if (localObject != null)
    {
      boolean bool = d.l.b.a.b.j.d.a.b((av)localObject);
      AppMethodBeat.o(187764);
      return bool;
    }
    AppMethodBeat.o(187764);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56437);
    if (((paramObject instanceof n)) && (p.i(this.MOf, ((n)paramObject).MOf)) && (p.i(ggC(), ((n)paramObject).ggC())))
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
    ae localae = ggC();
    Object localObject = localae;
    if (!(localae instanceof av)) {
      localObject = null;
    }
    localObject = (av)localObject;
    if (localObject == null)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    if (((av)localObject).gjv().git())
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((av)localObject).giD();
    p.g(localObject, "valueParameter.name");
    if (((f)localObject).Nqp)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((f)localObject).sD();
    AppMethodBeat.o(56436);
    return localObject;
  }
  
  public final o ggg()
  {
    AppMethodBeat.i(187763);
    Object localObject = ggC().gju();
    p.g(localObject, "descriptor.type");
    localObject = (o)new t((ab)localObject, (d.g.a.a)new b(this));
    AppMethodBeat.o(187763);
    return localObject;
  }
  
  public final j.a ggh()
  {
    return this.MOg;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56438);
    int i = this.MOf.hashCode();
    int j = ggC().hashCode();
    AppMethodBeat.o(56438);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56439);
    Object localObject = aa.MOS;
    localObject = aa.b(this);
    AppMethodBeat.o(56439);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<List<? extends Annotation>>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<Type>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.n
 * JD-Core Version:    0.7.0.1
 */