package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class b
{
  public static <K, V> boolean aA(Map<K, V> paramMap)
  {
    AppMethodBeat.i(200024);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(200024);
      return true;
    }
    AppMethodBeat.o(200024);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(200021);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(200021);
      return true;
    }
    AppMethodBeat.o(200021);
    return false;
  }
  
  private static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(200023);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(200023);
      return true;
    }
    AppMethodBeat.o(200023);
    return false;
  }
  
  public static <T> boolean m(Collection<T> paramCollection)
  {
    AppMethodBeat.i(200022);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(200022);
      return true;
    }
    AppMethodBeat.o(200022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.b
 * JD-Core Version:    0.7.0.1
 */