package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory
  implements j.a
{
  private static final String TAG = "XWalkWebFactory";
  static XWalkWebFactory sInstance;
  private boolean mIsDebugMode = false;
  private boolean mIsDebugModeReplase = false;
  
  public static XWalkWebFactory getInstance()
  {
    if (sInstance == null) {
      sInstance = new XWalkWebFactory();
    }
    return sInstance;
  }
  
  public static boolean tryLoadLocalAssetRuntime(Context paramContext, boolean paramBoolean)
  {
    boolean bool2 = false;
    for (;;)
    {
      Object localObject;
      try
      {
        XWalkEnvironment.init(paramContext);
        if ((paramBoolean) && (XWalkEnvironment.getAvailableVersion() == 999)) {
          XWalkEnvironment.delApiVersion(999);
        }
        int i = XWalkEnvironment.getAvailableVersion();
        if (i != -1)
        {
          bool1 = bool2;
          if (!paramBoolean) {}
        }
        else
        {
          try
          {
            paramContext = paramContext.getAssets().open("runtime_package.zip");
            localObject = new File(XWalkEnvironment.getDownloadZipDir(999));
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            localObject = new FileOutputStream((File)localObject);
            byte[] arrayOfByte = new byte[1048576];
            i = paramContext.read(arrayOfByte);
            if (i == -1) {
              continue;
            }
            ((FileOutputStream)localObject).write(arrayOfByte, 0, i);
            continue;
          }
          catch (IOException paramContext)
          {
            bool1 = bool2;
          }
        }
        return bool1;
      }
      finally {}
      ((FileOutputStream)localObject).flush();
      paramContext.close();
      ((FileOutputStream)localObject).close();
      XWalkUpdater.updateLocalXWalkRuntime();
      boolean bool1 = true;
    }
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    if (WebView.getCurWebType() != WebView.d.xho) {}
    for (;;)
    {
      return;
      try
      {
        if (XWalkEnvironment.getAvailableVersion() > 0)
        {
          paramContext = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
          paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
          paramContext.removeJavascriptInterface("accessibility");
          paramContext.removeJavascriptInterface("accessibilityTraversal");
          paramContext.clearCache(true);
          XWalkViewDatabase.clearFormData();
          if (paramBoolean)
          {
            paramContext = getCookieManager();
            if (paramContext != null)
            {
              paramContext.removeAllCookie();
              return;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        org.xwalk.core.Log.e("XWalkWebFactory", "clearAllWebViewCache exception 1 -- " + paramContext.getMessage());
      }
    }
  }
  
  public com.tencent.xweb.c.h createWebView(WebView paramWebView)
  {
    try
    {
      if (h.eL(paramWebView.getContext()))
      {
        WebViewExtension.updateExtension(false);
        paramWebView = new h(paramWebView);
        return paramWebView;
      }
    }
    catch (Exception paramWebView)
    {
      paramWebView = "init xwalk crashed:" + paramWebView.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(paramWebView);
      org.xwalk.core.Log.e("XWalkWebFactory", paramWebView);
      XWalkInitializer.addXWalkInitializeLog(paramWebView);
    }
    return null;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    if (paramString.equals("STR_CMD_GET_DEBUG_VIEW")) {
      return new a((WebView)paramArrayOfObject[0]);
    }
    if (paramString.equals("STR_CMD_GET_UPDATER")) {
      return new l.a();
    }
    if (paramString.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
      return new com.tencent.xweb.xwalk.plugin.c();
    }
    if (paramString.equals("STR_CMD_CLEAR_SCHEDULER"))
    {
      com.tencent.xweb.xwalk.a.c.a(null);
      return null;
    }
    if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE"))
    {
      this.mIsDebugMode = true;
      this.mIsDebugModeReplase = true;
    }
    for (;;)
    {
      return null;
      if (paramString.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE"))
      {
        this.mIsDebugMode = true;
        this.mIsDebugModeReplase = false;
      }
      else if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW"))
      {
        tryLoadLocalAssetRuntime((Context)paramArrayOfObject[0], true);
        a.io((Context)paramArrayOfObject[0]);
      }
      else if (paramString.equals("BASE_CONTEXT_CHANGED"))
      {
        XWalkCoreWrapper.getInstance().invokeRuntimeChannel(80001, paramArrayOfObject);
      }
    }
  }
  
  public b.a getCookieManager()
  {
    return new c();
  }
  
  public b.b getCookieSyncManager()
  {
    return new d();
  }
  
  public com.tencent.xweb.c.g getJsCore(g.a parama, Context paramContext)
  {
    initWebviewCore(paramContext, null);
    switch (1.gXB[parama.ordinal()])
    {
    }
    do
    {
      do
      {
        return null;
      } while (!com.tencent.xweb.xwalk.a.d.isXWalkReady());
      if (parama == g.a.xgC)
      {
        parama = new g();
        parama.init(0);
        return parama;
      }
    } while (parama != g.a.xgD);
    parama = new g();
    parama.init(1);
    return parama;
  }
  
  public boolean hasInited()
  {
    return XWalkWebFactory.a.hasInited();
  }
  
  public boolean hasInitedCallback()
  {
    return XWalkWebFactory.a.hasInitedCallback();
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    XWalkWebFactory.a.initCallback(paramWebViewExtensionListener);
  }
  
  public void initEnviroment(Context paramContext)
  {
    if (this.mIsDebugMode) {
      tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplase);
    }
  }
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    boolean bool = XWalkWebFactory.a.iq(paramContext);
    if (paramc != null)
    {
      if (bool) {
        paramc.onCoreInitFinished();
      }
    }
    else {
      return bool;
    }
    paramc.tc();
    return bool;
  }
  
  public boolean isCoreReady()
  {
    return XWalkWebFactory.a.isCoreReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory
 * JD-Core Version:    0.7.0.1
 */