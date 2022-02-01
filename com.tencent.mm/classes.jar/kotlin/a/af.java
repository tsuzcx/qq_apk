package kotlin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, hxG=1)
class af
{
  public static final <K, V> V d(Map<K, ? extends V> paramMap, K paramK)
  {
    AppMethodBeat.i(129235);
    p.h(paramMap, "$this$getOrImplicitDefault");
    if ((paramMap instanceof ad))
    {
      paramMap = ((ad)paramMap).hxJ();
      AppMethodBeat.o(129235);
      return paramMap;
    }
    Object localObject = paramMap.get(paramK);
    if ((localObject == null) && (!paramMap.containsKey(paramK)))
    {
      paramMap = (Throwable)new NoSuchElementException("Key " + paramK + " is missing in the map.");
      AppMethodBeat.o(129235);
      throw paramMap;
    }
    AppMethodBeat.o(129235);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.a.af
 * JD-Core Version:    0.7.0.1
 */