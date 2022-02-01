package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.protocal.protobuf.dqv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
  private final int DXC;
  private final int DXD;
  private final int DXE;
  WebView DXF;
  public LinkedList<String> DXG;
  public String DXH;
  public String DXI;
  public int DXJ;
  public int DXK;
  public CountDownLatch DXL;
  public com.tencent.mm.sdk.b.c DXM;
  public p tipDialog;
  
  public c()
  {
    AppMethodBeat.i(77820);
    this.DXC = 0;
    this.DXD = 1;
    this.DXE = 2;
    this.DXF = null;
    this.DXG = null;
    this.DXH = null;
    this.DXI = null;
    this.DXJ = 0;
    this.DXK = 0;
    this.DXL = new CountDownLatch(1);
    this.DXM = new com.tencent.mm.sdk.b.c() {};
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
        ae.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", new Object[] { paramWebView.getMessage() });
        boolean bool = false;
      }
    }
    ae.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(77821);
    return bool;
  }
  
  private int j(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(77824);
    ae.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate in");
    this.DXF = paramWebView;
    try
    {
      paramWebView = new int[1];
      paramWebView[0] = 2;
      this.DXL = new CountDownLatch(1);
      try
      {
        m.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(77817);
            c.this.DXF.invokeMiscMethod("getTranslateSampleString", null);
            AppMethodBeat.o(77817);
          }
        });
        ae.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
        this.DXL.await(500L, TimeUnit.MILLISECONDS);
        ae.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
        paramWebView[0] = new j().g(this.DXG, paramString);
        ae.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate doScene end ret[0] = " + paramWebView[0]);
        int i = paramWebView[0];
        AppMethodBeat.o(77824);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ae.w("MicroMsg.WebViewTranslateHelper", localInterruptedException.getMessage());
          ae.printErrStackTrace("MicroMsg.WebViewTranslateHelper", localInterruptedException, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramWebView)
    {
      ae.e("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate failed");
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
    String str = ad.fom();
    localBundle.putString("destLanguage", str);
    if (paramBoolean) {
      localBundle.putBoolean("isFastOpen", true);
    }
    try
    {
      if (paramWebView.isXWalkKernel()) {}
      for (i = j(paramWebView, str);; i = paramWebView.getInt("errorCode", 2))
      {
        ae.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", new Object[] { Integer.valueOf(i), str });
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
        ae.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { paramWebView.getMessage() });
        label161:
        int i = 2;
      }
    }
  }
  
  public final void a(WebView paramWebView, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(182684);
    this.DXF = paramWebView;
    paramWebView = new LinkedList();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      dqv localdqv = new dqv();
      localdqv.HXP = bu.aSB(str1);
      localdqv.HXQ = str2;
      localdqv.Scene = 8;
      paramWebView.add(localdqv);
    }
    if (!new r().d(paramWebView, this.DXJ, this.DXK))
    {
      eQO();
      ae.d("MicroMsg.WebViewTranslateHelper", "translate: BatchGetTranslateString err !!!!");
    }
    AppMethodBeat.o(182684);
  }
  
  public final void eQO()
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