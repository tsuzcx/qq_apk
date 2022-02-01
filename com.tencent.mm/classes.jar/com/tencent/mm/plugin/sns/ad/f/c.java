package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class c
{
  public static <K, V> boolean aJ(Map<K, V> paramMap)
  {
    AppMethodBeat.i(219175);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(219175);
      return true;
    }
    AppMethodBeat.o(219175);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(219172);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(219172);
      return true;
    }
    AppMethodBeat.o(219172);
    return false;
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(219174);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(219174);
      return true;
    }
    AppMethodBeat.o(219174);
    return false;
  }
  
  public static <T> boolean m(Collection<T> paramCollection)
  {
    AppMethodBeat.i(219173);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(219173);
      return true;
    }
    AppMethodBeat.o(219173);
    return false;
  }
  
  public static <T> boolean w(T[] paramArrayOfT)
  {
    return (paramArrayOfT == null) || (paramArrayOfT.length == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.c
 * JD-Core Version:    0.7.0.1
 */