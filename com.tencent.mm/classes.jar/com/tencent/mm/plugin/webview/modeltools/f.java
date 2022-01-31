package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.bv.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.c.bsj;
import com.tencent.mm.protocal.c.bsk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f
{
  private static String rid = null;
  
  public static Bundle M(Bundle paramBundle)
  {
    try
    {
      Object localObject = new bsj();
      ((bsj)localObject).tIU = paramBundle.getString("PickedWord");
      ((bsj)localObject).tIV = paramBundle.getString("PrefixText");
      ((bsj)localObject).tIW = paramBundle.getString("SuffixText");
      ((bsj)localObject).pyo = paramBundle.getInt("Scene");
      y.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", new Object[] { ((bsj)localObject).tIV, ((bsj)localObject).tIU, ((bsj)localObject).tIW });
      paramBundle = new b.a();
      paramBundle.ecH = ((a)localObject);
      paramBundle.ecI = new bsk();
      paramBundle.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
      paramBundle.ecG = 2974;
      paramBundle.ecJ = 0;
      paramBundle.ecK = 0;
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      localObject = new Bundle();
      b.a(paramBundle.Kt(), new f.1(localCountDownLatch, (Bundle)localObject));
      try
      {
        localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
        y.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
        return localObject;
      }
      catch (InterruptedException paramBundle)
      {
        for (;;)
        {
          y.w("MicroMsg.SmartPickWordHelper", paramBundle.getMessage());
          y.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramBundle, "", new Object[0]);
        }
      }
      return null;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
    }
  }
  
  public static boolean SG(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    String str = e.kvx;
    ((j)g.r(j.class)).a(ae.getContext(), 17, paramString, str);
    return false;
  }
  
  public static void SH(String paramString)
  {
    String str = "";
    try
    {
      paramString = URLEncoder.encode(bk.pm(paramString), "UTF-8");
      h.nFQ.f(13742, new Object[] { Integer.valueOf(1), paramString, "", "", Integer.valueOf(0) });
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString, "", new Object[0]);
        paramString = str;
      }
    }
  }
  
  public static void fw(String paramString1, String paramString2)
  {
    int j = 1;
    if ((!bk.bl(rid)) && (!bk.isEqual(paramString1, rid))) {}
    for (i = 1;; i = 0)
    {
      localObject = "";
      String str3 = "";
      str2 = "";
      String str1 = str3;
      try
      {
        paramString2 = URLEncoder.encode(bk.pm(paramString2), "UTF-8");
        str1 = str3;
        localObject = paramString2;
        paramString1 = URLEncoder.encode(bk.pm(paramString1), "UTF-8");
        str1 = paramString1;
        localObject = paramString2;
        str3 = URLEncoder.encode(bk.pm(rid), "UTF-8");
        localObject = str3;
        str1 = paramString1;
        paramString1 = (String)localObject;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SmartPickWordHelper", paramString1, "", new Object[0]);
          paramString1 = str2;
          paramString2 = (String)localObject;
          continue;
          i = 0;
        }
      }
      localObject = h.nFQ;
      if (i == 0) {
        break;
      }
      i = j;
      ((h)localObject).f(13742, new Object[] { Integer.valueOf(2), paramString2, paramString1, str1, Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.f
 * JD-Core Version:    0.7.0.1
 */