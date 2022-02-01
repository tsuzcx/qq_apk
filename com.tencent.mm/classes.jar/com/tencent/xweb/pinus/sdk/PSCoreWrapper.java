package com.tencent.xweb.pinus.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.am;
import com.tencent.xweb.pinus.d;
import com.tencent.xweb.pinus.e;
import java.util.Locale;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkEnvironment;

public class PSCoreWrapper
{
  public static final String BRIDGE_PACKAGE = "com.tencent.xweb.pinus";
  private static final String TAG = "PSCoreWrapper";
  private static PSCoreWrapper sInstance;
  private final int mApkVersion;
  private final int mMultiProcessType;
  private final String mPrivilegedServicesName;
  private final String mSandboxedServicesName;
  private final Context mWrapperContext;
  
  private PSCoreWrapper(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(213549);
    this.mApkVersion = paramInt;
    this.mWrapperContext = new com.tencent.xweb.pinus.a(paramContext, paramInt);
    this.mMultiProcessType = XWalkEnvironment.getMultiProcessType();
    this.mPrivilegedServicesName = XWalkEnvironment.getPrivilegedServicesName();
    this.mSandboxedServicesName = XWalkEnvironment.getSandboxedServicesName();
    AppMethodBeat.o(213549);
  }
  
  public static boolean attachPinusCore(int paramInt)
  {
    AppMethodBeat.i(213595);
    XWalkEnvironment.addXWalkInitializeLog("PSCoreWrapper", "attachPinusCore, version:".concat(String.valueOf(paramInt)));
    if (paramInt == -1)
    {
      XWalkEnvironment.addXWalkInitializeLog("PSCoreWrapper", "attachPinusCore, version invalid");
      AppMethodBeat.o(213595);
      return false;
    }
    JNIUtils.setClassLoader(e.khp().getClassLoader());
    boolean bool = e.khp().initChannels(false);
    XWalkEnvironment.addXWalkInitializeLog("PSCoreWrapper", "attachPinusCore, result:".concat(String.valueOf(bool)));
    AppMethodBeat.o(213595);
    return bool;
  }
  
  public static void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(213670);
    e.khp().U(new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(213670);
  }
  
  public static void dockPinusCore(int paramInt)
  {
    AppMethodBeat.i(213608);
    XWalkEnvironment.addXWalkInitializeLog("PSCoreWrapper", "dockPinusCore, version:".concat(String.valueOf(paramInt)));
    sInstance = new PSCoreWrapper(XWalkEnvironment.getApplicationContext(), paramInt);
    am.a(new d());
    if (!com.tencent.xweb.a.keX().Q("DIS_INIT_XWALK_AT_LOAD", "tools", false))
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(213437);
            org.xwalk.core.Log.i("PSCoreWrapper", "dockPinusCore, post initPinusView to main thread");
            PSCoreWrapper.access$100(PSCoreWrapper.sInstance);
            WebView.onXWebCoreInited();
            AppMethodBeat.o(213437);
          }
        });
        AppMethodBeat.o(213608);
        return;
      }
      org.xwalk.core.Log.i("PSCoreWrapper", "dockPinusCore, initPinusView in current thread");
      sInstance.initPinusView();
      WebView.onXWebCoreInited();
      AppMethodBeat.o(213608);
      return;
    }
    XWalkEnvironment.addXWalkInitializeLog("PSCoreWrapper", "dockPinusCore, DIS_INIT_XWALK_AT_LOAD is true");
    AppMethodBeat.o(213608);
  }
  
  public static PSCoreWrapper getInstance()
  {
    return sInstance;
  }
  
  public static void handleRuntimeError(Exception paramException)
  {
    AppMethodBeat.i(213579);
    org.xwalk.core.Log.e("PSCoreWrapper", "This API is incompatible with the XWeb Pinus runtime library");
    org.xwalk.core.Log.e("PSCoreWrapper", "stack trace: " + android.util.Log.getStackTraceString(paramException));
    AppMethodBeat.o(213579);
  }
  
  public static boolean hasFeatureStatic(int paramInt)
  {
    AppMethodBeat.i(213644);
    Object localObject = e.khp().invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(213644);
      return bool;
    }
    AppMethodBeat.o(213644);
    return false;
  }
  
  private void initPinusView()
  {
    AppMethodBeat.i(213630);
    org.xwalk.core.Log.i("PSCoreWrapper", "initPinusView");
    Class localClass = getBridgeClass("PSViewDelegate");
    ReflectMethod localReflectMethod = new ReflectMethod(localClass, "setSandBoxProcessCrashDumpPath", new Class[] { String.class, String.class });
    if (!localReflectMethod.isNull()) {
      localReflectMethod.invoke(new Object[] { XWalkEnvironment.java_crash_dump_path, XWalkEnvironment.native_crash_dump_path });
    }
    localReflectMethod = new ReflectMethod(localClass, "preInit", new Class[] { Bundle.class });
    if (!localReflectMethod.isNull())
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("lang", XWalkEnvironment.getLocaleString());
      localReflectMethod.invoke(new Object[] { localBundle });
    }
    new ReflectMethod(localClass, "init", new Class[] { Context.class, Context.class, Integer.TYPE, String.class, String.class, String.class, String.class }).invoke(new Object[] { null, this.mWrapperContext, Integer.valueOf(this.mMultiProcessType), String.valueOf(XWalkEnvironment.getAvailableVersion()), "20220105", this.mPrivilegedServicesName, this.mSandboxedServicesName });
    AppMethodBeat.o(213630);
  }
  
  public static Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(213657);
    paramArrayOfObject = e.khp().invokeRuntimeChannel(paramInt, paramArrayOfObject);
    AppMethodBeat.o(213657);
    return paramArrayOfObject;
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(213763);
    try
    {
      Object localObject1 = e.khp().getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("com.tencent.xweb.pinus.".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213763);
        return localObject1;
      }
    }
    finally
    {
      org.xwalk.core.Log.w("PSCoreWrapper", "getBridgeClass failed, class:" + paramString + ", error:" + localObject2);
      AppMethodBeat.o(213763);
    }
    return null;
  }
  
  public Class<?> getBridgeClassFromXWalk(String paramString)
  {
    AppMethodBeat.i(213777);
    try
    {
      Object localObject1 = e.khp().getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("org.xwalk.core.internal.".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213777);
        return localObject1;
      }
    }
    finally
    {
      org.xwalk.core.Log.w("PSCoreWrapper", "getBridgeClass failed, class:" + paramString + ", error:" + localObject2);
      AppMethodBeat.o(213777);
    }
    return null;
  }
  
  public Object getBridgeObject(Object paramObject)
  {
    AppMethodBeat.i(213748);
    try
    {
      Object localObject1 = new ReflectMethod(paramObject, "getBridge", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(213748);
      return localObject1;
    }
    finally
    {
      org.xwalk.core.Log.w("PSCoreWrapper", "getBridgeObject failed, object:" + paramObject + ", error:" + localObject2);
      AppMethodBeat.o(213748);
    }
    return null;
  }
  
  public Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(213796);
    try
    {
      Object localObject1 = e.khp().getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass(paramString);
        AppMethodBeat.o(213796);
        return localObject1;
      }
    }
    finally
    {
      org.xwalk.core.Log.w("PSCoreWrapper", "getClass failed, class:" + paramString + ", error:" + localObject2);
      AppMethodBeat.o(213796);
    }
    return null;
  }
  
  public boolean hasFeature(int paramInt)
  {
    AppMethodBeat.i(213729);
    Object localObject = invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(213729);
      return bool;
    }
    AppMethodBeat.o(213729);
    return false;
  }
  
  public boolean isSupportTranslateWebSite()
  {
    AppMethodBeat.i(213720);
    Object localObject = invokeRuntimeChannel(80011, null);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(213720);
      return bool;
    }
    AppMethodBeat.o(213720);
    return false;
  }
  
  public void updateResourceLocale(Locale paramLocale)
  {
    AppMethodBeat.i(213706);
    if ((this.mWrapperContext instanceof com.tencent.xweb.pinus.a))
    {
      ((com.tencent.xweb.pinus.a)this.mWrapperContext).updateResourceLocale(paramLocale);
      AppMethodBeat.o(213706);
      return;
    }
    org.xwalk.core.Log.w("PSCoreWrapper", "updateResourceLocale, invalid context wrapper");
    AppMethodBeat.o(213706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.PSCoreWrapper
 * JD-Core Version:    0.7.0.1
 */