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
import com.tencent.mm.plugin.webview.d.k;
import com.tencent.mm.plugin.webview.ui.tools.l;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
  private boolean Fdd;
  GameWebViewUI JpT;
  private h JpU;
  com.tencent.mm.plugin.webview.stub.e JpV;
  com.tencent.mm.plugin.webview.d.h JpW;
  com.tencent.mm.plugin.wepkg.e JpX;
  b JpY;
  private a JpZ;
  k Jqa;
  m Jqb;
  ViewGroup WN;
  MMWebView iGY;
  Context mContext;
  c xyK;
  long xyL;
  g xyM;
  String xyo;
  GameWebPerformanceInfo xyv;
  
  public a(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.xyK = new c()
    {
      protected final void an(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((a.this.JpV != null) && (paramAnonymousBundle != null)) {
            a.this.JpV.j(96, paramAnonymousBundle);
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
    this.Jqb = new m()
    {
      public final void aM(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        Log.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          a.this.WN.removeView(a.this.iGY);
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
          com.tencent.mm.br.c.b(a.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.eam));
          continue;
          localBundle.putString("KPublisherId", h.eam);
          localBundle.putInt("getA8KeyScene", a.this.gy(h.JrK, h.ehX));
          continue;
          paramAnonymousInt = h.ehX;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          Log.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (a.this.JpV.isSDCardAvailable())
          {
            long l = SdcardUtil.getAvailableExternalMemorySize2();
            Log.i("MicroMsg.GameFloatWebView", "availableSize = %d", new Object[] { Long.valueOf(l) });
            if (l < 524288000L)
            {
              Log.e("MicroMsg.GameFloatWebView", "available size not enough");
              label418:
              paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
            }
          }
          boolean bool;
          for (;;)
          {
            localBundle.putInt("webview_video_proxy_init", paramAnonymousInt);
            break;
            paramAnonymousBundle = new o(com.tencent.mm.plugin.webview.a.IJo);
            bool = true;
            if (!paramAnonymousBundle.exists())
            {
              bool = paramAnonymousBundle.mkdirs();
              Log.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { aa.z(paramAnonymousBundle.her()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, q.k(aa.z(paramAnonymousBundle.her()), false));
            FactoryProxyManager.getPlayManager().setMaxStorageSize(200L);
            continue;
            Log.i("MicroMsg.GameFloatWebView", "sdcard not available");
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
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
            a.this.JpT.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                a.this.JpT.aG(this.JhE, paramAnonymousInt, i);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            a.this.JpT.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = a.this.JpT.gfz();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.e.gw(paramAnonymousBundle.getString("set_page_title_color"), a.this.JpT.getResources().getColor(2131099892));
            a.this.JpT.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.dqb != null) {
                  a.this.JpT.setMMTitle(this.dqb);
                }
                a.this.JpT.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            Log.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.cr.d.bJ(paramAnonymousBundle);
            continue;
            a.this.JpT.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                a.this.JpT.bb(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = com.tencent.xweb.c.hsp().getCookie(paramAnonymousBundle);
            Log.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cb.a.getDensity(a.this.JpT));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            l.Jhd.me((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = a.this.JpT.getMMTitle();
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
            if (a.this.JpW != null)
            {
              a.this.JpW.yX(bool);
              continue;
              bool = a.this.JpY.gio();
              paramAnonymousBundle = a.this.JpY.coy();
              localObject1 = a.this.JpY.gip();
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
                  com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                  localObject2 = com.tencent.xweb.c.hsp();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(Util.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.hsr();
                  com.tencent.xweb.d.sync();
                  Log.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(Util.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  a.this.xyK.Jqh.bm(paramAnonymousBundle);
                  Log.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  a.this.xyv.hhB = 1;
                  a.this.xyM.Jra = System.currentTimeMillis();
                  continue;
                  a.this.xyM.Jrb = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.xyv = GameWebPerformanceInfo.Fe(paramString);
    this.xyv.url = paramString;
    this.xyv.hhu = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.xyv.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.xyv.hhF = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.xyv.hhK = l;
    this.xyv.hhM = l;
    this.xyM = g.baJ(paramString);
    this.xyM.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.JpT = paramGameWebViewUI;
    this.WN = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.hZ(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.JpY = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.JpY);
    this.JpZ = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.JpZ);
    Log.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.JpY.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().hsU();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().hsN();
    paramViewGroup.getSettings().hsM();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().hsW();
    paramViewGroup.getSettings().hsS();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().hsR();
    paramViewGroup.getSettings().hsT();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
    com.tencent.xweb.c.hsp().hsq();
    com.tencent.xweb.c.hsp().e(paramViewGroup);
    this.iGY = paramViewGroup;
    this.JpU = new h(paramGameWebViewUI.getIntent());
    this.JpX = new com.tencent.mm.plugin.wepkg.e();
    this.JpX.JLI = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void dTT()
      {
        AppMethodBeat.i(80819);
        Log.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { a.this.xyo });
        if ((a.this.iGY != null) && (a.this.iGY.getParent() != null) && (a.this.JpY != null) && (!Util.isNullOrNil(a.this.xyo)))
        {
          a.this.iGY.stopLoading();
          a.this.iGY.loadUrl(a.this.JpY.coy());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.xyv.hhN = System.currentTimeMillis();
    this.xyM.JqV = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int gy(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.JpV != null) {
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
        if (this.JpV.JE(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.JpV.IT(paramString);
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
    if (!this.Fdd)
    {
      Log.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.Fdd = true;
      c.a(this.xyK.Jqh.Jqi);
      this.JpX.zE(true);
      if (this.iGY != null)
      {
        this.iGY.setWebViewClient(null);
        this.iGY.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.xyv;
      localGameWebPerformanceInfo.hhU += System.currentTimeMillis() - this.xyL;
      this.xyv.hhV = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.hhr.a(this.xyv);
      GameWebPerformanceInfo.Ff(this.xyo);
      g.baM(this.xyo);
    }
    AppMethodBeat.o(80846);
  }
  
  final class a
    extends i
  {
    a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
    {
      super();
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(80827);
      if (a.this.JpX != null) {
        a.this.JpX.a(paramConsoleMessage);
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
      WebResourceResponse localWebResourceResponse = a.this.JpX.p(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      WebResourceResponse localWebResourceResponse = a.this.JpX.p(paramWebView, paramWebResourceRequest.getUrl().toString());
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
      AppMethodBeat.i(211311);
      Log.i("MicroMsg.GameFloatWebView", "jsapi ready");
      a.this.JpW = paramh;
      AppMethodBeat.o(211311);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.f.g paramg)
    {
      a.this.JpV = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (a.this.xyv.hhQ == 0L) {
        a.this.xyv.hhQ = l;
      }
      if (a.this.xyM.JqW == 0L) {
        a.this.xyM.JqW = l;
      }
      a.this.xyK.Jqh.ghf();
      a.this.JpX.bcg(paramString);
      AppMethodBeat.o(80828);
    }
    
    public final void av(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (a.this.xyv.hhS == 0L) {
        a.this.xyv.hhS = l;
      }
      if (a.this.xyM.JqY == 0L) {
        a.this.xyM.JqY = l;
      }
      super.av(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void azM(String paramString)
    {
      AppMethodBeat.i(80833);
      if (a.this.JpX.gkw())
      {
        this.iGY.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.azM(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final void b(k paramk)
    {
      AppMethodBeat.i(211312);
      Log.i("MicroMsg.GameFloatWebView", "jsloader ready");
      a.this.Jqa = paramk;
      AppMethodBeat.o(211312);
    }
    
    public final m bLB()
    {
      return a.this.Jqb;
    }
    
    public final boolean baF(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = a.this.JpX.bci(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean baG(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.baG(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void baH(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        Log.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        a.this.WN.removeView(this.iGY);
        AppMethodBeat.o(80835);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(80835);
      }
    }
    
    public final boolean bk(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (a.this.xyv.hhT == 0L) {
        a.this.xyv.hhT = l;
      }
      if (a.this.xyM.JqZ == 0L) {
        a.this.xyM.JqZ = l;
      }
      boolean bool = super.bk(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final WebResourceResponse c(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80837);
      WebResourceResponse localWebResourceResponse = a.this.JpX.p(paramWebView, paramString);
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
      if (a.this.xyv.hhR == 0L) {
        a.this.xyv.hhR = l;
      }
      if (a.this.xyM.JqX == 0L) {
        a.this.xyM.JqX = l;
      }
      if (a.this.xyv.hhL == 0L)
      {
        a.this.xyv.hhL = l;
        a.this.xyL = l;
      }
      this.iGY.setVisibility(0);
      a.this.JpX.bch(paramString);
      a.this.xyK.Jqh.LZ();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return h.eam;
    }
    
    public final void ghd()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.iGY.removeJavascriptInterface("MicroMsg");
        this.iGY.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.iGY.setWebChromeClient(null);
        this.iGY.setWebViewClient(null);
        this.iGY.setOnTouchListener(null);
        this.iGY.setOnLongClickListener(null);
        this.iGY.setVisibility(8);
        this.iGY.removeAllViews();
        this.iGY.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.iGY.destroy();
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
    
    public final void ghe()
    {
      AppMethodBeat.i(80840);
      a.this.xyv.hhP = System.currentTimeMillis();
      super.ghe();
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
      Object localObject = a.this.JpX.onMiscCallBack(paramString, paramBundle);
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