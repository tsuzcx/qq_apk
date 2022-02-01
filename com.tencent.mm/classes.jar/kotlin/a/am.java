package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, iBN=1)
public class am
  extends al
{
  public static final <T> Set<T> B(Set<? extends T> paramSet)
  {
    AppMethodBeat.i(129118);
    p.k(paramSet, "$this$optimizeReadOnlySet");
    switch (paramSet.size())
    {
    default: 
      AppMethodBeat.o(129118);
      return paramSet;
    case 0: 
      paramSet = (Set)x.aaAf;
      AppMethodBeat.o(129118);
      return paramSet;
    }
    paramSet = ak.setOf(paramSet.iterator().next());
    AppMethodBeat.o(129118);
    return paramSet;
  }
  
  public static final <T> HashSet<T> ai(T... paramVarArgs)
  {
    AppMethodBeat.i(218807);
    p.k(paramVarArgs, "elements");
    paramVarArgs = (HashSet)e.b(paramVarArgs, (Collection)new HashSet(ae.aDD(paramVarArgs.length)));
    AppMethodBeat.o(218807);
    return paramVarArgs;
  }
  
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129117);
    p.k(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.ac(paramVarArgs);
      AppMethodBeat.o(129117);
      return paramVarArgs;
    }
    paramVarArgs = (Set)x.aaAf;
    AppMethodBeat.o(129117);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.am
 * JD-Core Version:    0.7.0.1
 */