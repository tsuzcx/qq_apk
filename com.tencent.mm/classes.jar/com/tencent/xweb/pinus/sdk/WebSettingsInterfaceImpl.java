package com.tencent.xweb.pinus.sdk;

import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.xwalk.core.ReflectMethod;

public class WebSettingsInterfaceImpl
  implements WebSettingsInterface
{
  private static final String TAG = "WebSettingsInterfaceImpl";
  private ReflectMethod disableCustomizedLongPressTimeoutMethod;
  private ReflectMethod enableCustomizedLongPressTimeoutintMethod;
  private ReflectMethod getAllowContentAccessMethod;
  private ReflectMethod getAllowFileAccessFromFileURLsMethod;
  private ReflectMethod getAllowFileAccessMethod;
  private ReflectMethod getAllowUniversalAccessFromFileURLsMethod;
  private ReflectMethod getAppBrandInfoMethod;
  private ReflectMethod getAudioPlaybackRequiresUserGestureMethod;
  private ReflectMethod getBackgroundAudioPauseMethod;
  private ReflectMethod getBlockNetworkImageMethod;
  private ReflectMethod getBlockNetworkLoadsMethod;
  private ReflectMethod getBuiltInZoomControlsMethod;
  private ReflectMethod getCacheModeMethod;
  private ReflectMethod getCursiveFontFamilyMethod;
  private ReflectMethod getDatabaseEnabledMethod;
  private ReflectMethod getDatabasePathMethod;
  private ReflectMethod getDefaultFixedFontSizeMethod;
  private ReflectMethod getDefaultFontSizeMethod;
  private ReflectMethod getDefaultTextEncodingNameMethod;
  private ReflectMethod getDisabledActionModeMenuItemsMethod;
  private ReflectMethod getDisplayZoomControlsMethod;
  private ReflectMethod getDomStorageEnabledMethod;
  private ReflectMethod getFantasyFontFamilyMethod;
  private ReflectMethod getFixedFontFamilyMethod;
  private ReflectMethod getForceDarkBehaviorMethod;
  private ReflectMethod getForceDarkMethod;
  private ReflectMethod getForceDarkModeMethod;
  private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod;
  private ReflectMethod getJavaScriptEnabledMethod;
  private ReflectMethod getJavascriptCanAccessClipboardMethod;
  private ReflectMethod getLayoutAlgorithmMethod;
  private ReflectMethod getLoadWithOverviewModeMethod;
  private ReflectMethod getLoadsImagesAutomaticallyMethod;
  private ReflectMethod getMediaPlaybackRequiresUserGestureMethod;
  private ReflectMethod getMinimumFontSizeMethod;
  private ReflectMethod getMinimumLogicalFontSizeMethod;
  private ReflectMethod getMixedContentModeMethod;
  private ReflectMethod getOffscreenPreRasterMethod;
  private ReflectMethod getSansSerifFontFamilyMethod;
  private ReflectMethod getSaveFormDataMethod;
  private ReflectMethod getSavePasswordMethod;
  private ReflectMethod getSerifFontFamilyMethod;
  private ReflectMethod getStandardFontFamilyMethod;
  private ReflectMethod getTextZoomMethod;
  private ReflectMethod getUseWideViewPortMethod;
  private ReflectMethod getUserAgentStringMethod;
  private ReflectMethod getUsingForAppBrandMethod;
  private ReflectMethod getVideoPlaybackRequiresUserGestureMethod;
  private Object inner;
  private ReflectMethod setAllowContentAccessbooleanMethod;
  private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod;
  private ReflectMethod setAllowFileAccessbooleanMethod;
  private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod;
  private ReflectMethod setAppBrandInfoMapStringStringMethod;
  private ReflectMethod setAppCacheEnabledbooleanMethod;
  private ReflectMethod setAppCacheMaxSizelongMethod;
  private ReflectMethod setAppCachePathStringMethod;
  private ReflectMethod setAudioPlaybackRequiresUserGesturebooleanMethod;
  private ReflectMethod setBackgroundAudioPausebooleanMethod;
  private ReflectMethod setBlockNetworkImagebooleanMethod;
  private ReflectMethod setBlockNetworkLoadsbooleanMethod;
  private ReflectMethod setBuiltInZoomControlsbooleanMethod;
  private ReflectMethod setCacheModeintMethod;
  private ReflectMethod setCursiveFontFamilyStringMethod;
  private ReflectMethod setDatabaseEnabledbooleanMethod;
  private ReflectMethod setDatabasePathStringMethod;
  private ReflectMethod setDefaultFixedFontSizeintMethod;
  private ReflectMethod setDefaultFontSizeintMethod;
  private ReflectMethod setDefaultTextEncodingNameStringMethod;
  private ReflectMethod setDisabledActionModeMenuItemsintMethod;
  private ReflectMethod setDisplayZoomControlsbooleanMethod;
  private ReflectMethod setDomStorageEnabledbooleanMethod;
  private ReflectMethod setFantasyFontFamilyStringMethod;
  private ReflectMethod setFixedFontFamilyStringMethod;
  private ReflectMethod setForceDarkBehaviorintMethod;
  private ReflectMethod setForceDarkModeintMethod;
  private ReflectMethod setForceDarkintMethod;
  private ReflectMethod setGeolocationEnabledbooleanMethod;
  private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
  private ReflectMethod setJavaScriptEnabledbooleanMethod;
  private ReflectMethod setJavascriptCanAccessClipboardbooleanMethod;
  private ReflectMethod setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod;
  private ReflectMethod setLoadWithOverviewModebooleanMethod;
  private ReflectMethod setLoadsImagesAutomaticallybooleanMethod;
  private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod;
  private ReflectMethod setMinimumFontSizeintMethod;
  private ReflectMethod setMinimumLogicalFontSizeintMethod;
  private ReflectMethod setMixedContentModeintMethod;
  private ReflectMethod setNeedInitialFocusbooleanMethod;
  private ReflectMethod setOffscreenPreRasterbooleanMethod;
  private ReflectMethod setSansSerifFontFamilyStringMethod;
  private ReflectMethod setSaveFormDatabooleanMethod;
  private ReflectMethod setSavePasswordbooleanMethod;
  private ReflectMethod setSerifFontFamilyStringMethod;
  private ReflectMethod setStandardFontFamilyStringMethod;
  private ReflectMethod setSupportMultipleWindowsbooleanMethod;
  private ReflectMethod setSupportZoombooleanMethod;
  private ReflectMethod setTextZoomintMethod;
  private ReflectMethod setUseWideViewPortbooleanMethod;
  private ReflectMethod setUserAgentStringStringMethod;
  private ReflectMethod setUsingForAppBrandintMethod;
  private ReflectMethod setVideoPlaybackRequiresUserGesturebooleanMethod;
  private ReflectMethod supportMultipleWindowsMethod;
  private ReflectMethod supportZoomMethod;
  
  public WebSettingsInterfaceImpl(Object paramObject)
  {
    this.inner = paramObject;
  }
  
  private ReflectMethod getDisableCustomizedLongPressTimeoutMethod()
  {
    try
    {
      AppMethodBeat.i(214303);
      ReflectMethod localReflectMethod2 = this.disableCustomizedLongPressTimeoutMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "disableCustomizedLongPressTimeout", new Class[0]);
        this.disableCustomizedLongPressTimeoutMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214303);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getEnableCustomizedLongPressTimeoutintMethod()
  {
    try
    {
      AppMethodBeat.i(214293);
      ReflectMethod localReflectMethod2 = this.enableCustomizedLongPressTimeoutintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "enableCustomizedLongPressTimeout", new Class[] { Integer.TYPE });
        this.enableCustomizedLongPressTimeoutintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214293);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAllowContentAccessMethod()
  {
    try
    {
      AppMethodBeat.i(213469);
      ReflectMethod localReflectMethod2 = this.getAllowContentAccessMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAllowContentAccess", new Class[0]);
        this.getAllowContentAccessMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213469);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAllowFileAccessFromFileURLsMethod()
  {
    try
    {
      AppMethodBeat.i(213488);
      ReflectMethod localReflectMethod2 = this.getAllowFileAccessFromFileURLsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAllowFileAccessFromFileURLs", new Class[0]);
        this.getAllowFileAccessFromFileURLsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213488);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAllowFileAccessMethod()
  {
    try
    {
      AppMethodBeat.i(213481);
      ReflectMethod localReflectMethod2 = this.getAllowFileAccessMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAllowFileAccess", new Class[0]);
        this.getAllowFileAccessMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213481);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAllowUniversalAccessFromFileURLsMethod()
  {
    try
    {
      AppMethodBeat.i(213493);
      ReflectMethod localReflectMethod2 = this.getAllowUniversalAccessFromFileURLsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAllowUniversalAccessFromFileURLs", new Class[0]);
        this.getAllowUniversalAccessFromFileURLsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213493);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAppBrandInfoMethod()
  {
    try
    {
      AppMethodBeat.i(214198);
      ReflectMethod localReflectMethod2 = this.getAppBrandInfoMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAppBrandInfo", new Class[0]);
        this.getAppBrandInfoMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214198);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetAudioPlaybackRequiresUserGestureMethod()
  {
    try
    {
      AppMethodBeat.i(214259);
      ReflectMethod localReflectMethod2 = this.getAudioPlaybackRequiresUserGestureMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getAudioPlaybackRequiresUserGesture", new Class[0]);
        this.getAudioPlaybackRequiresUserGestureMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214259);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetBackgroundAudioPauseMethod()
  {
    try
    {
      AppMethodBeat.i(214332);
      ReflectMethod localReflectMethod2 = this.getBackgroundAudioPauseMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getBackgroundAudioPause", new Class[0]);
        this.getBackgroundAudioPauseMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214332);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetBlockNetworkImageMethod()
  {
    try
    {
      AppMethodBeat.i(213496);
      ReflectMethod localReflectMethod2 = this.getBlockNetworkImageMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getBlockNetworkImage", new Class[0]);
        this.getBlockNetworkImageMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213496);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetBlockNetworkLoadsMethod()
  {
    try
    {
      AppMethodBeat.i(213501);
      ReflectMethod localReflectMethod2 = this.getBlockNetworkLoadsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getBlockNetworkLoads", new Class[0]);
        this.getBlockNetworkLoadsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213501);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetBuiltInZoomControlsMethod()
  {
    try
    {
      AppMethodBeat.i(213508);
      ReflectMethod localReflectMethod2 = this.getBuiltInZoomControlsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getBuiltInZoomControls", new Class[0]);
        this.getBuiltInZoomControlsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213508);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetCacheModeMethod()
  {
    try
    {
      AppMethodBeat.i(213514);
      ReflectMethod localReflectMethod2 = this.getCacheModeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getCacheMode", new Class[0]);
        this.getCacheModeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213514);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetCursiveFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213522);
      ReflectMethod localReflectMethod2 = this.getCursiveFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getCursiveFontFamily", new Class[0]);
        this.getCursiveFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213522);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDatabaseEnabledMethod()
  {
    try
    {
      AppMethodBeat.i(213529);
      ReflectMethod localReflectMethod2 = this.getDatabaseEnabledMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDatabaseEnabled", new Class[0]);
        this.getDatabaseEnabledMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213529);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDatabasePathMethod()
  {
    try
    {
      AppMethodBeat.i(213537);
      ReflectMethod localReflectMethod2 = this.getDatabasePathMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDatabasePath", new Class[0]);
        this.getDatabasePathMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213537);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDefaultFixedFontSizeMethod()
  {
    try
    {
      AppMethodBeat.i(213544);
      ReflectMethod localReflectMethod2 = this.getDefaultFixedFontSizeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDefaultFixedFontSize", new Class[0]);
        this.getDefaultFixedFontSizeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213544);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDefaultFontSizeMethod()
  {
    try
    {
      AppMethodBeat.i(213554);
      ReflectMethod localReflectMethod2 = this.getDefaultFontSizeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDefaultFontSize", new Class[0]);
        this.getDefaultFontSizeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213554);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDefaultTextEncodingNameMethod()
  {
    try
    {
      AppMethodBeat.i(213563);
      ReflectMethod localReflectMethod2 = this.getDefaultTextEncodingNameMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDefaultTextEncodingName", new Class[0]);
        this.getDefaultTextEncodingNameMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213563);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDisabledActionModeMenuItemsMethod()
  {
    try
    {
      AppMethodBeat.i(213573);
      ReflectMethod localReflectMethod2 = this.getDisabledActionModeMenuItemsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDisabledActionModeMenuItems", new Class[0]);
        this.getDisabledActionModeMenuItemsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213573);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDisplayZoomControlsMethod()
  {
    try
    {
      AppMethodBeat.i(213580);
      ReflectMethod localReflectMethod2 = this.getDisplayZoomControlsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDisplayZoomControls", new Class[0]);
        this.getDisplayZoomControlsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213580);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetDomStorageEnabledMethod()
  {
    try
    {
      AppMethodBeat.i(213589);
      ReflectMethod localReflectMethod2 = this.getDomStorageEnabledMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getDomStorageEnabled", new Class[0]);
        this.getDomStorageEnabledMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213589);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetFantasyFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213596);
      ReflectMethod localReflectMethod2 = this.getFantasyFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getFantasyFontFamily", new Class[0]);
        this.getFantasyFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213596);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetFixedFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213603);
      ReflectMethod localReflectMethod2 = this.getFixedFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getFixedFontFamily", new Class[0]);
        this.getFixedFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213603);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetForceDarkBehaviorMethod()
  {
    try
    {
      AppMethodBeat.i(214239);
      ReflectMethod localReflectMethod2 = this.getForceDarkBehaviorMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getForceDarkBehavior", new Class[0]);
        this.getForceDarkBehaviorMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214239);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetForceDarkMethod()
  {
    try
    {
      AppMethodBeat.i(213612);
      ReflectMethod localReflectMethod2 = this.getForceDarkMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getForceDark", new Class[0]);
        this.getForceDarkMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213612);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetForceDarkModeMethod()
  {
    try
    {
      AppMethodBeat.i(214218);
      ReflectMethod localReflectMethod2 = this.getForceDarkModeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getForceDarkMode", new Class[0]);
        this.getForceDarkModeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214218);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetJavaScriptCanOpenWindowsAutomaticallyMethod()
  {
    try
    {
      AppMethodBeat.i(213621);
      ReflectMethod localReflectMethod2 = this.getJavaScriptCanOpenWindowsAutomaticallyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
        this.getJavaScriptCanOpenWindowsAutomaticallyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213621);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetJavaScriptEnabledMethod()
  {
    try
    {
      AppMethodBeat.i(213632);
      ReflectMethod localReflectMethod2 = this.getJavaScriptEnabledMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getJavaScriptEnabled", new Class[0]);
        this.getJavaScriptEnabledMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213632);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetJavascriptCanAccessClipboardMethod()
  {
    try
    {
      AppMethodBeat.i(214357);
      ReflectMethod localReflectMethod2 = this.getJavascriptCanAccessClipboardMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getJavascriptCanAccessClipboard", new Class[0]);
        this.getJavascriptCanAccessClipboardMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214357);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetLayoutAlgorithmMethod()
  {
    try
    {
      AppMethodBeat.i(213641);
      ReflectMethod localReflectMethod2 = this.getLayoutAlgorithmMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getLayoutAlgorithm", new Class[0]);
        this.getLayoutAlgorithmMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213641);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetLoadWithOverviewModeMethod()
  {
    try
    {
      AppMethodBeat.i(213650);
      ReflectMethod localReflectMethod2 = this.getLoadWithOverviewModeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getLoadWithOverviewMode", new Class[0]);
        this.getLoadWithOverviewModeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213650);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetLoadsImagesAutomaticallyMethod()
  {
    try
    {
      AppMethodBeat.i(213656);
      ReflectMethod localReflectMethod2 = this.getLoadsImagesAutomaticallyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getLoadsImagesAutomatically", new Class[0]);
        this.getLoadsImagesAutomaticallyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213656);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetMediaPlaybackRequiresUserGestureMethod()
  {
    try
    {
      AppMethodBeat.i(213665);
      ReflectMethod localReflectMethod2 = this.getMediaPlaybackRequiresUserGestureMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getMediaPlaybackRequiresUserGesture", new Class[0]);
        this.getMediaPlaybackRequiresUserGestureMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213665);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetMinimumFontSizeMethod()
  {
    try
    {
      AppMethodBeat.i(213676);
      ReflectMethod localReflectMethod2 = this.getMinimumFontSizeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getMinimumFontSize", new Class[0]);
        this.getMinimumFontSizeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213676);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetMinimumLogicalFontSizeMethod()
  {
    try
    {
      AppMethodBeat.i(213684);
      ReflectMethod localReflectMethod2 = this.getMinimumLogicalFontSizeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getMinimumLogicalFontSize", new Class[0]);
        this.getMinimumLogicalFontSizeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213684);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetMixedContentModeMethod()
  {
    try
    {
      AppMethodBeat.i(213691);
      ReflectMethod localReflectMethod2 = this.getMixedContentModeMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getMixedContentMode", new Class[0]);
        this.getMixedContentModeMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213691);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetOffscreenPreRasterMethod()
  {
    try
    {
      AppMethodBeat.i(213698);
      ReflectMethod localReflectMethod2 = this.getOffscreenPreRasterMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getOffscreenPreRaster", new Class[0]);
        this.getOffscreenPreRasterMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213698);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetSansSerifFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213705);
      ReflectMethod localReflectMethod2 = this.getSansSerifFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getSansSerifFontFamily", new Class[0]);
        this.getSansSerifFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213705);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetSaveFormDataMethod()
  {
    try
    {
      AppMethodBeat.i(213714);
      ReflectMethod localReflectMethod2 = this.getSaveFormDataMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getSaveFormData", new Class[0]);
        this.getSaveFormDataMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213714);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetSavePasswordMethod()
  {
    try
    {
      AppMethodBeat.i(213722);
      ReflectMethod localReflectMethod2 = this.getSavePasswordMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getSavePassword", new Class[0]);
        this.getSavePasswordMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213722);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetSerifFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213728);
      ReflectMethod localReflectMethod2 = this.getSerifFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getSerifFontFamily", new Class[0]);
        this.getSerifFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213728);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetStandardFontFamilyMethod()
  {
    try
    {
      AppMethodBeat.i(213736);
      ReflectMethod localReflectMethod2 = this.getStandardFontFamilyMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getStandardFontFamily", new Class[0]);
        this.getStandardFontFamilyMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213736);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetTextZoomMethod()
  {
    try
    {
      AppMethodBeat.i(213749);
      ReflectMethod localReflectMethod2 = this.getTextZoomMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getTextZoom", new Class[0]);
        this.getTextZoomMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213749);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetUseWideViewPortMethod()
  {
    try
    {
      AppMethodBeat.i(213757);
      ReflectMethod localReflectMethod2 = this.getUseWideViewPortMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getUseWideViewPort", new Class[0]);
        this.getUseWideViewPortMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213757);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetUserAgentStringMethod()
  {
    try
    {
      AppMethodBeat.i(213764);
      ReflectMethod localReflectMethod2 = this.getUserAgentStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getUserAgentString", new Class[0]);
        this.getUserAgentStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213764);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetUsingForAppBrandMethod()
  {
    try
    {
      AppMethodBeat.i(214171);
      ReflectMethod localReflectMethod2 = this.getUsingForAppBrandMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getUsingForAppBrand", new Class[0]);
        this.getUsingForAppBrandMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214171);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getGetVideoPlaybackRequiresUserGestureMethod()
  {
    try
    {
      AppMethodBeat.i(214280);
      ReflectMethod localReflectMethod2 = this.getVideoPlaybackRequiresUserGestureMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "getVideoPlaybackRequiresUserGesture", new Class[0]);
        this.getVideoPlaybackRequiresUserGestureMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214280);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAllowContentAccessbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213771);
      ReflectMethod localReflectMethod2 = this.setAllowContentAccessbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAllowContentAccess", new Class[] { Boolean.TYPE });
        this.setAllowContentAccessbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213771);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAllowFileAccessFromFileURLsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213791);
      ReflectMethod localReflectMethod2 = this.setAllowFileAccessFromFileURLsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAllowFileAccessFromFileURLs", new Class[] { Boolean.TYPE });
        this.setAllowFileAccessFromFileURLsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213791);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAllowFileAccessbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213782);
      ReflectMethod localReflectMethod2 = this.setAllowFileAccessbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAllowFileAccess", new Class[] { Boolean.TYPE });
        this.setAllowFileAccessbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213782);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAllowUniversalAccessFromFileURLsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213800);
      ReflectMethod localReflectMethod2 = this.setAllowUniversalAccessFromFileURLsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAllowUniversalAccessFromFileURLs", new Class[] { Boolean.TYPE });
        this.setAllowUniversalAccessFromFileURLsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213800);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAppBrandInfoMapStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(214183);
      ReflectMethod localReflectMethod2 = this.setAppBrandInfoMapStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAppBrandInfo", new Class[] { Map.class });
        this.setAppBrandInfoMapStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214183);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAppCacheEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213808);
      ReflectMethod localReflectMethod2 = this.setAppCacheEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAppCacheEnabled", new Class[] { Boolean.TYPE });
        this.setAppCacheEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213808);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAppCacheMaxSizelongMethod()
  {
    try
    {
      AppMethodBeat.i(213816);
      ReflectMethod localReflectMethod2 = this.setAppCacheMaxSizelongMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAppCacheMaxSize", new Class[] { Long.TYPE });
        this.setAppCacheMaxSizelongMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213816);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAppCachePathStringMethod()
  {
    try
    {
      AppMethodBeat.i(213825);
      ReflectMethod localReflectMethod2 = this.setAppCachePathStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAppCachePath", new Class[] { String.class });
        this.setAppCachePathStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213825);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetAudioPlaybackRequiresUserGesturebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214249);
      ReflectMethod localReflectMethod2 = this.setAudioPlaybackRequiresUserGesturebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setAudioPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE });
        this.setAudioPlaybackRequiresUserGesturebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214249);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBackgroundAudioPausebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214316);
      ReflectMethod localReflectMethod2 = this.setBackgroundAudioPausebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBackgroundAudioPause", new Class[] { Boolean.TYPE });
        this.setBackgroundAudioPausebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214316);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBlockNetworkImagebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213832);
      ReflectMethod localReflectMethod2 = this.setBlockNetworkImagebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBlockNetworkImage", new Class[] { Boolean.TYPE });
        this.setBlockNetworkImagebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213832);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBlockNetworkLoadsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213843);
      ReflectMethod localReflectMethod2 = this.setBlockNetworkLoadsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBlockNetworkLoads", new Class[] { Boolean.TYPE });
        this.setBlockNetworkLoadsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213843);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetBuiltInZoomControlsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213849);
      ReflectMethod localReflectMethod2 = this.setBuiltInZoomControlsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setBuiltInZoomControls", new Class[] { Boolean.TYPE });
        this.setBuiltInZoomControlsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213849);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetCacheModeintMethod()
  {
    try
    {
      AppMethodBeat.i(213856);
      ReflectMethod localReflectMethod2 = this.setCacheModeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setCacheMode", new Class[] { Integer.TYPE });
        this.setCacheModeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213856);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetCursiveFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(213863);
      ReflectMethod localReflectMethod2 = this.setCursiveFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setCursiveFontFamily", new Class[] { String.class });
        this.setCursiveFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213863);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDatabaseEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213872);
      ReflectMethod localReflectMethod2 = this.setDatabaseEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDatabaseEnabled", new Class[] { Boolean.TYPE });
        this.setDatabaseEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213872);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDatabasePathStringMethod()
  {
    try
    {
      AppMethodBeat.i(213878);
      ReflectMethod localReflectMethod2 = this.setDatabasePathStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDatabasePath", new Class[] { String.class });
        this.setDatabasePathStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213878);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDefaultFixedFontSizeintMethod()
  {
    try
    {
      AppMethodBeat.i(213881);
      ReflectMethod localReflectMethod2 = this.setDefaultFixedFontSizeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDefaultFixedFontSize", new Class[] { Integer.TYPE });
        this.setDefaultFixedFontSizeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213881);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDefaultFontSizeintMethod()
  {
    try
    {
      AppMethodBeat.i(213887);
      ReflectMethod localReflectMethod2 = this.setDefaultFontSizeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDefaultFontSize", new Class[] { Integer.TYPE });
        this.setDefaultFontSizeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213887);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDefaultTextEncodingNameStringMethod()
  {
    try
    {
      AppMethodBeat.i(213891);
      ReflectMethod localReflectMethod2 = this.setDefaultTextEncodingNameStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDefaultTextEncodingName", new Class[] { String.class });
        this.setDefaultTextEncodingNameStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213891);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDisabledActionModeMenuItemsintMethod()
  {
    try
    {
      AppMethodBeat.i(213897);
      ReflectMethod localReflectMethod2 = this.setDisabledActionModeMenuItemsintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDisabledActionModeMenuItems", new Class[] { Integer.TYPE });
        this.setDisabledActionModeMenuItemsintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213897);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDisplayZoomControlsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213903);
      ReflectMethod localReflectMethod2 = this.setDisplayZoomControlsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDisplayZoomControls", new Class[] { Boolean.TYPE });
        this.setDisplayZoomControlsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213903);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetDomStorageEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213909);
      ReflectMethod localReflectMethod2 = this.setDomStorageEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setDomStorageEnabled", new Class[] { Boolean.TYPE });
        this.setDomStorageEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213909);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetFantasyFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(213913);
      ReflectMethod localReflectMethod2 = this.setFantasyFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setFantasyFontFamily", new Class[] { String.class });
        this.setFantasyFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213913);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetFixedFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(213918);
      ReflectMethod localReflectMethod2 = this.setFixedFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setFixedFontFamily", new Class[] { String.class });
        this.setFixedFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213918);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetForceDarkBehaviorintMethod()
  {
    try
    {
      AppMethodBeat.i(214231);
      ReflectMethod localReflectMethod2 = this.setForceDarkBehaviorintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setForceDarkBehavior", new Class[] { Integer.TYPE });
        this.setForceDarkBehaviorintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214231);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetForceDarkModeintMethod()
  {
    try
    {
      AppMethodBeat.i(214209);
      ReflectMethod localReflectMethod2 = this.setForceDarkModeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setForceDarkMode", new Class[] { Integer.TYPE });
        this.setForceDarkModeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214209);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetForceDarkintMethod()
  {
    try
    {
      AppMethodBeat.i(213923);
      ReflectMethod localReflectMethod2 = this.setForceDarkintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setForceDark", new Class[] { Integer.TYPE });
        this.setForceDarkintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213923);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetGeolocationEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213931);
      ReflectMethod localReflectMethod2 = this.setGeolocationEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setGeolocationEnabled", new Class[] { Boolean.TYPE });
        this.setGeolocationEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213931);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetJavaScriptCanOpenWindowsAutomaticallybooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213940);
      ReflectMethod localReflectMethod2 = this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setJavaScriptCanOpenWindowsAutomatically", new Class[] { Boolean.TYPE });
        this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213940);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetJavaScriptEnabledbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213948);
      ReflectMethod localReflectMethod2 = this.setJavaScriptEnabledbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setJavaScriptEnabled", new Class[] { Boolean.TYPE });
        this.setJavaScriptEnabledbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213948);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetJavascriptCanAccessClipboardbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214343);
      ReflectMethod localReflectMethod2 = this.setJavascriptCanAccessClipboardbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setJavascriptCanAccessClipboard", new Class[] { Boolean.TYPE });
        this.setJavascriptCanAccessClipboardbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214343);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetLayoutAlgorithmWebSettingsLayoutAlgorithmMethod()
  {
    try
    {
      AppMethodBeat.i(213958);
      ReflectMethod localReflectMethod2 = this.setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setLayoutAlgorithm", new Class[] { WebSettings.LayoutAlgorithm.class });
        this.setLayoutAlgorithmWebSettingsLayoutAlgorithmMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213958);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetLoadWithOverviewModebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213968);
      ReflectMethod localReflectMethod2 = this.setLoadWithOverviewModebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setLoadWithOverviewMode", new Class[] { Boolean.TYPE });
        this.setLoadWithOverviewModebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213968);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetLoadsImagesAutomaticallybooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213976);
      ReflectMethod localReflectMethod2 = this.setLoadsImagesAutomaticallybooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setLoadsImagesAutomatically", new Class[] { Boolean.TYPE });
        this.setLoadsImagesAutomaticallybooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213976);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetMediaPlaybackRequiresUserGesturebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(213983);
      ReflectMethod localReflectMethod2 = this.setMediaPlaybackRequiresUserGesturebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setMediaPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE });
        this.setMediaPlaybackRequiresUserGesturebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213983);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetMinimumFontSizeintMethod()
  {
    try
    {
      AppMethodBeat.i(213994);
      ReflectMethod localReflectMethod2 = this.setMinimumFontSizeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setMinimumFontSize", new Class[] { Integer.TYPE });
        this.setMinimumFontSizeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(213994);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetMinimumLogicalFontSizeintMethod()
  {
    try
    {
      AppMethodBeat.i(214004);
      ReflectMethod localReflectMethod2 = this.setMinimumLogicalFontSizeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setMinimumLogicalFontSize", new Class[] { Integer.TYPE });
        this.setMinimumLogicalFontSizeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214004);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetMixedContentModeintMethod()
  {
    try
    {
      AppMethodBeat.i(214013);
      ReflectMethod localReflectMethod2 = this.setMixedContentModeintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setMixedContentMode", new Class[] { Integer.TYPE });
        this.setMixedContentModeintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214013);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetNeedInitialFocusbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214017);
      ReflectMethod localReflectMethod2 = this.setNeedInitialFocusbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setNeedInitialFocus", new Class[] { Boolean.TYPE });
        this.setNeedInitialFocusbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214017);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetOffscreenPreRasterbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214028);
      ReflectMethod localReflectMethod2 = this.setOffscreenPreRasterbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setOffscreenPreRaster", new Class[] { Boolean.TYPE });
        this.setOffscreenPreRasterbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214028);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSansSerifFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(214038);
      ReflectMethod localReflectMethod2 = this.setSansSerifFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSansSerifFontFamily", new Class[] { String.class });
        this.setSansSerifFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214038);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSaveFormDatabooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214051);
      ReflectMethod localReflectMethod2 = this.setSaveFormDatabooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSaveFormData", new Class[] { Boolean.TYPE });
        this.setSaveFormDatabooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214051);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSavePasswordbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214061);
      ReflectMethod localReflectMethod2 = this.setSavePasswordbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSavePassword", new Class[] { Boolean.TYPE });
        this.setSavePasswordbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214061);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSerifFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(214072);
      ReflectMethod localReflectMethod2 = this.setSerifFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSerifFontFamily", new Class[] { String.class });
        this.setSerifFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214072);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetStandardFontFamilyStringMethod()
  {
    try
    {
      AppMethodBeat.i(214082);
      ReflectMethod localReflectMethod2 = this.setStandardFontFamilyStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setStandardFontFamily", new Class[] { String.class });
        this.setStandardFontFamilyStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214082);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSupportMultipleWindowsbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214090);
      ReflectMethod localReflectMethod2 = this.setSupportMultipleWindowsbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSupportMultipleWindows", new Class[] { Boolean.TYPE });
        this.setSupportMultipleWindowsbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214090);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetSupportZoombooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214103);
      ReflectMethod localReflectMethod2 = this.setSupportZoombooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setSupportZoom", new Class[] { Boolean.TYPE });
        this.setSupportZoombooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214103);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetTextZoomintMethod()
  {
    try
    {
      AppMethodBeat.i(214113);
      ReflectMethod localReflectMethod2 = this.setTextZoomintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setTextZoom", new Class[] { Integer.TYPE });
        this.setTextZoomintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214113);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetUseWideViewPortbooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214122);
      ReflectMethod localReflectMethod2 = this.setUseWideViewPortbooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setUseWideViewPort", new Class[] { Boolean.TYPE });
        this.setUseWideViewPortbooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214122);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetUserAgentStringStringMethod()
  {
    try
    {
      AppMethodBeat.i(214132);
      ReflectMethod localReflectMethod2 = this.setUserAgentStringStringMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setUserAgentString", new Class[] { String.class });
        this.setUserAgentStringStringMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214132);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetUsingForAppBrandintMethod()
  {
    try
    {
      AppMethodBeat.i(214161);
      ReflectMethod localReflectMethod2 = this.setUsingForAppBrandintMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setUsingForAppBrand", new Class[] { Integer.TYPE });
        this.setUsingForAppBrandintMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214161);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSetVideoPlaybackRequiresUserGesturebooleanMethod()
  {
    try
    {
      AppMethodBeat.i(214267);
      ReflectMethod localReflectMethod2 = this.setVideoPlaybackRequiresUserGesturebooleanMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "setVideoPlaybackRequiresUserGesture", new Class[] { Boolean.TYPE });
        this.setVideoPlaybackRequiresUserGesturebooleanMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214267);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSupportMultipleWindowsMethod()
  {
    try
    {
      AppMethodBeat.i(214142);
      ReflectMethod localReflectMethod2 = this.supportMultipleWindowsMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "supportMultipleWindows", new Class[0]);
        this.supportMultipleWindowsMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214142);
      return localReflectMethod1;
    }
    finally {}
  }
  
  private ReflectMethod getSupportZoomMethod()
  {
    try
    {
      AppMethodBeat.i(214151);
      ReflectMethod localReflectMethod2 = this.supportZoomMethod;
      ReflectMethod localReflectMethod1 = localReflectMethod2;
      if (localReflectMethod2 == null)
      {
        localReflectMethod1 = new ReflectMethod(this.inner, "supportZoom", new Class[0]);
        this.supportZoomMethod = localReflectMethod1;
      }
      AppMethodBeat.o(214151);
      return localReflectMethod1;
    }
    finally {}
  }
  
  public static void handleRuntimeError(Exception paramException) {}
  
  public void disableCustomizedLongPressTimeout()
  {
    AppMethodBeat.i(215299);
    try
    {
      getDisableCustomizedLongPressTimeoutMethod().invoke(new Object[0]);
      AppMethodBeat.o(215299);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215299);
    }
  }
  
  public void enableCustomizedLongPressTimeout(int paramInt)
  {
    AppMethodBeat.i(215292);
    try
    {
      getEnableCustomizedLongPressTimeoutintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215292);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215292);
    }
  }
  
  public boolean getAllowContentAccess()
  {
    AppMethodBeat.i(214378);
    try
    {
      bool = ((Boolean)getGetAllowContentAccessMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214378);
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
  
  public boolean getAllowFileAccess()
  {
    AppMethodBeat.i(214388);
    try
    {
      bool = ((Boolean)getGetAllowFileAccessMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214388);
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
  
  public boolean getAllowFileAccessFromFileURLs()
  {
    AppMethodBeat.i(214397);
    try
    {
      bool = ((Boolean)getGetAllowFileAccessFromFileURLsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214397);
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
  
  public boolean getAllowUniversalAccessFromFileURLs()
  {
    AppMethodBeat.i(214409);
    try
    {
      bool = ((Boolean)getGetAllowUniversalAccessFromFileURLsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214409);
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
  
  public Map<String, String> getAppBrandInfo()
  {
    AppMethodBeat.i(215228);
    try
    {
      Map localMap = (Map)getGetAppBrandInfoMethod().invoke(new Object[0]);
      AppMethodBeat.o(215228);
      return localMap;
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
  
  public boolean getAudioPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(215265);
    try
    {
      bool = ((Boolean)getGetAudioPlaybackRequiresUserGestureMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215265);
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
  
  public boolean getBackgroundAudioPause()
  {
    AppMethodBeat.i(215313);
    try
    {
      bool = ((Boolean)getGetBackgroundAudioPauseMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215313);
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
  
  public boolean getBlockNetworkImage()
  {
    AppMethodBeat.i(214421);
    try
    {
      bool = ((Boolean)getGetBlockNetworkImageMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214421);
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
  
  public boolean getBlockNetworkLoads()
  {
    AppMethodBeat.i(214432);
    try
    {
      bool = ((Boolean)getGetBlockNetworkLoadsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214432);
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
  
  public boolean getBuiltInZoomControls()
  {
    AppMethodBeat.i(214444);
    try
    {
      bool = ((Boolean)getGetBuiltInZoomControlsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214444);
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
  
  public int getCacheMode()
  {
    AppMethodBeat.i(214457);
    try
    {
      i = ((Integer)getGetCacheModeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214457);
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
  
  public String getCursiveFontFamily()
  {
    AppMethodBeat.i(214468);
    try
    {
      String str = (String)getGetCursiveFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214468);
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
  
  public boolean getDatabaseEnabled()
  {
    AppMethodBeat.i(214481);
    try
    {
      bool = ((Boolean)getGetDatabaseEnabledMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214481);
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
  
  public String getDatabasePath()
  {
    AppMethodBeat.i(214495);
    try
    {
      String str = (String)getGetDatabasePathMethod().invoke(new Object[0]);
      AppMethodBeat.o(214495);
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
  
  public int getDefaultFixedFontSize()
  {
    AppMethodBeat.i(214504);
    try
    {
      i = ((Integer)getGetDefaultFixedFontSizeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214504);
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
  
  public int getDefaultFontSize()
  {
    AppMethodBeat.i(214518);
    try
    {
      i = ((Integer)getGetDefaultFontSizeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214518);
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
  
  public String getDefaultTextEncodingName()
  {
    AppMethodBeat.i(214532);
    try
    {
      String str = (String)getGetDefaultTextEncodingNameMethod().invoke(new Object[0]);
      AppMethodBeat.o(214532);
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
  
  public int getDisabledActionModeMenuItems()
  {
    AppMethodBeat.i(214542);
    try
    {
      i = ((Integer)getGetDisabledActionModeMenuItemsMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214542);
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
  
  public boolean getDisplayZoomControls()
  {
    AppMethodBeat.i(214551);
    try
    {
      bool = ((Boolean)getGetDisplayZoomControlsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214551);
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
  
  public boolean getDomStorageEnabled()
  {
    AppMethodBeat.i(214558);
    try
    {
      bool = ((Boolean)getGetDomStorageEnabledMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214558);
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
  
  public String getFantasyFontFamily()
  {
    AppMethodBeat.i(214569);
    try
    {
      String str = (String)getGetFantasyFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214569);
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
  
  public String getFixedFontFamily()
  {
    AppMethodBeat.i(214581);
    try
    {
      String str = (String)getGetFixedFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214581);
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
  
  public int getForceDark()
  {
    AppMethodBeat.i(214591);
    try
    {
      i = ((Integer)getGetForceDarkMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214591);
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
  
  public int getForceDarkBehavior()
  {
    AppMethodBeat.i(215253);
    try
    {
      i = ((Integer)getGetForceDarkBehaviorMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(215253);
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
  
  public int getForceDarkMode()
  {
    AppMethodBeat.i(215242);
    try
    {
      i = ((Integer)getGetForceDarkModeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(215242);
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
  
  public boolean getJavaScriptCanOpenWindowsAutomatically()
  {
    AppMethodBeat.i(214604);
    try
    {
      bool = ((Boolean)getGetJavaScriptCanOpenWindowsAutomaticallyMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214604);
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
  
  public boolean getJavaScriptEnabled()
  {
    AppMethodBeat.i(214612);
    try
    {
      bool = ((Boolean)getGetJavaScriptEnabledMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214612);
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
  
  public boolean getJavascriptCanAccessClipboard()
  {
    AppMethodBeat.i(215327);
    try
    {
      bool = ((Boolean)getGetJavascriptCanAccessClipboardMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215327);
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
  
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm()
  {
    AppMethodBeat.i(214623);
    try
    {
      WebSettings.LayoutAlgorithm localLayoutAlgorithm = (WebSettings.LayoutAlgorithm)getGetLayoutAlgorithmMethod().invoke(new Object[0]);
      AppMethodBeat.o(214623);
      return localLayoutAlgorithm;
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
  
  public boolean getLoadWithOverviewMode()
  {
    AppMethodBeat.i(214634);
    try
    {
      bool = ((Boolean)getGetLoadWithOverviewModeMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214634);
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
  
  public boolean getLoadsImagesAutomatically()
  {
    AppMethodBeat.i(214642);
    try
    {
      bool = ((Boolean)getGetLoadsImagesAutomaticallyMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214642);
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
  
  public boolean getMediaPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(214652);
    try
    {
      bool = ((Boolean)getGetMediaPlaybackRequiresUserGestureMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214652);
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
  
  public int getMinimumFontSize()
  {
    AppMethodBeat.i(214658);
    try
    {
      i = ((Integer)getGetMinimumFontSizeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214658);
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
  
  public int getMinimumLogicalFontSize()
  {
    AppMethodBeat.i(214669);
    try
    {
      i = ((Integer)getGetMinimumLogicalFontSizeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214669);
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
  
  public int getMixedContentMode()
  {
    AppMethodBeat.i(214675);
    try
    {
      i = ((Integer)getGetMixedContentModeMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214675);
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
  
  public boolean getOffscreenPreRaster()
  {
    AppMethodBeat.i(214680);
    try
    {
      bool = ((Boolean)getGetOffscreenPreRasterMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214680);
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
  
  public String getSansSerifFontFamily()
  {
    AppMethodBeat.i(214687);
    try
    {
      String str = (String)getGetSansSerifFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214687);
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
  
  public boolean getSaveFormData()
  {
    AppMethodBeat.i(214699);
    try
    {
      bool = ((Boolean)getGetSaveFormDataMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214699);
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
  
  public boolean getSavePassword()
  {
    AppMethodBeat.i(214707);
    try
    {
      bool = ((Boolean)getGetSavePasswordMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214707);
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
  
  public String getSerifFontFamily()
  {
    AppMethodBeat.i(214713);
    try
    {
      String str = (String)getGetSerifFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214713);
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
  
  public String getStandardFontFamily()
  {
    AppMethodBeat.i(214723);
    try
    {
      String str = (String)getGetStandardFontFamilyMethod().invoke(new Object[0]);
      AppMethodBeat.o(214723);
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
  
  public int getTextZoom()
  {
    AppMethodBeat.i(214732);
    try
    {
      i = ((Integer)getGetTextZoomMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(214732);
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
  
  public boolean getUseWideViewPort()
  {
    AppMethodBeat.i(214741);
    try
    {
      bool = ((Boolean)getGetUseWideViewPortMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(214741);
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
  
  public String getUserAgentString()
  {
    AppMethodBeat.i(214749);
    try
    {
      String str = (String)getGetUserAgentStringMethod().invoke(new Object[0]);
      AppMethodBeat.o(214749);
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
  
  public int getUsingForAppBrand()
  {
    AppMethodBeat.i(215213);
    try
    {
      i = ((Integer)getGetUsingForAppBrandMethod().invoke(new Object[0])).intValue();
      AppMethodBeat.o(215213);
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
  
  public boolean getVideoPlaybackRequiresUserGesture()
  {
    AppMethodBeat.i(215283);
    try
    {
      bool = ((Boolean)getGetVideoPlaybackRequiresUserGestureMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215283);
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
  
  public void setAllowContentAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(214759);
    try
    {
      getSetAllowContentAccessbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214759);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214759);
    }
  }
  
  public void setAllowFileAccess(boolean paramBoolean)
  {
    AppMethodBeat.i(214767);
    try
    {
      getSetAllowFileAccessbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214767);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214767);
    }
  }
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(214780);
    try
    {
      getSetAllowFileAccessFromFileURLsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214780);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214780);
    }
  }
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean)
  {
    AppMethodBeat.i(214792);
    try
    {
      getSetAllowUniversalAccessFromFileURLsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214792);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214792);
    }
  }
  
  public void setAppBrandInfo(Map<String, String> paramMap)
  {
    AppMethodBeat.i(215220);
    try
    {
      getSetAppBrandInfoMapStringStringMethod().invoke(new Object[] { paramMap });
      AppMethodBeat.o(215220);
      return;
    }
    catch (UnsupportedOperationException paramMap)
    {
      handleRuntimeError(paramMap);
      AppMethodBeat.o(215220);
    }
  }
  
  public void setAppCacheEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214806);
    try
    {
      getSetAppCacheEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214806);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214806);
    }
  }
  
  public void setAppCacheMaxSize(long paramLong)
  {
    AppMethodBeat.i(214815);
    try
    {
      getSetAppCacheMaxSizelongMethod().invoke(new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(214815);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214815);
    }
  }
  
  public void setAppCachePath(String paramString)
  {
    AppMethodBeat.i(214828);
    try
    {
      getSetAppCachePathStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214828);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214828);
    }
  }
  
  public void setAudioPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(215258);
    try
    {
      getSetAudioPlaybackRequiresUserGesturebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215258);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215258);
    }
  }
  
  public void setBackgroundAudioPause(boolean paramBoolean)
  {
    AppMethodBeat.i(215305);
    try
    {
      getSetBackgroundAudioPausebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215305);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215305);
    }
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    AppMethodBeat.i(214841);
    try
    {
      getSetBlockNetworkImagebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214841);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214841);
    }
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean)
  {
    AppMethodBeat.i(214849);
    try
    {
      getSetBlockNetworkLoadsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214849);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214849);
    }
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(214860);
    try
    {
      getSetBuiltInZoomControlsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214860);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214860);
    }
  }
  
  public void setCacheMode(int paramInt)
  {
    AppMethodBeat.i(214869);
    try
    {
      getSetCacheModeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214869);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214869);
    }
  }
  
  public void setCursiveFontFamily(String paramString)
  {
    AppMethodBeat.i(214889);
    try
    {
      getSetCursiveFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214889);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214889);
    }
  }
  
  public void setDatabaseEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214898);
    try
    {
      getSetDatabaseEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214898);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214898);
    }
  }
  
  public void setDatabasePath(String paramString)
  {
    AppMethodBeat.i(214907);
    try
    {
      getSetDatabasePathStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214907);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214907);
    }
  }
  
  public void setDefaultFixedFontSize(int paramInt)
  {
    AppMethodBeat.i(214914);
    try
    {
      getSetDefaultFixedFontSizeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214914);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214914);
    }
  }
  
  public void setDefaultFontSize(int paramInt)
  {
    AppMethodBeat.i(214925);
    try
    {
      getSetDefaultFontSizeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214925);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214925);
    }
  }
  
  public void setDefaultTextEncodingName(String paramString)
  {
    AppMethodBeat.i(214934);
    try
    {
      getSetDefaultTextEncodingNameStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214934);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214934);
    }
  }
  
  public void setDisabledActionModeMenuItems(int paramInt)
  {
    AppMethodBeat.i(214944);
    try
    {
      getSetDisabledActionModeMenuItemsintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214944);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214944);
    }
  }
  
  public void setDisplayZoomControls(boolean paramBoolean)
  {
    AppMethodBeat.i(214952);
    try
    {
      getSetDisplayZoomControlsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214952);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214952);
    }
  }
  
  public void setDomStorageEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(214965);
    try
    {
      getSetDomStorageEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(214965);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214965);
    }
  }
  
  public void setFantasyFontFamily(String paramString)
  {
    AppMethodBeat.i(214981);
    try
    {
      getSetFantasyFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214981);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214981);
    }
  }
  
  public void setFixedFontFamily(String paramString)
  {
    AppMethodBeat.i(214988);
    try
    {
      getSetFixedFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(214988);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(214988);
    }
  }
  
  public void setForceDark(int paramInt)
  {
    AppMethodBeat.i(214996);
    try
    {
      getSetForceDarkintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(214996);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(214996);
    }
  }
  
  public void setForceDarkBehavior(int paramInt)
  {
    AppMethodBeat.i(215247);
    try
    {
      getSetForceDarkBehaviorintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215247);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215247);
    }
  }
  
  public void setForceDarkMode(int paramInt)
  {
    AppMethodBeat.i(215233);
    try
    {
      getSetForceDarkModeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215233);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215233);
    }
  }
  
  public void setGeolocationEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(215001);
    try
    {
      getSetGeolocationEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215001);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215001);
    }
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(215009);
    try
    {
      getSetJavaScriptCanOpenWindowsAutomaticallybooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215009);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215009);
    }
  }
  
  public void setJavaScriptEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(215021);
    try
    {
      getSetJavaScriptEnabledbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215021);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215021);
    }
  }
  
  public void setJavascriptCanAccessClipboard(boolean paramBoolean)
  {
    AppMethodBeat.i(215321);
    try
    {
      getSetJavascriptCanAccessClipboardbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215321);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215321);
    }
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm)
  {
    AppMethodBeat.i(215029);
    try
    {
      getSetLayoutAlgorithmWebSettingsLayoutAlgorithmMethod().invoke(new Object[] { paramLayoutAlgorithm });
      AppMethodBeat.o(215029);
      return;
    }
    catch (UnsupportedOperationException paramLayoutAlgorithm)
    {
      handleRuntimeError(paramLayoutAlgorithm);
      AppMethodBeat.o(215029);
    }
  }
  
  public void setLoadWithOverviewMode(boolean paramBoolean)
  {
    AppMethodBeat.i(215042);
    try
    {
      getSetLoadWithOverviewModebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215042);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215042);
    }
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean)
  {
    AppMethodBeat.i(215052);
    try
    {
      getSetLoadsImagesAutomaticallybooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215052);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215052);
    }
  }
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(215064);
    try
    {
      getSetMediaPlaybackRequiresUserGesturebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215064);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215064);
    }
  }
  
  public void setMinimumFontSize(int paramInt)
  {
    AppMethodBeat.i(215077);
    try
    {
      getSetMinimumFontSizeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215077);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215077);
    }
  }
  
  public void setMinimumLogicalFontSize(int paramInt)
  {
    AppMethodBeat.i(215085);
    try
    {
      getSetMinimumLogicalFontSizeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215085);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215085);
    }
  }
  
  public void setMixedContentMode(int paramInt)
  {
    AppMethodBeat.i(215093);
    try
    {
      getSetMixedContentModeintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215093);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215093);
    }
  }
  
  public void setNeedInitialFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(215101);
    try
    {
      getSetNeedInitialFocusbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215101);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215101);
    }
  }
  
  public void setOffscreenPreRaster(boolean paramBoolean)
  {
    AppMethodBeat.i(215107);
    try
    {
      getSetOffscreenPreRasterbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215107);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215107);
    }
  }
  
  public void setSansSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(215112);
    try
    {
      getSetSansSerifFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(215112);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(215112);
    }
  }
  
  public void setSaveFormData(boolean paramBoolean)
  {
    AppMethodBeat.i(215121);
    try
    {
      getSetSaveFormDatabooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215121);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215121);
    }
  }
  
  public void setSavePassword(boolean paramBoolean)
  {
    AppMethodBeat.i(215130);
    try
    {
      getSetSavePasswordbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215130);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215130);
    }
  }
  
  public void setSerifFontFamily(String paramString)
  {
    AppMethodBeat.i(215139);
    try
    {
      getSetSerifFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(215139);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(215139);
    }
  }
  
  public void setStandardFontFamily(String paramString)
  {
    AppMethodBeat.i(215145);
    try
    {
      getSetStandardFontFamilyStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(215145);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(215145);
    }
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean)
  {
    AppMethodBeat.i(215155);
    try
    {
      getSetSupportMultipleWindowsbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215155);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215155);
    }
  }
  
  public void setSupportZoom(boolean paramBoolean)
  {
    AppMethodBeat.i(215163);
    try
    {
      getSetSupportZoombooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215163);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215163);
    }
  }
  
  public void setTextZoom(int paramInt)
  {
    AppMethodBeat.i(215171);
    try
    {
      getSetTextZoomintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215171);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215171);
    }
  }
  
  public void setUseWideViewPort(boolean paramBoolean)
  {
    AppMethodBeat.i(215179);
    try
    {
      getSetUseWideViewPortbooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215179);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215179);
    }
  }
  
  public void setUserAgentString(String paramString)
  {
    AppMethodBeat.i(215188);
    try
    {
      getSetUserAgentStringStringMethod().invoke(new Object[] { paramString });
      AppMethodBeat.o(215188);
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      handleRuntimeError(paramString);
      AppMethodBeat.o(215188);
    }
  }
  
  public void setUsingForAppBrand(int paramInt)
  {
    AppMethodBeat.i(215206);
    try
    {
      getSetUsingForAppBrandintMethod().invoke(new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(215206);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215206);
    }
  }
  
  public void setVideoPlaybackRequiresUserGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(215275);
    try
    {
      getSetVideoPlaybackRequiresUserGesturebooleanMethod().invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(215275);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      handleRuntimeError(localUnsupportedOperationException);
      AppMethodBeat.o(215275);
    }
  }
  
  public boolean supportMultipleWindows()
  {
    AppMethodBeat.i(215195);
    try
    {
      bool = ((Boolean)getSupportMultipleWindowsMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215195);
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
  
  public boolean supportZoom()
  {
    AppMethodBeat.i(215202);
    try
    {
      bool = ((Boolean)getSupportZoomMethod().invoke(new Object[0])).booleanValue();
      AppMethodBeat.o(215202);
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
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebSettingsInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */