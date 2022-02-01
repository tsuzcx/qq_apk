package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import com.tencent.xweb.ao;
import com.tencent.xweb.z;
import java.io.File;
import java.lang.reflect.Field;

public class WebSearchWebView
  extends MMWebView
{
  private Context context;
  
  public WebSearchWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(315226);
    this.context = paramContext;
    init();
    AppMethodBeat.o(315226);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(315234);
    this.context = paramContext;
    init();
    AppMethodBeat.o(315234);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(315240);
    this.context = paramContext;
    init();
    AppMethodBeat.o(315240);
  }
  
  private void cDC()
  {
    AppMethodBeat.i(315256);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(315256);
      return;
    }
    if (d.rb(19))
    {
      AppMethodBeat.o(315256);
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
      AppMethodBeat.o(315256);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(315256);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(315247);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "init WebSearchWebView");
    this.lYs = true;
    nJ(this.context);
    cDC();
    AppMethodBeat.o(315247);
  }
  
  public final void a(z paramz, ag paramag)
  {
    AppMethodBeat.i(315270);
    getSettings().kfS();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().kfU();
    getSettings().setUserAgentString(aa.cN(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().kfN();
    getSettings().kfM();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().kfU();
    getSettings().kfQ();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().kfP();
    getSettings().kfR();
    getSettings().setDatabasePath(com.tencent.mm.loader.i.b.bmq() + "databases/");
    ao.kfp();
    ao.g(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    if (paramz != null) {
      super.setWebChromeClient(paramz);
    }
    super.setWebViewClient(paramag);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "current webview core %s", new Object[] { getWebCoreType() });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    jEU();
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.md(getContext()));
    if (f >= a.mj(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      Log.i("MicroMsg.WebSearch.WebSearchWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(315270);
      return;
      if (f >= a.mi(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= a.mh(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= a.mg(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= a.mf(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= a.me(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= a.md(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= a.mc(getContext())) {
        getSettings().setTextZoom(92);
      } else {
        getSettings().setTextZoom(80);
      }
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(315277);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(315277);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(315277);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(315277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.WebSearchWebView
 * JD-Core Version:    0.7.0.1
 */