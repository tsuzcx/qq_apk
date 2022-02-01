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
  static c Mqg;
  static String Mqh;
  static boolean Mqi;
  static com.tencent.xweb.x5.sdk.c Mqm;
  View.OnLongClickListener KRn;
  IWebView Mqj;
  c Mqk;
  com.tencent.xweb.internal.d Mql;
  private int Mqn;
  public boolean isX5Kernel;
  
  static
  {
    AppMethodBeat.i(156917);
    aj.initInterface();
    Mqg = c.Mqt;
    Mqh = "";
    Mqi = false;
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
    this(paramContext, paramAttributeSet, 0, c.Mqt);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, c paramc)
  {
    super((Context)localObject, paramAttributeSet, paramInt);
    AppMethodBeat.i(156815);
    this.Mqk = c.Mqt;
    this.isX5Kernel = false;
    this.Mqn = -1;
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
    //   6: ldc 106
    //   8: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: astore 7
    //   14: aload_1
    //   15: aload_0
    //   16: aload_2
    //   17: iload 4
    //   19: invokestatic 109	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   22: ifne +84 -> 106
    //   25: aload_1
    //   26: astore 7
    //   28: iload_3
    //   29: ifeq +77 -> 106
    //   32: getstatic 57	com/tencent/xweb/WebView$c:Mqt	Lcom/tencent/xweb/WebView$c;
    //   35: astore_1
    //   36: iconst_3
    //   37: anewarray 18	com/tencent/xweb/WebView$c
    //   40: astore 8
    //   42: aload 8
    //   44: iconst_0
    //   45: getstatic 112	com/tencent/xweb/WebView$c:Mqu	Lcom/tencent/xweb/WebView$c;
    //   48: aastore
    //   49: aload 8
    //   51: iconst_1
    //   52: getstatic 115	com/tencent/xweb/WebView$c:Mqw	Lcom/tencent/xweb/WebView$c;
    //   55: aastore
    //   56: aload 8
    //   58: iconst_2
    //   59: getstatic 118	com/tencent/xweb/WebView$c:Mqv	Lcom/tencent/xweb/WebView$c;
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
    //   93: invokestatic 109	com/tencent/xweb/WebView:a	(Lcom/tencent/xweb/WebView$c;Landroid/content/Context;Lcom/tencent/xweb/WebView$PreInitCallback;Z)Z
    //   96: ifeq +54 -> 150
    //   99: aload 8
    //   101: iload 5
    //   103: aaload
    //   104: astore 7
    //   106: aload 7
    //   108: putstatic 59	com/tencent/xweb/WebView:Mqg	Lcom/tencent/xweb/WebView$c;
    //   111: getstatic 57	com/tencent/xweb/WebView$c:Mqt	Lcom/tencent/xweb/WebView$c;
    //   114: aload 7
    //   116: if_acmpne +43 -> 159
    //   119: invokestatic 123	com/tencent/xweb/util/g:gcz	()V
    //   122: ldc 125
    //   124: ldc 127
    //   126: aload 7
    //   128: invokestatic 133	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 137	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 143	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 106
    //   139: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   159: new 145	java/lang/StringBuilder
    //   162: dup
    //   163: ldc 147
    //   165: invokespecial 150	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: aload 7
    //   170: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: ldc 156
    //   175: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 165	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   181: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 175	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   190: ldc 106
    //   192: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (paramc == c.Mqv) {
      com.tencent.xweb.x5.sdk.d.gcN();
    }
    org.xwalk.core.Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(paramc)));
    if ((!paramBoolean) && (b.c(paramc)))
    {
      com.tencent.xweb.util.g.j(paramc);
      AppMethodBeat.o(156813);
      return false;
    }
    b localb = b.c("LOAD_CORE", paramc);
    localb.gbG();
    paramBoolean = bool;
    try
    {
      j.a locala = j.g(paramc);
      paramBoolean = bool;
      bool = locala.initWebviewCore(paramContext, paramPreInitCallback);
      if (bool)
      {
        paramBoolean = bool;
        c.gaw().Mpc = locala.getCookieManager();
        paramBoolean = bool;
        d.Mpe = locala.getCookieSyncManager();
        paramBoolean = bool;
        com.tencent.xweb.util.g.i(paramc);
        paramBoolean = bool;
        localb.gbH();
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
  
  private void b(c paramc)
  {
    AppMethodBeat.i(156819);
    org.xwalk.core.Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + paramc);
    if (XWalkEnvironment.getApplicationContext() == null) {
      XWalkEnvironment.init(getContext());
    }
    if (this.Mqk != c.Mqt)
    {
      AppMethodBeat.o(156819);
      return;
    }
    if (getCurWebType() == c.Mqt)
    {
      _initWebviewCore(getContext(), c.Mqw, null, true);
      org.xwalk.core.Log.e("xweb.Webview", "use xweb without init, force to use sys web");
    }
    int i;
    if (h.gbL().gbO())
    {
      this.Mqk = c.Mqw;
      XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
      this.Mqj = j.a(this.Mqk, this);
      if (this.Mqj == null)
      {
        paramc = new c[3];
        paramc[0] = c.Mqu;
        paramc[1] = c.Mqw;
        paramc[2] = c.Mqv;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < 3)
      {
        if ((paramc[i] != this.Mqk) && (_initWebviewCore(getContext(), paramc[i], null, false)))
        {
          this.Mqj = j.a(paramc[i], this);
          if (this.Mqj != null) {
            this.Mqk = getCurWebType();
          }
        }
      }
      else
      {
        if (this.Mqj == null)
        {
          a(getContext(), c.Mqw, null, false, true);
          this.Mqj = j.a(c.Mqw, this);
          this.Mqk = getCurWebType();
        }
        if (this.Mqj != null) {
          break label360;
        }
        org.xwalk.core.Log.e("xweb.WebView", "init finally failed type = " + this.Mqk);
        com.tencent.xweb.util.g.gcA();
        AppMethodBeat.o(156819);
        return;
        if (paramc == c.Mqw)
        {
          this.Mqk = paramc;
          paramc = j.g(c.Mqw);
          if (paramc == null) {
            break;
          }
          paramc.initWebviewCore(getContext(), null);
          break;
        }
        this.Mqk = getCurWebType();
        break;
      }
      i += 1;
    }
    label360:
    addView(this.Mqj.getWebViewUI());
    if (this.Mqk == c.Mqv) {
      if (this.Mqj.getX5WebViewExtension() != null)
      {
        this.isX5Kernel = true;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
      }
    }
    for (;;)
    {
      if (this.Mqj.getCurWebviewClient() != null) {
        this.Mqj.getCurWebviewClient().MpP = this.Mqj.getDefalutOpProvider();
      }
      if (this.Mqj.getCurWebChromeClient() != null) {
        this.Mqj.getCurWebChromeClient().MpP = this.Mqj.getDefalutOpProvider();
      }
      this.Mqj.getView().setOnLongClickListener(new WebView.1(this));
      try
      {
        this.Mql = ((com.tencent.xweb.internal.d)j.g(c.Mqu).excute("STR_CMD_GET_DEBUG_VIEW", new Object[] { this }));
        this.Mql.gbf();
        if (getWebCoreType() == c.Mqu)
        {
          paramc = getContext();
          if ((paramc instanceof d)) {
            ((d)paramc).Mqy = this.Mqj;
          }
          com.tencent.xweb.internal.i.f(c.Mqu).gbK();
        }
        paramc = getSettings().getUserAgentString();
        getSettings().setUserAgentString(paramc + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(156819);
        return;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        continue;
        org.xwalk.core.Log.i("xweb.WebView", "this webview instance is using :" + this.Mqk);
      }
      catch (Exception paramc)
      {
        for (;;)
        {
          org.xwalk.core.Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
          this.Mql = new com.tencent.xweb.internal.d()
          {
            public final boolean bba(String paramAnonymousString)
            {
              return false;
            }
            
            public final void gbf() {}
          };
        }
      }
    }
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    AppMethodBeat.i(156877);
    if (getCurWebType() == c.Mqw) {
      com.tencent.xweb.util.f.ni("android.webkit.WebView", "disablePlatformNotifications");
    }
    AppMethodBeat.o(156877);
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    AppMethodBeat.i(156876);
    if (getCurWebType() == c.Mqw) {
      com.tencent.xweb.util.f.ni("android.webkit.WebView", "enablePlatformNotifications");
    }
    AppMethodBeat.o(156876);
  }
  
  public static boolean getCanReboot()
  {
    AppMethodBeat.i(156860);
    if ((Mqi) && (XWebCoreInfo.getCurAbiInstalledNewestVersion(XWalkEnvironment.getApplicationContext()) > 0))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has installed xweb core ");
      AppMethodBeat.o(156860);
      return true;
    }
    if ((getCurWebType() == c.Mqu) && (XWalkEnvironment.getAvailableVersion() > 0) && (XWalkEnvironment.getInstalledNewstVersionForCurAbi() > XWalkEnvironment.getAvailableVersion()))
    {
      org.xwalk.core.Log.i("xweb.WebView", "need rebot because of has newer xweb version ");
      AppMethodBeat.o(156860);
      return true;
    }
    if (getCurWebType() == c.Mqv)
    {
      if (Mqm != null)
      {
        boolean bool = Mqm.getCanReboot();
        AppMethodBeat.o(156860);
        return bool;
      }
      org.xwalk.core.Log.e("xweb.WebView", "getCanReboot: sImp is null");
    }
    if (h.gbL().gbP())
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
    if (Mqm != null)
    {
      paramContext = Mqm.getCrashExtraMessage(paramContext);
      AppMethodBeat.o(156859);
      return paramContext;
    }
    org.xwalk.core.Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
    AppMethodBeat.o(156859);
    return "";
  }
  
  public static String getCurStrModule()
  {
    return Mqh;
  }
  
  public static c getCurWebType()
  {
    return Mqg;
  }
  
  public static int getInstalledTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156856);
    if (Mqm != null)
    {
      int i = Mqm.getTbsCoreVersion(paramContext);
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
    if (Mqg != c.Mqt)
    {
      paramContext = Mqg;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isIaDevice())
    {
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
      com.tencent.xweb.util.g.Fh(69L);
      paramContext = c.Mqw;
      AppMethodBeat.o(156809);
      return paramContext;
    }
    if (y.gaM().baY(paramString) != c.Mqt)
    {
      paramc = y.gaM().baY(paramString);
      XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(paramc)));
    }
    for (;;)
    {
      com.tencent.xweb.util.g.h(paramc);
      paramContext = paramc;
      if (paramc == c.Mqu)
      {
        paramContext = paramc;
        if (!XWalkEnvironment.hasAvailableVersion())
        {
          paramContext = c.Mqw;
          Mqi = true;
          XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use sys");
        }
      }
      h.d(paramContext);
      if (h.gbL().gbQ())
      {
        XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
        paramContext = c.Mqw;
      }
      if (paramContext == c.Mqv) {
        com.tencent.xweb.x5.sdk.d.gcN();
      }
      AppMethodBeat.o(156809);
      return paramContext;
      if (a.baw(paramString) != c.Mqt)
      {
        paramc = a.baw(paramString);
        XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + paramString + "use cmd web type = " + paramc);
      }
    }
  }
  
  public static c getPreferedWebviewType(Context paramContext, String paramString)
  {
    AppMethodBeat.i(156808);
    paramContext = getPreferedWebviewType(paramContext, c.Mqv, paramString);
    AppMethodBeat.o(156808);
    return paramContext;
  }
  
  @Deprecated
  public static int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(156857);
    if (Mqm != null)
    {
      int i = Mqm.getTbsCoreVersion(paramContext);
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
    if (Mqm != null)
    {
      int i = Mqm.getTbsSDKVersion(paramContext);
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
    if (Mqg == c.Mqv)
    {
      if (Mqm != null)
      {
        int i = Mqm.getTbsCoreVersion(paramContext);
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
    if (getCurWebType() == c.Mqt)
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
  
  private List<TextureView> hr(View paramView)
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
          localArrayList.addAll(hr(paramView.getChildAt(i)));
          i += 1;
        }
      }
    }
  }
  
  public static void initWebviewCore(Context paramContext, c paramc, String paramString, WebView.PreInitCallback paramPreInitCallback)
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
    if (Mqg != c.Mqt)
    {
      if (Mqg != paramc) {
        org.xwalk.core.Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
      }
      AppMethodBeat.o(156810);
      return;
    }
    Mqh = str;
    com.tencent.xweb.util.g.bbr(str);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    XWalkEnvironment.init(paramContext);
    s.init();
    y.lx(paramContext);
    if (XWalkEnvironment.getAvailableVersion() <= 0)
    {
      XWalkEnvironment.addXWalkInitializeLog("initWebviewCore with no xweb, tryEmbedInstall");
      w.gaK();
    }
    _initWebviewCore(paramContext, getPreferedWebviewType(paramContext, paramc, paramString), paramPreInitCallback, true);
    AppMethodBeat.o(156810);
  }
  
  public static boolean isSys()
  {
    AppMethodBeat.i(156914);
    if (getCurWebType() == c.Mqw)
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
    if (getCurWebType() == c.Mqv)
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
    if (getCurWebType() == c.Mqu)
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
    Mqg = c.Mqt;
    XWalkEnvironment.refreshVerInfo();
    initWebviewCore(XWalkEnvironment.getApplicationContext(), c.Mqu, Mqh, null);
    AppMethodBeat.o(185175);
  }
  
  public static boolean setProfileResultCallback(String paramString, k paramk)
  {
    AppMethodBeat.i(183498);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null)
    {
      boolean bool = localf.gbJ().setProfileResultCallback(paramString, paramk);
      AppMethodBeat.o(183498);
      return bool;
    }
    AppMethodBeat.o(183498);
    return false;
  }
  
  public static void setX5Interface(com.tencent.xweb.x5.sdk.c paramc)
  {
    Mqm = paramc;
  }
  
  public void _disablePlatformNotifications() {}
  
  public void _enablePlatformNotifications() {}
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(156875);
    this.Mqj.addJavascriptInterface(paramObject, paramString);
    AppMethodBeat.o(156875);
  }
  
  public boolean canGoBack()
  {
    AppMethodBeat.i(156888);
    boolean bool = this.Mqj.canGoBack();
    AppMethodBeat.o(156888);
    return bool;
  }
  
  public boolean canGoForward()
  {
    AppMethodBeat.i(156900);
    boolean bool = this.Mqj.canGoForward();
    AppMethodBeat.o(156900);
    return bool;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    AppMethodBeat.i(156817);
    org.xwalk.core.Log.d("xweb.WebView", "captureBitmap");
    this.Mqj.captureBitmap(parama);
    AppMethodBeat.o(156817);
  }
  
  public void clearHistory()
  {
    AppMethodBeat.i(156899);
    this.Mqj.clearHistory();
    AppMethodBeat.o(156899);
  }
  
  public void clearMatches()
  {
    AppMethodBeat.i(156847);
    this.Mqj.clearMatches();
    AppMethodBeat.o(156847);
  }
  
  public void clearSslPreferences()
  {
    AppMethodBeat.i(156862);
    this.Mqj.clearSslPreferences();
    AppMethodBeat.o(156862);
  }
  
  public void clearView()
  {
    AppMethodBeat.i(156890);
    this.Mqj.clearView();
    AppMethodBeat.o(156890);
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    AppMethodBeat.i(197078);
    WebBackForwardList localWebBackForwardList = this.Mqj.copyBackForwardList();
    AppMethodBeat.o(197078);
    return localWebBackForwardList;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(156891);
    this.Mqj.destroy();
    AppMethodBeat.o(156891);
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(156910);
    this.Mqj.disableVideoJsCallback(paramBoolean);
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
    this.Mqj.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(156894);
  }
  
  public void findAllAsync(String paramString)
  {
    AppMethodBeat.i(156849);
    this.Mqj.findAllAsync(paramString);
    AppMethodBeat.o(156849);
  }
  
  public void findNext(boolean paramBoolean)
  {
    AppMethodBeat.i(156848);
    this.Mqj.findNext(paramBoolean);
    AppMethodBeat.o(156848);
  }
  
  public String getAbstractInfo()
  {
    AppMethodBeat.i(156851);
    String str = this.Mqj.getAbstractInfo();
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
        localObject1 = hr(this).iterator();
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
    int i = this.Mqj.getContentHeight();
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
    x localx = this.Mqj.getCurWebChromeClient();
    AppMethodBeat.o(156853);
    return localx;
  }
  
  public ac getCurWebviewClient()
  {
    AppMethodBeat.i(156852);
    ac localac = this.Mqj.getCurWebviewClient();
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
    a locala = this.Mqj.getFullscreenVideoKind();
    AppMethodBeat.o(156895);
    return locala;
  }
  
  public b getHitTestResult()
  {
    AppMethodBeat.i(156845);
    b localb = this.Mqj.getHitTestResult();
    AppMethodBeat.o(156845);
    return localb;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    AppMethodBeat.i(197080);
    paramString1 = this.Mqj.getHttpAuthUsernamePassword(paramString1, paramString2);
    AppMethodBeat.o(197080);
    return paramString1;
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, i parami)
  {
    AppMethodBeat.i(156916);
    boolean bool = this.Mqj.getImageBitmapToFile(paramString1, paramString2, paramString3, parami);
    AppMethodBeat.o(156916);
    return bool;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(156865);
    float f = this.Mqj.getScale();
    AppMethodBeat.o(156865);
    return f;
  }
  
  public int getScrollHeight()
  {
    AppMethodBeat.i(156907);
    int i = this.Mqj.getScrollHeight();
    AppMethodBeat.o(156907);
    return i;
  }
  
  public z getSettings()
  {
    AppMethodBeat.i(156878);
    z localz = this.Mqj.getSettings();
    AppMethodBeat.o(156878);
    return localz;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(156846);
    String str = this.Mqj.getTitle();
    AppMethodBeat.o(156846);
    return str;
  }
  
  public ViewGroup getTopView()
  {
    AppMethodBeat.i(156840);
    ViewGroup localViewGroup = this.Mqj.getTopView();
    AppMethodBeat.o(156840);
    return localViewGroup;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(156841);
    String str = this.Mqj.getUrl();
    AppMethodBeat.o(156841);
    return str;
  }
  
  public String getVersionInfo()
  {
    AppMethodBeat.i(156850);
    String str = this.Mqj.getVersionInfo();
    AppMethodBeat.o(156850);
    return str;
  }
  
  public View getView()
  {
    AppMethodBeat.i(156839);
    View localView = this.Mqj.getView();
    AppMethodBeat.o(156839);
    return localView;
  }
  
  public int getVisibleTitleHeight()
  {
    AppMethodBeat.i(156869);
    int i = this.Mqj.getVisibleTitleHeight();
    AppMethodBeat.o(156869);
    return i;
  }
  
  public c getWebCoreType()
  {
    return this.Mqk;
  }
  
  public int getWebScrollX()
  {
    AppMethodBeat.i(156867);
    int i = this.Mqj.getWebScrollX();
    AppMethodBeat.o(156867);
    return i;
  }
  
  public int getWebScrollY()
  {
    AppMethodBeat.i(156866);
    int i = this.Mqj.getWebScrollY();
    AppMethodBeat.o(156866);
    return i;
  }
  
  public View getWebViewUI()
  {
    AppMethodBeat.i(156879);
    View localView = this.Mqj.getWebViewUI();
    AppMethodBeat.o(156879);
    return localView;
  }
  
  public Object getX5WebViewExtension()
  {
    AppMethodBeat.i(156820);
    Object localObject = this.Mqj.getX5WebViewExtension();
    AppMethodBeat.o(156820);
    return localObject;
  }
  
  public void goBack()
  {
    AppMethodBeat.i(156889);
    this.Mqj.goBack();
    AppMethodBeat.o(156889);
  }
  
  public void goForward()
  {
    AppMethodBeat.i(156901);
    this.Mqj.goForward();
    AppMethodBeat.o(156901);
  }
  
  public boolean hasEnteredFullscreen()
  {
    AppMethodBeat.i(156892);
    boolean bool = this.Mqj.hasEnteredFullscreen();
    AppMethodBeat.o(156892);
    return bool;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(156897);
    paramString = this.Mqj.invokeMiscMethod(paramString, paramBundle);
    AppMethodBeat.o(156897);
    return paramString;
  }
  
  public boolean isOverScrollStart()
  {
    AppMethodBeat.i(156868);
    boolean bool = this.Mqj.isOverScrollStart();
    AppMethodBeat.o(156868);
    return bool;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    AppMethodBeat.i(156854);
    if (isXWalkKernel())
    {
      boolean bool = this.Mqj.isSupportExtendPluginForAppbrand();
      AppMethodBeat.o(156854);
      return bool;
    }
    AppMethodBeat.o(156854);
    return false;
  }
  
  public boolean isSysKernel()
  {
    return this.Mqk == c.Mqw;
  }
  
  public boolean isX5WrappedSysKernel()
  {
    AppMethodBeat.i(175639);
    if ((getCurWebType() == c.Mqv) && (!this.isX5Kernel))
    {
      AppMethodBeat.o(175639);
      return true;
    }
    AppMethodBeat.o(175639);
    return false;
  }
  
  public boolean isXWalkKernel()
  {
    return this.Mqk == c.Mqu;
  }
  
  public void leaveFullscreen()
  {
    AppMethodBeat.i(156893);
    this.Mqj.leaveFullscreen();
    AppMethodBeat.o(156893);
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156863);
    this.Mqj.loadData(paramString1, paramString2, paramString3);
    com.tencent.xweb.util.g.a(paramString1, this);
    reportLoadByReason();
    AppMethodBeat.o(156863);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(156871);
    this.Mqj.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    com.tencent.xweb.util.g.a(paramString1, this);
    AppMethodBeat.o(156871);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(156884);
    if (this.Mql.bba(paramString))
    {
      this.Mqj.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156884);
      return;
    }
    this.Mqj.loadUrl(paramString);
    com.tencent.xweb.util.g.a(paramString, this);
    reportLoadByReason();
    AppMethodBeat.o(156884);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(156874);
    if (this.Mql.bba(paramString))
    {
      this.Mqj.loadUrl("http://weixin.qq.com/");
      AppMethodBeat.o(156874);
      return;
    }
    this.Mqj.loadUrl(paramString, paramMap);
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
      localf.gbJ().baU("xprofile.frameCost");
    }
    AppMethodBeat.o(156886);
  }
  
  @Deprecated
  public void manualStopFrameCostProfiler(l paraml)
  {
    AppMethodBeat.i(156887);
    com.tencent.xweb.internal.f localf = com.tencent.xweb.internal.i.f(getCurWebType());
    if (localf != null) {
      localf.gbJ().a(paraml);
    }
    AppMethodBeat.o(156887);
  }
  
  public void onHide()
  {
    AppMethodBeat.i(156906);
    this.Mqj.onHide();
    AppMethodBeat.o(156906);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(156830);
    this.Mqj.onPause();
    AppMethodBeat.o(156830);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(156829);
    this.Mqj.onResume();
    AppMethodBeat.o(156829);
  }
  
  public void onShow()
  {
    AppMethodBeat.i(156905);
    this.Mqj.onShow();
    AppMethodBeat.o(156905);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    AppMethodBeat.i(156833);
    super.onVisibilityChanged(paramView, paramInt);
    if (this.Mqj != null) {
      this.Mqj.getView().setVisibility(paramInt);
    }
    AppMethodBeat.o(156833);
  }
  
  public void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean overlayHorizontalScrollbar()
  {
    AppMethodBeat.i(156870);
    boolean bool = this.Mqj.overlayHorizontalScrollbar();
    AppMethodBeat.o(156870);
    return bool;
  }
  
  public void reload()
  {
    AppMethodBeat.i(156861);
    this.Mqj.reload();
    AppMethodBeat.o(156861);
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    AppMethodBeat.i(156842);
    this.Mqj.removeJavascriptInterface(paramString);
    AppMethodBeat.o(156842);
  }
  
  public void reportLoadByReason()
  {
    AppMethodBeat.i(156915);
    com.tencent.xweb.util.g.aiD(this.Mqn);
    this.Mqn = -1;
    AppMethodBeat.o(156915);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(156898);
    boolean bool = this.Mqj.savePage(paramString1, paramString2, paramInt);
    AppMethodBeat.o(156898);
    return bool;
  }
  
  public void setA8keyReason(int paramInt)
  {
    this.Mqn = paramInt;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(156832);
    org.xwalk.core.Log.i("xweb.WebView", "setBackgroundColor color:" + Integer.toHexString(paramInt));
    super.setBackgroundColor(paramInt);
    if (this.Mqj != null) {
      this.Mqj.getWebViewUI().setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(156832);
  }
  
  public void setBottomHeight(int paramInt)
  {
    AppMethodBeat.i(156904);
    this.Mqj.setBottomHeight(paramInt);
    AppMethodBeat.o(156904);
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    AppMethodBeat.i(156882);
    this.Mqj.setDownloadListener(paramDownloadListener);
    AppMethodBeat.o(156882);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    AppMethodBeat.i(156883);
    this.Mqj.setFindListener(paramFindListener);
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
    this.Mqj.setHorizontalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156909);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(197079);
    this.Mqj.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
    AppMethodBeat.o(197079);
  }
  
  public void setJSExceptionListener(ae paramae)
  {
    AppMethodBeat.i(156896);
    this.Mqj.setJSExceptionListener(paramae);
    AppMethodBeat.o(156896);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.KRn = paramOnLongClickListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(156831);
    this.Mqj.getWebViewUI().setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(156831);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(156908);
    this.Mqj.setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(156908);
  }
  
  public u setVideoJsCallback(v paramv)
  {
    AppMethodBeat.i(156911);
    paramv = this.Mqj.setVideoJsCallback(paramv);
    AppMethodBeat.o(156911);
    return paramv;
  }
  
  public void setWebChromeClient(x paramx)
  {
    AppMethodBeat.i(156881);
    if (paramx != null) {
      paramx.MpP = this.Mqj.getDefalutOpProvider();
    }
    this.Mqj.setWebChromeClient(paramx);
    AppMethodBeat.o(156881);
  }
  
  public void setWebViewCallbackClient(ab paramab)
  {
    AppMethodBeat.i(156844);
    this.Mqj.setWebViewCallbackClient(paramab);
    AppMethodBeat.o(156844);
  }
  
  public void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(156880);
    if (paramac != null) {
      paramac.MpP = this.Mqj.getDefalutOpProvider();
    }
    this.Mqj.setWebViewClient(paramac);
    AppMethodBeat.o(156880);
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama)
  {
    AppMethodBeat.i(156821);
    this.Mqj.setWebViewClientExtension(parama);
    AppMethodBeat.o(156821);
  }
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(156903);
    this.Mqj.smoothScroll(paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(156903);
  }
  
  public void startLongScreenshot(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(156885);
    if (((this.Mqj instanceof com.tencent.xweb.internal.g)) && (this.Mqk == c.Mqu)) {
      ((com.tencent.xweb.internal.g)this.Mqj).a(((ViewGroup)getWebViewUI()).getChildAt(0), paramBoolean, paramq);
    }
    AppMethodBeat.o(156885);
  }
  
  public void stopLoading()
  {
    AppMethodBeat.i(156843);
    this.Mqj.stopLoading();
    AppMethodBeat.o(156843);
  }
  
  public void super_computeScroll()
  {
    AppMethodBeat.i(156826);
    this.Mqj.super_computeScroll();
    AppMethodBeat.o(156826);
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156825);
    boolean bool = this.Mqj.super_dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156825);
    return bool;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156823);
    boolean bool = this.Mqj.super_onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156823);
    return bool;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156824);
    this.Mqj.super_onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(156824);
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(156827);
    this.Mqj.super_onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(156827);
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(156822);
    boolean bool = this.Mqj.super_onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(156822);
    return bool;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    AppMethodBeat.i(156828);
    paramBoolean = this.Mqj.super_overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    AppMethodBeat.o(156828);
    return paramBoolean;
  }
  
  public boolean supportFeature(int paramInt)
  {
    AppMethodBeat.i(156902);
    boolean bool = this.Mqj.supportFeature(paramInt);
    AppMethodBeat.o(156902);
    return bool;
  }
  
  public boolean zoomIn()
  {
    AppMethodBeat.i(156873);
    boolean bool = this.Mqj.zoomIn();
    AppMethodBeat.o(156873);
    return bool;
  }
  
  public boolean zoomOut()
  {
    AppMethodBeat.i(156872);
    boolean bool = this.Mqj.zoomOut();
    AppMethodBeat.o(156872);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(156802);
      Mqp = new a("NOT_HOOK", 0);
      Mqq = new a("HOOK_NOT_EVALUTE_JS", 1);
      Mqr = new a("HOOK_EVALUTE_JS", 2);
      Mqs = new a[] { Mqp, Mqq, Mqr };
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
      Mqt = new c("WV_KIND_NONE", 0);
      Mqu = new c("WV_KIND_CW", 1);
      Mqv = new c("WV_KIND_X5", 2);
      Mqw = new c("WV_KIND_SYS", 3);
      Mqx = new c[] { Mqt, Mqu, Mqv, Mqw };
      AppMethodBeat.o(156805);
    }
    
    private c() {}
  }
  
  static final class d
    extends MutableContextWrapper
  {
    IWebView Mqy;
    
    public d(Context paramContext)
    {
      super();
    }
    
    public final void setBaseContext(Context paramContext)
    {
      AppMethodBeat.i(156806);
      super.setBaseContext(paramContext);
      if (!y.gaM().MpW) {
        ah.B("BASE_CONTEXT_CHANGED", this.Mqy);
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