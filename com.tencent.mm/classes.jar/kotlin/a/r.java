package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.k.g;

@Metadata(d1={""}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class r
  extends q
{
  public static final g F(Collection<?> paramCollection)
  {
    AppMethodBeat.i(129044);
    s.u(paramCollection, "$this$indices");
    paramCollection = new g(0, paramCollection.size() - 1);
    AppMethodBeat.o(129044);
    return paramCollection;
  }
  
  public static final <T> int a(List<? extends T> paramList, int paramInt, b<? super T, Integer> paramb)
  {
    AppMethodBeat.i(191090);
    s.u(paramList, "$this$binarySearch");
    s.u(paramb, "comparison");
    int i = paramList.size();
    if (paramInt < 0)
    {
      paramList = (Throwable)new IllegalArgumentException("fromIndex (0) is greater than toIndex (" + paramInt + ").");
      AppMethodBeat.o(191090);
      throw paramList;
    }
    if (paramInt > i)
    {
      paramList = (Throwable)new IndexOutOfBoundsException("toIndex (" + paramInt + ") is greater than size (" + i + ").");
      AppMethodBeat.o(191090);
      throw paramList;
    }
    i = 0;
    paramInt -= 1;
    while (i <= paramInt)
    {
      int j = i + paramInt >>> 1;
      int k = ((Number)paramb.invoke(paramList.get(j))).intValue();
      if (k < 0)
      {
        i = j + 1;
      }
      else if (k > 0)
      {
        paramInt = j - 1;
      }
      else
      {
        AppMethodBeat.o(191090);
        return j;
      }
    }
    paramInt = -(i + 1);
    AppMethodBeat.o(191090);
    return paramInt;
  }
  
  public static final <T> Collection<T> ak(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129038);
    s.u(paramArrayOfT, "$this$asCollection");
    paramArrayOfT = (Collection)new i(paramArrayOfT, false);
    AppMethodBeat.o(129038);
    return paramArrayOfT;
  }
  
  public static final <T> ArrayList<T> al(T... paramVarArgs)
  {
    AppMethodBeat.i(129041);
    s.u(paramVarArgs, "elements");
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = new ArrayList();
      AppMethodBeat.o(129041);
      return paramVarArgs;
    }
    paramVarArgs = new ArrayList((Collection)new i(paramVarArgs, true));
    AppMethodBeat.o(129041);
    return paramVarArgs;
  }
  
  public static final <T> List<T> am(T... paramVarArgs)
  {
    AppMethodBeat.i(129043);
    s.u(paramVarArgs, "elements");
    paramVarArgs = k.ab(paramVarArgs);
    AppMethodBeat.o(129043);
    return paramVarArgs;
  }
  
  public static final <T> List<T> hs(T paramT)
  {
    AppMethodBeat.i(129042);
    if (paramT != null)
    {
      paramT = p.listOf(paramT);
      AppMethodBeat.o(129042);
      return paramT;
    }
    paramT = (List)ab.aivy;
    AppMethodBeat.o(129042);
    return paramT;
  }
  
  public static final void kkW()
  {
    AppMethodBeat.i(129047);
    Throwable localThrowable = (Throwable)new ArithmeticException("Index overflow has happened.");
    AppMethodBeat.o(129047);
    throw localThrowable;
  }
  
  public static final void kkX()
  {
    AppMethodBeat.i(129048);
    Throwable localThrowable = (Throwable)new ArithmeticException("Count overflow has happened.");
    AppMethodBeat.o(129048);
    throw localThrowable;
  }
  
  public static final <T> List<T> listOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129039);
    s.u(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = k.V(paramVarArgs);
      AppMethodBeat.o(129039);
      return paramVarArgs;
    }
    paramVarArgs = (List)ab.aivy;
    AppMethodBeat.o(129039);
    return paramVarArgs;
  }
  
  public static final <T> List<T> mutableListOf(T... paramVarArgs)
  {
    AppMethodBeat.i(129040);
    s.u(paramVarArgs, "elements");
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = (List)new ArrayList();
      AppMethodBeat.o(129040);
      return paramVarArgs;
    }
    paramVarArgs = (List)new ArrayList((Collection)new i(paramVarArgs, true));
    AppMethodBeat.o(129040);
    return paramVarArgs;
  }
  
  public static final <T> int oE(List<? extends T> paramList)
  {
    AppMethodBeat.i(129045);
    s.u(paramList, "$this$lastIndex");
    int i = paramList.size();
    AppMethodBeat.o(129045);
    return i - 1;
  }
  
  public static final <T> List<T> oF(List<? extends T> paramList)
  {
    AppMethodBeat.i(129046);
    s.u(paramList, "$this$optimizeReadOnlyList");
    switch (paramList.size())
    {
    default: 
      AppMethodBeat.o(129046);
      return paramList;
    case 0: 
      paramList = (List)ab.aivy;
      AppMethodBeat.o(129046);
      return paramList;
    }
    paramList = p.listOf(paramList.get(0));
    AppMethodBeat.o(129046);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.r
 * JD-Core Version:    0.7.0.1
 */