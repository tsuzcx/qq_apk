package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import java.util.Map;

public final class a
{
  public String finderEncryptedTopicId;
  public String finderTopicName;
  
  public static a s(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(201848);
    if (c.isEmpty(paramMap))
    {
      AppMethodBeat.o(201848);
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
        AppMethodBeat.o(201848);
        return null;
      }
      paramString = new a();
      paramString.finderEncryptedTopicId = str;
      paramString.finderTopicName = paramMap;
      AppMethodBeat.o(201848);
      return paramString;
    }
    catch (Throwable paramMap)
    {
      AppMethodBeat.o(201848);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.a
 * JD-Core Version:    0.7.0.1
 */