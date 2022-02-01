package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, fOb=1)
public class am
  extends al
{
  public static final <T> Set<T> m(Set<? extends T> paramSet)
  {
    AppMethodBeat.i(129118);
    k.h(paramSet, "$this$optimizeReadOnlySet");
    switch (paramSet.size())
    {
    default: 
      AppMethodBeat.o(129118);
      return paramSet;
    case 0: 
      paramSet = (Set)x.KTH;
      AppMethodBeat.o(129118);
      return paramSet;
    }
    paramSet = ak.setOf(paramSet.iterator().next());
    AppMethodBeat.o(129118);
    return paramSet;
  }
  
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129117);
    k.h(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.X(paramVarArgs);
      AppMethodBeat.o(129117);
      return paramVarArgs;
    }
    paramVarArgs = (Set)x.KTH;
    AppMethodBeat.o(129117);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.am
 * JD-Core Version:    0.7.0.1
 */