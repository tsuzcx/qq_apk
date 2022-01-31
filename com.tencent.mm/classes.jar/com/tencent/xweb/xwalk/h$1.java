package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.R.layout;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;

final class h$1
  extends j
{
  String xmj = null;
  
  h$1(h paramh, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  private static int m(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    String str = paramString;
    if (paramInt2 == 0) {
      str = new StringBuffer(paramString).reverse().toString();
    }
    int i = 0;
    paramInt2 = 0;
    for (;;)
    {
      int j = paramInt2;
      if (paramInt2 < str.length() - 1)
      {
        i += str.substring(paramInt2, paramInt2 + 1).getBytes().length;
        if (i >= paramInt1) {
          j = paramInt2 + 1;
        }
      }
      else
      {
        return j;
      }
      paramInt2 += 1;
    }
  }
  
  public final View getVideoLoadingProgressView()
  {
    Log.i("XWWebView", "getVideoLoadingProgressView");
    return LayoutInflater.from(this.xmk.xjP.getContext()).inflate(R.layout.video_progress, null);
  }
  
  public final boolean isSearchable()
  {
    Object localObject = h.d(this.xmk).onMiscCallBack("supportSmartPickWord", new Bundle());
    if ((localObject instanceof Boolean)) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  public final void onClearCurrentPage()
  {
    if (h.d(this.xmk) != null) {
      h.d(this.xmk).hasDiscardCurrentPage(true);
    }
  }
  
  public final boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    com.tencent.xweb.j localj = this.xmk.gVg;
    paramXWalkView = ConsoleMessage.MessageLevel.DEBUG;
    switch (e.1.xlP[paramConsoleMessageType.ordinal()])
    {
    }
    for (;;)
    {
      return localj.onConsoleMessage(new ConsoleMessage(paramString1, paramString2, paramInt, paramXWalkView));
      paramXWalkView = ConsoleMessage.MessageLevel.DEBUG;
      continue;
      paramXWalkView = ConsoleMessage.MessageLevel.ERROR;
      continue;
      paramXWalkView = ConsoleMessage.MessageLevel.LOG;
      continue;
      paramXWalkView = ConsoleMessage.MessageLevel.TIP;
      continue;
      paramXWalkView = ConsoleMessage.MessageLevel.WARNING;
    }
  }
  
  public final boolean onCreateWindowRequested(XWalkView paramXWalkView, XWalkUIClient.InitiateBy paramInitiateBy, ValueCallback<XWalkView> paramValueCallback)
  {
    return super.onCreateWindowRequested(paramXWalkView, paramInitiateBy, paramValueCallback);
  }
  
  public final void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt) {}
  
  public final void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    super.onFullscreenToggled(paramXWalkView, paramBoolean);
  }
  
  public final void onGeolocationPermissionsHidePrompt() {}
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    this.xmk.gVg.onGeolocationPermissionsShowPrompt(paramString, new e.b(paramXWalkGeolocationPermissionsCallback));
  }
  
  public final void onHideCustomView()
  {
    Log.i("XWWebView", "onHideCustomView");
    this.xmk.gVg.ajc();
    this.xmk.xmb.setVisibility(0);
    if (h.c(this.xmk) != null) {
      h.c(this.xmk).onHideCustomView();
    }
  }
  
  public final void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    super.onIconAvailable(paramXWalkView, paramString, paramMessage);
  }
  
  public final void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    super.onJavascriptCloseWindow(paramXWalkView);
  }
  
  public final boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    return super.onJavascriptModalDialog(paramXWalkView, paramJavascriptMessageType, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
  }
  
  public final boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsAlert");
    return this.xmk.gVg.a(this.xmk.xjP, paramString1, paramString2, new e.c(paramXWalkJavascriptResult));
  }
  
  public final boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsConfirm");
    return this.xmk.gVg.b(this.xmk.xjP, paramString1, paramString2, new e.c(paramXWalkJavascriptResult));
  }
  
  public final boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    Log.i("XWWebView", "onJsPrompt");
    return this.xmk.gVg.a(this.xmk.xjP, paramString1, paramString2, paramString3, new e.d(paramXWalkJavascriptResult));
  }
  
  public final void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    Log.i("XWWebView", "onPageLoadStarted: url = " + paramString);
    this.xmk.gIG.b(this.xmk.xjP, paramString, this.xmk.xlW.getFavicon());
    this.xmj = null;
    if ((h.a(this.xmk) != null) && (paramString != null) && (!paramString.equals(h.a(this.xmk))) && (e.ahb(paramString) != e.ahb(h.a(this.xmk))))
    {
      if ((e.ahb(h.a(this.xmk)) == 1) && (e.ahb(paramString) == 2)) {
        h.a(this.xmk, 1);
      }
    }
    else
    {
      h.a(this.xmk, paramString);
      this.xmk.xjV = System.currentTimeMillis();
      paramXWalkView = paramString;
      if (paramString == null) {
        paramXWalkView = "";
      }
      e.eb(paramXWalkView, h.b(this.xmk));
      if (h.c(this.xmk) != null)
      {
        paramXWalkView = h.c(this.xmk);
        if (this.xmk.xjP.getFullscreenVideoKind() != WebView.a.xhl) {
          break label249;
        }
      }
    }
    label249:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.aa(true, bool);
      return;
      if ((e.ahb(h.a(this.xmk)) != 2) || (e.ahb(paramString) != 1)) {
        break;
      }
      h.a(this.xmk, 2);
      break;
    }
  }
  
  public final void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    if ((this.xmj != null) && (this.xmj.equals(paramString)))
    {
      Log.i("XWWebView", "abandoned onPageFinished: url = " + paramString + " status = " + paramLoadStatus);
      return;
    }
    if (h.c(this.xmk) != null)
    {
      paramXWalkView = h.c(this.xmk);
      if (this.xmk.xjP.getFullscreenVideoKind() != WebView.a.xhl) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.aa(false, bool);
      this.xmj = paramString;
      Log.i("XWWebView", "onPageFinished: url = " + paramString + " status = " + paramLoadStatus);
      this.xmk.gIG.a(this.xmk.xjP, paramString);
      paramXWalkView = XWalkUIClient.LoadStatus.FAILED;
      e.m(paramString, System.currentTimeMillis() - this.xmk.xjV, h.b(this.xmk));
      this.xmk.xjV = System.currentTimeMillis();
      return;
    }
  }
  
  public final void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    super.onReceivedIcon(paramXWalkView, paramString, paramBitmap);
  }
  
  public final void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    Log.i("XWWebView", "onReceivedTitle: " + paramString);
    super.onReceivedTitle(paramXWalkView, paramString);
    this.xmk.gVg.d(null, paramString);
    if (h.c(this.xmk) != null)
    {
      paramXWalkView = h.c(this.xmk);
      if (this.xmk.xjP.getFullscreenVideoKind() != WebView.a.xhl) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.aa(true, bool);
      return;
    }
  }
  
  public final void onRequestFocus(XWalkView paramXWalkView)
  {
    super.onRequestFocus(paramXWalkView);
  }
  
  public final void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    this.xmk.gIG.a(this.xmk.xjP, paramFloat1, paramFloat2);
  }
  
  public final boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    if (isSearchable())
    {
      paramXWalkView = new Bundle();
      paramXWalkView.putString("query", paramString1);
      h.d(this.xmk).onMiscCallBack("jumpToSos", paramXWalkView);
      this.xmk.xlW.getUrl();
      this.xmk.xlW.getRefererUrl();
      this.xmk.xlW.getTitle();
      return true;
    }
    return false;
  }
  
  public final boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    if (!isSearchable()) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("PickedWord", paramString1);
    localBundle.putString("PrefixText", paramString2);
    localBundle.putString("SuffixText", paramString3);
    paramString1 = h.d(this.xmk).onMiscCallBack("smartPickWord", localBundle);
    if ((paramString1 instanceof Bundle))
    {
      paramString1 = (Bundle)paramString1;
      if ((paramString1 != null) && (paramString1.getString("PickedWord") != null))
      {
        int j = paramString1.getInt("PrefixOffset");
        int i = paramString1.getInt("SuffixOffset");
        j = m(j, paramString2, 0);
        i = m(i, paramString3, 1);
        paramXWalkView.adjustSelectPosition(paramLong, paramString1.getString("PickedWord"), -j, i);
      }
      return true;
    }
    return false;
  }
  
  public final void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    super.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
  }
  
  public final void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    Log.i("XWWebView", "onShowCustomView:" + paramView);
    this.xmk.gVg.anw();
    e.cSQ();
    this.xmk.xmb.setVisibility(4);
    if (h.c(this.xmk) != null) {
      h.c(this.xmk).onShowCustomView(paramView, new e.a(paramCustomViewCallback));
    }
  }
  
  public final void onShowSos()
  {
    h.d(this.xmk).onMiscCallBack("onShowSos", new Bundle());
  }
  
  public final void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    super.onUnhandledKeyEvent(paramXWalkView, paramKeyEvent);
  }
  
  public final void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    Log.i("XWWebView", "openFileChooser with three param");
    this.xmk.gVg.openFileChooser(paramValueCallback, paramString1, paramString2);
  }
  
  public final boolean shouldDiscardCurrentPage()
  {
    if (h.d(this.xmk) != null) {
      return h.d(this.xmk).shouldDiscardCurrentPage();
    }
    return super.shouldDiscardCurrentPage();
  }
  
  public final boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    return super.shouldOverrideKeyEvent(paramXWalkView, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.h.1
 * JD-Core Version:    0.7.0.1
 */