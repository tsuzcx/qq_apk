package kotlin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.a.a;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"all", "", "T", "Lkotlin/sequences/Sequence;", "predicate", "Lkotlin/Function1;", "any", "asIterable", "", "asSequence", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Z", "count", "distinct", "distinctBy", "selector", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlin/sequences/Sequence;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlin/sequences/Sequence;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "first", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "firstNotNullOf", "firstNotNullOfOrNull", "firstOrNull", "flatMap", "flatMapIterable", "flatMapIndexed", "flatMapIndexedIterable", "flatMapIndexedSequence", "flatMapIndexedTo", "flatMapIndexedIterableTo", "flatMapIndexedSequenceTo", "flatMapTo", "flatMapIterableTo", "fold", "initial", "operation", "acc", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "maxBy", "maxByOrNull", "maxOf", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "maxOfOrNull", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxOrNull", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "maxWithOrNull", "min", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minOrNull", "minWith", "minWithOrNull", "minus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "", "(Lkotlin/sequences/Sequence;[Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "minusElement", "none", "onEach", "onEachIndexed", "partition", "plus", "plusElement", "reduce", "S", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceIndexedOrNull", "reduceOrNull", "requireNoNulls", "runningFold", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "runningFoldIndexed", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/sequences/Sequence;", "runningReduce", "runningReduceIndexed", "scan", "scanIndexed", "single", "singleOrNull", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "sumOf", "Lkotlin/UInt;", "sumOfUInt", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)I", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)J", "take", "takeWhile", "toCollection", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toMutableSet", "", "toSet", "", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/sequences/SequencesKt")
public class p
  extends o
{
  public static final <T, C extends Collection<? super T>> C a(h<? extends T> paramh, C paramC)
  {
    AppMethodBeat.i(129510);
    s.u(paramh, "$this$toCollection");
    s.u(paramC, "destination");
    paramh = paramh.iterator();
    while (paramh.hasNext()) {
      paramC.add(paramh.next());
    }
    AppMethodBeat.o(129510);
    return paramC;
  }
  
  public static final <T> h<T> a(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129507);
    s.u(paramh, "$this$filter");
    s.u(paramb, "predicate");
    paramh = (h)new e(paramh, true, paramb);
    AppMethodBeat.o(129507);
    return paramh;
  }
  
  public static final <T> T b(h<? extends T> paramh)
  {
    AppMethodBeat.i(190944);
    s.u(paramh, "$this$last");
    paramh = paramh.iterator();
    if (!paramh.hasNext())
    {
      paramh = (Throwable)new NoSuchElementException("Sequence is empty.");
      AppMethodBeat.o(190944);
      throw paramh;
    }
    Object localObject;
    do
    {
      localObject = paramh.next();
    } while (paramh.hasNext());
    AppMethodBeat.o(190944);
    return localObject;
  }
  
  public static final <T> h<T> b(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129508);
    s.u(paramh, "$this$filterNot");
    s.u(paramb, "predicate");
    paramh = (h)new e(paramh, false, paramb);
    AppMethodBeat.o(129508);
    return paramh;
  }
  
  public static final <T> h<T> c(h<? extends T> paramh)
  {
    AppMethodBeat.i(129509);
    s.u(paramh, "$this$filterNotNull");
    paramh = k.b(paramh, (b)b.ajuv);
    if (paramh == null)
    {
      paramh = new NullPointerException("null cannot be cast to non-null type kotlin.sequences.Sequence<T>");
      AppMethodBeat.o(129509);
      throw paramh;
    }
    AppMethodBeat.o(129509);
    return paramh;
  }
  
  public static final <T, R> h<R> c(h<? extends T> paramh, b<? super T, ? extends h<? extends R>> paramb)
  {
    AppMethodBeat.i(129513);
    s.u(paramh, "$this$flatMap");
    s.u(paramb, "transform");
    paramh = (h)new f(paramh, paramb, (b)c.ajuw);
    AppMethodBeat.o(129513);
    return paramh;
  }
  
  public static final <T> List<T> d(h<? extends T> paramh)
  {
    AppMethodBeat.i(129511);
    s.u(paramh, "$this$toList");
    paramh = kotlin.a.p.oF(k.e(paramh));
    AppMethodBeat.o(129511);
    return paramh;
  }
  
  public static final <T, R> h<R> d(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129514);
    s.u(paramh, "$this$map");
    s.u(paramb, "transform");
    paramh = (h)new r(paramh, paramb);
    AppMethodBeat.o(129514);
    return paramh;
  }
  
  public static final <T> List<T> e(h<? extends T> paramh)
  {
    AppMethodBeat.i(129512);
    s.u(paramh, "$this$toMutableList");
    paramh = (List)k.a(paramh, (Collection)new ArrayList());
    AppMethodBeat.o(129512);
    return paramh;
  }
  
  public static final <T, R> h<R> e(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129515);
    s.u(paramh, "$this$mapNotNull");
    s.u(paramb, "transform");
    paramh = k.c((h)new r(paramh, paramb));
    AppMethodBeat.o(129515);
    return paramh;
  }
  
  public static final <T> int f(h<? extends T> paramh)
  {
    AppMethodBeat.i(129516);
    s.u(paramh, "$this$count");
    int i = 0;
    paramh = paramh.iterator();
    while (paramh.hasNext())
    {
      paramh.next();
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        kotlin.a.p.kkX();
        i = j;
      }
    }
    AppMethodBeat.o(129516);
    return i;
  }
  
  public static final <T> Iterable<T> g(h<? extends T> paramh)
  {
    AppMethodBeat.i(129519);
    s.u(paramh, "$this$asIterable");
    paramh = (Iterable)new a(paramh);
    AppMethodBeat.o(129519);
    return paramh;
  }
  
  @Metadata(d1={""}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements Iterable<T>, a
  {
    public a(h paramh) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(129474);
      Iterator localIterator = this.ajuu.iterator();
      AppMethodBeat.o(129474);
      return localIterator;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements b<T, Boolean>
  {
    public static final b ajuv;
    
    static
    {
      AppMethodBeat.i(129492);
      ajuv = new b();
      AppMethodBeat.o(129492);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.m.p
 * JD-Core Version:    0.7.0.1
 */