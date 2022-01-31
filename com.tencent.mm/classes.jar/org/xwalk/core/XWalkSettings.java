package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkSettings
{
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NO_CACHE = 2;
  private ReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod;
  private ReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumLayoutAlgorithmClassValueOfMethod;
  private ReflectMethod getAcceptLanguagesMethod;
  private ReflectMethod getAllowContentAccessMethod;
  private ReflectMethod getAllowFileAccessFromFileURLsMethod;
  private ReflectMethod getAllowFileAccessMethod;
  private ReflectMethod getAllowUniversalAccessFromFileURLsMethod;
  private ReflectMethod getBlockNetworkImageMethod;
  private ReflectMethod getBlockNetworkLoadsMethod;
  private ReflectMethod getBuiltInZoomControlsMethod;
  private ReflectMethod getCacheModeMethod;
  private ReflectMethod getCursiveFontFamilyMethod;
  private ReflectMethod getDatabaseEnabledMethod;
  private ReflectMethod getDefaultFixedFontSizeMethod;
  private ReflectMethod getDefaultFontSizeMethod;
  private ReflectMethod getDomStorageEnabledMethod;
  private ReflectMethod getFantasyFontFamilyMethod;
  private ReflectMethod getFixedFontFamilyMethod;
  private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod;
  private ReflectMethod getJavaScriptEnabledMethod;
  private ReflectMethod getLayoutAlgorithmMethod;
  private ReflectMethod getLoadWithOverviewModeMethod;
  private ReflectMethod getLoadsImagesAutomaticallyMethod;
  private ReflectMethod getMediaPlaybackRequiresUserGestureMethod;
  private ReflectMethod getMinimumFontSizeMethod;
  private ReflectMethod getMinimumLogicalFontSizeMethod;
  private ReflectMethod getSansSerifFontFamilyMethod;
  private ReflectMethod getSaveFormDataMethod;
  private ReflectMethod getSerifFontFamilyMethod;
  private ReflectMethod getStandardFontFamilyMethod;
  private ReflectMethod getSupportQuirksModeMethod;
  private ReflectMethod getSupportSpatialNavigationMethod;
  private ReflectMethod getTextZoomMethod;
  private ReflectMethod getUseWideViewPortMethod;
  private ReflectMethod getUserAgentStringMethod;
  private ReflectMethod getUsingForAppBrandMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setAcceptLanguagesStringMethod;
  private ReflectMethod setAllowContentAccessbooleanMethod;
  private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod;
  private ReflectMethod setAllowFileAccessbooleanMethod;
  private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod;
  private ReflectMethod setAppCacheEnabledbooleanMethod;
  private ReflectMethod setAppCachePathStringMethod;
  private ReflectMethod setBlockNetworkImagebooleanMethod;
  private ReflectMethod setBlockNetworkLoadsbooleanMethod;
  private ReflectMethod setBuiltInZoomControlsbooleanMethod;
  private ReflectMethod setCacheModeintMethod;
  private ReflectMethod setCursiveFontFamilyStringMethod;
  private ReflectMethod setDatabaseEnabledbooleanMethod;
  private ReflectMethod setDefaultFixedFontSizeintMethod;
  private ReflectMethod setDefaultFontSizeintMethod;
  private ReflectMethod setDomStorageEnabledbooleanMethod;
  private ReflectMethod setFantasyFontFamilyStringMethod;
  private ReflectMethod setFixedFontFamilyStringMethod;
  private ReflectMethod setInitialPageScalefloatMethod;
  private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
  private ReflectMethod setJavaScriptEnabledbooleanMethod;
  private ReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod;
  private ReflectMethod setLoadWithOverviewModebooleanMethod;
  private ReflectMethod setLoadsImagesAutomaticallybooleanMethod;
  private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod;
  private ReflectMethod setMinimumFontSizeIntMethod;
  private ReflectMethod setMinimumLogicalFontSizeIntMethod;
  private ReflectMethod setSansSerifFontFamilyStringMethod;
  private ReflectMethod setSaveFormDatabooleanMethod;
  private ReflectMethod setSerifFontFamilyStringMethod;
  private ReflectMethod setStandardFontFamilyStringMethod;
  private ReflectMethod setSupportMultipleWindowsbooleanMethod;
  private ReflectMethod setSupportQuirksModebooleanMethod;
  private ReflectMethod setSupportSpatialNavigationbooleanMethod;
  private ReflectMethod setSupportZoombooleanMethod;
  private ReflectMethod setTextZoomintMethod;
  private ReflectMethod setUseWideViewPortbooleanMethod;
  private ReflectMethod setUserAgentStringStringMethod;
  private ReflectMethod setUsingForAppBrandMethod;
  private ReflectMethod supportMultipleWindowsMethod;
  private ReflectMethod supportZoomMethod;
  private ReflectMethod supportsMultiTouchZoomForTestMethod;
  
  public XWalkSettings(Object paramObject)
  {
    AppMethodBeat.i(85768);
    this.enumLayoutAlgorithmClassValueOfMethod = new ReflectMethod();
    this.setCacheModeintMethod = new ReflectMethod(null, "setCacheMode", new Class[0]);
    this.getCacheModeMethod = new ReflectMethod(null, "getCacheMode", new Class[0]);
    this.setBlockNetworkLoadsbooleanMethod = new ReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
    this.getBlockNetworkLoadsMethod = new ReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
    this.setAllowFileAccessbooleanMethod = new ReflectMethod(null, "setAllowFileAccess", new Class[0]);
    this.getAllowFileAccessMethod = new ReflectMethod(null, "getAllowFileAccess", new Class[0]);
    this.setAllowContentAccessbooleanMethod = new ReflectMethod(null, "setAllowContentAccess", new Class[0]);
    this.getAllowContentAccessMethod = new ReflectMethod(null, "getAllowContentAccess", new Class[0]);
    this.setJavaScriptEnabledbooleanMethod = new ReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
    this.setStandardFontFamilyStringMethod = new ReflectMethod(null, "setStandardFontFamily", new Class[0]);
    this.setFixedFontFamilyStringMethod = new ReflectMethod(null, "setFixedFontFamily", new Class[0]);
    this.setSansSerifFontFamilyStringMethod = new ReflectMethod(null, "setSansSerifFontFamily", new Class[0]);
    this.setSerifFontFamilyStringMethod = new ReflectMethod(null, "setSerifFontFamily", new Class[0]);
    this.setCursiveFontFamilyStringMethod = new ReflectMethod(null, "setCursiveFontFamily", new Class[0]);
    this.setFantasyFontFamilyStringMethod = new ReflectMethod(null, "setFantasyFontFamily", new Class[0]);
    this.setMinimumFontSizeIntMethod = new ReflectMethod(null, "setMinimumFontSize", new Class[0]);
    this.setMinimumLogicalFontSizeIntMethod = new ReflectMethod(null, "setMinimumLogicalFontSize", new Class[0]);
    this.setAllowUniversalAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
    this.setAllowFileAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
    this.setLoadsImagesAutomaticallybooleanMethod = new ReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
    this.getLoadsImagesAutomaticallyMethod = new ReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
    this.setBlockNetworkImagebooleanMethod = new ReflectMethod(null, "setBlockNetworkImage", new Class[0]);
    this.getBlockNetworkImageMethod = new ReflectMethod(null, "getBlockNetworkImage", new Class[0]);
    this.getJavaScriptEnabledMethod = new ReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
    this.getStandardFontFamilyMethod = new ReflectMethod(null, "getStandardFontFamily", new Class[0]);
    this.getFixedFontFamilyMethod = new ReflectMethod(null, "getFixedFontFamily", new Class[0]);
    this.getSansSerifFontFamilyMethod = new ReflectMethod(null, "getSansSerifFontFamily", new Class[0]);
    this.getSerifFontFamilyMethod = new ReflectMethod(null, "getSerifFontFamily", new Class[0]);
    this.getCursiveFontFamilyMethod = new ReflectMethod(null, "getCursiveFontFamily", new Class[0]);
    this.getFantasyFontFamilyMethod = new ReflectMethod(null, "getFantasyFontFamily", new Class[0]);
    this.getMinimumFontSizeMethod = new ReflectMethod(null, "getMinimumFontSize", new Class[0]);
    this.getMinimumLogicalFontSizeMethod = new ReflectMethod(null, "getMinimumLogicalFontSize", new Class[0]);
    this.getAllowUniversalAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
    this.getAllowFileAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
    this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new ReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    this.getJavaScriptCanOpenWindowsAutomaticallyMethod = new ReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    this.setSupportMultipleWindowsbooleanMethod = new ReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
    this.supportMultipleWindowsMethod = new ReflectMethod(null, "supportMultipleWindows", new Class[0]);
    this.setUseWideViewPortbooleanMethod = new ReflectMethod(null, "setUseWideViewPort", new Class[0]);
    this.getUseWideViewPortMethod = new ReflectMethod(null, "getUseWideViewPort", new Class[0]);
    this.setAppCacheEnabledbooleanMethod = new ReflectMethod(null, "setAppCacheEnabled", new Class[0]);
    this.setAppCachePathStringMethod = new ReflectMethod(null, "setAppCachePath", new Class[0]);
    this.setDomStorageEnabledbooleanMethod = new ReflectMethod(null, "setDomStorageEnabled", new Class[0]);
    this.getDomStorageEnabledMethod = new ReflectMethod(null, "getDomStorageEnabled", new Class[0]);
    this.setDatabaseEnabledbooleanMethod = new ReflectMethod(null, "setDatabaseEnabled", new Class[0]);
    this.getDatabaseEnabledMethod = new ReflectMethod(null, "getDatabaseEnabled", new Class[0]);
    this.setMediaPlaybackRequiresUserGesturebooleanMethod = new ReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
    this.getMediaPlaybackRequiresUserGestureMethod = new ReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
    this.setUsingForAppBrandMethod = new ReflectMethod(null, "setUsingForAppBrand", new Class[0]);
    this.getUsingForAppBrandMethod = new ReflectMethod(null, "getUsingForAppBrand", new Class[0]);
    this.setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    this.getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    this.setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    this.getAcceptLanguagesMethod = new ReflectMethod(null, "getAcceptLanguages", new Class[0]);
    this.setSaveFormDatabooleanMethod = new ReflectMethod(null, "setSaveFormData", new Class[0]);
    this.getSaveFormDataMethod = new ReflectMethod(null, "getSaveFormData", new Class[0]);
    this.setInitialPageScalefloatMethod = new ReflectMethod(null, "setInitialPageScale", new Class[0]);
    this.setTextZoomintMethod = new ReflectMethod(null, "setTextZoom", new Class[0]);
    this.getTextZoomMethod = new ReflectMethod(null, "getTextZoom", new Class[0]);
    this.setDefaultFontSizeintMethod = new ReflectMethod(null, "setDefaultFontSize", new Class[0]);
    this.getDefaultFontSizeMethod = new ReflectMethod(null, "getDefaultFontSize", new Class[0]);
    this.setDefaultFixedFontSizeintMethod = new ReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
    this.getDefaultFixedFontSizeMethod = new ReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
    this.setSupportZoombooleanMethod = new ReflectMethod(null, "setSupportZoom", new Class[0]);
    this.supportZoomMethod = new ReflectMethod(null, "supportZoom", new Class[0]);
    this.setBuiltInZoomControlsbooleanMethod = new ReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
    this.getBuiltInZoomControlsMethod = new ReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
    this.supportsMultiTouchZoomForTestMethod = new ReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);
    this.setSupportSpatialNavigationbooleanMethod = new ReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
    this.getSupportSpatialNavigationMethod = new ReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
    this.setSupportQuirksModebooleanMethod = new ReflectMethod(null, "setSupportQuirksMode", new Class[0]);
    this.getSupportQuirksModeMethod = new ReflectMethod(null, "getSupportQuirksMode", new Class[0]);
    this.setLayoutAlgorithmLayoutAlgorithmInternalMethod = new ReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
    this.getLayoutAlgorithmMethod = new ReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
    this.setLoadWithOverviewModebooleanMethod = new ReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
    this.getLoadWithOverviewModeMethod = new ReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
    this.SetLogCallBackXWalkLogMessageListenerInternalMethod = new ReflectMethod(null, "SetLogCallBack", new Class[0]);
    this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new ReflectMethod(null, "SetJSExceptionCallBack", new Class[0]);
    this.bridge = paramObject;
    reflectionInit();
    AppMethodBeat.o(85768);
  }
  
  private Object ConvertLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(85767);
    paramLayoutAlgorithm = this.enumLayoutAlgorithmClassValueOfMethod.invoke(new Object[] { paramLayoutAlgorithm.toString() });
    AppMethodBeat.o(85767);
    return paramLayoutAlgorithm;
  }
  
  public void SetJSExceptionCallBack(XWalkJSExceptionListener paramXWalkJSExceptionListener)
  {
    AppMethodBeat.i(85846);
    try
    {
      this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(new Object[] { paramXWalkJSExceptionListener.getBridge() });
      AppMethodBeat.o(85846);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkJSExceptionListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
        AppMethodBeat.o(85846);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85846);
    }
  }
  
  public void SetLogCallBack(XWalkLogMessageListener paramXWalkLogMessageListener)
  {
    AppMethodBeat.i(85845);
    try
    {
      this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(new Object[] { paramXWalkLogMessageListener.getBridge() });
      AppMethodBeat.o(85845);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkLogMessageListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
        AppMethodBeat.o(85845);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(85845);
    }
  }
  
  public String getAcceptLanguages()
  {
    AppMethodBeat.i(85822);
    try
    {
      String str = (String)this.getAcceptLanguagesMethod.invoke(new Object[0]);
      AppMethodBeat.o(85822);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85822);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85822);
    }
    return null;
  }
  
  public boolean getAllowContentAccess()
  {
    AppMethodBeat.i(85776);
    try
    {
      boolean bool = ((Boolean)this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85776);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85776);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85776);
    }
    return false;
  }
  
  public boolean getAllowFileAccess()
  {
    AppMethodBeat.i(85774);
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85774);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85774);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85774);
    }
    return false;
  }
  
  public boolean getAllowFileAccessFromFileURLs()
  {
    AppMethodBeat.i(85802);
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85802);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85802);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85802);
    }
    return false;
  }
  
  public boolean getAllowUniversalAccessFromFileURLs()
  {
    AppMethodBeat.i(85801);
    try
    {
      boolean bool = ((Boolean)this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85801);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85801);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85801);
    }
    return false;
  }
  
  public boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(85791);
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85791);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85791);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85791);
    }
    return false;
  }
  
  public boolean getBlockNetworkLoads()
  {
    AppMethodBeat.i(85772);
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85772);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85772);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85772);
    }
    return false;
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public boolean getBuiltInZoomControls()
  {
    AppMethodBeat.i(85835);
    try
    {
      boolean bool = ((Boolean)this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85835);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85835);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85835);
    }
    return false;
  }
  
  public int getCacheMode()
  {
    AppMethodBeat.i(85770);
    try
    {
      int i = ((Integer)this.getCacheModeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85770);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85770);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85770);
    }
    return 0;
  }
  
  public String getCursiveFontFamily()
  {
    AppMethodBeat.i(85797);
    try
    {
      String str = (String)this.getCursiveFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85797);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85797);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85797);
    }
    return "";
  }
  
  public boolean getDatabaseEnabled()
  {
    AppMethodBeat.i(85814);
    try
    {
      boolean bool = ((Boolean)this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85814);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85814);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85814);
    }
    return false;
  }
  
  public int getDefaultFixedFontSize()
  {
    AppMethodBeat.i(85831);
    try
    {
      int i = ((Integer)this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85831);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85831);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85831);
    }
    return 0;
  }
  
  public int getDefaultFontSize()
  {
    AppMethodBeat.i(85829);
    try
    {
      int i = ((Integer)this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85829);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85829);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85829);
    }
    return 0;
  }
  
  public boolean getDomStorageEnabled()
  {
    AppMethodBeat.i(85812);
    try
    {
      boolean bool = ((Boolean)this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85812);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85812);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85812);
    }
    return false;
  }
  
  public String getFantasyFontFamily()
  {
    AppMethodBeat.i(85798);
    try
    {
      String str = (String)this.getFantasyFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85798);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85798);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85798);
    }
    return "";
  }
  
  public String getFixedFontFamily()
  {
    AppMethodBeat.i(85794);
    try
    {
      String str = (String)this.getFixedFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85794);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85794);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85794);
    }
    return "";
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    AppMethodBeat.i(85804);
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85804);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85804);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85804);
    }
    return false;
  }
  
  public boolean getJavaScriptEnabled()
  {
    AppMethodBeat.i(85792);
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85792);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85792);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85792);
    }
    return false;
  }
  
  public XWalkSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    AppMethodBeat.i(85842);
    try
    {
      XWalkSettings.LayoutAlgorithm localLayoutAlgorithm = XWalkSettings.LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
      AppMethodBeat.o(85842);
      return localLayoutAlgorithm;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85842);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85842);
    }
    return null;
  }
  
  public boolean getLoadWithOverviewMode()
  {
    AppMethodBeat.i(85844);
    try
    {
      boolean bool = ((Boolean)this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85844);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85844);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85844);
    }
    return false;
  }
  
  public boolean getLoadsImagesAutomatically()
  {
    AppMethodBeat.i(85789);
    try
    {
      boolean bool = ((Boolean)this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85789);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85789);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85789);
    }
    return false;
  }
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(85816);
    try
    {
      boolean bool = ((Boolean)this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85816);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85816);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85816);
    }
    return false;
  }
  
  public int getMinimumFontSize()
  {
    AppMethodBeat.i(85799);
    try
    {
      int i = ((Integer)this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85799);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85799);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85799);
    }
    return 0;
  }
  
  public int getMinimumLogicalFontSize()
  {
    AppMethodBeat.i(85800);
    try
    {
      int i = ((Integer)this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85800);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85800);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85800);
    }
    return 0;
  }
  
  public String getSansSerifFontFamily()
  {
    AppMethodBeat.i(85795);
    try
    {
      String str = (String)this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85795);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85795);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85795);
    }
    return "";
  }
  
  public boolean getSaveFormData()
  {
    AppMethodBeat.i(85824);
    try
    {
      boolean bool = ((Boolean)this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85824);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85824);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85824);
    }
    return false;
  }
  
  public String getSerifFontFamily()
  {
    AppMethodBeat.i(85796);
    try
    {
      String str = (String)this.getSerifFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85796);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85796);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85796);
    }
    return "";
  }
  
  public String getStandardFontFamily()
  {
    AppMethodBeat.i(85793);
    try
    {
      String str = (String)this.getStandardFontFamilyMethod.invoke(new Object[0]);
      AppMethodBeat.o(85793);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85793);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85793);
    }
    return "";
  }
  
  public boolean getSupportQuirksMode()
  {
    AppMethodBeat.i(85840);
    try
    {
      boolean bool = ((Boolean)this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85840);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85840);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85840);
    }
    return false;
  }
  
  public boolean getSupportSpatialNavigation()
  {
    AppMethodBeat.i(85838);
    try
    {
      boolean bool = ((Boolean)this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85838);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85838);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85838);
    }
    return false;
  }
  
  public int getTextZoom()
  {
    AppMethodBeat.i(85827);
    try
    {
      int i = ((Integer)this.getTextZoomMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85827);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85827);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85827);
    }
    return 0;
  }
  
  public boolean getUseWideViewPort()
  {
    AppMethodBeat.i(85808);
    try
    {
      boolean bool = ((Boolean)this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85808);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85808);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85808);
    }
    return false;
  }
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(85820);
    try
    {
      String str = (String)this.getUserAgentStringMethod.invoke(new Object[0]);
      AppMethodBeat.o(85820);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85820);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85820);
    }
    return null;
  }
  
  public int getUsingForAppBrand()
  {
    AppMethodBeat.i(85818);
    try
    {
      int i = ((Integer)this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
      AppMethodBeat.o(85818);
      return i;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85818);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85818);
    }
    return 0;
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(85847);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(85847);
      return;
    }
    this.enumLayoutAlgorithmClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", new Class[] { String.class });
    this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", new Class[] { Integer.TYPE });
    this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
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
    this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.init(this.bridge, null, "SetJSExceptionCallBackSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkJSExceptionListenerBridge") });
    AppMethodBeat.o(85847);
  }
  
  public void setAcceptLanguages(String paramString)
  {
    AppMethodBeat.i(85821);
    try
    {
      this.setAcceptLanguagesStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85821);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85821);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85821);
    }
  }
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(85775);
    try
    {
      this.setAllowContentAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85775);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85775);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85775);
    }
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(85773);
    try
    {
      this.setAllowFileAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85773);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85773);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85773);
    }
  }
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(85787);
    try
    {
      this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85787);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85787);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85787);
    }
  }
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(85786);
    try
    {
      this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85786);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85786);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85786);
    }
  }
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85809);
    try
    {
      this.setAppCacheEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85809);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85809);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85809);
    }
  }
  
  public void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(85810);
    try
    {
      this.setAppCachePathStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85810);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85810);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85810);
    }
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(85790);
    try
    {
      this.setBlockNetworkImagebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85790);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85790);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85790);
    }
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    AppMethodBeat.i(85771);
    try
    {
      this.setBlockNetworkLoadsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85771);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85771);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85771);
    }
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(85834);
    try
    {
      this.setBuiltInZoomControlsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85834);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85834);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85834);
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    AppMethodBeat.i(85769);
    try
    {
      this.setCacheModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85769);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85769);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85769);
    }
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    AppMethodBeat.i(85782);
    try
    {
      this.setCursiveFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85782);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85782);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85782);
    }
  }
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85813);
    try
    {
      this.setDatabaseEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85813);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85813);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85813);
    }
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    AppMethodBeat.i(85830);
    try
    {
      this.setDefaultFixedFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85830);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85830);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85830);
    }
  }
  
  public void setDefaultFontSize(int paramInt)
  {
    AppMethodBeat.i(85828);
    try
    {
      this.setDefaultFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85828);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85828);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85828);
    }
  }
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85811);
    try
    {
      this.setDomStorageEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85811);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85811);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85811);
    }
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    AppMethodBeat.i(85783);
    try
    {
      this.setFantasyFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85783);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85783);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85783);
    }
  }
  
  public void setFixedFontFamily(String paramString)
  {
    AppMethodBeat.i(85779);
    try
    {
      this.setFixedFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85779);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85779);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85779);
    }
  }
  
  public void setInitialPageScale(float paramFloat)
  {
    AppMethodBeat.i(85825);
    try
    {
      this.setInitialPageScalefloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(85825);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85825);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85825);
    }
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(85803);
    try
    {
      this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85803);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85803);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85803);
    }
  }
  
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(85777);
    try
    {
      this.setJavaScriptEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85777);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85777);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85777);
    }
  }
  
  public void setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(85841);
    try
    {
      this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(new Object[] { ConvertLayoutAlgorithm(paramLayoutAlgorithm) });
      AppMethodBeat.o(85841);
      return;
    }
    catch (UnsupportedOperationException paramLayoutAlgorithm)
    {
      if (this.coreWrapper == null)
      {
        paramLayoutAlgorithm = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85841);
        throw paramLayoutAlgorithm;
      }
      XWalkCoreWrapper.handleRuntimeError(paramLayoutAlgorithm);
      AppMethodBeat.o(85841);
    }
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(85843);
    try
    {
      this.setLoadWithOverviewModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85843);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85843);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85843);
    }
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(85788);
    try
    {
      this.setLoadsImagesAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85788);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85788);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85788);
    }
  }
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(85815);
    try
    {
      this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85815);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85815);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85815);
    }
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    AppMethodBeat.i(85784);
    try
    {
      this.setMinimumFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85784);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85784);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85784);
    }
  }
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    AppMethodBeat.i(85785);
    try
    {
      this.setMinimumLogicalFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85785);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85785);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85785);
    }
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(85780);
    try
    {
      this.setSansSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85780);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85780);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85780);
    }
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    AppMethodBeat.i(85823);
    try
    {
      this.setSaveFormDatabooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85823);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85823);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85823);
    }
  }
  
  public void setSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(85781);
    try
    {
      this.setSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85781);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85781);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85781);
    }
  }
  
  public void setStandardFontFamily(String paramString)
  {
    AppMethodBeat.i(85778);
    try
    {
      this.setStandardFontFamilyStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85778);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85778);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85778);
    }
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(85805);
    try
    {
      this.setSupportMultipleWindowsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85805);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85805);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85805);
    }
  }
  
  public void setSupportQuirksMode(boolean paramBoolean)
  {
    AppMethodBeat.i(85839);
    try
    {
      this.setSupportQuirksModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85839);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85839);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85839);
    }
  }
  
  public void setSupportSpatialNavigation(boolean paramBoolean)
  {
    AppMethodBeat.i(85837);
    try
    {
      this.setSupportSpatialNavigationbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85837);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85837);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85837);
    }
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(85832);
    try
    {
      this.setSupportZoombooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85832);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85832);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85832);
    }
  }
  
  public void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(85826);
    try
    {
      this.setTextZoomintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85826);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85826);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85826);
    }
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(85807);
    try
    {
      this.setUseWideViewPortbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(85807);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85807);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85807);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(85819);
    try
    {
      this.setUserAgentStringStringMethod.invoke(new Object[] { paramString });
      AppMethodBeat.o(85819);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (this.coreWrapper == null)
      {
        paramString = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85819);
        throw paramString;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString);
      AppMethodBeat.o(85819);
    }
  }
  
  public void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(85817);
    try
    {
      this.setUsingForAppBrandMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(85817);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85817);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85817);
    }
  }
  
  public boolean supportMultipleWindows()
  {
    AppMethodBeat.i(85806);
    try
    {
      boolean bool = ((Boolean)this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85806);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85806);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85806);
    }
    return false;
  }
  
  public boolean supportZoom()
  {
    AppMethodBeat.i(85833);
    try
    {
      boolean bool = ((Boolean)this.supportZoomMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85833);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85833);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85833);
    }
    return false;
  }
  
  public boolean supportsMultiTouchZoomForTest()
  {
    AppMethodBeat.i(85836);
    try
    {
      boolean bool = ((Boolean)this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(85836);
      return bool;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      RuntimeException localRuntimeException;
      if (this.coreWrapper == null)
      {
        localRuntimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(85836);
        throw localRuntimeException;
      }
      XWalkCoreWrapper.handleRuntimeError(localRuntimeException);
      AppMethodBeat.o(85836);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkSettings
 * JD-Core Version:    0.7.0.1
 */