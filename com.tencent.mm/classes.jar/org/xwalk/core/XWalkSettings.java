package org.xwalk.core;

import java.util.ArrayList;

public class XWalkSettings
{
  public static final int LOAD_CACHE_ELSE_NETWORK = 1;
  public static final int LOAD_CACHE_ONLY = 3;
  public static final int LOAD_DEFAULT = -1;
  public static final int LOAD_NO_CACHE = 2;
  private ReflectMethod SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod = new ReflectMethod(null, "SetJSExceptionCallBack", new Class[0]);
  private ReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod = new ReflectMethod(null, "SetLogCallBack", new Class[0]);
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod enumLayoutAlgorithmClassValueOfMethod = new ReflectMethod();
  private ReflectMethod getAcceptLanguagesMethod = new ReflectMethod(null, "getAcceptLanguages", new Class[0]);
  private ReflectMethod getAllowContentAccessMethod = new ReflectMethod(null, "getAllowContentAccess", new Class[0]);
  private ReflectMethod getAllowFileAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
  private ReflectMethod getAllowFileAccessMethod = new ReflectMethod(null, "getAllowFileAccess", new Class[0]);
  private ReflectMethod getAllowUniversalAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
  private ReflectMethod getBlockNetworkImageMethod = new ReflectMethod(null, "getBlockNetworkImage", new Class[0]);
  private ReflectMethod getBlockNetworkLoadsMethod = new ReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
  private ReflectMethod getBuiltInZoomControlsMethod = new ReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
  private ReflectMethod getCacheModeMethod = new ReflectMethod(null, "getCacheMode", new Class[0]);
  private ReflectMethod getCursiveFontFamilyMethod = new ReflectMethod(null, "getCursiveFontFamily", new Class[0]);
  private ReflectMethod getDatabaseEnabledMethod = new ReflectMethod(null, "getDatabaseEnabled", new Class[0]);
  private ReflectMethod getDefaultFixedFontSizeMethod = new ReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
  private ReflectMethod getDefaultFontSizeMethod = new ReflectMethod(null, "getDefaultFontSize", new Class[0]);
  private ReflectMethod getDomStorageEnabledMethod = new ReflectMethod(null, "getDomStorageEnabled", new Class[0]);
  private ReflectMethod getFantasyFontFamilyMethod = new ReflectMethod(null, "getFantasyFontFamily", new Class[0]);
  private ReflectMethod getFixedFontFamilyMethod = new ReflectMethod(null, "getFixedFontFamily", new Class[0]);
  private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new ReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
  private ReflectMethod getJavaScriptEnabledMethod = new ReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
  private ReflectMethod getLayoutAlgorithmMethod = new ReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
  private ReflectMethod getLoadWithOverviewModeMethod = new ReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
  private ReflectMethod getLoadsImagesAutomaticallyMethod = new ReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
  private ReflectMethod getMediaPlaybackRequiresUserGestureMethod = new ReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
  private ReflectMethod getMinimumFontSizeMethod = new ReflectMethod(null, "getMinimumFontSize", new Class[0]);
  private ReflectMethod getMinimumLogicalFontSizeMethod = new ReflectMethod(null, "getMinimumLogicalFontSize", new Class[0]);
  private ReflectMethod getSansSerifFontFamilyMethod = new ReflectMethod(null, "getSansSerifFontFamily", new Class[0]);
  private ReflectMethod getSaveFormDataMethod = new ReflectMethod(null, "getSaveFormData", new Class[0]);
  private ReflectMethod getSerifFontFamilyMethod = new ReflectMethod(null, "getSerifFontFamily", new Class[0]);
  private ReflectMethod getStandardFontFamilyMethod = new ReflectMethod(null, "getStandardFontFamily", new Class[0]);
  private ReflectMethod getSupportQuirksModeMethod = new ReflectMethod(null, "getSupportQuirksMode", new Class[0]);
  private ReflectMethod getSupportSpatialNavigationMethod = new ReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
  private ReflectMethod getTextZoomMethod = new ReflectMethod(null, "getTextZoom", new Class[0]);
  private ReflectMethod getUseWideViewPortMethod = new ReflectMethod(null, "getUseWideViewPort", new Class[0]);
  private ReflectMethod getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
  private ReflectMethod getUsingForAppBrandMethod = new ReflectMethod(null, "getUsingForAppBrand", new Class[0]);
  private ReflectMethod postWrapperMethod;
  private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
  private ReflectMethod setAllowContentAccessbooleanMethod = new ReflectMethod(null, "setAllowContentAccess", new Class[0]);
  private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
  private ReflectMethod setAllowFileAccessbooleanMethod = new ReflectMethod(null, "setAllowFileAccess", new Class[0]);
  private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
  private ReflectMethod setAppCacheEnabledbooleanMethod = new ReflectMethod(null, "setAppCacheEnabled", new Class[0]);
  private ReflectMethod setAppCachePathStringMethod = new ReflectMethod(null, "setAppCachePath", new Class[0]);
  private ReflectMethod setBlockNetworkImagebooleanMethod = new ReflectMethod(null, "setBlockNetworkImage", new Class[0]);
  private ReflectMethod setBlockNetworkLoadsbooleanMethod = new ReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
  private ReflectMethod setBuiltInZoomControlsbooleanMethod = new ReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
  private ReflectMethod setCacheModeintMethod = new ReflectMethod(null, "setCacheMode", new Class[0]);
  private ReflectMethod setCursiveFontFamilyStringMethod = new ReflectMethod(null, "setCursiveFontFamily", new Class[0]);
  private ReflectMethod setDatabaseEnabledbooleanMethod = new ReflectMethod(null, "setDatabaseEnabled", new Class[0]);
  private ReflectMethod setDefaultFixedFontSizeintMethod = new ReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
  private ReflectMethod setDefaultFontSizeintMethod = new ReflectMethod(null, "setDefaultFontSize", new Class[0]);
  private ReflectMethod setDomStorageEnabledbooleanMethod = new ReflectMethod(null, "setDomStorageEnabled", new Class[0]);
  private ReflectMethod setFantasyFontFamilyStringMethod = new ReflectMethod(null, "setFantasyFontFamily", new Class[0]);
  private ReflectMethod setFixedFontFamilyStringMethod = new ReflectMethod(null, "setFixedFontFamily", new Class[0]);
  private ReflectMethod setInitialPageScalefloatMethod = new ReflectMethod(null, "setInitialPageScale", new Class[0]);
  private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new ReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
  private ReflectMethod setJavaScriptEnabledbooleanMethod = new ReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
  private ReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new ReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
  private ReflectMethod setLoadWithOverviewModebooleanMethod = new ReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
  private ReflectMethod setLoadsImagesAutomaticallybooleanMethod = new ReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
  private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new ReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
  private ReflectMethod setMinimumFontSizeIntMethod = new ReflectMethod(null, "setMinimumFontSize", new Class[0]);
  private ReflectMethod setMinimumLogicalFontSizeIntMethod = new ReflectMethod(null, "setMinimumLogicalFontSize", new Class[0]);
  private ReflectMethod setSansSerifFontFamilyStringMethod = new ReflectMethod(null, "setSansSerifFontFamily", new Class[0]);
  private ReflectMethod setSaveFormDatabooleanMethod = new ReflectMethod(null, "setSaveFormData", new Class[0]);
  private ReflectMethod setSerifFontFamilyStringMethod = new ReflectMethod(null, "setSerifFontFamily", new Class[0]);
  private ReflectMethod setStandardFontFamilyStringMethod = new ReflectMethod(null, "setStandardFontFamily", new Class[0]);
  private ReflectMethod setSupportMultipleWindowsbooleanMethod = new ReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
  private ReflectMethod setSupportQuirksModebooleanMethod = new ReflectMethod(null, "setSupportQuirksMode", new Class[0]);
  private ReflectMethod setSupportSpatialNavigationbooleanMethod = new ReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
  private ReflectMethod setSupportZoombooleanMethod = new ReflectMethod(null, "setSupportZoom", new Class[0]);
  private ReflectMethod setTextZoomintMethod = new ReflectMethod(null, "setTextZoom", new Class[0]);
  private ReflectMethod setUseWideViewPortbooleanMethod = new ReflectMethod(null, "setUseWideViewPort", new Class[0]);
  private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
  private ReflectMethod setUsingForAppBrandMethod = new ReflectMethod(null, "setUsingForAppBrand", new Class[0]);
  private ReflectMethod supportMultipleWindowsMethod = new ReflectMethod(null, "supportMultipleWindows", new Class[0]);
  private ReflectMethod supportZoomMethod = new ReflectMethod(null, "supportZoom", new Class[0]);
  private ReflectMethod supportsMultiTouchZoomForTestMethod = new ReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);
  
  public XWalkSettings(Object paramObject)
  {
    this.bridge = paramObject;
    reflectionInit();
  }
  
  private Object ConvertLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    return this.enumLayoutAlgorithmClassValueOfMethod.invoke(new Object[] { paramLayoutAlgorithm.toString() });
  }
  
  public void SetJSExceptionCallBack(XWalkJSExceptionListener paramXWalkJSExceptionListener)
  {
    try
    {
      this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.invoke(new Object[] { paramXWalkJSExceptionListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkJSExceptionListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetJSExceptionCallBackXWalkJSExceptionListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public void SetLogCallBack(XWalkLogMessageListener paramXWalkLogMessageListener)
  {
    try
    {
      this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(new Object[] { paramXWalkLogMessageListener.getBridge() });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null)
      {
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new Object[] { new ReflectMethod(paramXWalkLogMessageListener, "getBridge", new Class[0]) });
        XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public String getAcceptLanguages()
  {
    try
    {
      String str = (String)this.getAcceptLanguagesMethod.invoke(new Object[0]);
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
  
  public boolean getAllowContentAccess()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowFileAccess()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowFileAccessFromFileURLs()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getAllowUniversalAccessFromFileURLs()
  {
    try
    {
      boolean bool = ((Boolean)this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getBlockNetworkImage()
  {
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getBlockNetworkLoads()
  {
    try
    {
      boolean bool = ((Boolean)this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
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
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public boolean getBuiltInZoomControls()
  {
    try
    {
      boolean bool = ((Boolean)this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getCacheMode()
  {
    try
    {
      int i = ((Integer)this.getCacheModeMethod.invoke(new Object[0])).intValue();
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
  
  public String getCursiveFontFamily()
  {
    try
    {
      String str = (String)this.getCursiveFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public boolean getDatabaseEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getDefaultFixedFontSize()
  {
    try
    {
      int i = ((Integer)this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public int getDefaultFontSize()
  {
    try
    {
      int i = ((Integer)this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getDomStorageEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public String getFantasyFontFamily()
  {
    try
    {
      String str = (String)this.getFantasyFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public String getFixedFontFamily()
  {
    try
    {
      String str = (String)this.getFixedFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getJavaScriptEnabled()
  {
    try
    {
      boolean bool = ((Boolean)this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
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
  
  public XWalkSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    try
    {
      XWalkSettings.LayoutAlgorithm localLayoutAlgorithm = XWalkSettings.LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
      return localLayoutAlgorithm;
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
  
  public boolean getLoadWithOverviewMode()
  {
    try
    {
      boolean bool = ((Boolean)this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getLoadsImagesAutomatically()
  {
    try
    {
      boolean bool = ((Boolean)this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    try
    {
      boolean bool = ((Boolean)this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getMinimumFontSize()
  {
    try
    {
      int i = ((Integer)this.getMinimumFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public int getMinimumLogicalFontSize()
  {
    try
    {
      int i = ((Integer)this.getMinimumLogicalFontSizeMethod.invoke(new Object[0])).intValue();
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
  
  public String getSansSerifFontFamily()
  {
    try
    {
      String str = (String)this.getSansSerifFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public boolean getSaveFormData()
  {
    try
    {
      boolean bool = ((Boolean)this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
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
  
  public String getSerifFontFamily()
  {
    try
    {
      String str = (String)this.getSerifFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public String getStandardFontFamily()
  {
    try
    {
      String str = (String)this.getStandardFontFamilyMethod.invoke(new Object[0]);
      return str;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
    return "";
  }
  
  public boolean getSupportQuirksMode()
  {
    try
    {
      boolean bool = ((Boolean)this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean getSupportSpatialNavigation()
  {
    try
    {
      boolean bool = ((Boolean)this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getTextZoom()
  {
    try
    {
      int i = ((Integer)this.getTextZoomMethod.invoke(new Object[0])).intValue();
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
  
  public boolean getUseWideViewPort()
  {
    try
    {
      boolean bool = ((Boolean)this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
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
  
  public int getUsingForAppBrand()
  {
    try
    {
      int i = ((Integer)this.getUsingForAppBrandMethod.invoke(new Object[0])).intValue();
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
  
  void reflectionInit()
  {
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
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
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    try
    {
      this.setAllowContentAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    try
    {
      this.setAllowFileAccessbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    try
    {
      this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    try
    {
      this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    try
    {
      this.setAppCacheEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setAppCachePath(String paramString)
  {
    try
    {
      this.setAppCachePathStringMethod.invoke(new Object[] { paramString });
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
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    try
    {
      this.setBlockNetworkImagebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    try
    {
      this.setBlockNetworkLoadsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    try
    {
      this.setBuiltInZoomControlsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setCacheMode(int paramInt)
  {
    try
    {
      this.setCacheModeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setCursiveFontFamily(String paramString)
  {
    try
    {
      this.setCursiveFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    try
    {
      this.setDatabaseEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    try
    {
      this.setDefaultFixedFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setDefaultFontSize(int paramInt)
  {
    try
    {
      this.setDefaultFontSizeintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    try
    {
      this.setDomStorageEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setFantasyFontFamily(String paramString)
  {
    try
    {
      this.setFantasyFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setFixedFontFamily(String paramString)
  {
    try
    {
      this.setFixedFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setInitialPageScale(float paramFloat)
  {
    try
    {
      this.setInitialPageScalefloatMethod.invoke(new Object[] { Float.valueOf(paramFloat) });
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
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    try
    {
      this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    try
    {
      this.setJavaScriptEnabledbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    try
    {
      this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(new Object[] { ConvertLayoutAlgorithm(paramLayoutAlgorithm) });
      return;
    }
    catch (UnsupportedOperationException paramLayoutAlgorithm)
    {
      if (this.coreWrapper == null) {
        throw new RuntimeException("Crosswalk's APIs are not ready yet");
      }
      XWalkCoreWrapper.handleRuntimeError(paramLayoutAlgorithm);
    }
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    try
    {
      this.setLoadWithOverviewModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    try
    {
      this.setLoadsImagesAutomaticallybooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    try
    {
      this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setMinimumFontSize(int paramInt)
  {
    try
    {
      this.setMinimumFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    try
    {
      this.setMinimumLogicalFontSizeIntMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setSansSerifFontFamily(String paramString)
  {
    try
    {
      this.setSansSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setSaveFormData(boolean paramBoolean)
  {
    try
    {
      this.setSaveFormDatabooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSerifFontFamily(String paramString)
  {
    try
    {
      this.setSerifFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setStandardFontFamily(String paramString)
  {
    try
    {
      this.setStandardFontFamilyStringMethod.invoke(new Object[] { paramString });
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
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    try
    {
      this.setSupportMultipleWindowsbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportQuirksMode(boolean paramBoolean)
  {
    try
    {
      this.setSupportQuirksModebooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportSpatialNavigation(boolean paramBoolean)
  {
    try
    {
      this.setSupportSpatialNavigationbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setSupportZoom(boolean paramBoolean)
  {
    try
    {
      this.setSupportZoombooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setTextZoom(int paramInt)
  {
    try
    {
      this.setTextZoomintMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    try
    {
      this.setUseWideViewPortbooleanMethod.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void setUsingForAppBrand(int paramInt)
  {
    try
    {
      this.setUsingForAppBrandMethod.invoke(new Object[] { Integer.valueOf(paramInt) });
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
  
  public boolean supportMultipleWindows()
  {
    try
    {
      boolean bool = ((Boolean)this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean supportZoom()
  {
    try
    {
      boolean bool = ((Boolean)this.supportZoomMethod.invoke(new Object[0])).booleanValue();
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
  
  public boolean supportsMultiTouchZoomForTest()
  {
    try
    {
      boolean bool = ((Boolean)this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkSettings
 * JD-Core Version:    0.7.0.1
 */