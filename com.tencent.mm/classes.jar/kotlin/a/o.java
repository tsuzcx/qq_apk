package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.c;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.e;
import kotlin.k.g;
import kotlin.m.d;
import kotlin.m.h;

@Metadata(d1={"", ""}, d2={"indices", "Lkotlin/ranges/IntRange;", "T", "", "getIndices", "([Ljava/lang/Object;)Lkotlin/ranges/IntRange;", "", "([Z)Lkotlin/ranges/IntRange;", "", "([B)Lkotlin/ranges/IntRange;", "", "([C)Lkotlin/ranges/IntRange;", "", "([D)Lkotlin/ranges/IntRange;", "", "([F)Lkotlin/ranges/IntRange;", "", "([I)Lkotlin/ranges/IntRange;", "", "([J)Lkotlin/ranges/IntRange;", "", "([S)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "([Ljava/lang/Object;)I", "([Z)I", "([B)I", "([C)I", "([D)I", "([F)I", "([I)I", "([J)I", "([S)I", "all", "", "predicate", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "", "", "", "", "", "", "any", "([Ljava/lang/Object;)Z", "asIterable", "", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "asSequence", "Lkotlin/sequences/Sequence;", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateBy", "keySelector", "valueTransform", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateByTo", "M", "", "destination", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "averageOfByte", "([Ljava/lang/Byte;)D", "averageOfDouble", "([Ljava/lang/Double;)D", "averageOfFloat", "([Ljava/lang/Float;)D", "averageOfInt", "([Ljava/lang/Integer;)D", "averageOfLong", "([Ljava/lang/Long;)D", "averageOfShort", "([Ljava/lang/Short;)D", "component1", "([Ljava/lang/Object;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "count", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "distinct", "", "([Ljava/lang/Object;)Ljava/util/List;", "distinctBy", "selector", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "drop", "n", "([Ljava/lang/Object;I)Ljava/util/List;", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([ZI)Ljava/lang/Boolean;", "([BI)Ljava/lang/Byte;", "([CI)Ljava/lang/Character;", "([DI)Ljava/lang/Double;", "([FI)Ljava/lang/Float;", "([II)Ljava/lang/Integer;", "([JI)Ljava/lang/Long;", "([SI)Ljava/lang/Short;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexedTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "R", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Short;", "findLast", "first", "firstNotNullOf", "firstNotNullOfOrNull", "firstOrNull", "([Z)Ljava/lang/Boolean;", "([B)Ljava/lang/Byte;", "([C)Ljava/lang/Character;", "([D)Ljava/lang/Double;", "([F)Ljava/lang/Float;", "([I)Ljava/lang/Integer;", "([J)Ljava/lang/Long;", "([S)Ljava/lang/Short;", "flatMap", "flatMapSequence", "flatMapIndexed", "flatMapIndexedIterable", "flatMapIndexedSequence", "flatMapIndexedTo", "flatMapIndexedIterableTo", "flatMapIndexedSequenceTo", "flatMapTo", "flatMapSequenceTo", "fold", "initial", "operation", "acc", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/collections/Grouping;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/Set;", "isEmpty", "isNotEmpty", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ZLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([CLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([DLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([FLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ILjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([JLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([SLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "([Ljava/lang/Comparable;)Ljava/lang/Comparable;", "([Ljava/lang/Double;)Ljava/lang/Double;", "([Ljava/lang/Float;)Ljava/lang/Float;", "maxBy", "maxByOrNull", "maxOf", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)D", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)F", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "maxOfOrNull", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([ZLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([BLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([CLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([DLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([FLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([ILjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([JLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([SLjava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxOrNull", "maxWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "([ZLjava/util/Comparator;)Ljava/lang/Boolean;", "([BLjava/util/Comparator;)Ljava/lang/Byte;", "([CLjava/util/Comparator;)Ljava/lang/Character;", "([DLjava/util/Comparator;)Ljava/lang/Double;", "([FLjava/util/Comparator;)Ljava/lang/Float;", "([ILjava/util/Comparator;)Ljava/lang/Integer;", "([JLjava/util/Comparator;)Ljava/lang/Long;", "([SLjava/util/Comparator;)Ljava/lang/Short;", "maxWithOrNull", "min", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minOrNull", "minWith", "minWithOrNull", "none", "onEach", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "onEachIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "partition", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "random", "Lkotlin/random/Random;", "([Ljava/lang/Object;Lkotlin/random/Random;)Ljava/lang/Object;", "randomOrNull", "([ZLkotlin/random/Random;)Ljava/lang/Boolean;", "([BLkotlin/random/Random;)Ljava/lang/Byte;", "([CLkotlin/random/Random;)Ljava/lang/Character;", "([DLkotlin/random/Random;)Ljava/lang/Double;", "([FLkotlin/random/Random;)Ljava/lang/Float;", "([ILkotlin/random/Random;)Ljava/lang/Integer;", "([JLkotlin/random/Random;)Ljava/lang/Long;", "([SLkotlin/random/Random;)Ljava/lang/Short;", "reduce", "S", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceIndexedOrNull", "([ZLkotlin/jvm/functions/Function3;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function3;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function3;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function3;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function3;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function3;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function3;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function3;)Ljava/lang/Short;", "reduceOrNull", "([ZLkotlin/jvm/functions/Function2;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function2;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function2;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function2;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function2;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function2;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function2;)Ljava/lang/Short;", "reduceRight", "reduceRightIndexed", "reduceRightIndexedOrNull", "reduceRightOrNull", "requireNoNulls", "([Ljava/lang/Object;)[Ljava/lang/Object;", "reverse", "([Ljava/lang/Object;)V", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "reversed", "reversedArray", "runningFold", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "runningFoldIndexed", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "runningReduce", "runningReduceIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scan", "scanIndexed", "shuffle", "([Ljava/lang/Object;Lkotlin/random/Random;)V", "single", "singleOrNull", "slice", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)Ljava/util/List;", "sliceArray", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)[Ljava/lang/Object;", "sortBy", "sortByDescending", "sortDescending", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Comparable;II)V", "sorted", "([Ljava/lang/Comparable;)Ljava/util/List;", "sortedArray", "([Ljava/lang/Comparable;)[Ljava/lang/Comparable;", "sortedArrayDescending", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "subtract", "sum", "sumOfByte", "([Ljava/lang/Byte;)I", "sumOfDouble", "sumOfFloat", "([Ljava/lang/Float;)F", "sumOfInt", "([Ljava/lang/Integer;)I", "sumOfLong", "([Ljava/lang/Long;)J", "sumOfShort", "([Ljava/lang/Short;)I", "sumBy", "sumByDouble", "sumOf", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)J", "Lkotlin/UInt;", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "([ZLkotlin/jvm/functions/Function1;)I", "([ZLkotlin/jvm/functions/Function1;)J", "([BLkotlin/jvm/functions/Function1;)I", "([BLkotlin/jvm/functions/Function1;)J", "([CLkotlin/jvm/functions/Function1;)I", "([CLkotlin/jvm/functions/Function1;)J", "([DLkotlin/jvm/functions/Function1;)I", "([DLkotlin/jvm/functions/Function1;)J", "([FLkotlin/jvm/functions/Function1;)I", "([FLkotlin/jvm/functions/Function1;)J", "([ILkotlin/jvm/functions/Function1;)I", "([ILkotlin/jvm/functions/Function1;)J", "([JLkotlin/jvm/functions/Function1;)I", "([JLkotlin/jvm/functions/Function1;)J", "([SLkotlin/jvm/functions/Function1;)I", "([SLkotlin/jvm/functions/Function1;)J", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "([Ljava/lang/Boolean;)[Z", "toByteArray", "([Ljava/lang/Byte;)[B", "toCharArray", "([Ljava/lang/Character;)[C", "toCollection", "([ZLjava/util/Collection;)Ljava/util/Collection;", "([BLjava/util/Collection;)Ljava/util/Collection;", "([CLjava/util/Collection;)Ljava/util/Collection;", "([DLjava/util/Collection;)Ljava/util/Collection;", "([FLjava/util/Collection;)Ljava/util/Collection;", "([ILjava/util/Collection;)Ljava/util/Collection;", "([JLjava/util/Collection;)Ljava/util/Collection;", "([SLjava/util/Collection;)Ljava/util/Collection;", "toDoubleArray", "([Ljava/lang/Double;)[D", "toFloatArray", "([Ljava/lang/Float;)[F", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "toIntArray", "([Ljava/lang/Integer;)[I", "toList", "toLongArray", "([Ljava/lang/Long;)[J", "toMutableList", "toMutableSet", "", "([Ljava/lang/Object;)Ljava/util/Set;", "toSet", "toShortArray", "([Ljava/lang/Short;)[S", "union", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "a", "b", "([Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Ljava/lang/Object;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Z[Ljava/lang/Object;)Ljava/util/List;", "([Z[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([B[Ljava/lang/Object;)Ljava/util/List;", "([B[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([C[Ljava/lang/Object;)Ljava/util/List;", "([C[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([D[Ljava/lang/Object;)Ljava/util/List;", "([D[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([F[Ljava/lang/Object;)Ljava/util/List;", "([F[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([I[Ljava/lang/Object;)Ljava/util/List;", "([I[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([J[Ljava/lang/Object;)Ljava/util/List;", "([J[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([S[Ljava/lang/Object;)Ljava/util/List;", "([S[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/ArraysKt")
public class o
  extends n
{
  public static final Integer A(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(129081);
    s.u(paramArrayOfInt, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= k.ad(paramArrayOfInt)))
    {
      paramInt = paramArrayOfInt[paramInt];
      AppMethodBeat.o(129081);
      return Integer.valueOf(paramInt);
    }
    AppMethodBeat.o(129081);
    return null;
  }
  
  public static final int B(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(129083);
    s.u(paramArrayOfInt, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (paramInt == paramArrayOfInt[i])
      {
        AppMethodBeat.o(129083);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(129083);
    return -1;
  }
  
  public static final List<Float> D(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(129098);
    s.u(paramArrayOfFloat, "$this$toList");
    switch (paramArrayOfFloat.length)
    {
    default: 
      paramArrayOfFloat = k.E(paramArrayOfFloat);
      AppMethodBeat.o(129098);
      return paramArrayOfFloat;
    case 0: 
      paramArrayOfFloat = (List)ab.aivy;
      AppMethodBeat.o(129098);
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = p.listOf(Float.valueOf(paramArrayOfFloat[0]));
    AppMethodBeat.o(129098);
    return paramArrayOfFloat;
  }
  
  public static final List<Float> E(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(168692);
    s.u(paramArrayOfFloat, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfFloat.length);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    paramArrayOfFloat = (List)localArrayList;
    AppMethodBeat.o(168692);
    return paramArrayOfFloat;
  }
  
  public static final <T> T X(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129078);
    s.u(paramArrayOfT, "$this$first");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(129078);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(129078);
    return paramArrayOfT;
  }
  
  public static final <T> T Y(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129079);
    s.u(paramArrayOfT, "$this$firstOrNull");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(129079);
      return null;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(129079);
    return paramArrayOfT;
  }
  
  public static final <T> T Z(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129084);
    s.u(paramArrayOfT, "$this$last");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(129084);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[k.ad(paramArrayOfT)];
    AppMethodBeat.o(129084);
    return paramArrayOfT;
  }
  
  public static final int a(byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(191238);
    s.u(paramArrayOfByte, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      if (paramByte == paramArrayOfByte[i])
      {
        AppMethodBeat.o(191238);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191238);
    return -1;
  }
  
  public static final int a(char[] paramArrayOfChar, char paramChar)
  {
    AppMethodBeat.i(191268);
    s.u(paramArrayOfChar, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      if (paramChar == paramArrayOfChar[i])
      {
        AppMethodBeat.o(191268);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191268);
    return -1;
  }
  
  public static final int a(short[] paramArrayOfShort, short paramShort)
  {
    AppMethodBeat.i(191247);
    s.u(paramArrayOfShort, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      if (paramShort == paramArrayOfShort[i])
      {
        AppMethodBeat.o(191247);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191247);
    return -1;
  }
  
  public static final <A extends Appendable> A a(byte[] paramArrayOfByte, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4, b<? super Byte, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129108);
    s.u(paramArrayOfByte, "$this$joinTo");
    s.u(paramA, "buffer");
    s.u(paramCharSequence1, "separator");
    s.u(paramCharSequence2, "prefix");
    s.u(paramCharSequence3, "postfix");
    s.u(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int k = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      byte b = paramArrayOfByte[i];
      j += 1;
      if (j > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramb != null) {
        paramA.append((CharSequence)paramb.invoke(Byte.valueOf(b)));
      }
      for (;;)
      {
        i += 1;
        break;
        paramA.append((CharSequence)String.valueOf(b));
      }
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(129108);
    return paramA;
  }
  
  public static final <T, A extends Appendable> A a(T[] paramArrayOfT, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129107);
    s.u(paramArrayOfT, "$this$joinTo");
    s.u(paramA, "buffer");
    s.u(paramCharSequence1, "separator");
    s.u(paramCharSequence2, "prefix");
    s.u(paramCharSequence3, "postfix");
    s.u(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      paramCharSequence2 = paramArrayOfT[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        k = i;
        if (i > paramInt) {
          break;
        }
      }
      kotlin.n.n.a(paramA, paramCharSequence2, paramb);
      j += 1;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(129107);
    return paramA;
  }
  
  public static final <T> String a(T[] paramArrayOfT, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129109);
    s.u(paramArrayOfT, "$this$joinToString");
    s.u(paramCharSequence1, "separator");
    s.u(paramCharSequence2, "prefix");
    s.u(paramCharSequence3, "postfix");
    s.u(paramCharSequence4, "truncated");
    paramArrayOfT = ((StringBuilder)k.a(paramArrayOfT, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    s.s(paramArrayOfT, "joinTo(StringBuilder(), …ed, transform).toString()");
    AppMethodBeat.o(129109);
    return paramArrayOfT;
  }
  
  public static final <C extends Collection<? super Integer>> C a(int[] paramArrayOfInt, C paramC)
  {
    AppMethodBeat.i(191341);
    s.u(paramArrayOfInt, "$this$toCollection");
    s.u(paramC, "destination");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    AppMethodBeat.o(191341);
    return paramC;
  }
  
  public static final <C extends Collection<? super T>, T> C a(T[] paramArrayOfT, C paramC)
  {
    AppMethodBeat.i(129087);
    s.u(paramArrayOfT, "$this$filterNotNullTo");
    s.u(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT[i];
      if (? != null) {
        paramC.add(?);
      }
      i += 1;
    }
    AppMethodBeat.o(129087);
    return paramC;
  }
  
  public static final List<Float> a(float[] paramArrayOfFloat, g paramg)
  {
    AppMethodBeat.i(191314);
    s.u(paramArrayOfFloat, "$this$slice");
    s.u(paramg, "indices");
    if (paramg.isEmpty())
    {
      paramArrayOfFloat = (List)ab.aivy;
      AppMethodBeat.o(191314);
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = k.C(k.a(paramArrayOfFloat, paramg.fIj, paramg.aixs + 1));
    AppMethodBeat.o(191314);
    return paramArrayOfFloat;
  }
  
  public static final <T, R> List<R> a(T[] paramArrayOfT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129105);
    s.u(paramArrayOfT, "$this$map");
    s.u(paramb, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfT.length);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramb.invoke(paramArrayOfT[i]));
      i += 1;
    }
    paramArrayOfT = (List)localCollection;
    AppMethodBeat.o(129105);
    return paramArrayOfT;
  }
  
  public static final int aa(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191195);
    s.u(paramArrayOfInt, "$this$first");
    int i = paramArrayOfInt[0];
    AppMethodBeat.o(191195);
    return i;
  }
  
  public static final <T> T aa(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129085);
    s.u(paramArrayOfT, "$this$single");
    switch (paramArrayOfT.length)
    {
    default: 
      paramArrayOfT = (Throwable)new IllegalArgumentException("Array has more than one element.");
      AppMethodBeat.o(129085);
      throw paramArrayOfT;
    case 0: 
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(129085);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(129085);
    return paramArrayOfT;
  }
  
  public static final Integer ab(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191209);
    s.u(paramArrayOfInt, "$this$firstOrNull");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(191209);
      return null;
    }
    i = paramArrayOfInt[0];
    AppMethodBeat.o(191209);
    return Integer.valueOf(i);
  }
  
  public static final <T> List<T> ab(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191303);
    s.u(paramArrayOfT, "$this$filterNotNull");
    paramArrayOfT = (List)k.a(paramArrayOfT, (Collection)new ArrayList());
    AppMethodBeat.o(191303);
    return paramArrayOfT;
  }
  
  public static final int ac(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191282);
    s.u(paramArrayOfInt, "$this$last");
    int i = paramArrayOfInt[k.ad(paramArrayOfInt)];
    AppMethodBeat.o(191282);
    return i;
  }
  
  public static final <T> List<T> ac(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129088);
    s.u(paramArrayOfT, "$this$take");
    if (20 >= paramArrayOfT.length)
    {
      paramArrayOfT = k.ae(paramArrayOfT);
      AppMethodBeat.o(129088);
      return paramArrayOfT;
    }
    ArrayList localArrayList = new ArrayList(20);
    int k = paramArrayOfT.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localArrayList.add(paramArrayOfT[i]);
      j += 1;
      if (j == 20) {
        break;
      }
      i += 1;
    }
    paramArrayOfT = (List)localArrayList;
    AppMethodBeat.o(129088);
    return paramArrayOfT;
  }
  
  public static final int ad(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(129090);
    s.u(paramArrayOfInt, "$this$lastIndex");
    int i = paramArrayOfInt.length;
    AppMethodBeat.o(129090);
    return i - 1;
  }
  
  public static final <T> int ad(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129089);
    s.u(paramArrayOfT, "$this$lastIndex");
    int i = paramArrayOfT.length;
    AppMethodBeat.o(129089);
    return i - 1;
  }
  
  public static final List<Integer> ae(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(129096);
    s.u(paramArrayOfInt, "$this$toList");
    switch (paramArrayOfInt.length)
    {
    default: 
      paramArrayOfInt = k.af(paramArrayOfInt);
      AppMethodBeat.o(129096);
      return paramArrayOfInt;
    case 0: 
      paramArrayOfInt = (List)ab.aivy;
      AppMethodBeat.o(129096);
      return paramArrayOfInt;
    }
    paramArrayOfInt = p.listOf(Integer.valueOf(paramArrayOfInt[0]));
    AppMethodBeat.o(129096);
    return paramArrayOfInt;
  }
  
  public static final <T> List<T> ae(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129093);
    s.u(paramArrayOfT, "$this$toList");
    switch (paramArrayOfT.length)
    {
    default: 
      paramArrayOfT = k.af(paramArrayOfT);
      AppMethodBeat.o(129093);
      return paramArrayOfT;
    case 0: 
      paramArrayOfT = (List)ab.aivy;
      AppMethodBeat.o(129093);
      return paramArrayOfT;
    }
    paramArrayOfT = p.listOf(paramArrayOfT[0]);
    AppMethodBeat.o(129093);
    return paramArrayOfT;
  }
  
  public static final List<Integer> af(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(129103);
    s.u(paramArrayOfInt, "$this$toMutableList");
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    paramArrayOfInt = (List)localArrayList;
    AppMethodBeat.o(129103);
    return paramArrayOfInt;
  }
  
  public static final <T> List<T> af(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129102);
    s.u(paramArrayOfT, "$this$toMutableList");
    paramArrayOfT = (List)new ArrayList(p.ak(paramArrayOfT));
    AppMethodBeat.o(129102);
    return paramArrayOfT;
  }
  
  public static final Integer ag(int[] paramArrayOfInt)
  {
    int j = 1;
    AppMethodBeat.i(191352);
    s.u(paramArrayOfInt, "$this$maxOrNull");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(191352);
      return null;
    }
    i = paramArrayOfInt[0];
    int n = k.ad(paramArrayOfInt);
    int k = i;
    if (n > 0) {
      for (k = i;; k = i)
      {
        int m = paramArrayOfInt[j];
        i = k;
        if (k < m) {
          i = m;
        }
        k = i;
        if (j == n) {
          break;
        }
        j += 1;
      }
    }
    AppMethodBeat.o(191352);
    return Integer.valueOf(k);
  }
  
  public static final <T> Set<T> ag(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129104);
    s.u(paramArrayOfT, "$this$toSet");
    switch (paramArrayOfT.length)
    {
    default: 
      paramArrayOfT = (Set)k.b(paramArrayOfT, (Collection)new LinkedHashSet(ak.aKi(paramArrayOfT.length)));
      AppMethodBeat.o(129104);
      return paramArrayOfT;
    case 0: 
      paramArrayOfT = (Set)ad.aivA;
      AppMethodBeat.o(129104);
      return paramArrayOfT;
    }
    paramArrayOfT = ar.setOf(paramArrayOfT[0]);
    AppMethodBeat.o(129104);
    return paramArrayOfT;
  }
  
  public static final double ah(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191364);
    s.u(paramArrayOfInt, "$this$average");
    double d = 0.0D;
    int k = paramArrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      d += paramArrayOfInt[j];
      j += 1;
      i += 1;
    }
    if (i == 0)
    {
      AppMethodBeat.o(191364);
      return (0.0D / 0.0D);
    }
    d /= i;
    AppMethodBeat.o(191364);
    return d;
  }
  
  public static final <T> Iterable<ae<T>> ah(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129106);
    s.u(paramArrayOfT, "$this$withIndex");
    paramArrayOfT = (Iterable)new af((kotlin.g.a.a)new c(paramArrayOfT));
    AppMethodBeat.o(129106);
    return paramArrayOfT;
  }
  
  public static final <T> Iterable<T> ai(T[] paramArrayOfT)
  {
    AppMethodBeat.i(191361);
    s.u(paramArrayOfT, "$this$asIterable");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (Iterable)ab.aivy;
      AppMethodBeat.o(191361);
      return paramArrayOfT;
    }
    paramArrayOfT = (Iterable)new a(paramArrayOfT);
    AppMethodBeat.o(191361);
    return paramArrayOfT;
  }
  
  public static final <T> h<T> aj(T[] paramArrayOfT)
  {
    AppMethodBeat.i(129113);
    s.u(paramArrayOfT, "$this$asSequence");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (h)d.ajtZ;
      AppMethodBeat.o(129113);
      return paramArrayOfT;
    }
    paramArrayOfT = (h)new b(paramArrayOfT);
    AppMethodBeat.o(129113);
    return paramArrayOfT;
  }
  
  public static final <T, C extends Collection<? super T>> C b(T[] paramArrayOfT, C paramC)
  {
    AppMethodBeat.i(129092);
    s.u(paramArrayOfT, "$this$toCollection");
    s.u(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramArrayOfT[i]);
      i += 1;
    }
    AppMethodBeat.o(129092);
    return paramC;
  }
  
  public static final <T> List<T> b(T[] paramArrayOfT, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(191327);
    s.u(paramArrayOfT, "$this$sortedWith");
    s.u(paramComparator, "comparator");
    s.u(paramArrayOfT, "$this$sortedArrayWith");
    s.u(paramComparator, "comparator");
    int i;
    if (paramArrayOfT.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label63;
      }
    }
    for (;;)
    {
      paramArrayOfT = k.V(paramArrayOfT);
      AppMethodBeat.o(191327);
      return paramArrayOfT;
      i = 0;
      break;
      label63:
      paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
      s.s(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
      k.a(paramArrayOfT, paramComparator);
    }
  }
  
  public static final boolean b(long[] paramArrayOfLong, long paramLong)
  {
    AppMethodBeat.i(191179);
    s.u(paramArrayOfLong, "$this$contains");
    if (k.c(paramArrayOfLong, paramLong) >= 0)
    {
      AppMethodBeat.o(191179);
      return true;
    }
    AppMethodBeat.o(191179);
    return false;
  }
  
  public static final int c(long[] paramArrayOfLong, long paramLong)
  {
    AppMethodBeat.i(191262);
    s.u(paramArrayOfLong, "$this$indexOf");
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      if (paramLong == paramArrayOfLong[i])
      {
        AppMethodBeat.o(191262);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191262);
    return -1;
  }
  
  public static final Character c(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(191225);
    s.u(paramArrayOfChar, "$this$getOrNull");
    if (k.e(paramArrayOfChar) >= 0)
    {
      char c = paramArrayOfChar[0];
      AppMethodBeat.o(191225);
      return Character.valueOf(c);
    }
    AppMethodBeat.o(191225);
    return null;
  }
  
  public static final boolean contains(byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(191161);
    s.u(paramArrayOfByte, "$this$contains");
    if (k.a(paramArrayOfByte, paramByte) >= 0)
    {
      AppMethodBeat.o(191161);
      return true;
    }
    AppMethodBeat.o(191161);
    return false;
  }
  
  public static final boolean contains(char[] paramArrayOfChar, char paramChar)
  {
    AppMethodBeat.i(129077);
    s.u(paramArrayOfChar, "$this$contains");
    if (k.a(paramArrayOfChar, paramChar) >= 0)
    {
      AppMethodBeat.o(129077);
      return true;
    }
    AppMethodBeat.o(129077);
    return false;
  }
  
  public static final boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(129076);
    s.u(paramArrayOfInt, "$this$contains");
    if (k.B(paramArrayOfInt, paramInt) >= 0)
    {
      AppMethodBeat.o(129076);
      return true;
    }
    AppMethodBeat.o(129076);
    return false;
  }
  
  public static final <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(129075);
    s.u(paramArrayOfT, "$this$contains");
    if (k.indexOf(paramArrayOfT, paramT) >= 0)
    {
      AppMethodBeat.o(129075);
      return true;
    }
    AppMethodBeat.o(129075);
    return false;
  }
  
  public static final boolean contains(short[] paramArrayOfShort, short paramShort)
  {
    AppMethodBeat.i(191166);
    s.u(paramArrayOfShort, "$this$contains");
    if (k.a(paramArrayOfShort, paramShort) >= 0)
    {
      AppMethodBeat.o(191166);
      return true;
    }
    AppMethodBeat.o(191166);
    return false;
  }
  
  public static final char d(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(129086);
    s.u(paramArrayOfChar, "$this$single");
    switch (paramArrayOfChar.length)
    {
    default: 
      paramArrayOfChar = (Throwable)new IllegalArgumentException("Array has more than one element.");
      AppMethodBeat.o(129086);
      throw paramArrayOfChar;
    case 0: 
      paramArrayOfChar = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(129086);
      throw paramArrayOfChar;
    }
    char c = paramArrayOfChar[0];
    AppMethodBeat.o(129086);
    return c;
  }
  
  public static final List<Short> d(short[] paramArrayOfShort)
  {
    int i = 0;
    AppMethodBeat.i(129095);
    s.u(paramArrayOfShort, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfShort.length)
    {
    default: 
      s.u(paramArrayOfShort, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfShort.length);
      j = paramArrayOfShort.length;
    }
    while (i < j)
    {
      localArrayList.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
      continue;
      paramArrayOfShort = (List)ab.aivy;
      AppMethodBeat.o(129095);
      return paramArrayOfShort;
      paramArrayOfShort = p.listOf(Short.valueOf(paramArrayOfShort[0]));
      AppMethodBeat.o(129095);
      return paramArrayOfShort;
    }
    paramArrayOfShort = (List)localArrayList;
    AppMethodBeat.o(129095);
    return paramArrayOfShort;
  }
  
  public static final List<Byte> dF(byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(129094);
    s.u(paramArrayOfByte, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfByte.length)
    {
    default: 
      s.u(paramArrayOfByte, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfByte.length);
      j = paramArrayOfByte.length;
    }
    while (i < j)
    {
      localArrayList.add(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
      continue;
      paramArrayOfByte = (List)ab.aivy;
      AppMethodBeat.o(129094);
      return paramArrayOfByte;
      paramArrayOfByte = p.listOf(Byte.valueOf(paramArrayOfByte[0]));
      AppMethodBeat.o(129094);
      return paramArrayOfByte;
    }
    paramArrayOfByte = (List)localArrayList;
    AppMethodBeat.o(129094);
    return paramArrayOfByte;
  }
  
  public static final int e(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(191339);
    s.u(paramArrayOfChar, "$this$lastIndex");
    int i = paramArrayOfChar.length;
    AppMethodBeat.o(191339);
    return i - 1;
  }
  
  public static final List<Character> f(char[] paramArrayOfChar)
  {
    int i = 0;
    AppMethodBeat.i(129101);
    s.u(paramArrayOfChar, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfChar.length)
    {
    default: 
      s.u(paramArrayOfChar, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfChar.length);
      j = paramArrayOfChar.length;
    }
    while (i < j)
    {
      localArrayList.add(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
      continue;
      paramArrayOfChar = (List)ab.aivy;
      AppMethodBeat.o(129101);
      return paramArrayOfChar;
      paramArrayOfChar = p.listOf(Character.valueOf(paramArrayOfChar[0]));
      AppMethodBeat.o(129101);
      return paramArrayOfChar;
    }
    paramArrayOfChar = (List)localArrayList;
    AppMethodBeat.o(129101);
    return paramArrayOfChar;
  }
  
  public static final List<Double> f(double[] paramArrayOfDouble)
  {
    int i = 0;
    AppMethodBeat.i(129099);
    s.u(paramArrayOfDouble, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfDouble.length)
    {
    default: 
      s.u(paramArrayOfDouble, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfDouble.length);
      j = paramArrayOfDouble.length;
    }
    while (i < j)
    {
      localArrayList.add(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
      continue;
      paramArrayOfDouble = (List)ab.aivy;
      AppMethodBeat.o(129099);
      return paramArrayOfDouble;
      paramArrayOfDouble = p.listOf(Double.valueOf(paramArrayOfDouble[0]));
      AppMethodBeat.o(129099);
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = (List)localArrayList;
    AppMethodBeat.o(129099);
    return paramArrayOfDouble;
  }
  
  public static final List<Boolean> f(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    AppMethodBeat.i(129100);
    s.u(paramArrayOfBoolean, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfBoolean.length)
    {
    default: 
      s.u(paramArrayOfBoolean, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfBoolean.length);
      j = paramArrayOfBoolean.length;
    }
    while (i < j)
    {
      localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
      continue;
      paramArrayOfBoolean = (List)ab.aivy;
      AppMethodBeat.o(129100);
      return paramArrayOfBoolean;
      paramArrayOfBoolean = p.listOf(Boolean.valueOf(paramArrayOfBoolean[0]));
      AppMethodBeat.o(129100);
      return paramArrayOfBoolean;
    }
    paramArrayOfBoolean = (List)localArrayList;
    AppMethodBeat.o(129100);
    return paramArrayOfBoolean;
  }
  
  public static final <T> int indexOf(T[] paramArrayOfT, T paramT)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(129082);
    s.u(paramArrayOfT, "$this$indexOf");
    if (paramT == null)
    {
      j = paramArrayOfT.length;
      while (i < j)
      {
        if (paramArrayOfT[i] == null)
        {
          AppMethodBeat.o(129082);
          return i;
        }
        i += 1;
      }
    }
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      if (s.p(paramT, paramArrayOfT[i]))
      {
        AppMethodBeat.o(129082);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(129082);
    return -1;
  }
  
  public static final List<Long> k(long[] paramArrayOfLong)
  {
    int i = 0;
    AppMethodBeat.i(129097);
    s.u(paramArrayOfLong, "$this$toList");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfLong.length)
    {
    default: 
      s.u(paramArrayOfLong, "$this$toMutableList");
      localArrayList = new ArrayList(paramArrayOfLong.length);
      j = paramArrayOfLong.length;
    }
    while (i < j)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
      continue;
      paramArrayOfLong = (List)ab.aivy;
      AppMethodBeat.o(129097);
      return paramArrayOfLong;
      paramArrayOfLong = p.listOf(Long.valueOf(paramArrayOfLong[0]));
      AppMethodBeat.o(129097);
      return paramArrayOfLong;
    }
    paramArrayOfLong = (List)localArrayList;
    AppMethodBeat.o(129097);
    return paramArrayOfLong;
  }
  
  public static final <T> T m(T[] paramArrayOfT, int paramInt)
  {
    AppMethodBeat.i(129080);
    s.u(paramArrayOfT, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= k.ad(paramArrayOfT)))
    {
      paramArrayOfT = paramArrayOfT[paramInt];
      AppMethodBeat.o(129080);
      return paramArrayOfT;
    }
    AppMethodBeat.o(129080);
    return null;
  }
  
  @Metadata(d1={""}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterable<T>, kotlin.g.b.a.a
  {
    public a(Object[] paramArrayOfObject) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(191006);
      Iterator localIterator = c.ao(this.aivr);
      AppMethodBeat.o(191006);
      return localIterator;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class b
    implements h<T>
  {
    public b(Object[] paramArrayOfObject) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(129151);
      Iterator localIterator = c.ao(this.aivs);
      AppMethodBeat.o(129151);
      return localIterator;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements kotlin.g.a.a<Iterator<? extends T>>
  {
    c(Object[] paramArrayOfObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.o
 * JD-Core Version:    0.7.0.1
 */