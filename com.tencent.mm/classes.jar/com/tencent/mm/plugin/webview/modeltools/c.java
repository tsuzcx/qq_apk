package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ao;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static ArrayList<String> WNp;
  
  public static void O(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(295821);
    if (!Util.isNullOrNil(paramList))
    {
      String str = Uri.parse(paramString).getHost();
      Object localObject = str.split("\\.");
      if (localObject.length <= 1) {}
      for (localObject = "";; localObject = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)])
      {
        Log.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[] { str });
        Log.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[] { localObject });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!Util.isNullOrNil(str))
          {
            ao.setCookie(paramString, str + "=");
            ao.setCookie(paramString, str + "=;path=/");
            if (!Util.isNullOrNil((String)localObject)) {
              ao.setCookie((String)localObject, str + "=;domain=." + (String)localObject + ";path=/");
            }
          }
        }
      }
    }
    AppMethodBeat.o(295821);
  }
  
  public static String bkL(String paramString)
  {
    AppMethodBeat.i(79118);
    String str;
    try
    {
      paramString = new URI(paramString);
      str = paramString.getScheme();
      if (Util.isNullOrNil(str))
      {
        AppMethodBeat.o(79118);
        return null;
      }
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(79118);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(str);
    localStringBuilder.append("://");
    localStringBuilder.append(paramString.getHost());
    int i = paramString.getPort();
    if ((i == -1) || ((str.equalsIgnoreCase("http")) && (i == 80)) || ((str.equalsIgnoreCase("https")) && (i == 443))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localStringBuilder.append(":");
        localStringBuilder.append(paramString.getPort());
      }
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(79118);
      return paramString;
    }
  }
  
  public static void dI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79117);
    if (!paramBoolean)
    {
      AppMethodBeat.o(79117);
      return;
    }
    if (WNp == null) {
      WNp = new ArrayList();
    }
    if (WNp.contains(paramString))
    {
      AppMethodBeat.o(79117);
      return;
    }
    WNp.add(paramString);
    AppMethodBeat.o(79117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.c
 * JD-Core Version:    0.7.0.1
 */