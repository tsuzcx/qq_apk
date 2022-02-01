package d.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.NoSuchElementException;

@l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"all", "", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", "S", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "reduce", "reduceIndexed", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "reversed", "scan", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"})
public class z
  extends y
{
  public static final char aL(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(129440);
    p.h(paramCharSequence, "$this$last");
    if (paramCharSequence.length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(129440);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(n.aH(paramCharSequence));
    AppMethodBeat.o(129440);
    return c;
  }
  
  public static final char aM(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199631);
    p.h(paramCharSequence, "$this$single");
    switch (paramCharSequence.length())
    {
    default: 
      paramCharSequence = (Throwable)new IllegalArgumentException("Char sequence has more than one element.");
      AppMethodBeat.o(199631);
      throw paramCharSequence;
    case 0: 
      paramCharSequence = (Throwable)new NoSuchElementException("Char sequence is empty.");
      AppMethodBeat.o(199631);
      throw paramCharSequence;
    }
    char c = paramCharSequence.charAt(0);
    AppMethodBeat.o(199631);
    return c;
  }
  
  public static final String hq(String paramString, int paramInt)
  {
    AppMethodBeat.i(129441);
    p.h(paramString, "$this$drop");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException(("Requested character count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129441);
      throw paramString;
    }
    paramString = paramString.substring(h.lq(paramInt, paramString.length()));
    p.g(paramString, "(this as java.lang.String).substring(startIndex)");
    AppMethodBeat.o(129441);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.n.z
 * JD-Core Version:    0.7.0.1
 */