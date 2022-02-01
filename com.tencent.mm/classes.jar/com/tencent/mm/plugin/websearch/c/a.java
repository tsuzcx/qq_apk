package com.tencent.mm.plugin.websearch.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.ao;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    AppMethodBeat.i(116765);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", String.valueOf(paramInt2));
    localHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(ai.aft(3)));
    String str;
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("isHomePage", str);
      if (ao.isDarkMode()) {
        localHashMap.put("isDarkMode", "1");
      }
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("extParams", paramString);
      }
      paramString = com.tencent.mm.model.c.d.aXu().Fu("100192");
      if ((!paramString.isValid()) || (!"1".equals(paramString.gzz().get("openSearchSuggestion")))) {
        break label253;
      }
    }
    label253:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (bool) {
        localHashMap.put("isSug", "1");
      }
      AppMethodBeat.o(116765);
      return localHashMap;
      str = "0";
      break;
    }
  }
  
  public static String bd(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(ai.afw(3));
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
      localStringBuffer.append(ai.afq(Util.safeParseInt((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(116763);
    return paramMap;
  }
  
  public static Map<String, String> br(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116764);
    Map localMap = a(paramInt, paramBoolean, 64, "");
    AppMethodBeat.o(116764);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a
 * JD-Core Version:    0.7.0.1
 */