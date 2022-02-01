package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "kotlin-stdlib"}, iBN=1)
public class l
  extends k
{
  public static final <T> Collection<T> af(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129038);
    p.k(paramArrayOfT, "$this$asCollection");
    paramArrayOfT = (Collection)new d(paramArrayOfT, false);
    AppMethodBeat.o(129038);
    return paramArrayOfT;
  }
  
  public static final <T> ArrayList<T> ag(T... paramVarArgs)
  {
    AppMethodBeat.i(129041);
    p.k(paramVarArgs, "elements");
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = new ArrayList();
      AppMethodBeat.o(129041);
      return paramVarArgs;
    }
    paramVarArgs = new ArrayList((Collection)new d(paramVarArgs, true));
    AppMethodBeat.o(129041);
    return paramVarArgs;
  }
  
  public static final <T> List<T> ah(T... paramVarArgs)
  {
    AppMethodBeat.i(129043);
    p.k(paramVarArgs, "elements");
    paramVarArgs = e.X(paramVarArgs);
    AppMethodBeat.o(129043);
    return paramVarArgs;
  }
  
  public static final <T> List<T> eY(T paramT)
  {
    AppMethodBeat.i(129042);
    if (paramT != null)
    {
      paramT = j.listOf(paramT);
      AppMethodBeat.o(129042);
      return paramT;
    }
    paramT = (List)v.aaAd;
    AppMethodBeat.o(129042);
    return paramT;
  }
  
  public static final void iBO()
  {
    AppMethodBeat.i(129047);
    Throwable localThrowable = (Throwable)new ArithmeticException("Index overflow has happened.");
    AppMethodBeat.o(129047);
    throw localThrowable;
  }
  
  public static final void iBP()
  {
    AppMethodBeat.i(129048);
    Throwable localThrowable = (Throwable)new ArithmeticException("Count overflow has happened.");
    AppMethodBeat.o(129048);
    throw localThrowable;
  }
  
  public static final <T> List<T> listOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129039);
    p.k(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.Q(paramVarArgs);
      AppMethodBeat.o(129039);
      return paramVarArgs;
    }
    paramVarArgs = (List)v.aaAd;
    AppMethodBeat.o(129039);
    return paramVarArgs;
  }
  
  public static final <T> int lk(List<? extends T> paramList)
  {
    AppMethodBeat.i(129045);
    p.k(paramList, "$this$lastIndex");
    int i = paramList.size();
    AppMethodBeat.o(129045);
    return i - 1;
  }
  
  public static final <T> List<T> ll(List<? extends T> paramList)
  {
    AppMethodBeat.i(129046);
    p.k(paramList, "$this$optimizeReadOnlyList");
    switch (paramList.size())
    {
    default: 
      AppMethodBeat.o(129046);
      return paramList;
    case 0: 
      paramList = (List)v.aaAd;
      AppMethodBeat.o(129046);
      return paramList;
    }
    paramList = j.listOf(paramList.get(0));
    AppMethodBeat.o(129046);
    return paramList;
  }
  
  public static final <T> List<T> mutableListOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129040);
    p.k(paramVarArgs, "elements");
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = (List)new ArrayList();
      AppMethodBeat.o(129040);
      return paramVarArgs;
    }
    paramVarArgs = (List)new ArrayList((Collection)new d(paramVarArgs, true));
    AppMethodBeat.o(129040);
    return paramVarArgs;
  }
  
  public static final kotlin.k.e p(Collection<?> paramCollection)
  {
    AppMethodBeat.i(129044);
    p.k(paramCollection, "$this$indices");
    paramCollection = new kotlin.k.e(0, paramCollection.size() - 1);
    AppMethodBeat.o(129044);
    return paramCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.l
 * JD-Core Version:    0.7.0.1
 */