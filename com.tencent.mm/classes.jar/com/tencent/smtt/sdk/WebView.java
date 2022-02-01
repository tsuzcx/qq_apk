package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
  private static com.tencent.smtt.utils.p o;
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
  private b g;
  private WebSettings h = null;
  private Context i = null;
  private boolean k = false;
  private p l = null;
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
  
  /* Error */
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 156	android/widget/FrameLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: ldc 157
    //   9: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_0
    //   13: ldc 159
    //   15: putfield 161	com/tencent/smtt/sdk/WebView:b	Ljava/lang/String;
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 165	com/tencent/smtt/sdk/WebView:h	Lcom/tencent/smtt/sdk/WebSettings;
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 171	com/tencent/smtt/sdk/WebView:k	Z
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 175	com/tencent/smtt/sdk/WebView:m	Z
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 177	com/tencent/smtt/sdk/WebView:q	Lcom/tencent/smtt/sdk/WebViewClient;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 179	com/tencent/smtt/sdk/WebView:r	Lcom/tencent/smtt/sdk/WebChromeClient;
    //   63: aload_0
    //   64: iconst_1
    //   65: putfield 181	com/tencent/smtt/sdk/WebView:t	I
    //   68: aload_0
    //   69: iconst_2
    //   70: putfield 183	com/tencent/smtt/sdk/WebView:u	I
    //   73: aload_0
    //   74: iconst_3
    //   75: putfield 185	com/tencent/smtt/sdk/WebView:v	I
    //   78: aload_0
    //   79: ldc 187
    //   81: putfield 189	com/tencent/smtt/sdk/WebView:w	Ljava/lang/String;
    //   84: aload_0
    //   85: ldc 191
    //   87: putfield 193	com/tencent/smtt/sdk/WebView:x	Ljava/lang/String;
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 195	com/tencent/smtt/sdk/WebView:A	Ljava/lang/Object;
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield 197	com/tencent/smtt/sdk/WebView:B	Landroid/view/View$OnLongClickListener;
    //   100: iconst_1
    //   101: putstatic 125	com/tencent/smtt/sdk/WebView:mWebViewCreated	Z
    //   104: aload_0
    //   105: new 199	com/tencent/smtt/sdk/p
    //   108: dup
    //   109: invokespecial 200	com/tencent/smtt/sdk/p:<init>	()V
    //   112: putfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   115: aload_0
    //   116: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   119: ldc 202
    //   121: iconst_1
    //   122: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   125: invokestatic 211	com/tencent/smtt/sdk/QbSdk:getIsSysWebViewForcedByOuter	()Z
    //   128: ifeq +193 -> 321
    //   131: aload_1
    //   132: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   135: ifeq +186 -> 321
    //   138: aload_0
    //   139: aload_1
    //   140: putfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   148: aload_0
    //   149: iconst_0
    //   150: putfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   153: aload_1
    //   154: ldc 221
    //   156: invokestatic 224	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   159: aload_0
    //   160: new 36	com/tencent/smtt/sdk/WebView$b
    //   163: dup
    //   164: aload_0
    //   165: aload_1
    //   166: aload_2
    //   167: invokespecial 227	com/tencent/smtt/sdk/WebView$b:<init>	(Lcom/tencent/smtt/sdk/WebView;Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   170: putfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   173: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   176: aload_1
    //   177: iconst_1
    //   178: iconst_0
    //   179: invokevirtual 238	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   182: aload_0
    //   183: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   186: invokestatic 244	com/tencent/smtt/sdk/CookieSyncManager:createInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   189: invokevirtual 247	com/tencent/smtt/sdk/CookieSyncManager:startSync	()V
    //   192: ldc 249
    //   194: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   197: ldc_w 257
    //   200: iconst_0
    //   201: anewarray 251	java/lang/Class
    //   204: invokevirtual 261	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   207: astore_2
    //   208: aload_2
    //   209: iconst_1
    //   210: invokevirtual 267	java/lang/reflect/Method:setAccessible	(Z)V
    //   213: aload_2
    //   214: aconst_null
    //   215: iconst_0
    //   216: anewarray 269	java/lang/Object
    //   219: invokevirtual 273	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   222: checkcast 275	android/os/Handler
    //   225: invokevirtual 279	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   228: invokevirtual 285	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   231: new 287	com/tencent/smtt/sdk/h
    //   234: dup
    //   235: invokespecial 288	com/tencent/smtt/sdk/h:<init>	()V
    //   238: invokevirtual 294	java/lang/Thread:setUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   241: iconst_1
    //   242: putstatic 133	com/tencent/smtt/sdk/WebView:mSysWebviewCreated	Z
    //   245: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   248: invokevirtual 296	com/tencent/smtt/sdk/CookieManager:a	()V
    //   251: aload_0
    //   252: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   255: iconst_1
    //   256: invokevirtual 301	android/webkit/WebView:setFocusableInTouchMode	(Z)V
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   264: new 303	android/widget/FrameLayout$LayoutParams
    //   267: dup
    //   268: iconst_m1
    //   269: iconst_m1
    //   270: invokespecial 306	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   273: invokevirtual 310	com/tencent/smtt/sdk/WebView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   276: ldc 159
    //   278: ldc_w 312
    //   281: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: ldc 159
    //   286: ldc_w 319
    //   289: iconst_1
    //   290: invokestatic 322	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   293: invokestatic 327	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   296: aload_1
    //   297: sipush 402
    //   300: new 329	java/lang/Throwable
    //   303: dup
    //   304: invokespecial 330	java/lang/Throwable:<init>	()V
    //   307: invokevirtual 334	com/tencent/smtt/sdk/TbsCoreLoadStat:setLoadErrorCode	(Landroid/content/Context;ILjava/lang/Throwable;)V
    //   310: aload_1
    //   311: aload_0
    //   312: invokestatic 339	com/tencent/smtt/sdk/e:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/WebView;)V
    //   315: ldc 157
    //   317: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: return
    //   321: aload_1
    //   322: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   325: ifeq +55 -> 380
    //   328: iconst_1
    //   329: invokestatic 342	com/tencent/smtt/utils/TbsLog:setWriteLogJIT	(Z)V
    //   332: aload_0
    //   333: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   336: ldc_w 344
    //   339: iconst_1
    //   340: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   343: aload_1
    //   344: invokestatic 347	com/tencent/smtt/utils/TbsLog:initIfNeed	(Landroid/content/Context;)V
    //   347: aload_0
    //   348: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   351: ldc_w 344
    //   354: iconst_2
    //   355: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   358: aload_1
    //   359: ifnonnull +28 -> 387
    //   362: new 349	java/lang/IllegalArgumentException
    //   365: dup
    //   366: ldc_w 351
    //   369: invokespecial 354	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   372: astore_1
    //   373: ldc 157
    //   375: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   378: aload_1
    //   379: athrow
    //   380: iconst_0
    //   381: invokestatic 342	com/tencent/smtt/utils/TbsLog:setWriteLogJIT	(Z)V
    //   384: goto -52 -> 332
    //   387: getstatic 127	com/tencent/smtt/sdk/WebView:o	Lcom/tencent/smtt/utils/p;
    //   390: ifnonnull +10 -> 400
    //   393: aload_1
    //   394: invokestatic 359	com/tencent/smtt/utils/p:a	(Landroid/content/Context;)Lcom/tencent/smtt/utils/p;
    //   397: putstatic 127	com/tencent/smtt/sdk/WebView:o	Lcom/tencent/smtt/utils/p;
    //   400: getstatic 127	com/tencent/smtt/sdk/WebView:o	Lcom/tencent/smtt/utils/p;
    //   403: getfield 361	com/tencent/smtt/utils/p:a	Z
    //   406: ifeq +19 -> 425
    //   409: ldc 159
    //   411: ldc_w 363
    //   414: iconst_1
    //   415: invokestatic 322	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   418: aload_1
    //   419: ldc_w 365
    //   422: invokestatic 224	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   425: aload_0
    //   426: aload_1
    //   427: aload_0
    //   428: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   431: invokespecial 368	com/tencent/smtt/sdk/WebView:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/p;)V
    //   434: aload_0
    //   435: aload_1
    //   436: putfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   439: aload_1
    //   440: ifnull +10 -> 450
    //   443: aload_1
    //   444: invokevirtual 374	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   447: putstatic 121	com/tencent/smtt/sdk/WebView:j	Landroid/content/Context;
    //   450: aload_0
    //   451: getfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   454: ifeq +586 -> 1040
    //   457: getstatic 375	com/tencent/smtt/sdk/QbSdk:a	Z
    //   460: ifne +580 -> 1040
    //   463: aload_0
    //   464: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   467: ldc_w 377
    //   470: iconst_1
    //   471: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   474: aload_0
    //   475: invokestatic 383	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   478: aload_1
    //   479: iconst_0
    //   480: invokeinterface 389 3 0
    //   485: putfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   488: aload_0
    //   489: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   492: ldc_w 377
    //   495: iconst_2
    //   496: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   499: aload_0
    //   500: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   503: ifnull +15 -> 518
    //   506: aload_0
    //   507: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   510: invokeinterface 395 1 0
    //   515: ifnonnull +177 -> 692
    //   518: ldc 159
    //   520: ldc_w 397
    //   523: iconst_1
    //   524: invokestatic 322	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   527: aload_0
    //   528: aconst_null
    //   529: putfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   532: aload_0
    //   533: iconst_0
    //   534: putfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   537: aload_1
    //   538: ldc 221
    //   540: invokestatic 224	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   543: aload_0
    //   544: aload_1
    //   545: aload_0
    //   546: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   549: invokespecial 368	com/tencent/smtt/sdk/WebView:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/p;)V
    //   552: aload_0
    //   553: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   556: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   559: ifeq +117 -> 676
    //   562: aload_0
    //   563: new 36	com/tencent/smtt/sdk/WebView$b
    //   566: dup
    //   567: aload_0
    //   568: aload_1
    //   569: aload_2
    //   570: invokespecial 227	com/tencent/smtt/sdk/WebView$b:<init>	(Lcom/tencent/smtt/sdk/WebView;Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   573: putfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   576: ldc 159
    //   578: ldc_w 399
    //   581: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   587: aload_1
    //   588: iconst_1
    //   589: iconst_0
    //   590: invokevirtual 238	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   593: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   596: invokevirtual 296	com/tencent/smtt/sdk/CookieManager:a	()V
    //   599: aload_0
    //   600: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   603: iconst_1
    //   604: invokevirtual 301	android/webkit/WebView:setFocusableInTouchMode	(Z)V
    //   607: aload_0
    //   608: aload_0
    //   609: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   612: new 303	android/widget/FrameLayout$LayoutParams
    //   615: dup
    //   616: iconst_m1
    //   617: iconst_m1
    //   618: invokespecial 306	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   621: invokevirtual 310	com/tencent/smtt/sdk/WebView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   624: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   627: bipush 11
    //   629: if_icmplt +24 -> 653
    //   632: aload_0
    //   633: ldc_w 406
    //   636: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   639: aload_0
    //   640: ldc_w 411
    //   643: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   646: aload_0
    //   647: ldc_w 413
    //   650: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   653: aload_0
    //   654: aload_1
    //   655: invokespecial 415	com/tencent/smtt/sdk/WebView:b	(Landroid/content/Context;)V
    //   658: invokestatic 418	com/tencent/smtt/utils/TbsLog:writeLogToDisk	()V
    //   661: aload_1
    //   662: invokestatic 422	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;)V
    //   665: aload_1
    //   666: aload_0
    //   667: invokestatic 339	com/tencent/smtt/sdk/e:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/WebView;)V
    //   670: ldc 157
    //   672: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   675: return
    //   676: aload_0
    //   677: new 36	com/tencent/smtt/sdk/WebView$b
    //   680: dup
    //   681: aload_0
    //   682: aload_1
    //   683: invokespecial 425	com/tencent/smtt/sdk/WebView$b:<init>	(Lcom/tencent/smtt/sdk/WebView;Landroid/content/Context;)V
    //   686: putfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   689: goto -113 -> 576
    //   692: ldc 159
    //   694: ldc_w 427
    //   697: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload_0
    //   701: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   704: invokeinterface 395 1 0
    //   709: iconst_1
    //   710: invokevirtual 430	android/view/View:setFocusableInTouchMode	(Z)V
    //   713: aload_0
    //   714: aload_2
    //   715: invokespecial 433	com/tencent/smtt/sdk/WebView:a	(Landroid/util/AttributeSet;)V
    //   718: aload_0
    //   719: aload_0
    //   720: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   723: invokeinterface 395 1 0
    //   728: new 303	android/widget/FrameLayout$LayoutParams
    //   731: dup
    //   732: iconst_m1
    //   733: iconst_m1
    //   734: invokespecial 306	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   737: invokevirtual 310	com/tencent/smtt/sdk/WebView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   740: invokestatic 437	com/tencent/smtt/sdk/QbSdk:getOAIDByApp	()Ljava/lang/String;
    //   743: invokestatic 443	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   746: ifne +61 -> 807
    //   749: invokestatic 448	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   752: astore_2
    //   753: aload_2
    //   754: ifnull +53 -> 807
    //   757: aload_2
    //   758: invokevirtual 450	com/tencent/smtt/sdk/x:b	()Z
    //   761: ifeq +46 -> 807
    //   764: aload_2
    //   765: invokevirtual 453	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   768: invokevirtual 458	com/tencent/smtt/sdk/y:a	()Lcom/tencent/smtt/export/external/DexLoader;
    //   771: astore_2
    //   772: invokestatic 437	com/tencent/smtt/sdk/QbSdk:getOAIDByApp	()Ljava/lang/String;
    //   775: astore 4
    //   777: aload_2
    //   778: ldc_w 460
    //   781: ldc_w 462
    //   784: iconst_1
    //   785: anewarray 251	java/lang/Class
    //   788: dup
    //   789: iconst_0
    //   790: ldc_w 464
    //   793: aastore
    //   794: iconst_1
    //   795: anewarray 269	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload 4
    //   802: aastore
    //   803: invokevirtual 470	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   806: pop
    //   807: aload_0
    //   808: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   811: new 472	com/tencent/smtt/sdk/b
    //   814: dup
    //   815: aload_0
    //   816: aconst_null
    //   817: aload_0
    //   818: getfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   821: invokespecial 475	com/tencent/smtt/sdk/b:<init>	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/sdk/DownloadListener;Z)V
    //   824: invokeinterface 479 2 0
    //   829: aload_0
    //   830: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   833: invokeinterface 483 1 0
    //   838: new 8	com/tencent/smtt/sdk/WebView$1
    //   841: dup
    //   842: aload_0
    //   843: invokestatic 383	com/tencent/smtt/sdk/TbsOneGreyInfoHelper:getCoreEntry	()Lcom/tencent/smtt/export/external/interfaces/IX5CoreEntry;
    //   846: invokeinterface 487 1 0
    //   851: invokeinterface 493 1 0
    //   856: invokespecial 496	com/tencent/smtt/sdk/WebView$1:<init>	(Lcom/tencent/smtt/sdk/WebView;Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewClientExtension;)V
    //   859: invokeinterface 502 2 0
    //   864: getstatic 404	android/os/Build$VERSION:SDK_INT	I
    //   867: bipush 11
    //   869: if_icmplt +24 -> 893
    //   872: aload_0
    //   873: ldc_w 406
    //   876: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   879: aload_0
    //   880: ldc_w 411
    //   883: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   886: aload_0
    //   887: ldc_w 413
    //   890: invokevirtual 409	com/tencent/smtt/sdk/WebView:removeJavascriptInterface	(Ljava/lang/String;)V
    //   893: aload_0
    //   894: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   897: ifnull +64 -> 961
    //   900: invokestatic 418	com/tencent/smtt/utils/TbsLog:writeLogToDisk	()V
    //   903: aload_1
    //   904: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   907: ifne +54 -> 961
    //   910: aload_1
    //   911: invokestatic 507	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   914: getfield 511	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   917: ldc_w 513
    //   920: iconst_0
    //   921: invokeinterface 519 3 0
    //   926: istore_3
    //   927: iload_3
    //   928: ifle +225 -> 1153
    //   931: iload_3
    //   932: invokestatic 522	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   935: aload_1
    //   936: invokevirtual 525	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   939: if_icmpeq +214 -> 1153
    //   942: iload_3
    //   943: invokestatic 522	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   946: aload_1
    //   947: invokevirtual 527	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   950: if_icmpne +203 -> 1153
    //   953: invokestatic 522	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   956: aload_1
    //   957: invokevirtual 529	com/tencent/smtt/sdk/q:o	(Landroid/content/Context;)Z
    //   960: pop
    //   961: aload_1
    //   962: aload_0
    //   963: invokestatic 339	com/tencent/smtt/sdk/e:a	(Landroid/content/Context;Lcom/tencent/smtt/sdk/WebView;)V
    //   966: new 531	java/lang/StringBuilder
    //   969: dup
    //   970: ldc_w 533
    //   973: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   976: astore_1
    //   977: aload_0
    //   978: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   981: ifnull +229 -> 1210
    //   984: iconst_1
    //   985: istore 5
    //   987: aload_1
    //   988: iload 5
    //   990: invokevirtual 538	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   993: ldc_w 540
    //   996: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: invokestatic 546	com/tencent/smtt/sdk/QbSdk:getTbsCoreVersionString	()Ljava/lang/String;
    //   1002: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload_0
    //   1007: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   1010: ifnull +24 -> 1034
    //   1013: aload_0
    //   1014: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   1017: ldc_w 548
    //   1020: iconst_1
    //   1021: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   1024: aload_0
    //   1025: getfield 173	com/tencent/smtt/sdk/WebView:l	Lcom/tencent/smtt/sdk/p;
    //   1028: ldc 202
    //   1030: iconst_2
    //   1031: invokevirtual 205	com/tencent/smtt/sdk/p:a	(Ljava/lang/String;B)V
    //   1034: ldc 157
    //   1036: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1039: return
    //   1040: aload_0
    //   1041: aconst_null
    //   1042: putfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   1045: aload_0
    //   1046: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   1049: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1052: ifeq +85 -> 1137
    //   1055: aload_0
    //   1056: new 36	com/tencent/smtt/sdk/WebView$b
    //   1059: dup
    //   1060: aload_0
    //   1061: aload_1
    //   1062: aload_2
    //   1063: invokespecial 227	com/tencent/smtt/sdk/WebView$b:<init>	(Lcom/tencent/smtt/sdk/WebView;Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   1066: putfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   1069: ldc 159
    //   1071: ldc_w 550
    //   1074: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1077: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   1080: aload_1
    //   1081: iconst_1
    //   1082: iconst_0
    //   1083: invokevirtual 238	com/tencent/smtt/sdk/CookieManager:a	(Landroid/content/Context;ZZ)V
    //   1086: invokestatic 235	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   1089: invokevirtual 296	com/tencent/smtt/sdk/CookieManager:a	()V
    //   1092: aload_0
    //   1093: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   1096: iconst_1
    //   1097: invokevirtual 301	android/webkit/WebView:setFocusableInTouchMode	(Z)V
    //   1100: aload_0
    //   1101: aload_0
    //   1102: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   1105: new 303	android/widget/FrameLayout$LayoutParams
    //   1108: dup
    //   1109: iconst_m1
    //   1110: iconst_m1
    //   1111: invokespecial 306	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   1114: invokevirtual 310	com/tencent/smtt/sdk/WebView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1117: aload_0
    //   1118: aconst_null
    //   1119: invokevirtual 553	com/tencent/smtt/sdk/WebView:setDownloadListener	(Lcom/tencent/smtt/sdk/DownloadListener;)V
    //   1122: aload_0
    //   1123: aload_1
    //   1124: invokespecial 415	com/tencent/smtt/sdk/WebView:b	(Landroid/content/Context;)V
    //   1127: invokestatic 418	com/tencent/smtt/utils/TbsLog:writeLogToDisk	()V
    //   1130: aload_1
    //   1131: invokestatic 422	com/tencent/smtt/sdk/q:a	(Landroid/content/Context;)V
    //   1134: goto -270 -> 864
    //   1137: aload_0
    //   1138: new 36	com/tencent/smtt/sdk/WebView$b
    //   1141: dup
    //   1142: aload_0
    //   1143: aload_1
    //   1144: invokespecial 425	com/tencent/smtt/sdk/WebView$b:<init>	(Lcom/tencent/smtt/sdk/WebView;Landroid/content/Context;)V
    //   1147: putfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   1150: goto -81 -> 1069
    //   1153: ldc 159
    //   1155: new 531	java/lang/StringBuilder
    //   1158: dup
    //   1159: ldc_w 555
    //   1162: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1165: iload_3
    //   1166: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1169: ldc_w 560
    //   1172: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: invokestatic 522	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1178: aload_1
    //   1179: invokevirtual 525	com/tencent/smtt/sdk/q:i	(Landroid/content/Context;)I
    //   1182: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1185: ldc_w 562
    //   1188: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: invokestatic 522	com/tencent/smtt/sdk/q:a	()Lcom/tencent/smtt/sdk/q;
    //   1194: aload_1
    //   1195: invokevirtual 527	com/tencent/smtt/sdk/q:j	(Landroid/content/Context;)I
    //   1198: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1207: goto -246 -> 961
    //   1210: iconst_0
    //   1211: istore 5
    //   1213: goto -226 -> 987
    //   1216: astore_2
    //   1217: goto -324 -> 893
    //   1220: astore_2
    //   1221: goto -414 -> 807
    //   1224: astore_2
    //   1225: goto -418 -> 807
    //   1228: astore_2
    //   1229: goto -576 -> 653
    //   1232: astore_2
    //   1233: goto -988 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1236	0	this	WebView
    //   0	1236	1	paramContext	Context
    //   0	1236	2	paramAttributeSet	AttributeSet
    //   0	1236	3	paramInt	int
    //   0	1236	4	paramMap	Map<String, Object>
    //   0	1236	5	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   864	893	1216	finally
    //   740	753	1220	finally
    //   757	772	1220	finally
    //   772	807	1224	finally
    //   624	653	1228	finally
    //   192	245	1232	java/lang/Exception
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  public WebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  private void a(Context paramContext, p paramp)
  {
    AppMethodBeat.i(219602);
    if ((QbSdk.h) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    if (paramp != null) {
      paramp.a("x5_core_engine_init_sync", (byte)1);
    }
    x localx = x.a();
    localx.a(paramContext, paramp);
    this.e = localx.b();
    AppMethodBeat.o(219602);
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
    paramView = com.tencent.smtt.utils.k.a(this.A, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
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
            return;
          }
          return;
        }
        finally
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
      if (i1 >= 0) {
        return true;
      }
    }
    finally
    {
      AppMethodBeat.o(54165);
    }
    return false;
  }
  
  /* Error */
  private int d(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 671
    //   3: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iconst_1
    //   8: ldc_w 673
    //   11: invokestatic 678	com/tencent/smtt/utils/f:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnull +24 -> 42
    //   21: aload_1
    //   22: aload 6
    //   24: invokestatic 681	com/tencent/smtt/utils/f:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   27: astore 7
    //   29: aload 7
    //   31: ifnonnull +19 -> 50
    //   34: ldc_w 671
    //   37: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_m1
    //   41: ireturn
    //   42: ldc_w 671
    //   45: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_m1
    //   49: ireturn
    //   50: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   53: invokeinterface 686 1 0
    //   58: ifeq +440 -> 498
    //   61: aload_1
    //   62: invokestatic 690	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   65: astore_1
    //   66: new 692	java/io/File
    //   69: dup
    //   70: new 531	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 693	java/lang/StringBuilder:<init>	()V
    //   77: aload_1
    //   78: invokevirtual 696	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: getstatic 699	java/io/File:separator	Ljava/lang/String;
    //   84: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 701
    //   90: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: ldc_w 703
    //   99: invokespecial 705	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 708	java/io/File:exists	()Z
    //   107: istore_3
    //   108: iload_3
    //   109: ifne +26 -> 135
    //   112: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   115: invokeinterface 711 1 0
    //   120: aload 7
    //   122: aload 6
    //   124: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   127: ldc_w 671
    //   130: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_m1
    //   134: ireturn
    //   135: new 716	java/util/Properties
    //   138: dup
    //   139: invokespecial 717	java/util/Properties:<init>	()V
    //   142: astore 5
    //   144: new 719	java/io/FileInputStream
    //   147: dup
    //   148: aload_1
    //   149: invokespecial 722	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: astore 4
    //   154: aload 4
    //   156: astore_1
    //   157: aload 5
    //   159: aload 4
    //   161: invokevirtual 726	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   164: aload 4
    //   166: astore_1
    //   167: aload 4
    //   169: invokevirtual 729	java/io/FileInputStream:close	()V
    //   172: aload 4
    //   174: astore_1
    //   175: aload 5
    //   177: ldc_w 731
    //   180: invokevirtual 735	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 5
    //   185: aload 5
    //   187: ifnonnull +61 -> 248
    //   190: aload 4
    //   192: invokevirtual 729	java/io/FileInputStream:close	()V
    //   195: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   198: invokeinterface 711 1 0
    //   203: aload 7
    //   205: aload 6
    //   207: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   210: ldc_w 671
    //   213: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: iconst_m1
    //   217: ireturn
    //   218: astore_1
    //   219: ldc_w 737
    //   222: new 531	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 739
    //   229: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload_1
    //   233: invokevirtual 740	java/io/IOException:toString	()Ljava/lang/String;
    //   236: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 742	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto -50 -> 195
    //   248: aload 4
    //   250: astore_1
    //   251: aload 5
    //   253: invokestatic 747	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   256: istore_2
    //   257: aload 4
    //   259: astore_1
    //   260: ldc_w 737
    //   263: ldc_w 749
    //   266: iload_2
    //   267: invokestatic 752	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   270: invokevirtual 755	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 757	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 4
    //   278: invokevirtual 729	java/io/FileInputStream:close	()V
    //   281: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   284: invokeinterface 711 1 0
    //   289: aload 7
    //   291: aload 6
    //   293: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   296: ldc_w 671
    //   299: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: iload_2
    //   303: ireturn
    //   304: astore_1
    //   305: ldc_w 737
    //   308: new 531	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 739
    //   315: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload_1
    //   319: invokevirtual 740	java/io/IOException:toString	()Ljava/lang/String;
    //   322: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 742	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -50 -> 281
    //   334: astore 5
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: astore_1
    //   342: ldc_w 737
    //   345: new 531	java/lang/StringBuilder
    //   348: dup
    //   349: ldc_w 759
    //   352: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   355: aload 5
    //   357: invokevirtual 760	java/lang/Exception:toString	()Ljava/lang/String;
    //   360: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 742	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 4
    //   371: ifnull +8 -> 379
    //   374: aload 4
    //   376: invokevirtual 729	java/io/FileInputStream:close	()V
    //   379: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   382: invokeinterface 711 1 0
    //   387: aload 7
    //   389: aload 6
    //   391: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   394: ldc_w 671
    //   397: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: iconst_m1
    //   401: ireturn
    //   402: astore_1
    //   403: ldc_w 737
    //   406: new 531	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 739
    //   413: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: invokevirtual 740	java/io/IOException:toString	()Ljava/lang/String;
    //   420: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 742	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto -50 -> 379
    //   432: astore 4
    //   434: aconst_null
    //   435: astore_1
    //   436: aload_1
    //   437: ifnull +7 -> 444
    //   440: aload_1
    //   441: invokevirtual 729	java/io/FileInputStream:close	()V
    //   444: getstatic 117	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   447: invokeinterface 711 1 0
    //   452: aload 7
    //   454: aload 6
    //   456: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   459: ldc_w 671
    //   462: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   465: aload 4
    //   467: athrow
    //   468: astore_1
    //   469: ldc_w 737
    //   472: new 531	java/lang/StringBuilder
    //   475: dup
    //   476: ldc_w 739
    //   479: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload_1
    //   483: invokevirtual 740	java/io/IOException:toString	()Ljava/lang/String;
    //   486: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 742	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto -51 -> 444
    //   498: aload 7
    //   500: aload 6
    //   502: invokestatic 714	com/tencent/smtt/utils/f:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   505: ldc_w 671
    //   508: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        g localg = g.a(true);
        if (g.b)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
          AppMethodBeat.o(54930);
          return;
        }
        n localn = n.a(WebView.h());
        int i = localn.c();
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(i)));
        if (i == 2)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
          localg.a(String.valueOf(localn.b()));
          localg.b(true);
          AppMethodBeat.o(54930);
          return;
        }
        int j = localn.b("copy_status");
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(j)));
        if (j == 1)
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
          localg.a(String.valueOf(localn.c("copy_core_ver")));
          localg.b(true);
          AppMethodBeat.o(54930);
          return;
        }
        if ((!x.a().b()) && ((i == 3) || (j == 3)))
        {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
          localg.a(String.valueOf(g.d()));
          localg.b(true);
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
    finally
    {
      TbsLog.e("webview", "updateRebootStatus excpetion: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(54302);
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(54186);
    if (!x.a().b()) {
      com.tencent.smtt.utils.k.a("android.webkit.WebView", "disablePlatformNotifications");
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
    if (!x.a().b()) {
      com.tencent.smtt.utils.k.a("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(54185);
  }
  
  public static String findAddress(String paramString)
  {
    AppMethodBeat.i(54245);
    if (!x.a().b())
    {
      paramString = android.webkit.WebView.findAddress(paramString);
      AppMethodBeat.o(54245);
      return paramString;
    }
    AppMethodBeat.o(54245);
    return null;
  }
  
  /* Error */
  public static String getCrashExtraMessage(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 801
    //   5: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +13 -> 22
    //   12: ldc_w 801
    //   15: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: ldc_w 803
    //   21: areturn
    //   22: new 531	java/lang/StringBuilder
    //   25: dup
    //   26: ldc_w 805
    //   29: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokestatic 808	com/tencent/smtt/sdk/QbSdk:getTbsVersionForCrash	(Landroid/content/Context;)I
    //   36: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc_w 810
    //   42: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_3
    //   49: iload_2
    //   50: istore_1
    //   51: ldc_w 812
    //   54: aload_0
    //   55: invokevirtual 816	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   58: getfield 821	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   61: invokevirtual 825	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   64: ifeq +12 -> 76
    //   67: ldc_w 827
    //   70: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   73: pop
    //   74: iconst_1
    //   75: istore_1
    //   76: iload_1
    //   77: ifeq +32 -> 109
    //   80: new 531	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 693	java/lang/StringBuilder:<init>	()V
    //   87: aload_3
    //   88: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 829
    //   94: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_0
    //   101: ldc_w 801
    //   104: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: new 531	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 693	java/lang/StringBuilder:<init>	()V
    //   116: astore 4
    //   118: aload 4
    //   120: iconst_1
    //   121: invokestatic 834	com/tencent/smtt/sdk/g:a	(Z)Lcom/tencent/smtt/sdk/g;
    //   124: invokevirtual 836	com/tencent/smtt/sdk/g:e	()Ljava/lang/String;
    //   127: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 4
    //   133: ldc_w 838
    //   136: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_3
    //   143: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_0
    //   148: invokestatic 217	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   151: ifne +107 -> 258
    //   154: getstatic 842	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   157: ifnull +101 -> 258
    //   160: getstatic 842	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   163: ldc_w 844
    //   166: invokeinterface 849 2 0
    //   171: ifeq +87 -> 258
    //   174: getstatic 842	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   177: ldc_w 851
    //   180: invokeinterface 849 2 0
    //   185: ifeq +73 -> 258
    //   188: new 531	java/lang/StringBuilder
    //   191: dup
    //   192: ldc_w 853
    //   195: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: getstatic 842	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   201: ldc_w 844
    //   204: invokeinterface 857 2 0
    //   209: invokevirtual 696	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: ldc_w 859
    //   215: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 842	com/tencent/smtt/sdk/QbSdk:mSettings	Ljava/util/Map;
    //   221: ldc_w 851
    //   224: invokeinterface 857 2 0
    //   229: invokevirtual 696	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: ldc_w 861
    //   235: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_0
    //   242: aload 4
    //   244: ldc_w 838
    //   247: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 4
    //   253: aload_0
    //   254: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 4
    //   260: invokevirtual 864	java/lang/StringBuilder:length	()I
    //   263: sipush 8192
    //   266: if_icmple +26 -> 292
    //   269: aload 4
    //   271: aload 4
    //   273: invokevirtual 864	java/lang/StringBuilder:length	()I
    //   276: sipush 8192
    //   279: isub
    //   280: invokevirtual 867	java/lang/StringBuilder:substring	(I)Ljava/lang/String;
    //   283: astore_0
    //   284: ldc_w 801
    //   287: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_0
    //   291: areturn
    //   292: aload 4
    //   294: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: astore_0
    //   298: ldc_w 801
    //   301: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_0
    //   305: areturn
    //   306: astore 4
    //   308: iload_2
    //   309: istore_1
    //   310: goto -234 -> 76
    //   313: astore 4
    //   315: iload_2
    //   316: istore_1
    //   317: goto -241 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   50	267	1	i1	int
    //   1	315	2	i2	int
    //   48	95	3	str	String
    //   116	177	4	localStringBuilder	StringBuilder
    //   306	1	4	localObject	Object
    //   313	1	4	localClassNotFoundException	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   67	74	306	finally
    //   67	74	313	java/lang/ClassNotFoundException
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    AppMethodBeat.i(54225);
    if (!x.a().b())
    {
      if (Build.VERSION.SDK_INT < 26)
      {
        AppMethodBeat.o(54225);
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.k.a("android.webkit.WebView", "getCurrentWebViewPackage");
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
    //   3: ldc_w 876
    //   6: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 448	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   12: invokevirtual 450	com/tencent/smtt/sdk/x:b	()Z
    //   15: ifne +24 -> 39
    //   18: ldc_w 778
    //   21: ldc_w 877
    //   24: invokestatic 782	com/tencent/smtt/utils/k:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   27: astore_0
    //   28: ldc_w 876
    //   31: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: aconst_null
    //   40: astore_0
    //   41: ldc_w 876
    //   44: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    boolean bool = g.a(true).f();
    TbsLog.d("TbsNeedReboot", "WebView.getTbsNeedReboot--ret = ".concat(String.valueOf(bool)));
    AppMethodBeat.o(54301);
    return bool;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 44138;
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
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
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
      com.tencent.smtt.sdk.c.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onDetachedFromWindow();
      AppMethodBeat.o(54273);
      return;
    }
    finally
    {
      for (;;)
      {
        TbsLog.w("tbsOnDetachedFromWindow", "exception: ".concat(String.valueOf(localObject)));
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
      finally
      {
        TbsLog.d("writetbscorepvfile", "file.getAbsolutePath=" + paramContext.getAbsolutePath() + " Throwable=" + localObject2);
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
      Method localMethod = com.tencent.smtt.utils.k.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    finally
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
        Object localObject = com.tencent.smtt.utils.k.a(this.g, "canZoomIn");
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
        Object localObject = com.tencent.smtt.utils.k.a(this.g, "canZoomOut");
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
      localObject = com.tencent.smtt.utils.k.a(this.g, "capturePicture");
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
      com.tencent.smtt.utils.k.a(this.g, "clearView");
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
        localMethod = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54163);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
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
        localMethod = com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54159);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
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
        i1 = ((Integer)com.tencent.smtt.utils.k.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(54162);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeHorizontalScrollRange", new Class[0]);
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
        localMethod = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54161);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollExtent", new Class[0]);
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
        localMethod = com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        i1 = ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
        AppMethodBeat.o(54160);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollOffset", new Class[0]);
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
        i1 = ((Integer)com.tencent.smtt.utils.k.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
        AppMethodBeat.o(54164);
        return i1;
      }
      Method localMethod = com.tencent.smtt.utils.k.a(this.g, "computeVerticalScrollRange", new Class[0]);
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
      }
      finally
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
    paramString = com.tencent.smtt.utils.k.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
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
    finally
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
      com.tencent.smtt.utils.k.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
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
        localMethod = com.tencent.smtt.utils.k.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
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
      paramString = com.tencent.smtt.utils.k.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
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
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(54246);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        com.tencent.smtt.utils.k.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
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
      paramString = (View)com.tencent.smtt.utils.k.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(54269);
      return paramString;
    }
    paramString = this.f.findHierarchyView(paramString, paramInt);
    AppMethodBeat.o(54269);
    return paramString;
  }
  
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
      com.tencent.smtt.utils.k.a(this.g, "freeMemory");
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
      Object localObject = com.tencent.smtt.utils.k.a(this.g, "getContentWidth");
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
        Object localObject = com.tencent.smtt.utils.k.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
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
        Object localObject = com.tencent.smtt.utils.k.a(this.g, "getRendererRequestedPriority");
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
      Object localObject = com.tencent.smtt.utils.k.a(this.g, "getScale");
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
      Object localObject = com.tencent.smtt.utils.k.a(this.g, "getVisibleTitleHeight");
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
      localView = (View)com.tencent.smtt.utils.k.a(this.g, "getZoomControls");
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
        Object localObject = com.tencent.smtt.utils.k.a(this.g, "isPrivateBrowsingEnabled");
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
      return;
    }
    finally
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
      com.tencent.smtt.utils.k.a(this.g, "onPause");
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
      com.tencent.smtt.utils.k.a(this.g, "onResume");
      AppMethodBeat.o(54235);
      return;
    }
    this.f.onResume();
    AppMethodBeat.o(54235);
  }
  
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
      com.tencent.smtt.sdk.c.b.a(this.i, str3, str2, str1, this.a, this.e, i(), bool);
      this.a = 0;
      this.k = false;
      super.onVisibilityChanged(paramView, paramInt);
      AppMethodBeat.o(54275);
      return;
    }
    finally
    {
      for (;;)
      {
        TbsLog.w("onVisibilityChanged", "exception: ".concat(String.valueOf(localObject)));
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
      com.tencent.smtt.utils.k.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
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
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(54256);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.k.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
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
      Method localMethod = com.tencent.smtt.utils.k.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    finally
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
      paramBundle = com.tencent.smtt.utils.k.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
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
      com.tencent.smtt.utils.k.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
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
      paramBundle = com.tencent.smtt.utils.k.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
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
  
  public void saveWebArchive(String paramString)
  {
    AppMethodBeat.i(54199);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
        AppMethodBeat.o(54199);
      }
    }
    else {
      this.f.saveWebArchive(paramString);
    }
    AppMethodBeat.o(54199);
  }
  
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(54200);
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        com.tencent.smtt.utils.k.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
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
      return;
    }
    finally
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
      return;
    }
    finally
    {
      AppMethodBeat.o(54290);
    }
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(54252);
    if (!this.e)
    {
      this.g.setDownloadListener(new WebView.5(this, paramDownloadListener));
      AppMethodBeat.o(54252);
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
    AppMethodBeat.o(54252);
  }
  
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
      com.tencent.smtt.utils.k.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
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
        Object localObject2 = com.tencent.smtt.utils.k.a(localObject1, "getListenerInfo", new Class[0]);
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
    finally
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
        com.tencent.smtt.utils.k.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
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
        localObject = new j(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebChromeClient(), this, paramWebChromeClient);
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
        localObject = new k(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebViewClient(), this, paramWebViewClient);
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
  
  public boolean showDebugView(String paramString)
  {
    AppMethodBeat.i(54195);
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, o.a().getLooper());
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
      com.tencent.smtt.utils.k.a(localView, "super_computeScroll");
      return;
    }
    finally
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
      paramMotionEvent = com.tencent.smtt.utils.k.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    finally
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
      paramMotionEvent = com.tencent.smtt.utils.k.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    finally
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
      com.tencent.smtt.utils.k.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    finally
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
      com.tencent.smtt.utils.k.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    finally
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
      paramMotionEvent = com.tencent.smtt.utils.k.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    finally
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
    Object localObject1 = this.f.getView();
    try
    {
      localObject1 = com.tencent.smtt.utils.k.a(localObject1, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject1 != null) {}
    }
    finally
    {
      AppMethodBeat.o(54304);
      return false;
    }
    paramBoolean = ((Boolean)localObject2).booleanValue();
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
  
  /* Error */
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 2014
    //   3: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 171	com/tencent/smtt/sdk/WebView:k	Z
    //   10: ifne +244 -> 254
    //   13: aload_0
    //   14: getfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   17: ifeq +237 -> 254
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 171	com/tencent/smtt/sdk/WebView:k	Z
    //   25: ldc_w 803
    //   28: astore 8
    //   30: ldc_w 803
    //   33: astore 9
    //   35: ldc_w 803
    //   38: astore 10
    //   40: aload 8
    //   42: astore 7
    //   44: aload 9
    //   46: astore 6
    //   48: aload 10
    //   50: astore 5
    //   52: aload_0
    //   53: getfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   56: ifeq +66 -> 122
    //   59: aload_0
    //   60: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   63: invokeinterface 483 1 0
    //   68: invokeinterface 965 1 0
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
    //   94: ldc_w 967
    //   97: invokevirtual 972	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 7
    //   102: aload 11
    //   104: ldc_w 974
    //   107: invokevirtual 972	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 6
    //   112: aload 11
    //   114: ldc_w 976
    //   117: invokevirtual 972	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore 5
    //   122: ldc_w 978
    //   125: aload_0
    //   126: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   129: invokevirtual 816	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   132: getfield 821	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   135: invokevirtual 825	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +37 -> 175
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   146: invokespecial 980	com/tencent/smtt/sdk/WebView:d	(Landroid/content/Context;)I
    //   149: istore_3
    //   150: iload_3
    //   151: istore_2
    //   152: iload_3
    //   153: iconst_m1
    //   154: if_icmpne +8 -> 162
    //   157: aload_0
    //   158: getfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   161: istore_2
    //   162: aload_0
    //   163: iload_2
    //   164: putfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   172: invokespecial 982	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)V
    //   175: ldc_w 914
    //   178: new 531	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 2016
    //   185: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: getfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   192: invokevirtual 558	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 757	com/tencent/smtt/utils/TbsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   205: invokeinterface 483 1 0
    //   210: invokeinterface 987 1 0
    //   215: istore 4
    //   217: aload_0
    //   218: getfield 167	com/tencent/smtt/sdk/WebView:i	Landroid/content/Context;
    //   221: aload 7
    //   223: aload 6
    //   225: aload 5
    //   227: aload_0
    //   228: getfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   231: aload_0
    //   232: getfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   235: aload_0
    //   236: invokespecial 989	com/tencent/smtt/sdk/WebView:i	()J
    //   239: iload 4
    //   241: invokestatic 994	com/tencent/smtt/sdk/c/b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZJZ)V
    //   244: aload_0
    //   245: iconst_0
    //   246: putfield 169	com/tencent/smtt/sdk/WebView:a	I
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 171	com/tencent/smtt/sdk/WebView:k	Z
    //   254: aload_0
    //   255: getfield 163	com/tencent/smtt/sdk/WebView:e	Z
    //   258: ifne +357 -> 615
    //   261: ldc_w 2018
    //   264: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   267: astore 5
    //   269: aload 5
    //   271: ldc_w 2020
    //   274: iconst_1
    //   275: anewarray 251	java/lang/Class
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 298
    //   283: aastore
    //   284: invokevirtual 2023	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   287: astore 6
    //   289: aload 6
    //   291: iconst_1
    //   292: invokevirtual 267	java/lang/reflect/Method:setAccessible	(Z)V
    //   295: aload 6
    //   297: aconst_null
    //   298: iconst_1
    //   299: anewarray 269	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload_0
    //   305: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   308: aastore
    //   309: invokevirtual 273	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   312: astore 6
    //   314: aload 6
    //   316: ifnull +114 -> 430
    //   319: aload 5
    //   321: ldc_w 2025
    //   324: invokevirtual 1785	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   327: astore 5
    //   329: aload 5
    //   331: iconst_1
    //   332: invokevirtual 1788	java/lang/reflect/Field:setAccessible	(Z)V
    //   335: aload 5
    //   337: aload 6
    //   339: invokevirtual 1789	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: astore 5
    //   344: aload 5
    //   346: ifnull +84 -> 430
    //   349: aload 5
    //   351: checkcast 2027	android/app/Dialog
    //   354: astore 5
    //   356: aload 5
    //   358: aconst_null
    //   359: invokevirtual 2031	android/app/Dialog:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   362: ldc_w 2033
    //   365: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   368: astore 6
    //   370: aload 6
    //   372: ldc_w 2035
    //   375: invokevirtual 1785	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   378: astore 7
    //   380: aload 7
    //   382: iconst_1
    //   383: invokevirtual 1788	java/lang/reflect/Field:setAccessible	(Z)V
    //   386: aload 7
    //   388: aload 5
    //   390: invokevirtual 1789	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   393: checkcast 744	java/lang/Integer
    //   396: invokevirtual 1141	java/lang/Integer:intValue	()I
    //   399: istore_2
    //   400: aload 6
    //   402: ldc_w 2037
    //   405: invokevirtual 1785	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   408: astore 6
    //   410: aload 6
    //   412: iconst_1
    //   413: invokevirtual 1788	java/lang/reflect/Field:setAccessible	(Z)V
    //   416: aload 6
    //   418: aload 5
    //   420: invokevirtual 1789	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   423: checkcast 275	android/os/Handler
    //   426: iload_2
    //   427: invokevirtual 2040	android/os/Handler:removeMessages	(I)V
    //   430: iload_1
    //   431: ifeq +10 -> 441
    //   434: aload_0
    //   435: getfield 229	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$b;
    //   438: invokevirtual 1218	android/webkit/WebView:destroy	()V
    //   441: ldc_w 2042
    //   444: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   447: ldc_w 2044
    //   450: invokevirtual 1785	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   453: astore 6
    //   455: aload 6
    //   457: iconst_1
    //   458: invokevirtual 1788	java/lang/reflect/Field:setAccessible	(Z)V
    //   461: aload 6
    //   463: aconst_null
    //   464: invokevirtual 1789	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   467: checkcast 2046	android/content/ComponentCallbacks
    //   470: astore 5
    //   472: aload 5
    //   474: ifnull +66 -> 540
    //   477: aload 6
    //   479: aconst_null
    //   480: aconst_null
    //   481: invokevirtual 2050	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   484: ldc_w 2052
    //   487: invokestatic 255	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   490: ldc_w 2054
    //   493: invokevirtual 1785	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   496: astore 6
    //   498: aload 6
    //   500: iconst_1
    //   501: invokevirtual 1788	java/lang/reflect/Field:setAccessible	(Z)V
    //   504: aload 6
    //   506: aconst_null
    //   507: invokevirtual 1789	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   510: astore 6
    //   512: aload 6
    //   514: ifnull +26 -> 540
    //   517: aload 6
    //   519: checkcast 2056	java/util/List
    //   522: astore 6
    //   524: aload 6
    //   526: monitorenter
    //   527: aload 6
    //   529: aload 5
    //   531: invokeinterface 2059 2 0
    //   536: pop
    //   537: aload 6
    //   539: monitorexit
    //   540: ldc 159
    //   542: new 531	java/lang/StringBuilder
    //   545: dup
    //   546: ldc_w 2061
    //   549: invokespecial 534	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   552: invokestatic 2063	com/tencent/smtt/sdk/QbSdk:a	()Ljava/lang/String;
    //   555: invokevirtual 543	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 565	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 317	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: ldc_w 2014
    //   567: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   570: return
    //   571: astore 8
    //   573: ldc_w 2064
    //   576: ldc_w 1001
    //   579: aload 8
    //   581: invokestatic 773	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   584: invokevirtual 755	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   587: invokestatic 1003	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: iconst_0
    //   591: istore 4
    //   593: goto -376 -> 217
    //   596: astore 5
    //   598: aload 6
    //   600: monitorexit
    //   601: ldc_w 2014
    //   604: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   607: aload 5
    //   609: athrow
    //   610: astore 5
    //   612: goto -72 -> 540
    //   615: iload_1
    //   616: ifeq -76 -> 540
    //   619: aload_0
    //   620: getfield 219	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   623: invokeinterface 1217 1 0
    //   628: goto -88 -> 540
    //   631: astore 5
    //   633: goto -203 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	WebView
    //   0	636	1	paramBoolean	boolean
    //   151	276	2	i1	int
    //   149	6	3	i2	int
    //   215	377	4	bool	boolean
    //   50	480	5	localObject1	Object
    //   596	12	5	localObject2	Object
    //   610	1	5	localException1	Exception
    //   631	1	5	localException2	Exception
    //   42	345	7	localObject4	Object
    //   28	48	8	str1	String
    //   571	9	8	localObject5	Object
    //   33	47	9	str2	String
    //   38	46	10	str3	String
    //   73	40	11	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   201	217	571	finally
    //   527	540	596	finally
    //   441	472	610	java/lang/Exception
    //   477	512	610	java/lang/Exception
    //   517	527	610	java/lang/Exception
    //   598	610	610	java/lang/Exception
    //   261	314	631	java/lang/Exception
    //   319	344	631	java/lang/Exception
    //   349	430	631	java/lang/Exception
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
            }
          }
          boolean bool = false;
        }
        finally
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
          ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
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
    
    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(54523);
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(54523);
    }
    
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
        return;
      }
      finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */