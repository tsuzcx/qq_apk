package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.updater.c;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public class XWalkCoreWrapper
{
  private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
  public static final int INVOKE_NOTITY_FUNCTION_ID_FOR_TEST = 10001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
  public static final int InvokeChannel_func_id_log = 30002;
  public static final int InvokeChannel_func_native_trans = 30003;
  private static final String TAG = "XWalkLib";
  private static final String WRAPPER_PACKAGE = "org.xwalk.core";
  private static ClassLoader mStandAloneClassLoader;
  private static XWalkCoreWrapper sInstance;
  private static XWalkCoreWrapper sProvisionalInstance;
  private static HashMap<String, LinkedList<ReservedAction>> sReservedActions;
  private static LinkedList<String> sReservedActivities;
  private int mApiVersion;
  private int mApkVersion;
  private Context mBridgeContext;
  private ClassLoader mBridgeLoader;
  private int mCoreStatus;
  private int mMinApiVersion;
  private Context mWrapperContext;
  ClassLoader sBridgeLoader;
  
  static
  {
    AppMethodBeat.i(154682);
    sReservedActivities = new LinkedList();
    sReservedActions = new HashMap();
    AppMethodBeat.o(154682);
  }
  
  private XWalkCoreWrapper(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154658);
    this.mApiVersion = 8;
    if ((paramInt1 > 0) && (paramInt1 <= this.mApiVersion)) {}
    for (;;)
    {
      this.mMinApiVersion = paramInt1;
      this.mCoreStatus = 0;
      this.mWrapperContext = paramContext;
      this.mApkVersion = paramInt2;
      AppMethodBeat.o(154658);
      return;
      paramInt1 = this.mApiVersion;
    }
  }
  
  public static int attachXWalkCore(int paramInt)
  {
    AppMethodBeat.i(154655);
    Assert.assertFalse(sReservedActivities.isEmpty());
    Assert.assertNull(sInstance);
    Log.i("XWalkLib", "Attach xwalk core");
    if (paramInt == -1)
    {
      Log.i("XWalkLib", "version = -1, no xwalk");
      AppMethodBeat.o(154655);
      return 10;
    }
    sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, paramInt);
    if (XWalkEnvironment.isDownloadMode())
    {
      sProvisionalInstance.findDownloadedCore();
      paramInt = sProvisionalInstance.mCoreStatus;
      AppMethodBeat.o(154655);
      return paramInt;
    }
    paramInt = sProvisionalInstance.mCoreStatus;
    AppMethodBeat.o(154655);
    return paramInt;
  }
  
  public static void bindNativeTrans(long paramLong)
  {
    AppMethodBeat.i(161640);
    invokeNativeChannel(null, 30003, new String[] { String.valueOf(paramLong) });
    AppMethodBeat.o(161640);
  }
  
  private boolean checkCoreApk()
  {
    AppMethodBeat.i(154675);
    if (!new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists())
    {
      Log.e("XWalkLib", "checkCoreApk apk not exists");
      this.mCoreStatus = 9;
      AppMethodBeat.o(154675);
      return false;
    }
    Log.i("XWalkLib", "XWalk checkCoreApk matched");
    AppMethodBeat.o(154675);
    return true;
  }
  
  private boolean checkCoreArchitecture()
  {
    AppMethodBeat.i(154673);
    for (;;)
    {
      try
      {
        ReflectMethod localReflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", new Class[] { Context.class, String.class });
        String str1 = null;
        if (this.mBridgeContext != null)
        {
          if (Build.VERSION.SDK_INT < 17) {
            str1 = "/data/data/" + this.mBridgeContext.getPackageName() + "/lib";
          }
          bool = ((Boolean)localReflectMethod.invoke(new Object[] { this.mBridgeContext, str1 })).booleanValue();
          if (!bool)
          {
            g.Fh(191L);
            Log.e("XWalkLib", "Mismatch of CPU architecture current device abi is " + XWalkEnvironment.getRuntimeAbi() + ", runtime abi is " + XWalkEnvironment.getRuntimeAbi() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
            this.mCoreStatus = 6;
            AppMethodBeat.o(154673);
            return false;
          }
        }
        else
        {
          if (this.mWrapperContext == null) {
            break label522;
          }
          str1 = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
          bool = ((Boolean)localReflectMethod.invoke(new Object[] { this.mWrapperContext, str1 })).booleanValue();
          continue;
        }
        String str2;
        Log.i("XWalkLib", "XWalk core architecture matched");
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("XWalkLib", localRuntimeException.getLocalizedMessage());
        Log.e("XWalkLib", "current device abi is " + XWalkEnvironment.getRuntimeAbi() + ", runtime abi is " + XWalkEnvironment.getRuntimeAbi() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
        g.Fh(192L);
        if ((localRuntimeException.getCause() instanceof UnsatisfiedLinkError))
        {
          this.mCoreStatus = 6;
          str2 = localRuntimeException.getMessage();
          Log.e("XWalkLib", "UnsatisfiedLinkError : ".concat(String.valueOf(str2)));
          if (!TextUtils.isEmpty(str2))
          {
            if (str2.contains("is 64-bit instead of 32-bit")) {
              g.Fh(193L);
            }
          }
          else {
            try
            {
              if (!"true".equalsIgnoreCase(a.baB("dis_abandon_when_32runtime_use_64so")))
              {
                XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
                c.gdu().gdC();
              }
              AppMethodBeat.o(154673);
              return false;
            }
            catch (Throwable localThrowable1)
            {
              Log.e("XWalkLib", "clear version failed , errmsg:" + localThrowable1.getMessage());
              continue;
            }
          }
          if (localThrowable1.contains("is 32-bit instead of 64-bit"))
          {
            g.Fh(194L);
            try
            {
              if ("true".equalsIgnoreCase(a.baB("dis_abandon_when_64runtime_use_32so"))) {
                continue;
              }
              XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
              c.gdu().gdC();
            }
            catch (Throwable localThrowable2)
            {
              Log.e("XWalkLib", "clear version failed , errmsg:" + localThrowable2.getMessage());
            }
            continue;
          }
          g.Fh(195L);
          continue;
        }
        this.mCoreStatus = 5;
        AppMethodBeat.o(154673);
        return false;
      }
      AppMethodBeat.o(154673);
      return true;
      label522:
      boolean bool = false;
    }
  }
  
  private boolean checkCorePackage(String paramString)
  {
    AppMethodBeat.i(154674);
    try
    {
      this.mBridgeContext = this.mWrapperContext.createPackageContext(paramString, 3);
      Log.d("XWalkLib", "Created package context for ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(154674);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.d("XWalkLib", paramString + " not found");
      AppMethodBeat.o(154674);
    }
    return false;
  }
  
  public static void dockXWalkCore()
  {
    AppMethodBeat.i(154656);
    Assert.assertNotNull(sProvisionalInstance);
    Assert.assertNull(sInstance);
    Log.d("XWalkLib", "Dock xwalk core");
    sInstance = sProvisionalInstance;
    sProvisionalInstance = null;
    AppMethodBeat.o(154656);
  }
  
  private boolean findDownloadedCore()
  {
    AppMethodBeat.i(154661);
    this.mBridgeLoader = getBridgeLoader();
    sProvisionalInstance.initCoreBridge();
    if ((this.mBridgeLoader == null) || (!checkCoreVersion()) || (!checkCoreArchitecture()) || (!checkCoreApk()))
    {
      Log.e("XWalkLib", "mBridgeLoader set to null , prev mBridgeLoader =  " + this.mBridgeLoader);
      this.mBridgeLoader = null;
      AppMethodBeat.o(154661);
      return false;
    }
    if (!initLog(sProvisionalInstance)) {
      Log.e("XWalkLib", "initLog failed !");
    }
    for (;;)
    {
      Log.d("XWalkLib", "Running in downloaded mode");
      this.mCoreStatus = 1;
      AppMethodBeat.o(154661);
      return true;
      Log.i("XWalkLib", "initLog success!");
    }
  }
  
  public static int getCoreStatus()
  {
    if (sInstance != null) {
      return sInstance.mCoreStatus;
    }
    if (sProvisionalInstance == null) {
      return 0;
    }
    return sProvisionalInstance.mCoreStatus;
  }
  
  public static XWalkCoreWrapper getInstance()
  {
    return sInstance;
  }
  
  private static ClassLoader getStandAloneClassLoader()
  {
    AppMethodBeat.i(154671);
    Object localObject;
    if ((getInstance() != null) && (getInstance().sBridgeLoader != null))
    {
      localObject = getInstance().sBridgeLoader;
      AppMethodBeat.o(154671);
      return localObject;
    }
    if (mStandAloneClassLoader != null)
    {
      localObject = mStandAloneClassLoader;
      AppMethodBeat.o(154671);
      return localObject;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i == -1)
      {
        Log.i("XWalkLib", "getXWalkClassLoader version = -1");
        AppMethodBeat.o(154671);
        return null;
      }
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      String str = XWalkEnvironment.getClassDexFilePath(i);
      boolean bool = new File(str).exists();
      if (!bool)
      {
        AppMethodBeat.o(154671);
        return null;
      }
      mStandAloneClassLoader = com.tencent.xweb.util.h.bo(str, XWalkEnvironment.getOptimizedDexDir(i), (String)localObject);
      localObject = mStandAloneClassLoader;
      AppMethodBeat.o(154671);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWalkLib", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(154671);
    }
    return null;
  }
  
  public static void handlePostInit(String paramString)
  {
    AppMethodBeat.i(154650);
    Log.d("XWalkLib", "Post init xwalk core in ".concat(String.valueOf(paramString)));
    if (!sReservedActions.containsKey(paramString))
    {
      AppMethodBeat.o(154650);
      return;
    }
    LinkedList localLinkedList = (LinkedList)sReservedActions.get(paramString);
    while (localLinkedList.size() != 0)
    {
      ReservedAction localReservedAction = (ReservedAction)localLinkedList.pop();
      if (localReservedAction.mObject != null)
      {
        Log.d("XWalkLib", "Init reserved object: " + localReservedAction.mObject.getClass());
        new ReflectMethod(localReservedAction.mObject, "reflectionInit", new Class[0]).invoke(new Object[0]);
      }
      else if (localReservedAction.mClass != null)
      {
        Log.d("XWalkLib", "Init reserved class: " + localReservedAction.mClass.toString());
        new ReflectMethod(localReservedAction.mClass, "reflectionInit", new Class[0]).invoke(new Object[0]);
      }
      else
      {
        Log.d("XWalkLib", "Call reserved method: " + localReservedAction.mMethod.toString());
        Object[] arrayOfObject = localReservedAction.mArguments;
        if (arrayOfObject != null)
        {
          int i = 0;
          while (i < arrayOfObject.length)
          {
            if ((arrayOfObject[i] instanceof ReflectMethod)) {
              arrayOfObject[i] = ((ReflectMethod)arrayOfObject[i]).invokeWithArguments();
            }
            i += 1;
          }
        }
        localReservedAction.mMethod.invoke(arrayOfObject);
      }
    }
    sReservedActions.remove(paramString);
    sReservedActivities.remove(paramString);
    AppMethodBeat.o(154650);
  }
  
  public static void handlePreInit(String paramString)
  {
    AppMethodBeat.i(154646);
    if (sInstance != null)
    {
      AppMethodBeat.o(154646);
      return;
    }
    Log.d("XWalkLib", "Pre init xwalk core in ".concat(String.valueOf(paramString)));
    if (sReservedActions.containsKey(paramString)) {
      sReservedActions.remove(paramString);
    }
    for (;;)
    {
      sReservedActions.put(paramString, new LinkedList());
      AppMethodBeat.o(154646);
      return;
      sReservedActivities.add(paramString);
    }
  }
  
  public static void handleRuntimeError(Exception paramException)
  {
    AppMethodBeat.i(154651);
    Log.e("XWalkLib", "This API is incompatible with the Crosswalk runtime library");
    AppMethodBeat.o(154651);
  }
  
  public static boolean hasFeatureStatic(int paramInt)
  {
    AppMethodBeat.i(154672);
    Object localObject = invokeRuntimeChannel(getStandAloneClassLoader(), 80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(154672);
      return bool;
    }
    AppMethodBeat.o(154672);
    return false;
  }
  
  private byte[] hexStringToByteArray(String paramString)
  {
    AppMethodBeat.i(154677);
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.length() % 2 != 0))
    {
      AppMethodBeat.o(154677);
      return null;
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < paramString.length())
    {
      int j = Character.digit(paramString.charAt(i), 16);
      int k = Character.digit(paramString.charAt(i + 1), 16);
      arrayOfByte[(i / 2)] = ((byte)((j << 4) + k));
      i += 2;
    }
    AppMethodBeat.o(154677);
    return arrayOfByte;
  }
  
  private void initCoreBridge()
  {
    AppMethodBeat.i(154659);
    Log.d("XWalkLib", "Init core bridge");
    new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", new Class[] { Context.class, Object.class }).invoke(new Object[] { this.mBridgeContext, this });
    AppMethodBeat.o(154659);
  }
  
  public static void initEmbeddedMode()
  {
    AppMethodBeat.i(154657);
    if ((sInstance != null) || (!sReservedActivities.isEmpty()))
    {
      AppMethodBeat.o(154657);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException("royle:downloadmode should not goto this");
    AppMethodBeat.o(154657);
    throw localRuntimeException;
  }
  
  private boolean initLog(XWalkCoreWrapper paramXWalkCoreWrapper)
  {
    AppMethodBeat.i(154663);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      AppMethodBeat.o(154663);
      return false;
    }
    Object localObject = new XWalkLogMessageListener(paramXWalkCoreWrapper)
    {
      public void onLogMessage(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(154643);
        Log.i("XWalkLib", "[WCWebview] :".concat(String.valueOf(paramAnonymousString2)));
        AppMethodBeat.o(154643);
      }
    };
    try
    {
      paramXWalkCoreWrapper = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkLogMessageListener)localObject).getBridge();
      new ReflectMethod(paramXWalkCoreWrapper, "setLogCallBack", new Class[] { Object.class }).invoke(new Object[] { localObject });
      AppMethodBeat.o(154663);
      return true;
    }
    catch (RuntimeException paramXWalkCoreWrapper)
    {
      Log.d("XWalkLib", paramXWalkCoreWrapper.getLocalizedMessage());
      AppMethodBeat.o(154663);
    }
    return false;
  }
  
  private void initXWalkView()
  {
    AppMethodBeat.i(154660);
    Log.d("XWalkLib", "Init xwalk view");
    new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", new Class[] { Context.class, Context.class }).invoke(new Object[] { this.mBridgeContext, this.mWrapperContext });
    AppMethodBeat.o(154660);
  }
  
  public static boolean invokeNativeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154667);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk invokeNativeChannel runtime version not matched 153");
      AppMethodBeat.o(154667);
      return false;
    }
    try
    {
      invokeReflectMethod(paramClassLoader, "invokeNativeChannel", paramInt, paramArrayOfObject);
      AppMethodBeat.o(154667);
      return true;
    }
    catch (RuntimeException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeNativeChannel error:" + paramClassLoader.getLocalizedMessage());
      g.gcJ();
      AppMethodBeat.o(154667);
      return false;
    }
    catch (ClassCircularityError paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        g.gcK();
      }
    }
    catch (Exception paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        g.gcL();
      }
    }
  }
  
  private static Object invokeReflectMethod(ClassLoader paramClassLoader, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154668);
    if (paramClassLoader == null)
    {
      paramClassLoader = new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), paramString, new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      AppMethodBeat.o(154668);
      return paramClassLoader;
    }
    try
    {
      paramClassLoader = paramClassLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate");
      paramClassLoader = new ReflectMethod(paramClassLoader, paramString, new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      AppMethodBeat.o(154668);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeRuntimeChannel with classloader error:" + paramClassLoader.getMessage());
      AppMethodBeat.o(154668);
    }
    return null;
  }
  
  public static Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154665);
    paramArrayOfObject = invokeRuntimeChannel(null, paramInt, paramArrayOfObject);
    AppMethodBeat.o(154665);
    return paramArrayOfObject;
  }
  
  private static Object invokeRuntimeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(154666);
    if (paramClassLoader == null) {
      Log.i("XWalkLib", "invokeRuntimeChannel class loader is null. may be gp version");
    }
    if (XWalkEnvironment.getAvailableVersion() < 255)
    {
      Log.d("XWalkLib", "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
      AppMethodBeat.o(154666);
      return null;
    }
    try
    {
      paramClassLoader = invokeReflectMethod(paramClassLoader, "invokeRuntimeChannel", paramInt, paramArrayOfObject);
      AppMethodBeat.o(154666);
      return paramClassLoader;
    }
    catch (RuntimeException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
      g.gcJ();
      AppMethodBeat.o(154666);
      return null;
    }
    catch (ClassCircularityError paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        g.gcK();
      }
    }
    catch (Exception paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        g.gcL();
      }
    }
  }
  
  public static void reserveReflectClass(Class<?> paramClass)
  {
    AppMethodBeat.i(154648);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve class " + paramClass.toString() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramClass));
    AppMethodBeat.o(154648);
  }
  
  public static void reserveReflectMethod(ReflectMethod paramReflectMethod)
  {
    AppMethodBeat.i(154649);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve method " + paramReflectMethod.toString() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramReflectMethod));
    AppMethodBeat.o(154649);
  }
  
  public static void reserveReflectObject(Object paramObject)
  {
    AppMethodBeat.i(154647);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve object " + paramObject.getClass() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new ReservedAction(paramObject));
    AppMethodBeat.o(154647);
  }
  
  private boolean verifyPackageInfo(PackageInfo paramPackageInfo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154676);
    if (paramPackageInfo.signatures == null)
    {
      Log.e("XWalkLib", "No signature in package info");
      AppMethodBeat.o(154676);
      return false;
    }
    try
    {
      paramString1 = MessageDigest.getInstance(paramString1);
      paramString2 = hexStringToByteArray(paramString2);
      if (paramString2 == null)
      {
        paramPackageInfo = new IllegalArgumentException("Invalid hash code");
        AppMethodBeat.o(154676);
        throw paramPackageInfo;
      }
    }
    catch (NoSuchAlgorithmException paramPackageInfo)
    {
      paramPackageInfo = new IllegalArgumentException("Invalid hash algorithm");
      AppMethodBeat.o(154676);
      throw paramPackageInfo;
      int i = 0;
      while (i < paramPackageInfo.signatures.length)
      {
        Log.d("XWalkLib", "Checking signature ".concat(String.valueOf(i)));
        if (!MessageDigest.isEqual(paramString1.digest(paramPackageInfo.signatures[i].toByteArray()), paramString2))
        {
          Log.e("XWalkLib", "Hash code does not match");
          i += 1;
        }
        else
        {
          Log.d("XWalkLib", "Signature passed verification");
          AppMethodBeat.o(154676);
          return true;
        }
      }
      AppMethodBeat.o(154676);
      return false;
    }
    catch (NullPointerException paramPackageInfo)
    {
      label64:
      break label64;
    }
  }
  
  public boolean checkCoreVersion()
  {
    AppMethodBeat.i(154662);
    Log.i("XWalkLib", "[Environment] SDK:" + Build.VERSION.SDK_INT);
    Log.i("XWalkLib", "[App Version] build:24.53.595.0, api:" + this.mApiVersion + ", min_api:" + this.mMinApiVersion);
    try
    {
      localClass = getBridgeClass("XWalkCoreVersion");
      localObject = "";
    }
    catch (RuntimeException localRuntimeException1)
    {
      Class localClass;
      Object localObject;
      String str;
      label104:
      int i;
      int j;
      Log.e("XWalkLib", "XWalk core not found");
      this.mCoreStatus = 2;
      AppMethodBeat.o(154662);
      return false;
    }
    try
    {
      str = (String)new ReflectField(localClass, "XWALK_BUILD_VERSION").get();
      localObject = str;
    }
    catch (RuntimeException localRuntimeException2)
    {
      break label104;
    }
    i = ((Integer)new ReflectField(localClass, "API_VERSION").get()).intValue();
    j = ((Integer)new ReflectField(localClass, "MIN_API_VERSION").get()).intValue();
    Log.i("XWalkLib", "[Lib Version] build:" + (String)localObject + ", api:" + i + ", min_api:" + j);
    if ((XWalkEnvironment.isDownloadMode()) && (XWalkEnvironment.isDownloadModeUpdate()) && (!((String)localObject).isEmpty()) && (!((String)localObject).equals("24.53.595.0")))
    {
      this.mCoreStatus = 8;
      AppMethodBeat.o(154662);
      return false;
    }
    if (this.mMinApiVersion > i)
    {
      this.mCoreStatus = 3;
      AppMethodBeat.o(154662);
      return false;
    }
    if (this.mApiVersion < j)
    {
      this.mCoreStatus = 4;
      AppMethodBeat.o(154662);
      return false;
    }
    Log.i("XWalkLib", "XWalk core version matched");
    AppMethodBeat.o(154662);
    return true;
  }
  
  public int getApkVersion()
  {
    AppMethodBeat.i(154653);
    Object localObject = getBridgeLoader();
    if (localObject == null)
    {
      AppMethodBeat.o(154653);
      return 0;
    }
    try
    {
      localObject = ((ClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      if (localObject == null)
      {
        AppMethodBeat.o(154653);
        return 0;
      }
      try
      {
        i = ((Integer)new ReflectField((Class)localObject, "XWALK_APK_VERSION").get()).intValue();
        AppMethodBeat.o(154653);
        return i;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      return 0;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(154653);
    }
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(154680);
    try
    {
      paramString = this.mBridgeLoader.loadClass("org.xwalk.core.internal.".concat(String.valueOf(paramString)));
      AppMethodBeat.o(154680);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(154680);
    }
    return null;
  }
  
  public ClassLoader getBridgeLoader()
  {
    AppMethodBeat.i(183749);
    if (this.sBridgeLoader != null)
    {
      localObject = this.sBridgeLoader;
      AppMethodBeat.o(183749);
      return localObject;
    }
    Object localObject = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
    String str = XWalkEnvironment.getClassDexFilePath(this.mApkVersion);
    if (!new File(str).exists())
    {
      AppMethodBeat.o(183749);
      return null;
    }
    this.sBridgeLoader = com.tencent.xweb.util.h.bo(str, XWalkEnvironment.getOptimizedDexDir(this.mApkVersion), (String)localObject);
    localObject = this.sBridgeLoader;
    AppMethodBeat.o(183749);
    return localObject;
  }
  
  public Object getBridgeObject(Object paramObject)
  {
    AppMethodBeat.i(154678);
    try
    {
      paramObject = new ReflectMethod(paramObject, "getBridge", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(154678);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      AppMethodBeat.o(154678);
    }
    return null;
  }
  
  public Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(154681);
    try
    {
      paramString = this.mBridgeLoader.loadClass(paramString);
      AppMethodBeat.o(154681);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(154681);
    }
    return null;
  }
  
  public Object getWrapperObject(Object paramObject)
  {
    AppMethodBeat.i(154679);
    try
    {
      paramObject = new ReflectMethod(paramObject, "getWrapper", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(154679);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
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
  
  public boolean initNotifyChannnel()
  {
    AppMethodBeat.i(154664);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      AppMethodBeat.o(154664);
      return false;
    }
    Object localObject = new XWalkNotifyChannelListener()
    {
      public void onNotifyCallBackChannel(int paramAnonymousInt, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(154644);
        Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramAnonymousInt + " para size = " + paramAnonymousArrayOfObject.length);
        switch (paramAnonymousInt)
        {
        default: 
        case 50001: 
          try
          {
            Log.i("XWalkLib", "XWalkNotifyChannelListener called  funid = " + paramAnonymousInt + " do not match");
            AppMethodBeat.o(154644);
            return;
          }
          catch (RuntimeException paramAnonymousArrayOfObject)
          {
            Log.e("XWalkLib", "XWalkNotifyChannelListener error:" + paramAnonymousArrayOfObject.getLocalizedMessage());
            AppMethodBeat.o(154644);
            return;
          }
          g.t(Long.parseLong((String)paramAnonymousArrayOfObject[0]), Long.parseLong((String)paramAnonymousArrayOfObject[1]), Integer.parseInt((String)paramAnonymousArrayOfObject[2]));
          AppMethodBeat.o(154644);
          return;
        }
        g.dc(Integer.parseInt((String)paramAnonymousArrayOfObject[0]), (String)paramAnonymousArrayOfObject[1]);
        AppMethodBeat.o(154644);
      }
    };
    try
    {
      Class localClass = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkNotifyChannelListener)localObject).getBridge();
      new ReflectMethod(localClass, "setNotifyCallBackChannel", new Class[] { Object.class }).invoke(new Object[] { localObject });
      AppMethodBeat.o(154664);
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.d("XWalkLib", localRuntimeException.getLocalizedMessage());
      AppMethodBeat.o(154664);
    }
    return false;
  }
  
  public boolean isDownLoadCoreAvailable()
  {
    AppMethodBeat.i(154654);
    Object localObject = getBridgeLoader();
    if (localObject == null)
    {
      AppMethodBeat.o(154654);
      return false;
    }
    try
    {
      localObject = ((ClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      if (localObject == null)
      {
        AppMethodBeat.o(154654);
        return false;
      }
      AppMethodBeat.o(154654);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(154654);
    }
    return false;
  }
  
  public boolean isSharedMode()
  {
    return this.mBridgeContext != null;
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
  
  static class ReservedAction
  {
    Object[] mArguments;
    Class<?> mClass;
    ReflectMethod mMethod;
    Object mObject;
    
    ReservedAction(Class<?> paramClass)
    {
      this.mClass = paramClass;
    }
    
    ReservedAction(Object paramObject)
    {
      this.mObject = paramObject;
    }
    
    ReservedAction(ReflectMethod paramReflectMethod)
    {
      AppMethodBeat.i(154645);
      this.mMethod = paramReflectMethod;
      if (paramReflectMethod.getArguments() != null) {
        this.mArguments = Arrays.copyOf(paramReflectMethod.getArguments(), paramReflectMethod.getArguments().length);
      }
      AppMethodBeat.o(154645);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper
 * JD-Core Version:    0.7.0.1
 */