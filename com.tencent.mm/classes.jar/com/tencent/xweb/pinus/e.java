package com.tencent.xweb.pinus;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.pinus.sdk.PSLogChannelListener;
import com.tencent.xweb.pinus.sdk.PSNotifyChannelListener;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.l;
import com.tencent.xweb.util.m;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.RuntimeToSdkChannel;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFileUtil;

public final class e
{
  private static final String[] aikr = { "xwebcore" };
  private ClassLoader mClassLoader;
  private boolean mHasInited = false;
  private boolean mInitedResult = false;
  
  private Class<?> getBridgeClass(String paramString)
  {
    AppMethodBeat.i(213410);
    try
    {
      Object localObject1 = getClassLoader();
      if (localObject1 != null)
      {
        localObject1 = ((ClassLoader)localObject1).loadClass("com.tencent.xweb.pinus.".concat(String.valueOf(paramString)));
        AppMethodBeat.o(213410);
        return localObject1;
      }
      Log.w("PinusStandAloneChannel", "getBridgeClass, classloader is null");
    }
    finally
    {
      for (;;)
      {
        Log.w("PinusStandAloneChannel", "getBridgeClass failed, class:" + paramString + ", error:" + localObject2);
      }
    }
    AppMethodBeat.o(213410);
    return null;
  }
  
  private boolean initCoreBridge()
  {
    AppMethodBeat.i(213358);
    Log.i("PinusStandAloneChannel", "initCoreBridge start");
    try
    {
      new ReflectMethod(getBridgeClass("PSCoreBridge"), "init", new Class[] { Context.class, Object.class }).invoke(new Object[] { null, this });
      AppMethodBeat.o(213358);
      return true;
    }
    finally
    {
      Log.e("PinusStandAloneChannel", "initCoreBridge error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213358);
    }
    return false;
  }
  
  private boolean initLogChannel()
  {
    AppMethodBeat.i(213402);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i < 153)
    {
      Log.w("PinusStandAloneChannel", "initLogChannel, version(" + i + ") below SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION");
      AppMethodBeat.o(213402);
      return false;
    }
    Log.i("PinusStandAloneChannel", "initLogChannel start");
    PSLogChannelListener local2 = new PSLogChannelListener()
    {
      public final void onLogMessage(int paramAnonymousInt1, String paramAnonymousString1, int paramAnonymousInt2, String paramAnonymousString2)
      {
        AppMethodBeat.i(213318);
        String str = paramAnonymousString1;
        if (paramAnonymousString1.contains("/")) {
          str = "XWeb.Core";
        }
        Log.i(str, paramAnonymousString2);
        AppMethodBeat.o(213318);
      }
    };
    try
    {
      new ReflectMethod(getBridgeClass("PSViewDelegate"), "setLogCallBack", new Class[] { Object.class }).invoke(new Object[] { local2 });
      AppMethodBeat.o(213402);
      return true;
    }
    finally
    {
      Log.e("PinusStandAloneChannel", "setLogCallBack error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213402);
    }
    return false;
  }
  
  private boolean initNotifyChannel()
  {
    AppMethodBeat.i(213393);
    int i = XWalkEnvironment.getAvailableVersion();
    if (i < 153)
    {
      Log.w("PinusStandAloneChannel", "initNotifyChannel, version(" + i + ") below SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION");
      AppMethodBeat.o(213393);
      return false;
    }
    Log.i("PinusStandAloneChannel", "initNotifyChannel start");
    PSNotifyChannelListener local1 = new PSNotifyChannelListener()
    {
      public final void onNotifyCallBackChannel(int paramAnonymousInt, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(213313);
        switch (paramAnonymousInt)
        {
        default: 
        case 50001: 
          try
          {
            Log.i("PinusStandAloneChannel", "NotifyChannel called funid = " + paramAnonymousInt + " do not match");
            AppMethodBeat.o(213313);
            return;
          }
          catch (RuntimeException paramAnonymousArrayOfObject)
          {
            Log.e("PinusStandAloneChannel", "NotifyChannel error:".concat(String.valueOf(paramAnonymousArrayOfObject)));
            AppMethodBeat.o(213313);
            return;
          }
          l.y(Long.parseLong((String)paramAnonymousArrayOfObject[0]), Long.parseLong((String)paramAnonymousArrayOfObject[1]), Integer.parseInt((String)paramAnonymousArrayOfObject[2]));
          AppMethodBeat.o(213313);
          return;
        }
        l.ev(Integer.parseInt((String)paramAnonymousArrayOfObject[0]), (String)paramAnonymousArrayOfObject[1]);
        AppMethodBeat.o(213313);
      }
    };
    try
    {
      new ReflectMethod(getBridgeClass("PSViewDelegate"), "setNotifyCallBackChannel", new Class[] { Object.class }).invoke(new Object[] { local1 });
      AppMethodBeat.o(213393);
      return true;
    }
    finally
    {
      Log.e("PinusStandAloneChannel", "setNotifyCallBackChannel error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213393);
    }
    return false;
  }
  
  private boolean isSupportStandAloneMode()
  {
    AppMethodBeat.i(213369);
    try
    {
      Object localObject1 = new ReflectMethod(getBridgeClass("PSCoreBridge"), "isSupportStandAloneMode", new Class[0]).invoke(new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        AppMethodBeat.o(213369);
        return bool;
      }
    }
    finally
    {
      Log.e("PinusStandAloneChannel", "isSupportStandAloneMode error:".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(213369);
      return false;
    }
    AppMethodBeat.o(213369);
    return false;
  }
  
  public static e khp()
  {
    return a.aikt;
  }
  
  private boolean loadNativeLibrary()
  {
    AppMethodBeat.i(213423);
    long l = System.currentTimeMillis();
    try
    {
      String str1 = XWalkFileUtil.getExtractedCoreDir(XWalkEnvironment.getAvailableVersion());
      String[] arrayOfString = aikr;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        Log.i("PinusStandAloneChannel", "loadNativeLibrary, path:" + str1 + File.separator + "lib" + str2 + ".so");
        System.load(str1 + File.separator + "lib" + str2 + ".so");
        i += 1;
      }
      RuntimeException localRuntimeException1;
      if (((Boolean)new ReflectMethod(getBridgeClass("PSViewDelegate"), "checkCoreArchitecture", new Class[0]).invoke(new Object[0])).booleanValue()) {
        break label326;
      }
    }
    catch (Error localError)
    {
      Log.e("PinusStandAloneChannel", "loadNativeLibraryInternal, error:".concat(String.valueOf(localError)));
      localRuntimeException1 = new RuntimeException(localError);
      AppMethodBeat.o(213423);
      throw localRuntimeException1;
    }
    catch (RuntimeException localRuntimeException2)
    {
      Log.e("PinusStandAloneChannel", "checkCoreArchitecture, error:".concat(String.valueOf(localRuntimeException2)));
      Log.e("PinusStandAloneChannel", "current device abi is " + b.khx() + ", runtime abi is " + b.khw() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
      AppMethodBeat.o(213423);
      return false;
    }
    l.Br(191L);
    Log.e("PinusStandAloneChannel", "Mismatch of CPU architecture current device abi is " + b.khx() + ", runtime abi is " + b.khw() + ", core detail is " + XWalkEnvironment.getAvailableVersionDetail());
    AppMethodBeat.o(213423);
    return false;
    label326:
    Log.i("PinusStandAloneChannel", "pinus core architecture matched, costTime:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(213423);
    return true;
  }
  
  private boolean setStandAloneMode(boolean paramBoolean)
  {
    AppMethodBeat.i(213384);
    try
    {
      new ReflectMethod(getBridgeClass("PSCoreBridge"), "setStandAloneMode", new Class[] { Boolean.TYPE }).invoke(new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(213384);
      return true;
    }
    finally
    {
      Log.e("PinusStandAloneChannel", "setStandAloneMode error:".concat(String.valueOf(localObject)));
      AppMethodBeat.o(213384);
    }
    return false;
  }
  
  /* Error */
  public final boolean U(Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc_w 276
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 138	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   9: istore_2
    //   10: iload_2
    //   11: sipush 153
    //   14: if_icmpge +38 -> 52
    //   17: ldc 69
    //   19: new 79	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 278
    //   26: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_2
    //   30: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 145
    //   35: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 77	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: ldc_w 276
    //   47: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_0
    //   51: ireturn
    //   52: ldc 69
    //   54: ldc_w 280
    //   57: invokestatic 106	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: new 108	org/xwalk/core/ReflectMethod
    //   63: dup
    //   64: aload_0
    //   65: ldc 152
    //   67: invokespecial 112	com/tencent/xweb/pinus/e:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   70: ldc_w 282
    //   73: iconst_2
    //   74: anewarray 116	java/lang/Class
    //   77: dup
    //   78: iconst_0
    //   79: getstatic 285	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: ldc_w 287
    //   88: aastore
    //   89: invokespecial 121	org/xwalk/core/ReflectMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   92: iconst_2
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: sipush 30003
    //   101: invokestatic 290	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: dup
    //   106: iconst_1
    //   107: aload_1
    //   108: aastore
    //   109: invokevirtual 125	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: ldc_w 276
    //   116: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: iconst_1
    //   120: ireturn
    //   121: astore_1
    //   122: ldc 69
    //   124: ldc_w 292
    //   127: aload_1
    //   128: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: invokestatic 295	com/tencent/xweb/util/l:kiG	()V
    //   140: ldc_w 276
    //   143: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 69
    //   151: ldc_w 297
    //   154: aload_1
    //   155: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: invokestatic 300	com/tencent/xweb/util/l:kiH	()V
    //   167: ldc_w 276
    //   170: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iconst_0
    //   174: ireturn
    //   175: astore_1
    //   176: ldc 69
    //   178: ldc_w 302
    //   181: aload_1
    //   182: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   185: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   188: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: invokestatic 305	com/tencent/xweb/util/l:kiI	()V
    //   194: ldc_w 276
    //   197: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iconst_0
    //   201: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	e
    //   0	202	1	paramArrayOfObject	Object[]
    //   9	21	2	i	int
    // Exception table:
    //   from	to	target	type
    //   52	113	121	java/lang/RuntimeException
    //   52	113	148	java/lang/ClassCircularityError
    //   52	113	175	finally
  }
  
  public final ClassLoader getClassLoader()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213456);
        if (this.mClassLoader != null)
        {
          localClassLoader = this.mClassLoader;
          AppMethodBeat.o(213456);
          return localClassLoader;
        }
      }
      finally
      {
        try
        {
          this.mClassLoader = m.kiJ();
          XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "getClassLoader, classLoader:" + this.mClassLoader);
          ClassLoader localClassLoader = this.mClassLoader;
          AppMethodBeat.o(213456);
          continue;
        }
        finally
        {
          Log.e("PinusStandAloneChannel", "getClassLoader error:".concat(String.valueOf(localObject2)));
          Object localObject3 = null;
        }
        localObject1 = finally;
      }
    }
  }
  
  public final boolean initChannels(boolean paramBoolean)
  {
    long l;
    int i;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213448);
        if (this.mHasInited)
        {
          Log.w("PinusStandAloneChannel", "initStandAloneChannel, already inited, result:" + this.mInitedResult);
          paramBoolean = this.mInitedResult;
          AppMethodBeat.o(213448);
          return paramBoolean;
        }
        this.mInitedResult = false;
        l = System.currentTimeMillis();
        i = XWalkEnvironment.getAvailableVersion();
        XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, apkVersion:".concat(String.valueOf(i)));
        if (paramBoolean)
        {
          l.y(1749L, 59L, 1L);
          if (i == -1)
          {
            l.y(1749L, 49L, 1L);
            AppMethodBeat.o(213448);
            paramBoolean = false;
          }
        }
        else
        {
          l.y(1749L, 61L, 1L);
          continue;
        }
        if (getClassLoader() != null) {
          break label180;
        }
      }
      finally {}
      XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, create class loader failed");
      l.y(1749L, 50L, 1L);
      AppMethodBeat.o(213448);
      paramBoolean = false;
      continue;
      label180:
      bool = initCoreBridge();
      XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, initCoreBridgeResult:".concat(String.valueOf(bool)));
      if (!bool)
      {
        l.y(1749L, 51L, 1L);
        AppMethodBeat.o(213448);
        paramBoolean = false;
      }
      else
      {
        if (!paramBoolean) {
          break;
        }
        bool = isSupportStandAloneMode();
        XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initChannels, isSupportStandAloneMode:".concat(String.valueOf(bool)));
        if (bool)
        {
          bool = setStandAloneMode(true);
          XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initChannels, setStandAloneModeResult:".concat(String.valueOf(bool)));
          if (bool) {
            break label449;
          }
          l.y(1749L, 57L, 1L);
          AppMethodBeat.o(213448);
          paramBoolean = false;
        }
        else
        {
          l.y(1749L, 58L, 1L);
          paramBoolean = a.keX().kff();
          XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initChannels, try runtime:".concat(String.valueOf(paramBoolean)));
          AppMethodBeat.o(213448);
        }
      }
    }
    XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initChannels, setStandAloneModeResult:".concat(String.valueOf(setStandAloneMode(false))));
    boolean bool = loadNativeLibrary();
    XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initChannels, loadLibraryResult:".concat(String.valueOf(bool)));
    if (bool)
    {
      if (new File(XWalkFileUtil.getDownloadApkPath(XWalkEnvironment.getAvailableVersion())).exists()) {
        break label436;
      }
      Log.e("PinusStandAloneChannel", "checkCoreApk, apk not exists");
      i = 0;
      break label624;
    }
    for (;;)
    {
      l.y(1749L, 55L, 1L);
      AppMethodBeat.o(213448);
      paramBoolean = false;
      break;
      label436:
      Log.i("PinusStandAloneChannel", "pinus core apk matched");
      i = 1;
      label449:
      label624:
      while (i != 0)
      {
        bool = initNotifyChannel();
        XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, initNotifyChannelResult:".concat(String.valueOf(bool)));
        if (!bool) {
          l.y(1749L, 52L, 1L);
        }
        XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, initRuntimeToSdkChannelResult:".concat(String.valueOf(RuntimeToSdkChannel.initPinusRuntimeToSdkChannel())));
        if (!bool) {
          l.y(1749L, 53L, 1L);
        }
        XWalkEnvironment.addXWalkInitializeLog("PinusStandAloneChannel", "initStandAloneChannel, initLogChannelResult:".concat(String.valueOf(initLogChannel())));
        if (!bool) {
          l.y(1749L, 54L, 1L);
        }
        this.mHasInited = true;
        this.mInitedResult = true;
        if (paramBoolean) {
          l.y(1749L, 60L, 1L);
        }
        for (;;)
        {
          Log.i("PinusStandAloneChannel", "initStandAloneChannel, costTime:" + (System.currentTimeMillis() - l));
          paramBoolean = this.mInitedResult;
          AppMethodBeat.o(213448);
          break;
          l.y(1749L, 62L, 1L);
        }
      }
    }
  }
  
  /* Error */
  public final Object invokeRuntimeChannel(int paramInt, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: ldc_w 426
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 138	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   9: istore_3
    //   10: iload_3
    //   11: sipush 255
    //   14: if_icmpge +39 -> 53
    //   17: ldc 69
    //   19: new 79	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 428
    //   26: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_3
    //   30: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 430
    //   36: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 77	org/xwalk/core/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc_w 426
    //   48: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: ldc 69
    //   55: ldc_w 432
    //   58: iload_1
    //   59: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokestatic 106	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 108	org/xwalk/core/ReflectMethod
    //   71: dup
    //   72: aload_0
    //   73: ldc 152
    //   75: invokespecial 112	com/tencent/xweb/pinus/e:getBridgeClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   78: ldc_w 433
    //   81: iconst_2
    //   82: anewarray 116	java/lang/Class
    //   85: dup
    //   86: iconst_0
    //   87: getstatic 285	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: ldc_w 287
    //   96: aastore
    //   97: invokespecial 121	org/xwalk/core/ReflectMethod:<init>	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload_1
    //   107: invokestatic 290	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_2
    //   114: aastore
    //   115: invokevirtual 125	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   118: astore_2
    //   119: ldc_w 426
    //   122: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_2
    //   126: areturn
    //   127: astore_2
    //   128: ldc 69
    //   130: ldc_w 435
    //   133: aload_2
    //   134: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: invokestatic 295	com/tencent/xweb/util/l:kiG	()V
    //   146: ldc_w 426
    //   149: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_2
    //   155: ldc 69
    //   157: ldc_w 437
    //   160: aload_2
    //   161: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   167: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: invokestatic 300	com/tencent/xweb/util/l:kiH	()V
    //   173: goto -27 -> 146
    //   176: astore_2
    //   177: ldc 69
    //   179: ldc_w 439
    //   182: aload_2
    //   183: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 59	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 130	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: invokestatic 305	com/tencent/xweb/util/l:kiI	()V
    //   195: goto -49 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	e
    //   0	198	1	paramInt	int
    //   0	198	2	paramArrayOfObject	Object[]
    //   9	21	3	i	int
    // Exception table:
    //   from	to	target	type
    //   53	119	127	java/lang/RuntimeException
    //   53	119	154	java/lang/ClassCircularityError
    //   53	119	176	finally
  }
  
  static final class a
  {
    public static final e aikt;
    
    static
    {
      AppMethodBeat.i(213304);
      aikt = new e((byte)0);
      AppMethodBeat.o(213304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.e
 * JD-Core Version:    0.7.0.1
 */