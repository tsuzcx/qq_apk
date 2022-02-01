package com.tencent.mm.plugin.sns.ad.adxml;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.d;
import java.util.Map;

public class a
{
  public String Jxv;
  public String Jxw;
  
  public static a s(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(270630);
    if (d.isEmpty(paramMap))
    {
      AppMethodBeat.o(270630);
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
        AppMethodBeat.o(270630);
        return null;
      }
      paramString = new a();
      paramString.Jxv = str;
      paramString.Jxw = paramMap;
      AppMethodBeat.o(270630);
      return paramString;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(270630);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.adxml.a
 * JD-Core Version:    0.7.0.1
 */