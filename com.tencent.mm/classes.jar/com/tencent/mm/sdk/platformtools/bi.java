package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bi
{
  public static Map<String, String> aLg(String paramString)
  {
    AppMethodBeat.i(157824);
    if ((paramString == null) || (!paramString.startsWith("~SEMI_XML~")))
    {
      AppMethodBeat.o(157824);
      return null;
    }
    String str1 = paramString.substring(10);
    paramString = new HashMap();
    int j = str1.length();
    int i = 0;
    for (;;)
    {
      if (i < j - 4)
      {
        int k = i + 1;
        try
        {
          int m = str1.charAt(i);
          i = k + 1;
          k = (m << 16) + str1.charAt(k) + i;
          String str2 = str1.substring(i, k);
          i = k + 1;
          m = str1.charAt(k);
          k = i + 1;
          i = (m << 16) + str1.charAt(i) + k;
          paramString.put(str2, str1.substring(k, i));
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.SemiXml", localException, "", new Object[0]);
        }
      }
    }
    AppMethodBeat.o(157824);
    return paramString;
  }
  
  public static String bF(Map<String, String> paramMap)
  {
    AppMethodBeat.i(157823);
    if (paramMap == null)
    {
      AppMethodBeat.o(157823);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("~SEMI_XML~");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (localObject != null)
      {
        int i = str.length();
        int j = ((String)localObject).length();
        localStringBuilder.append((char)(i >> 16)).append((char)i).append(str);
        localStringBuilder.append((char)(j >> 16)).append((char)j).append((String)localObject);
      }
    }
    paramMap = localStringBuilder.toString();
    AppMethodBeat.o(157823);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bi
 * JD-Core Version:    0.7.0.1
 */