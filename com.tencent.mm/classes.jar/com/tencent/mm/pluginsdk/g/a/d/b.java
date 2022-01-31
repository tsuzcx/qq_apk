package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public enum b
{
  public static String as(Map<String, List<String>> paramMap)
  {
    if (paramMap == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      localStringBuilder.append(bk.aM((String)((Map.Entry)localObject).getKey(), "null"));
      localStringBuilder.append(" : ");
      localObject = (List)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(bk.pm((String)((Iterator)localObject).next())).append("|");
        }
      }
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.d.b
 * JD-Core Version:    0.7.0.1
 */