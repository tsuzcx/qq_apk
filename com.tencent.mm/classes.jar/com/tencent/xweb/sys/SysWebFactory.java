package com.tencent.xweb.sys;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.aj;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public class SysWebFactory
  implements l.a
{
  private static final String TAG = "XWEB.SysWebFactory";
  static SysWebFactory sInstance;
  
  public static SysWebFactory getInstance()
  {
    AppMethodBeat.i(153677);
    if (sInstance == null)
    {
      aj.iwN();
      sInstance = new SysWebFactory();
    }
    SysWebFactory localSysWebFactory = sInstance;
    AppMethodBeat.o(153677);
    return localSysWebFactory;
  }
  
  private static <T> T runOnUiThreadBlocking(Callable<T> paramCallable)
  {
    AppMethodBeat.i(153687);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramCallable = paramCallable.call();
      AppMethodBeat.o(153687);
      return paramCallable;
    }
    paramCallable = new FutureTask(paramCallable);
    new Handler(Looper.getMainLooper()).post(paramCallable);
    paramCallable = paramCallable.get();
    AppMethodBeat.o(153687);
    return paramCallable;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(153684);
    try
    {
      android.webkit.WebView localWebView = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        localWebView.removeJavascriptInterface("accessibility");
        localWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      localWebView.clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      AppMethodBeat.o(153684);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("SysWebFactory", "clearAllWebViewCache failed " + paramContext.getMessage());
      AppMethodBeat.o(153684);
    }
  }
  
  public IWebView createWebView(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153679);
    try
    {
      paramWebView = new e(paramWebView);
      AppMethodBeat.o(153679);
      return paramWebView;
    }
    catch (Throwable paramWebView)
    {
      String str = paramWebView.getMessage();
      if ((str != null) && (str.contains("Calling View methods on another thread than the UI thread.")))
      {
        Log.e("XWEB.SysWebFactory", "setNeedEnforceMainLooper=true", paramWebView);
        a.ixx();
      }
      AppMethodBeat.o(153679);
      throw paramWebView;
    }
  }
  
  public IWebStorage createWebviewStorage()
  {
    return null;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(153678);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(153678);
      return null;
    }
    if ((!paramString.equals("STR_CMD_GET_DEBUG_VIEW")) && (paramString.equals("STR_CMD_GET_UPDATER")))
    {
      AppMethodBeat.o(153678);
      return null;
    }
    AppMethodBeat.o(153678);
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(153685);
    Object localObject;
    if (a.ixy())
    {
      localObject = new a();
      AppMethodBeat.o(153685);
      return localObject;
    }
    try
    {
      localObject = (CookieInternal.ICookieManagerInternal)runOnUiThreadBlocking(new Callable() {});
      AppMethodBeat.o(153685);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWEB.SysWebFactory", "getCookieManager", localException);
      a locala = new a();
      AppMethodBeat.o(153685);
      return locala;
    }
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(153686);
    Object localObject;
    if (a.ixy())
    {
      localObject = new b();
      AppMethodBeat.o(153686);
      return localObject;
    }
    try
    {
      localObject = (CookieInternal.ICookieSyncManagerInternal)runOnUiThreadBlocking(new Callable() {});
      AppMethodBeat.o(153686);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWEB.SysWebFactory", "getCookieSyncManager", localException);
      b localb = new b();
      AppMethodBeat.o(153686);
      return localb;
    }
  }
  
  public IJsRuntime getJsCore(JsRuntime.JsRuntimeType paramJsRuntimeType, Context paramContext)
  {
    return null;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(205318);
    f localf = new f();
    AppMethodBeat.o(205318);
    return localf;
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(153682);
    boolean bool = a.hasInited();
    AppMethodBeat.o(153682);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(153683);
    boolean bool = a.hasInitedCallback();
    AppMethodBeat.o(153683);
    return bool;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(153681);
    a.ixz();
    AppMethodBeat.o(153681);
  }
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(153680);
    aj.iwN();
    a.b(paramPreInitCallback);
    AppMethodBeat.o(153680);
    return true;
  }
  
  public boolean isCoreReady()
  {
    return true;
  }
  
  static final class a
  {
    private static boolean aacJ;
    private static boolean aafs;
    private static Boolean aaft;
    private static final AtomicBoolean aafu;
    
    static
    {
      AppMethodBeat.i(153676);
      aacJ = false;
      aafs = false;
      aaft = null;
      aafu = new AtomicBoolean(false);
      AppMethodBeat.o(153676);
    }
    
    public static void b(WebView.PreInitCallback paramPreInitCallback)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(153674);
          if (aacJ)
          {
            AppMethodBeat.o(153674);
            return;
          }
          if (!ixw())
          {
            aacJ = true;
            if (paramPreInitCallback != null) {
              paramPreInitCallback.onCoreInitFinished();
            }
            AppMethodBeat.o(153674);
            continue;
          }
          if (!aafu.get()) {
            break label84;
          }
        }
        finally {}
        if (paramPreInitCallback != null)
        {
          paramPreInitCallback.onCoreInitFinished();
          AppMethodBeat.o(153674);
          continue;
          label84:
          paramPreInitCallback = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(153672);
              try
              {
                SysWebFactory.a.access$000();
                SysWebFactory.a.bfm();
                if (this.PDG != null) {
                  this.PDG.onCoreInitFinished();
                }
                AppMethodBeat.o(153672);
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
              {
                Log.e("SysWebFactory.preIniter", "link error, may be abi not match, try xweb core");
                com.tencent.xweb.WebView._initWebviewCore(XWalkEnvironment.getApplicationContext(), WebView.c.aabm, this.PDG, true);
                AppMethodBeat.o(153672);
                return;
              }
              catch (Exception localException1) {}
              try
              {
                Log.e("SysWebFactory.preIniter", "PathUtils.getDataDirectory = ".concat(String.valueOf(g.pf("org.chromium.base.PathUtils", "getDataDirectory").toString())));
                Log.e("SysWebFactory.preIniter", "ensureSystemWebViewGlobalLooper failed " + localException1.getMessage());
                h.u(577L, 233L, 1L);
                AppMethodBeat.o(153672);
                return;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Log.e("SysWebFactory.preIniter", "try reflect to PathUtils failed " + localException2.getMessage());
                }
              }
            }
          };
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            paramPreInitCallback.run();
            AppMethodBeat.o(153674);
          }
          else
          {
            new Handler(Looper.getMainLooper()).post(paramPreInitCallback);
          }
        }
        else
        {
          AppMethodBeat.o(153674);
        }
      }
    }
    
    public static boolean hasInited()
    {
      return aacJ;
    }
    
    public static boolean hasInitedCallback()
    {
      return aafs;
    }
    
    private static boolean ixw()
    {
      AppMethodBeat.i(183736);
      if (aaft == null) {
        aaft = Boolean.valueOf(XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").getBoolean("isEnforceMainLooper", false));
      }
      boolean bool = aaft.booleanValue();
      AppMethodBeat.o(183736);
      return bool;
    }
    
    public static void ixx()
    {
      AppMethodBeat.i(183737);
      XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").edit().putBoolean("isEnforceMainLooper", true).apply();
      AppMethodBeat.o(183737);
    }
    
    public static boolean ixy()
    {
      AppMethodBeat.i(153673);
      if (!ixw())
      {
        AppMethodBeat.o(153673);
        return true;
      }
      boolean bool = aafu.get();
      AppMethodBeat.o(153673);
      return bool;
    }
    
    public static void ixz()
    {
      aafs = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory
 * JD-Core Version:    0.7.0.1
 */