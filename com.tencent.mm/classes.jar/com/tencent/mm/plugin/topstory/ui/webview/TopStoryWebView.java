package com.tencent.mm.plugin.topstory.ui.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.b;
import com.tencent.xweb.n;
import java.io.File;
import java.lang.reflect.Field;

public class TopStoryWebView
  extends MMWebView
{
  private Context context;
  
  public TopStoryWebView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public TopStoryWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private void init()
  {
    y.i("MicroMsg.TopStory.TopStoryWebView", "init TopStoryWebView");
    this.dyX = true;
    hi(this.context);
    if ((!getIsX5Kernel()) && (!d.gF(19))) {}
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      y.d("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        y.i("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.TopStory.TopStoryWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
    }
  }
  
  public final void a(a parama, c paramc)
  {
    getSettings().cSs();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().cSu();
    getSettings().setUserAgentString(s.aX(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().cSn();
    getSettings().cSm();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().cSu();
    getSettings().cSq();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().cSp();
    getSettings().cSr();
    getSettings().setDatabasePath(e.dOO + "databases/");
    b.cSe().cSf();
    b.cSe().c(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)ae.getContext().getSystemService("window"));
    super.setWebChromeClient(parama);
    super.setWebViewClient(paramc);
    y.i("MicroMsg.TopStory.TopStoryWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    cJS();
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (!g.bNd()) {
          break label367;
        }
        android.webkit.WebView.setWebContentsDebuggingEnabled(true);
      }
      for (;;)
      {
        f = getContext().getSharedPreferences(ae.cqR(), 0).getFloat("current_text_size_scale_key", 1.0F);
        if (f < 2.025F) {
          break;
        }
        getSettings().setTextZoom(160);
        y.i("MicroMsg.TopStory.TopStoryWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
        return;
        label367:
        android.webkit.WebView.setWebContentsDebuggingEnabled(false);
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        float f;
        continue;
        if (f >= 1.875F) {
          getSettings().setTextZoom(150);
        } else if (f >= 1.625F) {
          getSettings().setTextZoom(140);
        } else if (f >= 1.375F) {
          getSettings().setTextZoom(130);
        } else if (f >= 1.25F) {
          getSettings().setTextZoom(120);
        } else if (f >= 1.125F) {
          getSettings().setTextZoom(110);
        } else if (f >= 1.0F) {
          getSettings().setTextZoom(100);
        } else if (f >= 0.875F) {
          getSettings().setTextZoom(90);
        } else {
          getSettings().setTextZoom(80);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    destroy();
    removeJavascriptInterface("topStoryJSApi");
    try
    {
      destroy();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.TopStory.TopStoryWebView", localException, "onDestroy", new Object[0]);
    }
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    try
    {
      Field localField = com.tencent.xweb.WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null) {
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      return;
    }
    catch (Exception paramWindowManager) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView
 * JD-Core Version:    0.7.0.1
 */