package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import java.io.File;
import java.lang.reflect.Field;

public class TopStoryWebView
  extends MMWebView
{
  private Context context;
  
  public TopStoryWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(2160);
    this.context = paramContext;
    init();
    AppMethodBeat.o(2160);
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(2161);
    this.context = paramContext;
    init();
    AppMethodBeat.o(2161);
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(2162);
    this.context = paramContext;
    init();
    AppMethodBeat.o(2162);
  }
  
  private void cKy()
  {
    AppMethodBeat.i(2164);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(2164);
      return;
    }
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      AppMethodBeat.o(2164);
      return;
    }
    try
    {
      Object localObject = new c(this, "mSysWebView", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new c(localObject, "mProvider", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new c(localObject, "mWebViewCore", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new c(localObject, "sWebCoreHandler", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new c(localObject, "mLooper", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new c(localObject, "mThread", null).get();
      ab.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ab.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(2164);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(2164);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(2163);
    ab.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
    this.inited = true;
    iG(this.context);
    cKy();
    AppMethodBeat.o(2163);
  }
  
  public final void a(b paramb, d paramd)
  {
    AppMethodBeat.i(2165);
    getSettings().dYx();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().dYz();
    getSettings().setUserAgentString(u.bD(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().dYs();
    getSettings().dYr();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().dYz();
    getSettings().dYv();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().dYu();
    getSettings().dYw();
    getSettings().setDatabasePath(e.eQu + "databases/");
    com.tencent.xweb.b.dYg().dYh();
    com.tencent.xweb.b.dYg().f(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)ah.getContext().getSystemService("window"));
    super.setWebChromeClient(paramb);
    super.setWebViewClient(paramd);
    ab.i("MicroMsg.TopStory.TopStoryWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    dOL();
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (!g.cIw()) {
          break label390;
        }
        android.webkit.WebView.setWebContentsDebuggingEnabled(true);
      }
      for (;;)
      {
        f = getContext().getSharedPreferences(ah.dsP(), 0).getFloat("current_text_size_scale_key", a.gg(getContext()));
        if (f < a.gm(getContext())) {
          break;
        }
        getSettings().setTextZoom(160);
        ab.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
        AppMethodBeat.o(2165);
        return;
        label390:
        android.webkit.WebView.setWebContentsDebuggingEnabled(false);
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        float f;
        continue;
        if (f >= a.gl(getContext())) {
          getSettings().setTextZoom(150);
        } else if (f >= a.gk(getContext())) {
          getSettings().setTextZoom(140);
        } else if (f >= a.gj(getContext())) {
          getSettings().setTextZoom(130);
        } else if (f >= a.gi(getContext())) {
          getSettings().setTextZoom(120);
        } else if (f >= a.gh(getContext())) {
          getSettings().setTextZoom(110);
        } else if (f >= a.gg(getContext())) {
          getSettings().setTextZoom(100);
        } else if (f >= a.gf(getContext())) {
          getSettings().setTextZoom(90);
        } else {
          getSettings().setTextZoom(80);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(2166);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    destroy();
    removeJavascriptInterface("topStoryJSApi");
    try
    {
      destroy();
      AppMethodBeat.o(2166);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", localException, "onDestroy", new Object[0]);
      AppMethodBeat.o(2166);
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(2167);
    try
    {
      Field localField = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(2167);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(2167);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(2167);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView
 * JD-Core Version:    0.7.0.1
 */