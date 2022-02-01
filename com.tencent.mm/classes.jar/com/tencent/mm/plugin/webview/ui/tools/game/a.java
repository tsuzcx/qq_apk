package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  GameWebViewUI CEI;
  private i CEJ;
  com.tencent.mm.plugin.webview.stub.e CEK;
  f CEL;
  com.tencent.mm.plugin.wepkg.c CEM;
  b CEN;
  private a CEO;
  com.tencent.mm.plugin.webview.c.i CEP;
  m CEQ;
  ViewGroup UK;
  MMWebView hqK;
  Context mContext;
  String sXV;
  GameWebPerformanceInfo sYb;
  c sYm;
  long sYn;
  h sYo;
  private boolean zjc;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.sYm = new c()
    {
      protected final void ad(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((a.this.CEK != null) && (paramAnonymousBundle != null)) {
            a.this.CEK.k(96, paramAnonymousBundle);
          }
          AppMethodBeat.o(80818);
          return;
        }
        catch (RemoteException paramAnonymousBundle)
        {
          AppMethodBeat.o(80818);
        }
      }
    };
    this.CEQ = new m()
    {
      public final void aD(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        ac.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          a.this.UK.removeView(a.this.hqK);
          a.this.onDestroy();
          AppMethodBeat.o(80825);
          return;
        }
        catch (Exception paramAnonymousBundle)
        {
          AppMethodBeat.o(80825);
        }
      }
      
      public final Bundle k(final int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80826);
        ac.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(paramAnonymousInt)));
        final Bundle localBundle = new Bundle();
        switch (paramAnonymousInt)
        {
        default: 
          ac.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
        }
        for (;;)
        {
          AppMethodBeat.o(80826);
          return localBundle;
          paramAnonymousBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
          com.tencent.mm.br.d.b(a.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", i.dvr));
          continue;
          localBundle.putString("KPublisherId", i.dvr);
          localBundle.putInt("getA8KeyScene", a.this.fu(i.CGq, i.dCr));
          continue;
          paramAnonymousInt = i.dCr;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          ac.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (a.this.CEK.isSDCardAvailable())
          {
            long l = bh.eVQ();
            ac.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              ac.e("MicroMsg.GameFloatWebView", "available size not enough");
              label418:
              paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
            }
          }
          boolean bool;
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramAnonymousInt);
            break;
            paramAnonymousBundle = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.webview.a.CcB);
            bool = true;
            if (!paramAnonymousBundle.exists())
            {
              bool = paramAnonymousBundle.mkdirs();
              ac.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { com.tencent.mm.vfs.q.B(paramAnonymousBundle.fxV()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(paramAnonymousBundle.fxV()), false));
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            ac.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
          }
          Object localObject1 = paramAnonymousBundle.getString("webview_video_proxy_cdn_urls");
          Object localObject2 = paramAnonymousBundle.getString("webview_video_proxy_fileId");
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_file_size");
          int i = paramAnonymousBundle.getInt("webview_video_proxy_file_duration");
          int j = paramAnonymousBundle.getInt("webview_video_proxy_file_type");
          int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramAnonymousInt, i);
          paramAnonymousBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
          ac.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousBundle });
          localBundle.putInt("webview_video_proxy_play_data_id", k);
          localBundle.putString("webview_video_proxy_local_url", paramAnonymousBundle);
          continue;
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
          ac.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt > 0)
          {
            FactoryProxyManager.getPlayManager().stopPlay(paramAnonymousInt);
            continue;
            paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_state");
            FactoryProxyManager.getPlayManager().setPlayerState(paramAnonymousInt);
            continue;
            paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_net_state");
            FactoryProxyManager.getPlayManager().setNetWorkState(paramAnonymousInt);
            continue;
            paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
            i = paramAnonymousBundle.getInt("webview_video_proxy_play_remain_time");
            FactoryProxyManager.getPlayManager().setRemainTime(paramAnonymousInt, i);
            continue;
            paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
            i = paramAnonymousBundle.getInt("webview_video_proxy_preload_duration");
            ac.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
            localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramAnonymousInt, i));
            continue;
            localObject1 = paramAnonymousBundle.getString("show_kb_placeholder");
            paramAnonymousInt = paramAnonymousBundle.getInt("show_kb_max_length");
            a.this.CEI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                a.this.CEI.ft(this.CyC, paramAnonymousInt);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            a.this.CEI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = a.this.CEI.eDX();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.fr(paramAnonymousBundle.getString("set_page_title_color"), a.this.CEI.getResources().getColor(2131099874));
            a.this.CEI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.cNi != null) {
                  a.this.CEI.setMMTitle(this.cNi);
                }
                a.this.CEI.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            ac.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.cq.d.bt(paramAnonymousBundle);
            continue;
            a.this.CEI.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                a.this.CEI.aJ(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.fJa().getCookie(paramAnonymousBundle);
            ac.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cc.a.getDensity(a.this.CEI));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            k.Cya.kC((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = a.this.CEI.getMMTitle();
            localObject1 = getCurrentUrl();
            localBundle.putString("webview_current_url", (String)localObject1);
            if (paramAnonymousBundle != null) {}
            for (paramAnonymousBundle = paramAnonymousBundle.toString();; paramAnonymousBundle = "")
            {
              localBundle.putString("webview_current_title", paramAnonymousBundle);
              localBundle.putString("webview_current_desc", (String)localObject1);
              break;
            }
            bool = paramAnonymousBundle.getBoolean("add_shortcut_status");
            if (a.this.CEL != null)
            {
              a.this.CEL.uj(bool);
              continue;
              bool = a.this.CEN.eGv();
              paramAnonymousBundle = a.this.CEN.eAr();
              localObject1 = a.this.CEN.eGw();
              if (bool)
              {
                localBundle.putString("result", "not_return");
              }
              else
              {
                localBundle.putString("full_url", bs.nullAsNil(paramAnonymousBundle));
                if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                {
                  localBundle.putInt("set_cookie", 1);
                  com.tencent.xweb.d.li(ai.getContext());
                  localObject2 = com.tencent.xweb.c.fJa();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bs.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.fJc();
                  com.tencent.xweb.d.sync();
                  ac.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bs.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  a.this.sYm.CEW.aU(paramAnonymousBundle);
                  ac.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  a.this.sYb.fYP = 1;
                  a.this.sYo.CFK = System.currentTimeMillis();
                  continue;
                  a.this.sYo.CFL = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.sYb = GameWebPerformanceInfo.tr(paramString);
    this.sYb.url = paramString;
    this.sYb.fYI = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.sYb.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.sYb.fYT = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.sYb.fYY = l;
    this.sYb.fZa = l;
    this.sYo = h.aDB(paramString);
    this.sYo.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.CEI = paramGameWebViewUI;
    this.UK = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.gU(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.CEN = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.CEN);
    this.CEO = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.CEO);
    ac.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.CEN.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().fJH();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().fJA();
    paramViewGroup.getSettings().fJz();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().fJJ();
    paramViewGroup.getSettings().fJF();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().fJE();
    paramViewGroup.getSettings().fJG();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
    com.tencent.xweb.c.fJa().fJb();
    com.tencent.xweb.c.fJa().e(paramViewGroup);
    this.hqK = paramViewGroup;
    this.CEJ = new i(paramGameWebViewUI.getIntent());
    this.CEM = new com.tencent.mm.plugin.wepkg.c();
    this.CEM.CZv = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void cOX()
      {
        AppMethodBeat.i(80819);
        ac.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { a.this.sXV });
        if ((a.this.hqK != null) && (a.this.hqK.getParent() != null) && (a.this.CEN != null) && (!bs.isNullOrNil(a.this.sXV)))
        {
          a.this.hqK.stopLoading();
          a.this.hqK.loadUrl(a.this.CEN.eAr());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.sYb.fZb = System.currentTimeMillis();
    this.sYo.CFF = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int fu(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.CEK != null) {
        break label59;
      }
      i = 1;
    }
    for (;;)
    {
      ac.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(80845);
      return i;
      try
      {
        label59:
        if (this.CEK.xr(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.CEK.wH(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        ac.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
        i = 1;
      }
      continue;
      label137:
      i = 0;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80846);
    if (!this.zjc)
    {
      ac.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.zjc = true;
      c.a(this.sYm.CEW.CEX);
      this.CEM.uO(true);
      if (this.hqK != null)
      {
        this.hqK.setWebViewClient(null);
        this.hqK.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.sYb;
      localGameWebPerformanceInfo.fZi += System.currentTimeMillis() - this.sYn;
      this.sYb.fZj = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.fYF.a(this.sYb);
      GameWebPerformanceInfo.ts(this.sXV);
      h.aDE(this.sXV);
    }
    AppMethodBeat.o(80846);
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.ui.tools.widget.i
  {
    a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
    {
      super();
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(80827);
      if (a.this.CEM != null) {
        a.this.CEM.a(paramConsoleMessage);
      }
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(80827);
      return bool;
    }
  }
  
  final class b
    extends b
  {
    public b(MMWebView paramMMWebView)
    {
      super();
    }
    
    public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(80838);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        paramWebView = super.a(paramWebView, paramWebResourceRequest);
        AppMethodBeat.o(80838);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = a.this.CEM.aET(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80838);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(80838);
      return paramWebView;
    }
    
    public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
    {
      AppMethodBeat.i(80839);
      if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      {
        paramWebView = super.a(paramWebView, paramWebResourceRequest);
        AppMethodBeat.o(80839);
        return paramWebView;
      }
      WebResourceResponse localWebResourceResponse = a.this.CEM.aET(paramWebResourceRequest.getUrl().toString());
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80839);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(80839);
      return paramWebView;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(188551);
      ac.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.CEL = paramf;
      AppMethodBeat.o(188551);
    }
    
    public final void a(com.tencent.mm.plugin.webview.c.i parami)
    {
      AppMethodBeat.i(188552);
      ac.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.CEP = parami;
      AppMethodBeat.o(188552);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, g paramg)
    {
      a.this.CEK = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      ac.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.sYb.fZe == 0L) {
        a.this.sYb.fZe = l;
      }
      if (a.this.sYo.CFG == 0L) {
        a.this.sYo.CFG = l;
      }
      a.this.sYm.CEW.eFr();
      a.this.CEM.o(paramWebView, paramString);
      AppMethodBeat.o(80828);
    }
    
    public final boolean aDx(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = a.this.CEM.aEU(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean aDy(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.aDy(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void aDz(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        ac.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.UK.removeView(this.hqK);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final boolean aS(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (a.this.sYb.fZh == 0L) {
        a.this.sYb.fZh = l;
      }
      if (a.this.sYo.CFJ == 0L) {
        a.this.sYo.CFJ = l;
      }
      boolean bool = super.aS(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final void ahb(String paramString)
    {
      AppMethodBeat.i(80833);
      if (a.this.CEM.eIL())
      {
        this.hqK.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.ahb(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final m blA()
    {
      return a.this.CEQ;
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = a.this.CEM.aET(paramString);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final void cl(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (a.this.sYb.fZg == 0L) {
        a.this.sYb.fZg = l;
      }
      if (a.this.sYo.CFI == 0L) {
        a.this.sYo.CFI = l;
      }
      super.cl(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void eFp()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.hqK.removeJavascriptInterface("MicroMsg");
        this.hqK.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.hqK.setWebChromeClient(null);
        this.hqK.setWebViewClient(null);
        this.hqK.setOnTouchListener(null);
        this.hqK.setOnLongClickListener(null);
        this.hqK.setVisibility(8);
        this.hqK.removeAllViews();
        this.hqK.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.hqK.destroy();
            AppMethodBeat.o(80836);
            return;
          }
          catch (Exception localException2)
          {
            ac.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
            AppMethodBeat.o(80836);
          }
          localException1 = localException1;
          ac.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
        }
      }
    }
    
    public final void eFq()
    {
      AppMethodBeat.i(80840);
      a.this.sYb.fZd = System.currentTimeMillis();
      super.eFq();
      AppMethodBeat.o(80840);
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      ac.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.sYb.fZf == 0L) {
        a.this.sYb.fZf = l;
      }
      if (a.this.sYo.CFH == 0L) {
        a.this.sYo.CFH = l;
      }
      if (a.this.sYb.fYZ == 0L)
      {
        a.this.sYb.fYZ = l;
        a.this.sYn = l;
      }
      this.hqK.setVisibility(0);
      a.this.CEM.p(paramWebView, paramString);
      a.this.sYm.CEW.Bb();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return i.dvr;
    }
  }
  
  final class c
    extends com.tencent.xweb.x5.export.external.extension.proxy.a
  {
    private c() {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80843);
      Object localObject = a.this.CEM.onMiscCallBack(paramString, paramBundle);
      if (localObject != null)
      {
        AppMethodBeat.o(80843);
        return localObject;
      }
      paramString = super.onMiscCallBack(paramString, paramBundle);
      AppMethodBeat.o(80843);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a
 * JD-Core Version:    0.7.0.1
 */