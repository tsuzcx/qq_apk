package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"INT_MAX_POWER_OF_TWO", "", "checkBuilderCapacity", "", "capacity", "mapCapacity", "expectedSize", "mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "comparator", "Ljava/util/Comparator;", "kotlin-stdlib"}, hxG=1)
public class ag
  extends af
{
  public static final int atJ(int paramInt)
  {
    if (paramInt < 0) {
      return paramInt;
    }
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return (int)(paramInt / 0.75F + 1.0F);
    }
    return 2147483647;
  }
  
  public static final <K, V> Map<K, V> b(o<? extends K, ? extends V> paramo)
  {
    AppMethodBeat.i(129008);
    p.h(paramo, "pair");
    paramo = Collections.singletonMap(paramo.first, paramo.second);
    p.g(paramo, "java.util.Collections.si…(pair.first, pair.second)");
    AppMethodBeat.o(129008);
    return paramo;
  }
  
  public static final <K, V> Map<K, V> ct(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(129009);
    p.h(paramMap, "$this$toSingletonMap");
    paramMap = (Map.Entry)paramMap.entrySet().iterator().next();
    paramMap = Collections.singletonMap(paramMap.getKey(), paramMap.getValue());
    p.g(paramMap, "java.util.Collections.singletonMap(key, value)");
    p.g(paramMap, "with(entries.iterator().…ingletonMap(key, value) }");
    AppMethodBeat.o(129009);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.ag
 * JD-Core Version:    0.7.0.1
 */