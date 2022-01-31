package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.f;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.j.a;
import com.tencent.xweb.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class WebView
  extends FrameLayout
  implements h
{
  static WebView.d xhc = WebView.d.xhn;
  static String xhd = "";
  static com.tencent.xweb.x5.sdk.c xhh;
  public boolean isX5Kernel = false;
  View.OnLongClickListener wjs;
  h xhe;
  WebView.d xhf = WebView.d.xhn;
  com.tencent.xweb.c.e xhg;
  
  static {}
  
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
    this(paramContext, paramAttributeSet, 0, WebView.d.xhn);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.d paramd)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramd);
  }
  
  private void a(WebView.d paramd)
  {
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.xhf != WebView.d.xhn) {}
    for (;;)
    {
      return;
      if (getCurWebType() == WebView.d.xhn)
      {
        a(getContext(), WebView.d.xhq, null);
        Log.e("xweb.Webview", "use xweb without init, force to use sys web");
      }
      int i;
      if (paramd == WebView.d.xhq)
      {
        this.xhf = paramd;
        this.xhe = com.tencent.xweb.c.j.a(this.xhf, this);
        if (this.xhe == null)
        {
          paramd = new WebView.d[3];
          paramd[0] = WebView.d.xho;
          paramd[1] = WebView.d.xhq;
          paramd[2] = WebView.d.xhp;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < 3)
        {
          if ((paramd[i] != this.xhf) && (a(getContext(), paramd[i], null)))
          {
            this.xhe = com.tencent.xweb.c.j.a(paramd[i], this);
            if (this.xhe != null) {
              this.xhf = getCurWebType();
            }
          }
        }
        else
        {
          if (this.xhe == null)
          {
            a(getContext(), WebView.d.xhq, null, false, true);
            this.xhe = com.tencent.xweb.c.j.a(WebView.d.xhq, this);
            this.xhf = getCurWebType();
          }
          if (this.xhe != null) {
            break label253;
          }
          Log.e("xweb.WebView", "init finally failed type = " + this.xhf);
          com.tencent.xweb.util.e.cTj();
          return;
          this.xhf = getCurWebType();
          break;
        }
        i += 1;
      }
      label253:
      addView(this.xhe.getWebViewUI());
      if (this.xhf == WebView.d.xhp) {
        if (this.xhe.getX5WebViewExtension() != null)
        {
          this.isX5Kernel = true;
          Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
          label300:
          if (this.xhe.getCurWebviewClient() != null) {
            this.xhe.getCurWebviewClient().xgI = this.xhe.getDefalutOpProvider();
          }
          if (this.xhe.getCurWebChromeClient() != null) {
            this.xhe.getCurWebChromeClient().xgI = this.xhe.getDefalutOpProvider();
          }
          this.xhe.getView().setOnLongClickListener(new WebView.1(this));
        }
      }
      try
      {
        this.xhg = ((com.tencent.xweb.c.e)com.tencent.xweb.c.j.c(WebView.d.xho).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
        this.xhg.cSv();
        if (getWebCoreType() != WebView.d.xho) {
          continue;
        }
        paramd = a.agP(getCurStrModule());
        i = a.agO(getCurStrModule());
        if (!(this.xhe instanceof i)) {
          continue;
        }
        ((i)this.xhe).ea(paramd, i);
        return;
        Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        break label300;
        Log.i("xweb.WebView", "this webview instance is using :" + this.xhf);
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
          this.xhg = new WebView.2(this);
        }
      }
    }
  }
  
  private static boolean a(Context paramContext, WebView.d paramd, c paramc)
  {
    try
    {
      boolean bool = a(paramContext, paramd, paramc, true, false);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, WebView.d paramd, c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_1
    //   7: astore 7
    //   9: aload_1
    //   10: aload_0
    //   11: aload_2
    //   12: iload 4
    //   14: invokestatic 245	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$d;Landroid/content/Context;Lcom/tencent/xweb/WebView$c;Z)Z
    //   17: ifne +84 -> 101
    //   20: aload_1
    //   21: astore 7
    //   23: iload_3
    //   24: ifeq +77 -> 101
    //   27: getstatic 41	com/tencent/xweb/WebView$d:xhn	Lcom/tencent/xweb/WebView$d;
    //   30: astore_1
    //   31: iconst_3
    //   32: anewarray 16	com/tencent/xweb/WebView$d
    //   35: astore 8
    //   37: aload 8
    //   39: iconst_0
    //   40: getstatic 114	com/tencent/xweb/WebView$d:xhp	Lcom/tencent/xweb/WebView$d;
    //   43: aastore
    //   44: aload 8
    //   46: iconst_1
    //   47: getstatic 111	com/tencent/xweb/WebView$d:xho	Lcom/tencent/xweb/WebView$d;
    //   50: aastore
    //   51: aload 8
    //   53: iconst_2
    //   54: getstatic 88	com/tencent/xweb/WebView$d:xhq	Lcom/tencent/xweb/WebView$d;
    //   57: aastore
    //   58: iconst_0
    //   59: istore 5
    //   61: aload_1
    //   62: astore 7
    //   64: iload 5
    //   66: iconst_3
    //   67: if_icmpge +34 -> 101
    //   70: aload 8
    //   72: iload 5
    //   74: aaload
    //   75: aload_1
    //   76: if_acmpeq +71 -> 147
    //   79: aload 8
    //   81: iload 5
    //   83: aaload
    //   84: aload_0
    //   85: aload_2
    //   86: iload 4
    //   88: invokestatic 245	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$d;Landroid/content/Context;Lcom/tencent/xweb/WebView$c;Z)Z
    //   91: ifeq +56 -> 147
    //   94: aload 8
    //   96: iload 5
    //   98: aaload
    //   99: astore 7
    //   101: aload 7
    //   103: putstatic 43	com/tencent/xweb/WebView:xhc	Lcom/tencent/xweb/WebView$d;
    //   106: getstatic 41	com/tencent/xweb/WebView$d:xhn	Lcom/tencent/xweb/WebView$d;
    //   109: aload 7
    //   111: if_acmpne +45 -> 156
    //   114: invokestatic 248	com/tencent/xweb/util/e:cTi	()V
    //   117: ldc 119
    //   119: new 121	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 250
    //   125: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 7
    //   130: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 101	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: iload 6
    //   141: istore_3
    //   142: ldc 2
    //   144: monitorexit
    //   145: iload_3
    //   146: ireturn
    //   147: iload 5
    //   149: iconst_1
    //   150: iadd
    //   151: istore 5
    //   153: goto -92 -> 61
    //   156: new 121	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 252
    //   162: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload 7
    //   167: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: ldc 254
    //   172: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokestatic 261	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   178: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 267	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   187: iconst_1
    //   188: istore_3
    //   189: goto -47 -> 142
    //   192: astore_0
    //   193: ldc 2
    //   195: monitorexit
    //   196: aload_0
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramContext	Context
    //   0	198	1	paramd	WebView.d
    //   0	198	2	paramc	c
    //   0	198	3	paramBoolean1	boolean
    //   0	198	4	paramBoolean2	boolean
    //   59	93	5	i	int
    //   1	139	6	bool	boolean
    //   7	159	7	locald	WebView.d
    //   35	60	8	arrayOfd	WebView.d[]
    // Exception table:
    //   from	to	target	type
    //   9	20	192	finally
    //   27	58	192	finally
    //   79	94	192	finally
    //   101	139	192	finally
    //   156	187	192	finally
  }
  
  private static boolean a(WebView.d paramd, Context paramContext, c paramc, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!paramBoolean) && (com.tencent.xweb.c.c.b(paramd)))
    {
      com.tencent.xweb.util.e.e(paramd);
      return false;
    }
    com.tencent.xweb.c.c localc = com.tencent.xweb.c.c.b("LOAD_CORE", paramd);
    localc.cSG();
    paramBoolean = bool;
    for (;;)
    {
      try
      {
        j.a locala = com.tencent.xweb.c.j.c(paramd);
        paramBoolean = bool;
        bool = locala.initWebviewCore(paramContext, paramc);
        if (bool)
        {
          paramBoolean = bool;
          b.cSe().xgq = locala.getCookieManager();
          paramBoolean = bool;
          c.xgs = locala.getCookieSyncManager();
          paramBoolean = bool;
          com.tencent.xweb.util.e.d(paramd);
          paramBoolean = bool;
          localc.cSH();
          return bool;
        }
      }
      catch (Exception paramContext)
      {
        XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + paramd);
        com.tencent.xweb.util.e.f(paramd);
        return paramBoolean;
      }
      paramBoolean = bool;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = " + paramd);
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (getCurWebType() == WebView.d.xhq) {
      d.gS("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (getCurWebType() == WebView.d.xhq) {
      d.gS("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  private List<TextureView> et(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView)) {
      localArrayList.add((TextureView)paramView);
    }
    for (;;)
    {
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(et(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static boolean getCanReboot()
  {
    if (getCurWebType() == WebView.d.xhp)
    {
      if (xhh != null) {
        return xhh.getCanReboot();
      }
      Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    return false;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (xhh != null) {
      return xhh.getCrashExtraMessage(paramContext);
    }
    Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    return "";
  }
  
  public static String getCurStrModule()
  {
    return xhd;
  }
  
  public static WebView.d getCurWebType()
  {
    return xhc;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    if (xhh != null) {
      return xhh.getTbsCoreVersion(paramContext);
    }
    Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    return 0;
  }
  
  public static WebView.d getPreferedWebviewType(Context paramContext, WebView.d paramd, String paramString)
  {
    if (xhc != WebView.d.xhn)
    {
      paramContext = xhc;
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    int i;
    if (k.cSk().agU(paramString) != WebView.d.xhn)
    {
      i = 1;
      paramContext = k.cSk().agU(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = " + paramContext);
    }
    for (;;)
    {
      paramd = paramContext;
      if (i == 0)
      {
        paramd = paramContext;
        if (paramContext == WebView.d.xho)
        {
          paramd = paramContext;
          if (XWalkEnvironment.getXWebInitArgs("isgpversion", false))
          {
            paramd = WebView.d.xhq;
            XWalkEnvironment.addXWalkInitializeLog("gp version  , use sys");
          }
        }
      }
      paramContext = paramd;
      if (paramd != WebView.d.xho) {
        break;
      }
      paramContext = paramd;
      if (XWalkEnvironment.hasAvailableVersion()) {
        break;
      }
      paramContext = WebView.d.xhp;
      XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use x5");
      return paramContext;
      if (a.agL(paramString) != WebView.d.xhn)
      {
        paramContext = a.agL(paramString);
        XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + paramString + "use cmd web type = " + paramContext);
        i = 0;
      }
      else
      {
        paramContext = paramd;
        i = 0;
      }
    }
  }
  
  public static WebView.d getPreferedWebviewType(Context paramContext, String paramString)
  {
    return getPreferedWebviewType(paramContext, WebView.d.xhp, paramString);
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    if (xhh != null) {
      return xhh.getTbsCoreVersion(paramContext);
    }
    Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    return 0;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    if (xhh != null) {
      return xhh.getTbsSDKVersion(paramContext);
    }
    Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
    return 0;
  }
  
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    if (xhc == WebView.d.xhp)
    {
      if (xhh != null) {
        return xhh.getTbsCoreVersion(paramContext);
      }
      Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    }
    return 0;
  }
  
  public static boolean hasInited()
  {
    if (getCurWebType() == WebView.d.xhn) {}
    while (com.tencent.xweb.c.j.c(getCurWebType()) == null) {
      return false;
    }
    return com.tencent.xweb.c.j.c(getCurWebType()).hasInited();
  }
  
  public static void initWebviewCore(Context paramContext, WebView.d paramd, String paramString, c paramc)
  {
    if (xhc != WebView.d.xhn)
    {
      if (xhc != paramd) {
        Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      return;
    }
    xhd = paramString;
    com.tencent.xweb.util.e.agY(paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    XWalkEnvironment.init(paramContext);
    k.im(paramContext);
    a(paramContext, getPreferedWebviewType(paramContext, paramd, str), paramc);
  }
  
  public static boolean isSys()
  {
    return getCurWebType() == WebView.d.xhq;
  }
  
  public static boolean isX5()
  {
    return getCurWebType() == WebView.d.xhp;
  }
  
  public static boolean isXWalk()
  {
    return getCurWebType() == WebView.d.xho;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.sdk.c paramc)
  {
    xhh = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.xhe.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean canGoBack()
  {
    return this.xhe.canGoBack();
  }
  
  public void clearMatches()
  {
    this.xhe.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    this.xhe.clearSslPreferences();
  }
  
  public void clearView()
  {
    this.xhe.clearView();
  }
  
  public void destroy()
  {
    this.xhe.destroy();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public void drawCanvas(Canvas paramCanvas)
  {
    if (isXWalkKernel())
    {
      paramCanvas.drawBitmap(getBitmap(), 0.0F, 0.0F, null);
      return;
    }
    draw(paramCanvas);
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    this.xhe.evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void findAllAsync(String paramString)
  {
    this.xhe.findAllAsync(paramString);
  }
  
  public void findNext(boolean paramBoolean)
  {
    this.xhe.findNext(paramBoolean);
  }
  
  public String getAbstractInfo()
  {
    return this.xhe.getAbstractInfo();
  }
  
  public Bitmap getBitmap()
  {
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    if (localBitmap != null)
    {
      localBitmap.eraseColor(-1);
      Canvas localCanvas1 = new Canvas(localBitmap);
      if (isXWalkKernel()) {}
      try
      {
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        Object localObject = et(this).iterator();
        while (((Iterator)localObject).hasNext()) {
          localCanvas1.drawBitmap(((TextureView)((Iterator)localObject).next()).getBitmap(), 0.0F, 0.0F, localPaint);
        }
        localObject = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas2 = new Canvas((Bitmap)localObject);
        getTopView().draw(localCanvas2);
        localCanvas1.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, localPaint);
        return localBitmap;
      }
      catch (Exception localException) {}
      draw(localCanvas1);
      return localBitmap;
    }
    return localBitmap;
  }
  
  public int getContentHeight()
  {
    return this.xhe.getContentHeight();
  }
  
  public b.a getCookieManager()
  {
    return null;
  }
  
  public b.b getCookieSyncManager()
  {
    return null;
  }
  
  public j getCurWebChromeClient()
  {
    return this.xhe.getCurWebChromeClient();
  }
  
  public p getCurWebviewClient()
  {
    return this.xhe.getCurWebviewClient();
  }
  
  public f getDefalutOpProvider()
  {
    return null;
  }
  
  public a getFullscreenVideoKind()
  {
    return this.xhe.getFullscreenVideoKind();
  }
  
  public WebView.b getHitTestResult()
  {
    return this.xhe.getHitTestResult();
  }
  
  public float getScale()
  {
    return this.xhe.getScale();
  }
  
  public n getSettings()
  {
    return this.xhe.getSettings();
  }
  
  public String getTitle()
  {
    return this.xhe.getTitle();
  }
  
  public ViewGroup getTopView()
  {
    return this.xhe.getTopView();
  }
  
  public String getUrl()
  {
    return this.xhe.getUrl();
  }
  
  public String getVersionInfo()
  {
    return this.xhe.getVersionInfo();
  }
  
  public View getView()
  {
    return this.xhe.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    return this.xhe.getVisibleTitleHeight();
  }
  
  public WebView.d getWebCoreType()
  {
    return this.xhf;
  }
  
  public int getWebScrollX()
  {
    return this.xhe.getWebScrollX();
  }
  
  public int getWebScrollY()
  {
    return this.xhe.getWebScrollY();
  }
  
  public View getWebViewUI()
  {
    return this.xhe.getWebViewUI();
  }
  
  public Object getX5WebViewExtension()
  {
    return this.xhe.getX5WebViewExtension();
  }
  
  public void goBack()
  {
    this.xhe.goBack();
  }
  
  public boolean hasEnteredFullscreen()
  {
    return this.xhe.hasEnteredFullscreen();
  }
  
  public boolean isOverScrollStart()
  {
    return this.xhe.isOverScrollStart();
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    if (isXWalkKernel()) {
      return this.xhe.isSupportExtendPluginForAppbrand();
    }
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.xhf == WebView.d.xhq;
  }
  
  public boolean isXWalkKernel()
  {
    return this.xhf == WebView.d.xho;
  }
  
  public void leaveFullscreen()
  {
    this.xhe.leaveFullscreen();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.xhe.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.e.aha(paramString1);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.xhe.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.e.aha(paramString1);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.xhg.agV(paramString))
    {
      this.xhe.loadUrl("http://weixin.qq.com/");
      return;
    }
    this.xhe.loadUrl(paramString);
    com.tencent.xweb.util.e.aha(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (this.xhg.agV(paramString))
    {
      this.xhe.loadUrl("http://weixin.qq.com/");
      return;
    }
    this.xhe.loadUrl(paramString, paramMap);
    com.tencent.xweb.util.e.aha(paramString);
  }
  
  public void onPause()
  {
    this.xhe.onPause();
  }
  
  public void onResume()
  {
    this.xhe.onResume();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.xhe != null) {
      this.xhe.getView().setVisibility(paramInt);
    }
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    return this.xhe.overlayHorizontalScrollbar();
  }
  
  public void reload()
  {
    this.xhe.reload();
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.xhe.removeJavascriptInterface(paramString);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return this.xhe.savePage(paramString1, paramString2, paramInt);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.xhe.setDownloadListener(paramDownloadListener);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    this.xhe.setFindListener(paramFindListener);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
  }
  
  public void setJSExceptionListener(q paramq)
  {
    this.xhe.setJSExceptionListener(paramq);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.wjs = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.xhe.getWebViewUI().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setWebChromeClient(j paramj)
  {
    if (paramj != null) {
      paramj.xgI = this.xhe.getDefalutOpProvider();
    }
    this.xhe.setWebChromeClient(paramj);
  }
  
  public void setWebViewCallbackClient(o paramo)
  {
    this.xhe.setWebViewCallbackClient(paramo);
  }
  
  public void setWebViewClient(p paramp)
  {
    if (paramp != null) {
      paramp.xgI = this.xhe.getDefalutOpProvider();
    }
    this.xhe.setWebViewClient(paramp);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    this.xhe.setWebViewClientExtension(paramb);
  }
  
  public void stopLoading()
  {
    this.xhe.stopLoading();
  }
  
  public void super_computeScroll()
  {
    this.xhe.super_computeScroll();
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.xhe.super_dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.xhe.super_onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.xhe.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.xhe.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.xhe.super_onTouchEvent(paramMotionEvent);
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return this.xhe.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }
  
  public boolean zoomIn()
  {
    return this.xhe.zoomIn();
  }
  
  public boolean zoomOut()
  {
    return this.xhe.zoomOut();
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static abstract interface c
  {
    public abstract void onCoreInitFinished();
    
    public abstract void tc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.WebView
 * JD-Core Version:    0.7.0.1
 */