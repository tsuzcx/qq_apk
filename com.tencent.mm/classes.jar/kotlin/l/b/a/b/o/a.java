package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;

public final class a
{
  public static final <K> Map<K, Integer> G(Iterable<? extends K> paramIterable)
  {
    AppMethodBeat.i(61342);
    p.k(paramIterable, "$this$mapToIndex");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      ((Map)localLinkedHashMap).put(localObject, Integer.valueOf(i));
      i += 1;
    }
    paramIterable = (Map)localLinkedHashMap;
    AppMethodBeat.o(61342);
    return paramIterable;
  }
  
  public static final <K, V> HashMap<K, V> aFF(int paramInt)
  {
    AppMethodBeat.i(61344);
    HashMap localHashMap = new HashMap(ii(paramInt));
    AppMethodBeat.o(61344);
    return localHashMap;
  }
  
  public static final <E> HashSet<E> aFG(int paramInt)
  {
    AppMethodBeat.i(61345);
    HashSet localHashSet = new HashSet(ii(paramInt));
    AppMethodBeat.o(61345);
    return localHashSet;
  }
  
  public static final <T> List<T> bN(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(61346);
    p.k(paramArrayList, "$this$compact");
    switch (paramArrayList.size())
    {
    default: 
      paramArrayList.trimToSize();
      paramArrayList = (List)paramArrayList;
      AppMethodBeat.o(61346);
      return paramArrayList;
    case 0: 
      paramArrayList = (List)v.aaAd;
      AppMethodBeat.o(61346);
      return paramArrayList;
    }
    paramArrayList = j.listOf(j.lo((List)paramArrayList));
    AppMethodBeat.o(61346);
    return paramArrayList;
  }
  
  public static final <T> void c(Collection<T> paramCollection, T paramT)
  {
    AppMethodBeat.i(61343);
    p.k(paramCollection, "$this$addIfNotNull");
    if (paramT != null) {
      paramCollection.add(paramT);
    }
    AppMethodBeat.o(61343);
  }
  
  public static final int ii(int paramInt)
  {
    if (paramInt < 3) {
      return 3;
    }
    return paramInt / 3 + paramInt + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.o.a
 * JD-Core Version:    0.7.0.1
 */