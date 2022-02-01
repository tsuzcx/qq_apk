package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l.b.a.b.b.as;
import d.l.o;
import d.l.p;
import java.util.List;

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"})
public final class w
  implements p
{
  private final z.a Jkt;
  final as Jku;
  
  static
  {
    AppMethodBeat.i(56505);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bk(w.class), "upperBounds", "getUpperBounds()Ljava/util/List;")) };
    AppMethodBeat.o(56505);
  }
  
  public w(as paramas)
  {
    AppMethodBeat.i(56510);
    this.Jku = paramas;
    this.Jkt = z.G((a)new a(this));
    AppMethodBeat.o(56510);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56507);
    if (((paramObject instanceof w)) && (d.g.b.k.g(this.Jku, ((w)paramObject).Jku)))
    {
      AppMethodBeat.o(56507);
      return true;
    }
    AppMethodBeat.o(56507);
    return false;
  }
  
  public final List<o> fwf()
  {
    AppMethodBeat.i(56506);
    List localList = (List)this.Jkt.invoke();
    AppMethodBeat.o(56506);
    return localList;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(56508);
    int i = this.Jku.hashCode();
    AppMethodBeat.o(56508);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56509);
    Object localObject = ab.JkB;
    localObject = ab.a(this.Jku);
    AppMethodBeat.o(56509);
    return localObject;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<List<? extends u>>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.w
 * JD-Core Version:    0.7.0.1
 */