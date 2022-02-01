package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.d;
import java.util.Map;

public class b
{
  public String PLk;
  public String PLl;
  
  public static b v(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(309831);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(309831);
      return null;
    }
    try
    {
      String str = (String)paramMap.get(paramString + ".finderEncryptedTopicId");
      paramMap = (String)paramMap.get(paramString + ".finderTopicName");
      if (!TextUtils.isEmpty(str))
      {
        boolean bool = TextUtils.isEmpty(paramMap);
        if (!bool) {}
      }
      else
      {
        return null;
      }
      paramString = new b();
      paramString.PLk = str;
      paramString.PLl = paramMap;
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(309831);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.b
 * JD-Core Version:    0.7.0.1
 */