package com.tencent.mm.plugin.sns.ad.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class d
{
  public static boolean J(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static <K, V> boolean aC(Map<K, V> paramMap)
  {
    AppMethodBeat.i(267941);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(267941);
      return true;
    }
    AppMethodBeat.o(267941);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(267938);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(267938);
      return true;
    }
    AppMethodBeat.o(267938);
    return false;
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(267940);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(267940);
      return true;
    }
    AppMethodBeat.o(267940);
    return false;
  }
  
  public static <T> boolean n(Collection<T> paramCollection)
  {
    AppMethodBeat.i(267939);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(267939);
      return true;
    }
    AppMethodBeat.o(267939);
    return false;
  }
  
  public static <T> boolean w(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }
  
  public static <T> boolean x(T[] paramArrayOfT)
  {
    AppMethodBeat.i(267943);
    if (!w(paramArrayOfT))
    {
      AppMethodBeat.o(267943);
      return true;
    }
    AppMethodBeat.o(267943);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.i.d
 * JD-Core Version:    0.7.0.1
 */