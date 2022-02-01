package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PreLoadWebViewUI
  extends WebViewUI
{
  boolean DNn;
  private int Ehv = -1;
  CountDownLatch Ehw = new CountDownLatch(eUb() + 2);
  private com.tencent.mm.plugin.webview.c.g Ehx;
  protected String dCW;
  protected String sessionId;
  
  private Map<String, Object> eUh()
  {
    Object localObject = bQm();
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
  
  public final MMWebView bQN()
  {
    Object localObject1 = getIntent();
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      this.Ehv = ((Intent)localObject1).getIntExtra("key_preload_biz", -1);
      ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.Ehv) });
      localObject1 = ai.eMn();
      i = this.Ehv;
      if (((ai)localObject1).DCf.containsKey(Integer.valueOf(i)))
      {
        localObject2 = (com.tencent.mm.plugin.websearch.api.aj)((ai)localObject1).DCf.get(Integer.valueOf(i));
        if (!com.tencent.mm.sdk.platformtools.aj.fkJ()) {
          ad.i(((com.tencent.mm.plugin.websearch.api.aj)localObject2).TAG, "getWebView not in toolsmp process");
        }
      }
      else
      {
        localObject1 = null;
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = ((ak)localObject1).gZN;
        this.Ehx = ((ak)localObject1).DCr;
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
          this.DNn = false;
          localObject1 = bQm();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            if (bt.aRe(Uri.parse((String)localObject1).getQueryParameter("isOpenPreload")) == 1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.plugin.report.service.g.yhR.f(15005, new Object[] { Integer.valueOf(this.Ehv), Integer.valueOf(4), Integer.valueOf(0) });
            }
            return MMWebView.a.kH(this);
            ad.i(((com.tencent.mm.plugin.websearch.api.aj)localObject2).TAG, "getWebView cached webview size %d %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCl.size()), ((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCk });
            if ((((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCk.get()) || (((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCl.size() <= 0))
            {
              localObject1 = null;
              break;
            }
            localObject1 = (ak)((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCl.get(0);
            ((com.tencent.mm.plugin.websearch.api.aj)localObject2).DCl.remove(0);
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
        ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { ((MMWebView)localObject1).toString() });
        this.DNn = true;
        com.tencent.mm.plugin.report.service.g.yhR.f(15005, new Object[] { Integer.valueOf(this.Ehv), Integer.valueOf(3), Integer.valueOf(0) });
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public com.tencent.mm.plugin.webview.core.h bRd()
  {
    com.tencent.mm.plugin.webview.core.h localh = super.bRd();
    if (localh != null) {
      localh.a(new com.tencent.mm.plugin.webview.core.i()
      {
        public final void bRf()
        {
          AppMethodBeat.i(208206);
          ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller js ready");
          PreLoadWebViewUI.this.bRf();
          AppMethodBeat.o(208206);
        }
        
        public final void dWE()
        {
          AppMethodBeat.i(208207);
          ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller binded");
          super.dWE();
          AppMethodBeat.o(208207);
        }
      });
    }
    return localh;
  }
  
  protected void bRf()
  {
    if (this.DNn)
    {
      com.tencent.e.h.LTJ.aU(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80728);
          try
          {
            PreLoadWebViewUI.a(PreLoadWebViewUI.this).await();
            if (PreLoadWebViewUI.b(PreLoadWebViewUI.this))
            {
              ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "send onUiInit to webview");
              PreLoadWebViewUI.this.eTV();
              PreLoadWebViewUI.this.DzP.b("onUiInit", PreLoadWebViewUI.this.eUg(), null);
            }
            AppMethodBeat.o(80728);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.WebSearch.PreLoadWebViewUI", localInterruptedException, "", new Object[0]);
            }
          }
        }
      });
      return;
    }
    this.DzP.b("onUiInit", eUg(), null);
  }
  
  public void bzn()
  {
    super.bzn();
    this.Ehw.countDown();
    if (b.fjN())
    {
      if (this.DNn) {
        t.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), com.tencent.mm.sdk.platformtools.aj.getProcessName() + " use preloaded " + this.omW.getWebCoreType(), 1).show();
      }
    }
    else {
      return;
    }
    t.makeText(com.tencent.mm.sdk.platformtools.aj.getContext(), com.tencent.mm.sdk.platformtools.aj.getProcessName() + " no preloaded " + this.omW.getWebCoreType(), 1).show();
  }
  
  public final void eRV()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.omW.setBackgroundResource(17170445);
      this.EcH.setBackgroundResource(17170445);
      this.EcI.setBackgroundResource(17170445);
      return;
    }
    this.omW.setBackgroundColor(getResources().getColor(2131101159));
  }
  
  public final com.tencent.mm.plugin.webview.c.g eSV()
  {
    return this.Ehx;
  }
  
  public final boolean eSW()
  {
    return this.DNn;
  }
  
  protected void eTV() {}
  
  public int eUb()
  {
    return 0;
  }
  
  protected Map<String, Object> eUc()
  {
    return null;
  }
  
  public final Map<String, Object> eUg()
  {
    Map localMap1 = eUh();
    Map localMap2 = eUc();
    if (localMap2 != null) {
      localMap1.putAll(localMap2);
    }
    ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localMap1.toString() });
    return localMap1;
  }
  
  protected f getJsapi()
  {
    return this.DzP;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.sessionId))
    {
      this.sessionId = getIntent().getStringExtra("sessionId");
      this.dCW = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.dCW)) {
        this.dCW = this.sessionId;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    this.Ehw.countDown();
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