package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.File;
import java.lang.reflect.Field;

public class TopStoryWebView
  extends MMWebView
{
  private Context context;
  
  public TopStoryWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126566);
    this.context = paramContext;
    init();
    AppMethodBeat.o(126566);
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126567);
    this.context = paramContext;
    init();
    AppMethodBeat.o(126567);
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126568);
    this.context = paramContext;
    init();
    AppMethodBeat.o(126568);
  }
  
  private void bIM()
  {
    AppMethodBeat.i(126570);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(126570);
      return;
    }
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      AppMethodBeat.o(126570);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      ac.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ac.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(126570);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(126570);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(126569);
    ac.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
    this.fJw = true;
    kt(this.context);
    bIM();
    AppMethodBeat.o(126569);
  }
  
  public final void a(b paramb, d paramd)
  {
    AppMethodBeat.i(126571);
    getSettings().fJH();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().fJJ();
    getSettings().setUserAgentString(x.bS(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().fJA();
    getSettings().fJz();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().fJJ();
    getSettings().fJF();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().fJE();
    getSettings().fJG();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
    com.tencent.xweb.c.fJa().fJb();
    com.tencent.xweb.c.fJa().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)ai.getContext().getSystemService("window"));
    super.setWebChromeClient(paramb);
    super.setWebViewClient(paramd);
    ac.i("MicroMsg.TopStory.TopStoryWebView", "current webview core %s", new Object[] { getWebCoreType() });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    fuM();
    float f = getContext().getSharedPreferences(ai.eUX(), 0).getFloat("current_text_size_scale_key", a.hQ(getContext()));
    if (f >= a.hW(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      ac.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(126571);
      return;
      if (f >= a.hV(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= a.hU(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= a.hT(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= a.hS(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= a.hR(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= a.hQ(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= a.hP(getContext())) {
        getSettings().setTextZoom(92);
      } else {
        getSettings().setTextZoom(80);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126572);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    destroy();
    removeJavascriptInterface("topStoryJSApi");
    try
    {
      destroy();
      AppMethodBeat.o(126572);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", localException, "onDestroy", new Object[0]);
      AppMethodBeat.o(126572);
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(126573);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(126573);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(126573);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(126573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView
 * JD-Core Version:    0.7.0.1
 */