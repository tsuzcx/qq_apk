package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public class XWalkCoreWrapper
{
  private static final String BRIDGE_PACKAGE = "org.xwalk.core.internal";
  public static final int INVOKE_NOTITY_FUNCTION_ID_FOR_TEST = 10001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_IDKEY = 50001;
  public static final int INVOKE_NOTITY_FUNCTION_ID_KVSTAT = 50002;
  public static final int INVOKE_RUNTIME_ID_CONTEXT_CHANGED = 80001;
  public static final int INVOKE_RUNTIME_ID_DELETE_ORIGIN = 80006;
  public static final int INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL = 80005;
  public static final int INVOKE_RUNTIME_ID_SUPPORT_TRANLATE_WEB = 80011;
  private static final String TAG = "XWalkLib";
  private static final String WRAPPER_PACKAGE = "org.xwalk.core";
  private static ClassLoader mStandAloneClassLoader;
  private static XWalkCoreWrapper sInstance;
  private static XWalkCoreWrapper sProvisionalInstance;
  private static HashMap<String, LinkedList<XWalkCoreWrapper.ReservedAction>> sReservedActions;
  private static LinkedList<String> sReservedActivities;
  private int mApiVersion;
  private int mApkVersion;
  private Context mBridgeContext;
  private ClassLoader mBridgeLoader;
  private int mCoreStatus;
  private int mMinApiVersion;
  private Context mWrapperContext;
  DexClassLoader sBridgeLoader;
  
  static
  {
    AppMethodBeat.i(85591);
    sReservedActivities = new LinkedList();
    sReservedActions = new HashMap();
    AppMethodBeat.o(85591);
  }
  
  private XWalkCoreWrapper(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(85568);
    this.mApiVersion = 8;
    if ((paramInt1 > 0) && (paramInt1 <= this.mApiVersion)) {}
    for (;;)
    {
      this.mMinApiVersion = paramInt1;
      this.mCoreStatus = 0;
      this.mWrapperContext = paramContext;
      this.mApkVersion = paramInt2;
      AppMethodBeat.o(85568);
      return;
      paramInt1 = this.mApiVersion;
    }
  }
  
  public static int attachXWalkCore(int paramInt)
  {
    AppMethodBeat.i(85565);
    Assert.assertFalse(sReservedActivities.isEmpty());
    Assert.assertNull(sInstance);
    Log.i("XWalkLib", "Attach xwalk core");
    if (paramInt == -1)
    {
      Log.i("XWalkLib", "version = -1, no xwalk");
      AppMethodBeat.o(85565);
      return 10;
    }
    sProvisionalInstance = new XWalkCoreWrapper(XWalkEnvironment.getApplicationContext(), 1, paramInt);
    if (XWalkEnvironment.isDownloadMode())
    {
      sProvisionalInstance.findDownloadedCore();
      paramInt = sProvisionalInstance.mCoreStatus;
      AppMethodBeat.o(85565);
      return paramInt;
    }
    paramInt = sProvisionalInstance.mCoreStatus;
    AppMethodBeat.o(85565);
    return paramInt;
  }
  
  private boolean checkCoreApk()
  {
    AppMethodBeat.i(85584);
    if (!new File(XWalkEnvironment.getDownloadApkPath(this.mApkVersion)).exists())
    {
      Log.e("XWalkLib", "checkCoreApk apk not exists");
      this.mCoreStatus = 9;
      AppMethodBeat.o(85584);
      return false;
    }
    Log.i("XWalkLib", "XWalk checkCoreApk matched");
    AppMethodBeat.o(85584);
    return true;
  }
  
  private boolean checkCoreArchitecture()
  {
    AppMethodBeat.i(85582);
    for (;;)
    {
      try
      {
        ReflectMethod localReflectMethod = new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "loadXWalkLibrary", new Class[] { Context.class, String.class });
        String str = null;
        if (this.mBridgeContext != null)
        {
          if (Build.VERSION.SDK_INT < 17) {
            str = "/data/data/" + this.mBridgeContext.getPackageName() + "/lib";
          }
          bool = ((Boolean)localReflectMethod.invoke(new Object[] { this.mBridgeContext, str })).booleanValue();
          if (!bool)
          {
            Log.e("XWalkLib", "Mismatch of CPU architecture");
            this.mCoreStatus = 6;
            AppMethodBeat.o(85582);
            return false;
          }
        }
        else
        {
          if (this.mWrapperContext == null) {
            break label233;
          }
          str = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
          bool = ((Boolean)localReflectMethod.invoke(new Object[] { this.mWrapperContext, str })).booleanValue();
          continue;
        }
        Log.i("XWalkLib", "XWalk core architecture matched");
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.e("XWalkLib", localRuntimeException.getLocalizedMessage());
        if ((localRuntimeException.getCause() instanceof UnsatisfiedLinkError))
        {
          this.mCoreStatus = 6;
          AppMethodBeat.o(85582);
          return false;
        }
        this.mCoreStatus = 5;
        AppMethodBeat.o(85582);
        return false;
      }
      AppMethodBeat.o(85582);
      return true;
      label233:
      boolean bool = false;
    }
  }
  
  private boolean checkCorePackage(String paramString)
  {
    AppMethodBeat.i(85583);
    try
    {
      this.mBridgeContext = this.mWrapperContext.createPackageContext(paramString, 3);
      Log.d("XWalkLib", "Created package context for ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(85583);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.d("XWalkLib", paramString + " not found");
      AppMethodBeat.o(85583);
    }
    return false;
  }
  
  public static void dockXWalkCore()
  {
    AppMethodBeat.i(85566);
    Assert.assertNotNull(sProvisionalInstance);
    Assert.assertNull(sInstance);
    Log.d("XWalkLib", "Dock xwalk core");
    sInstance = sProvisionalInstance;
    sProvisionalInstance = null;
    AppMethodBeat.o(85566);
  }
  
  private boolean findDownloadedCore()
  {
    AppMethodBeat.i(85571);
    this.mBridgeLoader = getBridgeLoader();
    sProvisionalInstance.initCoreBridge();
    if ((this.mBridgeLoader == null) || (!checkCoreVersion()) || (!checkCoreArchitecture()) || (!checkCoreApk()))
    {
      Log.e("XWalkLib", "mBridgeLoader set to null , prev mBridgeLoader =  " + this.mBridgeLoader);
      this.mBridgeLoader = null;
      AppMethodBeat.o(85571);
      return false;
    }
    if (!initLog(sProvisionalInstance)) {
      Log.e("XWalkLib", "initLog failed !");
    }
    for (;;)
    {
      Log.d("XWalkLib", "Running in downloaded mode");
      this.mCoreStatus = 1;
      AppMethodBeat.o(85571);
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
    AppMethodBeat.i(85580);
    Object localObject;
    if ((getInstance() != null) && (getInstance().sBridgeLoader != null))
    {
      localObject = getInstance().sBridgeLoader;
      AppMethodBeat.o(85580);
      return localObject;
    }
    if (mStandAloneClassLoader != null)
    {
      localObject = mStandAloneClassLoader;
      AppMethodBeat.o(85580);
      return localObject;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i == -1)
      {
        Log.i("XWalkLib", "getXWalkClassLoader version = -1");
        AppMethodBeat.o(85580);
        return null;
      }
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      String str = XWalkEnvironment.getClassDexFilePath(i);
      boolean bool = new File(str).exists();
      if (!bool)
      {
        AppMethodBeat.o(85580);
        return null;
      }
      mStandAloneClassLoader = new DexClassLoader(str, XWalkEnvironment.getOptimizedDexDir(i), (String)localObject, ClassLoader.getSystemClassLoader());
      localObject = mStandAloneClassLoader;
      AppMethodBeat.o(85580);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("XWalkLib", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(85580);
    }
    return null;
  }
  
  public static void handlePostInit(String paramString)
  {
    AppMethodBeat.i(85560);
    Log.d("XWalkLib", "Post init xwalk core in ".concat(String.valueOf(paramString)));
    if (!sReservedActions.containsKey(paramString))
    {
      AppMethodBeat.o(85560);
      return;
    }
    LinkedList localLinkedList = (LinkedList)sReservedActions.get(paramString);
    while (localLinkedList.size() != 0)
    {
      XWalkCoreWrapper.ReservedAction localReservedAction = (XWalkCoreWrapper.ReservedAction)localLinkedList.pop();
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
    AppMethodBeat.o(85560);
  }
  
  public static void handlePreInit(String paramString)
  {
    AppMethodBeat.i(85556);
    if (sInstance != null)
    {
      AppMethodBeat.o(85556);
      return;
    }
    Log.d("XWalkLib", "Pre init xwalk core in ".concat(String.valueOf(paramString)));
    if (sReservedActions.containsKey(paramString)) {
      sReservedActions.remove(paramString);
    }
    for (;;)
    {
      sReservedActions.put(paramString, new LinkedList());
      AppMethodBeat.o(85556);
      return;
      sReservedActivities.add(paramString);
    }
  }
  
  public static void handleRuntimeError(RuntimeException paramRuntimeException)
  {
    AppMethodBeat.i(85561);
    Log.e("XWalkLib", "This API is incompatible with the Crosswalk runtime library");
    AppMethodBeat.o(85561);
  }
  
  public static boolean hasFeatureStatic(int paramInt)
  {
    AppMethodBeat.i(85581);
    Object localObject = invokeRuntimeChannel(getStandAloneClassLoader(), 80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(85581);
      return bool;
    }
    AppMethodBeat.o(85581);
    return false;
  }
  
  private byte[] hexStringToByteArray(String paramString)
  {
    AppMethodBeat.i(85586);
    if ((paramString == null) || (paramString.isEmpty()) || (paramString.length() % 2 != 0))
    {
      AppMethodBeat.o(85586);
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
    AppMethodBeat.o(85586);
    return arrayOfByte;
  }
  
  private void initCoreBridge()
  {
    AppMethodBeat.i(85569);
    Log.d("XWalkLib", "Init core bridge");
    new ReflectMethod(getBridgeClass("XWalkCoreBridge"), "init", new Class[] { Context.class, Object.class }).invoke(new Object[] { this.mBridgeContext, this });
    AppMethodBeat.o(85569);
  }
  
  public static void initEmbeddedMode()
  {
    AppMethodBeat.i(85567);
    if ((sInstance != null) || (!sReservedActivities.isEmpty()))
    {
      AppMethodBeat.o(85567);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException("royle:downloadmode should not goto this");
    AppMethodBeat.o(85567);
    throw localRuntimeException;
  }
  
  private boolean initLog(XWalkCoreWrapper paramXWalkCoreWrapper)
  {
    AppMethodBeat.i(85573);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      AppMethodBeat.o(85573);
      return false;
    }
    Object localObject = new XWalkCoreWrapper.1(this, paramXWalkCoreWrapper);
    try
    {
      paramXWalkCoreWrapper = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkLogMessageListener)localObject).getBridge();
      new ReflectMethod(paramXWalkCoreWrapper, "setLogCallBack", new Class[] { Object.class }).invoke(new Object[] { localObject });
      AppMethodBeat.o(85573);
      return true;
    }
    catch (RuntimeException paramXWalkCoreWrapper)
    {
      Log.d("XWalkLib", paramXWalkCoreWrapper.getLocalizedMessage());
      AppMethodBeat.o(85573);
    }
    return false;
  }
  
  private void initXWalkView()
  {
    AppMethodBeat.i(85570);
    Log.d("XWalkLib", "Init xwalk view");
    new ReflectMethod(getBridgeClass("XWalkViewDelegate"), "init", new Class[] { Context.class, Context.class }).invoke(new Object[] { this.mBridgeContext, this.mWrapperContext });
    AppMethodBeat.o(85570);
  }
  
  public static boolean invokeNativeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85577);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk invokeNativeChannel runtime version not matched 153");
      AppMethodBeat.o(85577);
      return false;
    }
    try
    {
      invokeReflectMethod(paramClassLoader, "invokeNativeChannel", paramInt, paramArrayOfObject);
      AppMethodBeat.o(85577);
      return true;
    }
    catch (RuntimeException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeNativeChannel error:" + paramClassLoader.getLocalizedMessage());
      f.dZT();
      AppMethodBeat.o(85577);
      return false;
    }
    catch (ClassCircularityError paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        f.dZU();
      }
    }
    catch (Exception paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        f.dZV();
      }
    }
  }
  
  private static Object invokeReflectMethod(ClassLoader paramClassLoader, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85578);
    if (paramClassLoader == null)
    {
      paramClassLoader = new ReflectMethod(getInstance().getBridgeClass("XWalkViewDelegate"), "invokeRuntimeChannel", new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      AppMethodBeat.o(85578);
      return paramClassLoader;
    }
    try
    {
      paramClassLoader = paramClassLoader.loadClass("org.xwalk.core.internal.XWalkViewDelegate");
      paramClassLoader = new ReflectMethod(paramClassLoader, paramString, new Class[] { Integer.TYPE, [Ljava.lang.Object.class }).invoke(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
      AppMethodBeat.o(85578);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeRuntimeChannel with classloader error:" + paramClassLoader.getMessage());
      AppMethodBeat.o(85578);
    }
    return null;
  }
  
  public static Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85575);
    paramArrayOfObject = invokeRuntimeChannel(null, paramInt, paramArrayOfObject);
    AppMethodBeat.o(85575);
    return paramArrayOfObject;
  }
  
  private static Object invokeRuntimeChannel(ClassLoader paramClassLoader, int paramInt, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(85576);
    if (XWalkEnvironment.getAvailableVersion() < 255)
    {
      Log.d("XWalkLib", "invokeRuntimeChannel version below SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION");
      AppMethodBeat.o(85576);
      return null;
    }
    try
    {
      paramClassLoader = invokeReflectMethod(paramClassLoader, "invokeRuntimeChannel", paramInt, paramArrayOfObject);
      AppMethodBeat.o(85576);
      return paramClassLoader;
    }
    catch (RuntimeException paramClassLoader)
    {
      Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
      f.dZT();
      AppMethodBeat.o(85576);
      return null;
    }
    catch (ClassCircularityError paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        f.dZU();
      }
    }
    catch (Exception paramClassLoader)
    {
      for (;;)
      {
        Log.e("XWalkLib", "invokeRuntimeChannel error:" + paramClassLoader.getLocalizedMessage());
        f.dZV();
      }
    }
  }
  
  public static void reserveReflectClass(Class<?> paramClass)
  {
    AppMethodBeat.i(85558);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve class " + paramClass.toString() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramClass));
    AppMethodBeat.o(85558);
  }
  
  public static void reserveReflectMethod(ReflectMethod paramReflectMethod)
  {
    AppMethodBeat.i(85559);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve method " + paramReflectMethod.toString() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramReflectMethod));
    AppMethodBeat.o(85559);
  }
  
  public static void reserveReflectObject(Object paramObject)
  {
    AppMethodBeat.i(85557);
    String str = (String)sReservedActivities.getLast();
    Log.d("XWalkLib", "Reserve object " + paramObject.getClass() + " to " + str);
    ((LinkedList)sReservedActions.get(str)).add(new XWalkCoreWrapper.ReservedAction(paramObject));
    AppMethodBeat.o(85557);
  }
  
  private boolean verifyPackageInfo(PackageInfo paramPackageInfo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(85585);
    if (paramPackageInfo.signatures == null)
    {
      Log.e("XWalkLib", "No signature in package info");
      AppMethodBeat.o(85585);
      return false;
    }
    try
    {
      paramString1 = MessageDigest.getInstance(paramString1);
      paramString2 = hexStringToByteArray(paramString2);
      if (paramString2 == null)
      {
        paramPackageInfo = new IllegalArgumentException("Invalid hash code");
        AppMethodBeat.o(85585);
        throw paramPackageInfo;
      }
    }
    catch (NoSuchAlgorithmException paramPackageInfo)
    {
      paramPackageInfo = new IllegalArgumentException("Invalid hash algorithm");
      AppMethodBeat.o(85585);
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
          AppMethodBeat.o(85585);
          return true;
        }
      }
      AppMethodBeat.o(85585);
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
    AppMethodBeat.i(85572);
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
      AppMethodBeat.o(85572);
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
      AppMethodBeat.o(85572);
      return false;
    }
    if (this.mMinApiVersion > i)
    {
      this.mCoreStatus = 3;
      AppMethodBeat.o(85572);
      return false;
    }
    if (this.mApiVersion < j)
    {
      this.mCoreStatus = 4;
      AppMethodBeat.o(85572);
      return false;
    }
    Log.i("XWalkLib", "XWalk core version matched");
    AppMethodBeat.o(85572);
    return true;
  }
  
  public int getApkVersion()
  {
    AppMethodBeat.i(85563);
    Object localObject = getBridgeLoader();
    if (localObject == null)
    {
      AppMethodBeat.o(85563);
      return 0;
    }
    try
    {
      localObject = ((DexClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      if (localObject == null)
      {
        AppMethodBeat.o(85563);
        return 0;
      }
      try
      {
        i = ((Integer)new ReflectField((Class)localObject, "XWALK_APK_VERSION").get()).intValue();
        AppMethodBeat.o(85563);
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
      AppMethodBeat.o(85563);
    }
  }
  
  public Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(85589);
    try
    {
      paramString = this.mBridgeLoader.loadClass("org.xwalk.core.internal.".concat(String.valueOf(paramString)));
      AppMethodBeat.o(85589);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(85589);
    }
    return null;
  }
  
  public DexClassLoader getBridgeLoader()
  {
    AppMethodBeat.i(85562);
    if (this.sBridgeLoader != null)
    {
      localObject = this.sBridgeLoader;
      AppMethodBeat.o(85562);
      return localObject;
    }
    Object localObject = XWalkEnvironment.getExtractedCoreDir(this.mApkVersion);
    String str = XWalkEnvironment.getClassDexFilePath(this.mApkVersion);
    if (!new File(str).exists())
    {
      AppMethodBeat.o(85562);
      return null;
    }
    this.sBridgeLoader = new DexClassLoader(str, XWalkEnvironment.getOptimizedDexDir(this.mApkVersion), (String)localObject, ClassLoader.getSystemClassLoader());
    localObject = this.sBridgeLoader;
    AppMethodBeat.o(85562);
    return localObject;
  }
  
  public Object getBridgeObject(Object paramObject)
  {
    AppMethodBeat.i(85587);
    try
    {
      paramObject = new ReflectMethod(paramObject, "getBridge", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(85587);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      AppMethodBeat.o(85587);
    }
    return null;
  }
  
  public Class<?> getClass(String paramString)
  {
    AppMethodBeat.i(85590);
    try
    {
      paramString = this.mBridgeLoader.loadClass(paramString);
      AppMethodBeat.o(85590);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      AppMethodBeat.o(85590);
    }
    return null;
  }
  
  public Object getWrapperObject(Object paramObject)
  {
    AppMethodBeat.i(85588);
    try
    {
      paramObject = new ReflectMethod(paramObject, "getWrapper", new Class[0]).invoke(new Object[0]);
      AppMethodBeat.o(85588);
      return paramObject;
    }
    catch (RuntimeException paramObject)
    {
      AppMethodBeat.o(85588);
    }
    return null;
  }
  
  public boolean hasFeature(int paramInt)
  {
    AppMethodBeat.i(85579);
    Object localObject = invokeRuntimeChannel(80003, new Object[] { Integer.valueOf(paramInt) });
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(85579);
      return bool;
    }
    AppMethodBeat.o(85579);
    return false;
  }
  
  public boolean initNotifyChannnel()
  {
    AppMethodBeat.i(85574);
    if (XWalkEnvironment.getAvailableVersion() < 153)
    {
      Log.d("XWalkLib", "XWalk runtime version not matched 153");
      AppMethodBeat.o(85574);
      return false;
    }
    Object localObject = new XWalkCoreWrapper.2(this);
    try
    {
      Class localClass = getBridgeClass("XWalkViewDelegate");
      localObject = ((XWalkNotifyChannelListener)localObject).getBridge();
      new ReflectMethod(localClass, "setNotifyCallBackChannel", new Class[] { Object.class }).invoke(new Object[] { localObject });
      AppMethodBeat.o(85574);
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.d("XWalkLib", localRuntimeException.getLocalizedMessage());
      AppMethodBeat.o(85574);
    }
    return false;
  }
  
  public boolean isDownLoadCoreAvailable()
  {
    AppMethodBeat.i(85564);
    Object localObject = getBridgeLoader();
    if (localObject == null)
    {
      AppMethodBeat.o(85564);
      return false;
    }
    try
    {
      localObject = ((DexClassLoader)localObject).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
      if (localObject == null)
      {
        AppMethodBeat.o(85564);
        return false;
      }
      AppMethodBeat.o(85564);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      AppMethodBeat.o(85564);
    }
    return false;
  }
  
  public boolean isSharedMode()
  {
    return this.mBridgeContext != null;
  }
  
  public boolean isSupportTranslateWebSite()
  {
    AppMethodBeat.i(139610);
    Object localObject = invokeRuntimeChannel(80011, null);
    if ((localObject instanceof Boolean))
    {
      boolean bool = ((Boolean)localObject).booleanValue();
      AppMethodBeat.o(139610);
      return bool;
    }
    AppMethodBeat.o(139610);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkCoreWrapper
 * JD-Core Version:    0.7.0.1
 */