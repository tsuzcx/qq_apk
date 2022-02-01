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
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.d.k;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.wepkg.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  GameWebPerformanceInfo CCD;
  d CCS;
  long CCT;
  h CCU;
  String CCx;
  private boolean Lrz;
  GameWebViewUI Qno;
  i Qnp;
  com.tencent.mm.plugin.webview.stub.e Qnq;
  f Qnr;
  b Qns;
  private a Qnt;
  k Qnu;
  com.tencent.mm.plugin.webview.ui.tools.widget.m Qnv;
  ViewGroup Rx;
  MMWebView lxa;
  Context mContext;
  com.tencent.mm.plugin.webview.d.h pIl;
  
  public b(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.CCS = new d()
    {
      protected final void ah(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((b.this.Qnq != null) && (paramAnonymousBundle != null)) {
            b.this.Qnq.l(96, paramAnonymousBundle);
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
    this.Qnv = new com.tencent.mm.plugin.webview.ui.tools.widget.m()
    {
      public final void aI(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        Log.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          b.this.Rx.removeView(b.this.lxa);
          b.this.onDestroy();
          AppMethodBeat.o(80825);
          return;
        }
        catch (Exception paramAnonymousBundle)
        {
          AppMethodBeat.o(80825);
        }
      }
      
      public final Bundle l(final int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80826);
        Log.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(paramAnonymousInt)));
        final Bundle localBundle = new Bundle();
        switch (paramAnonymousInt)
        {
        default: 
          Log.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
        }
        for (;;)
        {
          AppMethodBeat.o(80826);
          return localBundle;
          paramAnonymousBundle.setClassLoader(GameWebViewUI.class.getClassLoader());
          com.tencent.mm.by.c.b(b.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", i.fUj));
          continue;
          localBundle.putString("KPublisherId", i.fUj);
          localBundle.putInt("getA8KeyScene", b.this.hg(i.Qpg, i.gco));
          continue;
          paramAnonymousInt = i.gco;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          Log.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (b.this.Qnq.isSDCardAvailable())
          {
            long l = SdcardUtil.getAvailableExternalMemorySize2();
            Log.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              Log.e("MicroMsg.GameFloatWebView", "available size not enough");
              label418:
              paramAnonymousInt = FactoryProxyManager.getPlayManager().init(b.this.mContext, null);
            }
          }
          boolean bool;
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramAnonymousInt);
            break;
            paramAnonymousBundle = new com.tencent.mm.vfs.q(com.tencent.mm.plugin.webview.a.PDD);
            bool = true;
            if (!paramAnonymousBundle.ifE())
            {
              bool = paramAnonymousBundle.ifL();
              Log.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { paramAnonymousBundle.bOF(), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(b.this.mContext, com.tencent.mm.b.q.n(paramAnonymousBundle.bOF(), false));
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            Log.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(b.this.mContext, null);
          }
          Object localObject1 = paramAnonymousBundle.getString("webview_video_proxy_cdn_urls");
          Object localObject2 = paramAnonymousBundle.getString("webview_video_proxy_fileId");
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_file_size");
          final int i = paramAnonymousBundle.getInt("webview_video_proxy_file_duration");
          int j = paramAnonymousBundle.getInt("webview_video_proxy_file_type");
          int k = FactoryProxyManager.getPlayManager().startPlay((String)localObject1, j, (String)localObject2, paramAnonymousInt, i);
          paramAnonymousBundle = FactoryProxyManager.getPlayManager().buildPlayURLMp4(k);
          Log.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[] { localObject1, localObject2, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramAnonymousBundle });
          localBundle.putInt("webview_video_proxy_play_data_id", k);
          localBundle.putString("webview_video_proxy_local_url", paramAnonymousBundle);
          continue;
          paramAnonymousInt = paramAnonymousBundle.getInt("webview_video_proxy_play_data_id");
          Log.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            Log.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(i) });
            localBundle.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(paramAnonymousInt, i));
            continue;
            localObject1 = paramAnonymousBundle.getString("show_kb_placeholder");
            paramAnonymousInt = paramAnonymousBundle.getInt("show_kb_max_length");
            i = paramAnonymousBundle.getInt("show_kb_show_remind_word_count");
            b.this.Qno.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                b.this.Qno.aI(this.Qnx, paramAnonymousInt, i);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            b.this.Qno.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = b.this.Qno.gYK();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.he(paramAnonymousBundle.getString("set_page_title_color"), b.this.Qno.getResources().getColor(c.c.action_bar_tittle_color));
            b.this.Qno.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.cWz != null) {
                  b.this.Qno.setMMTitle(this.cWz);
                }
                b.this.Qno.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            Log.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.xwebutil.c.bN(paramAnonymousBundle);
            continue;
            b.this.Qno.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                b.this.Qno.aX(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.ivX().getCookie(paramAnonymousBundle);
            Log.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.ci.a.getDensity(b.this.Qno));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            com.tencent.mm.plugin.webview.ui.tools.m.Qer.mF((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = b.this.Qno.getMMTitle();
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
            if (b.this.pIl != null)
            {
              b.this.pIl.CS(bool);
              continue;
              bool = b.this.Qns.hbQ();
              paramAnonymousBundle = b.this.Qns.cCL();
              localObject1 = b.this.Qns.hbR();
              if (bool)
              {
                localBundle.putString("result", "not_return");
              }
              else
              {
                localBundle.putString("full_url", Util.nullAsNil(paramAnonymousBundle));
                if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                {
                  localBundle.putInt("set_cookie", 1);
                  com.tencent.xweb.d.my(MMApplicationContext.getContext());
                  localObject2 = com.tencent.xweb.c.ivX();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(Util.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.ivZ();
                  com.tencent.xweb.d.sync();
                  Log.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(Util.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  b.this.CCS.QnE.bk(paramAnonymousBundle);
                  Log.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  b.this.CCD.jTz = 1;
                  b.this.CCU.Qox = System.currentTimeMillis();
                  continue;
                  b.this.CCU.Qoy = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.CCD = GameWebPerformanceInfo.Ma(paramString);
    this.CCD.url = paramString;
    this.CCD.jTs = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.CCD.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.CCD.jTD = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.CCD.jTI = l;
    this.CCD.jTK = l;
    this.CCU = h.bmH(paramString);
    this.CCU.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.Qno = paramGameWebViewUI;
    this.Rx = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.jd(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.Qns = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.Qns);
    this.Qnt = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.Qnt);
    Log.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.Qns.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().iwC();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().iwx();
    paramViewGroup.getSettings().iww();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().iwE();
    paramViewGroup.getSettings().iwA();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().iwz();
    paramViewGroup.getSettings().iwB();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    com.tencent.xweb.c.ivX().ivY();
    com.tencent.xweb.c.ivX().f(paramViewGroup);
    this.lxa = paramViewGroup;
    this.Qnp = new i(paramGameWebViewUI.getIntent());
    this.Qnr = new f();
    this.Qnr.QLb = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void exa()
      {
        AppMethodBeat.i(80819);
        Log.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { b.this.CCx });
        if ((b.this.lxa != null) && (b.this.lxa.getParent() != null) && (b.this.Qns != null) && (!Util.isNullOrNil(b.this.CCx)))
        {
          b.this.lxa.stopLoading();
          b.this.lxa.loadUrl(b.this.Qns.cCL());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.CCD.jTL = System.currentTimeMillis();
    this.CCU.Qos = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int hg(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.Qnq != null) {
        break label59;
      }
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(80845);
      return i;
      try
      {
        label59:
        if (this.Qnq.QX(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.Qnq.Qm(paramString);
        if (bool)
        {
          i = 7;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + paramString.getMessage());
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
    if (!this.Lrz)
    {
      Log.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.Lrz = true;
      d.a(this.CCS.QnE.QnF);
      this.Qnr.DD(true);
      if (this.lxa != null)
      {
        this.lxa.setWebViewClient(null);
        this.lxa.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.CCD;
      localGameWebPerformanceInfo.jTS += System.currentTimeMillis() - this.CCT;
      this.CCD.jTT = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.jTp.a(this.CCD);
      GameWebPerformanceInfo.Mb(this.CCx);
      h.bmK(this.CCx);
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
      if (b.this.Qnr != null) {
        b.this.Qnr.a(paramConsoleMessage);
      }
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(80827);
      return bool;
    }
  }
  
  final class b
    extends c
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
      WebResourceResponse localWebResourceResponse = b.this.Qnr.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      WebResourceResponse localWebResourceResponse = b.this.Qnr.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80839);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(80839);
      return paramWebView;
    }
    
    public final void a(com.tencent.mm.plugin.webview.d.h paramh)
    {
      AppMethodBeat.i(219666);
      Log.i("MicroMsg.GameFloatWebView", "jsapi ready");
      b.this.pIl = paramh;
      AppMethodBeat.o(219666);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, g paramg)
    {
      b.this.Qnq = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (b.this.CCD.jTO == 0L) {
        b.this.CCD.jTO = l;
      }
      if (b.this.CCU.Qot == 0L) {
        b.this.CCU.Qot = l;
      }
      b.this.CCS.QnE.hay();
      b.this.Qnr.bog(paramString);
      AppMethodBeat.o(80828);
    }
    
    public final void aJy(String paramString)
    {
      AppMethodBeat.i(80833);
      if (b.this.Qnr.hen())
      {
        this.lxa.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.aJy(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final void ax(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (b.this.CCD.jTQ == 0L) {
        b.this.CCD.jTQ = l;
      }
      if (b.this.CCU.Qov == 0L) {
        b.this.CCU.Qov = l;
      }
      super.ax(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void b(k paramk)
    {
      AppMethodBeat.i(219667);
      Log.i("MicroMsg.GameFloatWebView", "jsloader ready");
      b.this.Qnu = paramk;
      AppMethodBeat.o(219667);
    }
    
    public final com.tencent.mm.plugin.webview.ui.tools.widget.m bXB()
    {
      return b.this.Qnv;
    }
    
    public final boolean bi(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (b.this.CCD.jTR == 0L) {
        b.this.CCD.jTR = l;
      }
      if (b.this.CCU.Qow == 0L) {
        b.this.CCU.Qow = l;
      }
      boolean bool = super.bi(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final boolean bmD(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = b.this.Qnr.boi(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean bmE(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.bmE(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void bmF(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        Log.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        b.this.Rx.removeView(this.lxa);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = b.this.Qnr.a(paramWebView, paramString, null);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (b.this.CCD.jTP == 0L) {
        b.this.CCD.jTP = l;
      }
      if (b.this.CCU.Qou == 0L) {
        b.this.CCU.Qou = l;
      }
      if (b.this.CCD.jTJ == 0L)
      {
        b.this.CCD.jTJ = l;
        b.this.CCT = l;
      }
      this.lxa.setVisibility(0);
      b.this.Qnr.boh(paramString);
      b.this.CCS.QnE.OR();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return i.fUj;
    }
    
    public final void haw()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.lxa.removeJavascriptInterface("MicroMsg");
        this.lxa.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.lxa.setWebChromeClient(null);
        this.lxa.setWebViewClient(null);
        this.lxa.setOnTouchListener(null);
        this.lxa.setOnLongClickListener(null);
        this.lxa.setVisibility(8);
        this.lxa.removeAllViews();
        this.lxa.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.lxa.destroy();
            AppMethodBeat.o(80836);
            return;
          }
          catch (Exception localException2)
          {
            Log.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
            AppMethodBeat.o(80836);
          }
          localException1 = localException1;
          Log.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
        }
      }
    }
    
    public final void hax()
    {
      AppMethodBeat.i(80840);
      b.this.CCD.jTN = System.currentTimeMillis();
      super.hax();
      AppMethodBeat.o(80840);
    }
  }
  
  final class c
    extends com.tencent.xweb.x5.export.external.extension.proxy.a
  {
    private c() {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(80843);
      Object localObject = b.this.Qnr.onMiscCallBack(paramString, paramBundle);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.b
 * JD-Core Version:    0.7.0.1
 */