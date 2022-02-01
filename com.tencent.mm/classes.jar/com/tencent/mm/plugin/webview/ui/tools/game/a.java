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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  GameWebViewUI BmB;
  private i BmC;
  com.tencent.mm.plugin.webview.stub.e BmD;
  f BmE;
  com.tencent.mm.plugin.wepkg.c BmF;
  b BmG;
  private a BmH;
  com.tencent.mm.plugin.webview.c.i BmI;
  m BmJ;
  ViewGroup TP;
  MMWebView gQk;
  Context mContext;
  String rQe;
  GameWebPerformanceInfo rQk;
  c rQv;
  long rQw;
  h rQx;
  private boolean xWg;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.rQv = new c()
    {
      protected final void aa(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((a.this.BmD != null) && (paramAnonymousBundle != null)) {
            a.this.BmD.j(96, paramAnonymousBundle);
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
    this.BmJ = new m()
    {
      public final void ay(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        ad.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          a.this.TP.removeView(a.this.gQk);
          a.this.onDestroy();
          AppMethodBeat.o(80825);
          return;
        }
        catch (Exception paramAnonymousBundle)
        {
          AppMethodBeat.o(80825);
        }
      }
      
      public final Bundle j(final int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80826);
        ad.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(paramAnonymousInt)));
        final Bundle localBundle = new Bundle();
        switch (paramAnonymousInt)
        {
        default: 
          ad.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
        }
        for (;;)
        {
          AppMethodBeat.o(80826);
          return localBundle;
          paramAnonymousBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
          com.tencent.mm.bs.d.b(a.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", i.dxF));
          continue;
          localBundle.putString("KPublisherId", i.dxF);
          localBundle.putInt("getA8KeyScene", a.this.fm(i.Boj, i.dEF));
          continue;
          paramAnonymousInt = i.dEF;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          ad.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (a.this.BmD.isSDCardAvailable())
          {
            long l = bi.eGv();
            ad.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              ad.e("MicroMsg.GameFloatWebView", "available size not enough");
              label418:
              paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
            }
          }
          boolean bool;
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramAnonymousInt);
            break;
            paramAnonymousBundle = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.webview.a.AKk);
            bool = true;
            if (!paramAnonymousBundle.exists())
            {
              bool = paramAnonymousBundle.mkdirs();
              ad.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { com.tencent.mm.vfs.q.B(paramAnonymousBundle.fhU()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(paramAnonymousBundle.fhU()), false));
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            ad.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
          }
          Object localObject1 = paramAnonymousBundle.getString("webview_video_proxy_cdn_urls");
          Object localObject2 = paramAnonymousBundle.getString("webview_video_proxy_fileId");
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_file_size");
          int i = paramAnonymousBundle.getInt("webview_video_proxy_file_duration");
          int j = paramAnonymousBundle.getInt("webview_video_proxy_file_type");
          int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramAnonymousInt, i);
          paramAnonymousBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
          ad.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousBundle });
          localBundle.putInt("webview_video_proxy_play_data_id", k);
          localBundle.putString("webview_video_proxy_local_url", paramAnonymousBundle);
          continue;
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
          ad.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            ad.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
            localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramAnonymousInt, i));
            continue;
            localObject1 = paramAnonymousBundle.getString("show_kb_placeholder");
            paramAnonymousInt = paramAnonymousBundle.getInt("show_kb_max_length");
            a.this.BmB.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                a.this.BmB.fl(this.Bgq, paramAnonymousInt);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            a.this.BmB.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = a.this.BmB.eoC();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.fj(paramAnonymousBundle.getString("set_page_title_color"), a.this.BmB.getResources().getColor(2131099874));
            a.this.BmB.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.cPN != null) {
                  a.this.BmB.setMMTitle(this.cPN);
                }
                a.this.BmB.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            ad.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.cr.d.bs(paramAnonymousBundle);
            continue;
            a.this.BmB.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                a.this.BmB.aE(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.fqC().getCookie(paramAnonymousBundle);
            ad.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cd.a.getDensity(a.this.BmB));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            k.BfO.kg((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = a.this.BmB.getMMTitle();
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
            if (a.this.BmE != null)
            {
              a.this.BmE.th(bool);
              continue;
              bool = a.this.BmG.erb();
              paramAnonymousBundle = a.this.BmG.ekV();
              localObject1 = a.this.BmG.erc();
              if (bool)
              {
                localBundle.putString("result", "not_return");
              }
              else
              {
                localBundle.putString("full_url", bt.nullAsNil(paramAnonymousBundle));
                if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                {
                  localBundle.putInt("set_cookie", 1);
                  com.tencent.xweb.d.kU(aj.getContext());
                  localObject2 = com.tencent.xweb.c.fqC();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bt.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.fqE();
                  com.tencent.xweb.d.sync();
                  ad.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bt.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  a.this.rQv.BmP.aQ(paramAnonymousBundle);
                  ad.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  a.this.rQk.fUU = 1;
                  a.this.rQx.BnD = System.currentTimeMillis();
                  continue;
                  a.this.rQx.BnE = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.rQk = GameWebPerformanceInfo.qe(paramString);
    this.rQk.url = paramString;
    this.rQk.fUN = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.rQk.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.rQk.fUY = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.rQk.fVd = l;
    this.rQk.fVf = l;
    this.rQx = h.ayk(paramString);
    this.rQx.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.BmB = paramGameWebViewUI;
    this.TP = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.gJ(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.BmG = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.BmG);
    this.BmH = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.BmH);
    ad.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.BmG.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().frg();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().fqZ();
    paramViewGroup.getSettings().fqY();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().fri();
    paramViewGroup.getSettings().fre();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().frd();
    paramViewGroup.getSettings().frf();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
    com.tencent.xweb.c.fqC().fqD();
    com.tencent.xweb.c.fqC().e(paramViewGroup);
    this.gQk = paramViewGroup;
    this.BmC = new i(paramGameWebViewUI.getIntent());
    this.BmF = new com.tencent.mm.plugin.wepkg.c();
    this.BmF.BHn = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void cBM()
      {
        AppMethodBeat.i(80819);
        ad.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { a.this.rQe });
        if ((a.this.gQk != null) && (a.this.gQk.getParent() != null) && (a.this.BmG != null) && (!bt.isNullOrNil(a.this.rQe)))
        {
          a.this.gQk.stopLoading();
          a.this.gQk.loadUrl(a.this.BmG.ekV());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.rQk.fVg = System.currentTimeMillis();
    this.rQx.Bny = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int fm(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.BmD != null) {
        break label59;
      }
      i = 1;
    }
    for (;;)
    {
      ad.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(80845);
      return i;
      try
      {
        label59:
        if (this.BmD.to(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.BmD.sE(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
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
    if (!this.xWg)
    {
      ad.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.xWg = true;
      c.a(this.rQv.BmP.BmQ);
      this.BmF.tM(true);
      if (this.gQk != null)
      {
        this.gQk.setWebViewClient(null);
        this.gQk.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.rQk;
      localGameWebPerformanceInfo.fVn += System.currentTimeMillis() - this.rQw;
      this.rQk.fVo = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.fUK.a(this.rQk);
      GameWebPerformanceInfo.qf(this.rQe);
      h.ayn(this.rQe);
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
      if (a.this.BmF != null) {
        a.this.BmF.a(paramConsoleMessage);
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
      WebResourceResponse localWebResourceResponse = a.this.BmF.azC(paramWebResourceRequest.getUrl().toString());
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
      WebResourceResponse localWebResourceResponse = a.this.BmF.azC(paramWebResourceRequest.getUrl().toString());
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
      AppMethodBeat.i(188107);
      ad.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.BmE = paramf;
      AppMethodBeat.o(188107);
    }
    
    public final void a(com.tencent.mm.plugin.webview.c.i parami)
    {
      AppMethodBeat.i(188108);
      ad.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.BmI = parami;
      AppMethodBeat.o(188108);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, g paramg)
    {
      a.this.BmD = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.rQk.fVj == 0L) {
        a.this.rQk.fVj = l;
      }
      if (a.this.rQx.Bnz == 0L) {
        a.this.rQx.Bnz = l;
      }
      a.this.rQv.BmP.epX();
      a.this.BmF.o(paramWebView, paramString);
      AppMethodBeat.o(80828);
    }
    
    public final boolean aO(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (a.this.rQk.fVm == 0L) {
        a.this.rQk.fVm = l;
      }
      if (a.this.rQx.BnC == 0L) {
        a.this.rQx.BnC = l;
      }
      boolean bool = super.aO(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final void acj(String paramString)
    {
      AppMethodBeat.i(80833);
      if (a.this.BmF.ets())
      {
        this.gQk.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.acj(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final boolean ayg(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = a.this.BmF.azD(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean ayh(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.ayh(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void ayi(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        ad.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.TP.removeView(this.gQk);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final m beG()
    {
      return a.this.BmJ;
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = a.this.BmF.azC(paramString);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final void cf(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (a.this.rQk.fVl == 0L) {
        a.this.rQk.fVl = l;
      }
      if (a.this.rQx.BnB == 0L) {
        a.this.rQx.BnB = l;
      }
      super.cf(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void epV()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.gQk.removeJavascriptInterface("MicroMsg");
        this.gQk.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.gQk.setWebChromeClient(null);
        this.gQk.setWebViewClient(null);
        this.gQk.setOnTouchListener(null);
        this.gQk.setOnLongClickListener(null);
        this.gQk.setVisibility(8);
        this.gQk.removeAllViews();
        this.gQk.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.gQk.destroy();
            AppMethodBeat.o(80836);
            return;
          }
          catch (Exception localException2)
          {
            ad.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
            AppMethodBeat.o(80836);
          }
          localException1 = localException1;
          ad.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
        }
      }
    }
    
    public final void epW()
    {
      AppMethodBeat.i(80840);
      a.this.rQk.fVi = System.currentTimeMillis();
      super.epW();
      AppMethodBeat.o(80840);
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.rQk.fVk == 0L) {
        a.this.rQk.fVk = l;
      }
      if (a.this.rQx.BnA == 0L) {
        a.this.rQx.BnA = l;
      }
      if (a.this.rQk.fVe == 0L)
      {
        a.this.rQk.fVe = l;
        a.this.rQw = l;
      }
      this.gQk.setVisibility(0);
      a.this.BmF.p(paramWebView, paramString);
      a.this.rQv.BmP.Bx();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return i.dxF;
    }
  }
  
  final class c
    extends com.tencent.xweb.x5.export.external.extension.proxy.a
  {
    private c() {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80843);
      Object localObject = a.this.BmF.onMiscCallBack(paramString, paramBundle);
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