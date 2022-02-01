package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vending.c.a;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class c
{
  private final int AKo;
  private final int AKp;
  private final int AKq;
  WebView AKr;
  public LinkedList<String> AKs;
  public String AKt;
  public String AKu;
  public int AKv;
  public int AKw;
  public CountDownLatch AKx;
  public com.tencent.mm.sdk.b.c AKy;
  public p tipDialog;
  
  public c()
  {
    AppMethodBeat.i(77820);
    this.AKo = 0;
    this.AKp = 1;
    this.AKq = 2;
    this.AKr = null;
    this.AKs = null;
    this.AKt = null;
    this.AKu = null;
    this.AKv = 0;
    this.AKw = 0;
    this.AKx = new CountDownLatch(1);
    this.AKy = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(77820);
  }
  
  public static boolean a(WebView paramWebView)
  {
    AppMethodBeat.i(77821);
    if ((paramWebView == null) || (paramWebView.isSysKernel()))
    {
      AppMethodBeat.o(77821);
      return false;
    }
    try
    {
      paramWebView = paramWebView.invokeMiscMethod("supportTranslateWebSite", null);
      if (paramWebView == null) {
        break label86;
      }
      bool = paramWebView.getBoolean("result");
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", new Object[] { paramWebView.getMessage() });
        boolean bool = false;
      }
    }
    ad.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(77821);
    return bool;
  }
  
  private int i(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(77824);
    ad.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate in");
    this.AKr = paramWebView;
    try
    {
      paramWebView = new int[1];
      paramWebView[0] = 2;
      this.AKx = new CountDownLatch(1);
      try
      {
        l.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(77817);
            c.this.AKr.invokeMiscMethod("getTranslateSampleString", null);
            AppMethodBeat.o(77817);
          }
        });
        ad.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
        this.AKx.await(500L, TimeUnit.MILLISECONDS);
        ad.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
        paramWebView[0] = new j().f(this.AKs, paramString);
        ad.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate doScene end ret[0] = " + paramWebView[0]);
        int i = paramWebView[0];
        AppMethodBeat.o(77824);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ad.w("MicroMsg.WebViewTranslateHelper", localInterruptedException.getMessage());
          ad.printErrStackTrace("MicroMsg.WebViewTranslateHelper", localInterruptedException, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramWebView)
    {
      ad.e("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate failed");
      AppMethodBeat.o(77824);
    }
  }
  
  public final int a(WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(77822);
    if ((paramWebView == null) || (paramWebView.isSysKernel()))
    {
      AppMethodBeat.o(77822);
      return 2;
    }
    Bundle localBundle = new Bundle();
    String str = ac.eFu();
    localBundle.putString("destLanguage", str);
    if (paramBoolean) {
      localBundle.putBoolean("isFastOpen", true);
    }
    try
    {
      if (paramWebView.isXWalkKernel()) {}
      for (i = i(paramWebView, str);; i = paramWebView.getInt("errorCode", 2))
      {
        ad.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(77822);
        return i;
        localBundle.putBoolean("isFastOpen", false);
        break;
        paramWebView = paramWebView.invokeMiscMethod("detectTranslateWebSiteIsNeeded", localBundle);
        if (paramWebView == null) {
          break label161;
        }
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ad.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { paramWebView.getMessage() });
        label161:
        int i = 2;
      }
    }
  }
  
  public final void a(WebView paramWebView, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(182684);
    this.AKr = paramWebView;
    paramWebView = new LinkedList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      des localdes = new des();
      localdes.Ewl = bt.aGh(str1);
      localdes.Ewm = str2;
      localdes.Scene = 8;
      paramWebView.add(localdes);
    }
    if (!new r().a(paramWebView, this.AKv, this.AKw))
    {
      eiS();
      ad.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
    }
    AppMethodBeat.o(182684);
  }
  
  public final void eiS()
  {
    AppMethodBeat.i(77823);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(77823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c
 * JD-Core Version:    0.7.0.1
 */