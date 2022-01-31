package com.tencent.mm.plugin.webview;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;
import com.tencent.xweb.WebView;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  public p tipDialog;
  private final int uNE;
  private final int uNF;
  private final int uNG;
  public WebView uNH;
  public LinkedList<String> uNI;
  public String uNJ;
  public String uNK;
  public int uNL;
  public int uNM;
  public CountDownLatch uNN;
  public c uNO;
  
  public b()
  {
    AppMethodBeat.i(153068);
    this.uNE = 0;
    this.uNF = 1;
    this.uNG = 2;
    this.uNH = null;
    this.uNI = null;
    this.uNJ = null;
    this.uNK = null;
    this.uNL = 0;
    this.uNM = 0;
    this.uNN = new CountDownLatch(1);
    this.uNO = new b.4(this);
    AppMethodBeat.o(153068);
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(5619);
    if ((paramWebView == null) || (paramWebView.isSysKernel()))
    {
      AppMethodBeat.o(5619);
      return false;
    }
    try
    {
      paramWebView = paramWebView.invokeMiscMethod("supportTranslateWebSite", null);
      if (paramWebView == null) {
        break label89;
      }
      bool = paramWebView.getBoolean("result");
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ab.e("MicroMsg.WebViewTranslateHelper", "supportTranslateWebSite error %s", new Object[] { paramWebView.getMessage() });
        boolean bool = false;
      }
    }
    ab.i("MicroMsg.WebViewTranslateHelper", "supportTranslate %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(5619);
    return bool;
  }
  
  private int i(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(153070);
    ab.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate in");
    this.uNH = paramWebView;
    try
    {
      paramWebView = new int[1];
      paramWebView[0] = 2;
      this.uNN = new CountDownLatch(1);
      try
      {
        m.runOnUiThread(new b.3(this));
        ab.i("MicroMsg.WebViewTranslateHelper", "invokeMiscMethod getTranslateSampleString begin");
        this.uNN.await(500L, TimeUnit.MILLISECONDS);
        ab.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate end");
        paramWebView[0] = new h().f(this.uNI, paramString);
        ab.i("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate doScene end ret[0] = " + paramWebView[0]);
        int i = paramWebView[0];
        AppMethodBeat.o(153070);
        return i;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ab.w("MicroMsg.WebViewTranslateHelper", localInterruptedException.getMessage());
          ab.printErrStackTrace("MicroMsg.WebViewTranslateHelper", localInterruptedException, "", new Object[0]);
        }
      }
      return 2;
    }
    catch (Exception paramWebView)
    {
      ab.e("MicroMsg.WebViewTranslateHelper", "xWalkNeedTranslate failed");
      AppMethodBeat.o(153070);
    }
  }
  
  public final int a(WebView paramWebView, boolean paramBoolean)
  {
    AppMethodBeat.i(5620);
    if ((paramWebView == null) || (paramWebView.isSysKernel()))
    {
      AppMethodBeat.o(5620);
      return 2;
    }
    Bundle localBundle = new Bundle();
    String str = aa.dsG();
    localBundle.putString("destLanguage", str);
    if (paramBoolean) {
      localBundle.putBoolean("isFastOpen", true);
    }
    try
    {
      if (paramWebView.isXWalkKernel()) {}
      for (i = i(paramWebView, str);; i = paramWebView.getInt("errorCode", 2))
      {
        ab.i("MicroMsg.WebViewTranslateHelper", "needTranslate errCode %d,languageCode %s", new Object[] { Integer.valueOf(i), str });
        AppMethodBeat.o(5620);
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
        ab.e("MicroMsg.WebViewTranslateHelper", "detectTranslateWebSiteIsNeeded error %s", new Object[] { paramWebView.getMessage() });
        label163:
        int i = 2;
      }
    }
  }
  
  public final void dau()
  {
    AppMethodBeat.i(153069);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(153069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.b
 * JD-Core Version:    0.7.0.1
 */