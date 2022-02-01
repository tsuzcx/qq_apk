package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.e;
import kotlin.k.g;
import kotlin.m.h;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"all", "", "T", "", "predicate", "Lkotlin/Function1;", "any", "asIterable", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "component1", "(Ljava/util/List;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "count", "", "distinct", "distinctBy", "selector", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "(Ljava/util/List;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Ljava/lang/Iterable;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "firstNotNullOf", "firstNotNullOfOrNull", "firstOrNull", "flatMap", "flatMapSequence", "flatMapIndexed", "flatMapIndexedIterable", "flatMapIndexedSequence", "flatMapIndexedTo", "flatMapIndexedIterableTo", "flatMapIndexedSequenceTo", "flatMapTo", "flatMapSequenceTo", "fold", "initial", "operation", "acc", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldRightIndexed", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "(Ljava/util/List;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "maxBy", "maxByOrNull", "maxOf", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "maxOfOrNull", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Iterable;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxOrNull", "maxWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "maxWithOrNull", "min", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minOrNull", "minWith", "minWithOrNull", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "", "(Ljava/lang/Iterable;[Ljava/lang/Object;)Ljava/util/List;", "minusElement", "none", "onEach", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Iterable;", "onEachIndexed", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Iterable;", "partition", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;[Ljava/lang/Object;)Ljava/util/List;", "plusElement", "random", "(Ljava/util/Collection;)Ljava/lang/Object;", "Lkotlin/random/Random;", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "randomOrNull", "reduce", "S", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceIndexedOrNull", "reduceOrNull", "reduceRight", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceRightIndexed", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceRightIndexedOrNull", "reduceRightOrNull", "requireNoNulls", "reversed", "runningFold", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "runningFoldIndexed", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "runningReduce", "runningReduceIndexed", "scan", "scanIndexed", "shuffle", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sortBy", "sortByDescending", "sortDescending", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "subtract", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "sumOf", "Lkotlin/UInt;", "sumOfUInt", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)I", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)J", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "", "toByteArray", "", "toCharArray", "", "", "toCollection", "toDoubleArray", "", "toFloatArray", "", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toIntArray", "", "toList", "toLongArray", "", "toMutableList", "toMutableSet", "", "toSet", "toShortArray", "", "union", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "a", "b", "(Ljava/lang/Iterable;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zipWithNext", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/CollectionsKt")
public class z
  extends y
{
  public static final <T> h<T> A(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129219);
    s.u(paramIterable, "$this$asSequence");
    paramIterable = (h)new a(paramIterable);
    AppMethodBeat.o(129219);
    return paramIterable;
  }
  
  public static final double B(Iterable<Integer> paramIterable)
  {
    AppMethodBeat.i(129220);
    s.u(paramIterable, "$this$average");
    double d = 0.0D;
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      d += ((Number)paramIterable.next()).intValue();
      i += 1;
      if (i < 0) {
        p.kkX();
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(129220);
      return (0.0D / 0.0D);
    }
    d /= i;
    AppMethodBeat.o(129220);
    return d;
  }
  
  public static final int C(Iterable<Integer> paramIterable)
  {
    AppMethodBeat.i(129221);
    s.u(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).intValue() + i) {}
    AppMethodBeat.o(129221);
    return i;
  }
  
  public static final long D(Iterable<Long> paramIterable)
  {
    AppMethodBeat.i(129222);
    s.u(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (long l = 0L; paramIterable.hasNext(); l = ((Number)paramIterable.next()).longValue() + l) {}
    AppMethodBeat.o(129222);
    return l;
  }
  
  public static final float E(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(168696);
    s.u(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (float f = 0.0F; paramIterable.hasNext(); f = ((Number)paramIterable.next()).floatValue() + f) {}
    AppMethodBeat.o(168696);
    return f;
  }
  
  public static final boolean[] G(Collection<Boolean> paramCollection)
  {
    AppMethodBeat.i(191246);
    s.u(paramCollection, "$this$toBooleanArray");
    boolean[] arrayOfBoolean = new boolean[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfBoolean[i] = ((Boolean)paramCollection.next()).booleanValue();
      i += 1;
    }
    AppMethodBeat.o(191246);
    return arrayOfBoolean;
  }
  
  public static final float[] H(Collection<Float> paramCollection)
  {
    AppMethodBeat.i(168695);
    s.u(paramCollection, "$this$toFloatArray");
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
  
  public static final int[] I(Collection<Integer> paramCollection)
  {
    AppMethodBeat.i(129197);
    s.u(paramCollection, "$this$toIntArray");
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
  
  public static final <T> List<T> J(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(129201);
    s.u(paramCollection, "$this$toMutableList");
    paramCollection = (List)new ArrayList(paramCollection);
    AppMethodBeat.o(129201);
    return paramCollection;
  }
  
  public static final <T> int a(List<? extends T> paramList, T paramT)
  {
    AppMethodBeat.i(191122);
    s.u(paramList, "$this$indexOf");
    int i = paramList.indexOf(paramT);
    AppMethodBeat.o(191122);
    return i;
  }
  
  public static final <T, A extends Appendable> A a(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129215);
    s.u(paramIterable, "$this$joinTo");
    s.u(paramA, "buffer");
    s.u(paramCharSequence1, "separator");
    s.u(paramCharSequence2, "prefix");
    s.u(paramCharSequence3, "postfix");
    s.u(paramCharSequence4, "truncated");
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
  
  public static final <T> T a(Iterable<? extends T> paramIterable, int paramInt, b<? super Integer, ? extends T> paramb)
  {
    AppMethodBeat.i(191059);
    s.u(paramIterable, "$this$elementAtOrElse");
    s.u(paramb, "defaultValue");
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if ((paramInt >= 0) && (paramInt <= p.oE(paramIterable)))
      {
        paramIterable = paramIterable.get(paramInt);
        AppMethodBeat.o(191059);
        return paramIterable;
      }
      paramIterable = paramb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(191059);
      return paramIterable;
    }
    if (paramInt < 0)
    {
      paramIterable = paramb.invoke(Integer.valueOf(paramInt));
      AppMethodBeat.o(191059);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramInt == i)
      {
        AppMethodBeat.o(191059);
        return localObject;
      }
      i += 1;
    }
    paramIterable = paramb.invoke(Integer.valueOf(paramInt));
    AppMethodBeat.o(191059);
    return paramIterable;
  }
  
  public static final <T> String a(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(129217);
    s.u(paramIterable, "$this$joinToString");
    s.u(paramCharSequence1, "separator");
    s.u(paramCharSequence2, "prefix");
    s.u(paramCharSequence3, "postfix");
    s.u(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)p.a(paramIterable, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    s.s(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    AppMethodBeat.o(129217);
    return paramIterable;
  }
  
  public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(129191);
    s.u(paramIterable, "$this$filterNotNullTo");
    s.u(paramC, "destination");
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
    s.u(paramIterable, "$this$sortedWith");
    s.u(paramComparator, "comparator");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1)
      {
        paramIterable = p.p(paramIterable);
        AppMethodBeat.o(129196);
        return paramIterable;
      }
      paramIterable = ((Collection)paramIterable).toArray(new Object[0]);
      if (paramIterable == null)
      {
        paramIterable = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129196);
        throw paramIterable;
      }
      if (paramIterable == null)
      {
        paramIterable = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129196);
        throw paramIterable;
      }
      k.a(paramIterable, paramComparator);
      paramIterable = k.V(paramIterable);
      AppMethodBeat.o(129196);
      return paramIterable;
    }
    paramIterable = p.q(paramIterable);
    p.a(paramIterable, paramComparator);
    AppMethodBeat.o(129196);
    return paramIterable;
  }
  
  public static final <T> List<T> a(List<? extends T> paramList, g paramg)
  {
    AppMethodBeat.i(191198);
    s.u(paramList, "$this$slice");
    s.u(paramg, "indices");
    if (paramg.isEmpty())
    {
      paramList = (List)ab.aivy;
      AppMethodBeat.o(191198);
      return paramList;
    }
    paramList = p.p((Iterable)paramList.subList(paramg.fIj, paramg.aixs + 1));
    AppMethodBeat.o(191198);
    return paramList;
  }
  
  public static final <T> boolean a(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129173);
    s.u(paramIterable, "$this$contains");
    if ((paramIterable instanceof Collection))
    {
      boolean bool = ((Collection)paramIterable).contains(paramT);
      AppMethodBeat.o(129173);
      return bool;
    }
    if (p.b(paramIterable, paramT) >= 0)
    {
      AppMethodBeat.o(129173);
      return true;
    }
    AppMethodBeat.o(129173);
    return false;
  }
  
  public static final <T> T ae(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(129178);
    s.u(paramList, "$this$getOrNull");
    if ((paramInt >= 0) && (paramInt <= p.oE(paramList)))
    {
      paramList = paramList.get(paramInt);
      AppMethodBeat.o(129178);
      return paramList;
    }
    AppMethodBeat.o(129178);
    return null;
  }
  
  public static final <T> List<T> af(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(191173);
    s.u(paramList, "$this$dropLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramList = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(191173);
      throw paramList;
    }
    paramList = p.c((Iterable)paramList, kotlin.k.k.qu(paramList.size() - paramInt, 0));
    AppMethodBeat.o(191173);
    return paramList;
  }
  
  public static final <T> List<T> ag(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(129193);
    s.u(paramList, "$this$takeLast");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramList = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129193);
      throw paramList;
    }
    if (paramInt == 0)
    {
      paramList = (List)ab.aivy;
      AppMethodBeat.o(129193);
      return paramList;
    }
    i = paramList.size();
    if (paramInt >= i)
    {
      paramList = p.p((Iterable)paramList);
      AppMethodBeat.o(129193);
      return paramList;
    }
    if (paramInt == 1)
    {
      paramList = p.listOf(p.oM(paramList));
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
  
  public static final <T> int b(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129179);
    s.u(paramIterable, "$this$indexOf");
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
        p.kkW();
      }
      if (s.p(paramT, localObject))
      {
        AppMethodBeat.o(129179);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(129179);
    return -1;
  }
  
  public static final <T> T b(Iterable<? extends T> paramIterable, int paramInt)
  {
    AppMethodBeat.i(191047);
    s.u(paramIterable, "$this$elementAt");
    if ((paramIterable instanceof List))
    {
      paramIterable = ((List)paramIterable).get(paramInt);
      AppMethodBeat.o(191047);
      return paramIterable;
    }
    paramIterable = p.a(paramIterable, paramInt, (b)new b(paramInt));
    AppMethodBeat.o(191047);
    return paramIterable;
  }
  
  public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(129198);
    s.u(paramIterable, "$this$toCollection");
    s.u(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    AppMethodBeat.o(129198);
    return paramC;
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129213);
    s.u(paramCollection, "$this$plus");
    s.u(paramIterable, "elements");
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
    p.a((Collection)paramCollection, paramIterable);
    paramCollection = (List)paramCollection;
    AppMethodBeat.o(129213);
    return paramCollection;
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection, T paramT)
  {
    AppMethodBeat.i(129212);
    s.u(paramCollection, "$this$plus");
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
    s.u(paramIterable1, "$this$union");
    s.u(paramIterable2, "other");
    paramIterable1 = p.u(paramIterable1);
    p.a((Collection)paramIterable1, paramIterable2);
    AppMethodBeat.o(129207);
    return paramIterable1;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(129192);
    s.u(paramIterable, "$this$take");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramIterable = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(129192);
      throw paramIterable;
    }
    if (paramInt == 0)
    {
      paramIterable = (List)ab.aivy;
      AppMethodBeat.o(129192);
      return paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      if (paramInt >= ((Collection)paramIterable).size())
      {
        paramIterable = p.p(paramIterable);
        AppMethodBeat.o(129192);
        return paramIterable;
      }
      if (paramInt == 1)
      {
        paramIterable = p.listOf(p.e(paramIterable));
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
    paramIterable = p.oF((List)localArrayList);
    AppMethodBeat.o(129192);
    return paramIterable;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    AppMethodBeat.i(191349);
    s.u(paramIterable1, "$this$plus");
    s.u(paramIterable2, "elements");
    if ((paramIterable1 instanceof Collection))
    {
      paramIterable1 = p.b((Collection)paramIterable1, paramIterable2);
      AppMethodBeat.o(191349);
      return paramIterable1;
    }
    ArrayList localArrayList = new ArrayList();
    p.a((Collection)localArrayList, paramIterable1);
    p.a((Collection)localArrayList, paramIterable2);
    paramIterable1 = (List)localArrayList;
    AppMethodBeat.o(191349);
    return paramIterable1;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129210);
    s.u(paramIterable, "$this$minus");
    ArrayList localArrayList = new ArrayList(p.a(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    int i = 0;
    label113:
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        int j;
        if ((i == 0) && (s.p(localObject, paramT)))
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
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(129189);
    s.u(paramIterable, "$this$filter");
    s.u(paramb, "predicate");
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
  
  public static final <T, R> List<r<T, R>> d(Iterable<? extends T> paramIterable, Iterable<? extends R> paramIterable1)
  {
    AppMethodBeat.i(129214);
    s.u(paramIterable, "$this$zip");
    s.u(paramIterable1, "other");
    Iterator localIterator1 = paramIterable.iterator();
    Iterator localIterator2 = paramIterable1.iterator();
    paramIterable = new ArrayList(Math.min(p.a(paramIterable, 10), p.a(paramIterable1, 10)));
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      paramIterable.add(v.Y(localIterator1.next(), localIterator2.next()));
    }
    paramIterable = (List)paramIterable;
    AppMethodBeat.o(129214);
    return paramIterable;
  }
  
  public static final <T> List<T> d(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(129211);
    s.u(paramIterable, "$this$plus");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = p.b((Collection)paramIterable, paramT);
      AppMethodBeat.o(129211);
      return paramIterable;
    }
    ArrayList localArrayList = new ArrayList();
    p.a((Collection)localArrayList, paramIterable);
    localArrayList.add(paramT);
    paramIterable = (List)localArrayList;
    AppMethodBeat.o(129211);
    return paramIterable;
  }
  
  public static final <T, R> List<R> d(Iterable<? extends T> paramIterable, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(129203);
    s.u(paramIterable, "$this$map");
    s.u(paramb, "transform");
    Collection localCollection = (Collection)new ArrayList(p.a(paramIterable, 10));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramb.invoke(paramIterable.next()));
    }
    paramIterable = (List)localCollection;
    AppMethodBeat.o(129203);
    return paramIterable;
  }
  
  public static final <T> T e(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129174);
    s.u(paramIterable, "$this$first");
    if ((paramIterable instanceof List))
    {
      paramIterable = p.oK((List)paramIterable);
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
  
  public static final <T> T f(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129176);
    s.u(paramIterable, "$this$firstOrNull");
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
  
  public static final <T> T g(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129180);
    s.u(paramIterable, "$this$last");
    if ((paramIterable instanceof List))
    {
      paramIterable = p.oM((List)paramIterable);
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
  
  public static final <T> T h(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191138);
    s.u(paramIterable, "$this$lastOrNull");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).isEmpty())
      {
        AppMethodBeat.o(191138);
        return null;
      }
      paramIterable = ((List)paramIterable).get(((List)paramIterable).size() - 1);
      AppMethodBeat.o(191138);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(191138);
      return null;
    }
    Object localObject;
    do
    {
      localObject = paramIterable.next();
    } while (paramIterable.hasNext());
    AppMethodBeat.o(191138);
    return localObject;
  }
  
  public static final <T> T i(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129183);
    s.u(paramIterable, "$this$single");
    if ((paramIterable instanceof List))
    {
      paramIterable = p.oO((List)paramIterable);
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
  
  public static final <T> T j(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129185);
    s.u(paramIterable, "$this$singleOrNull");
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
  
  public static final <T> List<T> k(Iterable<? extends T> paramIterable)
  {
    int i = 1;
    AppMethodBeat.i(129187);
    s.u(paramIterable, "$this$drop");
    ArrayList localArrayList;
    if ((paramIterable instanceof Collection))
    {
      int j = ((Collection)paramIterable).size() - 1;
      if (j <= 0)
      {
        paramIterable = (List)ab.aivy;
        AppMethodBeat.o(129187);
        return paramIterable;
      }
      if (j == 1)
      {
        paramIterable = p.listOf(p.g(paramIterable));
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
      paramIterable = p.oF((List)localArrayList);
      AppMethodBeat.o(129187);
      return paramIterable;
    }
  }
  
  public static final <T> List<T> l(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129190);
    s.u(paramIterable, "$this$filterNotNull");
    paramIterable = (List)p.a(paramIterable, (Collection)new ArrayList());
    AppMethodBeat.o(129190);
    return paramIterable;
  }
  
  public static final <T> List<T> m(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129194);
    s.u(paramIterable, "$this$reversed");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).size() <= 1))
    {
      paramIterable = p.p(paramIterable);
      AppMethodBeat.o(129194);
      return paramIterable;
    }
    paramIterable = p.q(paramIterable);
    p.oJ(paramIterable);
    AppMethodBeat.o(129194);
    return paramIterable;
  }
  
  public static final <T extends Comparable<? super T>> List<T> n(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129195);
    s.u(paramIterable, "$this$sorted");
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() <= 1)
      {
        paramIterable = p.p(paramIterable);
        AppMethodBeat.o(129195);
        return paramIterable;
      }
      paramIterable = ((Collection)paramIterable).toArray(new Comparable[0]);
      if (paramIterable == null)
      {
        paramIterable = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      if (paramIterable == null)
      {
        paramIterable = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      paramIterable = (Comparable[])paramIterable;
      if (paramIterable == null)
      {
        paramIterable = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        AppMethodBeat.o(129195);
        throw paramIterable;
      }
      k.W((Object[])paramIterable);
      paramIterable = k.V((Object[])paramIterable);
      AppMethodBeat.o(129195);
      return paramIterable;
    }
    paramIterable = p.q(paramIterable);
    p.N(paramIterable);
    AppMethodBeat.o(129195);
    return paramIterable;
  }
  
  public static final <T> HashSet<T> o(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(183772);
    s.u(paramIterable, "$this$toHashSet");
    paramIterable = (HashSet)p.b(paramIterable, (Collection)new HashSet(ak.aKi(p.a(paramIterable, 12))));
    AppMethodBeat.o(183772);
    return paramIterable;
  }
  
  public static final <T> T oK(List<? extends T> paramList)
  {
    AppMethodBeat.i(129175);
    s.u(paramList, "$this$first");
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
  
  public static final <T> T oL(List<? extends T> paramList)
  {
    AppMethodBeat.i(129177);
    s.u(paramList, "$this$firstOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(129177);
      return null;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(129177);
    return paramList;
  }
  
  public static final <T> T oM(List<? extends T> paramList)
  {
    AppMethodBeat.i(129181);
    s.u(paramList, "$this$last");
    if (paramList.isEmpty())
    {
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(129181);
      throw paramList;
    }
    paramList = paramList.get(p.oE(paramList));
    AppMethodBeat.o(129181);
    return paramList;
  }
  
  public static final <T> T oN(List<? extends T> paramList)
  {
    AppMethodBeat.i(129182);
    s.u(paramList, "$this$lastOrNull");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(129182);
      return null;
    }
    paramList = paramList.get(paramList.size() - 1);
    AppMethodBeat.o(129182);
    return paramList;
  }
  
  public static final <T> T oO(List<? extends T> paramList)
  {
    AppMethodBeat.i(129184);
    s.u(paramList, "$this$single");
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
  
  public static final <T> T oP(List<? extends T> paramList)
  {
    AppMethodBeat.i(129186);
    s.u(paramList, "$this$singleOrNull");
    if (paramList.size() == 1)
    {
      paramList = paramList.get(0);
      AppMethodBeat.o(129186);
      return paramList;
    }
    AppMethodBeat.o(129186);
    return null;
  }
  
  public static final <T> List<T> p(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129199);
    s.u(paramIterable, "$this$toList");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = p.J((Collection)paramIterable);
        AppMethodBeat.o(129199);
        return paramIterable;
      case 0: 
        paramIterable = (List)ab.aivy;
        AppMethodBeat.o(129199);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = p.listOf(paramIterable);
        AppMethodBeat.o(129199);
        return paramIterable;
      }
    }
    paramIterable = p.oF(p.q(paramIterable));
    AppMethodBeat.o(129199);
    return paramIterable;
  }
  
  public static final <T> List<T> q(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129200);
    s.u(paramIterable, "$this$toMutableList");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = p.J((Collection)paramIterable);
      AppMethodBeat.o(129200);
      return paramIterable;
    }
    paramIterable = (List)p.b(paramIterable, (Collection)new ArrayList());
    AppMethodBeat.o(129200);
    return paramIterable;
  }
  
  public static final <T> Set<T> r(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129202);
    s.u(paramIterable, "$this$toSet");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = (Set)p.b(paramIterable, (Collection)new LinkedHashSet(ak.aKi(((Collection)paramIterable).size())));
        AppMethodBeat.o(129202);
        return paramIterable;
      case 0: 
        paramIterable = (Set)ad.aivA;
        AppMethodBeat.o(129202);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = ar.setOf(paramIterable);
        AppMethodBeat.o(129202);
        return paramIterable;
      }
    }
    paramIterable = ar.M((Set)p.b(paramIterable, (Collection)new LinkedHashSet()));
    AppMethodBeat.o(129202);
    return paramIterable;
  }
  
  public static final <T> Iterable<ae<T>> s(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129204);
    s.u(paramIterable, "$this$withIndex");
    paramIterable = (Iterable)new af((a)new c(paramIterable));
    AppMethodBeat.o(129204);
    return paramIterable;
  }
  
  public static final <T> List<T> t(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129205);
    s.u(paramIterable, "$this$distinct");
    paramIterable = p.p((Iterable)p.u(paramIterable));
    AppMethodBeat.o(129205);
    return paramIterable;
  }
  
  public static final long[] toLongArray(Collection<Long> paramCollection)
  {
    AppMethodBeat.i(191270);
    s.u(paramCollection, "$this$toLongArray");
    long[] arrayOfLong = new long[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfLong[i] = ((Number)paramCollection.next()).longValue();
      i += 1;
    }
    AppMethodBeat.o(191270);
    return arrayOfLong;
  }
  
  public static final <T> Set<T> u(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(129206);
    s.u(paramIterable, "$this$toMutableSet");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Set)new LinkedHashSet((Collection)paramIterable);
      AppMethodBeat.o(129206);
      return paramIterable;
    }
    paramIterable = (Set)p.b(paramIterable, (Collection)new LinkedHashSet());
    AppMethodBeat.o(129206);
    return paramIterable;
  }
  
  public static final <T> int v(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191342);
    s.u(paramIterable, "$this$count");
    if ((paramIterable instanceof Collection))
    {
      i = ((Collection)paramIterable).size();
      AppMethodBeat.o(191342);
      return i;
    }
    int i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramIterable.next();
      int j = i + 1;
      i = j;
      if (j < 0)
      {
        p.kkX();
        i = j;
      }
    }
    AppMethodBeat.o(191342);
    return i;
  }
  
  public static final Float w(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(191343);
    s.u(paramIterable, "$this$maxOrNull");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(191343);
      return null;
    }
    for (float f = ((Number)paramIterable.next()).floatValue(); paramIterable.hasNext(); f = Math.max(f, ((Number)paramIterable.next()).floatValue())) {}
    AppMethodBeat.o(191343);
    return Float.valueOf(f);
  }
  
  public static final <T extends Comparable<? super T>> T x(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191345);
    s.u(paramIterable, "$this$maxOrNull");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(191345);
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
      AppMethodBeat.o(191345);
      return paramIterable;
    }
  }
  
  public static final Float y(Iterable<Float> paramIterable)
  {
    AppMethodBeat.i(191346);
    s.u(paramIterable, "$this$minOrNull");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(191346);
      return null;
    }
    for (float f = ((Number)paramIterable.next()).floatValue(); paramIterable.hasNext(); f = Math.min(f, ((Number)paramIterable.next()).floatValue())) {}
    AppMethodBeat.o(191346);
    return Float.valueOf(f);
  }
  
  public static final <T extends Comparable<? super T>> T z(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(191348);
    s.u(paramIterable, "$this$minOrNull");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(191348);
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
      AppMethodBeat.o(191348);
      return paramIterable;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    implements h<T>
  {
    public a(Iterable paramIterable) {}
    
    public final Iterator<T> iterator()
    {
      AppMethodBeat.i(129234);
      Iterator localIterator = this.aivv.iterator();
      AppMethodBeat.o(129234);
      return localIterator;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
  static final class b
    extends u
    implements b<Integer, T>
  {
    b(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends u
    implements a<Iterator<? extends T>>
  {
    c(Iterable paramIterable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.z
 * JD-Core Version:    0.7.0.1
 */