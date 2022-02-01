package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.q;
import d.g.b.x;
import d.g.b.z;
import d.l;
import d.l.b.a.b.b.as;
import d.l.k;
import d.l.o;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"})
public final class v
  implements d.l.p
{
  private final y.a NlP;
  final as NlQ;
  
  static
  {
    AppMethodBeat.i(56505);
    cxA = new k[] { (k)z.a(new x(z.bp(v.class), "upperBounds", "getUpperBounds()Ljava/util/List;")) };
    AppMethodBeat.o(56505);
  }
  
  public v(as paramas)
  {
    AppMethodBeat.i(56510);
    this.NlQ = paramas;
    this.NlP = y.R((a)new a(this));
    AppMethodBeat.o(56510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56507);
    if (((paramObject instanceof v)) && (d.g.b.p.i(this.NlQ, ((v)paramObject).NlQ)))
    {
      AppMethodBeat.o(56507);
      return true;
    }
    AppMethodBeat.o(56507);
    return false;
  }
  
  public final List<o> gkL()
  {
    AppMethodBeat.i(56506);
    List localList = (List)this.NlP.invoke();
    AppMethodBeat.o(56506);
    return localList;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56508);
    int i = this.NlQ.hashCode();
    AppMethodBeat.o(56508);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56509);
    Object localObject = aa.NlX;
    localObject = aa.a(this.NlQ);
    AppMethodBeat.o(56509);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
  static final class a
    extends q
    implements a<List<? extends t>>
  {
    a(v paramv)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.v
 * JD-Core Version:    0.7.0.1
 */