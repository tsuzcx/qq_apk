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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.c.k;
import com.tencent.xweb.p;
import com.tencent.xweb.util.f;
import com.tencent.xweb.w;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;

final class j$1
  extends l
{
  String BJW = null;
  
  j$1(j paramj, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final boolean OnGetSampleString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(139594);
    paramXWalkView = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    Log.d("XWWebView", "translate: OnGetSampleString orghashmap size = " + paramMap.size() + " resultHashMap size = " + localHashMap.size());
    paramXWalkView.putSerializable("sample_hashmap", localHashMap);
    paramXWalkView = j.f(this.BJX).onMiscCallBack("onGetSampleString", paramXWalkView);
    if ((paramXWalkView instanceof Boolean))
    {
      boolean bool = ((Boolean)paramXWalkView).booleanValue();
      AppMethodBeat.o(139594);
      return bool;
    }
    AppMethodBeat.o(139594);
    return false;
  }
  
  public final View getVideoLoadingProgressView()
  {
    AppMethodBeat.i(85253);
    Log.i("XWWebView", "getVideoLoadingProgressView");
    View localView = LayoutInflater.from(this.BJX.BHt.getContext()).inflate(2130971070, null);
    AppMethodBeat.o(85253);
    return localView;
  }
  
  public final boolean isSearchable()
  {
    AppMethodBeat.i(85256);
    Object localObject = j.f(this.BJX).onMiscCallBack("supportSmartPickWord", new Bundle());
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(85256);
      return bool;
    }
    AppMethodBeat.o(85256);
    return false;
  }
  
  public final void onClearCurrentPage()
  {
    AppMethodBeat.i(85276);
    if (j.f(this.BJX) != null) {
      j.f(this.BJX).hasDiscardCurrentPage(true);
    }
    AppMethodBeat.o(85276);
  }
  
  public final boolean onConsoleMessage(XWalkView paramXWalkView, String paramString1, int paramInt, String paramString2, XWalkUIClient.ConsoleMessageType paramConsoleMessageType)
  {
    AppMethodBeat.i(85262);
    if ((XWalkUIClient.ConsoleMessageType.ERROR == paramConsoleMessageType) && (j.g(this.BJX) != null) && (paramString1.split(":").length == 2))
    {
      j.g(this.BJX);
      f.dZp();
    }
    p localp = this.BJX.iyr;
    paramXWalkView = ConsoleMessage.MessageLevel.DEBUG;
    switch (f.1.BJx[paramConsoleMessageType.ordinal()])
    {
    }
    for (;;)
    {
      boolean bool = localp.onConsoleMessage(new ConsoleMessage(paramString1, paramString2, paramInt, paramXWalkView));
      AppMethodBeat.o(85262);
      return bool;
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
    AppMethodBeat.i(85264);
    boolean bool = super.onCreateWindowRequested(paramXWalkView, paramInitiateBy, paramValueCallback);
    AppMethodBeat.o(85264);
    return bool;
  }
  
  public final void onDidChangeThemeColor(XWalkView paramXWalkView, int paramInt) {}
  
  public final void onFullscreenToggled(XWalkView paramXWalkView, boolean paramBoolean)
  {
    AppMethodBeat.i(85270);
    super.onFullscreenToggled(paramXWalkView, paramBoolean);
    AppMethodBeat.o(85270);
  }
  
  public final void onGeolocationPermissionsHidePrompt() {}
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    AppMethodBeat.i(85261);
    this.BJX.iyr.onGeolocationPermissionsShowPrompt(paramString, new f.b(paramXWalkGeolocationPermissionsCallback));
    AppMethodBeat.o(85261);
  }
  
  public final boolean onGetTranslateString(XWalkView paramXWalkView, Map<String, String> paramMap)
  {
    AppMethodBeat.i(139593);
    paramXWalkView = new Bundle();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    Log.d("XWWebView", "translate: onGetTranslateString orghashmap size = " + paramMap.size() + " resultHashMap size = " + localHashMap.size());
    if ((localHashMap.size() == 0) && (j.d(this.BJX)))
    {
      Log.d("XWWebView", "translate: onTranslateFinish ");
      j.h(this.BJX);
    }
    paramXWalkView.putSerializable("translate_hashmap", localHashMap);
    paramXWalkView = j.f(this.BJX).onMiscCallBack("onGetTranslateString", paramXWalkView);
    if ((paramXWalkView instanceof Boolean))
    {
      boolean bool = ((Boolean)paramXWalkView).booleanValue();
      AppMethodBeat.o(139593);
      return bool;
    }
    AppMethodBeat.o(139593);
    return false;
  }
  
  public final void onHideCustomView()
  {
    AppMethodBeat.i(85252);
    Log.i("XWWebView", "onHideCustomView");
    if (this.BJX.iyr.aJH())
    {
      Log.i("XWWebView", "onHideCustomView isHandled:true");
      AppMethodBeat.o(85252);
      return;
    }
    this.BJX.BJM.setVisibility(0);
    if (j.c(this.BJX) != null) {
      j.c(this.BJX).onHideCustomView();
    }
    AppMethodBeat.o(85252);
  }
  
  public final void onIconAvailable(XWalkView paramXWalkView, String paramString, Message paramMessage)
  {
    AppMethodBeat.i(85265);
    super.onIconAvailable(paramXWalkView, paramString, paramMessage);
    AppMethodBeat.o(85265);
  }
  
  public final void onJavascriptCloseWindow(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85268);
    super.onJavascriptCloseWindow(paramXWalkView);
    AppMethodBeat.o(85268);
  }
  
  public final boolean onJavascriptModalDialog(XWalkView paramXWalkView, XWalkUIClient.JavascriptMessageType paramJavascriptMessageType, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85269);
    boolean bool = super.onJavascriptModalDialog(paramXWalkView, paramJavascriptMessageType, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
    AppMethodBeat.o(85269);
    return bool;
  }
  
  public final boolean onJsAlert(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85258);
    Log.i("XWWebView", "onJsAlert");
    boolean bool = this.BJX.iyr.a(this.BJX.BHt, paramString1, paramString2, new f.c(paramXWalkJavascriptResult));
    AppMethodBeat.o(85258);
    return bool;
  }
  
  public final boolean onJsConfirm(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85259);
    Log.i("XWWebView", "onJsConfirm");
    boolean bool = this.BJX.iyr.b(this.BJX.BHt, paramString1, paramString2, new f.c(paramXWalkJavascriptResult));
    AppMethodBeat.o(85259);
    return bool;
  }
  
  public final boolean onJsPrompt(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85260);
    Log.i("XWWebView", "onJsPrompt");
    boolean bool = this.BJX.iyr.a(this.BJX.BHt, paramString1, paramString2, paramString3, new f.e(paramXWalkJavascriptResult));
    AppMethodBeat.o(85260);
    return bool;
  }
  
  public final void onPageLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85248);
    Log.i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(paramString)));
    this.BJX.iyq.b(this.BJX.BHt, paramString, this.BJX.BJF.getFavicon());
    k.dYQ().dYN();
    this.BJW = null;
    if ((j.a(this.BJX) != null) && (paramString != null) && (!paramString.equals(j.a(this.BJX))) && (f.ayk(paramString) != f.ayk(j.a(this.BJX))))
    {
      if ((f.ayk(j.a(this.BJX)) == 1) && (f.ayk(paramString) == 2)) {
        j.a(this.BJX, 1);
      }
    }
    else
    {
      j.a(this.BJX, paramString);
      this.BJX.BHz = System.currentTimeMillis();
      paramXWalkView = paramString;
      if (paramString == null) {
        paramXWalkView = "";
      }
      f.fl(paramXWalkView, j.b(this.BJX));
      c.a(this.BJX.BHt);
      if (j.c(this.BJX) != null)
      {
        paramXWalkView = j.c(this.BJX);
        if (this.BJX.BHt.getFullscreenVideoKind() != WebView.a.BEn) {
          break label307;
        }
      }
    }
    label307:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.ao(true, bool);
      if (j.d(this.BJX))
      {
        Log.d("XWWebView", "onTranslateStart setTranslateMode true ");
        j.e(this.BJX);
        this.BJX.BJF.setTranslateMode(true);
      }
      AppMethodBeat.o(85248);
      return;
      if ((f.ayk(j.a(this.BJX)) != 2) || (f.ayk(paramString) != 1)) {
        break;
      }
      j.a(this.BJX, 2);
      break;
    }
  }
  
  public final void onPageLoadStopped(XWalkView paramXWalkView, String paramString, XWalkUIClient.LoadStatus paramLoadStatus)
  {
    AppMethodBeat.i(85249);
    if ((this.BJW != null) && (this.BJW.equals(paramString)))
    {
      Log.i("XWWebView", "abandoned onPageFinished: url = " + paramString + " status = " + paramLoadStatus);
      AppMethodBeat.o(85249);
      return;
    }
    if (j.c(this.BJX) != null)
    {
      paramXWalkView = j.c(this.BJX);
      if (this.BJX.BHt.getFullscreenVideoKind() != WebView.a.BEn) {
        break label216;
      }
    }
    label216:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.ao(false, bool);
      this.BJW = paramString;
      Log.i("XWWebView", "onPageFinished: url = " + paramString + " status = " + paramLoadStatus);
      this.BJX.iyq.b(this.BJX.BHt, paramString);
      if (paramLoadStatus != XWalkUIClient.LoadStatus.FAILED) {
        k.dYQ().dYO();
      }
      f.q(paramString, System.currentTimeMillis() - this.BJX.BHz, j.b(this.BJX));
      this.BJX.BHz = System.currentTimeMillis();
      AppMethodBeat.o(85249);
      return;
    }
  }
  
  public final void onReceivedIcon(XWalkView paramXWalkView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(85266);
    super.onReceivedIcon(paramXWalkView, paramString, paramBitmap);
    AppMethodBeat.o(85266);
  }
  
  public final void onReceivedTitle(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85250);
    Log.i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(paramString)));
    super.onReceivedTitle(paramXWalkView, paramString);
    this.BJX.iyr.d(null, paramString);
    if (j.c(this.BJX) != null)
    {
      paramXWalkView = j.c(this.BJX);
      if (this.BJX.BHt.getFullscreenVideoKind() != WebView.a.BEn) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      paramXWalkView.ao(true, bool);
      AppMethodBeat.o(85250);
      return;
    }
  }
  
  public final void onRequestFocus(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(85267);
    super.onRequestFocus(paramXWalkView);
    AppMethodBeat.o(85267);
  }
  
  public final void onScaleChanged(XWalkView paramXWalkView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(85271);
    this.BJX.iyq.a(this.BJX.BHt, paramFloat1, paramFloat2);
    AppMethodBeat.o(85271);
  }
  
  public final boolean onSearchWord(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85257);
    if (isSearchable())
    {
      paramXWalkView = new Bundle();
      paramXWalkView.putString("query", paramString1);
      j.f(this.BJX).onMiscCallBack("jumpToSos", paramXWalkView);
      this.BJX.BJF.getUrl();
      this.BJX.BJF.getRefererUrl();
      this.BJX.BJF.getTitle();
      AppMethodBeat.o(85257);
      return true;
    }
    AppMethodBeat.o(85257);
    return false;
  }
  
  public final boolean onSelectInfoChanged(XWalkView paramXWalkView, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85254);
    if (!isSearchable())
    {
      AppMethodBeat.o(85254);
      return false;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("PickedWord", paramString1);
    ((Bundle)localObject).putString("PrefixText", paramString2);
    ((Bundle)localObject).putString("SuffixText", paramString3);
    localObject = j.f(this.BJX).onMiscCallBack("smartPickWord", (Bundle)localObject);
    if ((localObject instanceof Bundle))
    {
      localObject = (Bundle)localObject;
      if ((localObject != null) && (((Bundle)localObject).getString("PickedWord") != null))
      {
        int i = ((Bundle)localObject).getInt("PrefixOffset");
        int j = ((Bundle)localObject).getInt("SuffixOffset");
        paramString1 = j.b.c(paramString1, ((Bundle)localObject).getString("PickedWord"), i, j, paramString2, paramString3);
        Log.d("XWWebView", "onSelectInfoChanged " + paramString1.toString());
        paramXWalkView.adjustSelectPosition(paramLong, ((Bundle)localObject).getString("PickedWord"), -paramString1.BKd, paramString1.BKf);
      }
      AppMethodBeat.o(85254);
      return true;
    }
    AppMethodBeat.o(85254);
    return false;
  }
  
  public final void onShowCustomView(View paramView, int paramInt, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85274);
    super.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
    AppMethodBeat.o(85274);
  }
  
  public final void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85251);
    Log.i("XWWebView", "onShowCustomView:".concat(String.valueOf(paramView)));
    boolean bool = this.BJX.iyr.a(paramView, new f.a(paramCustomViewCallback));
    f.dZh();
    if (bool)
    {
      Log.i("XWWebView", "onShowCustomView isHandled:true");
      AppMethodBeat.o(85251);
      return;
    }
    this.BJX.BJM.setVisibility(4);
    if (j.c(this.BJX) != null) {
      j.c(this.BJX).onShowCustomView(paramView, new f.a(paramCustomViewCallback));
    }
    AppMethodBeat.o(85251);
  }
  
  public final void onShowSos()
  {
    AppMethodBeat.i(85255);
    j.f(this.BJX).onMiscCallBack("onShowSos", new Bundle());
    AppMethodBeat.o(85255);
  }
  
  public final void onUnhandledKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(85273);
    super.onUnhandledKeyEvent(paramXWalkView, paramKeyEvent);
    AppMethodBeat.o(85273);
  }
  
  public final void openFileChooser(XWalkView paramXWalkView, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85263);
    Log.i("XWWebView", "openFileChooser with three param");
    this.BJX.iyr.openFileChooser(paramValueCallback, paramString1, paramString2);
    AppMethodBeat.o(85263);
  }
  
  public final boolean shouldDiscardCurrentPage()
  {
    AppMethodBeat.i(85275);
    if (j.f(this.BJX) != null)
    {
      bool = j.f(this.BJX).shouldDiscardCurrentPage();
      AppMethodBeat.o(85275);
      return bool;
    }
    boolean bool = super.shouldDiscardCurrentPage();
    AppMethodBeat.o(85275);
    return bool;
  }
  
  public final boolean shouldOverrideKeyEvent(XWalkView paramXWalkView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(85272);
    boolean bool = super.shouldOverrideKeyEvent(paramXWalkView, paramKeyEvent);
    AppMethodBeat.o(85272);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.1
 * JD-Core Version:    0.7.0.1
 */