package d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(gfA=1, gfx={1, 1, 16}, gfy={""}, gfz={"buildMap", "", "K", "V", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptyMap", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"})
public class ah
  extends ag
{
  public static final <K, V> Map<K, V> A(Iterable<? extends o<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(129022);
    p.h(paramIterable, "$this$toMap");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = ae.a(paramIterable, (Map)new LinkedHashMap(ae.aji(((Collection)paramIterable).size())));
        AppMethodBeat.o(129022);
        return paramIterable;
      case 0: 
        paramIterable = ae.emptyMap();
        AppMethodBeat.o(129022);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = (o)((List)paramIterable).get(0);; paramIterable = (o)paramIterable.iterator().next())
      {
        paramIterable = ae.c(paramIterable);
        AppMethodBeat.o(129022);
        return paramIterable;
      }
    }
    paramIterable = ae.cd(ae.a(paramIterable, (Map)new LinkedHashMap()));
    AppMethodBeat.o(129022);
    return paramIterable;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends o<? extends K, ? extends V>> paramIterable, M paramM)
  {
    AppMethodBeat.i(129023);
    p.h(paramIterable, "$this$toMap");
    p.h(paramM, "destination");
    ae.a(paramM, paramIterable);
    AppMethodBeat.o(129023);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> a(o<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(129017);
    p.h(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = ae.a(paramVarArgs, (Map)new LinkedHashMap(ae.aji(paramVarArgs.length)));
      AppMethodBeat.o(129017);
      return paramVarArgs;
    }
    paramVarArgs = ae.emptyMap();
    AppMethodBeat.o(129017);
    return paramVarArgs;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(o<? extends K, ? extends V>[] paramArrayOfo, M paramM)
  {
    AppMethodBeat.i(129024);
    p.h(paramArrayOfo, "$this$toMap");
    p.h(paramM, "destination");
    ae.a(paramM, paramArrayOfo);
    AppMethodBeat.o(129024);
    return paramM;
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, Iterable<? extends o<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(129021);
    p.h(paramMap, "$this$putAll");
    p.h(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      o localo = (o)paramIterable.next();
      paramMap.put(localo.first, localo.second);
    }
    AppMethodBeat.o(129021);
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, o<? extends K, ? extends V>[] paramArrayOfo)
  {
    AppMethodBeat.i(129020);
    p.h(paramMap, "$this$putAll");
    p.h(paramArrayOfo, "pairs");
    int j = paramArrayOfo.length;
    int i = 0;
    while (i < j)
    {
      o<? extends K, ? extends V> localo = paramArrayOfo[i];
      paramMap.put(localo.first, localo.second);
      i += 1;
    }
    AppMethodBeat.o(129020);
  }
  
  public static final <K, V> Map<K, V> b(o<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(129018);
    p.h(paramVarArgs, "pairs");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(ae.aji(paramVarArgs.length));
    ae.a((Map)localLinkedHashMap, paramVarArgs);
    paramVarArgs = (Map)localLinkedHashMap;
    AppMethodBeat.o(129018);
    return paramVarArgs;
  }
  
  public static final <K, V> HashMap<K, V> c(o<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(177352);
    p.h(paramVarArgs, "pairs");
    HashMap localHashMap = new HashMap(ae.aji(paramVarArgs.length));
    ae.a((Map)localHashMap, paramVarArgs);
    AppMethodBeat.o(177352);
    return localHashMap;
  }
  
  public static final <K, V> Map<K, V> cd(Map<K, ? extends V> paramMap)
  {
    AppMethodBeat.i(129025);
    p.h(paramMap, "$this$optimizeReadOnlyMap");
    switch (paramMap.size())
    {
    default: 
      AppMethodBeat.o(129025);
      return paramMap;
    case 0: 
      paramMap = ae.emptyMap();
      AppMethodBeat.o(129025);
      return paramMap;
    }
    paramMap = ae.cc(paramMap);
    AppMethodBeat.o(129025);
    return paramMap;
  }
  
  public static final <K, V> V e(Map<K, ? extends V> paramMap, K paramK)
  {
    AppMethodBeat.i(129019);
    p.h(paramMap, "$this$getValue");
    paramMap = ae.d(paramMap, paramK);
    AppMethodBeat.o(129019);
    return paramMap;
  }
  
  public static final <K, V> Map<K, V> emptyMap()
  {
    AppMethodBeat.i(129016);
    Object localObject = w.MKF;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
      AppMethodBeat.o(129016);
      throw ((Throwable)localObject);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(129016);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.ah
 * JD-Core Version:    0.7.0.1
 */