package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.l.b.a.b.b.as;
import kotlin.l.n;
import kotlin.l.u;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"})
public final class v
  implements kotlin.l.v
{
  private final y.a aaEr;
  final as aaEs;
  
  static
  {
    AppMethodBeat.i(56505);
    cMt = new n[] { (n)ab.a(new z(ab.bO(v.class), "upperBounds", "getUpperBounds()Ljava/util/List;")) };
    AppMethodBeat.o(56505);
  }
  
  public v(as paramas)
  {
    AppMethodBeat.i(56510);
    this.aaEs = paramas;
    this.aaEr = y.au((a)new a(this));
    AppMethodBeat.o(56510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56507);
    if (((paramObject instanceof v)) && (p.h(this.aaEs, ((v)paramObject).aaEs)))
    {
      AppMethodBeat.o(56507);
      return true;
    }
    AppMethodBeat.o(56507);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56508);
    int i = this.aaEs.hashCode();
    AppMethodBeat.o(56508);
    return i;
  }
  
  public final List<u> iCz()
  {
    AppMethodBeat.i(56506);
    List localList = (List)this.aaEr.invoke();
    AppMethodBeat.o(56506);
    return localList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56509);
    Object localObject = aa.aaEz;
    localObject = aa.a(this.aaEs);
    AppMethodBeat.o(56509);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
  static final class a
    extends q
    implements a<List<? extends t>>
  {
    a(v paramv)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"})
    static final class a
      extends q
      implements a
    {
      a(v.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.v
 * JD-Core Version:    0.7.0.1
 */