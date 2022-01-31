package org.c.g;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static <K, V> String s(Map<K, V> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    if (paramMap.isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext()) {
        return "{" + localStringBuilder.substring(1) + "}";
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder.append(String.format(", %s -> %s ", new Object[] { localEntry.getKey().toString(), localEntry.getValue().toString() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.c.g.b
 * JD-Core Version:    0.7.0.1
 */