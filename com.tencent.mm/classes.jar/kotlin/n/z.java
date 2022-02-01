package kotlin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "reduce", "reduceIndexed", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "reversed", "scan", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, iBN=1)
public class z
  extends y
{
  public static final char bi(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129440);
    p.k(paramCharSequence, "$this$last");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(129440);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(n.be(paramCharSequence));
    AppMethodBeat.o(129440);
    return c;
  }
  
  public static final char bj(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(218107);
    p.k(paramCharSequence, "$this$single");
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = (Throwable)new IllegalArgumentException("Char sequence has more than one element.");
      AppMethodBeat.o(218107);
      throw paramCharSequence;
    case 0: 
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(218107);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(218107);
    return c;
  }
  
  public static final Character bl(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(292761);
    p.k(paramCharSequence, "$this$firstOrNull");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(292761);
      return null;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(292761);
    return Character.valueOf(c);
  }
  
  public static final String iE(String paramString, int paramInt)
  {
    AppMethodBeat.i(129441);
    p.k(paramString, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129441);
      throw paramString;
    }
    paramString = paramString.substring(i.ow(paramInt, paramString.length()));
    p.j(paramString, "(this as java.lang.String).substring(startIndex)");
    AppMethodBeat.o(129441);
    return paramString;
  }
  
  public static final Character w(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(218103);
    p.k(paramCharSequence, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= n.be(paramCharSequence)))
    {
      char c = paramCharSequence.charAt(paramInt);
      AppMethodBeat.o(218103);
      return Character.valueOf(c);
    }
    AppMethodBeat.o(218103);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.n.z
 * JD-Core Version:    0.7.0.1
 */