package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"buildMap", "", "K", "V", "capacity", "", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "emptyMap", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/collections/MapsKt")
public class an
  extends am
{
  public static final <K, V> Map<K, V> F(Iterable<? extends r<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(129022);
    s.u(paramIterable, "$this$toMap");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = ak.a(paramIterable, (Map)new LinkedHashMap(ak.aKi(((Collection)paramIterable).size())));
        AppMethodBeat.o(129022);
        return paramIterable;
      case 0: 
        paramIterable = ak.kkZ();
        AppMethodBeat.o(129022);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = (r)((List)paramIterable).get(0);; paramIterable = (r)paramIterable.iterator().next())
      {
        paramIterable = ak.l(paramIterable);
        AppMethodBeat.o(129022);
        return paramIterable;
      }
    }
    paramIterable = ak.dx(ak.a(paramIterable, (Map)new LinkedHashMap()));
    AppMethodBeat.o(129022);
    return paramIterable;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends r<? extends K, ? extends V>> paramIterable, M paramM)
  {
    AppMethodBeat.i(129023);
    s.u(paramIterable, "$this$toMap");
    s.u(paramM, "destination");
    ak.a(paramM, paramIterable);
    AppMethodBeat.o(129023);
    return paramM;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(r<? extends K, ? extends V>[] paramArrayOfr, M paramM)
  {
    AppMethodBeat.i(129024);
    s.u(paramArrayOfr, "$this$toMap");
    s.u(paramM, "destination");
    ak.a(paramM, paramArrayOfr);
    AppMethodBeat.o(129024);
    return paramM;
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, Iterable<? extends r<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(129021);
    s.u(paramMap, "$this$putAll");
    s.u(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      r localr = (r)paramIterable.next();
      paramMap.put(localr.bsC, localr.bsD);
    }
    AppMethodBeat.o(129021);
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, r<? extends K, ? extends V>[] paramArrayOfr)
  {
    AppMethodBeat.i(129020);
    s.u(paramMap, "$this$putAll");
    s.u(paramArrayOfr, "pairs");
    int j = paramArrayOfr.length;
    int i = 0;
    while (i < j)
    {
      r<? extends K, ? extends V> localr = paramArrayOfr[i];
      paramMap.put(localr.bsC, localr.bsD);
      i += 1;
    }
    AppMethodBeat.o(129020);
  }
  
  public static final <K, V> Map<K, V> dv(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(191168);
    s.u(paramMap, "$this$toMap");
    switch (paramMap.size())
    {
    default: 
      paramMap = ak.dw(paramMap);
      AppMethodBeat.o(191168);
      return paramMap;
    case 0: 
      paramMap = ak.kkZ();
      AppMethodBeat.o(191168);
      return paramMap;
    }
    paramMap = ak.du(paramMap);
    AppMethodBeat.o(191168);
    return paramMap;
  }
  
  public static final <K, V> Map<K, V> dw(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(191175);
    s.u(paramMap, "$this$toMutableMap");
    paramMap = (Map)new LinkedHashMap(paramMap);
    AppMethodBeat.o(191175);
    return paramMap;
  }
  
  public static final <K, V> Map<K, V> dx(Map<K, ? extends V> paramMap)
  {
    AppMethodBeat.i(129025);
    s.u(paramMap, "$this$optimizeReadOnlyMap");
    switch (paramMap.size())
    {
    default: 
      AppMethodBeat.o(129025);
      return paramMap;
    case 0: 
      paramMap = ak.kkZ();
      AppMethodBeat.o(129025);
      return paramMap;
    }
    paramMap = ak.du(paramMap);
    AppMethodBeat.o(129025);
    return paramMap;
  }
  
  public static final <K, V> V e(Map<K, ? extends V> paramMap, K paramK)
  {
    AppMethodBeat.i(129019);
    s.u(paramMap, "$this$getValue");
    paramMap = ak.d(paramMap, paramK);
    AppMethodBeat.o(129019);
    return paramMap;
  }
  
  public static final <K, V> Map<K, V> e(r<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(129017);
    s.u(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = ak.a(paramVarArgs, (Map)new LinkedHashMap(ak.aKi(paramVarArgs.length)));
      AppMethodBeat.o(129017);
      return paramVarArgs;
    }
    paramVarArgs = ak.kkZ();
    AppMethodBeat.o(129017);
    return paramVarArgs;
  }
  
  public static final <K, V> Map<K, V> f(r<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(129018);
    s.u(paramVarArgs, "pairs");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(ak.aKi(paramVarArgs.length));
    ak.a((Map)localLinkedHashMap, paramVarArgs);
    paramVarArgs = (Map)localLinkedHashMap;
    AppMethodBeat.o(129018);
    return paramVarArgs;
  }
  
  public static final <K, V> HashMap<K, V> g(r<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(177352);
    s.u(paramVarArgs, "pairs");
    HashMap localHashMap = new HashMap(ak.aKi(paramVarArgs.length));
    ak.a((Map)localHashMap, paramVarArgs);
    AppMethodBeat.o(177352);
    return localHashMap;
  }
  
  public static final <K, V> Map<K, V> kkZ()
  {
    AppMethodBeat.i(129016);
    Object localObject = ac.aivz;
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
      AppMethodBeat.o(129016);
      throw ((Throwable)localObject);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(129016);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.an
 * JD-Core Version:    0.7.0.1
 */