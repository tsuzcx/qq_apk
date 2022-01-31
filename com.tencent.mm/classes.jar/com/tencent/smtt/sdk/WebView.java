package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.Uri;
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
import android.view.ViewStructure;
import android.webkit.WebView.VisualStateCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
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
  private static com.tencent.smtt.utils.w o;
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
  private an l;
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
    AppMethodBeat.i(65023);
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
    AppMethodBeat.o(65023);
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
    AppMethodBeat.i(64862);
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
    this.l = new an();
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
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
      mSysWebviewCreated = true;
      label244:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable());
      AppMethodBeat.o(64862);
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
        AppMethodBeat.o(64862);
        throw paramContext;
        TbsLog.setWriteLogJIT(false);
      }
      if (o == null) {
        o = com.tencent.smtt.utils.w.a(paramContext);
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
        this.f = bz.a().a(true).a(paramContext);
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
          label648:
          b(paramContext);
          TbsLog.writeLogToDisk();
          ao.a(paramContext);
          AppMethodBeat.o(64862);
          return;
          this.g = new b(paramContext);
          continue;
          TbsLog.i("WebView", "X5 WebView Created Success!!");
          this.f.getView().setFocusableInTouchMode(true);
          a(paramAttributeSet);
          addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
          this.f.setDownloadListener(new b(this, null, this.e));
          this.f.getX5WebViewExtension().setWebViewClientExtension(new bp(this, bz.a().a(true).k()));
          try
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              removeJavascriptInterface("searchBoxJavaBridge_");
              removeJavascriptInterface("accessibility");
              removeJavascriptInterface("accessibilityTraversal");
            }
            label813:
            if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (o.a(true).h()) && (Build.VERSION.SDK_INT >= 11)) {
              setLayerType(1, null);
            }
            if (this.f != null)
            {
              TbsLog.writeLogToDisk();
              if (!TbsShareManager.isThirdPartyApp(paramContext))
              {
                paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
                if ((paramInt <= 0) || (paramInt == ao.a().h(paramContext)) || (paramInt != ao.a().i(paramContext))) {
                  break label1094;
                }
                ao.a().n(paramContext);
              }
            }
            for (;;)
            {
              if (this.l != null)
              {
                this.l.a("load_url_gap", (byte)1);
                this.l.a("init_all", (byte)2);
              }
              QbSdk.continueLoadSo(paramContext);
              AppMethodBeat.o(64862);
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
                ao.a(paramContext);
                break;
              }
              label1094:
              TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + ao.a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + ao.a().i(paramContext));
            }
          }
          catch (Throwable paramAttributeSet)
          {
            break label813;
          }
        }
        catch (Throwable paramAttributeSet)
        {
          break label648;
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label244;
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private void a(Context paramContext, an paraman)
  {
    AppMethodBeat.i(139434);
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paraman != null) {
      paraman.a("x5_core_engine_init_sync", (byte)1);
    }
    bz localbz = bz.a();
    localbz.a(paramContext, paraman);
    this.e = localbz.b();
    AppMethodBeat.o(139434);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    AppMethodBeat.i(64992);
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
        AppMethodBeat.o(64992);
        return;
      }
      if (i3 == arrayOfInt[3])
      {
        this.f.getView().setHorizontalScrollBarEnabled(false);
        break label165;
        label158:
        AppMethodBeat.o(64992);
        return;
      }
      label165:
      i1 += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    AppMethodBeat.i(65003);
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200))
    {
      AppMethodBeat.o(65003);
      return false;
    }
    paramView = com.tencent.smtt.utils.r.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null)
    {
      boolean bool = ((Boolean)paramView).booleanValue();
      AppMethodBeat.o(65003);
      return bool;
    }
    AppMethodBeat.o(65003);
    return false;
  }
  
  private void b(Context paramContext)
  {
    AppMethodBeat.i(64863);
    if (n != null)
    {
      AppMethodBeat.o(64863);
      return;
    }
    n = new WebView.a(null);
    new br(this, paramContext).start();
    AppMethodBeat.o(64863);
  }
  
  private boolean c(Context paramContext)
  {
    AppMethodBeat.i(64871);
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0)
      {
        AppMethodBeat.o(64871);
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(64871);
    }
    return false;
  }
  
  public static void clearClientCertPreferences(Runnable paramRunnable)
  {
    AppMethodBeat.i(139436);
    if (Build.VERSION.SDK_INT >= 21) {
      android.webkit.WebView.clearClientCertPreferences(paramRunnable);
    }
    AppMethodBeat.o(139436);
  }
  
  /* Error */
  private int d(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 639
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iconst_1
    //   8: ldc_w 641
    //   11: invokestatic 646	com/tencent/smtt/utils/k:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +24 -> 42
    //   21: aload_1
    //   22: aload 6
    //   24: invokestatic 649	com/tencent/smtt/utils/k:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   27: astore 7
    //   29: aload 7
    //   31: ifnonnull +19 -> 50
    //   34: ldc_w 639
    //   37: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_m1
    //   41: ireturn
    //   42: ldc_w 639
    //   45: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_m1
    //   49: ireturn
    //   50: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 654 1 0
    //   58: ifeq +432 -> 490
    //   61: aconst_null
    //   62: astore 5
    //   64: aload_1
    //   65: ldc_w 656
    //   68: iconst_0
    //   69: invokevirtual 660	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   72: astore_1
    //   73: new 662	java/io/File
    //   76: dup
    //   77: new 510	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 663	java/lang/StringBuilder:<init>	()V
    //   84: aload_1
    //   85: invokevirtual 666	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: getstatic 669	java/io/File:separator	Ljava/lang/String;
    //   91: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 671
    //   97: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: ldc_w 673
    //   106: invokespecial 675	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual 678	java/io/File:exists	()Z
    //   114: istore_3
    //   115: iload_3
    //   116: ifne +26 -> 142
    //   119: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   122: invokeinterface 681 1 0
    //   127: aload 7
    //   129: aload 6
    //   131: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   134: ldc_w 639
    //   137: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: iconst_m1
    //   141: ireturn
    //   142: new 686	java/util/Properties
    //   145: dup
    //   146: invokespecial 687	java/util/Properties:<init>	()V
    //   149: astore 8
    //   151: new 689	java/io/FileInputStream
    //   154: dup
    //   155: aload_1
    //   156: invokespecial 692	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: astore 4
    //   161: aload 4
    //   163: astore_1
    //   164: aload 8
    //   166: aload 4
    //   168: invokevirtual 696	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   171: aload 4
    //   173: astore_1
    //   174: aload 4
    //   176: invokevirtual 699	java/io/FileInputStream:close	()V
    //   179: aload 4
    //   181: astore_1
    //   182: aload 8
    //   184: ldc_w 701
    //   187: invokevirtual 705	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 5
    //   192: aload 5
    //   194: ifnonnull +61 -> 255
    //   197: aload 4
    //   199: invokevirtual 699	java/io/FileInputStream:close	()V
    //   202: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   205: invokeinterface 681 1 0
    //   210: aload 7
    //   212: aload 6
    //   214: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   217: ldc_w 639
    //   220: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: iconst_m1
    //   224: ireturn
    //   225: astore_1
    //   226: ldc_w 707
    //   229: new 510	java/lang/StringBuilder
    //   232: dup
    //   233: ldc_w 709
    //   236: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload_1
    //   240: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   243: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -50 -> 202
    //   255: aload 4
    //   257: astore_1
    //   258: aload 5
    //   260: invokestatic 717	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   263: istore_2
    //   264: aload 4
    //   266: invokevirtual 699	java/io/FileInputStream:close	()V
    //   269: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   272: invokeinterface 681 1 0
    //   277: aload 7
    //   279: aload 6
    //   281: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   284: ldc_w 639
    //   287: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: iload_2
    //   291: ireturn
    //   292: astore_1
    //   293: ldc_w 707
    //   296: new 510	java/lang/StringBuilder
    //   299: dup
    //   300: ldc_w 709
    //   303: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload_1
    //   307: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   310: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: goto -50 -> 269
    //   322: astore 5
    //   324: aconst_null
    //   325: astore 4
    //   327: aload 4
    //   329: astore_1
    //   330: ldc_w 707
    //   333: new 510	java/lang/StringBuilder
    //   336: dup
    //   337: ldc_w 719
    //   340: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: aload 5
    //   345: invokevirtual 720	java/lang/Exception:toString	()Ljava/lang/String;
    //   348: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 4
    //   359: ifnull +8 -> 367
    //   362: aload 4
    //   364: invokevirtual 699	java/io/FileInputStream:close	()V
    //   367: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   370: invokeinterface 681 1 0
    //   375: aload 7
    //   377: aload 6
    //   379: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   382: ldc_w 639
    //   385: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: iconst_m1
    //   389: ireturn
    //   390: astore_1
    //   391: ldc_w 707
    //   394: new 510	java/lang/StringBuilder
    //   397: dup
    //   398: ldc_w 709
    //   401: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   404: aload_1
    //   405: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   408: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -50 -> 367
    //   420: astore_1
    //   421: aload 5
    //   423: astore 4
    //   425: aload 4
    //   427: ifnull +8 -> 435
    //   430: aload 4
    //   432: invokevirtual 699	java/io/FileInputStream:close	()V
    //   435: getstatic 100	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   438: invokeinterface 681 1 0
    //   443: aload 7
    //   445: aload 6
    //   447: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   450: ldc_w 639
    //   453: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload_1
    //   457: athrow
    //   458: astore 4
    //   460: ldc_w 707
    //   463: new 510	java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w 709
    //   470: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload 4
    //   475: invokevirtual 710	java/io/IOException:toString	()Ljava/lang/String;
    //   478: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 712	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: goto -52 -> 435
    //   490: aload 7
    //   492: aload 6
    //   494: invokestatic 684	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   497: ldc_w 639
    //   500: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: iconst_m1
    //   504: ireturn
    //   505: astore 5
    //   507: aload_1
    //   508: astore 4
    //   510: aload 5
    //   512: astore_1
    //   513: goto -88 -> 425
    //   516: astore 5
    //   518: goto -191 -> 327
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	WebView
    //   0	521	1	paramContext	Context
    //   263	28	2	i1	int
    //   114	2	3	bool	boolean
    //   159	272	4	localObject1	Object
    //   458	16	4	localIOException	java.io.IOException
    //   508	1	4	localContext	Context
    //   62	197	5	str	String
    //   322	100	5	localException1	Exception
    //   505	6	5	localObject2	Object
    //   516	1	5	localException2	Exception
    //   14	479	6	localFileOutputStream	FileOutputStream
    //   27	464	7	localFileLock	java.nio.channels.FileLock
    //   149	34	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   197	202	225	java/io/IOException
    //   264	269	292	java/io/IOException
    //   64	115	322	java/lang/Exception
    //   142	161	322	java/lang/Exception
    //   362	367	390	java/io/IOException
    //   64	115	420	finally
    //   142	161	420	finally
    //   430	435	458	java/io/IOException
    //   164	171	505	finally
    //   174	179	505	finally
    //   182	192	505	finally
    //   258	264	505	finally
    //   330	357	505	finally
    //   164	171	516	java/lang/Exception
    //   174	179	516	java/lang/Exception
    //   182	192	516	java/lang/Exception
    //   258	264	516	java/lang/Exception
  }
  
  static void d()
  {
    AppMethodBeat.i(65008);
    by localby = new by();
    try
    {
      new Thread(localby).start();
      AppMethodBeat.o(65008);
      return;
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("webview", "updateRebootStatus excpetion: ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(65008);
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(64892);
    if (!bz.a().b()) {
      com.tencent.smtt.utils.r.a("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(64892);
  }
  
  public static void disableWebView()
  {
    AppMethodBeat.i(139437);
    if (Build.VERSION.SDK_INT >= 28) {
      com.tencent.smtt.utils.r.a("android.webkit.WebView", "disableWebView");
    }
    AppMethodBeat.o(139437);
  }
  
  private void e(Context paramContext)
  {
    AppMethodBeat.i(65002);
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      boolean bool = paramContext.exists();
      if (!bool)
      {
        AppMethodBeat.o(65002);
        return;
      }
      paramContext.delete();
      AppMethodBeat.o(65002);
      return;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
      AppMethodBeat.o(65002);
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(64891);
    if (!bz.a().b()) {
      com.tencent.smtt.utils.r.a("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(64891);
  }
  
  public static void enableSlowWholeDocumentDraw()
  {
    AppMethodBeat.i(139438);
    if (Build.VERSION.SDK_INT >= 21) {
      com.tencent.smtt.utils.r.a("android.webkit.WebView", "enableSlowWholeDocumentDraw");
    }
    AppMethodBeat.o(139438);
  }
  
  public static String findAddress(String paramString)
  {
    AppMethodBeat.i(64951);
    if (!bz.a().b())
    {
      paramString = android.webkit.WebView.findAddress(paramString);
      AppMethodBeat.o(64951);
      return paramString;
    }
    AppMethodBeat.o(64951);
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    i2 = 0;
    AppMethodBeat.i(65006);
    if (paramContext == null)
    {
      AppMethodBeat.o(65006);
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";tbs_sdk_version:43663;";
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
      AppMethodBeat.o(65006);
      return paramContext;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(o.a(true).e());
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.n != null) && (QbSdk.n.containsKey("weapp_id")) && (QbSdk.n.containsKey("weapp_name")))
    {
      paramContext = "weapp_id:" + QbSdk.n.get("weapp_id") + ";weapp_name:" + QbSdk.n.get("weapp_name") + ";";
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext);
    }
    if (localStringBuilder.length() > 8192)
    {
      paramContext = localStringBuilder.substring(localStringBuilder.length() - 8192);
      AppMethodBeat.o(65006);
      return paramContext;
    }
    paramContext = localStringBuilder.toString();
    AppMethodBeat.o(65006);
    return paramContext;
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    AppMethodBeat.i(64931);
    if (!bz.a().b())
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        AppMethodBeat.o(64931);
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.r.a("android.webkit.WebView", "getCurrentWebViewPackage");
        AppMethodBeat.o(64931);
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(64931);
        return null;
      }
    }
    AppMethodBeat.o(64931);
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 826
    //   6: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 362	com/tencent/smtt/sdk/bz:a	()Lcom/tencent/smtt/sdk/bz;
    //   12: invokevirtual 550	com/tencent/smtt/sdk/bz:b	()Z
    //   15: ifne +24 -> 39
    //   18: ldc_w 743
    //   21: ldc_w 827
    //   24: invokestatic 747	com/tencent/smtt/utils/r:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   27: astore_0
    //   28: ldc_w 826
    //   31: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc_w 826
    //   44: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static Uri getSafeBrowsingPrivacyPolicyUrl()
  {
    AppMethodBeat.i(139440);
    if (Build.VERSION.SDK_INT >= 27)
    {
      Object localObject = com.tencent.smtt.utils.r.a("android.webkit.WebView", "getSafeBrowsingPrivacyPolicyUrl");
      if ((localObject instanceof Uri))
      {
        localObject = (Uri)localObject;
        AppMethodBeat.o(139440);
        return localObject;
      }
    }
    AppMethodBeat.o(139440);
    return null;
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(64989);
    int i1 = QbSdk.getTbsVersion(paramContext);
    AppMethodBeat.o(64989);
    return i1;
  }
  
  public static boolean getTbsNeedReboot()
  {
    AppMethodBeat.i(65007);
    d();
    boolean bool = o.a(true).f();
    AppMethodBeat.o(65007);
    return bool;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43663;
  }
  
  public static ClassLoader getWebViewClassLoader()
  {
    AppMethodBeat.i(139441);
    if (Build.VERSION.SDK_INT >= 28)
    {
      Object localObject = com.tencent.smtt.utils.r.a("android.webkit.WebView", "enableSlowWholeDocumentDraw");
      if ((localObject instanceof ClassLoader))
      {
        localObject = (ClassLoader)localObject;
        AppMethodBeat.o(139441);
        return localObject;
      }
    }
    AppMethodBeat.o(139441);
    return null;
  }
  
  private long i()
  {
    AppMethodBeat.i(64890);
    synchronized (QbSdk.h)
    {
      if (QbSdk.e)
      {
        QbSdk.g += System.currentTimeMillis() - QbSdk.f;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
      }
      long l1 = QbSdk.g / 1000L;
      QbSdk.g = 0L;
      QbSdk.f = System.currentTimeMillis();
      AppMethodBeat.o(64890);
      return l1;
    }
  }
  
  public static void setDataDirectorySuffix(String paramString)
  {
    AppMethodBeat.i(139446);
    try
    {
      com.tencent.smtt.utils.r.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", new Class[] { String.class }, new Object[] { paramString });
      AppMethodBeat.o(139446);
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(139446);
    }
  }
  
  public static void setSafeBrowsingWhitelist(List<String> paramList, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(139447);
    try
    {
      com.tencent.smtt.utils.r.a(Class.forName("android.webkit.WebView"), "setSafeBrowsingWhitelist", new Class[] { List.class, android.webkit.ValueCallback.class }, new Object[] { paramList, paramValueCallback });
      AppMethodBeat.o(139447);
      return;
    }
    catch (ClassNotFoundException paramList)
    {
      AppMethodBeat.o(139447);
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(64995);
        if (paramBoolean == z)
        {
          AppMethodBeat.o(64995);
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
          AppMethodBeat.o(64995);
          continue;
        }
        if (y.getAlpha() == 255) {
          break label115;
        }
      }
      finally {}
      y.setAlpha(255);
      label115:
      AppMethodBeat.o(64995);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(64908);
    Object localObject = bz.a();
    if ((localObject != null) && (((bz)localObject).b()))
    {
      ((bz)localObject).c().a(paramBoolean);
      AppMethodBeat.o(64908);
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
        AppMethodBeat.o(64908);
        return;
      }
      catch (Exception localException)
      {
        TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
      }
    }
    AppMethodBeat.o(64908);
  }
  
  public static void startSafeBrowsing(Context paramContext, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(139448);
    try
    {
      com.tencent.smtt.utils.r.a(Class.forName("android.webkit.WebView"), "startSafeBrowsing", new Class[] { Context.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramValueCallback });
      AppMethodBeat.o(139448);
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      AppMethodBeat.o(139448);
    }
  }
  
  protected void a()
  {
    AppMethodBeat.i(64979);
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
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onDetachedFromWindow();
      AppMethodBeat.o(64979);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  void a(Context paramContext)
  {
    AppMethodBeat.i(65001);
    int i1 = d(paramContext);
    if (i1 != -1) {}
    for (String str = "PV=" + String.valueOf(i1 + 1);; str = "PV=1")
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      try
      {
        paramContext.getParentFile().mkdirs();
        if ((!paramContext.isFile()) || (!paramContext.exists())) {
          paramContext.createNewFile();
        }
        paramContext = new FileOutputStream(paramContext, false);
        d = paramContext;
        paramContext.write(str.getBytes());
      }
      finally
      {
        if (d != null) {
          d.flush();
        }
        AppMethodBeat.o(65001);
      }
      try
      {
        if (d == null) {
          break label190;
        }
        d.flush();
        AppMethodBeat.o(65001);
        return;
      }
      catch (Throwable paramContext)
      {
        AppMethodBeat.o(65001);
        return;
      }
    }
    label190:
    AppMethodBeat.o(65001);
  }
  
  void a(android.webkit.WebView paramWebView) {}
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(64961);
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      AppMethodBeat.o(64961);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(64961);
  }
  
  public void addView(View paramView)
  {
    AppMethodBeat.i(65004);
    if (!this.e)
    {
      this.g.addView(paramView);
      AppMethodBeat.o(65004);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.r.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      AppMethodBeat.o(65004);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(65004);
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
    AppMethodBeat.i(64910);
    if (!this.e)
    {
      bool = this.g.canGoBack();
      AppMethodBeat.o(64910);
      return bool;
    }
    boolean bool = this.f.canGoBack();
    AppMethodBeat.o(64910);
    return bool;
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    AppMethodBeat.i(64914);
    if (!this.e)
    {
      bool = this.g.canGoBackOrForward(paramInt);
      AppMethodBeat.o(64914);
      return bool;
    }
    boolean bool = this.f.canGoBackOrForward(paramInt);
    AppMethodBeat.o(64914);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(64912);
    if (!this.e)
    {
      bool = this.g.canGoForward();
      AppMethodBeat.o(64912);
      return bool;
    }
    boolean bool = this.f.canGoForward();
    AppMethodBeat.o(64912);
    return bool;
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    AppMethodBeat.i(64969);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.r.a(this.g, "canZoomIn");
        if (localObject == null)
        {
          AppMethodBeat.o(64969);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64969);
        return bool;
      }
      AppMethodBeat.o(64969);
      return false;
    }
    boolean bool = this.f.canZoomIn();
    AppMethodBeat.o(64969);
    return bool;
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    AppMethodBeat.i(64971);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.r.a(this.g, "canZoomOut");
        if (localObject == null)
        {
          AppMethodBeat.o(64971);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64971);
        return bool;
      }
      AppMethodBeat.o(64971);
      return false;
    }
    boolean bool = this.f.canZoomOut();
    AppMethodBeat.o(64971);
    return bool;
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    AppMethodBeat.i(64919);
    if (!this.e)
    {
      localObject = com.tencent.smtt.utils.r.a(this.g, "capturePicture");
      if (localObject == null)
      {
        AppMethodBeat.o(64919);
        return null;
      }
      localObject = (Picture)localObject;
      AppMethodBeat.o(64919);
      return localObject;
    }
    Object localObject = this.f.capturePicture();
    AppMethodBeat.o(64919);
    return localObject;
  }
  
  public void clearCache(boolean paramBoolean)
  {
    AppMethodBeat.i(64943);
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      AppMethodBeat.o(64943);
      return;
    }
    this.f.clearCache(paramBoolean);
    AppMethodBeat.o(64943);
  }
  
  public void clearFormData()
  {
    AppMethodBeat.i(64944);
    if (!this.e)
    {
      this.g.clearFormData();
      AppMethodBeat.o(64944);
      return;
    }
    this.f.clearFormData();
    AppMethodBeat.o(64944);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(64945);
    if (!this.e)
    {
      this.g.clearHistory();
      AppMethodBeat.o(64945);
      return;
    }
    this.f.clearHistory();
    AppMethodBeat.o(64945);
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    AppMethodBeat.i(64953);
    if (!this.e)
    {
      this.g.clearMatches();
      AppMethodBeat.o(64953);
      return;
    }
    this.f.clearMatches();
    AppMethodBeat.o(64953);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(64946);
    if (!this.e)
    {
      this.g.clearSslPreferences();
      AppMethodBeat.o(64946);
      return;
    }
    this.f.clearSslPreferences();
    AppMethodBeat.o(64946);
  }
  
  @Deprecated
  public void clearView()
  {
    AppMethodBeat.i(64918);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "clearView");
      AppMethodBeat.o(64918);
      return;
    }
    this.f.clearView();
    AppMethodBeat.o(64918);
  }
  
  public int computeHorizontalScrollExtent()
  {
    AppMethodBeat.i(64869);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(64869);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64869);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64869);
    }
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    AppMethodBeat.i(64865);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(64865);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64865);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64865);
    }
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    AppMethodBeat.i(64868);
    try
    {
      if (this.e)
      {
        i1 = ((Integer)com.tencent.smtt.utils.r.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(64868);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64868);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64868);
    }
    return -1;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(64976);
    if (!this.e)
    {
      this.g.computeScroll();
      AppMethodBeat.o(64976);
      return;
    }
    this.f.computeScroll();
    AppMethodBeat.o(64976);
  }
  
  public int computeVerticalScrollExtent()
  {
    AppMethodBeat.i(64867);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(64867);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64867);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64867);
    }
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    AppMethodBeat.i(64866);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(64866);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64866);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64866);
    }
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    AppMethodBeat.i(64870);
    try
    {
      if (this.e)
      {
        i1 = ((Integer)com.tencent.smtt.utils.r.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(64870);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      AppMethodBeat.o(64870);
      return i1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64870);
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(64947);
    if (this.e)
    {
      localWebBackForwardList = WebBackForwardList.a(this.f.copyBackForwardList());
      AppMethodBeat.o(64947);
      return localWebBackForwardList;
    }
    WebBackForwardList localWebBackForwardList = WebBackForwardList.a(this.g.copyBackForwardList());
    AppMethodBeat.o(64947);
    return localWebBackForwardList;
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    AppMethodBeat.i(64864);
    if (this.e) {
      try
      {
        paramString = this.f.createPrintDocumentAdapter(paramString);
        AppMethodBeat.o(64864);
        return paramString;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(64864);
        return null;
      }
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(64864);
      return null;
    }
    paramString = com.tencent.smtt.utils.r.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(64864);
    return paramString;
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(64957);
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
    AppMethodBeat.o(64957);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(64889);
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new bs(this, "WebviewDestroy").start();
        if (this.e)
        {
          this.f.destroy();
          AppMethodBeat.o(64889);
          return;
        }
        this.g.destroy();
        AppMethodBeat.o(64889);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      tbsWebviewDestroy(true);
      AppMethodBeat.o(64889);
      return;
    }
    tbsWebviewDestroy(true);
    AppMethodBeat.o(64889);
  }
  
  public void documentHasImages(Message paramMessage)
  {
    AppMethodBeat.i(64954);
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      AppMethodBeat.o(64954);
      return;
    }
    this.f.documentHasImages(paramMessage);
    AppMethodBeat.o(64954);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    AppMethodBeat.i(64974);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      AppMethodBeat.o(64974);
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
    AppMethodBeat.o(64974);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(64988);
    Method localMethod;
    if (this.e) {
      try
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        AppMethodBeat.o(64988);
        return;
      }
      catch (Exception paramValueCallback)
      {
        loadUrl(paramString);
        AppMethodBeat.o(64988);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
        AppMethodBeat.o(64988);
        return;
      }
      catch (Exception paramString) {}
    }
    AppMethodBeat.o(64988);
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    AppMethodBeat.i(64950);
    if (!this.e)
    {
      paramString = com.tencent.smtt.utils.r.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null)
      {
        AppMethodBeat.o(64950);
        return 0;
      }
      i1 = ((Integer)paramString).intValue();
      AppMethodBeat.o(64950);
      return i1;
    }
    int i1 = this.f.findAll(paramString);
    AppMethodBeat.o(64950);
    return i1;
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(64952);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        com.tencent.smtt.utils.r.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(64952);
      }
    }
    else {
      this.f.findAllAsync(paramString);
    }
    AppMethodBeat.o(64952);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    AppMethodBeat.i(64975);
    if (!this.e)
    {
      paramString = (View)com.tencent.smtt.utils.r.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(64975);
      return paramString;
    }
    paramString = this.f.findHierarchyView(paramString, paramInt);
    AppMethodBeat.o(64975);
    return paramString;
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(64949);
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      AppMethodBeat.o(64949);
      return;
    }
    this.f.findNext(paramBoolean);
    AppMethodBeat.o(64949);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(64967);
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      AppMethodBeat.o(64967);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
    AppMethodBeat.o(64967);
  }
  
  @Deprecated
  public void freeMemory()
  {
    AppMethodBeat.i(64942);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "freeMemory");
      AppMethodBeat.o(64942);
      return;
    }
    this.f.freeMemory();
    AppMethodBeat.o(64942);
  }
  
  public CharSequence getAccessibilityClassName()
  {
    AppMethodBeat.i(139439);
    try
    {
      if (this.e)
      {
        localObject = com.tencent.smtt.utils.r.a(this.f.getView(), "getAccessibilityClassName", new Class[0]);
        ((Method)localObject).setAccessible(true);
        localObject = (CharSequence)((Method)localObject).invoke(this.f.getView(), new Object[0]);
        AppMethodBeat.o(139439);
        return localObject;
      }
      Object localObject = com.tencent.smtt.utils.r.a(this.g, "getAccessibilityClassName", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (CharSequence)((Method)localObject).invoke(this.g, new Object[0]);
      AppMethodBeat.o(139439);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139439);
    }
    return null;
  }
  
  public SslCertificate getCertificate()
  {
    AppMethodBeat.i(64883);
    if (!this.e)
    {
      localSslCertificate = this.g.getCertificate();
      AppMethodBeat.o(64883);
      return localSslCertificate;
    }
    SslCertificate localSslCertificate = this.f.getCertificate();
    AppMethodBeat.o(64883);
    return localSslCertificate;
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(64936);
    if (!this.e)
    {
      i1 = this.g.getContentHeight();
      AppMethodBeat.o(64936);
      return i1;
    }
    int i1 = this.f.getContentHeight();
    AppMethodBeat.o(64936);
    return i1;
  }
  
  public int getContentWidth()
  {
    AppMethodBeat.i(64937);
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.r.a(this.g, "getContentWidth");
      if (localObject == null)
      {
        AppMethodBeat.o(64937);
        return 0;
      }
      i1 = ((Integer)localObject).intValue();
      AppMethodBeat.o(64937);
      return i1;
    }
    int i1 = this.f.getContentWidth();
    AppMethodBeat.o(64937);
    return i1;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(64930);
    if (!this.e)
    {
      localBitmap = this.g.getFavicon();
      AppMethodBeat.o(64930);
      return localBitmap;
    }
    Bitmap localBitmap = this.f.getFavicon();
    AppMethodBeat.o(64930);
    return localBitmap;
  }
  
  public WebView.HitTestResult getHitTestResult()
  {
    AppMethodBeat.i(64923);
    if (!this.e)
    {
      localHitTestResult = new WebView.HitTestResult(this.g.getHitTestResult());
      AppMethodBeat.o(64923);
      return localHitTestResult;
    }
    WebView.HitTestResult localHitTestResult = new WebView.HitTestResult(this.f.getHitTestResult());
    AppMethodBeat.o(64923);
    return localHitTestResult;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(64887);
    if (!this.e)
    {
      paramString1 = this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
      AppMethodBeat.o(64887);
      return paramString1;
    }
    paramString1 = this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(64887);
    return paramString1;
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    AppMethodBeat.i(64928);
    if (!this.e)
    {
      str = this.g.getOriginalUrl();
      AppMethodBeat.o(64928);
      return str;
    }
    String str = this.f.getOriginalUrl();
    AppMethodBeat.o(64928);
    return str;
  }
  
  public int getProgress()
  {
    AppMethodBeat.i(64935);
    if (!this.e)
    {
      i1 = this.g.getProgress();
      AppMethodBeat.o(64935);
      return i1;
    }
    int i1 = this.f.getProgress();
    AppMethodBeat.o(64935);
    return i1;
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    AppMethodBeat.i(64934);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(64934);
          return false;
        }
        Object localObject = com.tencent.smtt.utils.r.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null)
        {
          AppMethodBeat.o(64934);
          return false;
        }
        boolean bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64934);
        return bool;
      }
      AppMethodBeat.o(64934);
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64934);
    }
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    AppMethodBeat.i(64933);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(64933);
          return 0;
        }
        Object localObject = com.tencent.smtt.utils.r.a(this.g, "getRendererRequestedPriority");
        if (localObject == null)
        {
          AppMethodBeat.o(64933);
          return 0;
        }
        i1 = ((Integer)localObject).intValue();
        AppMethodBeat.o(64933);
        return i1;
      }
      AppMethodBeat.o(64933);
      return 0;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64933);
    }
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    AppMethodBeat.i(64920);
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.r.a(this.g, "getScale");
      if (localObject == null)
      {
        AppMethodBeat.o(64920);
        return 0.0F;
      }
      f1 = ((Float)localObject).floatValue();
      AppMethodBeat.o(64920);
      return f1;
    }
    float f1 = this.f.getScale();
    AppMethodBeat.o(64920);
    return f1;
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    AppMethodBeat.i(65016);
    if (getView() == null)
    {
      AppMethodBeat.o(65016);
      return 0;
    }
    int i1 = getView().getScrollBarDefaultDelayBeforeFade();
    AppMethodBeat.o(65016);
    return i1;
  }
  
  public int getScrollBarFadeDuration()
  {
    AppMethodBeat.i(65017);
    if (getView() == null)
    {
      AppMethodBeat.o(65017);
      return 0;
    }
    int i1 = getView().getScrollBarFadeDuration();
    AppMethodBeat.o(65017);
    return i1;
  }
  
  public int getScrollBarSize()
  {
    AppMethodBeat.i(65018);
    if (getView() == null)
    {
      AppMethodBeat.o(65018);
      return 0;
    }
    int i1 = getView().getScrollBarSize();
    AppMethodBeat.o(65018);
    return i1;
  }
  
  public int getScrollBarStyle()
  {
    AppMethodBeat.i(65019);
    if (getView() == null)
    {
      AppMethodBeat.o(65019);
      return 0;
    }
    int i1 = getView().getScrollBarStyle();
    AppMethodBeat.o(65019);
    return i1;
  }
  
  public WebSettings getSettings()
  {
    AppMethodBeat.i(64963);
    if (this.h != null)
    {
      localWebSettings = this.h;
      AppMethodBeat.o(64963);
      return localWebSettings;
    }
    if (this.e)
    {
      localWebSettings = new WebSettings(this.f.getSettings());
      this.h = localWebSettings;
      AppMethodBeat.o(64963);
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.g.getSettings());
    this.h = localWebSettings;
    AppMethodBeat.o(64963);
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    AppMethodBeat.i(64983);
    if (!this.e)
    {
      AppMethodBeat.o(64983);
      return null;
    }
    IX5WebSettingsExtension localIX5WebSettingsExtension = this.f.getX5WebViewExtension().getSettingsExtension();
    AppMethodBeat.o(64983);
    return localIX5WebSettingsExtension;
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(64929);
    if (!this.e)
    {
      str = this.g.getTitle();
      AppMethodBeat.o(64929);
      return str;
    }
    String str = this.f.getTitle();
    AppMethodBeat.o(64929);
    return str;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(64927);
    if (!this.e)
    {
      str = this.g.getUrl();
      AppMethodBeat.o(64927);
      return str;
    }
    String str = this.f.getUrl();
    AppMethodBeat.o(64927);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(64978);
    if (!this.e)
    {
      localObject = this.g;
      AppMethodBeat.o(64978);
      return localObject;
    }
    Object localObject = this.f.getView();
    AppMethodBeat.o(64978);
    return localObject;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(64882);
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.r.a(this.g, "getVisibleTitleHeight");
      if (localObject == null)
      {
        AppMethodBeat.o(64882);
        return 0;
      }
      i1 = ((Integer)localObject).intValue();
      AppMethodBeat.o(64882);
      return i1;
    }
    int i1 = this.f.getVisibleTitleHeight();
    AppMethodBeat.o(64882);
    return i1;
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.r;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    AppMethodBeat.i(64986);
    if (!this.e)
    {
      AppMethodBeat.o(64986);
      return null;
    }
    IX5WebChromeClientExtension localIX5WebChromeClientExtension = this.f.getX5WebViewExtension().getWebChromeClientExtension();
    AppMethodBeat.o(64986);
    return localIX5WebChromeClientExtension;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(64880);
    if (this.e)
    {
      i1 = this.f.getView().getScrollX();
      AppMethodBeat.o(64880);
      return i1;
    }
    int i1 = this.g.getScrollX();
    AppMethodBeat.o(64880);
    return i1;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(64881);
    if (this.e)
    {
      i1 = this.f.getView().getScrollY();
      AppMethodBeat.o(64881);
      return i1;
    }
    int i1 = this.g.getScrollY();
    AppMethodBeat.o(64881);
    return i1;
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.q;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    AppMethodBeat.i(64987);
    if (!this.e)
    {
      AppMethodBeat.o(64987);
      return null;
    }
    IX5WebViewClientExtension localIX5WebViewClientExtension = this.f.getX5WebViewExtension().getWebViewClientExtension();
    AppMethodBeat.o(64987);
    return localIX5WebViewClientExtension;
  }
  
  public Looper getWebViewLooper()
  {
    AppMethodBeat.i(139442);
    try
    {
      if (this.e)
      {
        localObject = com.tencent.smtt.utils.r.a(this.f.getView(), "getWebViewLooper", new Class[0]);
        ((Method)localObject).setAccessible(true);
        localObject = (Looper)((Method)localObject).invoke(this.f.getView(), new Object[0]);
        AppMethodBeat.o(139442);
        return localObject;
      }
      Object localObject = com.tencent.smtt.utils.r.a(this.g, "getWebViewLooper", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = (Looper)((Method)localObject).invoke(this.g, new Object[0]);
      AppMethodBeat.o(139442);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139442);
    }
    return null;
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    AppMethodBeat.i(64924);
    if (!this.e)
    {
      AppMethodBeat.o(64924);
      return null;
    }
    IX5WebViewBase.HitTestResult localHitTestResult = this.f.getHitTestResult();
    AppMethodBeat.o(64924);
    return localHitTestResult;
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    AppMethodBeat.i(64982);
    if (!this.e)
    {
      AppMethodBeat.o(64982);
      return null;
    }
    IX5WebViewExtension localIX5WebViewExtension = this.f.getX5WebViewExtension();
    AppMethodBeat.o(64982);
    return localIX5WebViewExtension;
  }
  
  @Deprecated
  public View getZoomControls()
  {
    AppMethodBeat.i(64968);
    if (!this.e)
    {
      localView = (View)com.tencent.smtt.utils.r.a(this.g, "getZoomControls");
      AppMethodBeat.o(64968);
      return localView;
    }
    View localView = this.f.getZoomControls();
    AppMethodBeat.o(64968);
    return localView;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(64911);
    if (!this.e)
    {
      this.g.goBack();
      AppMethodBeat.o(64911);
      return;
    }
    this.f.goBack();
    AppMethodBeat.o(64911);
  }
  
  public void goBackOrForward(int paramInt)
  {
    AppMethodBeat.i(64915);
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      AppMethodBeat.o(64915);
      return;
    }
    this.f.goBackOrForward(paramInt);
    AppMethodBeat.o(64915);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(64913);
    if (!this.e)
    {
      this.g.goForward();
      AppMethodBeat.o(64913);
      return;
    }
    this.f.goForward();
    AppMethodBeat.o(64913);
  }
  
  public void invokeZoomPicker()
  {
    AppMethodBeat.i(64922);
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      AppMethodBeat.o(64922);
      return;
    }
    this.f.invokeZoomPicker();
    AppMethodBeat.o(64922);
  }
  
  public boolean isDayMode()
  {
    return z;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    AppMethodBeat.i(64970);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.r.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null)
        {
          AppMethodBeat.o(64970);
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
        AppMethodBeat.o(64970);
        return bool;
      }
      AppMethodBeat.o(64970);
      return false;
    }
    boolean bool = this.f.isPrivateBrowsingEnable();
    AppMethodBeat.o(64970);
    return bool;
  }
  
  public boolean isVisibleToUserForAutofill(int paramInt)
  {
    AppMethodBeat.i(139443);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "isVisibleToUserForAutofill", new Class[] { Integer.TYPE });
        localMethod.setAccessible(true);
        bool = ((Boolean)localMethod.invoke(this.f.getView(), new Object[] { Integer.valueOf(paramInt) })).booleanValue();
        AppMethodBeat.o(139443);
        return bool;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "isVisibleToUserForAutofill", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(this.g, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      AppMethodBeat.o(139443);
      return bool;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139443);
    }
    return false;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(64903);
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      AppMethodBeat.o(64903);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(64903);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(64904);
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      AppMethodBeat.o(64904);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(64904);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(64900);
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString)))
    {
      AppMethodBeat.o(64900);
      return;
    }
    if (!this.e)
    {
      this.g.loadUrl(paramString);
      AppMethodBeat.o(64900);
      return;
    }
    this.f.loadUrl(paramString);
    AppMethodBeat.o(64900);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(64899);
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString)))
    {
      AppMethodBeat.o(64899);
      return;
    }
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        this.g.loadUrl(paramString, paramMap);
        AppMethodBeat.o(64899);
      }
    }
    else {
      this.f.loadUrl(paramString, paramMap);
    }
    AppMethodBeat.o(64899);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(64980);
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new bx(this, "onDetachedFromWindow").start();
        AppMethodBeat.o(64980);
        return;
      }
      a();
      AppMethodBeat.o(64980);
      return;
    }
    catch (Throwable localThrowable)
    {
      a();
      AppMethodBeat.o(64980);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(64998);
    if (this.B != null)
    {
      if (!this.B.onLongClick(paramView))
      {
        bool = a(paramView);
        AppMethodBeat.o(64998);
        return bool;
      }
      AppMethodBeat.o(64998);
      return true;
    }
    boolean bool = a(paramView);
    AppMethodBeat.o(64998);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(64940);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "onPause");
      AppMethodBeat.o(64940);
      return;
    }
    this.f.onPause();
    AppMethodBeat.o(64940);
  }
  
  @TargetApi(23)
  public void onProvideVirtualStructure(ViewStructure paramViewStructure)
  {
    AppMethodBeat.i(139444);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "onProvideVirtualStructure", new Class[] { ViewStructure.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramViewStructure });
        AppMethodBeat.o(139444);
        return;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "onProvideVirtualStructure", new Class[] { ViewStructure.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.g, new Object[] { paramViewStructure });
      AppMethodBeat.o(139444);
      return;
    }
    catch (Exception paramViewStructure)
    {
      AppMethodBeat.o(139444);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(64941);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "onResume");
      AppMethodBeat.o(64941);
      return;
    }
    this.f.onResume();
    AppMethodBeat.o(64941);
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(64872);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (c(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
    AppMethodBeat.o(64872);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(64981);
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(64981);
      return;
    }
    if (s == null) {
      s = this.i.getApplicationInfo().packageName;
    }
    if ((s != null) && ((s.equals("com.tencent.mm")) || (s.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(64981);
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
    }
    try
    {
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(64981);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(64877);
    if (!this.e)
    {
      bool = this.g.overlayHorizontalScrollbar();
      AppMethodBeat.o(64877);
      return bool;
    }
    boolean bool = this.f.overlayHorizontalScrollbar();
    AppMethodBeat.o(64877);
    return bool;
  }
  
  public boolean overlayVerticalScrollbar()
  {
    AppMethodBeat.i(64878);
    if (this.e)
    {
      bool = this.f.overlayVerticalScrollbar();
      AppMethodBeat.o(64878);
      return bool;
    }
    boolean bool = this.g.overlayVerticalScrollbar();
    AppMethodBeat.o(64878);
    return bool;
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    AppMethodBeat.i(64917);
    if (!this.e)
    {
      paramBoolean = this.g.pageDown(paramBoolean);
      AppMethodBeat.o(64917);
      return paramBoolean;
    }
    paramBoolean = this.f.pageDown(paramBoolean, -1);
    AppMethodBeat.o(64917);
    return paramBoolean;
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    AppMethodBeat.i(64916);
    if (!this.e)
    {
      paramBoolean = this.g.pageUp(paramBoolean);
      AppMethodBeat.o(64916);
      return paramBoolean;
    }
    paramBoolean = this.f.pageUp(paramBoolean, -1);
    AppMethodBeat.o(64916);
    return paramBoolean;
  }
  
  public void pauseTimers()
  {
    AppMethodBeat.i(64938);
    if (!this.e)
    {
      this.g.pauseTimers();
      AppMethodBeat.o(64938);
      return;
    }
    this.f.pauseTimers();
    AppMethodBeat.o(64938);
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(64902);
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      AppMethodBeat.o(64902);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
    AppMethodBeat.o(64902);
  }
  
  public void postVisualStateCallback(long paramLong, WebView.c paramc)
  {
    AppMethodBeat.i(139445);
    try
    {
      if ((!this.e) && (Build.VERSION.SDK_INT >= 23))
      {
        Method localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "onProvideVirtualStructure", new Class[] { Long.TYPE, WebView.VisualStateCallback.class });
        paramc = new bq(this, paramc);
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { Long.valueOf(paramLong), paramc });
      }
      AppMethodBeat.o(139445);
      return;
    }
    catch (Exception paramc)
    {
      AppMethodBeat.o(139445);
    }
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(64965);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64965);
      return;
    }
    this.f.refreshPlugins(paramBoolean);
    AppMethodBeat.o(64965);
  }
  
  public void reload()
  {
    AppMethodBeat.i(64909);
    if (!this.e)
    {
      this.g.reload();
      AppMethodBeat.o(64909);
      return;
    }
    this.f.reload();
    AppMethodBeat.o(64909);
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(64962);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.r.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(64962);
        return;
      }
      this.f.removeJavascriptInterface(paramString);
    }
    AppMethodBeat.o(64962);
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(65005);
    if (!this.e)
    {
      this.g.removeView(paramView);
      AppMethodBeat.o(65005);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.r.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      AppMethodBeat.o(65005);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(65005);
    }
  }
  
  public JSONObject reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(139435);
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
        AppMethodBeat.o(139435);
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
    AppMethodBeat.i(64879);
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
          AppMethodBeat.o(64879);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(64879);
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    paramBoolean = ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
    AppMethodBeat.o(64879);
    return paramBoolean;
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    AppMethodBeat.i(64925);
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      AppMethodBeat.o(64925);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
    AppMethodBeat.o(64925);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    AppMethodBeat.i(64926);
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      AppMethodBeat.o(64926);
      return;
    }
    this.f.requestImageRef(paramMessage);
    AppMethodBeat.o(64926);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    AppMethodBeat.i(64896);
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.r.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null)
      {
        AppMethodBeat.o(64896);
        return false;
      }
      bool = ((Boolean)paramBundle).booleanValue();
      AppMethodBeat.o(64896);
      return bool;
    }
    boolean bool = this.f.restorePicture(paramBundle, paramFile);
    AppMethodBeat.o(64896);
    return bool;
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    AppMethodBeat.i(64897);
    if (!this.e)
    {
      paramBundle = WebBackForwardList.a(this.g.restoreState(paramBundle));
      AppMethodBeat.o(64897);
      return paramBundle;
    }
    paramBundle = WebBackForwardList.a(this.f.restoreState(paramBundle));
    AppMethodBeat.o(64897);
    return paramBundle;
  }
  
  public void resumeTimers()
  {
    AppMethodBeat.i(64939);
    if (!this.e)
    {
      this.g.resumeTimers();
      AppMethodBeat.o(64939);
      return;
    }
    this.f.resumeTimers();
    AppMethodBeat.o(64939);
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(64885);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      AppMethodBeat.o(64885);
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
    AppMethodBeat.o(64885);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    AppMethodBeat.i(64895);
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.r.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null)
      {
        AppMethodBeat.o(64895);
        return false;
      }
      bool = ((Boolean)paramBundle).booleanValue();
      AppMethodBeat.o(64895);
      return bool;
    }
    boolean bool = this.f.savePicture(paramBundle, paramFile);
    AppMethodBeat.o(64895);
    return bool;
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    AppMethodBeat.i(64894);
    if (!this.e)
    {
      paramBundle = WebBackForwardList.a(this.g.saveState(paramBundle));
      AppMethodBeat.o(64894);
      return paramBundle;
    }
    paramBundle = WebBackForwardList.a(this.f.saveState(paramBundle));
    AppMethodBeat.o(64894);
    return paramBundle;
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    AppMethodBeat.i(64905);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.r.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(64905);
      }
    }
    else {
      this.f.saveWebArchive(paramString);
    }
    AppMethodBeat.o(64905);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(64906);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.r.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
        AppMethodBeat.o(64906);
      }
    }
    else {
      this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
    }
    AppMethodBeat.o(64906);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(64997);
    try
    {
      if (this.e) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      AppMethodBeat.o(64997);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(64997);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(64977);
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      AppMethodBeat.o(64977);
      return;
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(64884);
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      AppMethodBeat.o(64884);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
    AppMethodBeat.o(64884);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    AppMethodBeat.i(64996);
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      AppMethodBeat.o(64996);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(64996);
    }
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(64958);
    if (!this.e)
    {
      this.g.setDownloadListener(new bu(this, paramDownloadListener));
      AppMethodBeat.o(64958);
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
    AppMethodBeat.o(64958);
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    AppMethodBeat.i(64948);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.g.setFindListener(new bt(this, paramFindListener));
        AppMethodBeat.o(64948);
      }
    }
    else {
      this.f.setFindListener(paramFindListener);
    }
    AppMethodBeat.o(64948);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(64875);
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      AppMethodBeat.o(64875);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
    AppMethodBeat.o(64875);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(64886);
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(64886);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(64886);
  }
  
  public void setInitialScale(int paramInt)
  {
    AppMethodBeat.i(64921);
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      AppMethodBeat.o(64921);
      return;
    }
    this.f.setInitialScale(paramInt);
    AppMethodBeat.o(64921);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    AppMethodBeat.i(64966);
    if (!this.e)
    {
      com.tencent.smtt.utils.r.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(64966);
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
    AppMethodBeat.o(64966);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    AppMethodBeat.i(64893);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3)
      {
        this.g.setNetworkAvailable(paramBoolean);
        AppMethodBeat.o(64893);
      }
    }
    else {
      this.f.setNetworkAvailable(paramBoolean);
    }
    AppMethodBeat.o(64893);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(64999);
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      AppMethodBeat.o(64999);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.A == null)
      {
        Object localObject2 = com.tencent.smtt.utils.r.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.A = ((Field)localObject2).get(localObject1);
      }
      this.B = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      AppMethodBeat.o(64999);
      return;
    }
    catch (Throwable paramOnLongClickListener)
    {
      AppMethodBeat.o(64999);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(64991);
    getView().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(64991);
  }
  
  public void setPictureListener(WebView.PictureListener paramPictureListener)
  {
    AppMethodBeat.i(64960);
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        AppMethodBeat.o(64960);
        return;
      }
      this.g.setPictureListener(new bv(this, paramPictureListener));
      AppMethodBeat.o(64960);
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      AppMethodBeat.o(64960);
      return;
    }
    this.f.setPictureListener(new bw(this, paramPictureListener));
    AppMethodBeat.o(64960);
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(64932);
    try
    {
      if (!this.e)
      {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 < 26)
        {
          AppMethodBeat.o(64932);
          return;
        }
        com.tencent.smtt.utils.r.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(64932);
        return;
      }
      AppMethodBeat.o(64932);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(64932);
    }
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    AppMethodBeat.i(64874);
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      AppMethodBeat.o(64874);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
    AppMethodBeat.o(64874);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(64876);
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      AppMethodBeat.o(64876);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
    AppMethodBeat.o(64876);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(64990);
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        AppMethodBeat.o(64990);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    AppMethodBeat.o(64990);
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(65020);
    super.setVisibility(paramInt);
    if (getView() == null)
    {
      AppMethodBeat.o(65020);
      return;
    }
    getView().setVisibility(paramInt);
    AppMethodBeat.o(65020);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    AppMethodBeat.i(64959);
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.r = paramWebChromeClient;
        AppMethodBeat.o(64959);
        return;
        localObject = new r(bz.a().a(true).i(), this, paramWebChromeClient);
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
    AppMethodBeat.i(64985);
    if (!this.e)
    {
      AppMethodBeat.o(64985);
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
    AppMethodBeat.o(64985);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    AppMethodBeat.i(64956);
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
    AppMethodBeat.o(64956);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    AppMethodBeat.i(64955);
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.q = paramWebViewClient;
        AppMethodBeat.o(64955);
        return;
        localObject = new w(bz.a().a(true).j(), this, paramWebViewClient);
      }
    }
    b localb = this.g;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new ae(this, paramWebViewClient))
    {
      localb.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    AppMethodBeat.i(64984);
    if (!this.e)
    {
      AppMethodBeat.o(64984);
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
    AppMethodBeat.o(64984);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    AppMethodBeat.i(64901);
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, am.a().getLooper());
      AppMethodBeat.o(64901);
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
        AppMethodBeat.o(64901);
        return true;
      }
      AppMethodBeat.o(64901);
      return false;
    }
    AppMethodBeat.o(64901);
    return false;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(64907);
    if (!this.e)
    {
      this.g.stopLoading();
      AppMethodBeat.o(64907);
      return;
    }
    this.f.stopLoading();
    AppMethodBeat.o(64907);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(65015);
    if (!this.e)
    {
      this.g.a();
      AppMethodBeat.o(65015);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.r.a(localView, "super_computeScroll");
      AppMethodBeat.o(65015);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(65015);
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65012);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.b(paramMotionEvent);
      AppMethodBeat.o(65012);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.r.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(65012);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(65012);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(65012);
    }
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65013);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.c(paramMotionEvent);
      AppMethodBeat.o(65013);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.r.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(65013);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(65013);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(65013);
    }
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(65011);
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(65011);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.r.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      AppMethodBeat.o(65011);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(65011);
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(65009);
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(65009);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.r.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      AppMethodBeat.o(65009);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(65009);
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65014);
    boolean bool;
    if (!this.e)
    {
      bool = this.g.a(paramMotionEvent);
      AppMethodBeat.o(65014);
      return bool;
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.r.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null)
      {
        AppMethodBeat.o(65014);
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      AppMethodBeat.o(65014);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      AppMethodBeat.o(65014);
    }
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(65010);
    if (!this.e)
    {
      paramBoolean = this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      AppMethodBeat.o(65010);
      return paramBoolean;
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = com.tencent.smtt.utils.r.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null)
      {
        AppMethodBeat.o(65010);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(65010);
      return false;
    }
    paramBoolean = ((Boolean)localThrowable).booleanValue();
    AppMethodBeat.o(65010);
    return paramBoolean;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    AppMethodBeat.i(64993);
    if (paramBoolean == z)
    {
      AppMethodBeat.o(64993);
      return;
    }
    z = paramBoolean;
    if (paramBoolean)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      AppMethodBeat.o(64993);
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    AppMethodBeat.o(64993);
  }
  
  public void switchToNightMode()
  {
    AppMethodBeat.i(64994);
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!z)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
    AppMethodBeat.o(64994);
  }
  
  /* Error */
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2018
    //   3: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 159	com/tencent/smtt/sdk/WebView:k	Z
    //   10: ifne +218 -> 228
    //   13: aload_0
    //   14: getfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   17: ifeq +211 -> 228
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 159	com/tencent/smtt/sdk/WebView:k	Z
    //   25: ldc_w 774
    //   28: astore 8
    //   30: ldc_w 774
    //   33: astore 9
    //   35: ldc_w 774
    //   38: astore 10
    //   40: aload 8
    //   42: astore 7
    //   44: aload 9
    //   46: astore 6
    //   48: aload 10
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 151	com/tencent/smtt/sdk/WebView:e	Z
    //   56: ifeq +66 -> 122
    //   59: aload_0
    //   60: getfield 207	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   63: invokeinterface 427 1 0
    //   68: invokeinterface 938 1 0
    //   73: astore 11
    //   75: aload 8
    //   77: astore 7
    //   79: aload 9
    //   81: astore 6
    //   83: aload 10
    //   85: astore 5
    //   87: aload 11
    //   89: ifnull +33 -> 122
    //   92: aload 11
    //   94: ldc_w 940
    //   97: invokevirtual 945	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 7
    //   102: aload 11
    //   104: ldc_w 947
    //   107: invokevirtual 945	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 6
    //   112: aload 11
    //   114: ldc_w 949
    //   117: invokevirtual 945	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 5
    //   122: ldc_w 951
    //   125: aload_0
    //   126: getfield 155	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   129: invokevirtual 447	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   132: getfield 452	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   135: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +37 -> 175
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 155	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   146: invokespecial 953	com/tencent/smtt/sdk/WebView:d	(Landroid/content/Context;)I
    //   149: istore_3
    //   150: iload_3
    //   151: istore_2
    //   152: iload_3
    //   153: iconst_m1
    //   154: if_icmpne +8 -> 162
    //   157: aload_0
    //   158: getfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   161: istore_2
    //   162: aload_0
    //   163: iload_2
    //   164: putfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 155	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   172: invokespecial 955	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)V
    //   175: aload_0
    //   176: getfield 207	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   179: invokeinterface 427 1 0
    //   184: invokeinterface 958 1 0
    //   189: istore 4
    //   191: aload_0
    //   192: getfield 155	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   195: aload 7
    //   197: aload 6
    //   199: aload 5
    //   201: aload_0
    //   202: getfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   205: aload_0
    //   206: getfield 151	com/tencent/smtt/sdk/WebView:e	Z
    //   209: aload_0
    //   210: invokespecial 960	com/tencent/smtt/sdk/WebView:i	()J
    //   213: iload 4
    //   215: invokestatic 965	com/tencent/smtt/sdk/a/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJZ)V
    //   218: aload_0
    //   219: iconst_0
    //   220: putfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 159	com/tencent/smtt/sdk/WebView:k	Z
    //   228: aload_0
    //   229: getfield 151	com/tencent/smtt/sdk/WebView:e	Z
    //   232: ifne +340 -> 572
    //   235: ldc_w 2020
    //   238: invokestatic 243	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   241: astore 5
    //   243: aload 5
    //   245: ldc_w 2022
    //   248: iconst_1
    //   249: anewarray 239	java/lang/Class
    //   252: dup
    //   253: iconst_0
    //   254: ldc_w 286
    //   257: aastore
    //   258: invokevirtual 2025	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   261: astore 6
    //   263: aload 6
    //   265: iconst_1
    //   266: invokevirtual 255	java/lang/reflect/Method:setAccessible	(Z)V
    //   269: aload 6
    //   271: aconst_null
    //   272: iconst_1
    //   273: anewarray 257	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: getfield 217	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   282: aastore
    //   283: invokevirtual 261	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   286: astore 6
    //   288: aload 6
    //   290: ifnull +114 -> 404
    //   293: aload 5
    //   295: ldc_w 2027
    //   298: invokevirtual 1784	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   301: astore 5
    //   303: aload 5
    //   305: iconst_1
    //   306: invokevirtual 1787	java/lang/reflect/Field:setAccessible	(Z)V
    //   309: aload 5
    //   311: aload 6
    //   313: invokevirtual 1788	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   316: astore 5
    //   318: aload 5
    //   320: ifnull +84 -> 404
    //   323: aload 5
    //   325: checkcast 2029	android/app/Dialog
    //   328: astore 5
    //   330: aload 5
    //   332: aconst_null
    //   333: invokevirtual 2033	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   336: ldc_w 2035
    //   339: invokestatic 243	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   342: astore 6
    //   344: aload 6
    //   346: ldc_w 2037
    //   349: invokevirtual 1784	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   352: astore 7
    //   354: aload 7
    //   356: iconst_1
    //   357: invokevirtual 1787	java/lang/reflect/Field:setAccessible	(Z)V
    //   360: aload 7
    //   362: aload 5
    //   364: invokevirtual 1788	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   367: checkcast 714	java/lang/Integer
    //   370: invokevirtual 1098	java/lang/Integer:intValue	()I
    //   373: istore_2
    //   374: aload 6
    //   376: ldc_w 2039
    //   379: invokevirtual 1784	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   382: astore 6
    //   384: aload 6
    //   386: iconst_1
    //   387: invokevirtual 1787	java/lang/reflect/Field:setAccessible	(Z)V
    //   390: aload 6
    //   392: aload 5
    //   394: invokevirtual 1788	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast 263	android/os/Handler
    //   400: iload_2
    //   401: invokevirtual 2042	android/os/Handler:removeMessages	(I)V
    //   404: iload_1
    //   405: ifeq +10 -> 415
    //   408: aload_0
    //   409: getfield 217	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   412: invokevirtual 1177	android/webkit/WebView:destroy	()V
    //   415: ldc_w 2044
    //   418: invokestatic 243	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   421: ldc_w 2046
    //   424: invokevirtual 1784	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   427: astore 6
    //   429: aload 6
    //   431: iconst_1
    //   432: invokevirtual 1787	java/lang/reflect/Field:setAccessible	(Z)V
    //   435: aload 6
    //   437: aconst_null
    //   438: invokevirtual 1788	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   441: checkcast 2048	android/content/ComponentCallbacks
    //   444: astore 5
    //   446: aload 5
    //   448: ifnull +66 -> 514
    //   451: aload 6
    //   453: aconst_null
    //   454: aconst_null
    //   455: invokevirtual 2052	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   458: ldc_w 2054
    //   461: invokestatic 243	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   464: ldc_w 2056
    //   467: invokevirtual 1784	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   470: astore 6
    //   472: aload 6
    //   474: iconst_1
    //   475: invokevirtual 1787	java/lang/reflect/Field:setAccessible	(Z)V
    //   478: aload 6
    //   480: aconst_null
    //   481: invokevirtual 1788	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   484: astore 6
    //   486: aload 6
    //   488: ifnull +26 -> 514
    //   491: aload 6
    //   493: checkcast 888	java/util/List
    //   496: astore 6
    //   498: aload 6
    //   500: monitorenter
    //   501: aload 6
    //   503: aload 5
    //   505: invokeinterface 2059 2 0
    //   510: pop
    //   511: aload 6
    //   513: monitorexit
    //   514: ldc 147
    //   516: new 510	java/lang/StringBuilder
    //   519: dup
    //   520: ldc_w 2061
    //   523: invokespecial 513	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   526: invokestatic 2063	com/tencent/smtt/sdk/QbSdk:b	()Ljava/lang/String;
    //   529: invokevirtual 522	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 528	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 305	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: ldc_w 2018
    //   541: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   544: return
    //   545: astore 8
    //   547: iconst_0
    //   548: istore 4
    //   550: goto -359 -> 191
    //   553: astore 5
    //   555: aload 6
    //   557: monitorexit
    //   558: ldc_w 2018
    //   561: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   564: aload 5
    //   566: athrow
    //   567: astore 5
    //   569: goto -55 -> 514
    //   572: iload_1
    //   573: ifeq -59 -> 514
    //   576: aload_0
    //   577: getfield 207	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   580: invokeinterface 1176 1 0
    //   585: goto -71 -> 514
    //   588: astore 5
    //   590: goto -186 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	WebView
    //   0	593	1	paramBoolean	boolean
    //   151	250	2	i1	int
    //   149	6	3	i2	int
    //   189	360	4	bool	boolean
    //   50	454	5	localObject1	Object
    //   553	12	5	localObject2	Object
    //   567	1	5	localException1	Exception
    //   588	1	5	localException2	Exception
    //   42	319	7	localObject4	Object
    //   28	48	8	str1	String
    //   545	1	8	localThrowable	Throwable
    //   33	47	9	str2	String
    //   38	46	10	str3	String
    //   73	40	11	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   175	191	545	java/lang/Throwable
    //   501	514	553	finally
    //   555	558	553	finally
    //   415	446	567	java/lang/Exception
    //   451	486	567	java/lang/Exception
    //   491	501	567	java/lang/Exception
    //   558	567	567	java/lang/Exception
    //   235	288	588	java/lang/Exception
    //   293	318	588	java/lang/Exception
    //   323	404	588	java/lang/Exception
  }
  
  public void zoomBy(float paramFloat)
  {
    AppMethodBeat.i(139449);
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.r.a(this.f.getView(), "onProvideVirtualStructure", new Class[] { Float.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { Float.valueOf(paramFloat) });
        AppMethodBeat.o(139449);
        return;
      }
      Method localMethod = com.tencent.smtt.utils.r.a(this.g, "onProvideVirtualStructure", new Class[] { Float.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(this.g, new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(139449);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(139449);
    }
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(64972);
    if (!this.e)
    {
      bool = this.g.zoomIn();
      AppMethodBeat.o(64972);
      return bool;
    }
    boolean bool = this.f.zoomIn();
    AppMethodBeat.o(64972);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(64973);
    if (!this.e)
    {
      bool = this.g.zoomOut();
      AppMethodBeat.o(64973);
      return bool;
    }
    boolean bool = this.f.zoomOut();
    AppMethodBeat.o(64973);
    return bool;
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
      AppMethodBeat.i(64843);
      if ((!QbSdk.getIsSysWebViewForcedByOuter()) || (!TbsShareManager.isThirdPartyApp(paramContext)))
      {
        CookieSyncManager.createInstance(WebView.a(WebView.this)).startSync();
        try
        {
          this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
          WebView.this.setAccessible(true);
          ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
          WebView.mSysWebviewCreated = true;
          AppMethodBeat.o(64843);
          return;
        }
        catch (Exception this$1) {}
      }
      AppMethodBeat.o(64843);
    }
    
    public void a()
    {
      AppMethodBeat.i(64849);
      super.computeScroll();
      AppMethodBeat.o(64849);
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(64847);
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(64847);
    }
    
    @TargetApi(9)
    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(64856);
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(64856);
    }
    
    @TargetApi(9)
    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(64854);
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
        AppMethodBeat.o(64854);
        return paramBoolean;
      }
      AppMethodBeat.o(64854);
      return false;
    }
    
    public boolean a(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64851);
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(64851);
      return bool;
    }
    
    public boolean b(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64858);
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(64858);
      return bool;
    }
    
    public boolean c(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64860);
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(64860);
      return bool;
    }
    
    public void computeScroll()
    {
      AppMethodBeat.i(64848);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        AppMethodBeat.o(64848);
        return;
      }
      super.computeScroll();
      AppMethodBeat.o(64848);
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      AppMethodBeat.i(64852);
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.f()) && (WebView.g() != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.g());
          paramCanvas.restore();
        }
        AppMethodBeat.o(64852);
        return;
      }
      catch (Throwable paramCanvas)
      {
        AppMethodBeat.o(64852);
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64857);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(64857);
        return bool;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(64857);
      return bool;
    }
    
    public android.webkit.WebSettings getSettings()
    {
      AppMethodBeat.i(64845);
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        AppMethodBeat.o(64845);
        return localWebSettings;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(64845);
      }
      return null;
    }
    
    public void invalidate()
    {
      AppMethodBeat.i(64844);
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.invalidate();
      }
      AppMethodBeat.o(64844);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64859);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(64859);
        return bool;
      }
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(64859);
      return bool;
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(64855);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
        AppMethodBeat.o(64855);
        return;
      }
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(64855);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(64846);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        AppMethodBeat.o(64846);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.b(WebView.this, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(64846);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(64850);
      if (!hasFocus()) {
        requestFocus();
      }
      boolean bool;
      if (WebView.this.mWebViewCallbackClient != null)
      {
        bool = WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
        AppMethodBeat.o(64850);
        return bool;
      }
      try
      {
        bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(64850);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        AppMethodBeat.o(64850);
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      AppMethodBeat.i(64853);
      if (WebView.this.mWebViewCallbackClient != null)
      {
        paramBoolean = WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
        AppMethodBeat.o(64853);
        return paramBoolean;
      }
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramBoolean = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
        AppMethodBeat.o(64853);
        return paramBoolean;
      }
      AppMethodBeat.o(64853);
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      AppMethodBeat.i(64861);
      try
      {
        super.setOverScrollMode(paramInt);
        AppMethodBeat.o(64861);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(64861);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */