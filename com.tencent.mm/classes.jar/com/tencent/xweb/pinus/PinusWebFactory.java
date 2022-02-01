package com.tencent.xweb.pinus;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.XWebViewProvider;
import com.tencent.xweb.ao;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import com.tencent.xweb.pinus.sdk.WebViewExtension;
import com.tencent.xweb.xwalk.m;
import com.tencent.xweb.xwalk.t;
import java.util.Locale;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;

public class PinusWebFactory
  implements WebViewWrapperFactory.IWebViewProvider
{
  private static final String TAG = "PinusWebFactory";
  private static PinusWebFactory sInstance;
  private boolean mIsDebugMode = false;
  private boolean mIsDebugModeReplace = false;
  
  public static PinusWebFactory getInstance()
  {
    AppMethodBeat.i(213237);
    if (sInstance == null)
    {
      ao.kgs();
      sInstance = new PinusWebFactory();
    }
    PinusWebFactory localPinusWebFactory = sInstance;
    AppMethodBeat.o(213237);
    return localPinusWebFactory;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(213364);
    if (com.tencent.xweb.WebView.getCurWebType() != WebView.WebViewKind.aifL)
    {
      Log.w("PinusWebFactory", "clearAllWebViewCache, not pinus");
      AppMethodBeat.o(213364);
      return;
    }
    try
    {
      if (XWalkEnvironment.getAvailableVersion() <= 0)
      {
        Log.w("PinusWebFactory", "clearAllWebViewCache, no available version");
        AppMethodBeat.o(213364);
        return;
      }
      paramContext = new android.webkit.WebView(paramContext);
      paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
      paramContext.removeJavascriptInterface("accessibility");
      paramContext.removeJavascriptInterface("accessibilityTraversal");
      paramContext.clearCache(true);
      if (paramBoolean)
      {
        paramContext = getCookieManager();
        if (paramContext != null) {
          paramContext.removeAllCookie();
        }
      }
      AppMethodBeat.o(213364);
      return;
    }
    finally
    {
      Log.e("PinusWebFactory", "clearAllWebViewCache, error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(213364);
    }
  }
  
  public IWebView createWebView(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(213272);
    try
    {
      if (h.oX(paramWebView.getContext()))
      {
        Log.i("PinusWebFactory", "createWebView, PinusWebView is available");
        paramWebView = new h(paramWebView);
        return paramWebView;
      }
    }
    finally
    {
      AppMethodBeat.o(213272);
    }
    AppMethodBeat.o(213272);
    return null;
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(213407);
    f localf = new f();
    AppMethodBeat.o(213407);
    return localf;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(213259);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(213259);
      return null;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(213259);
      return null;
      if (!paramString.equals("STR_CMD_INVOKE_TO_RUNTIME")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("BASE_CONTEXT_CHANGED")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("STR_CMD_FEATURE_SUPPORT")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("STR_CMD_NATIVE_TRANS_INIT")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("STR_CMD_FORCE_DARK_MODE_COMMAND")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("STR_CMD_UPDATE_RESOURCE_LOCALE")) {
        break;
      }
      i = 8;
      break;
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2))
      {
        AppMethodBeat.o(213259);
        return null;
      }
      try
      {
        if (PSCoreWrapper.getInstance() == null) {
          continue;
        }
        paramString = PSCoreWrapper.invokeRuntimeChannel(((Integer)paramArrayOfObject[0]).intValue(), (Object[])paramArrayOfObject[1]);
        AppMethodBeat.o(213259);
        return paramString;
      }
      finally
      {
        Log.e("PinusWebFactory", "STR_CMD_INVOKE_TO_RUNTIME failed, error:".concat(String.valueOf(paramString)));
      }
      continue;
      this.mIsDebugMode = true;
      this.mIsDebugModeReplace = true;
      continue;
      this.mIsDebugMode = true;
      this.mIsDebugModeReplace = false;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0) && ((paramArrayOfObject[0] instanceof h))) {}
    for (paramString = (h)paramArrayOfObject[0]; (paramString != null) && (PSCoreWrapper.getInstance() != null); paramString = null)
    {
      for (;;)
      {
        paramString = paramString.getBridge();
        if (paramString == null) {
          break;
        }
        PSCoreWrapper.invokeRuntimeChannel(80001, new Object[] { paramString });
        break;
        boolean bool = PSCoreWrapper.hasFeatureStatic(((Integer)paramArrayOfObject[0]).intValue());
        AppMethodBeat.o(213259);
        return Boolean.valueOf(bool);
        PSCoreWrapper.bindNativeTrans(((Long)paramArrayOfObject[0]).longValue());
        break;
        Log.w("PinusWebFactory", "setWeChatDefaultForceDarkMode, not implemented");
        break;
        Log.w("PinusWebFactory", "setWeChatDefaultForceDarkBehavior, not implemented");
        break;
        try
        {
          if (PSCoreWrapper.getInstance() == null) {
            break label547;
          }
          PSCoreWrapper.getInstance().updateResourceLocale((Locale)paramArrayOfObject[0]);
          break;
        }
        finally
        {
          Log.e("PinusWebFactory", "execute, updateResourceLocale error:", paramString);
        }
      }
      break;
      label547:
      Log.w("PinusWebFactory", "execute, updateResourceLocale, PSCoreWrapper is null");
      break;
    }
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(213380);
    b localb = new b();
    AppMethodBeat.o(213380);
    return localb;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(213396);
    c localc = new c();
    AppMethodBeat.o(213396);
    return localc;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(213419);
    t localt = new t();
    AppMethodBeat.o(213419);
    return localt;
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(213324);
    boolean bool = a.hasInited();
    AppMethodBeat.o(213324);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(213336);
    boolean bool = a.hasInitedCallback();
    AppMethodBeat.o(213336);
    return bool;
  }
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(213294);
    Log.i("PinusWebFactory", "initEnvironment");
    if (this.mIsDebugMode) {
      XWebViewProvider.tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplace);
    }
    AppMethodBeat.o(213294);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(213284);
    l.a(WebView.WebViewKind.aifL, new m());
    AppMethodBeat.o(213284);
  }
  
  public void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(213315);
    a.a(paramWebViewExtensionListener);
    AppMethodBeat.o(213315);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(213302);
    Log.i("PinusWebFactory", "initWebviewCore");
    boolean bool = a.oW(paramContext);
    if (paramPreInitCallback != null)
    {
      if (!bool) {
        break label41;
      }
      paramPreInitCallback.onCoreInitFinished();
    }
    for (;;)
    {
      AppMethodBeat.o(213302);
      return bool;
      label41:
      paramPreInitCallback.aDm();
    }
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(213346);
    boolean bool = a.isCoreReady();
    AppMethodBeat.o(213346);
    return bool;
  }
  
  static final class a
  {
    private static boolean aikD = false;
    private static boolean mHasInited = false;
    private static boolean mIsCoreReady = false;
    
    public static void a(WebViewExtensionListener paramWebViewExtensionListener)
    {
      AppMethodBeat.i(213253);
      if (aikD)
      {
        AppMethodBeat.o(213253);
        return;
      }
      Log.i("PinusWebFactory.PreIniter", "initExtension");
      WebViewExtension.setExtension(paramWebViewExtensionListener);
      aikD = true;
      AppMethodBeat.o(213253);
    }
    
    public static boolean hasInited()
    {
      return mHasInited;
    }
    
    public static boolean hasInitedCallback()
    {
      return aikD;
    }
    
    public static boolean isCoreReady()
    {
      return mIsCoreReady;
    }
    
    public static boolean oW(Context paramContext)
    {
      AppMethodBeat.i(213249);
      if (mHasInited)
      {
        AppMethodBeat.o(213249);
        return true;
      }
      Log.i("PinusWebFactory.PreIniter", "preInit start");
      if (h.oX(paramContext))
      {
        Log.i("PinusWebFactory.PreIniter", "preInit finished");
        mHasInited = true;
        mIsCoreReady = true;
        String str = XWalkEnvironment.getProcessName();
        paramContext = str;
        if (TextUtils.isEmpty(str)) {
          paramContext = XWalkEnvironment.getApplicationContext().getPackageName();
        }
        paramContext = paramContext.replace(":", ".");
        PSCoreWrapper.invokeRuntimeChannel(90002, new Object[] { paramContext + "." + XWalkGrayValueUtil.getGrayValue() });
      }
      for (;;)
      {
        boolean bool = mHasInited;
        AppMethodBeat.o(213249);
        return bool;
        Log.i("PinusWebFactory.PreIniter", "preInit failed, pinus is not available");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.PinusWebFactory
 * JD-Core Version:    0.7.0.1
 */