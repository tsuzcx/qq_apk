package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstNotNullOf", "", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapIndexed", "flatMapIndexedIterable", "flatMapIndexedTo", "", "flatMapIndexedIterableTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "flatMapTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxOrNull", "maxWith", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "maxWithOrNull", "min", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minOrNull", "minWith", "minWithOrNull", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "onEachIndexed", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "reduce", "reduceIndexed", "reduceIndexedOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Character;", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightIndexedOrNull", "reduceRightOrNull", "reversed", "runningFold", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "runningFoldIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "runningReduce", "runningReduceIndexed", "scan", "scanIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "sumOf", "sumOfDouble", "sumOfInt", "", "sumOfLong", "Lkotlin/UInt;", "sumOfUInt", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)I", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)J", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
public class z
  extends y
{
  public static final char bA(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190942);
    s.u(paramCharSequence, "$this$single");
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = (Throwable)new IllegalArgumentException("Char sequence has more than one element.");
      AppMethodBeat.o(190942);
      throw paramCharSequence;
    case 0: 
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(190942);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(190942);
    return c;
  }
  
  public static final String bJJ(String paramString)
  {
    AppMethodBeat.i(190950);
    s.u(paramString, "$this$takeLast");
    int i = paramString.length();
    paramString = paramString.substring(i - k.qv(36, i));
    s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    AppMethodBeat.o(190950);
    return paramString;
  }
  
  public static final char bx(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190922);
    s.u(paramCharSequence, "$this$first");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(190922);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(190922);
    return c;
  }
  
  public static final Character by(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(190925);
    s.u(paramCharSequence, "$this$firstOrNull");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(190925);
      return null;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(190925);
    return Character.valueOf(c);
  }
  
  public static final char bz(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129440);
    s.u(paramCharSequence, "$this$last");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(129440);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(n.bt(paramCharSequence));
    AppMethodBeat.o(129440);
    return c;
  }
  
  public static final String jO(String paramString, int paramInt)
  {
    AppMethodBeat.i(129441);
    s.u(paramString, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129441);
      throw paramString;
    }
    paramString = paramString.substring(k.qv(paramInt, paramString.length()));
    s.s(paramString, "(this as java.lang.String).substring(startIndex)");
    AppMethodBeat.o(129441);
    return paramString;
  }
  
  public static final String jP(String paramString, int paramInt)
  {
    AppMethodBeat.i(190948);
    s.u(paramString, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(190948);
      throw paramString;
    }
    paramString = paramString.substring(0, k.qv(paramInt, paramString.length()));
    s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    AppMethodBeat.o(190948);
    return paramString;
  }
  
  public static final Character q(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(190930);
    s.u(paramCharSequence, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= n.bt(paramCharSequence)))
    {
      char c = paramCharSequence.charAt(paramInt);
      AppMethodBeat.o(190930);
      return Character.valueOf(c);
    }
    AppMethodBeat.o(190930);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.z
 * JD-Core Version:    0.7.0.1
 */