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
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.m;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ao;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  GameWebPerformanceInfo IwE;
  d IwT;
  long IwU;
  h IwV;
  String Iwy;
  private boolean RUD;
  GameWebViewUI XfC;
  i XfD;
  e XfE;
  com.tencent.mm.plugin.wepkg.f XfF;
  b XfG;
  private a XfH;
  m XfI;
  p XfJ;
  ViewGroup bxO;
  Context mContext;
  MMWebView ooz;
  j sNc;
  
  public b(GameWebViewUI paramGameWebViewUI, ViewGroup paramViewGroup, String paramString)
  {
    AppMethodBeat.i(80844);
    this.IwT = new d()
    {
      protected final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80818);
        try
        {
          if ((b.this.XfE != null) && (paramAnonymousBundle != null)) {
            b.this.XfE.m(96, paramAnonymousBundle);
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
    this.XfJ = new p()
    {
      public final void aF(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(80825);
        Log.i("MicroMsg.GameFloatWebView", "closeWindow");
        try
        {
          b.this.bxO.removeView(b.this.ooz);
          b.this.onDestroy();
          AppMethodBeat.o(80825);
          return;
        }
        catch (Exception paramAnonymousBundle)
        {
          AppMethodBeat.o(80825);
        }
      }
      
      public final Bundle m(final int paramAnonymousInt, final Bundle paramAnonymousBundle)
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
          com.tencent.mm.br.c.b(b.this.mContext, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", i.iag));
          continue;
          localBundle.putString("KPublisherId", i.iag);
          localBundle.putInt("getA8KeyScene", b.this.ig(i.Xhu, i.iiA));
          continue;
          paramAnonymousInt = i.iiA;
          localBundle.putInt("geta8key_scene", paramAnonymousInt);
          Log.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", new Object[] { Integer.valueOf(paramAnonymousInt) });
          continue;
          if (b.this.XfE.isSDCardAvailable())
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
            paramAnonymousBundle = new u(com.tencent.mm.plugin.webview.a.Wui);
            bool = true;
            if (!paramAnonymousBundle.jKS())
            {
              bool = paramAnonymousBundle.jKY();
              Log.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", new Object[] { ah.v(paramAnonymousBundle.jKT()), Boolean.valueOf(bool) });
            }
            if (!bool) {
              break label418;
            }
            paramAnonymousInt = FactoryProxyManager.getPlayManager().init(b.this.mContext, q.n(ah.v(paramAnonymousBundle.jKT()), false));
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
            b.this.XfC.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80821);
                b.this.XfC.aQ(this.XfL, paramAnonymousInt, i);
                AppMethodBeat.o(80821);
              }
            });
            continue;
            b.this.XfC.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80822);
                int i = b.this.XfC.iyH();
                localBundle.putInt("height", i);
                AppMethodBeat.o(80822);
              }
            });
            continue;
            localObject1 = paramAnonymousBundle.getString("set_page_title_text");
            paramAnonymousInt = com.tencent.mm.plugin.webview.ui.tools.f.fo(paramAnonymousBundle.getString("set_page_title_color"), b.this.XfC.getResources().getColor(c.c.action_bar_tittle_color));
            b.this.XfC.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80823);
                if (this.eSG != null) {
                  b.this.XfC.setMMTitle(this.eSG);
                }
                b.this.XfC.setMMTitleColor(paramAnonymousInt);
                AppMethodBeat.o(80823);
              }
            });
            continue;
            bool = paramAnonymousBundle.getBoolean("clear_webview_cache_clear_cookie", false);
            Log.i("MicroMsg.GameFloatWebView", "includeCookie = %b", new Object[] { Boolean.valueOf(bool) });
            paramAnonymousBundle = new Intent();
            paramAnonymousBundle.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
            paramAnonymousBundle.putExtra("tools_clean_webview_cache_ignore_cookie", bool);
            com.tencent.mm.xwebutil.c.cs(paramAnonymousBundle);
            continue;
            b.this.XfC.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(80824);
                b.this.XfC.bl(paramAnonymousBundle);
                AppMethodBeat.o(80824);
              }
            });
            continue;
            paramAnonymousBundle = getCurrentUrl();
            localObject1 = ao.getCookie(paramAnonymousBundle);
            Log.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", new Object[] { paramAnonymousBundle, localObject1 });
            localBundle.putString("cookie", (String)localObject1);
            localBundle.putFloat("density", com.tencent.mm.cd.a.getDensity(b.this.XfC));
            continue;
            localObject1 = paramAnonymousBundle.getString("traceid");
            paramAnonymousBundle = paramAnonymousBundle.getString("username");
            r.WWq.ow((String)localObject1, paramAnonymousBundle);
            continue;
            paramAnonymousBundle = b.this.XfC.getMMTitle();
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
            if (b.this.sNc != null)
            {
              b.this.sNc.IA(bool);
              continue;
              bool = b.this.XfG.iCk();
              paramAnonymousBundle = b.this.XfG.dfU();
              localObject1 = b.this.XfG.iCl();
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
                  ao.oQ(MMApplicationContext.getContext());
                  localObject2 = ((Map)localObject1).keySet().iterator();
                  while (((Iterator)localObject2).hasNext())
                  {
                    String str = (String)((Iterator)localObject2).next();
                    ao.setCookie(Util.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  ao.kgo();
                  Log.i("MicroMsg.GameFloatWebView", "cookies:%s", new Object[] { ao.getCookie(Util.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                  continue;
                  b.this.IwT.XfS.bP(paramAnonymousBundle);
                  Log.i("MicroMsg.GameFloatWebView", "set game float page time data");
                  continue;
                  b.this.IwE.mtR = 1;
                  b.this.IwV.XgL = System.currentTimeMillis();
                  continue;
                  b.this.IwV.XgM = System.currentTimeMillis();
                }
              }
            }
          }
        }
      }
    };
    this.IwE = GameWebPerformanceInfo.EJ(paramString);
    this.IwE.url = paramString;
    this.IwE.mtK = ((paramGameWebViewUI.hashCode() & 0x7FFFFFFF) + "_" + (paramString.hashCode() & 0x7FFFFFFF));
    long l = System.currentTimeMillis();
    this.IwE.startTime = paramGameWebViewUI.getIntent().getLongExtra("start_time", l);
    this.IwE.mtV = paramGameWebViewUI.getIntent().getLongExtra("start_activity_time", l);
    this.IwE.mua = l;
    this.IwE.muc = l;
    this.IwV = h.bml(paramString);
    this.IwV.startTime = System.currentTimeMillis();
    this.mContext = paramGameWebViewUI;
    this.XfC = paramGameWebViewUI;
    this.bxO = paramViewGroup;
    paramViewGroup = MMWebViewWithJsApi.a.ld(this.mContext);
    paramViewGroup.setBackgroundResource(17170445);
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setVisibility(4);
    this.XfG = new b(paramViewGroup);
    paramViewGroup.setWebViewClient(this.XfG);
    this.XfH = new a((MMWebViewWithJsApi)paramViewGroup);
    paramViewGroup.setWebChromeClient(this.XfH);
    Log.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", new Object[] { Integer.valueOf(paramViewGroup.hashCode()), Integer.valueOf(this.XfG.hashCode()) });
    if (paramViewGroup.getIsX5Kernel()) {
      paramViewGroup.setWebViewClientExtension(new c((byte)0));
    }
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    paramViewGroup.getSettings().kfS();
    paramViewGroup.getSettings().setBuiltInZoomControls(false);
    paramViewGroup.getSettings().setUseWideViewPort(true);
    paramViewGroup.getSettings().setLoadWithOverviewMode(true);
    paramViewGroup.getSettings().kfN();
    paramViewGroup.getSettings().kfM();
    paramViewGroup.getSettings().setGeolocationEnabled(true);
    paramViewGroup.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    paramViewGroup.getSettings().kfU();
    paramViewGroup.getSettings().kfQ();
    paramViewGroup.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
    paramViewGroup.getSettings().kfP();
    paramViewGroup.getSettings().kfR();
    paramViewGroup.getSettings().setDatabasePath(com.tencent.mm.loader.i.b.bmq() + "databases/");
    ao.kfp();
    ao.g(paramViewGroup);
    this.ooz = paramViewGroup;
    this.XfD = new i(paramGameWebViewUI.getIntent());
    this.XfF = new com.tencent.mm.plugin.wepkg.f();
    this.XfF.XEA = new com.tencent.mm.plugin.wepkg.event.b()
    {
      public final void fEX()
      {
        AppMethodBeat.i(80819);
        Log.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", new Object[] { b.this.Iwy });
        if ((b.this.ooz != null) && (b.this.ooz.getParent() != null) && (b.this.XfG != null) && (!Util.isNullOrNil(b.this.Iwy)))
        {
          b.this.ooz.stopLoading();
          b.this.ooz.loadUrl(b.this.XfG.dfU());
        }
        AppMethodBeat.o(80819);
      }
    };
    this.IwE.mud = System.currentTimeMillis();
    this.IwV.XgG = System.currentTimeMillis();
    AppMethodBeat.o(80844);
  }
  
  final int ig(String paramString, int paramInt)
  {
    AppMethodBeat.i(80845);
    int i = paramInt;
    if (paramInt == 0)
    {
      if ((paramString == null) || (paramString.length() <= 0)) {
        break label137;
      }
      if (this.XfE != null) {
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
        if (this.XfE.IV(paramString))
        {
          i = 8;
          continue;
        }
        boolean bool = this.XfE.IS(paramString);
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
    if (!this.RUD)
    {
      Log.i("MicroMsg.GameFloatWebView", "onDestroy");
      this.RUD = true;
      d.a(this.IwT.XfS.XfT);
      this.XfF.Jk(true);
      if (this.ooz != null)
      {
        this.ooz.setWebViewClient(null);
        this.ooz.setWebChromeClient(null);
      }
      GameWebPerformanceInfo localGameWebPerformanceInfo = this.IwE;
      localGameWebPerformanceInfo.muk += System.currentTimeMillis() - this.IwU;
      this.IwE.mul = System.currentTimeMillis();
      com.tencent.mm.game.report.api.a.mtH.a(this.IwE);
      GameWebPerformanceInfo.EK(this.Iwy);
      h.bmo(this.Iwy);
    }
    AppMethodBeat.o(80846);
  }
  
  final class a
    extends l
  {
    a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
    {
      super();
    }
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      AppMethodBeat.i(80827);
      if (b.this.XfF != null) {
        b.this.XfF.a(paramConsoleMessage);
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
      WebResourceResponse localWebResourceResponse = b.this.XfF.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
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
      WebResourceResponse localWebResourceResponse = b.this.XfF.a(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80839);
        return localWebResourceResponse;
      }
      paramWebView = super.a(paramWebView, paramWebResourceRequest, paramBundle);
      AppMethodBeat.o(80839);
      return paramWebView;
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(297069);
      Log.i("MicroMsg.GameFloatWebView", "jsapi ready");
      b.this.sNc = paramj;
      AppMethodBeat.o(297069);
    }
    
    public final void a(e parame, g paramg)
    {
      b.this.XfE = parame;
    }
    
    public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(80828);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (b.this.IwE.mug == 0L) {
        b.this.IwE.mug = l;
      }
      if (b.this.IwV.XgH == 0L) {
        b.this.IwV.XgH = l;
      }
      b.this.IwT.XfS.iAL();
      b.this.XfF.bnU(paramString);
      AppMethodBeat.o(80828);
    }
    
    public final void aGm(String paramString)
    {
      AppMethodBeat.i(80833);
      if (b.this.XfF.iEV())
      {
        this.ooz.loadUrl(paramString);
        AppMethodBeat.o(80833);
        return;
      }
      super.aGm(paramString);
      AppMethodBeat.o(80833);
    }
    
    public final void aJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(80841);
      long l = System.currentTimeMillis();
      if (b.this.IwE.mui == 0L) {
        b.this.IwE.mui = l;
      }
      if (b.this.IwV.XgJ == 0L) {
        b.this.IwV.XgJ = l;
      }
      super.aJ(paramString, paramBoolean);
      AppMethodBeat.o(80841);
    }
    
    public final void b(m paramm)
    {
      AppMethodBeat.i(297074);
      Log.i("MicroMsg.GameFloatWebView", "jsloader ready");
      b.this.XfI = paramm;
      AppMethodBeat.o(297074);
    }
    
    public final boolean bN(Bundle paramBundle)
    {
      AppMethodBeat.i(80842);
      long l = System.currentTimeMillis();
      if (b.this.IwE.muj == 0L) {
        b.this.IwE.muj = l;
      }
      if (b.this.IwV.XgK == 0L) {
        b.this.IwV.XgK = l;
      }
      boolean bool = super.bN(paramBundle);
      AppMethodBeat.o(80842);
      return bool;
    }
    
    public final boolean bmh(String paramString)
    {
      AppMethodBeat.i(80832);
      boolean bool = b.this.XfF.bnW(paramString);
      AppMethodBeat.o(80832);
      return bool;
    }
    
    public final boolean bmi(String paramString)
    {
      AppMethodBeat.i(80834);
      boolean bool = super.bmi(paramString);
      AppMethodBeat.o(80834);
      return bool;
    }
    
    public final void bmj(String paramString)
    {
      AppMethodBeat.i(80835);
      try
      {
        Log.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
        b.this.bxO.removeView(this.ooz);
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
      WebResourceResponse localWebResourceResponse = b.this.XfF.a(paramWebView, paramString, null);
      if (localWebResourceResponse != null)
      {
        AppMethodBeat.o(80837);
        return localWebResourceResponse;
      }
      paramWebView = super.c(paramWebView, paramString);
      AppMethodBeat.o(80837);
      return paramWebView;
    }
    
    public final p cxM()
    {
      return b.this.XfJ;
    }
    
    public final void f(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(80829);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", new Object[] { paramString, Long.valueOf(l) });
      if (b.this.IwE.muh == 0L) {
        b.this.IwE.muh = l;
      }
      if (b.this.IwV.XgI == 0L) {
        b.this.IwV.XgI = l;
      }
      if (b.this.IwE.mub == 0L)
      {
        b.this.IwE.mub = l;
        b.this.IwU = l;
      }
      this.ooz.setVisibility(0);
      b.this.XfF.bnV(paramString);
      b.this.IwT.XfS.aoZ();
      AppMethodBeat.o(80829);
    }
    
    public final String getSource()
    {
      return i.iag;
    }
    
    public final void iAJ()
    {
      AppMethodBeat.i(80836);
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.ooz.removeJavascriptInterface("MicroMsg");
        this.ooz.removeJavascriptInterface("JsApi");
      }
      try
      {
        this.ooz.setWebChromeClient(null);
        this.ooz.setWebViewClient(null);
        this.ooz.setOnTouchListener(null);
        this.ooz.setOnLongClickListener(null);
        this.ooz.setVisibility(8);
        this.ooz.removeAllViews();
        this.ooz.clearView();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            this.ooz.destroy();
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
    
    public final void iAK()
    {
      AppMethodBeat.i(80840);
      b.this.IwE.muf = System.currentTimeMillis();
      super.iAK();
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
      Object localObject = b.this.XfF.onMiscCallBack(paramString, paramBundle);
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