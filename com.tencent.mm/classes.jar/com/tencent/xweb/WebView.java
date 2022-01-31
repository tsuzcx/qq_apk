package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.i;
import com.tencent.xweb.c.i.a;
import com.tencent.xweb.c.j;
import com.tencent.xweb.c.k;
import com.tencent.xweb.c.l.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public class WebView
  extends FrameLayout
  implements i
{
  static WebView.d BEd;
  static String BEe;
  static com.tencent.xweb.x5.sdk.c BEi;
  View.OnLongClickListener ACZ;
  i BEf;
  WebView.d BEg;
  com.tencent.xweb.c.e BEh;
  private int BEj;
  public boolean isX5Kernel;
  
  static
  {
    AppMethodBeat.i(3941);
    ac.initInterface();
    BEd = WebView.d.BEp;
    BEe = "";
    AppMethodBeat.o(3941);
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
    this(paramContext, paramAttributeSet, 0, WebView.d.BEp);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.d paramd)
  {
    super((Context)localObject, paramAttributeSet, paramInt);
    AppMethodBeat.i(3854);
    this.BEg = WebView.d.BEp;
    this.isX5Kernel = false;
    this.BEj = -1;
    a(paramd);
    AppMethodBeat.o(3854);
  }
  
  private void a(WebView.d paramd)
  {
    AppMethodBeat.i(3857);
    org.xwalk.core.Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + paramd);
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.BEg != WebView.d.BEp)
    {
      AppMethodBeat.o(3857);
      return;
    }
    if (getCurWebType() == WebView.d.BEp)
    {
      b(getContext(), WebView.d.BEs, null);
      org.xwalk.core.Log.e("xweb.Webview", "use xweb without init, force to use sys web");
    }
    int i;
    if (k.dYQ().dYT())
    {
      this.BEg = WebView.d.BEs;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
      this.BEf = com.tencent.xweb.c.l.a(this.BEg, this);
      if (this.BEf == null)
      {
        paramd = new WebView.d[3];
        paramd[0] = WebView.d.BEq;
        paramd[1] = WebView.d.BEs;
        paramd[2] = WebView.d.BEr;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < 3)
      {
        if ((paramd[i] != this.BEg) && (b(getContext(), paramd[i], null)))
        {
          this.BEf = com.tencent.xweb.c.l.a(paramd[i], this);
          if (this.BEf != null) {
            this.BEg = getCurWebType();
          }
        }
      }
      else
      {
        if (this.BEf == null)
        {
          a(getContext(), WebView.d.BEs, null, false, true);
          this.BEf = com.tencent.xweb.c.l.a(WebView.d.BEs, this);
          this.BEg = getCurWebType();
        }
        if (this.BEf != null) {
          break label329;
        }
        org.xwalk.core.Log.e("xweb.WebView", "init finally failed type = " + this.BEg);
        com.tencent.xweb.util.f.dZz();
        AppMethodBeat.o(3857);
        return;
        if (paramd == WebView.d.BEs)
        {
          this.BEg = paramd;
          break;
        }
        this.BEg = getCurWebType();
        break;
      }
      i += 1;
    }
    label329:
    addView(this.BEf.getWebViewUI());
    if (this.BEg == WebView.d.BEr) {
      if (this.BEf.getX5WebViewExtension() != null)
      {
        this.isX5Kernel = true;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
      }
    }
    for (;;)
    {
      if (this.BEf.getCurWebviewClient() != null) {
        this.BEf.getCurWebviewClient().BDF = this.BEf.getDefalutOpProvider();
      }
      if (this.BEf.getCurWebChromeClient() != null) {
        this.BEf.getCurWebChromeClient().BDF = this.BEf.getDefalutOpProvider();
      }
      this.BEf.getView().setOnLongClickListener(new WebView.1(this));
      try
      {
        this.BEh = ((com.tencent.xweb.c.e)com.tencent.xweb.c.l.e(WebView.d.BEq).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
        this.BEh.dYB();
        if (getWebCoreType() == WebView.d.BEq)
        {
          paramd = a.axM(getCurStrModule());
          i = a.axL(getCurStrModule());
          if ((this.BEf instanceof j)) {
            ((j)this.BEf).fk(paramd, i);
          }
          paramd = getContext();
          if ((paramd instanceof WebView.e)) {
            ((WebView.e)paramd).BEu = this.BEf;
          }
        }
        paramd = getSettings().getUserAgentString();
        getSettings().setUserAgentString(paramd + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(3857);
        return;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        continue;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using :" + this.BEg);
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          org.xwalk.core.Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
          this.BEh = new WebView.2(this);
        }
      }
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, WebView.d paramd, WebView.c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: sipush 3851
    //   9: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_1
    //   13: astore 7
    //   15: aload_1
    //   16: aload_0
    //   17: aload_2
    //   18: iload 4
    //   20: invokestatic 314	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$d;Landroid/content/Context;Lcom/tencent/xweb/WebView$c;Z)Z
    //   23: ifne +84 -> 107
    //   26: aload_1
    //   27: astore 7
    //   29: iload_3
    //   30: ifeq +77 -> 107
    //   33: getstatic 50	com/tencent/xweb/WebView$d:BEp	Lcom/tencent/xweb/WebView$d;
    //   36: astore_1
    //   37: iconst_3
    //   38: anewarray 15	com/tencent/xweb/WebView$d
    //   41: astore 8
    //   43: aload 8
    //   45: iconst_0
    //   46: getstatic 172	com/tencent/xweb/WebView$d:BEq	Lcom/tencent/xweb/WebView$d;
    //   49: aastore
    //   50: aload 8
    //   52: iconst_1
    //   53: getstatic 136	com/tencent/xweb/WebView$d:BEs	Lcom/tencent/xweb/WebView$d;
    //   56: aastore
    //   57: aload 8
    //   59: iconst_2
    //   60: getstatic 175	com/tencent/xweb/WebView$d:BEr	Lcom/tencent/xweb/WebView$d;
    //   63: aastore
    //   64: iconst_0
    //   65: istore 5
    //   67: aload_1
    //   68: astore 7
    //   70: iload 5
    //   72: iconst_3
    //   73: if_icmpge +34 -> 107
    //   76: aload 8
    //   78: iload 5
    //   80: aaload
    //   81: aload_1
    //   82: if_acmpeq +71 -> 153
    //   85: aload 8
    //   87: iload 5
    //   89: aaload
    //   90: aload_0
    //   91: aload_2
    //   92: iload 4
    //   94: invokestatic 314	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$d;Landroid/content/Context;Lcom/tencent/xweb/WebView$c;Z)Z
    //   97: ifeq +56 -> 153
    //   100: aload 8
    //   102: iload 5
    //   104: aaload
    //   105: astore 7
    //   107: aload 7
    //   109: putstatic 52	com/tencent/xweb/WebView:BEd	Lcom/tencent/xweb/WebView$d;
    //   112: getstatic 50	com/tencent/xweb/WebView$d:BEp	Lcom/tencent/xweb/WebView$d;
    //   115: aload 7
    //   117: if_acmpne +45 -> 162
    //   120: invokestatic 317	com/tencent/xweb/util/f:dZy	()V
    //   123: ldc 93
    //   125: ldc_w 319
    //   128: aload 7
    //   130: invokestatic 325	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 328	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: invokestatic 147	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: sipush 3851
    //   142: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: iload 6
    //   147: istore_3
    //   148: ldc 2
    //   150: monitorexit
    //   151: iload_3
    //   152: ireturn
    //   153: iload 5
    //   155: iconst_1
    //   156: iadd
    //   157: istore 5
    //   159: goto -92 -> 67
    //   162: new 95	java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w 330
    //   169: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 7
    //   174: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: ldc_w 332
    //   180: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokestatic 335	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   186: invokevirtual 299	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 337	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   195: sipush 3851
    //   198: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: iconst_1
    //   202: istore_3
    //   203: goto -55 -> 148
    //   206: astore_0
    //   207: ldc 2
    //   209: monitorexit
    //   210: aload_0
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramContext	Context
    //   0	212	1	paramd	WebView.d
    //   0	212	2	paramc	WebView.c
    //   0	212	3	paramBoolean1	boolean
    //   0	212	4	paramBoolean2	boolean
    //   65	93	5	i	int
    //   1	145	6	bool	boolean
    //   13	160	7	locald	WebView.d
    //   41	60	8	arrayOfd	WebView.d[]
    // Exception table:
    //   from	to	target	type
    //   6	12	206	finally
    //   15	26	206	finally
    //   33	64	206	finally
    //   85	100	206	finally
    //   107	145	206	finally
    //   162	201	206	finally
  }
  
  private static boolean a(WebView.d paramd, Context paramContext, WebView.c paramc, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(3852);
    org.xwalk.core.Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(paramd)));
    if ((!paramBoolean) && (com.tencent.xweb.c.c.b(paramd)))
    {
      com.tencent.xweb.util.f.h(paramd);
      AppMethodBeat.o(3852);
      return false;
    }
    com.tencent.xweb.c.c localc = com.tencent.xweb.c.c.c("LOAD_CORE", paramd);
    localc.dYN();
    paramBoolean = bool;
    try
    {
      l.a locala = com.tencent.xweb.c.l.e(paramd);
      paramBoolean = bool;
      bool = locala.initWebviewCore(paramContext, paramc);
      if (bool)
      {
        paramBoolean = bool;
        b.dYg().BCV = locala.getCookieManager();
        paramBoolean = bool;
        c.BCX = locala.getCookieSyncManager();
        paramBoolean = bool;
        com.tencent.xweb.util.f.g(paramd);
        paramBoolean = bool;
        localc.dYO();
        paramBoolean = bool;
      }
      for (;;)
      {
        AppMethodBeat.o(3852);
        return paramBoolean;
        paramBoolean = bool;
        XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = ".concat(String.valueOf(paramd)));
        paramBoolean = bool;
        continue;
        try
        {
          XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "crash stack : " + android.util.Log.getStackTraceString(paramContext));
          com.tencent.xweb.util.f.i(paramd);
        }
        catch (Exception paramContext)
        {
          break label229;
        }
      }
    }
    catch (Exception paramContext)
    {
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + paramd + ", err = " + paramContext.getMessage());
    }
  }
  
  private static boolean b(Context paramContext, WebView.d paramd, WebView.c paramc)
  {
    try
    {
      AppMethodBeat.i(3850);
      boolean bool = a(paramContext, paramd, paramc, true, false);
      AppMethodBeat.o(3850);
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(3914);
    if (getCurWebType() == WebView.d.BEs) {
      com.tencent.xweb.util.e.je("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(3914);
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(3913);
    if (getCurWebType() == WebView.d.BEs) {
      com.tencent.xweb.util.e.je("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(3913);
  }
  
  private List<TextureView> fH(View paramView)
  {
    AppMethodBeat.i(3873);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView)) {
      localArrayList.add((TextureView)paramView);
    }
    for (;;)
    {
      AppMethodBeat.o(3873);
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(fH(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(3897);
    if (getCurWebType() == WebView.d.BEr)
    {
      if (BEi != null)
      {
        boolean bool = BEi.getCanReboot();
        AppMethodBeat.o(3897);
        return bool;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    if (k.dYQ().dYU())
    {
      AppMethodBeat.o(3897);
      return true;
    }
    AppMethodBeat.o(3897);
    return false;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    AppMethodBeat.i(3896);
    if (BEi != null)
    {
      paramContext = BEi.getCrashExtraMessage(paramContext);
      AppMethodBeat.o(3896);
      return paramContext;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    AppMethodBeat.o(3896);
    return "";
  }
  
  public static String getCurStrModule()
  {
    return BEe;
  }
  
  public static WebView.d getCurWebType()
  {
    return BEd;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(3893);
    if (BEi != null)
    {
      int i = BEi.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(3893);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    AppMethodBeat.o(3893);
    return 0;
  }
  
  public static WebView.d getPreferedWebviewType(Context paramContext, WebView.d paramd, String paramString)
  {
    AppMethodBeat.i(3848);
    if (BEd != WebView.d.BEp)
    {
      paramContext = BEd;
      AppMethodBeat.o(3848);
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isIaDevice())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
      com.tencent.xweb.util.f.pf(69L);
      paramContext = WebView.d.BEs;
      AppMethodBeat.o(3848);
      return paramContext;
    }
    int i;
    if (q.dYn().axW(paramString) != WebView.d.BEp)
    {
      i = 1;
      paramd = q.dYn().axW(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(paramd)));
    }
    for (;;)
    {
      com.tencent.xweb.util.f.f(paramd);
      paramContext = paramd;
      if (i == 0)
      {
        paramContext = paramd;
        if (paramd == WebView.d.BEq)
        {
          paramContext = paramd;
          if (XWalkEnvironment.getXWebInitArgs("isgpversion", false))
          {
            paramContext = WebView.d.BEs;
            XWalkEnvironment.addXWalkInitializeLog("gp version  , use sys");
          }
        }
      }
      paramd = paramContext;
      if (paramContext == WebView.d.BEq)
      {
        paramd = paramContext;
        if (!XWalkEnvironment.hasAvailableVersion())
        {
          paramd = WebView.d.BEr;
          XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use x5");
        }
      }
      k.c(paramd);
      if (k.dYQ().dYV())
      {
        XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
        paramd = WebView.d.BEs;
      }
      AppMethodBeat.o(3848);
      return paramd;
      if (a.axH(paramString) != WebView.d.BEp)
      {
        paramd = a.axH(paramString);
        XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + paramString + "use cmd web type = " + paramd);
      }
      i = 0;
    }
  }
  
  public static WebView.d getPreferedWebviewType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(3847);
    paramContext = getPreferedWebviewType(paramContext, WebView.d.BEr, paramString);
    AppMethodBeat.o(3847);
    return paramContext;
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(3894);
    if (BEi != null)
    {
      int i = BEi.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(3894);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    AppMethodBeat.o(3894);
    return 0;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    AppMethodBeat.i(3895);
    if (BEi != null)
    {
      int i = BEi.getTbsSDKVersion(paramContext);
      AppMethodBeat.o(3895);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
    AppMethodBeat.o(3895);
    return 0;
  }
  
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(3892);
    if (BEd == WebView.d.BEr)
    {
      if (BEi != null)
      {
        int i = BEi.getTbsCoreVersion(paramContext);
        AppMethodBeat.o(3892);
        return i;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    }
    AppMethodBeat.o(3892);
    return 0;
  }
  
  public static boolean hasInited()
  {
    AppMethodBeat.i(3853);
    if (getCurWebType() == WebView.d.BEp)
    {
      AppMethodBeat.o(3853);
      return false;
    }
    if (com.tencent.xweb.c.l.e(getCurWebType()) == null)
    {
      AppMethodBeat.o(3853);
      return false;
    }
    boolean bool = com.tencent.xweb.c.l.e(getCurWebType()).hasInited();
    AppMethodBeat.o(3853);
    return bool;
  }
  
  public static void initWebviewCore(Context paramContext, WebView.d paramd, String paramString, WebView.c paramc)
  {
    AppMethodBeat.i(3849);
    if (BEd != WebView.d.BEp)
    {
      if (BEd != paramd) {
        org.xwalk.core.Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      AppMethodBeat.o(3849);
      return;
    }
    BEe = paramString;
    com.tencent.xweb.util.f.ayh(paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    XWalkEnvironment.init(paramContext);
    q.jS(paramContext);
    b(paramContext, getPreferedWebviewType(paramContext, paramd, str), paramc);
    AppMethodBeat.o(3849);
  }
  
  public static boolean isSys()
  {
    AppMethodBeat.i(3939);
    if (getCurWebType() == WebView.d.BEs)
    {
      AppMethodBeat.o(3939);
      return true;
    }
    AppMethodBeat.o(3939);
    return false;
  }
  
  public static boolean isX5()
  {
    AppMethodBeat.i(3938);
    if (getCurWebType() == WebView.d.BEr)
    {
      AppMethodBeat.o(3938);
      return true;
    }
    AppMethodBeat.o(3938);
    return false;
  }
  
  public static boolean isXWalk()
  {
    AppMethodBeat.i(3937);
    if (getCurWebType() == WebView.d.BEq)
    {
      AppMethodBeat.o(3937);
      return true;
    }
    AppMethodBeat.o(3937);
    return false;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.sdk.c paramc)
  {
    BEi = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(3912);
    this.BEf.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(3912);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(3922);
    boolean bool = this.BEf.canGoBack();
    AppMethodBeat.o(3922);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(3933);
    boolean bool = this.BEf.canGoForward();
    AppMethodBeat.o(3933);
    return bool;
  }
  
  public void captureBitmap(i.a parama)
  {
    AppMethodBeat.i(151429);
    org.xwalk.core.Log.d("xweb.WebView", "captureBitmap");
    this.BEf.captureBitmap(parama);
    AppMethodBeat.o(151429);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(3932);
    this.BEf.clearHistory();
    AppMethodBeat.o(3932);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(3884);
    this.BEf.clearMatches();
    AppMethodBeat.o(3884);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(3899);
    this.BEf.clearSslPreferences();
    AppMethodBeat.o(3899);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(3924);
    this.BEf.clearView();
    AppMethodBeat.o(3924);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(3925);
    this.BEf.destroy();
    AppMethodBeat.o(3925);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(3856);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(3856);
  }
  
  public void drawCanvas(Canvas paramCanvas)
  {
    AppMethodBeat.i(3871);
    if (isXWalkKernel())
    {
      paramCanvas.drawBitmap(getBitmap(), 0.0F, 0.0F, null);
      AppMethodBeat.o(3871);
      return;
    }
    draw(paramCanvas);
    AppMethodBeat.o(3871);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(3855);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(3855);
    return bool;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(3928);
    this.BEf.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(3928);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(3886);
    this.BEf.findAllAsync(paramString);
    AppMethodBeat.o(3886);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(3885);
    this.BEf.findNext(paramBoolean);
    AppMethodBeat.o(3885);
  }
  
  public String getAbstractInfo()
  {
    AppMethodBeat.i(3888);
    String str = this.BEf.getAbstractInfo();
    AppMethodBeat.o(3888);
    return str;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(3872);
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Paint localPaint;
    Object localObject1;
    Object localObject2;
    if (localBitmap != null)
    {
      localBitmap.eraseColor(-1);
      Canvas localCanvas = new Canvas(localBitmap);
      if (!isXWalkKernel()) {
        break label191;
      }
      try
      {
        localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        localObject1 = fH(this).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((TextureView)((Iterator)localObject1).next()).getBitmap();
            if (localObject2 != null)
            {
              localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, localPaint);
              continue;
              AppMethodBeat.o(3872);
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    for (;;)
    {
      return localBitmap;
      org.xwalk.core.Log.e("xweb.WebView", "getBitmap textureViewBitmap = null");
      break;
      localObject1 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      getTopView().draw((Canvas)localObject2);
      localException.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, localPaint);
      continue;
      label191:
      draw(localException);
    }
  }
  
  public int getContentHeight()
  {
    AppMethodBeat.i(3901);
    int i = this.BEf.getContentHeight();
    AppMethodBeat.o(3901);
    return i;
  }
  
  public b.a getCookieManager()
  {
    return null;
  }
  
  public b.b getCookieSyncManager()
  {
    return null;
  }
  
  public p getCurWebChromeClient()
  {
    AppMethodBeat.i(3890);
    p localp = this.BEf.getCurWebChromeClient();
    AppMethodBeat.o(3890);
    return localp;
  }
  
  public w getCurWebviewClient()
  {
    AppMethodBeat.i(3889);
    w localw = this.BEf.getCurWebviewClient();
    AppMethodBeat.o(3889);
    return localw;
  }
  
  public com.tencent.xweb.c.f getDefalutOpProvider()
  {
    return null;
  }
  
  public a getFullscreenVideoKind()
  {
    AppMethodBeat.i(3929);
    a locala = this.BEf.getFullscreenVideoKind();
    AppMethodBeat.o(3929);
    return locala;
  }
  
  public WebView.b getHitTestResult()
  {
    AppMethodBeat.i(3882);
    WebView.b localb = this.BEf.getHitTestResult();
    AppMethodBeat.o(3882);
    return localb;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, g paramg)
  {
    AppMethodBeat.i(151433);
    boolean bool = this.BEf.getImageBitmapToFile(paramString1, paramString2, paramString3, paramg);
    AppMethodBeat.o(151433);
    return bool;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(3902);
    float f = this.BEf.getScale();
    AppMethodBeat.o(3902);
    return f;
  }
  
  public t getSettings()
  {
    AppMethodBeat.i(3915);
    t localt = this.BEf.getSettings();
    AppMethodBeat.o(3915);
    return localt;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(3883);
    String str = this.BEf.getTitle();
    AppMethodBeat.o(3883);
    return str;
  }
  
  public ViewGroup getTopView()
  {
    AppMethodBeat.i(3877);
    ViewGroup localViewGroup = this.BEf.getTopView();
    AppMethodBeat.o(3877);
    return localViewGroup;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(3878);
    String str = this.BEf.getUrl();
    AppMethodBeat.o(3878);
    return str;
  }
  
  public String getVersionInfo()
  {
    AppMethodBeat.i(3887);
    String str = this.BEf.getVersionInfo();
    AppMethodBeat.o(3887);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(3876);
    View localView = this.BEf.getView();
    AppMethodBeat.o(3876);
    return localView;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(3906);
    int i = this.BEf.getVisibleTitleHeight();
    AppMethodBeat.o(3906);
    return i;
  }
  
  public WebView.d getWebCoreType()
  {
    return this.BEg;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(3904);
    int i = this.BEf.getWebScrollX();
    AppMethodBeat.o(3904);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(3903);
    int i = this.BEf.getWebScrollY();
    AppMethodBeat.o(3903);
    return i;
  }
  
  public View getWebViewUI()
  {
    AppMethodBeat.i(3916);
    View localView = this.BEf.getWebViewUI();
    AppMethodBeat.o(3916);
    return localView;
  }
  
  public Object getX5WebViewExtension()
  {
    AppMethodBeat.i(3858);
    Object localObject = this.BEf.getX5WebViewExtension();
    AppMethodBeat.o(3858);
    return localObject;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(3923);
    this.BEf.goBack();
    AppMethodBeat.o(3923);
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(3926);
    boolean bool = this.BEf.hasEnteredFullscreen();
    AppMethodBeat.o(3926);
    return bool;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(151431);
    paramString = this.BEf.invokeMiscMethod(paramString, paramBundle);
    AppMethodBeat.o(151431);
    return paramString;
  }
  
  public boolean isOverScrollStart()
  {
    AppMethodBeat.i(3905);
    boolean bool = this.BEf.isOverScrollStart();
    AppMethodBeat.o(3905);
    return bool;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(3891);
    if (isXWalkKernel())
    {
      boolean bool = this.BEf.isSupportExtendPluginForAppbrand();
      AppMethodBeat.o(3891);
      return bool;
    }
    AppMethodBeat.o(3891);
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.BEg == WebView.d.BEs;
  }
  
  public boolean isXWalkKernel()
  {
    return this.BEg == WebView.d.BEq;
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(3927);
    this.BEf.leaveFullscreen();
    AppMethodBeat.o(3927);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(3900);
    this.BEf.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.f.ayj(paramString1);
    reportLoadByReason();
    AppMethodBeat.o(3900);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3908);
    this.BEf.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.f.ayj(paramString1);
    AppMethodBeat.o(3908);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(3921);
    if (this.BEh.axY(paramString))
    {
      this.BEf.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(3921);
      return;
    }
    this.BEf.loadUrl(paramString);
    com.tencent.xweb.util.f.ayj(paramString);
    reportLoadByReason();
    AppMethodBeat.o(3921);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(3911);
    if (this.BEh.axY(paramString))
    {
      this.BEf.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(3911);
      return;
    }
    this.BEf.loadUrl(paramString, paramMap);
    com.tencent.xweb.util.f.ayj(paramString);
    reportLoadByReason();
    AppMethodBeat.o(3911);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(3868);
    this.BEf.onPause();
    AppMethodBeat.o(3868);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(3867);
    this.BEf.onResume();
    AppMethodBeat.o(3867);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(3870);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.BEf != null) {
      this.BEf.getView().setVisibility(paramInt);
    }
    AppMethodBeat.o(3870);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(3907);
    boolean bool = this.BEf.overlayHorizontalScrollbar();
    AppMethodBeat.o(3907);
    return bool;
  }
  
  public void reload()
  {
    AppMethodBeat.i(3898);
    this.BEf.reload();
    AppMethodBeat.o(3898);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(3879);
    this.BEf.removeJavascriptInterface(paramString);
    AppMethodBeat.o(3879);
  }
  
  public void reportLoadByReason()
  {
    AppMethodBeat.i(3940);
    com.tencent.xweb.util.f.TA(this.BEj);
    this.BEj = -1;
    AppMethodBeat.o(3940);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(3931);
    boolean bool = this.BEf.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(3931);
    return bool;
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.BEj = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(155569);
    super.setBackgroundColor(paramInt);
    if (this.BEf != null) {
      this.BEf.getWebViewUI().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(155569);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(3919);
    this.BEf.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(3919);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(3920);
    this.BEf.setFindListener(paramFindListener);
    AppMethodBeat.o(3920);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(3874);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      AppMethodBeat.o(3874);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
    AppMethodBeat.o(3874);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(3875);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      AppMethodBeat.o(3875);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
    AppMethodBeat.o(3875);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(3936);
    this.BEf.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(3936);
  }
  
  public void setJSExceptionListener(x paramx)
  {
    AppMethodBeat.i(3930);
    this.BEf.setJSExceptionListener(paramx);
    AppMethodBeat.o(3930);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.ACZ = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(3869);
    this.BEf.getWebViewUI().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(3869);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(3935);
    this.BEf.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(3935);
  }
  
  public void setWebChromeClient(p paramp)
  {
    AppMethodBeat.i(3918);
    if (paramp != null) {
      paramp.BDF = this.BEf.getDefalutOpProvider();
    }
    this.BEf.setWebChromeClient(paramp);
    AppMethodBeat.o(3918);
  }
  
  public void setWebViewCallbackClient(v paramv)
  {
    AppMethodBeat.i(3881);
    this.BEf.setWebViewCallbackClient(paramv);
    AppMethodBeat.o(3881);
  }
  
  public void setWebViewClient(w paramw)
  {
    AppMethodBeat.i(3917);
    if (paramw != null) {
      paramw.BDF = this.BEf.getDefalutOpProvider();
    }
    this.BEf.setWebViewClient(paramw);
    AppMethodBeat.o(3917);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b paramb)
  {
    AppMethodBeat.i(3859);
    this.BEf.setWebViewClientExtension(paramb);
    AppMethodBeat.o(3859);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(151432);
    this.BEf.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(151432);
  }
  
  public void startLongScreenshot(l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(151430);
    if (((this.BEf instanceof j)) && (this.BEg == WebView.d.BEq)) {
      ((j)this.BEf).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, paraml);
    }
    AppMethodBeat.o(151430);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(3880);
    this.BEf.stopLoading();
    AppMethodBeat.o(3880);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(3864);
    this.BEf.super_computeScroll();
    AppMethodBeat.o(3864);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3863);
    boolean bool = this.BEf.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3863);
    return bool;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3861);
    boolean bool = this.BEf.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3861);
    return bool;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(3862);
    this.BEf.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(3862);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(3865);
    this.BEf.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(3865);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3860);
    boolean bool = this.BEf.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3860);
    return bool;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(3866);
    paramBoolean = this.BEf.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(3866);
    return paramBoolean;
  }
  
  public boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(3934);
    boolean bool = this.BEf.supportFeature(paramInt);
    AppMethodBeat.o(3934);
    return bool;
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(3910);
    boolean bool = this.BEf.zoomIn();
    AppMethodBeat.o(3910);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(3909);
    boolean bool = this.BEf.zoomOut();
    AppMethodBeat.o(3909);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(3843);
      BEl = new a("NOT_HOOK", 0);
      BEm = new a("HOOK_NOT_EVALUTE_JS", 1);
      BEn = new a("HOOK_EVALUTE_JS", 2);
      BEo = new a[] { BEl, BEm, BEn };
      AppMethodBeat.o(3843);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.WebView
 * JD-Core Version:    0.7.0.1
 */