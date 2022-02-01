package com.tencent.mm.plugin.webview.luggage.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.k;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.h;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ab;
import com.tencent.xweb.w;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class a
  extends MMWebView
  implements com.tencent.luggage.webview.a
{
  protected com.tencent.mm.plugin.webview.e.c ATm;
  private g AWA;
  private WeakReference<f> AWx;
  private h AWy;
  private e AWz;
  private k caI;
  private aa kwV;
  private boolean mDestroyed;
  public String sMt;
  private Handler ugg;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78800);
    this.mDestroyed = false;
    this.AWy = new h()
    {
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(78799);
        ad.i(getClass().getSimpleName(), "onPageStarted");
        super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(78799);
      }
    };
    this.AWz = new e() {};
    this.AWA = new g()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(78778);
        a.b(a.this).beA();
        super.computeScroll(paramAnonymousView);
        AppMethodBeat.o(78778);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(78774);
        if ((a.b(a.this).C(paramAnonymousMotionEvent)) || (super.dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
        {
          AppMethodBeat.o(78774);
          return true;
        }
        AppMethodBeat.o(78774);
        return false;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(78773);
        if ((a.b(a.this).D(paramAnonymousMotionEvent)) || (super.onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
        {
          AppMethodBeat.o(78773);
          return true;
        }
        AppMethodBeat.o(78773);
        return false;
      }
      
      public final Object onMiscCallBack(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(78771);
        if (a.a(a.this).get() == null)
        {
          ad.i("MicroMsg.LuggageMMWebViewCoreImpl", "page is null");
          paramAnonymousString = super.onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString == null)
        {
          ad.i("MicroMsg.LuggageMMWebViewCoreImpl", "method is null");
          paramAnonymousString = super.onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        String str;
        if (paramAnonymousString.equals("getDrawable"))
        {
          str = paramAnonymousBundle.getString("packageName");
          int i = paramAnonymousBundle.getInt("resourceId");
          if ((!bt.isNullOrNil(str)) && (i > 0)) {
            try
            {
              Drawable localDrawable = com.tencent.mm.ce.b.f(aj.getContext().getPackageManager().getResourcesForApplication(str), i);
              AppMethodBeat.o(78771);
              return localDrawable;
            }
            catch (Exception localException2)
            {
              ad.e("MicroMsg.LuggageMMWebViewCoreImpl", "get resource for package : %s, fail, : %s", new Object[] { str, localException2.getMessage() });
            }
          }
        }
        if (paramAnonymousString.equals("getShareUrl")) {
          try
          {
            str = ((f)a.a(a.this).get()).ekW().awT(a.this.getUrl());
            ad.i("MicroMsg.LuggageMMWebViewCoreImpl", "getShareUrl by x5 core, shareurl = %s", new Object[] { str });
            AppMethodBeat.o(78771);
            return str;
          }
          catch (Exception localException1)
          {
            ad.e("MicroMsg.LuggageMMWebViewCoreImpl", "getShare url failed");
          }
        }
        if (paramAnonymousString.equals("supportImagePreview"))
        {
          ad.i("MicroMsg.LuggageMMWebViewCoreImpl", "supportImagePreview");
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString.equals("imagePreview"))
        {
          j.a(paramAnonymousBundle, ((f)a.a(a.this).get()).getWebView(), null, ((f)a.a(a.this).get()).isFullScreen());
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString.equals("closeImagePreview"))
        {
          j.emM();
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        paramAnonymousString = super.onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
        AppMethodBeat.o(78771);
        return paramAnonymousString;
      }
      
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(78777);
        a.b(a.this).d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        super.onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
        AppMethodBeat.o(78777);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(78776);
        a.b(a.this).onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousView);
        AppMethodBeat.o(78776);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(78772);
        if ((a.b(a.this).B(paramAnonymousMotionEvent)) || (super.onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
        {
          AppMethodBeat.o(78772);
          return true;
        }
        AppMethodBeat.o(78772);
        return false;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(78775);
        if ((a.b(a.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean)) || (super.overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView)))
        {
          AppMethodBeat.o(78775);
          return true;
        }
        AppMethodBeat.o(78775);
        return false;
      }
    };
    this.kwV = new aa()
    {
      public final boolean B(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78779);
        boolean bool = a.this.af(paramAnonymousMotionEvent);
        AppMethodBeat.o(78779);
        return bool;
      }
      
      public final boolean C(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78784);
        boolean bool = a.this.ag(paramAnonymousMotionEvent);
        AppMethodBeat.o(78784);
        return bool;
      }
      
      public final boolean D(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(78785);
        boolean bool = a.this.ah(paramAnonymousMotionEvent);
        AppMethodBeat.o(78785);
        return bool;
      }
      
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(78780);
        paramAnonymousBoolean = a.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(78780);
        return paramAnonymousBoolean;
      }
      
      public final void beA()
      {
        AppMethodBeat.i(78781);
        a.this.feT();
        AppMethodBeat.o(78781);
      }
      
      @TargetApi(9)
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(78782);
        a.this.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(78782);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(78783);
        a.this.Q(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(78783);
      }
    };
    this.ATm = new com.tencent.mm.plugin.webview.e.c();
    this.ugg = new Handler(Looper.getMainLooper());
    this.fFP = true;
    boolean bool;
    if (getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      this.isX5Kernel = bool;
      w.a.ha(getContext());
      if ((!getIsX5Kernel()) && (!com.tencent.mm.compatible.util.d.lf(19))) {}
      try
      {
        paramContext = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mProvider", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mWebViewCore", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "sWebCoreHandler", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mLooper", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.c(paramContext, "mThread", null).get();
        ad.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramContext });
        if ((paramContext instanceof Thread))
        {
          paramContext = (Thread)paramContext;
          ad.i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramContext.getState() });
          if (paramContext.getState() == Thread.State.WAITING) {
            paramContext.interrupt();
          }
        }
        ki(getContext());
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().frg();
        getSettings().fqZ();
        getSettings().fqY();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().fri();
        getSettings().fre();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().frd();
        getSettings().frf();
        getSettings().setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
        com.tencent.xweb.c.fqC().fqD();
        com.tencent.xweb.c.fqC().e(this);
        getSettings().setUserAgentString(x.bR(getContext(), getSettings().getUserAgentString()) + " Luggage");
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        super.setWebViewClient(this.AWy);
        super.setWebChromeClient(this.AWz);
        if (getIsX5Kernel()) {
          super.setWebViewCallbackClient(this.kwV);
        }
        super.setWebViewClientExtension(this.AWA);
        feS();
        AppMethodBeat.o(78800);
        return;
        bool = false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          ad.e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramContext });
        }
      }
    }
  }
  
  protected void Bg()
  {
    AppMethodBeat.i(78807);
    if (getWebCore().cay != null)
    {
      getWebCore().cay.a(new LuggageMMLocalResourceProvider());
      getWebCore().cay.a(new com.tencent.mm.plugin.webview.luggage.d(com.tencent.mm.plugin.appbrand.aa.d.Ne("luggage_mm_adapter.js")));
    }
    AppMethodBeat.o(78807);
  }
  
  public void a(final a.a parama)
  {
    AppMethodBeat.i(78808);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78787);
        a.a(a.this, parama);
        AppMethodBeat.o(78787);
      }
    });
    AppMethodBeat.o(78808);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(78803);
    super.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(78803);
  }
  
  public final void bO(final String paramString)
  {
    AppMethodBeat.i(78804);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78770);
        a.a(a.this, paramString);
        AppMethodBeat.o(78770);
      }
    });
    AppMethodBeat.o(78804);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(78816);
    boolean bool = super.canGoBack();
    AppMethodBeat.o(78816);
    return bool;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(78817);
    if (this.mDestroyed)
    {
      AppMethodBeat.o(78817);
      return;
    }
    try
    {
      super.destroy();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      ad.printErrStackTrace("MicroMsg.LuggageMMWebViewCoreImpl", localNullPointerException, "destroy()", new Object[0]);
      return;
    }
    finally
    {
      this.mDestroyed = true;
      AppMethodBeat.o(78817);
    }
  }
  
  public void evaluateJavascript(final String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(78805);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78786);
        a.a(a.this, paramString, paramValueCallback);
        AppMethodBeat.o(78786);
      }
    });
    AppMethodBeat.o(78805);
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(78814);
    String str = super.getTitle();
    AppMethodBeat.o(78814);
    return str;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(78813);
    String str = super.getUrl();
    AppMethodBeat.o(78813);
    return str;
  }
  
  public View getView()
  {
    return this;
  }
  
  public k getWebCore()
  {
    return this.caI;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(78815);
    super.goBack();
    AppMethodBeat.o(78815);
  }
  
  public void loadData(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(78811);
    paramString1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78790);
        a.a(a.this, paramString1, paramString2, paramString3);
        AppMethodBeat.o(78790);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString1.run();
      AppMethodBeat.o(78811);
      return;
    }
    aq.f(paramString1);
    AppMethodBeat.o(78811);
  }
  
  public void loadUrl(final String paramString)
  {
    AppMethodBeat.i(78809);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78788);
        a.b(a.this, paramString);
        AppMethodBeat.o(78788);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString.run();
      AppMethodBeat.o(78809);
      return;
    }
    aq.f(paramString);
    AppMethodBeat.o(78809);
  }
  
  public void loadUrl(final String paramString, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(78810);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78789);
        a.a(a.this, paramString, paramMap);
        AppMethodBeat.o(78789);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString.run();
      AppMethodBeat.o(78810);
      return;
    }
    aq.f(paramString);
    AppMethodBeat.o(78810);
  }
  
  protected final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(78802);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(78802);
      return;
    }
    this.ugg.post(paramRunnable);
    AppMethodBeat.o(78802);
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(78801);
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(paramContext);
    }
    AppMethodBeat.o(78801);
  }
  
  public void setPage(f paramf)
  {
    AppMethodBeat.i(182690);
    this.AWx = new WeakReference(paramf);
    AppMethodBeat.o(182690);
  }
  
  public void setSource(String paramString)
  {
    this.sMt = paramString;
  }
  
  public void setWebChromeClient(w paramw)
  {
    AppMethodBeat.i(78820);
    this.AWz.a(paramw);
    AppMethodBeat.o(78820);
  }
  
  protected void setWebChromeClientProxy(e parame)
  {
    AppMethodBeat.i(78821);
    if (parame != null)
    {
      this.AWz.a(parame);
      this.AWz = parame;
    }
    AppMethodBeat.o(78821);
  }
  
  public void setWebCore(k paramk)
  {
    AppMethodBeat.i(78806);
    this.caI = paramk;
    Bg();
    AppMethodBeat.o(78806);
  }
  
  public void setWebViewClient(ab paramab)
  {
    AppMethodBeat.i(78818);
    this.AWy.a(paramab);
    AppMethodBeat.o(78818);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(78822);
    this.AWA.a(parama);
    AppMethodBeat.o(78822);
  }
  
  protected void setWebViewClientExtensionProxy(g paramg)
  {
    AppMethodBeat.i(78823);
    if (paramg != null)
    {
      this.AWA.a(paramg);
      this.AWA = paramg;
    }
    AppMethodBeat.o(78823);
  }
  
  protected void setWebViewClientProxy(h paramh)
  {
    AppMethodBeat.i(78819);
    if (paramh != null)
    {
      this.AWy.a(paramh);
      this.AWy = paramh;
    }
    AppMethodBeat.o(78819);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(78812);
    super.stopLoading();
    AppMethodBeat.o(78812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.a
 * JD-Core Version:    0.7.0.1
 */