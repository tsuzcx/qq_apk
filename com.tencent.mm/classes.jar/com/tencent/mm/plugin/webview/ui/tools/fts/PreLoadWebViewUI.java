package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.b;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PreLoadWebViewUI
  extends WebViewUI
{
  boolean WEv;
  private int WpB = -1;
  private com.tencent.mm.plugin.webview.jsapi.k Xen;
  protected List<Runnable> Xeo;
  private com.tencent.mm.plugin.websearch.webview.j Xep = new com.tencent.mm.plugin.websearch.webview.j(0);
  private boolean Xeq = false;
  protected String hVn;
  protected String sessionId;
  
  private void aT(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().UcS) && (this.Xeq))
    {
      paramRunnable.run();
      return;
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi not ready, waiting");
    if (this.Xeo == null) {
      this.Xeo = new ArrayList();
    }
    this.Xeo.add(paramRunnable);
  }
  
  protected final void aS(final Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aT(paramRunnable);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296855);
        PreLoadWebViewUI.a(PreLoadWebViewUI.this, paramRunnable);
        AppMethodBeat.o(296855);
      }
    });
  }
  
  protected void cxT()
  {
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
    this.Xeq = true;
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "sendOnUIInit isPreload:%s", new Object[] { Boolean.valueOf(this.WEv) });
    aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296859);
        if (PreLoadWebViewUI.b(PreLoadWebViewUI.this)) {
          PreLoadWebViewUI.this.iAm();
        }
        PreLoadWebViewUI.this.WlX.b("onUiInit", PreLoadWebViewUI.this.iAD(), null);
        AppMethodBeat.o(296859);
      }
    });
    if ((this.Xeo != null) && (!this.Xeo.isEmpty()))
    {
      Object localObject = new ArrayList(this.Xeo);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.Xeo.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
    }
  }
  
  public final MMWebView dhw()
  {
    Intent localIntent = getIntent();
    WebSearchWebView localWebSearchWebView = null;
    Object localObject = null;
    if (localIntent != null)
    {
      this.WpB = localIntent.getIntExtra("key_preload_biz", -1);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.WpB) });
      localObject = b.Xfl;
      localObject = b.auJ(this.WpB);
    }
    if (localObject != null)
    {
      this.Xen = ((d)localObject).WpJ;
      localWebSearchWebView = ((d)localObject).TPU;
    }
    if (localWebSearchWebView == null)
    {
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
      this.WEv = false;
      localObject = dgY();
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (Util.safeParseInt(Uri.parse((String)localObject).getQueryParameter("isOpenPreload")) == 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.OAn.b(15005, new Object[] { Integer.valueOf(this.WpB), Integer.valueOf(4), Integer.valueOf(0) });
        }
        localObject = new WebSearchWebView(this);
        ((WebSearchWebView)localObject).addJavascriptInterface(new a(new PreLoadWebViewUI..ExternalSyntheticLambda0((WebSearchWebView)localObject)), "webSearchJSApi");
        return localObject;
        i = 0;
        continue;
        i = 0;
      }
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { localWebSearchWebView.toString() });
    this.WEv = true;
    localWebSearchWebView.bm(this);
    com.tencent.mm.plugin.report.service.h.OAn.b(15005, new Object[] { Integer.valueOf(this.WpB), Integer.valueOf(3), Integer.valueOf(0) });
    return localWebSearchWebView;
  }
  
  public com.tencent.mm.plugin.webview.core.k dhx()
  {
    com.tencent.mm.plugin.webview.core.k localk = super.dhx();
    if (localk != null)
    {
      localk.a(new l()
      {
        public final void cxT()
        {
          AppMethodBeat.i(296866);
          Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
          PreLoadWebViewUI.this.cxT();
          AppMethodBeat.o(296866);
        }
      });
      localk.a(new m()
      {
        public final WebResourceResponse b(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest)
        {
          AppMethodBeat.i(296865);
          paramAnonymousWebView = PreLoadWebViewUI.a(PreLoadWebViewUI.this).a(paramAnonymousWebView, paramAnonymousWebResourceRequest);
          AppMethodBeat.o(296865);
          return paramAnonymousWebView;
        }
      });
    }
    return localk;
  }
  
  protected com.tencent.mm.plugin.webview.jsapi.j getJsapi()
  {
    return this.WlX;
  }
  
  public final Map<String, Object> iAD()
  {
    Map localMap1 = iAE();
    Map localMap2 = iAv();
    if (localMap2 != null) {
      localMap1.putAll(localMap2);
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localMap1.toString() });
    return localMap1;
  }
  
  protected final Map<String, Object> iAE()
  {
    Object localObject = dgY();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      HashMap localHashMap = new HashMap();
      localObject = Uri.parse((String)localObject);
      Iterator localIterator = ((Uri)localObject).getQueryParameterNames().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, ((Uri)localObject).getQueryParameter(str));
      }
      return localHashMap;
    }
    return Collections.emptyMap();
  }
  
  protected void iAm() {}
  
  protected Map<String, Object> iAv()
  {
    return null;
  }
  
  public final void ixx()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.sMP.setBackgroundResource(17170445);
      this.WWX.setBackgroundResource(17170445);
      this.WWY.setBackgroundResource(17170445);
      return;
    }
    this.sMP.setBackgroundColor(getResources().getColor(c.c.websearch_bg));
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.k iyP()
  {
    return this.Xen;
  }
  
  public final boolean iyQ()
  {
    return this.WEv;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sessionId = getIntent().getStringExtra("sessionId");
    this.hVn = Util.nullAs(getIntent().getStringExtra("subSessionId"), this.sessionId);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
 * JD-Core Version:    0.7.0.1
 */