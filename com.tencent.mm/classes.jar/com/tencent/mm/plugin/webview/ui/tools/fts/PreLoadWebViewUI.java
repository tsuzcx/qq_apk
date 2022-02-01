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
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
  private int CDK = -1;
  CountDownLatch CDL = new CountDownLatch(eFg() + 2);
  private g CDM;
  boolean Ckh;
  protected String drf;
  protected String sessionId;
  
  private Map<String, Object> eFl()
  {
    Object localObject = bLL();
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
  
  public com.tencent.mm.plugin.webview.core.h bMD()
  {
    com.tencent.mm.plugin.webview.core.h localh = super.bMD();
    if (localh != null) {
      localh.a(new com.tencent.mm.plugin.webview.core.i()
      {
        public final void bMF()
        {
          AppMethodBeat.i(188536);
          ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller js ready");
          PreLoadWebViewUI.this.bMF();
          AppMethodBeat.o(188536);
        }
        
        public final void dKr()
        {
          AppMethodBeat.i(188537);
          ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "controller binded");
          super.dKr();
          AppMethodBeat.o(188537);
        }
      });
    }
    return localh;
  }
  
  protected void bMF()
  {
    if (this.Ckh)
    {
      com.tencent.e.h.JZN.aV(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(80728);
          try
          {
            PreLoadWebViewUI.a(PreLoadWebViewUI.this).await();
            if (PreLoadWebViewUI.b(PreLoadWebViewUI.this))
            {
              ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "send onUiInit to webview");
              PreLoadWebViewUI.this.eFc();
              PreLoadWebViewUI.this.Cjc.b("onUiInit", PreLoadWebViewUI.this.eFk(), null);
            }
            AppMethodBeat.o(80728);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.WebSearch.PreLoadWebViewUI", localInterruptedException, "", new Object[0]);
            }
          }
        }
      });
      return;
    }
    this.Cjc.b("onUiInit", eFk(), null);
  }
  
  public final MMWebView bMm()
  {
    Object localObject1 = getIntent();
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      this.CDK = ((Intent)localObject1).getIntExtra("key_preload_biz", -1);
      ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.CDK) });
      localObject1 = ae.exw();
      i = this.CDK;
      if (((ae)localObject1).BZj.containsKey(Integer.valueOf(i)))
      {
        localObject2 = (af)((ae)localObject1).BZj.get(Integer.valueOf(i));
        if (!ai.eVe()) {
          ac.i(((af)localObject2).TAG, "getWebView not in toolsmp process");
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
        localObject2 = ((ag)localObject1).gGd;
        this.CDM = ((ag)localObject1).BZv;
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 == null)
        {
          ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
          this.Ckh = false;
          localObject1 = bLL();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            if (bs.aLy(Uri.parse((String)localObject1).getQueryParameter("isOpenPreload")) == 1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              com.tencent.mm.plugin.report.service.h.wUl.f(15005, new Object[] { Integer.valueOf(this.CDK), Integer.valueOf(4), Integer.valueOf(0) });
            }
            return MMWebView.a.kv(this);
            ac.i(((af)localObject2).TAG, "getWebView cached webview size %d %s", new Object[] { Integer.valueOf(((af)localObject2).BZp.size()), ((af)localObject2).GZS });
            if ((((af)localObject2).GZS.get()) || (((af)localObject2).BZp.size() <= 0))
            {
              localObject1 = null;
              break;
            }
            localObject1 = (ag)((af)localObject2).BZp.get(0);
            ((af)localObject2).BZp.remove(0);
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
        ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { ((MMWebView)localObject1).toString() });
        this.Ckh = true;
        com.tencent.mm.plugin.report.service.h.wUl.f(15005, new Object[] { Integer.valueOf(this.CDK), Integer.valueOf(3), Integer.valueOf(0) });
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public void bvh()
  {
    super.bvh();
    this.CDL.countDown();
    if (b.eUk())
    {
      if (this.Ckh) {
        t.makeText(ai.getContext(), ai.getProcessName() + " use preloaded " + this.nKq.getWebCoreType(), 1).show();
      }
    }
    else {
      return;
    }
    t.makeText(ai.getContext(), ai.getProcessName() + " no preloaded " + this.nKq.getWebCoreType(), 1).show();
  }
  
  public final void eDd()
  {
    int i = getIntent().getIntExtra("webview_bg_color_rsID", -1);
    if ((i != -1) && (getContentView() != null))
    {
      setBackGroundColorResource(i);
      getContentView().setBackgroundResource(i);
      this.nKq.setBackgroundResource(17170445);
      this.CyY.setBackgroundResource(17170445);
      this.CyZ.setBackgroundResource(17170445);
      return;
    }
    this.nKq.setBackgroundColor(getResources().getColor(2131101159));
  }
  
  public final g eEd()
  {
    return this.CDM;
  }
  
  public final boolean eEe()
  {
    return this.Ckh;
  }
  
  protected void eFc() {}
  
  public int eFg()
  {
    return 0;
  }
  
  protected Map<String, Object> eFh()
  {
    return null;
  }
  
  public final Map<String, Object> eFk()
  {
    Map localMap1 = eFl();
    Map localMap2 = eFh();
    if (localMap2 != null) {
      localMap1.putAll(localMap2);
    }
    ac.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localMap1.toString() });
    return localMap1;
  }
  
  protected f getJsapi()
  {
    return this.Cjc;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.sessionId))
    {
      this.sessionId = getIntent().getStringExtra("sessionId");
      this.drf = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.drf)) {
        this.drf = this.sessionId;
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
    this.CDL.countDown();
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