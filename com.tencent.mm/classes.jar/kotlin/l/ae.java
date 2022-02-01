package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getLowerBounds", "", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "getUpperBounds", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class ae
  implements WildcardType, aa
{
  private static final ae aixU;
  public static final ae.a aixV;
  private final Type dFg;
  private final Type dFh;
  
  static
  {
    AppMethodBeat.i(191288);
    aixV = new ae.a((byte)0);
    aixU = new ae(null, null);
    AppMethodBeat.o(191288);
  }
  
  public ae(Type paramType1, Type paramType2)
  {
    this.dFg = paramType1;
    this.dFh = paramType2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191324);
    if (((paramObject instanceof WildcardType)) && (Arrays.equals(getUpperBounds(), ((WildcardType)paramObject).getUpperBounds())) && (Arrays.equals(getLowerBounds(), ((WildcardType)paramObject).getLowerBounds())))
    {
      AppMethodBeat.o(191324);
      return true;
    }
    AppMethodBeat.o(191324);
    return false;
  }
  
  public final Type[] getLowerBounds()
  {
    if (this.dFh == null) {
      return new Type[0];
    }
    return new Type[] { this.dFh };
  }
  
  public final String getTypeName()
  {
    AppMethodBeat.i(191316);
    String str;
    if (this.dFh != null)
    {
      str = "? super " + ac.i(this.dFh);
      AppMethodBeat.o(191316);
      return str;
    }
    if ((this.dFg != null) && ((s.p(this.dFg, Object.class) ^ true)))
    {
      str = "? extends " + ac.i(this.dFg);
      AppMethodBeat.o(191316);
      return str;
    }
    AppMethodBeat.o(191316);
    return "?";
  }
  
  public final Type[] getUpperBounds()
  {
    Type localType2 = this.dFg;
    Type localType1 = localType2;
    if (localType2 == null) {
      localType1 = (Type)Object.class;
    }
    return new Type[] { localType1 };
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191330);
    int i = Arrays.hashCode(getUpperBounds());
    int j = Arrays.hashCode(getLowerBounds());
    AppMethodBeat.o(191330);
    return i ^ j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191333);
    String str = getTypeName();
    AppMethodBeat.o(191333);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.ae
 * JD-Core Version:    0.7.0.1
 */