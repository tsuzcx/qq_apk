package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.w;
import d.l.b.a.b.b.ae;
import d.l.b.a.b.b.av;
import d.l.b.a.b.f.f;
import d.l.j;
import d.l.j.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"})
public final class o
  implements j
{
  private final z.a KWd;
  private final z.a KWe;
  final e<?> KXi;
  final j.a KXj;
  final int index;
  
  static
  {
    AppMethodBeat.i(56434);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (d.l.k)w.a(new d.g.b.u(w.bn(o.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(56434);
  }
  
  public o(e<?> parame, int paramInt, j.a parama, d.g.a.a<? extends ae> parama1)
  {
    AppMethodBeat.i(56440);
    this.KXi = parame;
    this.index = paramInt;
    this.KXj = parama;
    this.KWd = z.N(parama1);
    this.KWe = z.N((d.g.a.a)new a(this));
    AppMethodBeat.o(56440);
  }
  
  private final ae fPe()
  {
    AppMethodBeat.i(56435);
    ae localae = (ae)this.KWd.invoke();
    AppMethodBeat.o(56435);
    return localae;
  }
  
  public final boolean bmP()
  {
    AppMethodBeat.i(207357);
    ae localae = fPe();
    Object localObject = localae;
    if (!(localae instanceof av)) {
      localObject = null;
    }
    localObject = (av)localObject;
    if (localObject != null)
    {
      boolean bool = d.l.b.a.b.j.d.a.b((av)localObject);
      AppMethodBeat.o(207357);
      return bool;
    }
    AppMethodBeat.o(207357);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56437);
    if (((paramObject instanceof o)) && (d.g.b.k.g(this.KXi, ((o)paramObject).KXi)) && (d.g.b.k.g(fPe(), ((o)paramObject).fPe())))
    {
      AppMethodBeat.o(56437);
      return true;
    }
    AppMethodBeat.o(56437);
    return false;
  }
  
  public final d.l.o fOG()
  {
    AppMethodBeat.i(207356);
    Object localObject = fPe().fRV();
    d.g.b.k.g(localObject, "descriptor.type");
    localObject = (d.l.o)new u((d.l.b.a.b.m.ab)localObject, (d.g.a.a)new b(this));
    AppMethodBeat.o(207356);
    return localObject;
  }
  
  public final j.a fOH()
  {
    return this.KXj;
  }
  
  public final String getName()
  {
    AppMethodBeat.i(56436);
    ae localae = fPe();
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
    if (((av)localObject).fRW().fQV())
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((av)localObject).fRf();
    d.g.b.k.g(localObject, "valueParameter.name");
    if (((f)localObject).Lzs)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((f)localObject).rf();
    AppMethodBeat.o(56436);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56438);
    int i = this.KXi.hashCode();
    int j = fPe().hashCode();
    AppMethodBeat.o(56438);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56439);
    Object localObject = ab.KXV;
    localObject = ab.b(this);
    AppMethodBeat.o(56439);
    return localObject;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends Annotation>>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<Type>
  {
    b(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.o
 * JD-Core Version:    0.7.0.1
 */