package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

@l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"all", "", "T", "", "predicate", "Lkotlin/Function1;", "any", "asIterable", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "component1", "(Ljava/util/List;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "count", "", "distinct", "distinctBy", "selector", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "(Ljava/util/List;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Ljava/lang/Iterable;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldRightIndexed", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "(Ljava/util/List;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "", "(Ljava/lang/Iterable;[Ljava/lang/Object;)Ljava/util/List;", "minusElement", "none", "onEach", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Iterable;", "partition", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;[Ljava/lang/Object;)Ljava/util/List;", "plusElement", "random", "(Ljava/util/Collection;)Ljava/lang/Object;", "Lkotlin/random/Random;", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "randomOrNull", "reduce", "S", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceOrNull", "reduceRight", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceRightIndexed", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceRightOrNull", "requireNoNulls", "reversed", "scan", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sortBy", "sortByDescending", "sortDescending", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "subtract", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "", "toByteArray", "", "toCharArray", "", "", "toCollection", "toDoubleArray", "", "toFloatArray", "", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toIntArray", "", "toList", "toLongArray", "", "toMutableList", "toMutableSet", "", "toSet", "toShortArray", "", "union", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "a", "b", "(Ljava/lang/Iterable;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zipWithNext", "kotlin-stdlib"})
public class t
  extends s
{
  public static final <T> T E(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(129178);
    p.h(paramList, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= j.ja(paramList)))
    {
      paramList = paramList.get(paramInt);
      AppMethodBeat.o(129178);
      return paramList;
    }
    AppMethodBeat.o(129178);
    return null;
  }
  
  public static final <T> List<T> F(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(129193);
    p.h(paramList, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramList = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129193);
      throw paramList;
    }
    if (paramInt == 0)
    {
      paramList = (List)v.MKE;
      AppMethodBeat.o(129193);
      return paramList;
    }
    i = paramList.size();
    if (paramInt >= i)
    {
      paramList = j.l((Iterable)paramList);
      AppMethodBeat.o(129193);
      return paramList;
    }
    if (paramInt == 1)
    {
      paramList = j.listOf(j.je(paramList));
      AppMethodBeat.o(129193);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    if ((paramList instanceof RandomAccess))
    {
      paramInt = i - paramInt;
      while (paramInt < i)
      {
        localArrayList.add(paramList.get(paramInt));
        paramInt += 1;
      }
    }
    paramList = (Iterator)paramList.listIterator(i - paramInt);
    while (paramList.hasNext()) {
      localArrayList.add(paramList.next());
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(129193);
    return paramList;
  }
  
  public static final <T> int a(List<? extends T> paramList, T paramT)
  {
    AppMethodBeat.i(199616);
    p.h(paramList, "$this$indexOf");
    int i = paramList.indexOf(paramT);
    AppMethodBeat.o(199616);
    return i;
  }
  
  public static final <T, A extends Appendable> A a(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129215);
    p.h(paramIterable, "$this$joinTo");
    p.h(paramA, "buffer");
    p.h(paramCharSequence1, "separator");
    p.h(paramCharSequence2, "prefix");
    p.h(paramCharSequence3, "postfix");
    p.h(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramIterable = paramIterable.iterator();
    int j;
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramCharSequence2 = paramIterable.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      n.a(paramA, paramCharSequence2, paramb);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(129215);
    return paramA;
  }
  
  public static final <T> String a(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129217);
    p.h(paramIterable, "$this$joinToString");
    p.h(paramCharSequence1, "separator");
    p.h(paramCharSequence2, "prefix");
    p.h(paramCharSequence3, "postfix");
    p.h(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)j.a(paramIterable, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    p.g(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    AppMethodBeat.o(129217);
    return paramIterable;
  }
  
  public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(129191);
    p.h(paramIterable, "$this$filterNotNullTo");
    p.h(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    AppMethodBeat.o(129191);
    return paramC;
  }
  
  public static final <T> List<T> a(Iterable<? extends T> paramIterable, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(129196);
    p.h(paramIterable, "$this$sortedWith");
    p.h(paramComparator, "comparator");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1)
      {
        paramIterable = j.l(paramIterable);
        AppMethodBeat.o(129196);
        return paramIterable;
      }
      paramIterable = ((Collection)paramIterable).toArray(new Object[0]);
      if (paramIterable == null)
      {
        paramIterable = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129196);
        throw paramIterable;
      }
      if (paramIterable == null)
      {
        paramIterable = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129196);
        throw paramIterable;
      }
      e.a(paramIterable, paramComparator);
      paramIterable = e.asList(paramIterable);
      AppMethodBeat.o(129196);
      return paramIterable;
    }
    paramIterable = j.m(paramIterable);
    j.a(paramIterable, paramComparator);
    AppMethodBeat.o(129196);
    return paramIterable;
  }
  
  public static final <T> boolean a(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129173);
    p.h(paramIterable, "$this$contains");
    if ((paramIterable instanceof Collection))
    {
      boolean bool = ((Collection)paramIterable).contains(paramT);
      AppMethodBeat.o(129173);
      return bool;
    }
    if (j.b(paramIterable, paramT) >= 0)
    {
      AppMethodBeat.o(129173);
      return true;
    }
    AppMethodBeat.o(129173);
    return false;
  }
  
  public static final <T> int b(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129179);
    p.h(paramIterable, "$this$indexOf");
    if ((paramIterable instanceof List))
    {
      i = ((List)paramIterable).indexOf(paramT);
      AppMethodBeat.o(129179);
      return i;
    }
    int i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i < 0) {
        j.gfB();
      }
      if (p.i(paramT, localObject))
      {
        AppMethodBeat.o(129179);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(129179);
    return -1;
  }
  
  public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(129198);
    p.h(paramIterable, "$this$toCollection");
    p.h(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    AppMethodBeat.o(129198);
    return paramC;
  }
  
  public static final <T> List<T> b(Iterable<? extends T> paramIterable, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(129192);
    p.h(paramIterable, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramIterable = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129192);
      throw paramIterable;
    }
    if (paramInt == 0)
    {
      paramIterable = (List)v.MKE;
      AppMethodBeat.o(129192);
      return paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      if (paramInt >= ((Collection)paramIterable).size())
      {
        paramIterable = j.l(paramIterable);
        AppMethodBeat.o(129192);
        return paramIterable;
      }
      if (paramInt == 1)
      {
        paramIterable = j.listOf(j.c(paramIterable));
        AppMethodBeat.o(129192);
        return paramIterable;
      }
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramIterable = paramIterable.iterator();
    i = j;
    do
    {
      if (!paramIterable.hasNext()) {
        break;
      }
      localArrayList.add(paramIterable.next());
      j = i + 1;
      i = j;
    } while (j != paramInt);
    paramIterable = j.jb((List)localArrayList);
    AppMethodBeat.o(129192);
    return paramIterable;
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129213);
    p.h(paramCollection, "$this$plus");
    p.h(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      int i = paramCollection.size();
      ArrayList localArrayList = new ArrayList(((Collection)paramIterable).size() + i);
      localArrayList.addAll(paramCollection);
      localArrayList.addAll((Collection)paramIterable);
      paramCollection = (List)localArrayList;
      AppMethodBeat.o(129213);
      return paramCollection;
    }
    paramCollection = new ArrayList(paramCollection);
    j.a((Collection)paramCollection, paramIterable);
    paramCollection = (List)paramCollection;
    AppMethodBeat.o(129213);
    return paramCollection;
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection, T paramT)
  {
    AppMethodBeat.i(129212);
    p.h(paramCollection, "$this$plus");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + 1);
    localArrayList.addAll(paramCollection);
    localArrayList.add(paramT);
    paramCollection = (List)localArrayList;
    AppMethodBeat.o(129212);
    return paramCollection;
  }
  
  public static final <T> Set<T> b(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    AppMethodBeat.i(129207);
    p.h(paramIterable1, "$this$union");
    p.h(paramIterable2, "other");
    paramIterable1 = j.q(paramIterable1);
    j.a((Collection)paramIterable1, paramIterable2);
    AppMethodBeat.o(129207);
    return paramIterable1;
  }
  
  public static final <T> T c(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129174);
    p.h(paramIterable, "$this$first");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.jc((List)paramIterable);
      AppMethodBeat.o(129174);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(129174);
      throw paramIterable;
    }
    paramIterable = paramIterable.next();
    AppMethodBeat.o(129174);
    return paramIterable;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129189);
    p.h(paramIterable, "$this$filter");
    p.h(paramb, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramb.invoke(localObject)).booleanValue()) {
        localCollection.add(localObject);
      }
    }
    paramIterable = (List)localCollection;
    AppMethodBeat.o(129189);
    return paramIterable;
  }
  
  public static final <T, R> List<o<T, R>> c(Iterable<? extends T> paramIterable, Iterable<? extends R> paramIterable1)
  {
    AppMethodBeat.i(129214);
    p.h(paramIterable, "$this$zip");
    p.h(paramIterable1, "other");
    Iterator localIterator1 = paramIterable.iterator();
    Iterator localIterator2 = paramIterable1.iterator();
    paramIterable = new ArrayList(Math.min(j.a(paramIterable, 10), j.a(paramIterable1, 10)));
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      paramIterable.add(u.S(localIterator1.next(), localIterator2.next()));
    }
    paramIterable = (List)paramIterable;
    AppMethodBeat.o(129214);
    return paramIterable;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129210);
    p.h(paramIterable, "$this$minus");
    ArrayList localArrayList = new ArrayList(j.a(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    int i = 0;
    label113:
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        int j;
        if ((i == 0) && (p.i(localObject, paramT)))
        {
          j = 0;
          i = 1;
        }
        for (;;)
        {
          if (j == 0) {
            break label113;
          }
          ((Collection)localArrayList).add(localObject);
          break;
          j = 1;
        }
      }
      paramIterable = (List)localArrayList;
      AppMethodBeat.o(129210);
      return paramIterable;
    }
  }
  
  public static final <T> T d(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129176);
    p.h(paramIterable, "$this$firstOrNull");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).isEmpty())
      {
        AppMethodBeat.o(129176);
        return null;
      }
      paramIterable = ((List)paramIterable).get(0);
      AppMethodBeat.o(129176);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(129176);
      return null;
    }
    paramIterable = paramIterable.next();
    AppMethodBeat.o(129176);
    return paramIterable;
  }
  
  public static final <T, R> List<R> d(Iterable<? extends T> paramIterable, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129203);
    p.h(paramIterable, "$this$map");
    p.h(paramb, "transform");
    Collection localCollection = (Collection)new ArrayList(j.a(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramb.invoke(paramIterable.next()));
    }
    paramIterable = (List)localCollection;
    AppMethodBeat.o(129203);
    return paramIterable;
  }
  
  public static final <T> List<T> d(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129211);
    p.h(paramIterable, "$this$plus");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = j.b((Collection)paramIterable, paramT);
      AppMethodBeat.o(129211);
      return paramIterable;
    }
    ArrayList localArrayList = new ArrayList();
    j.a((Collection)localArrayList, paramIterable);
    localArrayList.add(paramT);
    paramIterable = (List)localArrayList;
    AppMethodBeat.o(129211);
    return paramIterable;
  }
  
  public static final <T> T e(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129180);
    p.h(paramIterable, "$this$last");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.je((List)paramIterable);
      AppMethodBeat.o(129180);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(129180);
      throw paramIterable;
    }
    Object localObject;
    do
    {
      localObject = paramIterable.next();
    } while (paramIterable.hasNext());
    AppMethodBeat.o(129180);
    return localObject;
  }
  
  public static final <T> T f(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129183);
    p.h(paramIterable, "$this$single");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.jg((List)paramIterable);
      AppMethodBeat.o(129183);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(129183);
      throw paramIterable;
    }
    Object localObject = paramIterable.next();
    if (paramIterable.hasNext())
    {
      paramIterable = (Throwable)new IllegalArgumentException("Collection has more than one element.");
      AppMethodBeat.o(129183);
      throw paramIterable;
    }
    AppMethodBeat.o(129183);
    return localObject;
  }
  
  public static final <T> T g(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129185);
    p.h(paramIterable, "$this$singleOrNull");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).size() == 1)
      {
        paramIterable = ((List)paramIterable).get(0);
        AppMethodBeat.o(129185);
        return paramIterable;
      }
      AppMethodBeat.o(129185);
      return null;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(129185);
      return null;
    }
    Object localObject = paramIterable.next();
    if (paramIterable.hasNext())
    {
      AppMethodBeat.o(129185);
      return null;
    }
    AppMethodBeat.o(129185);
    return localObject;
  }
  
  public static final <T> List<T> h(Iterable<? extends T> paramIterable)
  {
    int i = 1;
    AppMethodBeat.i(129187);
    p.h(paramIterable, "$this$drop");
    ArrayList localArrayList;
    if ((paramIterable instanceof Collection))
    {
      int j = ((Collection)paramIterable).size() - 1;
      if (j <= 0)
      {
        paramIterable = (List)v.MKE;
        AppMethodBeat.o(129187);
        return paramIterable;
      }
      if (j == 1)
      {
        paramIterable = j.listOf(j.e(paramIterable));
        AppMethodBeat.o(129187);
        return paramIterable;
      }
      localArrayList = new ArrayList(j);
      if ((paramIterable instanceof List))
      {
        if ((paramIterable instanceof RandomAccess))
        {
          j = ((Collection)paramIterable).size();
          while (i < j)
          {
            localArrayList.add(((List)paramIterable).get(i));
            i += 1;
          }
        }
        paramIterable = (Iterator)((List)paramIterable).listIterator(1);
        while (paramIterable.hasNext()) {
          localArrayList.add(paramIterable.next());
        }
        paramIterable = (List)localArrayList;
        AppMethodBeat.o(129187);
        return paramIterable;
      }
    }
    else
    {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (i > 0) {
          localArrayList.add(localObject);
        } else {
          i += 1;
        }
      }
      paramIterable = j.jb((List)localArrayList);
      AppMethodBeat.o(129187);
      return paramIterable;
    }
  }
  
  public static final <T> List<T> i(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129194);
    p.h(paramIterable, "$this$reversed");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).size() <= 1))
    {
      paramIterable = j.l(paramIterable);
      AppMethodBeat.o(129194);
      return paramIterable;
    }
    paramIterable = j.m(paramIterable);
    j.reverse(paramIterable);
    AppMethodBeat.o(129194);
    return paramIterable;
  }
  
  public static final <T extends Comparable<? super T>> List<T> j(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129195);
    p.h(paramIterable, "$this$sorted");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1)
      {
        paramIterable = j.l(paramIterable);
        AppMethodBeat.o(129195);
        return paramIterable;
      }
      paramIterable = ((Collection)paramIterable).toArray(new Comparable[0]);
      if (paramIterable == null)
      {
        paramIterable = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      if (paramIterable == null)
      {
        paramIterable = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      paramIterable = (Comparable[])paramIterable;
      if (paramIterable == null)
      {
        paramIterable = new d.v("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      e.sort((Object[])paramIterable);
      paramIterable = e.asList((Object[])paramIterable);
      AppMethodBeat.o(129195);
      return paramIterable;
    }
    paramIterable = j.m(paramIterable);
    j.sort(paramIterable);
    AppMethodBeat.o(129195);
    return paramIterable;
  }
  
  public static final <T> T jc(List<? extends T> paramList)
  {
    AppMethodBeat.i(129175);
    p.h(paramList, "$this$first");
    if (paramList.isEmpty())
    {
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(129175);
      throw paramList;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(129175);
    return paramList;
  }
  
  public static final <T> T jd(List<? extends T> paramList)
  {
    AppMethodBeat.i(129177);
    p.h(paramList, "$this$firstOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(129177);
      return null;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(129177);
    return paramList;
  }
  
  public static final <T> T je(List<? extends T> paramList)
  {
    AppMethodBeat.i(129181);
    p.h(paramList, "$this$last");
    if (paramList.isEmpty())
    {
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(129181);
      throw paramList;
    }
    paramList = paramList.get(j.ja(paramList));
    AppMethodBeat.o(129181);
    return paramList;
  }
  
  public static final <T> T jf(List<? extends T> paramList)
  {
    AppMethodBeat.i(129182);
    p.h(paramList, "$this$lastOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(129182);
      return null;
    }
    paramList = paramList.get(paramList.size() - 1);
    AppMethodBeat.o(129182);
    return paramList;
  }
  
  public static final <T> T jg(List<? extends T> paramList)
  {
    AppMethodBeat.i(129184);
    p.h(paramList, "$this$single");
    switch (paramList.size())
    {
    default: 
      paramList = (Throwable)new IllegalArgumentException("List has more than one element.");
      AppMethodBeat.o(129184);
      throw paramList;
    case 0: 
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(129184);
      throw paramList;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(129184);
    return paramList;
  }
  
  public static final <T> T jh(List<? extends T> paramList)
  {
    AppMethodBeat.i(129186);
    p.h(paramList, "$this$singleOrNull");
    if (paramList.size() == 1)
    {
      paramList = paramList.get(0);
      AppMethodBeat.o(129186);
      return paramList;
    }
    AppMethodBeat.o(129186);
    return null;
  }
  
  public static final <T> List<T> ji(List<? extends T> paramList)
  {
    AppMethodBeat.i(129188);
    p.h(paramList, "$this$dropLast");
    paramList = j.b((Iterable)paramList, d.k.h.lp(paramList.size() - 1, 0));
    AppMethodBeat.o(129188);
    return paramList;
  }
  
  public static final <T> HashSet<T> k(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(183772);
    p.h(paramIterable, "$this$toHashSet");
    paramIterable = (HashSet)j.b(paramIterable, (Collection)new HashSet(ae.aji(j.a(paramIterable, 12))));
    AppMethodBeat.o(183772);
    return paramIterable;
  }
  
  public static final <T> List<T> l(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129199);
    p.h(paramIterable, "$this$toList");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = j.s((Collection)paramIterable);
        AppMethodBeat.o(129199);
        return paramIterable;
      case 0: 
        paramIterable = (List)v.MKE;
        AppMethodBeat.o(129199);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = j.listOf(paramIterable);
        AppMethodBeat.o(129199);
        return paramIterable;
      }
    }
    paramIterable = j.jb(j.m(paramIterable));
    AppMethodBeat.o(129199);
    return paramIterable;
  }
  
  public static final <T> List<T> m(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129200);
    p.h(paramIterable, "$this$toMutableList");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = j.s((Collection)paramIterable);
      AppMethodBeat.o(129200);
      return paramIterable;
    }
    paramIterable = (List)j.b(paramIterable, (Collection)new ArrayList());
    AppMethodBeat.o(129200);
    return paramIterable;
  }
  
  public static final <T> Set<T> n(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129202);
    p.h(paramIterable, "$this$toSet");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = (Set)j.b(paramIterable, (Collection)new LinkedHashSet(ae.aji(((Collection)paramIterable).size())));
        AppMethodBeat.o(129202);
        return paramIterable;
      case 0: 
        paramIterable = (Set)x.MKG;
        AppMethodBeat.o(129202);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = ak.setOf(paramIterable);
        AppMethodBeat.o(129202);
        return paramIterable;
      }
    }
    paramIterable = ak.t((Set)j.b(paramIterable, (Collection)new LinkedHashSet()));
    AppMethodBeat.o(129202);
    return paramIterable;
  }
  
  public static final <T> Iterable<y<T>> o(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129204);
    p.h(paramIterable, "$this$withIndex");
    paramIterable = (Iterable)new z((a)new c(paramIterable));
    AppMethodBeat.o(129204);
    return paramIterable;
  }
  
  public static final <T> List<T> p(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129205);
    p.h(paramIterable, "$this$distinct");
    paramIterable = j.l((Iterable)j.q(paramIterable));
    AppMethodBeat.o(129205);
    return paramIterable;
  }
  
  public static final boolean[] p(Collection<Boolean> paramCollection)
  {
    AppMethodBeat.i(199617);
    p.h(paramCollection, "$this$toBooleanArray");
    boolean[] arrayOfBoolean = new boolean[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfBoolean[i] = ((Boolean)paramCollection.next()).booleanValue();
      i += 1;
    }
    AppMethodBeat.o(199617);
    return arrayOfBoolean;
  }
  
  public static final <T> Set<T> q(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129206);
    p.h(paramIterable, "$this$toMutableSet");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Set)new LinkedHashSet((Collection)paramIterable);
      AppMethodBeat.o(129206);
      return paramIterable;
    }
    paramIterable = (Set)j.b(paramIterable, (Collection)new LinkedHashSet());
    AppMethodBeat.o(129206);
    return paramIterable;
  }
  
  public static final float[] q(Collection<Float> paramCollection)
  {
    AppMethodBeat.i(168695);
    p.h(paramCollection, "$this$toFloatArray");
    float[] arrayOfFloat = new float[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfFloat[i] = ((Number)paramCollection.next()).floatValue();
      i += 1;
    }
    AppMethodBeat.o(168695);
    return arrayOfFloat;
  }
  
  public static final Float r(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(199618);
    p.h(paramIterable, "$this$max");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(199618);
      return null;
    }
    float f1 = ((Number)paramIterable.next()).floatValue();
    if (Float.isNaN(f1))
    {
      AppMethodBeat.o(199618);
      return Float.valueOf(f1);
      Object localObject;
      if (f1 < localObject) {
        f1 = localObject;
      }
    }
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        float f2 = ((Number)paramIterable.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        AppMethodBeat.o(199618);
        return Float.valueOf(f2);
      }
      AppMethodBeat.o(199618);
      return Float.valueOf(f1);
    }
  }
  
  public static final int[] r(Collection<Integer> paramCollection)
  {
    AppMethodBeat.i(129197);
    p.h(paramCollection, "$this$toIntArray");
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfInt[i] = ((Number)paramCollection.next()).intValue();
      i += 1;
    }
    AppMethodBeat.o(129197);
    return arrayOfInt;
  }
  
  public static final <T extends Comparable<? super T>> T s(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129208);
    p.h(paramIterable, "$this$max");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(129208);
      return null;
    }
    paramIterable = (Comparable)localIterator.next();
    if (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramIterable.compareTo(localComparable) >= 0) {
        break label89;
      }
      paramIterable = localComparable;
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(129208);
      return paramIterable;
    }
  }
  
  public static final <T> List<T> s(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(129201);
    p.h(paramCollection, "$this$toMutableList");
    paramCollection = (List)new ArrayList(paramCollection);
    AppMethodBeat.o(129201);
    return paramCollection;
  }
  
  public static final Float t(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(199619);
    p.h(paramIterable, "$this$min");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(199619);
      return null;
    }
    float f1 = ((Number)paramIterable.next()).floatValue();
    if (Float.isNaN(f1))
    {
      AppMethodBeat.o(199619);
      return Float.valueOf(f1);
      Object localObject;
      if (f1 > localObject) {
        f1 = localObject;
      }
    }
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        float f2 = ((Number)paramIterable.next()).floatValue();
        if (!Float.isNaN(f2)) {
          break;
        }
        AppMethodBeat.o(199619);
        return Float.valueOf(f2);
      }
      AppMethodBeat.o(199619);
      return Float.valueOf(f1);
    }
  }
  
  public static final <T extends Comparable<? super T>> T u(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129209);
    p.h(paramIterable, "$this$min");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(129209);
      return null;
    }
    paramIterable = (Comparable)localIterator.next();
    if (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramIterable.compareTo(localComparable) <= 0) {
        break label89;
      }
      paramIterable = localComparable;
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(129209);
      return paramIterable;
    }
  }
  
  public static final <T> d.m.h<T> v(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129219);
    p.h(paramIterable, "$this$asSequence");
    paramIterable = (d.m.h)new a(paramIterable);
    AppMethodBeat.o(129219);
    return paramIterable;
  }
  
  public static final double w(Iterable<Integer> paramIterable)
  {
    AppMethodBeat.i(129220);
    p.h(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).intValue();
      i += 1;
      if (i < 0) {
        j.gfC();
      }
    }
    if (i == 0)
    {
      paramIterable = k.MLL;
      d = k.gfX();
      AppMethodBeat.o(129220);
      return d;
    }
    d /= i;
    AppMethodBeat.o(129220);
    return d;
  }
  
  public static final int x(Iterable<Integer> paramIterable)
  {
    AppMethodBeat.i(129221);
    p.h(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).intValue() + i) {}
    AppMethodBeat.o(129221);
    return i;
  }
  
  public static final long y(Iterable<Long> paramIterable)
  {
    AppMethodBeat.i(129222);
    p.h(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (long l = 0L; paramIterable.hasNext(); l = ((Number)paramIterable.next()).longValue() + l) {}
    AppMethodBeat.o(129222);
    return l;
  }
  
  public static final float z(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(168696);
    p.h(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (float f = 0.0F; paramIterable.hasNext(); f = ((Number)paramIterable.next()).floatValue() + f) {}
    AppMethodBeat.o(168696);
    return f;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"})
  public static final class a
    implements d.m.h<T>
  {
    public a(Iterable paramIterable) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(129234);
      Iterator localIterator = this.MKB.iterator();
      AppMethodBeat.o(129234);
      return localIterator;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "invoke"})
  static final class c
    extends q
    implements a<Iterator<? extends T>>
  {
    c(Iterable paramIterable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.t
 * JD-Core Version:    0.7.0.1
 */