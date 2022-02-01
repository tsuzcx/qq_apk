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
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  boolean Efm;
  CountDownLatch EzA = new CountDownLatch(eXO() + 2);
  private com.tencent.mm.plugin.webview.c.g EzB;
  private int Ezz = -1;
  protected String dEb;
  protected String sessionId;
  
  private Map<String, Object> eXU()
  {
    Object localObject = bRn();
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
  
  public void bAi()
  {
    super.bAi();
    this.EzA.countDown();
    if (b.fnF())
    {
      if (this.Efm) {
        t.makeText(com.tencent.mm.sdk.platformtools.ak.getContext(), com.tencent.mm.sdk.platformtools.ak.getProcessName() + " use preloaded " + this.osM.getWebCoreType(), 1).show();
      }
    }
    else {
      return;
    }
    t.makeText(com.tencent.mm.sdk.platformtools.ak.getContext(), com.tencent.mm.sdk.platformtools.ak.getProcessName() + " no preloaded " + this.osM.getWebCoreType(), 1).show();
  }
  
  public final MMWebView bRO()
  {
    Object localObject1 = getIntent();
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      this.Ezz = ((Intent)localObject1).getIntExtra("key_preload_biz", -1);
      ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.Ezz) });
      localObject1 = ai.ePW();
      i = this.Ezz;
      if (((ai)localObject1).DUc.containsKey(Integer.valueOf(i)))
      {
        localObject2 = (aj)((ai)localObject1).DUc.get(Integer.valueOf(i));
        if (!com.tencent.mm.sdk.platformtools.ak.foD()) {
          ae.i(((aj)localObject2).TAG, "getWebView not in toolsmp process");
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
        localObject2 = ((com.tencent.mm.plugin.websearch.api.ak)localObject1).hcA;
        this.EzB = ((com.tencent.mm.plugin.websearch.api.ak)localObject1).DUo;
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
          this.Efm = false;
          localObject1 = bRn();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            if (bu.aSB(Uri.parse((String)localObject1).getQueryParameter("isOpenPreload")) == 1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.plugin.report.service.g.yxI.f(15005, new Object[] { Integer.valueOf(this.Ezz), Integer.valueOf(4), Integer.valueOf(0) });
            }
            return MMWebView.a.kO(this);
            ae.i(((aj)localObject2).TAG, "getWebView cached webview size %d %s", new Object[] { Integer.valueOf(((aj)localObject2).DUi.size()), ((aj)localObject2).DUh });
            if ((((aj)localObject2).DUh.get()) || (((aj)localObject2).DUi.size() <= 0))
            {
              localObject1 = null;
              break;
            }
            localObject1 = (com.tencent.mm.plugin.websearch.api.ak)((aj)localObject2).DUi.get(0);
            ((aj)localObject2).DUi.remove(0);
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
        ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { ((MMWebView)localObject1).toString() });
        this.Efm = true;
        com.tencent.mm.plugin.report.service.g.yxI.f(15005, new Object[] { Integer.valueOf(this.Ezz), Integer.valueOf(3), Integer.valueOf(0) });
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public com.tencent.mm.plugin.webview.core.h bSe()
  {
    com.tencent.mm.plugin.webview.core.h localh = super.bSe();
    if (localh != null) {
      localh.a(new com.tencent.mm.plugin.webview.core.i()
      {
        public final void bSg()
        {
          AppMethodBeat.i(198384);
          ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller js ready");
          PreLoadWebViewUI.this.bSg();
          AppMethodBeat.o(198384);
        }
        
        public final void eag()
        {
          AppMethodBeat.i(198385);
          ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller binded");
          super.eag();
          AppMethodBeat.o(198385);
        }
      });
    }
    return localh;
  }
  
  protected void bSg()
  {
    if (this.Efm)
    {
      com.tencent.e.h.MqF.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80728);
          try
          {
            PreLoadWebViewUI.a(PreLoadWebViewUI.this).await();
            if (PreLoadWebViewUI.b(PreLoadWebViewUI.this))
            {
              ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "send onUiInit to webview");
              PreLoadWebViewUI.this.eXI();
              PreLoadWebViewUI.this.DRx.b("onUiInit", PreLoadWebViewUI.this.eXT(), null);
            }
            AppMethodBeat.o(80728);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.WebSearch.PreLoadWebViewUI", localInterruptedException, "", new Object[0]);
            }
          }
        }
      });
      return;
    }
    this.DRx.b("onUiInit", eXT(), null);
  }
  
  public final void eVH()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.osM.setBackgroundResource(17170445);
      this.EuJ.setBackgroundResource(17170445);
      this.EuK.setBackgroundResource(17170445);
      return;
    }
    this.osM.setBackgroundColor(getResources().getColor(2131101159));
  }
  
  public final com.tencent.mm.plugin.webview.c.g eWI()
  {
    return this.EzB;
  }
  
  public final boolean eWJ()
  {
    return this.Efm;
  }
  
  protected void eXI() {}
  
  public int eXO()
  {
    return 0;
  }
  
  protected Map<String, Object> eXP()
  {
    return null;
  }
  
  public final Map<String, Object> eXT()
  {
    Map localMap1 = eXU();
    Map localMap2 = eXP();
    if (localMap2 != null) {
      localMap1.putAll(localMap2);
    }
    ae.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localMap1.toString() });
    return localMap1;
  }
  
  protected f getJsapi()
  {
    return this.DRx;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.sessionId))
    {
      this.sessionId = getIntent().getStringExtra("sessionId");
      this.dEb = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.dEb)) {
        this.dEb = this.sessionId;
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
    this.EzA.countDown();
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