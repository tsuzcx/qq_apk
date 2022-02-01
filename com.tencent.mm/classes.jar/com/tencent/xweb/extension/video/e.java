package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;

public final class e
{
  private static ClassLoader mClassLoader;
  
  /* Error */
  public static b a(Context paramContext, com.tencent.xweb.WebView paramWebView, View paramView, String paramString)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 27	org/xwalk/core/XWalkEnvironment:activityFromContext	(Landroid/content/Context;)Landroid/app/Activity;
    //   9: astore 6
    //   11: ldc 29
    //   13: ldc 31
    //   15: aload 6
    //   17: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 41	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: invokestatic 52	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   29: ifnull +104 -> 133
    //   32: ldc 29
    //   34: ldc 54
    //   36: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: invokestatic 52	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   42: ldc 56
    //   44: invokevirtual 60	org/xwalk/core/XWalkCoreWrapper:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore 5
    //   49: aconst_null
    //   50: astore 4
    //   52: aload 5
    //   54: ifnull +220 -> 274
    //   57: ldc 29
    //   59: ldc 62
    //   61: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 6	com/tencent/xweb/extension/video/e$a
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 68	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   73: invokespecial 72	com/tencent/xweb/extension/video/e$a:<init>	(Ljava/lang/Object;)V
    //   76: astore 5
    //   78: aload_0
    //   79: instanceof 74
    //   82: ifne +267 -> 349
    //   85: new 74	org/xwalk/core/resource/XWalkContextWrapper
    //   88: dup
    //   89: aload_1
    //   90: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   93: invokestatic 84	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   96: invokespecial 87	org/xwalk/core/resource/XWalkContextWrapper:<init>	(Landroid/content/Context;I)V
    //   99: astore_0
    //   100: aload 4
    //   102: ifnull +12 -> 114
    //   105: aload_0
    //   106: checkcast 74	org/xwalk/core/resource/XWalkContextWrapper
    //   109: aload 4
    //   111: invokevirtual 91	org/xwalk/core/resource/XWalkContextWrapper:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   114: aload 5
    //   116: aload 6
    //   118: aload_1
    //   119: aload_2
    //   120: aload_0
    //   121: aload_3
    //   122: invokevirtual 94	com/tencent/xweb/extension/video/e$a:a	(Landroid/app/Activity;Landroid/view/View;Landroid/view/View;Landroid/content/Context;Ljava/lang/String;)V
    //   125: ldc 15
    //   127: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload 5
    //   132: areturn
    //   133: ldc 29
    //   135: ldc 99
    //   137: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 101
    //   142: iconst_0
    //   143: invokestatic 105	org/xwalk/core/XWalkEnvironment:getXWebInitArgs	(Ljava/lang/String;Z)Z
    //   146: invokestatic 110	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   149: astore 4
    //   151: invokestatic 84	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   154: sipush 2852
    //   157: if_icmpeq +12 -> 169
    //   160: invokestatic 84	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   163: sipush 2853
    //   166: if_icmpne +19 -> 185
    //   169: ldc 29
    //   171: ldc 112
    //   173: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aconst_null
    //   177: astore 4
    //   179: aconst_null
    //   180: astore 5
    //   182: goto -130 -> 52
    //   185: aload 4
    //   187: ifnull +71 -> 258
    //   190: aload 4
    //   192: instanceof 107
    //   195: ifeq +63 -> 258
    //   198: aload 4
    //   200: checkcast 107	java/lang/Boolean
    //   203: invokevirtual 116	java/lang/Boolean:booleanValue	()Z
    //   206: ifne +36 -> 242
    //   209: invokestatic 120	com/tencent/xweb/extension/video/e:iwZ	()Ljava/lang/ClassLoader;
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull +136 -> 352
    //   219: aload 4
    //   221: ldc 56
    //   223: invokevirtual 125	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   226: astore 5
    //   228: goto -176 -> 52
    //   231: astore 4
    //   233: aconst_null
    //   234: astore 4
    //   236: aconst_null
    //   237: astore 5
    //   239: goto -187 -> 52
    //   242: ldc 29
    //   244: ldc 127
    //   246: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aconst_null
    //   250: astore 4
    //   252: aconst_null
    //   253: astore 5
    //   255: goto -203 -> 52
    //   258: ldc 29
    //   260: ldc 132
    //   262: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aconst_null
    //   266: astore 4
    //   268: aconst_null
    //   269: astore 5
    //   271: goto -219 -> 52
    //   274: ldc 29
    //   276: ldc 134
    //   278: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: ldc 29
    //   283: ldc 136
    //   285: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: new 138	com/tencent/xweb/extension/video/d
    //   291: dup
    //   292: invokespecial 141	com/tencent/xweb/extension/video/d:<init>	()V
    //   295: astore_0
    //   296: aload_0
    //   297: aload 6
    //   299: aload_1
    //   300: aload_2
    //   301: aload_2
    //   302: invokevirtual 144	android/view/View:getContext	()Landroid/content/Context;
    //   305: aload_3
    //   306: invokevirtual 145	com/tencent/xweb/extension/video/d:a	(Landroid/app/Activity;Landroid/view/View;Landroid/view/View;Landroid/content/Context;Ljava/lang/String;)V
    //   309: ldc 15
    //   311: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_0
    //   315: areturn
    //   316: astore_0
    //   317: ldc 29
    //   319: new 147	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 149
    //   325: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_0
    //   329: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: goto -60 -> 281
    //   344: astore 5
    //   346: goto -110 -> 236
    //   349: goto -249 -> 100
    //   352: aconst_null
    //   353: astore 5
    //   355: goto -127 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramContext	Context
    //   0	358	1	paramWebView	com.tencent.xweb.WebView
    //   0	358	2	paramView	View
    //   0	358	3	paramString	String
    //   50	170	4	localObject1	Object
    //   231	1	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   234	33	4	localObject2	Object
    //   47	223	5	localObject3	Object
    //   344	1	5	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   353	1	5	localObject4	Object
    //   9	289	6	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   209	214	231	java/lang/ClassNotFoundException
    //   57	100	316	java/lang/Exception
    //   105	114	316	java/lang/Exception
    //   114	125	316	java/lang/Exception
    //   274	281	316	java/lang/Exception
    //   219	228	344	java/lang/ClassNotFoundException
  }
  
  private static ClassLoader iwZ()
  {
    AppMethodBeat.i(153646);
    ClassLoader localClassLoader;
    if (mClassLoader != null)
    {
      localClassLoader = mClassLoader;
      AppMethodBeat.o(153646);
      return localClassLoader;
    }
    try
    {
      mClassLoader = i.iyv();
      localClassLoader = mClassLoader;
      AppMethodBeat.o(153646);
      return localClassLoader;
    }
    catch (Exception localException)
    {
      Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(153646);
    }
    return null;
  }
  
  public static final class a
    implements b
  {
    private ReflectMethod aadA;
    private ReflectMethod aadB;
    private ReflectMethod aadC;
    private ReflectMethod aadD;
    private ReflectMethod aadE;
    private ReflectMethod aadF;
    private ReflectMethod aadG;
    private ReflectMethod aadH;
    private ReflectMethod aadI;
    private ReflectMethod aadJ;
    private Object aadK;
    private ReflectMethod aadw;
    private ReflectMethod aadx;
    private ReflectMethod aady;
    private ReflectMethod aadz;
    
    public a(Object paramObject)
    {
      AppMethodBeat.i(153636);
      this.aadK = paramObject;
      this.aadw = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
      this.aadx = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
      this.aady = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
      this.aadz = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
      this.aadA = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
      this.aadB = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
      this.aadC = new ReflectMethod(paramObject, "disableJsCallback", new Class[] { Boolean.TYPE });
      this.aadD = new ReflectMethod(paramObject, "setVideoJsCallback", new Class[] { Object.class });
      this.aadG = new ReflectMethod(paramObject, "videoChangeStatus", new Class[0]);
      this.aadE = new ReflectMethod(paramObject, "videoPlay", new Class[0]);
      this.aadF = new ReflectMethod(paramObject, "videoPause", new Class[0]);
      this.aadH = new ReflectMethod(paramObject, "videoSeek", new Class[] { Double.TYPE });
      this.aadI = new ReflectMethod(paramObject, "videoExitFullscreen", new Class[0]);
      this.aadJ = new ReflectMethod(paramObject, "supportSetRequestedOrientationCallback", new Class[0]);
      AppMethodBeat.o(153636);
    }
    
    public final void H(double paramDouble)
    {
      AppMethodBeat.i(153645);
      try
      {
        this.aadH.invoke(new Object[] { Double.valueOf(paramDouble) });
        AppMethodBeat.o(153645);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoSeek invoke error:" + localException.getMessage());
        AppMethodBeat.o(153645);
      }
    }
    
    public final void IO(boolean paramBoolean)
    {
      AppMethodBeat.i(153640);
      try
      {
        this.aadC.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(153640);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime disableJsCallback error:" + localException.getMessage());
        AppMethodBeat.o(153640);
      }
    }
    
    public final void a(Activity paramActivity, View paramView1, View paramView2, Context paramContext, String paramString)
    {
      AppMethodBeat.i(205661);
      try
      {
        this.aadw.invoke(new Object[] { paramActivity, paramView1, paramView2, paramContext, paramString });
        AppMethodBeat.o(205661);
        return;
      }
      catch (Exception paramActivity)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime init error:" + paramActivity.getMessage());
        AppMethodBeat.o(205661);
      }
    }
    
    public final void bu(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(153637);
      try
      {
        this.aadx.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        AppMethodBeat.o(153637);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime evaluteJavascript error:" + localException.getMessage());
        AppMethodBeat.o(153637);
      }
    }
    
    public final void eP(Object paramObject)
    {
      AppMethodBeat.i(153638);
      try
      {
        this.aadB.invoke(new Object[] { paramObject });
        AppMethodBeat.o(153638);
        return;
      }
      catch (Exception paramObject)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime registerJavascriptInterface error:" + paramObject.getMessage());
        AppMethodBeat.o(153638);
      }
    }
    
    public final boolean eQ(Object paramObject)
    {
      AppMethodBeat.i(153642);
      g localg = h.bEW("FullScreenVideo");
      if ((localg != null) && (localg.aajM >= 10)) {
        try
        {
          boolean bool = ((Boolean)this.aadD.invoke(new Object[] { paramObject })).booleanValue();
          AppMethodBeat.o(153642);
          return bool;
        }
        catch (Exception paramObject)
        {
          Log.i("VideoNativeInterface", "setVideoJsCallback invoke error:" + paramObject.getMessage());
          AppMethodBeat.o(153642);
          return false;
        }
      }
      if (localg != null) {
        Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available version:" + localg.aajM);
      }
      for (;;)
      {
        AppMethodBeat.o(153642);
        return false;
        Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available");
      }
    }
    
    public final void gvc()
    {
      AppMethodBeat.i(153644);
      try
      {
        this.aadF.invoke(new Object[0]);
        AppMethodBeat.o(153644);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoPause invoke error:" + localException.getMessage());
        AppMethodBeat.o(153644);
      }
    }
    
    public final void iwh()
    {
      AppMethodBeat.i(153643);
      try
      {
        this.aadE.invoke(new Object[0]);
        AppMethodBeat.o(153643);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoPlay invoke error:" + localException.getMessage());
        AppMethodBeat.o(153643);
      }
    }
    
    public final boolean iwi()
    {
      AppMethodBeat.i(205663);
      try
      {
        boolean bool = ((Boolean)this.aadJ.invoke(new Object[0])).booleanValue();
        AppMethodBeat.o(205663);
        return bool;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "supportSetRequestedOrientationCallback invoke error:" + localException.getMessage());
        AppMethodBeat.o(205663);
      }
      return false;
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(153641);
      try
      {
        this.aadz.invoke(new Object[0]);
        AppMethodBeat.o(153641);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onHideCustomView error:" + localException.getMessage());
        AppMethodBeat.o(153641);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(153639);
      try
      {
        this.aady.invoke(new Object[] { paramView, paramCustomViewCallback });
        AppMethodBeat.o(153639);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onShowCustomView error:" + paramView.getMessage());
        AppMethodBeat.o(153639);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */