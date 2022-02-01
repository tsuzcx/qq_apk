package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"buildSet", "", "E", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptySet", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, hxG=1)
public class am
  extends al
{
  public static final <T> Set<T> C(Set<? extends T> paramSet)
  {
    AppMethodBeat.i(129118);
    p.h(paramSet, "$this$optimizeReadOnlySet");
    switch (paramSet.size())
    {
    default: 
      AppMethodBeat.o(129118);
      return paramSet;
    case 0: 
      paramSet = (Set)x.SXt;
      AppMethodBeat.o(129118);
      return paramSet;
    }
    paramSet = ak.setOf(paramSet.iterator().next());
    AppMethodBeat.o(129118);
    return paramSet;
  }
  
  public static final <T> HashSet<T> ae(T... paramVarArgs)
  {
    AppMethodBeat.i(206263);
    p.h(paramVarArgs, "elements");
    paramVarArgs = (HashSet)e.b(paramVarArgs, (Collection)new HashSet(ae.atJ(paramVarArgs.length)));
    AppMethodBeat.o(206263);
    return paramVarArgs;
  }
  
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129117);
    p.h(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.Y(paramVarArgs);
      AppMethodBeat.o(129117);
      return paramVarArgs;
    }
    paramVarArgs = (Set)x.SXt;
    AppMethodBeat.o(129117);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.am
 * JD-Core Version:    0.7.0.1
 */