package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
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
import android.webkit.WebBackForwardList;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.b;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.j.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWebCoreInfo;

public class WebView
  extends FrameLayout
  implements IWebView
{
  static WebView.c MNk;
  static String MNl;
  static boolean MNm;
  static com.tencent.xweb.x5.sdk.c MNq;
  View.OnLongClickListener LnL;
  IWebView MNn;
  WebView.c MNo;
  com.tencent.xweb.internal.d MNp;
  private int MNr;
  public boolean isX5Kernel;
  
  static
  {
    AppMethodBeat.i(156917);
    aj.initInterface();
    MNk = WebView.c.MNx;
    MNl = "";
    MNm = false;
    AppMethodBeat.o(156917);
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
    this(paramContext, paramAttributeSet, 0, WebView.c.MNx);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, WebView.c paramc)
  {
    super((Context)localObject, paramAttributeSet, paramInt);
    AppMethodBeat.i(156815);
    this.MNo = WebView.c.MNx;
    this.isX5Kernel = false;
    this.MNr = -1;
    b(paramc);
    AppMethodBeat.o(156815);
  }
  
  public static boolean _initWebviewCore(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(156811);
      paramBoolean = a(paramContext, paramc, paramPreInitCallback, true, false);
      AppMethodBeat.o(156811);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static boolean a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc 105
    //   8: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: astore 7
    //   14: aload_1
    //   15: aload_0
    //   16: aload_2
    //   17: iload 4
    //   19: invokestatic 108	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   22: ifne +84 -> 106
    //   25: aload_1
    //   26: astore 7
    //   28: iload_3
    //   29: ifeq +77 -> 106
    //   32: getstatic 56	com/tencent/xweb/WebView$c:MNx	Lcom/tencent/xweb/WebView$c;
    //   35: astore_1
    //   36: iconst_3
    //   37: anewarray 18	com/tencent/xweb/WebView$c
    //   40: astore 8
    //   42: aload 8
    //   44: iconst_0
    //   45: getstatic 111	com/tencent/xweb/WebView$c:MNy	Lcom/tencent/xweb/WebView$c;
    //   48: aastore
    //   49: aload 8
    //   51: iconst_1
    //   52: getstatic 114	com/tencent/xweb/WebView$c:MNA	Lcom/tencent/xweb/WebView$c;
    //   55: aastore
    //   56: aload 8
    //   58: iconst_2
    //   59: getstatic 117	com/tencent/xweb/WebView$c:MNz	Lcom/tencent/xweb/WebView$c;
    //   62: aastore
    //   63: iconst_0
    //   64: istore 5
    //   66: aload_1
    //   67: astore 7
    //   69: iload 5
    //   71: iconst_3
    //   72: if_icmpge +34 -> 106
    //   75: aload 8
    //   77: iload 5
    //   79: aaload
    //   80: aload_1
    //   81: if_acmpeq +69 -> 150
    //   84: aload 8
    //   86: iload 5
    //   88: aaload
    //   89: aload_0
    //   90: aload_2
    //   91: iload 4
    //   93: invokestatic 108	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   96: ifeq +54 -> 150
    //   99: aload 8
    //   101: iload 5
    //   103: aaload
    //   104: astore 7
    //   106: aload 7
    //   108: putstatic 58	com/tencent/xweb/WebView:MNk	Lcom/tencent/xweb/WebView$c;
    //   111: getstatic 56	com/tencent/xweb/WebView$c:MNx	Lcom/tencent/xweb/WebView$c;
    //   114: aload 7
    //   116: if_acmpne +43 -> 159
    //   119: invokestatic 122	com/tencent/xweb/util/g:ghb	()V
    //   122: ldc 124
    //   124: ldc 126
    //   126: aload 7
    //   128: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 136	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 142	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 105
    //   139: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: iload 6
    //   144: istore_3
    //   145: ldc 2
    //   147: monitorexit
    //   148: iload_3
    //   149: ireturn
    //   150: iload 5
    //   152: iconst_1
    //   153: iadd
    //   154: istore 5
    //   156: goto -90 -> 66
    //   159: new 144	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 146
    //   165: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 7
    //   170: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc 155
    //   175: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 164	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   181: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 174	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   190: ldc 105
    //   192: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: iconst_1
    //   196: istore_3
    //   197: goto -52 -> 145
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramContext	Context
    //   0	206	1	paramc	WebView.c
    //   0	206	2	paramPreInitCallback	WebView.PreInitCallback
    //   0	206	3	paramBoolean1	boolean
    //   0	206	4	paramBoolean2	boolean
    //   64	91	5	i	int
    //   1	142	6	bool	boolean
    //   12	157	7	localc	WebView.c
    //   40	60	8	arrayOfc	WebView.c[]
    // Exception table:
    //   from	to	target	type
    //   6	11	200	finally
    //   14	25	200	finally
    //   32	63	200	finally
    //   84	99	200	finally
    //   106	142	200	finally
    //   159	195	200	finally
  }
  
  private static boolean a(WebView.c paramc, Context paramContext, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(156813);
    if (paramc == WebView.c.MNz) {
      com.tencent.xweb.x5.sdk.d.ghp();
    }
    org.xwalk.core.Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(paramc)));
    if ((!paramBoolean) && (b.c(paramc)))
    {
      com.tencent.xweb.util.g.j(paramc);
      AppMethodBeat.o(156813);
      return false;
    }
    b localb = b.c("LOAD_CORE", paramc);
    localb.ggi();
    paramBoolean = bool;
    try
    {
      j.a locala = j.g(paramc);
      paramBoolean = bool;
      bool = locala.initWebviewCore(paramContext, paramPreInitCallback);
      if (bool)
      {
        paramBoolean = bool;
        c.geY().MLY = locala.getCookieManager();
        paramBoolean = bool;
        d.MMa = locala.getCookieSyncManager();
        paramBoolean = bool;
        com.tencent.xweb.util.g.i(paramc);
        paramBoolean = bool;
        localb.ggj();
        paramBoolean = bool;
      }
      for (;;)
      {
        AppMethodBeat.o(156813);
        return paramBoolean;
        paramBoolean = bool;
        XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = ".concat(String.valueOf(paramc)));
        paramBoolean = bool;
        continue;
        try
        {
          XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "crash stack : " + android.util.Log.getStackTraceString(paramContext));
          com.tencent.xweb.util.g.k(paramc);
        }
        catch (Exception paramContext)
        {
          break label232;
        }
      }
    }
    catch (Exception paramContext)
    {
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + paramc + ", err = " + paramContext.getMessage());
    }
  }
  
  private void b(WebView.c paramc)
  {
    AppMethodBeat.i(156819);
    org.xwalk.core.Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + paramc);
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.MNo != WebView.c.MNx)
    {
      AppMethodBeat.o(156819);
      return;
    }
    if (getCurWebType() == WebView.c.MNx)
    {
      _initWebviewCore(getContext(), WebView.c.MNA, null, true);
      org.xwalk.core.Log.e("xweb.Webview", "use xweb without init, force to use sys web");
    }
    int i;
    if (h.ggn().ggq())
    {
      this.MNo = WebView.c.MNA;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
      this.MNn = j.a(this.MNo, this);
      if (this.MNn == null)
      {
        paramc = new WebView.c[3];
        paramc[0] = WebView.c.MNy;
        paramc[1] = WebView.c.MNA;
        paramc[2] = WebView.c.MNz;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < 3)
      {
        if ((paramc[i] != this.MNo) && (_initWebviewCore(getContext(), paramc[i], null, false)))
        {
          this.MNn = j.a(paramc[i], this);
          if (this.MNn != null) {
            this.MNo = getCurWebType();
          }
        }
      }
      else
      {
        if (this.MNn == null)
        {
          a(getContext(), WebView.c.MNA, null, false, true);
          this.MNn = j.a(WebView.c.MNA, this);
          this.MNo = getCurWebType();
        }
        if (this.MNn != null) {
          break label360;
        }
        org.xwalk.core.Log.e("xweb.WebView", "init finally failed type = " + this.MNo);
        com.tencent.xweb.util.g.ghc();
        AppMethodBeat.o(156819);
        return;
        if (paramc == WebView.c.MNA)
        {
          this.MNo = paramc;
          paramc = j.g(WebView.c.MNA);
          if (paramc == null) {
            break;
          }
          paramc.initWebviewCore(getContext(), null);
          break;
        }
        this.MNo = getCurWebType();
        break;
      }
      i += 1;
    }
    label360:
    addView(this.MNn.getWebViewUI());
    if (this.MNo == WebView.c.MNz) {
      if (this.MNn.getX5WebViewExtension() != null)
      {
        this.isX5Kernel = true;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
      }
    }
    for (;;)
    {
      if (this.MNn.getCurWebviewClient() != null) {
        this.MNn.getCurWebviewClient().MMT = this.MNn.getDefalutOpProvider();
      }
      if (this.MNn.getCurWebChromeClient() != null) {
        this.MNn.getCurWebChromeClient().MMT = this.MNn.getDefalutOpProvider();
      }
      this.MNn.getView().setOnLongClickListener(new WebView.1(this));
      try
      {
        this.MNp = ((com.tencent.xweb.internal.d)j.g(WebView.c.MNy).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
        this.MNp.gfH();
        if (getWebCoreType() == WebView.c.MNy)
        {
          paramc = getContext();
          if ((paramc instanceof d)) {
            ((d)paramc).MNC = this.MNn;
          }
          com.tencent.xweb.internal.i.f(WebView.c.MNy).ggm();
        }
        paramc = getSettings().getUserAgentString();
        getSettings().setUserAgentString(paramc + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(156819);
        return;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        continue;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using :" + this.MNo);
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          org.xwalk.core.Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
          this.MNp = new com.tencent.xweb.internal.d()
          {
            public final boolean bcD(String paramAnonymousString)
            {
              return false;
            }
            
            public final void gfH() {}
          };
        }
      }
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(156877);
    if (getCurWebType() == WebView.c.MNA) {
      com.tencent.xweb.util.f.no("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(156877);
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(156876);
    if (getCurWebType() == WebView.c.MNA) {
      com.tencent.xweb.util.f.no("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(156876);
  }
  
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(156860);
    if ((MNm) && (XWebCoreInfo.getCurAbiInstalledNewestVersion(XWalkEnvironment.getApplicationContext()) > 0))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has installed xweb core ");
      AppMethodBeat.o(156860);
      return true;
    }
    if ((getCurWebType() == WebView.c.MNy) && (XWalkEnvironment.getAvailableVersion() > 0) && (XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has newer xweb version ");
      AppMethodBeat.o(156860);
      return true;
    }
    if (getCurWebType() == WebView.c.MNz)
    {
      if (MNq != null)
      {
        boolean bool = MNq.getCanReboot();
        AppMethodBeat.o(156860);
        return bool;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    if (h.ggn().ggr())
    {
      AppMethodBeat.o(156860);
      return true;
    }
    AppMethodBeat.o(156860);
    return false;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    AppMethodBeat.i(156859);
    if (MNq != null)
    {
      paramContext = MNq.getCrashExtraMessage(paramContext);
      AppMethodBeat.o(156859);
      return paramContext;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    AppMethodBeat.o(156859);
    return "";
  }
  
  public static String getCurStrModule()
  {
    return MNl;
  }
  
  public static WebView.c getCurWebType()
  {
    return MNk;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156856);
    if (MNq != null)
    {
      int i = MNq.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(156856);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    AppMethodBeat.o(156856);
    return 0;
  }
  
  public static WebView.c getPreferedWebviewType(Context paramContext, WebView.c paramc, String paramString)
  {
    AppMethodBeat.i(156809);
    if (MNk != WebView.c.MNx)
    {
      paramContext = MNk;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isIaDevice())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
      com.tencent.xweb.util.g.FJ(69L);
      paramContext = WebView.c.MNA;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    if (y.gfo().bcB(paramString) != WebView.c.MNx)
    {
      paramc = y.gfo().bcB(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(paramc)));
    }
    for (;;)
    {
      com.tencent.xweb.util.g.h(paramc);
      paramContext = paramc;
      if (paramc == WebView.c.MNy)
      {
        paramContext = paramc;
        if (!XWalkEnvironment.hasAvailableVersion())
        {
          paramContext = WebView.c.MNA;
          MNm = true;
          XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use sys");
        }
      }
      h.d(paramContext);
      if (h.ggn().ggs())
      {
        XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
        paramContext = WebView.c.MNA;
      }
      if (paramContext == WebView.c.MNz) {
        com.tencent.xweb.x5.sdk.d.ghp();
      }
      AppMethodBeat.o(156809);
      return paramContext;
      if (a.bbZ(paramString) != WebView.c.MNx)
      {
        paramc = a.bbZ(paramString);
        XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + paramString + "use cmd web type = " + paramc);
      }
    }
  }
  
  public static WebView.c getPreferedWebviewType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(156808);
    paramContext = getPreferedWebviewType(paramContext, WebView.c.MNz, paramString);
    AppMethodBeat.o(156808);
    return paramContext;
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156857);
    if (MNq != null)
    {
      int i = MNq.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(156857);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    AppMethodBeat.o(156857);
    return 0;
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    AppMethodBeat.i(156858);
    if (MNq != null)
    {
      int i = MNq.getTbsSDKVersion(paramContext);
      AppMethodBeat.o(156858);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
    AppMethodBeat.o(156858);
    return 0;
  }
  
  public static int getUsingTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156855);
    if (MNk == WebView.c.MNz)
    {
      if (MNq != null)
      {
        int i = MNq.getTbsCoreVersion(paramContext);
        AppMethodBeat.o(156855);
        return i;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    }
    AppMethodBeat.o(156855);
    return 0;
  }
  
  public static boolean hasInited()
  {
    AppMethodBeat.i(156814);
    if (getCurWebType() == WebView.c.MNx)
    {
      AppMethodBeat.o(156814);
      return false;
    }
    if (j.g(getCurWebType()) == null)
    {
      AppMethodBeat.o(156814);
      return false;
    }
    boolean bool = j.g(getCurWebType()).hasInited();
    AppMethodBeat.o(156814);
    return bool;
  }
  
  private List<TextureView> hw(View paramView)
  {
    AppMethodBeat.i(156836);
    ArrayList localArrayList = new ArrayList();
    if ((paramView instanceof TextureView)) {
      localArrayList.add((TextureView)paramView);
    }
    for (;;)
    {
      AppMethodBeat.o(156836);
      return localArrayList;
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(hw(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static void initWebviewCore(Context paramContext, WebView.c paramc, String paramString, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(156810);
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.isEmpty()) {}
    }
    else
    {
      str = "tools";
    }
    if (MNk != WebView.c.MNx)
    {
      if (MNk != paramc) {
        org.xwalk.core.Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      AppMethodBeat.o(156810);
      return;
    }
    MNl = str;
    com.tencent.xweb.util.g.bcU(str);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    XWalkEnvironment.init(paramContext);
    s.init();
    y.lD(paramContext);
    if (XWalkEnvironment.getAvailableVersion() <= 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("initWebviewCore with no xweb, tryEmbedInstall");
      w.gfm();
    }
    _initWebviewCore(paramContext, getPreferedWebviewType(paramContext, paramc, paramString), paramPreInitCallback, true);
    AppMethodBeat.o(156810);
  }
  
  public static boolean isSys()
  {
    AppMethodBeat.i(156914);
    if (getCurWebType() == WebView.c.MNA)
    {
      AppMethodBeat.o(156914);
      return true;
    }
    AppMethodBeat.o(156914);
    return false;
  }
  
  public static boolean isX5()
  {
    AppMethodBeat.i(156913);
    if (getCurWebType() == WebView.c.MNz)
    {
      AppMethodBeat.o(156913);
      return true;
    }
    AppMethodBeat.o(156913);
    return false;
  }
  
  public static boolean isXWalk()
  {
    AppMethodBeat.i(156912);
    if (getCurWebType() == WebView.c.MNy)
    {
      AppMethodBeat.o(156912);
      return true;
    }
    AppMethodBeat.o(156912);
    return false;
  }
  
  public static void reinitToXWeb()
  {
    AppMethodBeat.i(185175);
    XWalkEnvironment.addXWalkInitializeLog("reinitToXWeb");
    MNk = WebView.c.MNx;
    XWalkEnvironment.refreshVerInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), WebView.c.MNy, MNl, null);
    AppMethodBeat.o(185175);
  }
  
  public static boolean setProfileResultCallback(String paramString, k paramk)
  {
    AppMethodBeat.i(183498);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null)
    {
      boolean bool = localf.ggl().setProfileResultCallback(paramString, paramk);
      AppMethodBeat.o(183498);
      return bool;
    }
    AppMethodBeat.o(183498);
    return false;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.sdk.c paramc)
  {
    MNq = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(156875);
    this.MNn.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(156875);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(156888);
    boolean bool = this.MNn.canGoBack();
    AppMethodBeat.o(156888);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(156900);
    boolean bool = this.MNn.canGoForward();
    AppMethodBeat.o(156900);
    return bool;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    AppMethodBeat.i(156817);
    org.xwalk.core.Log.d("xweb.WebView", "captureBitmap");
    this.MNn.captureBitmap(parama);
    AppMethodBeat.o(156817);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(156899);
    this.MNn.clearHistory();
    AppMethodBeat.o(156899);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(156847);
    this.MNn.clearMatches();
    AppMethodBeat.o(156847);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(156862);
    this.MNn.clearSslPreferences();
    AppMethodBeat.o(156862);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(156890);
    this.MNn.clearView();
    AppMethodBeat.o(156890);
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(217396);
    WebBackForwardList localWebBackForwardList = this.MNn.copyBackForwardList();
    AppMethodBeat.o(217396);
    return localWebBackForwardList;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(156891);
    this.MNn.destroy();
    AppMethodBeat.o(156891);
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(156910);
    this.MNn.disableVideoJsCallback(paramBoolean);
    AppMethodBeat.o(156910);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(156818);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(156818);
  }
  
  public void drawCanvas(Canvas paramCanvas)
  {
    AppMethodBeat.i(156834);
    if (isXWalkKernel())
    {
      paramCanvas.drawBitmap(getBitmap(), 0.0F, 0.0F, null);
      AppMethodBeat.o(156834);
      return;
    }
    draw(paramCanvas);
    AppMethodBeat.o(156834);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(156816);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    AppMethodBeat.o(156816);
    return bool;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(156894);
    this.MNn.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(156894);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(156849);
    this.MNn.findAllAsync(paramString);
    AppMethodBeat.o(156849);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(156848);
    this.MNn.findNext(paramBoolean);
    AppMethodBeat.o(156848);
  }
  
  public String getAbstractInfo()
  {
    AppMethodBeat.i(156851);
    String str = this.MNn.getAbstractInfo();
    AppMethodBeat.o(156851);
    return str;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(156835);
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
        localObject1 = hw(this).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((TextureView)((Iterator)localObject1).next()).getBitmap();
            if (localObject2 != null)
            {
              localCanvas.drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, localPaint);
              continue;
              AppMethodBeat.o(156835);
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
    AppMethodBeat.i(156864);
    int i = this.MNn.getContentHeight();
    AppMethodBeat.o(156864);
    return i;
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    return null;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    return null;
  }
  
  public x getCurWebChromeClient()
  {
    AppMethodBeat.i(156853);
    x localx = this.MNn.getCurWebChromeClient();
    AppMethodBeat.o(156853);
    return localx;
  }
  
  public ac getCurWebviewClient()
  {
    AppMethodBeat.i(156852);
    ac localac = this.MNn.getCurWebviewClient();
    AppMethodBeat.o(156852);
    return localac;
  }
  
  public e getDefalutOpProvider()
  {
    return null;
  }
  
  public a getFullscreenVideoKind()
  {
    AppMethodBeat.i(156895);
    a locala = this.MNn.getFullscreenVideoKind();
    AppMethodBeat.o(156895);
    return locala;
  }
  
  public b getHitTestResult()
  {
    AppMethodBeat.i(156845);
    b localb = this.MNn.getHitTestResult();
    AppMethodBeat.o(156845);
    return localb;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217398);
    paramString1 = this.MNn.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(217398);
    return paramString1;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(156916);
    boolean bool = this.MNn.getImageBitmapToFile(paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(156916);
    return bool;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(156865);
    float f = this.MNn.getScale();
    AppMethodBeat.o(156865);
    return f;
  }
  
  public int getScrollHeight()
  {
    AppMethodBeat.i(156907);
    int i = this.MNn.getScrollHeight();
    AppMethodBeat.o(156907);
    return i;
  }
  
  public z getSettings()
  {
    AppMethodBeat.i(156878);
    z localz = this.MNn.getSettings();
    AppMethodBeat.o(156878);
    return localz;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(156846);
    String str = this.MNn.getTitle();
    AppMethodBeat.o(156846);
    return str;
  }
  
  public ViewGroup getTopView()
  {
    AppMethodBeat.i(156840);
    ViewGroup localViewGroup = this.MNn.getTopView();
    AppMethodBeat.o(156840);
    return localViewGroup;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(156841);
    String str = this.MNn.getUrl();
    AppMethodBeat.o(156841);
    return str;
  }
  
  public String getVersionInfo()
  {
    AppMethodBeat.i(156850);
    String str = this.MNn.getVersionInfo();
    AppMethodBeat.o(156850);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(156839);
    View localView = this.MNn.getView();
    AppMethodBeat.o(156839);
    return localView;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(156869);
    int i = this.MNn.getVisibleTitleHeight();
    AppMethodBeat.o(156869);
    return i;
  }
  
  public WebView.c getWebCoreType()
  {
    return this.MNo;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(156867);
    int i = this.MNn.getWebScrollX();
    AppMethodBeat.o(156867);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(156866);
    int i = this.MNn.getWebScrollY();
    AppMethodBeat.o(156866);
    return i;
  }
  
  public View getWebViewUI()
  {
    AppMethodBeat.i(156879);
    View localView = this.MNn.getWebViewUI();
    AppMethodBeat.o(156879);
    return localView;
  }
  
  public Object getX5WebViewExtension()
  {
    AppMethodBeat.i(156820);
    Object localObject = this.MNn.getX5WebViewExtension();
    AppMethodBeat.o(156820);
    return localObject;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(156889);
    this.MNn.goBack();
    AppMethodBeat.o(156889);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(156901);
    this.MNn.goForward();
    AppMethodBeat.o(156901);
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(156892);
    boolean bool = this.MNn.hasEnteredFullscreen();
    AppMethodBeat.o(156892);
    return bool;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(156897);
    paramString = this.MNn.invokeMiscMethod(paramString, paramBundle);
    AppMethodBeat.o(156897);
    return paramString;
  }
  
  public boolean isOverScrollStart()
  {
    AppMethodBeat.i(156868);
    boolean bool = this.MNn.isOverScrollStart();
    AppMethodBeat.o(156868);
    return bool;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(156854);
    if (isXWalkKernel())
    {
      boolean bool = this.MNn.isSupportExtendPluginForAppbrand();
      AppMethodBeat.o(156854);
      return bool;
    }
    AppMethodBeat.o(156854);
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.MNo == WebView.c.MNA;
  }
  
  public boolean isX5WrappedSysKernel()
  {
    AppMethodBeat.i(175639);
    if ((getCurWebType() == WebView.c.MNz) && (!this.isX5Kernel))
    {
      AppMethodBeat.o(175639);
      return true;
    }
    AppMethodBeat.o(175639);
    return false;
  }
  
  public boolean isXWalkKernel()
  {
    return this.MNo == WebView.c.MNy;
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(156893);
    this.MNn.leaveFullscreen();
    AppMethodBeat.o(156893);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156863);
    this.MNn.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.g.a(paramString1, this);
    reportLoadByReason();
    AppMethodBeat.o(156863);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(156871);
    this.MNn.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.g.a(paramString1, this);
    AppMethodBeat.o(156871);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(156884);
    if (this.MNp.bcD(paramString))
    {
      this.MNn.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156884);
      return;
    }
    this.MNn.loadUrl(paramString);
    com.tencent.xweb.util.g.a(paramString, this);
    reportLoadByReason();
    AppMethodBeat.o(156884);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(156874);
    if (this.MNp.bcD(paramString))
    {
      this.MNn.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156874);
      return;
    }
    this.MNn.loadUrl(paramString, paramMap);
    com.tencent.xweb.util.g.a(paramString, this);
    reportLoadByReason();
    AppMethodBeat.o(156874);
  }
  
  @Deprecated
  public void manualStartFrameCostProfiler()
  {
    AppMethodBeat.i(156886);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null) {
      localf.ggl().bcx("xprofile.frameCost");
    }
    AppMethodBeat.o(156886);
  }
  
  @Deprecated
  public void manualStopFrameCostProfiler(l paraml)
  {
    AppMethodBeat.i(156887);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null) {
      localf.ggl().a(paraml);
    }
    AppMethodBeat.o(156887);
  }
  
  public void onHide()
  {
    AppMethodBeat.i(156906);
    this.MNn.onHide();
    AppMethodBeat.o(156906);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(156830);
    this.MNn.onPause();
    AppMethodBeat.o(156830);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(156829);
    this.MNn.onResume();
    AppMethodBeat.o(156829);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(156905);
    this.MNn.onShow();
    AppMethodBeat.o(156905);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(156833);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.MNn != null) {
      this.MNn.getView().setVisibility(paramInt);
    }
    AppMethodBeat.o(156833);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(156870);
    boolean bool = this.MNn.overlayHorizontalScrollbar();
    AppMethodBeat.o(156870);
    return bool;
  }
  
  public void reload()
  {
    AppMethodBeat.i(156861);
    this.MNn.reload();
    AppMethodBeat.o(156861);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(156842);
    this.MNn.removeJavascriptInterface(paramString);
    AppMethodBeat.o(156842);
  }
  
  public void reportLoadByReason()
  {
    AppMethodBeat.i(156915);
    com.tencent.xweb.util.g.ajm(this.MNr);
    this.MNr = -1;
    AppMethodBeat.o(156915);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(156898);
    boolean bool = this.MNn.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(156898);
    return bool;
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.MNr = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(156832);
    org.xwalk.core.Log.i("xweb.WebView", "setBackgroundColor color:" + Integer.toHexString(paramInt));
    super.setBackgroundColor(paramInt);
    if (this.MNn != null) {
      this.MNn.getWebViewUI().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(156832);
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(156904);
    this.MNn.setBottomHeight(paramInt);
    AppMethodBeat.o(156904);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(156882);
    this.MNn.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(156882);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(156883);
    this.MNn.setFindListener(paramFindListener);
    AppMethodBeat.o(156883);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    AppMethodBeat.i(156837);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusable(false);
      AppMethodBeat.o(156837);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusable(false);
    AppMethodBeat.o(156837);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(156838);
    if (!paramBoolean)
    {
      setDescendantFocusability(393216);
      super.setFocusableInTouchMode(false);
      AppMethodBeat.o(156838);
      return;
    }
    setDescendantFocusability(131072);
    super.setFocusableInTouchMode(false);
    AppMethodBeat.o(156838);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156909);
    this.MNn.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156909);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217397);
    this.MNn.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(217397);
  }
  
  public void setJSExceptionListener(ae paramae)
  {
    AppMethodBeat.i(156896);
    this.MNn.setJSExceptionListener(paramae);
    AppMethodBeat.o(156896);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.LnL = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(156831);
    this.MNn.getWebViewUI().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(156831);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156908);
    this.MNn.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156908);
  }
  
  public u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(156911);
    paramv = this.MNn.setVideoJsCallback(paramv);
    AppMethodBeat.o(156911);
    return paramv;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(156881);
    if (paramx != null) {
      paramx.MMT = this.MNn.getDefalutOpProvider();
    }
    this.MNn.setWebChromeClient(paramx);
    AppMethodBeat.o(156881);
  }
  
  public void setWebViewCallbackClient(ab paramab)
  {
    AppMethodBeat.i(156844);
    this.MNn.setWebViewCallbackClient(paramab);
    AppMethodBeat.o(156844);
  }
  
  public void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(156880);
    if (paramac != null) {
      paramac.MMT = this.MNn.getDefalutOpProvider();
    }
    this.MNn.setWebViewClient(paramac);
    AppMethodBeat.o(156880);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(156821);
    this.MNn.setWebViewClientExtension(parama);
    AppMethodBeat.o(156821);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(156903);
    this.MNn.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(156903);
  }
  
  public void startLongScreenshot(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(156885);
    if (((this.MNn instanceof com.tencent.xweb.internal.g)) && (this.MNo == WebView.c.MNy)) {
      ((com.tencent.xweb.internal.g)this.MNn).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, paramq);
    }
    AppMethodBeat.o(156885);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(156843);
    this.MNn.stopLoading();
    AppMethodBeat.o(156843);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(156826);
    this.MNn.super_computeScroll();
    AppMethodBeat.o(156826);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156825);
    boolean bool = this.MNn.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156825);
    return bool;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156823);
    boolean bool = this.MNn.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156823);
    return bool;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156824);
    this.MNn.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(156824);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156827);
    this.MNn.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(156827);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156822);
    boolean bool = this.MNn.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156822);
    return bool;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(156828);
    paramBoolean = this.MNn.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(156828);
    return paramBoolean;
  }
  
  public boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(156902);
    boolean bool = this.MNn.supportFeature(paramInt);
    AppMethodBeat.o(156902);
    return bool;
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(156873);
    boolean bool = this.MNn.zoomIn();
    AppMethodBeat.o(156873);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(156872);
    boolean bool = this.MNn.zoomOut();
    AppMethodBeat.o(156872);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156802);
      MNt = new a("NOT_HOOK", 0);
      MNu = new a("HOOK_NOT_EVALUTE_JS", 1);
      MNv = new a("HOOK_EVALUTE_JS", 2);
      MNw = new a[] { MNt, MNu, MNv };
      AppMethodBeat.o(156802);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public String mExtra;
    public int mType = 0;
  }
  
  static final class d
    extends MutableContextWrapper
  {
    IWebView MNC;
    
    public d(Context paramContext)
    {
      super();
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(156806);
      super.setBaseContext(paramContext);
      if (!y.gfo().MNa) {
        ah.B("BASE_CONTEXT_CHANGED", this.MNC);
      }
      AppMethodBeat.o(156806);
    }
    
    public final void unbindService(ServiceConnection paramServiceConnection)
    {
      AppMethodBeat.i(156807);
      try
      {
        super.unbindService(paramServiceConnection);
        AppMethodBeat.o(156807);
        return;
      }
      catch (IllegalArgumentException paramServiceConnection)
      {
        org.xwalk.core.Log.e("xweb.WebView", "ContextWrapper unbindService IllegalArgumentException", paramServiceConnection);
        AppMethodBeat.o(156807);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.WebView
 * JD-Core Version:    0.7.0.1
 */