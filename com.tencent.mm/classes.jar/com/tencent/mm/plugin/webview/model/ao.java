package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class ao
{
  private static Map<String, String> rgU = new HashMap();
  
  public static String RR(String paramString)
  {
    y.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[] { paramString });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
      paramString = null;
      return paramString;
    }
    String str2 = (String)rgU.get(paramString);
    String str1 = str2;
    int i;
    if (bk.bl(str2))
    {
      i = paramString.indexOf("#");
      if (i >= 0) {
        break label90;
      }
    }
    label90:
    for (str1 = paramString;; str1 = paramString.substring(0, i))
    {
      str1 = (String)rgU.get(str1);
      if (bk.bl(str1)) {
        break;
      }
      return str1;
    }
  }
  
  public static void clear()
  {
    rgU.clear();
  }
  
  public static void fv(String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[] { paramString1, paramString2 });
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
      return;
    }
    if (rgU.containsKey(paramString1))
    {
      y.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
      return;
    }
    rgU.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ao
 * JD-Core Version:    0.7.0.1
 */