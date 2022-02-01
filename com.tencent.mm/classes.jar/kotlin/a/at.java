package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "setOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/SetsKt")
public class at
  extends as
{
  public static final <T> Set<T> M(Set<? extends T> paramSet)
  {
    AppMethodBeat.i(129118);
    s.u(paramSet, "$this$optimizeReadOnlySet");
    switch (paramSet.size())
    {
    default: 
      AppMethodBeat.o(129118);
      return paramSet;
    case 0: 
      paramSet = (Set)ad.aivA;
      AppMethodBeat.o(129118);
      return paramSet;
    }
    paramSet = ar.setOf(paramSet.iterator().next());
    AppMethodBeat.o(129118);
    return paramSet;
  }
  
  public static final <T> HashSet<T> an(T... paramVarArgs)
  {
    AppMethodBeat.i(191185);
    s.u(paramVarArgs, "elements");
    paramVarArgs = (HashSet)k.b(paramVarArgs, (Collection)new HashSet(ak.aKi(paramVarArgs.length)));
    AppMethodBeat.o(191185);
    return paramVarArgs;
  }
  
  public static final <T> Set<T> mutableSetOf(T... paramVarArgs)
  {
    AppMethodBeat.i(191181);
    s.u(paramVarArgs, "elements");
    paramVarArgs = (Set)k.b(paramVarArgs, (Collection)new LinkedHashSet(ak.aKi(paramVarArgs.length)));
    AppMethodBeat.o(191181);
    return paramVarArgs;
  }
  
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129117);
    s.u(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = k.ag(paramVarArgs);
      AppMethodBeat.o(129117);
      return paramVarArgs;
    }
    paramVarArgs = (Set)ad.aivA;
    AppMethodBeat.o(129117);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.at
 * JD-Core Version:    0.7.0.1
 */