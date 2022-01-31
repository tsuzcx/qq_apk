package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import java.io.File;

public final class a
{
  ViewGroup MO;
  MMWebView foJ;
  Context mContext;
  c nkG;
  long nkH;
  g nkK;
  String nkp;
  GameWebPerformanceInfo nkv;
  com.tencent.mm.plugin.webview.stub.d viZ;
  GameWebViewUI vmn;
  private h vmo;
  com.tencent.mm.plugin.webview.ui.tools.jsapi.d vmp;
  com.tencent.mm.plugin.wepkg.c vmq;
  b vmr;
  private a.a vms;
  f vmt;
  private boolean vmu;
  m vmv;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(8673);
    this.nkG = new a.1(this);
    this.vmv = new a.4(this);
    this.nkv = GameWebPerformanceInfo.lO(paramString);
    this.nkv.url = paramString;
    this.nkv.ezP = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.nkv.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.nkv.eAa = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.nkv.eAf = l;
    this.nkv.eAh = l;
    this.nkK = g.aiN(paramString);
    this.nkK.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.vmn = paramGameWebViewUI;
    this.MO = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.fD(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.vmr = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.vmr);
    this.vms = new a.a(this, (MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.vms);
    ab.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.vmr.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new a.c(this, (byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().dYx();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().dYs();
    paramViewGroup.getSettings().dYr();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().dYz();
    paramViewGroup.getSettings().dYv();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().dYu();
    paramViewGroup.getSettings().dYw();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eQu + "databases/");
    com.tencent.xweb.b.dYg().dYh();
    com.tencent.xweb.b.dYg().f(paramViewGroup);
    this.foJ = paramViewGroup;
    this.vmo = new h(paramGameWebViewUI.getIntent());
    this.vmq = new com.tencent.mm.plugin.wepkg.c();
    this.vmq.vEF = new a.2(this);
    this.nkv.eAi = System.currentTimeMillis();
    this.nkK.vmX = System.currentTimeMillis();
    AppMethodBeat.o(8673);
  }
  
  final int dT(String paramString, int paramInt)
  {
    AppMethodBeat.i(8674);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.viZ != null) {
        break label59;
      }
      i = 1;
    }
    for (;;)
    {
      ab.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(8674);
      return i;
      try
      {
        label59:
        if (this.viZ.oD(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.viZ.nU(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
        i = 1;
      }
      continue;
      label137:
      i = 0;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(8675);
    if (!this.vmu)
    {
      ab.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.vmu = true;
      c.a(this.nkG.vmB.vmC);
      this.vmq.oW(true);
      if (this.foJ != null)
      {
        this.foJ.setWebViewClient(null);
        this.foJ.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.nkv;
      localGameWebPerformanceInfo.eAp += System.currentTimeMillis() - this.nkH;
      this.nkv.eAq = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.ezM.a(this.nkv);
      GameWebPerformanceInfo.lP(this.nkp);
      e.aiM(this.nkp);
      g.aiP(this.nkp);
    }
    AppMethodBeat.o(8675);
  }
  
  final class b
    extends b
  {
    public b(MMWebView paramMMWebView)
    {
      super();
    }
    
    public final void PW(String paramString)
    {
      AppMethodBeat.i(8662);
      if (a.this.vmq.dkj())
      {
        this.foJ.loadUrl(paramString);
        AppMethodBeat.o(8662);
        return;
      }
      super.PW(paramString);
      AppMethodBeat.o(8662);
    }
    
    public final s a(WebView paramWebView, r paramr)
    {
      AppMethodBeat.i(8667);
      if ((paramr == null) || (paramr.getUrl() == null))
      {
        paramWebView = super.a(paramWebView, paramr);
        AppMethodBeat.o(8667);
        return paramWebView;
      }
      s locals = a.this.vmq.akj(paramr.getUrl().toString());
      if (locals != null)
      {
        AppMethodBeat.o(8667);
        return locals;
      }
      paramWebView = super.a(paramWebView, paramr);
      AppMethodBeat.o(8667);
      return paramWebView;
    }
    
    public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
    {
      AppMethodBeat.i(8668);
      if ((paramr == null) || (paramr.getUrl() == null))
      {
        paramWebView = super.a(paramWebView, paramr);
        AppMethodBeat.o(8668);
        return paramWebView;
      }
      s locals = a.this.vmq.akj(paramr.getUrl().toString());
      if (locals != null)
      {
        AppMethodBeat.o(8668);
        return locals;
      }
      paramWebView = super.a(paramWebView, paramr, paramBundle);
      AppMethodBeat.o(8668);
      return paramWebView;
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.d paramd, k paramk)
    {
      a.this.viZ = paramd;
    }
    
    public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
    {
      AppMethodBeat.i(8659);
      ab.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.vmp = paramd;
      AppMethodBeat.o(8659);
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(8660);
      ab.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.vmt = paramf;
      AppMethodBeat.o(8660);
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(8657);
      long l = System.currentTimeMillis();
      ab.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.nkv.eAl == 0L) {
        a.this.nkv.eAl = l;
      }
      if (a.this.nkK.vmY == 0L) {
        a.this.nkK.vmY = l;
      }
      a.this.nkG.vmB.dgb();
      a.this.vmq.k(paramWebView, paramString);
      AppMethodBeat.o(8657);
    }
    
    public final m aGm()
    {
      return a.this.vmv;
    }
    
    public final boolean aiJ(String paramString)
    {
      AppMethodBeat.i(8663);
      boolean bool = super.aiJ(paramString);
      AppMethodBeat.o(8663);
      return bool;
    }
    
    public final void aiK(String paramString)
    {
      AppMethodBeat.i(8664);
      try
      {
        ab.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.MO.removeView(this.foJ);
        AppMethodBeat.o(8664);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(8664);
      }
    }
    
    public final boolean aip(String paramString)
    {
      AppMethodBeat.i(8661);
      boolean bool = a.this.vmq.akk(paramString);
      AppMethodBeat.o(8661);
      return bool;
    }
    
    public final boolean av(Bundle paramBundle)
    {
      AppMethodBeat.i(8671);
      long l = System.currentTimeMillis();
      if (a.this.nkv.eAo == 0L) {
        a.this.nkv.eAo = l;
      }
      if (a.this.nkK.vnb == 0L) {
        a.this.nkK.vnb = l;
      }
      boolean bool = super.av(paramBundle);
      AppMethodBeat.o(8671);
      return bool;
    }
    
    public final void bP(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(8670);
      long l = System.currentTimeMillis();
      if (a.this.nkv.eAn == 0L) {
        a.this.nkv.eAn = l;
      }
      if (a.this.nkK.vna == 0L) {
        a.this.nkK.vna = l;
      }
      super.bP(paramString, paramBoolean);
      AppMethodBeat.o(8670);
    }
    
    public final s c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(8666);
      s locals = a.this.vmq.akj(paramString);
      if (locals != null)
      {
        AppMethodBeat.o(8666);
        return locals;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(8666);
      return paramWebView;
    }
    
    public final void dfW()
    {
      AppMethodBeat.i(8665);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.foJ.removeJavascriptInterface("MicroMsg");
        this.foJ.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.foJ.setWebChromeClient(null);
        this.foJ.setWebViewClient(null);
        this.foJ.setOnTouchListener(null);
        this.foJ.setOnLongClickListener(null);
        this.foJ.setVisibility(8);
        this.foJ.removeAllViews();
        this.foJ.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.foJ.destroy();
            AppMethodBeat.o(8665);
            return;
          }
          catch (Exception localException2)
          {
            ab.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
            AppMethodBeat.o(8665);
          }
          localException1 = localException1;
          ab.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
        }
      }
    }
    
    public final void dfX()
    {
      AppMethodBeat.i(8669);
      a.this.nkv.eAk = System.currentTimeMillis();
      super.dfX();
      AppMethodBeat.o(8669);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(8658);
      long l = System.currentTimeMillis();
      ab.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.nkv.eAm == 0L) {
        a.this.nkv.eAm = l;
      }
      if (a.this.nkK.vmZ == 0L) {
        a.this.nkK.vmZ = l;
      }
      if (a.this.nkv.eAg == 0L)
      {
        a.this.nkv.eAg = l;
        a.this.nkH = l;
      }
      this.foJ.setVisibility(0);
      a.this.vmq.l(paramWebView, paramString);
      a.this.nkG.vmB.uG();
      AppMethodBeat.o(8658);
    }
    
    public final String getSource()
    {
      return h.cGT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a
 * JD-Core Version:    0.7.0.1
 */