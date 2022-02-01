package com.tencent.mm.plugin.websearch.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    AppMethodBeat.i(116765);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", "64");
    localHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(aj.asY(3)));
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("isHomePage", str);
      if (aw.isDarkMode()) {
        localHashMap.put("isDarkMode", "1");
      }
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("extParams", paramString);
      }
      localHashMap.put("isSug", "1");
      AppMethodBeat.o(116765);
      return localHashMap;
    }
  }
  
  public static String bo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aj.atb(3));
    localStringBuffer.append("/app.html?");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuffer.append("&");
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
    }
    if (!paramMap.containsKey("sessionId"))
    {
      localStringBuffer.append("&");
      localStringBuffer.append("sessionId");
      localStringBuffer.append("=");
      localStringBuffer.append(aj.asV(Util.safeParseInt((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(116763);
    return paramMap;
  }
  
  public static Map<String, String> ck(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116764);
    Map localMap = a(paramInt, paramBoolean, 64, "");
    AppMethodBeat.o(116764);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.d.a
 * JD-Core Version:    0.7.0.1
 */