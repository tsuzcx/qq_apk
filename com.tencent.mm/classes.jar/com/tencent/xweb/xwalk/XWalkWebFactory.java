package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.b.a;
import com.tencent.xweb.c.b.b;
import com.tencent.xweb.c.l.a;
import com.tencent.xweb.k.a;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.b.a.a;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory
  implements l.a
{
  private static final String TAG = "XWalkWebFactory";
  static XWalkWebFactory sInstance;
  private boolean mIsDebugMode = false;
  private boolean mIsDebugModeReplase = false;
  
  public static XWalkWebFactory getInstance()
  {
    AppMethodBeat.i(85399);
    if (sInstance == null) {
      sInstance = new XWalkWebFactory();
    }
    XWalkWebFactory localXWalkWebFactory = sInstance;
    AppMethodBeat.o(85399);
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
    //   5: ldc 48
    //   7: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: invokestatic 54	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   14: iload_1
    //   15: ifeq +17 -> 32
    //   18: invokestatic 58	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   21: ldc 59
    //   23: if_icmpne +9 -> 32
    //   26: ldc 59
    //   28: invokestatic 63	org/xwalk/core/XWalkEnvironment:delApiVersion	(I)Z
    //   31: pop
    //   32: invokestatic 58	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   35: istore_2
    //   36: iload_2
    //   37: iconst_m1
    //   38: if_icmpeq +7 -> 45
    //   41: iload_1
    //   42: ifeq +106 -> 148
    //   45: aload_0
    //   46: invokevirtual 69	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   49: ldc 71
    //   51: invokevirtual 77	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore 4
    //   56: new 79	java/io/File
    //   59: dup
    //   60: ldc 59
    //   62: invokestatic 83	org/xwalk/core/XWalkEnvironment:getDownloadZipDir	(I)Ljava/lang/String;
    //   65: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore 5
    //   70: aload 5
    //   72: invokevirtual 90	java/io/File:exists	()Z
    //   75: ifeq +9 -> 84
    //   78: aload 5
    //   80: invokevirtual 93	java/io/File:delete	()Z
    //   83: pop
    //   84: new 95	java/io/FileOutputStream
    //   87: dup
    //   88: aload 5
    //   90: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore 5
    //   95: ldc 99
    //   97: newarray byte
    //   99: astore 6
    //   101: aload 4
    //   103: aload 6
    //   105: invokevirtual 105	java/io/InputStream:read	([B)I
    //   108: istore_2
    //   109: iload_2
    //   110: iconst_m1
    //   111: if_icmpeq +49 -> 160
    //   114: aload 5
    //   116: aload 6
    //   118: iconst_0
    //   119: iload_2
    //   120: invokevirtual 109	java/io/FileOutputStream:write	([BII)V
    //   123: goto -22 -> 101
    //   126: astore_0
    //   127: aload 5
    //   129: astore_0
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 112	java/io/InputStream:close	()V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   148: ldc 48
    //   150: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iload_3
    //   154: istore_1
    //   155: ldc 2
    //   157: monitorexit
    //   158: iload_1
    //   159: ireturn
    //   160: aload 5
    //   162: invokevirtual 116	java/io/FileOutputStream:flush	()V
    //   165: invokestatic 121	org/xwalk/core/XWalkUpdater:updateLocalXWalkRuntime	()V
    //   168: invokestatic 124	org/xwalk/core/XWalkEnvironment:resetForDebug	()V
    //   171: aload_0
    //   172: invokestatic 54	org/xwalk/core/XWalkEnvironment:init	(Landroid/content/Context;)V
    //   175: aload 4
    //   177: ifnull +8 -> 185
    //   180: aload 4
    //   182: invokevirtual 112	java/io/InputStream:close	()V
    //   185: aload 5
    //   187: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   190: iconst_1
    //   191: istore_1
    //   192: ldc 48
    //   194: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   220: invokevirtual 112	java/io/InputStream:close	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   233: ldc 48
    //   235: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(85410);
    if (WebView.getCurWebType() != WebView.d.BEq)
    {
      AppMethodBeat.o(85410);
      return;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i <= 0)
      {
        AppMethodBeat.o(85410);
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
      AppMethodBeat.o(85410);
      return;
    }
    catch (Throwable paramContext)
    {
      org.xwalk.core.Log.e("XWalkWebFactory", "clearAllWebViewCache exception 1 -- " + paramContext.getMessage());
      AppMethodBeat.o(85410);
    }
  }
  
  public com.tencent.xweb.c.i createWebView(WebView paramWebView)
  {
    AppMethodBeat.i(85401);
    try
    {
      if (j.fL(paramWebView.getContext()))
      {
        WebViewExtension.updateExtension(false);
        paramWebView = new j(paramWebView);
        AppMethodBeat.o(85401);
        return paramWebView;
      }
    }
    catch (Exception paramWebView)
    {
      paramWebView = "init xwalk crashed:" + paramWebView.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(paramWebView);
      org.xwalk.core.Log.e("XWalkWebFactory", paramWebView);
      XWalkInitializer.addXWalkInitializeLog(paramWebView);
      AppMethodBeat.o(85401);
    }
    return null;
  }
  
  public com.tencent.xweb.c.h createWebviewStorage()
  {
    AppMethodBeat.i(85413);
    i locali = new i();
    AppMethodBeat.o(85413);
    return locali;
  }
  
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85400);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(85400);
      return null;
    }
    if (paramString.equals("STR_CMD_INVOKE_TO_RUNTIME"))
    {
      if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2))
      {
        AppMethodBeat.o(85400);
        return null;
      }
      try
      {
        if (XWalkCoreWrapper.getInstance() != null)
        {
          paramString = XWalkCoreWrapper.invokeRuntimeChannel(((Integer)paramArrayOfObject[0]).intValue(), (Object[])paramArrayOfObject[1]);
          AppMethodBeat.o(85400);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        org.xwalk.core.Log.e("XWalkWebFactory", "STR_CMD_INVOKE_TO_RUNTIME failed , err = " + paramString.getMessage());
      }
    }
    label549:
    label552:
    for (;;)
    {
      AppMethodBeat.o(85400);
      return null;
      if (paramString.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG"))
      {
        if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0))
        {
          AppMethodBeat.o(85400);
          return null;
        }
        paramString = a.db(paramArrayOfObject[0]);
        AppMethodBeat.o(85400);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_DEBUG_VIEW"))
      {
        paramString = new c((WebView)paramArrayOfObject[0]);
        AppMethodBeat.o(85400);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_UPDATER"))
      {
        paramString = new n.a();
        AppMethodBeat.o(85400);
        return paramString;
      }
      if (paramString.equals("STR_CMD_GET_PLUGIN_UPDATER"))
      {
        paramString = new com.tencent.xweb.xwalk.a.g();
        AppMethodBeat.o(85400);
        return paramString;
      }
      if (paramString.equals("STR_CMD_CLEAR_SCHEDULER"))
      {
        com.tencent.xweb.xwalk.b.c.a(null);
        AppMethodBeat.o(85400);
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
          paramString = com.tencent.xweb.xwalk.b.a.ayr(XWalkEnvironment.getUpdateConfigFullPath());
          if (paramString == null)
          {
            XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
            AppMethodBeat.o(85400);
            return null;
          }
          com.tencent.xweb.a.a(paramString.BKM, paramString.BKK, true);
          f.pf(68L);
        }
        catch (Exception paramString)
        {
          XWalkEnvironment.addXWalkInitializeLog("recheck cmds failed , " + paramString.getMessage());
        }
      }
      else if (paramString.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW"))
      {
        tryLoadLocalAssetRuntime((Context)paramArrayOfObject[0], true);
        c.ge((Context)paramArrayOfObject[0]);
      }
      else
      {
        if (paramString.equals("BASE_CONTEXT_CHANGED")) {
          if ((paramArrayOfObject == null) || (paramArrayOfObject.length <= 0) || (!(paramArrayOfObject[0] instanceof j))) {
            break label549;
          }
        }
        for (paramString = (j)paramArrayOfObject[0];; paramString = null)
        {
          if ((paramString == null) || (XWalkCoreWrapper.getInstance() == null)) {
            break label552;
          }
          if (paramString.BJF == null) {
            org.xwalk.core.Log.e("XWWebView", "getXWalkBridge mwebview == null");
          }
          for (paramString = null;; paramString = paramString.BJF.getBridge())
          {
            XWalkCoreWrapper.getInstance();
            XWalkCoreWrapper.invokeRuntimeChannel(80001, new Object[] { paramString });
            break;
          }
          if (!paramString.equals("STR_CMD_FEATURE_SUPPORT")) {
            break;
          }
          boolean bool = XWalkCoreWrapper.hasFeatureStatic(((Integer)paramArrayOfObject[0]).intValue());
          AppMethodBeat.o(85400);
          return Boolean.valueOf(bool);
        }
      }
    }
  }
  
  public b.a getCookieManager()
  {
    AppMethodBeat.i(85411);
    d locald = new d();
    AppMethodBeat.o(85411);
    return locald;
  }
  
  public b.b getCookieSyncManager()
  {
    AppMethodBeat.i(85412);
    e locale = new e();
    AppMethodBeat.o(85412);
    return locale;
  }
  
  public com.tencent.xweb.c.g getJsCore(k.a parama, Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(85404);
    initWebviewCore(paramContext, null);
    switch (XWalkWebFactory.1.BIj[parama.ordinal()])
    {
    default: 
      paramContext = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(85404);
      return paramContext;
      paramContext = localObject;
      if (com.tencent.xweb.xwalk.b.e.isXWalkReady()) {
        if (parama == k.a.BDu)
        {
          paramContext = new h();
          paramContext.init(0);
        }
        else
        {
          paramContext = localObject;
          if (parama == k.a.BDv)
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
    AppMethodBeat.i(85407);
    boolean bool = XWalkWebFactory.a.hasInited();
    AppMethodBeat.o(85407);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(85408);
    boolean bool = XWalkWebFactory.a.hasInitedCallback();
    AppMethodBeat.o(85408);
    return bool;
  }
  
  public void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(85406);
    XWalkWebFactory.a.initCallback(paramWebViewExtensionListener);
    AppMethodBeat.o(85406);
  }
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(85402);
    if (this.mIsDebugMode) {
      tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplase);
    }
    AppMethodBeat.o(85402);
  }
  
  public void initInterface() {}
  
  public boolean initWebviewCore(Context paramContext, WebView.c paramc)
  {
    AppMethodBeat.i(85405);
    boolean bool = XWalkWebFactory.a.jX(paramContext);
    if (paramc != null)
    {
      if (!bool) {
        break label33;
      }
      paramc.onCoreInitFinished();
    }
    for (;;)
    {
      AppMethodBeat.o(85405);
      return bool;
      label33:
      paramc.BG();
    }
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(85409);
    boolean bool = XWalkWebFactory.a.isCoreReady();
    AppMethodBeat.o(85409);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory
 * JD-Core Version:    0.7.0.1
 */