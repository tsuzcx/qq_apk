package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class ab
  implements h
{
  private final Class<?> aiwN;
  private final String esT;
  
  public ab(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(129334);
    this.aiwN = paramClass;
    this.esT = paramString;
    AppMethodBeat.o(129334);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129331);
    if (((paramObject instanceof ab)) && (s.p(this.aiwN, ((ab)paramObject).aiwN)))
    {
      AppMethodBeat.o(129331);
      return true;
    }
    AppMethodBeat.o(129331);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129332);
    int i = this.aiwN.hashCode();
    AppMethodBeat.o(129332);
    return i;
  }
  
  public final Class<?> kls()
  {
    return this.aiwN;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129333);
    String str = this.aiwN.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(129333);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.ab
 * JD-Core Version:    0.7.0.1
 */