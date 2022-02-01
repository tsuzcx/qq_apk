package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getGenericComponentType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
final class a
  implements GenericArrayType, aa
{
  private final Type aixE;
  
  public a(Type paramType)
  {
    AppMethodBeat.i(191309);
    this.aixE = paramType;
    AppMethodBeat.o(191309);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191328);
    if (((paramObject instanceof GenericArrayType)) && (s.p(getGenericComponentType(), ((GenericArrayType)paramObject).getGenericComponentType())))
    {
      AppMethodBeat.o(191328);
      return true;
    }
    AppMethodBeat.o(191328);
    return false;
  }
  
  public final Type getGenericComponentType()
  {
    return this.aixE;
  }
  
  public final String getTypeName()
  {
    AppMethodBeat.i(191321);
    String str = ac.i(this.aixE) + "[]";
    AppMethodBeat.o(191321);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191335);
    int i = getGenericComponentType().hashCode();
    AppMethodBeat.o(191335);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191337);
    String str = getTypeName();
    AppMethodBeat.o(191337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.l.a
 * JD-Core Version:    0.7.0.1
 */