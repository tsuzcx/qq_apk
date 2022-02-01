package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "kotlin-stdlib"})
public final class p
  implements d
{
  private final Class<?> KUC;
  private final String ceF;
  
  public p(Class<?> paramClass, String paramString)
  {
    AppMethodBeat.i(129334);
    this.KUC = paramClass;
    this.ceF = paramString;
    AppMethodBeat.o(129334);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129331);
    if (((paramObject instanceof p)) && (k.g(this.KUC, ((p)paramObject).KUC)))
    {
      AppMethodBeat.o(129331);
      return true;
    }
    AppMethodBeat.o(129331);
    return false;
  }
  
  public final Class<?> fOt()
  {
    return this.KUC;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129332);
    int i = this.KUC.hashCode();
    AppMethodBeat.o(129332);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129333);
    String str = this.KUC.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(129333);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.p
 * JD-Core Version:    0.7.0.1
 */