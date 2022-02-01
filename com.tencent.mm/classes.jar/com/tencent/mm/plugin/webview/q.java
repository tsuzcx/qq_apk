package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.protocal.protobuf.fqj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vending.c.a;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class q
{
  private final int WvN;
  private final int WvO;
  private final int WvP;
  WebView WvQ;
  public LinkedList<String> WvR;
  public String WvS;
  public String WvT;
  public int WvU;
  public int WvV;
  public CountDownLatch WvW;
  public IListener WvX;
  public w tipDialog;
  
  public q()
  {
    AppMethodBeat.i(77820);
    this.WvN = 0;
    this.WvO = 1;
    this.WvP = 2;
    this.WvQ = null;
    this.WvR = null;
    this.WvS = null;
    this.WvT = null;
    this.WvU = 0;
    this.WvV = 0;
    this.WvW = new CountDownLatch(1);
    this.WvX = new WebViewTranslateHelper.4(this, f.hfK);
    AppMethodBeat.o(77820);
  }
  
  public static boolean b(WebView paramWebView)
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
        Log.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", new Object[] { paramWebView.getMessage() });
        boolean bool = false;
      }
    }
    Log.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(77821);
    return bool;
  }
  
  private int k(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(77824);
    Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate in");
    this.WvQ = paramWebView;
    try
    {
      paramWebView = new int[1];
      paramWebView[0] = 2;
      this.WvW = new CountDownLatch(1);
      try
      {
        o.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(77817);
            q.this.WvQ.invokeMiscMethod("getTranslateSampleString", null);
            AppMethodBeat.o(77817);
          }
        });
        Log.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
        this.WvW.await(500L, TimeUnit.MILLISECONDS);
        Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
        paramWebView[0] = new j().h(this.WvR, paramString);
        Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate doScene end ret[0] = " + paramWebView[0]);
        int i = paramWebView[0];
        AppMethodBeat.o(77824);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.w("MicroMsg.WebViewTranslateHelper", localInterruptedException.getMessage());
          Log.printErrStackTrace("MicroMsg.WebViewTranslateHelper", localInterruptedException, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramWebView)
    {
      Log.e("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate failed");
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
    String str = LocaleUtil.getApplicationLanguage();
    localBundle.putString("destLanguage", str);
    if (paramBoolean) {
      localBundle.putBoolean("isFastOpen", true);
    }
    try
    {
      if (paramWebView.isXWalkKernel()) {}
      for (i = k(paramWebView, str);; i = paramWebView.getInt("errorCode", 2))
      {
        Log.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(77822);
        return i;
        localBundle.putBoolean("isFastOpen", false);
        break;
        paramWebView = paramWebView.invokeMiscMethod("detectTranslateWebSiteIsNeeded", localBundle);
        if (paramWebView == null) {
          break label164;
        }
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { paramWebView.getMessage() });
        label164:
        int i = 2;
      }
    }
  }
  
  public final void a(WebView paramWebView, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(182684);
    this.WvQ = paramWebView;
    paramWebView = new LinkedList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      fqj localfqj = new fqj();
      localfqj.abQm = Util.safeParseInt(str1);
      localfqj.abQn = str2;
      localfqj.IJG = 8;
      paramWebView.add(localfqj);
    }
    if (!new r().d(paramWebView, this.WvU, this.WvV))
    {
      irA();
      Log.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
    }
    AppMethodBeat.o(182684);
  }
  
  public final void irA()
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
 * Qualified Name:     com.tencent.mm.plugin.webview.q
 * JD-Core Version:    0.7.0.1
 */