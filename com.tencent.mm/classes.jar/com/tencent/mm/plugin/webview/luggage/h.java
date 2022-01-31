package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.luggage.webview.a;
import com.tencent.luggage.webview.a.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.j;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import java.util.Map;

public class h
  extends MMWebView
  implements a
{
  private o gGh = new h.8(this);
  private Handler mHw = new Handler(Looper.getMainLooper());
  private g rck = new h.5(this);
  private d rcl = new h.6(this);
  private f rcm = new h.7(this);
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.dyX = true;
    if (getX5WebViewExtension() != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.isX5Kernel = bool;
      hi(getContext());
      getSettings().cSs();
      getSettings().setJavaScriptEnabled(true);
      getSettings().setMediaPlaybackRequiresUserGesture(true);
      getSettings().cSu();
      getSettings().setUserAgentString(com.tencent.mm.plugin.webview.luggage.d.b.aX(getContext(), getSettings().getUserAgentString()) + " Luggage");
      getView().setHorizontalScrollBarEnabled(false);
      getView().setVerticalScrollBarEnabled(false);
      setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      super.setWebViewClient(this.rck);
      super.setWebChromeClient(this.rcl);
      if (getIsX5Kernel())
      {
        super.setWebViewCallbackClient(this.gGh);
        super.setWebViewClientExtension(this.rcm);
      }
      cJT();
      return;
    }
  }
  
  public void a(a.a parama)
  {
    runOnUiThread(new h.3(this, parama));
  }
  
  public final void aX(String paramString)
  {
    runOnUiThread(new h.1(this, paramString));
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    super.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean canGoBack()
  {
    return super.canGoBack();
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    runOnUiThread(new h.2(this, paramString, paramValueCallback));
  }
  
  public String getTitle()
  {
    return super.getTitle();
  }
  
  public String getUrl()
  {
    return super.getUrl();
  }
  
  public View getView()
  {
    return this;
  }
  
  public void goBack()
  {
    super.goBack();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadUrl(String paramString)
  {
    super.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    super.loadUrl(paramString, paramMap);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.mHw.post(paramRunnable);
  }
  
  public void setWebChromeClient(j paramj)
  {
    this.rcl.a(paramj);
  }
  
  public void setWebChromeClientProxy(d paramd)
  {
    if (paramd != null)
    {
      this.rcl.a(paramd);
      this.rcl = paramd;
    }
  }
  
  public void setWebViewClient(p paramp)
  {
    this.rck.a(paramp);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    this.rcm.a(paramb);
  }
  
  protected void setWebViewClientExtensionProxy(f paramf)
  {
    if (paramf != null)
    {
      this.rcm.a(paramf);
      this.rcm = paramf;
    }
  }
  
  public void setWebViewClientProxy(g paramg)
  {
    if (paramg != null)
    {
      this.rck.a(paramg);
      this.rck = paramg;
    }
  }
  
  public void stopLoading()
  {
    super.stopLoading();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.h
 * JD-Core Version:    0.7.0.1
 */