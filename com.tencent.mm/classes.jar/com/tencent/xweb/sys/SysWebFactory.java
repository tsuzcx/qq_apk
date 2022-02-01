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
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.ao;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public class SysWebFactory
  implements WebViewWrapperFactory.IWebViewProvider
{
  private static final String TAG = "SysWebFactory";
  private static SysWebFactory sInstance;
  
  public static SysWebFactory getInstance()
  {
    AppMethodBeat.i(153677);
    if (sInstance == null)
    {
      ao.kgs();
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
    finally
    {
      Log.e("SysWebFactory", "clearAllWebViewCache error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(153684);
    }
  }
  
  public IWebView createWebView(com.tencent.xweb.WebView paramWebView)
  {
    AppMethodBeat.i(153679);
    try
    {
      paramWebView = new f(paramWebView);
      AppMethodBeat.o(153679);
      return paramWebView;
    }
    finally
    {
      String str = paramWebView.getMessage();
      if ((str != null) && (str.contains("Calling View methods on another thread than the UI thread.")))
      {
        Log.e("SysWebFactory", "createWebView error:".concat(String.valueOf(paramWebView)));
        a.khr();
      }
      AppMethodBeat.o(153679);
    }
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(212717);
    e locale = new e();
    AppMethodBeat.o(212717);
    return locale;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(153678);
    AppMethodBeat.o(153678);
    return null;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(153685);
    Object localObject1;
    if (a.khs())
    {
      localObject1 = new a();
      AppMethodBeat.o(153685);
      return localObject1;
    }
    try
    {
      localObject1 = (CookieInternal.ICookieManagerInternal)runOnUiThreadBlocking(new Callable() {});
      AppMethodBeat.o(153685);
      return localObject1;
    }
    finally
    {
      Log.e("SysWebFactory", "getCookieManager error:".concat(String.valueOf(localObject2)));
      a locala = new a();
      AppMethodBeat.o(153685);
      return locala;
    }
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(153686);
    Object localObject1;
    if (a.khs())
    {
      localObject1 = new b();
      AppMethodBeat.o(153686);
      return localObject1;
    }
    try
    {
      localObject1 = (CookieInternal.ICookieSyncManagerInternal)runOnUiThreadBlocking(new Callable() {});
      AppMethodBeat.o(153686);
      return localObject1;
    }
    finally
    {
      Log.e("SysWebFactory", "getCookieSyncManager error:".concat(String.valueOf(localObject2)));
      b localb = new b();
      AppMethodBeat.o(153686);
      return localb;
    }
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(212721);
    g localg = new g();
    AppMethodBeat.o(212721);
    return localg;
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
  
  public void initEnviroment(Context paramContext) {}
  
  public void initInterface() {}
  
  public void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(212691);
    a.kht();
    AppMethodBeat.o(212691);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(153680);
    Log.i("SysWebFactory", "initWebviewCore");
    ao.kgs();
    a.c(paramPreInitCallback);
    AppMethodBeat.o(153680);
    return true;
  }
  
  public boolean isCoreReady()
  {
    return true;
  }
  
  static final class a
  {
    private static boolean aimi;
    private static Boolean aimj;
    private static final AtomicBoolean aimk;
    private static boolean mHasInited;
    
    static
    {
      AppMethodBeat.i(212678);
      mHasInited = false;
      aimi = false;
      aimj = null;
      aimk = new AtomicBoolean(false);
      AppMethodBeat.o(212678);
    }
    
    public static void c(WebView.PreInitCallback paramPreInitCallback)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(212667);
          if (mHasInited)
          {
            AppMethodBeat.o(212667);
            return;
          }
          if (!khq())
          {
            mHasInited = true;
            if (paramPreInitCallback != null) {
              paramPreInitCallback.onCoreInitFinished();
            }
            AppMethodBeat.o(212667);
            continue;
          }
          if (!aimk.get()) {
            break label84;
          }
        }
        finally {}
        if (paramPreInitCallback != null)
        {
          paramPreInitCallback.onCoreInitFinished();
          AppMethodBeat.o(212667);
          continue;
          label84:
          paramPreInitCallback = new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 27
              //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: invokestatic 36	com/tencent/xweb/sys/SysWebFactory$a:access$000	()V
              //   8: invokestatic 40	com/tencent/xweb/sys/SysWebFactory$a:bDd	()Z
              //   11: pop
              //   12: aload_0
              //   13: getfield 19	com/tencent/xweb/sys/SysWebFactory$a$1:Wul	Lcom/tencent/xweb/WebView$PreInitCallback;
              //   16: ifnull +12 -> 28
              //   19: aload_0
              //   20: getfield 19	com/tencent/xweb/sys/SysWebFactory$a$1:Wul	Lcom/tencent/xweb/WebView$PreInitCallback;
              //   23: invokeinterface 45 1 0
              //   28: ldc 27
              //   30: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   33: return
              //   34: astore_1
              //   35: ldc 50
              //   37: ldc 52
              //   39: invokestatic 58	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   42: invokestatic 64	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
              //   45: getstatic 70	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
              //   48: aload_0
              //   49: getfield 19	com/tencent/xweb/sys/SysWebFactory$a$1:Wul	Lcom/tencent/xweb/WebView$PreInitCallback;
              //   52: iconst_1
              //   53: invokestatic 76	com/tencent/xweb/WebView:initWebviewCore	(Landroid/content/Context;Lcom/tencent/xweb/WebView$WebViewKind;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
              //   56: pop
              //   57: ldc 27
              //   59: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   62: return
              //   63: astore_1
              //   64: ldc 50
              //   66: ldc 78
              //   68: ldc 80
              //   70: ldc 82
              //   72: invokestatic 88	com/tencent/xweb/util/k:rc	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
              //   75: invokevirtual 92	java/lang/Object:toString	()Ljava/lang/String;
              //   78: invokestatic 98	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   81: invokevirtual 102	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   84: invokestatic 58	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   87: ldc 50
              //   89: ldc 104
              //   91: aload_1
              //   92: invokestatic 98	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   95: invokevirtual 102	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   98: invokestatic 58	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   101: ldc2_w 105
              //   104: ldc2_w 107
              //   107: lconst_1
              //   108: invokestatic 114	com/tencent/xweb/util/l:y	(JJJ)V
              //   111: ldc 27
              //   113: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   116: return
              //   117: astore_2
              //   118: ldc 50
              //   120: ldc 116
              //   122: aload_2
              //   123: invokestatic 98	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   126: invokevirtual 102	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   129: invokestatic 58	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
              //   132: goto -45 -> 87
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	135	0	this	1
              //   34	1	1	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
              //   63	29	1	localObject1	Object
              //   117	6	2	localObject2	Object
              // Exception table:
              //   from	to	target	type
              //   5	28	34	java/lang/UnsatisfiedLinkError
              //   5	28	63	finally
              //   64	87	117	finally
            }
          };
          if (Looper.getMainLooper() == Looper.myLooper())
          {
            paramPreInitCallback.run();
            AppMethodBeat.o(212667);
          }
          else
          {
            new Handler(Looper.getMainLooper()).post(paramPreInitCallback);
          }
        }
        else
        {
          AppMethodBeat.o(212667);
        }
      }
    }
    
    public static boolean hasInited()
    {
      return mHasInited;
    }
    
    public static boolean hasInitedCallback()
    {
      return aimi;
    }
    
    private static boolean khq()
    {
      AppMethodBeat.i(212654);
      if (aimj == null) {
        aimj = Boolean.valueOf(XWalkSharedPreferenceUtil.getMMKVSharedPreferences("SysWebFactory.PreIniter").getBoolean("isEnforceMainLooper", false));
      }
      boolean bool = aimj.booleanValue();
      AppMethodBeat.o(212654);
      return bool;
    }
    
    public static void khr()
    {
      AppMethodBeat.i(212658);
      XWalkSharedPreferenceUtil.getMMKVSharedPreferences("SysWebFactory.PreIniter").edit().putBoolean("isEnforceMainLooper", true).apply();
      AppMethodBeat.o(212658);
    }
    
    public static boolean khs()
    {
      AppMethodBeat.i(212663);
      if (!khq())
      {
        AppMethodBeat.o(212663);
        return true;
      }
      boolean bool = aimk.get();
      AppMethodBeat.o(212663);
      return bool;
    }
    
    public static void kht()
    {
      aimi = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory
 * JD-Core Version:    0.7.0.1
 */