package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m.h;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"all", "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "flatMap", "", "R", "transform", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "forEach", "", "action", "map", "mapNotNull", "", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, hxG=1)
public class ai
  extends ah
{
  public static final <K, V> List<o<K, V>> cv(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(129241);
    p.h(paramMap, "$this$toList");
    if (paramMap.size() == 0)
    {
      paramMap = (List)v.SXr;
      AppMethodBeat.o(129241);
      return paramMap;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    if (!localIterator.hasNext())
    {
      paramMap = (List)v.SXr;
      AppMethodBeat.o(129241);
      return paramMap;
    }
    Map.Entry localEntry = (Map.Entry)localIterator.next();
    if (!localIterator.hasNext())
    {
      paramMap = j.listOf(new o(localEntry.getKey(), localEntry.getValue()));
      AppMethodBeat.o(129241);
      return paramMap;
    }
    paramMap = new ArrayList(paramMap.size());
    paramMap.add(new o(localEntry.getKey(), localEntry.getValue()));
    do
    {
      localEntry = (Map.Entry)localIterator.next();
      paramMap.add(new o(localEntry.getKey(), localEntry.getValue()));
    } while (localIterator.hasNext());
    paramMap = (List)paramMap;
    AppMethodBeat.o(129241);
    return paramMap;
  }
  
  public static final <K, V> h<Map.Entry<K, V>> cw(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(206264);
    p.h(paramMap, "$this$asSequence");
    paramMap = j.z((Iterable)paramMap.entrySet());
    AppMethodBeat.o(206264);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ai
 * JD-Core Version:    0.7.0.1
 */