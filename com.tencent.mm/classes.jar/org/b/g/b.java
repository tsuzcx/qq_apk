package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static <K, V> String y(Map<K, V> paramMap)
  {
    AppMethodBeat.i(77305);
    if (paramMap == null)
    {
      AppMethodBeat.o(77305);
      return "";
    }
    if (paramMap.isEmpty())
    {
      AppMethodBeat.o(77305);
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        paramMap = "{" + localStringBuilder.substring(1) + "}";
        AppMethodBeat.o(77305);
        return paramMap;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(", %s -> %s ", new Object[] { localEntry.getKey().toString(), localEntry.getValue().toString() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.g.b
 * JD-Core Version:    0.7.0.1
 */