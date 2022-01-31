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
import com.tencent.xweb.util.f;
import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView
  extends AbsoluteLayout
{
  private static final String ANIMATABLE = "animatable";
  public static final int RELOAD_IGNORE_CACHE = 1;
  public static final int RELOAD_NORMAL = 0;
  public static final String SURFACE_VIEW = "SurfaceView";
  private static final String TAG = "XWalkView";
  public static final String TEXTURE_VIEW = "TextureView";
  private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
  private ReflectMethod addJavascriptInterfaceObjectStringMethod;
  private ReflectMethod adjustSelectPositionlongStringintintMethod;
  private Object bridge;
  private ReflectMethod canZoomInMethod;
  private ReflectMethod canZoomOutMethod;
  private ReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod;
  private ReflectMethod clearCacheForSingleFileStringMethod;
  private ReflectMethod clearCachebooleanMethod;
  private ReflectMethod clearClientCertPreferencesRunnableMethod;
  private ReflectMethod clearFormDataMethod;
  private ReflectMethod clearMatchesMethod;
  private ReflectMethod clearSslPreferencesMethod;
  private ReflectMethod computeHorizontalScrollOffsetMethod;
  private ReflectMethod computeHorizontalScrollRangeMethod;
  private ReflectMethod computeVerticalScrollExtentMethod;
  private ReflectMethod computeVerticalScrollOffsetMethod;
  private ReflectMethod computeVerticalScrollRangeMethod;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod evaluateJavascriptStringValueCallbackMethod;
  private ReflectMethod findAllAsyncStringMethod;
  private ReflectMethod findNextbooleanMethod;
  private ReflectMethod getAPIVersionMethod;
  private ReflectMethod getCertificateMethod;
  private ReflectMethod getCompositingSurfaceTypeMethod;
  private ReflectMethod getContentHeightMethod;
  private ReflectMethod getExtensionManagerMethod;
  private ReflectMethod getFaviconMethod;
  private ReflectMethod getHitTestResultMethod;
  private ReflectMethod getImageBitmapToFileMethod;
  private ReflectMethod getNavigationHistoryMethod;
  private ReflectMethod getOriginalUrlMethod;
  private ReflectMethod getRefererUrlMethod;
  private ReflectMethod getRemoteDebuggingUrlMethod;
  private ReflectMethod getScalenMethod;
  private ReflectMethod getSettingsMethod;
  private ReflectMethod getTitleMethod;
  private ReflectMethod getTranslateSampleStringintMethod;
  private ReflectMethod getUrlMethod;
  private ReflectMethod getUserAgentStringMethod;
  private ReflectMethod getXWalkContentViewMethod;
  private ReflectMethod getXWalkVersionMethod;
  private ReflectMethod hasEnteredFullscreenMethod;
  private ReflectMethod invokeExtensionMethod;
  private ReflectMethod isSupportExtendPluginForAppbrandMethod;
  private ReflectMethod leaveFullscreenMethod;
  private ReflectMethod loadAppFromManifestStringStringMethod;
  private ReflectMethod loadDataStringStringStringMethod;
  private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod;
  private ReflectMethod loadStringStringMapMethod;
  private ReflectMethod loadStringStringMethod;
  private ReflectMethod loadUrlStringMapMethod;
  private ReflectMethod loadUrlStringMethod;
  private String mAnimatable;
  private XWalkView.OverScrolledListener mOverScrolledListener;
  private XWalkView.ScrollChangedListener mScrollChangedListener;
  private ReflectMethod onActivityResultintintIntentMethod;
  private ReflectMethod onCreateInputConnectionEditorInfoMethod;
  private ReflectMethod onDestroyMethod;
  private ReflectMethod onHideMethod;
  private ReflectMethod onNewIntentIntentMethod;
  private ReflectMethod onPauseMethod;
  private ReflectMethod onResumeMethod;
  private ReflectMethod onShowMethod;
  private ReflectMethod onTouchEventMotionEventMethod;
  private ReflectMethod pauseTimersMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod preInitViewSizeMethod;
  private ReflectMethod reloadintMethod;
  private ReflectMethod removeJavascriptInterfaceStringMethod;
  private ReflectMethod replaceTranslatedStringMethod;
  private ReflectMethod restoreStateBundleMethod;
  private ReflectMethod resumeTimersMethod;
  private ReflectMethod savePageMethod;
  private ReflectMethod saveStateBundleMethod;
  private ReflectMethod scrollByintintMethod;
  private ReflectMethod scrollTointintMethod;
  private ReflectMethod setAcceptLanguagesStringMethod;
  private ReflectMethod setBackgroundColorintMethod;
  private ReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod;
  private ReflectMethod setExtendCanvasClientXWalkExtendCanvasClientInternalMethod;
  private ReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod;
  private ReflectMethod setFindListenerXWalkFindListenerInternalMethod;
  private ReflectMethod setHorizontalScrollBarEnablebooleanMethod;
  private ReflectMethod setInitialScaleintMethod;
  private ReflectMethod setNetworkAvailablebooleanMethod;
  private ReflectMethod setOnTouchListenerOnTouchListenerMethod;
  private ReflectMethod setOriginAccessWhitelistStringStringArrayMethod;
  private ReflectMethod setProxyWebViewClientExtensionInternalMethod;
  private ReflectMethod setResourceClientXWalkResourceClientInternalMethod;
  private ReflectMethod setSurfaceViewVisibilityintMethod;
  private ReflectMethod setTranslateModebooleanMethod;
  private ReflectMethod setUIClientXWalkUIClientInternalMethod;
  private ReflectMethod setUserAgentStringStringMethod;
  private ReflectMethod setVerticalScrollBarEnablebooleanMethod;
  private ReflectMethod setXWalkViewInternalVisibilityintMethod;
  private ReflectMethod setZOrderOnTopbooleanMethod;
  private ReflectMethod smoothScrollintintMethod;
  private ReflectMethod startActivityForResultIntentintBundleMethod;
  private ReflectMethod stopLoadingMethod;
  private ReflectMethod zoomByfloatMethod;
  private ReflectMethod zoomInMethod;
  private ReflectMethod zoomOutMethod;
  
  static
  {
    AppMethodBeat.i(86044);
    if (!XWalkView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(86044);
      return;
    }
  }
  
  public XWalkView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(85939);
    this.preInitViewSizeMethod = new ReflectMethod(null, "preInitViewSize", new Class[0]);
    this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
    this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
    this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
    this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new ReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
    this.setTranslateModebooleanMethod = new ReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new ReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new ReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new ReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new ReflectMethod(null, "invokeExtension", new Class[0]);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(85939);
  }
  
  @Deprecated
  public XWalkView(Context paramContext, Activity paramActivity)
  {
    super(paramContext, null);
    AppMethodBeat.i(85943);
    this.preInitViewSizeMethod = new ReflectMethod(null, "preInitViewSize", new Class[0]);
    this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
    this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
    this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
    this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new ReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
    this.setTranslateModebooleanMethod = new ReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new ReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new ReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new ReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new ReflectMethod(null, "invokeExtension", new Class[0]);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorTypes.add(Activity.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.constructorParams.add(paramActivity);
    this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(85943);
  }
  
  public XWalkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(85941);
    this.preInitViewSizeMethod = new ReflectMethod(null, "preInitViewSize", new Class[0]);
    this.isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
    this.getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
    this.loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
    this.loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
    this.loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
    this.loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
    this.loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
    this.reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
    this.stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
    this.getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
    this.getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    this.savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
    this.getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
    this.getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
    this.getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
    this.getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
    this.getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
    this.addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
    this.removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
    this.evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
    this.clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
    this.clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
    this.hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
    this.leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
    this.pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
    this.resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
    this.onPauseMethod = new ReflectMethod(null, "onPause", new Class[0]);
    this.onResumeMethod = new ReflectMethod(null, "onResume", new Class[0]);
    this.onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
    this.onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
    this.onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
    this.startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
    this.onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
    this.onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
    this.saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
    this.restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
    this.getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
    this.getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
    this.setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
    this.setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
    this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod = new ReflectMethod(null, "setExtendCanvasClient", new Class[0]);
    this.setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
    this.setProxyWebViewClientExtensionInternalMethod = new ReflectMethod(null, "setProxyWebViewClientExtension", new Class[0]);
    this.setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
    this.setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
    this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
    this.getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
    this.setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
    this.getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
    this.zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
    this.getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
    this.zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
    this.zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
    this.canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
    this.canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
    this.onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
    this.setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
    this.getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
    this.setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
    this.clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    this.setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
    this.setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
    this.setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
    this.onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
    this.setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
    this.smoothScrollintintMethod = new ReflectMethod(null, "smoothScroll", new Class[0]);
    this.scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
    this.scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
    this.computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
    this.computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
    this.computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
    this.computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
    this.computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
    this.getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
    this.clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
    this.clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
    this.getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
    this.setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
    this.findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
    this.findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
    this.clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
    this.setTranslateModebooleanMethod = new ReflectMethod(null, "setTranslateMode", new Class[0]);
    this.getTranslateSampleStringintMethod = new ReflectMethod(null, "getTranslateSampleString", new Class[0]);
    this.replaceTranslatedStringMethod = new ReflectMethod(null, "replaceTranslatedString", new Class[0]);
    this.getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
    this.adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
    this.setVerticalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setVerticalScrollBarEnable", new Class[0]);
    this.setHorizontalScrollBarEnablebooleanMethod = new ReflectMethod(null, "setHorizontalScrollBarEnable", new Class[0]);
    this.getImageBitmapToFileMethod = new ReflectMethod(null, "getImageBitmapToFile", new Class[0]);
    this.invokeExtensionMethod = new ReflectMethod(null, "invokeExtension", new Class[0]);
    if (isInEditMode())
    {
      AppMethodBeat.o(85941);
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
    this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
    reflectionInit();
    AppMethodBeat.o(85941);
  }
  
  private void onFocusChangedDelegate(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(86020);
    onFocusChanged(paramBoolean, paramInt, paramRect);
    AppMethodBeat.o(86020);
  }
  
  private void onOverScrolledDelegate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(86021);
    onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(86021);
  }
  
  private void onOverscrollRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(86022);
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramBoolean);
    }
    AppMethodBeat.o(86022);
  }
  
  private boolean onTouchEventDelegate(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(86017);
    boolean bool = onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(86017);
    return bool;
  }
  
  private boolean performLongClickDelegate()
  {
    AppMethodBeat.i(86016);
    boolean bool = performLongClick();
    AppMethodBeat.o(86016);
    return bool;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(85966);
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      AppMethodBeat.o(85966);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.addJavascriptInterfaceObjectStringMethod.setArguments(new Object[] { paramObject, paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
        AppMethodBeat.o(85966);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85966);
    }
  }
  
  public void adjustSelectPosition(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86040);
    try
    {
      this.adjustSelectPositionlongStringintintMethod.invoke(new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(86040);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86040);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(86040);
    }
  }
  
  public boolean canZoomIn()
  {
    AppMethodBeat.i(86005);
    try
    {
      boolean bool = ((Boolean)this.canZoomInMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(86005);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86005);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86005);
    }
    return false;
  }
  
  public boolean canZoomOut()
  {
    AppMethodBeat.i(86006);
    try
    {
      boolean bool = ((Boolean)this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(86006);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86006);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86006);
    }
    return false;
  }
  
  public void captureBitmapAsync(XWalkGetBitmapCallback paramXWalkGetBitmapCallback)
  {
    AppMethodBeat.i(85997);
    try
    {
      this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(new Object[] { paramXWalkGetBitmapCallback.getBridge() });
      AppMethodBeat.o(85997);
      return;
    }
    catch (UnsupportedOperationException paramXWalkGetBitmapCallback)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkGetBitmapCallback = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85997);
        throw paramXWalkGetBitmapCallback;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkGetBitmapCallback);
      AppMethodBeat.o(85997);
    }
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(85969);
    try
    {
      this.clearCachebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85969);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85969);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85969);
    }
  }
  
  public void clearCacheForSingleFile(String paramString)
  {
    AppMethodBeat.i(85970);
    try
    {
      this.clearCacheForSingleFileStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85970);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85970);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85970);
    }
  }
  
  public void clearClientCertPreferences(Runnable paramRunnable)
  {
    AppMethodBeat.i(86033);
    try
    {
      this.clearClientCertPreferencesRunnableMethod.invoke(new Object[] { paramRunnable });
      AppMethodBeat.o(86033);
      return;
    }
    catch (UnsupportedOperationException paramRunnable)
    {
      if (this.coreWrapper == null)
      {
        paramRunnable = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86033);
        throw paramRunnable;
      }
      XWalkCoreWrapper.handleRuntimeError(paramRunnable);
      AppMethodBeat.o(86033);
    }
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(86011);
    try
    {
      this.clearFormDataMethod.invoke(new Object[0]);
      AppMethodBeat.o(86011);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86011);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86011);
    }
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(86038);
    try
    {
      this.clearMatchesMethod.invoke(new Object[0]);
      AppMethodBeat.o(86038);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86038);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86038);
    }
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(86032);
    try
    {
      this.clearSslPreferencesMethod.invoke(new Object[0]);
      AppMethodBeat.o(86032);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86032);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86032);
    }
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(86027);
    try
    {
      int i = ((Integer)this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(86027);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86027);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86027);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(86026);
    try
    {
      int i = ((Integer)this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(86026);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86026);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86026);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(86030);
    try
    {
      int i = ((Integer)this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(86030);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86030);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86030);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(86029);
    try
    {
      int i = ((Integer)this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(86029);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86029);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86029);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(86028);
    try
    {
      int i = ((Integer)this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(86028);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86028);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86028);
    }
    return 0;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(85968);
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      AppMethodBeat.o(85968);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85968);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85968);
    }
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(86036);
    try
    {
      this.findAllAsyncStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(86036);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86036);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(86036);
    }
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(86037);
    try
    {
      this.findNextbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(86037);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86037);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86037);
    }
  }
  
  public String getAPIVersion()
  {
    AppMethodBeat.i(85985);
    try
    {
      String str = (String)this.getAPIVersionMethod.invoke(new Object[0]);
      AppMethodBeat.o(85985);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85985);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85985);
    }
    return null;
  }
  
  public Object getBridge()
  {
    return this.bridge;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(86034);
    try
    {
      SslCertificate localSslCertificate = (SslCertificate)this.getCertificateMethod.invoke(new Object[0]);
      AppMethodBeat.o(86034);
      return localSslCertificate;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86034);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86034);
    }
    return null;
  }
  
  public String getCompositingSurfaceType()
  {
    AppMethodBeat.i(86039);
    try
    {
      String str = (String)this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
      AppMethodBeat.o(86039);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86039);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86039);
    }
    return null;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(85962);
    try
    {
      int i = ((Integer)this.getContentHeightMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85962);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85962);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85962);
    }
    return 0;
  }
  
  public XWalkExternalExtensionManager getExtensionManager()
  {
    AppMethodBeat.i(86031);
    try
    {
      XWalkExternalExtensionManager localXWalkExternalExtensionManager = (XWalkExternalExtensionManager)this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
      AppMethodBeat.o(86031);
      return localXWalkExternalExtensionManager;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86031);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86031);
    }
    return null;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(86009);
    try
    {
      Bitmap localBitmap = (Bitmap)this.getFaviconMethod.invoke(new Object[0]);
      AppMethodBeat.o(86009);
      return localBitmap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86009);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86009);
    }
    return null;
  }
  
  public XWalkHitTestResult getHitTestResult()
  {
    AppMethodBeat.i(85961);
    try
    {
      XWalkHitTestResult localXWalkHitTestResult = (XWalkHitTestResult)this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
      AppMethodBeat.o(85961);
      return localXWalkHitTestResult;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85961);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85961);
    }
    return null;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, XWalkGetImageBitmapToFileFinishedCallback paramXWalkGetImageBitmapToFileFinishedCallback)
  {
    AppMethodBeat.i(139617);
    try
    {
      paramString1 = this.getImageBitmapToFileMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramXWalkGetImageBitmapToFileFinishedCallback.getBridge() });
      if ((paramString1 instanceof Boolean))
      {
        boolean bool = ((Boolean)paramString1).booleanValue();
        AppMethodBeat.o(139617);
        return bool;
      }
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139617);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(139617);
      return false;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("XWalkView", "getImageBitmapToFile error:" + paramString1.getMessage());
      }
    }
  }
  
  public XWalkNavigationHistory getNavigationHistory()
  {
    AppMethodBeat.i(85965);
    try
    {
      XWalkNavigationHistory localXWalkNavigationHistory = (XWalkNavigationHistory)this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
      AppMethodBeat.o(85965);
      return localXWalkNavigationHistory;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85965);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85965);
    }
    return null;
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(85964);
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(85964);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85964);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85964);
    }
    return null;
  }
  
  public String getRefererUrl()
  {
    AppMethodBeat.i(85958);
    try
    {
      String str = (String)this.getRefererUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(85958);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85958);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85958);
    }
    return null;
  }
  
  public Uri getRemoteDebuggingUrl()
  {
    AppMethodBeat.i(86000);
    try
    {
      Uri localUri = (Uri)this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(86000);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86000);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86000);
    }
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(86002);
    try
    {
      float f = ((Float)this.getScalenMethod.invoke(new Object[0])).floatValue();
      AppMethodBeat.o(86002);
      return f;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86002);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86002);
    }
    return 1.0F;
  }
  
  public XWalkSettings getSettings()
  {
    AppMethodBeat.i(85998);
    try
    {
      XWalkSettings localXWalkSettings = (XWalkSettings)this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
      AppMethodBeat.o(85998);
      return localXWalkSettings;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85998);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85998);
    }
    return null;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(85963);
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      AppMethodBeat.o(85963);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85963);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85963);
    }
    return null;
  }
  
  public void getTranslateSampleString(int paramInt)
  {
    AppMethodBeat.i(139615);
    try
    {
      this.getTranslateSampleStringintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      f.iB(938, 103);
      AppMethodBeat.o(139615);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139615);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(139615);
    }
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(85959);
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      AppMethodBeat.o(85959);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85959);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85959);
    }
    return null;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(85995);
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      AppMethodBeat.o(85995);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85995);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85995);
    }
    return null;
  }
  
  public ViewGroup getXWalkContentView()
  {
    AppMethodBeat.i(85945);
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.getXWalkContentViewMethod.invoke(new Object[0]);
      AppMethodBeat.o(85945);
      return localViewGroup;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85945);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85945);
    }
    return null;
  }
  
  public String getXWalkVersion()
  {
    AppMethodBeat.i(85986);
    try
    {
      String str = (String)this.getXWalkVersionMethod.invoke(new Object[0]);
      AppMethodBeat.o(85986);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85986);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85986);
    }
    return null;
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(85971);
    try
    {
      boolean bool = ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85971);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85971);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85971);
    }
    return false;
  }
  
  public Object invokeExtension(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(139618);
    if (this.invokeExtensionMethod == null)
    {
      Log.e("XWalkView", "invokeExtension not support this feature:");
      AppMethodBeat.o(139618);
      return null;
    }
    try
    {
      paramObject = this.invokeExtensionMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramObject });
      AppMethodBeat.o(139618);
      return paramObject;
    }
    catch (UnsupportedOperationException paramObject)
    {
      if (this.coreWrapper == null)
      {
        paramObject = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139618);
        throw paramObject;
      }
      XWalkCoreWrapper.handleRuntimeError(paramObject);
      AppMethodBeat.o(139618);
      return null;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.e("XWalkView", "invokeExtension error:" + paramObject.getMessage());
      }
    }
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(85944);
    try
    {
      boolean bool = ((Boolean)this.isSupportExtendPluginForAppbrandMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85944);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85944);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85944);
    }
    return false;
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(85972);
    try
    {
      this.leaveFullscreenMethod.invoke(new Object[0]);
      AppMethodBeat.o(85972);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85972);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85972);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85949);
    try
    {
      this.loadStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(85949);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85949);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85949);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(85950);
    try
    {
      this.loadStringStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramMap });
      AppMethodBeat.o(85950);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85950);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85950);
    }
  }
  
  public void loadAppFromManifest(String paramString1, String paramString2)
  {
    AppMethodBeat.i(85955);
    try
    {
      this.loadAppFromManifestStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(85955);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85955);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85955);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(85951);
    try
    {
      this.loadDataStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(85951);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85951);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85951);
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(85952);
    try
    {
      this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
      AppMethodBeat.o(85952);
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85952);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85952);
    }
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(85953);
    try
    {
      this.loadUrlStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85953);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85953);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85953);
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(85954);
    try
    {
      this.loadUrlStringMapMethod.invoke(new Object[] { paramString, paramMap });
      AppMethodBeat.o(85954);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85954);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85954);
    }
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(85981);
    try
    {
      this.onActivityResultintintIntentMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      AppMethodBeat.o(85981);
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85981);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(85981);
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(86007);
    try
    {
      paramEditorInfo = (InputConnection)this.onCreateInputConnectionEditorInfoMethod.invoke(new Object[] { paramEditorInfo });
      AppMethodBeat.o(86007);
      return paramEditorInfo;
    }
    catch (UnsupportedOperationException paramEditorInfo)
    {
      if (this.coreWrapper == null)
      {
        paramEditorInfo = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86007);
        throw paramEditorInfo;
      }
      XWalkCoreWrapper.handleRuntimeError(paramEditorInfo);
      AppMethodBeat.o(86007);
    }
    return null;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(85979);
    try
    {
      this.onDestroyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85979);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85979);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85979);
    }
  }
  
  public void onHide()
  {
    AppMethodBeat.i(85977);
    try
    {
      this.onHideMethod.invoke(new Object[0]);
      AppMethodBeat.o(85977);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85977);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85977);
    }
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(85982);
    try
    {
      boolean bool = ((Boolean)this.onNewIntentIntentMethod.invoke(new Object[] { paramIntent })).booleanValue();
      AppMethodBeat.o(85982);
      return bool;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85982);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(85982);
    }
    return false;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(85975);
    if (!XWalkCoreWrapper.getInstance().hasFeature(1))
    {
      AppMethodBeat.o(85975);
      return;
    }
    try
    {
      this.onPauseMethod.invoke(new Object[0]);
      AppMethodBeat.o(85975);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85975);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85975);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(85976);
    if (!XWalkCoreWrapper.getInstance().hasFeature(1))
    {
      AppMethodBeat.o(85976);
      return;
    }
    try
    {
      this.onResumeMethod.invoke(new Object[0]);
      AppMethodBeat.o(85976);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85976);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85976);
    }
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(86019);
    onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangedListener != null) {
      this.mScrollChangedListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(86019);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(85978);
    try
    {
      this.onShowMethod.invoke(new Object[0]);
      AppMethodBeat.o(85978);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85978);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85978);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(86018);
    try
    {
      boolean bool = ((Boolean)this.onTouchEventMotionEventMethod.invoke(new Object[] { paramMotionEvent })).booleanValue();
      AppMethodBeat.o(86018);
      return bool;
    }
    catch (UnsupportedOperationException paramMotionEvent)
    {
      if (this.coreWrapper == null)
      {
        paramMotionEvent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86018);
        throw paramMotionEvent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMotionEvent);
      AppMethodBeat.o(86018);
    }
    return false;
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(85973);
    try
    {
      this.pauseTimersMethod.invoke(new Object[0]);
      AppMethodBeat.o(85973);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85973);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85973);
    }
  }
  
  public void postXWalkViewInternalContextActivityConstructor()
  {
    AppMethodBeat.i(85948);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
    AppMethodBeat.o(85948);
  }
  
  public void postXWalkViewInternalContextAttributeSetConstructor()
  {
    AppMethodBeat.i(85942);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
    AppMethodBeat.o(85942);
  }
  
  public void postXWalkViewInternalContextConstructor()
  {
    AppMethodBeat.i(85940);
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
    AppMethodBeat.o(85940);
  }
  
  public boolean preInitViewSize(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(155679);
    try
    {
      paramBoolean = ((Boolean)this.preInitViewSizeMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      AppMethodBeat.o(155679);
      return paramBoolean;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(155679);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(155679);
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("XWalkView", "fakeViewSizeForPreload error exception:".concat(String.valueOf(localException)));
      }
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(86043);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(86043);
      return;
    }
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
      label139:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label139;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(86043);
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
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.init(this.bridge, null, "setExtendCanvasClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge") });
        this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkResourceClientBridge") });
        this.setProxyWebViewClientExtensionInternalMethod.init(this.bridge, null, "setProxyWebViewClientExtensionSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkProxyWebViewClientExtensionBridge") });
        this.setBackgroundColorintMethod.init(this.bridge, null, "setBackgroundColorSuper", new Class[] { Integer.TYPE });
        this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, null, "setOriginAccessWhitelistSuper", new Class[] { String.class, [Ljava.lang.String.class });
        this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[] { String.class });
        this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
        this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[] { String.class });
        this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, null, "captureBitmapAsyncSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge") });
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
        this.isSupportExtendPluginForAppbrandMethod.init(this.bridge, null, "isSupportExtendPluginForAppbrandSuper", new Class[0]);
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
          AppMethodBeat.o(86043);
          return;
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        AppMethodBeat.o(86043);
        return;
      }
      this.invokeExtensionMethod = null;
    }
  }
  
  public void reload(int paramInt)
  {
    AppMethodBeat.i(85956);
    try
    {
      this.reloadintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85956);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85956);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85956);
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(85967);
    try
    {
      this.removeJavascriptInterfaceStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85967);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.removeJavascriptInterfaceStringMethod.setArguments(new Object[] { paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
        AppMethodBeat.o(85967);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85967);
    }
  }
  
  public void replaceTranslatedString(Map<String, String> paramMap)
  {
    AppMethodBeat.i(139616);
    try
    {
      this.replaceTranslatedStringMethod.invoke(new Object[] { paramMap });
      AppMethodBeat.o(139616);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper == null)
      {
        paramMap = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139616);
        throw paramMap;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMap);
      AppMethodBeat.o(139616);
    }
  }
  
  public boolean restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(85984);
    try
    {
      boolean bool = ((Boolean)this.restoreStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      AppMethodBeat.o(85984);
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null)
      {
        paramBundle = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85984);
        throw paramBundle;
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
      AppMethodBeat.o(85984);
    }
    return false;
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(85974);
    try
    {
      this.resumeTimersMethod.invoke(new Object[0]);
      AppMethodBeat.o(85974);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85974);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85974);
    }
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(85960);
    try
    {
      boolean bool = ((Boolean)this.savePageMethod.invoke(new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(85960);
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85960);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(85960);
    }
    return false;
  }
  
  public boolean saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(85983);
    try
    {
      boolean bool = ((Boolean)this.saveStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      AppMethodBeat.o(85983);
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null)
      {
        paramBundle = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85983);
        throw paramBundle;
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
      AppMethodBeat.o(85983);
    }
    return false;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86025);
    try
    {
      this.scrollByintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(86025);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86025);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86025);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(86024);
    try
    {
      this.scrollTointintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(86024);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86024);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86024);
    }
  }
  
  public void setAcceptLanguages(String paramString)
  {
    AppMethodBeat.i(85996);
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85996);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85996);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85996);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(85992);
    try
    {
      this.setBackgroundColorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85992);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85992);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85992);
    }
  }
  
  public void setCustomOnOverScrolledListener(XWalkView.OverScrolledListener paramOverScrolledListener)
  {
    this.mOverScrolledListener = paramOverScrolledListener;
  }
  
  public void setCustomOnScrollChangedListener(XWalkView.ScrollChangedListener paramScrollChangedListener)
  {
    this.mScrollChangedListener = paramScrollChangedListener;
  }
  
  public void setDownloadListener(XWalkDownloadListener paramXWalkDownloadListener)
  {
    AppMethodBeat.i(86015);
    try
    {
      this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(new Object[] { paramXWalkDownloadListener.getBridge() });
      AppMethodBeat.o(86015);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkDownloadListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
        AppMethodBeat.o(86015);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(86015);
    }
  }
  
  public void setExtendCanvasClient(XWalkExtendCanvasClient paramXWalkExtendCanvasClient)
  {
    AppMethodBeat.i(85989);
    try
    {
      this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.invoke(new Object[] { paramXWalkExtendCanvasClient.getBridge() });
      AppMethodBeat.o(85989);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkExtendCanvasClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendCanvasClientXWalkExtendCanvasClientInternalMethod);
        AppMethodBeat.o(85989);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85989);
    }
  }
  
  public void setExtendPluginClient(XWalkExtendPluginClient paramXWalkExtendPluginClient)
  {
    AppMethodBeat.i(85988);
    try
    {
      this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(new Object[] { paramXWalkExtendPluginClient.getBridge() });
      AppMethodBeat.o(85988);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkExtendPluginClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
        AppMethodBeat.o(85988);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85988);
    }
  }
  
  public void setFindListener(XWalkFindListener paramXWalkFindListener)
  {
    AppMethodBeat.i(86035);
    try
    {
      this.setFindListenerXWalkFindListenerInternalMethod.invoke(new Object[] { paramXWalkFindListener.getBridge() });
      AppMethodBeat.o(86035);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkFindListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
        AppMethodBeat.o(86035);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(86035);
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(85946);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      AppMethodBeat.o(85946);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
    AppMethodBeat.o(85946);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(85947);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      AppMethodBeat.o(85947);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
    AppMethodBeat.o(85947);
  }
  
  public void setHorizontalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(86042);
    try
    {
      this.setHorizontalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(86042);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86042);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86042);
    }
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(86008);
    try
    {
      this.setInitialScaleintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(86008);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86008);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86008);
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(85999);
    try
    {
      this.setNetworkAvailablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85999);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85999);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85999);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(86023);
    try
    {
      this.setOnTouchListenerOnTouchListenerMethod.invoke(new Object[] { paramOnTouchListener });
      AppMethodBeat.o(86023);
      return;
    }
    catch (UnsupportedOperationException paramOnTouchListener)
    {
      if (this.coreWrapper == null)
      {
        paramOnTouchListener = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86023);
        throw paramOnTouchListener;
      }
      XWalkCoreWrapper.handleRuntimeError(paramOnTouchListener);
      AppMethodBeat.o(86023);
    }
  }
  
  public void setOriginAccessWhitelist(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(85993);
    try
    {
      this.setOriginAccessWhitelistStringStringArrayMethod.invoke(new Object[] { paramString, paramArrayOfString });
      AppMethodBeat.o(85993);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85993);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85993);
    }
  }
  
  public void setProxyWebViewClientExtension(XWalkProxyWebViewClientExtension paramXWalkProxyWebViewClientExtension)
  {
    AppMethodBeat.i(85991);
    try
    {
      this.setProxyWebViewClientExtensionInternalMethod.invoke(new Object[] { paramXWalkProxyWebViewClientExtension.getBridge() });
      AppMethodBeat.o(85991);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setProxyWebViewClientExtensionInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkProxyWebViewClientExtension, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setProxyWebViewClientExtensionInternalMethod);
        AppMethodBeat.o(85991);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85991);
    }
  }
  
  public void setResourceClient(XWalkResourceClient paramXWalkResourceClient)
  {
    AppMethodBeat.i(85990);
    try
    {
      this.setResourceClientXWalkResourceClientInternalMethod.invoke(new Object[] { paramXWalkResourceClient.getBridge() });
      AppMethodBeat.o(85990);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkResourceClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
        AppMethodBeat.o(85990);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85990);
    }
  }
  
  public void setSurfaceViewVisibility(int paramInt)
  {
    AppMethodBeat.i(86013);
    try
    {
      this.setSurfaceViewVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(86013);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setSurfaceViewVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
        AppMethodBeat.o(86013);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(86013);
    }
  }
  
  public void setTranslateMode(boolean paramBoolean)
  {
    AppMethodBeat.i(139614);
    try
    {
      this.setTranslateModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(139614);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139614);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(139614);
    }
  }
  
  public void setUIClient(XWalkUIClient paramXWalkUIClient)
  {
    AppMethodBeat.i(85987);
    try
    {
      this.setUIClientXWalkUIClientInternalMethod.invoke(new Object[] { paramXWalkUIClient.getBridge() });
      AppMethodBeat.o(85987);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setUIClientXWalkUIClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkUIClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
        AppMethodBeat.o(85987);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85987);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(85994);
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85994);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85994);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85994);
    }
  }
  
  public void setVerticalScrollBarEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(86041);
    try
    {
      this.setVerticalScrollBarEnablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(86041);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86041);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86041);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(86012);
    super.setVisibility(paramInt);
    setXWalkViewInternalVisibility(paramInt);
    setSurfaceViewVisibility(paramInt);
    AppMethodBeat.o(86012);
  }
  
  public void setXWalkViewInternalVisibility(int paramInt)
  {
    AppMethodBeat.i(86014);
    try
    {
      this.setXWalkViewInternalVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(86014);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setXWalkViewInternalVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
        AppMethodBeat.o(86014);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(86014);
    }
  }
  
  public void setZOrderOnTop(boolean paramBoolean)
  {
    AppMethodBeat.i(86010);
    try
    {
      this.setZOrderOnTopbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(86010);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86010);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86010);
    }
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(139613);
    try
    {
      this.smoothScrollintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      AppMethodBeat.o(139613);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(139613);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(139613);
    }
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(85980);
    try
    {
      this.startActivityForResultIntentintBundleMethod.invoke(new Object[] { paramIntent, Integer.valueOf(paramInt), paramBundle });
      AppMethodBeat.o(85980);
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null)
      {
        paramIntent = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85980);
        throw paramIntent;
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
      AppMethodBeat.o(85980);
    }
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(85957);
    try
    {
      this.stopLoadingMethod.invoke(new Object[0]);
      AppMethodBeat.o(85957);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85957);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85957);
    }
  }
  
  public void zoomBy(float paramFloat)
  {
    AppMethodBeat.i(86004);
    try
    {
      this.zoomByfloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(86004);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86004);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86004);
    }
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(86001);
    try
    {
      boolean bool = ((Boolean)this.zoomInMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(86001);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86001);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86001);
    }
    return false;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(86003);
    try
    {
      boolean bool = ((Boolean)this.zoomOutMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(86003);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(86003);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(86003);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkView
 * JD-Core Version:    0.7.0.1
 */