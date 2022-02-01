package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;

public final class b
{
  public static <K, V> boolean aD(Map<K, V> paramMap)
  {
    AppMethodBeat.i(197703);
    if (!isEmpty(paramMap))
    {
      AppMethodBeat.o(197703);
      return true;
    }
    AppMethodBeat.o(197703);
    return false;
  }
  
  public static <T> boolean isEmpty(Collection<T> paramCollection)
  {
    AppMethodBeat.i(197700);
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      AppMethodBeat.o(197700);
      return true;
    }
    AppMethodBeat.o(197700);
    return false;
  }
  
  public static <K, V> boolean isEmpty(Map<K, V> paramMap)
  {
    AppMethodBeat.i(197702);
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      AppMethodBeat.o(197702);
      return true;
    }
    AppMethodBeat.o(197702);
    return false;
  }
  
  public static <T> boolean m(Collection<T> paramCollection)
  {
    AppMethodBeat.i(197701);
    if (!isEmpty(paramCollection))
    {
      AppMethodBeat.o(197701);
      return true;
    }
    AppMethodBeat.o(197701);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.b
 * JD-Core Version:    0.7.0.1
 */