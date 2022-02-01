package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5CoreEntry;
import com.tencent.smtt.export.external.interfaces.IX5CoreMessy;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 0;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final Lock c;
  private static OutputStream d;
  private static Context j;
  public static boolean mSysWebviewCreated;
  public static boolean mWebViewCreated;
  private static BroadcastReceiver n;
  private static com.tencent.smtt.utils.o o;
  private static Method p;
  private static String s;
  private static Paint y;
  private static boolean z;
  private Object A;
  private View.OnLongClickListener B;
  int a;
  private final String b;
  private boolean e;
  private IX5WebViewBase f;
  private b g;
  private WebSettings h;
  private Context i;
  private boolean k;
  private n l;
  private boolean m;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient q;
  private WebChromeClient r;
  private final int t;
  private final int u;
  private final int v;
  private final String w;
  private final String x;
  
  static
  {
    AppMethodBeat.i(54317);
    c = new ReentrantLock();
    d = null;
    j = null;
    n = null;
    mWebViewCreated = false;
    o = null;
    p = null;
    s = null;
    mSysWebviewCreated = false;
    y = null;
    z = true;
    NIGHT_MODE_ALPHA = 153;
    AppMethodBeat.o(54317);
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(54156);
    this.b = "WebView";
    this.e = false;
    this.h = null;
    this.i = null;
    this.a = 0;
    this.k = false;
    this.l = null;
    this.m = false;
    this.q = null;
    this.r = null;
    this.t = 1;
    this.u = 2;
    this.v = 3;
    this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
    this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
    this.A = null;
    this.B = null;
    mWebViewCreated = true;
    this.l = new n();
    this.l.a("init_all", (byte)1);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.i = paramContext;
      this.f = null;
      this.e = false;
      QbSdk.a(paramContext, "failed to createTBSWebview!");
      this.g = new b(paramContext, paramAttributeSet);
      CookieManager.getInstance().a(paramContext, true, false);
      CookieSyncManager.createInstance(this.i).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new f());
      mSysWebviewCreated = true;
      label249:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 402, new Throwable());
      c.a(paramContext, this);
      AppMethodBeat.o(54156);
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      }
      for (;;)
      {
        this.l.a("tbslog_init", (byte)1);
        TbsLog.initIfNeed(paramContext);
        this.l.a("tbslog_init", (byte)2);
        if (paramContext != null) {
          break;
        }
        paramContext = new IllegalArgumentException("Invalid context argument");
        AppMethodBeat.o(54156);
        throw paramContext;
        TbsLog.setWriteLogJIT(false);
      }
      if (o == null) {
        o = com.tencent.smtt.utils.o.a(paramContext);
      }
      if (o.a)
      {
        TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
        QbSdk.a(paramContext, "debug.conf force syswebview!");
      }
      a(paramContext, this.l);
      this.i = paramContext;
      if (paramContext != null) {
        j = paramContext.getApplicationContext();
      }
      if ((this.e) && (!QbSdk.a))
      {
        this.l.a("init_x5_webview", (byte)1);
        this.f = TbsOneGreyInfoHelper.getCoreEntry().createX5WebView(paramContext, false);
        this.l.a("init_x5_webview", (byte)2);
        if ((this.f == null) || (this.f.getView() == null))
        {
          TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
          this.f = null;
          this.e = false;
          QbSdk.a(paramContext, "failed to createTBSWebview!");
          a(paramContext, this.l);
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new b(paramContext, paramAttributeSet);
          }
        }
      }
      for (;;)
      {
        TbsLog.i("WebView", "SystemWebView Created Success! #1");
        CookieManager.getInstance().a(paramContext, true, false);
        CookieManager.getInstance().a();
        this.g.setFocusableInTouchMode(true);
        addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        try
        {
          if (Build.VERSION.SDK_INT >= 11)
          {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
          }
          label657:
          b(paramContext);
          TbsLog.writeLogToDisk();
          o.a(paramContext);
          c.a(paramContext, this);
          AppMethodBeat.o(54156);
          return;
          this.g = new b(paramContext);
          continue;
          TbsLog.i("WebView", "X5 WebView Created Success!!");
          this.f.getView().setFocusableInTouchMode(true);
          a(paramAttributeSet);
          addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
          this.f.setDownloadListener(new b(this, null, this.e));
          this.f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebChromeClientExtension())
          {
            public void invalidate() {}
            
            public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              AppMethodBeat.i(55116);
              super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
              WebView.a(WebView.this, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
              AppMethodBeat.o(55116);
            }
          });
          try
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              removeJavascriptInterface("searchBoxJavaBridge_");
              removeJavascriptInterface("accessibility");
              removeJavascriptInterface("accessibilityTraversal");
            }
            label830:
            if (this.f != null)
            {
              TbsLog.writeLogToDisk();
              if (!TbsShareManager.isThirdPartyApp(paramContext))
              {
                paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
                if ((paramInt <= 0) || (paramInt == o.a().h(paramContext)) || (paramInt != o.a().i(paramContext))) {
                  break label1090;
                }
                o.a().n(paramContext);
              }
            }
            for (;;)
            {
              c.a(paramContext, this);
              paramContext = new StringBuilder("loadX5 -> isX5webview:");
              if (this.f != null) {
                paramBoolean = true;
              }
              paramContext.append(paramBoolean).append(",X5CoreVersion:").append(QbSdk.getTbsCoreVersionString());
              if (this.l != null)
              {
                this.l.a("load_url_gap", (byte)1);
                this.l.a("init_all", (byte)2);
              }
              AppMethodBeat.o(54156);
              return;
              this.f = null;
              if (TbsShareManager.isThirdPartyApp(this.i)) {}
              for (this.g = new b(paramContext, paramAttributeSet);; this.g = new b(paramContext))
              {
                TbsLog.i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().a(paramContext, true, false);
                CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                b(paramContext);
                TbsLog.writeLogToDisk();
                o.a(paramContext);
                break;
              }
              label1090:
              TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + o.a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + o.a().i(paramContext));
            }
          }
          catch (Throwable paramAttributeSet)
          {
            break label830;
          }
        }
        catch (Throwable paramAttributeSet)
        {
          break label657;
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label249;
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  public WebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.b = "WebView";
    this.e = false;
    this.h = null;
    this.i = null;
    this.a = 0;
    this.k = false;
    this.l = null;
    this.m = false;
    this.q = null;
    this.r = null;
    this.t = 1;
    this.u = 2;
    this.v = 3;
    this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
    this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
    this.A = null;
    this.B = null;
  }
  
  private void a(Context paramContext, n paramn)
  {
    AppMethodBeat.i(54167);
    if ((QbSdk.h) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramn != null) {
      paramn.a("x5_core_engine_init_sync", (byte)1);
    }
    v localv = v.a();
    localv.a(paramContext, paramn);
    this.e = localv.b();
    AppMethodBeat.o(54167);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    AppMethodBeat.i(54286);
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int[] arrayOfInt;
      int i3;
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        if (i1 >= i2) {
          break label158;
        }
        if (!paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars")) {
          break label165;
        }
        arrayOfInt = getResources().getIntArray(16842974);
        i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
        if (i3 == arrayOfInt[1])
        {
          this.f.getView().setVerticalScrollBarEnabled(false);
          this.f.getView().setHorizontalScrollBarEnabled(false);
        }
        else if (i3 == arrayOfInt[2])
        {
          this.f.getView().setVerticalScrollBarEnabled(false);
        }
      }
      catch (Exception paramAttributeSet)
      {
        AppMethodBeat.o(54286);
        return;
      }
      if (i3 == arrayOfInt[3])
      {
        this.f.getView().setHorizontalScrollBarEnabled(false);
        break label165;
        label158:
        AppMethodBeat.o(54286);
        return;
      }
      label165:
      i1 += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    AppMethodBeat.i(54297);
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200))
    {
      AppMethodBeat.o(54297);
      return false;
    }
    paramView = k.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null)
    {
      boolean bool = ((Boolean)paramView).booleanValue();
      AppMethodBeat.o(54297);
      return bool;
    }
    AppMethodBeat.o(54297);
    return false;
  }
  
  private void b(final Context paramContext)
  {
    AppMethodBeat.i(54157);
    if (n != null)
    {
      AppMethodBeat.o(54157);
      return;
    }
    n = new a(null);
    new Thread()
    {
      public void run()
      {
        AppMethodBeat.i(55020);
        try
        {
          if (Apn.getApnType(paramContext) == 3) {}
          for (boolean bool = true;; bool = false)
          {
            QbSdk.d = bool;
            QbSdk.e = System.currentTimeMillis();
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            paramContext.getApplicationContext().registerReceiver(WebView.e(), localIntentFilter);
            AppMethodBeat.o(55020);
            return;
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(55020);
        }
      }
    }.start();
    AppMethodBeat.o(54157);
  }
  
  private boolean c(Context paramContext)
  {
    AppMethodBeat.i(54165);
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0)
      {
        AppMethodBeat.o(54165);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(54165);
    }
    return false;
  }
  
  /* Error */
  private int d(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 650
    //   3: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iconst_1
    //   8: ldc_w 652
    //   11: invokestatic 657	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +24 -> 42
    //   21: aload_1
    //   22: aload 6
    //   24: invokestatic 660	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   27: astore 7
    //   29: aload 7
    //   31: ifnonnull +19 -> 50
    //   34: ldc_w 650
    //   37: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_m1
    //   41: ireturn
    //   42: ldc_w 650
    //   45: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_m1
    //   49: ireturn
    //   50: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 665 1 0
    //   58: ifeq +440 -> 498
    //   61: aload_1
    //   62: invokestatic 669	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   65: astore_1
    //   66: new 671	java/io/File
    //   69: dup
    //   70: new 499	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 672	java/lang/StringBuilder:<init>	()V
    //   77: aload_1
    //   78: invokevirtual 675	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: getstatic 678	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 680
    //   90: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: ldc_w 682
    //   99: invokespecial 684	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 687	java/io/File:exists	()Z
    //   107: istore_3
    //   108: iload_3
    //   109: ifne +26 -> 135
    //   112: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 690 1 0
    //   120: aload 7
    //   122: aload 6
    //   124: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   127: ldc_w 650
    //   130: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_m1
    //   134: ireturn
    //   135: new 695	java/util/Properties
    //   138: dup
    //   139: invokespecial 696	java/util/Properties:<init>	()V
    //   142: astore 5
    //   144: new 698	java/io/FileInputStream
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 701	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: astore 4
    //   154: aload 4
    //   156: astore_1
    //   157: aload 5
    //   159: aload 4
    //   161: invokevirtual 705	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   164: aload 4
    //   166: astore_1
    //   167: aload 4
    //   169: invokevirtual 708	java/io/FileInputStream:close	()V
    //   172: aload 4
    //   174: astore_1
    //   175: aload 5
    //   177: ldc_w 710
    //   180: invokevirtual 714	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnonnull +61 -> 248
    //   190: aload 4
    //   192: invokevirtual 708	java/io/FileInputStream:close	()V
    //   195: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   198: invokeinterface 690 1 0
    //   203: aload 7
    //   205: aload 6
    //   207: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   210: ldc_w 650
    //   213: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: iconst_m1
    //   217: ireturn
    //   218: astore_1
    //   219: ldc_w 716
    //   222: new 499	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 718
    //   229: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: invokevirtual 719	java/io/IOException:toString	()Ljava/lang/String;
    //   236: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 721	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto -50 -> 195
    //   248: aload 4
    //   250: astore_1
    //   251: aload 5
    //   253: invokestatic 726	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   256: istore_2
    //   257: aload 4
    //   259: astore_1
    //   260: ldc_w 716
    //   263: ldc_w 728
    //   266: iload_2
    //   267: invokestatic 731	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 734	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 736	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 4
    //   278: invokevirtual 708	java/io/FileInputStream:close	()V
    //   281: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   284: invokeinterface 690 1 0
    //   289: aload 7
    //   291: aload 6
    //   293: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   296: ldc_w 650
    //   299: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: iload_2
    //   303: ireturn
    //   304: astore_1
    //   305: ldc_w 716
    //   308: new 499	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 718
    //   315: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload_1
    //   319: invokevirtual 719	java/io/IOException:toString	()Ljava/lang/String;
    //   322: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 721	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -50 -> 281
    //   334: astore 5
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: astore_1
    //   342: ldc_w 716
    //   345: new 499	java/lang/StringBuilder
    //   348: dup
    //   349: ldc_w 738
    //   352: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   355: aload 5
    //   357: invokevirtual 739	java/lang/Exception:toString	()Ljava/lang/String;
    //   360: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 721	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 4
    //   371: ifnull +8 -> 379
    //   374: aload 4
    //   376: invokevirtual 708	java/io/FileInputStream:close	()V
    //   379: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   382: invokeinterface 690 1 0
    //   387: aload 7
    //   389: aload 6
    //   391: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   394: ldc_w 650
    //   397: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: iconst_m1
    //   401: ireturn
    //   402: astore_1
    //   403: ldc_w 716
    //   406: new 499	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 718
    //   413: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: invokevirtual 719	java/io/IOException:toString	()Ljava/lang/String;
    //   420: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 721	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto -50 -> 379
    //   432: astore 4
    //   434: aconst_null
    //   435: astore_1
    //   436: aload_1
    //   437: ifnull +7 -> 444
    //   440: aload_1
    //   441: invokevirtual 708	java/io/FileInputStream:close	()V
    //   444: getstatic 119	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   447: invokeinterface 690 1 0
    //   452: aload 7
    //   454: aload 6
    //   456: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   459: ldc_w 650
    //   462: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: aload 4
    //   467: athrow
    //   468: astore_1
    //   469: ldc_w 716
    //   472: new 499	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 718
    //   479: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload_1
    //   483: invokevirtual 719	java/io/IOException:toString	()Ljava/lang/String;
    //   486: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 534	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 721	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto -51 -> 444
    //   498: aload 7
    //   500: aload 6
    //   502: invokestatic 693	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   505: ldc_w 650
    //   508: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   511: iconst_m1
    //   512: ireturn
    //   513: astore 4
    //   515: goto -79 -> 436
    //   518: astore 5
    //   520: goto -181 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	WebView
    //   0	523	1	paramContext	Context
    //   256	47	2	i1	int
    //   107	2	3	bool	boolean
    //   152	223	4	localFileInputStream	java.io.FileInputStream
    //   432	34	4	localObject1	Object
    //   513	1	4	localObject2	Object
    //   142	110	5	localObject3	Object
    //   334	22	5	localException1	Exception
    //   518	1	5	localException2	Exception
    //   14	487	6	localFileOutputStream	FileOutputStream
    //   27	472	7	localFileLock	java.nio.channels.FileLock
    // Exception table:
    //   from	to	target	type
    //   190	195	218	java/io/IOException
    //   276	281	304	java/io/IOException
    //   61	108	334	java/lang/Exception
    //   135	154	334	java/lang/Exception
    //   374	379	402	java/io/IOException
    //   61	108	432	finally
    //   135	154	432	finally
    //   440	444	468	java/io/IOException
    //   157	164	513	finally
    //   167	172	513	finally
    //   175	185	513	finally
    //   251	257	513	finally
    //   260	276	513	finally
    //   342	369	513	finally
    //   157	164	518	java/lang/Exception
    //   167	172	518	java/lang/Exception
    //   175	185	518	java/lang/Exception
    //   251	257	518	java/lang/Exception
    //   260	276	518	java/lang/Exception
  }
  
  static void d()
  {
    AppMethodBeat.i(54302);
    Runnable local9 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(54930);
        if (WebView.h() == null)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
          AppMethodBeat.o(54930);
          return;
        }
        e locale = e.a(true);
        if (e.b)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
          AppMethodBeat.o(54930);
          return;
        }
        l locall = l.a(WebView.h());
        int i = locall.c();
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(i)));
        if (i == 2)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
          locale.a(String.valueOf(locall.b()));
          locale.b(true);
          AppMethodBeat.o(54930);
          return;
        }
        int j = locall.b("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(j)));
        if (j == 1)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
          locale.a(String.valueOf(locall.c("copy_core_ver")));
          locale.b(true);
          AppMethodBeat.o(54930);
          return;
        }
        if ((!v.a().b()) && ((i == 3) || (j == 3)))
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
          locale.a(String.valueOf(e.d()));
          locale.b(true);
        }
        AppMethodBeat.o(54930);
      }
    };
    try
    {
      new Thread(local9).start();
      AppMethodBeat.o(54302);
      return;
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("webview", "updateRebootStatus excpetion: ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(54302);
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(54186);
    if (!v.a().b()) {
      k.a("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(54186);
  }
  
  private void e(Context paramContext)
  {
    AppMethodBeat.i(54296);
    try
    {
      paramContext = QbSdk.getTbsFolderDir(paramContext);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      boolean bool = paramContext.exists();
      if (!bool)
      {
        AppMethodBeat.o(54296);
        return;
      }
      paramContext.delete();
      AppMethodBeat.o(54296);
      return;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
      AppMethodBeat.o(54296);
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(54185);
    if (!v.a().b()) {
      k.a("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(54185);
  }
  
  public static String findAddress(String paramString)
  {
    AppMethodBeat.i(54245);
    if (!v.a().b())
    {
      paramString = android.webkit.WebView.findAddress(paramString);
      AppMethodBeat.o(54245);
      return paramString;
    }
    AppMethodBeat.o(54245);
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    i2 = 0;
    AppMethodBeat.i(54300);
    if (paramContext == null)
    {
      AppMethodBeat.o(54300);
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";tbs_sdk_version:43804;";
    i1 = i2;
    if ("com.tencent.mm".equals(paramContext.getApplicationInfo().packageName)) {}
    try
    {
      Class.forName("de.robv.android.xposed.XposedBridge");
      i1 = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        i1 = i2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    if (i1 != 0)
    {
      paramContext = str + "isXposed=true;";
      AppMethodBeat.o(54300);
      return paramContext;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e.a(true).e());
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey("weapp_id")) && (QbSdk.mSettings.containsKey("weapp_name")))
    {
      paramContext = "weapp_id:" + QbSdk.mSettings.get("weapp_id") + ";weapp_name:" + QbSdk.mSettings.get("weapp_name") + ";";
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext);
    }
    if (localStringBuilder.length() > 8192)
    {
      paramContext = localStringBuilder.substring(localStringBuilder.length() - 8192);
      AppMethodBeat.o(54300);
      return paramContext;
    }
    paramContext = localStringBuilder.toString();
    AppMethodBeat.o(54300);
    return paramContext;
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    AppMethodBeat.i(54225);
    if (!v.a().b())
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        AppMethodBeat.o(54225);
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)k.a("android.webkit.WebView", "getCurrentWebViewPackage");
        AppMethodBeat.o(54225);
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(54225);
        return null;
      }
    }
    AppMethodBeat.o(54225);
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 855
    //   6: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 561	com/tencent/smtt/sdk/v:a	()Lcom/tencent/smtt/sdk/v;
    //   12: invokevirtual 564	com/tencent/smtt/sdk/v:b	()Z
    //   15: ifne +24 -> 39
    //   18: ldc_w 757
    //   21: ldc_w 856
    //   24: invokestatic 761	com/tencent/smtt/utils/k:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   27: astore_0
    //   28: ldc_w 855
    //   31: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc_w 855
    //   44: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -13 -> 34
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	14	0	localObject1	Object
    //   50	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	34	50	finally
    //   41	47	50	finally
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(54283);
    int i1 = QbSdk.getTbsVersion(paramContext);
    AppMethodBeat.o(54283);
    return i1;
  }
  
  public static boolean getTbsNeedReboot()
  {
    AppMethodBeat.i(54301);
    d();
    boolean bool = e.a(true).f();
    TbsLog.d("TbsNeedReboot", "WebView.getTbsNeedReboot--ret = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(54301);
    return bool;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43804;
  }
  
  private long i()
  {
    AppMethodBeat.i(54184);
    synchronized (QbSdk.g)
    {
      if (QbSdk.d)
      {
        QbSdk.f += System.currentTimeMillis() - QbSdk.e;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f);
      }
      long l1 = QbSdk.f / 1000L;
      QbSdk.f = 0L;
      QbSdk.e = System.currentTimeMillis();
      TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime wifiConnectedTime=".concat(String.valueOf(l1)));
      AppMethodBeat.o(54184);
      return l1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(54289);
        if (paramBoolean == z)
        {
          AppMethodBeat.o(54289);
          return;
        }
        z = paramBoolean;
        if (y == null)
        {
          Paint localPaint = new Paint();
          y = localPaint;
          localPaint.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (y.getAlpha() == NIGHT_MODE_ALPHA) {
            break label115;
          }
          y.setAlpha(NIGHT_MODE_ALPHA);
          AppMethodBeat.o(54289);
          continue;
        }
        if (y.getAlpha() == 255) {
          break label115;
        }
      }
      finally {}
      y.setAlpha(255);
      label115:
      AppMethodBeat.o(54289);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(54202);
    Object localObject = v.a();
    if ((localObject != null) && (((v)localObject).b()))
    {
      TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().setWebContentsDebuggingEnabled(paramBoolean);
      AppMethodBeat.o(54202);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        localObject = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
        p = (Method)localObject;
        if (localObject != null)
        {
          p.setAccessible(true);
          p.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
        }
        AppMethodBeat.o(54202);
        return;
      }
      catch (Exception localException)
      {
        TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
      }
    }
    AppMethodBeat.o(54202);
  }
  
  protected void a()
  {
    AppMethodBeat.i(54273);
    String str3;
    String str2;
    String str1;
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      TbsLog.d("sdkreport", "webview.onDetachedFromWindow--Pv=" + this.a);
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.b.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onDetachedFromWindow();
      AppMethodBeat.o(54273);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.w("tbsOnDetachedFromWindow", "exception: ".concat(String.valueOf(localThrowable)));
        boolean bool = false;
      }
    }
  }
  
  void a(Context paramContext)
  {
    AppMethodBeat.i(54295);
    int i1 = d(paramContext);
    if (i1 != -1) {}
    for (String str = "PV=" + String.valueOf(i1 + 1);; str = "PV=1")
    {
      paramContext = QbSdk.getTbsFolderDir(paramContext);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      try
      {
        paramContext.getParentFile().mkdirs();
        if ((!paramContext.isFile()) || (!paramContext.exists())) {
          paramContext.createNewFile();
        }
        FileOutputStream localFileOutputStream = new FileOutputStream(paramContext, false);
        d = localFileOutputStream;
        localFileOutputStream.write(str.getBytes());
      }
      finally
      {
        TbsLog.d("writetbscorepvfile", "writepvfile finish ");
        if (d != null) {
          d.flush();
        }
        AppMethodBeat.o(54295);
      }
      try
      {
        TbsLog.d("writetbscorepvfile", "writepvfile finish ");
        if (d == null) {
          break label243;
        }
        d.flush();
        AppMethodBeat.o(54295);
        return;
      }
      catch (Throwable localThrowable)
      {
        TbsLog.d("writetbscorepvfile", "file.getAbsolutePath=" + paramContext.getAbsolutePath() + " Throwable=" + localThrowable);
        AppMethodBeat.o(54295);
        return;
      }
    }
    label243:
    AppMethodBeat.o(54295);
  }
  
  void a(android.webkit.WebView paramWebView) {}
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(54255);
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      AppMethodBeat.o(54255);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(54255);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(54298);
    if (!this.e)
    {
      this.g.addView(paramView);
      AppMethodBeat.o(54298);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = k.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      AppMethodBeat.o(54298);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(54298);
    }
  }
  
  android.webkit.WebView b()
  {
    if (!this.e) {
      return this.g;
    }
    return null;
  }
  
  IX5WebViewBase c()
  {
    return this.f;
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(54204);
    if (!this.e)
    {
      bool = this.g.canGoBack();
      AppMethodBeat.o(54204);
      return bool;
    }
    boolean bool = this.f.canGoBack();
    AppMethodBeat.o(54204);
    return bool;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    AppMethodBeat.i(54208);
    if (!this.e)
    {
      bool = this.g.canGoBackOrForward(paramInt);
      AppMethodBeat.o(54208);
      return bool;
    }
    boolean bool = this.f.canGoBackOrForward(paramInt);
    AppMethodBeat.o(54208);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(54206);
    if (!this.e)
    {
      bool = this.g.canGoForward();
      AppMethodBeat.o(54206);
      return bool;
    }
    boolean bool = this.f.canGoForward();
    AppMethodBeat.o(54206);
    return bool;
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    AppMethodBeat.i(54263);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.g, "canZoomIn");
        if (localObject == null)
        {
          AppMethodBeat.o(54263);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54263);
        return bool;
      }
      AppMethodBeat.o(54263);
      return false;
    }
    boolean bool = this.f.canZoomIn();
    AppMethodBeat.o(54263);
    return bool;
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    AppMethodBeat.i(54265);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.g, "canZoomOut");
        if (localObject == null)
        {
          AppMethodBeat.o(54265);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54265);
        return bool;
      }
      AppMethodBeat.o(54265);
      return false;
    }
    boolean bool = this.f.canZoomOut();
    AppMethodBeat.o(54265);
    return bool;
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    AppMethodBeat.i(54213);
    if (!this.e)
    {
      localObject = k.a(this.g, "capturePicture");
      if (localObject == null)
      {
        AppMethodBeat.o(54213);
        return null;
      }
      localObject = (Picture)localObject;
      AppMethodBeat.o(54213);
      return localObject;
    }
    Object localObject = this.f.capturePicture();
    AppMethodBeat.o(54213);
    return localObject;
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(54237);
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      AppMethodBeat.o(54237);
      return;
    }
    this.f.clearCache(paramBoolean);
    AppMethodBeat.o(54237);
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(54238);
    if (!this.e)
    {
      this.g.clearFormData();
      AppMethodBeat.o(54238);
      return;
    }
    this.f.clearFormData();
    AppMethodBeat.o(54238);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(54239);
    if (!this.e)
    {
      this.g.clearHistory();
      AppMethodBeat.o(54239);
      return;
    }
    this.f.clearHistory();
    AppMethodBeat.o(54239);
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    AppMethodBeat.i(54247);
    if (!this.e)
    {
      this.g.clearMatches();
      AppMethodBeat.o(54247);
      return;
    }
    this.f.clearMatches();
    AppMethodBeat.o(54247);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(54240);
    if (!this.e)
    {
      this.g.clearSslPreferences();
      AppMethodBeat.o(54240);
      return;
    }
    this.f.clearSslPreferences();
    AppMethodBeat.o(54240);
  }
  
  @Deprecated
  public void clearView()
  {
    AppMethodBeat.i(54212);
    if (!this.e)
    {
      k.a(this.g, "clearView");
      AppMethodBeat.o(54212);
      return;
    }
    this.f.clearView();
    AppMethodBeat.o(54212);
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(54163);
    try
    {
      if (this.e)
      {
        localMethod = k.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54163);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54163);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54163);
    }
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(54159);
    try
    {
      if (this.e)
      {
        localMethod = k.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54159);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54159);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54159);
    }
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(54162);
    try
    {
      if (this.e)
      {
        i1 = ((Integer)k.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(54162);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54162);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54162);
    }
    return -1;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(54270);
    if (!this.e)
    {
      this.g.computeScroll();
      AppMethodBeat.o(54270);
      return;
    }
    this.f.computeScroll();
    AppMethodBeat.o(54270);
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(54161);
    try
    {
      if (this.e)
      {
        localMethod = k.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54161);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54161);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54161);
    }
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(54160);
    try
    {
      if (this.e)
      {
        localMethod = k.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54160);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54160);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54160);
    }
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(54164);
    try
    {
      if (this.e)
      {
        i1 = ((Integer)k.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(54164);
        return i1;
      }
      Method localMethod = k.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(54164);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54164);
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(54241);
    if (this.e)
    {
      localWebBackForwardList = WebBackForwardList.a(this.f.copyBackForwardList());
      AppMethodBeat.o(54241);
      return localWebBackForwardList;
    }
    WebBackForwardList localWebBackForwardList = WebBackForwardList.a(this.g.copyBackForwardList());
    AppMethodBeat.o(54241);
    return localWebBackForwardList;
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    AppMethodBeat.i(54158);
    if (this.e) {
      try
      {
        paramString = this.f.createPrintDocumentAdapter(paramString);
        AppMethodBeat.o(54158);
        return paramString;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(54158);
        return null;
      }
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(54158);
      return null;
    }
    paramString = k.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54158);
    return paramString;
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(54251);
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
    AppMethodBeat.o(54251);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(54183);
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new Thread("WebviewDestroy")
        {
          public void run()
          {
            AppMethodBeat.i(54959);
            WebView.this.tbsWebviewDestroy(false);
            AppMethodBeat.o(54959);
          }
        }.start();
        if (this.e)
        {
          this.f.destroy();
          AppMethodBeat.o(54183);
          return;
        }
        this.g.destroy();
        AppMethodBeat.o(54183);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      tbsWebviewDestroy(true);
      AppMethodBeat.o(54183);
      return;
    }
    tbsWebviewDestroy(true);
    AppMethodBeat.o(54183);
  }
  
  public void documentHasImages(Message paramMessage)
  {
    AppMethodBeat.i(54248);
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      AppMethodBeat.o(54248);
      return;
    }
    this.f.documentHasImages(paramMessage);
    AppMethodBeat.o(54248);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    AppMethodBeat.i(54268);
    if (!this.e)
    {
      k.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      AppMethodBeat.o(54268);
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
    AppMethodBeat.o(54268);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54282);
    Method localMethod;
    if (this.e) {
      try
      {
        localMethod = k.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        AppMethodBeat.o(54282);
        return;
      }
      catch (Exception paramValueCallback)
      {
        loadUrl(paramString);
        AppMethodBeat.o(54282);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
        AppMethodBeat.o(54282);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(54282);
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    AppMethodBeat.i(54244);
    if (!this.e)
    {
      paramString = k.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null)
      {
        AppMethodBeat.o(54244);
        return 0;
      }
      i1 = ((Integer)paramString).intValue();
      AppMethodBeat.o(54244);
      return i1;
    }
    int i1 = this.f.findAll(paramString);
    AppMethodBeat.o(54244);
    return i1;
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(54246);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        k.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(54246);
      }
    }
    else {
      this.f.findAllAsync(paramString);
    }
    AppMethodBeat.o(54246);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    AppMethodBeat.i(54269);
    if (!this.e)
    {
      paramString = (View)k.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(54269);
      return paramString;
    }
    paramString = this.f.findHierarchyView(paramString, paramInt);
    AppMethodBeat.o(54269);
    return paramString;
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(54243);
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      AppMethodBeat.o(54243);
      return;
    }
    this.f.findNext(paramBoolean);
    AppMethodBeat.o(54243);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(54261);
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      AppMethodBeat.o(54261);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
    AppMethodBeat.o(54261);
  }
  
  @Deprecated
  public void freeMemory()
  {
    AppMethodBeat.i(54236);
    if (!this.e)
    {
      k.a(this.g, "freeMemory");
      AppMethodBeat.o(54236);
      return;
    }
    this.f.freeMemory();
    AppMethodBeat.o(54236);
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(54177);
    if (!this.e)
    {
      localSslCertificate = this.g.getCertificate();
      AppMethodBeat.o(54177);
      return localSslCertificate;
    }
    SslCertificate localSslCertificate = this.f.getCertificate();
    AppMethodBeat.o(54177);
    return localSslCertificate;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(54230);
    if (!this.e)
    {
      i1 = this.g.getContentHeight();
      AppMethodBeat.o(54230);
      return i1;
    }
    int i1 = this.f.getContentHeight();
    AppMethodBeat.o(54230);
    return i1;
  }
  
  public int getContentWidth()
  {
    AppMethodBeat.i(54231);
    if (!this.e)
    {
      Object localObject = k.a(this.g, "getContentWidth");
      if (localObject == null)
      {
        AppMethodBeat.o(54231);
        return 0;
      }
      i1 = ((Integer)localObject).intValue();
      AppMethodBeat.o(54231);
      return i1;
    }
    int i1 = this.f.getContentWidth();
    AppMethodBeat.o(54231);
    return i1;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(54224);
    if (!this.e)
    {
      localBitmap = this.g.getFavicon();
      AppMethodBeat.o(54224);
      return localBitmap;
    }
    Bitmap localBitmap = this.f.getFavicon();
    AppMethodBeat.o(54224);
    return localBitmap;
  }
  
  public HitTestResult getHitTestResult()
  {
    AppMethodBeat.i(54217);
    if (!this.e)
    {
      localHitTestResult = new HitTestResult(this.g.getHitTestResult());
      AppMethodBeat.o(54217);
      return localHitTestResult;
    }
    HitTestResult localHitTestResult = new HitTestResult(this.f.getHitTestResult());
    AppMethodBeat.o(54217);
    return localHitTestResult;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(54181);
    if (!this.e)
    {
      paramString1 = this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
      AppMethodBeat.o(54181);
      return paramString1;
    }
    paramString1 = this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(54181);
    return paramString1;
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    AppMethodBeat.i(54222);
    if (!this.e)
    {
      str = this.g.getOriginalUrl();
      AppMethodBeat.o(54222);
      return str;
    }
    String str = this.f.getOriginalUrl();
    AppMethodBeat.o(54222);
    return str;
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(54229);
    if (!this.e)
    {
      i1 = this.g.getProgress();
      AppMethodBeat.o(54229);
      return i1;
    }
    int i1 = this.f.getProgress();
    AppMethodBeat.o(54229);
    return i1;
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    AppMethodBeat.i(54228);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(54228);
          return false;
        }
        Object localObject = k.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null)
        {
          AppMethodBeat.o(54228);
          return false;
        }
        boolean bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54228);
        return bool;
      }
      AppMethodBeat.o(54228);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54228);
    }
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    AppMethodBeat.i(54227);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(54227);
          return 0;
        }
        Object localObject = k.a(this.g, "getRendererRequestedPriority");
        if (localObject == null)
        {
          AppMethodBeat.o(54227);
          return 0;
        }
        i1 = ((Integer)localObject).intValue();
        AppMethodBeat.o(54227);
        return i1;
      }
      AppMethodBeat.o(54227);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54227);
    }
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    AppMethodBeat.i(54214);
    if (!this.e)
    {
      Object localObject = k.a(this.g, "getScale");
      if (localObject == null)
      {
        AppMethodBeat.o(54214);
        return 0.0F;
      }
      f1 = ((Float)localObject).floatValue();
      AppMethodBeat.o(54214);
      return f1;
    }
    float f1 = this.f.getScale();
    AppMethodBeat.o(54214);
    return f1;
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    AppMethodBeat.i(54310);
    if (getView() == null)
    {
      AppMethodBeat.o(54310);
      return 0;
    }
    int i1 = getView().getScrollBarDefaultDelayBeforeFade();
    AppMethodBeat.o(54310);
    return i1;
  }
  
  public int getScrollBarFadeDuration()
  {
    AppMethodBeat.i(54311);
    if (getView() == null)
    {
      AppMethodBeat.o(54311);
      return 0;
    }
    int i1 = getView().getScrollBarFadeDuration();
    AppMethodBeat.o(54311);
    return i1;
  }
  
  public int getScrollBarSize()
  {
    AppMethodBeat.i(54312);
    if (getView() == null)
    {
      AppMethodBeat.o(54312);
      return 0;
    }
    int i1 = getView().getScrollBarSize();
    AppMethodBeat.o(54312);
    return i1;
  }
  
  public int getScrollBarStyle()
  {
    AppMethodBeat.i(54313);
    if (getView() == null)
    {
      AppMethodBeat.o(54313);
      return 0;
    }
    int i1 = getView().getScrollBarStyle();
    AppMethodBeat.o(54313);
    return i1;
  }
  
  public WebSettings getSettings()
  {
    AppMethodBeat.i(54257);
    if (this.h != null)
    {
      localWebSettings = this.h;
      AppMethodBeat.o(54257);
      return localWebSettings;
    }
    if (this.e)
    {
      localWebSettings = new WebSettings(this.f.getSettings());
      this.h = localWebSettings;
      AppMethodBeat.o(54257);
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.g.getSettings());
    this.h = localWebSettings;
    AppMethodBeat.o(54257);
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    AppMethodBeat.i(54277);
    if (!this.e)
    {
      AppMethodBeat.o(54277);
      return null;
    }
    IX5WebSettingsExtension localIX5WebSettingsExtension = this.f.getX5WebViewExtension().getSettingsExtension();
    AppMethodBeat.o(54277);
    return localIX5WebSettingsExtension;
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(54223);
    if (!this.e)
    {
      str = this.g.getTitle();
      AppMethodBeat.o(54223);
      return str;
    }
    String str = this.f.getTitle();
    AppMethodBeat.o(54223);
    return str;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(54221);
    if (!this.e)
    {
      str = this.g.getUrl();
      AppMethodBeat.o(54221);
      return str;
    }
    String str = this.f.getUrl();
    AppMethodBeat.o(54221);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(54272);
    if (!this.e)
    {
      localObject = this.g;
      AppMethodBeat.o(54272);
      return localObject;
    }
    Object localObject = this.f.getView();
    AppMethodBeat.o(54272);
    return localObject;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(54176);
    if (!this.e)
    {
      Object localObject = k.a(this.g, "getVisibleTitleHeight");
      if (localObject == null)
      {
        AppMethodBeat.o(54176);
        return 0;
      }
      i1 = ((Integer)localObject).intValue();
      AppMethodBeat.o(54176);
      return i1;
    }
    int i1 = this.f.getVisibleTitleHeight();
    AppMethodBeat.o(54176);
    return i1;
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.r;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    AppMethodBeat.i(54280);
    if (!this.e)
    {
      AppMethodBeat.o(54280);
      return null;
    }
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.f.getX5WebViewExtension().getWebChromeClientExtension();
    AppMethodBeat.o(54280);
    return localIX5WebChromeClientExtension;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(54174);
    if (this.e)
    {
      i1 = this.f.getView().getScrollX();
      AppMethodBeat.o(54174);
      return i1;
    }
    int i1 = this.g.getScrollX();
    AppMethodBeat.o(54174);
    return i1;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(54175);
    if (this.e)
    {
      i1 = this.f.getView().getScrollY();
      AppMethodBeat.o(54175);
      return i1;
    }
    int i1 = this.g.getScrollY();
    AppMethodBeat.o(54175);
    return i1;
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.q;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    AppMethodBeat.i(54281);
    if (!this.e)
    {
      AppMethodBeat.o(54281);
      return null;
    }
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.f.getX5WebViewExtension().getWebViewClientExtension();
    AppMethodBeat.o(54281);
    return localIX5WebViewClientExtension;
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    AppMethodBeat.i(54218);
    if (!this.e)
    {
      AppMethodBeat.o(54218);
      return null;
    }
    IX5WebViewBase.HitTestResult localHitTestResult = this.f.getHitTestResult();
    AppMethodBeat.o(54218);
    return localHitTestResult;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    AppMethodBeat.i(54276);
    if (!this.e)
    {
      AppMethodBeat.o(54276);
      return null;
    }
    IX5WebViewExtension localIX5WebViewExtension = this.f.getX5WebViewExtension();
    AppMethodBeat.o(54276);
    return localIX5WebViewExtension;
  }
  
  @Deprecated
  public View getZoomControls()
  {
    AppMethodBeat.i(54262);
    if (!this.e)
    {
      localView = (View)k.a(this.g, "getZoomControls");
      AppMethodBeat.o(54262);
      return localView;
    }
    View localView = this.f.getZoomControls();
    AppMethodBeat.o(54262);
    return localView;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(54205);
    if (!this.e)
    {
      this.g.goBack();
      AppMethodBeat.o(54205);
      return;
    }
    this.f.goBack();
    AppMethodBeat.o(54205);
  }
  
  public void goBackOrForward(int paramInt)
  {
    AppMethodBeat.i(54209);
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      AppMethodBeat.o(54209);
      return;
    }
    this.f.goBackOrForward(paramInt);
    AppMethodBeat.o(54209);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(54207);
    if (!this.e)
    {
      this.g.goForward();
      AppMethodBeat.o(54207);
      return;
    }
    this.f.goForward();
    AppMethodBeat.o(54207);
  }
  
  public void invokeZoomPicker()
  {
    AppMethodBeat.i(54216);
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      AppMethodBeat.o(54216);
      return;
    }
    this.f.invokeZoomPicker();
    AppMethodBeat.o(54216);
  }
  
  public boolean isDayMode()
  {
    return z;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    AppMethodBeat.i(54264);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = k.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null)
        {
          AppMethodBeat.o(54264);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(54264);
        return bool;
      }
      AppMethodBeat.o(54264);
      return false;
    }
    boolean bool = this.f.isPrivateBrowsingEnable();
    AppMethodBeat.o(54264);
    return bool;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54197);
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      AppMethodBeat.o(54197);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(54197);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(54198);
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      AppMethodBeat.o(54198);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(54198);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(54194);
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString)))
    {
      AppMethodBeat.o(54194);
      return;
    }
    if (!this.e)
    {
      this.g.loadUrl(paramString);
      AppMethodBeat.o(54194);
      return;
    }
    this.f.loadUrl(paramString);
    AppMethodBeat.o(54194);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(54193);
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString)))
    {
      AppMethodBeat.o(54193);
      return;
    }
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        this.g.loadUrl(paramString, paramMap);
        AppMethodBeat.o(54193);
      }
    }
    else {
      this.f.loadUrl(paramString, paramMap);
    }
    AppMethodBeat.o(54193);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(54274);
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new Thread("onDetachedFromWindow")
        {
          public void run()
          {
            AppMethodBeat.i(54938);
            try
            {
              WebView.this.a();
              AppMethodBeat.o(54938);
              return;
            }
            catch (Exception localException)
            {
              AppMethodBeat.o(54938);
            }
          }
        }.start();
        AppMethodBeat.o(54274);
        return;
      }
      a();
      AppMethodBeat.o(54274);
      return;
    }
    catch (Throwable localThrowable)
    {
      a();
      AppMethodBeat.o(54274);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(54292);
    if (this.B != null)
    {
      if (!this.B.onLongClick(paramView))
      {
        bool = a(paramView);
        AppMethodBeat.o(54292);
        return bool;
      }
      AppMethodBeat.o(54292);
      return true;
    }
    boolean bool = a(paramView);
    AppMethodBeat.o(54292);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(54234);
    if (!this.e)
    {
      k.a(this.g, "onPause");
      AppMethodBeat.o(54234);
      return;
    }
    this.f.onPause();
    AppMethodBeat.o(54234);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(54235);
    if (!this.e)
    {
      k.a(this.g, "onResume");
      AppMethodBeat.o(54235);
      return;
    }
    this.f.onResume();
    AppMethodBeat.o(54235);
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54166);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (c(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
    AppMethodBeat.o(54166);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(54275);
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(54275);
      return;
    }
    if (s == null) {
      s = this.i.getApplicationInfo().packageName;
    }
    if ((s != null) && ((s.equals("com.tencent.mm")) || (s.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(54275);
      return;
    }
    String str3;
    String str2;
    String str1;
    if ((paramInt != 0) && (!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      str3 = str4;
      str2 = str5;
      str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      TbsLog.d("sdkreport", "webview.onVisibilityChanged--Pv=" + this.a);
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.b.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(54275);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.w("onVisibilityChanged", "exception: ".concat(String.valueOf(localThrowable)));
        boolean bool = false;
      }
    }
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(54171);
    if (!this.e)
    {
      bool = this.g.overlayHorizontalScrollbar();
      AppMethodBeat.o(54171);
      return bool;
    }
    boolean bool = this.f.overlayHorizontalScrollbar();
    AppMethodBeat.o(54171);
    return bool;
  }
  
  public boolean overlayVerticalScrollbar()
  {
    AppMethodBeat.i(54172);
    if (this.e)
    {
      bool = this.f.overlayVerticalScrollbar();
      AppMethodBeat.o(54172);
      return bool;
    }
    boolean bool = this.g.overlayVerticalScrollbar();
    AppMethodBeat.o(54172);
    return bool;
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    AppMethodBeat.i(54211);
    if (!this.e)
    {
      paramBoolean = this.g.pageDown(paramBoolean);
      AppMethodBeat.o(54211);
      return paramBoolean;
    }
    paramBoolean = this.f.pageDown(paramBoolean, -1);
    AppMethodBeat.o(54211);
    return paramBoolean;
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    AppMethodBeat.i(54210);
    if (!this.e)
    {
      paramBoolean = this.g.pageUp(paramBoolean);
      AppMethodBeat.o(54210);
      return paramBoolean;
    }
    paramBoolean = this.f.pageUp(paramBoolean, -1);
    AppMethodBeat.o(54210);
    return paramBoolean;
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(54232);
    if (!this.e)
    {
      this.g.pauseTimers();
      AppMethodBeat.o(54232);
      return;
    }
    this.f.pauseTimers();
    AppMethodBeat.o(54232);
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(54196);
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      AppMethodBeat.o(54196);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
    AppMethodBeat.o(54196);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(54259);
    if (!this.e)
    {
      k.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54259);
      return;
    }
    this.f.refreshPlugins(paramBoolean);
    AppMethodBeat.o(54259);
  }
  
  public void reload()
  {
    AppMethodBeat.i(54203);
    if (!this.e)
    {
      this.g.reload();
      AppMethodBeat.o(54203);
      return;
    }
    this.f.reload();
    AppMethodBeat.o(54203);
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(54256);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        k.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(54256);
        return;
      }
      this.f.removeJavascriptInterface(paramString);
    }
    AppMethodBeat.o(54256);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(54299);
    if (!this.e)
    {
      this.g.removeView(paramView);
      AppMethodBeat.o(54299);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = k.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      AppMethodBeat.o(54299);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(54299);
    }
  }
  
  public JSONObject reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(54192);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("IS_X5", this.e);
      label28:
      TbsLog.i("sdkreport", "reportInitPerformance initType is " + paramLong1 + " isX5Core is " + this.e + " isPerformanceDataRecorded" + this.m);
      JSONObject localJSONObject2;
      if ((this.e) && (this.l != null) && (!this.m))
      {
        this.l.a("init_type", paramLong1);
        this.l.a("time_oncreate", paramLong2);
        this.l.a("webview_type", paramInt);
        this.l.a("time_webaccelerator", paramLong3);
        if (this.l.a(this.f.hashCode(), getUrl())) {
          this.m = true;
        }
        localJSONObject2 = this.l.a();
      }
      try
      {
        localJSONObject1.put("DETAIL", localJSONObject2);
        label191:
        AppMethodBeat.o(54192);
        return localJSONObject1;
      }
      catch (JSONException localJSONException1)
      {
        break label191;
      }
    }
    catch (JSONException localJSONException2)
    {
      break label28;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(54173);
    if (this.e)
    {
      localObject1 = this.f.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          paramBoolean = ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
          AppMethodBeat.o(54173);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(54173);
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    paramBoolean = ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
    AppMethodBeat.o(54173);
    return paramBoolean;
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    AppMethodBeat.i(54219);
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      AppMethodBeat.o(54219);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
    AppMethodBeat.o(54219);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    AppMethodBeat.i(54220);
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      AppMethodBeat.o(54220);
      return;
    }
    this.f.requestImageRef(paramMessage);
    AppMethodBeat.o(54220);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    AppMethodBeat.i(54190);
    if (!this.e)
    {
      paramBundle = k.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null)
      {
        AppMethodBeat.o(54190);
        return false;
      }
      bool = ((Boolean)paramBundle).booleanValue();
      AppMethodBeat.o(54190);
      return bool;
    }
    boolean bool = this.f.restorePicture(paramBundle, paramFile);
    AppMethodBeat.o(54190);
    return bool;
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(54191);
    if (!this.e)
    {
      paramBundle = WebBackForwardList.a(this.g.restoreState(paramBundle));
      AppMethodBeat.o(54191);
      return paramBundle;
    }
    paramBundle = WebBackForwardList.a(this.f.restoreState(paramBundle));
    AppMethodBeat.o(54191);
    return paramBundle;
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(54233);
    if (!this.e)
    {
      this.g.resumeTimers();
      AppMethodBeat.o(54233);
      return;
    }
    this.f.resumeTimers();
    AppMethodBeat.o(54233);
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(54179);
    if (!this.e)
    {
      k.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(54179);
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
    AppMethodBeat.o(54179);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    AppMethodBeat.i(54189);
    if (!this.e)
    {
      paramBundle = k.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null)
      {
        AppMethodBeat.o(54189);
        return false;
      }
      bool = ((Boolean)paramBundle).booleanValue();
      AppMethodBeat.o(54189);
      return bool;
    }
    boolean bool = this.f.savePicture(paramBundle, paramFile);
    AppMethodBeat.o(54189);
    return bool;
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(54188);
    if (!this.e)
    {
      paramBundle = WebBackForwardList.a(this.g.saveState(paramBundle));
      AppMethodBeat.o(54188);
      return paramBundle;
    }
    paramBundle = WebBackForwardList.a(this.f.saveState(paramBundle));
    AppMethodBeat.o(54188);
    return paramBundle;
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    AppMethodBeat.i(54199);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        k.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(54199);
      }
    }
    else {
      this.f.saveWebArchive(paramString);
    }
    AppMethodBeat.o(54199);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54200);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        k.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
        AppMethodBeat.o(54200);
      }
    }
    else {
      this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
    }
    AppMethodBeat.o(54200);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(54291);
    try
    {
      if (this.e) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      AppMethodBeat.o(54291);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54291);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(54271);
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(54271);
      return;
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(54178);
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      AppMethodBeat.o(54178);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
    AppMethodBeat.o(54178);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    AppMethodBeat.i(54290);
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      AppMethodBeat.o(54290);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54290);
    }
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(54252);
    if (!this.e)
    {
      this.g.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          AppMethodBeat.i(54352);
          if (paramDownloadListener == null)
          {
            if (WebView.a(WebView.this) == null) {}
            for (paramAnonymousString2 = null;; paramAnonymousString2 = WebView.a(WebView.this).getApplicationInfo())
            {
              if ((paramAnonymousString2 == null) || (!"com.tencent.mm".equals(paramAnonymousString2.packageName))) {
                com.tencent.smtt.sdk.b.c.a(WebView.a(WebView.this), paramAnonymousString1, null, null);
              }
              AppMethodBeat.o(54352);
              return;
            }
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
          AppMethodBeat.o(54352);
        }
      });
      AppMethodBeat.o(54252);
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
    AppMethodBeat.o(54252);
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    AppMethodBeat.i(54242);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.g.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(54690);
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
            AppMethodBeat.o(54690);
          }
        });
        AppMethodBeat.o(54242);
      }
    }
    else {
      this.f.setFindListener(paramFindListener);
    }
    AppMethodBeat.o(54242);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(54169);
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      AppMethodBeat.o(54169);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
    AppMethodBeat.o(54169);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(54180);
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(54180);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(54180);
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(54215);
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      AppMethodBeat.o(54215);
      return;
    }
    this.f.setInitialScale(paramInt);
    AppMethodBeat.o(54215);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    AppMethodBeat.i(54260);
    if (!this.e)
    {
      k.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(54260);
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
    AppMethodBeat.o(54260);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(54187);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3)
      {
        this.g.setNetworkAvailable(paramBoolean);
        AppMethodBeat.o(54187);
      }
    }
    else {
      this.f.setNetworkAvailable(paramBoolean);
    }
    AppMethodBeat.o(54187);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(54293);
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      AppMethodBeat.o(54293);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.A == null)
      {
        Object localObject2 = k.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.A = ((Field)localObject2).get(localObject1);
      }
      this.B = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      AppMethodBeat.o(54293);
      return;
    }
    catch (Throwable paramOnLongClickListener)
    {
      AppMethodBeat.o(54293);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(54285);
    getView().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(54285);
  }
  
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    AppMethodBeat.i(54254);
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        AppMethodBeat.o(54254);
        return;
      }
      this.g.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          AppMethodBeat.i(54318);
          WebView.this.a(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
          AppMethodBeat.o(54318);
        }
      });
      AppMethodBeat.o(54254);
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      AppMethodBeat.o(54254);
      return;
    }
    this.f.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(54841);
        WebView.this.a(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        AppMethodBeat.o(54841);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
    AppMethodBeat.o(54254);
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(54226);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(54226);
          return;
        }
        k.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(54226);
        return;
      }
      AppMethodBeat.o(54226);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(54226);
    }
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    AppMethodBeat.i(54168);
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      AppMethodBeat.o(54168);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
    AppMethodBeat.o(54168);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(54170);
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      AppMethodBeat.o(54170);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
    AppMethodBeat.o(54170);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(54284);
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        AppMethodBeat.o(54284);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    AppMethodBeat.o(54284);
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(54314);
    super.setVisibility(paramInt);
    if (getView() == null)
    {
      AppMethodBeat.o(54314);
      return;
    }
    getView().setVisibility(paramInt);
    AppMethodBeat.o(54314);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    AppMethodBeat.i(54253);
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.r = paramWebChromeClient;
        AppMethodBeat.o(54253);
        return;
        localObject = new h(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebChromeClient(), this, paramWebChromeClient);
      }
    }
    b localb = this.g;
    if (paramWebChromeClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localb.setWebChromeClient((android.webkit.WebChromeClient)localObject);
      break;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    AppMethodBeat.i(54279);
    if (!this.e)
    {
      AppMethodBeat.o(54279);
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
    AppMethodBeat.o(54279);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    AppMethodBeat.i(54250);
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
    AppMethodBeat.o(54250);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    AppMethodBeat.i(54249);
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.q = paramWebViewClient;
        AppMethodBeat.o(54249);
        return;
        localObject = new i(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebViewClient(), this, paramWebViewClient);
      }
    }
    b localb = this.g;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebViewClient(this, paramWebViewClient))
    {
      localb.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    AppMethodBeat.i(54278);
    if (!this.e)
    {
      AppMethodBeat.o(54278);
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
    AppMethodBeat.o(54278);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    AppMethodBeat.i(54195);
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, m.a().getLooper());
      AppMethodBeat.o(54195);
      return true;
    }
    if (paramString.startsWith("http://debugx5.qq.com"))
    {
      if (!this.e)
      {
        paramString = new StringBuilder();
        paramString.append("<!DOCTYPE html><html><body>");
        paramString.append("<head>");
        paramString.append("<title>无法打开debugx5</title>");
        paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
        paramString.append("</head>");
        paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
        paramString.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
        paramString.append("</body></html>");
        loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
        AppMethodBeat.o(54195);
        return true;
      }
      AppMethodBeat.o(54195);
      return false;
    }
    AppMethodBeat.o(54195);
    return false;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(54201);
    if (!this.e)
    {
      this.g.stopLoading();
      AppMethodBeat.o(54201);
      return;
    }
    this.f.stopLoading();
    AppMethodBeat.o(54201);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(54309);
    if (!this.e)
    {
      this.g.a();
      AppMethodBeat.o(54309);
      return;
    }
    View localView = this.f.getView();
    try
    {
      k.a(localView, "super_computeScroll");
      AppMethodBeat.o(54309);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54309);
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(54306);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.b(paramMotionEvent);
      AppMethodBeat.o(54306);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = k.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(54306);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(54306);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(54306);
    }
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(54307);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.c(paramMotionEvent);
      AppMethodBeat.o(54307);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = k.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(54307);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(54307);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(54307);
    }
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54305);
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(54305);
      return;
    }
    View localView = this.f.getView();
    try
    {
      k.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(54305);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54305);
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(54303);
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(54303);
      return;
    }
    View localView = this.f.getView();
    try
    {
      k.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(54303);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54303);
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(54308);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.a(paramMotionEvent);
      AppMethodBeat.o(54308);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = k.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(54308);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(54308);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(54308);
    }
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(54304);
    if (!this.e)
    {
      paramBoolean = this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(54304);
      return paramBoolean;
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = k.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null)
      {
        AppMethodBeat.o(54304);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(54304);
      return false;
    }
    paramBoolean = ((Boolean)localThrowable).booleanValue();
    AppMethodBeat.o(54304);
    return paramBoolean;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    AppMethodBeat.i(54287);
    if (paramBoolean == z)
    {
      AppMethodBeat.o(54287);
      return;
    }
    z = paramBoolean;
    if (paramBoolean)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      AppMethodBeat.o(54287);
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    AppMethodBeat.o(54287);
  }
  
  public void switchToNightMode()
  {
    AppMethodBeat.i(54288);
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!z)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
    AppMethodBeat.o(54288);
  }
  
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    AppMethodBeat.i(54182);
    Object localObject4;
    Object localObject1;
    int i1;
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      TbsLog.d("sdkreport", "webview.destroy--Pv=" + this.a);
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.b.b.a(this.i, (String)localObject4, (String)???, (String)localObject1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      if (this.e) {}
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          label430:
          ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
          ((Field)???).setAccessible(true);
          localObject1 = (ComponentCallbacks)((Field)???).get(null);
          if (localObject1 != null)
          {
            ((Field)???).set(null, null);
            ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
            ((Field)???).setAccessible(true);
            ??? = ((Field)???).get(null);
            if (??? == null) {}
          }
        }
        catch (Exception localException1)
        {
          boolean bool;
          continue;
        }
        synchronized ((List)???)
        {
          ((List)???).remove(localObject1);
          TbsLog.i("WebView", "X5 GUID = " + QbSdk.a());
          AppMethodBeat.o(54182);
          return;
          localThrowable = localThrowable;
          TbsLog.w("tbsWebviewDestroy", "exception: ".concat(String.valueOf(localThrowable)));
          bool = false;
        }
      }
    }
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.g });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i1 = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i1);
        }
      }
    }
    catch (Exception localException2)
    {
      break label430;
    }
    if (paramBoolean) {
      this.g.destroy();
    }
    for (;;)
    {
      if (paramBoolean) {
        this.f.destroy();
      }
    }
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(54266);
    if (!this.e)
    {
      bool = this.g.zoomIn();
      AppMethodBeat.o(54266);
      return bool;
    }
    boolean bool = this.f.zoomIn();
    AppMethodBeat.o(54266);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(54267);
    if (!this.e)
    {
      bool = this.g.zoomOut();
      AppMethodBeat.o(54267);
      return bool;
    }
    boolean bool = this.f.zoomOut();
    AppMethodBeat.o(54267);
    return bool;
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult a;
    private android.webkit.WebView.HitTestResult b = null;
    
    public HitTestResult()
    {
      this.a = null;
      this.b = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.a = null;
      this.b = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.a = paramHitTestResult;
      this.b = null;
    }
    
    public String getExtra()
    {
      AppMethodBeat.i(54565);
      String str = "";
      if (this.a != null) {
        str = this.a.getExtra();
      }
      for (;;)
      {
        AppMethodBeat.o(54565);
        return str;
        if (this.b != null) {
          str = this.b.getExtra();
        }
      }
    }
    
    public int getType()
    {
      AppMethodBeat.i(54564);
      int i = 0;
      if (this.a != null) {
        i = this.a.getType();
      }
      for (;;)
      {
        AppMethodBeat.o(54564);
        return i;
        if (this.b != null) {
          i = this.b.getType();
        }
      }
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  public class WebViewTransport
  {
    private WebView b;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.b;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.b = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context arg1, Intent paramIntent)
    {
      AppMethodBeat.i(55494);
      if (paramIntent != null) {}
      for (;;)
      {
        try
        {
          int i;
          long l;
          if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
          {
            i = Apn.getApnType(???);
            l = System.currentTimeMillis();
          }
          synchronized (QbSdk.g)
          {
            if (QbSdk.d) {
              QbSdk.f += l - QbSdk.e;
            }
            QbSdk.e = l;
            TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.f + " apnType=" + i);
            if (i == 3)
            {
              bool = true;
              QbSdk.d = bool;
              AppMethodBeat.o(55494);
              return;
            }
          }
          boolean bool = false;
        }
        catch (Throwable ???)
        {
          AppMethodBeat.o(55494);
          return;
        }
      }
    }
  }
  
  class b
    extends android.webkit.WebView
  {
    public b(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(54510);
      if ((!QbSdk.getIsSysWebViewForcedByOuter()) || (!TbsShareManager.isThirdPartyApp(paramContext)))
      {
        CookieSyncManager.createInstance(WebView.a(WebView.this)).startSync();
        try
        {
          this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
          WebView.this.setAccessible(true);
          ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new f());
          WebView.mSysWebviewCreated = true;
          AppMethodBeat.o(54510);
          return;
        }
        catch (Exception this$1) {}
      }
      AppMethodBeat.o(54510);
    }
    
    public void a()
    {
      AppMethodBeat.i(54516);
      super.computeScroll();
      AppMethodBeat.o(54516);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(54514);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(54514);
    }
    
    @TargetApi(9)
    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(54523);
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(54523);
    }
    
    @TargetApi(9)
    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(54521);
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
        AppMethodBeat.o(54521);
        return paramBoolean;
      }
      AppMethodBeat.o(54521);
      return false;
    }
    
    public boolean a(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54518);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(54518);
      return bool;
    }
    
    public boolean b(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54525);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(54525);
      return bool;
    }
    
    public boolean c(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54527);
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(54527);
      return bool;
    }
    
    public void computeScroll()
    {
      AppMethodBeat.i(54515);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        AppMethodBeat.o(54515);
        return;
      }
      super.computeScroll();
      AppMethodBeat.o(54515);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(54519);
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.f()) && (WebView.g() != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.g());
          paramCanvas.restore();
        }
        AppMethodBeat.o(54519);
        return;
      }
      catch (Throwable paramCanvas)
      {
        AppMethodBeat.o(54519);
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54524);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(54524);
        return bool;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(54524);
      return bool;
    }
    
    public android.webkit.WebSettings getSettings()
    {
      AppMethodBeat.i(54512);
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        AppMethodBeat.o(54512);
        return localWebSettings;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(54512);
      }
      return null;
    }
    
    public void invalidate()
    {
      AppMethodBeat.i(54511);
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.invalidate();
      }
      AppMethodBeat.o(54511);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54526);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(54526);
        return bool;
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(54526);
      return bool;
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(54522);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
        AppMethodBeat.o(54522);
        return;
      }
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(54522);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(54513);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        AppMethodBeat.o(54513);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.b(WebView.this, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(54513);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(54517);
      if (!hasFocus()) {
        requestFocus();
      }
      new StringBuilder("SystemWebView - onTouchEvent:").append(paramMotionEvent);
      boolean bool;
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(54517);
        return bool;
      }
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(54517);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        AppMethodBeat.o(54517);
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(54520);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        paramBoolean = WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
        AppMethodBeat.o(54520);
        return paramBoolean;
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
        AppMethodBeat.o(54520);
        return paramBoolean;
      }
      AppMethodBeat.o(54520);
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      AppMethodBeat.i(54528);
      try
      {
        super.setOverScrollMode(paramInt);
        AppMethodBeat.o(54528);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(54528);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */