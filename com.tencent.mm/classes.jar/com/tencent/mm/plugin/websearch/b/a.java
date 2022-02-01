package com.tencent.mm.plugin.websearch.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.al;
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
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.ad.iR(ak.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(com.tencent.mm.plugin.websearch.api.ad.WL(3)));
    String str;
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("isHomePage", str);
      if (al.isDarkMode()) {
        localHashMap.put("isDarkMode", "1");
      }
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("extParams", paramString);
      }
      paramString = com.tencent.mm.model.c.d.aDI().xi("100192");
      if ((!paramString.isValid()) || (!"1".equals(paramString.fsy().get("openSearchSuggestion")))) {
        break label253;
      }
    }
    label253:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (bool) {
        localHashMap.put("isSug", "1");
      }
      AppMethodBeat.o(116765);
      return localHashMap;
      str = "0";
      break;
    }
  }
  
  public static Map<String, String> aY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116764);
    Map localMap = a(paramInt, paramBoolean, 64, "");
    AppMethodBeat.o(116764);
    return localMap;
  }
  
  public static String be(Map<String, String> paramMap)
  {
    AppMethodBeat.i(116763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.WN(3));
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
      localStringBuffer.append(com.tencent.mm.plugin.websearch.api.ad.WI(bu.aSB((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(116763);
    return paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a
 * JD-Core Version:    0.7.0.1
 */