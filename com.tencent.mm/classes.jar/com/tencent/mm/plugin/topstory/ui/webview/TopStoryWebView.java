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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  
  private void bNc()
  {
    AppMethodBeat.i(126570);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(126570);
      return;
    }
    if (com.tencent.mm.compatible.util.d.ly(19))
    {
      AppMethodBeat.o(126570);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      ad.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ad.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(126570);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(126570);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(126569);
    ad.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
    this.gcX = true;
    kF(this.context);
    bNc();
    AppMethodBeat.o(126569);
  }
  
  public final void a(b paramb, d paramd)
  {
    AppMethodBeat.i(126571);
    getSettings().gbb();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().gbd();
    getSettings().setUserAgentString(x.bW(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().gaU();
    getSettings().gaT();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().gbd();
    getSettings().gaZ();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().gaY();
    getSettings().gba();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
    com.tencent.xweb.c.gaw().gax();
    com.tencent.xweb.c.gaw().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)aj.getContext().getSystemService("window"));
    super.setWebChromeClient(paramb);
    super.setWebViewClient(paramd);
    ad.i("MicroMsg.TopStory.TopStoryWebView", "current webview core %s", new Object[] { getWebCoreType() });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    fLz();
    float f = getContext().getSharedPreferences(aj.fkC(), 0).getFloat("current_text_size_scale_key", a.hZ(getContext()));
    if (f >= a.jdMethod_if(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      ad.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(126571);
      return;
      if (f >= a.ie(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= a.id(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= a.ic(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= a.ib(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= a.ia(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= a.hZ(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= a.hY(getContext())) {
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
      ad.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", localException, "onDestroy", new Object[0]);
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