package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.m.h;
import kotlin.r;

@Metadata(d1={""}, d2={"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrNull", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/MapsKt")
public class ao
  extends an
{
  public static final <K, V> List<r<K, V>> dy(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(129241);
    s.u(paramMap, "$this$toList");
    if (paramMap.size() == 0)
    {
      paramMap = (List)ab.aivy;
      AppMethodBeat.o(129241);
      return paramMap;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext())
    {
      paramMap = (List)ab.aivy;
      AppMethodBeat.o(129241);
      return paramMap;
    }
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    if (!localIterator.hasNext())
    {
      paramMap = p.listOf(new r(localEntry.getKey(), localEntry.getValue()));
      AppMethodBeat.o(129241);
      return paramMap;
    }
    paramMap = new ArrayList(paramMap.size());
    paramMap.add(new r(localEntry.getKey(), localEntry.getValue()));
    do
    {
      localEntry = (Map.Entry)localIterator.next();
      paramMap.add(new r(localEntry.getKey(), localEntry.getValue()));
    } while (localIterator.hasNext());
    paramMap = (List)paramMap;
    AppMethodBeat.o(129241);
    return paramMap;
  }
  
  public static final <K, V> h<Map.Entry<K, V>> dz(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(191143);
    s.u(paramMap, "$this$asSequence");
    paramMap = p.A((Iterable)paramMap.entrySet());
    AppMethodBeat.o(191143);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ao
 * JD-Core Version:    0.7.0.1
 */