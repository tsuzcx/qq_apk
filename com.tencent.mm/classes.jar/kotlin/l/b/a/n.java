package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.j;
import kotlin.l.j.a;
import kotlin.l.k;
import kotlin.l.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"})
public final class n
  implements j
{
  private final y.a SZW;
  private final y.a SZX;
  final e<?> TaS;
  final j.a TaT;
  final int index;
  
  static
  {
    AppMethodBeat.i(56434);
    cLI = new k[] { (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(n.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), (k)kotlin.g.b.aa.a(new kotlin.g.b.y(kotlin.g.b.aa.bp(n.class), "annotations", "getAnnotations()Ljava/util/List;")) };
    AppMethodBeat.o(56434);
  }
  
  public n(e<?> parame, int paramInt, j.a parama, kotlin.g.a.a<? extends ae> parama1)
  {
    AppMethodBeat.i(56440);
    this.TaS = parame;
    this.index = paramInt;
    this.TaT = parama;
    this.SZW = y.ak(parama1);
    this.SZX = y.ak((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(56440);
  }
  
  private final ae hyH()
  {
    AppMethodBeat.i(56435);
    ae localae = (ae)this.SZW.invoke();
    AppMethodBeat.o(56435);
    return localae;
  }
  
  public final boolean FI()
  {
    AppMethodBeat.i(186236);
    ae localae = hyH();
    Object localObject = localae;
    if (!(localae instanceof av)) {
      localObject = null;
    }
    localObject = (av)localObject;
    if (localObject != null)
    {
      boolean bool = kotlin.l.b.a.b.j.d.a.b((av)localObject);
      AppMethodBeat.o(186236);
      return bool;
    }
    AppMethodBeat.o(186236);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56437);
    if (((paramObject instanceof n)) && (p.j(this.TaS, ((n)paramObject).TaS)) && (p.j(hyH(), ((n)paramObject).hyH())))
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
    ae localae = hyH();
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
    if (((av)localObject).hBz().hAx())
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((av)localObject).hAH();
    p.g(localObject, "valueParameter.name");
    if (((f)localObject).TDa)
    {
      AppMethodBeat.o(56436);
      return null;
    }
    localObject = ((f)localObject).sG();
    AppMethodBeat.o(56436);
    return localObject;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56438);
    int i = this.TaS.hashCode();
    int j = hyH().hashCode();
    AppMethodBeat.o(56438);
    return i * 31 + j;
  }
  
  public final o hyl()
  {
    AppMethodBeat.i(186235);
    Object localObject = hyH().hBy();
    p.g(localObject, "descriptor.type");
    localObject = (o)new t((ab)localObject, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(186235);
    return localObject;
  }
  
  public final j.a hym()
  {
    return this.TaT;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56439);
    Object localObject = aa.TbF;
    localObject = aa.b(this);
    AppMethodBeat.o(56439);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(n paramn)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.n
 * JD-Core Version:    0.7.0.1
 */