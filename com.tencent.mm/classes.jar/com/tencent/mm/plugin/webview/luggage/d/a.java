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
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.h;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class a
  extends MMWebView
  implements com.tencent.luggage.webview.a
{
  public String EdH;
  protected com.tencent.mm.plugin.webview.f.c PPN;
  private WeakReference<g> PTt;
  private i PTu;
  private f PTv;
  private h PTw;
  private p crX;
  private boolean mDestroyed;
  private Handler mMainThreadHandler;
  private ac pGc;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(78800);
    this.mDestroyed = false;
    this.PTu = new i()
    {
      public final void b(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(78799);
        Log.i(getClass().getSimpleName(), "onPageStarted");
        super.b(paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap);
        AppMethodBeat.o(78799);
      }
    };
    this.PTv = new f() {};
    this.PTw = new h()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(78778);
        a.b(a.this).computeScroll(paramAnonymousView);
        super.computeScroll(paramAnonymousView);
        AppMethodBeat.o(78778);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(78774);
        if ((a.b(a.this).dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)) || (super.dispatchTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
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
        if ((a.b(a.this).onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)) || (super.onInterceptTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
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
        if ((a.a(a.this) == null) || (a.a(a.this).get() == null))
        {
          Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "page is null");
          paramAnonymousString = super.onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString == null)
        {
          Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "method is null");
          paramAnonymousString = super.onMiscCallBack(paramAnonymousString, paramAnonymousBundle);
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        String str;
        if (paramAnonymousString.equals("getDrawable"))
        {
          str = paramAnonymousBundle.getString("packageName");
          int i = paramAnonymousBundle.getInt("resourceId");
          if ((!Util.isNullOrNil(str)) && (i > 0)) {
            try
            {
              Drawable localDrawable = com.tencent.mm.cj.b.g(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(str), i);
              AppMethodBeat.o(78771);
              return localDrawable;
            }
            catch (Exception localException2)
            {
              Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "get resource for package : %s, fail, : %s", new Object[] { str, localException2.getMessage() });
            }
          }
        }
        if (paramAnonymousString.equals("getShareUrl")) {
          try
          {
            str = ((g)a.a(a.this).get()).gUA().bld(a.this.getUrl());
            Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "getShareUrl by x5 core, shareurl = %s", new Object[] { str });
            AppMethodBeat.o(78771);
            return str;
          }
          catch (Exception localException1)
          {
            Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "getShare url failed");
          }
        }
        if (paramAnonymousString.equals("supportImagePreview"))
        {
          Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "supportImagePreview");
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString.equals("imagePreview"))
        {
          j.a(paramAnonymousBundle, ((g)a.a(a.this).get()).PPv, null, ((g)a.a(a.this).get()).QT());
          paramAnonymousString = Boolean.TRUE;
          AppMethodBeat.o(78771);
          return paramAnonymousString;
        }
        if (paramAnonymousString.equals("closeImagePreview"))
        {
          j.gWB();
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
        a.b(a.this).onOverScrolled(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2, paramAnonymousView);
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
        if ((a.b(a.this).onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)) || (super.onTouchEvent(paramAnonymousMotionEvent, paramAnonymousView)))
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
        if ((a.b(a.this).overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView)) || (super.overScrollBy(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean, paramAnonymousView)))
        {
          AppMethodBeat.o(78775);
          return true;
        }
        AppMethodBeat.o(78775);
        return false;
      }
    };
    this.pGc = new ac()
    {
      public final void computeScroll(View paramAnonymousView)
      {
        AppMethodBeat.i(268087);
        a.this.hZQ();
        AppMethodBeat.o(268087);
      }
      
      public final boolean dispatchTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(268089);
        boolean bool = a.this.av(paramAnonymousMotionEvent);
        AppMethodBeat.o(268089);
        return bool;
      }
      
      public final boolean onInterceptTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(268090);
        boolean bool = a.this.aw(paramAnonymousMotionEvent);
        AppMethodBeat.o(268090);
        return bool;
      }
      
      @TargetApi(9)
      public final void onOverScrolled(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, View paramAnonymousView)
      {
        AppMethodBeat.i(268088);
        a.this.g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(268088);
      }
      
      public final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, View paramAnonymousView)
      {
        AppMethodBeat.i(78783);
        a.this.W(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        AppMethodBeat.o(78783);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent, View paramAnonymousView)
      {
        AppMethodBeat.i(268084);
        boolean bool = a.this.au(paramAnonymousMotionEvent);
        AppMethodBeat.o(268084);
        return bool;
      }
      
      public final boolean overScrollBy(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8, boolean paramAnonymousBoolean, View paramAnonymousView)
      {
        AppMethodBeat.i(268086);
        paramAnonymousBoolean = a.this.b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, paramAnonymousInt6, paramAnonymousInt7, paramAnonymousInt8, paramAnonymousBoolean);
        AppMethodBeat.o(268086);
        return paramAnonymousBoolean;
      }
    };
    this.PPN = new com.tencent.mm.plugin.webview.f.c();
    this.mMainThreadHandler = new Handler(Looper.getMainLooper());
    this.jvb = true;
    boolean bool;
    if (getX5WebViewExtension() != null) {
      bool = true;
    }
    for (;;)
    {
      this.aabd = bool;
      ab.a.jt(getContext());
      if ((!getIsX5Kernel()) && (!com.tencent.mm.compatible.util.d.qV(19))) {}
      try
      {
        paramContext = new com.tencent.mm.compatible.loader.b(this, "mSysWebView", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.b(paramContext, "mProvider", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.b(paramContext, "mWebViewCore", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.b(paramContext, "sWebCoreHandler", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.b(paramContext, "mLooper", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { paramContext });
        paramContext = new com.tencent.mm.compatible.loader.b(paramContext, "mThread", null).get();
        Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { paramContext });
        if ((paramContext instanceof Thread))
        {
          paramContext = (Thread)paramContext;
          Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { paramContext.getState() });
          if (paramContext.getState() == Thread.State.WAITING) {
            paramContext.interrupt();
          }
        }
        lF(getContext());
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().iwC();
        getSettings().iwx();
        getSettings().iww();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().iwE();
        getSettings().iwA();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().iwz();
        getSettings().iwB();
        getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
        com.tencent.xweb.c.ivX().ivY();
        com.tencent.xweb.c.ivX().f(this);
        getSettings().setUserAgentString(ab.cC(getContext(), getSettings().getUserAgentString()) + " Luggage");
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        super.setWebViewClient(this.PTu);
        super.setWebChromeClient(this.PTv);
        if (getIsX5Kernel()) {
          super.setWebViewCallbackClient(this.pGc);
        }
        super.setWebViewClientExtension(this.PTw);
        hZP();
        AppMethodBeat.o(78800);
        return;
        bool = false;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { paramContext });
        }
      }
    }
  }
  
  protected void Ou()
  {
    AppMethodBeat.i(78807);
    if (getWebCore().crR != null)
    {
      getWebCore().crR.a(new LuggageMMLocalResourceProvider());
      getWebCore().crR.a(new e(com.tencent.mm.plugin.appbrand.ac.d.anc("luggage_mm_adapter.js")));
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
      Log.printErrStackTrace("MicroMsg.LuggageMMWebViewCoreImpl", localNullPointerException, "destroy()", new Object[0]);
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
  
  public String getUserAgent()
  {
    AppMethodBeat.i(214976);
    String str = getSettings().getUserAgentString();
    AppMethodBeat.o(214976);
    return str;
  }
  
  public View getView()
  {
    return this;
  }
  
  public p getWebCore()
  {
    return this.crX;
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
    MMHandlerThread.postToMainThread(paramString1);
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
        a.a(a.this, paramString);
        AppMethodBeat.o(78788);
      }
    };
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramString.run();
      AppMethodBeat.o(78809);
      return;
    }
    MMHandlerThread.postToMainThread(paramString);
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
    MMHandlerThread.postToMainThread(paramString);
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
    this.mMainThreadHandler.post(paramRunnable);
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
  
  public void setPage(g paramg)
  {
    AppMethodBeat.i(182690);
    this.PTt = new WeakReference(paramg);
    AppMethodBeat.o(182690);
  }
  
  public void setSource(String paramString)
  {
    this.EdH = paramString;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(78820);
    this.PTv.a(paramx);
    AppMethodBeat.o(78820);
  }
  
  protected void setWebChromeClientProxy(f paramf)
  {
    AppMethodBeat.i(78821);
    if (paramf != null)
    {
      this.PTv.a(paramf);
      this.PTv = paramf;
    }
    AppMethodBeat.o(78821);
  }
  
  public void setWebCore(p paramp)
  {
    AppMethodBeat.i(78806);
    this.crX = paramp;
    Ou();
    AppMethodBeat.o(78806);
  }
  
  public void setWebViewClient(ad paramad)
  {
    AppMethodBeat.i(78818);
    this.PTu.a(paramad);
    AppMethodBeat.o(78818);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(78822);
    this.PTw.a(parama);
    AppMethodBeat.o(78822);
  }
  
  protected void setWebViewClientExtensionProxy(h paramh)
  {
    AppMethodBeat.i(78823);
    if (paramh != null)
    {
      this.PTw.a(paramh);
      this.PTw = paramh;
    }
    AppMethodBeat.o(78823);
  }
  
  protected void setWebViewClientProxy(i parami)
  {
    AppMethodBeat.i(78819);
    if (parami != null)
    {
      this.PTu.a(parami);
      this.PTu = parami;
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