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
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public abstract class PreLoadWebViewUI
  extends WebViewUI
{
  boolean ARU;
  CountDownLatch BlA = new CountDownLatch(epM() + 2);
  private g BlB;
  private int Blz = -1;
  protected String dtw;
  protected String sessionId;
  
  private Map<String, Object> epR()
  {
    Object localObject = bEx();
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
  
  public final MMWebView bEY()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      this.Blz = ((Intent)localObject).getIntExtra("key_preload_biz", -1);
      ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.Blz) });
    }
    for (localObject = (ai)ag.eic().Sg(this.Blz).gy(this);; localObject = null)
    {
      MMWebView localMMWebView;
      if (localObject != null)
      {
        localMMWebView = (MMWebView)((ai)localObject).AHd;
        this.BlB = ((ai)localObject).AHe;
      }
      for (localObject = localMMWebView;; localObject = null)
      {
        if (localObject == null)
        {
          ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
          this.ARU = false;
          localObject = bEx();
          int i;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            if (bt.aGh(Uri.parse((String)localObject).getQueryParameter("isOpenPreload")) == 1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.plugin.report.service.h.vKh.f(15005, new Object[] { Integer.valueOf(this.Blz), Integer.valueOf(4), Integer.valueOf(0) });
            }
            return MMWebView.a.kk(this);
            i = 0;
            continue;
            i = 0;
          }
        }
        ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { ((MMWebView)localObject).toString() });
        this.ARU = true;
        com.tencent.mm.plugin.report.service.h.vKh.f(15005, new Object[] { Integer.valueOf(this.Blz), Integer.valueOf(3), Integer.valueOf(0) });
        return localObject;
      }
    }
  }
  
  public com.tencent.mm.plugin.webview.core.h bFq()
  {
    com.tencent.mm.plugin.webview.core.h localh = super.bFq();
    if (localh != null) {
      localh.a(new com.tencent.mm.plugin.webview.core.i()
      {
        public final void bFs()
        {
          AppMethodBeat.i(188092);
          PreLoadWebViewUI.this.bFs();
          AppMethodBeat.o(188092);
        }
      });
    }
    return localh;
  }
  
  protected void bFs()
  {
    if (this.ARU)
    {
      com.tencent.e.h.Iye.aS(new Runnable()
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
              PreLoadWebViewUI.this.epI();
              PreLoadWebViewUI.this.AQP.b("onUiInit", PreLoadWebViewUI.this.epQ(), null);
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
    this.AQP.b("onUiInit", epQ(), null);
  }
  
  public void bol()
  {
    super.bol();
    this.BlA.countDown();
    if (b.eEQ())
    {
      if (this.ARU) {
        t.makeText(aj.getContext(), aj.getProcessName() + " use preloaded " + this.nhy.getWebCoreType(), 1).show();
      }
    }
    else {
      return;
    }
    t.makeText(aj.getContext(), aj.getProcessName() + " no preloaded " + this.nhy.getWebCoreType(), 1).show();
  }
  
  public final void enK()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.nhy.setBackgroundResource(17170445);
      this.BgL.setBackgroundResource(17170445);
      this.BgM.setBackgroundResource(17170445);
      return;
    }
    this.nhy.setBackgroundColor(getResources().getColor(2131101159));
  }
  
  public final g eoI()
  {
    return this.BlB;
  }
  
  public final boolean eoJ()
  {
    return this.ARU;
  }
  
  protected void epI() {}
  
  public int epM()
  {
    return 0;
  }
  
  protected Map<String, Object> epN()
  {
    return null;
  }
  
  public final Map<String, Object> epQ()
  {
    Map localMap1 = epR();
    Map localMap2 = epN();
    if (localMap2 != null) {
      localMap1.putAll(localMap2);
    }
    ad.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localMap1.toString() });
    return localMap1;
  }
  
  protected f getJsapi()
  {
    return this.AQP;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.sessionId))
    {
      this.sessionId = getIntent().getStringExtra("sessionId");
      this.dtw = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.dtw)) {
        this.dtw = this.sessionId;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.BlA.countDown();
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