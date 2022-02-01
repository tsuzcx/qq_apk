package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkSettings
{
  public static final int InvokeChannel_func_id_log = 30002;
  public static final int InvokeChannel_func_native_trans = 30003;
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NO_CACHE = 2;
  private LazyReflectMethod InvokeChannelInternalMethod;
  private LazyReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod;
  private LazyReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private LazyReflectMethod disableCustomizedLongPressTimeoutVoidMethod;
  private LazyReflectMethod enableCustomizedLongPressTimeoutIntMethod;
  private LazyReflectMethod enumLayoutAlgorithmClassValueOfMethod;
  private LazyReflectMethod getAcceptLanguagesMethod;
  private LazyReflectMethod getAllowContentAccessMethod;
  private LazyReflectMethod getAllowFileAccessFromFileURLsMethod;
  private LazyReflectMethod getAllowFileAccessMethod;
  private LazyReflectMethod getAllowUniversalAccessFromFileURLsMethod;
  private LazyReflectMethod getAppBrandInfoMethod;
  private LazyReflectMethod getAudioPlaybackRequiresUserGestureMethod;
  private LazyReflectMethod getBackgroundAudioPauseMethod;
  private LazyReflectMethod getBlockNetworkImageMethod;
  private LazyReflectMethod getBlockNetworkLoadsMethod;
  private LazyReflectMethod getBuiltInZoomControlsMethod;
  private LazyReflectMethod getCacheModeMethod;
  private LazyReflectMethod getCursiveFontFamilyMethod;
  private LazyReflectMethod getDatabaseEnabledMethod;
  private LazyReflectMethod getDefaultFixedFontSizeMethod;
  private LazyReflectMethod getDefaultFontSizeMethod;
  private LazyReflectMethod getDomStorageEnabledMethod;
  private LazyReflectMethod getFantasyFontFamilyMethod;
  private LazyReflectMethod getFixedFontFamilyMethod;
  private LazyReflectMethod getForceDarkBehaviorMethod;
  private LazyReflectMethod getForceDarkModeMethod;
  private LazyReflectMethod getJavaScriptCanAccessClipboardMethod;
  private LazyReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod;
  private LazyReflectMethod getJavaScriptEnabledMethod;
  private LazyReflectMethod getLayoutAlgorithmMethod;
  private LazyReflectMethod getLoadWithOverviewModeMethod;
  private LazyReflectMethod getLoadsImagesAutomaticallyMethod;
  private LazyReflectMethod getMediaPlaybackRequiresUserGestureMethod;
  private LazyReflectMethod getMinimumFontSizeMethod;
  private LazyReflectMethod getMinimumLogicalFontSizeMethod;
  private LazyReflectMethod getSansSerifFontFamilyMethod;
  private LazyReflectMethod getSaveFormDataMethod;
  private LazyReflectMethod getSerifFontFamilyMethod;
  private LazyReflectMethod getStandardFontFamilyMethod;
  private LazyReflectMethod getSupportQuirksModeMethod;
  private LazyReflectMethod getSupportSpatialNavigationMethod;
  private LazyReflectMethod getTextZoomMethod;
  private LazyReflectMethod getUseWideViewPortMethod;
  private LazyReflectMethod getUserAgentStringMethod;
  private LazyReflectMethod getUsingForAppBrandMethod;
  private LazyReflectMethod getVideoPlaybackRequiresUserGestureMethod;
  private LazyReflectMethod postWrapperMethod;
  private LazyReflectMethod setAcceptLanguagesStringMethod;
  private LazyReflectMethod setAllowContentAccessbooleanMethod;
  private LazyReflectMethod setAllowFileAccessFromFileURLsbooleanMethod;
  private LazyReflectMethod setAllowFileAccessbooleanMethod;
  private LazyReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod;
  private LazyReflectMethod setAppBrandInfoMethod;
  private LazyReflectMethod setAppCacheEnabledbooleanMethod;
  private LazyReflectMethod setAppCachePathStringMethod;
  private LazyReflectMethod setAudioPlaybackRequiresUserGesturebooleanMethod;
  private LazyReflectMethod setBackgroundAudioPauseMethod;
  private LazyReflectMethod setBlockNetworkImagebooleanMethod;
  private LazyReflectMethod setBlockNetworkLoadsbooleanMethod;
  private LazyReflectMethod setBuiltInZoomControlsbooleanMethod;
  private LazyReflectMethod setCacheModeintMethod;
  private LazyReflectMethod setCursiveFontFamilyStringMethod;
  private LazyReflectMethod setDatabaseEnabledbooleanMethod;
  private LazyReflectMethod setDefaultFixedFontSizeintMethod;
  private LazyReflectMethod setDefaultFontSizeintMethod;
  private LazyReflectMethod setDomStorageEnabledbooleanMethod;
  private LazyReflectMethod setFantasyFontFamilyStringMethod;
  private LazyReflectMethod setFixedFontFamilyStringMethod;
  private LazyReflectMethod setForceDarkBehaviorintMethod;
  private LazyReflectMethod setForceDarkModeintMethod;
  private LazyReflectMethod setInitialPageScalefloatMethod;
  private LazyReflectMethod setJavaScriptCanAccessClipboardbooleanMethod;
  private LazyReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
  private LazyReflectMethod setJavaScriptEnabledbooleanMethod;
  private LazyReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod;
  private LazyReflectMethod setLoadWithOverviewModebooleanMethod;
  private LazyReflectMethod setLoadsImagesAutomaticallybooleanMethod;
  private LazyReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod;
  private LazyReflectMethod setMinimumFontSizeIntMethod;
  private LazyReflectMethod setMinimumLogicalFontSizeIntMethod;
  private LazyReflectMethod setSansSerifFontFamilyStringMethod;
  private LazyReflectMethod setSaveFormDatabooleanMethod;
  private LazyReflectMethod setSerifFontFamilyStringMethod;
  private LazyReflectMethod setStandardFontFamilyStringMethod;
  private LazyReflectMethod setSupportMultipleWindowsbooleanMethod;
  private LazyReflectMethod setSupportQuirksModebooleanMethod;
  private LazyReflectMethod setSupportSpatialNavigationbooleanMethod;
  private LazyReflectMethod setSupportZoombooleanMethod;
  private LazyReflectMethod setTextZoomintMethod;
  private LazyReflectMethod setUseWideViewPortbooleanMethod;
  private LazyReflectMethod setUserAgentStringStringMethod;
  private LazyReflectMethod setUsingForAppBrandMethod;
  private LazyReflectMethod setVideoPlaybackRequiresUserGesturebooleanMethod;
  private LazyReflectMethod supportMultipleWindowsMethod;
  private LazyReflectMethod supportZoomMethod;
  private LazyReflectMethod supportsMultiTouchZoomForTestMethod;
  
  public XWalkSettings(Object paramObject)
  {
    AppMethodBeat.i(154863);
    this.enumLayoutAlgorithmClassValueOfMethod = new LazyReflectMethod();
    this.setCacheModeintMethod = new LazyReflectMethod(null, "setCacheMode", new Class[0]);
    this.getCacheModeMethod = new LazyReflectMethod(null, "getCacheMode", new Class[0]);
    this.setForceDarkModeintMethod = new LazyReflectMethod(null, "setForceDarkMode", new Class[0]);
    this.getForceDarkModeMethod = new LazyReflectMethod(null, "getForceDarkMode", new Class[0]);
    this.setForceDarkBehaviorintMethod = new LazyReflectMethod(null, "setForceDarkBehavior", new Class[0]);
    this.getForceDarkBehaviorMethod = new LazyReflectMethod(null, "getForceDarkBehavior", new Class[0]);
    this.setBlockNetworkLoadsbooleanMethod = new LazyReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
    this.getBlockNetworkLoadsMethod = new LazyReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
    this.setAllowFileAccessbooleanMethod = new LazyReflectMethod(null, "setAllowFileAccess", new Class[0]);
    this.getAllowFileAccessMethod = new LazyReflectMethod(null, "getAllowFileAccess", new Class[0]);
    this.setAllowContentAccessbooleanMethod = new LazyReflectMethod(null, "setAllowContentAccess", new Class[0]);
    this.getAllowContentAccessMethod = new LazyReflectMethod(null, "getAllowContentAccess", new Class[0]);
    this.setJavaScriptEnabledbooleanMethod = new LazyReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
    this.setStandardFontFamilyStringMethod = new LazyReflectMethod(null, "setStandardFontFamily", new Class[0]);
    this.setFixedFontFamilyStringMethod = new LazyReflectMethod(null, "setFixedFontFamily", new Class[0]);
    this.setSansSerifFontFamilyStringMethod = new LazyReflectMethod(null, "setSansSerifFontFamily", new Class[0]);
    this.setSerifFontFamilyStringMethod = new LazyReflectMethod(null, "setSerifFontFamily", new Class[0]);
    this.setCursiveFontFamilyStringMethod = new LazyReflectMethod(null, "setCursiveFontFamily", new Class[0]);
    this.setFantasyFontFamilyStringMethod = new LazyReflectMethod(null, "setFantasyFontFamily", new Class[0]);
    this.setMinimumFontSizeIntMethod = new LazyReflectMethod(null, "setMinimumFontSize", new Class[0]);
    this.setMinimumLogicalFontSizeIntMethod = new LazyReflectMethod(null, "setMinimumLogicalFontSize", new Class[0]);
    this.setAllowUniversalAccessFromFileURLsbooleanMethod = new LazyReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
    this.setAllowFileAccessFromFileURLsbooleanMethod = new LazyReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
    this.setLoadsImagesAutomaticallybooleanMethod = new LazyReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
    this.getLoadsImagesAutomaticallyMethod = new LazyReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
    this.setBlockNetworkImagebooleanMethod = new LazyReflectMethod(null, "setBlockNetworkImage", new Class[0]);
    this.getBlockNetworkImageMethod = new LazyReflectMethod(null, "getBlockNetworkImage", new Class[0]);
    this.getJavaScriptEnabledMethod = new LazyReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
    this.getStandardFontFamilyMethod = new LazyReflectMethod(null, "getStandardFontFamily", new Class[0]);
    this.getFixedFontFamilyMethod = new LazyReflectMethod(null, "getFixedFontFamily", new Class[0]);
    this.getSansSerifFontFamilyMethod = new LazyReflectMethod(null, "getSansSerifFontFamily", new Class[0]);
    this.getSerifFontFamilyMethod = new LazyReflectMethod(null, "getSerifFontFamily", new Class[0]);
    this.getCursiveFontFamilyMethod = new LazyReflectMethod(null, "getCursiveFontFamily", new Class[0]);
    this.getFantasyFontFamilyMethod = new LazyReflectMethod(null, "getFantasyFontFamily", new Class[0]);
    this.getMinimumFontSizeMethod = new LazyReflectMethod(null, "getMinimumFontSize", new Class[0]);
    this.getMinimumLogicalFontSizeMethod = new LazyReflectMethod(null, "getMinimumLogicalFontSize", new Class[0]);
    this.getAllowUniversalAccessFromFileURLsMethod = new LazyReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
    this.getAllowFileAccessFromFileURLsMethod = new LazyReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
    this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new LazyReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    this.getJavaScriptCanOpenWindowsAutomaticallyMethod = new LazyReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    this.setJavaScriptCanAccessClipboardbooleanMethod = new LazyReflectMethod(null, "setJavaScriptCanAccessClipboard", new Class[0]);
    this.getJavaScriptCanAccessClipboardMethod = new LazyReflectMethod(null, "getJavaScriptCanAccessClipboard", new Class[0]);
    this.setSupportMultipleWindowsbooleanMethod = new LazyReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
    this.supportMultipleWindowsMethod = new LazyReflectMethod(null, "supportMultipleWindows", new Class[0]);
    this.setUseWideViewPortbooleanMethod = new LazyReflectMethod(null, "setUseWideViewPort", new Class[0]);
    this.getUseWideViewPortMethod = new LazyReflectMethod(null, "getUseWideViewPort", new Class[0]);
    this.setAppCacheEnabledbooleanMethod = new LazyReflectMethod(null, "setAppCacheEnabled", new Class[0]);
    this.setAppCachePathStringMethod = new LazyReflectMethod(null, "setAppCachePath", new Class[0]);
    this.setDomStorageEnabledbooleanMethod = new LazyReflectMethod(null, "setDomStorageEnabled", new Class[0]);
    this.getDomStorageEnabledMethod = new LazyReflectMethod(null, "getDomStorageEnabled", new Class[0]);
    this.setDatabaseEnabledbooleanMethod = new LazyReflectMethod(null, "setDatabaseEnabled", new Class[0]);
    this.getDatabaseEnabledMethod = new LazyReflectMethod(null, "getDatabaseEnabled", new Class[0]);
    this.setMediaPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
    this.getMediaPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
    this.setAudioPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setAudioPlaybackRequiresUserGesture", new Class[0]);
    this.getAudioPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getAudioPlaybackRequiresUserGesture", new Class[0]);
    this.enableCustomizedLongPressTimeoutIntMethod = new LazyReflectMethod(null, "enableCustomizedLongPressTimeout", new Class[0]);
    this.disableCustomizedLongPressTimeoutVoidMethod = new LazyReflectMethod(null, "disableCustomizedLongPressTimeout", new Class[0]);
    this.setVideoPlaybackRequiresUserGesturebooleanMethod = new LazyReflectMethod(null, "setVideoPlaybackRequiresUserGesture", new Class[0]);
    this.getVideoPlaybackRequiresUserGestureMethod = new LazyReflectMethod(null, "getVideoPlaybackRequiresUserGesture", new Class[0]);
    this.setUsingForAppBrandMethod = new LazyReflectMethod(null, "setUsingForAppBrand", new Class[0]);
    this.getUsingForAppBrandMethod = new LazyReflectMethod(null, "getUsingForAppBrand", new Class[0]);
    this.setUserAgentStringStringMethod = new LazyReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new LazyReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new LazyReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.getAcceptLanguagesMethod = new LazyReflectMethod(null, "getAcceptLanguages", new Class[0]);
    this.setSaveFormDatabooleanMethod = new LazyReflectMethod(null, "setSaveFormData", new Class[0]);
    this.getSaveFormDataMethod = new LazyReflectMethod(null, "getSaveFormData", new Class[0]);
    this.setInitialPageScalefloatMethod = new LazyReflectMethod(null, "setInitialPageScale", new Class[0]);
    this.setTextZoomintMethod = new LazyReflectMethod(null, "setTextZoom", new Class[0]);
    this.getTextZoomMethod = new LazyReflectMethod(null, "getTextZoom", new Class[0]);
    this.setDefaultFontSizeintMethod = new LazyReflectMethod(null, "setDefaultFontSize", new Class[0]);
    this.getDefaultFontSizeMethod = new LazyReflectMethod(null, "getDefaultFontSize", new Class[0]);
    this.setDefaultFixedFontSizeintMethod = new LazyReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
    this.getDefaultFixedFontSizeMethod = new LazyReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
    this.setSupportZoombooleanMethod = new LazyReflectMethod(null, "setSupportZoom", new Class[0]);
    this.supportZoomMethod = new LazyReflectMethod(null, "supportZoom", new Class[0]);
    this.setBuiltInZoomControlsbooleanMethod = new LazyReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
    this.getBuiltInZoomControlsMethod = new LazyReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
    this.supportsMultiTouchZoomForTestMethod = new LazyReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);
    this.setSupportSpatialNavigationbooleanMethod = new LazyReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
    this.getSupportSpatialNavigationMethod = new LazyReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
    this.setSupportQuirksModebooleanMethod = new LazyReflectMethod(null, "setSupportQuirksMode", new Class[0]);
    this.getSupportQuirksModeMethod = new LazyReflectMethod(null, "getSupportQuirksMode", new Class[0]);
    this.setLayoutAlgorithmLayoutAlgorithmInternalMethod = new LazyReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
    this.getLayoutAlgorithmMethod = new LazyReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
    this.setLoadWithOverviewModebooleanMethod = new LazyReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
    this.getLoadWithOverviewModeMethod = new LazyReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
    this.SetLogCallBackXWalkLogMessageListenerInternalMethod = new LazyReflectMethod(null, "SetLogCallBack", new Class[0]);
    this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new LazyReflectMethod(null, "SetJSExceptionCallBack", new Class[0]);
    this.setAppBrandInfoMethod = new LazyReflectMethod(null, "setAppBrandInfo", new Class[0]);
    this.getAppBrandInfoMethod = new LazyReflectMethod(null, "getAppBrandInfoSuper", new Class[0]);
    this.setBackgroundAudioPauseMethod = new LazyReflectMethod(null, "setBackgroundAudioPauseSuper", new Class[0]);
    this.getBackgroundAudioPauseMethod = new LazyReflectMethod(null, "getBackgroundAudioPauseSuper", new Class[0]);
    this.InvokeChannelInternalMethod = new LazyReflectMethod(null, "InvokeChannel", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(154863);
  }
  
  private Object ConvertLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154862);
    paramLayoutAlgorithm = this.enumLayoutAlgorithmClassValueOfMethod.invoke(new Object[] { paramLayoutAlgorithm.toString() });
    AppMethodBeat.o(154862);
    return paramLayoutAlgorithm;
  }
  
  public void InvokeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(161641);
    try
    {
      this.InvokeChannelInternalMethod.invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      AppMethodBeat.o(161641);
      return;
    }
    catch (UnsupportedOperationException paramArrayOfObject)
    {
      if (this.coreWrapper == null)
      {
        paramArrayOfObject = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(161641);
        throw paramArrayOfObject;
      }
      XWalkCoreWrapper.handleRuntimeError(paramArrayOfObject);
      AppMethodBeat.o(161641);
    }
  }
  
  public void SetJSExceptionCallBack(XWalkJSExceptionListener paramXWalkJSExceptionListener)
  {
    AppMethodBeat.i(154947);
    try
    {
      this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(new Object[] { paramXWalkJSExceptionListener.getBridge() });
      AppMethodBeat.o(154947);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkJSExceptionListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
        AppMethodBeat.o(154947);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154947);
    }
  }
  
  public void SetLogCallBack(XWalkLogMessageListener paramXWalkLogMessageListener)
  {
    AppMethodBeat.i(154946);
    try
    {
      this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(new Object[] { paramXWalkLogMessageListener.getBridge() });
      AppMethodBeat.o(154946);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new Object[] { new LazyReflectMethod(paramXWalkLogMessageListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
        AppMethodBeat.o(154946);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(154946);
    }
  }
  
  public void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(161642);
    InvokeChannel(30003, new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(161642);
  }
  
  public void disableCustomizedLongPressTimeout()
  {
    AppMethodBeat.i(209700);
    try
    {
      this.disableCustomizedLongPressTimeoutVoidMethod.invoke(new Object[0]);
      AppMethodBeat.o(209700);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209700);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209700);
    }
  }
  
  public void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(209697);
    try
    {
      this.enableCustomizedLongPressTimeoutIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(209697);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209697);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209697);
    }
  }
  
  public String getAcceptLanguages()
  {
    AppMethodBeat.i(154923);
    try
    {
      String str = (String)this.getAcceptLanguagesMethod.invoke(new Object[0]);
      AppMethodBeat.o(154923);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154923);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154923);
    }
    return null;
  }
  
  public boolean getAllowContentAccess()
  {
    AppMethodBeat.i(154875);
    try
    {
      boolean bool = ((Boolean)this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154875);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154875);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154875);
    }
    return false;
  }
  
  public boolean getAllowFileAccess()
  {
    AppMethodBeat.i(154873);
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154873);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154873);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154873);
    }
    return false;
  }
  
  public boolean getAllowFileAccessFromFileURLs()
  {
    AppMethodBeat.i(154901);
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154901);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154901);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154901);
    }
    return false;
  }
  
  public boolean getAllowUniversalAccessFromFileURLs()
  {
    AppMethodBeat.i(154900);
    try
    {
      boolean bool = ((Boolean)this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154900);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154900);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154900);
    }
    return false;
  }
  
  public Map<String, String> getAppBrandInfo()
  {
    AppMethodBeat.i(209756);
    try
    {
      Map localMap = (Map)this.getAppBrandInfoMethod.invoke(new Object[0]);
      AppMethodBeat.o(209756);
      return localMap;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209756);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209756);
    }
    return null;
  }
  
  public boolean getAudioPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(183765);
    try
    {
      boolean bool = ((Boolean)this.getAudioPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(183765);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(183765);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(183765);
    }
    return false;
  }
  
  public boolean getBackgroundAudioPause()
  {
    AppMethodBeat.i(209760);
    try
    {
      boolean bool = ((Boolean)this.getBackgroundAudioPauseMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(209760);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209760);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209760);
    }
    return false;
  }
  
  public boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(154890);
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154890);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154890);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154890);
    }
    return false;
  }
  
  public boolean getBlockNetworkLoads()
  {
    AppMethodBeat.i(154871);
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154871);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154871);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154871);
    }
    return false;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public boolean getBuiltInZoomControls()
  {
    AppMethodBeat.i(154936);
    try
    {
      boolean bool = ((Boolean)this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154936);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154936);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154936);
    }
    return false;
  }
  
  public int getCacheMode()
  {
    AppMethodBeat.i(154865);
    try
    {
      int i = ((Integer)this.getCacheModeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154865);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154865);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154865);
    }
    return 0;
  }
  
  public String getCursiveFontFamily()
  {
    AppMethodBeat.i(154896);
    try
    {
      String str = (String)this.getCursiveFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154896);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154896);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154896);
    }
    return "";
  }
  
  public boolean getDatabaseEnabled()
  {
    AppMethodBeat.i(154913);
    try
    {
      boolean bool = ((Boolean)this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154913);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154913);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154913);
    }
    return false;
  }
  
  public int getDefaultFixedFontSize()
  {
    AppMethodBeat.i(154932);
    try
    {
      int i = ((Integer)this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154932);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154932);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154932);
    }
    return 0;
  }
  
  public int getDefaultFontSize()
  {
    AppMethodBeat.i(154930);
    try
    {
      int i = ((Integer)this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154930);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154930);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154930);
    }
    return 0;
  }
  
  public boolean getDomStorageEnabled()
  {
    AppMethodBeat.i(154911);
    try
    {
      boolean bool = ((Boolean)this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154911);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154911);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154911);
    }
    return false;
  }
  
  public String getFantasyFontFamily()
  {
    AppMethodBeat.i(154897);
    try
    {
      String str = (String)this.getFantasyFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154897);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154897);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154897);
    }
    return "";
  }
  
  public String getFixedFontFamily()
  {
    AppMethodBeat.i(154893);
    try
    {
      String str = (String)this.getFixedFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154893);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154893);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154893);
    }
    return "";
  }
  
  public int getForceDarkBehavior()
  {
    AppMethodBeat.i(154869);
    try
    {
      int i = ((Integer)this.getForceDarkBehaviorMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154869);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154869);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154869);
    }
    return 0;
  }
  
  public int getForceDarkMode()
  {
    AppMethodBeat.i(154867);
    try
    {
      int i = ((Integer)this.getForceDarkModeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154867);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154867);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154867);
    }
    return 0;
  }
  
  public boolean getJavaScriptCanAccessClipboard()
  {
    AppMethodBeat.i(209683);
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptCanAccessClipboardMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(209683);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209683);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209683);
    }
    return true;
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    AppMethodBeat.i(154903);
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154903);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154903);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154903);
    }
    return false;
  }
  
  public boolean getJavaScriptEnabled()
  {
    AppMethodBeat.i(154891);
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154891);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154891);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154891);
    }
    return false;
  }
  
  public XWalkSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    AppMethodBeat.i(154943);
    try
    {
      XWalkSettings.LayoutAlgorithm localLayoutAlgorithm = XWalkSettings.LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
      AppMethodBeat.o(154943);
      return localLayoutAlgorithm;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154943);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154943);
    }
    return null;
  }
  
  public boolean getLoadWithOverviewMode()
  {
    AppMethodBeat.i(154945);
    try
    {
      boolean bool = ((Boolean)this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154945);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154945);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154945);
    }
    return false;
  }
  
  public boolean getLoadsImagesAutomatically()
  {
    AppMethodBeat.i(154888);
    try
    {
      boolean bool = ((Boolean)this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154888);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154888);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154888);
    }
    return false;
  }
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(154915);
    try
    {
      boolean bool = ((Boolean)this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154915);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154915);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154915);
    }
    return false;
  }
  
  public int getMinimumFontSize()
  {
    AppMethodBeat.i(154898);
    try
    {
      int i = ((Integer)this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154898);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154898);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154898);
    }
    return 0;
  }
  
  public int getMinimumLogicalFontSize()
  {
    AppMethodBeat.i(154899);
    try
    {
      int i = ((Integer)this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154899);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154899);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154899);
    }
    return 0;
  }
  
  public String getSansSerifFontFamily()
  {
    AppMethodBeat.i(154894);
    try
    {
      String str = (String)this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154894);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154894);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154894);
    }
    return "";
  }
  
  public boolean getSaveFormData()
  {
    AppMethodBeat.i(154925);
    try
    {
      boolean bool = ((Boolean)this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154925);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154925);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154925);
    }
    return false;
  }
  
  public String getSerifFontFamily()
  {
    AppMethodBeat.i(154895);
    try
    {
      String str = (String)this.getSerifFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154895);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154895);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154895);
    }
    return "";
  }
  
  public String getStandardFontFamily()
  {
    AppMethodBeat.i(154892);
    try
    {
      String str = (String)this.getStandardFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(154892);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154892);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154892);
    }
    return "";
  }
  
  public boolean getSupportQuirksMode()
  {
    AppMethodBeat.i(154941);
    try
    {
      boolean bool = ((Boolean)this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154941);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154941);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154941);
    }
    return false;
  }
  
  public boolean getSupportSpatialNavigation()
  {
    AppMethodBeat.i(154939);
    try
    {
      boolean bool = ((Boolean)this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154939);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154939);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154939);
    }
    return false;
  }
  
  public int getTextZoom()
  {
    AppMethodBeat.i(154928);
    try
    {
      int i = ((Integer)this.getTextZoomMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154928);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154928);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154928);
    }
    return 0;
  }
  
  public boolean getUseWideViewPort()
  {
    AppMethodBeat.i(154907);
    try
    {
      boolean bool = ((Boolean)this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154907);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154907);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154907);
    }
    return false;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(154921);
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      AppMethodBeat.o(154921);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154921);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154921);
    }
    return null;
  }
  
  public int getUsingForAppBrand()
  {
    AppMethodBeat.i(154919);
    try
    {
      int i = ((Integer)this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(154919);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154919);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154919);
    }
    return 0;
  }
  
  public boolean getVideoPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(154917);
    try
    {
      boolean bool = ((Boolean)this.getVideoPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154917);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154917);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154917);
    }
    return false;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154948);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154948);
      return;
    }
    this.enumLayoutAlgorithmClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", new Class[] { String.class });
    this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", new Class[] { Integer.TYPE });
    this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
    this.setForceDarkModeintMethod.init(this.bridge, null, "setForceDarkModeSuper", new Class[] { Integer.TYPE });
    this.getForceDarkModeMethod.init(this.bridge, null, "getForceDarkModeSuper", new Class[0]);
    this.setForceDarkBehaviorintMethod.init(this.bridge, null, "setForceDarkBehaviorSuper", new Class[] { Integer.TYPE });
    this.getForceDarkBehaviorMethod.init(this.bridge, null, "getForceDarkBehaviorSuper", new Class[0]);
    this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, null, "setBlockNetworkLoadsSuper", new Class[] { Boolean.TYPE });
    this.getBlockNetworkLoadsMethod.init(this.bridge, null, "getBlockNetworkLoadsSuper", new Class[0]);
    this.setAllowFileAccessbooleanMethod.init(this.bridge, null, "setAllowFileAccessSuper", new Class[] { Boolean.TYPE });
    this.getAllowFileAccessMethod.init(this.bridge, null, "getAllowFileAccessSuper", new Class[0]);
    this.setAllowContentAccessbooleanMethod.init(this.bridge, null, "setAllowContentAccessSuper", new Class[] { Boolean.TYPE });
    this.getAllowContentAccessMethod.init(this.bridge, null, "getAllowContentAccessSuper", new Class[0]);
    this.setJavaScriptEnabledbooleanMethod.init(this.bridge, null, "setJavaScriptEnabledSuper", new Class[] { Boolean.TYPE });
    this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowUniversalAccessFromFileURLsSuper", new Class[] { Boolean.TYPE });
    this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowFileAccessFromFileURLsSuper", new Class[] { Boolean.TYPE });
    this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, null, "setLoadsImagesAutomaticallySuper", new Class[] { Boolean.TYPE });
    this.getLoadsImagesAutomaticallyMethod.init(this.bridge, null, "getLoadsImagesAutomaticallySuper", new Class[0]);
    this.setBlockNetworkImagebooleanMethod.init(this.bridge, null, "setBlockNetworkImageSuper", new Class[] { Boolean.TYPE });
    this.getBlockNetworkImageMethod.init(this.bridge, null, "getBlockNetworkImageSuper", new Class[0]);
    this.getJavaScriptEnabledMethod.init(this.bridge, null, "getJavaScriptEnabledSuper", new Class[0]);
    this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, null, "getAllowUniversalAccessFromFileURLsSuper", new Class[0]);
    this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, null, "getAllowFileAccessFromFileURLsSuper", new Class[0]);
    this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, null, "setJavaScriptCanOpenWindowsAutomaticallySuper", new Class[] { Boolean.TYPE });
    this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, null, "getJavaScriptCanOpenWindowsAutomaticallySuper", new Class[0]);
    this.setJavaScriptCanAccessClipboardbooleanMethod.init(this.bridge, null, "setJavaScriptCanAccessClipboardSuper", new Class[] { Boolean.TYPE });
    this.getJavaScriptCanAccessClipboardMethod.init(this.bridge, null, "getJavaScriptCanAccessClipboardSuper", new Class[0]);
    this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, null, "setSupportMultipleWindowsSuper", new Class[] { Boolean.TYPE });
    this.supportMultipleWindowsMethod.init(this.bridge, null, "supportMultipleWindowsSuper", new Class[0]);
    this.setUseWideViewPortbooleanMethod.init(this.bridge, null, "setUseWideViewPortSuper", new Class[] { Boolean.TYPE });
    this.getUseWideViewPortMethod.init(this.bridge, null, "getUseWideViewPortSuper", new Class[0]);
    this.setAppCacheEnabledbooleanMethod.init(this.bridge, null, "setAppCacheEnabledSuper", new Class[] { Boolean.TYPE });
    this.setAppCachePathStringMethod.init(this.bridge, null, "setAppCachePathSuper", new Class[] { String.class });
    this.setDomStorageEnabledbooleanMethod.init(this.bridge, null, "setDomStorageEnabledSuper", new Class[] { Boolean.TYPE });
    this.getDomStorageEnabledMethod.init(this.bridge, null, "getDomStorageEnabledSuper", new Class[0]);
    this.setDatabaseEnabledbooleanMethod.init(this.bridge, null, "setDatabaseEnabledSuper", new Class[] { Boolean.TYPE });
    this.getDatabaseEnabledMethod.init(this.bridge, null, "getDatabaseEnabledSuper", new Class[0]);
    this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setMediaPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getMediaPlaybackRequiresUserGestureSuper", new Class[0]);
    this.setAudioPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setAudioPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getAudioPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getAudioPlaybackRequiresUserGestureSuper", new Class[0]);
    this.setVideoPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setVideoPlaybackRequiresUserGestureSuper", new Class[] { Boolean.TYPE });
    this.getVideoPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getVideoPlaybackRequiresUserGestureSuper", new Class[0]);
    this.enableCustomizedLongPressTimeoutIntMethod.init(this.bridge, null, "enableCustomizedLongPressTimeoutSuper", new Class[] { Integer.TYPE });
    this.disableCustomizedLongPressTimeoutVoidMethod.init(this.bridge, null, "disableCustomizedLongPressTimeoutSuper", new Class[0]);
    this.setUsingForAppBrandMethod.init(this.bridge, null, "setUsingForAppBrandSuper", new Class[] { Integer.TYPE });
    this.getUsingForAppBrandMethod.init(this.bridge, null, "getUsingForAppBrandSuper", new Class[0]);
    this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[] { String.class });
    this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
    this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[] { String.class });
    this.getAcceptLanguagesMethod.init(this.bridge, null, "getAcceptLanguagesSuper", new Class[0]);
    this.setSaveFormDatabooleanMethod.init(this.bridge, null, "setSaveFormDataSuper", new Class[] { Boolean.TYPE });
    this.getSaveFormDataMethod.init(this.bridge, null, "getSaveFormDataSuper", new Class[0]);
    this.setInitialPageScalefloatMethod.init(this.bridge, null, "setInitialPageScaleSuper", new Class[] { Float.TYPE });
    this.setTextZoomintMethod.init(this.bridge, null, "setTextZoomSuper", new Class[] { Integer.TYPE });
    this.getTextZoomMethod.init(this.bridge, null, "getTextZoomSuper", new Class[0]);
    this.setDefaultFontSizeintMethod.init(this.bridge, null, "setDefaultFontSizeSuper", new Class[] { Integer.TYPE });
    this.getDefaultFontSizeMethod.init(this.bridge, null, "getDefaultFontSizeSuper", new Class[0]);
    this.setDefaultFixedFontSizeintMethod.init(this.bridge, null, "setDefaultFixedFontSizeSuper", new Class[] { Integer.TYPE });
    this.getDefaultFixedFontSizeMethod.init(this.bridge, null, "getDefaultFixedFontSizeSuper", new Class[0]);
    this.setSupportZoombooleanMethod.init(this.bridge, null, "setSupportZoomSuper", new Class[] { Boolean.TYPE });
    this.supportZoomMethod.init(this.bridge, null, "supportZoomSuper", new Class[0]);
    this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, null, "setBuiltInZoomControlsSuper", new Class[] { Boolean.TYPE });
    this.getBuiltInZoomControlsMethod.init(this.bridge, null, "getBuiltInZoomControlsSuper", new Class[0]);
    this.supportsMultiTouchZoomForTestMethod.init(this.bridge, null, "supportsMultiTouchZoomForTestSuper", new Class[0]);
    this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, null, "setSupportSpatialNavigationSuper", new Class[] { Boolean.TYPE });
    this.getSupportSpatialNavigationMethod.init(this.bridge, null, "getSupportSpatialNavigationSuper", new Class[0]);
    this.setSupportQuirksModebooleanMethod.init(this.bridge, null, "setSupportQuirksModeSuper", new Class[] { Boolean.TYPE });
    this.getSupportQuirksModeMethod.init(this.bridge, null, "getSupportQuirksModeSuper", new Class[0]);
    this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, null, "setLayoutAlgorithmSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal") });
    this.getLayoutAlgorithmMethod.init(this.bridge, null, "getLayoutAlgorithmSuper", new Class[0]);
    this.setLoadWithOverviewModebooleanMethod.init(this.bridge, null, "setLoadWithOverviewModeSuper", new Class[] { Boolean.TYPE });
    this.getLoadWithOverviewModeMethod.init(this.bridge, null, "getLoadWithOverviewModeSuper", new Class[0]);
    this.SetLogCallBackXWalkLogMessageListenerInternalMethod.init(this.bridge, null, "SetLogCallBackSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge") });
    this.setStandardFontFamilyStringMethod.init(this.bridge, null, "setStandardFontFamilySuper", new Class[] { String.class });
    this.setFixedFontFamilyStringMethod.init(this.bridge, null, "setFixedFontFamilySuper", new Class[] { String.class });
    this.setSansSerifFontFamilyStringMethod.init(this.bridge, null, "setSansSerifFontFamilySuper", new Class[] { String.class });
    this.setSerifFontFamilyStringMethod.init(this.bridge, null, "setSerifFontFamilySuper", new Class[] { String.class });
    this.setCursiveFontFamilyStringMethod.init(this.bridge, null, "setCursiveFontFamilySuper", new Class[] { String.class });
    this.setFantasyFontFamilyStringMethod.init(this.bridge, null, "setFantasyFontFamilySuper", new Class[] { String.class });
    this.setMinimumFontSizeIntMethod.init(this.bridge, null, "setMinimumFontSizeSuper", new Class[] { Integer.TYPE });
    this.setMinimumLogicalFontSizeIntMethod.init(this.bridge, null, "setMinimumLogicalFontSizeSuper", new Class[] { Integer.TYPE });
    this.getStandardFontFamilyMethod.init(this.bridge, null, "getStandardFontFamilySuper", new Class[0]);
    this.getFixedFontFamilyMethod.init(this.bridge, null, "getFixedFontFamilySuper", new Class[0]);
    this.getSansSerifFontFamilyMethod.init(this.bridge, null, "getSansSerifFontFamilySuper", new Class[0]);
    this.getSerifFontFamilyMethod.init(this.bridge, null, "getSerifFontFamilySuper", new Class[0]);
    this.getCursiveFontFamilyMethod.init(this.bridge, null, "getCursiveFontFamilySuper", new Class[0]);
    this.getFantasyFontFamilyMethod.init(this.bridge, null, "getFantasyFontFamilySuper", new Class[0]);
    this.getMinimumFontSizeMethod.init(this.bridge, null, "getMinimumFontSizeSuper", new Class[0]);
    this.getMinimumLogicalFontSizeMethod.init(this.bridge, null, "getMinimumLogicalFontSizeSuper", new Class[0]);
    this.getAppBrandInfoMethod.init(this.bridge, null, "getAppBrandInfoSuper", new Class[0]);
    this.setAppBrandInfoMethod.init(this.bridge, null, "setAppBrandInfoSuper", new Class[] { Map.class });
    this.getBackgroundAudioPauseMethod.init(this.bridge, null, "getBackgroundAudioPauseSuper", new Class[0]);
    this.setBackgroundAudioPauseMethod.init(this.bridge, null, "setBackgroundAudioPauseSuper", new Class[] { Boolean.TYPE });
    this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.init(this.bridge, null, "SetJSExceptionCallBackSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkJSExceptionListenerBridge") });
    this.InvokeChannelInternalMethod.init(this.bridge, null, "InvokeChannel", new Class[] { Integer.TYPE, [Ljava.lang.Object.class });
    AppMethodBeat.o(154948);
  }
  
  public void setAcceptLanguages(String paramString)
  {
    AppMethodBeat.i(154922);
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154922);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154922);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154922);
    }
  }
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(154874);
    try
    {
      this.setAllowContentAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154874);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154874);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154874);
    }
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(154872);
    try
    {
      this.setAllowFileAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154872);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154872);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154872);
    }
  }
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(154886);
    try
    {
      this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154886);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154886);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154886);
    }
  }
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(154885);
    try
    {
      this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154885);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154885);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154885);
    }
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(209754);
    try
    {
      this.setAppBrandInfoMethod.invoke(new Object[] { paramMap });
      AppMethodBeat.o(209754);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      if (this.coreWrapper == null)
      {
        paramMap = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209754);
        throw paramMap;
      }
      XWalkCoreWrapper.handleRuntimeError(paramMap);
      AppMethodBeat.o(209754);
    }
  }
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154908);
    try
    {
      this.setAppCacheEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154908);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154908);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154908);
    }
  }
  
  public void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(154909);
    try
    {
      this.setAppCachePathStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154909);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154909);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154909);
    }
  }
  
  public void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(183764);
    try
    {
      this.setAudioPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(183764);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(183764);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(183764);
    }
  }
  
  public void setBackgroundAudioPause(boolean paramBoolean)
  {
    AppMethodBeat.i(209758);
    try
    {
      this.setBackgroundAudioPauseMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(209758);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209758);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209758);
    }
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(154889);
    try
    {
      this.setBlockNetworkImagebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154889);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154889);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154889);
    }
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    AppMethodBeat.i(154870);
    try
    {
      this.setBlockNetworkLoadsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154870);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154870);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154870);
    }
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(154935);
    try
    {
      this.setBuiltInZoomControlsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154935);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154935);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154935);
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    AppMethodBeat.i(154864);
    try
    {
      this.setCacheModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154864);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154864);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154864);
    }
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    AppMethodBeat.i(154881);
    try
    {
      this.setCursiveFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154881);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154881);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154881);
    }
  }
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154912);
    try
    {
      this.setDatabaseEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154912);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154912);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154912);
    }
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    AppMethodBeat.i(154931);
    try
    {
      this.setDefaultFixedFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154931);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154931);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154931);
    }
  }
  
  public void setDefaultFontSize(int paramInt)
  {
    AppMethodBeat.i(154929);
    try
    {
      this.setDefaultFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154929);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154929);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154929);
    }
  }
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154910);
    try
    {
      this.setDomStorageEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154910);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154910);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154910);
    }
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    AppMethodBeat.i(154882);
    try
    {
      this.setFantasyFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154882);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154882);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154882);
    }
  }
  
  public void setFixedFontFamily(String paramString)
  {
    AppMethodBeat.i(154878);
    try
    {
      this.setFixedFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154878);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154878);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154878);
    }
  }
  
  public void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(154868);
    try
    {
      this.setForceDarkBehaviorintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154868);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154868);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154868);
    }
  }
  
  public void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(154866);
    try
    {
      this.setForceDarkModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154866);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154866);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154866);
    }
  }
  
  public void setInitialPageScale(float paramFloat)
  {
    AppMethodBeat.i(154926);
    try
    {
      this.setInitialPageScalefloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(154926);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154926);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154926);
    }
  }
  
  public void setJavaScriptCanAccessClipboard(boolean paramBoolean)
  {
    AppMethodBeat.i(209682);
    try
    {
      this.setJavaScriptCanAccessClipboardbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(209682);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(209682);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(209682);
    }
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154902);
    try
    {
      this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154902);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154902);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154902);
    }
  }
  
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(154876);
    try
    {
      this.setJavaScriptEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154876);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154876);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154876);
    }
  }
  
  public void setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(154942);
    try
    {
      this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(new Object[] { ConvertLayoutAlgorithm(paramLayoutAlgorithm) });
      AppMethodBeat.o(154942);
      return;
    }
    catch (UnsupportedOperationException paramLayoutAlgorithm)
    {
      if (this.coreWrapper == null)
      {
        paramLayoutAlgorithm = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154942);
        throw paramLayoutAlgorithm;
      }
      XWalkCoreWrapper.handleRuntimeError(paramLayoutAlgorithm);
      AppMethodBeat.o(154942);
    }
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(154944);
    try
    {
      this.setLoadWithOverviewModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154944);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154944);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154944);
    }
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(154887);
    try
    {
      this.setLoadsImagesAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154887);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154887);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154887);
    }
  }
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154914);
    try
    {
      this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154914);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154914);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154914);
    }
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    AppMethodBeat.i(154883);
    try
    {
      this.setMinimumFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154883);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154883);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154883);
    }
  }
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    AppMethodBeat.i(154884);
    try
    {
      this.setMinimumLogicalFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154884);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154884);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154884);
    }
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(154879);
    try
    {
      this.setSansSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154879);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154879);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154879);
    }
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    AppMethodBeat.i(154924);
    try
    {
      this.setSaveFormDatabooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154924);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154924);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154924);
    }
  }
  
  public void setSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(154880);
    try
    {
      this.setSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154880);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154880);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154880);
    }
  }
  
  public void setStandardFontFamily(String paramString)
  {
    AppMethodBeat.i(154877);
    try
    {
      this.setStandardFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154877);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154877);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154877);
    }
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(154904);
    try
    {
      this.setSupportMultipleWindowsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154904);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154904);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154904);
    }
  }
  
  public void setSupportQuirksMode(boolean paramBoolean)
  {
    AppMethodBeat.i(154940);
    try
    {
      this.setSupportQuirksModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154940);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154940);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154940);
    }
  }
  
  public void setSupportSpatialNavigation(boolean paramBoolean)
  {
    AppMethodBeat.i(154938);
    try
    {
      this.setSupportSpatialNavigationbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154938);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154938);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154938);
    }
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(154933);
    try
    {
      this.setSupportZoombooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154933);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154933);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154933);
    }
  }
  
  public void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(154927);
    try
    {
      this.setTextZoomintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154927);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154927);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154927);
    }
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(154906);
    try
    {
      this.setUseWideViewPortbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154906);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154906);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154906);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(154920);
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(154920);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154920);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(154920);
    }
  }
  
  public void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(154918);
    try
    {
      this.setUsingForAppBrandMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(154918);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154918);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154918);
    }
  }
  
  public void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(154916);
    try
    {
      this.setVideoPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154916);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154916);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154916);
    }
  }
  
  public boolean supportMultipleWindows()
  {
    AppMethodBeat.i(154905);
    try
    {
      boolean bool = ((Boolean)this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154905);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154905);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154905);
    }
    return false;
  }
  
  public boolean supportZoom()
  {
    AppMethodBeat.i(154934);
    try
    {
      boolean bool = ((Boolean)this.supportZoomMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154934);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154934);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154934);
    }
    return false;
  }
  
  public boolean supportsMultiTouchZoomForTest()
  {
    AppMethodBeat.i(154937);
    try
    {
      boolean bool = ((Boolean)this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(154937);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154937);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(154937);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkSettings
 * JD-Core Version:    0.7.0.1
 */