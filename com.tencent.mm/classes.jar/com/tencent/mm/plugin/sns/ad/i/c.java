package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class c
{
  public static boolean K(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static <K, V> boolean aI(Map<K, V> paramMap)
  {
    AppMethodBeat.i(202350);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(202350);
      return true;
    }
    AppMethodBeat.o(202350);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(202347);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(202347);
      return true;
    }
    AppMethodBeat.o(202347);
    return false;
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(202349);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(202349);
      return true;
    }
    AppMethodBeat.o(202349);
    return false;
  }
  
  public static <T> boolean o(Collection<T> paramCollection)
  {
    AppMethodBeat.i(202348);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(202348);
      return true;
    }
    AppMethodBeat.o(202348);
    return false;
  }
  
  public static <T> boolean w(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }
  
  public static <T> boolean x(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202351);
    if (!w(paramArrayOfT))
    {
      AppMethodBeat.o(202351);
      return true;
    }
    AppMethodBeat.o(202351);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.c
 * JD-Core Version:    0.7.0.1
 */