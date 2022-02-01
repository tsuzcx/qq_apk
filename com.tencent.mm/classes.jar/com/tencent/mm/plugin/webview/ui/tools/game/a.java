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
import com.tencent.mm.b.q;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.w;
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
  private boolean ASx;
  com.tencent.mm.plugin.wepkg.d EAA;
  b EAB;
  private a EAC;
  com.tencent.mm.plugin.webview.c.i EAD;
  m EAE;
  GameWebViewUI EAw;
  private h EAx;
  com.tencent.mm.plugin.webview.stub.e EAy;
  f EAz;
  ViewGroup WA;
  MMWebView hLV;
  Context mContext;
  String ugc;
  GameWebPerformanceInfo ugi;
  c ugv;
  long ugw;
  g ugx;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.ugv = new c()
    {
      protected final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((a.this.EAy != null) && (paramAnonymousBundle != null)) {
            a.this.EAy.k(96, paramAnonymousBundle);
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
    this.EAE = new m()
    {
      public final void aA(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        ae.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          a.this.WA.removeView(a.this.hLV);
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
        ae.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(paramAnonymousInt)));
        final Bundle localBundle = new Bundle();
        switch (paramAnonymousInt)
        {
        default: 
          ae.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
        }
        for (;;)
        {
          AppMethodBeat.o(80826);
          return localBundle;
          paramAnonymousBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
          com.tencent.mm.br.d.b(a.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.dIz));
          continue;
          localBundle.putString("KPublisherId", h.dIz);
          localBundle.putInt("getA8KeyScene", a.this.ga(h.ECg, h.dPU));
          continue;
          paramAnonymousInt = h.dPU;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          ae.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (a.this.EAy.isSDCardAvailable())
          {
            long l = bj.fpv();
            ae.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              ae.e("MicroMsg.GameFloatWebView", "available size not enough");
              label418:
              paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
            }
          }
          boolean bool;
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramAnonymousInt);
            break;
            paramAnonymousBundle = new com.tencent.mm.vfs.k(com.tencent.mm.plugin.webview.a.DXx);
            bool = true;
            if (!paramAnonymousBundle.exists())
            {
              bool = paramAnonymousBundle.mkdirs();
              ae.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { w.B(paramAnonymousBundle.fTh()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, q.k(w.B(paramAnonymousBundle.fTh()), false));
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            ae.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
          }
          Object localObject1 = paramAnonymousBundle.getString("webview_video_proxy_cdn_urls");
          Object localObject2 = paramAnonymousBundle.getString("webview_video_proxy_fileId");
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_file_size");
          final int i = paramAnonymousBundle.getInt("webview_video_proxy_file_duration");
          int j = paramAnonymousBundle.getInt("webview_video_proxy_file_type");
          int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramAnonymousInt, i);
          paramAnonymousBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
          ae.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousBundle });
          localBundle.putInt("webview_video_proxy_play_data_id", k);
          localBundle.putString("webview_video_proxy_local_url", paramAnonymousBundle);
          continue;
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
          ae.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            ae.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
            localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramAnonymousInt, i));
            continue;
            localObject1 = paramAnonymousBundle.getString("show_kb_placeholder");
            paramAnonymousInt = paramAnonymousBundle.getInt("show_kb_max_length");
            i = paramAnonymousBundle.getInt("show_kb_show_remind_word_count");
            a.this.EAw.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                a.this.EAw.aE(this.Eum, paramAnonymousInt, i);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            a.this.EAw.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = a.this.EAw.eWB();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.ee(paramAnonymousBundle.getString("set_page_title_color"), a.this.EAw.getResources().getColor(2131099874));
            a.this.EAw.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.cZw != null) {
                  a.this.EAw.setMMTitle(this.cZw);
                }
                a.this.EAw.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            ae.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.cp.d.bz(paramAnonymousBundle);
            continue;
            a.this.EAw.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                a.this.EAw.aP(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.geY().getCookie(paramAnonymousBundle);
            ae.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cb.a.getDensity(a.this.EAw));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            com.tencent.mm.plugin.webview.ui.tools.k.EtK.lf((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = a.this.EAw.getMMTitle();
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
            if (a.this.EAz != null)
            {
              a.this.EAz.vf(bool);
              continue;
              bool = a.this.EAB.eZi();
              paramAnonymousBundle = a.this.EAB.eST();
              localObject1 = a.this.EAB.eZj();
              if (bool)
              {
                localBundle.putString("result", "not_return");
              }
              else
              {
                localBundle.putString("full_url", bu.nullAsNil(paramAnonymousBundle));
                if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                {
                  localBundle.putInt("set_cookie", 1);
                  com.tencent.xweb.d.lB(ak.getContext());
                  localObject2 = com.tencent.xweb.c.geY();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bu.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.gfa();
                  com.tencent.xweb.d.sync();
                  ae.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bu.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  a.this.ugv.EAK.ba(paramAnonymousBundle);
                  ae.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  a.this.ugi.guM = 1;
                  a.this.ugx.EBz = System.currentTimeMillis();
                  continue;
                  a.this.ugx.EBA = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.ugi = GameWebPerformanceInfo.wQ(paramString);
    this.ugi.url = paramString;
    this.ugi.guF = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.ugi.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.ugi.guQ = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.ugi.guV = l;
    this.ugi.guX = l;
    this.ugx = g.aKv(paramString);
    this.ugx.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.EAw = paramGameWebViewUI;
    this.WA = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.hf(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.EAB = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.EAB);
    this.EAC = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.EAC);
    ae.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.EAB.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().gfD();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().gfw();
    paramViewGroup.getSettings().gfv();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().gfF();
    paramViewGroup.getSettings().gfB();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().gfA();
    paramViewGroup.getSettings().gfC();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
    com.tencent.xweb.c.geY().geZ();
    com.tencent.xweb.c.geY().e(paramViewGroup);
    this.hLV = paramViewGroup;
    this.EAx = new h(paramGameWebViewUI.getIntent());
    this.EAA = new com.tencent.mm.plugin.wepkg.d();
    this.EAA.EVP = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void dak()
      {
        AppMethodBeat.i(80819);
        ae.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { a.this.ugc });
        if ((a.this.hLV != null) && (a.this.hLV.getParent() != null) && (a.this.EAB != null) && (!bu.isNullOrNil(a.this.ugc)))
        {
          a.this.hLV.stopLoading();
          a.this.hLV.loadUrl(a.this.EAB.eST());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.ugi.guY = System.currentTimeMillis();
    this.ugx.EBu = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int ga(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.EAy != null) {
        break label59;
      }
      i = 1;
    }
    for (;;)
    {
      ae.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(80845);
      return i;
      try
      {
        label59:
        if (this.EAy.AZ(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.EAy.Ao(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        ae.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
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
    if (!this.ASx)
    {
      ae.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.ASx = true;
      c.a(this.ugv.EAK.EAL);
      this.EAA.vI(true);
      if (this.hLV != null)
      {
        this.hLV.setWebViewClient(null);
        this.hLV.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.ugi;
      localGameWebPerformanceInfo.gvf += System.currentTimeMillis() - this.ugw;
      this.ugi.gvg = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.guC.a(this.ugi);
      GameWebPerformanceInfo.wR(this.ugc);
      g.aKy(this.ugc);
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
      if (a.this.EAA != null) {
        a.this.EAA.a(paramConsoleMessage);
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
      WebResourceResponse localWebResourceResponse = a.this.EAA.p(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      WebResourceResponse localWebResourceResponse = a.this.EAA.p(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      AppMethodBeat.i(198402);
      ae.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.EAz = paramf;
      AppMethodBeat.o(198402);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.e.g paramg)
    {
      a.this.EAy = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      ae.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.ugi.gvb == 0L) {
        a.this.ugi.gvb = l;
      }
      if (a.this.ugx.EBv == 0L) {
        a.this.ugx.EBv = l;
      }
      a.this.ugv.EAK.eYa();
      a.this.EAA.aLP(paramString);
      AppMethodBeat.o(80828);
    }
    
    public final boolean aKr(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = a.this.EAA.aLQ(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean aKs(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.aKs(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void aKt(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        ae.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.WA.removeView(this.hLV);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final boolean aY(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (a.this.ugi.gve == 0L) {
        a.this.ugi.gve = l;
      }
      if (a.this.ugx.EBy == 0L) {
        a.this.ugx.EBy = l;
      }
      boolean bool = super.aY(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final void amx(String paramString)
    {
      AppMethodBeat.i(80833);
      if (a.this.EAA.fbq())
      {
        this.hLV.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.amx(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final void at(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (a.this.ugi.gvd == 0L) {
        a.this.ugi.gvd = l;
      }
      if (a.this.ugx.EBx == 0L) {
        a.this.ugx.EBx = l;
      }
      super.at(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void b(com.tencent.mm.plugin.webview.c.i parami)
    {
      AppMethodBeat.i(198403);
      ae.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.EAD = parami;
      AppMethodBeat.o(198403);
    }
    
    public final m bpV()
    {
      return a.this.EAE;
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = a.this.EAA.p(paramWebView, paramString);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final void eXY()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.hLV.removeJavascriptInterface("MicroMsg");
        this.hLV.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.hLV.setWebChromeClient(null);
        this.hLV.setWebViewClient(null);
        this.hLV.setOnTouchListener(null);
        this.hLV.setOnLongClickListener(null);
        this.hLV.setVisibility(8);
        this.hLV.removeAllViews();
        this.hLV.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.hLV.destroy();
            AppMethodBeat.o(80836);
            return;
          }
          catch (Exception localException2)
          {
            ae.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
            AppMethodBeat.o(80836);
          }
          localException1 = localException1;
          ae.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
        }
      }
    }
    
    public final void eXZ()
    {
      AppMethodBeat.i(80840);
      a.this.ugi.gva = System.currentTimeMillis();
      super.eXZ();
      AppMethodBeat.o(80840);
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      ae.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.ugi.gvc == 0L) {
        a.this.ugi.gvc = l;
      }
      if (a.this.ugx.EBw == 0L) {
        a.this.ugx.EBw = l;
      }
      if (a.this.ugi.guW == 0L)
      {
        a.this.ugi.guW = l;
        a.this.ugw = l;
      }
      this.hLV.setVisibility(0);
      a.this.EAA.o(paramWebView, paramString);
      a.this.ugv.EAK.CD();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return h.dIz;
    }
  }
  
  final class c
    extends com.tencent.xweb.x5.export.external.extension.proxy.a
  {
    private c() {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80843);
      Object localObject = a.this.EAA.onMiscCallBack(paramString, paramBundle);
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