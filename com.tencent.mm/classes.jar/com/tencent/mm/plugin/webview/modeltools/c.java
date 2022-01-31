package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
{
  public static final String rhR = Integer.toString(100028);
  
  private static void a(String paramString, List<String> paramList, b paramb)
  {
    if (!bk.dk(paramList))
    {
      String str = Uri.parse(paramString).getHost();
      Object localObject = str.split("\\.");
      if (localObject.length <= 1) {}
      for (localObject = "";; localObject = localObject[(localObject.length - 2)] + "." + localObject[(localObject.length - 1)])
      {
        y.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[] { str });
        y.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[] { localObject });
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!bk.bl(str))
          {
            paramb.setCookie(paramString, str + "=");
            paramb.setCookie(paramString, str + "=;path=/");
            if (!bk.bl((String)localObject)) {
              paramb.setCookie((String)localObject, str + "=;domain=." + (String)localObject + ";path=/");
            }
          }
        }
      }
    }
  }
  
  public static void d(d paramd)
  {
    try
    {
      paramd = paramd.f(24, new Bundle(0));
      if (paramd == null)
      {
        y.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
        return;
      }
    }
    catch (RemoteException paramd)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", paramd, "", new Object[0]);
        paramd = null;
      }
      paramd = paramd.getStringArrayList("cookies_cleanup_url_list");
      if (bk.dk(paramd))
      {
        y.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
        return;
      }
      dc(paramd);
      com.tencent.xweb.c.il(ae.getContext());
      com.tencent.xweb.c.sync();
      y.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
    }
  }
  
  private static void dc(List<String> paramList)
  {
    b localb = b.cSe();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      y.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[] { str1 });
      paramList = localb.getCookie(str1);
      if (bk.bl(paramList)) {
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
          if ((!bk.bl(str2)) && (str2.contains("="))) {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.c
 * JD-Core Version:    0.7.0.1
 */