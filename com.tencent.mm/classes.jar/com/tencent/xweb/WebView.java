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
import com.tencent.xweb.internal.d;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.internal.h;
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
  static c INo;
  static String INp;
  static boolean INq;
  static com.tencent.xweb.x5.sdk.c INu;
  View.OnLongClickListener HzE;
  IWebView INr;
  c INs;
  d INt;
  private int INv;
  public boolean isX5Kernel;
  
  static
  {
    AppMethodBeat.i(156917);
    ah.initInterface();
    INo = c.INB;
    INp = "";
    INq = false;
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
    this(paramContext, paramAttributeSet, 0, c.INB);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, c paramc)
  {
    super((Context)localObject, paramAttributeSet, paramInt);
    AppMethodBeat.i(156815);
    this.INs = c.INB;
    this.isX5Kernel = false;
    this.INv = -1;
    b(paramc);
    AppMethodBeat.o(156815);
  }
  
  public static boolean _initWebviewCore(Context paramContext, c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
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
  private static boolean a(Context paramContext, c paramc, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc 108
    //   8: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: astore 7
    //   14: aload_1
    //   15: aload_0
    //   16: aload_2
    //   17: iload 4
    //   19: invokestatic 111	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   22: ifne +84 -> 106
    //   25: aload_1
    //   26: astore 7
    //   28: iload_3
    //   29: ifeq +77 -> 106
    //   32: getstatic 59	com/tencent/xweb/WebView$c:INB	Lcom/tencent/xweb/WebView$c;
    //   35: astore_1
    //   36: iconst_3
    //   37: anewarray 20	com/tencent/xweb/WebView$c
    //   40: astore 8
    //   42: aload 8
    //   44: iconst_0
    //   45: getstatic 114	com/tencent/xweb/WebView$c:INC	Lcom/tencent/xweb/WebView$c;
    //   48: aastore
    //   49: aload 8
    //   51: iconst_1
    //   52: getstatic 117	com/tencent/xweb/WebView$c:INE	Lcom/tencent/xweb/WebView$c;
    //   55: aastore
    //   56: aload 8
    //   58: iconst_2
    //   59: getstatic 120	com/tencent/xweb/WebView$c:IND	Lcom/tencent/xweb/WebView$c;
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
    //   93: invokestatic 111	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   96: ifeq +54 -> 150
    //   99: aload 8
    //   101: iload 5
    //   103: aaload
    //   104: astore 7
    //   106: aload 7
    //   108: putstatic 61	com/tencent/xweb/WebView:INo	Lcom/tencent/xweb/WebView$c;
    //   111: getstatic 59	com/tencent/xweb/WebView$c:INB	Lcom/tencent/xweb/WebView$c;
    //   114: aload 7
    //   116: if_acmpne +43 -> 159
    //   119: invokestatic 125	com/tencent/xweb/util/g:fsB	()V
    //   122: ldc 127
    //   124: ldc 129
    //   126: aload 7
    //   128: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 145	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 108
    //   139: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   159: new 147	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 149
    //   165: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 7
    //   170: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc 158
    //   175: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 167	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   181: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 177	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   190: ldc 108
    //   192: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	206	1	paramc	c
    //   0	206	2	paramPreInitCallback	WebView.PreInitCallback
    //   0	206	3	paramBoolean1	boolean
    //   0	206	4	paramBoolean2	boolean
    //   64	91	5	i	int
    //   1	142	6	bool	boolean
    //   12	157	7	localc	c
    //   40	60	8	arrayOfc	c[]
    // Exception table:
    //   from	to	target	type
    //   6	11	200	finally
    //   14	25	200	finally
    //   32	63	200	finally
    //   84	99	200	finally
    //   106	142	200	finally
    //   159	195	200	finally
  }
  
  private static boolean a(c paramc, Context paramContext, WebView.PreInitCallback paramPreInitCallback, boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(156813);
    org.xwalk.core.Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(paramc)));
    if ((!paramBoolean) && (b.c(paramc)))
    {
      com.tencent.xweb.util.g.j(paramc);
      AppMethodBeat.o(156813);
      return false;
    }
    b localb = b.c("LOAD_CORE", paramc);
    localb.frI();
    paramBoolean = bool;
    try
    {
      j.a locala = com.tencent.xweb.internal.j.g(paramc);
      paramBoolean = bool;
      bool = locala.initWebviewCore(paramContext, paramPreInitCallback);
      if (bool)
      {
        paramBoolean = bool;
        c.fqC().IMn = locala.getCookieManager();
        paramBoolean = bool;
        d.IMp = locala.getCookieSyncManager();
        paramBoolean = bool;
        com.tencent.xweb.util.g.i(paramc);
        paramBoolean = bool;
        localb.frJ();
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
          break label220;
        }
      }
    }
    catch (Exception paramContext)
    {
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + paramc + ", err = " + paramContext.getMessage());
    }
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(156819);
    org.xwalk.core.Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + paramc);
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.INs != c.INB)
    {
      AppMethodBeat.o(156819);
      return;
    }
    if (getCurWebType() == c.INB)
    {
      _initWebviewCore(getContext(), c.INE, null, true);
      org.xwalk.core.Log.e("xweb.Webview", "use xweb without init, force to use sys web");
    }
    int i;
    if (h.frN().frQ())
    {
      this.INs = c.INE;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
      this.INr = com.tencent.xweb.internal.j.a(this.INs, this);
      if (this.INr == null)
      {
        paramc = new c[3];
        paramc[0] = c.INC;
        paramc[1] = c.INE;
        paramc[2] = c.IND;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < 3)
      {
        if ((paramc[i] != this.INs) && (_initWebviewCore(getContext(), paramc[i], null, false)))
        {
          this.INr = com.tencent.xweb.internal.j.a(paramc[i], this);
          if (this.INr != null) {
            this.INs = getCurWebType();
          }
        }
      }
      else
      {
        if (this.INr == null)
        {
          a(getContext(), c.INE, null, false, true);
          this.INr = com.tencent.xweb.internal.j.a(c.INE, this);
          this.INs = getCurWebType();
        }
        if (this.INr != null) {
          break label360;
        }
        org.xwalk.core.Log.e("xweb.WebView", "init finally failed type = " + this.INs);
        com.tencent.xweb.util.g.fsC();
        AppMethodBeat.o(156819);
        return;
        if (paramc == c.INE)
        {
          this.INs = paramc;
          paramc = com.tencent.xweb.internal.j.g(c.INE);
          if (paramc == null) {
            break;
          }
          paramc.initWebviewCore(getContext(), null);
          break;
        }
        this.INs = getCurWebType();
        break;
      }
      i += 1;
    }
    label360:
    addView(this.INr.getWebViewUI());
    if (this.INs == c.IND) {
      if (this.INr.getX5WebViewExtension() != null)
      {
        this.isX5Kernel = true;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
      }
    }
    for (;;)
    {
      if (this.INr.getCurWebviewClient() != null) {
        this.INr.getCurWebviewClient().IMW = this.INr.getDefalutOpProvider();
      }
      if (this.INr.getCurWebChromeClient() != null) {
        this.INr.getCurWebChromeClient().IMW = this.INr.getDefalutOpProvider();
      }
      this.INr.getView().setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(156799);
          if (WebView.this.HzE != null)
          {
            boolean bool = WebView.this.HzE.onLongClick(WebView.this);
            AppMethodBeat.o(156799);
            return bool;
          }
          AppMethodBeat.o(156799);
          return false;
        }
      });
      try
      {
        this.INt = ((d)com.tencent.xweb.internal.j.g(c.INC).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
        this.INt.frk();
        if (getWebCoreType() == c.INC)
        {
          paramc = getContext();
          if ((paramc instanceof d)) {
            ((d)paramc).ING = this.INr;
          }
          com.tencent.xweb.internal.i.f(c.INC).frM();
        }
        paramc = getSettings().getUserAgentString();
        getSettings().setUserAgentString(paramc + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(156819);
        return;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        continue;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using :" + this.INs);
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          org.xwalk.core.Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
          this.INt = new d()
          {
            public final boolean aPe(String paramAnonymousString)
            {
              return false;
            }
            
            public final void frk() {}
          };
        }
      }
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(156877);
    if (getCurWebType() == c.INE) {
      com.tencent.xweb.util.f.mj("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(156877);
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(156876);
    if (getCurWebType() == c.INE) {
      com.tencent.xweb.util.f.mj("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(156876);
  }
  
  private List<TextureView> gI(View paramView)
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
          localArrayList.addAll(gI(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(156860);
    if ((INq) && (XWebCoreInfo.getCurAbiInstalledNewestVersion(XWalkEnvironment.getApplicationContext()) > 0))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has installed xweb core ");
      AppMethodBeat.o(156860);
      return true;
    }
    if ((getCurWebType() == c.INC) && (XWalkEnvironment.getAvailableVersion() > 0) && (XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has newer xweb version ");
      AppMethodBeat.o(156860);
      return true;
    }
    if (getCurWebType() == c.IND)
    {
      if (INu != null)
      {
        boolean bool = INu.getCanReboot();
        AppMethodBeat.o(156860);
        return bool;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    if (h.frN().frR())
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
    if (INu != null)
    {
      paramContext = INu.getCrashExtraMessage(paramContext);
      AppMethodBeat.o(156859);
      return paramContext;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    AppMethodBeat.o(156859);
    return "";
  }
  
  public static String getCurStrModule()
  {
    return INp;
  }
  
  public static c getCurWebType()
  {
    return INo;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156856);
    if (INu != null)
    {
      int i = INu.getTbsCoreVersion(paramContext);
      AppMethodBeat.o(156856);
      return i;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
    AppMethodBeat.o(156856);
    return 0;
  }
  
  public static c getPreferedWebviewType(Context paramContext, c paramc, String paramString)
  {
    AppMethodBeat.i(156809);
    if (INo != c.INB)
    {
      paramContext = INo;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isIaDevice())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
      com.tencent.xweb.util.g.xs(69L);
      paramContext = c.INE;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    if (x.fqR().aPc(paramString) != c.INB)
    {
      paramc = x.fqR().aPc(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(paramc)));
    }
    for (;;)
    {
      com.tencent.xweb.util.g.h(paramc);
      paramContext = paramc;
      if (paramc == c.INC)
      {
        paramContext = paramc;
        if (!XWalkEnvironment.hasAvailableVersion())
        {
          paramContext = c.INE;
          INq = true;
          XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use sys");
        }
      }
      h.d(paramContext);
      if (h.frN().frS())
      {
        XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
        paramContext = c.INE;
      }
      AppMethodBeat.o(156809);
      return paramContext;
      if (a.aOH(paramString) != c.INB)
      {
        paramc = a.aOH(paramString);
        XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + paramString + "use cmd web type = " + paramc);
      }
    }
  }
  
  public static c getPreferedWebviewType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(156808);
    paramContext = getPreferedWebviewType(paramContext, c.IND, paramString);
    AppMethodBeat.o(156808);
    return paramContext;
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156857);
    if (INu != null)
    {
      int i = INu.getTbsCoreVersion(paramContext);
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
    if (INu != null)
    {
      int i = INu.getTbsSDKVersion(paramContext);
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
    if (INo == c.IND)
    {
      if (INu != null)
      {
        int i = INu.getTbsCoreVersion(paramContext);
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
    if (getCurWebType() == c.INB)
    {
      AppMethodBeat.o(156814);
      return false;
    }
    if (com.tencent.xweb.internal.j.g(getCurWebType()) == null)
    {
      AppMethodBeat.o(156814);
      return false;
    }
    boolean bool = com.tencent.xweb.internal.j.g(getCurWebType()).hasInited();
    AppMethodBeat.o(156814);
    return bool;
  }
  
  public static void initWebviewCore(Context paramContext, c paramc, String paramString, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(156810);
    if (INo != c.INB)
    {
      if (INo != paramc) {
        org.xwalk.core.Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      AppMethodBeat.o(156810);
      return;
    }
    INp = paramString;
    com.tencent.xweb.util.g.aPv(paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    XWalkEnvironment.init(paramContext);
    r.init();
    x.kW(paramContext);
    if (XWalkEnvironment.getAvailableVersion() <= 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("initWebviewCore with no xweb, tryEmbedInstall");
      v.fqQ();
    }
    _initWebviewCore(paramContext, getPreferedWebviewType(paramContext, paramc, str), paramPreInitCallback, true);
    AppMethodBeat.o(156810);
  }
  
  public static boolean isSys()
  {
    AppMethodBeat.i(156914);
    if (getCurWebType() == c.INE)
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
    if (getCurWebType() == c.IND)
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
    if (getCurWebType() == c.INC)
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
    INo = c.INB;
    XWalkEnvironment.refreshVerInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), c.INC, INp, null);
    AppMethodBeat.o(185175);
  }
  
  public static boolean setProfileResultCallback(String paramString, j paramj)
  {
    AppMethodBeat.i(183498);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null)
    {
      boolean bool = localf.frL().setProfileResultCallback(paramString, paramj);
      AppMethodBeat.o(183498);
      return bool;
    }
    AppMethodBeat.o(183498);
    return false;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.sdk.c paramc)
  {
    INu = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(156875);
    this.INr.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(156875);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(156888);
    boolean bool = this.INr.canGoBack();
    AppMethodBeat.o(156888);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(156900);
    boolean bool = this.INr.canGoForward();
    AppMethodBeat.o(156900);
    return bool;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    AppMethodBeat.i(156817);
    org.xwalk.core.Log.d("xweb.WebView", "captureBitmap");
    this.INr.captureBitmap(parama);
    AppMethodBeat.o(156817);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(156899);
    this.INr.clearHistory();
    AppMethodBeat.o(156899);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(156847);
    this.INr.clearMatches();
    AppMethodBeat.o(156847);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(156862);
    this.INr.clearSslPreferences();
    AppMethodBeat.o(156862);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(156890);
    this.INr.clearView();
    AppMethodBeat.o(156890);
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(195163);
    WebBackForwardList localWebBackForwardList = this.INr.copyBackForwardList();
    AppMethodBeat.o(195163);
    return localWebBackForwardList;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(156891);
    this.INr.destroy();
    AppMethodBeat.o(156891);
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(156910);
    this.INr.disableVideoJsCallback(paramBoolean);
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
    this.INr.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(156894);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(156849);
    this.INr.findAllAsync(paramString);
    AppMethodBeat.o(156849);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(156848);
    this.INr.findNext(paramBoolean);
    AppMethodBeat.o(156848);
  }
  
  public String getAbstractInfo()
  {
    AppMethodBeat.i(156851);
    String str = this.INr.getAbstractInfo();
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
        localObject1 = gI(this).iterator();
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
    int i = this.INr.getContentHeight();
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
  
  public w getCurWebChromeClient()
  {
    AppMethodBeat.i(156853);
    w localw = this.INr.getCurWebChromeClient();
    AppMethodBeat.o(156853);
    return localw;
  }
  
  public ab getCurWebviewClient()
  {
    AppMethodBeat.i(156852);
    ab localab = this.INr.getCurWebviewClient();
    AppMethodBeat.o(156852);
    return localab;
  }
  
  public e getDefalutOpProvider()
  {
    return null;
  }
  
  public a getFullscreenVideoKind()
  {
    AppMethodBeat.i(156895);
    a locala = this.INr.getFullscreenVideoKind();
    AppMethodBeat.o(156895);
    return locala;
  }
  
  public b getHitTestResult()
  {
    AppMethodBeat.i(156845);
    b localb = this.INr.getHitTestResult();
    AppMethodBeat.o(156845);
    return localb;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(156916);
    boolean bool = this.INr.getImageBitmapToFile(paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(156916);
    return bool;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(156865);
    float f = this.INr.getScale();
    AppMethodBeat.o(156865);
    return f;
  }
  
  public int getScrollHeight()
  {
    AppMethodBeat.i(156907);
    int i = this.INr.getScrollHeight();
    AppMethodBeat.o(156907);
    return i;
  }
  
  public y getSettings()
  {
    AppMethodBeat.i(156878);
    y localy = this.INr.getSettings();
    AppMethodBeat.o(156878);
    return localy;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(156846);
    String str = this.INr.getTitle();
    AppMethodBeat.o(156846);
    return str;
  }
  
  public ViewGroup getTopView()
  {
    AppMethodBeat.i(156840);
    ViewGroup localViewGroup = this.INr.getTopView();
    AppMethodBeat.o(156840);
    return localViewGroup;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(156841);
    String str = this.INr.getUrl();
    AppMethodBeat.o(156841);
    return str;
  }
  
  public String getVersionInfo()
  {
    AppMethodBeat.i(156850);
    String str = this.INr.getVersionInfo();
    AppMethodBeat.o(156850);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(156839);
    View localView = this.INr.getView();
    AppMethodBeat.o(156839);
    return localView;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(156869);
    int i = this.INr.getVisibleTitleHeight();
    AppMethodBeat.o(156869);
    return i;
  }
  
  public c getWebCoreType()
  {
    return this.INs;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(156867);
    int i = this.INr.getWebScrollX();
    AppMethodBeat.o(156867);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(156866);
    int i = this.INr.getWebScrollY();
    AppMethodBeat.o(156866);
    return i;
  }
  
  public View getWebViewUI()
  {
    AppMethodBeat.i(156879);
    View localView = this.INr.getWebViewUI();
    AppMethodBeat.o(156879);
    return localView;
  }
  
  public Object getX5WebViewExtension()
  {
    AppMethodBeat.i(156820);
    Object localObject = this.INr.getX5WebViewExtension();
    AppMethodBeat.o(156820);
    return localObject;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(156889);
    this.INr.goBack();
    AppMethodBeat.o(156889);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(156901);
    this.INr.goForward();
    AppMethodBeat.o(156901);
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(156892);
    boolean bool = this.INr.hasEnteredFullscreen();
    AppMethodBeat.o(156892);
    return bool;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(156897);
    paramString = this.INr.invokeMiscMethod(paramString, paramBundle);
    AppMethodBeat.o(156897);
    return paramString;
  }
  
  public boolean isOverScrollStart()
  {
    AppMethodBeat.i(156868);
    boolean bool = this.INr.isOverScrollStart();
    AppMethodBeat.o(156868);
    return bool;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(156854);
    if (isXWalkKernel())
    {
      boolean bool = this.INr.isSupportExtendPluginForAppbrand();
      AppMethodBeat.o(156854);
      return bool;
    }
    AppMethodBeat.o(156854);
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.INs == c.INE;
  }
  
  public boolean isX5WrappedSysKernel()
  {
    AppMethodBeat.i(175639);
    if ((getCurWebType() == c.IND) && (!this.isX5Kernel))
    {
      AppMethodBeat.o(175639);
      return true;
    }
    AppMethodBeat.o(175639);
    return false;
  }
  
  public boolean isXWalkKernel()
  {
    return this.INs == c.INC;
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(156893);
    this.INr.leaveFullscreen();
    AppMethodBeat.o(156893);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156863);
    this.INr.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.g.a(paramString1, this);
    reportLoadByReason();
    AppMethodBeat.o(156863);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(156871);
    this.INr.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.g.a(paramString1, this);
    AppMethodBeat.o(156871);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(156884);
    if (this.INt.aPe(paramString))
    {
      this.INr.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156884);
      return;
    }
    this.INr.loadUrl(paramString);
    com.tencent.xweb.util.g.a(paramString, this);
    reportLoadByReason();
    AppMethodBeat.o(156884);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(156874);
    if (this.INt.aPe(paramString))
    {
      this.INr.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156874);
      return;
    }
    this.INr.loadUrl(paramString, paramMap);
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
      localf.frL().aOY("xprofile.frameCost");
    }
    AppMethodBeat.o(156886);
  }
  
  @Deprecated
  public void manualStopFrameCostProfiler(k paramk)
  {
    AppMethodBeat.i(156887);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null) {
      localf.frL().a(paramk);
    }
    AppMethodBeat.o(156887);
  }
  
  public void onHide()
  {
    AppMethodBeat.i(156906);
    this.INr.onHide();
    AppMethodBeat.o(156906);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(156830);
    this.INr.onPause();
    AppMethodBeat.o(156830);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(156829);
    this.INr.onResume();
    AppMethodBeat.o(156829);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(156905);
    this.INr.onShow();
    AppMethodBeat.o(156905);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(156833);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.INr != null) {
      this.INr.getView().setVisibility(paramInt);
    }
    AppMethodBeat.o(156833);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(156870);
    boolean bool = this.INr.overlayHorizontalScrollbar();
    AppMethodBeat.o(156870);
    return bool;
  }
  
  public void reload()
  {
    AppMethodBeat.i(156861);
    this.INr.reload();
    AppMethodBeat.o(156861);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(156842);
    this.INr.removeJavascriptInterface(paramString);
    AppMethodBeat.o(156842);
  }
  
  public void reportLoadByReason()
  {
    AppMethodBeat.i(156915);
    com.tencent.xweb.util.g.adf(this.INv);
    this.INv = -1;
    AppMethodBeat.o(156915);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(156898);
    boolean bool = this.INr.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(156898);
    return bool;
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.INv = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(156832);
    org.xwalk.core.Log.i("xweb.WebView", "setBackgroundColor color:" + Integer.toHexString(paramInt));
    super.setBackgroundColor(paramInt);
    if (this.INr != null) {
      this.INr.getWebViewUI().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(156832);
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(156904);
    this.INr.setBottomHeight(paramInt);
    AppMethodBeat.o(156904);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(156882);
    this.INr.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(156882);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(156883);
    this.INr.setFindListener(paramFindListener);
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
    this.INr.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156909);
  }
  
  public void setJSExceptionListener(ac paramac)
  {
    AppMethodBeat.i(156896);
    this.INr.setJSExceptionListener(paramac);
    AppMethodBeat.o(156896);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.HzE = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(156831);
    this.INr.getWebViewUI().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(156831);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156908);
    this.INr.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156908);
  }
  
  public t setVideoJsCallback(u paramu)
  {
    AppMethodBeat.i(156911);
    paramu = this.INr.setVideoJsCallback(paramu);
    AppMethodBeat.o(156911);
    return paramu;
  }
  
  public void setWebChromeClient(w paramw)
  {
    AppMethodBeat.i(156881);
    if (paramw != null) {
      paramw.IMW = this.INr.getDefalutOpProvider();
    }
    this.INr.setWebChromeClient(paramw);
    AppMethodBeat.o(156881);
  }
  
  public void setWebViewCallbackClient(aa paramaa)
  {
    AppMethodBeat.i(156844);
    this.INr.setWebViewCallbackClient(paramaa);
    AppMethodBeat.o(156844);
  }
  
  public void setWebViewClient(ab paramab)
  {
    AppMethodBeat.i(156880);
    if (paramab != null) {
      paramab.IMW = this.INr.getDefalutOpProvider();
    }
    this.INr.setWebViewClient(paramab);
    AppMethodBeat.o(156880);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(156821);
    this.INr.setWebViewClientExtension(parama);
    AppMethodBeat.o(156821);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(156903);
    this.INr.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(156903);
  }
  
  public void startLongScreenshot(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(156885);
    if (((this.INr instanceof com.tencent.xweb.internal.g)) && (this.INs == c.INC)) {
      ((com.tencent.xweb.internal.g)this.INr).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, paramp);
    }
    AppMethodBeat.o(156885);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(156843);
    this.INr.stopLoading();
    AppMethodBeat.o(156843);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(156826);
    this.INr.super_computeScroll();
    AppMethodBeat.o(156826);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156825);
    boolean bool = this.INr.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156825);
    return bool;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156823);
    boolean bool = this.INr.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156823);
    return bool;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156824);
    this.INr.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(156824);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156827);
    this.INr.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(156827);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156822);
    boolean bool = this.INr.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156822);
    return bool;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(156828);
    paramBoolean = this.INr.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(156828);
    return paramBoolean;
  }
  
  public boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(156902);
    boolean bool = this.INr.supportFeature(paramInt);
    AppMethodBeat.o(156902);
    return bool;
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(156873);
    boolean bool = this.INr.zoomIn();
    AppMethodBeat.o(156873);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(156872);
    boolean bool = this.INr.zoomOut();
    AppMethodBeat.o(156872);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156802);
      INx = new a("NOT_HOOK", 0);
      INy = new a("HOOK_NOT_EVALUTE_JS", 1);
      INz = new a("HOOK_EVALUTE_JS", 2);
      INA = new a[] { INx, INy, INz };
      AppMethodBeat.o(156802);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public String mExtra;
    public int mType = 0;
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(156805);
      INB = new c("WV_KIND_NONE", 0);
      INC = new c("WV_KIND_CW", 1);
      IND = new c("WV_KIND_X5", 2);
      INE = new c("WV_KIND_SYS", 3);
      INF = new c[] { INB, INC, IND, INE };
      AppMethodBeat.o(156805);
    }
    
    private c() {}
  }
  
  static final class d
    extends MutableContextWrapper
  {
    IWebView ING;
    
    public d(Context paramContext)
    {
      super();
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(156806);
      super.setBaseContext(paramContext);
      if (!x.fqR().INd) {
        af.B("BASE_CONTEXT_CHANGED", this.ING);
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