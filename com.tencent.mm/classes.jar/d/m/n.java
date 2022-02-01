package d.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.a.b;
import d.g.b.a.a;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"all", "", "T", "Lkotlin/sequences/Sequence;", "predicate", "Lkotlin/Function1;", "any", "asIterable", "", "asSequence", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Z", "count", "distinct", "distinctBy", "selector", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlin/sequences/Sequence;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlin/sequences/Sequence;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "first", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Lkotlin/sequences/Sequence;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "elements", "", "(Lkotlin/sequences/Sequence;[Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "minusElement", "none", "onEach", "partition", "plus", "plusElement", "reduce", "S", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceOrNull", "requireNoNulls", "scan", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "scanIndexed", "(Lkotlin/sequences/Sequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/sequences/Sequence;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeWhile", "toCollection", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toMutableSet", "", "toSet", "", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "zipWithNext", "kotlin-stdlib"}, fvw=1)
public class n
  extends m
{
  public static final <T> h<T> a(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129507);
    k.h(paramh, "$this$filter");
    k.h(paramb, "predicate");
    paramh = (h)new e(paramh, true, paramb);
    AppMethodBeat.o(129507);
    return paramh;
  }
  
  public static final <T, A extends Appendable> A a(h<? extends T> paramh, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4)
  {
    AppMethodBeat.i(129517);
    k.h(paramh, "$this$joinTo");
    k.h(paramA, "buffer");
    k.h(paramCharSequence1, "separator");
    k.h(paramCharSequence2, "prefix");
    k.h(paramCharSequence3, "postfix");
    k.h(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramh = paramh.iterator();
    while (paramh.hasNext())
    {
      paramCharSequence2 = paramh.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      d.n.n.a(paramA, paramCharSequence2, null);
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(129517);
    return paramA;
  }
  
  public static final <T, C extends Collection<? super T>> C a(h<? extends T> paramh, C paramC)
  {
    AppMethodBeat.i(129510);
    k.h(paramh, "$this$toCollection");
    k.h(paramC, "destination");
    paramh = paramh.iterator();
    while (paramh.hasNext()) {
      paramC.add(paramh.next());
    }
    AppMethodBeat.o(129510);
    return paramC;
  }
  
  public static final <T> h<T> b(h<? extends T> paramh)
  {
    AppMethodBeat.i(129509);
    k.h(paramh, "$this$filterNotNull");
    paramh = i.b(paramh, (b)b.Kcy);
    AppMethodBeat.o(129509);
    return paramh;
  }
  
  public static final <T> h<T> b(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129508);
    k.h(paramh, "$this$filterNot");
    k.h(paramb, "predicate");
    paramh = (h)new e(paramh, false, paramb);
    AppMethodBeat.o(129508);
    return paramh;
  }
  
  public static final <T, R> h<R> c(h<? extends T> paramh, b<? super T, ? extends h<? extends R>> paramb)
  {
    AppMethodBeat.i(129513);
    k.h(paramh, "$this$flatMap");
    k.h(paramb, "transform");
    paramh = (h)new f(paramh, paramb, (b)c.Kcz);
    AppMethodBeat.o(129513);
    return paramh;
  }
  
  public static final <T> List<T> c(h<? extends T> paramh)
  {
    AppMethodBeat.i(129511);
    k.h(paramh, "$this$toList");
    paramh = j.ix(i.d(paramh));
    AppMethodBeat.o(129511);
    return paramh;
  }
  
  public static final <T, R> h<R> d(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129514);
    k.h(paramh, "$this$map");
    k.h(paramb, "transform");
    paramh = (h)new p(paramh, paramb);
    AppMethodBeat.o(129514);
    return paramh;
  }
  
  public static final <T> List<T> d(h<? extends T> paramh)
  {
    AppMethodBeat.i(129512);
    k.h(paramh, "$this$toMutableList");
    paramh = (List)i.a(paramh, (Collection)new ArrayList());
    AppMethodBeat.o(129512);
    return paramh;
  }
  
  public static final <T> int e(h<? extends T> paramh)
  {
    AppMethodBeat.i(129516);
    k.h(paramh, "$this$count");
    int i = 0;
    paramh = paramh.iterator();
    while (paramh.hasNext())
    {
      paramh.next();
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        j.fvy();
        i = j;
      }
    }
    AppMethodBeat.o(129516);
    return i;
  }
  
  public static final <T, R> h<R> e(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129515);
    k.h(paramh, "$this$mapNotNull");
    k.h(paramb, "transform");
    paramh = i.b((h)new p(paramh, paramb));
    AppMethodBeat.o(129515);
    return paramh;
  }
  
  public static final <T> Iterable<T> f(h<? extends T> paramh)
  {
    AppMethodBeat.i(129519);
    k.h(paramh, "$this$asIterable");
    paramh = (Iterable)new a(paramh);
    AppMethodBeat.o(129519);
    return paramh;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"})
  public static final class a
    implements a, Iterable<T>
  {
    public a(h paramh) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(129474);
      Iterator localIterator = this.Kcx.iterator();
      AppMethodBeat.o(129474);
      return localIterator;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Z"})
  static final class b
    extends d.g.b.l
    implements b<T, Boolean>
  {
    public static final b Kcy;
    
    static
    {
      AppMethodBeat.i(129492);
      Kcy = new b();
      AppMethodBeat.o(129492);
    }
    
    b()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "R", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<h<? extends R>, Iterator<? extends R>>
  {
    public static final c Kcz;
    
    static
    {
      AppMethodBeat.i(129506);
      Kcz = new c();
      AppMethodBeat.o(129506);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.m.n
 * JD-Core Version:    0.7.0.1
 */