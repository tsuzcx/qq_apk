package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  protected String cCW;
  protected String cpW;
  private int uJR = -1;
  boolean vlr;
  CountDownLatch vls = new CountDownLatch(dfL() + 2);
  private com.tencent.mm.plugin.websearch.api.ah vlt;
  
  private void dfR()
  {
    if (this.vlr) {
      new Thread(new PreLoadWebViewUI.2(this)).start();
    }
  }
  
  public void aMf()
  {
    super.aMf();
    this.vls.countDown();
    if ((this.uQS != null) && (!this.uQS.ready)) {
      this.uQS.a(new PreLoadWebViewUI.1(this));
    }
    for (;;)
    {
      if (b.dsf())
      {
        if (!this.vlr) {
          break;
        }
        t.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "use preloaded webview(安装coolassist时弹出), sys " + ap.cZR().cZS(), 1).show();
      }
      return;
      dfR();
    }
    t.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "no preloaded webview(安装coolassist时弹出), sys " + ap.cZR().cZS(), 1).show();
  }
  
  public final boolean aYS()
  {
    return this.vlr;
  }
  
  public final MMWebView aYh()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      this.uJR = ((Intent)localObject1).getIntExtra("key_preload_biz", -1);
      ab.i("MicroMsg.WebSearch.PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.uJR) });
    }
    for (Object localObject2 = (al)aj.cZB().Jr(this.uJR).ft(this);; localObject2 = null)
    {
      label73:
      int i;
      if (localObject2 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label189;
        }
        localObject2 = null;
        this.vlt = ((com.tencent.mm.plugin.websearch.api.ah)localObject2);
        if (localObject1 != null) {
          break label234;
        }
        ab.i("MicroMsg.WebSearch.PreLoadWebViewUI", "no available preloaded webview");
        this.vlr = false;
        localObject1 = daZ();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label202;
        }
        if (bo.apV(Uri.parse((String)localObject1).getQueryParameter("isOpenPreload")) != 1) {
          break label197;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          h.qsU.e(15005, new Object[] { Integer.valueOf(this.uJR), Integer.valueOf(4), Integer.valueOf(0) });
        }
        if (this.uJR != 2) {
          break label207;
        }
        return MMWebView.a.iI(this);
        localObject1 = (MMWebView)((al)localObject2).uJY;
        break;
        label189:
        localObject2 = ((al)localObject2).uJZ;
        break label73;
        label197:
        i = 0;
        continue;
        label202:
        i = 0;
      }
      try
      {
        label207:
        if (ap.cZR().cZS()) {
          return MMWebView.a.iH(this);
        }
        localObject1 = MMWebView.a.iI(this);
        return localObject1;
      }
      catch (Exception localException)
      {
        return MMWebView.a.iI(this);
      }
      label234:
      ab.i("MicroMsg.WebSearch.PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { localException.toString() });
      this.vlr = true;
      h.qsU.e(15005, new Object[] { Integer.valueOf(this.uJR), Integer.valueOf(3), Integer.valueOf(0) });
      return localException;
    }
  }
  
  public final void deH()
  {
    h.qsU.e(15005, new Object[] { Integer.valueOf(this.uJR), Integer.valueOf(5), Integer.valueOf(0) });
  }
  
  public final com.tencent.mm.plugin.websearch.api.ah der()
  {
    return this.vlt;
  }
  
  public final void des()
  {
    this.vlr = false;
  }
  
  protected void dfG() {}
  
  public int dfL()
  {
    return 0;
  }
  
  protected Map<String, Object> dfM()
  {
    return null;
  }
  
  public final Map<String, Object> dfS()
  {
    Object localObject2 = daZ();
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
      localObject2 = dfM();
      if (localObject2 != null) {
        ((Map)localObject1).putAll((Map)localObject2);
      }
      ab.i("MicroMsg.WebSearch.PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localObject1.toString() });
      return localObject1;
      localObject1 = Collections.emptyMap();
    }
  }
  
  protected d getJsapi()
  {
    return this.uQS;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.cpW))
    {
      this.cpW = getIntent().getStringExtra("sessionId");
      this.cCW = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.cCW)) {
        this.cCW = this.cpW;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.vls.countDown();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected class a
    extends WebViewUI.h
  {
    protected a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
 * JD-Core Version:    0.7.0.1
 */