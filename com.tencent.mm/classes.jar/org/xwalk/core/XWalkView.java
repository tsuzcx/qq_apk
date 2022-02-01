package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.util.l;
import java.util.ArrayList;
import java.util.Map;

public class XWalkView
  extends AbsoluteLayout
  implements XWebExtendInterface
{
  private static final String ANIMATABLE = "animatable";
  public static final int RELOAD_IGNORE_CACHE = 1;
  public static final int RELOAD_NORMAL = 0;
  private static final String TAG = "XWalkView";
  private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
  private LazyReflectMethod addJavascriptInterfaceObjectStringMethod;
  private LazyReflectMethod adjustSelectPositionlongStringintintMethod;
  private Object bridge;
  private LazyReflectMethod canZoomInMethod;
  private LazyReflectMethod canZoomOutMethod;
  private LazyReflectMethod clearCacheForSingleFileStringMethod;
  private LazyReflectMethod clearCachebooleanMethod;
  private LazyReflectMethod clearClientCertPreferencesRunnableMethod;
  private LazyReflectMethod clearFormDataMethod;
  private LazyReflectMethod clearMatchesMethod;
  private LazyReflectMethod clearSslPreferencesMethod;
  private LazyReflectMethod computeHorizontalScrollOffsetMethod;
  private LazyReflectMethod computeHorizontalScrollRangeMethod;
  private LazyReflectMethod computeVerticalScrollExtentMethod;
  private LazyReflectMethod computeVerticalScrollOffsetMethod;
  private LazyReflectMethod computeVerticalScrollRangeMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod evaluateJavascriptStringValueCallbackMethod;
  private LazyReflectMethod findAllAsyncStringMethod;
  private LazyReflectMethod findNextbooleanMethod;
  private LazyReflectMethod getAPIVersionMethod;
  private LazyReflectMethod getCertificateMethod;
  private LazyReflectMethod getCompositingSurfaceTypeMethod;
  private LazyReflectMethod getContentHeightMethod;
  private LazyReflectMethod getExtensionManagerMethod;
  private LazyReflectMethod getFaviconMethod;
  private LazyReflectMethod getHitTestResultMethod;
  private LazyReflectMethod getImageBitmapToFileMethod;
  private LazyReflectMethod getNavigationHistoryMethod;
  private LazyReflectMethod getOriginalUrlMethod;
  private LazyReflectMethod getRefererUrlMethod;
  private LazyReflectMethod getRemoteDebuggingUrlMethod;
  private LazyReflectMethod getScalenMethod;
  private LazyReflectMethod getSettingsMethod;
  private LazyReflectMethod getTitleMethod;
  private LazyReflectMethod getTranslateSampleStringintMethod;
  private LazyReflectMethod getUrlMethod;
  private LazyReflectMethod getUserAgentStringMethod;
  private LazyReflectMethod getXWalkContentViewMethod;
  private LazyReflectMethod getXWalkVersionMethod;
  private LazyReflectMethod hasEnteredFullscreenMethod;
  private LazyReflectMethod invokeExtensionMethod;
  boolean isInitedBottomHeightMethod;
  private LazyReflectMethod leaveFullscreenMethod;
  private LazyReflectMethod loadAppFromManifestStringStringMethod;
  private LazyReflectMethod loadDataStringStringStringMethod;
  private LazyReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
  private LazyReflectMethod loadStringStringMapMethod;
  private LazyReflectMethod loadStringStringMethod;
  private LazyReflectMethod loadUrlStringMapMethod;
  private LazyReflectMethod loadUrlStringMethod;
  private String mAnimatable;
  private OverScrolledListener mOverScrolledListener;
  private ScrollChangedListener mScrollChangedListener;
  private LazyReflectMethod onActivityResultintintIntentMethod;
  private LazyReflectMethod onCreateInputConnectionEditorInfoMethod;
  private LazyReflectMethod onDestroyMethod;
  private LazyReflectMethod onHideMethod;
  private LazyReflectMethod onNewIntentIntentMethod;
  private LazyReflectMethod onPauseMethod;
  private LazyReflectMethod onResumeMethod;
  private LazyReflectMethod onShowMethod;
  private LazyReflectMethod onTouchEventMotionEventMethod;
  private LazyReflectMethod pauseTimersMethod;
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod preInitViewSizeMethod;
  private LazyReflectMethod reloadintMethod;
  private LazyReflectMethod removeJavascriptInterfaceStringMethod;
  private LazyReflectMethod replaceTranslatedStringMethod;
  private LazyReflectMethod restoreStateBundleMethod;
  private LazyReflectMethod resumeTimersMethod;
  private LazyReflectMethod savePageMethod;
  private LazyReflectMethod saveStateBundleMethod;
  private LazyReflectMethod scrollByintintMethod;
  private LazyReflectMethod scrollTointintMethod;
  private LazyReflectMethod setAcceptLanguagesStringMethod;
  private LazyReflectMethod setBackgroundColorintMethod;
  private LazyReflectMethod setBottomHeightMethod;
  private LazyReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod;
  private LazyReflectMethod setExtendInputClientXWalkExtendInputClientInternalMethod;
  private LazyReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod;
  private LazyReflectMethod setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod;
  private LazyReflectMethod setFindListenerXWalkFindListenerInternalMethod;
  private LazyReflectMethod setHorizontalScrollBarEnablebooleanMethod;
  private LazyReflectMethod setInitialScaleintMethod;
  private LazyReflectMethod setNetworkAvailablebooleanMethod;
  private LazyReflectMethod setOnTouchListenerOnTouchListenerMethod;
  private LazyReflectMethod setOriginAccessWhitelistStringStringArrayMethod;
  private LazyReflectMethod setProxyWebViewClientExtensionInternalMethod;
  private LazyReflectMethod setResourceClientXWalkResourceClientInternalMethod;
  private LazyReflectMethod setSurfaceViewVisibilityintMethod;
  private LazyReflectMethod setTranslateModebooleanMethod;
  private LazyReflectMethod setUIClientXWalkUIClientInternalMethod;
  private LazyReflectMethod setUserAgentStringStringMethod;
  private LazyReflectMethod setVerticalScrollBarEnablebooleanMethod;
  private LazyReflectMethod setWebContentsSizeintintMethod;
  private LazyReflectMethod setXWalkViewInternalVisibilityintMethod;
  private LazyReflectMethod setZOrderOnTopbooleanMethod;
  private LazyReflectMethod smoothScrollintintMethod;
  private LazyReflectMethod startActivityForResultIntentintBundleMethod;
  private LazyReflectMethod stopLoadingMethod;
  private LazyReflectMethod zoomByfloatMethod;
  private LazyReflectMethod zoomInMethod;
  private LazyReflectMethod zoomOutMethod;
  
  static
  {
    AppMethodBeat.i(155157);
    if (!XWalkView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(155157);
      return;
    }
  }
  
  public XWalkView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(155043);
    this.preInitViewSizeMethod = new LazyReflectMethod(null, "preInitViewSize", new Class[0]);
    this.getXWalkContentViewMethod = new LazyReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new LazyReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new LazyReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new LazyReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new LazyReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new LazyReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new LazyReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new LazyReflectMethod(null, "savePage", new Class[0]);
    this.isInitedBottomHeightMethod = false;
    this.setBottomHeightMethod = new LazyReflectMethod(null, "setBottomHeight", new Class[0]);
    this.getHitTestResultMethod = new LazyReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new LazyReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new LazyReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new LazyReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new LazyReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new LazyReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new LazyReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new LazyReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new LazyReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new LazyReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new LazyReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new LazyReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new LazyReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new LazyReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new LazyReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new LazyReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new LazyReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new LazyReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new LazyReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new LazyReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new LazyReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new LazyReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod(null, "setExtendTextAreaClient", new Class[0]);
    this.setExtendInputClientXWalkExtendInputClientInternalMethod = new LazyReflectMethod(null, "setExtendInputClient", new Class[0]);
    this.setWebContentsSizeintintMethod = new LazyReflectMethod(null, "setWebContentsSize", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new LazyReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.getSettingsMethod = new LazyReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new LazyReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new LazyReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new LazyReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new LazyReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new LazyReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new LazyReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new LazyReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new LazyReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new LazyReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new LazyReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new LazyReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new LazyReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new LazyReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new LazyReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new LazyReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new LazyReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new LazyReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new LazyReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new LazyReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new LazyReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new LazyReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new LazyReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new LazyReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new LazyReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new LazyReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new LazyReflectMethod(null, "clearMatches", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new LazyReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.setTranslateModebooleanMethod = new LazyReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new LazyReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new LazyReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new LazyReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new LazyReflectMethod(null, "invokeExtension", new Class[0]);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(155043);
  }
  
  @Deprecated
  public XWalkView(Context paramContext, Activity paramActivity)
  {
    super(paramContext, null);
    AppMethodBeat.i(155047);
    this.preInitViewSizeMethod = new LazyReflectMethod(null, "preInitViewSize", new Class[0]);
    this.getXWalkContentViewMethod = new LazyReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new LazyReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new LazyReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new LazyReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new LazyReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new LazyReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new LazyReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new LazyReflectMethod(null, "savePage", new Class[0]);
    this.isInitedBottomHeightMethod = false;
    this.setBottomHeightMethod = new LazyReflectMethod(null, "setBottomHeight", new Class[0]);
    this.getHitTestResultMethod = new LazyReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new LazyReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new LazyReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new LazyReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new LazyReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new LazyReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new LazyReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new LazyReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new LazyReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new LazyReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new LazyReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new LazyReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new LazyReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new LazyReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new LazyReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new LazyReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new LazyReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new LazyReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new LazyReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new LazyReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new LazyReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new LazyReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod(null, "setExtendTextAreaClient", new Class[0]);
    this.setExtendInputClientXWalkExtendInputClientInternalMethod = new LazyReflectMethod(null, "setExtendInputClient", new Class[0]);
    this.setWebContentsSizeintintMethod = new LazyReflectMethod(null, "setWebContentsSize", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new LazyReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.getSettingsMethod = new LazyReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new LazyReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new LazyReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new LazyReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new LazyReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new LazyReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new LazyReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new LazyReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new LazyReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new LazyReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new LazyReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new LazyReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new LazyReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new LazyReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new LazyReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new LazyReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new LazyReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new LazyReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new LazyReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new LazyReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new LazyReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new LazyReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new LazyReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new LazyReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new LazyReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new LazyReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new LazyReflectMethod(null, "clearMatches", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new LazyReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.setTranslateModebooleanMethod = new LazyReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new LazyReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new LazyReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new LazyReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new LazyReflectMethod(null, "invokeExtension", new Class[0]);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(Activity.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramActivity);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(155047);
  }
  
  public XWalkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(155045);
    this.preInitViewSizeMethod = new LazyReflectMethod(null, "preInitViewSize", new Class[0]);
    this.getXWalkContentViewMethod = new LazyReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new LazyReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new LazyReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new LazyReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new LazyReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new LazyReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new LazyReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new LazyReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new LazyReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new LazyReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new LazyReflectMethod(null, "savePage", new Class[0]);
    this.isInitedBottomHeightMethod = false;
    this.setBottomHeightMethod = new LazyReflectMethod(null, "setBottomHeight", new Class[0]);
    this.getHitTestResultMethod = new LazyReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new LazyReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new LazyReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new LazyReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new LazyReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new LazyReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new LazyReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new LazyReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new LazyReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new LazyReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new LazyReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new LazyReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new LazyReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new LazyReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new LazyReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new LazyReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new LazyReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new LazyReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new LazyReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new LazyReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new LazyReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new LazyReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new LazyReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new LazyReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new LazyReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new LazyReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new LazyReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new LazyReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod = new LazyReflectMethod(null, "setExtendTextAreaClient", new Class[0]);
    this.setExtendInputClientXWalkExtendInputClientInternalMethod = new LazyReflectMethod(null, "setExtendInputClient", new Class[0]);
    this.setWebContentsSizeintintMethod = new LazyReflectMethod(null, "setWebContentsSize", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new LazyReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new LazyReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new LazyReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new LazyReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.getSettingsMethod = new LazyReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new LazyReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new LazyReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new LazyReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new LazyReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new LazyReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new LazyReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new LazyReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new LazyReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new LazyReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new LazyReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new LazyReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new LazyReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new LazyReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new LazyReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new LazyReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new LazyReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new LazyReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new LazyReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new LazyReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new LazyReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new LazyReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new LazyReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new LazyReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new LazyReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new LazyReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new LazyReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new LazyReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new LazyReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new LazyReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new LazyReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new LazyReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new LazyReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new LazyReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new LazyReflectMethod(null, "clearMatches", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new LazyReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.setTranslateModebooleanMethod = new LazyReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new LazyReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new LazyReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new LazyReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new LazyReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new LazyReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new LazyReflectMethod(null, "invokeExtension", new Class[0]);
    if (isInEditMode())
    {
      AppMethodBeat.o(155045);
      return;
    }
    if (paramAttributeSet != null) {
      this.mAnimatable = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "animatable");
    }
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(AttributeSet.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramAttributeSet);
    this.postWrapperMethod = new LazyReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(155045);
  }
  
  private void onFocusChangedDelegate(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(155127);
    onFocusChanged(paramBoolean, paramInt, paramRect);
    AppMethodBeat.o(155127);
  }
  
  private void onOverscrollRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(155129);
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramBoolean);
    }
    AppMethodBeat.o(155129);
  }
  
  private boolean onTouchEventDelegate(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155124);
    boolean bool = onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(155124);
    return bool;
  }
  
  private boolean performLongClickDelegate()
  {
    AppMethodBeat.i(155123);
    boolean bool = performLongClick();
    AppMethodBeat.o(155123);
    return bool;
  }
  
  private void reflectionInit()
  {
    AppMethodBeat.i(155156);
    if (XWalkCoreWrapper.getInstance() == null)
    {
      XWalkReflectionInitHandler.reserveReflectObject(this);
      AppMethodBeat.o(155156);
      return;
    }
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
      }
      label135:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label135;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(155156);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), (Class[])localObject1);
    for (;;)
    {
      try
      {
        this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
        if (this.postWrapperMethod != null) {
          this.postWrapperMethod.invoke(new Object[0]);
        }
        this.loadStringStringMethod.init(this.bridge, null, "loadSuper", new Class[] { String.class, String.class });
        this.loadStringStringMapMethod.init(this.bridge, null, "loadSuper", new Class[] { String.class, String.class, Map.class });
        this.loadDataStringStringStringMethod.init(this.bridge, null, "loadDataSuper", new Class[] { String.class, String.class, String.class });
        this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, null, "loadDataWithBaseURLSuper", new Class[] { String.class, String.class, String.class, String.class, String.class });
        this.loadUrlStringMethod.init(this.bridge, null, "loadUrlSuper", new Class[] { String.class });
        this.loadUrlStringMapMethod.init(this.bridge, null, "loadUrlSuper", new Class[] { String.class, Map.class });
        this.loadAppFromManifestStringStringMethod.init(this.bridge, null, "loadAppFromManifestSuper", new Class[] { String.class, String.class });
        this.reloadintMethod.init(this.bridge, null, "reloadSuper", new Class[] { Integer.TYPE });
        this.stopLoadingMethod.init(this.bridge, null, "stopLoadingSuper", new Class[0]);
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.savePageMethod.init(this.bridge, null, "savePageSuper", new Class[] { String.class, String.class, Integer.TYPE });
        this.getHitTestResultMethod.init(this.bridge, null, "getHitTestResultSuper", new Class[0]);
        this.getContentHeightMethod.init(this.bridge, null, "getContentHeightSuper", new Class[0]);
        this.getTitleMethod.init(this.bridge, null, "getTitleSuper", new Class[0]);
        this.getOriginalUrlMethod.init(this.bridge, null, "getOriginalUrlSuper", new Class[0]);
        this.getNavigationHistoryMethod.init(this.bridge, null, "getNavigationHistorySuper", new Class[0]);
        this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", new Class[] { Object.class, String.class });
        this.removeJavascriptInterfaceStringMethod.init(this.bridge, null, "removeJavascriptInterfaceSuper", new Class[] { String.class });
        this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", new Class[] { String.class, ValueCallback.class });
        this.clearCachebooleanMethod.init(this.bridge, null, "clearCacheSuper", new Class[] { Boolean.TYPE });
        this.clearCacheForSingleFileStringMethod.init(this.bridge, null, "clearCacheForSingleFileSuper", new Class[] { String.class });
        this.hasEnteredFullscreenMethod.init(this.bridge, null, "hasEnteredFullscreenSuper", new Class[0]);
        this.leaveFullscreenMethod.init(this.bridge, null, "leaveFullscreenSuper", new Class[0]);
        this.pauseTimersMethod.init(this.bridge, null, "pauseTimersSuper", new Class[0]);
        this.resumeTimersMethod.init(this.bridge, null, "resumeTimersSuper", new Class[0]);
        this.onHideMethod.init(this.bridge, null, "onHideSuper", new Class[0]);
        this.onShowMethod.init(this.bridge, null, "onShowSuper", new Class[0]);
        if (XWalkCoreWrapper.getInstance().hasFeature(1))
        {
          this.onPauseMethod.init(this.bridge, null, "onPauseSuper", new Class[0]);
          this.onResumeMethod.init(this.bridge, null, "onResumeSuper", new Class[0]);
        }
        this.onDestroyMethod.init(this.bridge, null, "onDestroySuper", new Class[0]);
        this.startActivityForResultIntentintBundleMethod.init(this.bridge, null, "startActivityForResultSuper", new Class[] { Intent.class, Integer.TYPE, Bundle.class });
        this.onActivityResultintintIntentMethod.init(this.bridge, null, "onActivityResultSuper", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class });
        this.onNewIntentIntentMethod.init(this.bridge, null, "onNewIntentSuper", new Class[] { Intent.class });
        this.saveStateBundleMethod.init(this.bridge, null, "saveStateSuper", new Class[] { Bundle.class });
        this.restoreStateBundleMethod.init(this.bridge, null, "restoreStateSuper", new Class[] { Bundle.class });
        this.getAPIVersionMethod.init(this.bridge, null, "getAPIVersionSuper", new Class[0]);
        this.getXWalkVersionMethod.init(this.bridge, null, "getXWalkVersionSuper", new Class[0]);
        this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, null, "setUIClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkUIClientBridge") });
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.init(this.bridge, null, "setExtendPluginClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendPluginClientBridge") });
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.init(this.bridge, null, "setExtendTextAreaClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendTextAreaClientBridge") });
        this.setExtendInputClientXWalkExtendInputClientInternalMethod.init(this.bridge, null, "setExtendInputClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendInputClientBridge") });
        this.setWebContentsSizeintintMethod.init(this.bridge, null, "setWebContentsSizeSuper", new Class[] { Integer.TYPE, Integer.TYPE });
        this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkResourceClientBridge") });
        this.setProxyWebViewClientExtensionInternalMethod.init(this.bridge, null, "setProxyWebViewClientExtensionSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge") });
        this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", new Class[] { Integer.TYPE });
        this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", new Class[] { String.class, [Ljava.lang.String.class });
        this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[] { String.class });
        this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
        this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[] { String.class });
        this.getSettingsMethod.init(this.bridge, null, "getSettingsSuper", new Class[0]);
        this.setNetworkAvailablebooleanMethod.init(this.bridge, null, "setNetworkAvailableSuper", new Class[] { Boolean.TYPE });
        this.getRemoteDebuggingUrlMethod.init(this.bridge, null, "getRemoteDebuggingUrlSuper", new Class[0]);
        this.getScalenMethod.init(this.bridge, null, "getScaleSuper", new Class[0]);
        this.zoomInMethod.init(this.bridge, null, "zoomInSuper", new Class[0]);
        this.zoomOutMethod.init(this.bridge, null, "zoomOutSuper", new Class[0]);
        this.zoomByfloatMethod.init(this.bridge, null, "zoomBySuper", new Class[] { Float.TYPE });
        this.canZoomInMethod.init(this.bridge, null, "canZoomInSuper", new Class[0]);
        this.canZoomOutMethod.init(this.bridge, null, "canZoomOutSuper", new Class[0]);
        this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, null, "onCreateInputConnectionSuper", new Class[] { EditorInfo.class });
        this.setInitialScaleintMethod.init(this.bridge, null, "setInitialScaleSuper", new Class[] { Integer.TYPE });
        this.getFaviconMethod.init(this.bridge, null, "getFaviconSuper", new Class[0]);
        this.setZOrderOnTopbooleanMethod.init(this.bridge, null, "setZOrderOnTopSuper", new Class[] { Boolean.TYPE });
        this.clearFormDataMethod.init(this.bridge, null, "clearFormDataSuper", new Class[0]);
        this.setSurfaceViewVisibilityintMethod.init(this.bridge, null, "setSurfaceViewVisibilitySuper", new Class[] { Integer.TYPE });
        this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, null, "setXWalkViewInternalVisibilitySuper", new Class[] { Integer.TYPE });
        this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, null, "setDownloadListenerSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge") });
        this.onTouchEventMotionEventMethod.init(this.bridge, null, "onTouchEventSuper", new Class[] { MotionEvent.class });
        this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, null, "setOnTouchListenerSuper", new Class[] { View.OnTouchListener.class });
        this.smoothScrollintintMethod.init(this.bridge, null, "smoothScrollSuper", new Class[] { Integer.TYPE, Integer.TYPE, Long.TYPE });
        this.scrollTointintMethod.init(this.bridge, null, "scrollToSuper", new Class[] { Integer.TYPE, Integer.TYPE });
        this.scrollByintintMethod.init(this.bridge, null, "scrollBySuper", new Class[] { Integer.TYPE, Integer.TYPE });
        this.computeHorizontalScrollRangeMethod.init(this.bridge, null, "computeHorizontalScrollRangeSuper", new Class[0]);
        this.computeHorizontalScrollOffsetMethod.init(this.bridge, null, "computeHorizontalScrollOffsetSuper", new Class[0]);
        this.computeVerticalScrollRangeMethod.init(this.bridge, null, "computeVerticalScrollRangeSuper", new Class[0]);
        this.computeVerticalScrollOffsetMethod.init(this.bridge, null, "computeVerticalScrollOffsetSuper", new Class[0]);
        this.computeVerticalScrollExtentMethod.init(this.bridge, null, "computeVerticalScrollExtentSuper", new Class[0]);
        this.getExtensionManagerMethod.init(this.bridge, null, "getExtensionManagerSuper", new Class[0]);
        this.clearSslPreferencesMethod.init(this.bridge, null, "clearSslPreferencesSuper", new Class[0]);
        this.clearClientCertPreferencesRunnableMethod.init(this.bridge, null, "clearClientCertPreferencesSuper", new Class[] { Runnable.class });
        this.getCertificateMethod.init(this.bridge, null, "getCertificateSuper", new Class[0]);
        this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, null, "setFindListenerSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkFindListenerBridge") });
        this.findAllAsyncStringMethod.init(this.bridge, null, "findAllAsyncSuper", new Class[] { String.class });
        this.findNextbooleanMethod.init(this.bridge, null, "findNextSuper", new Class[] { Boolean.TYPE });
        this.clearMatchesMethod.init(this.bridge, null, "clearMatchesSuper", new Class[0]);
        this.getCompositingSurfaceTypeMethod.init(this.bridge, null, "getCompositingSurfaceTypeSuper", new Class[0]);
        this.getXWalkContentViewMethod.init(this.bridge, null, "getXWalkContentViewSuper", new Class[0]);
        this.adjustSelectPositionlongStringintintMethod.init(this.bridge, null, "adjustSelectPositionSuper", new Class[] { Long.TYPE, String.class, Integer.TYPE, Integer.TYPE });
        this.getRefererUrlMethod.init(this.bridge, null, "getRefererUrlSuper", new Class[0]);
        this.setVerticalScrollBarEnablebooleanMethod.init(this.bridge, null, "setVerticalScrollBarEnableSuper", new Class[] { Boolean.TYPE });
        this.setHorizontalScrollBarEnablebooleanMethod.init(this.bridge, null, "setHorizontalScrollBarEnableSuper", new Class[] { Boolean.TYPE });
        this.replaceTranslatedStringMethod.init(this.bridge, null, "replaceTranslatedStringSuper", new Class[] { Map.class });
        this.setTranslateModebooleanMethod.init(this.bridge, null, "setTranslateModeSuper", new Class[] { Boolean.TYPE });
        this.getTranslateSampleStringintMethod.init(this.bridge, null, "getTranslateSampleStringSuper", new Class[] { Integer.TYPE });
        this.getImageBitmapToFileMethod.init(this.bridge, null, "getImageBitmapToFileSuper", new Class[] { String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkGetImageBitmapToFileFinishedCallbackBridge") });
        if (XWalkCoreWrapper.getInstance().hasFeature(9))
        {
          this.invokeExtensionMethod.init(this.bridge, null, "invokeExtension", new Class[] { Integer.TYPE, Object.class });
          this.preInitViewSizeMethod.init(this.bridge, null, "preInitViewSizeSuper", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE });
          AppMethodBeat.o(155156);
          return;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        Log.e("XWalkView", "reflectionInit, error:".concat(String.valueOf(localUnsupportedOperationException)));
        AppMethodBeat.o(155156);
        return;
      }
      this.invokeExtensionMethod = null;
    }
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(155072);
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      AppMethodBeat.o(155072);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.addJavascriptInterfaceObjectStringMethod.setArguments(new Object[] { paramObject, paramString });
        XWalkReflectionInitHandler.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
        AppMethodBeat.o(155072);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155072);
    }
  }
  
  public void adjustSelectPosition(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155151);
    try
    {
      this.adjustSelectPositionlongStringintintMethod.invoke(new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(155151);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155151);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155151);
    }
  }
  
  public boolean canZoomIn()
  {
    AppMethodBeat.i(155112);
    try
    {
      boolean bool = ((Boolean)this.canZoomInMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155112);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155112);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155112);
    }
    return false;
  }
  
  public boolean canZoomOut()
  {
    AppMethodBeat.i(155113);
    try
    {
      boolean bool = ((Boolean)this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155113);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155113);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155113);
    }
    return false;
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(155075);
    try
    {
      this.clearCachebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155075);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155075);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155075);
    }
  }
  
  public void clearCacheForSingleFile(String paramString)
  {
    AppMethodBeat.i(155076);
    try
    {
      this.clearCacheForSingleFileStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155076);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155076);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155076);
    }
  }
  
  public void clearClientCertPreferences(Runnable paramRunnable)
  {
    AppMethodBeat.i(155141);
    try
    {
      this.clearClientCertPreferencesRunnableMethod.invoke(new Object[] { paramRunnable });
      AppMethodBeat.o(155141);
      return;
    }
    catch (UnsupportedOperationException paramRunnable)
    {
      if (this.coreWrapper == null)
      {
        paramRunnable = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155141);
        throw paramRunnable;
      }
      XWalkCoreWrapper.handleRuntimeError(paramRunnable);
      AppMethodBeat.o(155141);
    }
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(155118);
    try
    {
      this.clearFormDataMethod.invoke(new Object[0]);
      AppMethodBeat.o(155118);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155118);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155118);
    }
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(155146);
    try
    {
      this.clearMatchesMethod.invoke(new Object[0]);
      AppMethodBeat.o(155146);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155146);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155146);
    }
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(155140);
    try
    {
      this.clearSslPreferencesMethod.invoke(new Object[0]);
      AppMethodBeat.o(155140);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155140);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155140);
    }
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(155135);
    try
    {
      int i = ((Integer)this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155135);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155135);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155135);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(155134);
    try
    {
      int i = ((Integer)this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155134);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155134);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155134);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(155138);
    try
    {
      int i = ((Integer)this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155138);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155138);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155138);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(155137);
    try
    {
      int i = ((Integer)this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155137);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155137);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155137);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(155136);
    try
    {
      int i = ((Integer)this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155136);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155136);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155136);
    }
    return 0;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(155074);
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      AppMethodBeat.o(155074);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155074);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155074);
    }
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(155144);
    try
    {
      this.findAllAsyncStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155144);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155144);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155144);
    }
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(155145);
    try
    {
      this.findNextbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155145);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155145);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155145);
    }
  }
  
  public String getAPIVersion()
  {
    AppMethodBeat.i(155091);
    try
    {
      String str = (String)this.getAPIVersionMethod.invoke(new Object[0]);
      AppMethodBeat.o(155091);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155091);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155091);
    }
    return null;
  }
  
  public Object getBridge()
  {
    return this.bridge;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(155142);
    try
    {
      SslCertificate localSslCertificate = (SslCertificate)this.getCertificateMethod.invoke(new Object[0]);
      AppMethodBeat.o(155142);
      return localSslCertificate;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155142);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155142);
    }
    return null;
  }
  
  public String getCompositingSurfaceType()
  {
    AppMethodBeat.i(155147);
    try
    {
      String str = (String)this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
      AppMethodBeat.o(155147);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155147);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155147);
    }
    return null;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(155068);
    try
    {
      int i = ((Integer)this.getContentHeightMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(155068);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155068);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155068);
    }
    return 0;
  }
  
  public XWalkExternalExtensionManager getExtensionManager()
  {
    AppMethodBeat.i(155139);
    try
    {
      XWalkExternalExtensionManager localXWalkExternalExtensionManager = (XWalkExternalExtensionManager)this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
      AppMethodBeat.o(155139);
      return localXWalkExternalExtensionManager;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155139);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155139);
    }
    return null;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(155116);
    try
    {
      Bitmap localBitmap = (Bitmap)this.getFaviconMethod.invoke(new Object[0]);
      AppMethodBeat.o(155116);
      return localBitmap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155116);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155116);
    }
    return null;
  }
  
  public XWalkHitTestResult getHitTestResult()
  {
    AppMethodBeat.i(155067);
    try
    {
      XWalkHitTestResult localXWalkHitTestResult = (XWalkHitTestResult)this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
      AppMethodBeat.o(155067);
      return localXWalkHitTestResult;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155067);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155067);
    }
    return null;
  }
  
  /* Error */
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, XWalkGetImageBitmapToFileFinishedCallback paramXWalkGetImageBitmapToFileFinishedCallback)
  {
    // Byte code:
    //   0: ldc_w 1057
    //   3: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 556	org/xwalk/core/XWalkView:getImageBitmapToFileMethod	Lorg/xwalk/core/LazyReflectMethod;
    //   10: iconst_4
    //   11: anewarray 691	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: aload_1
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_2
    //   21: aastore
    //   22: dup
    //   23: iconst_2
    //   24: aload_3
    //   25: aastore
    //   26: dup
    //   27: iconst_3
    //   28: aload 4
    //   30: invokevirtual 1061	org/xwalk/core/XWalkGetImageBitmapToFileFinishedCallback:getBridge	()Ljava/lang/Object;
    //   33: aastore
    //   34: invokevirtual 711	org/xwalk/core/LazyReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   37: astore_1
    //   38: aload_1
    //   39: instanceof 763
    //   42: ifeq +52 -> 94
    //   45: aload_1
    //   46: checkcast 763	java/lang/Boolean
    //   49: invokevirtual 1005	java/lang/Boolean:booleanValue	()Z
    //   52: istore 5
    //   54: ldc_w 1057
    //   57: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iload 5
    //   62: ireturn
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 664	org/xwalk/core/XWalkView:coreWrapper	Lorg/xwalk/core/XWalkCoreWrapper;
    //   68: ifnonnull +22 -> 90
    //   71: new 996	java/lang/RuntimeException
    //   74: dup
    //   75: ldc_w 998
    //   78: invokespecial 1001	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   81: astore_1
    //   82: ldc_w 1057
    //   85: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    //   90: aload_1
    //   91: invokestatic 986	org/xwalk/core/XWalkCoreWrapper:handleRuntimeError	(Ljava/lang/Throwable;)V
    //   94: ldc_w 1057
    //   97: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: ldc 26
    //   105: ldc_w 1063
    //   108: aload_1
    //   109: invokestatic 962	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   112: invokevirtual 966	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   115: invokestatic 972	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: goto -24 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	XWalkView
    //   0	121	1	paramString1	String
    //   0	121	2	paramString2	String
    //   0	121	3	paramString3	String
    //   0	121	4	paramXWalkGetImageBitmapToFileFinishedCallback	XWalkGetImageBitmapToFileFinishedCallback
    //   52	9	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	54	63	java/lang/UnsupportedOperationException
    //   6	54	102	finally
  }
  
  public XWalkNavigationHistory getNavigationHistory()
  {
    AppMethodBeat.i(155071);
    try
    {
      XWalkNavigationHistory localXWalkNavigationHistory = (XWalkNavigationHistory)this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
      AppMethodBeat.o(155071);
      return localXWalkNavigationHistory;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155071);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155071);
    }
    return null;
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(155070);
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(155070);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155070);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155070);
    }
    return null;
  }
  
  public String getRefererUrl()
  {
    AppMethodBeat.i(155063);
    try
    {
      String str = (String)this.getRefererUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(155063);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155063);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155063);
    }
    return null;
  }
  
  public Uri getRemoteDebuggingUrl()
  {
    AppMethodBeat.i(155107);
    try
    {
      Uri localUri = (Uri)this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(155107);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155107);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155107);
    }
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(155109);
    try
    {
      float f = ((Float)this.getScalenMethod.invoke(new Object[0])).floatValue();
      AppMethodBeat.o(155109);
      return f;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155109);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155109);
    }
    return 1.0F;
  }
  
  public XWalkSettings getSettings()
  {
    AppMethodBeat.i(155105);
    try
    {
      XWalkSettings localXWalkSettings = (XWalkSettings)this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
      AppMethodBeat.o(155105);
      return localXWalkSettings;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155105);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155105);
    }
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(155069);
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      AppMethodBeat.o(155069);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155069);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155069);
    }
    return null;
  }
  
  public void getTranslateSampleString(int paramInt)
  {
    AppMethodBeat.i(155149);
    try
    {
      this.getTranslateSampleStringintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      l.qf(938, 103);
      AppMethodBeat.o(155149);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155149);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155149);
    }
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(155064);
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(155064);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155064);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155064);
    }
    return null;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(155102);
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      AppMethodBeat.o(155102);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155102);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155102);
    }
    return null;
  }
  
  public ViewGroup getXWalkContentView()
  {
    AppMethodBeat.i(155050);
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.getXWalkContentViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(155050);
      return localViewGroup;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155050);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155050);
    }
    return null;
  }
  
  public String getXWalkVersion()
  {
    AppMethodBeat.i(155092);
    try
    {
      String str = (String)this.getXWalkVersionMethod.invoke(new Object[0]);
      AppMethodBeat.o(155092);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155092);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155092);
    }
    return null;
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(155077);
    try
    {
      boolean bool = ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155077);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155077);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155077);
    }
    return false;
  }
  
  /* Error */
  public Object invokeExtension(int paramInt, Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 1098
    //   3: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 560	org/xwalk/core/XWalkView:invokeExtensionMethod	Lorg/xwalk/core/LazyReflectMethod;
    //   10: ifnonnull +19 -> 29
    //   13: ldc 26
    //   15: ldc_w 1100
    //   18: invokestatic 972	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1098
    //   24: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: aload_0
    //   30: getfield 560	org/xwalk/core/XWalkView:invokeExtensionMethod	Lorg/xwalk/core/LazyReflectMethod;
    //   33: iconst_2
    //   34: anewarray 691	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: iload_1
    //   40: invokestatic 994	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_2
    //   47: aastore
    //   48: invokevirtual 711	org/xwalk/core/LazyReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   51: astore_2
    //   52: ldc_w 1098
    //   55: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_2
    //   59: areturn
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 664	org/xwalk/core/XWalkView:coreWrapper	Lorg/xwalk/core/XWalkCoreWrapper;
    //   65: ifnonnull +22 -> 87
    //   68: new 996	java/lang/RuntimeException
    //   71: dup
    //   72: ldc_w 998
    //   75: invokespecial 1001	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   78: astore_2
    //   79: ldc_w 1098
    //   82: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: athrow
    //   87: aload_2
    //   88: invokestatic 986	org/xwalk/core/XWalkCoreWrapper:handleRuntimeError	(Ljava/lang/Throwable;)V
    //   91: ldc_w 1098
    //   94: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aconst_null
    //   98: areturn
    //   99: astore_2
    //   100: ldc 26
    //   102: ldc_w 1102
    //   105: aload_2
    //   106: invokestatic 962	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   109: invokevirtual 966	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   112: invokestatic 972	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto -24 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	XWalkView
    //   0	118	1	paramInt	int
    //   0	118	2	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	52	60	java/lang/UnsupportedOperationException
    //   29	52	99	finally
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(155078);
    try
    {
      this.leaveFullscreenMethod.invoke(new Object[0]);
      AppMethodBeat.o(155078);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155078);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155078);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155054);
    try
    {
      this.loadStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(155054);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155054);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155054);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(155055);
    try
    {
      this.loadStringStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramMap });
      AppMethodBeat.o(155055);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155055);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155055);
    }
  }
  
  public void loadAppFromManifest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155060);
    try
    {
      this.loadAppFromManifestStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(155060);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155060);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155060);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(155056);
    try
    {
      this.loadDataStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(155056);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155056);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155056);
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(155057);
    try
    {
      this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
      AppMethodBeat.o(155057);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155057);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155057);
    }
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(155058);
    try
    {
      this.loadUrlStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155058);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155058);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155058);
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(155059);
    try
    {
      this.loadUrlStringMapMethod.invoke(new Object[] { paramString, paramMap });
      AppMethodBeat.o(155059);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155059);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155059);
    }
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(155087);
    try
    {
      this.onActivityResultintintIntentMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      AppMethodBeat.o(155087);
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155087);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(155087);
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(155114);
    try
    {
      paramEditorInfo = (InputConnection)this.onCreateInputConnectionEditorInfoMethod.invoke(new Object[] { paramEditorInfo });
      AppMethodBeat.o(155114);
      return paramEditorInfo;
    }
    catch (UnsupportedOperationException paramEditorInfo)
    {
      if (this.coreWrapper == null)
      {
        paramEditorInfo = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155114);
        throw paramEditorInfo;
      }
      XWalkCoreWrapper.handleRuntimeError(paramEditorInfo);
      AppMethodBeat.o(155114);
    }
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(155085);
    try
    {
      this.onDestroyMethod.invoke(new Object[0]);
      AppMethodBeat.o(155085);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155085);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155085);
    }
  }
  
  public void onHide()
  {
    AppMethodBeat.i(155083);
    try
    {
      this.onHideMethod.invoke(new Object[0]);
      AppMethodBeat.o(155083);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155083);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155083);
    }
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(155088);
    try
    {
      boolean bool = ((Boolean)this.onNewIntentIntentMethod.invoke(new Object[] { paramIntent })).booleanValue();
      AppMethodBeat.o(155088);
      return bool;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155088);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(155088);
    }
    return false;
  }
  
  public void onOverScrolledDelegate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    AppMethodBeat.i(188344);
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
    }
    AppMethodBeat.o(188344);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(155081);
    if (!XWalkCoreWrapper.getInstance().hasFeature(1))
    {
      AppMethodBeat.o(155081);
      return;
    }
    try
    {
      this.onPauseMethod.invoke(new Object[0]);
      AppMethodBeat.o(155081);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155081);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155081);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(155082);
    if (!XWalkCoreWrapper.getInstance().hasFeature(1))
    {
      AppMethodBeat.o(155082);
      return;
    }
    try
    {
      this.onResumeMethod.invoke(new Object[0]);
      AppMethodBeat.o(155082);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155082);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155082);
    }
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(155126);
    onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangedListener != null) {
      this.mScrollChangedListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(155126);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(155084);
    try
    {
      this.onShowMethod.invoke(new Object[0]);
      AppMethodBeat.o(155084);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155084);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155084);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(155125);
    try
    {
      boolean bool = ((Boolean)this.onTouchEventMotionEventMethod.invoke(new Object[] { paramMotionEvent })).booleanValue();
      AppMethodBeat.o(155125);
      return bool;
    }
    catch (UnsupportedOperationException paramMotionEvent)
    {
      if (this.coreWrapper == null)
      {
        paramMotionEvent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155125);
        throw paramMotionEvent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMotionEvent);
      AppMethodBeat.o(155125);
    }
    return false;
  }
  
  public boolean overScrollByDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
  {
    AppMethodBeat.i(188334);
    if (this.mOverScrolledListener != null)
    {
      paramBoolean = this.mOverScrolledListener.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
      AppMethodBeat.o(188334);
      return paramBoolean;
    }
    AppMethodBeat.o(188334);
    return false;
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(155079);
    try
    {
      this.pauseTimersMethod.invoke(new Object[0]);
      AppMethodBeat.o(155079);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155079);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155079);
    }
  }
  
  public void postXWalkViewInternalContextActivityConstructor()
  {
    AppMethodBeat.i(155053);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    AppMethodBeat.o(155053);
  }
  
  public void postXWalkViewInternalContextAttributeSetConstructor()
  {
    AppMethodBeat.i(155046);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    AppMethodBeat.o(155046);
  }
  
  public void postXWalkViewInternalContextConstructor()
  {
    AppMethodBeat.i(155044);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    AppMethodBeat.o(155044);
  }
  
  /* Error */
  public boolean preInitViewSize(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1167
    //   3: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 178	org/xwalk/core/XWalkView:preInitViewSizeMethod	Lorg/xwalk/core/LazyReflectMethod;
    //   10: iconst_3
    //   11: anewarray 691	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: iload_1
    //   17: invokestatic 994	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 994	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: iload_3
    //   31: invokestatic 1010	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: aastore
    //   35: invokevirtual 711	org/xwalk/core/LazyReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 763	java/lang/Boolean
    //   41: invokevirtual 1005	java/lang/Boolean:booleanValue	()Z
    //   44: istore_3
    //   45: ldc_w 1167
    //   48: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: iload_3
    //   52: ireturn
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 664	org/xwalk/core/XWalkView:coreWrapper	Lorg/xwalk/core/XWalkCoreWrapper;
    //   59: ifnonnull +24 -> 83
    //   62: new 996	java/lang/RuntimeException
    //   65: dup
    //   66: ldc_w 998
    //   69: invokespecial 1001	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   72: astore 4
    //   74: ldc_w 1167
    //   77: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload 4
    //   82: athrow
    //   83: aload 4
    //   85: invokestatic 986	org/xwalk/core/XWalkCoreWrapper:handleRuntimeError	(Ljava/lang/Throwable;)V
    //   88: ldc_w 1167
    //   91: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore 4
    //   98: ldc 26
    //   100: ldc_w 1169
    //   103: aload 4
    //   105: invokestatic 962	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   108: invokevirtual 966	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 972	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: goto -26 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	XWalkView
    //   0	117	1	paramInt1	int
    //   0	117	2	paramInt2	int
    //   0	117	3	paramBoolean	boolean
    //   53	1	4	localUnsupportedOperationException	UnsupportedOperationException
    //   72	12	4	localRuntimeException	RuntimeException
    //   96	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	45	53	java/lang/UnsupportedOperationException
    //   6	45	96	finally
  }
  
  public void reload(int paramInt)
  {
    AppMethodBeat.i(155061);
    try
    {
      this.reloadintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155061);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155061);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155061);
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(155073);
    try
    {
      this.removeJavascriptInterfaceStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155073);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.removeJavascriptInterfaceStringMethod.setArguments(new Object[] { paramString });
        XWalkReflectionInitHandler.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
        AppMethodBeat.o(155073);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155073);
    }
  }
  
  public void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(155150);
    try
    {
      this.replaceTranslatedStringMethod.invoke(new Object[] { paramMap });
      AppMethodBeat.o(155150);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper == null)
      {
        paramMap = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155150);
        throw paramMap;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMap);
      AppMethodBeat.o(155150);
    }
  }
  
  public boolean restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(155090);
    try
    {
      boolean bool = ((Boolean)this.restoreStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      AppMethodBeat.o(155090);
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null)
      {
        paramBundle = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155090);
        throw paramBundle;
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
      AppMethodBeat.o(155090);
    }
    return false;
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(155080);
    try
    {
      this.resumeTimersMethod.invoke(new Object[0]);
      AppMethodBeat.o(155080);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155080);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155080);
    }
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(155065);
    try
    {
      boolean bool = ((Boolean)this.savePageMethod.invoke(new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(155065);
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155065);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(155065);
    }
    return false;
  }
  
  public boolean saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(155089);
    try
    {
      boolean bool = ((Boolean)this.saveStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      AppMethodBeat.o(155089);
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null)
      {
        paramBundle = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155089);
        throw paramBundle;
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
      AppMethodBeat.o(155089);
    }
    return false;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155133);
    try
    {
      this.scrollByintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(155133);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155133);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155133);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155132);
    try
    {
      this.scrollTointintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(155132);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155132);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155132);
    }
  }
  
  public void setAcceptLanguages(String paramString)
  {
    AppMethodBeat.i(155103);
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155103);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155103);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155103);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(155099);
    try
    {
      this.setBackgroundColorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155099);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155099);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155099);
    }
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(155066);
    if (!this.isInitedBottomHeightMethod)
    {
      this.isInitedBottomHeightMethod = true;
      this.setBottomHeightMethod.init(this.bridge, null, "setBottomHeightSuper", new Class[] { Integer.TYPE });
    }
    if ((this.setBottomHeightMethod == null) || (this.setBottomHeightMethod.isNull()))
    {
      AppMethodBeat.o(155066);
      return;
    }
    try
    {
      this.setBottomHeightMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155066);
      return;
    }
    finally
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155066);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155066);
    }
  }
  
  public void setCustomOnOverScrolledListener(OverScrolledListener paramOverScrolledListener)
  {
    this.mOverScrolledListener = paramOverScrolledListener;
  }
  
  public void setCustomOnScrollChangedListener(ScrollChangedListener paramScrollChangedListener)
  {
    this.mScrollChangedListener = paramScrollChangedListener;
  }
  
  public void setDownloadListener(XWalkDownloadListener paramXWalkDownloadListener)
  {
    AppMethodBeat.i(155122);
    try
    {
      this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(new Object[] { paramXWalkDownloadListener.getBridge() });
      AppMethodBeat.o(155122);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkDownloadListener, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
        AppMethodBeat.o(155122);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155122);
    }
  }
  
  public void setExtendInputClient(XWalkExtendInputClient paramXWalkExtendInputClient)
  {
    AppMethodBeat.i(188018);
    try
    {
      this.setExtendInputClientXWalkExtendInputClientInternalMethod.invoke(new Object[] { paramXWalkExtendInputClient.getBridge() });
      AppMethodBeat.o(188018);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendInputClientXWalkExtendInputClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendInputClient, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setExtendInputClientXWalkExtendInputClientInternalMethod);
        AppMethodBeat.o(188018);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(188018);
    }
  }
  
  public void setExtendPluginClient(XWalkExtendPluginClient paramXWalkExtendPluginClient)
  {
    AppMethodBeat.i(155094);
    try
    {
      this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(new Object[] { paramXWalkExtendPluginClient.getBridge() });
      AppMethodBeat.o(155094);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendPluginClient, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
        AppMethodBeat.o(155094);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155094);
    }
  }
  
  public void setExtendTextAreaClient(XWalkExtendTextAreaClient paramXWalkExtendTextAreaClient)
  {
    AppMethodBeat.i(155096);
    try
    {
      this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.invoke(new Object[] { paramXWalkExtendTextAreaClient.getBridge() });
      AppMethodBeat.o(155096);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkExtendTextAreaClient, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setExtendTextAreaClientXWalkExtendTextAreaClientInternalMethod);
        AppMethodBeat.o(155096);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155096);
    }
  }
  
  public void setFindListener(XWalkFindListener paramXWalkFindListener)
  {
    AppMethodBeat.i(155143);
    try
    {
      this.setFindListenerXWalkFindListenerInternalMethod.invoke(new Object[] { paramXWalkFindListener.getBridge() });
      AppMethodBeat.o(155143);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkFindListener, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
        AppMethodBeat.o(155143);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155143);
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(155051);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      AppMethodBeat.o(155051);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
    AppMethodBeat.o(155051);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(155052);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      AppMethodBeat.o(155052);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
    AppMethodBeat.o(155052);
  }
  
  public void setHorizontalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(155153);
    try
    {
      this.setHorizontalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155153);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155153);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155153);
    }
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(155115);
    try
    {
      this.setInitialScaleintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155115);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155115);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155115);
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(155106);
    try
    {
      this.setNetworkAvailablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155106);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155106);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155106);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(155130);
    try
    {
      this.setOnTouchListenerOnTouchListenerMethod.invoke(new Object[] { paramOnTouchListener });
      AppMethodBeat.o(155130);
      return;
    }
    catch (UnsupportedOperationException paramOnTouchListener)
    {
      if (this.coreWrapper == null)
      {
        paramOnTouchListener = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155130);
        throw paramOnTouchListener;
      }
      XWalkCoreWrapper.handleRuntimeError(paramOnTouchListener);
      AppMethodBeat.o(155130);
    }
  }
  
  public void setOriginAccessWhitelist(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(155100);
    try
    {
      this.setOriginAccessWhitelistStringStringArrayMethod.invoke(new Object[] { paramString, paramArrayOfString });
      AppMethodBeat.o(155100);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155100);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155100);
    }
  }
  
  public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension paramXWalkProxyWebViewClientExtension)
  {
    AppMethodBeat.i(155098);
    try
    {
      this.setProxyWebViewClientExtensionInternalMethod.invoke(new Object[] { paramXWalkProxyWebViewClientExtension.getBridge() });
      AppMethodBeat.o(155098);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setProxyWebViewClientExtensionInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkProxyWebViewClientExtension, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setProxyWebViewClientExtensionInternalMethod);
        AppMethodBeat.o(155098);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155098);
    }
  }
  
  public void setResourceClient(XWalkResourceClient paramXWalkResourceClient)
  {
    AppMethodBeat.i(155097);
    try
    {
      this.setResourceClientXWalkResourceClientInternalMethod.invoke(new Object[] { paramXWalkResourceClient.getBridge() });
      AppMethodBeat.o(155097);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkResourceClient, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
        AppMethodBeat.o(155097);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155097);
    }
  }
  
  public void setSurfaceViewVisibility(int paramInt)
  {
    AppMethodBeat.i(155120);
    try
    {
      this.setSurfaceViewVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155120);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setSurfaceViewVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
        AppMethodBeat.o(155120);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155120);
    }
  }
  
  public void setTranslateMode(boolean paramBoolean)
  {
    AppMethodBeat.i(155148);
    try
    {
      this.setTranslateModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155148);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155148);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155148);
    }
  }
  
  public void setUIClient(XWalkUIClient paramXWalkUIClient)
  {
    AppMethodBeat.i(155093);
    try
    {
      this.setUIClientXWalkUIClientInternalMethod.invoke(new Object[] { paramXWalkUIClient.getBridge() });
      AppMethodBeat.o(155093);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setUIClientXWalkUIClientInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkUIClient, "getBridge", new Class[0]) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
        AppMethodBeat.o(155093);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155093);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(155101);
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(155101);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155101);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(155101);
    }
  }
  
  public void setVerticalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(155152);
    try
    {
      this.setVerticalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155152);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155152);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155152);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(155119);
    super.setVisibility(paramInt);
    setXWalkViewInternalVisibility(paramInt);
    setSurfaceViewVisibility(paramInt);
    AppMethodBeat.o(155119);
  }
  
  public void setWebContentsSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188030);
    try
    {
      this.setWebContentsSizeintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(188030);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(188030);
    }
  }
  
  public void setXWalkViewInternalVisibility(int paramInt)
  {
    AppMethodBeat.i(155121);
    try
    {
      this.setXWalkViewInternalVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(155121);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setXWalkViewInternalVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkReflectionInitHandler.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
        AppMethodBeat.o(155121);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(155121);
    }
  }
  
  public void setZOrderOnTop(boolean paramBoolean)
  {
    AppMethodBeat.i(155117);
    try
    {
      this.setZOrderOnTopbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(155117);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155117);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155117);
    }
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(155131);
    try
    {
      this.smoothScrollintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(155131);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155131);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155131);
    }
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(155086);
    try
    {
      this.startActivityForResultIntentintBundleMethod.invoke(new Object[] { paramIntent, Integer.valueOf(paramInt), paramBundle });
      AppMethodBeat.o(155086);
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155086);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(155086);
    }
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(155062);
    try
    {
      this.stopLoadingMethod.invoke(new Object[0]);
      AppMethodBeat.o(155062);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155062);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155062);
    }
  }
  
  public void zoomBy(float paramFloat)
  {
    AppMethodBeat.i(155111);
    try
    {
      this.zoomByfloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(155111);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155111);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155111);
    }
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(155108);
    try
    {
      boolean bool = ((Boolean)this.zoomInMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155108);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155108);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155108);
    }
    return false;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(155110);
    try
    {
      boolean bool = ((Boolean)this.zoomOutMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(155110);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155110);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155110);
    }
    return false;
  }
  
  public static abstract interface OverScrolledListener
  {
    public abstract void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView);
    
    public abstract void onOverScrolled(boolean paramBoolean);
    
    public abstract boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView);
  }
  
  public static abstract interface ScrollChangedListener
  {
    public abstract void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkView
 * JD-Core Version:    0.7.0.1
 */