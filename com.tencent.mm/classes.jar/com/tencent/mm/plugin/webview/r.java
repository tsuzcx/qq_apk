package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.zi;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.protocal.protobuf.euw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.vending.c.a;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class r
{
  private final int PFn;
  private final int PFo;
  private final int PFp;
  WebView PFq;
  public LinkedList<String> PFr;
  public String PFs;
  public String PFt;
  public int PFu;
  public int PFv;
  public CountDownLatch PFw;
  public IListener PFx;
  public s tipDialog;
  
  public r()
  {
    AppMethodBeat.i(77820);
    this.PFn = 0;
    this.PFo = 1;
    this.PFp = 2;
    this.PFq = null;
    this.PFr = null;
    this.PFs = null;
    this.PFt = null;
    this.PFu = 0;
    this.PFv = 0;
    this.PFw = new CountDownLatch(1);
    this.PFx = new IListener() {};
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
    this.PFq = paramWebView;
    try
    {
      paramWebView = new int[1];
      paramWebView[0] = 2;
      this.PFw = new CountDownLatch(1);
      try
      {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(77817);
            r.this.PFq.invokeMiscMethod("getTranslateSampleString", null);
            AppMethodBeat.o(77817);
          }
        });
        Log.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
        this.PFw.await(500L, TimeUnit.MILLISECONDS);
        Log.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
        paramWebView[0] = new j().i(this.PFr, paramString);
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
          break label163;
        }
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        Log.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { paramWebView.getMessage() });
        label163:
        int i = 2;
      }
    }
  }
  
  public final void a(WebView paramWebView, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(182684);
    this.PFq = paramWebView;
    paramWebView = new LinkedList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      euw localeuw = new euw();
      localeuw.UwE = Util.safeParseInt(str1);
      localeuw.UwF = str2;
      localeuw.CPw = 8;
      paramWebView.add(localeuw);
    }
    if (!new com.tencent.mm.plugin.webview.model.r().d(paramWebView, this.PFu, this.PFv))
    {
      gSg();
      Log.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
    }
    AppMethodBeat.o(182684);
  }
  
  public final void gSg()
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
 * Qualified Name:     com.tencent.mm.plugin.webview.r
 * JD-Core Version:    0.7.0.1
 */