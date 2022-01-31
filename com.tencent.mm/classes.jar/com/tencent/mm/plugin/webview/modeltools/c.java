package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.c.h;
import com.tencent.xweb.u;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

public final class c
{
  public static final String uXq;
  private static ArrayList<String> uXr;
  
  static
  {
    AppMethodBeat.i(6925);
    uXq = Integer.toString(100028);
    AppMethodBeat.o(6925);
  }
  
  private static void a(String paramString, List<String> paramList, b paramb)
  {
    AppMethodBeat.i(6921);
    if (!bo.es(paramList))
    {
      String str = Uri.parse(paramString).getHost();
      Object localObject = str.split("\\.");
      if (localObject.length <= 1) {}
      for (localObject = "";; localObject = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)])
      {
        ab.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[] { str });
        ab.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[] { localObject });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!bo.isNullOrNil(str))
          {
            paramb.setCookie(paramString, str + "=");
            paramb.setCookie(paramString, str + "=;path=/");
            if (!bo.isNullOrNil((String)localObject)) {
              paramb.setCookie((String)localObject, str + "=;domain=." + (String)localObject + ";path=/");
            }
          }
        }
      }
    }
    AppMethodBeat.o(6921);
  }
  
  private static String ahy(String paramString)
  {
    AppMethodBeat.i(6924);
    String str;
    try
    {
      paramString = new URI(paramString);
      str = paramString.getScheme();
      if (bo.isNullOrNil(str))
      {
        AppMethodBeat.o(6924);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(6924);
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
      AppMethodBeat.o(6924);
      return paramString;
    }
  }
  
  public static void bM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(6923);
    if (!paramBoolean)
    {
      AppMethodBeat.o(6923);
      return;
    }
    if (uXr == null) {
      uXr = new ArrayList();
    }
    if (uXr.contains(paramString))
    {
      AppMethodBeat.o(6923);
      return;
    }
    uXr.add(paramString);
    AppMethodBeat.o(6923);
  }
  
  public static void c(d paramd)
  {
    AppMethodBeat.i(6919);
    try
    {
      paramd = paramd.i(24, new Bundle(0));
      if (paramd == null)
      {
        ab.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
        AppMethodBeat.o(6919);
        return;
      }
    }
    catch (RemoteException paramd)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", paramd, "", new Object[0]);
        paramd = null;
      }
      paramd = paramd.getStringArrayList("cookies_cleanup_url_list");
      if (bo.es(paramd))
      {
        ab.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
        AppMethodBeat.o(6919);
        return;
      }
      eg(paramd);
      com.tencent.xweb.c.jQ(ah.getContext());
      com.tencent.xweb.c.sync();
      ab.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
      AppMethodBeat.o(6919);
    }
  }
  
  public static void dcv()
  {
    AppMethodBeat.i(6922);
    if (uXr != null) {}
    for (int i = uXr.size();; i = 0)
    {
      ab.i("MicroMsg.WebView.CookiesCleanup", "clearWebViewData url list size %d", new Object[] { Integer.valueOf(i) });
      if (!bo.es(uXr)) {
        break;
      }
      AppMethodBeat.o(6922);
      return;
    }
    if (!bo.es(uXr))
    {
      eg(uXr);
      com.tencent.xweb.c.jQ(ah.getContext());
      com.tencent.xweb.c.sync();
      ab.i("MicroMsg.WebView.CookiesCleanup", "clearHostCookies end");
    }
    Iterator localIterator = uXr.iterator();
    while (localIterator.hasNext())
    {
      String str = ahy((String)localIterator.next());
      u localu = u.dYA();
      if (localu.BEb == null) {
        Log.e("WebStorage", "deleteOrigin failed webStg is null, cur core kind is " + WebView.getCurWebType());
      } else {
        localu.BEb.deleteOrigin(str);
      }
    }
    uXr.clear();
    AppMethodBeat.o(6922);
  }
  
  private static void eg(List<String> paramList)
  {
    AppMethodBeat.i(6920);
    b localb = b.dYg();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      ab.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[] { str1 });
      paramList = localb.getCookie(str1);
      if (bo.isNullOrNil(paramList)) {
        paramList = null;
      }
      for (;;)
      {
        a(str1, paramList, localb);
        break;
        paramList = paramList.split(";");
        int j = paramList.length;
        int i = 0;
        while (i < j)
        {
          paramList[i] = paramList[i].trim();
          i += 1;
        }
        LinkedList localLinkedList = new LinkedList();
        j = paramList.length;
        i = 0;
        while (i < j)
        {
          String str2 = paramList[i];
          if ((!bo.isNullOrNil(str2)) && (str2.contains("="))) {
            localLinkedList.add(str2.split("=")[0]);
          }
          i += 1;
        }
        paramList = localLinkedList;
        if (localLinkedList.isEmpty()) {
          paramList = null;
        }
      }
    }
    AppMethodBeat.o(6920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.c
 * JD-Core Version:    0.7.0.1
 */