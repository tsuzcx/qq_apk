package com.tencent.mm.plugin.webview.luggage.d;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.k;
import com.tencent.luggage.g.i;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.p;
import com.tencent.xweb.t;
import com.tencent.xweb.v;
import com.tencent.xweb.w;
import java.io.File;
import java.util.Map;

public class a
  extends MMWebView
  implements com.tencent.luggage.webview.a
{
  private k bzs;
  private v igO;
  public String nYv;
  private Handler phC;
  protected LuggageGetA8Key uRC;
  private g uUV;
  private com.tencent.mm.plugin.webview.luggage.d uUW;
  private f uUX;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(6534);
    this.uUV = new a.5(this);
    this.uUW = new a.6(this);
    this.uUX = new a.7(this);
    this.igO = new a.8(this);
    this.uRC = new LuggageGetA8Key();
    this.phC = new Handler(Looper.getMainLooper());
    this.inited = true;
    boolean bool;
    if (getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      this.isX5Kernel = bool;
      u.a.fO(getContext());
      if ((!getIsX5Kernel()) && (!com.tencent.mm.compatible.util.d.fv(19))) {}
      try
      {
        paramContext = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mProvider", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mWebViewCore", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "sWebCoreHandler", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mLooper", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mThread", null).get();
        ab.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramContext });
        if ((paramContext instanceof Thread))
        {
          paramContext = (Thread)paramContext;
          ab.i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramContext.getState() });
          if (paramContext.getState() == Thread.State.WAITING) {
            paramContext.interrupt();
          }
        }
        iG(getContext());
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().dYx();
        getSettings().dYs();
        getSettings().dYr();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(true);
        getSettings().dYz();
        getSettings().dYv();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().dYu();
        getSettings().dYw();
        getSettings().setDatabasePath(e.eQu + "databases/");
        com.tencent.xweb.b.dYg().dYh();
        com.tencent.xweb.b.dYg().f(this);
        getSettings().setUserAgentString(u.bD(getContext(), getSettings().getUserAgentString()) + " Luggage");
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        super.setWebViewClient(this.uUV);
        super.setWebChromeClient(this.uUW);
        if (getIsX5Kernel())
        {
          super.setWebViewCallbackClient(this.igO);
          super.setWebViewClientExtension(this.uUX);
        }
        dOM();
        AppMethodBeat.o(6534);
        return;
        bool = false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ab.e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramContext });
        }
      }
    }
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(6542);
    runOnUiThread(new a.3(this, parama));
    AppMethodBeat.o(6542);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(6537);
    super.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(6537);
  }
  
  public final void by(String paramString)
  {
    AppMethodBeat.i(6538);
    runOnUiThread(new a.1(this, paramString));
    AppMethodBeat.o(6538);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(6550);
    boolean bool = super.canGoBack();
    AppMethodBeat.o(6550);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(6551);
    super.destroy();
    AppMethodBeat.o(6551);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(6539);
    runOnUiThread(new a.2(this, paramString, paramValueCallback));
    AppMethodBeat.o(6539);
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(6548);
    String str = super.getTitle();
    AppMethodBeat.o(6548);
    return str;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(6547);
    String str = super.getUrl();
    AppMethodBeat.o(6547);
    return str;
  }
  
  public View getView()
  {
    return this;
  }
  
  public k getWebCore()
  {
    return this.bzs;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(6549);
    super.goBack();
    AppMethodBeat.o(6549);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6545);
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(6545);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(6543);
    super.loadUrl(paramString);
    AppMethodBeat.o(6543);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(6544);
    super.loadUrl(paramString, paramMap);
    AppMethodBeat.o(6544);
  }
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(6536);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(6536);
      return;
    }
    this.phC.post(paramRunnable);
    AppMethodBeat.o(6536);
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(6535);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    AppMethodBeat.o(6535);
  }
  
  public void setSource(String paramString)
  {
    this.nYv = paramString;
  }
  
  public void setWebChromeClient(p paramp)
  {
    AppMethodBeat.i(6554);
    this.uUW.a(paramp);
    AppMethodBeat.o(6554);
  }
  
  protected void setWebChromeClientProxy(com.tencent.mm.plugin.webview.luggage.d paramd)
  {
    AppMethodBeat.i(6555);
    if (paramd != null)
    {
      this.uUW.a(paramd);
      this.uUW = paramd;
    }
    AppMethodBeat.o(6555);
  }
  
  public void setWebCore(k paramk)
  {
    AppMethodBeat.i(6540);
    this.bzs = paramk;
    us();
    AppMethodBeat.o(6540);
  }
  
  public void setWebViewClient(w paramw)
  {
    AppMethodBeat.i(6552);
    this.uUV.a(paramw);
    AppMethodBeat.o(6552);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    AppMethodBeat.i(6556);
    this.uUX.a(paramb);
    AppMethodBeat.o(6556);
  }
  
  protected void setWebViewClientExtensionProxy(f paramf)
  {
    AppMethodBeat.i(6557);
    if (paramf != null)
    {
      this.uUX.a(paramf);
      this.uUX = paramf;
    }
    AppMethodBeat.o(6557);
  }
  
  protected void setWebViewClientProxy(g paramg)
  {
    AppMethodBeat.i(6553);
    if (paramg != null)
    {
      this.uUV.a(paramg);
      this.uUV = paramg;
    }
    AppMethodBeat.o(6553);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(6546);
    super.stopLoading();
    AppMethodBeat.o(6546);
  }
  
  protected void us()
  {
    AppMethodBeat.i(6541);
    if (getWebCore().bzi != null)
    {
      getWebCore().bzi.a(new LuggageMMLocalResourceProvider());
      getWebCore().bzi.a(new com.tencent.mm.plugin.webview.luggage.c(i.p(ah.getContext(), "luggage_mm_adapter.js")));
    }
    AppMethodBeat.o(6541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */