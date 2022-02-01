package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.i;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.resource.XWalkContextWrapper;

public class e
{
  static
  {
    AppMethodBeat.i(212781);
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(212781);
      return;
    }
  }
  
  public static a a(WebView.WebViewKind paramWebViewKind, Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    AppMethodBeat.i(212753);
    boolean bool;
    if (paramWebViewKind == WebView.WebViewKind.aifJ) {
      bool = com.tencent.xweb.a.keX().Q("fullscreen_video_enable_x5_try_runtime", "tools", false);
    }
    for (;;)
    {
      org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterface, webCoreType:" + paramWebViewKind + ", tryRuntimeVideoNativeInterface:" + bool);
      if (bool)
      {
        if (XWalkCoreWrapper.getInstance() != null) {
          paramContext = b(paramContext, paramWebView, paramView, paramString);
        }
        for (;;)
        {
          if (paramContext == null) {
            break label155;
          }
          org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterface, use [runtime] class XWebNativeInterfaceInternal");
          com.tencent.xweb.b.d.a(paramWebViewKind, 2, 1, false, null);
          AppMethodBeat.o(212753);
          return paramContext;
          if (paramWebViewKind != WebView.WebViewKind.aifK) {
            break label365;
          }
          bool = com.tencent.xweb.a.keX().Q("fullscreen_video_enable_sys_try_runtime", "tools", true);
          break;
          if (PSCoreWrapper.getInstance() != null) {
            paramContext = c(paramContext, paramWebView, paramView, paramString);
          } else {
            paramContext = a(paramContext, paramWebView, paramView, paramString);
          }
        }
      }
      label155:
      org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterface, use [sdk] class XWebNativeInterface");
      paramContext = new d();
      paramView.getContext();
      paramContext.WvQ = ((WebView)paramWebView);
      paramContext.aihw = paramString;
      paramWebView = kgP();
      if (paramWebView != null)
      {
        paramContext.aihx = paramWebView.getBoolean("fullscreen_video_enable_mute", false);
        paramContext.aihy = paramWebView.getBoolean("fullscreen_video_enable_speed", false);
        org.xwalk.core.Log.i("XWebNativeInterface", "initConfigs, before enableMute:" + paramContext.aihx + ", enableSpeed:" + paramContext.aihy);
        if ((paramContext.aihw != null) && (!paramContext.aihw.contains("xwebVideoBridge.xwebToJS_Video_MuteChange"))) {
          paramContext.aihx = false;
        }
        if ((paramContext.aihw != null) && (!paramContext.aihw.contains("xwebVideoBridge.xwebToJS_Video_RateChange"))) {
          paramContext.aihy = false;
        }
        org.xwalk.core.Log.i("XWebNativeInterface", "initConfigs, after enableMute:" + paramContext.aihx + ", enableSpeed:" + paramContext.aihy);
      }
      l.y(1749L, 15L, 1L);
      com.tencent.xweb.b.d.a(paramWebViewKind, 1, 1, bool, null);
      AppMethodBeat.o(212753);
      return paramContext;
      label365:
      bool = true;
    }
  }
  
  /* Error */
  private static a a(Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 195	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   8: sipush 2852
    //   11: if_icmpeq +12 -> 23
    //   14: invokestatic 195	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   17: sipush 2853
    //   20: if_icmpne +17 -> 37
    //   23: ldc 57
    //   25: ldc 197
    //   27: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 189
    //   32: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aconst_null
    //   36: areturn
    //   37: invokestatic 200	org/xwalk/core/XWalkEnvironment:isPinusWebViewCoreFromAvailableVersion	()Z
    //   40: istore 4
    //   42: ldc 57
    //   44: ldc 202
    //   46: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc 204
    //   51: iconst_0
    //   52: invokestatic 207	org/xwalk/core/XWalkEnvironment:getXWebInitArgs	(Ljava/lang/String;Z)Z
    //   55: ifne +153 -> 208
    //   58: iload 4
    //   60: ifeq +100 -> 160
    //   63: invokestatic 213	com/tencent/xweb/pinus/e:khp	()Lcom/tencent/xweb/pinus/e;
    //   66: invokevirtual 217	com/tencent/xweb/pinus/e:getClassLoader	()Ljava/lang/ClassLoader;
    //   69: astore 5
    //   71: aload 5
    //   73: ifnull +98 -> 171
    //   76: aload 5
    //   78: ldc 219
    //   80: invokevirtual 225	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   83: astore 6
    //   85: aload 6
    //   87: ifnull +269 -> 356
    //   90: ldc 57
    //   92: ldc 227
    //   94: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iload 4
    //   99: ifeq +149 -> 248
    //   102: invokestatic 213	com/tencent/xweb/pinus/e:khp	()Lcom/tencent/xweb/pinus/e;
    //   105: iconst_1
    //   106: invokevirtual 231	com/tencent/xweb/pinus/e:initChannels	(Z)Z
    //   109: ifeq +114 -> 223
    //   112: aload_0
    //   113: instanceof 233
    //   116: ifne +254 -> 370
    //   119: new 233	com/tencent/xweb/pinus/a
    //   122: dup
    //   123: aload_1
    //   124: invokevirtual 234	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   127: invokestatic 195	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   130: invokespecial 237	com/tencent/xweb/pinus/a:<init>	(Landroid/content/Context;I)V
    //   133: astore_0
    //   134: aload_0
    //   135: checkcast 233	com/tencent/xweb/pinus/a
    //   138: aload 5
    //   140: putfield 241	com/tencent/xweb/pinus/a:mClassLoader	Ljava/lang/ClassLoader;
    //   143: aload_0
    //   144: aload_1
    //   145: aload_2
    //   146: aload_3
    //   147: aload 6
    //   149: invokestatic 244	com/tencent/xweb/extension/video/e:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView;Landroid/view/View;Ljava/lang/String;Ljava/lang/Class;)Lcom/tencent/xweb/extension/video/e$a;
    //   152: astore_0
    //   153: ldc 189
    //   155: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_0
    //   159: areturn
    //   160: invokestatic 249	org/xwalk/core/XWalkStandAloneChannel:getInstance	()Lorg/xwalk/core/XWalkStandAloneChannel;
    //   163: invokevirtual 250	org/xwalk/core/XWalkStandAloneChannel:getClassLoader	()Ljava/lang/ClassLoader;
    //   166: astore 5
    //   168: goto -97 -> 71
    //   171: ldc 57
    //   173: ldc 252
    //   175: invokestatic 255	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: ldc 189
    //   180: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_0
    //   186: ldc 57
    //   188: ldc_w 257
    //   191: aload_0
    //   192: invokestatic 261	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: invokevirtual 265	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokestatic 255	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: ldc 189
    //   203: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aconst_null
    //   207: areturn
    //   208: ldc 57
    //   210: ldc_w 267
    //   213: invokestatic 255	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: ldc 189
    //   218: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aconst_null
    //   222: areturn
    //   223: ldc 57
    //   225: ldc_w 269
    //   228: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: ldc2_w 177
    //   234: ldc2_w 270
    //   237: lconst_1
    //   238: invokestatic 186	com/tencent/xweb/util/l:y	(JJJ)V
    //   241: ldc 189
    //   243: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aconst_null
    //   247: areturn
    //   248: invokestatic 249	org/xwalk/core/XWalkStandAloneChannel:getInstance	()Lorg/xwalk/core/XWalkStandAloneChannel;
    //   251: iconst_1
    //   252: invokevirtual 272	org/xwalk/core/XWalkStandAloneChannel:initChannels	(Z)Z
    //   255: ifeq +51 -> 306
    //   258: aload_0
    //   259: instanceof 274
    //   262: ifne +105 -> 367
    //   265: new 274	org/xwalk/core/resource/XWalkContextWrapper
    //   268: dup
    //   269: aload_1
    //   270: invokevirtual 234	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   273: invokestatic 195	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   276: invokespecial 275	org/xwalk/core/resource/XWalkContextWrapper:<init>	(Landroid/content/Context;I)V
    //   279: astore_0
    //   280: aload_0
    //   281: checkcast 274	org/xwalk/core/resource/XWalkContextWrapper
    //   284: aload 5
    //   286: invokevirtual 279	org/xwalk/core/resource/XWalkContextWrapper:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   289: aload_0
    //   290: aload_1
    //   291: aload_2
    //   292: aload_3
    //   293: aload 6
    //   295: invokestatic 244	com/tencent/xweb/extension/video/e:a	(Landroid/content/Context;Lcom/tencent/xweb/WebView;Landroid/view/View;Ljava/lang/String;Ljava/lang/Class;)Lcom/tencent/xweb/extension/video/e$a;
    //   298: astore_0
    //   299: ldc 189
    //   301: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: aload_0
    //   305: areturn
    //   306: ldc 57
    //   308: ldc_w 281
    //   311: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: ldc2_w 177
    //   317: ldc2_w 270
    //   320: lconst_1
    //   321: invokestatic 186	com/tencent/xweb/util/l:y	(JJJ)V
    //   324: goto -83 -> 241
    //   327: astore_0
    //   328: ldc 57
    //   330: new 59	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 283
    //   337: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_0
    //   341: invokestatic 289	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   344: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 255	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: goto -112 -> 241
    //   356: ldc 57
    //   358: ldc_w 291
    //   361: invokestatic 85	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: goto -123 -> 241
    //   367: goto -78 -> 289
    //   370: goto -227 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramContext	Context
    //   0	373	1	paramWebView	WebView
    //   0	373	2	paramView	View
    //   0	373	3	paramString	String
    //   40	58	4	bool	boolean
    //   69	216	5	localClassLoader	java.lang.ClassLoader
    //   83	211	6	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   63	71	185	java/lang/ClassNotFoundException
    //   76	85	185	java/lang/ClassNotFoundException
    //   160	168	185	java/lang/ClassNotFoundException
    //   171	178	185	java/lang/ClassNotFoundException
    //   90	97	327	finally
    //   102	143	327	finally
    //   143	153	327	finally
    //   223	241	327	finally
    //   248	289	327	finally
    //   289	299	327	finally
    //   306	324	327	finally
    //   356	364	327	finally
  }
  
  private static a a(Context paramContext, WebView paramWebView, View paramView, String paramString, Class<?> paramClass)
  {
    AppMethodBeat.i(212764);
    paramClass = new a(paramClass.newInstance());
    try
    {
      paramClass.a(paramWebView, paramView, paramContext, paramString);
      paramClass.cj(kgP());
      l.y(1749L, 16L, 1L);
      AppMethodBeat.o(212764);
      return paramClass;
    }
    catch (Exception paramContext)
    {
      org.xwalk.core.Log.e("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByOthers, init interface error:".concat(String.valueOf(paramContext)));
      l.y(1749L, 63L, 1L);
      AppMethodBeat.o(212764);
    }
    return null;
  }
  
  private static a b(Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    AppMethodBeat.i(212768);
    try
    {
      if ((!$assertionsDisabled) && (XWalkCoreWrapper.getInstance() == null))
      {
        paramContext = new AssertionError();
        AppMethodBeat.o(212768);
        throw paramContext;
      }
    }
    finally
    {
      org.xwalk.core.Log.e("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByXWalk, error:" + android.util.Log.getStackTraceString(paramContext));
    }
    for (;;)
    {
      AppMethodBeat.o(212768);
      return null;
      Class localClass = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      if (localClass != null)
      {
        org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByXWalk, try use [runtime] class XWebNativeInterfaceInternal");
        Object localObject = paramContext;
        if (!(paramContext instanceof XWalkContextWrapper)) {
          localObject = new XWalkContextWrapper(paramWebView.getContext(), XWalkEnvironment.getAvailableVersion());
        }
        paramContext = new a(localClass.newInstance());
        try
        {
          paramContext.a(paramWebView, paramView, (Context)localObject, paramString);
          paramContext.cj(kgP());
          l.y(1749L, 17L, 1L);
          AppMethodBeat.o(212768);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          org.xwalk.core.Log.e("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByXWalk, init interface error:".concat(String.valueOf(paramContext)));
          l.y(1749L, 64L, 1L);
          AppMethodBeat.o(212768);
          return null;
        }
      }
      org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByXWalk, try use runtime class XWebNativeInterfaceInternal but bot found");
    }
  }
  
  private static a c(Context paramContext, WebView paramWebView, View paramView, String paramString)
  {
    AppMethodBeat.i(212772);
    try
    {
      if ((!$assertionsDisabled) && (PSCoreWrapper.getInstance() == null))
      {
        paramContext = new AssertionError();
        AppMethodBeat.o(212772);
        throw paramContext;
      }
    }
    finally
    {
      org.xwalk.core.Log.e("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, error:" + android.util.Log.getStackTraceString(paramContext));
    }
    for (;;)
    {
      AppMethodBeat.o(212772);
      return null;
      Class localClass = PSCoreWrapper.getInstance().getClass("org.xwalk.core.internal.videofullscreen.XWebNativeInterfaceInternal");
      if (localClass != null)
      {
        org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, try use [runtime] class XWebNativeInterfaceInternal");
        Object localObject = paramContext;
        if (!(paramContext instanceof com.tencent.xweb.pinus.a)) {
          localObject = new com.tencent.xweb.pinus.a(paramWebView.getContext(), XWalkEnvironment.getAvailableVersion());
        }
        paramContext = new a(localClass.newInstance());
        try
        {
          paramContext.a(paramWebView, paramView, (Context)localObject, paramString);
          paramContext.cj(kgP());
          l.y(1749L, 18L, 1L);
          AppMethodBeat.o(212772);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          org.xwalk.core.Log.e("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, init interface error:".concat(String.valueOf(paramContext)));
          l.y(1749L, 65L, 1L);
          AppMethodBeat.o(212772);
          return null;
        }
      }
      org.xwalk.core.Log.i("XWebNativeInterfaceFactory", "createXWebNativeInterfaceByPinus, try use runtime class XWebNativeInterfaceInternal but bot found");
    }
  }
  
  private static Bundle kgP()
  {
    AppMethodBeat.i(212777);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("fullscreen_video_enable_mute", com.tencent.xweb.a.keX().kfd());
    localBundle.putBoolean("fullscreen_video_enable_speed", com.tencent.xweb.a.keX().kfe());
    AppMethodBeat.o(212777);
    return localBundle;
  }
  
  public static final class a
    implements a
  {
    private ReflectMethod aiic;
    private ReflectMethod aiid;
    private ReflectMethod aiie;
    private ReflectMethod aiif;
    private ReflectMethod aiig;
    private ReflectMethod aiih;
    private ReflectMethod aiii;
    private ReflectMethod aiij;
    private ReflectMethod aiik;
    private ReflectMethod aiil;
    private ReflectMethod aiim;
    private ReflectMethod aiin;
    private ReflectMethod aiio;
    private ReflectMethod aiip;
    private ReflectMethod aiiq;
    private ReflectMethod aiir;
    private ReflectMethod aiis;
    private Object aiit;
    
    public a(Object paramObject)
    {
      AppMethodBeat.i(153636);
      this.aiit = paramObject;
      this.aiic = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
      this.aiid = new ReflectMethod(paramObject, "initConfigs", new Class[] { Bundle.class });
      this.aiie = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
      this.aiif = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
      this.aiig = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
      this.aiih = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
      this.aiii = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
      this.aiij = new ReflectMethod(paramObject, "disableJsCallback", new Class[] { Boolean.TYPE });
      this.aiik = new ReflectMethod(paramObject, "setVideoJsCallback", new Class[] { Object.class });
      this.aiin = new ReflectMethod(paramObject, "videoChangeStatus", new Class[0]);
      this.aiil = new ReflectMethod(paramObject, "videoPlay", new Class[0]);
      this.aiim = new ReflectMethod(paramObject, "videoPause", new Class[0]);
      this.aiio = new ReflectMethod(paramObject, "videoSeek", new Class[] { Double.TYPE });
      this.aiip = new ReflectMethod(paramObject, "videoMute", new Class[] { Boolean.TYPE });
      this.aiiq = new ReflectMethod(paramObject, "videoPlaybackRate", new Class[] { Double.TYPE });
      this.aiir = new ReflectMethod(paramObject, "videoExitFullscreen", new Class[0]);
      this.aiis = new ReflectMethod(paramObject, "supportSetRequestedOrientationCallback", new Class[0]);
      AppMethodBeat.o(153636);
    }
    
    public final void OV(boolean paramBoolean)
    {
      AppMethodBeat.i(153640);
      try
      {
        this.aiij.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(153640);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "disableJsCallback error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153640);
      }
    }
    
    public final void Z(double paramDouble)
    {
      AppMethodBeat.i(153645);
      try
      {
        this.aiio.invoke(new Object[] { Double.valueOf(paramDouble) });
        AppMethodBeat.o(153645);
        return;
      }
      finally
      {
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "videoSeek invoke error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153645);
      }
    }
    
    public final void a(View paramView1, View paramView2, Context paramContext, String paramString)
    {
      AppMethodBeat.i(212722);
      try
      {
        this.aiic.invoke(new Object[] { null, paramView1, paramView2, paramContext, paramString });
        AppMethodBeat.o(212722);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "init error:".concat(String.valueOf(paramView1)));
        paramView1 = new Exception(paramView1);
        AppMethodBeat.o(212722);
      }
    }
    
    public final void bV(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(153637);
      try
      {
        this.aiie.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        AppMethodBeat.o(153637);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "evaluteJavascript error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153637);
      }
    }
    
    public final void cj(Bundle paramBundle)
    {
      AppMethodBeat.i(212729);
      try
      {
        this.aiid.invoke(new Object[] { paramBundle });
        AppMethodBeat.o(212729);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "initConfigs error:".concat(String.valueOf(paramBundle)));
        AppMethodBeat.o(212729);
      }
    }
    
    public final void hSS()
    {
      AppMethodBeat.i(153644);
      try
      {
        this.aiim.invoke(new Object[0]);
        AppMethodBeat.o(153644);
        return;
      }
      finally
      {
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "videoPause invoke error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153644);
      }
    }
    
    public final void hm(Object paramObject)
    {
      AppMethodBeat.i(153638);
      try
      {
        this.aiii.invoke(new Object[] { paramObject });
        AppMethodBeat.o(153638);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "registerJavascriptInterface error:".concat(String.valueOf(paramObject)));
        AppMethodBeat.o(153638);
      }
    }
    
    public final boolean hn(Object paramObject)
    {
      AppMethodBeat.i(153642);
      g localg = i.bHs("FullScreenVideo");
      if ((localg != null) && (localg.aipK >= 10)) {
        try
        {
          boolean bool = ((Boolean)this.aiik.invoke(new Object[] { paramObject })).booleanValue();
          AppMethodBeat.o(153642);
          return bool;
        }
        finally
        {
          org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "setVideoJsCallback invoke error:".concat(String.valueOf(paramObject)));
          AppMethodBeat.o(153642);
          return false;
        }
      }
      if (localg != null) {
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "setVideoJsCallback return false, fullScreenVideoPlugin is not available, version:" + localg.aipK);
      }
      for (;;)
      {
        AppMethodBeat.o(153642);
        return false;
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "setVideoJsCallback return false, fullScreenVideoPlugin is not available");
      }
    }
    
    public final void kfv()
    {
      AppMethodBeat.i(153643);
      try
      {
        this.aiil.invoke(new Object[0]);
        AppMethodBeat.o(153643);
        return;
      }
      finally
      {
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "videoPlay invoke error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153643);
      }
    }
    
    public final boolean kfw()
    {
      AppMethodBeat.i(212759);
      try
      {
        boolean bool = ((Boolean)this.aiis.invoke(new Object[0])).booleanValue();
        AppMethodBeat.o(212759);
        return bool;
      }
      finally
      {
        org.xwalk.core.Log.i("VideoNativeInterfaceRuntime", "supportSetRequestedOrientationCallback invoke error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(212759);
      }
      return false;
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(153641);
      try
      {
        this.aiig.invoke(new Object[0]);
        AppMethodBeat.o(153641);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "onHideCustomView error:".concat(String.valueOf(localObject)));
        AppMethodBeat.o(153641);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(153639);
      try
      {
        this.aiif.invoke(new Object[] { paramView, paramCustomViewCallback });
        AppMethodBeat.o(153639);
        return;
      }
      finally
      {
        org.xwalk.core.Log.e("VideoNativeInterfaceRuntime", "onShowCustomView error:".concat(String.valueOf(paramView)));
        AppMethodBeat.o(153639);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */