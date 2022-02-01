package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.f.f;
import kotlin.l.m;
import kotlin.l.m.a;
import kotlin.l.u;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"})
public final class n
  implements m
{
  private final y.a aaCQ;
  private final y.a aaCR;
  final e<?> aaDM;
  final m.a aaDN;
  final int index;
  
  static
  {
    AppMethodBeat.i(56434);
    cMt = new kotlin.l.n[] { (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(n.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (kotlin.l.n)kotlin.g.b.ab.a(new z(kotlin.g.b.ab.bO(n.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(56434);
  }
  
  public n(e<?> parame, int paramInt, m.a parama, kotlin.g.a.a<? extends ae> parama1)
  {
    AppMethodBeat.i(56440);
    this.aaDM = parame;
    this.index = paramInt;
    this.aaDN = parama;
    this.aaCQ = y.au(parama1);
    this.aaCR = y.au((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(56440);
  }
  
  private final ae iCS()
  {
    AppMethodBeat.i(56435);
    ae localae = (ae)this.aaCQ.invoke();
    AppMethodBeat.o(56435);
    return localae;
  }
  
  public final boolean Ho()
  {
    AppMethodBeat.i(246324);
    ae localae = iCS();
    Object localObject = localae;
    if (!(localae instanceof av)) {
      localObject = null;
    }
    localObject = (av)localObject;
    if (localObject != null)
    {
      boolean bool = kotlin.l.b.a.b.j.d.a.b((av)localObject);
      AppMethodBeat.o(246324);
      return bool;
    }
    AppMethodBeat.o(246324);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56437);
    if (((paramObject instanceof n)) && (p.h(this.aaDM, ((n)paramObject).aaDM)) && (p.h(iCS(), ((n)paramObject).iCS())))
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
    ae localae = iCS();
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
    if (((av)localObject).iFO().iEK())
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((av)localObject).iEU();
    p.j(localObject, "valueParameter.name");
    if (((f)localObject).abfN)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((f)localObject).qu();
    AppMethodBeat.o(56436);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56438);
    int i = this.aaDM.hashCode();
    int j = iCS().hashCode();
    AppMethodBeat.o(56438);
    return i * 31 + j;
  }
  
  public final u iCw()
  {
    AppMethodBeat.i(246323);
    Object localObject = iCS().iFN();
    p.j(localObject, "descriptor.type");
    localObject = (u)new t((kotlin.l.b.a.b.m.ab)localObject, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(246323);
    return localObject;
  }
  
  public final m.a iCx()
  {
    return this.aaDN;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56439);
    Object localObject = aa.aaEz;
    localObject = aa.b(this);
    AppMethodBeat.o(56439);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Type>
  {
    b(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.n
 * JD-Core Version:    0.7.0.1
 */