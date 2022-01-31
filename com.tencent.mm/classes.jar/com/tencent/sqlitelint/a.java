package com.tencent.sqlitelint;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  static void z(String paramString, Map<String, List<String>> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    String[] arrayOfString = new String[paramMap.size()];
    paramMap = new String[paramMap.size()][];
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      arrayOfString[i] = ((String)((Map.Entry)localObject).getKey());
      localObject = (List)((Map.Entry)localObject).getValue();
      paramMap[i] = new String[((List)localObject).size()];
      int j = 0;
      while (j < ((List)localObject).size())
      {
        paramMap[i][j] = ((String)((List)localObject).get(j));
        j += 1;
      }
      i += 1;
    }
    SQLiteLintNativeBridge.nativeAddToWhiteList(paramString, arrayOfString, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.a
 * JD-Core Version:    0.7.0.1
 */