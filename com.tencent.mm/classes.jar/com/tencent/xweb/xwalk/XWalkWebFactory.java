package com.tencent.xweb.xwalk;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.XWebViewProvider;
import com.tencent.xweb.ao;
import com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal;
import com.tencent.xweb.internal.CookieInternal.ICookieSyncManagerInternal;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.WebViewWrapperFactory.IWebViewProvider;
import com.tencent.xweb.internal.l;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;
import org.xwalk.core.XWalkView;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory
  implements WebViewWrapperFactory.IWebViewProvider
{
  private static final String TAG = "XWalkWebFactory";
  private static XWalkWebFactory sInstance;
  private boolean mIsDebugMode;
  private boolean mIsDebugModeReplace;
  
  private XWalkWebFactory()
  {
    AppMethodBeat.i(185205);
    this.mIsDebugMode = false;
    this.mIsDebugModeReplace = false;
    AppMethodBeat.o(185205);
  }
  
  public static XWalkWebFactory getInstance()
  {
    AppMethodBeat.i(154485);
    if (sInstance == null)
    {
      ao.kgs();
      sInstance = new XWalkWebFactory();
    }
    XWalkWebFactory localXWalkWebFactory = sInstance;
    AppMethodBeat.o(154485);
    return localXWalkWebFactory;
  }
  
  public void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(154496);
    if (WebView.getCurWebType() != WebView.WebViewKind.aifI)
    {
      Log.w("XWalkWebFactory", "clearAllWebViewCache, not xwalk");
      AppMethodBeat.o(154496);
      return;
    }
    try
    {
      if (XWalkEnvironment.getAvailableVersion() <= 0)
      {
        Log.w("XWalkWebFactory", "clearAllWebViewCache, no available version");
        AppMethodBeat.o(154496);
        return;
      }
      paramContext = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
      paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
      paramContext.removeJavascriptInterface("accessibility");
      paramContext.removeJavascriptInterface("accessibilityTraversal");
      paramContext.clearCache(true);
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
    finally
    {
      Log.e("XWalkWebFactory", "clearAllWebViewCache, error:".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(154496);
    }
  }
  
  public IWebView createWebView(WebView paramWebView)
  {
    AppMethodBeat.i(154487);
    try
    {
      if (j.pc(paramWebView.getContext()))
      {
        WebViewExtension.updateExtension(false);
        paramWebView = new j(paramWebView);
        return paramWebView;
      }
    }
    finally
    {
      AppMethodBeat.o(154487);
    }
    AppMethodBeat.o(154487);
    return null;
  }
  
  public IWebStorage createWebviewStorage()
  {
    AppMethodBeat.i(154499);
    i locali = new i();
    AppMethodBeat.o(154499);
    return locali;
  }
  
  /* Error */
  public Object excute(String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc 160
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokevirtual 164	java/lang/String:isEmpty	()Z
    //   13: ifeq +10 -> 23
    //   16: ldc 160
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: iconst_m1
    //   24: istore_3
    //   25: aload_1
    //   26: invokevirtual 167	java/lang/String:hashCode	()I
    //   29: lookupswitch	default:+83->112, -1778790264:+142->171, -1343444484:+212->241, -1127840013:+198->227, -695842575:+226->255, 755296886:+184->213, 867631080:+256->285, 1514909526:+170->199, 1779348820:+156->185, 1807778616:+241->270
    //   113: tableswitch	default:+51 -> 164, 0:+187->300, 1:+254->367, 2:+267->380, 3:+280->393, 4:+341->454, 5:+366->479, 6:+381->494, 7:+456->569, 8:+532->645
    //   165: if_icmpne -18432 -> -18267
    //   168: fload_2
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: ldc 169
    //   174: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   177: ifeq -65 -> 112
    //   180: iconst_0
    //   181: istore_3
    //   182: goto -70 -> 112
    //   185: aload_1
    //   186: ldc 175
    //   188: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq -79 -> 112
    //   194: iconst_1
    //   195: istore_3
    //   196: goto -84 -> 112
    //   199: aload_1
    //   200: ldc 177
    //   202: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -93 -> 112
    //   208: iconst_2
    //   209: istore_3
    //   210: goto -98 -> 112
    //   213: aload_1
    //   214: ldc 179
    //   216: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq -107 -> 112
    //   222: iconst_3
    //   223: istore_3
    //   224: goto -112 -> 112
    //   227: aload_1
    //   228: ldc 181
    //   230: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq -121 -> 112
    //   236: iconst_4
    //   237: istore_3
    //   238: goto -126 -> 112
    //   241: aload_1
    //   242: ldc 183
    //   244: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq -135 -> 112
    //   250: iconst_5
    //   251: istore_3
    //   252: goto -140 -> 112
    //   255: aload_1
    //   256: ldc 185
    //   258: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   261: ifeq -149 -> 112
    //   264: bipush 6
    //   266: istore_3
    //   267: goto -155 -> 112
    //   270: aload_1
    //   271: ldc 187
    //   273: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   276: ifeq -164 -> 112
    //   279: bipush 7
    //   281: istore_3
    //   282: goto -170 -> 112
    //   285: aload_1
    //   286: ldc 189
    //   288: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   291: ifeq -179 -> 112
    //   294: bipush 8
    //   296: istore_3
    //   297: goto -185 -> 112
    //   300: aload_2
    //   301: ifnull +9 -> 310
    //   304: aload_2
    //   305: arraylength
    //   306: iconst_2
    //   307: if_icmpge +10 -> 317
    //   310: ldc 160
    //   312: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aconst_null
    //   316: areturn
    //   317: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   320: ifnull -156 -> 164
    //   323: aload_2
    //   324: iconst_0
    //   325: aaload
    //   326: checkcast 196	java/lang/Integer
    //   329: invokevirtual 199	java/lang/Integer:intValue	()I
    //   332: aload_2
    //   333: iconst_1
    //   334: aaload
    //   335: checkcast 201	[Ljava/lang/Object;
    //   338: invokestatic 205	org/xwalk/core/XWalkCoreWrapper:invokeRuntimeChannel	(I[Ljava/lang/Object;)Ljava/lang/Object;
    //   341: astore_1
    //   342: ldc 160
    //   344: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_1
    //   348: areturn
    //   349: astore_1
    //   350: ldc 13
    //   352: ldc 207
    //   354: aload_1
    //   355: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   358: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   361: invokestatic 131	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: goto -200 -> 164
    //   367: aload_0
    //   368: iconst_1
    //   369: putfield 31	com/tencent/xweb/xwalk/XWalkWebFactory:mIsDebugMode	Z
    //   372: aload_0
    //   373: iconst_1
    //   374: putfield 33	com/tencent/xweb/xwalk/XWalkWebFactory:mIsDebugModeReplace	Z
    //   377: goto -213 -> 164
    //   380: aload_0
    //   381: iconst_1
    //   382: putfield 31	com/tencent/xweb/xwalk/XWalkWebFactory:mIsDebugMode	Z
    //   385: aload_0
    //   386: iconst_0
    //   387: putfield 33	com/tencent/xweb/xwalk/XWalkWebFactory:mIsDebugModeReplace	Z
    //   390: goto -226 -> 164
    //   393: aload_2
    //   394: ifnull +302 -> 696
    //   397: aload_2
    //   398: arraylength
    //   399: ifle +297 -> 696
    //   402: aload_2
    //   403: iconst_0
    //   404: aaload
    //   405: instanceof 139
    //   408: ifeq +288 -> 696
    //   411: aload_2
    //   412: iconst_0
    //   413: aaload
    //   414: checkcast 139	com/tencent/xweb/xwalk/j
    //   417: astore_1
    //   418: aload_1
    //   419: ifnull -255 -> 164
    //   422: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   425: ifnull -261 -> 164
    //   428: aload_1
    //   429: invokevirtual 211	com/tencent/xweb/xwalk/j:kjk	()Ljava/lang/Object;
    //   432: astore_1
    //   433: aload_1
    //   434: ifnull -270 -> 164
    //   437: ldc 212
    //   439: iconst_1
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: aload_1
    //   446: aastore
    //   447: invokestatic 205	org/xwalk/core/XWalkCoreWrapper:invokeRuntimeChannel	(I[Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: goto -287 -> 164
    //   454: aload_2
    //   455: iconst_0
    //   456: aaload
    //   457: checkcast 196	java/lang/Integer
    //   460: invokevirtual 199	java/lang/Integer:intValue	()I
    //   463: invokestatic 216	org/xwalk/core/XWalkCoreWrapper:hasFeatureStatic	(I)Z
    //   466: istore 4
    //   468: ldc 160
    //   470: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   473: iload 4
    //   475: invokestatic 221	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   478: areturn
    //   479: aload_2
    //   480: iconst_0
    //   481: aaload
    //   482: checkcast 223	java/lang/Long
    //   485: invokevirtual 227	java/lang/Long:longValue	()J
    //   488: invokestatic 231	org/xwalk/core/XWalkCoreWrapper:bindNativeTrans	(J)V
    //   491: goto -327 -> 164
    //   494: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   497: ifnull -333 -> 164
    //   500: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   503: ldc 233
    //   505: invokevirtual 237	org/xwalk/core/XWalkCoreWrapper:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   508: ldc 239
    //   510: iconst_1
    //   511: anewarray 241	java/lang/Class
    //   514: dup
    //   515: iconst_0
    //   516: getstatic 245	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   519: aastore
    //   520: invokevirtual 249	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   523: aconst_null
    //   524: iconst_1
    //   525: anewarray 4	java/lang/Object
    //   528: dup
    //   529: iconst_0
    //   530: aload_2
    //   531: iconst_0
    //   532: aaload
    //   533: checkcast 218	java/lang/Boolean
    //   536: invokevirtual 252	java/lang/Boolean:booleanValue	()Z
    //   539: invokestatic 221	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   542: aastore
    //   543: invokevirtual 258	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   546: pop
    //   547: goto -383 -> 164
    //   550: astore_1
    //   551: ldc 13
    //   553: ldc_w 260
    //   556: aload_1
    //   557: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   560: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   563: invokestatic 71	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: goto -402 -> 164
    //   569: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   572: ifnull -408 -> 164
    //   575: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   578: ldc 233
    //   580: invokevirtual 237	org/xwalk/core/XWalkCoreWrapper:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   583: ldc_w 262
    //   586: iconst_1
    //   587: anewarray 241	java/lang/Class
    //   590: dup
    //   591: iconst_0
    //   592: getstatic 263	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   595: aastore
    //   596: invokevirtual 249	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   599: aconst_null
    //   600: iconst_1
    //   601: anewarray 4	java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: aload_2
    //   607: iconst_0
    //   608: aaload
    //   609: checkcast 196	java/lang/Integer
    //   612: invokevirtual 199	java/lang/Integer:intValue	()I
    //   615: invokestatic 266	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: aastore
    //   619: invokevirtual 258	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   622: pop
    //   623: goto -459 -> 164
    //   626: astore_1
    //   627: ldc 13
    //   629: ldc_w 268
    //   632: aload_1
    //   633: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   636: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   639: invokestatic 71	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: goto -478 -> 164
    //   645: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   648: ifnull +37 -> 685
    //   651: invokestatic 194	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   654: aload_2
    //   655: iconst_0
    //   656: aaload
    //   657: checkcast 270	java/util/Locale
    //   660: invokevirtual 274	org/xwalk/core/XWalkCoreWrapper:updateResourceLocale	(Ljava/util/Locale;)V
    //   663: goto -499 -> 164
    //   666: astore_1
    //   667: ldc 13
    //   669: ldc_w 276
    //   672: aload_1
    //   673: invokestatic 124	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   676: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   679: invokestatic 131	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: goto -518 -> 164
    //   685: ldc 13
    //   687: ldc_w 278
    //   690: invokestatic 71	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: goto -529 -> 164
    //   696: aconst_null
    //   697: astore_1
    //   698: goto -280 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	XWalkWebFactory
    //   0	701	1	paramString	String
    //   0	701	2	paramArrayOfObject	Object[]
    //   24	273	3	i	int
    //   466	8	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   317	342	349	finally
    //   494	547	550	finally
    //   569	623	626	finally
    //   645	663	666	finally
    //   685	693	666	finally
  }
  
  public CookieInternal.ICookieManagerInternal getCookieManager()
  {
    AppMethodBeat.i(154497);
    e locale = new e();
    AppMethodBeat.o(154497);
    return locale;
  }
  
  public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager()
  {
    AppMethodBeat.i(154498);
    f localf = new f();
    AppMethodBeat.o(154498);
    return localf;
  }
  
  public IWebViewDatabase getWebViewDatabase()
  {
    AppMethodBeat.i(213006);
    t localt = new t();
    AppMethodBeat.o(213006);
    return localt;
  }
  
  public boolean hasInited()
  {
    AppMethodBeat.i(154493);
    boolean bool = a.hasInited();
    AppMethodBeat.o(154493);
    return bool;
  }
  
  public boolean hasInitedCallback()
  {
    AppMethodBeat.i(154494);
    boolean bool = a.hasInitedCallback();
    AppMethodBeat.o(154494);
    return bool;
  }
  
  public void initEnviroment(Context paramContext)
  {
    AppMethodBeat.i(154488);
    Log.i("XWalkWebFactory", "initEnvironment");
    if (this.mIsDebugMode) {
      XWebViewProvider.tryLoadLocalAssetRuntime(paramContext, this.mIsDebugModeReplace);
    }
    AppMethodBeat.o(154488);
  }
  
  public void initInterface()
  {
    AppMethodBeat.i(183744);
    l.a(WebView.WebViewKind.aifI, new m());
    AppMethodBeat.o(183744);
  }
  
  public void initWebViewExtensionListener(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(212968);
    a.a(paramWebViewExtensionListener);
    AppMethodBeat.o(212968);
  }
  
  public boolean initWebviewCore(Context paramContext, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(154491);
    Log.i("XWalkWebFactory", "initWebviewCore");
    boolean bool = a.oW(paramContext);
    if (paramPreInitCallback != null)
    {
      if (!bool) {
        break label41;
      }
      paramPreInitCallback.onCoreInitFinished();
    }
    for (;;)
    {
      AppMethodBeat.o(154491);
      return bool;
      label41:
      paramPreInitCallback.aDm();
    }
  }
  
  public boolean isCoreReady()
  {
    AppMethodBeat.i(154495);
    boolean bool = a.isCoreReady();
    AppMethodBeat.o(154495);
    return bool;
  }
  
  static final class a
  {
    private static boolean aimi = false;
    private static boolean mHasInited = false;
    private static boolean mIsCoreReady = false;
    
    public static void a(WebViewExtensionListener paramWebViewExtensionListener)
    {
      AppMethodBeat.i(213129);
      if (aimi)
      {
        AppMethodBeat.o(213129);
        return;
      }
      Log.i("XWalkWebFactory.PreIniter", "initExtension");
      WebViewExtension.setExtension(paramWebViewExtensionListener);
      aimi = true;
      AppMethodBeat.o(213129);
    }
    
    public static boolean hasInited()
    {
      return mHasInited;
    }
    
    public static boolean hasInitedCallback()
    {
      return aimi;
    }
    
    public static boolean isCoreReady()
    {
      return mIsCoreReady;
    }
    
    public static boolean oW(Context paramContext)
    {
      AppMethodBeat.i(213126);
      if (mHasInited)
      {
        AppMethodBeat.o(213126);
        return true;
      }
      Log.i("XWalkWebFactory.PreIniter", "preInit start");
      if (j.pc(paramContext))
      {
        Log.i("XWalkWebFactory.PreIniter", "preInit finished");
        mHasInited = true;
        mIsCoreReady = true;
        String str = XWalkEnvironment.getProcessName();
        paramContext = str;
        if (TextUtils.isEmpty(str)) {
          paramContext = XWalkEnvironment.getApplicationContext().getPackageName();
        }
        paramContext = paramContext.replace(":", ".");
        XWalkCoreWrapper.invokeRuntimeChannel(90002, new Object[] { paramContext + "." + XWalkGrayValueUtil.getGrayValue() });
      }
      for (;;)
      {
        boolean bool = mHasInited;
        AppMethodBeat.o(213126);
        return bool;
        Log.i("XWalkWebFactory.PreIniter", "preInit failed, xwalk is not available");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory
 * JD-Core Version:    0.7.0.1
 */