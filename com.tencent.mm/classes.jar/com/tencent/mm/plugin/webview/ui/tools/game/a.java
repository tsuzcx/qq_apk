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
import com.tencent.xweb.z;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class a
{
  private boolean ABc;
  m EiA;
  GameWebViewUI Eis;
  private h Eit;
  com.tencent.mm.plugin.webview.stub.e Eiu;
  f Eiv;
  com.tencent.mm.plugin.wepkg.d Eiw;
  b Eix;
  private a Eiy;
  com.tencent.mm.plugin.webview.c.i Eiz;
  ViewGroup WA;
  MMWebView hJc;
  Context mContext;
  g tVA;
  String tVg;
  GameWebPerformanceInfo tVm;
  c tVy;
  long tVz;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.tVy = new c()
    {
      protected final void ag(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((a.this.Eiu != null) && (paramAnonymousBundle != null)) {
            a.this.Eiu.k(96, paramAnonymousBundle);
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
    this.EiA = new m()
    {
      public final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        ad.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          a.this.WA.removeView(a.this.hJc);
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
          com.tencent.mm.bs.d.b(a.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.dHu));
          continue;
          localBundle.putString("KPublisherId", h.dHu);
          localBundle.putInt("getA8KeyScene", a.this.fR(h.Ekc, h.dOE));
          continue;
          paramAnonymousInt = h.dOE;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          ad.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (a.this.Eiu.isSDCardAvailable())
          {
            long l = bi.flA();
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
            paramAnonymousBundle = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.webview.a.DFA);
            bool = true;
            if (!paramAnonymousBundle.exists())
            {
              bool = paramAnonymousBundle.mkdirs();
              ad.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { com.tencent.mm.vfs.q.B(paramAnonymousBundle.fOK()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, com.tencent.mm.b.q.k(com.tencent.mm.vfs.q.B(paramAnonymousBundle.fOK()), false));
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
            a.this.Eis.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                a.this.Eis.fQ(this.Ecl, paramAnonymousInt);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            a.this.Eis.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = a.this.Eis.eSP();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.fO(paramAnonymousBundle.getString("set_page_title_color"), a.this.Eis.getResources().getColor(2131099874));
            a.this.Eis.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.cYy != null) {
                  a.this.Eis.setMMTitle(this.cYy);
                }
                a.this.Eis.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            ad.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.cq.d.by(paramAnonymousBundle);
            continue;
            a.this.Eis.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                a.this.Eis.aO(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.gaw().getCookie(paramAnonymousBundle);
            ad.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cc.a.getDensity(a.this.Eis));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            k.EbJ.kY((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = a.this.Eis.getMMTitle();
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
            if (a.this.Eiv != null)
            {
              a.this.Eiv.uX(bool);
              continue;
              bool = a.this.Eix.eVv();
              paramAnonymousBundle = a.this.Eix.ePh();
              localObject1 = a.this.Eix.eVw();
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
                  com.tencent.xweb.d.lv(aj.getContext());
                  localObject2 = com.tencent.xweb.c.gaw();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bt.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.gay();
                  com.tencent.xweb.d.sync();
                  ad.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bt.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  a.this.tVy.EiG.aZ(paramAnonymousBundle);
                  ad.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  a.this.tVm.gsl = 1;
                  a.this.tVA.Ejv = System.currentTimeMillis();
                  continue;
                  a.this.tVA.Ejw = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.tVm = GameWebPerformanceInfo.wh(paramString);
    this.tVm.url = paramString;
    this.tVm.gse = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.tVm.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.tVm.gsp = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.tVm.gsu = l;
    this.tVm.gsw = l;
    this.tVA = g.aJc(paramString);
    this.tVA.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.Eis = paramGameWebViewUI;
    this.WA = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.gZ(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.Eix = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.Eix);
    this.Eiy = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.Eiy);
    ad.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.Eix.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().gbb();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().gaU();
    paramViewGroup.getSettings().gaT();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().gbd();
    paramViewGroup.getSettings().gaZ();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().gaY();
    paramViewGroup.getSettings().gba();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
    com.tencent.xweb.c.gaw().gax();
    com.tencent.xweb.c.gaw().e(paramViewGroup);
    this.hJc = paramViewGroup;
    this.Eit = new h(paramGameWebViewUI.getIntent());
    this.Eiw = new com.tencent.mm.plugin.wepkg.d();
    this.Eiw.EDt = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void cXA()
      {
        AppMethodBeat.i(80819);
        ad.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { a.this.tVg });
        if ((a.this.hJc != null) && (a.this.hJc.getParent() != null) && (a.this.Eix != null) && (!bt.isNullOrNil(a.this.tVg)))
        {
          a.this.hJc.stopLoading();
          a.this.hJc.loadUrl(a.this.Eix.ePh());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.tVm.gsx = System.currentTimeMillis();
    this.tVA.Ejq = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int fR(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.Eiu != null) {
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
        if (this.Eiu.Ap(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.Eiu.zE(paramString);
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
    if (!this.ABc)
    {
      ad.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.ABc = true;
      c.a(this.tVy.EiG.EiH);
      this.Eiw.vz(true);
      if (this.hJc != null)
      {
        this.hJc.setWebViewClient(null);
        this.hJc.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.tVm;
      localGameWebPerformanceInfo.gsE += System.currentTimeMillis() - this.tVz;
      this.tVm.gsF = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.gsb.a(this.tVm);
      GameWebPerformanceInfo.wi(this.tVg);
      g.aJf(this.tVg);
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
      if (a.this.Eiw != null) {
        a.this.Eiw.a(paramConsoleMessage);
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
      WebResourceResponse localWebResourceResponse = a.this.Eiw.o(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      WebResourceResponse localWebResourceResponse = a.this.Eiw.o(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      AppMethodBeat.i(208221);
      ad.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.Eiv = paramf;
      AppMethodBeat.o(208221);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.e.g paramg)
    {
      a.this.Eiu = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.tVm.gsA == 0L) {
        a.this.tVm.gsA = l;
      }
      if (a.this.tVA.Ejr == 0L) {
        a.this.tVA.Ejr = l;
      }
      a.this.tVy.EiG.eUn();
      a.this.Eiw.aKt(paramString);
      AppMethodBeat.o(80828);
    }
    
    public final boolean aIY(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = a.this.Eiw.aKu(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean aIZ(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.aIZ(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void aJa(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        ad.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.WA.removeView(this.hJc);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final boolean aX(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (a.this.tVm.gsD == 0L) {
        a.this.tVm.gsD = l;
      }
      if (a.this.tVA.Eju == 0L) {
        a.this.tVA.Eju = l;
      }
      boolean bool = super.aX(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final void alz(String paramString)
    {
      AppMethodBeat.i(80833);
      if (a.this.Eiw.eXE())
      {
        this.hJc.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.alz(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final void at(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (a.this.tVm.gsC == 0L) {
        a.this.tVm.gsC = l;
      }
      if (a.this.tVA.Ejt == 0L) {
        a.this.tVA.Ejt = l;
      }
      super.at(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void b(com.tencent.mm.plugin.webview.c.i parami)
    {
      AppMethodBeat.i(208222);
      ad.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.Eiz = parami;
      AppMethodBeat.o(208222);
    }
    
    public final m bpl()
    {
      return a.this.EiA;
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = a.this.Eiw.o(paramWebView, paramString);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final void eUl()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.hJc.removeJavascriptInterface("MicroMsg");
        this.hJc.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.hJc.setWebChromeClient(null);
        this.hJc.setWebViewClient(null);
        this.hJc.setOnTouchListener(null);
        this.hJc.setOnLongClickListener(null);
        this.hJc.setVisibility(8);
        this.hJc.removeAllViews();
        this.hJc.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.hJc.destroy();
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
    
    public final void eUm()
    {
      AppMethodBeat.i(80840);
      a.this.tVm.gsz = System.currentTimeMillis();
      super.eUm();
      AppMethodBeat.o(80840);
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      ad.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.tVm.gsB == 0L) {
        a.this.tVm.gsB = l;
      }
      if (a.this.tVA.Ejs == 0L) {
        a.this.tVA.Ejs = l;
      }
      if (a.this.tVm.gsv == 0L)
      {
        a.this.tVm.gsv = l;
        a.this.tVz = l;
      }
      this.hJc.setVisibility(0);
      a.this.Eiw.n(paramWebView, paramString);
      a.this.tVy.EiG.CA();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return h.dHu;
    }
  }
  
  final class c
    extends com.tencent.xweb.x5.export.external.extension.proxy.a
  {
    private c() {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80843);
      Object localObject = a.this.Eiw.onMiscCallBack(paramString, paramBundle);
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