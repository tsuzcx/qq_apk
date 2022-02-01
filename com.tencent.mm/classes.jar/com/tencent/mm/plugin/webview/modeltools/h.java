package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  public static ArrayList<String> WNp;
  
  public static void a(String paramString, List<String> paramList, CookieManager paramCookieManager)
  {
    AppMethodBeat.i(295811);
    if (!Util.isNullOrNil(paramList))
    {
      String str = Uri.parse(paramString).getHost();
      Object localObject = str.split("\\.");
      if (localObject.length <= 1) {}
      for (localObject = "";; localObject = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)])
      {
        Log.d("MicroMsg.WebView.SysWebViewDataCleanHelper", "host(%s)", new Object[] { str });
        Log.d("MicroMsg.WebView.SysWebViewDataCleanHelper", "domain(%s)", new Object[] { localObject });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!Util.isNullOrNil(str))
          {
            paramCookieManager.setCookie(paramString, str + "=");
            paramCookieManager.setCookie(paramString, str + "=;path=/");
            if (!Util.isNullOrNil((String)localObject)) {
              paramCookieManager.setCookie((String)localObject, str + "=;domain=." + (String)localObject + ";path=/");
            }
          }
        }
      }
    }
    AppMethodBeat.o(295811);
  }
  
  public static void bkP(String paramString)
  {
    AppMethodBeat.i(295815);
    if (WNp == null) {
      WNp = new ArrayList();
    }
    if (WNp.contains(paramString))
    {
      AppMethodBeat.o(295815);
      return;
    }
    WNp.add(paramString);
    AppMethodBeat.o(295815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */