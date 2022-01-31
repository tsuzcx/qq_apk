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
  public static final String TEXTURE_VIEW = "TextureView";
  private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
  private ReflectMethod addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
  private ReflectMethod adjustSelectPositionlongStringintintMethod = new ReflectMethod(null, "adjustSelectPosition", new Class[0]);
  private Object bridge;
  private ReflectMethod canZoomInMethod = new ReflectMethod(null, "canZoomIn", new Class[0]);
  private ReflectMethod canZoomOutMethod = new ReflectMethod(null, "canZoomOut", new Class[0]);
  private ReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod(null, "captureBitmapAsync", new Class[0]);
  private ReflectMethod clearCacheForSingleFileStringMethod = new ReflectMethod(null, "clearCacheForSingleFile", new Class[0]);
  private ReflectMethod clearCachebooleanMethod = new ReflectMethod(null, "clearCache", new Class[0]);
  private ReflectMethod clearClientCertPreferencesRunnableMethod = new ReflectMethod(null, "clearClientCertPreferences", new Class[0]);
  private ReflectMethod clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
  private ReflectMethod clearMatchesMethod = new ReflectMethod(null, "clearMatches", new Class[0]);
  private ReflectMethod clearSslPreferencesMethod = new ReflectMethod(null, "clearSslPreferences", new Class[0]);
  private ReflectMethod computeHorizontalScrollOffsetMethod = new ReflectMethod(null, "computeHorizontalScrollOffset", new Class[0]);
  private ReflectMethod computeHorizontalScrollRangeMethod = new ReflectMethod(null, "computeHorizontalScrollRange", new Class[0]);
  private ReflectMethod computeVerticalScrollExtentMethod = new ReflectMethod(null, "computeVerticalScrollExtent", new Class[0]);
  private ReflectMethod computeVerticalScrollOffsetMethod = new ReflectMethod(null, "computeVerticalScrollOffset", new Class[0]);
  private ReflectMethod computeVerticalScrollRangeMethod = new ReflectMethod(null, "computeVerticalScrollRange", new Class[0]);
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
  private ReflectMethod findAllAsyncStringMethod = new ReflectMethod(null, "findAllAsync", new Class[0]);
  private ReflectMethod findNextbooleanMethod = new ReflectMethod(null, "findNext", new Class[0]);
  private ReflectMethod getAPIVersionMethod = new ReflectMethod(null, "getAPIVersion", new Class[0]);
  private ReflectMethod getCertificateMethod = new ReflectMethod(null, "getCertificate", new Class[0]);
  private ReflectMethod getCompositingSurfaceTypeMethod = new ReflectMethod(null, "getCompositingSurfaceType", new Class[0]);
  private ReflectMethod getContentHeightMethod = new ReflectMethod(null, "getContentHeight", new Class[0]);
  private ReflectMethod getExtensionManagerMethod = new ReflectMethod(null, "getExtensionManager", new Class[0]);
  private ReflectMethod getFaviconMethod = new ReflectMethod(null, "getFavicon", new Class[0]);
  private ReflectMethod getHitTestResultMethod = new ReflectMethod(null, "getHitTestResult", new Class[0]);
  private ReflectMethod getNavigationHistoryMethod = new ReflectMethod(null, "getNavigationHistory", new Class[0]);
  private ReflectMethod getOriginalUrlMethod = new ReflectMethod(null, "getOriginalUrl", new Class[0]);
  private ReflectMethod getRefererUrlMethod = new ReflectMethod(null, "getRefererUrl", new Class[0]);
  private ReflectMethod getRemoteDebuggingUrlMethod = new ReflectMethod(null, "getRemoteDebuggingUrl", new Class[0]);
  private ReflectMethod getScalenMethod = new ReflectMethod(null, "getScale", new Class[0]);
  private ReflectMethod getSettingsMethod = new ReflectMethod(null, "getSettings", new Class[0]);
  private ReflectMethod getTitleMethod = new ReflectMethod(null, "getTitle", new Class[0]);
  private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
  private ReflectMethod getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
  private ReflectMethod getXWalkContentViewMethod = new ReflectMethod(null, "getXWalkContentView", new Class[0]);
  private ReflectMethod getXWalkVersionMethod = new ReflectMethod(null, "getXWalkVersion", new Class[0]);
  private ReflectMethod hasEnteredFullscreenMethod = new ReflectMethod(null, "hasEnteredFullscreen", new Class[0]);
  private ReflectMethod isSupportExtendPluginForAppbrandMethod = new ReflectMethod(null, "isSupportExtendPluginForAppbrand", new Class[0]);
  private ReflectMethod leaveFullscreenMethod = new ReflectMethod(null, "leaveFullscreen", new Class[0]);
  private ReflectMethod loadAppFromManifestStringStringMethod = new ReflectMethod(null, "loadAppFromManifest", new Class[0]);
  private ReflectMethod loadDataStringStringStringMethod = new ReflectMethod(null, "loadData", new Class[0]);
  private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod(null, "loadDataWithBaseURL", new Class[0]);
  private ReflectMethod loadStringStringMapMethod = new ReflectMethod(null, "load", new Class[0]);
  private ReflectMethod loadStringStringMethod = new ReflectMethod(null, "load", new Class[0]);
  private ReflectMethod loadUrlStringMapMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
  private ReflectMethod loadUrlStringMethod = new ReflectMethod(null, "loadUrl", new Class[0]);
  private String mAnimatable;
  private XWalkView.OverScrolledListener mOverScrolledListener;
  private XWalkView.ScrollChangedListener mScrollChangedListener;
  private ReflectMethod onActivityResultintintIntentMethod = new ReflectMethod(null, "onActivityResult", new Class[0]);
  private ReflectMethod onCreateInputConnectionEditorInfoMethod = new ReflectMethod(null, "onCreateInputConnection", new Class[0]);
  private ReflectMethod onDestroyMethod = new ReflectMethod(null, "onDestroy", new Class[0]);
  private ReflectMethod onHideMethod = new ReflectMethod(null, "onHide", new Class[0]);
  private ReflectMethod onNewIntentIntentMethod = new ReflectMethod(null, "onNewIntent", new Class[0]);
  private ReflectMethod onShowMethod = new ReflectMethod(null, "onShow", new Class[0]);
  private ReflectMethod onTouchEventMotionEventMethod = new ReflectMethod(null, "onTouchEvent", new Class[0]);
  private ReflectMethod pauseTimersMethod = new ReflectMethod(null, "pauseTimers", new Class[0]);
  private ReflectMethod postWrapperMethod;
  private ReflectMethod reloadintMethod = new ReflectMethod(null, "reload", new Class[0]);
  private ReflectMethod removeJavascriptInterfaceStringMethod = new ReflectMethod(null, "removeJavascriptInterface", new Class[0]);
  private ReflectMethod restoreStateBundleMethod = new ReflectMethod(null, "restoreState", new Class[0]);
  private ReflectMethod resumeTimersMethod = new ReflectMethod(null, "resumeTimers", new Class[0]);
  private ReflectMethod savePageMethod = new ReflectMethod(null, "savePage", new Class[0]);
  private ReflectMethod saveStateBundleMethod = new ReflectMethod(null, "saveState", new Class[0]);
  private ReflectMethod scrollByintintMethod = new ReflectMethod(null, "scrollBy", new Class[0]);
  private ReflectMethod scrollTointintMethod = new ReflectMethod(null, "scrollTo", new Class[0]);
  private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
  private ReflectMethod setBackgroundColorintMethod = new ReflectMethod(null, "setBackgroundColor", new Class[0]);
  private ReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod(null, "setDownloadListener", new Class[0]);
  private ReflectMethod setExtendPluginClientXWalkExtendPluginClientInternalMethod = new ReflectMethod(null, "setExtendPluginClient", new Class[0]);
  private ReflectMethod setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod(null, "setFindListener", new Class[0]);
  private ReflectMethod setInitialScaleintMethod = new ReflectMethod(null, "setInitialScale", new Class[0]);
  private ReflectMethod setNetworkAvailablebooleanMethod = new ReflectMethod(null, "setNetworkAvailable", new Class[0]);
  private ReflectMethod setOnTouchListenerOnTouchListenerMethod = new ReflectMethod(null, "setOnTouchListener", new Class[0]);
  private ReflectMethod setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod(null, "setOriginAccessWhitelist", new Class[0]);
  private ReflectMethod setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod(null, "setResourceClient", new Class[0]);
  private ReflectMethod setSurfaceViewVisibilityintMethod = new ReflectMethod(null, "setSurfaceViewVisibility", new Class[0]);
  private ReflectMethod setUIClientXWalkUIClientInternalMethod = new ReflectMethod(null, "setUIClient", new Class[0]);
  private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
  private ReflectMethod setXWalkViewInternalVisibilityintMethod = new ReflectMethod(null, "setXWalkViewInternalVisibility", new Class[0]);
  private ReflectMethod setZOrderOnTopbooleanMethod = new ReflectMethod(null, "setZOrderOnTop", new Class[0]);
  private ReflectMethod startActivityForResultIntentintBundleMethod = new ReflectMethod(null, "startActivityForResult", new Class[0]);
  private ReflectMethod stopLoadingMethod = new ReflectMethod(null, "stopLoading", new Class[0]);
  private ReflectMethod zoomByfloatMethod = new ReflectMethod(null, "zoomBy", new Class[0]);
  private ReflectMethod zoomInMethod = new ReflectMethod(null, "zoomIn", new Class[0]);
  private ReflectMethod zoomOutMethod = new ReflectMethod(null, "zoomOut", new Class[0]);
  
  static
  {
    if (!XWalkView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public XWalkView(Context paramContext)
  {
    super(paramContext, null);
    SurfaceView localSurfaceView = new SurfaceView(paramContext);
    localSurfaceView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    addView(localSurfaceView);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add(Context.class);
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramContext);
    this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
    reflectionInit();
  }
  
  @Deprecated
  public XWalkView(Context paramContext, Activity paramActivity)
  {
    super(paramContext, null);
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
  }
  
  public XWalkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
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
  }
  
  private void onFocusChangedDelegate(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  private void onOverScrolledDelegate(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  private void onOverscrollRefresh(boolean paramBoolean)
  {
    if (this.mOverScrolledListener != null) {
      this.mOverScrolledListener.onOverScrolled(paramBoolean);
    }
  }
  
  private boolean onTouchEventDelegate(MotionEvent paramMotionEvent)
  {
    return onTouchEvent(paramMotionEvent);
  }
  
  private boolean performLongClickDelegate()
  {
    return performLongClick();
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    try
    {
      this.addJavascriptInterfaceObjectStringMethod.invoke(new Object[] { paramObject, paramString });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.addJavascriptInterfaceObjectStringMethod.setArguments(new Object[] { paramObject, paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void adjustSelectPosition(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      this.adjustSelectPositionlongStringintintMethod.invoke(new Object[] { Long.valueOf(paramLong), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public boolean canZoomIn()
  {
    try
    {
      boolean bool = ((Boolean)this.canZoomInMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public boolean canZoomOut()
  {
    try
    {
      boolean bool = ((Boolean)this.canZoomOutMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public void captureBitmapAsync(XWalkGetBitmapCallback paramXWalkGetBitmapCallback)
  {
    try
    {
      this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(new Object[] { paramXWalkGetBitmapCallback.getBridge() });
      return;
    }
    catch (UnsupportedOperationException paramXWalkGetBitmapCallback)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkGetBitmapCallback);
    }
  }
  
  public void clearCache(boolean paramBoolean)
  {
    try
    {
      this.clearCachebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void clearCacheForSingleFile(String paramString)
  {
    try
    {
      this.clearCacheForSingleFileStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void clearClientCertPreferences(Runnable paramRunnable)
  {
    try
    {
      this.clearClientCertPreferencesRunnableMethod.invoke(new Object[] { paramRunnable });
      return;
    }
    catch (UnsupportedOperationException paramRunnable)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramRunnable);
    }
  }
  
  public void clearFormData()
  {
    try
    {
      this.clearFormDataMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void clearMatches()
  {
    try
    {
      this.clearMatchesMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void clearSslPreferences()
  {
    try
    {
      this.clearSslPreferencesMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      int i = ((Integer)this.computeHorizontalScrollOffsetMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      int i = ((Integer)this.computeHorizontalScrollRangeMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollExtentMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollOffsetMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      int i = ((Integer)this.computeVerticalScrollRangeMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    try
    {
      this.evaluateJavascriptStringValueCallbackMethod.invoke(new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void findAllAsync(String paramString)
  {
    try
    {
      this.findAllAsyncStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void findNext(boolean paramBoolean)
  {
    try
    {
      this.findNextbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public String getAPIVersion()
  {
    try
    {
      String str = (String)this.getAPIVersionMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public SslCertificate getCertificate()
  {
    try
    {
      SslCertificate localSslCertificate = (SslCertificate)this.getCertificateMethod.invoke(new Object[0]);
      return localSslCertificate;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getCompositingSurfaceType()
  {
    try
    {
      String str = (String)this.getCompositingSurfaceTypeMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public int getContentHeight()
  {
    try
    {
      int i = ((Integer)this.getContentHeightMethod.invoke(new Object[0])).intValue();
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 0;
  }
  
  public XWalkExternalExtensionManager getExtensionManager()
  {
    try
    {
      XWalkExternalExtensionManager localXWalkExternalExtensionManager = (XWalkExternalExtensionManager)this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke(new Object[0]));
      return localXWalkExternalExtensionManager;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public Bitmap getFavicon()
  {
    try
    {
      Bitmap localBitmap = (Bitmap)this.getFaviconMethod.invoke(new Object[0]);
      return localBitmap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public XWalkHitTestResult getHitTestResult()
  {
    try
    {
      XWalkHitTestResult localXWalkHitTestResult = (XWalkHitTestResult)this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke(new Object[0]));
      return localXWalkHitTestResult;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public XWalkNavigationHistory getNavigationHistory()
  {
    try
    {
      XWalkNavigationHistory localXWalkNavigationHistory = (XWalkNavigationHistory)this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke(new Object[0]));
      return localXWalkNavigationHistory;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getOriginalUrl()
  {
    try
    {
      String str = (String)this.getOriginalUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getRefererUrl()
  {
    try
    {
      String str = (String)this.getRefererUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public Uri getRemoteDebuggingUrl()
  {
    try
    {
      Uri localUri = (Uri)this.getRemoteDebuggingUrlMethod.invoke(new Object[0]);
      return localUri;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public float getScale()
  {
    try
    {
      float f = ((Float)this.getScalenMethod.invoke(new Object[0])).floatValue();
      return f;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return 1.0F;
  }
  
  public XWalkSettings getSettings()
  {
    try
    {
      XWalkSettings localXWalkSettings = (XWalkSettings)this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke(new Object[0]));
      return localXWalkSettings;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getTitle()
  {
    try
    {
      String str = (String)this.getTitleMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getUrl()
  {
    try
    {
      String str = (String)this.getUrlMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getUserAgentString()
  {
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public ViewGroup getXWalkContentView()
  {
    try
    {
      ViewGroup localViewGroup = (ViewGroup)this.getXWalkContentViewMethod.invoke(new Object[0]);
      return localViewGroup;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public String getXWalkVersion()
  {
    try
    {
      String str = (String)this.getXWalkVersionMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return null;
  }
  
  public boolean hasEnteredFullscreen()
  {
    try
    {
      boolean bool = ((Boolean)this.hasEnteredFullscreenMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    try
    {
      boolean bool = ((Boolean)this.isSupportExtendPluginForAppbrandMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public void leaveFullscreen()
  {
    try
    {
      this.leaveFullscreenMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2)
  {
    try
    {
      this.loadStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
  }
  
  @Deprecated
  public void load(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      this.loadStringStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramMap });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
  }
  
  public void loadAppFromManifest(String paramString1, String paramString2)
  {
    try
    {
      this.loadAppFromManifestStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.loadDataStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 });
      return;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
  }
  
  public void loadUrl(String paramString)
  {
    try
    {
      this.loadUrlStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    try
    {
      this.loadUrlStringMapMethod.invoke(new Object[] { paramString, paramMap });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  @Deprecated
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      this.onActivityResultintintIntentMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    try
    {
      paramEditorInfo = (InputConnection)this.onCreateInputConnectionEditorInfoMethod.invoke(new Object[] { paramEditorInfo });
      return paramEditorInfo;
    }
    catch (UnsupportedOperationException paramEditorInfo)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramEditorInfo);
    }
    return null;
  }
  
  public void onDestroy()
  {
    try
    {
      this.onDestroyMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void onHide()
  {
    try
    {
      this.onHideMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public boolean onNewIntent(Intent paramIntent)
  {
    try
    {
      boolean bool = ((Boolean)this.onNewIntentIntentMethod.invoke(new Object[] { paramIntent })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
    }
    return false;
  }
  
  public void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mScrollChangedListener != null) {
      this.mScrollChangedListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onShow()
  {
    try
    {
      this.onShowMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = ((Boolean)this.onTouchEventMotionEventMethod.invoke(new Object[] { paramMotionEvent })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramMotionEvent)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramMotionEvent);
    }
    return false;
  }
  
  public void pauseTimers()
  {
    try
    {
      this.pauseTimersMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void postXWalkViewInternalContextActivityConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  public void postXWalkViewInternalContextAttributeSetConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  public void postXWalkViewInternalContextConstructor()
  {
    addView((FrameLayout)this.bridge, new FrameLayout.LayoutParams(-1, -1));
    removeViewAt(0);
    new XWalkExternalExtensionManagerImpl(this);
  }
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
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
      label127:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label127;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      throw new AssertionError();
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), (Class[])localObject1);
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
      this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, null, "setResourceClientSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkResourceClientBridge") });
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
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException) {}
  }
  
  public void reload(int paramInt)
  {
    try
    {
      this.reloadintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    try
    {
      this.removeJavascriptInterfaceStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.removeJavascriptInterfaceStringMethod.setArguments(new Object[] { paramString });
        XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public boolean restoreState(Bundle paramBundle)
  {
    try
    {
      boolean bool = ((Boolean)this.restoreStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
    }
    return false;
  }
  
  public void resumeTimers()
  {
    try
    {
      this.resumeTimersMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      boolean bool = ((Boolean)this.savePageMethod.invoke(new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
    }
    return false;
  }
  
  public boolean saveState(Bundle paramBundle)
  {
    try
    {
      boolean bool = ((Boolean)this.saveStateBundleMethod.invoke(new Object[] { paramBundle })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramBundle)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramBundle);
    }
    return false;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    try
    {
      this.scrollByintintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    try
    {
      this.scrollTointintMethod.invoke(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setAcceptLanguages(String paramString)
  {
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    try
    {
      this.setBackgroundColorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
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
    try
    {
      this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(new Object[] { paramXWalkDownloadListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkDownloadListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setExtendPluginClient(XWalkExtendPluginClient paramXWalkExtendPluginClient)
  {
    try
    {
      this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.invoke(new Object[] { paramXWalkExtendPluginClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setExtendPluginClientXWalkExtendPluginClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkExtendPluginClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setExtendPluginClientXWalkExtendPluginClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setFindListener(XWalkFindListener paramXWalkFindListener)
  {
    try
    {
      this.setFindListenerXWalkFindListenerInternalMethod.invoke(new Object[] { paramXWalkFindListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkFindListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
  }
  
  public void setInitialScale(int paramInt)
  {
    try
    {
      this.setInitialScaleintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setLayerType(int paramInt, Paint paramPaint) {}
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    try
    {
      this.setNetworkAvailablebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    try
    {
      this.setOnTouchListenerOnTouchListenerMethod.invoke(new Object[] { paramOnTouchListener });
      return;
    }
    catch (UnsupportedOperationException paramOnTouchListener)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramOnTouchListener);
    }
  }
  
  public void setOriginAccessWhitelist(String paramString, String[] paramArrayOfString)
  {
    try
    {
      this.setOriginAccessWhitelistStringStringArrayMethod.invoke(new Object[] { paramString, paramArrayOfString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void setResourceClient(XWalkResourceClient paramXWalkResourceClient)
  {
    try
    {
      this.setResourceClientXWalkResourceClientInternalMethod.invoke(new Object[] { paramXWalkResourceClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkResourceClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setSurfaceViewVisibility(int paramInt)
  {
    try
    {
      this.setSurfaceViewVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setSurfaceViewVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setUIClient(XWalkUIClient paramXWalkUIClient)
  {
    try
    {
      this.setUIClientXWalkUIClientInternalMethod.invoke(new Object[] { paramXWalkUIClient.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setUIClientXWalkUIClientInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkUIClient, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 4) {
      i = 8;
    }
    super.setVisibility(i);
    setXWalkViewInternalVisibility(i);
    setSurfaceViewVisibility(i);
  }
  
  public void setXWalkViewInternalVisibility(int paramInt)
  {
    try
    {
      this.setXWalkViewInternalVisibilityintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.setXWalkViewInternalVisibilityintMethod.setArguments(new Object[] { Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void setZOrderOnTop(boolean paramBoolean)
  {
    try
    {
      this.setZOrderOnTopbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    try
    {
      this.startActivityForResultIntentintBundleMethod.invoke(new Object[] { paramIntent, Integer.valueOf(paramInt), paramBundle });
      return;
    }
    catch (UnsupportedOperationException paramIntent)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramIntent);
    }
  }
  
  public void stopLoading()
  {
    try
    {
      this.stopLoadingMethod.invoke(new Object[0]);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void zoomBy(float paramFloat)
  {
    try
    {
      this.zoomByfloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public boolean zoomIn()
  {
    try
    {
      boolean bool = ((Boolean)this.zoomInMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
  
  public boolean zoomOut()
  {
    try
    {
      boolean bool = ((Boolean)this.zoomOutMethod.invoke(new Object[0])).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkView
 * JD-Core Version:    0.7.0.1
 */