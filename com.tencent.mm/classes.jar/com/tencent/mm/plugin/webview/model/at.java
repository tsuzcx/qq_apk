package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class at
{
  private static Map<String, String> uXi;
  
  static
  {
    AppMethodBeat.i(6799);
    uXi = new HashMap();
    AppMethodBeat.o(6799);
  }
  
  public static String agU(String paramString)
  {
    AppMethodBeat.i(6797);
    ab.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
      AppMethodBeat.o(6797);
      return null;
    }
    String str2 = (String)uXi.get(paramString);
    String str1 = str2;
    int i;
    if (bo.isNullOrNil(str2))
    {
      i = paramString.indexOf("#");
      if (i >= 0) {
        break label106;
      }
    }
    label106:
    for (str1 = paramString;; str1 = paramString.substring(0, i))
    {
      str1 = (String)uXi.get(str1);
      if (!bo.isNullOrNil(str1)) {
        break;
      }
      AppMethodBeat.o(6797);
      return paramString;
    }
    AppMethodBeat.o(6797);
    return str1;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(6798);
    uXi.clear();
    AppMethodBeat.o(6798);
  }
  
  public static void hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6796);
    ab.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[] { paramString1, paramString2 });
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
      AppMethodBeat.o(6796);
      return;
    }
    if (uXi.containsKey(paramString1))
    {
      ab.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
      AppMethodBeat.o(6796);
      return;
    }
    uXi.put(paramString1, paramString2);
    AppMethodBeat.o(6796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.at
 * JD-Core Version:    0.7.0.1
 */