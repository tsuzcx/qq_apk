package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.af;
import com.tencent.xweb.b;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.j.a;
import com.tencent.xweb.r;
import com.tencent.xweb.r.a;
import com.tencent.xweb.s;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.a.a;
import java.lang.reflect.Method;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory
  implements j.a
{
  private static final String TAG = "XWalkWebFactory";
  static XWalkWebFactory sInstance;
  private boolean mIsDebugMode;
  private boolean mIsDebugModeReplase;
  
  private XWalkWebFactory()
  {
    AppMethodBeat.i(185205);
    this.mIsDebugMode = false;
    this.mIsDebugModeReplase = false;
    r.a(new a((byte)0));
    AppMethodBeat.o(185205);
  }
  
  public static XWalkWebFactory getInstance()
  {
    AppMethodBeat.i(154485);
    if (sInstance == null)
    {
      af.frp();
      sInstance = new XWalkWebFactory();
    }
    XWalkWebFactory localXWalkWebFactory = sInstance;
    AppMethodBeat.o(154485);
    return localXWalkWebFactory;
  }
  
  /* Error */
  public static boolean tryLoadLocalAssetRuntime(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 68
    //   7: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 74	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   14: iload_1
    //   15: ifeq +17 -> 32
    //   18: invokestatic 78	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   21: ldc 79
    //   23: if_icmpne +9 -> 32
    //   26: ldc 79
    //   28: invokestatic 83	org/xwalk/core/XWalkEnvironment:delApiVersion	(I)Z
    //   31: pop
    //   32: invokestatic 78	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   35: istore_2
    //   36: iload_2
    //   37: iconst_m1
    //   38: if_icmpeq +7 -> 45
    //   41: iload_1
    //   42: ifeq +106 -> 148
    //   45: aload_0
    //   46: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   49: ldc 91
    //   51: invokevirtual 97	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 4
    //   56: new 99	java/io/File
    //   59: dup
    //   60: ldc 79
    //   62: invokestatic 103	org/xwalk/core/XWalkEnvironment:getDownloadZipDir	(I)Ljava/lang/String;
    //   65: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: aload 5
    //   72: invokevirtual 110	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: aload 5
    //   80: invokevirtual 113	java/io/File:delete	()Z
    //   83: pop
    //   84: new 115	java/io/FileOutputStream
    //   87: dup
    //   88: aload 5
    //   90: invokespecial 118	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore 5
    //   95: ldc 119
    //   97: newarray byte
    //   99: astore 6
    //   101: aload 4
    //   103: aload 6
    //   105: invokevirtual 125	java/io/InputStream:read	([B)I
    //   108: istore_2
    //   109: iload_2
    //   110: iconst_m1
    //   111: if_icmpeq +49 -> 160
    //   114: aload 5
    //   116: aload 6
    //   118: iconst_0
    //   119: iload_2
    //   120: invokevirtual 129	java/io/FileOutputStream:write	([BII)V
    //   123: goto -22 -> 101
    //   126: astore_0
    //   127: aload 5
    //   129: astore_0
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 132	java/io/InputStream:close	()V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   148: ldc 68
    //   150: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: istore_1
    //   155: ldc 2
    //   157: monitorexit
    //   158: iload_1
    //   159: ireturn
    //   160: aload 5
    //   162: invokevirtual 136	java/io/FileOutputStream:flush	()V
    //   165: invokestatic 141	org/xwalk/core/XWalkUpdater:updateLocalXWalkRuntime	()V
    //   168: invokestatic 144	org/xwalk/core/XWalkEnvironment:resetForDebug	()V
    //   171: aload_0
    //   172: invokestatic 74	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 132	java/io/InputStream:close	()V
    //   185: aload 5
    //   187: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   190: iconst_1
    //   191: istore_1
    //   192: ldc 68
    //   194: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: goto -42 -> 155
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore_0
    //   207: aconst_null
    //   208: astore 5
    //   210: aconst_null
    //   211: astore 4
    //   213: aload 4
    //   215: ifnull +8 -> 223
    //   218: aload 4
    //   220: invokevirtual 132	java/io/InputStream:close	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   233: ldc 68
    //   235: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: goto -56 -> 185
    //   244: astore_0
    //   245: goto -55 -> 190
    //   248: astore 4
    //   250: goto -110 -> 140
    //   253: astore_0
    //   254: goto -106 -> 148
    //   257: astore 4
    //   259: goto -36 -> 223
    //   262: astore 4
    //   264: goto -31 -> 233
    //   267: astore_0
    //   268: aconst_null
    //   269: astore 5
    //   271: goto -58 -> 213
    //   274: astore_0
    //   275: goto -62 -> 213
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_0
    //   281: aconst_null
    //   282: astore 4
    //   284: goto -154 -> 130
    //   287: astore_0
    //   288: aconst_null
    //   289: astore_0
    //   290: goto -160 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramContext	Context
    //   0	293	1	paramBoolean	boolean
    //   35	85	2	i	int
    //   1	153	3	bool	boolean
    //   54	165	4	localInputStream	java.io.InputStream
    //   248	1	4	localException1	Exception
    //   257	1	4	localException2	Exception
    //   262	1	4	localException3	Exception
    //   282	1	4	localObject1	Object
    //   68	202	5	localObject2	Object
    //   99	18	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   95	101	126	java/io/IOException
    //   101	109	126	java/io/IOException
    //   114	123	126	java/io/IOException
    //   160	175	126	java/io/IOException
    //   5	14	200	finally
    //   18	32	200	finally
    //   32	36	200	finally
    //   135	140	200	finally
    //   144	148	200	finally
    //   148	153	200	finally
    //   180	185	200	finally
    //   185	190	200	finally
    //   192	197	200	finally
    //   218	223	200	finally
    //   228	233	200	finally
    //   233	240	200	finally
    //   45	56	206	finally
    //   180	185	240	java/lang/Exception
    //   185	190	244	java/lang/Exception
    //   135	140	248	java/lang/Exception
    //   144	148	253	java/lang/Exception
    //   218	223	257	java/lang/Exception
    //   228	233	262	java/lang/Exception
    //   56	84	267	finally
    //   84	95	267	finally
    //   95	101	274	finally
    //   101	109	274	finally
    //   114	123	274	finally
    //   160	175	274	finally
    //   45	56	278	java/io/IOException
    //   56	84	287	java/io/IOException
    //   84	95	287	java/io/IOException
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(154496);
    if (WebView.getCurWebType() != WebView.c.INC)
    {
      AppMethodBeat.o(154496);
      return;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i <= 0)
      {
        AppMethodBeat.o(154496);
        return;
      }
      paramContext = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
      paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
      paramContext.removeJavascriptInterface("accessibility");
      paramContext.removeJavascriptInterface("accessibilityTraversal");
      paramContext.clearCache(true);
      XWalkViewDatabase.clearFormData();
      if (paramBoolean)
      {
        paramContext = getCookieManager();
        if (paramContext != null) {
          paramContext.removeAllCookie();
        }
      }
      AppMethodBeat.o(154496);
      return;
    }
    catch (Throwable paramContext)
    {
      org.xwalk.core.Log.e("XWalkWebFactory", "clearAllWebViewCache exception 1 -- " + paramContext.getMessage());
      AppMethodBeat.o(154496);
    }
  }
  
  public IWebView createWebView(WebView paramWebView)
  {
    AppMethodBeat.i(154487);
    try
    {
      if (j.gX(paramWebView.getContext()))
      {
        WebViewExtension.updateExtension(false);
        paramWebView = new j(paramWebView);
        AppMethodBeat.o(154487);
        return paramWebView;
      }
    }
    catch (Exception paramWebView)
    {
      paramWebView = "init xwalk crashed:" + paramWebView.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(paramWebView);
      org.xwalk.core.Log.e("XWalkWebFactory", paramWebView);
      XWalkInitializer.addXWalkInitializeLog(paramWebView);
      AppMethodBeat.o(154487);
    }
    return null;
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(154499);
    i locali = new i();
    AppMethodBeat.o(154499);
    return locali;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154486);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(154486);
      return null;
    }
    if (paramString.equals("STR_CMD_INVOKE_TO_RUNTIME"))
    {
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2))
      {
        AppMethodBeat.o(154486);
        return null;
      }
      try
      {
        if (XWalkCoreWrapper.getInstance() != null)
        {
          paramString = XWalkCoreWrapper.invokeRuntimeChannel(((Integer)paramArrayOfObject[0]).intValue(), (Object[])paramArrayOfObject[1]);
          AppMethodBeat.o(154486);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        org.xwalk.core.Log.e("XWalkWebFactory", "STR_CMD_INVOKE_TO_RUNTIME failed , err = " + paramString.getMessage());
      }
    }
    label796:
    label799:
    for (;;)
    {
      AppMethodBeat.o(154486);
      return null;
      if (paramString.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG"))
      {
        if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
        {
          AppMethodBeat.o(154486);
          return null;
        }
        paramString = a.ey(paramArrayOfObject[0]);
        AppMethodBeat.o(154486);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_DEBUG_VIEW"))
      {
        paramString = new c((WebView)paramArrayOfObject[0]);
        AppMethodBeat.o(154486);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_UPDATER"))
      {
        paramString = new o.a();
        AppMethodBeat.o(154486);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_PLUGIN_UPDATER"))
      {
        paramString = new com.tencent.xweb.xwalk.a.i();
        AppMethodBeat.o(154486);
        return paramString;
      }
      if (paramString.equals("STR_CMD_CLEAR_SCHEDULER"))
      {
        Scheduler.a(null);
        AppMethodBeat.o(154486);
        return null;
      }
      if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE"))
      {
        this.mIsDebugMode = true;
        this.mIsDebugModeReplase = true;
      }
      else if (paramString.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE"))
      {
        this.mIsDebugMode = true;
        this.mIsDebugModeReplase = false;
      }
      else if (paramString.equals("STR_CMD_SET_RECHECK_COMMAND"))
      {
        try
        {
          paramString = com.tencent.xweb.xwalk.updater.a.aPF(XWalkEnvironment.getUpdateConfigFullPath());
          if (paramString == null)
          {
            XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
            AppMethodBeat.o(154486);
            return null;
          }
          com.tencent.xweb.a.a(paramString.IVp, paramString.IVn, true);
          g.xs(68L);
        }
        catch (Exception paramString)
        {
          XWalkEnvironment.addXWalkInitializeLog("recheck cmds failed , " + paramString.getMessage());
        }
      }
      else if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW"))
      {
        tryLoadLocalAssetRuntime((Context)paramArrayOfObject[0], true);
        c.hr((Context)paramArrayOfObject[0]);
      }
      else
      {
        if (paramString.equals("BASE_CONTEXT_CHANGED")) {
          if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0) || (!(paramArrayOfObject[0] instanceof j))) {
            break label796;
          }
        }
        for (paramString = (j)paramArrayOfObject[0];; paramString = null)
        {
          for (;;)
          {
            for (;;)
            {
              if ((paramString == null) || (XWalkCoreWrapper.getInstance() == null)) {
                break label799;
              }
              if (paramString.ITM == null) {
                org.xwalk.core.Log.e("XWWebView", "getXWalkBridge mwebview == null");
              }
              for (paramString = null;; paramString = paramString.ITM.getBridge())
              {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(80001, new Object[] { paramString });
                break;
              }
              if (paramString.equals("STR_CMD_FEATURE_SUPPORT"))
              {
                boolean bool = XWalkCoreWrapper.hasFeatureStatic(((Integer)paramArrayOfObject[0]).intValue());
                AppMethodBeat.o(154486);
                return Boolean.valueOf(bool);
              }
              if (paramString.equals("STR_CMD_NATIVE_TRANS_INIT"))
              {
                if (paramArrayOfObject.length != 1)
                {
                  AppMethodBeat.o(154486);
                  return null;
                }
                XWalkCoreWrapper.bindNativeTrans(((Long)paramArrayOfObject[0]).longValue());
                break;
              }
              if (!paramString.equals("STR_CMD_FORCE_DARK_MODE_COMMAND")) {
                break label699;
              }
              try
              {
                if (XWalkCoreWrapper.getInstance() == null) {
                  break;
                }
                XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkMode", new Class[] { Boolean.TYPE }).invoke(null, new Object[] { Boolean.valueOf(((Boolean)paramArrayOfObject[0]).booleanValue()) });
              }
              catch (Exception paramString)
              {
                org.xwalk.core.Log.e("XWalkWebFactory", "XWalkSettingsInternal setWeChatDefaultForceDarkMode error:" + paramString.getMessage());
              }
            }
            break;
            label699:
            if (!paramString.equals("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND")) {
              break;
            }
            try
            {
              if (XWalkCoreWrapper.getInstance() == null) {
                break;
              }
              XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkBehavior", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(((Integer)paramArrayOfObject[0]).intValue()) });
            }
            catch (Exception paramString)
            {
              org.xwalk.core.Log.e("XWalkWebFactory", "XWalkSettingsInternal setWeChatDefaultForceDarkBehavior error:" + paramString.getMessage());
            }
          }
          break;
        }
      }
    }
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(154497);
    d locald = new d();
    AppMethodBeat.o(154497);
    return locald;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(154498);
    e locale = new e();
    AppMethodBeat.o(154498);
    return locale;
  }
  
  public IJsRuntime getJsCore(JsRuntime.JsRuntimeType paramJsRuntimeType, Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(154490);
    initWebviewCore(paramContext, null);
    switch (1.ISl[paramJsRuntimeType.ordinal()])
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(154490);
      return paramContext;
      paramContext = localObject;
      if (com.tencent.xweb.xwalk.updater.d.isXWalkReady()) {
        if (paramJsRuntimeType == JsRuntime.JsRuntimeType.IMJ)
        {
          paramContext = new h();
          paramContext.init(0);
        }
        else
        {
          paramContext = localObject;
          if (paramJsRuntimeType == JsRuntime.JsRuntimeType.IMK)
          {
            paramContext = new h();
            paramContext.init(1);
          }
        }
      }
    }
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(154493);
    boolean bool = b.hasInited();
    AppMethodBeat.o(154493);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(154494);
    boolean bool = b.hasInitedCallback();
    AppMethodBeat.o(154494);
    return bool;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(154492);
    b.initCallback(paramWebViewExtensionListener);
    AppMethodBeat.o(154492);
  }
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(154488);
    if (this.mIsDebugMode) {
      tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplase);
    }
    AppMethodBeat.o(154488);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(183744);
    com.tencent.xweb.internal.i.a(WebView.c.INC, new m());
    AppMethodBeat.o(183744);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(154491);
    boolean bool = b.ld(paramContext);
    if (paramPreInitCallback != null)
    {
      if (!bool) {
        break label33;
      }
      paramPreInitCallback.onCoreInitFinished();
    }
    for (;;)
    {
      AppMethodBeat.o(154491);
      return bool;
      label33:
      paramPreInitCallback.aNK();
    }
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(154495);
    boolean bool = b.isCoreReady();
    AppMethodBeat.o(154495);
    return bool;
  }
  
  static final class a
    implements r.a
  {
    public final void bvj()
    {
      AppMethodBeat.i(185203);
      if (!"true".equalsIgnoreCase(com.tencent.xweb.a.lW("dis_refresh_main_cmd", "tools")))
      {
        com.tencent.xweb.a.fqt();
        s.refresh();
        AppMethodBeat.o(185203);
        return;
      }
      org.xwalk.core.Log.i("XWalkWebFactory", "dis_refresh_main_cmd");
      AppMethodBeat.o(185203);
    }
    
    public final void bvk()
    {
      AppMethodBeat.i(185204);
      if (!"true".equalsIgnoreCase(com.tencent.xweb.a.lW("dis_refresh_plugin_cmd", "tools")))
      {
        b.fqB();
        AppMethodBeat.o(185204);
        return;
      }
      org.xwalk.core.Log.i("XWalkWebFactory", "dis_refresh_plugin_cmd");
      AppMethodBeat.o(185204);
    }
    
    public final void vG(int paramInt)
    {
      AppMethodBeat.i(185202);
      if (paramInt == 0)
      {
        if (!af.frr())
        {
          AppMethodBeat.o(185202);
          return;
        }
        paramInt = XWalkEnvironment.getAvailableVersion();
        int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        if ((paramInt <= 0) && (i > 0) && (!"true".equalsIgnoreCase(com.tencent.xweb.a.aOM("dis_reinit_web_core")))) {
          WebView.reinitToXWeb();
        }
      }
      AppMethodBeat.o(185202);
    }
  }
  
  static final class b
  {
    private static boolean IRe = false;
    private static boolean ISn = false;
    private static boolean peC = false;
    
    public static boolean hasInited()
    {
      return peC;
    }
    
    public static boolean hasInitedCallback()
    {
      return IRe;
    }
    
    public static void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
    {
      AppMethodBeat.i(154484);
      if (IRe)
      {
        AppMethodBeat.o(154484);
        return;
      }
      org.xwalk.core.Log.i("XWebViewHelper", "initCallback");
      WebViewExtension.SetExtension(paramWebViewExtensionListener);
      IRe = true;
      AppMethodBeat.o(154484);
    }
    
    public static boolean isCoreReady()
    {
      return ISn;
    }
    
    public static boolean ld(Context paramContext)
    {
      AppMethodBeat.i(154483);
      boolean bool;
      if (peC)
      {
        bool = peC;
        AppMethodBeat.o(154483);
        return bool;
      }
      org.xwalk.core.Log.i("XWebViewHelper", "preInit");
      if (j.gX(paramContext))
      {
        org.xwalk.core.Log.i("XWebViewHelper", "preInit finished");
        peC = true;
        ISn = true;
      }
      for (;;)
      {
        bool = peC;
        AppMethodBeat.o(154483);
        return bool;
        org.xwalk.core.Log.i("XWebViewHelper", "preInit xwalk is not available");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory
 * JD-Core Version:    0.7.0.1
 */