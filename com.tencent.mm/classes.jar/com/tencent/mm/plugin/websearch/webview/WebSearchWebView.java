package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
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
    AppMethodBeat.i(198079);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198079);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198080);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198080);
  }
  
  public WebSearchWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198081);
    this.context = paramContext;
    init();
    AppMethodBeat.o(198081);
  }
  
  private void bQp()
  {
    AppMethodBeat.i(198083);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(198083);
      return;
    }
    if (d.oD(19))
    {
      AppMethodBeat.o(198083);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      Log.d("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        Log.i("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(198083);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.WebSearch.WebSearchWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(198083);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(198082);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "init WebSearchWebView");
    this.gKM = true;
    kI(this.context);
    bQp();
    AppMethodBeat.o(198082);
  }
  
  public final void a(x paramx, ac paramac)
  {
    AppMethodBeat.i(198084);
    getSettings().hsU();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().hsW();
    getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.z.cr(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().hsN();
    getSettings().hsM();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().hsW();
    getSettings().hsS();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().hsR();
    getSettings().hsT();
    getSettings().setDatabasePath(b.aKA() + "databases/");
    com.tencent.xweb.c.hsp().hsq();
    com.tencent.xweb.c.hsp().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    if (paramx != null) {
      super.setWebChromeClient(paramx);
    }
    super.setWebViewClient(paramac);
    Log.i("MicroMsg.WebSearch.WebSearchWebView", "current webview core %s", new Object[] { getWebCoreType() });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    gYW();
    float f = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.iX(getContext()));
    if (f >= a.jd(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      Log.i("MicroMsg.WebSearch.WebSearchWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(198084);
      return;
      if (f >= a.jc(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= a.jb(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= a.ja(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= a.iZ(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= a.iY(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= a.iX(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= a.iW(getContext())) {
        getSettings().setTextZoom(92);
      } else {
        getSettings().setTextZoom(80);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198085);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    destroy();
    removeJavascriptInterface("topStoryJSApi");
    try
    {
      destroy();
      AppMethodBeat.o(198085);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebSearch.WebSearchWebView", localException, "onDestroy", new Object[0]);
      AppMethodBeat.o(198085);
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(198086);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(198086);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(198086);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(198086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.WebSearchWebView
 * JD-Core Version:    0.7.0.1
 */