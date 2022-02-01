package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.d;
import com.tencent.xweb.internal.IWebStorage;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

public final class c
{
  public static final String DVp;
  private static ArrayList<String> DVq;
  
  static
  {
    AppMethodBeat.i(79119);
    DVp = Integer.toString(100028);
    AppMethodBeat.o(79119);
  }
  
  private static void a(String paramString, List<String> paramList, com.tencent.xweb.c paramc)
  {
    AppMethodBeat.i(79115);
    if (!bt.hj(paramList))
    {
      String str = Uri.parse(paramString).getHost();
      Object localObject = str.split("\\.");
      if (localObject.length <= 1) {}
      for (localObject = "";; localObject = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)])
      {
        ad.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[] { str });
        ad.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[] { localObject });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!bt.isNullOrNil(str))
          {
            paramc.setCookie(paramString, str + "=");
            paramc.setCookie(paramString, str + "=;path=/");
            if (!bt.isNullOrNil((String)localObject)) {
              paramc.setCookie((String)localObject, str + "=;domain=." + (String)localObject + ";path=/");
            }
          }
        }
      }
    }
    AppMethodBeat.o(79115);
  }
  
  private static String aHQ(String paramString)
  {
    AppMethodBeat.i(79118);
    String str;
    try
    {
      paramString = new URI(paramString);
      str = paramString.getScheme();
      if (bt.isNullOrNil(str))
      {
        AppMethodBeat.o(79118);
        return null;
      }
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", new Object[] { paramString.getMessage() });
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
  
  public static void cp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(79117);
    if (!paramBoolean)
    {
      AppMethodBeat.o(79117);
      return;
    }
    if (DVq == null) {
      DVq = new ArrayList();
    }
    if (DVq.contains(paramString))
    {
      AppMethodBeat.o(79117);
      return;
    }
    DVq.add(paramString);
    AppMethodBeat.o(79117);
  }
  
  public static void eQL()
  {
    AppMethodBeat.i(79116);
    if (DVq != null) {}
    for (int i = DVq.size();; i = 0)
    {
      ad.i("MicroMsg.WebView.CookiesCleanup", "clearWebViewData url list size %d", new Object[] { Integer.valueOf(i) });
      if (!bt.hj(DVq)) {
        break;
      }
      AppMethodBeat.o(79116);
      return;
    }
    Object localObject3;
    Object localObject2;
    if (!bt.hj(DVq))
    {
      localObject1 = DVq;
      localObject3 = com.tencent.xweb.c.gaw();
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        ad.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[] { str1 });
        localObject1 = ((com.tencent.xweb.c)localObject3).getCookie(str1);
        if (bt.isNullOrNil((String)localObject1)) {
          localObject1 = null;
        }
        for (;;)
        {
          a(str1, (List)localObject1, (com.tencent.xweb.c)localObject3);
          break;
          localObject1 = ((String)localObject1).split(";");
          int j = localObject1.length;
          i = 0;
          while (i < j)
          {
            localObject1[i] = localObject1[i].trim();
            i += 1;
          }
          localObject2 = new LinkedList();
          j = localObject1.length;
          i = 0;
          while (i < j)
          {
            String str2 = localObject1[i];
            if ((!bt.isNullOrNil(str2)) && (str2.contains("="))) {
              ((List)localObject2).add(str2.split("=")[0]);
            }
            i += 1;
          }
          localObject1 = localObject2;
          if (((List)localObject2).isEmpty()) {
            localObject1 = null;
          }
        }
      }
      d.lv(aj.getContext());
      d.sync();
      ad.i("MicroMsg.WebView.CookiesCleanup", "clearHostCookies end");
    }
    Object localObject1 = DVq.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = aHQ((String)((Iterator)localObject1).next());
      localObject3 = aa.gbe();
      if (((aa)localObject3).Mqe == null) {
        Log.e("WebStorage", "deleteOrigin failed webStg is null, cur core kind is " + WebView.getCurWebType());
      } else {
        ((aa)localObject3).Mqe.deleteOrigin((String)localObject2);
      }
    }
    DVq.clear();
    AppMethodBeat.o(79116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.c
 * JD-Core Version:    0.7.0.1
 */