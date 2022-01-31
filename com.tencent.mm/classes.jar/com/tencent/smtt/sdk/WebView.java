package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
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
import com.tencent.smtt.utils.t;
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

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final Lock c = new ReentrantLock();
  private static OutputStream d = null;
  private static Context j = null;
  public static boolean mSysWebviewCreated;
  public static boolean mWebViewCreated;
  private static BroadcastReceiver n = null;
  private static t o;
  private static Method p;
  private static String s;
  private static Paint y;
  private static boolean z;
  private Object A = null;
  private View.OnLongClickListener B = null;
  int a = 0;
  private final String b = "WebView";
  private boolean e = false;
  private IX5WebViewBase f;
  private WebView.b g;
  private WebSettings h = null;
  private Context i = null;
  private boolean k = false;
  private am l = null;
  private boolean m = false;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient q = null;
  private WebChromeClient r = null;
  private final int t = 1;
  private final int u = 2;
  private final int v = 3;
  private final String w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private final String x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  
  static
  {
    mWebViewCreated = false;
    o = null;
    p = null;
    s = null;
    mSysWebviewCreated = false;
    y = null;
    z = true;
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
    mWebViewCreated = true;
    this.l = new am();
    this.l.a("init_all", (byte)1);
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.i = paramContext;
      this.f = null;
      this.e = false;
      QbSdk.a(paramContext, "failed to createTBSWebview!");
      this.g = new WebView.b(this, paramContext, paramAttributeSet);
      CookieManager.getInstance().a(paramContext, true, false);
      CookieSyncManager.createInstance(this.i).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
      mSysWebviewCreated = true;
      label239:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable());
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
        throw new IllegalArgumentException("Invalid context argument");
        TbsLog.setWriteLogJIT(false);
      }
      if (o == null) {
        o = t.a(paramContext);
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
        this.f = bv.a().a(true).a(paramContext);
        this.l.a("init_x5_webview", (byte)2);
        if ((this.f == null) || (this.f.getView() == null))
        {
          TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
          this.f = null;
          this.e = false;
          QbSdk.a(paramContext, "failed to createTBSWebview!");
          a(paramContext, this.l);
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new WebView.b(this, paramContext, paramAttributeSet);
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
          label631:
          b(paramContext);
          TbsLog.writeLogToDisk();
          an.a(paramContext);
          return;
          this.g = new WebView.b(this, paramContext);
          continue;
          TbsLog.i("WebView", "X5 WebView Created Success!!");
          this.f.getView().setFocusableInTouchMode(true);
          a(paramAttributeSet);
          addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
          this.f.setDownloadListener(new b(this, null, this.e));
          this.f.getX5WebViewExtension().setWebViewClientExtension(new bm(this, bv.a().a(true).k()));
          try
          {
            if (Build.VERSION.SDK_INT >= 11)
            {
              removeJavascriptInterface("searchBoxJavaBridge_");
              removeJavascriptInterface("accessibility");
              removeJavascriptInterface("accessibilityTraversal");
            }
            label791:
            if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (o.a(true).h()) && (Build.VERSION.SDK_INT >= 11)) {
              setLayerType(1, null);
            }
            if (this.f != null)
            {
              TbsLog.writeLogToDisk();
              if (!TbsShareManager.isThirdPartyApp(paramContext))
              {
                paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
                if ((paramInt <= 0) || (paramInt == an.a().i(paramContext)) || (paramInt != an.a().j(paramContext))) {
                  break label1067;
                }
                an.a().o(paramContext);
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
              return;
              this.f = null;
              if (TbsShareManager.isThirdPartyApp(this.i)) {}
              for (this.g = new WebView.b(this, paramContext, paramAttributeSet);; this.g = new WebView.b(this, paramContext))
              {
                TbsLog.i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().a(paramContext, true, false);
                CookieManager.getInstance().a();
                this.g.setFocusableInTouchMode(true);
                addView(this.g, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                b(paramContext);
                TbsLog.writeLogToDisk();
                an.a(paramContext);
                break;
              }
              label1067:
              TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + an.a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + an.a().j(paramContext));
            }
          }
          catch (Throwable paramAttributeSet)
          {
            break label791;
          }
        }
        catch (Throwable paramAttributeSet)
        {
          break label631;
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label239;
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private void a(Context paramContext, am paramam)
  {
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramam != null) {
      paramam.a("x5_core_engine_init_sync", (byte)1);
    }
    bv localbv = bv.a();
    localbv.a(paramContext, paramam);
    this.e = localbv.b();
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    if (paramAttributeSet != null) {
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        while (i1 < i2)
        {
          if (paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars"))
          {
            int[] arrayOfInt = getResources().getIntArray(16842974);
            int i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
            if (i3 == arrayOfInt[1])
            {
              this.f.getView().setVerticalScrollBarEnabled(false);
              this.f.getView().setHorizontalScrollBarEnabled(false);
            }
            else if (i3 == arrayOfInt[2])
            {
              this.f.getView().setVerticalScrollBarEnabled(false);
            }
            else if (i3 == arrayOfInt[3])
            {
              this.f.getView().setHorizontalScrollBarEnabled(false);
            }
          }
          i1 += 1;
        }
        return;
      }
      catch (Exception paramAttributeSet) {}
    }
  }
  
  private boolean a(View paramView)
  {
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200)) {
      return false;
    }
    paramView = com.tencent.smtt.utils.q.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private void b(Context paramContext)
  {
    if (n != null) {
      return;
    }
    n = new WebView.a(null);
    new bn(this, paramContext).start();
  }
  
  private boolean c(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  private int d(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 617
    //   5: invokestatic 622	com/tencent/smtt/utils/j:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 6
    //   18: invokestatic 625	com/tencent/smtt/utils/j:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 630 1 0
    //   38: ifeq +402 -> 440
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_1
    //   45: ldc_w 632
    //   48: iconst_0
    //   49: invokevirtual 636	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   52: astore_1
    //   53: new 638	java/io/File
    //   56: dup
    //   57: new 499	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 639	java/lang/StringBuilder:<init>	()V
    //   64: aload_1
    //   65: invokevirtual 642	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: getstatic 645	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 647
    //   77: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: ldc_w 649
    //   86: invokespecial 651	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 654	java/io/File:exists	()Z
    //   94: istore_3
    //   95: iload_3
    //   96: ifne +20 -> 116
    //   99: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   102: invokeinterface 657 1 0
    //   107: aload 7
    //   109: aload 6
    //   111: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   114: iconst_m1
    //   115: ireturn
    //   116: new 662	java/util/Properties
    //   119: dup
    //   120: invokespecial 663	java/util/Properties:<init>	()V
    //   123: astore 8
    //   125: new 665	java/io/FileInputStream
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 668	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   133: astore 4
    //   135: aload 4
    //   137: astore_1
    //   138: aload 8
    //   140: aload 4
    //   142: invokevirtual 672	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   145: aload 4
    //   147: astore_1
    //   148: aload 4
    //   150: invokevirtual 675	java/io/FileInputStream:close	()V
    //   153: aload 4
    //   155: astore_1
    //   156: aload 8
    //   158: ldc_w 677
    //   161: invokevirtual 681	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   164: astore 5
    //   166: aload 5
    //   168: ifnonnull +55 -> 223
    //   171: aload 4
    //   173: invokevirtual 675	java/io/FileInputStream:close	()V
    //   176: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   179: invokeinterface 657 1 0
    //   184: aload 7
    //   186: aload 6
    //   188: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   191: iconst_m1
    //   192: ireturn
    //   193: astore_1
    //   194: ldc_w 683
    //   197: new 499	java/lang/StringBuilder
    //   200: dup
    //   201: ldc_w 685
    //   204: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: aload_1
    //   208: invokevirtual 686	java/io/IOException:toString	()Ljava/lang/String;
    //   211: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 688	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: goto -44 -> 176
    //   223: aload 4
    //   225: astore_1
    //   226: aload 5
    //   228: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   231: istore_2
    //   232: aload 4
    //   234: invokevirtual 675	java/io/FileInputStream:close	()V
    //   237: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   240: invokeinterface 657 1 0
    //   245: aload 7
    //   247: aload 6
    //   249: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   252: iload_2
    //   253: ireturn
    //   254: astore_1
    //   255: ldc_w 683
    //   258: new 499	java/lang/StringBuilder
    //   261: dup
    //   262: ldc_w 685
    //   265: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 686	java/io/IOException:toString	()Ljava/lang/String;
    //   272: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 688	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: goto -44 -> 237
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 4
    //   289: aload 4
    //   291: astore_1
    //   292: ldc_w 683
    //   295: new 499	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 695
    //   302: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload 5
    //   307: invokevirtual 696	java/lang/Exception:toString	()Ljava/lang/String;
    //   310: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 688	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload 4
    //   321: ifnull +8 -> 329
    //   324: aload 4
    //   326: invokevirtual 675	java/io/FileInputStream:close	()V
    //   329: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   332: invokeinterface 657 1 0
    //   337: aload 7
    //   339: aload 6
    //   341: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   344: iconst_m1
    //   345: ireturn
    //   346: astore_1
    //   347: ldc_w 683
    //   350: new 499	java/lang/StringBuilder
    //   353: dup
    //   354: ldc_w 685
    //   357: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload_1
    //   361: invokevirtual 686	java/io/IOException:toString	()Ljava/lang/String;
    //   364: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 688	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: goto -44 -> 329
    //   376: astore_1
    //   377: aload 5
    //   379: astore 4
    //   381: aload 4
    //   383: ifnull +8 -> 391
    //   386: aload 4
    //   388: invokevirtual 675	java/io/FileInputStream:close	()V
    //   391: getstatic 92	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   394: invokeinterface 657 1 0
    //   399: aload 7
    //   401: aload 6
    //   403: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   406: aload_1
    //   407: athrow
    //   408: astore 4
    //   410: ldc_w 683
    //   413: new 499	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 685
    //   420: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: aload 4
    //   425: invokevirtual 686	java/io/IOException:toString	()Ljava/lang/String;
    //   428: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 517	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 688	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: goto -46 -> 391
    //   440: aload 7
    //   442: aload 6
    //   444: invokestatic 660	com/tencent/smtt/utils/j:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   447: iconst_m1
    //   448: ireturn
    //   449: astore 5
    //   451: aload_1
    //   452: astore 4
    //   454: aload 5
    //   456: astore_1
    //   457: goto -76 -> 381
    //   460: astore 5
    //   462: goto -173 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	WebView
    //   0	465	1	paramContext	Context
    //   231	22	2	i1	int
    //   94	2	3	bool	boolean
    //   133	254	4	localObject1	Object
    //   408	16	4	localIOException	java.io.IOException
    //   452	1	4	localContext	Context
    //   42	185	5	str	String
    //   284	94	5	localException1	Exception
    //   449	6	5	localObject2	Object
    //   460	1	5	localException2	Exception
    //   8	435	6	localFileOutputStream	FileOutputStream
    //   21	420	7	localFileLock	java.nio.channels.FileLock
    //   123	34	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   171	176	193	java/io/IOException
    //   232	237	254	java/io/IOException
    //   44	95	284	java/lang/Exception
    //   116	135	284	java/lang/Exception
    //   324	329	346	java/io/IOException
    //   44	95	376	finally
    //   116	135	376	finally
    //   386	391	408	java/io/IOException
    //   138	145	449	finally
    //   148	153	449	finally
    //   156	166	449	finally
    //   226	232	449	finally
    //   292	319	449	finally
    //   138	145	460	java/lang/Exception
    //   148	153	460	java/lang/Exception
    //   156	166	460	java/lang/Exception
    //   226	232	460	java/lang/Exception
  }
  
  static void d()
  {
    new bu().start();
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!bv.a().b()) {
      com.tencent.smtt.utils.q.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  private void e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (!paramContext.exists()) {
        return;
      }
      paramContext.delete();
      return;
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!bv.a().b()) {
      com.tencent.smtt.utils.q.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!bv.a().b()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";tbs_sdk_version:43617;";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(o.a(true).e());
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.n != null) && (QbSdk.n.containsKey("weapp_id")) && (QbSdk.n.containsKey("weapp_name")))
    {
      paramContext = "weapp_id:" + QbSdk.n.get("weapp_id") + ";weapp_name:" + QbSdk.n.get("weapp_name") + ";";
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext);
    }
    if (localStringBuilder.length() > 8192) {
      return localStringBuilder.substring(localStringBuilder.length() - 8192);
    }
    return localStringBuilder.toString();
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!bv.a().b())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.q.a("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 351	com/tencent/smtt/sdk/bv:a	()Lcom/tencent/smtt/sdk/bv;
    //   6: invokevirtual 538	com/tencent/smtt/sdk/bv:b	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 704
    //   15: ldc_w 770
    //   18: invokestatic 708	com/tencent/smtt/utils/q:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -7 -> 22
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	8	0	localObject1	Object
    //   32	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    d();
    return o.a(true).f();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43617;
  }
  
  private long i()
  {
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
      return l1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = z;
        if (paramBoolean == bool) {
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
            continue;
          }
          y.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (y.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      y.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    Object localObject = bv.a();
    if ((localObject != null) && (((bv)localObject).b())) {
      ((bv)localObject).c().a(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          localObject = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
          p = (Method)localObject;
          if (localObject != null)
          {
            p.setAccessible(true);
            p.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
            return;
          }
        }
        catch (Exception localException)
        {
          TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
        }
      }
    }
  }
  
  protected void a()
  {
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
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
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, i());
      this.a = 0;
      this.k = false;
    }
    super.onDetachedFromWindow();
  }
  
  void a(Context paramContext)
  {
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
      }
      try
      {
        if (d != null) {
          d.flush();
        }
        return;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  void a(android.webkit.WebView paramWebView) {}
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.e)
    {
      this.g.addView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.q.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
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
    if (!this.e) {
      return this.g.canGoBack();
    }
    return this.f.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.e) {
      return this.g.canGoBackOrForward(paramInt);
    }
    return this.f.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.e) {
      return this.g.canGoForward();
    }
    return this.f.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.q.a(this.g, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.q.a(this.g, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.q.a(this.g, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.f.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      return;
    }
    this.f.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.e)
    {
      this.g.clearFormData();
      return;
    }
    this.f.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.e)
    {
      this.g.clearHistory();
      return;
    }
    this.f.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.e)
    {
      this.g.clearMatches();
      return;
    }
    this.f.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.e)
    {
      this.g.clearSslPreferences();
      return;
    }
    this.f.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "clearView");
      return;
    }
    this.f.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.q.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.q.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)com.tencent.smtt.utils.q.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.e)
    {
      this.g.computeScroll();
      return;
    }
    this.f.computeScroll();
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.q.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.q.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)com.tencent.smtt.utils.q.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.q.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.e) {
      return WebBackForwardList.a(this.f.copyBackForwardList());
    }
    return WebBackForwardList.a(this.g.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.e) {}
    for (;;)
    {
      try
      {
        localObject = this.f.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString) {}
      if (Build.VERSION.SDK_INT >= 21) {
        return com.tencent.smtt.utils.q.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    return null;
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
  }
  
  public void destroy()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new bo(this, "WebviewDestroy").start();
        if (this.e)
        {
          this.f.destroy();
          return;
        }
        this.g.destroy();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      tbsWebviewDestroy(true);
      return;
    }
    tbsWebviewDestroy(true);
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      return;
    }
    this.f.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.e) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = com.tencent.smtt.utils.q.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (Exception paramString) {}
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.e)
    {
      paramString = com.tencent.smtt.utils.q.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.f.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        com.tencent.smtt.utils.q.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.e) {
      return (View)com.tencent.smtt.utils.q.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.f.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      return;
    }
    this.f.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "freeMemory");
      return;
    }
    this.f.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.e) {
      return this.g.getCertificate();
    }
    return this.f.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.e) {
      return this.g.getContentHeight();
    }
    return this.f.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.q.a(this.g, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.e) {
      return this.g.getFavicon();
    }
    return this.f.getFavicon();
  }
  
  public WebView.HitTestResult getHitTestResult()
  {
    if (!this.e) {
      return new WebView.HitTestResult(this.g.getHitTestResult());
    }
    return new WebView.HitTestResult(this.f.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.e) {
      return this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.e) {
      return this.g.getOriginalUrl();
    }
    return this.f.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.e) {
      return this.g.getProgress();
    }
    return this.f.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = com.tencent.smtt.utils.q.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          return false;
        }
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = com.tencent.smtt.utils.q.a(this.g, "getRendererRequestedPriority");
        if (localObject == null) {
          return 0;
        }
        int i1 = ((Integer)localObject).intValue();
        return i1;
      }
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.q.a(this.g, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.f.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.h != null) {
      return this.h;
    }
    if (this.e)
    {
      localWebSettings = new WebSettings(this.f.getSettings());
      this.h = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.g.getSettings());
    this.h = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    if (!this.e) {
      return this.g.getTitle();
    }
    return this.f.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.e) {
      return this.g.getUrl();
    }
    return this.f.getUrl();
  }
  
  public View getView()
  {
    if (!this.e) {
      return this.g;
    }
    return this.f.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.q.a(this.g, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.r;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.e) {
      return this.f.getView().getScrollX();
    }
    return this.g.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.e) {
      return this.f.getView().getScrollY();
    }
    return this.g.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.q;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getHitTestResult();
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.e) {
      return (View)com.tencent.smtt.utils.q.a(this.g, "getZoomControls");
    }
    return this.f.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.e)
    {
      this.g.goBack();
      return;
    }
    this.f.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      return;
    }
    this.f.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.e)
    {
      this.g.goForward();
      return;
    }
    this.f.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      return;
    }
    this.f.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return z;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.q.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {
      return;
    }
    if (!this.e)
    {
      this.g.loadUrl(paramString);
      return;
    }
    this.f.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((this.e) && (this.l != null) && (!this.m)) {
      this.l.a("load_url_gap", (byte)2);
    }
    if ((paramString == null) || (showDebugView(paramString))) {}
    do
    {
      return;
      if (this.e) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.g.loadUrl(paramString, paramMap);
    return;
    this.f.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new bt(this, "onDetachedFromWindow").start();
        return;
      }
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      a();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.B != null)
    {
      if (!this.B.onLongClick(paramView)) {
        return a(paramView);
      }
      return true;
    }
    return a(paramView);
  }
  
  public void onPause()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "onPause");
      return;
    }
    this.f.onPause();
  }
  
  public void onResume()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "onResume");
      return;
    }
    this.f.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (c(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (s == null) {
      s = this.i.getApplicationInfo().packageName;
    }
    if ((s != null) && ((s.equals("com.tencent.mm")) || (s.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
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
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, i());
      this.a = 0;
      this.k = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.e) {
      return this.g.overlayHorizontalScrollbar();
    }
    return this.f.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.e) {
      return this.f.overlayVerticalScrollbar();
    }
    return this.g.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageDown(paramBoolean);
    }
    return this.f.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageUp(paramBoolean);
    }
    return this.f.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.e)
    {
      this.g.pauseTimers();
      return;
    }
    this.f.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.e)
    {
      this.g.reload();
      return;
    }
    this.f.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.q.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      return;
    }
    this.f.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.e)
    {
      this.g.removeView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.q.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public void reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    TbsLog.i("sdkreport", "reportInitPerformance initType is " + paramLong1 + " isX5Core is " + this.e + " isPerformanceDataRecorded" + this.m);
    if ((this.e) && (this.l != null) && (!this.m))
    {
      this.l.a("init_type", paramLong1);
      this.l.a("time_oncreate", paramLong2);
      this.l.a("webview_type", paramInt);
      this.l.a("time_webaccelerator", paramLong3);
      if (this.l.a(this.f.hashCode(), getUrl())) {
        this.m = true;
      }
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
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
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      return;
    }
    this.f.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.q.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.restoreState(paramBundle));
    }
    return WebBackForwardList.a(this.f.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.e)
    {
      this.g.resumeTimers();
      return;
    }
    this.f.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.q.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.saveState(paramBundle));
    }
    return WebBackForwardList.a(this.f.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.q.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.q.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    if (!this.e)
    {
      this.g.setDownloadListener(new bq(this, paramDownloadListener));
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setFindListener(new bp(this, paramFindListener));
      }
      return;
    }
    this.f.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      return;
    }
    this.f.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.q.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.g.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.f.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.A == null)
      {
        Object localObject2 = com.tencent.smtt.utils.q.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.A = ((Field)localObject2).get(localObject1);
      }
      this.B = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(WebView.PictureListener paramPictureListener)
  {
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        return;
      }
      this.g.setPictureListener(new br(this, paramPictureListener));
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      return;
    }
    this.f.setPictureListener(new bs(this, paramPictureListener));
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        com.tencent.smtt.utils.q.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getView() == null) {
      return;
    }
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
        this.r = paramWebChromeClient;
        return;
        localObject = new q(bv.a().a(true).i(), this, paramWebChromeClient);
      }
    }
    WebView.b localb = this.g;
    if (paramWebChromeClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebChromeClient(this, paramWebChromeClient))
    {
      localb.setWebChromeClient((android.webkit.WebChromeClient)localObject);
      break;
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.q = paramWebViewClient;
        return;
        localObject = new v(bv.a().a(true).j(), this, paramWebViewClient);
      }
    }
    WebView.b localb = this.g;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new ad(this, paramWebViewClient))
    {
      localb.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    boolean bool1;
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, al.a().getLooper());
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramString.startsWith("http://debugx5.qq.com"));
      bool1 = bool2;
    } while (this.e);
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
    return true;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.e)
    {
      this.g.stopLoading();
      return;
    }
    this.f.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.e)
    {
      this.g.a();
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.q.a(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.b(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.q.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.c(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.q.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.q.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.q.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.a(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.q.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = com.tencent.smtt.utils.q.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == z) {
      return;
    }
    z = paramBoolean;
    if (paramBoolean)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!z)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
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
      com.tencent.smtt.sdk.a.b.a(this.i, (String)localObject4, (String)???, (String)localObject1, this.a, this.e, i());
      this.a = 0;
      this.k = false;
    }
    if (!this.e) {}
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
      label380:
      break label380;
    }
    if (paramBoolean) {
      this.g.destroy();
    }
    for (;;)
    {
      try
      {
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
        continue;
      }
      synchronized ((List)???)
      {
        ((List)???).remove(localObject1);
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
        return;
      }
      if (paramBoolean) {
        this.f.destroy();
      }
    }
  }
  
  public boolean zoomIn()
  {
    if (!this.e) {
      return this.g.zoomIn();
    }
    return this.f.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.e) {
      return this.g.zoomOut();
    }
    return this.f.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */