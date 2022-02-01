package org.xwalk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.am;
import java.util.Locale;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkCoreWrapper
{
  public static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
  private static final String TAG = "XWalkCoreWrapper";
  private static XWalkCoreWrapper sInstance;
  private final int mApkVersion;
  private final Context mWrapperContext;
  
  private XWalkCoreWrapper(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(187625);
    this.mApkVersion = paramInt;
    this.mWrapperContext = new XWalkContextWrapper(paramContext, paramInt);
    AppMethodBeat.o(187625);
  }
  
  public static boolean attachXWalkCore(int paramInt)
  {
    AppMethodBeat.i(187635);
    XWalkEnvironment.addXWalkInitializeLog("XWalkCoreWrapper", "attachXWalkCore, version:".concat(String.valueOf(paramInt)));
    if (paramInt == -1)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkCoreWrapper", "attachXWalkCore, version invalid");
      AppMethodBeat.o(187635);
      return false;
    }
    boolean bool = XWalkStandAloneChannel.getInstance().initChannels(false);
    XWalkEnvironment.addXWalkInitializeLog("XWalkCoreWrapper", "attachXWalkCore, result:".concat(String.valueOf(bool)));
    AppMethodBeat.o(187635);
    return bool;
  }
  
  public static void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(161640);
    XWalkStandAloneChannel.getInstance().bindNativeTrans(paramLong);
    AppMethodBeat.o(161640);
  }
  
  public static void dockXWalkCore(int paramInt)
  {
    AppMethodBeat.i(187638);
    XWalkEnvironment.addXWalkInitializeLog("XWalkCoreWrapper", "dockXWalkCore, version:".concat(String.valueOf(paramInt)));
    sInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), paramInt);
    am.a(new XWalkPreferences());
    if (!a.keX().Q("DIS_INIT_XWALK_AT_LOAD", "tools", false))
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(187603);
            Log.i("XWalkCoreWrapper", "dockXWalkCore, post initXWalkView to main thread");
            XWalkCoreWrapper.access$100(XWalkCoreWrapper.sInstance);
            XWalkCoreWrapper.access$200(XWalkCoreWrapper.sInstance);
            WebView.onXWebCoreInited();
            AppMethodBeat.o(187603);
          }
        });
        AppMethodBeat.o(187638);
        return;
      }
      Log.i("XWalkCoreWrapper", "dockXWalkCore, initXWalkView in current thread");
      sInstance.initXWalkPreferences();
      sInstance.initXWalkView();
      WebView.onXWebCoreInited();
      AppMethodBeat.o(187638);
      return;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkCoreWrapper", "dockXWalkCore, DIS_INIT_XWALK_AT_LOAD is true");
    AppMethodBeat.o(187638);
  }
  
  public static XWalkCoreWrapper getInstance()
  {
    return sInstance;
  }
  
  public static void handleRuntimeError(Throwable paramThrowable)
  {
    AppMethodBeat.i(187631);
    Log.e("XWalkCoreWrapper", "This API is incompatible with the XWalk runtime library:".concat(String.valueOf(paramThrowable)));
    Log.e("XWalkCoreWrapper", "stack trace: " + android.util.Log.getStackTraceString(paramThrowable));
    AppMethodBeat.o(187631);
  }
  
  public static boolean hasFeatureStatic(int paramInt)
  {
    AppMethodBeat.i(154672);
    boolean bool = XWalkStandAloneChannel.getInstance().hasFeature(paramInt);
    AppMethodBeat.o(154672);
    return bool;
  }
  
  /* Error */
  private void initXWalkPreferences()
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 205
    //   7: aload_0
    //   8: getfield 33	org/xwalk/core/XWalkCoreWrapper:mApkVersion	I
    //   11: invokestatic 69	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   14: invokestatic 208	com/tencent/xweb/am:setValue	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: ldc 210
    //   19: invokestatic 216	com/tencent/xweb/ao:kge	()I
    //   22: invokestatic 69	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   25: invokestatic 208	com/tencent/xweb/am:setValue	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: invokestatic 219	org/xwalk/core/XWalkEnvironment:getLocaleString	()Ljava/lang/String;
    //   31: invokestatic 225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +11 -> 45
    //   37: ldc 227
    //   39: invokestatic 219	org/xwalk/core/XWalkEnvironment:getLocaleString	()Ljava/lang/String;
    //   42: invokestatic 208	com/tencent/xweb/am:setValue	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 13
    //   47: new 178	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 229
    //   53: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 33	org/xwalk/core/XWalkCoreWrapper:mApkVersion	I
    //   60: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 234
    //   65: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokestatic 216	com/tencent/xweb/ao:kge	()I
    //   71: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 158	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 203
    //   82: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: astore_1
    //   87: ldc 13
    //   89: ldc 236
    //   91: aload_1
    //   92: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: invokevirtual 73	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 176	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -73 -> 28
    //   104: astore_1
    //   105: ldc 13
    //   107: ldc 236
    //   109: aload_1
    //   110: invokestatic 173	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 73	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 176	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: goto -74 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	XWalkCoreWrapper
    //   86	6	1	localObject1	Object
    //   104	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	28	86	finally
    //   28	45	104	finally
  }
  
  private void initXWalkView()
  {
    AppMethodBeat.i(154660);
    Log.i("XWalkCoreWrapper", "initXWalkView, wrapperContext:" + this.mWrapperContext);
    new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", new Class[] { Context.class, Context.class }).invoke(new Object[] { null, this.mWrapperContext });
    AppMethodBeat.o(154660);
  }
  
  public static Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154665);
    paramArrayOfObject = XWalkStandAloneChannel.getInstance().invokeRuntimeChannel(paramInt, paramArrayOfObject);
    AppMethodBeat.o(154665);
    return paramArrayOfObject;
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(154680);
    try
    {
      Object localObject1 = XWalkStandAloneChannel.getInstance().getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("org.xwalk.core.internal.".concat(String.valueOf(paramString)));
        AppMethodBeat.o(154680);
        return localObject1;
      }
    }
    finally
    {
      Log.w("XWalkCoreWrapper", "getBridgeClass failed, class:" + paramString + ", error:" + localObject2);
      AppMethodBeat.o(154680);
    }
    return null;
  }
  
  public Object getBridgeObject(Object paramObject)
  {
    AppMethodBeat.i(154678);
    try
    {
      Object localObject1 = new ReflectMethod(paramObject, "getBridge", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(154678);
      return localObject1;
    }
    finally
    {
      Log.w("XWalkCoreWrapper", "getBridgeObject failed, object:" + paramObject + ", error:" + localObject2);
      AppMethodBeat.o(154678);
    }
    return null;
  }
  
  public Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(154681);
    try
    {
      Object localObject1 = XWalkStandAloneChannel.getInstance().getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass(paramString);
        AppMethodBeat.o(154681);
        return localObject1;
      }
    }
    finally
    {
      Log.w("XWalkCoreWrapper", "getClass failed, class:" + paramString + ", error:" + localObject2);
      AppMethodBeat.o(154681);
    }
    return null;
  }
  
  public Object getWrapperObject(Object paramObject)
  {
    AppMethodBeat.i(154679);
    try
    {
      Object localObject1 = new ReflectMethod(paramObject, "getWrapper", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(154679);
      return localObject1;
    }
    finally
    {
      Log.w("XWalkCoreWrapper", "getWrapperObject failed, object:" + paramObject + ", error:" + localObject2);
      AppMethodBeat.o(154679);
    }
    return null;
  }
  
  public boolean hasFeature(int paramInt)
  {
    AppMethodBeat.i(154669);
    Object localObject = invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(154669);
      return bool;
    }
    AppMethodBeat.o(154669);
    return false;
  }
  
  public boolean isSupportTranslateWebSite()
  {
    AppMethodBeat.i(154670);
    Object localObject = invokeRuntimeChannel(80011, null);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(154670);
      return bool;
    }
    AppMethodBeat.o(154670);
    return false;
  }
  
  public void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(187666);
    if ((this.mWrapperContext instanceof XWalkContextWrapper))
    {
      ((XWalkContextWrapper)this.mWrapperContext).updateResourceLocale(paramLocale);
      AppMethodBeat.o(187666);
      return;
    }
    Log.w("XWalkCoreWrapper", "updateResourceLocale, invalid context wrapper");
    AppMethodBeat.o(187666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper
 * JD-Core Version:    0.7.0.1
 */