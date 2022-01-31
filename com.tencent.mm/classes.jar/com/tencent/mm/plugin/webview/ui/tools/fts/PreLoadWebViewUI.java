package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.aq;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
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
  protected String bIB;
  protected String bVp;
  private int qUH = -1;
  boolean rvc;
  CountDownLatch rvd = new CountDownLatch(cfB() + 2);
  private ah rve;
  
  private void cfI()
  {
    if (this.rvc) {
      new Thread(new PreLoadWebViewUI.2(this)).start();
    }
  }
  
  public void aoX()
  {
    super.aoX();
    this.rvd.countDown();
    if ((this.rbk != null) && (!this.rbk.ready)) {
      this.rbk.a(new PreLoadWebViewUI.1(this));
    }
    for (;;)
    {
      if (b.cqk())
      {
        if (!this.rvc) {
          break;
        }
        s.makeText(ae.getContext(), "use preloaded webview(安装coolassist时弹出), sys " + aq.bZW().bZX(), 1).show();
      }
      return;
      cfI();
    }
    s.makeText(ae.getContext(), "no preloaded webview(安装coolassist时弹出), sys " + aq.bZW().bZX(), 1).show();
  }
  
  protected final MMWebView bZI()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      this.qUH = ((Intent)localObject1).getIntExtra("key_preload_biz", -1);
      y.i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[] { Integer.valueOf(this.qUH) });
    }
    for (Object localObject2 = (am)ak.bZF().BD(this.qUH).ew(this);; localObject2 = null)
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
        this.rve = ((ah)localObject2);
        if (localObject1 != null) {
          break label234;
        }
        y.i("PreLoadWebViewUI", "no available preloaded webview");
        this.rvc = false;
        localObject1 = caV();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label202;
        }
        if (bk.ZR(Uri.parse((String)localObject1).getQueryParameter("isOpenPreload")) != 1) {
          break label197;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          h.nFQ.f(15005, new Object[] { Integer.valueOf(this.qUH), Integer.valueOf(4), Integer.valueOf(0) });
        }
        if (this.qUH != 2) {
          break label207;
        }
        return MMWebView.a.cO(this);
        localObject1 = (MMWebView)((am)localObject2).qUO;
        break;
        label189:
        localObject2 = ((am)localObject2).qUP;
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
        if (aq.bZW().bZX()) {
          return MMWebView.a.hj(this);
        }
        localObject1 = MMWebView.a.cO(this);
        return localObject1;
      }
      catch (Exception localException)
      {
        return MMWebView.a.cO(this);
      }
      label234:
      y.i("PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[] { localException.toString() });
      this.rvc = true;
      h.nFQ.f(15005, new Object[] { Integer.valueOf(this.qUH), Integer.valueOf(3), Integer.valueOf(0) });
      return localException;
    }
  }
  
  protected final void ceB()
  {
    h.nFQ.f(15005, new Object[] { Integer.valueOf(this.qUH), Integer.valueOf(5), Integer.valueOf(0) });
  }
  
  protected final ah ced()
  {
    return this.rve;
  }
  
  protected final boolean cef()
  {
    return this.rvc;
  }
  
  protected final void ceg()
  {
    this.rvc = false;
  }
  
  public int cfB()
  {
    return 0;
  }
  
  protected Map<String, Object> cfC()
  {
    return null;
  }
  
  public final Map<String, Object> cfJ()
  {
    Object localObject2 = caV();
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
      localObject2 = cfC();
      if (localObject2 != null) {
        ((Map)localObject1).putAll((Map)localObject2);
      }
      y.i("PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[] { localObject1.toString() });
      return localObject1;
      localObject1 = Collections.emptyMap();
    }
  }
  
  protected void cfy() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (TextUtils.isEmpty(this.bIB))
    {
      this.bIB = getIntent().getStringExtra("sessionId");
      this.bVp = getIntent().getStringExtra("subSessionId");
      if (TextUtils.isEmpty(this.bVp)) {
        this.bVp = this.bIB;
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.rvd.countDown();
  }
  
  protected class a
    extends WebViewUI.i
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