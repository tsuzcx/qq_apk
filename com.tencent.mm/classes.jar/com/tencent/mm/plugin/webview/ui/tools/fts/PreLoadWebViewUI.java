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
  private int IFb = -1;
  boolean IRT;
  private com.tencent.mm.plugin.webview.d.i JoG;
  protected List<Runnable> JoH;
  private boolean JoI = false;
  protected String dVO;
  protected String sessionId;
  
  private void aE(Runnable paramRunnable)
  {
    if ((getJsapi() != null) && (getJsapi().GBl) && (this.JoI))
    {
      paramRunnable.run();
      return;
    }
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi not ready, waiting");
    if (this.JoH == null) {
      this.JoH = new ArrayList();
    }
    this.JoH.add(paramRunnable);
  }
  
  protected final void aD(final Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aE(paramRunnable);
      return;
    }
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211291);
        PreLoadWebViewUI.a(PreLoadWebViewUI.this, paramRunnable);
        AppMethodBeat.o(211291);
      }
    });
  }
  
  public com.tencent.mm.plugin.webview.core.i cpO()
  {
    com.tencent.mm.plugin.webview.core.i locali = super.cpO();
    if (locali != null) {
      locali.a(new j()
      {
        public final void cpR()
        {
          AppMethodBeat.i(211290);
          Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
          PreLoadWebViewUI.this.cpR();
          AppMethodBeat.o(211290);
        }
      });
    }
    return locali;
  }
  
  protected void cpR()
  {
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "onJsReady");
    this.JoI = true;
    Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "sendOnUIInit isPreload:%s", new Object[] { Boolean.valueOf(this.IRT) });
    aD(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80728);
        if (PreLoadWebViewUI.a(PreLoadWebViewUI.this)) {
          PreLoadWebViewUI.this.ggQ();
        }
        PreLoadWebViewUI.this.IBw.b("onUiInit", PreLoadWebViewUI.this.ggZ(), null);
        AppMethodBeat.o(80728);
      }
    });
    if ((this.JoH != null) && (!this.JoH.isEmpty()))
    {
      Object localObject = new ArrayList(this.JoH);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "jsapi ready callback, running jsapi count %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
      this.JoH.clear();
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
  
  public final MMWebView cpy()
  {
    Intent localIntent = getIntent();
    WebSearchWebView localWebSearchWebView = null;
    Object localObject = null;
    if (localIntent != null)
    {
      this.IFb = localIntent.getIntExtra("key_preload_biz", -1);
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.IFb) });
      localObject = b.JpB;
      localObject = b.agX(this.IFb);
    }
    if (localObject != null)
    {
      this.JoG = ((d)localObject).IFj;
      localWebSearchWebView = ((d)localObject).Gqy;
    }
    if (localWebSearchWebView == null)
    {
      Log.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
      this.IRT = false;
      localObject = coX();
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        if (Util.safeParseInt(Uri.parse((String)localObject).getQueryParameter("isOpenPreload")) == 1) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.a(15005, new Object[] { Integer.valueOf(this.IFb), Integer.valueOf(4), Integer.valueOf(0) });
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
    this.IRT = true;
    localWebSearchWebView.aG(this);
    com.tencent.mm.plugin.report.service.h.CyF.a(15005, new Object[] { Integer.valueOf(this.IFb), Integer.valueOf(3), Integer.valueOf(0) });
    return localWebSearchWebView;
  }
  
  public final void geA()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.pGj.setBackgroundResource(17170445);
      this.Jic.setBackgroundResource(17170445);
      this.Jid.setBackgroundResource(17170445);
      return;
    }
    this.pGj.setBackgroundColor(getResources().getColor(2131101402));
  }
  
  protected com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    return this.IBw;
  }
  
  public final com.tencent.mm.plugin.webview.d.i gfG()
  {
    return this.JoG;
  }
  
  public final boolean gfH()
  {
    return this.IRT;
  }
  
  protected void ggQ() {}
  
  protected Map<String, Object> ggW()
  {
    return null;
  }
  
  public final Map<String, Object> ggZ()
  {
    Object localObject2 = coX();
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
      localObject2 = ggW();
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
    this.dVO = Util.nullAs(getIntent().getStringExtra("subSessionId"), this.sessionId);
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