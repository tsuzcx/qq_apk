package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
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
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.b;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
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
  boolean POj;
  private int Pzt = -1;
  private com.tencent.mm.plugin.webview.d.i Qma;
  protected List<Runnable> Qmb;
  private boolean Qmc = false;
  protected String fPs;
  protected String sessionId;
  
  private void aK(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().NoX) && (this.Qmc))
    {
      paramRunnable.run();
      return;
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi not ready, waiting");
    if (this.Qmb == null) {
      this.Qmb = new ArrayList();
    }
    this.Qmb.add(paramRunnable);
  }
  
  protected final void aJ(final Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aK(paramRunnable);
      return;
    }
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(222172);
        PreLoadWebViewUI.a(PreLoadWebViewUI.this, paramRunnable);
        AppMethodBeat.o(222172);
      }
    });
  }
  
  protected void bXI()
  {
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
    this.Qmc = true;
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "sendOnUIInit isPreload:%s", new Object[] { Boolean.valueOf(this.POj) });
    aJ(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80728);
        if (PreLoadWebViewUI.a(PreLoadWebViewUI.this)) {
          PreLoadWebViewUI.this.hag();
        }
        PreLoadWebViewUI.this.PvJ.b("onUiInit", PreLoadWebViewUI.this.has(), null);
        AppMethodBeat.o(80728);
      }
    });
    if ((this.Qmb != null) && (!this.Qmb.isEmpty()))
    {
      Object localObject = new ArrayList(this.Qmb);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.Qmb.clear();
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
  
  public final MMWebView cDU()
  {
    Intent localIntent = getIntent();
    WebSearchWebView localWebSearchWebView = null;
    Object localObject = null;
    if (localIntent != null)
    {
      this.Pzt = localIntent.getIntExtra("key_preload_biz", -1);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.Pzt) });
      localObject = b.QmW;
      localObject = b.aoO(this.Pzt);
    }
    if (localObject != null)
    {
      this.Qma = ((d)localObject).PzB;
      localWebSearchWebView = ((d)localObject).Ndj;
    }
    if (localWebSearchWebView == null)
    {
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
      this.POj = false;
      localObject = cDu();
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (Util.safeParseInt(Uri.parse((String)localObject).getQueryParameter("isOpenPreload")) == 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.IzE.a(15005, new Object[] { Integer.valueOf(this.Pzt), Integer.valueOf(4), Integer.valueOf(0) });
        }
        localObject = new WebSearchWebView(this);
        ((WebSearchWebView)localObject).addJavascriptInterface(new a(this), "webSearchJSApi");
        return localObject;
        i = 0;
        continue;
        i = 0;
      }
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { localWebSearchWebView.toString() });
    this.POj = true;
    localWebSearchWebView.aD(this);
    com.tencent.mm.plugin.report.service.h.IzE.a(15005, new Object[] { Integer.valueOf(this.Pzt), Integer.valueOf(3), Integer.valueOf(0) });
    return localWebSearchWebView;
  }
  
  public com.tencent.mm.plugin.webview.core.i cDV()
  {
    com.tencent.mm.plugin.webview.core.i locali = super.cDV();
    if (locali != null) {
      locali.a(new j()
      {
        public final void bXI()
        {
          AppMethodBeat.i(237566);
          Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
          PreLoadWebViewUI.this.bXI();
          AppMethodBeat.o(237566);
        }
      });
    }
    return locali;
  }
  
  public final void gXB()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.pHS.setBackgroundResource(17170445);
      this.Qfa.setBackgroundResource(17170445);
      this.Qfb.setBackgroundResource(17170445);
      return;
    }
    this.pHS.setBackgroundColor(getResources().getColor(c.c.websearch_bg));
  }
  
  public final com.tencent.mm.plugin.webview.d.i gYS()
  {
    return this.Qma;
  }
  
  public final boolean gYT()
  {
    return this.POj;
  }
  
  protected com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    return this.PvJ;
  }
  
  protected void hag() {}
  
  protected Map<String, Object> hao()
  {
    return null;
  }
  
  public final Map<String, Object> has()
  {
    Object localObject2 = cDu();
    Object localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new HashMap();
      localObject2 = Uri.parse((String)localObject2);
      Iterator localIterator = ((Uri)localObject2).getQueryParameterNames().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject1).put(str, ((Uri)localObject2).getQueryParameter(str));
      }
    }
    for (;;)
    {
      localObject2 = hao();
      if (localObject2 != null) {
        ((Map)localObject1).putAll((Map)localObject2);
      }
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localObject1.toString() });
      return localObject1;
      localObject1 = Collections.emptyMap();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.sessionId = getIntent().getStringExtra("sessionId");
    this.fPs = Util.nullAs(getIntent().getStringExtra("subSessionId"), this.sessionId);
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