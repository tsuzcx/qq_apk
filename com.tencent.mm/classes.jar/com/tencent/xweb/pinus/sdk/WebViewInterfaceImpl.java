package com.tencent.xweb.pinus.sdk;

import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.print.PrintDocumentAdapter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeProvider;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.xwalk.core.ReflectMethod;

public class WebViewInterfaceImpl
  implements WebViewInterface
{
  private static final String TAG = "WebViewInterfaceImpl";
  private ReflectMethod addJavascriptInterfaceObjectStringMethod;
  private ReflectMethod canGoBackMethod;
  private ReflectMethod canGoBackOrForwardintMethod;
  private ReflectMethod canGoForwardMethod;
  private ReflectMethod clearCachebooleanMethod;
  private ReflectMethod clearFormDataMethod;
  private ReflectMethod clearHistoryMethod;
  private ReflectMethod clearMatchesMethod;
  private ReflectMethod clearSslPreferencesMethod;
  private ReflectMethod clearViewMethod;
  private ReflectMethod copyBackForwardListMethod;
  private ReflectMethod createPrintDocumentAdapterStringMethod;
  private ReflectMethod destroyMethod;
  private ReflectMethod dispatchKeyEventKeyEventMethod;
  private ReflectMethod documentHasImagesMessageMethod;
  private ReflectMethod evaluateJavascriptStringValueCallbackStringMethod;
  private ReflectMethod findAllAsyncStringMethod;
  private ReflectMethod findNextbooleanMethod;
  private ReflectMethod flingScrollintintMethod;
  private ReflectMethod getAccessibilityNodeProviderMethod;
  private ReflectMethod getCertificateMethod;
  private ReflectMethod getContentHeightMethod;
  private ReflectMethod getContentViewMethod;
  private ReflectMethod getFaviconMethod;
  private ReflectMethod getHitTestResultInnerMethod;
  private ReflectMethod getImageBitmapToFileStringStringStringObjectMethod;
  private ReflectMethod getOriginalUrlMethod;
  private ReflectMethod getProgressMethod;
  private ReflectMethod getScaleMethod;
  private ReflectMethod getSettingsInnerMethod;
  private ReflectMethod getTitleMethod;
  private ReflectMethod getTranslateSampleStringintMethod;
  private ReflectMethod getUrlMethod;
  private ReflectMethod goBackMethod;
  private ReflectMethod goBackOrForwardintMethod;
  private ReflectMethod goForwardMethod;
  private Object inner;
  private ReflectMethod invokeZoomPickerMethod;
  private ReflectMethod isPrivateBrowsingEnabledMethod;
  private ReflectMethod loadDataStringStringStringMethod;
  private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
  private ReflectMethod loadUrlStringMapStringStringMethod;
  private ReflectMethod loadUrlStringMethod;
  private ReflectMethod onCheckIsTextEditorMethod;
  private ReflectMethod onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod;
  private ReflectMethod onHideMethod;
  private ReflectMethod onPauseMethod;
  private ReflectMethod onResumeMethod;
  private ReflectMethod onShowMethod;
  private ReflectMethod onTouchEventMotionEventMethod;
  private ReflectMethod pageDownbooleanMethod;
  private ReflectMethod pageUpbooleanMethod;
  private ReflectMethod pauseTimersMethod;
  private ReflectMethod postUrlStringbyteMethod;
  private ReflectMethod reloadMethod;
  private ReflectMethod removeJavascriptInterfaceStringMethod;
  private ReflectMethod replaceTranslatedStringMapStringStringMethod;
  private ReflectMethod requestFocusNodeHrefMessageMethod;
  private ReflectMethod requestImageRefMessageMethod;
  private ReflectMethod restoreStateBundleMethod;
  private ReflectMethod resumeTimersMethod;
  private ReflectMethod savePageStringStringintMethod;
  private ReflectMethod saveStateBundleMethod;
  private ReflectMethod saveWebArchiveStringMethod;
  private ReflectMethod saveWebArchiveStringbooleanValueCallbackStringMethod;
  private ReflectMethod setBackgroundColorintMethod;
  private ReflectMethod setBottomHeightintMethod;
  private ReflectMethod setDownloadListenerDownloadListenerMethod;
  private ReflectMethod setExtendPluginClientObjectMethod;
  private ReflectMethod setExtendTextAreaClientObjectMethod;
  private ReflectMethod setFindListenerandroidwebkitWebViewFindListenerMethod;
  private ReflectMethod setHorizontalScrollBarEnablebooleanMethod;
  private ReflectMethod setInitialScaleintMethod;
  private ReflectMethod setNetworkAvailablebooleanMethod;
  private ReflectMethod setOnTouchListenerOnTouchListenerMethod;
  private ReflectMethod setPluginTextureScaleStringintfloatfloatMethod;
  private ReflectMethod setProxyWebViewClientExtensionObjectMethod;
  private ReflectMethod setTranslateModebooleanMethod;
  private ReflectMethod setVerticalScrollBarEnablebooleanMethod;
  private ReflectMethod setWebChromeClientObjectMethod;
  private ReflectMethod setWebContentsDebuggingEnabledbooleanMethod;
  private ReflectMethod setWebContentsSizeintintMethod;
  private ReflectMethod setWebViewClientObjectMethod;
  private ReflectMethod smoothScrollintintlongMethod;
  private ReflectMethod stopLoadingMethod;
  private ReflectMethod takePluginScreenshotStringintMethod;
  private ReflectMethod view_computeHorizontalScrollOffsetMethod;
  private ReflectMethod view_computeHorizontalScrollRangeMethod;
  private ReflectMethod view_computeVerticalScrollExtentMethod;
  private ReflectMethod view_computeVerticalScrollOffsetMethod;
  private ReflectMethod view_computeVerticalScrollRangeMethod;
  private ReflectMethod view_scrollByintintMethod;
  private ReflectMethod view_scrollTointintMethod;
  private ReflectMethod zoomByfloatMethod;
  private ReflectMethod zoomInMethod;
  private ReflectMethod zoomOutMethod;
  
  public WebViewInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getAddJavascriptInterfaceObjectStringMethod()
  {
    try
    {
      AppMethodBeat.i(213415);
      ReflectMethod localReflectMethod2 = this.addJavascriptInterfaceObjectStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "addJavascriptInterface", new Class[] { Object.class, String.class });
        this.addJavascriptInterfaceObjectStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213415);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getCanGoBackMethod()
  {
    try
    {
      AppMethodBeat.i(213422);
      ReflectMethod localReflectMethod2 = this.canGoBackMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "canGoBack", new Class[0]);
        this.canGoBackMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213422);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getCanGoBackOrForwardintMethod()
  {
    try
    {
      AppMethodBeat.i(213426);
      ReflectMethod localReflectMethod2 = this.canGoBackOrForwardintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "canGoBackOrForward", new Class[] { Integer.TYPE });
        this.canGoBackOrForwardintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213426);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getCanGoForwardMethod()
  {
    try
    {
      AppMethodBeat.i(213431);
      ReflectMethod localReflectMethod2 = this.canGoForwardMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "canGoForward", new Class[0]);
        this.canGoForwardMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213431);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearCachebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213439);
      ReflectMethod localReflectMethod2 = this.clearCachebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearCache", new Class[] { Boolean.TYPE });
        this.clearCachebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213439);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearFormDataMethod()
  {
    try
    {
      AppMethodBeat.i(213442);
      ReflectMethod localReflectMethod2 = this.clearFormDataMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearFormData", new Class[0]);
        this.clearFormDataMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213442);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearHistoryMethod()
  {
    try
    {
      AppMethodBeat.i(213447);
      ReflectMethod localReflectMethod2 = this.clearHistoryMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearHistory", new Class[0]);
        this.clearHistoryMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213447);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearMatchesMethod()
  {
    try
    {
      AppMethodBeat.i(213455);
      ReflectMethod localReflectMethod2 = this.clearMatchesMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearMatches", new Class[0]);
        this.clearMatchesMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213455);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearSslPreferencesMethod()
  {
    try
    {
      AppMethodBeat.i(213461);
      ReflectMethod localReflectMethod2 = this.clearSslPreferencesMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearSslPreferences", new Class[0]);
        this.clearSslPreferencesMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213461);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getClearViewMethod()
  {
    try
    {
      AppMethodBeat.i(213470);
      ReflectMethod localReflectMethod2 = this.clearViewMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "clearView", new Class[0]);
        this.clearViewMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213470);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getCopyBackForwardListMethod()
  {
    try
    {
      AppMethodBeat.i(213477);
      ReflectMethod localReflectMethod2 = this.copyBackForwardListMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "copyBackForwardList", new Class[0]);
        this.copyBackForwardListMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213477);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getCreatePrintDocumentAdapterStringMethod()
  {
    try
    {
      AppMethodBeat.i(213485);
      ReflectMethod localReflectMethod2 = this.createPrintDocumentAdapterStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "createPrintDocumentAdapter", new Class[] { String.class });
        this.createPrintDocumentAdapterStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213485);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getDestroyMethod()
  {
    try
    {
      AppMethodBeat.i(213489);
      ReflectMethod localReflectMethod2 = this.destroyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "destroy", new Class[0]);
        this.destroyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213489);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getDispatchKeyEventKeyEventMethod()
  {
    try
    {
      AppMethodBeat.i(213494);
      ReflectMethod localReflectMethod2 = this.dispatchKeyEventKeyEventMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "dispatchKeyEvent", new Class[] { KeyEvent.class });
        this.dispatchKeyEventKeyEventMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213494);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getDocumentHasImagesMessageMethod()
  {
    try
    {
      AppMethodBeat.i(213499);
      ReflectMethod localReflectMethod2 = this.documentHasImagesMessageMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "documentHasImages", new Class[] { Message.class });
        this.documentHasImagesMessageMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213499);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getEvaluateJavascriptStringValueCallbackStringMethod()
  {
    try
    {
      AppMethodBeat.i(213505);
      ReflectMethod localReflectMethod2 = this.evaluateJavascriptStringValueCallbackStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "evaluateJavascript", new Class[] { String.class, ValueCallback.class });
        this.evaluateJavascriptStringValueCallbackStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213505);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getFindAllAsyncStringMethod()
  {
    try
    {
      AppMethodBeat.i(213512);
      ReflectMethod localReflectMethod2 = this.findAllAsyncStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "findAllAsync", new Class[] { String.class });
        this.findAllAsyncStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213512);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getFindNextbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213520);
      ReflectMethod localReflectMethod2 = this.findNextbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "findNext", new Class[] { Boolean.TYPE });
        this.findNextbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213520);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getFlingScrollintintMethod()
  {
    try
    {
      AppMethodBeat.i(213525);
      ReflectMethod localReflectMethod2 = this.flingScrollintintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "flingScroll", new Class[] { Integer.TYPE, Integer.TYPE });
        this.flingScrollintintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213525);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAccessibilityNodeProviderMethod()
  {
    try
    {
      AppMethodBeat.i(213541);
      ReflectMethod localReflectMethod2 = this.getAccessibilityNodeProviderMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAccessibilityNodeProvider", new Class[0]);
        this.getAccessibilityNodeProviderMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213541);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetCertificateMethod()
  {
    try
    {
      AppMethodBeat.i(213548);
      ReflectMethod localReflectMethod2 = this.getCertificateMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getCertificate", new Class[0]);
        this.getCertificateMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213548);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetContentHeightMethod()
  {
    try
    {
      AppMethodBeat.i(213556);
      ReflectMethod localReflectMethod2 = this.getContentHeightMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getContentHeight", new Class[0]);
        this.getContentHeightMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213556);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetContentViewMethod()
  {
    try
    {
      AppMethodBeat.i(213919);
      ReflectMethod localReflectMethod2 = this.getContentViewMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getContentView", new Class[0]);
        this.getContentViewMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213919);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetFaviconMethod()
  {
    try
    {
      AppMethodBeat.i(213562);
      ReflectMethod localReflectMethod2 = this.getFaviconMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getFavicon", new Class[0]);
        this.getFaviconMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213562);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetHitTestResultInnerMethod()
  {
    try
    {
      AppMethodBeat.i(213571);
      ReflectMethod localReflectMethod2 = this.getHitTestResultInnerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getHitTestResultInner", new Class[0]);
        this.getHitTestResultInnerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213571);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetImageBitmapToFileStringStringStringObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213971);
      ReflectMethod localReflectMethod2 = this.getImageBitmapToFileStringStringStringObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getImageBitmapToFile", new Class[] { String.class, String.class, String.class, Object.class });
        this.getImageBitmapToFileStringStringStringObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213971);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetOriginalUrlMethod()
  {
    try
    {
      AppMethodBeat.i(213576);
      ReflectMethod localReflectMethod2 = this.getOriginalUrlMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getOriginalUrl", new Class[0]);
        this.getOriginalUrlMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213576);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetProgressMethod()
  {
    try
    {
      AppMethodBeat.i(213585);
      ReflectMethod localReflectMethod2 = this.getProgressMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getProgress", new Class[0]);
        this.getProgressMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213585);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetScaleMethod()
  {
    try
    {
      AppMethodBeat.i(213594);
      ReflectMethod localReflectMethod2 = this.getScaleMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getScale", new Class[0]);
        this.getScaleMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213594);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetSettingsInnerMethod()
  {
    try
    {
      AppMethodBeat.i(213599);
      ReflectMethod localReflectMethod2 = this.getSettingsInnerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getSettingsInner", new Class[0]);
        this.getSettingsInnerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213599);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetTitleMethod()
  {
    try
    {
      AppMethodBeat.i(213606);
      ReflectMethod localReflectMethod2 = this.getTitleMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getTitle", new Class[0]);
        this.getTitleMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213606);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetTranslateSampleStringintMethod()
  {
    try
    {
      AppMethodBeat.i(214039);
      ReflectMethod localReflectMethod2 = this.getTranslateSampleStringintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getTranslateSampleString", new Class[] { Integer.TYPE });
        this.getTranslateSampleStringintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214039);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetUrlMethod()
  {
    try
    {
      AppMethodBeat.i(213615);
      ReflectMethod localReflectMethod2 = this.getUrlMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getUrl", new Class[0]);
        this.getUrlMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213615);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGoBackMethod()
  {
    try
    {
      AppMethodBeat.i(213625);
      ReflectMethod localReflectMethod2 = this.goBackMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "goBack", new Class[0]);
        this.goBackMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213625);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGoBackOrForwardintMethod()
  {
    try
    {
      AppMethodBeat.i(213634);
      ReflectMethod localReflectMethod2 = this.goBackOrForwardintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "goBackOrForward", new Class[] { Integer.TYPE });
        this.goBackOrForwardintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213634);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGoForwardMethod()
  {
    try
    {
      AppMethodBeat.i(213642);
      ReflectMethod localReflectMethod2 = this.goForwardMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "goForward", new Class[0]);
        this.goForwardMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213642);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getInvokeZoomPickerMethod()
  {
    try
    {
      AppMethodBeat.i(213651);
      ReflectMethod localReflectMethod2 = this.invokeZoomPickerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "invokeZoomPicker", new Class[0]);
        this.invokeZoomPickerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213651);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getIsPrivateBrowsingEnabledMethod()
  {
    try
    {
      AppMethodBeat.i(213658);
      ReflectMethod localReflectMethod2 = this.isPrivateBrowsingEnabledMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "isPrivateBrowsingEnabled", new Class[0]);
        this.isPrivateBrowsingEnabledMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213658);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getLoadDataStringStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(213668);
      ReflectMethod localReflectMethod2 = this.loadDataStringStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "loadData", new Class[] { String.class, String.class, String.class });
        this.loadDataStringStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213668);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getLoadDataWithBaseURLStringStringStringStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(213682);
      ReflectMethod localReflectMethod2 = this.loadDataWithBaseURLStringStringStringStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "loadDataWithBaseURL", new Class[] { String.class, String.class, String.class, String.class, String.class });
        this.loadDataWithBaseURLStringStringStringStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213682);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getLoadUrlStringMapStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(213697);
      ReflectMethod localReflectMethod2 = this.loadUrlStringMapStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "loadUrl", new Class[] { String.class, Map.class });
        this.loadUrlStringMapStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213697);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getLoadUrlStringMethod()
  {
    try
    {
      AppMethodBeat.i(213689);
      ReflectMethod localReflectMethod2 = this.loadUrlStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "loadUrl", new Class[] { String.class });
        this.loadUrlStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213689);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnCheckIsTextEditorMethod()
  {
    try
    {
      AppMethodBeat.i(213703);
      ReflectMethod localReflectMethod2 = this.onCheckIsTextEditorMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onCheckIsTextEditor", new Class[0]);
        this.onCheckIsTextEditorMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213703);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213955);
      ReflectMethod localReflectMethod2 = this.onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onExtendTextAreaKeyboardHeightChanged", new Class[] { Boolean.TYPE, Integer.TYPE, Boolean.TYPE });
        this.onExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213955);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnHideMethod()
  {
    try
    {
      AppMethodBeat.i(214081);
      ReflectMethod localReflectMethod2 = this.onHideMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onHide", new Class[0]);
        this.onHideMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214081);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnPauseMethod()
  {
    try
    {
      AppMethodBeat.i(213709);
      ReflectMethod localReflectMethod2 = this.onPauseMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onPause", new Class[0]);
        this.onPauseMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213709);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnResumeMethod()
  {
    try
    {
      AppMethodBeat.i(213718);
      ReflectMethod localReflectMethod2 = this.onResumeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onResume", new Class[0]);
        this.onResumeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213718);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnShowMethod()
  {
    try
    {
      AppMethodBeat.i(214070);
      ReflectMethod localReflectMethod2 = this.onShowMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onShow", new Class[0]);
        this.onShowMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214070);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getOnTouchEventMotionEventMethod()
  {
    try
    {
      AppMethodBeat.i(214101);
      ReflectMethod localReflectMethod2 = this.onTouchEventMotionEventMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "onTouchEvent", new Class[] { MotionEvent.class });
        this.onTouchEventMotionEventMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214101);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getPageDownbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213726);
      ReflectMethod localReflectMethod2 = this.pageDownbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "pageDown", new Class[] { Boolean.TYPE });
        this.pageDownbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213726);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getPageUpbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213733);
      ReflectMethod localReflectMethod2 = this.pageUpbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "pageUp", new Class[] { Boolean.TYPE });
        this.pageUpbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213733);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getPauseTimersMethod()
  {
    try
    {
      AppMethodBeat.i(213742);
      ReflectMethod localReflectMethod2 = this.pauseTimersMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "pauseTimers", new Class[0]);
        this.pauseTimersMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213742);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getPostUrlStringbyteMethod()
  {
    try
    {
      AppMethodBeat.i(213752);
      ReflectMethod localReflectMethod2 = this.postUrlStringbyteMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "postUrl", new Class[] { String.class, [B.class });
        this.postUrlStringbyteMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213752);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getReloadMethod()
  {
    try
    {
      AppMethodBeat.i(213760);
      ReflectMethod localReflectMethod2 = this.reloadMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "reload", new Class[0]);
        this.reloadMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213760);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRemoveJavascriptInterfaceStringMethod()
  {
    try
    {
      AppMethodBeat.i(213766);
      ReflectMethod localReflectMethod2 = this.removeJavascriptInterfaceStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "removeJavascriptInterface", new Class[] { String.class });
        this.removeJavascriptInterfaceStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213766);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getReplaceTranslatedStringMapStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(214060);
      ReflectMethod localReflectMethod2 = this.replaceTranslatedStringMapStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "replaceTranslatedString", new Class[] { Map.class });
        this.replaceTranslatedStringMapStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214060);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRequestFocusNodeHrefMessageMethod()
  {
    try
    {
      AppMethodBeat.i(213774);
      ReflectMethod localReflectMethod2 = this.requestFocusNodeHrefMessageMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "requestFocusNodeHref", new Class[] { Message.class });
        this.requestFocusNodeHrefMessageMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213774);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRequestImageRefMessageMethod()
  {
    try
    {
      AppMethodBeat.i(213784);
      ReflectMethod localReflectMethod2 = this.requestImageRefMessageMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "requestImageRef", new Class[] { Message.class });
        this.requestImageRefMessageMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213784);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getRestoreStateBundleMethod()
  {
    try
    {
      AppMethodBeat.i(213794);
      ReflectMethod localReflectMethod2 = this.restoreStateBundleMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "restoreState", new Class[] { Bundle.class });
        this.restoreStateBundleMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213794);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getResumeTimersMethod()
  {
    try
    {
      AppMethodBeat.i(213803);
      ReflectMethod localReflectMethod2 = this.resumeTimersMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "resumeTimers", new Class[0]);
        this.resumeTimersMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213803);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSavePageStringStringintMethod()
  {
    try
    {
      AppMethodBeat.i(214110);
      ReflectMethod localReflectMethod2 = this.savePageStringStringintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "savePage", new Class[] { String.class, String.class, Integer.TYPE });
        this.savePageStringStringintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214110);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSaveStateBundleMethod()
  {
    try
    {
      AppMethodBeat.i(213810);
      ReflectMethod localReflectMethod2 = this.saveStateBundleMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "saveState", new Class[] { Bundle.class });
        this.saveStateBundleMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213810);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSaveWebArchiveStringMethod()
  {
    try
    {
      AppMethodBeat.i(213817);
      ReflectMethod localReflectMethod2 = this.saveWebArchiveStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "saveWebArchive", new Class[] { String.class });
        this.saveWebArchiveStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213817);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSaveWebArchiveStringbooleanValueCallbackStringMethod()
  {
    try
    {
      AppMethodBeat.i(213827);
      ReflectMethod localReflectMethod2 = this.saveWebArchiveStringbooleanValueCallbackStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, ValueCallback.class });
        this.saveWebArchiveStringbooleanValueCallbackStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213827);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBackgroundColorintMethod()
  {
    try
    {
      AppMethodBeat.i(213834);
      ReflectMethod localReflectMethod2 = this.setBackgroundColorintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBackgroundColor", new Class[] { Integer.TYPE });
        this.setBackgroundColorintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213834);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBottomHeightintMethod()
  {
    try
    {
      AppMethodBeat.i(214089);
      ReflectMethod localReflectMethod2 = this.setBottomHeightintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBottomHeight", new Class[] { Integer.TYPE });
        this.setBottomHeightintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214089);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDownloadListenerDownloadListenerMethod()
  {
    try
    {
      AppMethodBeat.i(213839);
      ReflectMethod localReflectMethod2 = this.setDownloadListenerDownloadListenerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDownloadListener", new Class[] { DownloadListener.class });
        this.setDownloadListenerDownloadListenerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213839);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetExtendPluginClientObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213925);
      ReflectMethod localReflectMethod2 = this.setExtendPluginClientObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setExtendPluginClient", new Class[] { Object.class });
        this.setExtendPluginClientObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213925);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetExtendTextAreaClientObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213949);
      ReflectMethod localReflectMethod2 = this.setExtendTextAreaClientObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setExtendTextAreaClient", new Class[] { Object.class });
        this.setExtendTextAreaClientObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213949);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetFindListenerandroidwebkitWebViewFindListenerMethod()
  {
    try
    {
      AppMethodBeat.i(213845);
      ReflectMethod localReflectMethod2 = this.setFindListenerandroidwebkitWebViewFindListenerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setFindListener", new Class[] { WebView.FindListener.class });
        this.setFindListenerandroidwebkitWebViewFindListenerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213845);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetHorizontalScrollBarEnablebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214130);
      ReflectMethod localReflectMethod2 = this.setHorizontalScrollBarEnablebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setHorizontalScrollBarEnable", new Class[] { Boolean.TYPE });
        this.setHorizontalScrollBarEnablebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214130);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetInitialScaleintMethod()
  {
    try
    {
      AppMethodBeat.i(213853);
      ReflectMethod localReflectMethod2 = this.setInitialScaleintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setInitialScale", new Class[] { Integer.TYPE });
        this.setInitialScaleintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213853);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetNetworkAvailablebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213860);
      ReflectMethod localReflectMethod2 = this.setNetworkAvailablebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setNetworkAvailable", new Class[] { Boolean.TYPE });
        this.setNetworkAvailablebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213860);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetOnTouchListenerOnTouchListenerMethod()
  {
    try
    {
      AppMethodBeat.i(213533);
      ReflectMethod localReflectMethod2 = this.setOnTouchListenerOnTouchListenerMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setOnTouchListener", new Class[] { View.OnTouchListener.class });
        this.setOnTouchListenerOnTouchListenerMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213533);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetPluginTextureScaleStringintfloatfloatMethod()
  {
    try
    {
      AppMethodBeat.i(213933);
      ReflectMethod localReflectMethod2 = this.setPluginTextureScaleStringintfloatfloatMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setPluginTextureScale", new Class[] { String.class, Integer.TYPE, Float.TYPE, Float.TYPE });
        this.setPluginTextureScaleStringintfloatfloatMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213933);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetProxyWebViewClientExtensionObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213963);
      ReflectMethod localReflectMethod2 = this.setProxyWebViewClientExtensionObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setProxyWebViewClientExtension", new Class[] { Object.class });
        this.setProxyWebViewClientExtensionObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213963);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetTranslateModebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214052);
      ReflectMethod localReflectMethod2 = this.setTranslateModebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setTranslateMode", new Class[] { Boolean.TYPE });
        this.setTranslateModebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214052);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetVerticalScrollBarEnablebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214118);
      ReflectMethod localReflectMethod2 = this.setVerticalScrollBarEnablebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setVerticalScrollBarEnable", new Class[] { Boolean.TYPE });
        this.setVerticalScrollBarEnablebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214118);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetWebChromeClientObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213869);
      ReflectMethod localReflectMethod2 = this.setWebChromeClientObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setWebChromeClient", new Class[] { Object.class });
        this.setWebChromeClientObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213869);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetWebContentsDebuggingEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213889);
      ReflectMethod localReflectMethod2 = this.setWebContentsDebuggingEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
        this.setWebContentsDebuggingEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213889);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetWebContentsSizeintintMethod()
  {
    try
    {
      AppMethodBeat.i(214139);
      ReflectMethod localReflectMethod2 = this.setWebContentsSizeintintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setWebContentsSize", new Class[] { Integer.TYPE, Integer.TYPE });
        this.setWebContentsSizeintintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214139);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetWebViewClientObjectMethod()
  {
    try
    {
      AppMethodBeat.i(213894);
      ReflectMethod localReflectMethod2 = this.setWebViewClientObjectMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setWebViewClient", new Class[] { Object.class });
        this.setWebViewClientObjectMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213894);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSmoothScrollintintlongMethod()
  {
    try
    {
      AppMethodBeat.i(214030);
      ReflectMethod localReflectMethod2 = this.smoothScrollintintlongMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "smoothScroll", new Class[] { Integer.TYPE, Integer.TYPE, Long.TYPE });
        this.smoothScrollintintlongMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214030);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getStopLoadingMethod()
  {
    try
    {
      AppMethodBeat.i(213899);
      ReflectMethod localReflectMethod2 = this.stopLoadingMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "stopLoading", new Class[0]);
        this.stopLoadingMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213899);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getTakePluginScreenshotStringintMethod()
  {
    try
    {
      AppMethodBeat.i(213943);
      ReflectMethod localReflectMethod2 = this.takePluginScreenshotStringintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "takePluginScreenshot", new Class[] { String.class, Integer.TYPE });
        this.takePluginScreenshotStringintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213943);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_computeHorizontalScrollOffsetMethod()
  {
    try
    {
      AppMethodBeat.i(213979);
      ReflectMethod localReflectMethod2 = this.view_computeHorizontalScrollOffsetMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_computeHorizontalScrollOffset", new Class[0]);
        this.view_computeHorizontalScrollOffsetMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213979);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_computeHorizontalScrollRangeMethod()
  {
    try
    {
      AppMethodBeat.i(213986);
      ReflectMethod localReflectMethod2 = this.view_computeHorizontalScrollRangeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_computeHorizontalScrollRange", new Class[0]);
        this.view_computeHorizontalScrollRangeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213986);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_computeVerticalScrollExtentMethod()
  {
    try
    {
      AppMethodBeat.i(213993);
      ReflectMethod localReflectMethod2 = this.view_computeVerticalScrollExtentMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_computeVerticalScrollExtent", new Class[0]);
        this.view_computeVerticalScrollExtentMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213993);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_computeVerticalScrollOffsetMethod()
  {
    try
    {
      AppMethodBeat.i(214000);
      ReflectMethod localReflectMethod2 = this.view_computeVerticalScrollOffsetMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_computeVerticalScrollOffset", new Class[0]);
        this.view_computeVerticalScrollOffsetMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214000);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_computeVerticalScrollRangeMethod()
  {
    try
    {
      AppMethodBeat.i(214006);
      ReflectMethod localReflectMethod2 = this.view_computeVerticalScrollRangeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_computeVerticalScrollRange", new Class[0]);
        this.view_computeVerticalScrollRangeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214006);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_scrollByintintMethod()
  {
    try
    {
      AppMethodBeat.i(214021);
      ReflectMethod localReflectMethod2 = this.view_scrollByintintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_scrollBy", new Class[] { Integer.TYPE, Integer.TYPE });
        this.view_scrollByintintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214021);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getView_scrollTointintMethod()
  {
    try
    {
      AppMethodBeat.i(214015);
      ReflectMethod localReflectMethod2 = this.view_scrollTointintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "view_scrollTo", new Class[] { Integer.TYPE, Integer.TYPE });
        this.view_scrollTointintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214015);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getZoomByfloatMethod()
  {
    try
    {
      AppMethodBeat.i(213906);
      ReflectMethod localReflectMethod2 = this.zoomByfloatMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "zoomBy", new Class[] { Float.TYPE });
        this.zoomByfloatMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213906);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getZoomInMethod()
  {
    try
    {
      AppMethodBeat.i(213910);
      ReflectMethod localReflectMethod2 = this.zoomInMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "zoomIn", new Class[0]);
        this.zoomInMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213910);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getZoomOutMethod()
  {
    try
    {
      AppMethodBeat.i(213914);
      ReflectMethod localReflectMethod2 = this.zoomOutMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "zoomOut", new Class[0]);
        this.zoomOutMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213914);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(214159);
    try
    {
      getAddJavascriptInterfaceObjectStringMethod().invoke(new Object[] { paramObject, paramString });
      AppMethodBeat.o(214159);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214159);
    }
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(214169);
    try
    {
      bool = ((Boolean)getCanGoBackMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214169);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    AppMethodBeat.i(214180);
    try
    {
      bool = ((Boolean)getCanGoBackOrForwardintMethod().invoke(new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(214180);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(214190);
    try
    {
      bool = ((Boolean)getCanGoForwardMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214190);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(214202);
    try
    {
      getClearCachebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214202);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214202);
    }
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(214213);
    try
    {
      getClearFormDataMethod().invoke(new Object[0]);
      AppMethodBeat.o(214213);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214213);
    }
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(214224);
    try
    {
      getClearHistoryMethod().invoke(new Object[0]);
      AppMethodBeat.o(214224);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214224);
    }
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(214233);
    try
    {
      getClearMatchesMethod().invoke(new Object[0]);
      AppMethodBeat.o(214233);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214233);
    }
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(214241);
    try
    {
      getClearSslPreferencesMethod().invoke(new Object[0]);
      AppMethodBeat.o(214241);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214241);
    }
  }
  
  public void clearView()
  {
    AppMethodBeat.i(214248);
    try
    {
      getClearViewMethod().invoke(new Object[0]);
      AppMethodBeat.o(214248);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214248);
    }
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(214258);
    try
    {
      WebBackForwardList localWebBackForwardList = (WebBackForwardList)getCopyBackForwardListMethod().invoke(new Object[0]);
      AppMethodBeat.o(214258);
      return localWebBackForwardList;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public PrintDocumentAdapter createPrintDocumentAdapter(String paramString)
  {
    AppMethodBeat.i(214266);
    try
    {
      paramString = (PrintDocumentAdapter)getCreatePrintDocumentAdapterStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214266);
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      for (;;)
      {
        handleRuntimeError(paramString);
        paramString = null;
      }
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(214275);
    try
    {
      getDestroyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214275);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214275);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(214282);
    try
    {
      bool = ((Boolean)getDispatchKeyEventKeyEventMethod().invoke(new Object[] { paramKeyEvent })).booleanValue();
      AppMethodBeat.o(214282);
      return bool;
    }
    catch (UnsupportedOperationException paramKeyEvent)
    {
      for (;;)
      {
        handleRuntimeError(paramKeyEvent);
        boolean bool = false;
      }
    }
  }
  
  public void documentHasImages(Message paramMessage)
  {
    AppMethodBeat.i(214291);
    try
    {
      getDocumentHasImagesMessageMethod().invoke(new Object[] { paramMessage });
      AppMethodBeat.o(214291);
      return;
    }
    catch (UnsupportedOperationException paramMessage)
    {
      handleRuntimeError(paramMessage);
      AppMethodBeat.o(214291);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(214301);
    try
    {
      getEvaluateJavascriptStringValueCallbackStringMethod().invoke(new Object[] { paramString, paramValueCallback });
      AppMethodBeat.o(214301);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214301);
    }
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(214313);
    try
    {
      getFindAllAsyncStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214313);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214313);
    }
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(214323);
    try
    {
      getFindNextbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214323);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214323);
    }
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214334);
    try
    {
      getFlingScrollintintMethod().invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(214334);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214334);
    }
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(214362);
    try
    {
      AccessibilityNodeProvider localAccessibilityNodeProvider = (AccessibilityNodeProvider)getGetAccessibilityNodeProviderMethod().invoke(new Object[0]);
      AppMethodBeat.o(214362);
      return localAccessibilityNodeProvider;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(214368);
    try
    {
      SslCertificate localSslCertificate = (SslCertificate)getGetCertificateMethod().invoke(new Object[0]);
      AppMethodBeat.o(214368);
      return localSslCertificate;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(214377);
    try
    {
      i = ((Integer)getGetContentHeightMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214377);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public ViewGroup getContentView()
  {
    AppMethodBeat.i(214838);
    try
    {
      ViewGroup localViewGroup = (ViewGroup)getGetContentViewMethod().invoke(new Object[0]);
      AppMethodBeat.o(214838);
      return localViewGroup;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(214387);
    try
    {
      Bitmap localBitmap = (Bitmap)getGetFaviconMethod().invoke(new Object[0]);
      AppMethodBeat.o(214387);
      return localBitmap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public Object getHitTestResultInner()
  {
    AppMethodBeat.i(214396);
    Object localObject1 = null;
    try
    {
      Object localObject2 = getGetHitTestResultInnerMethod().invoke(new Object[0]);
      localObject1 = localObject2;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
      }
    }
    AppMethodBeat.o(214396);
    return localObject1;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(214910);
    try
    {
      bool = ((Boolean)getGetImageBitmapToFileStringStringStringObjectMethod().invoke(new Object[] { paramString1, paramString2, paramString3, paramObject })).booleanValue();
      AppMethodBeat.o(214910);
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      for (;;)
      {
        handleRuntimeError(paramString1);
        boolean bool = false;
      }
    }
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(214407);
    try
    {
      String str = (String)getGetOriginalUrlMethod().invoke(new Object[0]);
      AppMethodBeat.o(214407);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(214418);
    try
    {
      i = ((Integer)getGetProgressMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214418);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public float getScale()
  {
    AppMethodBeat.i(214428);
    try
    {
      f = ((Float)getGetScaleMethod().invoke(new Object[0])).floatValue();
      AppMethodBeat.o(214428);
      return f;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        float f = 0.0F;
      }
    }
  }
  
  public Object getSettingsInner()
  {
    AppMethodBeat.i(214439);
    Object localObject1 = null;
    try
    {
      Object localObject2 = getGetSettingsInnerMethod().invoke(new Object[0]);
      localObject1 = localObject2;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
      }
    }
    AppMethodBeat.o(214439);
    return localObject1;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(214451);
    try
    {
      String str = (String)getGetTitleMethod().invoke(new Object[0]);
      AppMethodBeat.o(214451);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public void getTranslateSampleString(int paramInt)
  {
    AppMethodBeat.i(214995);
    try
    {
      getGetTranslateSampleStringintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214995);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214995);
    }
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(214466);
    try
    {
      String str = (String)getGetUrlMethod().invoke(new Object[0]);
      AppMethodBeat.o(214466);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        Object localObject = null;
      }
    }
  }
  
  public void goBack()
  {
    AppMethodBeat.i(214477);
    try
    {
      getGoBackMethod().invoke(new Object[0]);
      AppMethodBeat.o(214477);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214477);
    }
  }
  
  public void goBackOrForward(int paramInt)
  {
    AppMethodBeat.i(214490);
    try
    {
      getGoBackOrForwardintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214490);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214490);
    }
  }
  
  public void goForward()
  {
    AppMethodBeat.i(214500);
    try
    {
      getGoForwardMethod().invoke(new Object[0]);
      AppMethodBeat.o(214500);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214500);
    }
  }
  
  public void invokeZoomPicker()
  {
    AppMethodBeat.i(214514);
    try
    {
      getInvokeZoomPickerMethod().invoke(new Object[0]);
      AppMethodBeat.o(214514);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214514);
    }
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    AppMethodBeat.i(214526);
    try
    {
      bool = ((Boolean)getIsPrivateBrowsingEnabledMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214526);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214538);
    try
    {
      getLoadDataStringStringStringMethod().invoke(new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(214538);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      handleRuntimeError(paramString1);
      AppMethodBeat.o(214538);
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(214548);
    try
    {
      getLoadDataWithBaseURLStringStringStringStringStringMethod().invoke(new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
      AppMethodBeat.o(214548);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      handleRuntimeError(paramString1);
      AppMethodBeat.o(214548);
    }
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(214556);
    try
    {
      getLoadUrlStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214556);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214556);
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(214566);
    try
    {
      getLoadUrlStringMapStringStringMethod().invoke(new Object[] { paramString, paramMap });
      AppMethodBeat.o(214566);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214566);
    }
  }
  
  public boolean onCheckIsTextEditor()
  {
    AppMethodBeat.i(214575);
    try
    {
      bool = ((Boolean)getOnCheckIsTextEditorMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214575);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public void onExtendTextAreaKeyboardHeightChanged(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(214891);
    try
    {
      getOnExtendTextAreaKeyboardHeightChangedbooleanintbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(214891);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214891);
    }
  }
  
  public void onHide()
  {
    AppMethodBeat.i(215025);
    try
    {
      getOnHideMethod().invoke(new Object[0]);
      AppMethodBeat.o(215025);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215025);
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(214588);
    try
    {
      getOnPauseMethod().invoke(new Object[0]);
      AppMethodBeat.o(214588);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214588);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(214597);
    try
    {
      getOnResumeMethod().invoke(new Object[0]);
      AppMethodBeat.o(214597);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214597);
    }
  }
  
  public void onShow()
  {
    AppMethodBeat.i(215014);
    try
    {
      getOnShowMethod().invoke(new Object[0]);
      AppMethodBeat.o(215014);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215014);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(215041);
    try
    {
      bool = ((Boolean)getOnTouchEventMotionEventMethod().invoke(new Object[] { paramMotionEvent })).booleanValue();
      AppMethodBeat.o(215041);
      return bool;
    }
    catch (UnsupportedOperationException paramMotionEvent)
    {
      for (;;)
      {
        handleRuntimeError(paramMotionEvent);
        boolean bool = false;
      }
    }
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    AppMethodBeat.i(214607);
    try
    {
      paramBoolean = ((Boolean)getPageDownbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(214607);
      return paramBoolean;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        paramBoolean = false;
      }
    }
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    AppMethodBeat.i(214619);
    try
    {
      paramBoolean = ((Boolean)getPageUpbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(214619);
      return paramBoolean;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        paramBoolean = false;
      }
    }
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(214626);
    try
    {
      getPauseTimersMethod().invoke(new Object[0]);
      AppMethodBeat.o(214626);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214626);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214638);
    try
    {
      getPostUrlStringbyteMethod().invoke(new Object[] { paramString, paramArrayOfByte });
      AppMethodBeat.o(214638);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214638);
    }
  }
  
  public void reload()
  {
    AppMethodBeat.i(214647);
    try
    {
      getReloadMethod().invoke(new Object[0]);
      AppMethodBeat.o(214647);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214647);
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(214654);
    try
    {
      getRemoveJavascriptInterfaceStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214654);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214654);
    }
  }
  
  public void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(215007);
    try
    {
      getReplaceTranslatedStringMapStringStringMethod().invoke(new Object[] { paramMap });
      AppMethodBeat.o(215007);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      handleRuntimeError(paramMap);
      AppMethodBeat.o(215007);
    }
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    AppMethodBeat.i(214664);
    try
    {
      getRequestFocusNodeHrefMessageMethod().invoke(new Object[] { paramMessage });
      AppMethodBeat.o(214664);
      return;
    }
    catch (UnsupportedOperationException paramMessage)
    {
      handleRuntimeError(paramMessage);
      AppMethodBeat.o(214664);
    }
  }
  
  public void requestImageRef(Message paramMessage)
  {
    AppMethodBeat.i(214671);
    try
    {
      getRequestImageRefMessageMethod().invoke(new Object[] { paramMessage });
      AppMethodBeat.o(214671);
      return;
    }
    catch (UnsupportedOperationException paramMessage)
    {
      handleRuntimeError(paramMessage);
      AppMethodBeat.o(214671);
    }
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(214678);
    try
    {
      paramBundle = (WebBackForwardList)getRestoreStateBundleMethod().invoke(new Object[] { paramBundle });
      AppMethodBeat.o(214678);
      return paramBundle;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      for (;;)
      {
        handleRuntimeError(paramBundle);
        paramBundle = null;
      }
    }
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(214683);
    try
    {
      getResumeTimersMethod().invoke(new Object[0]);
      AppMethodBeat.o(214683);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214683);
    }
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(215051);
    try
    {
      bool = ((Boolean)getSavePageStringStringintMethod().invoke(new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(215051);
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      for (;;)
      {
        handleRuntimeError(paramString1);
        boolean bool = false;
      }
    }
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(214691);
    try
    {
      paramBundle = (WebBackForwardList)getSaveStateBundleMethod().invoke(new Object[] { paramBundle });
      AppMethodBeat.o(214691);
      return paramBundle;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      for (;;)
      {
        handleRuntimeError(paramBundle);
        paramBundle = null;
      }
    }
  }
  
  public void saveWebArchive(String paramString)
  {
    AppMethodBeat.i(214698);
    try
    {
      getSaveWebArchiveStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214698);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214698);
    }
  }
  
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(214709);
    try
    {
      getSaveWebArchiveStringbooleanValueCallbackStringMethod().invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      AppMethodBeat.o(214709);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214709);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(214715);
    try
    {
      getSetBackgroundColorintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214715);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214715);
    }
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(215031);
    try
    {
      getSetBottomHeightintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215031);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215031);
    }
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(214724);
    try
    {
      getSetDownloadListenerDownloadListenerMethod().invoke(new Object[] { paramDownloadListener });
      AppMethodBeat.o(214724);
      return;
    }
    catch (UnsupportedOperationException paramDownloadListener)
    {
      handleRuntimeError(paramDownloadListener);
      AppMethodBeat.o(214724);
    }
  }
  
  public void setExtendPluginClient(Object paramObject)
  {
    AppMethodBeat.i(214846);
    try
    {
      getSetExtendPluginClientObjectMethod().invoke(new Object[] { paramObject });
      AppMethodBeat.o(214846);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214846);
    }
  }
  
  public void setExtendTextAreaClient(Object paramObject)
  {
    AppMethodBeat.i(214882);
    try
    {
      getSetExtendTextAreaClientObjectMethod().invoke(new Object[] { paramObject });
      AppMethodBeat.o(214882);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214882);
    }
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(214735);
    try
    {
      getSetFindListenerandroidwebkitWebViewFindListenerMethod().invoke(new Object[] { paramFindListener });
      AppMethodBeat.o(214735);
      return;
    }
    catch (UnsupportedOperationException paramFindListener)
    {
      handleRuntimeError(paramFindListener);
      AppMethodBeat.o(214735);
    }
  }
  
  public void setHorizontalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(215069);
    try
    {
      getSetHorizontalScrollBarEnablebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215069);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215069);
    }
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(214744);
    try
    {
      getSetInitialScaleintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214744);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214744);
    }
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(214751);
    try
    {
      getSetNetworkAvailablebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214751);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214751);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(214349);
    try
    {
      getSetOnTouchListenerOnTouchListenerMethod().invoke(new Object[] { paramOnTouchListener });
      AppMethodBeat.o(214349);
      return;
    }
    catch (UnsupportedOperationException paramOnTouchListener)
    {
      handleRuntimeError(paramOnTouchListener);
      AppMethodBeat.o(214349);
    }
  }
  
  public void setPluginTextureScale(String paramString, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(214857);
    try
    {
      getSetPluginTextureScaleStringintfloatfloatMethod().invoke(new Object[] { paramString, Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
      AppMethodBeat.o(214857);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214857);
    }
  }
  
  public void setProxyWebViewClientExtension(Object paramObject)
  {
    AppMethodBeat.i(214899);
    try
    {
      getSetProxyWebViewClientExtensionObjectMethod().invoke(new Object[] { paramObject });
      AppMethodBeat.o(214899);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214899);
    }
  }
  
  public void setTranslateMode(boolean paramBoolean)
  {
    AppMethodBeat.i(214999);
    try
    {
      getSetTranslateModebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214999);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214999);
    }
  }
  
  public void setVerticalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(215059);
    try
    {
      getSetVerticalScrollBarEnablebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215059);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215059);
    }
  }
  
  public void setWebChromeClient(Object paramObject)
  {
    AppMethodBeat.i(214762);
    try
    {
      getSetWebChromeClientObjectMethod().invoke(new Object[] { paramObject });
      AppMethodBeat.o(214762);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214762);
    }
  }
  
  public void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214770);
    try
    {
      getSetWebContentsDebuggingEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214770);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214770);
    }
  }
  
  public void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215078);
    try
    {
      getSetWebContentsSizeintintMethod().invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(215078);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215078);
    }
  }
  
  public void setWebViewClient(Object paramObject)
  {
    AppMethodBeat.i(214782);
    try
    {
      getSetWebViewClientObjectMethod().invoke(new Object[] { paramObject });
      AppMethodBeat.o(214782);
      return;
    }
    catch (UnsupportedOperationException paramObject)
    {
      handleRuntimeError(paramObject);
      AppMethodBeat.o(214782);
    }
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(214990);
    try
    {
      getSmoothScrollintintlongMethod().invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(214990);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214990);
    }
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(214794);
    try
    {
      getStopLoadingMethod().invoke(new Object[0]);
      AppMethodBeat.o(214794);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214794);
    }
  }
  
  public void takePluginScreenshot(String paramString, int paramInt)
  {
    AppMethodBeat.i(214867);
    try
    {
      getTakePluginScreenshotStringintMethod().invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(214867);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214867);
    }
  }
  
  public int view_computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(214916);
    try
    {
      i = ((Integer)getView_computeHorizontalScrollOffsetMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214916);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public int view_computeHorizontalScrollRange()
  {
    AppMethodBeat.i(214927);
    try
    {
      i = ((Integer)getView_computeHorizontalScrollRangeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214927);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public int view_computeVerticalScrollExtent()
  {
    AppMethodBeat.i(214939);
    try
    {
      i = ((Integer)getView_computeVerticalScrollExtentMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214939);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public int view_computeVerticalScrollOffset()
  {
    AppMethodBeat.i(214948);
    try
    {
      i = ((Integer)getView_computeVerticalScrollOffsetMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214948);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public int view_computeVerticalScrollRange()
  {
    AppMethodBeat.i(214959);
    try
    {
      i = ((Integer)getView_computeVerticalScrollRangeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214959);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        int i = 0;
      }
    }
  }
  
  public void view_scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214978);
    try
    {
      getView_scrollByintintMethod().invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(214978);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214978);
    }
  }
  
  public void view_scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214966);
    try
    {
      getView_scrollTointintMethod().invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(214966);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214966);
    }
  }
  
  public void zoomBy(float paramFloat)
  {
    AppMethodBeat.i(214808);
    try
    {
      getZoomByfloatMethod().invoke(new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(214808);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214808);
    }
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(214816);
    try
    {
      bool = ((Boolean)getZoomInMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214816);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(214826);
    try
    {
      bool = ((Boolean)getZoomOutMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214826);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      for (;;)
      {
        handleRuntimeError(localUnsupportedOperationException);
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebViewInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */