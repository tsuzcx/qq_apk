package com.tencent.mm.pluginsdk.g.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public enum b
{
  public static String aR(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(79649);
    if (paramMap == null)
    {
      AppMethodBeat.o(79649);
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      localStringBuilder.append(bo.bf((String)((Map.Entry)localObject).getKey(), "null"));
      localStringBuilder.append(" : ");
      localObject = (List)((Map.Entry)localObject).getValue();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(bo.nullAsNil((String)((Iterator)localObject).next())).append("|");
        }
      }
      localStringBuilder.append("\n");
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(79649);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.d.b
 * JD-Core Version:    0.7.0.1
 */