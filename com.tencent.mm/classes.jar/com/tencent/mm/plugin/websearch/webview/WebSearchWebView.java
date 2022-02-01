package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;
import com.tencent.xweb.c;
import com.tencent.xweb.x;
import java.io.File;
import java.lang.reflect.Field;

public class WebSearchWebView
  extends MMWebView
{
  private Context context;
  
  public WebSearchWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198850);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198850);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198853);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198853);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198857);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198857);
  }
  
  private void cdf()
  {
    AppMethodBeat.i(198862);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(198862);
      return;
    }
    if (d.qV(19))
    {
      AppMethodBeat.o(198862);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.b(this, "mSysWebView", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mProvider", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mWebViewCore", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mLooper", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mThread", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        Log.i("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(198862);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(198862);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(198860);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "init WebSearchWebView");
    this.jvb = true;
    lF(this.context);
    cdf();
    AppMethodBeat.o(198860);
  }
  
  public final void a(x paramx, ad paramad)
  {
    AppMethodBeat.i(198880);
    getSettings().iwC();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().iwE();
    getSettings().setUserAgentString(ab.cC(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().iwx();
    getSettings().iww();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().iwE();
    getSettings().iwA();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().iwz();
    getSettings().iwB();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    c.ivX().ivY();
    c.ivX().f(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    if (paramx != null) {
      super.setWebChromeClient(paramx);
    }
    super.setWebViewClient(paramad);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "current webview core %s", new Object[] { getWebCoreType() });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    hZN();
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.kb(getContext()));
    if (f >= a.kh(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      Log.i("MicroMsg.WebSearch.WebSearchWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(198880);
      return;
      if (f >= a.kg(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= a.kf(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= a.ke(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= a.kd(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= a.kc(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= a.kb(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= a.ka(getContext())) {
        getSettings().setTextZoom(92);
      } else {
        getSettings().setTextZoom(80);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198882);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    destroy();
    removeJavascriptInterface("topStoryJSApi");
    try
    {
      destroy();
      AppMethodBeat.o(198882);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchWebView", localException, "onDestroy", new Object[0]);
      AppMethodBeat.o(198882);
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(198887);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(198887);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(198887);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(198887);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.WebSearchWebView
 * JD-Core Version:    0.7.0.1
 */