package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final <K> Map<K, Integer> A(Iterable<? extends K> paramIterable)
  {
    AppMethodBeat.i(61342);
    k.h(paramIterable, "$this$mapToIndex");
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
  
  public static final <K, V> HashMap<K, V> aiR(int paramInt)
  {
    AppMethodBeat.i(61344);
    HashMap localHashMap = new HashMap(gb(paramInt));
    AppMethodBeat.o(61344);
    return localHashMap;
  }
  
  public static final <E> HashSet<E> aiS(int paramInt)
  {
    AppMethodBeat.i(61345);
    HashSet localHashSet = new HashSet(gb(paramInt));
    AppMethodBeat.o(61345);
    return localHashSet;
  }
  
  public static final <T> List<T> bf(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(61346);
    k.h(paramArrayList, "$this$compact");
    switch (paramArrayList.size())
    {
    default: 
      paramArrayList.trimToSize();
      paramArrayList = (List)paramArrayList;
      AppMethodBeat.o(61346);
      return paramArrayList;
    case 0: 
      paramArrayList = (List)v.KTF;
      AppMethodBeat.o(61346);
      return paramArrayList;
    }
    paramArrayList = j.listOf(j.iO((List)paramArrayList));
    AppMethodBeat.o(61346);
    return paramArrayList;
  }
  
  public static final <T> void c(Collection<T> paramCollection, T paramT)
  {
    AppMethodBeat.i(61343);
    k.h(paramCollection, "$this$addIfNotNull");
    if (paramT != null) {
      paramCollection.add(paramT);
    }
    AppMethodBeat.o(61343);
  }
  
  public static final int gb(int paramInt)
  {
    if (paramInt < 3) {
      return 3;
    }
    return paramInt / 3 + paramInt + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.a
 * JD-Core Version:    0.7.0.1
 */