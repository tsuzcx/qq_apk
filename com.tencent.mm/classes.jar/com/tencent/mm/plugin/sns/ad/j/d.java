package com.tencent.mm.plugin.sns.ad.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class d
{
  public static <T> boolean B(Collection<T> paramCollection)
  {
    AppMethodBeat.i(309740);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(309740);
      return true;
    }
    AppMethodBeat.o(309740);
    return false;
  }
  
  public static boolean N(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static <K, V> boolean aT(Map<K, V> paramMap)
  {
    AppMethodBeat.i(309757);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(309757);
      return true;
    }
    AppMethodBeat.o(309757);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(309735);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(309735);
      return true;
    }
    AppMethodBeat.o(309735);
    return false;
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(309751);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(309751);
      return true;
    }
    AppMethodBeat.o(309751);
    return false;
  }
  
  public static <T> boolean y(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }
  
  public static <T> boolean z(T[] paramArrayOfT)
  {
    AppMethodBeat.i(309771);
    if (!y(paramArrayOfT))
    {
      AppMethodBeat.o(309771);
      return true;
    }
    AppMethodBeat.o(309771);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.j.d
 * JD-Core Version:    0.7.0.1
 */